package sdk.pendo.io.r4;

import sdk.pendo.io.y4.l3;

/* loaded from: classes6.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    private final int f1524a;

    protected d(int i) {
        if (!l3.q(i)) {
            throw new IllegalArgumentException("'nameType' should be between 0 and 255");
        }
        this.f1524a = i;
    }

    public final int a() {
        return this.f1524a;
    }

    public abstract boolean a(e eVar);
}
