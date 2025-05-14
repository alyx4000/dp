package sdk.pendo.io.x5;

/* loaded from: classes4.dex */
public interface h<T> {
    void onComplete();

    void onError(Throwable th);

    void onSubscribe(sdk.pendo.io.b6.b bVar);

    void onSuccess(T t);
}
