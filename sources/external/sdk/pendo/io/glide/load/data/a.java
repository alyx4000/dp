package external.sdk.pendo.io.glide.load.data;

/* loaded from: classes2.dex */
public interface a<T> {

    /* renamed from: external.sdk.pendo.io.glide.load.data.a$a, reason: collision with other inner class name */
    public interface InterfaceC0055a<T> {
        void a(Exception exc);

        void a(T t);
    }

    void cancel();

    void cleanup();

    Class<T> getDataClass();

    sdk.pendo.io.q.a getDataSource();

    void loadData(sdk.pendo.io.o.b bVar, InterfaceC0055a<? super T> interfaceC0055a);
}
