package androidx.camera.core;

import android.view.Display;
import androidx.camera.core.impl.CameraInfoInternal;

/* loaded from: classes.dex */
public final class DisplayOrientedMeteringPointFactory extends MeteringPointFactory {
    private final CameraInfo mCameraInfo;
    private final Display mDisplay;
    private final float mHeight;
    private final float mWidth;

    public DisplayOrientedMeteringPointFactory(Display display, CameraInfo cameraInfo, float f, float f2) {
        this.mWidth = f;
        this.mHeight = f2;
        this.mDisplay = display;
        this.mCameraInfo = cameraInfo;
    }

    private Integer getLensFacing() {
        CameraInfo cameraInfo = this.mCameraInfo;
        if (cameraInfo instanceof CameraInfoInternal) {
            return ((CameraInfoInternal) cameraInfo).getLensFacing();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    @Override // androidx.camera.core.MeteringPointFactory
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected android.graphics.PointF convertPoint(float r9, float r10) {
        /*
            r8 = this;
            float r0 = r8.mWidth
            float r1 = r8.mHeight
            java.lang.Integer r2 = r8.getLensFacing()
            if (r2 == 0) goto L12
            int r2 = r2.intValue()
            if (r2 != 0) goto L12
            r2 = 1
            goto L13
        L12:
            r2 = 0
        L13:
            int r3 = r8.getRelativeCameraOrientation(r2)
            r4 = 270(0x10e, float:3.78E-43)
            r5 = 90
            if (r3 == r5) goto L26
            if (r3 != r4) goto L20
            goto L26
        L20:
            r6 = r10
            r10 = r9
            r9 = r6
            r7 = r1
            r1 = r0
            r0 = r7
        L26:
            if (r3 == r5) goto L34
            r5 = 180(0xb4, float:2.52E-43)
            if (r3 == r5) goto L32
            if (r3 == r4) goto L2f
            goto L36
        L2f:
            float r10 = r1 - r10
            goto L36
        L32:
            float r10 = r1 - r10
        L34:
            float r9 = r0 - r9
        L36:
            if (r2 == 0) goto L3a
            float r10 = r1 - r10
        L3a:
            float r10 = r10 / r1
            float r9 = r9 / r0
            android.graphics.PointF r0 = new android.graphics.PointF
            r0.<init>(r10, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.DisplayOrientedMeteringPointFactory.convertPoint(float, float):android.graphics.PointF");
    }

    private int getRelativeCameraOrientation(boolean z) {
        try {
            int sensorRotationDegrees = this.mCameraInfo.getSensorRotationDegrees(this.mDisplay.getRotation());
            return z ? (360 - sensorRotationDegrees) % 360 : sensorRotationDegrees;
        } catch (Exception unused) {
            return 0;
        }
    }
}
