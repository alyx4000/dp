package sdk.pendo.io.j7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import sdk.pendo.io.h7.ILoggerFactory;

/* loaded from: classes6.dex */
public class f implements ILoggerFactory {

    /* renamed from: a, reason: collision with root package name */
    boolean f1233a = false;
    final Map<String, e> b = new HashMap();
    final LinkedBlockingQueue<sdk.pendo.io.i7.d> c = new LinkedBlockingQueue<>();

    public void a() {
        this.b.clear();
        this.c.clear();
    }

    public LinkedBlockingQueue<sdk.pendo.io.i7.d> b() {
        return this.c;
    }

    public List<e> c() {
        return new ArrayList(this.b.values());
    }

    public void d() {
        this.f1233a = true;
    }

    @Override // sdk.pendo.io.h7.ILoggerFactory
    public synchronized sdk.pendo.io.h7.a a(String str) {
        e eVar;
        eVar = this.b.get(str);
        if (eVar == null) {
            eVar = new e(str, this.c, this.f1233a);
            this.b.put(str, eVar);
        }
        return eVar;
    }
}
