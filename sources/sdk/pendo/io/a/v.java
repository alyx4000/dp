package sdk.pendo.io.a;

import external.sdk.pendo.io.mozilla.javascript.Context;
import sdk.pendo.io.a.c;

/* loaded from: classes6.dex */
final class v extends u {
    private static final int[] c0 = {0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 2, 2, 1, 1, 1, 0, 0, 1, 2, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, -1, -1, -1, -1, -1, -2, -1, -2, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, -4, -3, -4, -3, -3, -3, -3, -1, -2, 1, 1, 1, 2, 2, 2, 0, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -2, -1, -2, -1, -2, 0, 1, 0, 1, -1, -1, 0, 0, 1, 1, -1, 0, -1, 0, 0, 0, -3, -1, -1, -3, -3, -1, -1, -1, -1, -1, -1, -2, -2, -2, -2, -2, -2, -2, -2, 0, 1, 0, -1, -1, -1, -2, -1, -2, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, -1, -1, 0, 0, -1, -1, 0, 0};
    private final int A;
    private b B;
    private b C;
    private int D;
    private b[] E;
    private int F;
    private b[] G;
    private b H;
    private b I;
    private d J;
    private int K;
    private d L;
    private c M;
    private final int N;
    private s O;
    private s P;
    private s Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int[] V;
    private int[] W;
    private boolean X;
    private boolean Y;
    private int Z;
    private int a0;
    private int b0;
    private final c0 c;
    private final int d;
    private final int e;
    private final String f;
    private final int g;
    private final String h;
    private int i;
    private int j;
    private final d k;
    private r l;
    private r m;
    private int n;
    private d o;
    private int p;
    private d q;
    private int r;
    private d s;
    private int t;
    private d u;
    private b v;
    private b w;
    private c x;
    private final int y;
    private final int[] z;

    v(c0 c0Var, int i, String str, String str2, String str3, String[] strArr, int i2) {
        super(589824);
        this.k = new d();
        this.c = c0Var;
        this.d = "<init>".equals(str) ? 262144 | i : i;
        this.e = c0Var.f(str);
        this.f = str;
        this.g = c0Var.f(str2);
        this.h = str2;
        this.A = str3 == null ? 0 : c0Var.f(str3);
        if (strArr == null || strArr.length <= 0) {
            this.y = 0;
            this.z = null;
        } else {
            int length = strArr.length;
            this.y = length;
            this.z = new int[length];
            for (int i3 = 0; i3 < this.y; i3++) {
                this.z[i3] = c0Var.a(strArr[i3]).f814a;
            }
        }
        this.N = i2;
        if (i2 != 0) {
            int b = d0.b(str2) >> 2;
            b = (i & 8) != 0 ? b - 1 : b;
            this.j = b;
            this.T = b;
            s sVar = new s();
            this.O = sVar;
            a(sVar);
        }
    }

    private void b(Object obj) {
        d b;
        int i;
        if (obj instanceof Integer) {
            this.u.b(((Integer) obj).intValue());
            return;
        }
        if (obj instanceof String) {
            b = this.u.b(7);
            i = this.c.a((String) obj).f814a;
        } else {
            b = this.u.b(8);
            i = ((s) obj).d;
        }
        b.d(i);
    }

    private void c(int i, s sVar) {
        s sVar2 = this.Q;
        sVar2.l = new m(i, sVar, sVar2.l);
    }

    private void d() {
        r rVar = this.l;
        while (true) {
            if (rVar == null) {
                break;
            }
            String str = rVar.e;
            int a2 = p.a(this.c, str != null ? str : "java/lang/Throwable");
            s a3 = rVar.c.a();
            a3.f830a = (short) (a3.f830a | 2);
            s a4 = rVar.b.a();
            for (s a5 = rVar.f829a.a(); a5 != a4; a5 = a5.k) {
                a5.l = new m(a2, a3, a5.l);
            }
            rVar = rVar.f;
        }
        p pVar = this.O.j;
        pVar.a(this.c, this.d, this.h, this.j);
        pVar.a(this);
        s sVar = this.O;
        sVar.m = s.n;
        int i = 0;
        while (sVar != s.n) {
            s sVar2 = sVar.m;
            sVar.m = null;
            sVar.f830a = (short) (sVar.f830a | 8);
            int a6 = sVar.j.a() + sVar.h;
            if (a6 > i) {
                i = a6;
            }
            for (m mVar = sVar.l; mVar != null; mVar = mVar.c) {
                s a7 = mVar.b.a();
                if (sVar.j.a(this.c, a7.j, mVar.f825a) && a7.m == null) {
                    a7.m = sVar2;
                    sVar2 = a7;
                }
            }
            sVar = sVar2;
        }
        for (s sVar3 = this.O; sVar3 != null; sVar3 = sVar3.k) {
            if ((sVar3.f830a & 10) == 10) {
                sVar3.j.a(this);
            }
            if ((sVar3.f830a & 8) == 0) {
                s sVar4 = sVar3.k;
                int i2 = sVar3.d;
                int i3 = (sVar4 == null ? this.k.b : sVar4.d) - 1;
                if (i3 >= i2) {
                    for (int i4 = i2; i4 < i3; i4++) {
                        this.k.f818a[i4] = 0;
                    }
                    this.k.f818a[i3] = -65;
                    this.W[a(i2, 0, 1)] = p.a(this.c, "java/lang/Throwable");
                    k();
                    this.l = r.a(this.l, sVar3, sVar4);
                    i = Math.max(i, 1);
                }
            }
        }
        this.i = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[LOOP:5: B:47:0x0084->B:66:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00a3 -> B:42:0x00b2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e() {
        /*
            Method dump skipped, instructions count: 184
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.a.v.e():void");
    }

    private void g() {
        int i = this.N;
        if (i == 4) {
            s sVar = new s();
            sVar.j = new p(sVar);
            d dVar = this.k;
            sVar.a(dVar.f818a, dVar.b);
            this.P.k = sVar;
            this.P = sVar;
        } else {
            if (i != 1) {
                return;
            }
            this.Q.h = (short) this.S;
        }
        this.Q = null;
    }

    private void j() {
        char c;
        d b;
        int[] iArr = this.W;
        int i = iArr[1];
        int i2 = iArr[2];
        int i3 = 0;
        if (this.c.e() < 50) {
            this.u.d(this.W[0]).d(i);
            int i4 = i + 3;
            e(3, i4);
            this.u.d(i2);
            e(i4, i2 + i4);
            return;
        }
        int i5 = this.t == 0 ? this.W[0] : (this.W[0] - this.V[0]) - 1;
        int i6 = this.V[1];
        int i7 = i - i6;
        if (i2 == 0) {
            switch (i7) {
                case -3:
                case -2:
                case -1:
                    c = 248;
                    break;
                case 0:
                    if (i5 >= 64) {
                        c = 251;
                        break;
                    } else {
                        c = 0;
                        break;
                    }
                case 1:
                case 2:
                case 3:
                    c = 252;
                    break;
                default:
                    c = 255;
                    break;
            }
        } else {
            if (i7 == 0 && i2 == 1) {
                c = i5 < 63 ? '@' : (char) 247;
            }
            c = 255;
        }
        if (c != 255) {
            int i8 = 3;
            while (true) {
                if (i3 < i6 && i3 < i) {
                    if (this.W[i8] != this.V[i8]) {
                        c = 255;
                    } else {
                        i8++;
                        i3++;
                    }
                }
            }
        }
        if (c == 0) {
            this.u.b(i5);
            return;
        }
        if (c == '@') {
            this.u.b(i5 + 64);
        } else {
            if (c != 247) {
                if (c == 248) {
                    b = this.u.b(i7 + 251);
                } else {
                    if (c != 251) {
                        if (c == 252) {
                            this.u.b(i7 + 251).d(i5);
                            e(i6 + 3, i + 3);
                            return;
                        }
                        this.u.b(255).d(i5).d(i);
                        int i9 = i + 3;
                        e(3, i9);
                        this.u.d(i2);
                        e(i9, i2 + i9);
                        return;
                    }
                    b = this.u.b(251);
                }
                b.d(i5);
                return;
            }
            this.u.b(247).d(i5);
        }
        e(i + 3, i + 4);
    }

    boolean a(e eVar, boolean z, boolean z2, int i, int i2, int i3) {
        if (eVar == this.c.f() && i == this.g && i2 == this.A) {
            if (z2 == ((this.d & 131072) != 0)) {
                if (z != (this.c.e() < 49 && (this.d & 4096) != 0)) {
                    return false;
                }
                if (i3 == 0) {
                    if (this.y != 0) {
                        return false;
                    }
                } else if (eVar.g(i3) == this.y) {
                    int i4 = i3 + 2;
                    for (int i5 = 0; i5 < this.y; i5++) {
                        if (eVar.g(i4) != this.z[i5]) {
                            return false;
                        }
                        i4 += 2;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // sdk.pendo.io.a.u
    public void b() {
    }

    @Override // sdk.pendo.io.a.u
    public void c() {
    }

    int f() {
        int i;
        if (this.a0 != 0) {
            return this.b0 + 6;
        }
        int i2 = this.k.b;
        if (i2 <= 0) {
            i = 8;
        } else {
            if (i2 > 65535) {
                throw new t(this.c.b(), this.f, this.h, this.k.b);
            }
            this.c.f("Code");
            i = this.k.b + 16 + r.b(this.l) + 8;
            if (this.u != null) {
                this.c.f(this.c.e() >= 50 ? "StackMapTable" : "StackMap");
                i += this.u.b + 8;
            }
            if (this.o != null) {
                this.c.f("LineNumberTable");
                i += this.o.b + 8;
            }
            if (this.q != null) {
                this.c.f("LocalVariableTable");
                i += this.q.b + 8;
            }
            if (this.s != null) {
                this.c.f("LocalVariableTypeTable");
                i += this.s.b + 8;
            }
            b bVar = this.v;
            if (bVar != null) {
                i += bVar.b("RuntimeVisibleTypeAnnotations");
            }
            b bVar2 = this.w;
            if (bVar2 != null) {
                i += bVar2.b("RuntimeInvisibleTypeAnnotations");
            }
            c cVar = this.x;
            if (cVar != null) {
                c0 c0Var = this.c;
                d dVar = this.k;
                i += cVar.a(c0Var, dVar.f818a, dVar.b, this.i, this.j);
            }
        }
        if (this.y > 0) {
            this.c.f("Exceptions");
            i += (this.y * 2) + 8;
        }
        int a2 = i + c.a(this.c, this.d, this.A) + b.a(this.B, this.C, this.H, this.I);
        b[] bVarArr = this.E;
        if (bVarArr != null) {
            int i3 = this.D;
            if (i3 == 0) {
                i3 = bVarArr.length;
            }
            a2 += b.a("RuntimeVisibleParameterAnnotations", bVarArr, i3);
        }
        b[] bVarArr2 = this.G;
        if (bVarArr2 != null) {
            int i4 = this.F;
            if (i4 == 0) {
                i4 = bVarArr2.length;
            }
            a2 += b.a("RuntimeInvisibleParameterAnnotations", bVarArr2, i4);
        }
        if (this.J != null) {
            this.c.f("AnnotationDefault");
            a2 += this.J.b + 6;
        }
        if (this.L != null) {
            this.c.f("MethodParameters");
            a2 += this.L.b + 7;
        }
        c cVar2 = this.M;
        return cVar2 != null ? a2 + cVar2.a(this.c) : a2;
    }

    boolean h() {
        return this.Y;
    }

    boolean i() {
        return this.t > 0;
    }

    void k() {
        if (this.V != null) {
            if (this.u == null) {
                this.u = new d();
            }
            j();
            this.t++;
        }
        this.V = this.W;
        this.W = null;
    }

    private void e(int i, int i2) {
        while (i < i2) {
            p.a(this.c, this.W[i], this.u);
            i++;
        }
    }

    final void a(c.a aVar) {
        aVar.b(this.M);
        aVar.b(this.x);
    }

    @Override // sdk.pendo.io.a.u
    public void d(int i, int i2) {
        d dVar = this.k;
        this.Z = dVar.b;
        if (i2 < 4 && i != 169) {
            dVar.b((i < 54 ? ((i - 21) << 2) + 26 : ((i - 54) << 2) + 59) + i2);
        } else if (i2 >= 256) {
            dVar.b(196).b(i, i2);
        } else {
            dVar.a(i, i2);
        }
        s sVar = this.Q;
        if (sVar != null) {
            int i3 = this.N;
            if (i3 == 4 || i3 == 3) {
                sVar.j.a(i, i2, (b0) null, (c0) null);
            } else if (i == 169) {
                sVar.f830a = (short) (sVar.f830a | 64);
                sVar.g = (short) this.R;
                g();
            } else {
                int i4 = this.R + c0[i];
                if (i4 > this.S) {
                    this.S = i4;
                }
                this.R = i4;
            }
        }
        int i5 = this.N;
        if (i5 != 0) {
            int i6 = (i == 22 || i == 24 || i == 55 || i == 57) ? i2 + 2 : i2 + 1;
            if (i6 > this.j) {
                this.j = i6;
            }
        }
        if (i < 54 || i5 != 4 || this.l == null) {
            return;
        }
        a(new s());
    }

    void f(int i, int i2) {
        this.a0 = i + 6;
        this.b0 = i2 - 6;
    }

    void g(int i, int i2) {
        this.W[i] = i2;
    }

    void a(d dVar) {
        int i;
        boolean z = this.c.e() < 49;
        dVar.d((~(z ? 4096 : 0)) & this.d).d(this.e).d(this.g);
        if (this.a0 != 0) {
            dVar.a(this.c.f().c, this.a0, this.b0);
            return;
        }
        int i2 = this.k.b > 0 ? 1 : 0;
        if (this.y > 0) {
            i2++;
        }
        int i3 = this.d;
        if ((i3 & 4096) != 0 && z) {
            i2++;
        }
        if (this.A != 0) {
            i2++;
        }
        if ((131072 & i3) != 0) {
            i2++;
        }
        if (this.B != null) {
            i2++;
        }
        if (this.C != null) {
            i2++;
        }
        if (this.E != null) {
            i2++;
        }
        if (this.G != null) {
            i2++;
        }
        if (this.H != null) {
            i2++;
        }
        if (this.I != null) {
            i2++;
        }
        if (this.J != null) {
            i2++;
        }
        if (this.L != null) {
            i2++;
        }
        c cVar = this.M;
        if (cVar != null) {
            i2 += cVar.a();
        }
        dVar.d(i2);
        int i4 = this.k.b;
        if (i4 > 0) {
            int b = i4 + 10 + r.b(this.l);
            d dVar2 = this.u;
            if (dVar2 != null) {
                b += dVar2.b + 8;
                i = 1;
            } else {
                i = 0;
            }
            d dVar3 = this.o;
            if (dVar3 != null) {
                b += dVar3.b + 8;
                i++;
            }
            d dVar4 = this.q;
            if (dVar4 != null) {
                b += dVar4.b + 8;
                i++;
            }
            d dVar5 = this.s;
            if (dVar5 != null) {
                b += dVar5.b + 8;
                i++;
            }
            b bVar = this.v;
            if (bVar != null) {
                b += bVar.b("RuntimeVisibleTypeAnnotations");
                i++;
            }
            b bVar2 = this.w;
            if (bVar2 != null) {
                b += bVar2.b("RuntimeInvisibleTypeAnnotations");
                i++;
            }
            c cVar2 = this.x;
            if (cVar2 != null) {
                c0 c0Var = this.c;
                d dVar6 = this.k;
                b += cVar2.a(c0Var, dVar6.f818a, dVar6.b, this.i, this.j);
                i += this.x.a();
            }
            d c = dVar.d(this.c.f("Code")).c(b).d(this.i).d(this.j).c(this.k.b);
            d dVar7 = this.k;
            c.a(dVar7.f818a, 0, dVar7.b);
            r.a(this.l, dVar);
            dVar.d(i);
            if (this.u != null) {
                d d = dVar.d(this.c.f(this.c.e() >= 50 ? "StackMapTable" : "StackMap")).c(this.u.b + 2).d(this.t);
                d dVar8 = this.u;
                d.a(dVar8.f818a, 0, dVar8.b);
            }
            if (this.o != null) {
                d d2 = dVar.d(this.c.f("LineNumberTable")).c(this.o.b + 2).d(this.n);
                d dVar9 = this.o;
                d2.a(dVar9.f818a, 0, dVar9.b);
            }
            if (this.q != null) {
                d d3 = dVar.d(this.c.f("LocalVariableTable")).c(this.q.b + 2).d(this.p);
                d dVar10 = this.q;
                d3.a(dVar10.f818a, 0, dVar10.b);
            }
            if (this.s != null) {
                d d4 = dVar.d(this.c.f("LocalVariableTypeTable")).c(this.s.b + 2).d(this.r);
                d dVar11 = this.s;
                d4.a(dVar11.f818a, 0, dVar11.b);
            }
            b bVar3 = this.v;
            if (bVar3 != null) {
                bVar3.a(this.c.f("RuntimeVisibleTypeAnnotations"), dVar);
            }
            b bVar4 = this.w;
            if (bVar4 != null) {
                bVar4.a(this.c.f("RuntimeInvisibleTypeAnnotations"), dVar);
            }
            c cVar3 = this.x;
            if (cVar3 != null) {
                c0 c0Var2 = this.c;
                d dVar12 = this.k;
                cVar3.a(c0Var2, dVar12.f818a, dVar12.b, this.i, this.j, dVar);
            }
        }
        if (this.y > 0) {
            dVar.d(this.c.f("Exceptions")).c((this.y * 2) + 2).d(this.y);
            for (int i5 : this.z) {
                dVar.d(i5);
            }
        }
        c.a(this.c, this.d, this.A, dVar);
        b.a(this.c, this.B, this.C, this.H, this.I, dVar);
        if (this.E != null) {
            int f = this.c.f("RuntimeVisibleParameterAnnotations");
            b[] bVarArr = this.E;
            int i6 = this.D;
            if (i6 == 0) {
                i6 = bVarArr.length;
            }
            b.a(f, bVarArr, i6, dVar);
        }
        if (this.G != null) {
            int f2 = this.c.f("RuntimeInvisibleParameterAnnotations");
            b[] bVarArr2 = this.G;
            int i7 = this.F;
            if (i7 == 0) {
                i7 = bVarArr2.length;
            }
            b.a(f2, bVarArr2, i7, dVar);
        }
        if (this.J != null) {
            d c2 = dVar.d(this.c.f("AnnotationDefault")).c(this.J.b);
            d dVar13 = this.J;
            c2.a(dVar13.f818a, 0, dVar13.b);
        }
        if (this.L != null) {
            d b2 = dVar.d(this.c.f("MethodParameters")).c(this.L.b + 1).b(this.K);
            d dVar14 = this.L;
            b2.a(dVar14.f818a, 0, dVar14.b);
        }
        c cVar4 = this.M;
        if (cVar4 != null) {
            cVar4.a(this.c, dVar);
        }
    }

    @Override // sdk.pendo.io.a.u
    public void b(int i, int i2) {
        d dVar = this.k;
        this.Z = dVar.b;
        if (i == 17) {
            dVar.b(i, i2);
        } else {
            dVar.a(i, i2);
        }
        s sVar = this.Q;
        if (sVar != null) {
            int i3 = this.N;
            if (i3 == 4 || i3 == 3) {
                sVar.j.a(i, i2, (b0) null, (c0) null);
            } else if (i != 188) {
                int i4 = this.R + 1;
                if (i4 > this.S) {
                    this.S = i4;
                }
                this.R = i4;
            }
        }
    }

    @Override // sdk.pendo.io.a.u
    public void c(int i, int i2) {
        int i3 = this.N;
        if (i3 == 4) {
            d();
            return;
        }
        if (i3 == 1) {
            e();
        } else if (i3 == 2) {
            this.i = this.S;
        } else {
            this.i = i;
            this.j = i2;
        }
    }

    @Override // sdk.pendo.io.a.u
    public void a(int i, boolean z) {
        if (z) {
            this.D = i;
        } else {
            this.F = i;
        }
    }

    @Override // sdk.pendo.io.a.u
    public void b(int i, s sVar) {
        if (this.o == null) {
            this.o = new d();
        }
        this.n++;
        this.o.d(sVar.d);
        this.o.d(i);
    }

    @Override // sdk.pendo.io.a.u
    public a c(int i, e0 e0Var, String str, boolean z) {
        if (z) {
            b a2 = b.a(this.c, i, e0Var, str, this.H);
            this.H = a2;
            return a2;
        }
        b a3 = b.a(this.c, i, e0Var, str, this.I);
        this.I = a3;
        return a3;
    }

    @Override // sdk.pendo.io.a.u
    public a a(String str, boolean z) {
        if (z) {
            b a2 = b.a(this.c, str, this.B);
            this.B = a2;
            return a2;
        }
        b a3 = b.a(this.c, str, this.C);
        this.C = a3;
        return a3;
    }

    @Override // sdk.pendo.io.a.u
    public void b(String str, int i) {
        if (this.L == null) {
            this.L = new d();
        }
        this.K++;
        this.L.d(str == null ? 0 : this.c.f(str)).d(i);
    }

    @Override // sdk.pendo.io.a.u
    public a a() {
        d dVar = new d();
        this.J = dVar;
        return new b(this.c, false, dVar, null);
    }

    @Override // sdk.pendo.io.a.u
    public a b(int i, e0 e0Var, String str, boolean z) {
        if (z) {
            b a2 = b.a(this.c, i, e0Var, str, this.v);
            this.v = a2;
            return a2;
        }
        b a3 = b.a(this.c, i, e0Var, str, this.w);
        this.w = a3;
        return a3;
    }

    @Override // sdk.pendo.io.a.u
    public void a(c cVar) {
        if (cVar.b()) {
            cVar.c = this.x;
            this.x = cVar;
        } else {
            cVar.c = this.M;
            this.M = cVar;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0037, code lost:
    
        if (r5 != 'J') goto L32;
     */
    @Override // sdk.pendo.io.a.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r4, java.lang.String r5, java.lang.String r6, java.lang.String r7) {
        /*
            r3 = this;
            sdk.pendo.io.a.d r0 = r3.k
            int r0 = r0.b
            r3.Z = r0
            sdk.pendo.io.a.c0 r0 = r3.c
            sdk.pendo.io.a.b0 r5 = r0.a(r5, r6, r7)
            sdk.pendo.io.a.d r6 = r3.k
            int r0 = r5.f814a
            r6.b(r4, r0)
            sdk.pendo.io.a.s r6 = r3.Q
            if (r6 == 0) goto L62
            int r0 = r3.N
            r1 = 4
            r2 = 0
            if (r0 == r1) goto L5b
            r1 = 3
            if (r0 != r1) goto L21
            goto L5b
        L21:
            char r5 = r7.charAt(r2)
            r6 = 74
            r7 = 68
            switch(r4) {
                case 178: goto L43;
                case 179: goto L3a;
                case 180: goto L33;
                default: goto L2c;
            }
        L2c:
            int r4 = r3.R
            if (r5 == r7) goto L50
            if (r5 != r6) goto L4e
            goto L50
        L33:
            int r4 = r3.R
            if (r5 == r7) goto L4a
            if (r5 != r6) goto L51
            goto L4a
        L3a:
            int r4 = r3.R
            if (r5 == r7) goto L4e
            if (r5 != r6) goto L41
            goto L4e
        L41:
            r2 = -1
            goto L51
        L43:
            int r4 = r3.R
            if (r5 == r7) goto L4c
            if (r5 != r6) goto L4a
            goto L4c
        L4a:
            r2 = 1
            goto L51
        L4c:
            r2 = 2
            goto L51
        L4e:
            r2 = -2
            goto L51
        L50:
            r2 = -3
        L51:
            int r4 = r4 + r2
            int r5 = r3.S
            if (r4 <= r5) goto L58
            r3.S = r4
        L58:
            r3.R = r4
            goto L62
        L5b:
            sdk.pendo.io.a.p r6 = r6.j
            sdk.pendo.io.a.c0 r7 = r3.c
            r6.a(r4, r2, r5, r7)
        L62:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.a.v.a(int, java.lang.String, java.lang.String, java.lang.String):void");
    }

    @Override // sdk.pendo.io.a.u
    public void a(int i, int i2, Object[] objArr, int i3, Object[] objArr2) {
        int i4;
        d dVar;
        int i5 = this.N;
        if (i5 == 4) {
            return;
        }
        if (i5 == 3) {
            s sVar = this.Q;
            p pVar = sVar.j;
            if (pVar == null) {
                sVar.j = new l(sVar);
                this.Q.j.a(this.c, this.d, this.h, i2);
            } else if (i == -1) {
                pVar.a(this.c, i2, objArr, i3, objArr2);
            }
            this.Q.j.a(this);
        } else if (i == -1) {
            if (this.V == null) {
                int b = d0.b(this.h) >> 2;
                p pVar2 = new p(new s());
                pVar2.a(this.c, this.d, this.h, b);
                pVar2.a(this);
            }
            this.T = i2;
            int a2 = a(this.k.b, i2, i3);
            int i6 = 0;
            while (i6 < i2) {
                this.W[a2] = p.a(this.c, objArr[i6]);
                i6++;
                a2++;
            }
            int i7 = 0;
            while (i7 < i3) {
                this.W[a2] = p.a(this.c, objArr2[i7]);
                i7++;
                a2++;
            }
            k();
        } else {
            if (this.c.e() < 50) {
                throw new IllegalArgumentException("Class versions V1_5 or less must use F_NEW frames.");
            }
            if (this.u == null) {
                this.u = new d();
                i4 = this.k.b;
            } else {
                i4 = (this.k.b - this.U) - 1;
                if (i4 < 0) {
                    if (i != 3) {
                        throw new IllegalStateException();
                    }
                    return;
                }
            }
            if (i == 0) {
                this.T = i2;
                this.u.b(255).d(i4).d(i2);
                for (int i8 = 0; i8 < i2; i8++) {
                    b(objArr[i8]);
                }
                this.u.d(i3);
                for (int i9 = 0; i9 < i3; i9++) {
                    b(objArr2[i9]);
                }
            } else if (i != 1) {
                int i10 = 251;
                if (i == 2) {
                    this.T -= i2;
                    dVar = this.u;
                    i10 = 251 - i2;
                } else if (i == 3) {
                    dVar = this.u;
                    if (i4 < 64) {
                        dVar.b(i4);
                    }
                } else {
                    if (i != 4) {
                        throw new IllegalArgumentException();
                    }
                    d dVar2 = this.u;
                    if (i4 < 64) {
                        dVar2.b(i4 + 64);
                    } else {
                        dVar2.b(247).d(i4);
                    }
                    b(objArr2[0]);
                }
                dVar.b(i10).d(i4);
            } else {
                this.T += i2;
                this.u.b(i2 + 251).d(i4);
                for (int i11 = 0; i11 < i2; i11++) {
                    b(objArr[i11]);
                }
            }
            this.U = this.k.b;
            this.t++;
        }
        if (this.N == 2) {
            this.R = i3;
            for (int i12 = 0; i12 < i3; i12++) {
                Object obj = objArr2[i12];
                if (obj == y.e || obj == y.d) {
                    this.R++;
                }
            }
            int i13 = this.R;
            if (i13 > this.S) {
                this.S = i13;
            }
        }
        this.i = Math.max(this.i, i3);
        this.j = Math.max(this.j, this.T);
    }

    int a(int i, int i2, int i3) {
        int i4 = i2 + 3 + i3;
        int[] iArr = this.W;
        if (iArr == null || iArr.length < i4) {
            this.W = new int[i4];
        }
        int[] iArr2 = this.W;
        iArr2[0] = i;
        iArr2[1] = i2;
        iArr2[2] = i3;
        return 3;
    }

    @Override // sdk.pendo.io.a.u
    public void a(int i, int i2) {
        int i3;
        int i4;
        d dVar = this.k;
        this.Z = dVar.b;
        if (i > 255 || i2 > 127 || i2 < -128) {
            dVar.b(196).b(132, i).d(i2);
        } else {
            dVar.b(132).a(i, i2);
        }
        s sVar = this.Q;
        if (sVar != null && ((i4 = this.N) == 4 || i4 == 3)) {
            sVar.j.a(132, i, (b0) null, (c0) null);
        }
        if (this.N == 0 || (i3 = i + 1) <= this.j) {
            return;
        }
        this.j = i3;
    }

    @Override // sdk.pendo.io.a.u
    public void a(int i) {
        d dVar = this.k;
        this.Z = dVar.b;
        dVar.b(i);
        s sVar = this.Q;
        if (sVar != null) {
            int i2 = this.N;
            if (i2 == 4 || i2 == 3) {
                sVar.j.a(i, 0, (b0) null, (c0) null);
            } else {
                int i3 = this.R + c0[i];
                if (i3 > this.S) {
                    this.S = i3;
                }
                this.R = i3;
            }
            if ((i < 172 || i > 177) && i != 191) {
                return;
            }
            g();
        }
    }

    @Override // sdk.pendo.io.a.u
    public a a(int i, e0 e0Var, String str, boolean z) {
        if (z) {
            b a2 = b.a(this.c, (i & (-16776961)) | (this.Z << 8), e0Var, str, this.v);
            this.v = a2;
            return a2;
        }
        b a3 = b.a(this.c, (i & (-16776961)) | (this.Z << 8), e0Var, str, this.w);
        this.w = a3;
        return a3;
    }

    @Override // sdk.pendo.io.a.u
    public void a(String str, String str2, q qVar, Object... objArr) {
        this.Z = this.k.b;
        b0 b = this.c.b(str, str2, qVar, objArr);
        this.k.b(186, b.f814a);
        this.k.d(0);
        s sVar = this.Q;
        if (sVar != null) {
            int i = this.N;
            if (i == 4 || i == 3) {
                sVar.j.a(186, 0, b, this.c);
                return;
            }
            int a2 = b.a();
            int i2 = this.R + ((a2 & 3) - (a2 >> 2)) + 1;
            if (i2 > this.S) {
                this.S = i2;
            }
            this.R = i2;
        }
    }

    @Override // sdk.pendo.io.a.u
    public void a(int i, s sVar) {
        boolean z;
        d dVar = this.k;
        int i2 = dVar.b;
        this.Z = i2;
        int i3 = i >= 200 ? i - 33 : i;
        if ((sVar.f830a & 4) == 0 || sVar.d - i2 >= -32768) {
            if (i3 != i) {
                dVar.b(i);
                d dVar2 = this.k;
                sVar.a(dVar2, dVar2.b - 1, true);
            } else {
                dVar.b(i3);
                d dVar3 = this.k;
                sVar.a(dVar3, dVar3.b - 1, false);
            }
            z = false;
        } else {
            if (i3 == 167) {
                dVar.b(200);
            } else if (i3 == 168) {
                dVar.b(201);
            } else {
                dVar.b(i3 >= 198 ? i3 ^ 1 : ((i3 + 1) ^ 1) - 1);
                this.k.d(8);
                this.k.b(220);
                this.Y = true;
                z = true;
                d dVar4 = this.k;
                sVar.a(dVar4, dVar4.b - 1, true);
            }
            z = false;
            d dVar42 = this.k;
            sVar.a(dVar42, dVar42.b - 1, true);
        }
        s sVar2 = this.Q;
        if (sVar2 != null) {
            int i4 = this.N;
            s sVar3 = null;
            if (i4 == 4) {
                sVar2.j.a(i3, 0, (b0) null, (c0) null);
                s a2 = sVar.a();
                a2.f830a = (short) (a2.f830a | 2);
                c(0, sVar);
                if (i3 != 167) {
                    sVar3 = new s();
                }
            } else if (i4 == 3) {
                sVar2.j.a(i3, 0, (b0) null, (c0) null);
            } else if (i4 == 2) {
                this.R += c0[i3];
            } else if (i3 == 168) {
                short s = sVar.f830a;
                if ((s & 32) == 0) {
                    sVar.f830a = (short) (s | 32);
                    this.X = true;
                }
                sVar2.f830a = (short) (sVar2.f830a | 16);
                c(this.R + 1, sVar);
                sVar3 = new s();
            } else {
                int i5 = this.R + c0[i3];
                this.R = i5;
                c(i5, sVar);
            }
            if (sVar3 != null) {
                if (z) {
                    sVar3.f830a = (short) (sVar3.f830a | 2);
                }
                a(sVar3);
            }
            if (i3 == 167) {
                g();
            }
        }
    }

    @Override // sdk.pendo.io.a.u
    public void a(s sVar) {
        boolean z = this.Y;
        d dVar = this.k;
        this.Y = z | sVar.a(dVar.f818a, dVar.b);
        short s = sVar.f830a;
        if ((s & 1) != 0) {
            return;
        }
        int i = this.N;
        if (i == 4) {
            s sVar2 = this.Q;
            if (sVar2 != null) {
                if (sVar.d == sVar2.d) {
                    sVar2.f830a = (short) ((s & 2) | sVar2.f830a);
                    sVar.j = sVar2.j;
                    return;
                }
                c(0, sVar);
            }
            s sVar3 = this.P;
            if (sVar3 != null) {
                if (sVar.d == sVar3.d) {
                    sVar3.f830a = (short) (sVar3.f830a | (sVar.f830a & 2));
                    sVar.j = sVar3.j;
                    this.Q = sVar3;
                    return;
                }
                sVar3.k = sVar;
            }
            this.P = sVar;
            this.Q = sVar;
            sVar.j = new p(sVar);
            return;
        }
        if (i == 3) {
            s sVar4 = this.Q;
            if (sVar4 != null) {
                sVar4.j.f827a = sVar;
                return;
            }
        } else {
            if (i == 1) {
                s sVar5 = this.Q;
                if (sVar5 != null) {
                    sVar5.h = (short) this.S;
                    c(this.R, sVar);
                }
                this.Q = sVar;
                this.R = 0;
                this.S = 0;
                s sVar6 = this.P;
                if (sVar6 != null) {
                    sVar6.k = sVar;
                }
                this.P = sVar;
                return;
            }
            if (i != 2 || this.Q != null) {
                return;
            }
        }
        this.Q = sVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    @Override // sdk.pendo.io.a.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.Object r8) {
        /*
            r7 = this;
            sdk.pendo.io.a.d r0 = r7.k
            int r0 = r0.b
            r7.Z = r0
            sdk.pendo.io.a.c0 r0 = r7.c
            sdk.pendo.io.a.b0 r8 = r0.a(r8)
            int r0 = r8.f814a
            int r1 = r8.b
            r2 = 5
            r3 = 1
            r4 = 0
            if (r1 == r2) goto L2d
            r2 = 6
            if (r1 == r2) goto L2d
            r2 = 17
            if (r1 != r2) goto L2b
            java.lang.String r1 = r8.e
            char r1 = r1.charAt(r4)
            r2 = 74
            if (r1 == r2) goto L2d
            r2 = 68
            if (r1 != r2) goto L2b
            goto L2d
        L2b:
            r1 = r4
            goto L2e
        L2d:
            r1 = r3
        L2e:
            r2 = 18
            if (r1 == 0) goto L3a
            sdk.pendo.io.a.d r5 = r7.k
            r6 = 20
        L36:
            r5.b(r6, r0)
            goto L48
        L3a:
            r5 = 256(0x100, float:3.59E-43)
            if (r0 < r5) goto L43
            sdk.pendo.io.a.d r5 = r7.k
            r6 = 19
            goto L36
        L43:
            sdk.pendo.io.a.d r5 = r7.k
            r5.a(r2, r0)
        L48:
            sdk.pendo.io.a.s r0 = r7.Q
            if (r0 == 0) goto L6b
            int r5 = r7.N
            r6 = 4
            if (r5 == r6) goto L64
            r6 = 3
            if (r5 != r6) goto L55
            goto L64
        L55:
            int r8 = r7.R
            if (r1 == 0) goto L5a
            r3 = 2
        L5a:
            int r8 = r8 + r3
            int r0 = r7.S
            if (r8 <= r0) goto L61
            r7.S = r8
        L61:
            r7.R = r8
            goto L6b
        L64:
            sdk.pendo.io.a.p r0 = r0.j
            sdk.pendo.io.a.c0 r1 = r7.c
            r0.a(r2, r4, r8, r1)
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.a.v.a(java.lang.Object):void");
    }

    @Override // sdk.pendo.io.a.u
    public void a(String str, String str2, String str3, s sVar, s sVar2, int i) {
        if (str3 != null) {
            if (this.s == null) {
                this.s = new d();
            }
            this.r++;
            this.s.d(sVar.d).d(sVar2.d - sVar.d).d(this.c.f(str)).d(this.c.f(str3)).d(i);
        }
        if (this.q == null) {
            this.q = new d();
        }
        this.p++;
        this.q.d(sVar.d).d(sVar2.d - sVar.d).d(this.c.f(str)).d(this.c.f(str2)).d(i);
        if (this.N != 0) {
            char charAt = str2.charAt(0);
            int i2 = i + ((charAt == 'J' || charAt == 'D') ? 2 : 1);
            if (i2 > this.j) {
                this.j = i2;
            }
        }
    }

    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(Unknown Source)
        	at java.base/java.util.ArrayList$Itr.next(Unknown Source)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(ConstructorVisitor.java:139)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:91)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:56)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    @Override // sdk.pendo.io.a.u
    public sdk.pendo.io.a.a a(
    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(Unknown Source)
        	at java.base/java.util.ArrayList$Itr.next(Unknown Source)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(ConstructorVisitor.java:139)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:91)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:56)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r6v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:238)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:223)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:168)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
        	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:297)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:286)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:270)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:161)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:103)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:79)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:117)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:402)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:390)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:310)
        */

    @Override // sdk.pendo.io.a.u
    public void a(s sVar, int[] iArr, s[] sVarArr) {
        d dVar = this.k;
        this.Z = dVar.b;
        dVar.b(171).a((byte[]) null, 0, (4 - (this.k.b % 4)) % 4);
        sVar.a(this.k, this.Z, true);
        this.k.c(sVarArr.length);
        for (int i = 0; i < sVarArr.length; i++) {
            this.k.c(iArr[i]);
            sVarArr[i].a(this.k, this.Z, true);
        }
        a(sVar, sVarArr);
    }

    @Override // sdk.pendo.io.a.u
    public void a(int i, String str, String str2, String str3, boolean z) {
        this.Z = this.k.b;
        b0 a2 = this.c.a(str, str2, str3, z);
        if (i == 185) {
            this.k.b(185, a2.f814a).a(a2.a() >> 2, 0);
        } else {
            this.k.b(i, a2.f814a);
        }
        s sVar = this.Q;
        if (sVar != null) {
            int i2 = this.N;
            if (i2 == 4 || i2 == 3) {
                sVar.j.a(i, 0, a2, this.c);
                return;
            }
            int a3 = a2.a();
            int i3 = (a3 & 3) - (a3 >> 2);
            int i4 = i == 184 ? this.R + i3 + 1 : this.R + i3;
            if (i4 > this.S) {
                this.S = i4;
            }
            this.R = i4;
        }
    }

    @Override // sdk.pendo.io.a.u
    public void a(String str, int i) {
        this.Z = this.k.b;
        b0 a2 = this.c.a(str);
        this.k.b(197, a2.f814a).b(i);
        s sVar = this.Q;
        if (sVar != null) {
            int i2 = this.N;
            if (i2 == 4 || i2 == 3) {
                sVar.j.a(197, i, a2, this.c);
            } else {
                this.R += 1 - i;
            }
        }
    }

    @Override // sdk.pendo.io.a.u
    public a a(int i, String str, boolean z) {
        if (z) {
            if (this.E == null) {
                this.E = new b[d0.a(this.h).length];
            }
            b[] bVarArr = this.E;
            b a2 = b.a(this.c, str, bVarArr[i]);
            bVarArr[i] = a2;
            return a2;
        }
        if (this.G == null) {
            this.G = new b[d0.a(this.h).length];
        }
        b[] bVarArr2 = this.G;
        b a3 = b.a(this.c, str, bVarArr2[i]);
        bVarArr2[i] = a3;
        return a3;
    }

    private void a(s sVar, s[] sVarArr) {
        s sVar2 = this.Q;
        if (sVar2 != null) {
            int i = this.N;
            if (i == 4) {
                sVar2.j.a(171, 0, (b0) null, (c0) null);
                c(0, sVar);
                s a2 = sVar.a();
                a2.f830a = (short) (a2.f830a | 2);
                for (s sVar3 : sVarArr) {
                    c(0, sVar3);
                    s a3 = sVar3.a();
                    a3.f830a = (short) (a3.f830a | 2);
                }
            } else if (i == 1) {
                int i2 = this.R - 1;
                this.R = i2;
                c(i2, sVar);
                for (s sVar4 : sVarArr) {
                    c(this.R, sVar4);
                }
            }
            g();
        }
    }

    @Override // sdk.pendo.io.a.u
    public void a(int i, int i2, s sVar, s... sVarArr) {
        d dVar = this.k;
        this.Z = dVar.b;
        dVar.b(Context.VERSION_1_7).a((byte[]) null, 0, (4 - (this.k.b % 4)) % 4);
        sVar.a(this.k, this.Z, true);
        this.k.c(i).c(i2);
        for (s sVar2 : sVarArr) {
            sVar2.a(this.k, this.Z, true);
        }
        a(sVar, sVarArr);
    }

    @Override // sdk.pendo.io.a.u
    public void a(s sVar, s sVar2, s sVar3, String str) {
        r rVar = new r(sVar, sVar2, sVar3, str != null ? this.c.a(str).f814a : 0, str);
        if (this.l == null) {
            this.l = rVar;
        } else {
            this.m.f = rVar;
        }
        this.m = rVar;
    }

    @Override // sdk.pendo.io.a.u
    public void a(int i, String str) {
        this.Z = this.k.b;
        b0 a2 = this.c.a(str);
        this.k.b(i, a2.f814a);
        s sVar = this.Q;
        if (sVar != null) {
            int i2 = this.N;
            if (i2 == 4 || i2 == 3) {
                sVar.j.a(i, this.Z, a2, this.c);
            } else if (i == 187) {
                int i3 = this.R + 1;
                if (i3 > this.S) {
                    this.S = i3;
                }
                this.R = i3;
            }
        }
    }
}
