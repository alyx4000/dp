package sdk.pendo.io.e7;

import sdk.pendo.io.y6.r;

/* loaded from: classes6.dex */
public final class d<T> {

    /* renamed from: a, reason: collision with root package name */
    private final r<T> f1032a;
    private final Throwable b;

    private d(r<T> rVar, Throwable th) {
        this.f1032a = rVar;
        this.b = th;
    }

    public static <T> d<T> a(Throwable th) {
        if (th != null) {
            return new d<>(null, th);
        }
        throw new NullPointerException("error == null");
    }

    public static <T> d<T> a(r<T> rVar) {
        if (rVar != null) {
            return new d<>(rVar, null);
        }
        throw new NullPointerException("response == null");
    }
}
