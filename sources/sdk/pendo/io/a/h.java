package sdk.pendo.io.a;

import org.apache.commons.io.IOUtils;
import sdk.pendo.io.a.c;

/* loaded from: classes6.dex */
public class h extends g {
    private int A;
    private d B;
    private int C;
    private d D;
    private a0 E;
    private a0 F;
    private c G;
    private int H;
    private int c;
    private final c0 d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int[] i;
    private o j;
    private o k;
    private v l;
    private v m;
    private int n;
    private d o;
    private int p;
    private int q;
    private int r;
    private int s;
    private d t;
    private b u;
    private b v;
    private b w;
    private b x;
    private x y;
    private int z;

    public h(int i) {
        this(null, i);
    }

    private byte[] a(byte[] bArr, boolean z) {
        c[] b = b();
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = 0;
        this.A = 0;
        this.B = null;
        this.C = 0;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = z ? 3 : 0;
        new e(bArr, 0, false).a(this, b, (z ? 8 : 0) | 256);
        return d();
    }

    private c[] b() {
        c.a aVar = new c.a();
        aVar.b(this.G);
        for (o oVar = this.j; oVar != null; oVar = (o) oVar.b) {
            oVar.a(aVar);
        }
        for (v vVar = this.l; vVar != null; vVar = (v) vVar.b) {
            vVar.a(aVar);
        }
        for (a0 a0Var = this.E; a0Var != null; a0Var = (a0) a0Var.b) {
            a0Var.a(aVar);
        }
        return aVar.a();
    }

    @Override // sdk.pendo.io.a.g
    public final void a() {
    }

    protected ClassLoader c() {
        return getClass().getClassLoader();
    }

    public byte[] d() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = (this.h * 2) + 24;
        int i7 = 0;
        for (o oVar = this.j; oVar != null; oVar = (o) oVar.b) {
            i7++;
            i6 += oVar.b();
        }
        int i8 = 0;
        for (v vVar = this.l; vVar != null; vVar = (v) vVar.b) {
            i8++;
            i6 += vVar.f();
        }
        d dVar = this.o;
        if (dVar != null) {
            i6 += dVar.b + 8;
            this.d.f("InnerClasses");
            i = 1;
        } else {
            i = 0;
        }
        if (this.p != 0) {
            i++;
            i6 += 10;
            this.d.f("EnclosingMethod");
        }
        if ((this.e & 4096) != 0 && (this.c & 65535) < 49) {
            i++;
            i6 += 6;
            this.d.f("Synthetic");
        }
        if (this.r != 0) {
            i++;
            i6 += 8;
            this.d.f("Signature");
        }
        if (this.s != 0) {
            i++;
            i6 += 8;
            this.d.f("SourceFile");
        }
        d dVar2 = this.t;
        if (dVar2 != null) {
            i++;
            i6 += dVar2.b + 6;
            this.d.f("SourceDebugExtension");
        }
        if ((this.e & 131072) != 0) {
            i++;
            i6 += 6;
            this.d.f("Deprecated");
        }
        b bVar = this.u;
        if (bVar != null) {
            i++;
            i6 += bVar.b("RuntimeVisibleAnnotations");
        }
        b bVar2 = this.v;
        if (bVar2 != null) {
            i++;
            i6 += bVar2.b("RuntimeInvisibleAnnotations");
        }
        b bVar3 = this.w;
        if (bVar3 != null) {
            i++;
            i6 += bVar3.b("RuntimeVisibleTypeAnnotations");
        }
        b bVar4 = this.x;
        if (bVar4 != null) {
            i++;
            i6 += bVar4.b("RuntimeInvisibleTypeAnnotations");
        }
        if (this.d.a() > 0) {
            i++;
            i6 += this.d.a();
        }
        x xVar = this.y;
        if (xVar != null) {
            i += xVar.c();
            i6 += this.y.b();
        }
        if (this.z != 0) {
            i++;
            i6 += 8;
            this.d.f("NestHost");
        }
        d dVar3 = this.B;
        if (dVar3 != null) {
            i++;
            i6 += dVar3.b + 8;
            this.d.f("NestMembers");
        }
        d dVar4 = this.D;
        if (dVar4 != null) {
            i++;
            i6 += dVar4.b + 8;
            this.d.f("PermittedSubclasses");
        }
        if ((this.e & 65536) == 0 && this.E == null) {
            i2 = 0;
            i3 = 0;
        } else {
            i2 = 0;
            i3 = 0;
            for (a0 a0Var = this.E; a0Var != null; a0Var = (a0) a0Var.b) {
                i3++;
                i2 += a0Var.b();
            }
            i++;
            i6 += i2 + 8;
            this.d.f("Record");
        }
        c cVar = this.G;
        if (cVar != null) {
            int a2 = i + cVar.a();
            i6 += this.G.a(this.d);
            i = a2;
        }
        int d = i6 + this.d.d();
        int c = this.d.c();
        if (c > 65535) {
            throw new f(this.d.b(), c);
        }
        d dVar5 = new d(d);
        dVar5.c(-889275714).c(this.c);
        this.d.b(dVar5);
        dVar5.d((~((this.c & 65535) < 49 ? 4096 : 0)) & this.e).d(this.f).d(this.g);
        dVar5.d(this.h);
        for (int i9 = 0; i9 < this.h; i9++) {
            dVar5.d(this.i[i9]);
        }
        dVar5.d(i7);
        for (o oVar2 = this.j; oVar2 != null; oVar2 = (o) oVar2.b) {
            oVar2.a(dVar5);
        }
        dVar5.d(i8);
        boolean z = false;
        boolean z2 = false;
        for (v vVar2 = this.l; vVar2 != null; vVar2 = (v) vVar2.b) {
            z2 |= vVar2.i();
            z |= vVar2.h();
            vVar2.a(dVar5);
        }
        dVar5.d(i);
        if (this.o != null) {
            d d2 = dVar5.d(this.d.f("InnerClasses")).c(this.o.b + 2).d(this.n);
            d dVar6 = this.o;
            d2.a(dVar6.f818a, 0, dVar6.b);
        }
        if (this.p != 0) {
            dVar5.d(this.d.f("EnclosingMethod")).c(4).d(this.p).d(this.q);
        }
        if ((this.e & 4096) != 0 && (this.c & 65535) < 49) {
            dVar5.d(this.d.f("Synthetic")).c(0);
        }
        if (this.r != 0) {
            i4 = 2;
            dVar5.d(this.d.f("Signature")).c(2).d(this.r);
        } else {
            i4 = 2;
        }
        if (this.s != 0) {
            dVar5.d(this.d.f("SourceFile")).c(i4).d(this.s);
        }
        d dVar7 = this.t;
        if (dVar7 != null) {
            int i10 = dVar7.b;
            i5 = 0;
            dVar5.d(this.d.f("SourceDebugExtension")).c(i10).a(this.t.f818a, 0, i10);
        } else {
            i5 = 0;
        }
        if ((this.e & 131072) != 0) {
            dVar5.d(this.d.f("Deprecated")).c(i5);
        }
        b.a(this.d, this.u, this.v, this.w, this.x, dVar5);
        this.d.a(dVar5);
        x xVar2 = this.y;
        if (xVar2 != null) {
            xVar2.a(dVar5);
        }
        if (this.z != 0) {
            dVar5.d(this.d.f("NestHost")).c(2).d(this.z);
        }
        if (this.B != null) {
            d d3 = dVar5.d(this.d.f("NestMembers")).c(this.B.b + 2).d(this.A);
            d dVar8 = this.B;
            d3.a(dVar8.f818a, 0, dVar8.b);
        }
        if (this.D != null) {
            d d4 = dVar5.d(this.d.f("PermittedSubclasses")).c(this.D.b + 2).d(this.C);
            d dVar9 = this.D;
            d4.a(dVar9.f818a, 0, dVar9.b);
        }
        if ((this.e & 65536) != 0 || this.E != null) {
            dVar5.d(this.d.f("Record")).c(i2 + 2).d(i3);
            for (a0 a0Var2 = this.E; a0Var2 != null; a0Var2 = (a0) a0Var2.b) {
                a0Var2.a(dVar5);
            }
        }
        c cVar2 = this.G;
        if (cVar2 != null) {
            cVar2.a(this.d, dVar5);
        }
        byte[] bArr = dVar5.f818a;
        return z ? a(bArr, z2) : bArr;
    }

    public h(e eVar, int i) {
        super(589824);
        int i2;
        this.d = eVar == null ? new c0(this) : new c0(this, eVar);
        if ((i & 2) != 0) {
            i2 = 4;
        } else {
            i2 = 1;
            if ((i & 1) == 0) {
                i2 = 0;
            }
        }
        this.H = i2;
    }

    @Override // sdk.pendo.io.a.g
    public final void a(int i, int i2, String str, String str2, String str3, String[] strArr) {
        this.c = i;
        this.e = i2;
        int i3 = i & 65535;
        this.f = this.d.d(i3, str);
        if (str2 != null) {
            this.r = this.d.f(str2);
        }
        this.g = str3 == null ? 0 : this.d.a(str3).f814a;
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            this.h = length;
            this.i = new int[length];
            for (int i4 = 0; i4 < this.h; i4++) {
                this.i[i4] = this.d.a(strArr[i4]).f814a;
            }
        }
        if (this.H != 1 || i3 < 51) {
            return;
        }
        this.H = 2;
    }

    protected String b(String str, String str2) {
        ClassLoader c = c();
        try {
            Class<?> cls = Class.forName(str.replace(IOUtils.DIR_SEPARATOR_UNIX, '.'), false, c);
            try {
                Class<?> cls2 = Class.forName(str2.replace(IOUtils.DIR_SEPARATOR_UNIX, '.'), false, c);
                if (cls.isAssignableFrom(cls2)) {
                    return str;
                }
                if (cls2.isAssignableFrom(cls)) {
                    return str2;
                }
                if (cls.isInterface() || cls2.isInterface()) {
                    return "java/lang/Object";
                }
                do {
                    cls = cls.getSuperclass();
                } while (!cls.isAssignableFrom(cls2));
                return cls.getName().replace('.', IOUtils.DIR_SEPARATOR_UNIX);
            } catch (ClassNotFoundException e) {
                throw new TypeNotPresentException(str2, e);
            }
        } catch (ClassNotFoundException e2) {
            throw new TypeNotPresentException(str, e2);
        }
    }

    @Override // sdk.pendo.io.a.g
    public final void c(String str) {
        if (this.D == null) {
            this.D = new d();
        }
        this.C++;
        this.D.d(this.d.a(str).f814a);
    }

    @Override // sdk.pendo.io.a.g
    public final a a(String str, boolean z) {
        if (z) {
            b a2 = b.a(this.d, str, this.u);
            this.u = a2;
            return a2;
        }
        b a3 = b.a(this.d, str, this.v);
        this.v = a3;
        return a3;
    }

    @Override // sdk.pendo.io.a.g
    public final void b(String str) {
        if (this.B == null) {
            this.B = new d();
        }
        this.A++;
        this.B.d(this.d.a(str).f814a);
    }

    @Override // sdk.pendo.io.a.g
    public final void a(c cVar) {
        cVar.c = this.G;
        this.G = cVar;
    }

    @Override // sdk.pendo.io.a.g
    public final z b(String str, String str2, String str3) {
        a0 a0Var = new a0(this.d, str, str2, str3);
        if (this.E == null) {
            this.E = a0Var;
        } else {
            this.F.b = a0Var;
        }
        this.F = a0Var;
        return a0Var;
    }

    @Override // sdk.pendo.io.a.g
    public final n a(int i, String str, String str2, String str3, Object obj) {
        o oVar = new o(this.d, i, str, str2, str3, obj);
        if (this.j == null) {
            this.j = oVar;
        } else {
            this.k.b = oVar;
        }
        this.k = oVar;
        return oVar;
    }

    @Override // sdk.pendo.io.a.g
    public final void a(String str, String str2, String str3, int i) {
        if (this.o == null) {
            this.o = new d();
        }
        b0 a2 = this.d.a(str);
        if (a2.g == 0) {
            this.n++;
            this.o.d(a2.f814a);
            this.o.d(str2 == null ? 0 : this.d.a(str2).f814a);
            this.o.d(str3 != null ? this.d.f(str3) : 0);
            this.o.d(i);
            a2.g = this.n;
        }
    }

    @Override // sdk.pendo.io.a.g
    public final u a(int i, String str, String str2, String str3, String[] strArr) {
        v vVar = new v(this.d, i, str, str2, str3, strArr, this.H);
        if (this.l == null) {
            this.l = vVar;
        } else {
            this.m.b = vVar;
        }
        this.m = vVar;
        return vVar;
    }

    @Override // sdk.pendo.io.a.g
    public final w a(String str, int i, String str2) {
        c0 c0Var = this.d;
        x xVar = new x(c0Var, c0Var.c(str).f814a, i, str2 == null ? 0 : this.d.f(str2));
        this.y = xVar;
        return xVar;
    }

    @Override // sdk.pendo.io.a.g
    public final void a(String str) {
        this.z = this.d.a(str).f814a;
    }

    @Override // sdk.pendo.io.a.g
    public final void a(String str, String str2, String str3) {
        this.p = this.d.a(str).f814a;
        if (str2 == null || str3 == null) {
            return;
        }
        this.q = this.d.a(str2, str3);
    }

    @Override // sdk.pendo.io.a.g
    public final void a(String str, String str2) {
        if (str != null) {
            this.s = this.d.f(str);
        }
        if (str2 != null) {
            this.t = new d().a(str2, 0, Integer.MAX_VALUE);
        }
    }

    @Override // sdk.pendo.io.a.g
    public final a a(int i, e0 e0Var, String str, boolean z) {
        if (z) {
            b a2 = b.a(this.d, i, e0Var, str, this.w);
            this.w = a2;
            return a2;
        }
        b a3 = b.a(this.d, i, e0Var, str, this.x);
        this.x = a3;
        return a3;
    }
}
