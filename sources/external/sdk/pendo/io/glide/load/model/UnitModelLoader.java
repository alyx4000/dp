package external.sdk.pendo.io.glide.load.model;

import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.data.a;
import external.sdk.pendo.io.glide.load.model.b;
import external.sdk.pendo.io.glide.signature.ObjectKey;

/* loaded from: classes2.dex */
public class UnitModelLoader<Model> implements b<Model, Model> {
    private static final UnitModelLoader<?> INSTANCE = new UnitModelLoader<>();

    public static class Factory<Model> implements sdk.pendo.io.x.d<Model, Model> {
        private static final Factory<?> FACTORY = new Factory<>();

        @Deprecated
        public Factory() {
        }

        public static <T> Factory<T> getInstance() {
            return (Factory<T>) FACTORY;
        }

        @Override // sdk.pendo.io.x.d
        public b<Model, Model> build(e eVar) {
            return UnitModelLoader.getInstance();
        }

        public void teardown() {
        }
    }

    private static class a<Model> implements external.sdk.pendo.io.glide.load.data.a<Model> {
        private final Model f;

        a(Model model) {
            this.f = model;
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void cancel() {
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void cleanup() {
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public Class<Model> getDataClass() {
            return (Class<Model>) this.f.getClass();
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public sdk.pendo.io.q.a getDataSource() {
            return sdk.pendo.io.q.a.LOCAL;
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void loadData(sdk.pendo.io.o.b bVar, a.InterfaceC0055a<? super Model> interfaceC0055a) {
            interfaceC0055a.a((a.InterfaceC0055a<? super Model>) this.f);
        }
    }

    @Deprecated
    public UnitModelLoader() {
    }

    public static <T> UnitModelLoader<T> getInstance() {
        return (UnitModelLoader<T>) INSTANCE;
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public b.a<Model> buildLoadData(Model model, int i, int i2, Options options) {
        return new b.a<>(new ObjectKey(model), new a(model));
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public boolean handles(Model model) {
        return true;
    }
}
