package com.socure.docv.capturesdk.common.utils;

import android.animation.ValueAnimator;
import com.socure.docv.capturesdk.common.view.model.d;
import com.socure.docv.capturesdk.common.view.model.e;
import com.socure.docv.capturesdk.core.processor.model.Line;
import com.socure.docv.capturesdk.core.processor.model.Point;
import com.socure.docv.capturesdk.core.processor.model.Quadrilateral;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000V\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\u001a\u0016\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0000\u001a\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a \u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0000\u001aK\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u000e2%\b\u0002\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0012H\u0000\u001a\u0018\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001bH\u0000\u001a+\u0010!\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00012\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u001f\"\u00020\tH\u0000¢\u0006\u0004\b!\u0010\"\u001a+\u0010#\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00012\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u001f\"\u00020\tH\u0000¢\u0006\u0004\b#\u0010\"¨\u0006$"}, d2 = {"", "", "modelOutput", "Lcom/socure/docv/capturesdk/common/view/model/e;", "calculateGridLines", "Lcom/socure/docv/capturesdk/core/processor/model/Line;", "line", "Lcom/socure/docv/capturesdk/core/processor/model/Point;", "getDistanceBetweenEdges", "Lcom/socure/docv/capturesdk/common/view/model/d;", "previousPoint", "startEdgeDistance", "endEdgeDistance", "getNextGridLinePoint", "", "animDuration", "animationRange", "delayDuration", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "animatedValue", "", "updateListener", "Landroid/animation/ValueAnimator;", "createAnimator", "animationValue", "", "reduceBy", "calculateReducedPercentage", "percentage", "", "gridLines", "increaseDrawPoints", "(F[Lcom/socure/docv/capturesdk/common/view/model/d;)V", "decreaseDrawPoints", "capturesdk_productionRelease"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes5.dex */
public final class AnimationUtilsKt {
    public static final e calculateGridLines(List<Float> modelOutput) {
        Intrinsics.checkNotNullParameter(modelOutput, "modelOutput");
        Quadrilateral quadrilateral$capturesdk_productionRelease = ImageUtils.INSTANCE.getQuadrilateral$capturesdk_productionRelease(modelOutput);
        Point topLeft = quadrilateral$capturesdk_productionRelease.getTopLeft();
        Point topRight = quadrilateral$capturesdk_productionRelease.getTopRight();
        Point bottomRight = quadrilateral$capturesdk_productionRelease.getBottomRight();
        Point bottomLeft = quadrilateral$capturesdk_productionRelease.getBottomLeft();
        Point distanceBetweenEdges = getDistanceBetweenEdges(new Line(topLeft, topRight));
        Point distanceBetweenEdges2 = getDistanceBetweenEdges(new Line(bottomLeft, bottomRight));
        d nextGridLinePoint = getNextGridLinePoint(new d(topLeft.getX(), topLeft.getY(), bottomLeft.getX(), bottomLeft.getY()), distanceBetweenEdges, distanceBetweenEdges2);
        d nextGridLinePoint2 = getNextGridLinePoint(nextGridLinePoint, distanceBetweenEdges, distanceBetweenEdges2);
        d nextGridLinePoint3 = getNextGridLinePoint(nextGridLinePoint2, distanceBetweenEdges, distanceBetweenEdges2);
        Point distanceBetweenEdges3 = getDistanceBetweenEdges(new Line(topLeft, bottomLeft));
        Point distanceBetweenEdges4 = getDistanceBetweenEdges(new Line(topRight, bottomRight));
        d nextGridLinePoint4 = getNextGridLinePoint(new d(topLeft.getX(), topLeft.getY(), topRight.getX(), topRight.getY()), distanceBetweenEdges3, distanceBetweenEdges4);
        d nextGridLinePoint5 = getNextGridLinePoint(nextGridLinePoint4, distanceBetweenEdges3, distanceBetweenEdges4);
        return new e(nextGridLinePoint, nextGridLinePoint2, nextGridLinePoint3, nextGridLinePoint4, nextGridLinePoint5, getNextGridLinePoint(nextGridLinePoint5, distanceBetweenEdges3, distanceBetweenEdges4));
    }

    public static final float calculateReducedPercentage(float f, int i) {
        float f2 = f - i;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 100.0f) {
            return 100.0f;
        }
        return f2;
    }

    public static final ValueAnimator createAnimator(long j, float f, long j2, final Function1<? super Float, Unit> function1) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, f);
        ofFloat.setDuration(j);
        ofFloat.setStartDelay(j2);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.socure.docv.capturesdk.common.utils.AnimationUtilsKt$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AnimationUtilsKt.m957createAnimator$lambda2$lambda1(Function1.this, valueAnimator);
            }
        });
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(0F, animationRan…edValue as Float) }\n    }");
        return ofFloat;
    }

    public static /* synthetic */ ValueAnimator createAnimator$default(long j, float f, long j2, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 100.0f;
        }
        float f2 = f;
        if ((i & 4) != 0) {
            j2 = 0;
        }
        long j3 = j2;
        if ((i & 8) != 0) {
            function1 = null;
        }
        return createAnimator(j, f2, j3, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createAnimator$lambda-2$lambda-1, reason: not valid java name */
    public static final void m957createAnimator$lambda2$lambda1(Function1 function1, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (function1 != null) {
            Object animatedValue = it.getAnimatedValue();
            if (animatedValue == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
            }
            function1.invoke(Float.valueOf(((Float) animatedValue).floatValue()));
        }
    }

    public static final void decreaseDrawPoints(float f, d... gridLines) {
        Intrinsics.checkNotNullParameter(gridLines, "gridLines");
        for (d dVar : gridLines) {
            float f2 = f / 100;
            float f3 = dVar.e;
            float f4 = dVar.f;
            dVar.f352a = (dVar.c + (f2 * f3)) - f3;
            dVar.b = (dVar.d + (f2 * f4)) - f4;
        }
    }

    public static final Point getDistanceBetweenEdges(Line line) {
        Intrinsics.checkNotNullParameter(line, "line");
        float f = 4;
        return new Point((line.getEnd().getX() - line.getStart().getX()) / f, (line.getEnd().getY() - line.getStart().getY()) / f);
    }

    public static final d getNextGridLinePoint(d previousPoint, Point startEdgeDistance, Point endEdgeDistance) {
        Intrinsics.checkNotNullParameter(previousPoint, "previousPoint");
        Intrinsics.checkNotNullParameter(startEdgeDistance, "startEdgeDistance");
        Intrinsics.checkNotNullParameter(endEdgeDistance, "endEdgeDistance");
        return new d(startEdgeDistance.getX() + previousPoint.f352a, startEdgeDistance.getY() + previousPoint.b, endEdgeDistance.getX() + previousPoint.c, endEdgeDistance.getY() + previousPoint.d);
    }

    public static final void increaseDrawPoints(float f, d... gridLines) {
        Intrinsics.checkNotNullParameter(gridLines, "gridLines");
        for (d dVar : gridLines) {
            float f2 = f / 100;
            float f3 = dVar.e * f2;
            float f4 = f2 * dVar.f;
            dVar.c = dVar.f352a + f3;
            dVar.d = dVar.b + f4;
        }
    }
}
