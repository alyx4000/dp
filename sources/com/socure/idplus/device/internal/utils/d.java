package com.socure.idplus.device.internal.utils;

import android.app.Activity;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowInsets;
import android.view.WindowMetrics;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public c f618a;

    public final void a(Activity activity) {
        int i;
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.f618a != null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            WindowMetrics currentWindowMetrics = activity.getWindowManager().getCurrentWindowMetrics();
            Intrinsics.checkNotNullExpressionValue(currentWindowMetrics, "getCurrentWindowMetrics(...)");
            Insets insetsIgnoringVisibility = currentWindowMetrics.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets.Type.navigationBars() | WindowInsets.Type.displayCutout());
            Intrinsics.checkNotNullExpressionValue(insetsIgnoringVisibility, "getInsetsIgnoringVisibility(...)");
            int i5 = insetsIgnoringVisibility.right + insetsIgnoringVisibility.left;
            int i6 = insetsIgnoringVisibility.top + insetsIgnoringVisibility.bottom;
            Rect bounds = currentWindowMetrics.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
            i4 = bounds.width();
            i2 = bounds.height();
            i = i4 - i5;
            i3 = i2 - i6;
        } else {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            defaultDisplay.getRealMetrics(displayMetrics);
            int i7 = displayMetrics.widthPixels;
            int i8 = displayMetrics.heightPixels;
            defaultDisplay.getMetrics(displayMetrics);
            i = displayMetrics.widthPixels;
            i2 = i8;
            i3 = displayMetrics.heightPixels;
            i4 = i7;
        }
        this.f618a = new c(i, i3, i4, i2);
    }
}
