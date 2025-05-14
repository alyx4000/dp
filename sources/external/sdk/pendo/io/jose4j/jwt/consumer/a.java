package external.sdk.pendo.io.jose4j.jwt.consumer;

import external.sdk.pendo.io.jose4j.jwt.consumer.b;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public class a implements b {
    private static final b.a c = new b.a(7, "No Audience (aud) claim present.");

    /* renamed from: a, reason: collision with root package name */
    private Set<String> f752a;
    private boolean b;

    public a(Set<String> set, boolean z) {
        this.f752a = set;
        this.b = z;
    }

    @Override // external.sdk.pendo.io.jose4j.jwt.consumer.b
    public b.a a(g gVar) {
        sdk.pendo.io.f1.b c2 = gVar.c();
        if (!c2.i()) {
            if (this.b) {
                return c;
            }
            return null;
        }
        List<String> a2 = c2.a();
        Iterator<String> it = a2.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (this.f752a.contains(it.next())) {
                z = true;
            }
        }
        if (z) {
            return null;
        }
        StringBuilder sb = new StringBuilder("Audience (aud) claim ");
        sb.append(a2);
        sb.append(this.f752a.isEmpty() ? " present in the JWT but no expected audience value(s) were provided to the JWT Consumer." : " doesn't contain an acceptable identifier.");
        sb.append(" Expected ");
        if (this.f752a.size() == 1) {
            sb.append(this.f752a.iterator().next());
        } else {
            sb.append("one of ").append(this.f752a);
        }
        sb.append(" as an aud value.");
        return new b.a(8, sb.toString());
    }
}
