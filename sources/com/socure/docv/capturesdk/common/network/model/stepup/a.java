package com.socure.docv.capturesdk.common.network.model.stepup;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final /* synthetic */ class a {
    public static JsonAdapter a(Moshi moshi, Class cls, String str, String str2) {
        JsonAdapter adapter = moshi.adapter(cls, SetsKt.emptySet(), str);
        Intrinsics.checkNotNullExpressionValue(adapter, str2);
        return adapter;
    }
}
