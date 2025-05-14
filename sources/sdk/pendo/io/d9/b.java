package sdk.pendo.io.d9;

import java.security.cert.CertPathValidatorException;
import java.util.NoSuchElementException;
import sdk.pendo.io.d6.e;
import sdk.pendo.io.g9.d;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.x5.h;

/* loaded from: classes6.dex */
public final class b<T> implements h<T> {
    private sdk.pendo.io.d6.a A;
    private e<? super T> f;
    private e<? super sdk.pendo.io.b6.b> f0;
    private e<Throwable> s;
    private sdk.pendo.io.b6.b t0;
    private String u0;

    public static final class a<T> {
        private e<? super sdk.pendo.io.b6.b> d;

        /* renamed from: a, reason: collision with root package name */
        private e<Throwable> f997a = null;
        private sdk.pendo.io.d6.a b = null;
        private e<? super T> c = null;
        private String e = null;

        a<T> a(String str) {
            this.e = str;
            return this;
        }

        a<T> b(e<? super sdk.pendo.io.b6.b> eVar) {
            this.d = eVar;
            return this;
        }

        a<T> c(e<? super T> eVar) {
            this.c = eVar;
            return this;
        }

        a<T> a(sdk.pendo.io.d6.a aVar) {
            this.b = aVar;
            return this;
        }

        a<T> a(e<Throwable> eVar) {
            this.f997a = eVar;
            return this;
        }

        b<T> a() {
            return new b<>(this.c, this.f997a, this.b, this.d, this.e);
        }
    }

    private b(e<? super T> eVar, e<Throwable> eVar2, sdk.pendo.io.d6.a aVar, e<? super sdk.pendo.io.b6.b> eVar3, String str) {
        this.f = eVar;
        this.s = eVar2;
        this.A = aVar;
        this.f0 = eVar3;
        this.u0 = str;
    }

    public static <T> b<T> a(e<T> eVar, String str) {
        if (eVar != null) {
            return a(eVar, new sdk.pendo.io.a9.a(str), null, null, str);
        }
        throw new IllegalArgumentException("onSuccess can not be null");
    }

    @Override // sdk.pendo.io.x5.h
    public void onComplete() {
        sdk.pendo.io.d6.a aVar = this.A;
        if (aVar != null) {
            try {
                aVar.run();
            } catch (Exception e) {
                PendoLogger.e(e, e.getMessage(), this.u0);
            }
        }
    }

    @Override // sdk.pendo.io.x5.h
    public void onError(Throwable th) {
        if (a(th) && !(this.s instanceof sdk.pendo.io.a9.a)) {
            d.a(th, this.u0);
        }
        e<Throwable> eVar = this.s;
        if (eVar != null) {
            try {
                eVar.accept(th);
            } catch (Exception e) {
                PendoLogger.e(e, e.getMessage(), this.u0);
            }
        }
    }

    @Override // sdk.pendo.io.x5.h
    public void onSubscribe(sdk.pendo.io.b6.b bVar) {
        this.t0 = bVar;
        e<? super sdk.pendo.io.b6.b> eVar = this.f0;
        if (eVar != null) {
            try {
                eVar.accept(bVar);
            } catch (Exception e) {
                PendoLogger.e(e, e.getMessage(), this.u0);
            }
        }
    }

    @Override // sdk.pendo.io.x5.h
    public void onSuccess(T t) {
        try {
            this.f.accept(t);
        } catch (Exception e) {
            PendoLogger.e(e, e.getMessage(), this.u0);
        }
    }

    private static <T> b<T> a(e<T> eVar, e<Throwable> eVar2, sdk.pendo.io.d6.a aVar, e<? super sdk.pendo.io.b6.b> eVar3, String str) {
        return new a().c(eVar).a(eVar2).a(aVar).b(eVar3).a(str).a();
    }

    private boolean a(Throwable th) {
        return ((th instanceof NoSuchElementException) || (th instanceof CertPathValidatorException)) ? false : true;
    }
}
