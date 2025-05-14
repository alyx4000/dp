package com.socure.idplus.device.internal.behavior.dataHandler;

import com.socure.idplus.device.internal.behavior.model.SessionDataRequest;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class a extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.socure.idplus.device.internal.api.a f550a;
    public final /* synthetic */ String b;
    public final /* synthetic */ SessionDataRequest c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(com.socure.idplus.device.internal.api.a aVar, String str, SessionDataRequest sessionDataRequest) {
        super(0);
        this.f550a = aVar;
        this.b = str;
        this.c = sessionDataRequest;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return this.f550a.a(this.b, this.c);
    }
}
