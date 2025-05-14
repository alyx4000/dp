package com.socure.idplus.device.internal.sigmaDeviceV2.dataHandler;

import com.socure.idplus.device.internal.sigmaDeviceV2.model.SigmaDeviceV2Model;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class a extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.socure.idplus.device.internal.api.a f610a;
    public final /* synthetic */ String b;
    public final /* synthetic */ SigmaDeviceV2Model c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(com.socure.idplus.device.internal.api.a aVar, String str, SigmaDeviceV2Model sigmaDeviceV2Model) {
        super(0);
        this.f610a = aVar;
        this.b = str;
        this.c = sigmaDeviceV2Model;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return this.f610a.a(this.b, this.c);
    }
}
