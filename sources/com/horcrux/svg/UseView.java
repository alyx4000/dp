package com.horcrux.svg;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.ReactConstants;

/* loaded from: classes5.dex */
class UseView extends RenderableView {
    private SVGLength mH;
    private String mHref;
    private SVGLength mW;
    private SVGLength mX;
    private SVGLength mY;

    public UseView(ReactContext reactContext) {
        super(reactContext);
    }

    public void setHref(String str) {
        this.mHref = str;
        invalidate();
    }

    public void setX(Dynamic dynamic) {
        this.mX = SVGLength.from(dynamic);
        invalidate();
    }

    public void setX(String str) {
        this.mX = SVGLength.from(str);
        invalidate();
    }

    public void setX(Double d) {
        this.mX = SVGLength.from(d);
        invalidate();
    }

    public void setY(Dynamic dynamic) {
        this.mY = SVGLength.from(dynamic);
        invalidate();
    }

    public void setY(String str) {
        this.mY = SVGLength.from(str);
        invalidate();
    }

    public void setY(Double d) {
        this.mY = SVGLength.from(d);
        invalidate();
    }

    public void setWidth(Dynamic dynamic) {
        this.mW = SVGLength.from(dynamic);
        invalidate();
    }

    public void setWidth(String str) {
        this.mW = SVGLength.from(str);
        invalidate();
    }

    public void setWidth(Double d) {
        this.mW = SVGLength.from(d);
        invalidate();
    }

    public void setHeight(Dynamic dynamic) {
        this.mH = SVGLength.from(dynamic);
        invalidate();
    }

    public void setHeight(String str) {
        this.mH = SVGLength.from(str);
        invalidate();
    }

    public void setHeight(Double d) {
        this.mH = SVGLength.from(d);
        invalidate();
    }

    @Override // com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    void draw(Canvas canvas, Paint paint, float f) {
        VirtualView definedTemplate = getSvgView().getDefinedTemplate(this.mHref);
        if (definedTemplate == null) {
            FLog.w(ReactConstants.TAG, "`Use` element expected a pre-defined svg template as `href` prop, template named: " + this.mHref + " is not defined.");
            return;
        }
        definedTemplate.clearCache();
        canvas.translate((float) relativeOnWidth(this.mX), (float) relativeOnHeight(this.mY));
        boolean z = definedTemplate instanceof RenderableView;
        if (z) {
            ((RenderableView) definedTemplate).mergeProperties(this);
        }
        int saveAndSetupCanvas = definedTemplate.saveAndSetupCanvas(canvas, this.mCTM);
        clip(canvas, paint);
        if (definedTemplate instanceof SymbolView) {
            ((SymbolView) definedTemplate).drawSymbol(canvas, paint, f, (float) relativeOnWidth(this.mW), (float) relativeOnHeight(this.mH));
        } else {
            definedTemplate.draw(canvas, paint, f * this.mOpacity);
        }
        setClientRect(definedTemplate.getClientRect());
        definedTemplate.restoreCanvas(canvas, saveAndSetupCanvas);
        if (z) {
            ((RenderableView) definedTemplate).resetProperties();
        }
    }

    @Override // com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    int hitTest(float[] fArr) {
        if (this.mInvertible && this.mTransformInvertible) {
            float[] fArr2 = new float[2];
            this.mInvMatrix.mapPoints(fArr2, fArr);
            this.mInvTransform.mapPoints(fArr2);
            VirtualView definedTemplate = getSvgView().getDefinedTemplate(this.mHref);
            if (definedTemplate == null) {
                FLog.w(ReactConstants.TAG, "`Use` element expected a pre-defined svg template as `href` prop, template named: " + this.mHref + " is not defined.");
                return -1;
            }
            int hitTest = definedTemplate.hitTest(fArr2);
            if (hitTest != -1) {
                return (definedTemplate.isResponsible() || hitTest != definedTemplate.getId()) ? hitTest : getId();
            }
        }
        return -1;
    }

    @Override // com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    Path getPath(Canvas canvas, Paint paint) {
        VirtualView definedTemplate = getSvgView().getDefinedTemplate(this.mHref);
        if (definedTemplate == null) {
            FLog.w(ReactConstants.TAG, "`Use` element expected a pre-defined svg template as `href` prop, template named: " + this.mHref + " is not defined.");
            return null;
        }
        Path path = definedTemplate.getPath(canvas, paint);
        Path path2 = new Path();
        Matrix matrix = new Matrix();
        matrix.setTranslate((float) relativeOnWidth(this.mX), (float) relativeOnHeight(this.mY));
        path.transform(matrix, path2);
        return path2;
    }
}
