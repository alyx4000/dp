package sdk.pendo.io.a;

/* loaded from: classes6.dex */
final class b extends a {
    private final c0 c;
    private final boolean d;
    private final d e;
    private final int f;
    private int g;
    private final b h;
    private b i;

    b(c0 c0Var, boolean z, d dVar, b bVar) {
        super(589824);
        this.c = c0Var;
        this.d = z;
        this.e = dVar;
        int i = dVar.b;
        this.f = i == 0 ? -1 : i - 2;
        this.h = bVar;
        if (bVar != null) {
            bVar.i = this;
        }
    }

    static int a(b bVar, b bVar2, b bVar3, b bVar4) {
        int b = bVar != null ? 0 + bVar.b("RuntimeVisibleAnnotations") : 0;
        if (bVar2 != null) {
            b += bVar2.b("RuntimeInvisibleAnnotations");
        }
        if (bVar3 != null) {
            b += bVar3.b("RuntimeVisibleTypeAnnotations");
        }
        return bVar4 != null ? b + bVar4.b("RuntimeInvisibleTypeAnnotations") : b;
    }

    int b(String str) {
        if (str != null) {
            this.c.f(str);
        }
        int i = 8;
        for (b bVar = this; bVar != null; bVar = bVar.h) {
            i += bVar.e.b;
        }
        return i;
    }

    static int a(String str, b[] bVarArr, int i) {
        int i2 = (i * 2) + 7;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += bVarArr[i3] == null ? 0 : r3.b(str) - 8;
        }
        return i2;
    }

    static b a(c0 c0Var, int i, e0 e0Var, String str, b bVar) {
        d dVar = new d();
        f0.a(i, dVar);
        e0.a(e0Var, dVar);
        dVar.d(c0Var.f(str)).d(0);
        return new b(c0Var, true, dVar, bVar);
    }

    static b a(c0 c0Var, String str, b bVar) {
        d dVar = new d();
        dVar.d(c0Var.f(str)).d(0);
        return new b(c0Var, true, dVar, bVar);
    }

    void a(int i, d dVar) {
        int i2 = 2;
        int i3 = 0;
        b bVar = null;
        for (b bVar2 = this; bVar2 != null; bVar2 = bVar2.h) {
            bVar2.a();
            i2 += bVar2.e.b;
            i3++;
            bVar = bVar2;
        }
        dVar.d(i);
        dVar.c(i2);
        dVar.d(i3);
        while (bVar != null) {
            d dVar2 = bVar.e;
            dVar.a(dVar2.f818a, 0, dVar2.b);
            bVar = bVar.i;
        }
    }

    static void a(c0 c0Var, b bVar, b bVar2, b bVar3, b bVar4, d dVar) {
        if (bVar != null) {
            bVar.a(c0Var.f("RuntimeVisibleAnnotations"), dVar);
        }
        if (bVar2 != null) {
            bVar2.a(c0Var.f("RuntimeInvisibleAnnotations"), dVar);
        }
        if (bVar3 != null) {
            bVar3.a(c0Var.f("RuntimeVisibleTypeAnnotations"), dVar);
        }
        if (bVar4 != null) {
            bVar4.a(c0Var.f("RuntimeInvisibleTypeAnnotations"), dVar);
        }
    }

    static void a(int i, b[] bVarArr, int i2, d dVar) {
        int i3 = (i2 * 2) + 1;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += bVarArr[i4] == null ? 0 : r4.b(null) - 8;
        }
        dVar.d(i);
        dVar.c(i3);
        dVar.b(i2);
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = 0;
            b bVar = null;
            for (b bVar2 = bVarArr[i5]; bVar2 != null; bVar2 = bVar2.h) {
                bVar2.a();
                i6++;
                bVar = bVar2;
            }
            dVar.d(i6);
            while (bVar != null) {
                d dVar2 = bVar.e;
                dVar.a(dVar2.f818a, 0, dVar2.b);
                bVar = bVar.i;
            }
        }
    }

    @Override // sdk.pendo.io.a.a
    public void a(String str, Object obj) {
        int i;
        d dVar;
        int f;
        this.g++;
        if (this.d) {
            this.e.d(this.c.f(str));
        }
        if (obj instanceof String) {
            dVar = this.e;
            f = this.c.f((String) obj);
            i = 115;
        } else {
            i = 66;
            if (obj instanceof Byte) {
                dVar = this.e;
                f = this.c.a((int) ((Byte) obj).byteValue()).f814a;
            } else {
                if (obj instanceof Boolean) {
                    this.e.b(90, this.c.a(((Boolean) obj).booleanValue() ? 1 : 0).f814a);
                    return;
                }
                if (obj instanceof Character) {
                    this.e.b(67, this.c.a((int) ((Character) obj).charValue()).f814a);
                    return;
                }
                if (obj instanceof Short) {
                    this.e.b(83, this.c.a((int) ((Short) obj).shortValue()).f814a);
                    return;
                }
                if (!(obj instanceof d0)) {
                    int i2 = 0;
                    if (obj instanceof byte[]) {
                        byte[] bArr = (byte[]) obj;
                        this.e.b(91, bArr.length);
                        int length = bArr.length;
                        while (i2 < length) {
                            this.e.b(66, this.c.a((int) bArr[i2]).f814a);
                            i2++;
                        }
                        return;
                    }
                    if (obj instanceof boolean[]) {
                        boolean[] zArr = (boolean[]) obj;
                        this.e.b(91, zArr.length);
                        int length2 = zArr.length;
                        while (i2 < length2) {
                            this.e.b(90, this.c.a(zArr[i2] ? 1 : 0).f814a);
                            i2++;
                        }
                        return;
                    }
                    if (obj instanceof short[]) {
                        short[] sArr = (short[]) obj;
                        this.e.b(91, sArr.length);
                        int length3 = sArr.length;
                        while (i2 < length3) {
                            this.e.b(83, this.c.a((int) sArr[i2]).f814a);
                            i2++;
                        }
                        return;
                    }
                    if (obj instanceof char[]) {
                        char[] cArr = (char[]) obj;
                        this.e.b(91, cArr.length);
                        int length4 = cArr.length;
                        while (i2 < length4) {
                            this.e.b(67, this.c.a((int) cArr[i2]).f814a);
                            i2++;
                        }
                        return;
                    }
                    if (obj instanceof int[]) {
                        int[] iArr = (int[]) obj;
                        this.e.b(91, iArr.length);
                        int length5 = iArr.length;
                        while (i2 < length5) {
                            this.e.b(73, this.c.a(iArr[i2]).f814a);
                            i2++;
                        }
                        return;
                    }
                    if (obj instanceof long[]) {
                        long[] jArr = (long[]) obj;
                        this.e.b(91, jArr.length);
                        int length6 = jArr.length;
                        while (i2 < length6) {
                            this.e.b(74, this.c.a(jArr[i2]).f814a);
                            i2++;
                        }
                        return;
                    }
                    if (obj instanceof float[]) {
                        float[] fArr = (float[]) obj;
                        this.e.b(91, fArr.length);
                        int length7 = fArr.length;
                        while (i2 < length7) {
                            this.e.b(70, this.c.a(fArr[i2]).f814a);
                            i2++;
                        }
                        return;
                    }
                    if (!(obj instanceof double[])) {
                        b0 a2 = this.c.a(obj);
                        this.e.b(".s.IFJDCS".charAt(a2.b), a2.f814a);
                        return;
                    }
                    double[] dArr = (double[]) obj;
                    this.e.b(91, dArr.length);
                    int length8 = dArr.length;
                    while (i2 < length8) {
                        this.e.b(68, this.c.a(dArr[i2]).f814a);
                        i2++;
                    }
                    return;
                }
                dVar = this.e;
                f = this.c.f(((d0) obj).a());
                i = 99;
            }
        }
        dVar.b(i, f);
    }

    @Override // sdk.pendo.io.a.a
    public a a(String str, String str2) {
        this.g++;
        if (this.d) {
            this.e.d(this.c.f(str));
        }
        this.e.b(64, this.c.f(str2)).d(0);
        return new b(this.c, true, this.e, null);
    }

    @Override // sdk.pendo.io.a.a
    public a a(String str) {
        this.g++;
        if (this.d) {
            this.e.d(this.c.f(str));
        }
        this.e.b(91, 0);
        return new b(this.c, false, this.e, null);
    }

    @Override // sdk.pendo.io.a.a
    public void a() {
        int i = this.f;
        if (i != -1) {
            byte[] bArr = this.e.f818a;
            int i2 = this.g;
            bArr[i] = (byte) (i2 >>> 8);
            bArr[i + 1] = (byte) i2;
        }
    }

    @Override // sdk.pendo.io.a.a
    public void a(String str, String str2, String str3) {
        this.g++;
        if (this.d) {
            this.e.d(this.c.f(str));
        }
        this.e.b(101, this.c.f(str2)).d(this.c.f(str3));
    }
}
