package sdk.pendo.io.u;

/* loaded from: classes3.dex */
public interface a {
    void clearMemory();

    <T> T get(int i, Class<T> cls);

    <T> T getExact(int i, Class<T> cls);

    <T> void put(T t);

    void trimMemory(int i);
}
