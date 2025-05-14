package sdk.pendo.io.k6;

import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.x5.h;
import sdk.pendo.io.x5.i;
import sdk.pendo.io.x5.p;

/* loaded from: classes6.dex */
public final class e<T> extends sdk.pendo.io.k6.a<T, T> {
    final p s;

    static final class a<T> extends AtomicReference<sdk.pendo.io.b6.b> implements h<T>, sdk.pendo.io.b6.b, Runnable {
        T A;
        final h<? super T> f;
        Throwable f0;
        final p s;

        a(h<? super T> hVar, p pVar) {
            this.f = hVar;
            this.s = pVar;
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return sdk.pendo.io.e6.b.a(get());
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            sdk.pendo.io.e6.b.a((AtomicReference<sdk.pendo.io.b6.b>) this);
        }

        @Override // sdk.pendo.io.x5.h
        public void onComplete() {
            sdk.pendo.io.e6.b.a((AtomicReference<sdk.pendo.io.b6.b>) this, this.s.a(this));
        }

        @Override // sdk.pendo.io.x5.h
        public void onError(Throwable th) {
            this.f0 = th;
            sdk.pendo.io.e6.b.a((AtomicReference<sdk.pendo.io.b6.b>) this, this.s.a(this));
        }

        @Override // sdk.pendo.io.x5.h
        public void onSubscribe(sdk.pendo.io.b6.b bVar) {
            if (sdk.pendo.io.e6.b.c(this, bVar)) {
                this.f.onSubscribe(this);
            }
        }

        @Override // sdk.pendo.io.x5.h
        public void onSuccess(T t) {
            this.A = t;
            sdk.pendo.io.e6.b.a((AtomicReference<sdk.pendo.io.b6.b>) this, this.s.a(this));
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.f0;
            if (th != null) {
                this.f0 = null;
                this.f.onError(th);
                return;
            }
            T t = this.A;
            if (t == null) {
                this.f.onComplete();
            } else {
                this.A = null;
                this.f.onSuccess(t);
            }
        }
    }

    public e(i<T> iVar, p pVar) {
        super(iVar);
        this.s = pVar;
    }

    @Override // sdk.pendo.io.x5.g
    protected void b(h<? super T> hVar) {
        this.f.a(new a(hVar, this.s));
    }
}
