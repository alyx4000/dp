package com.socure.docv.capturesdk.feature.scanner.presentation.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.socure.docv.capturesdk.R;
import com.socure.docv.capturesdk.common.utils.ExtensionsKt;
import io.sentry.Session;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R#\u0010\u0010\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR#\u0010\u0015\u001a\n \u000b*\u0004\u0018\u00010\u00110\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u0014R#\u0010\u001a\u001a\n \u000b*\u0004\u0018\u00010\u00160\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u0019R*\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006+"}, d2 = {"Lcom/socure/docv/capturesdk/feature/scanner/presentation/ui/ScannerBottomLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/View$OnClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "setManualButtonClickListener", "", "contentDescription", "setManualButtonContentDescription", "setHelpButtonContentDescription", "Landroid/view/View;", "kotlin.jvm.PlatformType", "a", "Lkotlin/Lazy;", "getView", "()Landroid/view/View;", "view", "Landroidx/appcompat/widget/AppCompatButton;", "b", "getBtnHelp", "()Landroidx/appcompat/widget/AppCompatButton;", "btnHelp", "Landroid/widget/ImageView;", "c", "getBtnManual", "()Landroid/widget/ImageView;", "btnManual", "Lkotlin/Function0;", "d", "Lkotlin/jvm/functions/Function0;", "getHelpButtonClickListener", "()Lkotlin/jvm/functions/Function0;", "setHelpButtonClickListener", "(Lkotlin/jvm/functions/Function0;)V", "helpButtonClickListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Session.JsonKeys.ATTRS, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes5.dex */
public final class ScannerBottomLayout extends ConstraintLayout {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Lazy view;

    /* renamed from: b, reason: from kotlin metadata */
    public final Lazy btnHelp;

    /* renamed from: c, reason: from kotlin metadata */
    public final Lazy btnManual;

    /* renamed from: d, reason: from kotlin metadata */
    public Function0<Unit> helpButtonClickListener;

    public static final class a extends Lambda implements Function0<AppCompatButton> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppCompatButton invoke() {
            return (AppCompatButton) ScannerBottomLayout.this.getView().findViewById(R.id.btn_help);
        }
    }

    public static final class b extends Lambda implements Function0<ImageView> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ImageView invoke() {
            return (ImageView) ScannerBottomLayout.this.getView().findViewById(R.id.btn_manual);
        }
    }

    public static final class c extends Lambda implements Function0<View> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f495a;
        public final /* synthetic */ ScannerBottomLayout b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context, ScannerBottomLayout scannerBottomLayout) {
            super(0);
            this.f495a = context;
            this.b = scannerBottomLayout;
        }

        @Override // kotlin.jvm.functions.Function0
        public View invoke() {
            return LayoutInflater.from(this.f495a).inflate(R.layout.socure_scanner_bottom_layout, (ViewGroup) this.b, false);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ScannerBottomLayout(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ScannerBottomLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScannerBottomLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.view = LazyKt.lazy(new c(context, this));
        this.btnHelp = LazyKt.lazy(new a());
        this.btnManual = LazyKt.lazy(new b());
        addView(getView());
        c();
    }

    public /* synthetic */ ScannerBottomLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static final void a(ScannerBottomLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function0<Unit> function0 = this$0.helpButtonClickListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final AppCompatButton getBtnHelp() {
        return (AppCompatButton) this.btnHelp.getValue();
    }

    private final ImageView getBtnManual() {
        return (ImageView) this.btnManual.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getView() {
        return (View) this.view.getValue();
    }

    public final void a() {
        if (getBtnManual().getVisibility() == 0) {
            getBtnManual().setVisibility(8);
        }
    }

    public final boolean b() {
        return getBtnManual().getVisibility() == 0;
    }

    public final void c() {
        getBtnHelp().setOnClickListener(new View.OnClickListener() { // from class: com.socure.docv.capturesdk.feature.scanner.presentation.ui.ScannerBottomLayout$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScannerBottomLayout.a(ScannerBottomLayout.this, view);
            }
        });
    }

    public final void d() {
        if (getBtnHelp().getVisibility() != 0) {
            AppCompatButton btnHelp = getBtnHelp();
            Intrinsics.checkNotNullExpressionValue(btnHelp, "btnHelp");
            ExtensionsKt.showWithFadeInAnimation(btnHelp);
        }
    }

    public final void e() {
        if (getBtnManual().getVisibility() != 0) {
            ImageView btnManual = getBtnManual();
            Intrinsics.checkNotNullExpressionValue(btnManual, "btnManual");
            ExtensionsKt.showWithFadeInAnimation(btnManual);
        }
    }

    public final Function0<Unit> getHelpButtonClickListener() {
        return this.helpButtonClickListener;
    }

    public final void setHelpButtonClickListener(Function0<Unit> function0) {
        this.helpButtonClickListener = function0;
    }

    public final void setHelpButtonContentDescription(String contentDescription) {
        Intrinsics.checkNotNullParameter(contentDescription, "contentDescription");
        getBtnHelp().setContentDescription(contentDescription);
    }

    public final void setManualButtonClickListener(View.OnClickListener listener) {
        getBtnManual().setOnClickListener(listener);
    }

    public final void setManualButtonContentDescription(String contentDescription) {
        Intrinsics.checkNotNullParameter(contentDescription, "contentDescription");
        getBtnManual().setContentDescription(contentDescription);
    }
}
