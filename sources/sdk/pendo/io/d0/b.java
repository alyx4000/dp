package sdk.pendo.io.d0;

import external.sdk.pendo.io.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final List<ImageHeaderParser> f975a = new ArrayList();

    public synchronized void a(ImageHeaderParser imageHeaderParser) {
        this.f975a.add(imageHeaderParser);
    }

    public synchronized List<ImageHeaderParser> a() {
        return this.f975a;
    }
}
