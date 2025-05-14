package com.socure.idplus.device.internal.sigmaDeviceConfig.dataHandler;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class a extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.socure.idplus.device.internal.api.a f589a;
    public final /* synthetic */ String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(com.socure.idplus.device.internal.api.a aVar, String str) {
        super(0);
        this.f589a = aVar;
        this.b = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return this.f589a.a(this.b);
    }
}
