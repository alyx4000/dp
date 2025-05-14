package sdk.pendo.io.u2;

/* loaded from: classes3.dex */
public final class a<L, R> extends b<L, R> {
    public static final a<?, ?>[] f0 = new a[0];
    private static final a t0 = b(null, null);
    public final R A;
    public final L s;

    public a(L l, R r) {
        this.s = l;
        this.A = r;
    }

    @Override // sdk.pendo.io.u2.b
    public L a() {
        return this.s;
    }

    @Override // sdk.pendo.io.u2.b
    public R b() {
        return this.A;
    }

    @Override // java.util.Map.Entry
    public R setValue(R r) {
        throw new UnsupportedOperationException();
    }

    public static <L, R> a<L, R> b(L l, R r) {
        return new a<>(l, r);
    }
}
