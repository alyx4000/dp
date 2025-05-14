package sdk.pendo.io.k6;

import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.x5.h;
import sdk.pendo.io.x5.i;
import sdk.pendo.io.x5.p;

/* loaded from: classes6.dex */
public final class f<T> extends sdk.pendo.io.k6.a<T, T> {
    final p s;

    static final class a<T> extends AtomicReference<sdk.pendo.io.b6.b> implements h<T>, sdk.pendo.io.b6.b {
        final sdk.pendo.io.e6.f f = new sdk.pendo.io.e6.f();
        final h<? super T> s;

        a(h<? super T> hVar) {
            this.s = hVar;
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return sdk.pendo.io.e6.b.a(get());
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            sdk.pendo.io.e6.b.a((AtomicReference<sdk.pendo.io.b6.b>) this);
            this.f.dispose();
        }

        @Override // sdk.pendo.io.x5.h
        public void onComplete() {
            this.s.onComplete();
        }

        @Override // sdk.pendo.io.x5.h
        public void onError(Throwable th) {
            this.s.onError(th);
        }

        @Override // sdk.pendo.io.x5.h
        public void onSubscribe(sdk.pendo.io.b6.b bVar) {
            sdk.pendo.io.e6.b.c(this, bVar);
        }

        @Override // sdk.pendo.io.x5.h
        public void onSuccess(T t) {
            this.s.onSuccess(t);
        }
    }

    static final class b<T> implements Runnable {
        final h<? super T> f;
        final i<T> s;

        b(h<? super T> hVar, i<T> iVar) {
            this.f = hVar;
            this.s = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.s.a(this.f);
        }
    }

    public f(i<T> iVar, p pVar) {
        super(iVar);
        this.s = pVar;
    }

    @Override // sdk.pendo.io.x5.g
    protected void b(h<? super T> hVar) {
        a aVar = new a(hVar);
        hVar.onSubscribe(aVar);
        aVar.f.a(this.s.a(new b(aVar, this.f)));
    }
}
