package com.socure.docv.capturesdk.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import com.socure.docv.capturesdk.R;
import com.socure.docv.capturesdk.common.utils.AnimationUtilsKt;
import com.socure.docv.capturesdk.common.utils.ImageUtils;
import com.socure.docv.capturesdk.common.view.model.e;
import com.socure.docv.capturesdk.feature.scanner.data.Dimension;
import io.sentry.Session;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/socure/docv/capturesdk/common/view/GraphicOverlay;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Session.JsonKeys.ATTRS, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes5.dex */
public final class GraphicOverlay extends View {

    /* renamed from: a, reason: collision with root package name */
    public final Object f345a;
    public final List<Float> b;
    public final Paint c;
    public final Paint d;
    public Lazy<? extends Paint> e;
    public final Path f;
    public final float g;
    public final float h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public boolean n;
    public Drawable o;
    public e p;
    public final Function1<Float, Unit> q;
    public final Function1<Float, Unit> r;
    public final Function1<Float, Unit> s;

    public static final class a extends Lambda implements Function0<Paint> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Paint invoke() {
            Paint paint = new Paint();
            GraphicOverlay graphicOverlay = GraphicOverlay.this;
            paint.setColor(graphicOverlay.i);
            float f = graphicOverlay.g;
            paint.setStrokeWidth(f > 0.0f ? f / 2 : 1.0f);
            return paint;
        }
    }

    public static final class b extends Lambda implements Function1<Float, Unit> {
        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Float f) {
            Unit unit;
            float floatValue = f.floatValue();
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_G_Overlay", "onClearAnimationUpdate");
            GraphicOverlay graphicOverlay = GraphicOverlay.this;
            e eVar = graphicOverlay.p;
            if (eVar != null) {
                com.socure.docv.capturesdk.common.view.model.d dVar = eVar.f353a;
                com.socure.docv.capturesdk.common.view.model.d dVar2 = eVar.b;
                com.socure.docv.capturesdk.common.view.model.d dVar3 = eVar.c;
                com.socure.docv.capturesdk.common.view.model.d dVar4 = eVar.d;
                com.socure.docv.capturesdk.common.view.model.d dVar5 = eVar.e;
                com.socure.docv.capturesdk.common.view.model.d dVar6 = eVar.f;
                AnimationUtilsKt.decreaseDrawPoints(AnimationUtilsKt.calculateReducedPercentage(floatValue, 0), dVar, dVar4);
                AnimationUtilsKt.decreaseDrawPoints(AnimationUtilsKt.calculateReducedPercentage(floatValue, 11), dVar2, dVar5);
                AnimationUtilsKt.decreaseDrawPoints(AnimationUtilsKt.calculateReducedPercentage(floatValue, 22), dVar3, dVar6);
                graphicOverlay.invalidate();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                com.socure.docv.capturesdk.common.logger.b.b("SDLT_G_Overlay", "gridLines is NULL");
            }
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Float, Unit> {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Float f) {
            Unit unit;
            float floatValue = f.floatValue();
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_G_Overlay", "onDrawAnimationUpdate");
            GraphicOverlay graphicOverlay = GraphicOverlay.this;
            e eVar = graphicOverlay.p;
            if (eVar != null) {
                com.socure.docv.capturesdk.common.view.model.d dVar = eVar.f353a;
                com.socure.docv.capturesdk.common.view.model.d dVar2 = eVar.b;
                com.socure.docv.capturesdk.common.view.model.d dVar3 = eVar.c;
                com.socure.docv.capturesdk.common.view.model.d dVar4 = eVar.d;
                com.socure.docv.capturesdk.common.view.model.d dVar5 = eVar.e;
                com.socure.docv.capturesdk.common.view.model.d dVar6 = eVar.f;
                AnimationUtilsKt.increaseDrawPoints(AnimationUtilsKt.calculateReducedPercentage(floatValue, 0), dVar, dVar4);
                AnimationUtilsKt.increaseDrawPoints(AnimationUtilsKt.calculateReducedPercentage(floatValue, 11), dVar2, dVar5);
                AnimationUtilsKt.increaseDrawPoints(AnimationUtilsKt.calculateReducedPercentage(floatValue, 22), dVar3, dVar6);
                graphicOverlay.invalidate();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                com.socure.docv.capturesdk.common.logger.b.b("SDLT_G_Overlay", "gridLines is NULL");
            }
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function1<Float, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Float f) {
            float floatValue = f.floatValue();
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_G_Overlay", "onShowTickGraphic");
            if (!GraphicOverlay.this.b.isEmpty()) {
                GraphicOverlay graphicOverlay = GraphicOverlay.this;
                if (graphicOverlay.o == null) {
                    graphicOverlay.o = ResourcesCompat.getDrawable(graphicOverlay.getResources(), R.drawable.ic_socure_capture_success, null);
                    GraphicOverlay graphicOverlay2 = GraphicOverlay.this;
                    graphicOverlay2.d.setColor(graphicOverlay2.k);
                }
                float f2 = 2;
                int floatValue2 = (int) (((GraphicOverlay.this.b.get(6).floatValue() - GraphicOverlay.this.b.get(0).floatValue()) / f2) + GraphicOverlay.this.b.get(0).floatValue());
                int floatValue3 = (int) (((GraphicOverlay.this.b.get(7).floatValue() - GraphicOverlay.this.b.get(1).floatValue()) / f2) + GraphicOverlay.this.b.get(1).floatValue());
                GraphicOverlay graphicOverlay3 = GraphicOverlay.this;
                int i = (int) ((graphicOverlay3.h / f2) * (floatValue / 100));
                Drawable drawable = graphicOverlay3.o;
                if (drawable != null) {
                    drawable.setBounds(floatValue2 - i, floatValue3 - i, floatValue2 + i, floatValue3 + i);
                }
                GraphicOverlay.this.invalidate();
            } else {
                com.socure.docv.capturesdk.common.logger.b.b("SDLT_G_Overlay", "corners list is EMPTY");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GraphicOverlay(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.f345a = new Object();
        this.b = new ArrayList();
        this.c = new Paint();
        this.d = new Paint();
        this.f = new Path();
        this.i = ResourcesCompat.getColor(getResources(), R.color.socure_green, null);
        this.j = ResourcesCompat.getColor(getResources(), R.color.socure_translucent_green, null);
        this.k = ResourcesCompat.getColor(getResources(), R.color.socure_translucent_green_dark, null);
        this.l = ResourcesCompat.getColor(getResources(), R.color.socure_white, null);
        this.m = ResourcesCompat.getColor(getResources(), R.color.socure_translucent_white, null);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.GraphicOverlaySocure, 0, 0);
        this.g = obtainStyledAttributes.getDimension(R.styleable.GraphicOverlaySocure_paint_stroke_width_socure, obtainStyledAttributes.getResources().getDimension(R.dimen.capture_animation_paint_stroke_socure));
        this.h = obtainStyledAttributes.getDimension(R.styleable.GraphicOverlaySocure_success_vector_dimen_socure, obtainStyledAttributes.getResources().getDimension(R.dimen.capture_animation_tick_dimen_socure));
        this.e = LazyKt.lazy(new a());
        obtainStyledAttributes.recycle();
        this.q = new c();
        this.r = new b();
        this.s = new d();
    }

    public final void a() {
        if (this.n) {
            return;
        }
        this.b.clear();
        this.o = null;
        this.n = false;
        invalidate();
    }

    public final void a(List<Float> list, Dimension dimension) {
        this.c.reset();
        this.d.reset();
        this.f.reset();
        this.b.addAll(list);
        ImageUtils.INSTANCE.scaleIddModelCoordinates$capturesdk_productionRelease(this.b, new Dimension(getWidth(), getHeight()), dimension);
        this.d.setStyle(Paint.Style.FILL);
        this.c.setStrokeWidth(this.g);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.b.size() != 12) {
            com.socure.docv.capturesdk.common.logger.b.b("SDLT_G_Overlay", "corners.size is not 12 - size: " + this.b.size());
            this.c.reset();
            this.d.reset();
            this.f.reset();
            return;
        }
        synchronized (this.f345a) {
            if (canvas != null) {
                canvas.drawLine(this.b.get(0).floatValue(), this.b.get(1).floatValue(), this.b.get(3).floatValue(), this.b.get(4).floatValue(), this.c);
                canvas.drawLine(this.b.get(3).floatValue(), this.b.get(4).floatValue(), this.b.get(6).floatValue(), this.b.get(7).floatValue(), this.c);
                canvas.drawLine(this.b.get(6).floatValue(), this.b.get(7).floatValue(), this.b.get(9).floatValue(), this.b.get(10).floatValue(), this.c);
                canvas.drawLine(this.b.get(9).floatValue(), this.b.get(10).floatValue(), this.b.get(0).floatValue(), this.b.get(1).floatValue(), this.c);
                this.f.moveTo(this.b.get(0).floatValue(), this.b.get(1).floatValue());
                this.f.lineTo(this.b.get(3).floatValue(), this.b.get(4).floatValue());
                this.f.lineTo(this.b.get(6).floatValue(), this.b.get(7).floatValue());
                this.f.lineTo(this.b.get(9).floatValue(), this.b.get(10).floatValue());
                this.f.lineTo(this.b.get(0).floatValue(), this.b.get(1).floatValue());
                canvas.drawPath(this.f, this.d);
                if (this.n) {
                    e eVar = this.p;
                    if (eVar != null) {
                        com.socure.docv.capturesdk.common.view.model.d[] dVarArr = {eVar.f353a, eVar.b, eVar.c, eVar.d, eVar.e, eVar.f};
                        for (int i = 0; i < 6; i++) {
                            com.socure.docv.capturesdk.common.view.model.d dVar = dVarArr[i];
                            canvas.drawLine(dVar.f352a, dVar.b, dVar.c, dVar.d, this.e.getValue());
                        }
                    }
                    Drawable drawable = this.o;
                    if (drawable != null) {
                        drawable.draw(canvas);
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
