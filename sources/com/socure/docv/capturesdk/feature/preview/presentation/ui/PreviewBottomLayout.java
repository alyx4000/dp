package com.socure.docv.capturesdk.feature.preview.presentation.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.socure.docv.capturesdk.R;
import com.socure.docv.capturesdk.common.utils.ConstantsKt;
import com.socure.docv.capturesdk.common.utils.ExtensionsKt;
import com.socure.docv.capturesdk.common.utils.HelpPreviewUtils;
import io.sentry.Session;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010'\u001a\u00020&\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R#\u0010\r\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR#\u0010\u0010\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR#\u0010\u0015\u001a\n \b*\u0004\u0018\u00010\u00110\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\u0014R#\u0010\u0018\u001a\n \b*\u0004\u0018\u00010\u00110\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0017\u0010\u0014R#\u0010\u001b\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u001a\u0010\fR#\u0010 \u001a\n \b*\u0004\u0018\u00010\u001c0\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\n\u001a\u0004\b\u001e\u0010\u001fR#\u0010%\u001a\n \b*\u0004\u0018\u00010!0!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\n\u001a\u0004\b#\u0010$¨\u0006."}, d2 = {"Lcom/socure/docv/capturesdk/feature/preview/presentation/ui/PreviewBottomLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/View$OnClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "setRetakeListener", "setContinueListener", "Landroid/view/View;", "kotlin.jvm.PlatformType", "a", "Lkotlin/Lazy;", "getView", "()Landroid/view/View;", "view", "b", "getConfirmationView", "confirmationView", "Landroidx/appcompat/widget/AppCompatButton;", "c", "getBtnContinue", "()Landroidx/appcompat/widget/AppCompatButton;", "btnContinue", "d", "getBtnRetake", "btnRetake", "e", "getProgressView", "progressView", "Landroidx/appcompat/widget/AppCompatTextView;", "f", "getTvProgress", "()Landroidx/appcompat/widget/AppCompatTextView;", "tvProgress", "Landroid/widget/ProgressBar;", "g", "getPbVerification", "()Landroid/widget/ProgressBar;", "pbVerification", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Session.JsonKeys.ATTRS, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes5.dex */
public final class PreviewBottomLayout extends ConstraintLayout {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Lazy view;

    /* renamed from: b, reason: from kotlin metadata */
    public final Lazy confirmationView;

    /* renamed from: c, reason: from kotlin metadata */
    public final Lazy btnContinue;

    /* renamed from: d, reason: from kotlin metadata */
    public final Lazy btnRetake;

    /* renamed from: e, reason: from kotlin metadata */
    public final Lazy progressView;

    /* renamed from: f, reason: from kotlin metadata */
    public final Lazy tvProgress;

    /* renamed from: g, reason: from kotlin metadata */
    public final Lazy pbVerification;
    public ValueAnimator h;

    public static final class a extends Lambda implements Function0<AppCompatButton> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppCompatButton invoke() {
            return (AppCompatButton) PreviewBottomLayout.this.getView().findViewById(R.id.btn_continue);
        }
    }

    public static final class b extends Lambda implements Function0<AppCompatButton> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppCompatButton invoke() {
            return (AppCompatButton) PreviewBottomLayout.this.getView().findViewById(R.id.btn_retake);
        }
    }

    public static final class c extends Lambda implements Function0<View> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public View invoke() {
            return PreviewBottomLayout.this.getView().findViewById(R.id.cl_confirmation);
        }
    }

    public static final class d extends Lambda implements Function0<ProgressBar> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ProgressBar invoke() {
            return (ProgressBar) PreviewBottomLayout.this.getView().findViewById(R.id.pg_verifying);
        }
    }

    public static final class e extends Lambda implements Function0<View> {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public View invoke() {
            return PreviewBottomLayout.this.getView().findViewById(R.id.cl_progress_view);
        }
    }

    public static final class f extends Lambda implements Function0<AppCompatTextView> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppCompatTextView invoke() {
            return (AppCompatTextView) PreviewBottomLayout.this.getView().findViewById(R.id.tv_progress);
        }
    }

    public static final class g extends Lambda implements Function0<View> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f463a;
        public final /* synthetic */ PreviewBottomLayout b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Context context, PreviewBottomLayout previewBottomLayout) {
            super(0);
            this.f463a = context;
            this.b = previewBottomLayout;
        }

        @Override // kotlin.jvm.functions.Function0
        public View invoke() {
            return LayoutInflater.from(this.f463a).inflate(R.layout.socure_preview_bottom_layout, (ViewGroup) this.b, false);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PreviewBottomLayout(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PreviewBottomLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewBottomLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.view = LazyKt.lazy(new g(context, this));
        this.confirmationView = LazyKt.lazy(new c());
        this.btnContinue = LazyKt.lazy(new a());
        this.btnRetake = LazyKt.lazy(new b());
        this.progressView = LazyKt.lazy(new e());
        this.tvProgress = LazyKt.lazy(new f());
        this.pbVerification = LazyKt.lazy(new d());
        addView(getView());
    }

    public /* synthetic */ PreviewBottomLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static final void a(PreviewBottomLayout this$0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        ProgressBar pbVerification = this$0.getPbVerification();
        Object animatedValue = it.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        pbVerification.setProgress(((Integer) animatedValue).intValue(), true);
    }

    private final AppCompatButton getBtnContinue() {
        return (AppCompatButton) this.btnContinue.getValue();
    }

    private final AppCompatButton getBtnRetake() {
        return (AppCompatButton) this.btnRetake.getValue();
    }

    private final View getConfirmationView() {
        return (View) this.confirmationView.getValue();
    }

    private final ProgressBar getPbVerification() {
        return (ProgressBar) this.pbVerification.getValue();
    }

    private final View getProgressView() {
        return (View) this.progressView.getValue();
    }

    private final AppCompatTextView getTvProgress() {
        return (AppCompatTextView) this.tvProgress.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getView() {
        return (View) this.view.getValue();
    }

    public final void a() {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 80);
        this.h = ofInt;
        if (ofInt != null) {
            ofInt.setDuration(ConstantsKt.INITIAL_PROGRESS_DURATION_MS);
        }
        ValueAnimator valueAnimator = this.h;
        if (valueAnimator != null) {
            valueAnimator.setStartDelay(300L);
        }
        ValueAnimator valueAnimator2 = this.h;
        if (valueAnimator2 != null) {
            valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.socure.docv.capturesdk.feature.preview.presentation.ui.PreviewBottomLayout$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    PreviewBottomLayout.a(PreviewBottomLayout.this, valueAnimator3);
                }
            });
        }
        ValueAnimator valueAnimator3 = this.h;
        if (valueAnimator3 != null) {
            valueAnimator3.start();
        }
    }

    public final void a(String successLabel) {
        Intrinsics.checkNotNullParameter(successLabel, "successLabel");
        getTvProgress().setText(successLabel);
        ValueAnimator valueAnimator = this.h;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            ValueAnimator valueAnimator2 = this.h;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
            }
            this.h = null;
        }
        getPbVerification().setProgress(100, true);
    }

    public final void a(String label, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(label, "label");
        getConfirmationView().setVisibility(8);
        getProgressView().setVisibility(0);
        getTvProgress().getBackground().setTint(i);
        getTvProgress().setTextColor(i2);
        getTvProgress().setText(label);
        getPbVerification().setProgress(0);
        Drawable progressDrawable = getPbVerification().getProgressDrawable();
        if (progressDrawable == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
        }
        LayerDrawable layerDrawable = (LayerDrawable) progressDrawable;
        layerDrawable.getDrawable(0).setTint(i4);
        layerDrawable.getDrawable(1).setTint(i3);
        a();
    }

    public final void a(String contBtnText, String color, String str) {
        Intrinsics.checkNotNullParameter(contBtnText, "contBtnText");
        Intrinsics.checkNotNullParameter(color, "color");
        AppCompatButton btnContinue = getBtnContinue();
        Intrinsics.checkNotNullExpressionValue(btnContinue, "btnContinue");
        ExtensionsKt.setupText(btnContinue, contBtnText, color, 0);
        if (str != null) {
            AppCompatButton btnContinue2 = getBtnContinue();
            Intrinsics.checkNotNullExpressionValue(btnContinue2, "btnContinue");
            ExtensionsKt.setCorner(btnContinue2, str, str);
        }
    }

    public final void b(String contBtnText, String color, String str) {
        Intrinsics.checkNotNullParameter(contBtnText, "contBtnText");
        Intrinsics.checkNotNullParameter(color, "color");
        getBtnRetake().setTag("retake_button");
        AppCompatButton btnRetake = getBtnRetake();
        Intrinsics.checkNotNullExpressionValue(btnRetake, "btnRetake");
        ExtensionsKt.setupText$default(btnRetake, contBtnText, color, null, 4, null);
        getBtnRetake().setBackground(null);
        if (str != null) {
            AppCompatButton btnRetake2 = getBtnRetake();
            HelpPreviewUtils helpPreviewUtils = HelpPreviewUtils.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            btnRetake2.setBackground(helpPreviewUtils.getSecondaryButtonDrawable(context, str));
        }
    }

    public final void setContinueListener(View.OnClickListener listener) {
        getBtnContinue().setEnabled(true);
        getBtnContinue().setOnClickListener(listener);
    }

    public final void setRetakeListener(View.OnClickListener listener) {
        getBtnRetake().setOnClickListener(listener);
    }

    public final void a(com.socure.docv.capturesdk.common.view.model.b button) {
        Intrinsics.checkNotNullParameter(button, "button");
        getConfirmationView().setVisibility(0);
        getBtnContinue().setVisibility(8);
        getProgressView().setVisibility(4);
        String str = button.d;
        if (str != null) {
            String str2 = button.f351a;
            String str3 = button.b;
            getBtnRetake().setTag("ivs_retake_button");
            AppCompatButton btnRetake = getBtnRetake();
            Intrinsics.checkNotNullExpressionValue(btnRetake, "btnRetake");
            ExtensionsKt.setupText$default(btnRetake, str2, str3, null, 4, null);
            AppCompatButton btnRetake2 = getBtnRetake();
            Intrinsics.checkNotNullExpressionValue(btnRetake2, "btnRetake");
            ExtensionsKt.setCorner(btnRetake2, str, str);
        }
    }
}
