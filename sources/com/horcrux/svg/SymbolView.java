package com.horcrux.svg;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.facebook.react.bridge.ReactContext;

/* loaded from: classes5.dex */
class SymbolView extends GroupView {
    private String mAlign;
    private int mMeetOrSlice;
    private float mMinX;
    private float mMinY;
    private float mVbHeight;
    private float mVbWidth;

    public SymbolView(ReactContext reactContext) {
        super(reactContext);
    }

    public void setMinX(float f) {
        this.mMinX = f;
        invalidate();
    }

    public void setMinY(float f) {
        this.mMinY = f;
        invalidate();
    }

    public void setVbWidth(float f) {
        this.mVbWidth = f;
        invalidate();
    }

    public void setVbHeight(float f) {
        this.mVbHeight = f;
        invalidate();
    }

    public void setAlign(String str) {
        this.mAlign = str;
        invalidate();
    }

    public void setMeetOrSlice(int i) {
        this.mMeetOrSlice = i;
        invalidate();
    }

    @Override // com.horcrux.svg.GroupView, com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    void draw(Canvas canvas, Paint paint, float f) {
        saveDefinition();
    }

    void drawSymbol(Canvas canvas, Paint paint, float f, float f2, float f3) {
        if (this.mAlign != null) {
            canvas.concat(ViewBox.getTransform(new RectF(this.mMinX * this.mScale, this.mMinY * this.mScale, (this.mMinX + this.mVbWidth) * this.mScale, (this.mMinY + this.mVbHeight) * this.mScale), new RectF(0.0f, 0.0f, f2, f3), this.mAlign, this.mMeetOrSlice));
            super.draw(canvas, paint, f);
        }
    }
}
