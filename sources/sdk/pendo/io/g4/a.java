package sdk.pendo.io.g4;

import java.security.Permission;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes6.dex */
public class a extends Permission {
    private final Set<String> f;

    public a(String str) {
        super(str);
        HashSet hashSet = new HashSet();
        this.f = hashSet;
        hashSet.add(str);
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && this.f.equals(((a) obj).f);
    }

    @Override // java.security.Permission
    public String getActions() {
        return this.f.toString();
    }

    public int hashCode() {
        return this.f.hashCode();
    }

    @Override // java.security.Permission
    public boolean implies(Permission permission) {
        if (!(permission instanceof a)) {
            return false;
        }
        a aVar = (a) permission;
        return getName().equals(aVar.getName()) || this.f.containsAll(aVar.f);
    }
}
