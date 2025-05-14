package com.socure.idplus.device.internal.input;

import android.os.SystemClock;
import com.socure.idplus.device.internal.behavior.model.FocusChangeEvent;
import com.socure.idplus.device.internal.behavior.model.FocusType;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class c extends b implements Function1 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(com.socure.idplus.device.internal.thread.b socureThread) {
        super(6, socureThread);
        Intrinsics.checkNotNullParameter(socureThread, "socureThread");
    }

    public final void a(boolean z) {
        a(new FocusChangeEvent(SystemClock.uptimeMillis(), z ? FocusType.FOCUS : FocusType.BLUR));
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }
}
