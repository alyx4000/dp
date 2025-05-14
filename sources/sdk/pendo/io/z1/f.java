package sdk.pendo.io.z1;

import java.util.HashMap;
import java.util.LinkedHashSet;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    protected static HashMap<Class<?>, LinkedHashSet<Class<?>>> f1871a = new HashMap<>();
    protected static HashMap<Class<?>, HashMap<String, String>> b = new HashMap<>();

    static {
        a(Object.class, h.class);
        a(Object.class, g.class);
    }

    public static void a(Class<?> cls, Class<?> cls2) {
        synchronized (f1871a) {
            LinkedHashSet<Class<?>> linkedHashSet = f1871a.get(cls);
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet<>();
                f1871a.put(cls, linkedHashSet);
            }
            linkedHashSet.add(cls2);
        }
    }
}
