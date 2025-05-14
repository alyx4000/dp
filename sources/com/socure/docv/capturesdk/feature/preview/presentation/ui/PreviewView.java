package com.socure.docv.capturesdk.feature.preview.presentation.ui;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.common.callercontext.ContextChain;
import com.socure.docv.capturesdk.R;
import com.socure.docv.capturesdk.common.utils.ExtensionsKt;
import com.socure.docv.capturesdk.common.utils.HelpPreviewUtils;
import com.socure.docv.capturesdk.common.view.a;
import io.sentry.Session;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u00109\u001a\u000208\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010:\u0012\b\b\u0002\u0010=\u001a\u00020<¢\u0006\u0004\b>\u0010?J\u000f\u0010\u0005\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004R#\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u0011\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0014\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u0010R\u001b\u0010\u0017\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0016\u0010\u0010R\u001b\u0010\u001c\u001a\u00020\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\t\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010!\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001f\u0010 R\u001b\u0010&\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\t\u001a\u0004\b$\u0010%R\u001b\u0010)\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\t\u001a\u0004\b(\u0010 R\u001b\u0010,\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\t\u001a\u0004\b+\u0010 R\u001b\u00101\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\t\u001a\u0004\b/\u00100R\u001b\u00104\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\t\u001a\u0004\b3\u0010 R\u001b\u00107\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\t\u001a\u0004\b6\u0010 ¨\u0006@"}, d2 = {"Lcom/socure/docv/capturesdk/feature/preview/presentation/ui/PreviewView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "getVwShownTime$capturesdk_productionRelease", "()J", "getVwShownTime", "Landroid/view/View;", "kotlin.jvm.PlatformType", "b", "Lkotlin/Lazy;", "getView", "()Landroid/view/View;", "view", "Landroidx/appcompat/widget/AppCompatTextView;", "c", "getPreviewTitleTextView", "()Landroidx/appcompat/widget/AppCompatTextView;", "previewTitleTextView", "d", "getConfirmationTitleTextView", "confirmationTitleTextView", "e", "getConfirmationMsgTextView", "confirmationMsgTextView", "Lcom/socure/docv/capturesdk/feature/preview/presentation/ui/PreviewBottomLayout;", "f", "getPreviewBottomView", "()Lcom/socure/docv/capturesdk/feature/preview/presentation/ui/PreviewBottomLayout;", "previewBottomView", "Landroid/widget/ImageView;", "g", "getPreviewImageView", "()Landroid/widget/ImageView;", "previewImageView", "Landroidx/cardview/widget/CardView;", "h", "getCvImageHolder", "()Landroidx/cardview/widget/CardView;", "cvImageHolder", ContextChain.TAG_INFRA, "getIvDbgPreviewScan", "ivDbgPreviewScan", "j", "getIcSaveImages", "icSaveImages", "Landroid/widget/FrameLayout;", "k", "getFlStatusView", "()Landroid/widget/FrameLayout;", "flStatusView", "l", "getImgStatusBase", "imgStatusBase", "m", "getImgStatusStatus", "imgStatusStatus", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Session.JsonKeys.ATTRS, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes5.dex */
public final class PreviewView extends ConstraintLayout {

    /* renamed from: a, reason: collision with root package name */
    public long f464a;

    /* renamed from: b, reason: from kotlin metadata */
    public final Lazy view;

    /* renamed from: c, reason: from kotlin metadata */
    public final Lazy previewTitleTextView;

    /* renamed from: d, reason: from kotlin metadata */
    public final Lazy confirmationTitleTextView;

    /* renamed from: e, reason: from kotlin metadata */
    public final Lazy confirmationMsgTextView;

    /* renamed from: f, reason: from kotlin metadata */
    public final Lazy previewBottomView;

    /* renamed from: g, reason: from kotlin metadata */
    public final Lazy previewImageView;

    /* renamed from: h, reason: from kotlin metadata */
    public final Lazy cvImageHolder;

    /* renamed from: i, reason: from kotlin metadata */
    public final Lazy ivDbgPreviewScan;

    /* renamed from: j, reason: from kotlin metadata */
    public final Lazy icSaveImages;

    /* renamed from: k, reason: from kotlin metadata */
    public final Lazy flStatusView;

    /* renamed from: l, reason: from kotlin metadata */
    public final Lazy imgStatusBase;

    /* renamed from: m, reason: from kotlin metadata */
    public final Lazy imgStatusStatus;

    public static final class a extends Lambda implements Function0<AppCompatTextView> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppCompatTextView invoke() {
            return (AppCompatTextView) PreviewView.this.getView().findViewById(R.id.tv_confirmation_msg);
        }
    }

    public static final class b extends Lambda implements Function0<AppCompatTextView> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppCompatTextView invoke() {
            return (AppCompatTextView) PreviewView.this.getView().findViewById(R.id.tv_confirmation_title);
        }
    }

    public static final class c extends Lambda implements Function0<CardView> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public CardView invoke() {
            return (CardView) PreviewView.this.getView().findViewById(R.id.cv_image_holder);
        }
    }

    public static final class d extends Lambda implements Function0<FrameLayout> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public FrameLayout invoke() {
            return (FrameLayout) PreviewView.this.getView().findViewById(R.id.fl_status);
        }
    }

    public static final class e extends Lambda implements Function0<ImageView> {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ImageView invoke() {
            return (ImageView) PreviewView.this.getView().findViewById(R.id.ic_save_images);
        }
    }

    public static final class f extends Lambda implements Function0<ImageView> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ImageView invoke() {
            return (ImageView) PreviewView.this.getFlStatusView().findViewById(R.id.img_status_base);
        }
    }

    public static final class g extends Lambda implements Function0<ImageView> {
        public g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ImageView invoke() {
            return (ImageView) PreviewView.this.getFlStatusView().findViewById(R.id.img_status_status);
        }
    }

    public static final class h extends Lambda implements Function0<ImageView> {
        public h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ImageView invoke() {
            return (ImageView) PreviewView.this.getView().findViewById(R.id.iv_dbg_preview_scan);
        }
    }

    public static final class i extends Lambda implements Function0<PreviewBottomLayout> {
        public i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public PreviewBottomLayout invoke() {
            return (PreviewBottomLayout) PreviewView.this.getView().findViewById(R.id.cl_preview_bottom);
        }
    }

    public static final class j extends Lambda implements Function0<ImageView> {
        public j() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public ImageView invoke() {
            return (ImageView) PreviewView.this.getView().findViewById(R.id.img_preview);
        }
    }

    public static final class k extends Lambda implements Function0<AppCompatTextView> {
        public k() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppCompatTextView invoke() {
            return (AppCompatTextView) PreviewView.this.getView().findViewById(R.id.tv_preview_title);
        }
    }

    public static final class l extends Lambda implements Function0<Unit> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.socure.docv.capturesdk.common.view.a f476a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(com.socure.docv.capturesdk.common.view.a aVar) {
            super(0);
            this.f476a = aVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.f476a.a(com.socure.docv.capturesdk.common.view.model.a.DEBUG_IMAGE_SAVE, null);
            return Unit.INSTANCE;
        }
    }

    public static final class m extends Lambda implements Function0<View> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f477a;
        public final /* synthetic */ PreviewView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(Context context, PreviewView previewView) {
            super(0);
            this.f477a = context;
            this.b = previewView;
        }

        @Override // kotlin.jvm.functions.Function0
        public View invoke() {
            return LayoutInflater.from(this.f477a).inflate(R.layout.socure_preview_view, (ViewGroup) this.b, false);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PreviewView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PreviewView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f464a = -1L;
        this.view = LazyKt.lazy(new m(context, this));
        this.previewTitleTextView = LazyKt.lazy(new k());
        this.confirmationTitleTextView = LazyKt.lazy(new b());
        this.confirmationMsgTextView = LazyKt.lazy(new a());
        this.previewBottomView = LazyKt.lazy(new i());
        this.previewImageView = LazyKt.lazy(new j());
        this.cvImageHolder = LazyKt.lazy(new c());
        this.ivDbgPreviewScan = LazyKt.lazy(new h());
        this.icSaveImages = LazyKt.lazy(new e());
        this.flStatusView = LazyKt.lazy(new d());
        this.imgStatusBase = LazyKt.lazy(new f());
        this.imgStatusStatus = LazyKt.lazy(new g());
        addView(getView());
    }

    public /* synthetic */ PreviewView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public static final void a(com.socure.docv.capturesdk.common.view.a previewActionCallback, View view) {
        Intrinsics.checkNotNullParameter(previewActionCallback, "$previewActionCallback");
        view.setEnabled(false);
        previewActionCallback.a(com.socure.docv.capturesdk.common.view.model.a.CONTINUE, null);
    }

    private final AppCompatTextView getConfirmationMsgTextView() {
        Object value = this.confirmationMsgTextView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-confirmationMsgTextView>(...)");
        return (AppCompatTextView) value;
    }

    private final AppCompatTextView getConfirmationTitleTextView() {
        Object value = this.confirmationTitleTextView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-confirmationTitleTextView>(...)");
        return (AppCompatTextView) value;
    }

    private final CardView getCvImageHolder() {
        Object value = this.cvImageHolder.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-cvImageHolder>(...)");
        return (CardView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FrameLayout getFlStatusView() {
        Object value = this.flStatusView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-flStatusView>(...)");
        return (FrameLayout) value;
    }

    private final ImageView getIcSaveImages() {
        Object value = this.icSaveImages.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-icSaveImages>(...)");
        return (ImageView) value;
    }

    private final ImageView getImgStatusBase() {
        Object value = this.imgStatusBase.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-imgStatusBase>(...)");
        return (ImageView) value;
    }

    private final ImageView getImgStatusStatus() {
        Object value = this.imgStatusStatus.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-imgStatusStatus>(...)");
        return (ImageView) value;
    }

    private final ImageView getIvDbgPreviewScan() {
        Object value = this.ivDbgPreviewScan.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-ivDbgPreviewScan>(...)");
        return (ImageView) value;
    }

    private final ImageView getPreviewImageView() {
        Object value = this.previewImageView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-previewImageView>(...)");
        return (ImageView) value;
    }

    private final AppCompatTextView getPreviewTitleTextView() {
        Object value = this.previewTitleTextView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-previewTitleTextView>(...)");
        return (AppCompatTextView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getView() {
        return (View) this.view.getValue();
    }

    public final void a(com.socure.docv.capturesdk.common.view.model.b failureRetryButtonColor, String warningTitle, String str) {
        Unit unit;
        Intrinsics.checkNotNullParameter(failureRetryButtonColor, "failureRetryButtonColor");
        Intrinsics.checkNotNullParameter(warningTitle, "warningTitle");
        getConfirmationTitleTextView().setText(warningTitle);
        if (str != null) {
            getConfirmationMsgTextView().setVisibility(0);
            getConfirmationMsgTextView().setText(str);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            getConfirmationMsgTextView().setVisibility(4);
        }
        getPreviewBottomView().a(failureRetryButtonColor);
    }

    public final void a(com.socure.docv.capturesdk.common.view.model.g previewData, final com.socure.docv.capturesdk.common.view.a previewActionCallback) {
        Intrinsics.checkNotNullParameter(previewData, "previewData");
        Intrinsics.checkNotNullParameter(previewActionCallback, "previewActionCallback");
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_PV", "called setPreviewData");
        CardView cvImageHolder = getCvImageHolder();
        ViewGroup.LayoutParams layoutParams = cvImageHolder.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.dimensionRatio = previewData.f355a;
        cvImageHolder.setLayoutParams(layoutParams2);
        getPreviewTitleTextView().setText(previewData.b.f356a);
        getPreviewTitleTextView().setTextColor(Color.parseColor(previewData.b.b));
        getConfirmationTitleTextView().setTextColor(Color.parseColor(previewData.c.b));
        getConfirmationTitleTextView().setText(previewData.c.f356a);
        getConfirmationMsgTextView().setVisibility(0);
        getConfirmationMsgTextView().setTextColor(Color.parseColor(previewData.d.b));
        getConfirmationMsgTextView().setText(previewData.d.f356a);
        getFlStatusView().setVisibility(8);
        PreviewBottomLayout previewBottomView = getPreviewBottomView();
        com.socure.docv.capturesdk.common.view.model.b bVar = previewData.f;
        previewBottomView.a(bVar.f351a, bVar.b, bVar.d);
        com.socure.docv.capturesdk.common.view.model.b bVar2 = previewData.g;
        previewBottomView.b(bVar2.f351a, bVar2.b, bVar2.c);
        previewBottomView.setContinueListener(new View.OnClickListener() { // from class: com.socure.docv.capturesdk.feature.preview.presentation.ui.PreviewView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PreviewView.a(a.this, view);
            }
        });
        previewBottomView.setRetakeListener(new View.OnClickListener() { // from class: com.socure.docv.capturesdk.feature.preview.presentation.ui.PreviewView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PreviewView.a(PreviewView.this, previewActionCallback, view);
            }
        });
        HelpPreviewUtils.INSTANCE.showPreviewDbgImg$capturesdk_productionRelease(getIvDbgPreviewScan(), getIcSaveImages(), previewData.h, new l(previewActionCallback));
        getPreviewImageView().setImageBitmap(previewData.e);
    }

    public final void a(String label) {
        Intrinsics.checkNotNullParameter(label, "label");
        getConfirmationTitleTextView().setText(label);
        getConfirmationMsgTextView().setVisibility(4);
    }

    public final void a(String baseColor, String logoColor, int i2) {
        Intrinsics.checkNotNullParameter(baseColor, "baseColor");
        Intrinsics.checkNotNullParameter(logoColor, "logoColor");
        getFlStatusView().setVisibility(0);
        getImgStatusStatus().setImageResource(i2);
        ExtensionsKt.setTint(getImgStatusBase(), Color.parseColor(baseColor));
        ExtensionsKt.setTint(getImgStatusStatus(), Color.parseColor(logoColor));
    }

    public final void b(String label) {
        Intrinsics.checkNotNullParameter(label, "label");
        getConfirmationTitleTextView().setText(label);
        getConfirmationMsgTextView().setVisibility(4);
    }

    public final void c(String label) {
        Intrinsics.checkNotNullParameter(label, "label");
        getConfirmationTitleTextView().setText(label);
        getConfirmationMsgTextView().setVisibility(4);
    }

    public final PreviewBottomLayout getPreviewBottomView() {
        Object value = this.previewBottomView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-previewBottomView>(...)");
        return (PreviewBottomLayout) value;
    }

    /* renamed from: getVwShownTime$capturesdk_productionRelease, reason: from getter */
    public final long getF464a() {
        return this.f464a;
    }

    public static final void a(PreviewView this$0, com.socure.docv.capturesdk.common.view.a previewActionCallback, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(previewActionCallback, "$previewActionCallback");
        this$0.getPreviewImageView().setImageBitmap(null);
        this$0.invalidate();
        previewActionCallback.a(com.socure.docv.capturesdk.common.view.model.a.RETAKE, (String) view.getTag());
    }
}
