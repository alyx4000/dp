package sdk.pendo.io.g9;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes6.dex */
public final class v {

    class a implements sdk.pendo.io.d6.b<Long, Long, Long> {
        a() {
        }

        @Override // sdk.pendo.io.d6.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long apply(Long l, Long l2) {
            return Long.valueOf(l.longValue() + 1);
        }
    }

    class b implements sdk.pendo.io.d6.j<Long> {
        final /* synthetic */ AtomicBoolean f;

        b(AtomicBoolean atomicBoolean) {
            this.f = atomicBoolean;
        }

        @Override // sdk.pendo.io.d6.j
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean test(Long l) {
            return !this.f.get();
        }
    }

    public static sdk.pendo.io.x5.j<Long> a(AtomicBoolean atomicBoolean, long j, TimeUnit timeUnit) {
        return sdk.pendo.io.x5.j.d(j, timeUnit).a(new b(atomicBoolean)).a(new a());
    }
}
