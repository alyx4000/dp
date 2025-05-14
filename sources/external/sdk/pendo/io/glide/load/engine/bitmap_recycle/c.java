package external.sdk.pendo.io.glide.load.engine.bitmap_recycle;

import external.sdk.pendo.io.glide.load.engine.bitmap_recycle.f;
import java.util.Queue;
import sdk.pendo.io.i0.k;

/* loaded from: classes2.dex */
abstract class c<T extends f> {

    /* renamed from: a, reason: collision with root package name */
    private final Queue<T> f655a = k.a(20);

    c() {
    }

    abstract T a();

    public void a(T t) {
        if (this.f655a.size() < 20) {
            this.f655a.offer(t);
        }
    }

    T b() {
        T poll = this.f655a.poll();
        return poll == null ? a() : poll;
    }
}
