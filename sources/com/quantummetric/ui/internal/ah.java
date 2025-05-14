package com.quantummetric.ui.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import androidx.appcompat.widget.SwitchCompat;
import com.quantummetric.ui.internal.ce;
import java.lang.ref.WeakReference;

/* loaded from: classes5.dex */
final class ah extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    final WeakReference<View> f37a;
    int b;
    final boolean c;
    ce.a d;

    ah(View view, ce.a aVar) {
        this.f37a = new WeakReference<>(view);
        boolean j = ag.j(view);
        this.c = j;
        this.d = aVar;
        if (j) {
            a(view);
        } else {
            setBounds(0, 0, view.getWidth(), view.getHeight());
        }
    }

    static boolean a(Drawable drawable) {
        return (drawable instanceof ah) && !((ah) drawable).c;
    }

    final void a(View view) {
        Drawable drawable;
        Drawable drawable2;
        Drawable a2;
        if (ag.i(view)) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            drawable = switchCompat.getTrackDrawable();
            drawable2 = switchCompat.getThumbDrawable();
        } else if (view instanceof Switch) {
            Switch r0 = (Switch) view;
            drawable = r0.getTrackDrawable();
            drawable2 = r0.getThumbDrawable();
        } else {
            drawable = null;
            drawable2 = null;
        }
        if ((drawable2 instanceof LayerDrawable) && (a2 = de.a((LayerDrawable) drawable2)) != null) {
            drawable2 = a2;
        }
        if (drawable == null || drawable2 == null) {
            return;
        }
        Rect bounds = drawable.getBounds();
        Rect bounds2 = drawable2.getBounds();
        setBounds(Math.min(bounds2.left, bounds.left), Math.min(bounds2.top, bounds.top), Math.max(bounds2.right, bounds.right), Math.max(bounds2.bottom, bounds.bottom));
        Drawable.ConstantState constantState = drawable2.getConstantState();
        if (constantState != null) {
            this.b = constantState.hashCode();
            if (((CompoundButton) view).isChecked()) {
                this.b++;
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        try {
            View view = this.f37a.get();
            if (view == null || view.getWidth() * view.getHeight() <= 0) {
                return;
            }
            view.draw(canvas);
        } catch (Throwable unused) {
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return getBounds().height();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return getBounds().width();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
