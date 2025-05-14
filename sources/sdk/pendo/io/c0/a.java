package sdk.pendo.io.c0;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes6.dex */
class a implements h {

    /* renamed from: a, reason: collision with root package name */
    private final Set<i> f934a = Collections.newSetFromMap(new WeakHashMap());
    private boolean b;
    private boolean c;

    a() {
    }

    @Override // sdk.pendo.io.c0.h
    public void a(i iVar) {
        this.f934a.add(iVar);
        if (this.c) {
            iVar.onDestroy();
        } else if (this.b) {
            iVar.onStart();
        } else {
            iVar.onStop();
        }
    }

    void b() {
        this.b = true;
        Iterator it = sdk.pendo.io.i0.k.a(this.f934a).iterator();
        while (it.hasNext()) {
            ((i) it.next()).onStart();
        }
    }

    void c() {
        this.b = false;
        Iterator it = sdk.pendo.io.i0.k.a(this.f934a).iterator();
        while (it.hasNext()) {
            ((i) it.next()).onStop();
        }
    }

    void a() {
        this.c = true;
        Iterator it = sdk.pendo.io.i0.k.a(this.f934a).iterator();
        while (it.hasNext()) {
            ((i) it.next()).onDestroy();
        }
    }

    @Override // sdk.pendo.io.c0.h
    public void b(i iVar) {
        this.f934a.remove(iVar);
    }
}
