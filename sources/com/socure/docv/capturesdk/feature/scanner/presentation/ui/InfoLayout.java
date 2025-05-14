package com.socure.docv.capturesdk.feature.scanner.presentation.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
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

@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!R#\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R#\u0010\f\u001a\n \u0003*\u0004\u0018\u00010\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u000bR#\u0010\u0011\u001a\n \u0003*\u0004\u0018\u00010\r0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0014\u001a\n \u0003*\u0004\u0018\u00010\r0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0010R#\u0010\u0019\u001a\n \u0003*\u0004\u0018\u00010\u00150\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0018¨\u0006\""}, d2 = {"Lcom/socure/docv/capturesdk/feature/scanner/presentation/ui/InfoLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/View;", "kotlin.jvm.PlatformType", "a", "Lkotlin/Lazy;", "getView", "()Landroid/view/View;", "view", "b", "getContainerView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "containerView", "Landroid/widget/TextView;", "c", "getTvPrimaryInfo", "()Landroid/widget/TextView;", "tvPrimaryInfo", "d", "getTvSecondaryInfo", "tvSecondaryInfo", "Landroid/widget/ImageView;", "e", "getImgInfo", "()Landroid/widget/ImageView;", "imgInfo", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Session.JsonKeys.ATTRS, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes5.dex */
public final class InfoLayout extends ConstraintLayout {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Lazy view;

    /* renamed from: b, reason: from kotlin metadata */
    public final Lazy containerView;

    /* renamed from: c, reason: from kotlin metadata */
    public final Lazy tvPrimaryInfo;

    /* renamed from: d, reason: from kotlin metadata */
    public final Lazy tvSecondaryInfo;

    /* renamed from: e, reason: from kotlin metadata */
    public final Lazy imgInfo;

    public static final class a extends Lambda implements Function0<ConstraintLayout> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ConstraintLayout invoke() {
            return (ConstraintLayout) InfoLayout.this.getView().findViewById(R.id.cl_camera_info_container);
        }
    }

    public static final class b extends Lambda implements Function0<ImageView> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ImageView invoke() {
            return (ImageView) InfoLayout.this.getView().findViewById(R.id.imgInfo);
        }
    }

    public static final class c extends Lambda implements Function0<TextView> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) InfoLayout.this.getView().findViewById(R.id.tvPrimaryInfo);
        }
    }

    public static final class d extends Lambda implements Function0<TextView> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) InfoLayout.this.getView().findViewById(R.id.tvSecondaryInfo);
        }
    }

    public static final class e extends Lambda implements Function0<View> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f488a;
        public final /* synthetic */ InfoLayout b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Context context, InfoLayout infoLayout) {
            super(0);
            this.f488a = context;
            this.b = infoLayout;
        }

        @Override // kotlin.jvm.functions.Function0
        public View invoke() {
            return LayoutInflater.from(this.f488a).inflate(R.layout.socure_info_layout, (ViewGroup) this.b, false);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InfoLayout(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InfoLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.view = LazyKt.lazy(new e(context, this));
        this.containerView = LazyKt.lazy(new a());
        this.tvPrimaryInfo = LazyKt.lazy(new c());
        this.tvSecondaryInfo = LazyKt.lazy(new d());
        this.imgInfo = LazyKt.lazy(new b());
        addView(getView());
    }

    public /* synthetic */ InfoLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static /* synthetic */ void a(InfoLayout infoLayout, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        infoLayout.a(str, str2, z);
    }

    private final ConstraintLayout getContainerView() {
        return (ConstraintLayout) this.containerView.getValue();
    }

    private final ImageView getImgInfo() {
        return (ImageView) this.imgInfo.getValue();
    }

    private final TextView getTvPrimaryInfo() {
        return (TextView) this.tvPrimaryInfo.getValue();
    }

    private final TextView getTvSecondaryInfo() {
        return (TextView) this.tvSecondaryInfo.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getView() {
        return (View) this.view.getValue();
    }

    public final void a() {
        getContainerView().setVisibility(8);
        getTvPrimaryInfo().setVisibility(8);
        getImgInfo().setVisibility(8);
        getTvSecondaryInfo().setVisibility(8);
    }

    public final void a(String str, String str2, boolean z) {
        Unit unit;
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_SIL", "primaryText: " + str + " || secondaryText: " + str2 + " || isCaptureSuccess: " + z);
        Unit unit2 = null;
        if (z) {
            getContainerView().setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.socure_info_success_green_bg, null));
            getTvPrimaryInfo().setTextColor(ResourcesCompat.getColor(getResources(), R.color.socure_dark_green, null));
            getImgInfo().setVisibility(0);
            getImgInfo().setImageResource(R.drawable.ic_socure_success_alert);
        } else {
            getImgInfo().setVisibility(8);
            getContainerView().setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.socure_info_msg_bg, null));
            getTvPrimaryInfo().setTextColor(ResourcesCompat.getColor(getResources(), R.color.socure_white, null));
        }
        if (str != null) {
            getTvPrimaryInfo().setVisibility(0);
            getTvPrimaryInfo().setText(str);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            getTvPrimaryInfo().setVisibility(8);
        }
        if (str2 != null) {
            getTvSecondaryInfo().setVisibility(0);
            getTvSecondaryInfo().setText(str2);
            unit2 = Unit.INSTANCE;
        }
        if (unit2 == null) {
            getTvSecondaryInfo().setVisibility(8);
        }
        ConstraintLayout containerView = getContainerView();
        Intrinsics.checkNotNullExpressionValue(containerView, "containerView");
        if (containerView.getVisibility() == 0) {
            return;
        }
        ConstraintLayout containerView2 = getContainerView();
        Intrinsics.checkNotNullExpressionValue(containerView2, "containerView");
        ExtensionsKt.showWithFadeInAnimation(containerView2);
    }
}
