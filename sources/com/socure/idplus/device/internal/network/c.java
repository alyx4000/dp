package com.socure.idplus.device.internal.network;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;

/* loaded from: classes5.dex */
public abstract class c {
    public static void a(Function0 runnable, Function1 onSuccess, Function1 onError) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        ((Call) runnable.invoke()).enqueue(new b(onSuccess, onError));
    }
}
