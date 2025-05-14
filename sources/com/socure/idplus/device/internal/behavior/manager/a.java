package com.socure.idplus.device.internal.behavior.manager;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class a extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f551a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b bVar) {
        super(1);
        this.f551a = bVar;
    }

    public final void a(com.socure.idplus.device.internal.network.a networkError) {
        Integer b;
        Function0 function0;
        Intrinsics.checkNotNullParameter(networkError, "networkError");
        com.socure.idplus.device.internal.common.utils.a.a("BehaviorSessionManager", "Error uploading behavior data " + networkError.a());
        Integer b2 = networkError.b();
        if ((b2 != null && b2.intValue() == 403) || ((b = networkError.b()) != null && b.intValue() == 401)) {
            function0 = this.f551a.c;
            function0.invoke();
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((com.socure.idplus.device.internal.network.a) obj);
        return Unit.INSTANCE;
    }
}
