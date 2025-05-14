package sdk.pendo.io.a1;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import sdk.pendo.io.a1.a;

/* loaded from: classes6.dex */
public class d<A extends a> {

    /* renamed from: a, reason: collision with root package name */
    private final sdk.pendo.io.h7.a f839a;
    private String b;
    private final Map<String, A> c = new LinkedHashMap();

    public d(String str, Class<A> cls) {
        this.b = str;
        this.f839a = sdk.pendo.io.h7.b.a(getClass().getName() + "->" + cls.getSimpleName());
    }

    public A a(String str) {
        A a2 = this.c.get(str);
        if (a2 != null) {
            return a2;
        }
        throw new sdk.pendo.io.k1.e(str + " is an unknown, unsupported or unavailable " + this.b + " algorithm (not one of " + a() + ").");
    }

    public void b(A a2) {
        String c = a2.c();
        if (!a((d<A>) a2)) {
            this.f839a.a("{} is unavailable so will not be registered for {} algorithms.", c, this.b);
        } else {
            this.c.put(c, a2);
            this.f839a.a("{} registered for {} algorithm {}", a2, this.b, c);
        }
    }

    public Set<String> a() {
        return Collections.unmodifiableSet(this.c.keySet());
    }

    private boolean a(A a2) {
        try {
            return a2.d();
        } catch (Throwable th) {
            this.f839a.a("Unexpected problem checking for availability of " + a2.c() + " algorithm: " + sdk.pendo.io.k1.b.a(th));
            return false;
        }
    }
}
