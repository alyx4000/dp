package sdk.pendo.io.a1;

import sdk.pendo.io.i1.h;

/* loaded from: classes6.dex */
public abstract class f implements a {

    /* renamed from: a, reason: collision with root package name */
    protected final sdk.pendo.io.h7.a f841a = sdk.pendo.io.h7.b.a(getClass());
    private String b;
    private String c;
    private h d;
    private String e;

    @Override // sdk.pendo.io.a1.a
    public h a() {
        return this.d;
    }

    public void b(String str) {
        this.c = str;
    }

    @Override // sdk.pendo.io.a1.a
    public String c() {
        return this.b;
    }

    public String e() {
        return this.c;
    }

    public String toString() {
        return getClass().getName() + "(" + this.b + "|" + this.c + ")";
    }

    public void a(String str) {
        this.b = str;
    }

    public void c(String str) {
        this.e = str;
    }

    public void a(h hVar) {
        this.d = hVar;
    }
}
