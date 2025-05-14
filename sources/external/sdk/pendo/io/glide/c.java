package external.sdk.pendo.io.glide;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, Object> f626a;

    static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Map<Class<?>, Object> f627a = new HashMap();

        a() {
        }

        c a() {
            return new c(this);
        }
    }

    c(a aVar) {
        this.f626a = Collections.unmodifiableMap(new HashMap(aVar.f627a));
    }

    public boolean a(Class<Object> cls) {
        return this.f626a.containsKey(cls);
    }
}
