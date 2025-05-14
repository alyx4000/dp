package sdk.pendo.io.l7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.l7.c;
import sdk.pendo.io.l7.d;
import sdk.pendo.io.m7.a;

/* loaded from: classes6.dex */
public class e extends sdk.pendo.io.m7.a {
    private static final Logger l = Logger.getLogger(e.class.getName());
    protected static final Map<String, Integer> m = new a();
    String b;
    private volatile boolean c;
    private int d;
    private String e;
    private sdk.pendo.io.l7.c f;
    private String g;
    private Queue<d.b> i;
    private Map<Integer, sdk.pendo.io.l7.a> h = new HashMap();
    private final Queue<List<Object>> j = new LinkedList();
    private final Queue<sdk.pendo.io.t7.c<JSONArray>> k = new LinkedList();

    class a extends HashMap<String, Integer> {
        a() {
            put("connect", 1);
            put("connect_error", 1);
            put("connect_timeout", 1);
            put("connecting", 1);
            put("disconnect", 1);
            put("error", 1);
            put("reconnect", 1);
            put("reconnect_attempt", 1);
            put("reconnect_failed", 1);
            put("reconnect_error", 1);
            put("reconnecting", 1);
            put("ping", 1);
            put("pong", 1);
        }
    }

    class b extends LinkedList<d.b> {
        final /* synthetic */ sdk.pendo.io.l7.c f;

        class a implements a.InterfaceC0197a {
            a() {
            }

            @Override // sdk.pendo.io.m7.a.InterfaceC0197a
            public void call(Object... objArr) {
                e.this.i();
            }
        }

        /* renamed from: sdk.pendo.io.l7.e$b$b, reason: collision with other inner class name */
        class C0188b implements a.InterfaceC0197a {
            C0188b() {
            }

            @Override // sdk.pendo.io.m7.a.InterfaceC0197a
            public void call(Object... objArr) {
                e.this.c((sdk.pendo.io.t7.c) objArr[0]);
            }
        }

        class c implements a.InterfaceC0197a {
            c() {
            }

            @Override // sdk.pendo.io.m7.a.InterfaceC0197a
            public void call(Object... objArr) {
                e.this.b(objArr.length > 0 ? (String) objArr[0] : null);
            }
        }

        b(sdk.pendo.io.l7.c cVar) {
            this.f = cVar;
            add(sdk.pendo.io.l7.d.a(cVar, AbstractCircuitBreaker.PROPERTY_NAME, new a()));
            add(sdk.pendo.io.l7.d.a(cVar, "packet", new C0188b()));
            add(sdk.pendo.io.l7.d.a(cVar, "close", new c()));
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.c) {
                return;
            }
            e.this.k();
            e.this.f.i();
            c.p pVar = c.p.OPEN;
            e eVar = e.this;
            if (pVar == eVar.f.b) {
                eVar.i();
            }
            e.this.a("connecting", new Object[0]);
        }
    }

    class d implements Runnable {
        final /* synthetic */ String f;
        final /* synthetic */ Object[] s;

        d(String str, Object[] objArr) {
            this.f = str;
            this.s = objArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            sdk.pendo.io.l7.a aVar;
            if (e.m.containsKey(this.f)) {
                e.super.a(this.f, this.s);
                return;
            }
            Object[] objArr = this.s;
            int length = objArr.length - 1;
            if (objArr.length <= 0 || !(objArr[length] instanceof sdk.pendo.io.l7.a)) {
                aVar = null;
            } else {
                objArr = new Object[length];
                for (int i = 0; i < length; i++) {
                    objArr[i] = this.s[i];
                }
                aVar = (sdk.pendo.io.l7.a) this.s[length];
            }
            e.this.a(this.f, objArr, aVar);
        }
    }

    /* renamed from: sdk.pendo.io.l7.e$e, reason: collision with other inner class name */
    class RunnableC0189e implements Runnable {
        final /* synthetic */ sdk.pendo.io.l7.a A;
        final /* synthetic */ String f;
        final /* synthetic */ Object[] s;

        RunnableC0189e(String str, Object[] objArr, sdk.pendo.io.l7.a aVar) {
            this.f = str;
            this.s = objArr;
            this.A = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.f);
            Object[] objArr = this.s;
            if (objArr != null) {
                for (Object obj : objArr) {
                    jSONArray.put(obj);
                }
            }
            sdk.pendo.io.t7.c cVar = new sdk.pendo.io.t7.c(2, jSONArray);
            if (this.A != null) {
                e.l.fine(String.format(Locale.US, "emitting packet with ack id %d", Integer.valueOf(e.this.d)));
                e eVar = e.this;
                eVar.h.put(Integer.valueOf(eVar.d), this.A);
                e eVar2 = e.this;
                int i = eVar2.d;
                eVar2.d = i + 1;
                cVar.b = i;
            }
            if (e.this.c) {
                e.this.d(cVar);
            } else {
                e.this.k.add(cVar);
            }
        }
    }

    class f implements sdk.pendo.io.l7.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean[] f1339a;
        final /* synthetic */ int b;
        final /* synthetic */ e c;

        class a implements Runnable {
            final /* synthetic */ Object[] f;

            a(Object[] objArr) {
                this.f = objArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean[] zArr = f.this.f1339a;
                if (zArr[0]) {
                    return;
                }
                zArr[0] = true;
                Logger logger = e.l;
                if (logger.isLoggable(Level.FINE)) {
                    Object[] objArr = this.f;
                    if (objArr.length == 0) {
                        objArr = null;
                    }
                    logger.fine(String.format("sending ack %s", objArr));
                }
                JSONArray jSONArray = new JSONArray();
                for (Object obj : this.f) {
                    jSONArray.put(obj);
                }
                sdk.pendo.io.t7.c cVar = new sdk.pendo.io.t7.c(3, jSONArray);
                f fVar = f.this;
                cVar.b = fVar.b;
                fVar.c.d(cVar);
            }
        }

        f(boolean[] zArr, int i, e eVar) {
            this.f1339a = zArr;
            this.b = i;
            this.c = eVar;
        }

        @Override // sdk.pendo.io.l7.a
        public void call(Object... objArr) {
            sdk.pendo.io.u7.a.a(new a(objArr));
        }
    }

    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.c) {
                Logger logger = e.l;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(String.format("performing disconnect (%s)", e.this.e));
                }
                e.this.d(new sdk.pendo.io.t7.c(1));
            }
            e.this.d();
            if (e.this.c) {
                e.this.b("io client disconnect");
            }
        }
    }

    public e(sdk.pendo.io.l7.c cVar, String str, c.o oVar) {
        this.f = cVar;
        this.e = str;
        if (oVar != null) {
            this.g = oVar.p;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Queue<d.b> queue = this.i;
        if (queue != null) {
            Iterator<d.b> it = queue.iterator();
            while (it.hasNext()) {
                it.next().destroy();
            }
            this.i = null;
        }
        this.f.a(this);
    }

    private void f() {
        while (true) {
            List<Object> poll = this.j.poll();
            if (poll == null) {
                break;
            } else {
                super.a((String) poll.get(0), poll.toArray());
            }
        }
        this.j.clear();
        while (true) {
            sdk.pendo.io.t7.c<JSONArray> poll2 = this.k.poll();
            if (poll2 == null) {
                this.k.clear();
                return;
            }
            d(poll2);
        }
    }

    private void g() {
        this.c = true;
        a("connect", new Object[0]);
        f();
    }

    private void h() {
        Logger logger = l;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format("server disconnect (%s)", this.e));
        }
        d();
        b("io server disconnect");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        sdk.pendo.io.t7.c cVar;
        l.fine("transport is open - connecting");
        if ("/".equals(this.e)) {
            return;
        }
        String str = this.g;
        if (str == null || str.isEmpty()) {
            cVar = new sdk.pendo.io.t7.c(0);
        } else {
            cVar = new sdk.pendo.io.t7.c(0);
            cVar.f = this.g;
        }
        d(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.i != null) {
            return;
        }
        this.i = new b(this.f);
    }

    public e b() {
        sdk.pendo.io.u7.a.a(new g());
        return this;
    }

    public e c() {
        return j();
    }

    public e e() {
        return b();
    }

    public e j() {
        sdk.pendo.io.u7.a.a(new c());
        return this;
    }

    private sdk.pendo.io.l7.a a(int i) {
        return new f(new boolean[]{false}, i, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        Logger logger = l;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format("close (%s)", str));
        }
        this.c = false;
        this.b = null;
        a("disconnect", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(sdk.pendo.io.t7.c<?> cVar) {
        if (this.e.equals(cVar.c)) {
            switch (cVar.f1635a) {
                case 0:
                    g();
                    break;
                case 1:
                    h();
                    break;
                case 2:
                case 5:
                    b((sdk.pendo.io.t7.c<JSONArray>) cVar);
                    break;
                case 3:
                case 6:
                    a((sdk.pendo.io.t7.c<JSONArray>) cVar);
                    break;
                case 4:
                    a("error", cVar.d);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(sdk.pendo.io.t7.c cVar) {
        cVar.c = this.e;
        this.f.b(cVar);
    }

    private void b(sdk.pendo.io.t7.c<JSONArray> cVar) {
        ArrayList arrayList = new ArrayList(Arrays.asList(a(cVar.d)));
        Logger logger = l;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format("emitting event %s", arrayList));
        }
        if (cVar.b >= 0) {
            logger.fine("attaching ack callback to event");
            arrayList.add(a(cVar.b));
        }
        if (!this.c) {
            this.j.add(arrayList);
        } else {
            if (arrayList.isEmpty()) {
                return;
            }
            super.a(arrayList.remove(0).toString(), arrayList.toArray());
        }
    }

    @Override // sdk.pendo.io.m7.a
    public sdk.pendo.io.m7.a a(String str, Object... objArr) {
        sdk.pendo.io.u7.a.a(new d(str, objArr));
        return this;
    }

    public sdk.pendo.io.m7.a a(String str, Object[] objArr, sdk.pendo.io.l7.a aVar) {
        sdk.pendo.io.u7.a.a(new RunnableC0189e(str, objArr, aVar));
        return this;
    }

    private void a(sdk.pendo.io.t7.c<JSONArray> cVar) {
        sdk.pendo.io.l7.a remove = this.h.remove(Integer.valueOf(cVar.b));
        if (remove != null) {
            Logger logger = l;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(String.format("calling ack %s with %s", Integer.valueOf(cVar.b), cVar.d));
            }
            remove.call(a(cVar.d));
            return;
        }
        Logger logger2 = l;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(String.format("bad ack %s", Integer.valueOf(cVar.b)));
        }
    }

    private static Object[] a(JSONArray jSONArray) {
        Object obj;
        int length = jSONArray.length();
        Object[] objArr = new Object[length];
        for (int i = 0; i < length; i++) {
            Object obj2 = null;
            try {
                obj = jSONArray.get(i);
            } catch (JSONException e) {
                l.log(Level.WARNING, "An error occured while retrieving data from JSONArray", (Throwable) e);
                obj = null;
            }
            if (!JSONObject.NULL.equals(obj)) {
                obj2 = obj;
            }
            objArr[i] = obj2;
        }
        return objArr;
    }
}
