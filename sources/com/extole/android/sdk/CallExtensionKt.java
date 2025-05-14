package com.extole.android.sdk;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.random.Random;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* compiled from: CallExtension.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"randomAlphaNumericString", "", "desiredStrLength", "", "mobile-sdk_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CallExtensionKt {
    public static /* synthetic */ String randomAlphaNumericString$default(int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 15;
        }
        return randomAlphaNumericString(i);
    }

    public static final String randomAlphaNumericString(int i) {
        List plus = CollectionsKt.plus((Collection) CollectionsKt.plus((Iterable) new CharRange('a', 'z'), (Iterable) new CharRange('A', Matrix.MATRIX_TYPE_ZERO)), (Iterable) new CharRange('0', '9'));
        IntRange intRange = new IntRange(1, i);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            ((IntIterator) it).nextInt();
            arrayList.add(Integer.valueOf(Random.INSTANCE.nextInt(0, plus.size())));
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(Character.valueOf(((Character) plus.get(((Number) it2.next()).intValue())).charValue()));
        }
        return CollectionsKt.joinToString$default(arrayList3, "", null, null, 0, null, null, 62, null);
    }
}
