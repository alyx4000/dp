package sdk.pendo.io.q;

import java.security.MessageDigest;
import sdk.pendo.io.i0.j;

/* loaded from: classes6.dex */
public final class g<T> {
    private static final b<Object> e = new a();

    /* renamed from: a, reason: collision with root package name */
    private final T f1507a;
    private final b<T> b;
    private final String c;
    private volatile byte[] d;

    class a implements b<Object> {
        a() {
        }

        @Override // sdk.pendo.io.q.g.b
        public void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    }

    public interface b<T> {
        void a(byte[] bArr, T t, MessageDigest messageDigest);
    }

    private g(String str, T t, b<T> bVar) {
        this.c = j.a(str);
        this.f1507a = t;
        this.b = (b) j.a(bVar);
    }

    public static <T> g<T> a(String str, T t, b<T> bVar) {
        return new g<>(str, t, bVar);
    }

    private byte[] c() {
        if (this.d == null) {
            this.d = this.c.getBytes(f.f1506a);
        }
        return this.d;
    }

    public T b() {
        return this.f1507a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof g) {
            return this.c.equals(((g) obj).c);
        }
        return false;
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.c + "'}";
    }

    private static <T> b<T> a() {
        return (b<T>) e;
    }

    public static <T> g<T> a(String str) {
        return new g<>(str, null, a());
    }

    public static <T> g<T> a(String str, T t) {
        return new g<>(str, t, a());
    }

    public void a(T t, MessageDigest messageDigest) {
        this.b.a(c(), t, messageDigest);
    }
}
