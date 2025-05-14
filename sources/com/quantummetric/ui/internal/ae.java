package com.quantummetric.ui.internal;

import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.view.View;
import android.view.Window;
import com.facebook.react.uimanager.ViewProps;

/* loaded from: classes5.dex */
final class ae extends dg {
    private int A;
    private int B;

    ae(View view) {
        super(view);
    }

    static boolean a(View view) {
        if (view.getParent() instanceof View) {
            return false;
        }
        String simpleName = view.getClass().getSimpleName();
        return simpleName.equals("DecorView") || simpleName.equals("PopupDecorView");
    }

    private float t() {
        View view = this.F.get();
        if (view == null) {
            return -1.0f;
        }
        try {
            Window window = (Window) by.b(view, "mWindow");
            if (window != null) {
                return window.getAttributes().dimAmount;
            }
            return -1.0f;
        } catch (Exception unused) {
            return -1.0f;
        }
    }

    @Override // com.quantummetric.ui.internal.dg, com.quantummetric.ui.internal.b
    public final void j() {
        super.j();
        View view = this.F.get();
        if (view != null) {
            if (this.e instanceof cr) {
                ((cr) this.e).p = this.h;
            }
            Drawable background = view.getBackground();
            if (background instanceof InsetDrawable) {
                Rect b = de.b(background);
                if (de.a(b)) {
                    int i = this.k - (b.top + b.bottom);
                    int i2 = this.j - (b.left + b.right);
                    int i3 = this.h + b.top;
                    int i4 = this.i + b.left;
                    if (i * i2 > 0) {
                        this.k = i;
                        this.j = i2;
                        this.h = i3;
                        this.i = i4;
                    }
                }
            }
        }
        this.A = de.b(de.b());
        this.B = de.b(de.a());
    }

    @Override // com.quantummetric.ui.internal.b
    final String n() {
        ar arVar = new ar();
        float t = t();
        boolean z = false;
        if (t > 0.0f && t < 1.0f) {
            arVar.f65a.append(aa.M).append(":").append((Object) de.b(Color.argb((int) (t * 255.0f), 0, 0, 0))).append(";");
        }
        boolean z2 = (this.e instanceof cr) && ((cr) this.e).o;
        arVar.f65a.append(aa.ac).append(":").append(Integer.valueOf(this.A)).append(";");
        arVar.f65a.append(aa.ad).append(":").append(Integer.valueOf(this.B)).append(";");
        arVar.f65a.append(ViewProps.OVERFLOW).append(":").append((Object) aa.ab).append(";");
        String str = aa.aj;
        if (z2 && p()) {
            z = true;
        }
        if (z) {
            arVar.f65a.append(str).append(":").append((Object) "none").append(";");
        }
        return arVar.toString();
    }
}
