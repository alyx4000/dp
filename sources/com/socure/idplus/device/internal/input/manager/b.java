package com.socure.idplus.device.internal.input.manager;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public final ClipboardManager f569a;
    public final com.socure.idplus.device.internal.input.manager.monitor.a b;

    public b(Context context, com.socure.idplus.device.internal.input.manager.monitor.a actionMode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(actionMode, "actionMode");
        Object systemService = context.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        this.f569a = (ClipboardManager) systemService;
        this.b = actionMode;
    }

    public final CharSequence a() {
        ClipData.Item itemAt;
        ClipData primaryClip = this.f569a.getPrimaryClip();
        if (primaryClip == null || (itemAt = primaryClip.getItemAt(0)) == null) {
            return null;
        }
        return itemAt.getText();
    }

    public abstract void a(View view, boolean z);

    public abstract void a(ViewGroup viewGroup);

    public abstract void b();

    public abstract void b(ViewGroup viewGroup);
}
