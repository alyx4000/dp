package sdk.pendo.io.b6;

import java.util.ArrayList;
import sdk.pendo.io.q6.g;
import sdk.pendo.io.q6.k;

/* loaded from: classes6.dex */
public final class a implements b, sdk.pendo.io.e6.a {
    k<b> f;
    volatile boolean s;

    void a(k<b> kVar) {
        if (kVar == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Object obj : kVar.a()) {
            if (obj instanceof b) {
                try {
                    ((b) obj).dispose();
                } catch (Throwable th) {
                    sdk.pendo.io.c6.b.b(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
            }
        }
        if (arrayList != null) {
            if (arrayList.size() != 1) {
                throw new sdk.pendo.io.c6.a(arrayList);
            }
            throw g.a((Throwable) arrayList.get(0));
        }
    }

    @Override // sdk.pendo.io.e6.a
    public boolean b(b bVar) {
        sdk.pendo.io.f6.b.a(bVar, "disposable is null");
        if (!this.s) {
            synchronized (this) {
                if (!this.s) {
                    k<b> kVar = this.f;
                    if (kVar == null) {
                        kVar = new k<>();
                        this.f = kVar;
                    }
                    kVar.a((k<b>) bVar);
                    return true;
                }
            }
        }
        bVar.dispose();
        return false;
    }

    @Override // sdk.pendo.io.e6.a
    public boolean c(b bVar) {
        sdk.pendo.io.f6.b.a(bVar, "disposables is null");
        if (this.s) {
            return false;
        }
        synchronized (this) {
            if (this.s) {
                return false;
            }
            k<b> kVar = this.f;
            if (kVar != null && kVar.b(bVar)) {
                return true;
            }
            return false;
        }
    }

    @Override // sdk.pendo.io.b6.b
    public void dispose() {
        if (this.s) {
            return;
        }
        synchronized (this) {
            if (this.s) {
                return;
            }
            this.s = true;
            k<b> kVar = this.f;
            this.f = null;
            a(kVar);
        }
    }

    @Override // sdk.pendo.io.b6.b
    public boolean a() {
        return this.s;
    }

    @Override // sdk.pendo.io.e6.a
    public boolean a(b bVar) {
        if (!c(bVar)) {
            return false;
        }
        bVar.dispose();
        return true;
    }
}
