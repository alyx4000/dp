package sdk.pendo.io.y4;

import kotlin.jvm.internal.ByteCompanionObject;

/* loaded from: classes4.dex */
abstract class b implements r1 {
    private static long k = sdk.pendo.io.d5.j.a();

    /* renamed from: a, reason: collision with root package name */
    private sdk.pendo.io.z4.h f1766a;
    private int b;
    private sdk.pendo.io.z4.w c;
    private a1 d = null;
    private a1 e = null;
    private v0[] f = null;
    private v0 g = null;
    private v0 h = null;
    private j3 i = null;
    private Object j = null;

    b(sdk.pendo.io.z4.h hVar, int i) {
        this.f1766a = hVar;
        this.b = i;
        this.c = a(hVar, i);
    }

    private static sdk.pendo.io.z4.w a(sdk.pendo.io.z4.h hVar, int i) {
        byte[] bArr = new byte[16];
        sdk.pendo.io.d5.f.a(m(), bArr, 0);
        sdk.pendo.io.d5.f.a(sdk.pendo.io.d5.j.a(), bArr, 8);
        byte b = (byte) (bArr[0] & ByteCompanionObject.MAX_VALUE);
        bArr[0] = b;
        bArr[0] = (byte) (((byte) (i << 7)) | b);
        return hVar.c(bArr);
    }

    private static synchronized long m() {
        long j;
        synchronized (b.class) {
            j = k + 1;
            k = j;
        }
        return j;
    }

    @Override // sdk.pendo.io.y4.r1
    public sdk.pendo.io.z4.h b() {
        return this.f1766a;
    }

    @Override // sdk.pendo.io.y4.r1
    public v0[] c() {
        return this.f;
    }

    @Override // sdk.pendo.io.y4.r1
    public synchronized a1 d() {
        return this.d;
    }

    @Override // sdk.pendo.io.y4.r1
    public synchronized a1 e() {
        return this.e;
    }

    @Override // sdk.pendo.io.y4.r1
    public j3 f() {
        return this.i;
    }

    @Override // sdk.pendo.io.y4.r1
    public v0 g() {
        return this.h;
    }

    @Override // sdk.pendo.io.y4.r1
    public synchronized a1 h() {
        a1 a1Var;
        a1Var = this.d;
        if (a1Var == null) {
            a1Var = this.e;
        }
        return a1Var;
    }

    @Override // sdk.pendo.io.y4.r1
    public v0 j() {
        return this.g;
    }

    @Override // sdk.pendo.io.y4.r1
    public sdk.pendo.io.z4.w k() {
        return this.c;
    }

    synchronized boolean l() {
        return this.d != null;
    }

    @Override // sdk.pendo.io.y4.r1
    public v0 a() {
        return h().s();
    }

    void b(v0 v0Var) {
        this.h = v0Var;
    }

    void a(v2 v2Var) {
        synchronized (this) {
            if (this.d != null) {
                throw new h2((short) 80, "Handshake already started");
            }
            a1 a1Var = new a1();
            this.d = a1Var;
            a1Var.f1765a = this.b;
            a1 a1Var2 = this.e;
            if (a1Var2 != null) {
                a1Var.b = true;
                a1Var.c = a1Var2.P();
                this.d.T = this.e.s();
            }
        }
        v2Var.u();
    }

    void a(v2 v2Var, j3 j3Var) {
        synchronized (this) {
            a1 a1Var = this.d;
            if (a1Var == null) {
                throw new h2((short) 80);
            }
            this.i = j3Var;
            this.e = a1Var;
            this.d = null;
        }
        v2Var.G();
    }

    void a(v0[] v0VarArr) {
        this.f = v0VarArr;
    }

    void a(v0 v0Var) {
        this.g = v0Var;
    }
}
