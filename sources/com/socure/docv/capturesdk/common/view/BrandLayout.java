package com.socure.docv.capturesdk.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.socure.docv.capturesdk.R;
import io.sentry.Session;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R#\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR#\u0010\u0011\u001a\n \u0007*\u0004\u0018\u00010\r0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0016\u001a\n \u0007*\u0004\u0018\u00010\u00120\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/socure/docv/capturesdk/common/view/BrandLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "resId", "", "setImgBrandLogo", "Landroid/view/View;", "kotlin.jvm.PlatformType", "a", "Lkotlin/Lazy;", "getView", "()Landroid/view/View;", "view", "Landroidx/appcompat/widget/AppCompatTextView;", "b", "getTvPoweredBy", "()Landroidx/appcompat/widget/AppCompatTextView;", "tvPoweredBy", "Landroid/widget/ImageView;", "c", "getImgBrandLogo", "()Landroid/widget/ImageView;", "imgBrandLogo", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Session.JsonKeys.ATTRS, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes5.dex */
public final class BrandLayout extends ConstraintLayout {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Lazy view;

    /* renamed from: b, reason: from kotlin metadata */
    public final Lazy tvPoweredBy;

    /* renamed from: c, reason: from kotlin metadata */
    public final Lazy imgBrandLogo;

    public static final class a extends Lambda implements Function0<ImageView> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ImageView invoke() {
            return (ImageView) BrandLayout.this.getView().findViewById(R.id.img_brand_logo);
        }
    }

    public static final class b extends Lambda implements Function0<AppCompatTextView> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppCompatTextView invoke() {
            return (AppCompatTextView) BrandLayout.this.getView().findViewById(R.id.tv_powered_by);
        }
    }

    public static final class c extends Lambda implements Function0<View> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f338a;
        public final /* synthetic */ BrandLayout b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context, BrandLayout brandLayout) {
            super(0);
            this.f338a = context;
            this.b = brandLayout;
        }

        @Override // kotlin.jvm.functions.Function0
        public View invoke() {
            return LayoutInflater.from(this.f338a).inflate(R.layout.socure_brand_layout, (ViewGroup) this.b, false);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BrandLayout(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BrandLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrandLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.view = LazyKt.lazy(new c(context, this));
        this.tvPoweredBy = LazyKt.lazy(new b());
        this.imgBrandLogo = LazyKt.lazy(new a());
        addView(getView());
    }

    public /* synthetic */ BrandLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final ImageView getImgBrandLogo() {
        return (ImageView) this.imgBrandLogo.getValue();
    }

    private final AppCompatTextView getTvPoweredBy() {
        return (AppCompatTextView) this.tvPoweredBy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getView() {
        return (View) this.view.getValue();
    }

    private final void setImgBrandLogo(int resId) {
        getImgBrandLogo().setImageResource(resId);
    }

    public final void a(String powerByLabel, int i, int i2) {
        Intrinsics.checkNotNullParameter(powerByLabel, "powerByLabel");
        getTvPoweredBy().setText(powerByLabel);
        getTvPoweredBy().setTextColor(ContextCompat.getColor(getContext(), i2));
        setImgBrandLogo(i);
    }
}
