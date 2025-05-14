package sdk.pendo.io.p2;

import java.lang.reflect.Type;

/* loaded from: classes6.dex */
public abstract class b<T> extends sdk.pendo.io.u2.b<T, T> {
    private final String A;
    private final Type s = (Type) sdk.pendo.io.o2.e.a((Class) sdk.pendo.io.r2.a.a((Type) getClass(), (Class<?>) b.class).get(b.class.getTypeParameters()[0]), Object.class);

    protected b(String str) {
        this.A = str;
    }

    public final String c() {
        return this.A;
    }

    @Override // java.util.Map.Entry
    public final T setValue(T t) {
        throw new UnsupportedOperationException("Cannot alter Diff object.");
    }

    @Override // sdk.pendo.io.u2.b
    public final String toString() {
        return String.format("[%s: %s, %s]", this.A, a(), b());
    }
}
