package sdk.pendo.io.y4;

import com.google.android.material.internal.ViewUtils;
import java.util.Vector;

/* loaded from: classes4.dex */
public final class v0 {
    public static final v0 c;
    public static final v0 d;
    public static final v0 e;
    public static final v0 f;
    public static final v0 g;
    public static final v0 h;
    public static final v0 i;
    static final v0 j;
    static final v0 k;
    static final v0 l;
    static final v0 m;
    static final v0 n;
    static final v0 o;
    static final v0 p;
    static final v0 q;

    /* renamed from: a, reason: collision with root package name */
    private int f1804a;
    private String b;

    static {
        v0 v0Var = new v0(ViewUtils.EDGE_TO_EDGE_FLAGS, "SSL 3.0");
        c = v0Var;
        d = new v0(769, "TLS 1.0");
        e = new v0(770, "TLS 1.1");
        f = new v0(771, "TLS 1.2");
        v0 v0Var2 = new v0(772, "TLS 1.3");
        g = v0Var2;
        v0 v0Var3 = new v0(65279, "DTLS 1.0");
        h = v0Var3;
        v0 v0Var4 = new v0(65277, "DTLS 1.2");
        i = v0Var4;
        j = v0Var3;
        k = v0Var;
        l = v0Var4;
        m = v0Var2;
        n = v0Var3;
        o = v0Var;
        p = v0Var4;
        q = v0Var2;
    }

    private v0(int i2, String str) {
        this.f1804a = i2 & 65535;
        this.b = str;
    }

    private static void a(int i2) {
        if (!l3.q(i2)) {
            throw new IllegalArgumentException("'versionOctet' is not a valid octet");
        }
    }

    public static v0 c(v0[] v0VarArr) {
        v0 v0Var = null;
        if (v0VarArr != null) {
            for (v0 v0Var2 : v0VarArr) {
                if (v0Var2 != null && v0Var2.h() && (v0Var == null || v0Var2.d() > v0Var.d())) {
                    v0Var = v0Var2;
                }
            }
        }
        return v0Var;
    }

    static boolean h(v0 v0Var) {
        int b;
        return v0Var != null && (b = v0Var.b()) >= o.b() && b <= q.b();
    }

    public boolean b(v0 v0Var) {
        return v0Var != null && this.f1804a == v0Var.f1804a;
    }

    public int d() {
        return this.f1804a & 255;
    }

    public v0 e() {
        int i2;
        int c2 = c();
        int d2 = d();
        if (c2 != 3) {
            if (c2 != 254) {
                return null;
            }
            if (d2 == 253) {
                return h;
            }
            if (d2 == 255) {
                return null;
            }
            i2 = d2 + 1;
        } else {
            if (d2 == 0) {
                return null;
            }
            i2 = d2 - 1;
        }
        return a(c2, i2);
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof v0) && b((v0) obj));
    }

    public boolean f() {
        return c() == 254;
    }

    public boolean g() {
        return this == c;
    }

    public int hashCode() {
        return this.f1804a;
    }

    public v0[] i() {
        return new v0[]{this};
    }

    public String toString() {
        return this.b;
    }

    public static boolean a(v0[] v0VarArr, v0 v0Var) {
        if (v0VarArr != null && v0Var != null) {
            for (v0 v0Var2 : v0VarArr) {
                if (v0Var.b(v0Var2)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean g(v0 v0Var) {
        int b;
        return v0Var != null && (b = v0Var.b()) >= k.b() && b <= m.b();
    }

    public int b() {
        return this.f1804a;
    }

    public int c() {
        return this.f1804a >> 8;
    }

    public boolean d(v0 v0Var) {
        if (v0Var == null || c() != v0Var.c()) {
            return false;
        }
        int d2 = d() - v0Var.d();
        if (f()) {
            if (d2 < 0) {
                return false;
            }
        } else if (d2 > 0) {
            return false;
        }
        return true;
    }

    public boolean e(v0 v0Var) {
        if (v0Var == null || c() != v0Var.c()) {
            return false;
        }
        int d2 = d() - v0Var.d();
        if (f()) {
            if (d2 > 0) {
                return false;
            }
        } else if (d2 < 0) {
            return false;
        }
        return true;
    }

    public boolean f(v0 v0Var) {
        if (v0Var == null || c() != v0Var.c()) {
            return false;
        }
        int d2 = d() - v0Var.d();
        if (f()) {
            if (d2 >= 0) {
                return false;
            }
        } else if (d2 <= 0) {
            return false;
        }
        return true;
    }

    public boolean h() {
        return c() == 3;
    }

    public static v0 b(v0[] v0VarArr) {
        v0 v0Var = null;
        if (v0VarArr != null) {
            for (v0 v0Var2 : v0VarArr) {
                if (v0Var2 != null && v0Var2.f() && (v0Var == null || v0Var2.d() < v0Var.d())) {
                    v0Var = v0Var2;
                }
            }
        }
        return v0Var;
    }

    public v0[] a(v0 v0Var) {
        if (!e(v0Var)) {
            throw new IllegalArgumentException("'min' must be an equal or earlier version of this one");
        }
        Vector vector = new Vector();
        vector.addElement(this);
        v0 v0Var2 = this;
        while (!v0Var2.b(v0Var)) {
            v0Var2 = v0Var2.e();
            vector.addElement(v0Var2);
        }
        v0[] v0VarArr = new v0[vector.size()];
        for (int i2 = 0; i2 < vector.size(); i2++) {
            v0VarArr[i2] = (v0) vector.elementAt(i2);
        }
        return v0VarArr;
    }

    public boolean c(v0 v0Var) {
        if (v0Var == null || c() != v0Var.c()) {
            return false;
        }
        int d2 = d() - v0Var.d();
        if (f()) {
            if (d2 <= 0) {
                return false;
            }
        } else if (d2 >= 0) {
            return false;
        }
        return true;
    }

    public static v0 a(int i2, int i3) {
        String str;
        if (i2 != 3) {
            if (i2 == 254) {
                switch (i3) {
                    case 253:
                        return i;
                    case 254:
                        throw new IllegalArgumentException("{0xFE, 0xFE} is a reserved protocol version");
                    case 255:
                        return h;
                    default:
                        str = "DTLS";
                        break;
                }
            } else {
                str = "UNKNOWN";
            }
        } else {
            if (i3 == 0) {
                return c;
            }
            if (i3 == 1) {
                return d;
            }
            if (i3 == 2) {
                return e;
            }
            if (i3 == 3) {
                return f;
            }
            if (i3 == 4) {
                return g;
            }
            str = "TLS";
        }
        return a(i2, i3, str);
    }

    public static v0 a(v0[] v0VarArr) {
        v0 v0Var = null;
        if (v0VarArr != null) {
            for (v0 v0Var2 : v0VarArr) {
                if (v0Var2 != null && v0Var2.h() && (v0Var == null || v0Var2.d() < v0Var.d())) {
                    v0Var = v0Var2;
                }
            }
        }
        return v0Var;
    }

    public v0 a() {
        int c2 = c();
        if (c2 == 3) {
            return this;
        }
        if (c2 != 254) {
            return null;
        }
        int d2 = d();
        if (d2 == 253) {
            return f;
        }
        if (d2 != 255) {
            return null;
        }
        return e;
    }

    private static v0 a(int i2, int i3, String str) {
        a(i2);
        a(i3);
        int i4 = (i2 << 8) | i3;
        return new v0(i4, str + " 0x" + sdk.pendo.io.d5.i.d(Integer.toHexString(65536 | i4).substring(1)));
    }
}
