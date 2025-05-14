package com.socure.docv.capturesdk.common.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.socure.docv.capturesdk.R;
import io.sentry.Session;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010+\u001a\u00020*\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,\u0012\b\b\u0002\u0010.\u001a\u00020\u000f¢\u0006\u0004\b/\u00100J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u000b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fR#\u0010\u0018\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001c\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010!\u001a\u00020\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010 R#\u0010&\u001a\n \u0013*\u0004\u0018\u00010\"0\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0015\u001a\u0004\b$\u0010%R#\u0010)\u001a\n \u0013*\u0004\u0018\u00010\"0\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0015\u001a\u0004\b(\u0010%¨\u00061"}, d2 = {"Lcom/socure/docv/capturesdk/common/view/CustomToolbar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "title", "", "setTitle", "color", "setTitleColor", "Landroid/view/View$OnClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setCloseListener", "setBackListener", "contentDescription", "setBackContentDescription", "setCloseContentDescription", "", "colorString", "setToolbarBg", "Landroid/view/View;", "kotlin.jvm.PlatformType", "a", "Lkotlin/Lazy;", "getView", "()Landroid/view/View;", "view", "b", "getClToolbarView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "clToolbarView", "Landroidx/appcompat/widget/AppCompatTextView;", "c", "getTvInfoTitle", "()Landroidx/appcompat/widget/AppCompatTextView;", "tvInfoTitle", "Landroidx/appcompat/widget/AppCompatImageView;", "d", "getBtnClose", "()Landroidx/appcompat/widget/AppCompatImageView;", "btnClose", "e", "getBtnBack", "btnBack", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Session.JsonKeys.ATTRS, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes5.dex */
public final class CustomToolbar extends ConstraintLayout {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Lazy view;

    /* renamed from: b, reason: from kotlin metadata */
    public final Lazy clToolbarView;

    /* renamed from: c, reason: from kotlin metadata */
    public final Lazy tvInfoTitle;

    /* renamed from: d, reason: from kotlin metadata */
    public final Lazy btnClose;

    /* renamed from: e, reason: from kotlin metadata */
    public final Lazy btnBack;

    public static final class a extends Lambda implements Function0<AppCompatImageView> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppCompatImageView invoke() {
            return (AppCompatImageView) CustomToolbar.this.getView().findViewById(R.id.btnBack);
        }
    }

    public static final class b extends Lambda implements Function0<AppCompatImageView> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppCompatImageView invoke() {
            return (AppCompatImageView) CustomToolbar.this.getView().findViewById(R.id.btnClose);
        }
    }

    public static final class c extends Lambda implements Function0<ConstraintLayout> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ConstraintLayout invoke() {
            return (ConstraintLayout) CustomToolbar.this.getView().findViewById(R.id.clToolbarView);
        }
    }

    public static final class d extends Lambda implements Function0<AppCompatTextView> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppCompatTextView invoke() {
            return (AppCompatTextView) CustomToolbar.this.getView().findViewById(R.id.tvInfoTitle);
        }
    }

    public static final class e extends Lambda implements Function0<View> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f344a;
        public final /* synthetic */ CustomToolbar b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Context context, CustomToolbar customToolbar) {
            super(0);
            this.f344a = context;
            this.b = customToolbar;
        }

        @Override // kotlin.jvm.functions.Function0
        public View invoke() {
            return LayoutInflater.from(this.f344a).inflate(R.layout.socure_custom_toolbar, (ViewGroup) this.b, false);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomToolbar(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomToolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomToolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.view = LazyKt.lazy(new e(context, this));
        this.clToolbarView = LazyKt.lazy(new c());
        this.tvInfoTitle = LazyKt.lazy(new d());
        this.btnClose = LazyKt.lazy(new b());
        this.btnBack = LazyKt.lazy(new a());
        addView(getView());
    }

    public /* synthetic */ CustomToolbar(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final AppCompatImageView getBtnBack() {
        return (AppCompatImageView) this.btnBack.getValue();
    }

    private final AppCompatImageView getBtnClose() {
        return (AppCompatImageView) this.btnClose.getValue();
    }

    private final ConstraintLayout getClToolbarView() {
        Object value = this.clToolbarView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-clToolbarView>(...)");
        return (ConstraintLayout) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getView() {
        return (View) this.view.getValue();
    }

    private final void setTitle(String title) {
        getTvInfoTitle().setText(title);
    }

    private final void setTitleColor(String color) {
        getTvInfoTitle().setTextColor(Color.parseColor(color));
    }

    public final void a() {
        getBtnBack().setVisibility(4);
        getBtnBack().setOnClickListener(null);
    }

    public final void a(String str, String str2) {
        if (str != null) {
            setTitle(str);
            getTvInfoTitle().setVisibility(0);
        }
        if (str2 != null) {
            setTitleColor(str2);
        }
    }

    public final AppCompatTextView getTvInfoTitle() {
        Object value = this.tvInfoTitle.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-tvInfoTitle>(...)");
        return (AppCompatTextView) value;
    }

    public final void setBackContentDescription(String contentDescription) {
        Intrinsics.checkNotNullParameter(contentDescription, "contentDescription");
        getBtnBack().setContentDescription(contentDescription);
    }

    public final void setBackListener(View.OnClickListener listener) {
        getBtnBack().setOnClickListener(listener);
    }

    public final void setCloseContentDescription(String contentDescription) {
        Intrinsics.checkNotNullParameter(contentDescription, "contentDescription");
        getBtnClose().setContentDescription(contentDescription);
    }

    public final void setCloseListener(View.OnClickListener listener) {
        getBtnClose().setOnClickListener(listener);
    }

    public final void setToolbarBg(int colorString) {
        getClToolbarView().setBackgroundColor(colorString);
    }
}
