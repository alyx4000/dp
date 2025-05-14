package com.socure.idplus.device.internal.behavior.manager;

import android.util.Log;
import com.socure.idplus.device.internal.behavior.model.SessionDataResponse;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class c extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public static final c f553a = new c();

    public c() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        SessionDataResponse it = (SessionDataResponse) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        Log.d("BehaviorDataManager", "Success");
        return Unit.INSTANCE;
    }
}
