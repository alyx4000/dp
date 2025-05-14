package com.socure.docv.capturesdk.feature.scanner.presentation.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.socure.docv.capturesdk.R;
import com.socure.docv.capturesdk.common.utils.Utils;
import com.socure.docv.capturesdk.core.pipeline.model.ScanType;
import io.sentry.Session;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R#\u0010\r\u001a\n \t*\u0004\u0018\u00010\b0\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\fR#\u0010\u0012\u001a\n \t*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0011R#\u0010\u0015\u001a\n \t*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/socure/docv/capturesdk/feature/scanner/presentation/ui/ScannerHelpGraphic;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/View;", "b", "Lkotlin/Lazy;", "getView", "()Landroid/view/View;", "view", "Landroidx/appcompat/widget/AppCompatImageView;", "kotlin.jvm.PlatformType", "c", "getHelpGraphic", "()Landroidx/appcompat/widget/AppCompatImageView;", "helpGraphic", "Landroidx/appcompat/widget/AppCompatTextView;", "d", "getTitle", "()Landroidx/appcompat/widget/AppCompatTextView;", "title", "e", "getMessage", "message", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Session.JsonKeys.ATTRS, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes5.dex */
public final class ScannerHelpGraphic extends ConstraintLayout {
    public static final /* synthetic */ int f = 0;

    /* renamed from: a, reason: collision with root package name */
    public ScanType f511a;

    /* renamed from: b, reason: from kotlin metadata */
    public final Lazy view;

    /* renamed from: c, reason: from kotlin metadata */
    public final Lazy helpGraphic;

    /* renamed from: d, reason: from kotlin metadata */
    public final Lazy title;

    /* renamed from: e, reason: from kotlin metadata */
    public final Lazy message;

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f512a;

        static {
            int[] iArr = new int[ScanType.values().length];
            iArr[ScanType.LICENSE_FRONT.ordinal()] = 1;
            iArr[ScanType.LICENSE_BACK.ordinal()] = 2;
            iArr[ScanType.PASSPORT.ordinal()] = 3;
            iArr[ScanType.SELFIE.ordinal()] = 4;
            f512a = iArr;
        }
    }

    public static final class b extends Lambda implements Function0<AppCompatImageView> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppCompatImageView invoke() {
            return (AppCompatImageView) ScannerHelpGraphic.this.getView().findViewById(R.id.iv_help_graphic_view);
        }
    }

    public static final class c extends Lambda implements Function0<AppCompatTextView> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppCompatTextView invoke() {
            return (AppCompatTextView) ScannerHelpGraphic.this.getView().findViewById(R.id.tv_scan_help_msg);
        }
    }

    public static final class d extends Lambda implements Function0<AppCompatTextView> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppCompatTextView invoke() {
            return (AppCompatTextView) ScannerHelpGraphic.this.getView().findViewById(R.id.tv_scan_help_title);
        }
    }

    public static final class e extends Lambda implements Function0<View> {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public View invoke() {
            ScannerHelpGraphic scannerHelpGraphic = ScannerHelpGraphic.this;
            int i = ScannerHelpGraphic.f;
            View inflate = LayoutInflater.from(scannerHelpGraphic.getContext()).inflate(R.layout.socure_scanner_help_overlay, (ViewGroup) scannerHelpGraphic, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(context)\n          …elp_overlay, this, false)");
            return inflate;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ScannerHelpGraphic(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ScannerHelpGraphic(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScannerHelpGraphic(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.view = LazyKt.lazy(new e());
        this.helpGraphic = LazyKt.lazy(new b());
        this.title = LazyKt.lazy(new d());
        this.message = LazyKt.lazy(new c());
    }

    public /* synthetic */ ScannerHelpGraphic(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final AppCompatImageView getHelpGraphic() {
        return (AppCompatImageView) this.helpGraphic.getValue();
    }

    private final AppCompatTextView getMessage() {
        return (AppCompatTextView) this.message.getValue();
    }

    private final AppCompatTextView getTitle() {
        return (AppCompatTextView) this.title.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getView() {
        return (View) this.view.getValue();
    }

    public final void a(ScanType scanType, String title, String message) {
        int i;
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(message, "message");
        this.f511a = scanType;
        Utils utils = Utils.INSTANCE;
        ScanType scanType2 = null;
        if (scanType == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanType");
            scanType = null;
        }
        if (utils.isSelfie$capturesdk_productionRelease(scanType)) {
            ViewGroup.LayoutParams layoutParams = getHelpGraphic().getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            int dimension = (int) getResources().getDimension(R.dimen.selfie_help_graphic_margin_socure);
            layoutParams2.setMarginStart(dimension);
            layoutParams2.setMarginEnd(dimension);
        }
        AppCompatImageView helpGraphic = getHelpGraphic();
        ScanType scanType3 = this.f511a;
        if (scanType3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanType");
        } else {
            scanType2 = scanType3;
        }
        int i2 = a.f512a[scanType2.ordinal()];
        if (i2 == 1) {
            i = R.drawable.socure_scanner_help_graphic_front;
        } else if (i2 == 2) {
            i = R.drawable.socure_scanner_help_graphic_back;
        } else if (i2 == 3) {
            i = R.drawable.socure_scanner_help_graphic_passport;
        } else {
            if (i2 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            i = R.drawable.socure_scanner_help_graphic_selfie;
        }
        helpGraphic.setImageResource(i);
        getTitle().setText(title);
        getMessage().setText(message);
        addView(getView());
    }
}
