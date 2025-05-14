package sdk.pendo.io.z7;

import sdk.pendo.io.x7.h;
import sdk.pendo.io.x7.i;

/* loaded from: classes4.dex */
public class b extends Exception {
    private i A;
    private h f;
    private sdk.pendo.io.x7.c s;

    public b(h hVar, sdk.pendo.io.x7.c cVar, Exception exc, String str, i iVar) {
        super(str, exc);
        this.f = hVar;
        this.s = cVar;
        this.A = iVar;
    }

    public <C extends i> C a() {
        return (C) this.A;
    }

    public sdk.pendo.io.x7.c b() {
        return this.s;
    }

    public h c() {
        return this.f;
    }
}
