package sdk.pendo.io.l6;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public final class d<T> extends sdk.pendo.io.x5.j<T> {
    final sdk.pendo.io.x5.l<T> f;

    static final class a<T> extends AtomicReference<sdk.pendo.io.b6.b> implements sdk.pendo.io.x5.k<T>, sdk.pendo.io.b6.b {
        final sdk.pendo.io.x5.o<? super T> f;

        a(sdk.pendo.io.x5.o<? super T> oVar) {
            this.f = oVar;
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return sdk.pendo.io.e6.b.a(get());
        }

        public boolean b(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (a()) {
                return false;
            }
            try {
                this.f.onError(th);
                dispose();
                return true;
            } catch (Throwable th2) {
                dispose();
                throw th2;
            }
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            sdk.pendo.io.e6.b.a((AtomicReference<sdk.pendo.io.b6.b>) this);
        }

        @Override // sdk.pendo.io.x5.c
        public void onNext(T t) {
            if (t == null) {
                a(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                if (a()) {
                    return;
                }
                this.f.onNext(t);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", a.class.getSimpleName(), super.toString());
        }

        public void a(Throwable th) {
            if (b(th)) {
                return;
            }
            sdk.pendo.io.t6.a.b(th);
        }

        @Override // sdk.pendo.io.x5.k
        public void a(sdk.pendo.io.b6.b bVar) {
            sdk.pendo.io.e6.b.b(this, bVar);
        }
    }

    public d(sdk.pendo.io.x5.l<T> lVar) {
        this.f = lVar;
    }

    @Override // sdk.pendo.io.x5.j
    protected void b(sdk.pendo.io.x5.o<? super T> oVar) {
        a aVar = new a(oVar);
        oVar.onSubscribe(aVar);
        try {
            this.f.a(aVar);
        } catch (Throwable th) {
            sdk.pendo.io.c6.b.b(th);
            aVar.a(th);
        }
    }
}
