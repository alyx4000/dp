package sdk.pendo.io.y4;

import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes4.dex */
public final class u0 {
    public static final u0 b = a("http/1.1");
    public static final u0 c = a("spdy/1");
    public static final u0 d = a("spdy/2");
    public static final u0 e = a("spdy/3");
    public static final u0 f = a("stun.turn");
    public static final u0 g = a("stun.nat-discovery");
    public static final u0 h = a("h2");
    public static final u0 i = a("h2c");
    public static final u0 j = a("webrtc");
    public static final u0 k = a("c-webrtc");
    public static final u0 l = a("ftp");
    public static final u0 m = a("imap");
    public static final u0 n = a("pop3");
    public static final u0 o = a("managesieve");
    public static final u0 p = a("coap");
    public static final u0 q = a("xmpp-client");
    public static final u0 r = a("xmpp-server");

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f1803a;

    private u0(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("'bytes' cannot be null");
        }
        if (bArr.length < 1 || bArr.length > 255) {
            throw new IllegalArgumentException("'bytes' must have length from 1 to 255");
        }
        this.f1803a = bArr;
    }

    public static u0 a(String str) {
        return new u0(sdk.pendo.io.d5.i.c(str));
    }

    public boolean equals(Object obj) {
        return (obj instanceof u0) && sdk.pendo.io.d5.a.a(this.f1803a, ((u0) obj).f1803a);
    }

    public int hashCode() {
        return sdk.pendo.io.d5.a.b(this.f1803a);
    }

    public void a(OutputStream outputStream) {
        l3.c(this.f1803a, outputStream);
    }

    public String a() {
        return sdk.pendo.io.d5.i.c(this.f1803a);
    }

    public static u0 a(InputStream inputStream) {
        return new u0(l3.c(inputStream, 1));
    }
}
