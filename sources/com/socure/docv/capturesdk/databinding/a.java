package com.socure.docv.capturesdk.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.socure.docv.capturesdk.common.view.BrandLayout;
import com.socure.docv.capturesdk.feature.help.presentation.ui.HelpView;
import com.socure.docv.capturesdk.feature.preview.presentation.ui.PreviewView;

/* loaded from: classes5.dex */
public final class a implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f394a;
    public final BrandLayout b;
    public final HelpView c;
    public final PreviewView d;
    public final ConstraintLayout e;

    public a(ConstraintLayout constraintLayout, BrandLayout brandLayout, ConstraintLayout constraintLayout2, HelpView helpView, PreviewView previewView, ConstraintLayout constraintLayout3, View view) {
        this.f394a = constraintLayout;
        this.b = brandLayout;
        this.c = helpView;
        this.d = previewView;
        this.e = constraintLayout3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f394a;
    }
}
