package com.socure.docv.capturesdk.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.socure.docv.capturesdk.common.view.BrandLayout;
import com.socure.docv.capturesdk.common.view.CustomToolbar;

/* loaded from: classes5.dex */
public final class c implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f396a;
    public final BrandLayout b;
    public final CustomToolbar c;
    public final ConstraintLayout d;
    public final ConstraintLayout e;
    public final Guideline f;
    public final AppCompatTextView g;
    public final AppCompatTextView h;
    public final AppCompatTextView i;
    public final AppCompatTextView j;
    public final AppCompatTextView k;
    public final AppCompatTextView l;
    public final AppCompatTextView m;
    public final AppCompatTextView n;

    public c(ConstraintLayout constraintLayout, BrandLayout brandLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, CustomToolbar customToolbar, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, Guideline guideline, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, AppCompatTextView appCompatTextView7, AppCompatTextView appCompatTextView8) {
        this.f396a = constraintLayout;
        this.b = brandLayout;
        this.c = customToolbar;
        this.d = constraintLayout4;
        this.e = constraintLayout5;
        this.f = guideline;
        this.g = appCompatTextView;
        this.h = appCompatTextView2;
        this.i = appCompatTextView3;
        this.j = appCompatTextView4;
        this.k = appCompatTextView5;
        this.l = appCompatTextView6;
        this.m = appCompatTextView7;
        this.n = appCompatTextView8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f396a;
    }
}
