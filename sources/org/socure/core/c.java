package org.socure.core;

/* loaded from: classes6.dex */
public class c extends Mat {
    public c(d... dVarArr) {
        a(dVarArr);
    }

    public void a(d... dVarArr) {
        if (dVarArr == null || dVarArr.length == 0) {
            return;
        }
        int length = dVarArr.length;
        if (length > 0) {
            a(length, 1, a.a(5, 2));
        }
        float[] fArr = new float[length * 2];
        for (int i = 0; i < length; i++) {
            d dVar = dVarArr[i];
            int i2 = i * 2;
            fArr[i2 + 0] = (float) dVar.f806a;
            fArr[i2 + 1] = (float) dVar.b;
        }
        b(0, 0, fArr);
    }
}
