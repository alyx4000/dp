package com.socure.docv.capturesdk.feature.progress.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.socure.docv.capturesdk.R;
import com.socure.docv.capturesdk.databinding.f;
import com.socure.docv.capturesdk.feature.base.presentation.ui.BaseFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/socure/docv/capturesdk/feature/progress/ui/ProgressFragment;", "Lcom/socure/docv/capturesdk/feature/base/presentation/ui/BaseFragment;", "<init>", "()V", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes5.dex */
public final class ProgressFragment extends BaseFragment {
    public ProgressFragment() {
        super("SDLT_PF");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_progress_socure, viewGroup, false);
        int i = R.id.pb_consent_call;
        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(inflate, i);
        if (progressBar == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        Intrinsics.checkNotNullExpressionValue(new f(constraintLayout, progressBar), "inflate(inflater, container, false)");
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.root");
        return constraintLayout;
    }
}
