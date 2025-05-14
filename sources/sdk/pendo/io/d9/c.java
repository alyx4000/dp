package sdk.pendo.io.d9;

import java.security.cert.CertPathValidatorException;
import java.util.NoSuchElementException;
import sdk.pendo.io.d6.e;
import sdk.pendo.io.g9.d;
import sdk.pendo.io.logging.PendoLogger;

/* loaded from: classes6.dex */
public final class c<T> extends sdk.pendo.io.s6.a<T> {
    private e<Throwable> A;
    private sdk.pendo.io.d6.a f0;
    private e<? super T> s;
    private String t0;

    public static final class a<T> {

        /* renamed from: a, reason: collision with root package name */
        private e<Throwable> f998a = null;
        private sdk.pendo.io.d6.a b = null;
        private e<? super T> c = null;
        private String d = null;

        a<T> a(String str) {
            this.d = str;
            return this;
        }

        a<T> b(e<? super T> eVar) {
            this.c = eVar;
            return this;
        }

        a<T> a(sdk.pendo.io.d6.a aVar) {
            this.b = aVar;
            return this;
        }

        a<T> a(e<Throwable> eVar) {
            this.f998a = eVar;
            return this;
        }

        c<T> a() {
            return new c<>(this.c, this.f998a, this.b, this.d);
        }
    }

    private c(e<? super T> eVar, e<Throwable> eVar2, sdk.pendo.io.d6.a aVar, String str) {
        this.s = eVar;
        this.A = eVar2;
        this.f0 = aVar;
        this.t0 = str;
    }

    public static <T> c<T> a(e<T> eVar, String str) {
        if (eVar != null) {
            return a(eVar, new sdk.pendo.io.a9.a(str), null, str);
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    @Override // sdk.pendo.io.x5.o
    public void onComplete() {
        sdk.pendo.io.d6.a aVar = this.f0;
        if (aVar != null) {
            try {
                aVar.run();
            } catch (Exception e) {
                PendoLogger.e(e, e.getMessage(), this.t0);
            }
        }
    }

    @Override // sdk.pendo.io.x5.o
    public void onError(Throwable th) {
        if (a(th) && !(this.A instanceof sdk.pendo.io.a9.a)) {
            d.a(th, this.t0);
        }
        e<Throwable> eVar = this.A;
        if (eVar != null) {
            try {
                eVar.accept(th);
            } catch (Exception e) {
                PendoLogger.e(e, e.getMessage(), this.t0);
            }
        }
    }

    @Override // sdk.pendo.io.x5.o
    public void onNext(T t) {
        try {
            this.s.accept(t);
        } catch (Exception e) {
            PendoLogger.e(e, e.getMessage(), this.t0);
        }
    }

    private static <T> c<T> a(e<T> eVar, e<Throwable> eVar2, sdk.pendo.io.d6.a aVar, String str) {
        return new a().b(eVar).a(eVar2).a(aVar).a(str).a();
    }

    public static boolean a(Throwable th) {
        return ((th instanceof NoSuchElementException) || (th instanceof CertPathValidatorException)) ? false : true;
    }
}
