package external.sdk.pendo.io.glide.load.model;

import external.sdk.pendo.io.glide.load.Options;
import java.util.Collections;
import java.util.List;
import sdk.pendo.io.i0.j;
import sdk.pendo.io.q.f;

/* loaded from: classes2.dex */
public interface b<Model, Data> {

    public static class a<Data> {

        /* renamed from: a, reason: collision with root package name */
        public final f f683a;
        public final List<f> b;
        public final external.sdk.pendo.io.glide.load.data.a<Data> c;

        public a(f fVar, external.sdk.pendo.io.glide.load.data.a<Data> aVar) {
            this(fVar, Collections.emptyList(), aVar);
        }

        public a(f fVar, List<f> list, external.sdk.pendo.io.glide.load.data.a<Data> aVar) {
            this.f683a = (f) j.a(fVar);
            this.b = (List) j.a(list);
            this.c = (external.sdk.pendo.io.glide.load.data.a) j.a(aVar);
        }
    }

    a<Data> buildLoadData(Model model, int i, int i2, Options options);

    boolean handles(Model model);
}
