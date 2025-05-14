package external.sdk.pendo.io.glide.load.engine.cache;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import sdk.pendo.io.i0.j;

/* loaded from: classes2.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, a> f663a = new HashMap();
    private final C0060b b = new C0060b();

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        final Lock f664a = new ReentrantLock();
        int b;

        a() {
        }
    }

    /* renamed from: external.sdk.pendo.io.glide.load.engine.cache.b$b, reason: collision with other inner class name */
    private static class C0060b {

        /* renamed from: a, reason: collision with root package name */
        private final Queue<a> f665a = new ArrayDeque();

        C0060b() {
        }

        a a() {
            a poll;
            synchronized (this.f665a) {
                poll = this.f665a.poll();
            }
            return poll == null ? new a() : poll;
        }

        void a(a aVar) {
            synchronized (this.f665a) {
                if (this.f665a.size() < 10) {
                    this.f665a.offer(aVar);
                }
            }
        }
    }

    b() {
    }

    void a(String str) {
        a aVar;
        synchronized (this) {
            aVar = this.f663a.get(str);
            if (aVar == null) {
                aVar = this.b.a();
                this.f663a.put(str, aVar);
            }
            aVar.b++;
        }
        aVar.f664a.lock();
    }

    void b(String str) {
        a aVar;
        synchronized (this) {
            aVar = (a) j.a(this.f663a.get(str));
            int i = aVar.b;
            if (i < 1) {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.b);
            }
            int i2 = i - 1;
            aVar.b = i2;
            if (i2 == 0) {
                a remove = this.f663a.remove(str);
                if (!remove.equals(aVar)) {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + remove + ", safeKey: " + str);
                }
                this.b.a(remove);
            }
        }
        aVar.f664a.unlock();
    }
}
