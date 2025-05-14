package com.quantummetric.ui.internal;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.facebook.react.uimanager.ViewProps;
import io.sentry.protocol.ViewHierarchyNode;
import java.text.DecimalFormat;

/* loaded from: classes5.dex */
final class au extends dg {
    int A;
    int B;
    int C;
    int D;
    boolean E;
    private boolean G;
    private ImageView.ScaleType H;

    /* renamed from: com.quantummetric.instrument.internal.au$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f70a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f70a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f70a[ImageView.ScaleType.FIT_XY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    au(View view) {
        super(view);
        this.G = true;
        this.E = false;
    }

    private String a(int i) {
        return (i <= 0 || !this.G) ? "100%" : "calc(100% - " + i + "px)";
    }

    @Override // com.quantummetric.ui.internal.dg, com.quantummetric.ui.internal.b
    public final void a(ar arVar) {
        String str = !de.b(this.e.m) ? this.e.m : "";
        if (this.w) {
            super.a(arVar);
        } else {
            arVar.a((ar) "<img src=\"").a((ar) str).a((ar) "\" style=\"").a((ar) t()).a((ar) "\" class=\"i\"></img>");
        }
    }

    @Override // com.quantummetric.ui.internal.dg
    final boolean a(Drawable drawable) {
        boolean z = drawable instanceof ah;
        if (z && (this.e instanceof cs)) {
            ((cs) this.e).q = true;
        }
        return z;
    }

    @Override // com.quantummetric.ui.internal.dg, com.quantummetric.ui.internal.b
    public final void j() {
        super.j();
        View view = this.F.get();
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            ImageView.ScaleType scaleType = imageView.getScaleType();
            this.H = scaleType;
            boolean z = true;
            if (scaleType == ImageView.ScaleType.FIT_XY) {
                this.G = !bz.a().b(imageView.getDrawable());
            } else if (this.H == ImageView.ScaleType.MATRIX && (imageView.getDrawable() instanceof BitmapDrawable)) {
                Drawable drawable = imageView.getDrawable();
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicWidth * intrinsicHeight * imageView.getWidth() * imageView.getHeight() <= 0 || (intrinsicWidth <= imageView.getWidth() && intrinsicHeight <= imageView.getHeight())) {
                    z = false;
                }
                this.E = z;
            }
            this.A = imageView.getPaddingLeft();
            this.B = imageView.getPaddingTop();
            this.C = imageView.getPaddingRight();
            this.D = imageView.getPaddingBottom();
            if (imageView.getDrawable() != null) {
                if (this.H == ImageView.ScaleType.CENTER || this.H == ImageView.ScaleType.CENTER_INSIDE) {
                    int intrinsicWidth2 = imageView.getDrawable().getIntrinsicWidth();
                    int intrinsicHeight2 = imageView.getDrawable().getIntrinsicHeight();
                    if (intrinsicWidth2 <= 0 || intrinsicHeight2 <= 0) {
                        return;
                    }
                    int width = imageView.getWidth() - intrinsicWidth2;
                    int i = this.A;
                    int i2 = this.C;
                    int i3 = (width - i) - i2;
                    if (i3 > 0) {
                        int i4 = i3 / 2;
                        this.A = i + i4;
                        this.C = i2 + i4;
                    }
                    int height = imageView.getHeight() - intrinsicHeight2;
                    int i5 = this.B;
                    int i6 = this.D;
                    int i7 = (height - i5) - i6;
                    if (i7 > 0) {
                        int i8 = i7 / 2;
                        this.B = i5 + i8;
                        this.D = i6 + i8;
                    }
                }
            }
        }
    }

    @Override // com.quantummetric.ui.internal.b
    public final void l() {
        int i;
        super.l();
        if (!(this.e instanceof cs) || (i = ((cs) this.e).o) == 255) {
            return;
        }
        this.v.f65a.append(ViewProps.OPACITY).append(":").append((Object) new DecimalFormat("#0.00").format(i / 255.0f)).append(";");
    }

    final String t() {
        ar arVar = new ar();
        int b = de.b(this.A + this.C);
        int b2 = de.b(this.B + this.D);
        int i = AnonymousClass1.f70a[this.H.ordinal()];
        String str = i != 1 ? i != 2 ? "" : "fill" : "cover";
        boolean z = (this.e instanceof cs) && de.b(this.e.m);
        arVar.f65a.append(aa.af).append(":").append((Object) a(b)).append(";");
        return arVar.a(aa.ae, a(b2), !this.E).a(aa.ag, Integer.valueOf(de.b(this.A)), aa.f, this.A > 0).a(aa.ah, Integer.valueOf(de.b(this.B)), aa.f, this.B > 0).a("object-fit", str, !de.b(str)).a(ViewHierarchyNode.JsonKeys.VISIBILITY, aa.ab, z).toString();
    }
}
