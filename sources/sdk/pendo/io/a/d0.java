package sdk.pendo.io.a;

import java.lang.reflect.Method;
import org.apache.commons.io.IOUtils;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* loaded from: classes6.dex */
public final class d0 {
    public static final d0 e = new d0(0, "VZCBSIFJD", 0, 1);
    public static final d0 f = new d0(1, "VZCBSIFJD", 1, 2);
    public static final d0 g = new d0(2, "VZCBSIFJD", 2, 3);
    public static final d0 h = new d0(3, "VZCBSIFJD", 3, 4);
    public static final d0 i = new d0(4, "VZCBSIFJD", 4, 5);
    public static final d0 j = new d0(5, "VZCBSIFJD", 5, 6);
    public static final d0 k = new d0(6, "VZCBSIFJD", 6, 7);
    public static final d0 l = new d0(7, "VZCBSIFJD", 7, 8);
    public static final d0 m = new d0(8, "VZCBSIFJD", 8, 9);

    /* renamed from: a, reason: collision with root package name */
    private final int f819a;
    private final String b;
    private final int c;
    private final int d;

    private d0(int i2, String str, int i3, int i4) {
        this.f819a = i2;
        this.b = str;
        this.c = i3;
        this.d = i4;
    }

    private static void a(Class<?> cls, StringBuilder sb) {
        char c;
        while (cls.isArray()) {
            sb.append('[');
            cls = cls.getComponentType();
        }
        if (!cls.isPrimitive()) {
            sb.append(Matrix.MATRIX_TYPE_RANDOM_LT).append(b(cls)).append(';');
            return;
        }
        if (cls == Integer.TYPE) {
            c = 'I';
        } else if (cls == Void.TYPE) {
            c = 'V';
        } else if (cls == Boolean.TYPE) {
            c = Matrix.MATRIX_TYPE_ZERO;
        } else if (cls == Byte.TYPE) {
            c = 'B';
        } else if (cls == Character.TYPE) {
            c = 'C';
        } else if (cls == Short.TYPE) {
            c = 'S';
        } else if (cls == Double.TYPE) {
            c = 'D';
        } else if (cls == Float.TYPE) {
            c = 'F';
        } else {
            if (cls != Long.TYPE) {
                throw new AssertionError();
            }
            c = 'J';
        }
        sb.append(c);
    }

    public static int b(String str) {
        char charAt = str.charAt(1);
        int i2 = 1;
        int i3 = 1;
        while (charAt != ')') {
            if (charAt == 'J' || charAt == 'D') {
                i2++;
                i3 += 2;
            } else {
                while (str.charAt(i2) == '[') {
                    i2++;
                }
                int i4 = i2 + 1;
                if (str.charAt(i2) == 'L') {
                    i4 = Math.max(i4, str.indexOf(59, i4) + 1);
                }
                i3++;
                i2 = i4;
            }
            charAt = str.charAt(i2);
        }
        char charAt2 = str.charAt(i2 + 1);
        if (charAt2 == 'V') {
            return i3 << 2;
        }
        return (i3 << 2) | ((charAt2 == 'J' || charAt2 == 'D') ? 2 : 1);
    }

    public static d0 c(String str) {
        return new d0(11, str, 0, str.length());
    }

    public static d0 d(String str) {
        return new d0(str.charAt(0) == '[' ? 9 : 12, str, 0, str.length());
    }

    static int e(String str) {
        int i2 = 1;
        while (str.charAt(i2) != ')') {
            while (str.charAt(i2) == '[') {
                i2++;
            }
            int i3 = i2 + 1;
            i2 = str.charAt(i2) == 'L' ? Math.max(i3, str.indexOf(59, i3) + 1) : i3;
        }
        return i2 + 1;
    }

    public static d0 f(String str) {
        return a(str, 0, str.length());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        int i2 = this.f819a;
        if (i2 == 12) {
            i2 = 10;
        }
        int i3 = d0Var.f819a;
        if (i2 != (i3 != 12 ? i3 : 10)) {
            return false;
        }
        int i4 = this.c;
        int i5 = this.d;
        int i6 = d0Var.c;
        if (i5 - i4 != d0Var.d - i6) {
            return false;
        }
        while (i4 < i5) {
            if (this.b.charAt(i4) != d0Var.b.charAt(i6)) {
                return false;
            }
            i4++;
            i6++;
        }
        return true;
    }

    public int hashCode() {
        int i2 = this.f819a;
        int i3 = (i2 == 12 ? 10 : i2) * 13;
        if (i2 >= 9) {
            int i4 = this.d;
            for (int i5 = this.c; i5 < i4; i5++) {
                i3 = (i3 + this.b.charAt(i5)) * 17;
            }
        }
        return i3;
    }

    public String toString() {
        return a();
    }

    public static d0[] a(String str) {
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (str.charAt(i4) != ')') {
            while (str.charAt(i4) == '[') {
                i4++;
            }
            int i5 = i4 + 1;
            i4 = str.charAt(i4) == 'L' ? Math.max(i5, str.indexOf(59, i5) + 1) : i5;
            i3++;
        }
        d0[] d0VarArr = new d0[i3];
        int i6 = 1;
        while (str.charAt(i6) != ')') {
            int i7 = i6;
            while (str.charAt(i7) == '[') {
                i7++;
            }
            int i8 = i7 + 1;
            if (str.charAt(i7) == 'L') {
                i8 = Math.max(i8, str.indexOf(59, i8) + 1);
            }
            d0VarArr[i2] = a(str, i6, i8);
            i2++;
            i6 = i8;
        }
        return d0VarArr;
    }

    public String b() {
        return this.b.substring(this.c, this.d);
    }

    public int c() {
        int i2 = this.f819a;
        if (i2 == 12) {
            return 10;
        }
        return i2;
    }

    public static String b(Class<?> cls) {
        return cls.getName().replace('.', IOUtils.DIR_SEPARATOR_UNIX);
    }

    public static d0 c(Class<?> cls) {
        if (!cls.isPrimitive()) {
            return f(a(cls));
        }
        if (cls == Integer.TYPE) {
            return j;
        }
        if (cls == Void.TYPE) {
            return e;
        }
        if (cls == Boolean.TYPE) {
            return f;
        }
        if (cls == Byte.TYPE) {
            return h;
        }
        if (cls == Character.TYPE) {
            return g;
        }
        if (cls == Short.TYPE) {
            return i;
        }
        if (cls == Double.TYPE) {
            return m;
        }
        if (cls == Float.TYPE) {
            return k;
        }
        if (cls == Long.TYPE) {
            return l;
        }
        throw new AssertionError();
    }

    public String a() {
        int i2 = this.f819a;
        return i2 == 10 ? this.b.substring(this.c - 1, this.d + 1) : i2 == 12 ? "L" + this.b.substring(this.c, this.d) + ';' : this.b.substring(this.c, this.d);
    }

    public static String a(Class<?> cls) {
        StringBuilder sb = new StringBuilder();
        a(cls, sb);
        return sb.toString();
    }

    public static String a(Method method) {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        for (Class<?> cls : method.getParameterTypes()) {
            a(cls, sb);
        }
        sb.append(')');
        a(method.getReturnType(), sb);
        return sb.toString();
    }

    private static d0 a(String str, int i2, int i3) {
        char charAt = str.charAt(i2);
        if (charAt == '(') {
            return new d0(11, str, i2, i3);
        }
        if (charAt == 'F') {
            return k;
        }
        if (charAt == 'L') {
            return new d0(10, str, i2 + 1, i3 - 1);
        }
        if (charAt == 'S') {
            return i;
        }
        if (charAt == 'V') {
            return e;
        }
        if (charAt == 'I') {
            return j;
        }
        if (charAt == 'J') {
            return l;
        }
        if (charAt == 'Z') {
            return f;
        }
        if (charAt == '[') {
            return new d0(9, str, i2, i3);
        }
        switch (charAt) {
            case 'B':
                return h;
            case 'C':
                return g;
            case 'D':
                return m;
            default:
                throw new IllegalArgumentException();
        }
    }
}
