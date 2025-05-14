package io.castle.highwind.android;

import kotlin.math.MathKt;

/* loaded from: classes2.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public int f781a;
    public Object b;
    public int c;

    public x(int i, Object obj, int i2) {
        this.f781a = i;
        this.b = obj;
        this.c = i2;
        if (obj == null) {
            this.c = 1;
            return;
        }
        if (i2 == 7 && ((Double) obj).doubleValue() > 25.5d) {
            this.c = 6;
            this.b = Integer.valueOf(MathKt.roundToInt(((Double) this.b).doubleValue()));
        } else if (this.c == 6 && ((Integer) this.b).intValue() < 0) {
            this.b = 0;
        } else {
            if (this.c != 7 || ((Double) this.b).doubleValue() >= 0.0d) {
                return;
            }
            this.b = Double.valueOf(0.0d);
        }
    }

    public final String a() {
        return w.a(((this.f781a & 31) << 3) | (c.a(this.c) & 7));
    }
}
