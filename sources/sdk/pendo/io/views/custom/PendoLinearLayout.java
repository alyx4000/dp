package sdk.pendo.io.views.custom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import external.sdk.pendo.io.glide.RequestBuilder;
import external.sdk.pendo.io.glide.a;
import external.sdk.pendo.io.glide.request.target.CustomTarget;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.utilities.AndroidUtils;

/* loaded from: classes4.dex */
public class PendoLinearLayout extends LinearLayout implements IBackgroundRenderView {
    private int mBackgroundColor;
    private String mBackgroundImageUrl;
    private int mBorderColor;
    int mBorderWidth;
    private float[] mCornerRadii;
    boolean mGotBackgroundColor;
    private String mImageFillType;
    int mLayoutMaxWidth;

    public PendoLinearLayout(Context context) {
        this(context, null);
    }

    void addExtraPaddingIfNeeded() {
        int i = this.mBorderWidth;
        if (i > 0) {
            int i2 = i / 3;
            setPadding(getPaddingLeft() + i2, getPaddingTop() + i2, getPaddingRight() + i2, getPaddingBottom() + i2);
        }
    }

    public String getImageBackgroundImageUrl() {
        return this.mBackgroundImageUrl;
    }

    public String getImageFillType() {
        return this.mImageFillType;
    }

    public int getLayoutMaxWidth() {
        int i = this.mLayoutMaxWidth;
        if (i > 0) {
            return i;
        }
        return Integer.MAX_VALUE;
    }

    public Point getScreenSize() {
        Point point = new Point();
        if (!(getParent() instanceof PendoBannerView)) {
            return AndroidUtils.h();
        }
        point.x = getWidth();
        point.y = getHeight();
        return point;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int i3 = this.mLayoutMaxWidth;
        if (i3 > 0 && i3 >= getMinimumWidth() && this.mLayoutMaxWidth < size) {
            i = View.MeasureSpec.makeMeasureSpec(this.mLayoutMaxWidth, View.MeasureSpec.getMode(i));
        }
        super.onMeasure(i, i2);
    }

    @Override // sdk.pendo.io.views.custom.IBackgroundRenderView
    public void renderBackground() {
        if (this.mBackgroundImageUrl != null) {
            addExtraPaddingIfNeeded();
            setVisibility(4);
            Point screenSize = getScreenSize();
            a.a(this).asBitmap().m1085load(this.mBackgroundImageUrl).override(screenSize.x, screenSize.y).into((RequestBuilder) new CustomTarget<Bitmap>() { // from class: sdk.pendo.io.views.custom.PendoLinearLayout.1
                private void setImageWithDefaultFillType(Bitmap bitmap) {
                    PendoLinearLayout.this.setBackground(new BitmapDrawable(PendoLinearLayout.this.getResources(), bitmap));
                    this.setVisibility(0);
                }

                @Override // external.sdk.pendo.io.glide.request.target.Target
                public void onLoadCleared(Drawable drawable) {
                    this.setVisibility(0);
                }

                @Override // external.sdk.pendo.io.glide.request.target.CustomTarget, external.sdk.pendo.io.glide.request.target.Target
                public void onLoadFailed(Drawable drawable) {
                    PendoLogger.w("Load image background failed mBackgroundImageUrl=" + PendoLinearLayout.this.mBackgroundImageUrl, new Object[0]);
                    this.setVisibility(0);
                }

                public void onResourceReady(Bitmap bitmap, external.sdk.pendo.io.glide.request.transition.a<? super Bitmap> aVar) {
                    PendoLinearLayout pendoLinearLayout = PendoLinearLayout.this;
                    float[] fArr = pendoLinearLayout.mCornerRadii;
                    float f = (fArr == null || fArr.length <= 0) ? 0.0f : fArr[0];
                    if (pendoLinearLayout.mImageFillType != null) {
                        try {
                            View view = this;
                            PendoLinearLayout pendoLinearLayout2 = PendoLinearLayout.this;
                            PendoLinearLayout.this.setBackground(new sdk.pendo.io.o9.a(bitmap, view, pendoLinearLayout2.mImageFillType, pendoLinearLayout2.mBackgroundColor, pendoLinearLayout2.mBorderColor, pendoLinearLayout2.mBorderWidth, f));
                            this.setVisibility(0);
                            return;
                        } catch (IllegalArgumentException unused) {
                        }
                    }
                    setImageWithDefaultFillType(bitmap);
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
            ((GradientDrawable) gradientDrawable.mutate()).setColor(this.mBackgroundColor);
            if (this.mBorderWidth > 0) {
                ((GradientDrawable) gradientDrawable.mutate()).setStroke(this.mBorderWidth, this.mBorderColor);
            }
            if (this.mCornerRadii != null) {
                ((GradientDrawable) gradientDrawable.mutate()).setCornerRadii(this.mCornerRadii);
            }
            setBackground(gradientDrawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.mBackgroundColor = i;
        this.mGotBackgroundColor = true;
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setCornerRadii(float[] fArr) {
        this.mCornerRadii = (float[]) fArr.clone();
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setCornerRadius(float f) {
        this.mCornerRadii = new float[]{f, f, f, f, f, f, f, f};
    }

    @Override // sdk.pendo.io.views.custom.IBackgroundRenderView
    public void setImageBackgroundURL(String str) {
        this.mBackgroundImageUrl = str;
    }

    @Override // sdk.pendo.io.views.custom.IBackgroundRenderView
    public void setImageFillType(String str) {
        this.mImageFillType = str;
    }

    public void setLayoutMaxWidth(int i) {
        this.mLayoutMaxWidth = i;
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setStrokeColor(int i) {
        this.mBorderColor = i;
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setStrokeWidth(int i) {
        this.mBorderWidth = i;
    }

    boolean shouldSetBackgroundColor() {
        return this.mGotBackgroundColor || this.mCornerRadii != null || this.mBorderWidth > 0;
    }

    public PendoLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public PendoLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setWillNotDraw(false);
    }

    public PendoLinearLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        setWillNotDraw(false);
    }
}
