package com.socure.docv.capturesdk.common.utils;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0013\n\u0002\u0010\u0006\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00020\u0003\"\u00020\u0004¨\u0006\u0005"}, d2 = {"floatArrayOf", "", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "", "", "capturesdk_productionRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NumberUtilsKt {
    public static final float[] floatArrayOf(double... entries) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        ArrayList arrayList = new ArrayList(entries.length);
        for (double d : entries) {
            arrayList.add(Float.valueOf((float) d));
        }
        return CollectionsKt.toFloatArray(arrayList);
    }
}
