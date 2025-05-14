package sdk.pendo.io.m6;

import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.g6.f;

/* loaded from: classes6.dex */
public final class a<T> implements f<T> {
    private final AtomicReference<C0196a<T>> f = new AtomicReference<>();
    private final AtomicReference<C0196a<T>> s = new AtomicReference<>();

    /* renamed from: sdk.pendo.io.m6.a$a, reason: collision with other inner class name */
    static final class C0196a<E> extends AtomicReference<C0196a<E>> {
        private E f;

        C0196a() {
        }

        C0196a(E e) {
            a((C0196a<E>) e);
        }

        public E a() {
            E b = b();
            a((C0196a<E>) null);
            return b;
        }

        public E b() {
            return this.f;
        }

        public C0196a<E> c() {
            return get();
        }

        public void a(C0196a<E> c0196a) {
            lazySet(c0196a);
        }

        public void a(E e) {
            this.f = e;
        }
    }

    public a() {
        C0196a<T> c0196a = new C0196a<>();
        a(c0196a);
        b(c0196a);
    }

    C0196a<T> a() {
        return this.s.get();
    }

    C0196a<T> b() {
        return this.s.get();
    }

    C0196a<T> c() {
        return this.f.get();
    }

    @Override // sdk.pendo.io.g6.g
    public void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    @Override // sdk.pendo.io.g6.g
    public boolean isEmpty() {
        return b() == c();
    }

    @Override // sdk.pendo.io.g6.g
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        C0196a<T> c0196a = new C0196a<>(t);
        b(c0196a).a(c0196a);
        return true;
    }

    @Override // sdk.pendo.io.g6.f, sdk.pendo.io.g6.g
    public T poll() {
        C0196a<T> a2 = a();
        C0196a<T> c = a2.c();
        if (c == null) {
            if (a2 == c()) {
                return null;
            }
            do {
                c = a2.c();
            } while (c == null);
        }
        T a3 = c.a();
        a(c);
        return a3;
    }

    void a(C0196a<T> c0196a) {
        this.s.lazySet(c0196a);
    }

    C0196a<T> b(C0196a<T> c0196a) {
        return this.f.getAndSet(c0196a);
    }
}
