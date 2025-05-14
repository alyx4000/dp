package com.socure.docv.capturesdk.databinding;

import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.socure.docv.capturesdk.common.view.BrandLayout;

/* loaded from: classes5.dex */
public final class d implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f397a;
    public final BrandLayout b;
    public final AppCompatButton c;
    public final AppCompatButton d;
    public final ConstraintLayout e;
    public final AppCompatImageView f;
    public final RecyclerView g;
    public final AppCompatTextView h;

    public d(ConstraintLayout constraintLayout, BrandLayout brandLayout, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, Guideline guideline, AppCompatImageView appCompatImageView, ProgressBar progressBar, RecyclerView recyclerView, AppCompatTextView appCompatTextView) {
        this.f397a = constraintLayout;
        this.b = brandLayout;
        this.c = appCompatButton;
        this.d = appCompatButton2;
        this.e = constraintLayout2;
        this.f = appCompatImageView;
        this.g = recyclerView;
        this.h = appCompatTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f397a;
    }
}
