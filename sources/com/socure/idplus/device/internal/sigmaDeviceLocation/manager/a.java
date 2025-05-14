package com.socure.idplus.device.internal.sigmaDeviceLocation.manager;

import android.location.Location;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* loaded from: classes5.dex */
public final class a extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f597a;
    public final /* synthetic */ Function1 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Ref.BooleanRef booleanRef, Function1 function1) {
        super(1);
        this.f597a = booleanRef;
        this.b = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        this.f597a.element = true;
        this.b.invoke((Location) obj);
        return Unit.INSTANCE;
    }
}
