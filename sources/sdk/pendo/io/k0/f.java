package sdk.pendo.io.k0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public final class f extends i implements Iterable<i> {
    private final List<i> f = new ArrayList();

    public void a(i iVar) {
        if (iVar == null) {
            iVar = k.f;
        }
        this.f.add(iVar);
    }

    @Override // sdk.pendo.io.k0.i
    public float b() {
        if (this.f.size() == 1) {
            return this.f.get(0).b();
        }
        throw new IllegalStateException();
    }

    @Override // sdk.pendo.io.k0.i
    public int c() {
        if (this.f.size() == 1) {
            return this.f.get(0).c();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof f) && ((f) obj).f.equals(this.f));
    }

    @Override // sdk.pendo.io.k0.i
    public String g() {
        if (this.f.size() == 1) {
            return this.f.get(0).g();
        }
        throw new IllegalStateException();
    }

    public int hashCode() {
        return this.f.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<i> iterator() {
        return this.f.iterator();
    }

    public int size() {
        return this.f.size();
    }

    public i a(int i) {
        return this.f.get(i);
    }

    @Override // sdk.pendo.io.k0.i
    public boolean a() {
        if (this.f.size() == 1) {
            return this.f.get(0).a();
        }
        throw new IllegalStateException();
    }
}
