package sdk.pendo.io.l6;

import _COROUTINE.ArtificialStackFrames;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes6.dex */
public final class e0 {

    public static final class a<T> extends AtomicInteger implements sdk.pendo.io.g6.b<T>, Runnable {
        final sdk.pendo.io.x5.o<? super T> f;
        final T s;

        public a(sdk.pendo.io.x5.o<? super T> oVar, T t) {
            this.f = oVar;
            this.s = t;
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return get() == 3;
        }

        @Override // sdk.pendo.io.g6.g
        public void clear() {
            lazySet(3);
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            set(3);
        }

        @Override // sdk.pendo.io.g6.g
        public boolean isEmpty() {
            return get() != 1;
        }

        @Override // sdk.pendo.io.g6.g
        public boolean offer(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // sdk.pendo.io.g6.g
        public T poll() {
            if (get() != 1) {
                return null;
            }
            lazySet(3);
            return this.s;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.f.onNext(this.s);
                if (get() == 2) {
                    lazySet(3);
                    this.f.onComplete();
                }
            }
        }

        @Override // sdk.pendo.io.g6.c
        public int a(int i) {
            if ((i & 1) == 0) {
                return 0;
            }
            lazySet(1);
            return 1;
        }
    }

    static final class b<T, R> extends sdk.pendo.io.x5.j<R> {
        final T f;
        final sdk.pendo.io.d6.h<? super T, ? extends sdk.pendo.io.x5.m<? extends R>> s;

        b(T t, sdk.pendo.io.d6.h<? super T, ? extends sdk.pendo.io.x5.m<? extends R>> hVar) {
            this.f = t;
            this.s = hVar;
        }

        @Override // sdk.pendo.io.x5.j
        public void b(sdk.pendo.io.x5.o<? super R> oVar) {
            try {
                sdk.pendo.io.x5.m mVar = (sdk.pendo.io.x5.m) sdk.pendo.io.f6.b.a(this.s.apply(this.f), "The mapper returned a null ObservableSource");
                if (!(mVar instanceof Callable)) {
                    mVar.a(oVar);
                    return;
                }
                try {
                    Object call = ((Callable) mVar).call();
                    if (call == null) {
                        sdk.pendo.io.e6.c.a(oVar);
                        return;
                    }
                    a aVar = new a(oVar, call);
                    oVar.onSubscribe(aVar);
                    aVar.run();
                } catch (Throwable th) {
                    sdk.pendo.io.c6.b.b(th);
                    sdk.pendo.io.e6.c.a(th, oVar);
                }
            } catch (Throwable th2) {
                sdk.pendo.io.e6.c.a(th2, oVar);
            }
        }
    }

    public static <T, U> sdk.pendo.io.x5.j<U> a(T t, sdk.pendo.io.d6.h<? super T, ? extends sdk.pendo.io.x5.m<? extends U>> hVar) {
        return sdk.pendo.io.t6.a.a(new b(t, hVar));
    }

    public static <T, R> boolean a(sdk.pendo.io.x5.m<T> mVar, sdk.pendo.io.x5.o<? super R> oVar, sdk.pendo.io.d6.h<? super T, ? extends sdk.pendo.io.x5.m<? extends R>> hVar) {
        if (!(mVar instanceof Callable)) {
            return false;
        }
        try {
            ArtificialStackFrames artificialStackFrames = (Object) ((Callable) mVar).call();
            if (artificialStackFrames == null) {
                sdk.pendo.io.e6.c.a(oVar);
                return true;
            }
            sdk.pendo.io.x5.m mVar2 = (sdk.pendo.io.x5.m) sdk.pendo.io.f6.b.a(hVar.apply(artificialStackFrames), "The mapper returned a null ObservableSource");
            if (mVar2 instanceof Callable) {
                Object call = ((Callable) mVar2).call();
                if (call == null) {
                    sdk.pendo.io.e6.c.a(oVar);
                    return true;
                }
                a aVar = new a(oVar, call);
                oVar.onSubscribe(aVar);
                aVar.run();
            } else {
                mVar2.a(oVar);
            }
            return true;
        } catch (Throwable th) {
            sdk.pendo.io.c6.b.b(th);
            sdk.pendo.io.e6.c.a(th, oVar);
            return true;
        }
    }
}
