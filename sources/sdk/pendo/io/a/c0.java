package sdk.pendo.io.a;

/* loaded from: classes6.dex */
final class c0 {

    /* renamed from: a, reason: collision with root package name */
    final h f817a;
    private final e b;
    private int c;
    private String d;
    private int e;
    private a[] f;
    private int g;
    private d h;
    private int i;
    private d j;
    private int k;
    private a[] l;

    private static class a extends b0 {
        final int h;
        a i;

        a(int i, int i2, long j, int i3) {
            super(i, i2, null, null, null, j);
            this.h = i3;
        }

        a(int i, int i2, String str, int i3) {
            super(i, i2, null, null, str, 0L);
            this.h = i3;
        }

        a(int i, int i2, String str, long j, int i3) {
            super(i, i2, null, null, str, j);
            this.h = i3;
        }

        a(int i, int i2, String str, String str2, int i3) {
            super(i, i2, null, str, str2, 0L);
            this.h = i3;
        }

        a(int i, int i2, String str, String str2, String str3, long j, int i3) {
            super(i, i2, str, str2, str3, j);
            this.h = i3;
        }
    }

    c0(h hVar) {
        this.f817a = hVar;
        this.b = null;
        this.f = new a[256];
        this.g = 1;
        this.h = new d();
    }

    private void a(a aVar) {
        this.e++;
        int i = aVar.h;
        a[] aVarArr = this.f;
        int length = i % aVarArr.length;
        aVar.i = aVarArr[length];
        aVarArr[length] = aVar;
    }

    private static int b(int i, long j) {
        return (i + ((int) j) + ((int) (j >>> 32))) & Integer.MAX_VALUE;
    }

    private void b(int i, int i2, int i3) {
        a(new a(i, i2, i3, c(i2, i3)));
    }

    private static int c(int i, int i2) {
        return (i + i2) & Integer.MAX_VALUE;
    }

    b0 c(String str) {
        return b(19, str);
    }

    b0 d(String str) {
        return b(20, str);
    }

    b0 e(String str) {
        return b(8, str);
    }

    int f(String str) {
        int c = c(1, str);
        for (a b = b(c); b != null; b = b.i) {
            if (b.b == 1 && b.h == c && b.e.equals(str)) {
                return b.f814a;
            }
        }
        this.h.b(1).a(str);
        int i = this.g;
        this.g = i + 1;
        return c(new a(i, 1, str, c)).f814a;
    }

    int g(String str) {
        int c = c(128, str);
        for (a b = b(c); b != null; b = b.i) {
            if (b.b == 128 && b.h == c && b.e.equals(str)) {
                return b.f814a;
            }
        }
        return b(new a(this.k, 128, str, c));
    }

    c0(h hVar, e eVar) {
        this.f817a = hVar;
        this.b = eVar;
        byte[] bArr = eVar.c;
        int a2 = eVar.a(1) - 1;
        int i = eVar.b - a2;
        this.g = eVar.b();
        d dVar = new d(i);
        this.h = dVar;
        dVar.a(bArr, a2, i);
        this.f = new a[this.g * 2];
        char[] cArr = new char[eVar.c()];
        boolean z = false;
        int i2 = 1;
        while (i2 < this.g) {
            int a3 = eVar.a(i2);
            byte b = bArr[a3 - 1];
            switch (b) {
                case 1:
                    a(i2, eVar.h(i2, cArr));
                    break;
                case 2:
                case 13:
                case 14:
                default:
                    throw new IllegalArgumentException();
                case 3:
                case 4:
                    b(i2, b, eVar.d(a3));
                    break;
                case 5:
                case 6:
                    a(i2, b, eVar.e(a3));
                    break;
                case 7:
                case 8:
                case 16:
                case 19:
                case 20:
                    a(i2, b, eVar.g(a3, cArr));
                    break;
                case 9:
                case 10:
                case 11:
                    int a4 = eVar.a(eVar.g(a3 + 2));
                    a(i2, b, eVar.a(a3, cArr), eVar.g(a4, cArr), eVar.g(a4 + 2, cArr));
                    break;
                case 12:
                    a(i2, eVar.g(a3, cArr), eVar.g(a3 + 2, cArr));
                    break;
                case 15:
                    int a5 = eVar.a(eVar.g(a3 + 1));
                    int a6 = eVar.a(eVar.g(a5 + 2));
                    b(i2, eVar.c(a3), eVar.a(a5, cArr), eVar.g(a6, cArr), eVar.g(a6 + 2, cArr));
                    break;
                case 17:
                case 18:
                    int a7 = eVar.a(eVar.g(a3 + 2));
                    a(b, i2, eVar.g(a7, cArr), eVar.g(a7 + 2, cArr), eVar.g(a3));
                    z = true;
                    break;
            }
            i2 += (b == 5 || b == 6) ? 2 : 1;
        }
        if (z) {
            a(eVar, cArr);
        }
    }

    private b0 a(int i, int i2, int i3) {
        byte[] bArr = this.j.f818a;
        for (a b = b(i3); b != null; b = b.i) {
            if (b.b == 64 && b.h == i3) {
                int i4 = (int) b.f;
                boolean z = false;
                int i5 = 0;
                while (true) {
                    if (i5 >= i2) {
                        z = true;
                        break;
                    }
                    if (bArr[i + i5] != bArr[i4 + i5]) {
                        break;
                    }
                    i5++;
                }
                if (z) {
                    this.j.b = i;
                    return b;
                }
            }
        }
        int i6 = this.i;
        this.i = i6 + 1;
        return c(new a(i6, 64, i, i3));
    }

    b0 b(String str, String str2, q qVar, Object... objArr) {
        return a(18, str, str2, a(qVar, objArr).f814a);
    }

    int c() {
        return this.g;
    }

    int d() {
        return this.h.b;
    }

    int e() {
        return this.c;
    }

    e f() {
        return this.b;
    }

    private void b(int i, int i2, String str, String str2, String str3) {
        a(new a(i, 15, str, str2, str3, i2, a(15, str, str2, str3, i2)));
    }

    b0 a(q qVar, Object... objArr) {
        d dVar = this.j;
        if (dVar == null) {
            dVar = new d();
            this.j = dVar;
        }
        int length = objArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = a(objArr[i]).f814a;
        }
        int i2 = dVar.b;
        dVar.d(a(qVar.d(), qVar.c(), qVar.b(), qVar.a(), qVar.e()).f814a);
        dVar.d(length);
        for (int i3 = 0; i3 < length; i3++) {
            dVar.d(iArr[i3]);
        }
        int i4 = dVar.b - i2;
        int hashCode = qVar.hashCode();
        for (Object obj : objArr) {
            hashCode ^= obj.hashCode();
        }
        return a(i2, i4, hashCode & Integer.MAX_VALUE);
    }

    b0 c(int i) {
        return this.l[i];
    }

    int d(int i, String str) {
        this.c = i;
        this.d = str;
        return a(str).f814a;
    }

    b0 a(Object obj) {
        if (obj instanceof Integer) {
            return a(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return a(((Byte) obj).intValue());
        }
        if (obj instanceof Character) {
            return a((int) ((Character) obj).charValue());
        }
        if (obj instanceof Short) {
            return a(((Short) obj).intValue());
        }
        if (obj instanceof Boolean) {
            return a(((Boolean) obj).booleanValue() ? 1 : 0);
        }
        if (obj instanceof Float) {
            return a(((Float) obj).floatValue());
        }
        if (obj instanceof Long) {
            return a(((Long) obj).longValue());
        }
        if (obj instanceof Double) {
            return a(((Double) obj).doubleValue());
        }
        if (obj instanceof String) {
            return e((String) obj);
        }
        if (obj instanceof d0) {
            d0 d0Var = (d0) obj;
            int c = d0Var.c();
            if (c == 10) {
                return a(d0Var.b());
            }
            String a2 = d0Var.a();
            return c == 11 ? b(a2) : a(a2);
        }
        if (obj instanceof q) {
            q qVar = (q) obj;
            return a(qVar.d(), qVar.c(), qVar.b(), qVar.a(), qVar.e());
        }
        if (!(obj instanceof i)) {
            throw new IllegalArgumentException("value " + obj);
        }
        i iVar = (i) obj;
        return a(iVar.d(), iVar.c(), iVar.a(), iVar.b());
    }

    b0 b(String str) {
        return b(16, str);
    }

    private b0 b(int i, String str) {
        int c = c(i, str);
        for (a b = b(c); b != null; b = b.i) {
            if (b.b == i && b.h == c && b.e.equals(str)) {
                return b;
            }
        }
        this.h.b(i, f(str));
        int i2 = this.g;
        this.g = i2 + 1;
        return c(new a(i2, i, str, c));
    }

    private static int c(int i, String str) {
        return (i + str.hashCode()) & Integer.MAX_VALUE;
    }

    b0 a(String str) {
        return b(7, str);
    }

    private a c(a aVar) {
        int i = this.e;
        a[] aVarArr = this.f;
        if (i > (aVarArr.length * 3) / 4) {
            int length = aVarArr.length;
            int i2 = (length * 2) + 1;
            a[] aVarArr2 = new a[i2];
            for (int i3 = length - 1; i3 >= 0; i3--) {
                a aVar2 = this.f[i3];
                while (aVar2 != null) {
                    int i4 = aVar2.h % i2;
                    a aVar3 = aVar2.i;
                    aVar2.i = aVarArr2[i4];
                    aVarArr2[i4] = aVar2;
                    aVar2 = aVar3;
                }
            }
            this.f = aVarArr2;
        }
        this.e++;
        int i5 = aVar.h;
        a[] aVarArr3 = this.f;
        int length2 = i5 % aVarArr3.length;
        aVar.i = aVarArr3[length2];
        aVarArr3[length2] = aVar;
        return aVar;
    }

    b0 a(double d) {
        return a(6, Double.doubleToRawLongBits(d));
    }

    int b(int i, int i2) {
        long j;
        long j2;
        if (i < i2) {
            j = i;
            j2 = i2;
        } else {
            j = i2;
            j2 = i;
        }
        long j3 = j | (j2 << 32);
        int c = c(130, i + i2);
        for (a b = b(c); b != null; b = b.i) {
            if (b.b == 130 && b.h == c && b.f == j3) {
                return b.g;
            }
        }
        a[] aVarArr = this.l;
        int g = g(this.f817a.b(aVarArr[i].e, aVarArr[i2].e));
        c(new a(this.k, 130, j3, c)).g = g;
        return g;
    }

    private int b(a aVar) {
        if (this.l == null) {
            this.l = new a[16];
        }
        int i = this.k;
        a[] aVarArr = this.l;
        if (i == aVarArr.length) {
            a[] aVarArr2 = new a[aVarArr.length * 2];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, aVarArr.length);
            this.l = aVarArr2;
        }
        a[] aVarArr3 = this.l;
        int i2 = this.k;
        this.k = i2 + 1;
        aVarArr3[i2] = aVar;
        return c(aVar).f814a;
    }

    b0 a(String str, String str2, q qVar, Object... objArr) {
        return a(17, str, str2, a(qVar, objArr).f814a);
    }

    private b0 a(int i, String str, String str2, int i2) {
        int b = b(i, str, str2, i2);
        for (a b2 = b(b); b2 != null; b2 = b2.i) {
            if (b2.b == i && b2.h == b && b2.f == i2 && b2.d.equals(str) && b2.e.equals(str2)) {
                return b2;
            }
        }
        this.h.b(i, i2, a(str, str2));
        int i3 = this.g;
        this.g = i3 + 1;
        return c(new a(i3, i, null, str, str2, i2, b));
    }

    private a b(int i) {
        a[] aVarArr = this.f;
        return aVarArr[i % aVarArr.length];
    }

    private void a(int i, int i2, String str, String str2, int i3) {
        a(new a(i2, i, null, str, str2, i3, b(i, str, str2, i3)));
    }

    String b() {
        return this.d;
    }

    b0 a(String str, String str2, String str3) {
        return a(9, str, str2, str3);
    }

    private static int b(int i, String str, String str2) {
        return (i + (str.hashCode() * str2.hashCode())) & Integer.MAX_VALUE;
    }

    b0 a(float f) {
        return a(4, Float.floatToRawIntBits(f));
    }

    private static int b(int i, String str, String str2, int i2) {
        return (i + (str.hashCode() * str2.hashCode() * (i2 + 1))) & Integer.MAX_VALUE;
    }

    b0 a(int i) {
        return a(3, i);
    }

    private b0 a(int i, int i2) {
        int c = c(i, i2);
        for (a b = b(c); b != null; b = b.i) {
            if (b.b == i && b.h == c && b.f == i2) {
                return b;
            }
        }
        this.h.b(i).c(i2);
        int i3 = this.g;
        this.g = i3 + 1;
        return c(new a(i3, i, i2, c));
    }

    private static int b(int i, String str, String str2, String str3) {
        return (i + (str.hashCode() * str2.hashCode() * str3.hashCode())) & Integer.MAX_VALUE;
    }

    b0 a(long j) {
        return a(5, j);
    }

    void b(d dVar) {
        d d = dVar.d(this.g);
        d dVar2 = this.h;
        d.a(dVar2.f818a, 0, dVar2.b);
    }

    private b0 a(int i, long j) {
        int b = b(i, j);
        for (a b2 = b(b); b2 != null; b2 = b2.i) {
            if (b2.b == i && b2.h == b && b2.f == j) {
                return b2;
            }
        }
        int i2 = this.g;
        this.h.b(i).a(j);
        this.g += 2;
        return c(new a(i2, i, j, b));
    }

    private void a(int i, int i2, long j) {
        a(new a(i, i2, j, b(i2, j)));
    }

    private a a(int i, String str, String str2, String str3) {
        int b = b(i, str, str2, str3);
        for (a b2 = b(b); b2 != null; b2 = b2.i) {
            if (b2.b == i && b2.h == b && b2.c.equals(str) && b2.d.equals(str2) && b2.e.equals(str3)) {
                return b2;
            }
        }
        this.h.b(i, a(str).f814a, a(str2, str3));
        int i2 = this.g;
        this.g = i2 + 1;
        return c(new a(i2, i, str, str2, str3, 0L, b));
    }

    private void a(int i, int i2, String str, String str2, String str3) {
        a(new a(i, i2, str, str2, str3, 0L, b(i2, str, str2, str3)));
    }

    b0 a(int i, String str, String str2, String str3, boolean z) {
        int a2 = a(15, str, str2, str3, i);
        for (a b = b(a2); b != null; b = b.i) {
            if (b.b == 15 && b.h == a2 && b.f == i && b.c.equals(str) && b.d.equals(str2) && b.e.equals(str3)) {
                return b;
            }
        }
        if (i <= 4) {
            this.h.a(15, i, a(str, str2, str3).f814a);
        } else {
            this.h.a(15, i, a(str, str2, str3, z).f814a);
        }
        int i2 = this.g;
        this.g = i2 + 1;
        return c(new a(i2, 15, str, str2, str3, i, a2));
    }

    b0 a(String str, String str2, String str3, boolean z) {
        return a(z ? 11 : 10, str, str2, str3);
    }

    int a(String str, String str2) {
        int b = b(12, str, str2);
        for (a b2 = b(b); b2 != null; b2 = b2.i) {
            if (b2.b == 12 && b2.h == b && b2.d.equals(str) && b2.e.equals(str2)) {
                return b2.f814a;
            }
        }
        this.h.b(12, f(str), f(str2));
        int i = this.g;
        this.g = i + 1;
        return c(new a(i, 12, str, str2, b)).f814a;
    }

    private void a(int i, String str, String str2) {
        a(new a(i, 12, str, str2, b(12, str, str2)));
    }

    private void a(int i, String str) {
        a(new a(i, 1, str, c(1, str)));
    }

    private void a(int i, int i2, String str) {
        a(new a(i, i2, str, c(i2, str)));
    }

    int a(String str, int i) {
        int a2 = a(129, str, i);
        for (a b = b(a2); b != null; b = b.i) {
            if (b.b == 129 && b.h == a2 && b.f == i && b.e.equals(str)) {
                return b.f814a;
            }
        }
        return b(new a(this.k, 129, str, i, a2));
    }

    int a() {
        if (this.j == null) {
            return 0;
        }
        f("BootstrapMethods");
        return this.j.b + 8;
    }

    private void a(e eVar, char[] cArr) {
        byte[] bArr = eVar.c;
        int a2 = eVar.a();
        int g = eVar.g(a2 - 2);
        while (true) {
            if (g <= 0) {
                break;
            }
            if ("BootstrapMethods".equals(eVar.g(a2, cArr))) {
                this.i = eVar.g(a2 + 6);
                break;
            } else {
                a2 += eVar.d(a2 + 2) + 6;
                g--;
            }
        }
        if (this.i > 0) {
            int i = a2 + 8;
            int d = eVar.d(a2 + 2) - 2;
            d dVar = new d(d);
            this.j = dVar;
            dVar.a(bArr, i, d);
            int i2 = i;
            for (int i3 = 0; i3 < this.i; i3++) {
                int i4 = i2 - i;
                int g2 = eVar.g(i2);
                int i5 = i2 + 2;
                int g3 = eVar.g(i5);
                i2 = i5 + 2;
                int hashCode = eVar.b(g2, cArr).hashCode();
                while (true) {
                    int i6 = g3 - 1;
                    if (g3 > 0) {
                        int g4 = eVar.g(i2);
                        i2 += 2;
                        hashCode ^= eVar.b(g4, cArr).hashCode();
                        g3 = i6;
                    }
                }
                a(new a(i3, 64, i4, hashCode & Integer.MAX_VALUE));
            }
        }
    }

    private static int a(int i, String str, int i2) {
        return (i + str.hashCode() + i2) & Integer.MAX_VALUE;
    }

    private static int a(int i, String str, String str2, String str3, int i2) {
        return (i + (str.hashCode() * str2.hashCode() * str3.hashCode() * i2)) & Integer.MAX_VALUE;
    }

    void a(d dVar) {
        if (this.j != null) {
            d d = dVar.d(f("BootstrapMethods")).c(this.j.b + 2).d(this.i);
            d dVar2 = this.j;
            d.a(dVar2.f818a, 0, dVar2.b);
        }
    }
}
