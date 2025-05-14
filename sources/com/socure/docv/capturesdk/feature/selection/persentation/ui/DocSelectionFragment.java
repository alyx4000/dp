package com.socure.docv.capturesdk.feature.selection.persentation.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.navigation.fragment.FragmentKt;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.socure.docv.capturesdk.R;
import com.socure.docv.capturesdk.api.DocumentType;
import com.socure.docv.capturesdk.common.config.model.DataFlow;
import com.socure.docv.capturesdk.common.logger.b;
import com.socure.docv.capturesdk.common.session.a;
import com.socure.docv.capturesdk.common.utils.ExtensionsKt;
import com.socure.docv.capturesdk.common.utils.Utils;
import com.socure.docv.capturesdk.common.utils.UtilsKt;
import com.socure.docv.capturesdk.common.view.BrandLayout;
import com.socure.docv.capturesdk.common.view.CustomToolbar;
import com.socure.docv.capturesdk.common.view.model.c;
import com.socure.docv.capturesdk.databinding.e;
import com.socure.docv.capturesdk.feature.base.presentation.ui.BaseFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/socure/docv/capturesdk/feature/selection/persentation/ui/DocSelectionFragment;", "Lcom/socure/docv/capturesdk/feature/base/presentation/ui/BaseFragment;", "<init>", "()V", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes5.dex */
public final class DocSelectionFragment extends BaseFragment {
    public ViewBinding m;
    public final boolean n;
    public final String o;

    public DocSelectionFragment() {
        super("SDLT_DSF");
        a aVar = a.f305a;
        this.n = aVar.c().getWebsdk().getShowCameraPriming().getValue();
        this.o = aVar.b().getTheme().getPrimary().getColor();
    }

    public static final void a(DocSelectionFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b.a("SDLT_DSF", "clicked doc lic");
        this$0.a("document_type_selection_id_card", this$0.d());
        this$0.b().a(new DataFlow(Utils.INSTANCE.getLicFlow(a.f305a.c().getWebsdk().getEnableSelfie().getValue())).getScreenSequence());
        this$0.b().a(DocumentType.LICENSE);
        ExtensionsKt.safeNavigate(FragmentKt.findNavController(this$0), this$0.b().a(c.SELECTOR).getForwardNavActionId());
    }

    public static final void b(DocSelectionFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b.a("SDLT_DSF", "clicked doc passport");
        this$0.a("document_type_selection_passport", this$0.d());
        this$0.b().a(new DataFlow(Utils.INSTANCE.getPassportFlow(a.f305a.c().getWebsdk().getEnableSelfie().getValue())).getScreenSequence());
        this$0.b().a(DocumentType.PASSPORT);
        ExtensionsKt.safeNavigate(FragmentKt.findNavController(this$0), this$0.b().a(c.SELECTOR).getForwardNavActionId());
    }

    public static final void c(DocSelectionFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a(c.SELECTOR.a());
    }

    public final void a(View view, View view2) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.socure.docv.capturesdk.feature.selection.persentation.ui.DocSelectionFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                DocSelectionFragment.a(DocSelectionFragment.this, view3);
            }
        });
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.socure.docv.capturesdk.feature.selection.persentation.ui.DocSelectionFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                DocSelectionFragment.b(DocSelectionFragment.this, view3);
            }
        });
    }

    public final void a(TextView textView, TextView textView2, TextView textView3) {
        a aVar = a.f305a;
        ExtensionsKt.setupText$default(textView, aVar.b().getScreens().getPicker().getHeader().getLabel(), this.o, null, 4, null);
        ExtensionsKt.setupText$default(textView2, aVar.b().getScreens().getPicker().getButton().getLicense().getLabel(), this.o, null, 4, null);
        ExtensionsKt.setupText$default(textView3, aVar.b().getScreens().getPicker().getButton().getPassport().getLabel(), this.o, null, 4, null);
    }

    public final void a(CustomToolbar customToolbar) {
        customToolbar.setCloseListener(new View.OnClickListener() { // from class: com.socure.docv.capturesdk.feature.selection.persentation.ui.DocSelectionFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocSelectionFragment.c(DocSelectionFragment.this, view);
            }
        });
        customToolbar.setCloseContentDescription(a.f305a.b().getAccessibility().getCloseBtnContDes());
    }

    public final void a(com.socure.docv.capturesdk.databinding.c cVar) {
        Guideline guideline = cVar.f;
        Intrinsics.checkNotNullExpressionValue(guideline, "binding.glTop");
        a(guideline);
        ConstraintLayout constraintLayout = cVar.d;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.cvLicense");
        ConstraintLayout constraintLayout2 = cVar.e;
        Intrinsics.checkNotNullExpressionValue(constraintLayout2, "binding.cvPassport");
        a(constraintLayout, constraintLayout2);
        CustomToolbar customToolbar = cVar.c;
        Intrinsics.checkNotNullExpressionValue(customToolbar, "binding.clDocSelectionToolbar");
        a(customToolbar);
        cVar.c.a();
        BrandLayout brandLayout = cVar.b;
        Intrinsics.checkNotNullExpressionValue(brandLayout, "binding.brandView");
        a aVar = a.f305a;
        brandLayout.a(UtilsKt.getPowerByLabel(aVar.b().getScreens()), R.drawable.socure_logo_black, R.color.socure_black);
        try {
            AppCompatTextView appCompatTextView = cVar.j;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView, "binding.tvDocTitle");
            AppCompatTextView appCompatTextView2 = cVar.l;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView2, "binding.tvLicTitle");
            AppCompatTextView appCompatTextView3 = cVar.n;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView3, "binding.tvPassportTitle");
            a(appCompatTextView, appCompatTextView2, appCompatTextView3);
            AppCompatTextView appCompatTextView4 = cVar.i;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView4, "binding.tvDocSubtext");
            ExtensionsKt.setupText$default(appCompatTextView4, aVar.b().getNewLabels().getDocSelectSubText(), this.o, null, 4, null);
            AppCompatTextView appCompatTextView5 = cVar.k;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView5, "binding.tvLicSubText");
            ExtensionsKt.setupText$default(appCompatTextView5, aVar.b().getNewLabels().getDocIdSubText(), this.o, null, 4, null);
            AppCompatTextView appCompatTextView6 = cVar.m;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView6, "binding.tvPassportSubText");
            ExtensionsKt.setupText$default(appCompatTextView6, aVar.b().getNewLabels().getDocPassportSubText(), this.o, null, 4, null);
            AppCompatTextView appCompatTextView7 = cVar.h;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView7, "binding.tvDocReady");
            ExtensionsKt.setupText$default(appCompatTextView7, aVar.b().getNewLabels().getDocReady(), this.o, null, 4, null);
            Utils utils = Utils.INSTANCE;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            if (utils.hasCameraPermission(requireContext)) {
                return;
            }
            AppCompatTextView appCompatTextView8 = cVar.g;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView8, "binding.tvCameraAccess");
            ExtensionsKt.setupText$default(appCompatTextView8, aVar.b().getNewLabels().getDocCameraPermission(), this.o, null, 4, null);
        } catch (Throwable th) {
            b.a("SDLT_DSF", "customisation failed: " + th.getLocalizedMessage(), null, 4, null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        if (!this.n) {
            View inflate = inflater.inflate(R.layout.fragment_doc_selection_socure, viewGroup, false);
            int i = R.id.action_lic_id;
            CardView cardView = (CardView) ViewBindings.findChildViewById(inflate, i);
            if (cardView != null) {
                i = R.id.action_passport;
                CardView cardView2 = (CardView) ViewBindings.findChildViewById(inflate, i);
                if (cardView2 != null) {
                    i = R.id.brand_view;
                    BrandLayout brandLayout = (BrandLayout) ViewBindings.findChildViewById(inflate, i);
                    if (brandLayout != null) {
                        i = R.id.btn_lic_id;
                        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(inflate, i);
                        if (appCompatButton != null) {
                            i = R.id.btn_passport;
                            AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(inflate, i);
                            if (appCompatButton2 != null) {
                                i = R.id.cl_doc_selection_Toolbar;
                                CustomToolbar customToolbar = (CustomToolbar) ViewBindings.findChildViewById(inflate, i);
                                if (customToolbar != null) {
                                    i = R.id.glTop;
                                    Guideline guideline = (Guideline) ViewBindings.findChildViewById(inflate, i);
                                    if (guideline != null) {
                                        i = R.id.tvDocTitle;
                                        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(inflate, i);
                                        if (appCompatTextView != null) {
                                            e eVar = new e((ConstraintLayout) inflate, cardView, cardView2, brandLayout, appCompatButton, appCompatButton2, customToolbar, guideline, appCompatTextView);
                                            this.m = eVar;
                                            Intrinsics.checkNotNull(eVar);
                                            a(eVar);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
        }
        View inflate2 = inflater.inflate(R.layout.fragment_camera_prim_doc_selection, viewGroup, false);
        int i2 = R.id.brand_view;
        BrandLayout brandLayout2 = (BrandLayout) ViewBindings.findChildViewById(inflate2, i2);
        if (brandLayout2 != null) {
            i2 = R.id.clContainer;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(inflate2, i2);
            if (constraintLayout != null) {
                i2 = R.id.clContainerInside;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(inflate2, i2);
                if (constraintLayout2 != null) {
                    i2 = R.id.cl_doc_selection_Toolbar;
                    CustomToolbar customToolbar2 = (CustomToolbar) ViewBindings.findChildViewById(inflate2, i2);
                    if (customToolbar2 != null) {
                        i2 = R.id.cvLicense;
                        ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(inflate2, i2);
                        if (constraintLayout3 != null) {
                            i2 = R.id.cvPassport;
                            ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(inflate2, i2);
                            if (constraintLayout4 != null) {
                                i2 = R.id.glTop;
                                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(inflate2, i2);
                                if (guideline2 != null) {
                                    i2 = R.id.imgLicForward;
                                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(inflate2, i2);
                                    if (appCompatImageView != null) {
                                        i2 = R.id.imgPassportForward;
                                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(inflate2, i2);
                                        if (appCompatImageView2 != null) {
                                            i2 = R.id.tvCameraAccess;
                                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(inflate2, i2);
                                            if (appCompatTextView2 != null) {
                                                i2 = R.id.tvDocReady;
                                                AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.findChildViewById(inflate2, i2);
                                                if (appCompatTextView3 != null) {
                                                    i2 = R.id.tvDocSubtext;
                                                    AppCompatTextView appCompatTextView4 = (AppCompatTextView) ViewBindings.findChildViewById(inflate2, i2);
                                                    if (appCompatTextView4 != null) {
                                                        i2 = R.id.tvDocTitle;
                                                        AppCompatTextView appCompatTextView5 = (AppCompatTextView) ViewBindings.findChildViewById(inflate2, i2);
                                                        if (appCompatTextView5 != null) {
                                                            i2 = R.id.tvLicSubText;
                                                            AppCompatTextView appCompatTextView6 = (AppCompatTextView) ViewBindings.findChildViewById(inflate2, i2);
                                                            if (appCompatTextView6 != null) {
                                                                i2 = R.id.tvLicTitle;
                                                                AppCompatTextView appCompatTextView7 = (AppCompatTextView) ViewBindings.findChildViewById(inflate2, i2);
                                                                if (appCompatTextView7 != null) {
                                                                    i2 = R.id.tvPassportSubText;
                                                                    AppCompatTextView appCompatTextView8 = (AppCompatTextView) ViewBindings.findChildViewById(inflate2, i2);
                                                                    if (appCompatTextView8 != null) {
                                                                        i2 = R.id.tvPassportTitle;
                                                                        AppCompatTextView appCompatTextView9 = (AppCompatTextView) ViewBindings.findChildViewById(inflate2, i2);
                                                                        if (appCompatTextView9 != null) {
                                                                            com.socure.docv.capturesdk.databinding.c cVar = new com.socure.docv.capturesdk.databinding.c((ConstraintLayout) inflate2, brandLayout2, constraintLayout, constraintLayout2, customToolbar2, constraintLayout3, constraintLayout4, guideline2, appCompatImageView, appCompatImageView2, appCompatTextView2, appCompatTextView3, appCompatTextView4, appCompatTextView5, appCompatTextView6, appCompatTextView7, appCompatTextView8, appCompatTextView9);
                                                                            this.m = cVar;
                                                                            Intrinsics.checkNotNull(cVar);
                                                                            a(cVar);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate2.getResources().getResourceName(i2)));
        ViewBinding viewBinding = this.m;
        Intrinsics.checkNotNull(viewBinding);
        View root = viewBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.m = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ViewBinding viewBinding = this.m;
        Intrinsics.checkNotNull(viewBinding);
        View findViewById = viewBinding.getRoot().findViewById(R.id.tvDocTitle);
        Intrinsics.checkNotNullExpressionValue(findViewById, "binding.root.findViewByI…extView>(R.id.tvDocTitle)");
        UtilsKt.requestFocusAccessibilityEvent(findViewById);
    }

    public final void a(e eVar) {
        Guideline guideline = eVar.f;
        Intrinsics.checkNotNullExpressionValue(guideline, "binding.glTop");
        a(guideline);
        AppCompatButton appCompatButton = eVar.c;
        Intrinsics.checkNotNullExpressionValue(appCompatButton, "binding.btnLicId");
        AppCompatButton appCompatButton2 = eVar.d;
        Intrinsics.checkNotNullExpressionValue(appCompatButton2, "binding.btnPassport");
        a(appCompatButton, appCompatButton2);
        CustomToolbar customToolbar = eVar.e;
        Intrinsics.checkNotNullExpressionValue(customToolbar, "binding.clDocSelectionToolbar");
        a(customToolbar);
        eVar.e.a();
        BrandLayout brandLayout = eVar.b;
        Intrinsics.checkNotNullExpressionValue(brandLayout, "binding.brandView");
        brandLayout.a(UtilsKt.getPowerByLabel(a.f305a.b().getScreens()), R.drawable.socure_logo_black, R.color.socure_black);
        try {
            AppCompatTextView appCompatTextView = eVar.g;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView, "binding.tvDocTitle");
            AppCompatButton appCompatButton3 = eVar.c;
            Intrinsics.checkNotNullExpressionValue(appCompatButton3, "binding.btnLicId");
            AppCompatButton appCompatButton4 = eVar.d;
            Intrinsics.checkNotNullExpressionValue(appCompatButton4, "binding.btnPassport");
            a(appCompatTextView, appCompatButton3, appCompatButton4);
        } catch (Throwable th) {
            b.a("SDLT_DSF", "customisation failed: " + th.getLocalizedMessage(), null, 4, null);
        }
    }
}
