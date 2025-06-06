package io.sentry.transport;

import com.extole.android.sdk.impl.http.HttpRequest;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import io.sentry.RequestDetails;
import io.sentry.SentryEnvelope;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes2.dex */
final class HttpConnection {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final SentryOptions options;
    private final Proxy proxy;
    private final RateLimiter rateLimiter;
    private final RequestDetails requestDetails;

    private boolean isSuccessfulResponseCode(int i) {
        return i == 200;
    }

    public HttpConnection(SentryOptions sentryOptions, RequestDetails requestDetails, RateLimiter rateLimiter) {
        this(sentryOptions, requestDetails, AuthenticatorWrapper.getInstance(), rateLimiter);
    }

    HttpConnection(SentryOptions sentryOptions, RequestDetails requestDetails, AuthenticatorWrapper authenticatorWrapper, RateLimiter rateLimiter) {
        this.requestDetails = requestDetails;
        this.options = sentryOptions;
        this.rateLimiter = rateLimiter;
        Proxy resolveProxy = resolveProxy(sentryOptions.getProxy());
        this.proxy = resolveProxy;
        if (resolveProxy == null || sentryOptions.getProxy() == null) {
            return;
        }
        String user = sentryOptions.getProxy().getUser();
        String pass = sentryOptions.getProxy().getPass();
        if (user == null || pass == null) {
            return;
        }
        authenticatorWrapper.setDefault(new ProxyAuthenticator(user, pass));
    }

    private Proxy resolveProxy(SentryOptions.Proxy proxy) {
        if (proxy != null) {
            String port = proxy.getPort();
            String host = proxy.getHost();
            if (port != null && host != null) {
                try {
                    return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(host, Integer.parseInt(port)));
                } catch (NumberFormatException e) {
                    this.options.getLogger().log(SentryLevel.ERROR, e, "Failed to parse Sentry Proxy port: " + proxy.getPort() + ". Proxy is ignored", new Object[0]);
                }
            }
        }
        return null;
    }

    HttpURLConnection open() throws IOException {
        URLConnection uRLConnection;
        if (this.proxy == null) {
            uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(this.requestDetails.getUrl().openConnection());
        } else {
            uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(this.requestDetails.getUrl().openConnection(this.proxy));
        }
        return (HttpURLConnection) uRLConnection;
    }

    private HttpURLConnection createConnection() throws IOException {
        HttpURLConnection open = open();
        for (Map.Entry<String, String> entry : this.requestDetails.getHeaders().entrySet()) {
            open.setRequestProperty(entry.getKey(), entry.getValue());
        }
        open.setRequestMethod("POST");
        open.setDoOutput(true);
        open.setRequestProperty(HttpRequest.HEADER_CONTENT_ENCODING, HttpRequest.ENCODING_GZIP);
        open.setRequestProperty(HttpRequest.HEADER_CONTENT_TYPE, "application/x-sentry-envelope");
        open.setRequestProperty(HttpRequest.HEADER_ACCEPT, "application/json");
        open.setRequestProperty("Connection", "close");
        open.setConnectTimeout(this.options.getConnectionTimeoutMillis());
        open.setReadTimeout(this.options.getReadTimeoutMillis());
        SSLSocketFactory sslSocketFactory = this.options.getSslSocketFactory();
        if ((open instanceof HttpsURLConnection) && sslSocketFactory != null) {
            ((HttpsURLConnection) open).setSSLSocketFactory(sslSocketFactory);
        }
        open.connect();
        return open;
    }

    public TransportResult send(SentryEnvelope sentryEnvelope) throws IOException {
        try {
            OutputStream outputStream = createConnection().getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    this.options.getSerializer().serialize(sentryEnvelope, gZIPOutputStream);
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } finally {
                }
            } finally {
            }
        } finally {
            try {
                return readAndLog(r0);
            } finally {
            }
        }
        return readAndLog(r0);
    }

    private TransportResult readAndLog(HttpURLConnection httpURLConnection) {
        try {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                updateRetryAfterLimits(httpURLConnection, responseCode);
                if (isSuccessfulResponseCode(responseCode)) {
                    this.options.getLogger().log(SentryLevel.DEBUG, "Envelope sent successfully.", new Object[0]);
                    return TransportResult.success();
                }
                this.options.getLogger().log(SentryLevel.ERROR, "Request failed, API returned %s", Integer.valueOf(responseCode));
                if (this.options.isDebug()) {
                    this.options.getLogger().log(SentryLevel.ERROR, "%s", getErrorMessageFromStream(httpURLConnection));
                }
                return TransportResult.error(responseCode);
            } catch (IOException e) {
                this.options.getLogger().log(SentryLevel.ERROR, e, "Error reading and logging the response stream", new Object[0]);
                closeAndDisconnect(httpURLConnection);
                return TransportResult.error();
            }
        } finally {
            closeAndDisconnect(httpURLConnection);
        }
    }

    public void updateRetryAfterLimits(HttpURLConnection httpURLConnection, int i) {
        String headerField = httpURLConnection.getHeaderField("Retry-After");
        this.rateLimiter.updateRetryAfterLimits(httpURLConnection.getHeaderField("X-Sentry-Rate-Limits"), headerField, i);
    }

    private void closeAndDisconnect(HttpURLConnection httpURLConnection) {
        try {
            httpURLConnection.getInputStream().close();
        } catch (IOException unused) {
        } catch (Throwable th) {
            httpURLConnection.disconnect();
            throw th;
        }
        httpURLConnection.disconnect();
    }

    private String getErrorMessageFromStream(HttpURLConnection httpURLConnection) {
        try {
            InputStream errorStream = httpURLConnection.getErrorStream();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorStream, UTF_8));
                try {
                    StringBuilder sb = new StringBuilder();
                    boolean z = true;
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (!z) {
                            sb.append("\n");
                        }
                        sb.append(readLine);
                        z = false;
                    }
                    String sb2 = sb.toString();
                    bufferedReader.close();
                    if (errorStream != null) {
                        errorStream.close();
                    }
                    return sb2;
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
            return "Failed to obtain error message while analyzing send failure.";
        }
    }

    Proxy getProxy() {
        return this.proxy;
    }
}
