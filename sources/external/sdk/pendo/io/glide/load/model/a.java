package external.sdk.pendo.io.glide.load.model;

import external.sdk.pendo.io.glide.load.model.LazyHeaders;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public interface a {

    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    public static final a f682a = new C0062a();
    public static final a b = new LazyHeaders.a().a();

    /* renamed from: external.sdk.pendo.io.glide.load.model.a$a, reason: collision with other inner class name */
    class C0062a implements a {
        C0062a() {
        }

        @Override // external.sdk.pendo.io.glide.load.model.a
        public Map<String, String> getHeaders() {
            return Collections.emptyMap();
        }
    }

    Map<String, String> getHeaders();
}
