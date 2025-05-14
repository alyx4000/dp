package sdk.pendo.io.x7;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
class g {

    /* renamed from: a, reason: collision with root package name */
    private Map<b, sdk.pendo.io.y7.d> f1755a = new HashMap();

    public enum a {
        EVENT_TRIGGER,
        ANY_EVENT_TRIGGER,
        STATE_ENTER,
        ANY_STATE_ENTER,
        STATE_LEAVE,
        ANY_STATE_LEAVE,
        FINAL_STATE,
        ERROR
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        a f1756a;
        c b;
        h c;

        private b(a aVar, c cVar, h hVar) {
            this.f1756a = aVar;
            this.b = cVar;
            this.c = hVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            c cVar = this.b;
            if (cVar == null ? bVar.b != null : !cVar.equals(bVar.b)) {
                return false;
            }
            if (this.f1756a != bVar.f1756a) {
                return false;
            }
            h hVar = this.c;
            h hVar2 = bVar.c;
            return hVar == null ? hVar2 == null : hVar.equals(hVar2);
        }

        public int hashCode() {
            int hashCode = this.f1756a.hashCode() * 31;
            c cVar = this.b;
            int hashCode2 = (hashCode + (cVar != null ? cVar.hashCode() : 0)) * 31;
            h hVar = this.c;
            return hashCode2 + (hVar != null ? hVar.hashCode() : 0);
        }
    }

    g() {
    }

    public void a(sdk.pendo.io.z7.b bVar) {
        sdk.pendo.io.y7.d dVar = this.f1755a.get(new b(a.ERROR, null, 0 == true ? 1 : 0));
        if (dVar != null) {
            ((sdk.pendo.io.y7.c) dVar).a(bVar, bVar.a());
        }
    }

    public <C extends i> void b(h hVar, C c) {
        byte b2 = 0;
        byte b3 = 0;
        byte b4 = 0;
        sdk.pendo.io.y7.d dVar = this.f1755a.get(new b(a.STATE_ENTER, null, hVar));
        if (dVar != null) {
            ((sdk.pendo.io.y7.a) dVar).a(c);
        }
        sdk.pendo.io.y7.d dVar2 = this.f1755a.get(new b(a.ANY_STATE_ENTER, b4 == true ? 1 : 0, b3 == true ? 1 : 0));
        if (dVar2 != null) {
            ((sdk.pendo.io.y7.e) dVar2).a(hVar, c);
        }
    }

    public <C extends i> void c(h hVar, C c) {
        byte b2 = 0;
        byte b3 = 0;
        byte b4 = 0;
        sdk.pendo.io.y7.d dVar = this.f1755a.get(new b(a.STATE_LEAVE, null, hVar));
        if (dVar != null) {
            ((sdk.pendo.io.y7.a) dVar).a(c);
        }
        sdk.pendo.io.y7.d dVar2 = this.f1755a.get(new b(a.ANY_STATE_LEAVE, b4 == true ? 1 : 0, b3 == true ? 1 : 0));
        if (dVar2 != null) {
            ((sdk.pendo.io.y7.e) dVar2).a(hVar, c);
        }
    }

    public <C extends i> void a(c cVar, h hVar, h hVar2, C c) {
        byte b2 = 0;
        byte b3 = 0;
        byte b4 = 0;
        sdk.pendo.io.y7.d dVar = this.f1755a.get(new b(a.EVENT_TRIGGER, cVar, null));
        if (dVar != null) {
            ((sdk.pendo.io.y7.a) dVar).a(c);
        }
        sdk.pendo.io.y7.d dVar2 = this.f1755a.get(new b(a.ANY_EVENT_TRIGGER, b4 == true ? 1 : 0, b3 == true ? 1 : 0));
        if (dVar2 != null) {
            ((sdk.pendo.io.y7.b) dVar2).a(cVar, hVar, hVar2, c);
        }
    }

    public <C extends i> void a(h hVar, C c) {
        sdk.pendo.io.y7.d dVar = this.f1755a.get(new b(a.FINAL_STATE, null, 0 == true ? 1 : 0));
        if (dVar != null) {
            ((sdk.pendo.io.y7.e) dVar).a(hVar, c);
        }
    }

    public void a(a aVar, h hVar, c cVar, sdk.pendo.io.y7.d dVar) {
        this.f1755a.put(new b(aVar, cVar, hVar), dVar);
    }
}
