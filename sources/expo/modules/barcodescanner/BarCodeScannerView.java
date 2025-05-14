package expo.modules.barcodescanner;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.WindowManager;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.interfaces.barcodescanner.BarCodeScannerResult;
import expo.modules.interfaces.barcodescanner.BarCodeScannerSettings;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.viewevent.ViewEventCallback;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.views.ExpoView;
import io.sentry.protocol.ViewHierarchyNode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;

/* compiled from: BarCodeScannerView.kt */
@Metadata(d1 = {"\u0000\u0087\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J:\u0010\u001c\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` \u0012\u0004\u0012\u00020\u001f0\u001d2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\"2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\bH\u0002J\u0006\u0010&\u001a\u00020'J(\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\bH\u0002J\u000e\u0010\u000e\u001a\u00020'2\u0006\u0010,\u001a\u00020-J\b\u0010.\u001a\u00020'H\u0014J0\u0010/\u001a\u00020'2\u0006\u00100\u001a\u0002012\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\bH\u0014J\u0010\u00102\u001a\u00020'2\u0006\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u000201H\u0002J\u0010\u00106\u001a\u00020'2\b\u00107\u001a\u0004\u0018\u000108J\u000e\u00109\u001a\u00020'2\u0006\u0010:\u001a\u00020\bJ\u0010\u0010;\u001a\u00020'2\u0006\u0010,\u001a\u00020-H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lexpo/modules/barcodescanner/BarCodeScannerView;", "Lexpo/modules/kotlin/views/ExpoView;", "context", "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "actualDeviceOrientation", "", "displayDensity", "", "getDisplayDensity", "()F", "leftPadding", "onBarCodeScanned", "Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "Lexpo/modules/barcodescanner/BarCodeScannedEvent;", "getOnBarCodeScanned", "()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "onBarCodeScanned$delegate", "Lexpo/modules/kotlin/viewevent/ViewEventDelegate;", "orientationListener", "expo/modules/barcodescanner/BarCodeScannerView$orientationListener$1", "Lexpo/modules/barcodescanner/BarCodeScannerView$orientationListener$1;", "topPadding", "type", "viewFinder", "Lexpo/modules/barcodescanner/BarCodeScannerViewFinder;", "getCornerPointsAndBoundingBox", "Landroid/util/Pair;", "Ljava/util/ArrayList;", "Landroid/os/Bundle;", "Lkotlin/collections/ArrayList;", "cornerPoints", "", "boundingBox", "Lexpo/modules/interfaces/barcodescanner/BarCodeScannerResult$BoundingBox;", "getDeviceOrientation", "layoutViewFinder", "", ViewProps.LEFT, ViewProps.TOP, ViewProps.RIGHT, ViewProps.BOTTOM, "barCode", "Lexpo/modules/interfaces/barcodescanner/BarCodeScannerResult;", "onDetachedFromWindow", ViewProps.ON_LAYOUT, "changed", "", "onViewAdded", "child", "Landroid/view/View;", "setActualDeviceOrientation", "setBarCodeScannerSettings", "settings", "Lexpo/modules/interfaces/barcodescanner/BarCodeScannerSettings;", "setCameraType", "cameraType", "transformBarCodeScannerResultToViewCoordinates", "expo-barcode-scanner_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BarCodeScannerView extends ExpoView {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(BarCodeScannerView.class, "onBarCodeScanned", "getOnBarCodeScanned()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0))};
    private int actualDeviceOrientation;
    private int leftPadding;

    /* renamed from: onBarCodeScanned$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onBarCodeScanned;
    private final BarCodeScannerView$orientationListener$1 orientationListener;
    private int topPadding;
    private int type;
    private BarCodeScannerViewFinder viewFinder;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v4, types: [expo.modules.barcodescanner.BarCodeScannerView$orientationListener$1] */
    public BarCodeScannerView(final Context context, AppContext appContext) {
        super(context, appContext);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.onBarCodeScanned = new ViewEventDelegate(this, new Function1<BarCodeScannedEvent, Short>() { // from class: expo.modules.barcodescanner.BarCodeScannerView$onBarCodeScanned$2
            @Override // kotlin.jvm.functions.Function1
            public final Short invoke(BarCodeScannedEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                return Short.valueOf((short) (event.getData().hashCode() % 32767));
            }
        });
        ?? r0 = new OrientationEventListener(context) { // from class: expo.modules.barcodescanner.BarCodeScannerView$orientationListener$1
            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int orientation) {
                boolean actualDeviceOrientation;
                actualDeviceOrientation = this.setActualDeviceOrientation();
                if (actualDeviceOrientation) {
                    this.layoutViewFinder();
                }
            }
        };
        if (r0.canDetectOrientation()) {
            r0.enable();
        } else {
            r0.disable();
        }
        this.orientationListener = r0;
        this.actualDeviceOrientation = -1;
        ExpoBarCodeScanner.INSTANCE.createInstance(getDeviceOrientation());
        BarCodeScannerViewFinder barCodeScannerViewFinder = new BarCodeScannerViewFinder(context, this.type, this, appContext);
        this.viewFinder = barCodeScannerViewFinder;
        addView(barCodeScannerViewFinder);
    }

    private final ViewEventCallback<BarCodeScannedEvent> getOnBarCodeScanned() {
        return this.onBarCodeScanned.getValue(this, $$delegatedProperties[0]);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        disable();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        layoutViewFinder(left, top, right, bottom);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        if (Intrinsics.areEqual(this.viewFinder, child)) {
            return;
        }
        removeView(this.viewFinder);
        addView(this.viewFinder, 0);
    }

    public final void onBarCodeScanned(BarCodeScannerResult barCode) {
        Intrinsics.checkNotNullParameter(barCode, "barCode");
        transformBarCodeScannerResultToViewCoordinates(barCode);
        List<Integer> cornerPoints = barCode.getCornerPoints();
        Intrinsics.checkNotNullExpressionValue(cornerPoints, "barCode.cornerPoints");
        BarCodeScannerResult.BoundingBox boundingBox = barCode.getBoundingBox();
        Intrinsics.checkNotNullExpressionValue(boundingBox, "barCode.boundingBox");
        Pair<ArrayList<Bundle>, Bundle> cornerPointsAndBoundingBox = getCornerPointsAndBoundingBox(cornerPoints, boundingBox);
        ArrayList arrayList = (ArrayList) cornerPointsAndBoundingBox.first;
        Bundle bundle = (Bundle) cornerPointsAndBoundingBox.second;
        ViewEventCallback<BarCodeScannedEvent> onBarCodeScanned = getOnBarCodeScanned();
        int id = getId();
        String value = barCode.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "barCode.value");
        String raw = barCode.getRaw();
        Intrinsics.checkNotNullExpressionValue(raw, "barCode.raw");
        onBarCodeScanned.invoke(new BarCodeScannedEvent(id, value, raw, barCode.getType(), arrayList, bundle));
    }

    private final float getDisplayDensity() {
        return getResources().getDisplayMetrics().density;
    }

    private final void transformBarCodeScannerResultToViewCoordinates(BarCodeScannerResult barCode) {
        List<Integer> cornerPoints = barCode.getCornerPoints();
        int width = getWidth() - (this.leftPadding * 2);
        int height = getHeight() - (this.topPadding * 2);
        if (this.type == 1 && getDeviceOrientation() % 2 == 0) {
            Intrinsics.checkNotNullExpressionValue(cornerPoints, "cornerPoints");
            IntProgression step = RangesKt.step(RangesKt.until(1, cornerPoints.size()), 2);
            int first = step.getFirst();
            int last = step.getLast();
            int step2 = step.getStep();
            if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
                while (true) {
                    int referenceImageHeight = barCode.getReferenceImageHeight();
                    Integer num = cornerPoints.get(first);
                    Intrinsics.checkNotNullExpressionValue(num, "cornerPoints[it]");
                    cornerPoints.set(first, Integer.valueOf(referenceImageHeight - num.intValue()));
                    if (first == last) {
                        break;
                    } else {
                        first += step2;
                    }
                }
            }
        }
        if (this.type == 1 && getDeviceOrientation() % 2 != 0) {
            Intrinsics.checkNotNullExpressionValue(cornerPoints, "cornerPoints");
            IntProgression step3 = RangesKt.step(RangesKt.until(0, cornerPoints.size()), 2);
            int first2 = step3.getFirst();
            int last2 = step3.getLast();
            int step4 = step3.getStep();
            if ((step4 > 0 && first2 <= last2) || (step4 < 0 && last2 <= first2)) {
                while (true) {
                    int referenceImageWidth = barCode.getReferenceImageWidth();
                    Integer num2 = cornerPoints.get(first2);
                    Intrinsics.checkNotNullExpressionValue(num2, "cornerPoints[it]");
                    cornerPoints.set(first2, Integer.valueOf(referenceImageWidth - num2.intValue()));
                    if (first2 == last2) {
                        break;
                    } else {
                        first2 += step4;
                    }
                }
            }
        }
        Intrinsics.checkNotNullExpressionValue(cornerPoints, "cornerPoints");
        IntProgression step5 = RangesKt.step(RangesKt.until(0, cornerPoints.size()), 2);
        int first3 = step5.getFirst();
        int last3 = step5.getLast();
        int step6 = step5.getStep();
        if ((step6 > 0 && first3 <= last3) || (step6 < 0 && last3 <= first3)) {
            while (true) {
                cornerPoints.set(first3, Integer.valueOf(MathKt.roundToInt(((cornerPoints.get(first3).intValue() * width) / barCode.getReferenceImageWidth()) + this.leftPadding)));
                if (first3 == last3) {
                    break;
                } else {
                    first3 += step6;
                }
            }
        }
        IntProgression step7 = RangesKt.step(RangesKt.until(1, cornerPoints.size()), 2);
        int first4 = step7.getFirst();
        int last4 = step7.getLast();
        int step8 = step7.getStep();
        if ((step8 > 0 && first4 <= last4) || (step8 < 0 && last4 <= first4)) {
            while (true) {
                cornerPoints.set(first4, Integer.valueOf(MathKt.roundToInt(((cornerPoints.get(first4).intValue() * height) / barCode.getReferenceImageHeight()) + this.topPadding)));
                if (first4 == last4) {
                    break;
                } else {
                    first4 += step8;
                }
            }
        }
        barCode.setReferenceImageHeight(getHeight());
        barCode.setReferenceImageWidth(getWidth());
        barCode.setCornerPoints(cornerPoints);
    }

    private final Pair<ArrayList<Bundle>, Bundle> getCornerPointsAndBoundingBox(List<Integer> cornerPoints, BarCodeScannerResult.BoundingBox boundingBox) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, cornerPoints.size() - 1, 2);
        if (progressionLastElement >= 0) {
            while (true) {
                float intValue = cornerPoints.get(i).intValue() / getDisplayDensity();
                float intValue2 = cornerPoints.get(i + 1).intValue() / getDisplayDensity();
                Bundle bundle = new Bundle();
                bundle.putFloat(ViewHierarchyNode.JsonKeys.X, intValue);
                bundle.putFloat(ViewHierarchyNode.JsonKeys.Y, intValue2);
                arrayList.add(bundle);
                if (i == progressionLastElement) {
                    break;
                }
                i += 2;
            }
        }
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = new Bundle();
        bundle3.putFloat(ViewHierarchyNode.JsonKeys.X, boundingBox.getX() / getDisplayDensity());
        bundle3.putFloat(ViewHierarchyNode.JsonKeys.Y, boundingBox.getY() / getDisplayDensity());
        Unit unit = Unit.INSTANCE;
        bundle2.putParcelable("origin", bundle3);
        Bundle bundle4 = new Bundle();
        bundle4.putFloat("width", boundingBox.getWidth() / getDisplayDensity());
        bundle4.putFloat("height", boundingBox.getHeight() / getDisplayDensity());
        Unit unit2 = Unit.INSTANCE;
        bundle2.putParcelable("size", bundle4);
        return new Pair<>(arrayList, bundle2);
    }

    public final void setCameraType(int cameraType) {
        this.type = cameraType;
        this.viewFinder.setCameraType(cameraType);
        ExpoBarCodeScanner.INSTANCE.getInstance().adjustPreviewLayout(cameraType);
    }

    public final void setBarCodeScannerSettings(BarCodeScannerSettings settings) {
        this.viewFinder.setBarCodeScannerSettings(settings);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean setActualDeviceOrientation() {
        int deviceOrientation = getDeviceOrientation();
        if (this.actualDeviceOrientation == deviceOrientation) {
            return false;
        }
        this.actualDeviceOrientation = deviceOrientation;
        ExpoBarCodeScanner.INSTANCE.getInstance().setActualDeviceOrientation(this.actualDeviceOrientation);
        return true;
    }

    private final int getDeviceOrientation() {
        Object systemService = getContext().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        return ((WindowManager) systemService).getDefaultDisplay().getRotation();
    }

    public final void layoutViewFinder() {
        layoutViewFinder(getLeft(), getTop(), getRight(), getBottom());
    }

    private final void layoutViewFinder(int left, int top, int right, int bottom) {
        int i;
        int i2;
        float f = right - left;
        float f2 = bottom - top;
        double ratio = this.viewFinder.getRatio();
        double d = f2 * ratio;
        double d2 = f;
        if (d < d2) {
            i2 = (int) d;
            i = (int) f2;
        } else {
            i = (int) (d2 / ratio);
            i2 = (int) f;
        }
        float f3 = 2;
        int i3 = (int) ((f - i2) / f3);
        int i4 = (int) ((f2 - i) / f3);
        this.leftPadding = i3;
        this.topPadding = i4;
        this.viewFinder.layout(i3, i4, i2 + i3, i + i4);
        postInvalidate(left, top, right, bottom);
    }
}
