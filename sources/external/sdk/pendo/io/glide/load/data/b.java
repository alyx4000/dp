package external.sdk.pendo.io.glide.load.data;

/* loaded from: classes2.dex */
public interface b<T> {

    public interface a<T> {
        b<T> build(T t);

        Class<T> getDataClass();
    }

    void cleanup();

    T rewindAndGet();
}
