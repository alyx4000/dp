package sdk.pendo.io.views.custom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.widget.ScrollView;
import com.facebook.react.uimanager.ViewProps;
import external.sdk.pendo.io.glide.RequestBuilder;
import external.sdk.pendo.io.glide.a;
import external.sdk.pendo.io.glide.request.target.CustomTarget;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.g9.q0;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.utilities.AndroidUtils;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020\u0007J\b\u0010#\u001a\u00020$H\u0007J0\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0014J\u0018\u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0007H\u0014J\b\u0010.\u001a\u00020!H\u0016J\b\u0010/\u001a\u00020!H\u0016J\u0010\u00100\u001a\u00020!2\u0006\u00101\u001a\u00020\u0007H\u0016J\u0012\u00102\u001a\u00020!2\b\u00103\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u00104\u001a\u00020!2\u0006\u00105\u001a\u000206H\u0016J\u0010\u00107\u001a\u00020!2\u0006\u00108\u001a\u00020\tH\u0016J\u0010\u00109\u001a\u00020!2\u0006\u0010:\u001a\u00020\tH\u0016J\u0010\u0010;\u001a\u00020!2\u0006\u0010<\u001a\u00020\u0007H\u0016J\u0010\u0010=\u001a\u00020!2\u0006\u0010>\u001a\u00020\u0007H\u0016J\u0010\u0010?\u001a\u00020\u00152\u0006\u0010@\u001a\u00020\u0007H\u0007J\u0006\u0010A\u001a\u00020\u0015R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u000b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\r\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011¨\u0006B"}, d2 = {"Lsdk/pendo/io/views/custom/PendoScrollView;", "Landroid/widget/ScrollView;", "Lsdk/pendo/io/views/custom/IBackgroundRenderView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mBackgroundColor", "", "mBackgroundImageUrl", "", "mBorderColor", "mBorderWidth", "getMBorderWidth$annotations", "()V", "getMBorderWidth", "()I", "setMBorderWidth", "(I)V", "mCornerRadii", "", "mGotBackgroundColor", "", "getMGotBackgroundColor$annotations", "getMGotBackgroundColor", "()Z", "setMGotBackgroundColor", "(Z)V", "mImageFillType", "<set-?>", "mLayoutMaxWidth", "getMLayoutMaxWidth", "setLayoutMaxWidth", "addExtraPaddingIfNeeded", "", "getLayoutMaxWidth", "getScreenSize", "Landroid/graphics/Point;", ViewProps.ON_LAYOUT, "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "renderBackground", "renderView", "setBackgroundColor", "color", "setCornerRadii", "cornerRadii", "setCornerRadius", "cornerRadius", "", "setImageBackgroundURL", "url", "setImageFillType", "fillType", "setStrokeColor", "strokeColor", "setStrokeWidth", "strokeWidth", "shouldApplyPadding", ViewProps.TOP, "shouldSetBackgroundColor", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PendoScrollView extends ScrollView implements IBackgroundRenderView {
    private int mBackgroundColor;
    private String mBackgroundImageUrl;
    private int mBorderColor;
    private int mBorderWidth;
    private float[] mCornerRadii;
    private boolean mGotBackgroundColor;
    private String mImageFillType;
    private int mLayoutMaxWidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PendoScrollView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static /* synthetic */ void getMBorderWidth$annotations() {
    }

    public static /* synthetic */ void getMGotBackgroundColor$annotations() {
    }

    public final void addExtraPaddingIfNeeded() {
        int i = this.mBorderWidth;
        if (i > 0) {
            int i2 = i / 3;
            setPadding(getPaddingLeft() + i2, getPaddingTop() + i2, getPaddingRight() + i2, getPaddingBottom() + i2);
        }
    }

    public final int getLayoutMaxWidth() {
        int i = this.mLayoutMaxWidth;
        if (i > 0) {
            return i;
        }
        return Integer.MAX_VALUE;
    }

    public final int getMBorderWidth() {
        return this.mBorderWidth;
    }

    public final boolean getMGotBackgroundColor() {
        return this.mGotBackgroundColor;
    }

    public final int getMLayoutMaxWidth() {
        return this.mLayoutMaxWidth;
    }

    public final Point getScreenSize() {
        Point point = new Point();
        if (!(getParent() instanceof PendoBannerView)) {
            return AndroidUtils.h();
        }
        point.x = getWidth();
        point.y = getHeight();
        return point;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (Build.VERSION.SDK_INT >= 28 && shouldApplyPadding(t)) {
            setPadding(getPaddingLeft(), getPaddingTop() + q0.c(), getPaddingRight(), getPaddingBottom());
        }
        super.onLayout(changed, l, t, r, b);
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int i = this.mLayoutMaxWidth;
        if (i > 0 && i >= getMinimumWidth() && this.mLayoutMaxWidth < size) {
            widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mLayoutMaxWidth, View.MeasureSpec.getMode(widthMeasureSpec));
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // sdk.pendo.io.views.custom.IBackgroundRenderView
    public void renderBackground() {
        if (this.mBackgroundImageUrl != null) {
            addExtraPaddingIfNeeded();
            setVisibility(4);
            Point screenSize = getScreenSize();
            a.a(this).asBitmap().m1085load(this.mBackgroundImageUrl).override(screenSize.x, screenSize.y).into((RequestBuilder) new CustomTarget<Bitmap>() { // from class: sdk.pendo.io.views.custom.PendoScrollView$renderBackground$1
                @Override // external.sdk.pendo.io.glide.request.target.Target
                public void onLoadCleared(Drawable placeholder) {
                    this.setVisibility(0);
                }

                @Override // external.sdk.pendo.io.glide.request.target.CustomTarget, external.sdk.pendo.io.glide.request.target.Target
                public void onLoadFailed(Drawable errorDrawable) {
                    String str;
                    str = PendoScrollView.this.mBackgroundImageUrl;
                    PendoLogger.w("Load image background failed mBackgroundImageUrl=" + str, new Object[0]);
                    this.setVisibility(0);
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x001d  */
                /* JADX WARN: Removed duplicated region for block: B:17:0x006e  */
                /* JADX WARN: Removed duplicated region for block: B:21:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:25:0x0029  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onResourceReady(android.graphics.Bitmap r11, external.sdk.pendo.io.glide.request.transition.a<? super android.graphics.Bitmap> r12) {
                    /*
                        r10 = this;
                        java.lang.String r12 = "resource"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r12)
                        sdk.pendo.io.views.custom.PendoScrollView r12 = sdk.pendo.io.views.custom.PendoScrollView.this
                        float[] r12 = sdk.pendo.io.views.custom.PendoScrollView.access$getMCornerRadii$p(r12)
                        r0 = 1
                        r1 = 0
                        if (r12 == 0) goto L1a
                        int r12 = r12.length
                        if (r12 != 0) goto L14
                        r12 = r0
                        goto L15
                    L14:
                        r12 = r1
                    L15:
                        r12 = r12 ^ r0
                        if (r12 != r0) goto L1a
                        r12 = r0
                        goto L1b
                    L1a:
                        r12 = r1
                    L1b:
                        if (r12 == 0) goto L29
                        sdk.pendo.io.views.custom.PendoScrollView r12 = sdk.pendo.io.views.custom.PendoScrollView.this
                        float[] r12 = sdk.pendo.io.views.custom.PendoScrollView.access$getMCornerRadii$p(r12)
                        kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
                        r12 = r12[r1]
                        goto L2a
                    L29:
                        r12 = 0
                    L2a:
                        r9 = r12
                        sdk.pendo.io.views.custom.PendoScrollView r12 = sdk.pendo.io.views.custom.PendoScrollView.this
                        java.lang.String r2 = sdk.pendo.io.views.custom.PendoScrollView.access$getMImageFillType$p(r12)
                        if (r2 == 0) goto L3b
                        boolean r2 = kotlin.text.StringsKt.isBlank(r2)
                        if (r2 == 0) goto L3a
                        goto L3b
                    L3a:
                        r0 = r1
                    L3b:
                        if (r0 != 0) goto L6e
                        sdk.pendo.io.o9.a r0 = new sdk.pendo.io.o9.a     // Catch: java.lang.IllegalArgumentException -> L62
                        android.view.View r4 = r2     // Catch: java.lang.IllegalArgumentException -> L62
                        sdk.pendo.io.views.custom.PendoScrollView r2 = sdk.pendo.io.views.custom.PendoScrollView.this     // Catch: java.lang.IllegalArgumentException -> L62
                        java.lang.String r5 = sdk.pendo.io.views.custom.PendoScrollView.access$getMImageFillType$p(r2)     // Catch: java.lang.IllegalArgumentException -> L62
                        kotlin.jvm.internal.Intrinsics.checkNotNull(r5)     // Catch: java.lang.IllegalArgumentException -> L62
                        sdk.pendo.io.views.custom.PendoScrollView r2 = sdk.pendo.io.views.custom.PendoScrollView.this     // Catch: java.lang.IllegalArgumentException -> L62
                        int r6 = sdk.pendo.io.views.custom.PendoScrollView.access$getMBackgroundColor$p(r2)     // Catch: java.lang.IllegalArgumentException -> L62
                        sdk.pendo.io.views.custom.PendoScrollView r2 = sdk.pendo.io.views.custom.PendoScrollView.this     // Catch: java.lang.IllegalArgumentException -> L62
                        int r7 = sdk.pendo.io.views.custom.PendoScrollView.access$getMBorderColor$p(r2)     // Catch: java.lang.IllegalArgumentException -> L62
                        sdk.pendo.io.views.custom.PendoScrollView r2 = sdk.pendo.io.views.custom.PendoScrollView.this     // Catch: java.lang.IllegalArgumentException -> L62
                        int r8 = r2.getMBorderWidth()     // Catch: java.lang.IllegalArgumentException -> L62
                        r2 = r0
                        r3 = r11
                        r2.<init>(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.IllegalArgumentException -> L62
                        goto L79
                    L62:
                        android.graphics.drawable.BitmapDrawable r0 = new android.graphics.drawable.BitmapDrawable
                        sdk.pendo.io.views.custom.PendoScrollView r2 = sdk.pendo.io.views.custom.PendoScrollView.this
                        android.content.res.Resources r2 = r2.getResources()
                        r0.<init>(r2, r11)
                        goto L79
                    L6e:
                        android.graphics.drawable.BitmapDrawable r0 = new android.graphics.drawable.BitmapDrawable
                        sdk.pendo.io.views.custom.PendoScrollView r2 = sdk.pendo.io.views.custom.PendoScrollView.this
                        android.content.res.Resources r2 = r2.getResources()
                        r0.<init>(r2, r11)
                    L79:
                        r12.setBackground(r0)
                        android.view.View r11 = r2
                        r11.setVisibility(r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.views.custom.PendoScrollView$renderBackground$1.onResourceReady(android.graphics.Bitmap, external.sdk.pendo.io.glide.request.transition.a):void");
                }

                @Override // external.sdk.pendo.io.glide.request.target.Target
                public /* bridge */ /* synthetic */ void onResourceReady(Object obj, external.sdk.pendo.io.glide.request.transition.a aVar) {
                    onResourceReady((Bitmap) obj, (external.sdk.pendo.io.glide.request.transition.a<? super Bitmap>) aVar);
                }
            });
        }
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void renderView() {
        if (shouldSetBackgroundColor()) {
            addExtraPaddingIfNeeded();
            GradientDrawable gradientDrawable = new GradientDrawable();
            Drawable mutate = gradientDrawable.mutate();
            Intrinsics.checkNotNull(mutate, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            ((GradientDrawable) mutate).setColor(this.mBackgroundColor);
            if (this.mBorderWidth > 0) {
                Drawable mutate2 = gradientDrawable.mutate();
                Intrinsics.checkNotNull(mutate2, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                ((GradientDrawable) mutate2).setStroke(this.mBorderWidth, this.mBorderColor);
            }
            if (this.mCornerRadii != null) {
                Drawable mutate3 = gradientDrawable.mutate();
                Intrinsics.checkNotNull(mutate3, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                ((GradientDrawable) mutate3).setCornerRadii(this.mCornerRadii);
            }
            setBackground(gradientDrawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int color) {
        this.mBackgroundColor = color;
        this.mGotBackgroundColor = true;
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setCornerRadii(float[] cornerRadii) {
        this.mCornerRadii = cornerRadii != null ? (float[]) cornerRadii.clone() : null;
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setCornerRadius(float cornerRadius) {
        this.mCornerRadii = new float[]{cornerRadius, cornerRadius, cornerRadius, cornerRadius, cornerRadius, cornerRadius, cornerRadius, cornerRadius};
    }

    @Override // sdk.pendo.io.views.custom.IBackgroundRenderView
    public void setImageBackgroundURL(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.mBackgroundImageUrl = url;
    }

    @Override // sdk.pendo.io.views.custom.IBackgroundRenderView
    public void setImageFillType(String fillType) {
        Intrinsics.checkNotNullParameter(fillType, "fillType");
        this.mImageFillType = fillType;
    }

    public final void setLayoutMaxWidth(int i) {
        this.mLayoutMaxWidth = i;
    }

    public final void setMBorderWidth(int i) {
        this.mBorderWidth = i;
    }

    public final void setMGotBackgroundColor(boolean z) {
        this.mGotBackgroundColor = z;
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setStrokeColor(int strokeColor) {
        this.mBorderColor = strokeColor;
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setStrokeWidth(int strokeWidth) {
        this.mBorderWidth = strokeWidth;
    }

    public final boolean shouldApplyPadding(int top) {
        return top + getPaddingTop() < q0.c() && !q0.h(getRootView());
    }

    public final boolean shouldSetBackgroundColor() {
        return this.mGotBackgroundColor || this.mCornerRadii != null || this.mBorderWidth > 0;
    }
}
