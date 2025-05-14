package com.socure.idplus.device.internal.sigmaDeviceLocation.manager;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.ResponseBody;

/* loaded from: classes5.dex */
public final class d extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public static final d f600a = new d();

    public d() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ResponseBody it = (ResponseBody) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        com.socure.idplus.device.internal.common.utils.a.a("LocationManager", "Successfully posted the location");
        return Unit.INSTANCE;
    }
}
