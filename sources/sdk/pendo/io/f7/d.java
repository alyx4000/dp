package sdk.pendo.io.f7;

import javax.annotation.ParametersAreNonnullByDefault;
import sdk.pendo.io.x5.j;
import sdk.pendo.io.x5.m;
import sdk.pendo.io.x5.n;

@ParametersAreNonnullByDefault
/* loaded from: classes6.dex */
public final class d<T> implements n<T, T>, sdk.pendo.io.x5.f<T, T> {

    /* renamed from: a, reason: collision with root package name */
    final j<?> f1084a;

    d(j<?> jVar) {
        sdk.pendo.io.g7.a.a(jVar, "observable == null");
        this.f1084a = jVar;
    }

    @Override // sdk.pendo.io.x5.f
    public sdk.pendo.io.w5.a<T> a(sdk.pendo.io.x5.d<T> dVar) {
        return dVar.b(this.f1084a.a(sdk.pendo.io.x5.a.LATEST));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        return this.f1084a.equals(((d) obj).f1084a);
    }

    public int hashCode() {
        return this.f1084a.hashCode();
    }

    public String toString() {
        return "LifecycleTransformer{observable=" + this.f1084a + '}';
    }

    @Override // sdk.pendo.io.x5.n
    public m<T> a(j<T> jVar) {
        return jVar.d(this.f1084a);
    }
}
