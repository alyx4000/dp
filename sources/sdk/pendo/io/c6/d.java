package sdk.pendo.io.c6;

/* loaded from: classes6.dex */
public final class d extends RuntimeException {
    public d(String str, Throwable th) {
        super(str, th == null ? new NullPointerException() : th);
    }

    public d(Throwable th) {
        this("The exception was not handled due to missing onError handler in the subscribe() method call. Further reading: https://github.com/ReactiveX/RxJava/wiki/Error-Handling | " + th, th);
    }
}
