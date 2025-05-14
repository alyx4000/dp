package sdk.pendo.io.m7;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentMap<String, ConcurrentLinkedQueue<InterfaceC0197a>> f1399a = new ConcurrentHashMap();

    /* renamed from: sdk.pendo.io.m7.a$a, reason: collision with other inner class name */
    public interface InterfaceC0197a {
        void call(Object... objArr);
    }

    private class b implements InterfaceC0197a {

        /* renamed from: a, reason: collision with root package name */
        public final String f1400a;
        public final InterfaceC0197a b;

        public b(String str, InterfaceC0197a interfaceC0197a) {
            this.f1400a = str;
            this.b = interfaceC0197a;
        }

        @Override // sdk.pendo.io.m7.a.InterfaceC0197a
        public void call(Object... objArr) {
            a.this.a(this.f1400a, this);
            this.b.call(objArr);
        }
    }

    public a a(String str, Object... objArr) {
        ConcurrentLinkedQueue<InterfaceC0197a> concurrentLinkedQueue = this.f1399a.get(str);
        if (concurrentLinkedQueue != null) {
            Iterator<InterfaceC0197a> it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                it.next().call(objArr);
            }
        }
        return this;
    }

    public a b(String str, InterfaceC0197a interfaceC0197a) {
        ConcurrentLinkedQueue<InterfaceC0197a> putIfAbsent;
        ConcurrentLinkedQueue<InterfaceC0197a> concurrentLinkedQueue = this.f1399a.get(str);
        if (concurrentLinkedQueue == null && (putIfAbsent = this.f1399a.putIfAbsent(str, (concurrentLinkedQueue = new ConcurrentLinkedQueue<>()))) != null) {
            concurrentLinkedQueue = putIfAbsent;
        }
        concurrentLinkedQueue.add(interfaceC0197a);
        return this;
    }

    public a c(String str, InterfaceC0197a interfaceC0197a) {
        b(str, new b(str, interfaceC0197a));
        return this;
    }

    public a a() {
        this.f1399a.clear();
        return this;
    }

    public a a(String str) {
        this.f1399a.remove(str);
        return this;
    }

    public a a(String str, InterfaceC0197a interfaceC0197a) {
        ConcurrentLinkedQueue<InterfaceC0197a> concurrentLinkedQueue = this.f1399a.get(str);
        if (concurrentLinkedQueue != null) {
            Iterator<InterfaceC0197a> it = concurrentLinkedQueue.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (a(interfaceC0197a, it.next())) {
                    it.remove();
                    break;
                }
            }
        }
        return this;
    }

    private static boolean a(InterfaceC0197a interfaceC0197a, InterfaceC0197a interfaceC0197a2) {
        if (interfaceC0197a.equals(interfaceC0197a2)) {
            return true;
        }
        if (interfaceC0197a2 instanceof b) {
            return interfaceC0197a.equals(((b) interfaceC0197a2).b);
        }
        return false;
    }
}
