package com.google.android.material.shape;

/* loaded from: classes3.dex */
public class EdgeTreatment {
    boolean forceIntersection() {
        return false;
    }

    @Deprecated
    public void getEdgePath(float f, float f2, ShapePath shapePath) {
        getEdgePath(f, f / 2.0f, f2, shapePath);
    }

    public void getEdgePath(float f, float f2, float f3, ShapePath shapePath) {
        shapePath.lineTo(f, 0.0f);
    }
}
