package com.socure.docv.capturesdk.feature.consent.ui;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavArgsLazy;
import androidx.viewbinding.ViewBindings;
import com.socure.docv.capturesdk.common.utils.UtilsKt;
import com.socure.docv.capturesdk.common.view.CustomToolbar;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/socure/docv/capturesdk/feature/consent/ui/ConsentDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes5.dex */
public final class ConsentDialog extends DialogFragment {

    /* renamed from: a, reason: collision with root package name */
    public final NavArgsLazy f424a = new NavArgsLazy(Reflection.getOrCreateKotlinClass(com.socure.docv.capturesdk.feature.consent.ui.a.class), new b(this));

    public static final class a extends WebViewClient {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.socure.docv.capturesdk.databinding.b f425a;

        public a(com.socure.docv.capturesdk.databinding.b bVar) {
            this.f425a = bVar;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            this.f425a.b.setVisibility(8);
        }
    }

    public static final class b extends Lambda implements Function0<Bundle> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f426a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Fragment fragment) {
            super(0);
            this.f426a = fragment;
        }

        @Override // kotlin.jvm.functions.Function0
        public Bundle invoke() {
            Bundle arguments = this.f426a.getArguments();
            if (arguments != null) {
                return arguments;
            }
            throw new IllegalStateException("Fragment " + this.f426a + " has null arguments");
        }
    }

    public static final void a(ConsentDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    public static final boolean a(com.socure.docv.capturesdk.databinding.b binding, View view, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(binding, "$binding");
        if (i != 4 || keyEvent.getAction() != 1 || !binding.c.canGoBack()) {
            return false;
        }
        binding.c.goBack();
        return true;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_CDF", "onCreate");
        setStyle(1, R.style.Theme.WithActionBar);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(com.socure.docv.capturesdk.R.layout.dialog_consent_socure, viewGroup, false);
        int i = com.socure.docv.capturesdk.R.id.cl_consent_toolbar;
        CustomToolbar customToolbar = (CustomToolbar) ViewBindings.findChildViewById(inflate, i);
        if (customToolbar != null) {
            i = com.socure.docv.capturesdk.R.id.pb_web_loading;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(inflate, i);
            if (progressBar != null) {
                i = com.socure.docv.capturesdk.R.id.wv_consent_privacy;
                WebView webView = (WebView) ViewBindings.findChildViewById(inflate, i);
                if (webView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
                    final com.socure.docv.capturesdk.databinding.b bVar = new com.socure.docv.capturesdk.databinding.b(constraintLayout, customToolbar, progressBar, webView);
                    Intrinsics.checkNotNullExpressionValue(bVar, "inflate(inflater, container, false)");
                    customToolbar.a();
                    customToolbar.setCloseListener(new View.OnClickListener() { // from class: com.socure.docv.capturesdk.feature.consent.ui.ConsentDialog$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ConsentDialog.a(ConsentDialog.this, view);
                        }
                    });
                    Context context = getContext();
                    if (context != null) {
                        customToolbar.setToolbarBg(ContextCompat.getColor(context, com.socure.docv.capturesdk.R.color.socure_white));
                    }
                    Context requireContext = requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                    if (UtilsKt.isTalkBackEnabled(requireContext)) {
                        String a2 = ((com.socure.docv.capturesdk.feature.consent.ui.a) this.f424a.getValue()).a();
                        Intrinsics.checkNotNullExpressionValue(a2, "args.closeContentDescription");
                        customToolbar.setCloseContentDescription(a2);
                    }
                    webView.setWebViewClient(new a(bVar));
                    webView.loadUrl(((com.socure.docv.capturesdk.feature.consent.ui.a) this.f424a.getValue()).b());
                    webView.setOnKeyListener(new View.OnKeyListener() { // from class: com.socure.docv.capturesdk.feature.consent.ui.ConsentDialog$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnKeyListener
                        public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                            return ConsentDialog.a(com.socure.docv.capturesdk.databinding.b.this, view, i2, keyEvent);
                        }
                    });
                    return constraintLayout;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }
}
