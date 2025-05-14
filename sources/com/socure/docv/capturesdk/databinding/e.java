package com.socure.docv.capturesdk.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.socure.docv.capturesdk.common.view.BrandLayout;
import com.socure.docv.capturesdk.common.view.CustomToolbar;

/* loaded from: classes5.dex */
public final class e implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f398a;
    public final BrandLayout b;
    public final AppCompatButton c;
    public final AppCompatButton d;
    public final CustomToolbar e;
    public final Guideline f;
    public final AppCompatTextView g;

    public e(ConstraintLayout constraintLayout, CardView cardView, CardView cardView2, BrandLayout brandLayout, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, CustomToolbar customToolbar, Guideline guideline, AppCompatTextView appCompatTextView) {
        this.f398a = constraintLayout;
        this.b = brandLayout;
        this.c = appCompatButton;
        this.d = appCompatButton2;
        this.e = customToolbar;
        this.f = guideline;
        this.g = appCompatTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f398a;
    }
}
