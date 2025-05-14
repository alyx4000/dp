package com.socure.docv.capturesdk.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.progressindicator.CircularProgressIndicator;

/* loaded from: classes5.dex */
public final class h implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final CoordinatorLayout f401a;

    public h(CoordinatorLayout coordinatorLayout, FragmentContainerView fragmentContainerView, CircularProgressIndicator circularProgressIndicator, View view, ConstraintLayout constraintLayout) {
        this.f401a = coordinatorLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f401a;
    }
}
