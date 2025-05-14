package sdk.pendo.io.f7;

import java.util.concurrent.CancellationException;
import sdk.pendo.io.d6.j;

/* loaded from: classes6.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    static final sdk.pendo.io.d6.h<Throwable, Boolean> f1083a = new a();
    static final j<Boolean> b = new b();
    static final sdk.pendo.io.d6.h<Object, sdk.pendo.io.x5.b> c = new C0137c();

    class a implements sdk.pendo.io.d6.h<Throwable, Boolean> {
        a() {
        }

        @Override // sdk.pendo.io.d6.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(Throwable th) {
            if (th instanceof e) {
                return Boolean.TRUE;
            }
            sdk.pendo.io.c6.b.a(th);
            return Boolean.FALSE;
        }
    }

    class b implements j<Boolean> {
        b() {
        }

        @Override // sdk.pendo.io.d6.j
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean test(Boolean bool) {
            return bool.booleanValue();
        }
    }

    /* renamed from: sdk.pendo.io.f7.c$c, reason: collision with other inner class name */
    class C0137c implements sdk.pendo.io.d6.h<Object, sdk.pendo.io.x5.b> {
        C0137c() {
        }

        @Override // sdk.pendo.io.d6.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public sdk.pendo.io.x5.b apply(Object obj) {
            return sdk.pendo.io.x5.b.a(new CancellationException());
        }
    }
}
