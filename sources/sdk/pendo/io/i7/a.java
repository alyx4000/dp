package sdk.pendo.io.i7;

import java.util.Queue;
import sdk.pendo.io.j7.e;

/* loaded from: classes6.dex */
public class a implements sdk.pendo.io.h7.a {
    Queue<d> A;
    String f;
    e s;

    public a(e eVar, Queue<d> queue) {
        this.s = eVar;
        this.f = eVar.getName();
        this.A = queue;
    }

    @Override // sdk.pendo.io.h7.a
    public void a(String str) {
        a(b.TRACE, str, null, null);
    }

    @Override // sdk.pendo.io.h7.a
    public boolean a() {
        return true;
    }

    @Override // sdk.pendo.io.h7.a
    public void b(String str, Object obj) {
        a(b.DEBUG, str, new Object[]{obj}, null);
    }

    @Override // sdk.pendo.io.h7.a
    public String getName() {
        return this.f;
    }

    @Override // sdk.pendo.io.h7.a
    public void a(String str, Object obj, Object obj2) {
        a(b.DEBUG, str, new Object[]{obj, obj2}, null);
    }

    @Override // sdk.pendo.io.h7.a
    public void b(String str, Object obj, Object obj2) {
        a(b.TRACE, str, new Object[]{obj, obj2}, null);
    }

    @Override // sdk.pendo.io.h7.a
    public void a(String str, Throwable th) {
        a(b.DEBUG, str, null, th);
    }

    @Override // sdk.pendo.io.h7.a
    public void b(String str, Object... objArr) {
        a(b.TRACE, str, objArr, null);
    }

    @Override // sdk.pendo.io.h7.a
    public void a(String str, Object... objArr) {
        a(b.DEBUG, str, objArr, null);
    }

    private void a(b bVar, String str, Object[] objArr, Throwable th) {
        a(bVar, null, str, objArr, th);
    }

    private void a(b bVar, sdk.pendo.io.h7.c cVar, String str, Object[] objArr, Throwable th) {
        d dVar = new d();
        dVar.a(System.currentTimeMillis());
        dVar.a(bVar);
        dVar.a(this.s);
        dVar.a(this.f);
        dVar.b(str);
        dVar.a(objArr);
        dVar.a(th);
        dVar.c(Thread.currentThread().getName());
        this.A.add(dVar);
    }

    @Override // sdk.pendo.io.h7.a
    public void a(String str, Object obj) {
        a(b.TRACE, str, new Object[]{obj}, null);
    }
}
