package com.socure.idplus.device.internal.input;

import android.view.MotionEvent;
import com.socure.idplus.device.internal.behavior.model.Offset;
import com.socure.idplus.device.internal.behavior.model.PointerEvent;
import com.socure.idplus.device.internal.behavior.model.PointerType;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class f extends b implements Function1 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(com.socure.idplus.device.internal.thread.b socureThread) {
        super(5, socureThread);
        Intrinsics.checkNotNullParameter(socureThread, "socureThread");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        MotionEvent motionEvent = (MotionEvent) obj;
        if (motionEvent != null && motionEvent.getPointerCount() > 0) {
            long eventTime = motionEvent.getEventTime();
            int toolType = motionEvent.getToolType(0);
            a(new PointerEvent(eventTime, toolType != 1 ? toolType != 2 ? toolType != 3 ? toolType != 4 ? PointerType.UNKNOWN : PointerType.INVERTED_STYLUS : PointerType.MOUSE : PointerType.STYLUS : PointerType.TOUCH, motionEvent.getPressure(), new Offset(motionEvent.getX(), motionEvent.getY())));
        }
        return Unit.INSTANCE;
    }
}
