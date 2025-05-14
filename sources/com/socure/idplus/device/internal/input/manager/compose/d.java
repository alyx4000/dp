package com.socure.idplus.device.internal.input.manager.compose;

import android.content.Context;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.AndroidComposeView_androidKt;
import androidx.compose.ui.platform.ComposeView;
import com.socure.idplus.device.internal.behavior.model.InputChangeAction;
import com.socure.idplus.device.internal.behavior.model.InputChangeEvent;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class d extends com.socure.idplus.device.internal.input.manager.b {
    public final com.socure.idplus.device.internal.input.c c;
    public final com.socure.idplus.device.internal.input.d d;
    public WeakReference e;
    public String f;
    public final Rect g;
    public String h;
    public boolean i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, com.socure.idplus.device.internal.input.c focusChangeProducer, com.socure.idplus.device.internal.input.d inputChangeProducer, com.socure.idplus.device.internal.input.manager.monitor.a actionModeMonitor) {
        super(context, actionModeMonitor);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(focusChangeProducer, "focusChangeProducer");
        Intrinsics.checkNotNullParameter(inputChangeProducer, "inputChangeProducer");
        Intrinsics.checkNotNullParameter(actionModeMonitor, "actionModeMonitor");
        this.c = focusChangeProducer;
        this.d = inputChangeProducer;
        this.g = new Rect();
        this.h = "";
    }

    public final void a(String targetId, InputChangeAction inputChangeAction) {
        Intrinsics.checkNotNullParameter(targetId, "targetId");
        Intrinsics.checkNotNullParameter(inputChangeAction, "inputChangeAction");
        com.socure.idplus.device.internal.input.d dVar = this.d;
        InputChangeEvent inputChangeEvent = new InputChangeEvent(SystemClock.uptimeMillis(), Intrinsics.areEqual(this.f, targetId), inputChangeAction);
        dVar.getClass();
        Intrinsics.checkNotNullParameter(inputChangeEvent, "inputChangeEvent");
        dVar.a(inputChangeEvent);
    }

    @Override // com.socure.idplus.device.internal.input.manager.b
    public final void b() {
        this.e = null;
        this.f = null;
        this.g.set(0, 0, 0, 0);
        this.h = "";
        this.i = false;
    }

    public final String a(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return this.h + "_" + rect.left + "_" + rect.top + "_" + rect.bottom + "_" + rect.right;
    }

    @Override // com.socure.idplus.device.internal.input.manager.b
    public final void b(ViewGroup contentView) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        this.i = false;
        com.socure.idplus.device.internal.common.utils.a.a("SocureComposeViewManager", "onWindowRemoved");
    }

    @Override // com.socure.idplus.device.internal.input.manager.b
    public final void a(View view, boolean z) {
        if (this.i || !(view instanceof ComposeView)) {
            return;
        }
        this.i = true;
        this.e = new WeakReference(view);
        AndroidComposeView_androidKt.setPlatformTextInputServiceInterceptor(new c(this));
    }

    @Override // com.socure.idplus.device.internal.input.manager.b
    public final void a(ViewGroup contentView) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        this.i = true;
        this.e = new WeakReference(contentView);
        AndroidComposeView_androidKt.setPlatformTextInputServiceInterceptor(new c(this));
    }
}
