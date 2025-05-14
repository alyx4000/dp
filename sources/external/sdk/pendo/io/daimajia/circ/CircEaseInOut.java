package external.sdk.pendo.io.daimajia.circ;

import external.sdk.pendo.io.daimajia.BaseEasingMethod;

/* loaded from: classes2.dex */
public class CircEaseInOut extends BaseEasingMethod {
    public CircEaseInOut(float f) {
        super(f);
    }

    @Override // external.sdk.pendo.io.daimajia.BaseEasingMethod
    public Float calculate(float f, float f2, float f3, float f4) {
        float f5;
        float sqrt;
        float f6 = f / (f4 / 2.0f);
        if (f6 < 1.0f) {
            f5 = (-f3) / 2.0f;
            sqrt = ((float) Math.sqrt(1.0f - (f6 * f6))) - 1.0f;
        } else {
            f5 = f3 / 2.0f;
            float f7 = f6 - 2.0f;
            sqrt = ((float) Math.sqrt(1.0f - (f7 * f7))) + 1.0f;
        }
        return Float.valueOf((f5 * sqrt) + f2);
    }
}
