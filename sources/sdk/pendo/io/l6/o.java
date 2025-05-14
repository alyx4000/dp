package sdk.pendo.io.l6;

/* loaded from: classes6.dex */
public final class o<T> extends sdk.pendo.io.x5.j<T> {
    final T[] f;

    static final class a<T> extends sdk.pendo.io.h6.c<T> {
        int A;
        final sdk.pendo.io.x5.o<? super T> f;
        boolean f0;
        final T[] s;
        volatile boolean t0;

        a(sdk.pendo.io.x5.o<? super T> oVar, T[] tArr) {
            this.f = oVar;
            this.s = tArr;
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return this.t0;
        }

        void b() {
            T[] tArr = this.s;
            int length = tArr.length;
            for (int i = 0; i < length && !a(); i++) {
                T t = tArr[i];
                if (t == null) {
                    this.f.onError(new NullPointerException("The element at index " + i + " is null"));
                    return;
                }
                this.f.onNext(t);
            }
            if (a()) {
                return;
            }
            this.f.onComplete();
        }

        @Override // sdk.pendo.io.g6.g
        public void clear() {
            this.A = this.s.length;
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            this.t0 = true;
        }

        @Override // sdk.pendo.io.g6.g
        public boolean isEmpty() {
            return this.A == this.s.length;
        }

        @Override // sdk.pendo.io.g6.g
        public T poll() {
            int i = this.A;
            T[] tArr = this.s;
            if (i == tArr.length) {
                return null;
            }
            this.A = i + 1;
            return (T) sdk.pendo.io.f6.b.a((Object) tArr[i], "The array element is null");
        }

        @Override // sdk.pendo.io.g6.c
        public int a(int i) {
            if ((i & 1) == 0) {
                return 0;
            }
            this.f0 = true;
            return 1;
        }
    }

    public o(T[] tArr) {
        this.f = tArr;
    }

    @Override // sdk.pendo.io.x5.j
    public void b(sdk.pendo.io.x5.o<? super T> oVar) {
        a aVar = new a(oVar, this.f);
        oVar.onSubscribe(aVar);
        if (aVar.f0) {
            return;
        }
        aVar.b();
    }
}
