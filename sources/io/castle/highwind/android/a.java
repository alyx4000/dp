package io.castle.highwind.android;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0072a f761a = new C0072a();
    public static final Map<Integer, Integer> b;

    /* renamed from: io.castle.highwind.android.a$a, reason: collision with other inner class name */
    public static final class C0072a {
    }

    static {
        Integer[] numArr = new Integer[70];
        int i = 0;
        for (int i2 = 0; i2 < 70; i2++) {
            numArr[i2] = Integer.valueOf(i2);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(70), 16));
        while (i < 70) {
            Integer num = numArr[i];
            i++;
            int intValue = num.intValue();
            linkedHashMap.put(Integer.valueOf((int) (Math.pow(10.0d, intValue / 10) * ((intValue % 10) + 1))), num);
        }
        b = linkedHashMap;
        Set<Map.Entry> entrySet = linkedHashMap.entrySet();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(entrySet, 10)), 16));
        for (Map.Entry entry : entrySet) {
            linkedHashMap2.put(Integer.valueOf(((Number) entry.getValue()).intValue()), Integer.valueOf(((Number) entry.getKey()).intValue()));
        }
    }
}
