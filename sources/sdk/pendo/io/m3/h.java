package sdk.pendo.io.m3;

/* loaded from: classes6.dex */
public class h {
    static final g[] d = new g[0];

    /* renamed from: a, reason: collision with root package name */
    private g[] f1388a;
    private int b;
    private boolean c;

    public h() {
        this(10);
    }

    private void b(int i) {
        g[] gVarArr = new g[Math.max(this.f1388a.length, i + (i >> 1))];
        System.arraycopy(this.f1388a, 0, gVarArr, 0, this.b);
        this.f1388a = gVarArr;
        this.c = false;
    }

    public void a(g gVar) {
        if (gVar == null) {
            throw new NullPointerException("'element' cannot be null");
        }
        int length = this.f1388a.length;
        int i = this.b + 1;
        if (this.c | (i > length)) {
            b(i);
        }
        this.f1388a[this.b] = gVar;
        this.b = i;
    }

    g[] c() {
        int i = this.b;
        if (i == 0) {
            return d;
        }
        g[] gVarArr = this.f1388a;
        if (gVarArr.length == i) {
            this.c = true;
            return gVarArr;
        }
        g[] gVarArr2 = new g[i];
        System.arraycopy(gVarArr, 0, gVarArr2, 0, i);
        return gVarArr2;
    }

    public h(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("'initialCapacity' must not be negative");
        }
        this.f1388a = i == 0 ? d : new g[i];
        this.b = 0;
        this.c = false;
    }

    static g[] a(g[] gVarArr) {
        return gVarArr.length < 1 ? d : (g[]) gVarArr.clone();
    }

    public int b() {
        return this.b;
    }

    g[] a() {
        int i = this.b;
        if (i == 0) {
            return d;
        }
        g[] gVarArr = new g[i];
        System.arraycopy(this.f1388a, 0, gVarArr, 0, i);
        return gVarArr;
    }

    public g a(int i) {
        if (i < this.b) {
            return this.f1388a[i];
        }
        throw new ArrayIndexOutOfBoundsException(i + " >= " + this.b);
    }
}
