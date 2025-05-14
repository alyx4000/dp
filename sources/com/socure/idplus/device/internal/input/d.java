package com.socure.idplus.device.internal.input;

import com.socure.idplus.device.internal.behavior.model.InputChangeEvent;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class d extends b implements Function1 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(com.socure.idplus.device.internal.thread.b socureThread) {
        super(9, socureThread);
        Intrinsics.checkNotNullParameter(socureThread, "socureThread");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        InputChangeEvent inputChangeEvent = (InputChangeEvent) obj;
        Intrinsics.checkNotNullParameter(inputChangeEvent, "inputChangeEvent");
        a(inputChangeEvent);
        return Unit.INSTANCE;
    }
}
