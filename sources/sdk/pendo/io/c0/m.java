package sdk.pendo.io.c0;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes6.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private final Set<sdk.pendo.io.e0.a> f938a = Collections.newSetFromMap(new WeakHashMap());
    private final List<sdk.pendo.io.e0.a> b = new ArrayList();
    private boolean c;

    public boolean a(sdk.pendo.io.e0.a aVar) {
        boolean z = true;
        if (aVar == null) {
            return true;
        }
        boolean remove = this.f938a.remove(aVar);
        if (!this.b.remove(aVar) && !remove) {
            z = false;
        }
        if (z) {
            aVar.clear();
        }
        return z;
    }

    public boolean b() {
        return this.c;
    }

    public void c() {
        this.c = true;
        for (sdk.pendo.io.e0.a aVar : sdk.pendo.io.i0.k.a(this.f938a)) {
            if (aVar.isRunning() || aVar.isComplete()) {
                aVar.clear();
                this.b.add(aVar);
            }
        }
    }

    public void d() {
        this.c = true;
        for (sdk.pendo.io.e0.a aVar : sdk.pendo.io.i0.k.a(this.f938a)) {
            if (aVar.isRunning()) {
                aVar.pause();
                this.b.add(aVar);
            }
        }
    }

    public void e() {
        for (sdk.pendo.io.e0.a aVar : sdk.pendo.io.i0.k.a(this.f938a)) {
            if (!aVar.isComplete() && !aVar.isCleared()) {
                aVar.clear();
                if (this.c) {
                    this.b.add(aVar);
                } else {
                    aVar.begin();
                }
            }
        }
    }

    public void f() {
        this.c = false;
        for (sdk.pendo.io.e0.a aVar : sdk.pendo.io.i0.k.a(this.f938a)) {
            if (!aVar.isComplete() && !aVar.isRunning()) {
                aVar.begin();
            }
        }
        this.b.clear();
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f938a.size() + ", isPaused=" + this.c + "}";
    }

    public void a() {
        Iterator it = sdk.pendo.io.i0.k.a(this.f938a).iterator();
        while (it.hasNext()) {
            a((sdk.pendo.io.e0.a) it.next());
        }
        this.b.clear();
    }

    public void b(sdk.pendo.io.e0.a aVar) {
        this.f938a.add(aVar);
        if (!this.c) {
            aVar.begin();
            return;
        }
        aVar.clear();
        if (Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        this.b.add(aVar);
    }
}
