package sdk.pendo.io.x5;

/* loaded from: classes4.dex */
public interface o<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);

    void onSubscribe(sdk.pendo.io.b6.b bVar);
}
