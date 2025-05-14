package sdk.pendo.io.e6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import sdk.pendo.io.q6.g;

/* loaded from: classes6.dex */
public final class d implements sdk.pendo.io.b6.b, a {
    List<sdk.pendo.io.b6.b> f;
    volatile boolean s;

    void a(List<sdk.pendo.io.b6.b> list) {
        if (list == null) {
            return;
        }
        Iterator<sdk.pendo.io.b6.b> it = list.iterator();
        ArrayList arrayList = null;
        while (it.hasNext()) {
            try {
                it.next().dispose();
            } catch (Throwable th) {
                sdk.pendo.io.c6.b.b(th);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
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
    public boolean b(sdk.pendo.io.b6.b bVar) {
        sdk.pendo.io.f6.b.a(bVar, "d is null");
        if (!this.s) {
            synchronized (this) {
                if (!this.s) {
                    List list = this.f;
                    if (list == null) {
                        list = new LinkedList();
                        this.f = list;
                    }
                    list.add(bVar);
                    return true;
                }
            }
        }
        bVar.dispose();
        return false;
    }

    @Override // sdk.pendo.io.e6.a
    public boolean c(sdk.pendo.io.b6.b bVar) {
        sdk.pendo.io.f6.b.a(bVar, "Disposable item is null");
        if (this.s) {
            return false;
        }
        synchronized (this) {
            if (this.s) {
                return false;
            }
            List<sdk.pendo.io.b6.b> list = this.f;
            if (list != null && list.remove(bVar)) {
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
            List<sdk.pendo.io.b6.b> list = this.f;
            this.f = null;
            a(list);
        }
    }

    @Override // sdk.pendo.io.b6.b
    public boolean a() {
        return this.s;
    }

    @Override // sdk.pendo.io.e6.a
    public boolean a(sdk.pendo.io.b6.b bVar) {
        if (!c(bVar)) {
            return false;
        }
        bVar.dispose();
        return true;
    }
}
