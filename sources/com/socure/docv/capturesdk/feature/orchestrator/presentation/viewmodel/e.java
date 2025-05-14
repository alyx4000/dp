package com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class e implements ViewModelProvider.Factory {

    /* renamed from: a, reason: collision with root package name */
    public final ViewModelProvider.Factory f453a;

    public e(ViewModelProvider.Factory delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f453a = delegate;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_OVM_F", "ProductionOrchestratorVMFactory create");
        if (b.class.isAssignableFrom(modelClass)) {
            return new f((b) this.f453a.create(modelClass));
        }
        throw new IllegalArgumentException("Unknown ViewModel Class");
    }
}
