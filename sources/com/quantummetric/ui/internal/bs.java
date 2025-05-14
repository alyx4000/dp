package com.quantummetric.ui.internal;

import com.extole.android.sdk.impl.http.HttpRequest;
import com.quantummetric.ui.QuantumMetric;
import com.quantummetric.ui.internal.bk;
import com.socure.docv.capturesdk.common.utils.ApiConstant;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes5.dex */
final class bs extends HttpsURLConnection {

    /* renamed from: a, reason: collision with root package name */
    private long f133a;
    private long b;
    private boolean c;
    private HttpsURLConnection d;
    private boolean e;
    private String f;
    private StringBuilder g;
    private HashMap<String, String> h;

    class a extends FilterInputStream {

        /* renamed from: a, reason: collision with root package name */
        private ByteArrayOutputStream f134a;
        private boolean b;
        private boolean c;
        private boolean d;
        private byte[] e;

        a(InputStream inputStream) {
            super(inputStream);
            this.d = false;
            this.e = new byte[2];
            if (bk.a(bs.this.getHeaderFields().get(ApiConstant.HEADER_CONTENT_TYPE))) {
                this.d = true;
            }
            if (!bs.this.e || this.d) {
                return;
            }
            this.f134a = new ByteArrayOutputStream();
            String headerField = bs.this.getHeaderField(HttpRequest.HEADER_CONTENT_ENCODING);
            if (de.b(headerField) || !headerField.equals(HttpRequest.ENCODING_GZIP)) {
                return;
            }
            this.b = true;
        }

        private static String a(byte[] bArr) {
            StringBuilder sb = new StringBuilder();
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream, 32);
                byte[] bArr2 = new byte[32];
                while (true) {
                    int read = gZIPInputStream.read(bArr2);
                    if (read == -1) {
                        break;
                    }
                    sb.append(new String(bArr2, 0, read));
                }
                gZIPInputStream.close();
                byteArrayInputStream.close();
            } catch (Exception unused) {
            }
            return sb.toString();
        }

        private void a() throws IOException {
            StringBuilder append;
            String str;
            if (bs.this.c) {
                append = new StringBuilder("QM: response exceeds the ").append(bs.this.f133a / 1024);
                str = "kb configured limit!";
            } else {
                append = new StringBuilder("QM: response exceeds the ").append(bs.this.f133a / 1024);
                str = "kb memory protection limit set by QM!";
            }
            bs.a(bs.this, append.append(str).toString());
            this.c = true;
            this.f134a = null;
        }

        private boolean b() {
            return (!bs.this.e || this.f134a == null || this.c || this.d) ? false : true;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            bs bsVar;
            String byteArrayOutputStream;
            super.close();
            if (!this.c && bs.this.e) {
                try {
                    if (this.d) {
                        bsVar = bs.this;
                        byteArrayOutputStream = bk.a(bk.a.c);
                    } else if (this.b) {
                        bsVar = bs.this;
                        byteArrayOutputStream = a(this.f134a.toByteArray());
                    } else {
                        bsVar = bs.this;
                        byteArrayOutputStream = this.f134a.toString("UTF-8");
                    }
                    bs.a(bsVar, byteArrayOutputStream);
                } catch (Throwable unused) {
                }
            }
            this.c = true;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public final int read() throws IOException {
            byte[] bArr;
            byte b;
            int read = super.read();
            if (b()) {
                this.f134a.write(read);
                if (!this.b && ((b = (bArr = this.e)[0]) == 0 || bArr[1] == 0)) {
                    if (b == 0) {
                        bArr[0] = (byte) read;
                    } else if (bArr[1] == 0) {
                        byte b2 = (byte) read;
                        bArr[1] = b2;
                        if (b == 31 && b2 == -117) {
                            this.b = true;
                        }
                    }
                }
                if (this.f134a.size() > bs.this.f133a) {
                    a();
                }
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public final int read(byte[] bArr) throws IOException {
            int read = super.read(bArr);
            if (b()) {
                this.f134a.write(bArr);
                if (this.f134a.size() > bs.this.f133a) {
                    a();
                }
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public final int read(byte[] bArr, int i, int i2) throws IOException {
            int read = super.read(bArr, i, i2);
            if (b() && bArr.length > i && read > 0) {
                this.f134a.write(bArr, i, read);
                if (this.f134a.size() > bs.this.f133a) {
                    a();
                }
            }
            return read;
        }
    }

    class b extends FilterOutputStream {

        /* renamed from: a, reason: collision with root package name */
        private boolean f135a;

        b(OutputStream outputStream) {
            super(outputStream);
        }

        private void a() throws IOException {
            StringBuilder append;
            String str;
            bs.this.g.length();
            bs.this.g.setLength(0);
            if (bs.this.c) {
                append = new StringBuilder("QM: request exceeds the ").append(bs.this.f133a / 1024);
                str = "kb configured limit!";
            } else {
                append = new StringBuilder("QM: request exceeds the ").append(bs.this.f133a / 1024);
                str = "kb memory protection limit set by QM!";
            }
            bs.this.g.append(append.append(str).toString());
            this.f135a = true;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            super.close();
            this.f135a = true;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public final void write(int i) throws IOException {
            if (bs.this.e && !this.f135a) {
                bs.this.g.append((char) i);
                if (bs.this.g.length() > bs.this.b) {
                    a();
                }
            }
            this.out.write(i);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public final void write(byte[] bArr) throws IOException {
            if (bs.this.e && !this.f135a) {
                bs.this.g.append(new String(bArr, 0, bArr.length, "UTF-8"));
                if (bs.this.g.length() > bs.this.b) {
                    a();
                }
            }
            this.out.write(bArr);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public final void write(byte[] bArr, int i, int i2) throws IOException {
            if (bs.this.e && !this.f135a) {
                bs.this.g.append(new String(bArr, i, i2, "UTF-8"));
                if (bs.this.g.length() > bs.this.b) {
                    a();
                }
            }
            this.out.write(bArr, i, i2);
        }
    }

    bs(HttpsURLConnection httpsURLConnection) {
        super(httpsURLConnection.getURL());
        this.f133a = 10485760L;
        this.b = 10485760 / 2;
        this.c = false;
        this.d = httpsURLConnection;
        this.f = httpsURLConnection.getURL().toString();
        this.g = new StringBuilder();
        this.h = new HashMap<>();
        if (QuantumMetric.b == null || !de.l().a(this.f)) {
            return;
        }
        this.e = true;
        if (de.l().i < this.f133a) {
            long j = de.l().i;
            this.f133a = j;
            this.b = j / 2;
            this.c = true;
        }
    }

    static /* synthetic */ void a(bs bsVar, String str) {
        long j;
        long j2;
        int i;
        if (bsVar.e) {
            String headerField = bsVar.getHeaderField("X-Android-Sent-Millis");
            String headerField2 = bsVar.getHeaderField("X-Android-Received-Millis");
            long j3 = 0;
            try {
                long parseLong = Long.parseLong(headerField);
                try {
                    j3 = Long.parseLong(headerField2);
                    i = bsVar.getResponseCode();
                    j2 = parseLong;
                } catch (Exception unused) {
                    j = j3;
                    j3 = parseLong;
                    j2 = j3;
                    i = -1;
                    j3 = j;
                    bk.a(bk.a(bsVar.f, bsVar.method, j3 - j2, j2, i, bsVar.g.toString(), str, null, new HashMap(bsVar.h), bsVar.getHeaderFields()));
                    bsVar.g.setLength(0);
                    bsVar.h.clear();
                }
            } catch (Exception unused2) {
                j = 0;
            }
            bk.a(bk.a(bsVar.f, bsVar.method, j3 - j2, j2, i, bsVar.g.toString(), str, null, new HashMap(bsVar.h), bsVar.getHeaderFields()));
            bsVar.g.setLength(0);
            bsVar.h.clear();
        }
    }

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        if (this.e) {
            this.h.put(str, str2);
        }
        this.d.addRequestProperty(str, str2);
    }

    @Override // java.net.URLConnection
    public final void connect() throws IOException {
        this.d.connect();
    }

    @Override // java.net.HttpURLConnection
    public final void disconnect() {
        this.d.disconnect();
    }

    @Override // java.net.URLConnection
    public final boolean getAllowUserInteraction() {
        return this.d.getAllowUserInteraction();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public final String getCipherSuite() {
        return this.d.getCipherSuite();
    }

    @Override // java.net.URLConnection
    public final int getConnectTimeout() {
        return this.d.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public final Object getContent() throws IOException {
        return this.d.getContent();
    }

    @Override // java.net.URLConnection
    public final Object getContent(Class[] clsArr) throws IOException {
        return this.d.getContent(clsArr);
    }

    @Override // java.net.URLConnection
    public final String getContentEncoding() {
        return this.d.getContentEncoding();
    }

    @Override // java.net.URLConnection
    public final int getContentLength() {
        return this.d.getContentLength();
    }

    @Override // java.net.URLConnection
    public final long getContentLengthLong() {
        return this.d.getContentLengthLong();
    }

    @Override // java.net.URLConnection
    public final String getContentType() {
        return this.d.getContentType();
    }

    @Override // java.net.URLConnection
    public final long getDate() {
        return this.d.getDate();
    }

    @Override // java.net.URLConnection
    public final boolean getDefaultUseCaches() {
        return this.d.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public final boolean getDoInput() {
        return this.d.getDoInput();
    }

    @Override // java.net.URLConnection
    public final boolean getDoOutput() {
        return this.d.getDoOutput();
    }

    @Override // java.net.HttpURLConnection
    public final InputStream getErrorStream() {
        return this.d.getErrorStream();
    }

    @Override // java.net.URLConnection
    public final long getExpiration() {
        return this.d.getExpiration();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        return this.d.getHeaderField(i);
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        return this.d.getHeaderField(str);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final long getHeaderFieldDate(String str, long j) {
        return this.d.getHeaderFieldDate(str, j);
    }

    @Override // java.net.URLConnection
    public final int getHeaderFieldInt(String str, int i) {
        return this.d.getHeaderFieldInt(str, i);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        return this.d.getHeaderFieldKey(i);
    }

    @Override // java.net.URLConnection
    public final long getHeaderFieldLong(String str, long j) {
        return this.d.getHeaderFieldLong(str, j);
    }

    @Override // java.net.URLConnection
    public final Map<String, List<String>> getHeaderFields() {
        return this.d.getHeaderFields();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public final HostnameVerifier getHostnameVerifier() {
        return this.d.getHostnameVerifier();
    }

    @Override // java.net.URLConnection
    public final long getIfModifiedSince() {
        return this.d.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    public final InputStream getInputStream() throws IOException {
        return new a(this.d.getInputStream());
    }

    @Override // java.net.HttpURLConnection
    public final boolean getInstanceFollowRedirects() {
        return this.d.getInstanceFollowRedirects();
    }

    @Override // java.net.URLConnection
    public final long getLastModified() {
        return this.d.getLastModified();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public final Certificate[] getLocalCertificates() {
        return this.d.getLocalCertificates();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public final Principal getLocalPrincipal() {
        return this.d.getLocalPrincipal();
    }

    @Override // java.net.URLConnection
    public final OutputStream getOutputStream() throws IOException {
        return new b(this.d.getOutputStream());
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public final Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        return this.d.getPeerPrincipal();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final Permission getPermission() throws IOException {
        return this.d.getPermission();
    }

    @Override // java.net.URLConnection
    public final int getReadTimeout() {
        return this.d.getReadTimeout();
    }

    @Override // java.net.HttpURLConnection
    public final String getRequestMethod() {
        return this.d.getRequestMethod();
    }

    @Override // java.net.URLConnection
    public final Map<String, List<String>> getRequestProperties() {
        return this.d.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public final String getRequestProperty(String str) {
        return this.d.getRequestProperty(str);
    }

    @Override // java.net.HttpURLConnection
    public final int getResponseCode() throws IOException {
        return this.d.getResponseCode();
    }

    @Override // java.net.HttpURLConnection
    public final String getResponseMessage() throws IOException {
        return this.d.getResponseMessage();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public final SSLSocketFactory getSSLSocketFactory() {
        return this.d.getSSLSocketFactory();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public final Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        return this.d.getServerCertificates();
    }

    @Override // java.net.URLConnection
    public final URL getURL() {
        return this.d.getURL();
    }

    @Override // java.net.URLConnection
    public final boolean getUseCaches() {
        return this.d.getUseCaches();
    }

    @Override // java.net.URLConnection
    public final void setAllowUserInteraction(boolean z) {
        this.d.setAllowUserInteraction(z);
    }

    @Override // java.net.HttpURLConnection
    public final void setChunkedStreamingMode(int i) {
        this.d.setChunkedStreamingMode(i);
    }

    @Override // java.net.URLConnection
    public final void setConnectTimeout(int i) {
        this.d.setConnectTimeout(i);
    }

    @Override // java.net.URLConnection
    public final void setDefaultUseCaches(boolean z) {
        this.d.setDefaultUseCaches(z);
    }

    @Override // java.net.URLConnection
    public final void setDoInput(boolean z) {
        this.d.setDoInput(z);
    }

    @Override // java.net.URLConnection
    public final void setDoOutput(boolean z) {
        this.d.setDoOutput(z);
    }

    @Override // java.net.HttpURLConnection
    public final void setFixedLengthStreamingMode(int i) {
        this.d.setFixedLengthStreamingMode(i);
    }

    @Override // java.net.HttpURLConnection
    public final void setFixedLengthStreamingMode(long j) {
        this.d.setFixedLengthStreamingMode(j);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public final void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.d.setHostnameVerifier(hostnameVerifier);
    }

    @Override // java.net.URLConnection
    public final void setIfModifiedSince(long j) {
        this.d.setIfModifiedSince(j);
    }

    @Override // java.net.HttpURLConnection
    public final void setInstanceFollowRedirects(boolean z) {
        this.d.setInstanceFollowRedirects(z);
    }

    @Override // java.net.URLConnection
    public final void setReadTimeout(int i) {
        this.d.setReadTimeout(i);
    }

    @Override // java.net.HttpURLConnection
    public final void setRequestMethod(String str) throws ProtocolException {
        this.d.setRequestMethod(str);
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        if (this.e) {
            this.h.put(str, str2);
        }
        this.d.setRequestProperty(str, str2);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public final void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.d.setSSLSocketFactory(sSLSocketFactory);
    }

    @Override // java.net.URLConnection
    public final void setUseCaches(boolean z) {
        this.d.setUseCaches(z);
    }

    @Override // java.net.URLConnection
    public final String toString() {
        return this.d.toString();
    }

    @Override // java.net.HttpURLConnection
    public final boolean usingProxy() {
        return this.d.usingProxy();
    }
}
