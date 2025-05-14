package com.socure.idplus.device.internal.sigmaDeviceV2.manager;

import com.socure.idplus.device.internal.r;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.ResponseBody;

/* loaded from: classes5.dex */
public final class a extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f611a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(r rVar) {
        super(1);
        this.f611a = rVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ResponseBody it = (ResponseBody) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        this.f611a.invoke();
        return Unit.INSTANCE;
    }
}
