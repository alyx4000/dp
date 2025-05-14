package sdk.pendo.io.y6;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private final Method f1829a;
    private final List<?> b;

    j(Method method, List<?> list) {
        this.f1829a = method;
        this.b = Collections.unmodifiableList(list);
    }

    public Method a() {
        return this.f1829a;
    }

    public String toString() {
        return String.format("%s.%s() %s", this.f1829a.getDeclaringClass().getName(), this.f1829a.getName(), this.b);
    }
}
