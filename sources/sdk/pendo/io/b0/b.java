package sdk.pendo.io.b0;

import external.sdk.pendo.io.glide.load.resource.transcode.UnitTranscoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final List<a<?, ?>> f874a = new ArrayList();

    private static final class a<Z, R> {

        /* renamed from: a, reason: collision with root package name */
        private final Class<Z> f875a;
        private final Class<R> b;
        final sdk.pendo.io.b0.a<Z, R> c;

        a(Class<Z> cls, Class<R> cls2, sdk.pendo.io.b0.a<Z, R> aVar) {
            this.f875a = cls;
            this.b = cls2;
            this.c = aVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return this.f875a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.b);
        }
    }

    public synchronized <Z, R> sdk.pendo.io.b0.a<Z, R> a(Class<Z> cls, Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return UnitTranscoder.get();
        }
        for (a<?, ?> aVar : this.f874a) {
            if (aVar.a(cls, cls2)) {
                return (sdk.pendo.io.b0.a<Z, R>) aVar.c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    public synchronized <Z, R> List<Class<R>> b(Class<Z> cls, Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        Iterator<a<?, ?>> it = this.f874a.iterator();
        while (it.hasNext()) {
            if (it.next().a(cls, cls2)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }

    public synchronized <Z, R> void a(Class<Z> cls, Class<R> cls2, sdk.pendo.io.b0.a<Z, R> aVar) {
        this.f874a.add(new a<>(cls, cls2, aVar));
    }
}
