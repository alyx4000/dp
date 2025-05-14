package com.socure.docv.capturesdk.databinding;

import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.socure.docv.capturesdk.common.view.CustomToolbar;

/* loaded from: classes5.dex */
public final class b implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f395a;
    public final ProgressBar b;
    public final WebView c;

    public b(ConstraintLayout constraintLayout, CustomToolbar customToolbar, ProgressBar progressBar, WebView webView) {
        this.f395a = constraintLayout;
        this.b = progressBar;
        this.c = webView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f395a;
    }
}
