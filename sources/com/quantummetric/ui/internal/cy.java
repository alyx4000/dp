package com.quantummetric.ui.internal;

import android.content.res.ColorStateList;
import android.view.View;
import android.widget.EditText;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes5.dex */
final class cy extends da {
    static boolean p = true;
    String o;
    private boolean q;
    private boolean r;
    private float s;
    private int t;
    private int u;
    private float v;
    private float w;
    private float x;
    private float y;
    private float z;

    cy(View view) {
        super(view);
        this.y = -1.0f;
        this.z = -1.0f;
        this.o = b(view);
        super.a((Object) view);
        if (de.b(this.o)) {
            return;
        }
        c();
    }

    private void a(View view, EditText editText) {
        boolean z = true;
        if (ag.c(view)) {
            try {
                if (((TextInputLayout) view).getBoxBackgroundMode() == 1) {
                    z = false;
                }
            } catch (Throwable unused) {
            }
        }
        if (view.getHeight() > this.v) {
            this.x = z ? (view.getHeight() - this.v) / 2.0f : editText.getCompoundPaddingTop();
        }
        this.s = de.b(view.getPaddingLeft() + editText.getTotalPaddingLeft());
    }

    private void a(EditText editText) {
        if (this.w == 0.0f) {
            int currentHintTextColor = editText.getCurrentHintTextColor();
            this.u = currentHintTextColor;
            if (currentHintTextColor == 0 && (this.B.get() instanceof TextInputLayout)) {
                try {
                    ColorStateList defaultHintTextColor = ((TextInputLayout) this.B.get()).getDefaultHintTextColor();
                    if (defaultHintTextColor != null) {
                        this.u = defaultHintTextColor.getDefaultColor();
                    }
                } catch (Throwable unused) {
                }
            }
            this.t = this.u;
            float textSize = editText.getTextSize();
            this.v = textSize;
            this.w = (textSize * 3.0f) / 4.0f;
            this.r = editText.getMaxLines() == 1;
        }
    }

    static String b(View view) {
        if (!ag.c(view)) {
            return "";
        }
        try {
            CharSequence hint = ((TextInputLayout) view).getHint();
            return hint != null ? hint.toString() : "";
        } catch (NoSuchMethodError unused) {
            return "";
        }
    }

    private void c() {
        boolean z;
        View view = this.B.get();
        try {
            EditText d = d(view);
            if (d != null) {
                if (d.getText() != null && !de.b(d.getText().toString())) {
                    z = false;
                    this.q = z;
                    if (de.b(this.o) && d.getHint() != null) {
                        this.o = d.getHint().toString();
                    }
                    a(d);
                    a(view, d);
                    if (p || !ag.b()) {
                    }
                    CollapsingTextHelper collapsingTextHelper = (CollapsingTextHelper) by.a(view, (Class<?>) TextInputLayout.class, "collapsingTextHelper");
                    this.y = ((Float) by.a(collapsingTextHelper, (Class<?>) CollapsingTextHelper.class, "collapsedDrawX")).floatValue();
                    this.z = ((Float) by.a(collapsingTextHelper, (Class<?>) CollapsingTextHelper.class, "collapsedDrawY")).floatValue();
                    return;
                }
                z = true;
                this.q = z;
                if (de.b(this.o)) {
                    this.o = d.getHint().toString();
                }
                a(d);
                a(view, d);
                if (p) {
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static EditText d(View view) {
        try {
            if (ag.c(view)) {
                return ((TextInputLayout) view).getEditText();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.quantummetric.ui.internal.da, com.quantummetric.ui.internal.c
    final void a(Object obj) {
        super.a(obj);
        if (de.b(this.o)) {
            return;
        }
        c();
    }

    final String b() {
        float f;
        ar arVar = new ar();
        if (!de.b(this.o)) {
            float f2 = this.s;
            if (this.q) {
                f = this.x;
                arVar.f65a.append(aa.O).append(":").append(Integer.valueOf(de.b(this.v))).append(aa.f).append(";");
                arVar.f65a.append(aa.N).append(":").append((Object) de.b(this.t)).append(";");
            } else {
                arVar.f65a.append(aa.N).append(":").append((Object) de.b(this.u)).append(";");
                arVar.f65a.append(aa.O).append(":").append(Integer.valueOf(de.b(this.w))).append(aa.f).append(";");
                float f3 = this.y;
                if (f3 >= 0.0f) {
                    f2 = de.b(f3);
                }
                f = this.z;
                if (f < 0.0f) {
                    f = 0.0f;
                }
            }
            ar a2 = arVar.a(aa.ag, Float.valueOf(f2), aa.f, f2 > 0.0f).a(aa.ah, Integer.valueOf(de.b(f)), aa.f, f > 0.0f);
            a2.f65a.append(aa.al).append(":").append((Object) 1).append(";");
            a2.f65a.append(ViewProps.POSITION).append(":").append((Object) "absolute").append(";");
            if (this.r) {
                arVar.f65a.append("white-space").append(":").append((Object) "nowrap").append(";");
            }
        }
        return arVar.toString();
    }
}
