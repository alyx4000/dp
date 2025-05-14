package com.socure.docv.capturesdk.feature.scanner.presentation.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.socure.docv.capturesdk.R;
import com.socure.docv.capturesdk.common.utils.ConstantsKt;
import com.socure.docv.capturesdk.common.utils.ExtensionsKt;
import com.socure.docv.capturesdk.feature.scanner.data.GuidingBoxConstraintData;
import io.sentry.Session;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\t¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u001b\u0010\u0011\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0015\u001a\n \u0012*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/socure/docv/capturesdk/feature/scanner/presentation/ui/OverlayLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/View;", "getScannerView", "Lcom/socure/docv/capturesdk/feature/scanner/data/GuidingBoxConstraintData;", "guidingBoxConstraintData", "", "setUpGuidingBoxView", "getGuideView", "", "tintColor", "setGuidingBoxTintColor", "setGuidingBoxData", "a", "Lkotlin/Lazy;", "getView", "()Landroid/view/View;", "view", "kotlin.jvm.PlatformType", "b", "getGuideBoxView", "guideBoxView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Session.JsonKeys.ATTRS, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes5.dex */
public final class OverlayLayout extends ConstraintLayout {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Lazy view;

    /* renamed from: b, reason: from kotlin metadata */
    public final Lazy guideBoxView;

    public static final class a extends Lambda implements Function0<View> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public View invoke() {
            return OverlayLayout.this.getView().findViewById(R.id.vwGuideBox);
        }
    }

    public static final class b extends Lambda implements Function0<View> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public View invoke() {
            return OverlayLayout.this.getScannerView();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OverlayLayout(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OverlayLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlayLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.view = LazyKt.lazy(new b());
        this.guideBoxView = LazyKt.lazy(new a());
    }

    public /* synthetic */ OverlayLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final View getGuideBoxView() {
        return (View) this.guideBoxView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getScannerView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.socure_doc_overlay_view, (ViewGroup) this, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.…verlay_view, this, false)");
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getView() {
        return (View) this.view.getValue();
    }

    private final void setUpGuidingBoxView(GuidingBoxConstraintData guidingBoxConstraintData) {
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_OL", "setUpGuidingBoxView called");
        ViewGroup.LayoutParams layoutParams = getGuideBoxView().getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams2 = layoutParams instanceof ConstraintLayout.LayoutParams ? (ConstraintLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.width = guidingBoxConstraintData.getWidth();
            layoutParams2.dimensionRatio = guidingBoxConstraintData.getDimensionRatio();
            Float matchConstraintPercentWidth = guidingBoxConstraintData.getMatchConstraintPercentWidth();
            if (matchConstraintPercentWidth != null) {
                layoutParams2.matchConstraintPercentWidth = matchConstraintPercentWidth.floatValue();
            }
        } else {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_OL", "guideBoxView.layoutParams is null");
        }
        getGuideBoxView().setBackground(ResourcesCompat.getDrawable(getResources(), guidingBoxConstraintData.getGuidingBoxBgId(), null));
    }

    public final void a() {
        ViewGroup.LayoutParams layoutParams = getGuideBoxView().getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        String str = layoutParams2.dimensionRatio;
        Intrinsics.checkNotNullExpressionValue(str, "lp.dimensionRatio");
        if (Double.parseDouble(str) < 1.0d) {
            layoutParams2.dimensionRatio = ConstantsKt.LICENSE_GUIDING_BOX_RATIO;
            layoutParams2.width = -1;
        } else {
            layoutParams2.dimensionRatio = ConstantsKt.VERTICAL_LICENSE_GUIDING_BOX_RATIO;
            layoutParams2.width = 0;
        }
        layoutParams2.height = 0;
        getGuideBoxView().setLayoutParams(layoutParams2);
    }

    public final void b() {
        if (getGuideBoxView().getVisibility() == 0) {
            getGuideBoxView().setVisibility(8);
        }
    }

    public final boolean c() {
        ViewGroup.LayoutParams layoutParams = getGuideBoxView().getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        String str = ((ConstraintLayout.LayoutParams) layoutParams).dimensionRatio;
        Intrinsics.checkNotNullExpressionValue(str, "guideBoxView.layoutParam…outParams).dimensionRatio");
        return Double.parseDouble(str) < 1.0d;
    }

    public final void d() {
        if (getGuideBoxView().getVisibility() != 0) {
            View guideBoxView = getGuideBoxView();
            Intrinsics.checkNotNullExpressionValue(guideBoxView, "guideBoxView");
            ExtensionsKt.showWithFadeInAnimation(guideBoxView);
        }
    }

    public final View getGuideView() {
        View guideBoxView = getGuideBoxView();
        Intrinsics.checkNotNullExpressionValue(guideBoxView, "guideBoxView");
        return guideBoxView;
    }

    public final void setGuidingBoxData(GuidingBoxConstraintData guidingBoxConstraintData) {
        Intrinsics.checkNotNullParameter(guidingBoxConstraintData, "guidingBoxConstraintData");
        setUpGuidingBoxView(guidingBoxConstraintData);
        addView(getView());
    }

    public final void setGuidingBoxTintColor(int tintColor) {
        getGuideBoxView().setBackgroundTintList(ContextCompat.getColorStateList(getContext(), tintColor));
    }
}
