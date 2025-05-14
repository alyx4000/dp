package com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class c implements ViewModelProvider.Factory {

    /* renamed from: a, reason: collision with root package name */
    public final Application f445a;

    public c(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.f445a = application;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_OVM_F", "OrchestratorVMFactory create");
        if (b.class.isAssignableFrom(modelClass)) {
            return new d(this.f445a);
        }
        throw new IllegalArgumentException("Unknown ViewModel Class");
    }
}
