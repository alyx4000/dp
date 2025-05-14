package com.socure.docv.capturesdk.feature.consent.ui;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.socure.docv.capturesdk.R;
import com.socure.docv.capturesdk.common.network.model.stepup.App;
import com.socure.docv.capturesdk.common.network.model.stepup.Consent;
import com.socure.docv.capturesdk.common.utils.ApiConstant;
import com.socure.docv.capturesdk.common.utils.ExtensionsKt;
import com.socure.docv.capturesdk.common.utils.UtilsKt;
import com.socure.docv.capturesdk.common.view.BrandLayout;
import com.socure.docv.capturesdk.databinding.d;
import com.socure.docv.capturesdk.feature.base.presentation.ui.BaseFragment;
import com.socure.docv.capturesdk.feature.consent.ui.ConsentFragment;
import io.castle.android.api.model.Event;
import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.LinkResolver;
import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.MarkwonSpansFactory;
import io.noties.markwon.RenderProps;
import io.noties.markwon.SpanFactory;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.core.MarkwonTheme;
import io.noties.markwon.core.spans.LinkSpan;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.commonmark.node.Link;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/socure/docv/capturesdk/feature/consent/ui/ConsentFragment;", "Lcom/socure/docv/capturesdk/feature/base/presentation/ui/BaseFragment;", "<init>", "()V", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes5.dex */
public final class ConsentFragment extends BaseFragment {
    public static final /* synthetic */ int n = 0;
    public d m;

    public static final class a extends Lambda implements Function3<String, String, Boolean, Unit> {
        public final /* synthetic */ Consent b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Consent consent) {
            super(3);
            this.b = consent;
        }

        @Override // kotlin.jvm.functions.Function3
        public Unit invoke(String str, String str2, Boolean bool) {
            String id = str;
            String flag = str2;
            boolean booleanValue = bool.booleanValue();
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(flag, "flag");
            ConsentFragment consentFragment = ConsentFragment.this;
            Pair<String, String>[] pairArr = new Pair[6];
            pairArr[0] = new Pair<>("type", "checkbox");
            pairArr[1] = new Pair<>(Event.EVENT_TYPE_SCREEN, "consent");
            pairArr[2] = new Pair<>(ApiConstant.KEY_CODE, booleanValue ? "1" : "0");
            pairArr[3] = new Pair<>("version", this.b.getVersion());
            pairArr[4] = new Pair<>("id", id);
            pairArr[5] = new Pair<>("flag", flag);
            int i = ConsentFragment.n;
            consentFragment.a("clicked", pairArr);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends AbstractMarkwonPlugin {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ App f428a;
        public final /* synthetic */ ConsentFragment b;
        public final /* synthetic */ Consent c;

        public static final class a extends LinkSpan {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ConsentFragment f429a;
            public final /* synthetic */ Consent b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(ConsentFragment consentFragment, Consent consent, MarkwonTheme markwonTheme, String str, LinkResolver linkResolver) {
                super(markwonTheme, str, linkResolver);
                this.f429a = consentFragment;
                this.b = consent;
            }

            @Override // io.noties.markwon.core.spans.LinkSpan, android.text.style.URLSpan, android.text.style.ClickableSpan
            public void onClick(View widget) {
                Intrinsics.checkNotNullParameter(widget, "widget");
                if (!(widget instanceof TextView)) {
                    com.socure.docv.capturesdk.common.logger.b.a("SDLT_CF", "'widget IS NOT TextView' -- THIS SHOULD NOT HAVE HAPPENED!!", null, 4, null);
                    return;
                }
                CharSequence text = ((TextView) widget).getText();
                if (text == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.text.Spanned");
                }
                Spanned spanned = (Spanned) text;
                CharSequence spannedText = UtilsKt.getSpannedText(spanned, spanned.getSpanStart(this), spanned.getSpanEnd(this));
                ConsentFragment consentFragment = this.f429a;
                String link = getLink();
                Intrinsics.checkNotNullExpressionValue(link, "link");
                String obj = spannedText != null ? spannedText.toString() : null;
                String version = this.b.getVersion();
                int i = ConsentFragment.n;
                consentFragment.a(link, obj, version);
            }
        }

        public b(App app, ConsentFragment consentFragment, Consent consent) {
            this.f428a = app;
            this.b = consentFragment;
            this.c = consent;
        }

        public static final Object a(ConsentFragment this$0, Consent consent, MarkwonConfiguration configuration, RenderProps props) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(consent, "$consent");
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            Intrinsics.checkNotNullParameter(props, "props");
            return new a(this$0, consent, configuration.theme(), CoreProps.LINK_DESTINATION.require(props), configuration.linkResolver());
        }

        @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
        public void configureSpansFactory(MarkwonSpansFactory.Builder builder) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            final ConsentFragment consentFragment = this.b;
            final Consent consent = this.c;
            builder.setFactory(Link.class, new SpanFactory() { // from class: com.socure.docv.capturesdk.feature.consent.ui.ConsentFragment$b$$ExternalSyntheticLambda0
                @Override // io.noties.markwon.SpanFactory
                public final Object getSpans(MarkwonConfiguration markwonConfiguration, RenderProps renderProps) {
                    return ConsentFragment.b.a(ConsentFragment.this, consent, markwonConfiguration, renderProps);
                }
            });
        }

        @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
        public void configureTheme(MarkwonTheme.Builder builder) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            builder.linkColor(Color.parseColor(this.f428a.getTheme().getPrimary().getButton().getPrimary().getBackgroundColor()));
            builder.headingBreakHeight(0);
            builder.bulletWidth(15);
        }
    }

    public ConsentFragment() {
        super("SDLT_CF");
    }

    public static final void a(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }

    public static final void a(AlertDialog dialog, App config, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(config, "$config");
        dialog.getButton(-1).setTextColor(Color.parseColor(config.getTheme().getPrimary().getButton().getSecondary().getColor()));
    }

    public static final void a(Consent consent, ConsentFragment this$0, d binding, AlertDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(consent, "$consent");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        if (!consent.allChecked$capturesdk_productionRelease()) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_CF", "agree button was clicked when all mandatory checkboxes were not checked");
            this$0.a("clicked", new Pair<>("type", "agree_button"), new Pair<>(Event.EVENT_TYPE_SCREEN, "consent"), new Pair<>("version", consent.getVersion()), new Pair<>(ApiConstant.KEY_CODE, consent.selectedArray$capturesdk_productionRelease()));
            dialog.show();
        } else {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_CF", "agree clicked");
            this$0.a("consent_accepted", new Pair<>("version", consent.getVersion()), new Pair<>(ApiConstant.KEY_CODE, consent.selectedArray$capturesdk_productionRelease()), new Pair<>(Event.EVENT_TYPE_SCREEN, "consent"), this$0.d());
            binding.e.setVisibility(0);
            this$0.f();
            this$0.b().a(UtilsKt.formConsentRequest(true, consent));
        }
    }

    public static final void a(ConsentFragment this$0, Consent consent, d binding, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(consent, "$consent");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_CF", "decline clicked");
        this$0.a("consent_declined", new Pair<>("version", consent.getVersion()), new Pair<>(ApiConstant.KEY_CODE, consent.selectedArray$capturesdk_productionRelease()), this$0.d());
        this$0.a("error", new Pair<>("type", "consent_declined"), new Pair<>("version", consent.getVersion()), new Pair<>(ApiConstant.KEY_CODE, consent.selectedArray$capturesdk_productionRelease()));
        binding.e.setVisibility(0);
        this$0.f();
        this$0.b().a(UtilsKt.formConsentRequest(false, consent));
    }

    public final void a(String str, String str2, String str3) {
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_CF", "handleLinkClick: " + str + " | " + str2);
        try {
            Pair<String, String>[] pairArr = new Pair[5];
            pairArr[0] = new Pair<>("type", "hyperlink");
            pairArr[1] = new Pair<>(Event.EVENT_TYPE_SCREEN, "consent");
            pairArr[2] = new Pair<>("endpoint", str);
            if (str2 == null) {
                str2 = "null";
            }
            pairArr[3] = new Pair<>("message", str2);
            pairArr[4] = new Pair<>("version", str3);
            a("clicked", pairArr);
            CustomTabColorSchemeParams build = new CustomTabColorSchemeParams.Builder().setToolbarColor(ContextCompat.getColor(requireContext(), R.color.socure_white)).build();
            Intrinsics.checkNotNullExpressionValue(build, "Builder().setToolbarColo…or.socure_white)).build()");
            CustomTabsIntent build2 = new CustomTabsIntent.Builder().setShareState(2).setDefaultColorSchemeParams(build).build();
            Intrinsics.checkNotNullExpressionValue(build2, "builder.setShareState(Cu…omTabColorParams).build()");
            build2.launchUrl(requireContext(), Uri.parse(str));
        } catch (Throwable th) {
            if (!(th instanceof ActivityNotFoundException)) {
                com.socure.docv.capturesdk.common.logger.b.a("SDLT_CF", "updateHyperLink error: " + th.getLocalizedMessage(), null, 4, null);
                return;
            }
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_CF", "updateHyperLink error: ActivityNotFoundException", null, 4, null);
            NavController findNavController = FragmentKt.findNavController(this);
            com.socure.docv.capturesdk.feature.consent.ui.b bVar = new com.socure.docv.capturesdk.feature.consent.ui.b(str, com.socure.docv.capturesdk.common.session.a.f305a.b().getAccessibility().getCloseBtnContDes());
            Intrinsics.checkNotNullExpressionValue(bVar, "actionConsentPrivacyDial…sibility.closeBtnContDes)");
            ExtensionsKt.safeNavigate(findNavController, bVar);
        }
    }

    public final void f() {
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_CF", "announcementConsentProcess called");
        d dVar = this.m;
        Intrinsics.checkNotNull(dVar);
        dVar.e.announceForAccessibility(com.socure.docv.capturesdk.common.session.a.f305a.b().getAccessibility().getProcessingConsent());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_consent_socure, viewGroup, false);
        int i = R.id.brand_view;
        BrandLayout brandLayout = (BrandLayout) ViewBindings.findChildViewById(inflate, i);
        if (brandLayout != null) {
            i = R.id.btn_agree;
            AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(inflate, i);
            if (appCompatButton != null) {
                i = R.id.btn_decline;
                AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(inflate, i);
                if (appCompatButton2 != null) {
                    i = R.id.cl_progress_view;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(inflate, i);
                    if (constraintLayout != null) {
                        i = R.id.consent_bottom;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(inflate, i);
                        if (constraintLayout2 != null) {
                            i = R.id.gl_top;
                            Guideline guideline = (Guideline) ViewBindings.findChildViewById(inflate, i);
                            if (guideline != null) {
                                i = R.id.img_brand_logo;
                                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(inflate, i);
                                if (appCompatImageView != null) {
                                    i = R.id.pb_consent_call;
                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(inflate, i);
                                    if (progressBar != null) {
                                        i = R.id.rv_contents;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(inflate, i);
                                        if (recyclerView != null) {
                                            i = R.id.tv_consent_header;
                                            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(inflate, i);
                                            if (appCompatTextView != null) {
                                                d dVar = new d((ConstraintLayout) inflate, brandLayout, appCompatButton, appCompatButton2, constraintLayout, constraintLayout2, guideline, appCompatImageView, progressBar, recyclerView, appCompatTextView);
                                                this.m = dVar;
                                                Intrinsics.checkNotNull(dVar);
                                                Intrinsics.checkNotNullExpressionValue(guideline, "binding.glTop");
                                                a(guideline);
                                                d dVar2 = this.m;
                                                Intrinsics.checkNotNull(dVar2);
                                                App b2 = com.socure.docv.capturesdk.common.session.a.f305a.b();
                                                Consent consent = com.socure.docv.capturesdk.common.session.a.n;
                                                if (consent == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException("consentData");
                                                    consent = null;
                                                }
                                                a(dVar2, b2, consent);
                                                d dVar3 = this.m;
                                                Intrinsics.checkNotNull(dVar3);
                                                ConstraintLayout constraintLayout3 = dVar3.f397a;
                                                Intrinsics.checkNotNullExpressionValue(constraintLayout3, "binding.root");
                                                return constraintLayout3;
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
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.m = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        d dVar = this.m;
        Intrinsics.checkNotNull(dVar);
        AppCompatTextView appCompatTextView = dVar.h;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "binding.tvConsentHeader");
        UtilsKt.requestFocusAccessibilityEvent(appCompatTextView);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(final com.socure.docv.capturesdk.databinding.d r23, final com.socure.docv.capturesdk.common.network.model.stepup.App r24, com.socure.docv.capturesdk.common.network.model.stepup.Consent r25) {
        /*
            Method dump skipped, instructions count: 463
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.socure.docv.capturesdk.feature.consent.ui.ConsentFragment.a(com.socure.docv.capturesdk.databinding.d, com.socure.docv.capturesdk.common.network.model.stepup.App, com.socure.docv.capturesdk.common.network.model.stepup.Consent):void");
    }
}
