package sdk.pendo.io.y4;

import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes4.dex */
public class i1 {
    public static final i1 c = a(2074);
    public static final i1 d = a(2075);
    public static final i1 e = a(2076);
    public static final i1 f = a(2055);
    public static final i1 g = a(2056);
    public static final i1 h = a(8, 64);
    public static final i1 i = a(8, 65);
    public static final i1 j = a(2052);
    public static final i1 k = a(2053);
    public static final i1 l = a(2054);
    public static final i1 m = a(2057);
    public static final i1 n = a(2058);
    public static final i1 o = a(2059);

    /* renamed from: a, reason: collision with root package name */
    protected final short f1781a;
    protected final short b;

    public i1(short s, short s2) {
        if ((s & 255) != s) {
            throw new IllegalArgumentException("'hash' should be a uint8");
        }
        if ((s2 & 255) != s2) {
            throw new IllegalArgumentException("'signature' should be a uint8");
        }
        this.f1781a = s;
        this.b = s2;
    }

    private static i1 a(int i2) {
        return a(j1.b(i2), j1.e(i2));
    }

    public static i1 b(short s, short s2) {
        return s != 8 ? a(s, s2) : a(s2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof i1)) {
            return false;
        }
        i1 i1Var = (i1) obj;
        return i1Var.a() == a() && i1Var.b() == b();
    }

    public int hashCode() {
        return (a() << 16) | b();
    }

    public String toString() {
        return "{" + i0.c(this.f1781a) + "," + h1.c(this.b) + "}";
    }

    private static i1 a(short s, short s2) {
        return new i1(s, s2);
    }

    public short b() {
        return this.b;
    }

    public void a(OutputStream outputStream) {
        l3.a(a(), outputStream);
        l3.a(b(), outputStream);
    }

    public short a() {
        return this.f1781a;
    }

    private static i1 a(short s) {
        if (s == 64) {
            return h;
        }
        if (s == 65) {
            return i;
        }
        switch (s) {
            case 4:
                return j;
            case 5:
                return k;
            case 6:
                return l;
            case 7:
                return f;
            case 8:
                return g;
            case 9:
                return m;
            case 10:
                return n;
            case 11:
                return o;
            default:
                switch (s) {
                    case 26:
                        return c;
                    case 27:
                        return d;
                    case 28:
                        return e;
                    default:
                        return a((short) 8, s);
                }
        }
    }

    public static i1 a(InputStream inputStream) {
        return b(l3.g(inputStream), l3.g(inputStream));
    }
}
