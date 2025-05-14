package com.socure.idplus.device.internal.input;

import android.view.KeyEvent;
import com.socure.idplus.device.internal.behavior.model.KeyPressEvent;
import com.socure.idplus.device.internal.behavior.model.KeyPressType;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class e extends b implements Function1 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(com.socure.idplus.device.internal.thread.b socureThread) {
        super(4, socureThread);
        Intrinsics.checkNotNullParameter(socureThread, "socureThread");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        KeyEvent keyEvent = (KeyEvent) obj;
        if (keyEvent != null) {
            long eventTime = keyEvent.getEventTime();
            int action = keyEvent.getAction();
            a(new KeyPressEvent(eventTime, action != 0 ? action != 1 ? KeyPressType.UNKNOWN : KeyPressType.KEY_UP : KeyPressType.KEY_DOWN));
        }
        return Unit.INSTANCE;
    }
}
