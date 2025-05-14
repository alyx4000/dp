package sdk.pendo.io.c9;

import java.util.concurrent.TimeUnit;
import sdk.pendo.io.d6.h;
import sdk.pendo.io.x5.j;

/* loaded from: classes6.dex */
public class a implements h<j<? extends Throwable>, j<?>> {
    private int A = 0;
    private final int f;
    private final int s;

    /* renamed from: sdk.pendo.io.c9.a$a, reason: collision with other inner class name */
    class C0098a implements h<Throwable, j<?>> {
        C0098a() {
        }

        @Override // sdk.pendo.io.d6.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public j<?> apply(Throwable th) {
            a aVar = a.this;
            int i = aVar.A + 1;
            aVar.A = i;
            return i < aVar.f ? j.h(aVar.s, TimeUnit.MILLISECONDS) : j.a(th);
        }
    }

    public a(int i, int i2) {
        this.f = i;
        this.s = i2;
    }

    @Override // sdk.pendo.io.d6.h
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public j<?> apply(j<? extends Throwable> jVar) {
        return jVar.b(new C0098a());
    }
}
