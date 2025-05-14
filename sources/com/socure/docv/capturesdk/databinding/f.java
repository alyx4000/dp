package com.socure.docv.capturesdk.databinding;

import android.view.View;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes5.dex */
public final class f implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f399a;

    public f(ConstraintLayout constraintLayout, ProgressBar progressBar) {
        this.f399a = constraintLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f399a;
    }
}
