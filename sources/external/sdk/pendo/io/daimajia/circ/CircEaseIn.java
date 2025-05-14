package external.sdk.pendo.io.daimajia.circ;

import external.sdk.pendo.io.daimajia.BaseEasingMethod;

/* loaded from: classes2.dex */
public class CircEaseIn extends BaseEasingMethod {
    public CircEaseIn(float f) {
        super(f);
    }

    @Override // external.sdk.pendo.io.daimajia.BaseEasingMethod
    public Float calculate(float f, float f2, float f3, float f4) {
        float f5 = f / f4;
        return Float.valueOf(((-f3) * (((float) Math.sqrt(1.0f - (f5 * f5))) - 1.0f)) + f2);
    }
}
