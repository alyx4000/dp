package expo.modules.barcodescanner;

import android.hardware.Camera;
import android.util.Log;
import com.facebook.react.uimanager.ViewProps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExpoBarCodeScanner.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u0004\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0002$%B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0018\u001a\u00020\u0003J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u0003J,\u0010\u001b\u001a\u00060\u001cR\u00020\n2\u0010\u0010\u001d\u001a\f\u0012\b\u0012\u00060\u001cR\u00020\n0\u001e2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0003J\u000e\u0010!\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0003J\u000e\u0010\"\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0003J\u0006\u0010#\u001a\u00020\u001aR$\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R6\u0010\u000b\u001a*\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0018\u00010\rR\u00020\u00000\fj\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0018\u00010\rR\u00020\u0000`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\fj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0007¨\u0006&"}, d2 = {"Lexpo/modules/barcodescanner/ExpoBarCodeScanner;", "", "mActualDeviceOrientation", "", "(I)V", "actualDeviceOrientation", "getActualDeviceOrientation", "()I", "setActualDeviceOrientation", "camera", "Landroid/hardware/Camera;", "cameraInfo", "Ljava/util/HashMap;", "Lexpo/modules/barcodescanner/ExpoBarCodeScanner$CameraInfoWrapper;", "Lkotlin/collections/HashMap;", "cameraType", "cameraTypeToIndex", "cameras", "", "", "<set-?>", ViewProps.ROTATION, "getRotation", "acquireCameraInstance", "type", "adjustPreviewLayout", "", "getBestSize", "Landroid/hardware/Camera$Size;", "supportedSizes", "", ViewProps.MAX_WIDTH, ViewProps.MAX_HEIGHT, "getPreviewHeight", "getPreviewWidth", "releaseCameraInstance", "CameraInfoWrapper", "Companion", "expo-barcode-scanner_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ExpoBarCodeScanner {
    public static final int CAMERA_TYPE_BACK = 2;
    public static final int CAMERA_TYPE_FRONT = 1;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static ExpoBarCodeScanner innerInstance;
    private Camera camera;
    private int cameraType;
    private int mActualDeviceOrientation;
    private int rotation;
    private final HashMap<Integer, CameraInfoWrapper> cameraInfo = new HashMap<>();
    private final HashMap<Integer, Integer> cameraTypeToIndex = new HashMap<>();
    private final Set<Number> cameras = new HashSet();

    public ExpoBarCodeScanner(int i) {
        this.mActualDeviceOrientation = i;
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i2 = 0; i2 < numberOfCameras; i2++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == 1 && this.cameraInfo.get(1) == null) {
                this.cameraInfo.put(1, new CameraInfoWrapper(this, cameraInfo));
                this.cameraTypeToIndex.put(1, Integer.valueOf(i2));
                this.cameras.add(1);
            } else if (cameraInfo.facing == 0 && this.cameraInfo.get(2) == null) {
                this.cameraInfo.put(2, new CameraInfoWrapper(this, cameraInfo));
                this.cameraTypeToIndex.put(2, Integer.valueOf(i2));
                this.cameras.add(2);
            }
        }
    }

    public final int getRotation() {
        return this.rotation;
    }

    public final Camera acquireCameraInstance(int type) {
        if (this.camera == null && this.cameras.contains(Integer.valueOf(type)) && this.cameraTypeToIndex.get(Integer.valueOf(type)) != null) {
            try {
                Integer num = this.cameraTypeToIndex.get(Integer.valueOf(type));
                if (num != null) {
                    this.camera = Camera.open(num.intValue());
                }
                this.cameraType = type;
                adjustPreviewLayout(type);
            } catch (Exception e) {
                Log.e("ExpoBarCodeScanner", "acquireCameraInstance failed", e);
            }
        }
        return this.camera;
    }

    public final void releaseCameraInstance() {
        Camera camera = this.camera;
        if (camera != null) {
            camera.release();
        }
        this.camera = null;
    }

    public final int getPreviewWidth(int type) {
        CameraInfoWrapper cameraInfoWrapper = this.cameraInfo.get(Integer.valueOf(type));
        if (cameraInfoWrapper != null) {
            return cameraInfoWrapper.getPreviewWidth();
        }
        return 0;
    }

    public final int getPreviewHeight(int type) {
        CameraInfoWrapper cameraInfoWrapper = this.cameraInfo.get(Integer.valueOf(type));
        if (cameraInfoWrapper != null) {
            return cameraInfoWrapper.getPreviewHeight();
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v8 */
    public final Camera.Size getBestSize(List<? extends Camera.Size> supportedSizes, int maxWidth, int maxHeight) {
        Intrinsics.checkNotNullParameter(supportedSizes, "supportedSizes");
        ArrayList arrayList = new ArrayList();
        for (Object obj : supportedSizes) {
            Camera.Size size = (Camera.Size) obj;
            if (size.width <= maxWidth && size.height <= maxHeight) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        Object next = it.next();
        while (it.hasNext()) {
            Camera.Size size2 = (Camera.Size) it.next();
            next = (Camera.Size) next;
            if (size2.width * size2.height > next.width * next.height) {
                next = size2;
            }
        }
        return (Camera.Size) next;
    }

    /* renamed from: getActualDeviceOrientation, reason: from getter */
    public final int getMActualDeviceOrientation() {
        return this.mActualDeviceOrientation;
    }

    public final void setActualDeviceOrientation(int i) {
        this.mActualDeviceOrientation = i;
        adjustPreviewLayout(this.cameraType);
    }

    public final void adjustPreviewLayout(int type) {
        CameraInfoWrapper cameraInfoWrapper;
        Camera camera = this.camera;
        if (camera == null || (cameraInfoWrapper = this.cameraInfo.get(Integer.valueOf(type))) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(cameraInfoWrapper, "cameraInfo[type] ?: return");
        int i = this.mActualDeviceOrientation;
        int i2 = 0;
        if (i != 0) {
            if (i == 1) {
                i2 = 90;
            } else if (i == 2) {
                i2 = 180;
            } else if (i == 3) {
                i2 = 270;
            }
        }
        if (cameraInfoWrapper.getInfo().facing == 1) {
            int i3 = (cameraInfoWrapper.getInfo().orientation + i2) % 360;
            this.rotation = i3;
            this.rotation = (360 - i3) % 360;
        } else {
            this.rotation = ((cameraInfoWrapper.getInfo().orientation - i2) + 360) % 360;
        }
        camera.setDisplayOrientation(this.rotation);
        Camera.Parameters parameters = camera.getParameters();
        parameters.setRotation(this.rotation);
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        Intrinsics.checkNotNullExpressionValue(supportedPreviewSizes, "temporaryParameters.supportedPreviewSizes");
        Camera.Size bestSize = getBestSize(supportedPreviewSizes, 1920, 1920);
        int i4 = bestSize.width;
        int i5 = bestSize.height;
        parameters.setPreviewSize(i4, i5);
        try {
            camera.setParameters(parameters);
        } catch (Exception e) {
            e.printStackTrace();
        }
        cameraInfoWrapper.setPreviewHeight(i5);
        cameraInfoWrapper.setPreviewWidth(i4);
        int i6 = this.rotation;
        if (i6 == 90 || i6 == 270) {
            cameraInfoWrapper.setPreviewHeight(i4);
            cameraInfoWrapper.setPreviewWidth(i5);
        }
    }

    /* compiled from: ExpoBarCodeScanner.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u0013"}, d2 = {"Lexpo/modules/barcodescanner/ExpoBarCodeScanner$CameraInfoWrapper;", "", "info", "Landroid/hardware/Camera$CameraInfo;", "(Lexpo/modules/barcodescanner/ExpoBarCodeScanner;Landroid/hardware/Camera$CameraInfo;)V", "getInfo", "()Landroid/hardware/Camera$CameraInfo;", "previewHeight", "", "getPreviewHeight", "()I", "setPreviewHeight", "(I)V", "previewWidth", "getPreviewWidth", "setPreviewWidth", ViewProps.ROTATION, "getRotation", "setRotation", "expo-barcode-scanner_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class CameraInfoWrapper {
        private final Camera.CameraInfo info;
        private int previewHeight;
        private int previewWidth;
        private int rotation;
        final /* synthetic */ ExpoBarCodeScanner this$0;

        public CameraInfoWrapper(ExpoBarCodeScanner expoBarCodeScanner, Camera.CameraInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            this.this$0 = expoBarCodeScanner;
            this.info = info;
            this.previewWidth = -1;
            this.previewHeight = -1;
        }

        public final Camera.CameraInfo getInfo() {
            return this.info;
        }

        public final int getRotation() {
            return this.rotation;
        }

        public final void setRotation(int i) {
            this.rotation = i;
        }

        public final int getPreviewWidth() {
            return this.previewWidth;
        }

        public final void setPreviewWidth(int i) {
            this.previewWidth = i;
        }

        public final int getPreviewHeight() {
            return this.previewHeight;
        }

        public final void setPreviewHeight(int i) {
            this.previewHeight = i;
        }
    }

    /* compiled from: ExpoBarCodeScanner.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lexpo/modules/barcodescanner/ExpoBarCodeScanner$Companion;", "", "()V", "CAMERA_TYPE_BACK", "", "CAMERA_TYPE_FRONT", "innerInstance", "Lexpo/modules/barcodescanner/ExpoBarCodeScanner;", "instance", "getInstance", "()Lexpo/modules/barcodescanner/ExpoBarCodeScanner;", "createInstance", "", "deviceOrientation", "expo-barcode-scanner_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ExpoBarCodeScanner getInstance() {
            ExpoBarCodeScanner expoBarCodeScanner = ExpoBarCodeScanner.innerInstance;
            if (expoBarCodeScanner != null) {
                return expoBarCodeScanner;
            }
            throw new IllegalArgumentException("Bar code scanner needs to be initialized".toString());
        }

        public final void createInstance(int deviceOrientation) {
            ExpoBarCodeScanner.innerInstance = new ExpoBarCodeScanner(deviceOrientation);
        }
    }
}
