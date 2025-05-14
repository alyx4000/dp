package com.socure.idplus.device.internal.sigmaDeviceLocation.dataHandler;

import com.socure.idplus.device.internal.sigmaDeviceLocation.model.SigmaDeviceLocationModel;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class a extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.socure.idplus.device.internal.api.a f596a;
    public final /* synthetic */ String b;
    public final /* synthetic */ SigmaDeviceLocationModel c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(com.socure.idplus.device.internal.api.a aVar, String str, SigmaDeviceLocationModel sigmaDeviceLocationModel) {
        super(0);
        this.f596a = aVar;
        this.b = str;
        this.c = sigmaDeviceLocationModel;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return this.f596a.a(this.b, this.c);
    }
}
