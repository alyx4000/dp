package com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.socure.docv.capturesdk.common.utils.Screen;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class b implements ViewModelProvider.Factory {

    /* renamed from: a, reason: collision with root package name */
    public final com.socure.docv.capturesdk.di.c f528a;
    public final Screen b;

    public b(com.socure.docv.capturesdk.di.c dependencyGraph, Screen screen) {
        Intrinsics.checkNotNullParameter(dependencyGraph, "dependencyGraph");
        Intrinsics.checkNotNullParameter(screen, "screen");
        this.f528a = dependencyGraph;
        this.b = screen;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        if (modelClass.isAssignableFrom(c.class)) {
            return new c(this.f528a, this.b);
        }
        throw new IllegalArgumentException("Unknown ViewModel Class");
    }
}
