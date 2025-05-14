package sdk.pendo.io.q6;

import java.io.Serializable;
import sdk.pendo.io.x5.o;

/* loaded from: classes6.dex */
public enum i {
    COMPLETE;

    static final class a implements Serializable {
        final sdk.pendo.io.b6.b f;

        a(sdk.pendo.io.b6.b bVar) {
            this.f = bVar;
        }

        public String toString() {
            return "NotificationLite.Disposable[" + this.f + "]";
        }
    }

    static final class b implements Serializable {
        final Throwable f;

        b(Throwable th) {
            this.f = th;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return sdk.pendo.io.f6.b.a(this.f, ((b) obj).f);
            }
            return false;
        }

        public int hashCode() {
            return this.f.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.f + "]";
        }
    }

    static final class c implements Serializable {
        final sdk.pendo.io.w5.c f;

        public String toString() {
            return "NotificationLite.Subscription[" + this.f + "]";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T a(Object obj) {
        return obj;
    }

    public static <T> boolean a(Object obj, o<? super T> oVar) {
        if (obj == COMPLETE) {
            oVar.onComplete();
            return true;
        }
        if (obj instanceof b) {
            oVar.onError(((b) obj).f);
            return true;
        }
        oVar.onNext(obj);
        return false;
    }

    public static <T> boolean b(Object obj, o<? super T> oVar) {
        if (obj == COMPLETE) {
            oVar.onComplete();
            return true;
        }
        if (obj instanceof b) {
            oVar.onError(((b) obj).f);
            return true;
        }
        if (obj instanceof a) {
            oVar.onSubscribe(((a) obj).f);
            return false;
        }
        oVar.onNext(obj);
        return false;
    }

    public static boolean c(Object obj) {
        return obj instanceof b;
    }

    public static <T> Object d(T t) {
        return t;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }

    public static <T> boolean a(Object obj, sdk.pendo.io.w5.b<? super T> bVar) {
        if (obj == COMPLETE) {
            bVar.onComplete();
            return true;
        }
        if (obj instanceof b) {
            bVar.onError(((b) obj).f);
            return true;
        }
        if (obj instanceof c) {
            bVar.a(((c) obj).f);
            return false;
        }
        bVar.onNext(obj);
        return false;
    }

    public static boolean b(Object obj) {
        return obj == COMPLETE;
    }

    public static Object a() {
        return COMPLETE;
    }

    public static Object a(sdk.pendo.io.b6.b bVar) {
        return new a(bVar);
    }

    public static Object a(Throwable th) {
        return new b(th);
    }
}
