package com.socure.idplus.device.internal.sigmaDeviceLocation.manager;

import android.content.Context;
import com.socure.idplus.device.internal.g;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class b extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f598a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ Function1 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar, Context context, g gVar) {
        super(0);
        this.f598a = fVar;
        this.b = context;
        this.c = gVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        f fVar = this.f598a;
        Context context = this.b;
        Function1 function1 = this.c;
        fVar.getClass();
        f.a(context, function1);
        return Unit.INSTANCE;
    }
}
