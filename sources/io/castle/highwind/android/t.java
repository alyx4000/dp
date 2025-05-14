package io.castle.highwind.android;

import kotlin.collections.ArraysKt;

/* loaded from: classes2.dex */
public final class t {
    public final Object[] a(Double[] dArr, double d) {
        double doubleValue = (((Number) ArraysKt.last(dArr)).doubleValue() - ((Number) ArraysKt.first(dArr)).doubleValue()) / 16;
        int floor = (int) Math.floor((d - ((Number) ArraysKt.first(dArr)).doubleValue()) / doubleValue);
        double doubleValue2 = (floor * doubleValue) + ((Number) ArraysKt.first(dArr)).doubleValue();
        return new Object[]{Integer.valueOf(floor), new Double[]{Double.valueOf(doubleValue2), Double.valueOf(doubleValue + doubleValue2)}};
    }
}
