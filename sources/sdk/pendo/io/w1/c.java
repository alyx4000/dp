package sdk.pendo.io.w1;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import sdk.pendo.io.n1.g;

/* loaded from: classes4.dex */
public class c implements a {

    /* renamed from: a, reason: collision with root package name */
    private final ReentrantLock f1700a = new ReentrantLock();
    private final Map<String, g> b = new ConcurrentHashMap();
    private final Deque<String> c = new LinkedList();
    private final int d;

    public c(int i) {
        this.d = i;
    }

    private void b(String str) {
        this.f1700a.lock();
        try {
            this.c.addFirst(str);
        } finally {
            this.f1700a.unlock();
        }
    }

    private void c(String str) {
        this.f1700a.lock();
        try {
            this.c.removeFirstOccurrence(str);
            this.c.addFirst(str);
        } finally {
            this.f1700a.unlock();
        }
    }

    @Override // sdk.pendo.io.w1.a
    public g a(String str) {
        g gVar = this.b.get(str);
        if (gVar != null) {
            c(str);
        }
        return gVar;
    }

    public String toString() {
        return this.b.toString();
    }

    @Override // sdk.pendo.io.w1.a
    public void a(String str, g gVar) {
        if (this.b.put(str, gVar) != null) {
            c(str);
        } else {
            b(str);
        }
        if (this.b.size() > this.d) {
            this.b.remove(a());
        }
    }

    private String a() {
        this.f1700a.lock();
        try {
            return this.c.removeLast();
        } finally {
            this.f1700a.unlock();
        }
    }
}
