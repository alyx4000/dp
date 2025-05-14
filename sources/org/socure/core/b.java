package org.socure.core;

/* loaded from: classes6.dex */
public class b extends Mat {
    public b(Mat mat) {
        super(mat, Range.a());
        if (!b() && a(1, 6) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }
}
