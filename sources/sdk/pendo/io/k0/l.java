package sdk.pendo.io.k0;

import java.util.Map;
import java.util.Set;

/* loaded from: classes6.dex */
public final class l extends i {
    private final sdk.pendo.io.m0.g<String, i> f = new sdk.pendo.io.m0.g<>();

    public void a(String str, i iVar) {
        sdk.pendo.io.m0.g<String, i> gVar = this.f;
        if (iVar == null) {
            iVar = k.f;
        }
        gVar.put(str, iVar);
    }

    public f b(String str) {
        return (f) this.f.get(str);
    }

    public n c(String str) {
        return (n) this.f.get(str);
    }

    public boolean d(String str) {
        return this.f.containsKey(str);
    }

    public i e(String str) {
        return this.f.remove(str);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof l) && ((l) obj).f.equals(this.f));
    }

    public int hashCode() {
        return this.f.hashCode();
    }

    public Set<Map.Entry<String, i>> l() {
        return this.f.entrySet();
    }

    public void a(String str, Boolean bool) {
        a(str, bool == null ? k.f : new n(bool));
    }

    public void a(String str, Number number) {
        a(str, number == null ? k.f : new n(number));
    }

    public void a(String str, String str2) {
        a(str, str2 == null ? k.f : new n(str2));
    }

    public i a(String str) {
        return this.f.get(str);
    }
}
