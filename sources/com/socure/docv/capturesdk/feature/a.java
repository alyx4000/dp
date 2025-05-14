package com.socure.docv.capturesdk.feature;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.f;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: com.socure.docv.capturesdk.feature.a$a, reason: collision with other inner class name */
    public static final class C0041a extends Lambda implements Function0<ViewModelStore> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f414a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0041a(Fragment fragment) {
            super(0);
            this.f414a = fragment;
        }

        @Override // kotlin.jvm.functions.Function0
        public ViewModelStore invoke() {
            ViewModelStore viewModelStore = this.f414a.requireActivity().getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }

    public static final class b extends Lambda implements Function0<CreationExtras> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f415a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Function0 function0, Fragment fragment) {
            super(0);
            this.f415a = fragment;
        }

        @Override // kotlin.jvm.functions.Function0
        public CreationExtras invoke() {
            CreationExtras defaultViewModelCreationExtras = this.f415a.requireActivity().getDefaultViewModelCreationExtras();
            Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
            return defaultViewModelCreationExtras;
        }
    }

    public static final class c extends Lambda implements Function0<ViewModelProvider.Factory> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f416a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Fragment fragment) {
            super(0);
            this.f416a = fragment;
        }

        @Override // kotlin.jvm.functions.Function0
        public ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory = this.f416a.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    }

    public static final Lazy<f> a(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        return FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(f.class), new C0041a(fragment), new b(null, fragment), new c(fragment));
    }
}
