package sdk.pendo.io.t4;

import java.security.Key;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes6.dex */
abstract class a implements sdk.pendo.io.s4.a {

    /* renamed from: a, reason: collision with root package name */
    protected final b f1550a;

    a(b bVar) {
        this.f1550a = bVar;
    }

    protected static Set<String> a(String[] strArr) {
        HashSet hashSet = new HashSet();
        if (strArr != null) {
            for (String str : strArr) {
                if (str != null) {
                    hashSet.add(str);
                }
            }
        }
        return hashSet;
    }

    protected static Set<String> b(String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            Set<String> a2 = a(strArr);
            if (!a2.isEmpty()) {
                return Collections.unmodifiableSet(a2);
            }
        }
        return Collections.emptySet();
    }

    protected void a(String str) {
        if (!a0.a(str)) {
            throw new IllegalArgumentException("No algorithm name specified");
        }
    }

    protected boolean b(Set<String> set, String str) {
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            if (it.next().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    protected void a(Key key) {
        if (key == null) {
            throw new NullPointerException("'key' cannot be null");
        }
    }

    protected boolean b(Set<sdk.pendo.io.s4.b> set) {
        return (set == null || set.isEmpty()) ? false : true;
    }

    protected void a(Set<sdk.pendo.io.s4.b> set) {
        if (!b(set)) {
            throw new IllegalArgumentException("No cryptographic primitive specified");
        }
    }

    protected boolean a(Set<String> set, String str) {
        if (set.isEmpty()) {
            return false;
        }
        if (b(set, str)) {
            return true;
        }
        b bVar = this.f1550a;
        if (bVar != null) {
            Iterator<String> it = bVar.a(str).iterator();
            while (it.hasNext()) {
                if (b(set, it.next())) {
                    return true;
                }
            }
        }
        return false;
    }
}
