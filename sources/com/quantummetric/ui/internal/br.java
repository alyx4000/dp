package com.quantummetric.ui.internal;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.util.Hashtable;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes5.dex */
final class br extends URLStreamHandler {

    /* renamed from: a, reason: collision with root package name */
    private URLStreamHandler f132a;

    public br() {
    }

    private br(URLStreamHandler uRLStreamHandler) {
        this.f132a = uRLStreamHandler;
    }

    static void a() {
        try {
            br brVar = new br((URLStreamHandler) Class.forName("com.android.okhttp.HttpsHandler").newInstance());
            Field declaredField = URL.class.getDeclaredField("handlers");
            declaredField.setAccessible(true);
            Hashtable hashtable = (Hashtable) declaredField.get(null);
            if (hashtable != null) {
                hashtable.put("https", brVar);
            }
        } catch (Exception unused) {
        }
    }

    @Override // java.net.URLStreamHandler
    protected final boolean equals(URL url, URL url2) {
        return ((Boolean) by.a("equals", URLStreamHandler.class, this.f132a, url, url2)).booleanValue();
    }

    @Override // java.net.URLStreamHandler
    protected final int getDefaultPort() {
        return ((Integer) by.a("getDefaultPort", URLStreamHandler.class, this.f132a, new Object[0])).intValue();
    }

    @Override // java.net.URLStreamHandler
    protected final synchronized InetAddress getHostAddress(URL url) {
        return (InetAddress) by.a("getHostAddress", URLStreamHandler.class, this.f132a, url);
    }

    @Override // java.net.URLStreamHandler
    protected final int hashCode(URL url) {
        return ((Integer) by.a("hashCode", URLStreamHandler.class, this.f132a, url)).intValue();
    }

    @Override // java.net.URLStreamHandler
    protected final boolean hostsEqual(URL url, URL url2) {
        return ((Boolean) by.a("hostEquals", URLStreamHandler.class, this.f132a, url, url2)).booleanValue();
    }

    @Override // java.net.URLStreamHandler
    protected final URLConnection openConnection(URL url) throws IOException {
        return new bs((HttpsURLConnection) by.a("openConnection", URLStreamHandler.class, this.f132a, url));
    }

    @Override // java.net.URLStreamHandler
    protected final URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        return (URLConnection) by.a("openConnection", URLStreamHandler.class, this.f132a, url, proxy);
    }

    @Override // java.net.URLStreamHandler
    protected final boolean sameFile(URL url, URL url2) {
        return ((Boolean) by.a("sameFile", URLStreamHandler.class, this.f132a, url, url2)).booleanValue();
    }

    @Override // java.net.URLStreamHandler
    protected final String toExternalForm(URL url) {
        return (String) by.a("toExternalForm", URLStreamHandler.class, this.f132a, url);
    }
}
