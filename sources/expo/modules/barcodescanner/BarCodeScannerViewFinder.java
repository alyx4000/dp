package expo.modules.barcodescanner;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.util.Log;
import android.view.TextureView;
import expo.modules.core.errors.ModuleDestroyedException;
import expo.modules.interfaces.barcodescanner.BarCodeScannerInterface;
import expo.modules.interfaces.barcodescanner.BarCodeScannerProviderInterface;
import expo.modules.interfaces.barcodescanner.BarCodeScannerSettings;
import expo.modules.kotlin.AppContext;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: BarCodeScannerViewFinder.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u0000 52\u00020\u00012\u00020\u00022\u00020\u0003:\u00015B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0010H\u0016J \u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0016J\u0010\u0010'\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u0014H\u0016J \u0010(\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0016J\u0010\u0010)\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u0014H\u0016J\u001a\u0010*\u001a\u00020\u001e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010+\u001a\u00020!H\u0002J\u0010\u0010,\u001a\u00020\u001e2\b\u0010-\u001a\u0004\u0018\u00010.J\u000e\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u0007J\b\u00101\u001a\u00020\u001eH\u0002J\b\u00102\u001a\u00020\u001eH\u0002J\b\u00103\u001a\u00020\u001eH\u0002J\b\u00104\u001a\u00020\u001eH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u00066"}, d2 = {"Lexpo/modules/barcodescanner/BarCodeScannerViewFinder;", "Landroid/view/TextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "Landroid/hardware/Camera$PreviewCallback;", "context", "Landroid/content/Context;", "cameraType", "", "barCodeScannerView", "Lexpo/modules/barcodescanner/BarCodeScannerView;", "appContext", "Lexpo/modules/kotlin/AppContext;", "(Landroid/content/Context;ILexpo/modules/barcodescanner/BarCodeScannerView;Lexpo/modules/kotlin/AppContext;)V", "barCodeScanner", "Lexpo/modules/interfaces/barcodescanner/BarCodeScannerInterface;", "camera", "Landroid/hardware/Camera;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "finderSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "isChanging", "", "isStarting", "isStopping", "ratio", "", "getRatio", "()D", "initBarCodeScanner", "", "onPreviewFrame", "data", "", "innerCamera", "onSurfaceTextureAvailable", "surface", "width", "height", "onSurfaceTextureDestroyed", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "scanForBarcodes", "mImageData", "setBarCodeScannerSettings", "settings", "Lexpo/modules/interfaces/barcodescanner/BarCodeScannerSettings;", "setCameraType", "type", "startCamera", "startPreview", "stopCamera", "stopPreview", "Companion", "expo-barcode-scanner_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BarCodeScannerViewFinder extends TextureView implements TextureView.SurfaceTextureListener, Camera.PreviewCallback {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile boolean barCodeScannerTaskLock;
    private final AppContext appContext;
    private BarCodeScannerInterface barCodeScanner;
    private BarCodeScannerView barCodeScannerView;
    private Camera camera;
    private int cameraType;
    private final CoroutineScope coroutineScope;
    private SurfaceTexture finderSurfaceTexture;
    private volatile boolean isChanging;
    private volatile boolean isStarting;
    private volatile boolean isStopping;

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
        Intrinsics.checkNotNullParameter(surface, "surface");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BarCodeScannerViewFinder(Context context, int i, BarCodeScannerView barCodeScannerView, AppContext appContext) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(barCodeScannerView, "barCodeScannerView");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.cameraType = i;
        this.barCodeScannerView = barCodeScannerView;
        this.appContext = appContext;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        setSurfaceTextureListener(this);
        initBarCodeScanner();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        this.finderSurfaceTexture = surface;
        startCamera();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        this.finderSurfaceTexture = null;
        stopCamera();
        try {
            CoroutineScopeKt.cancel(this.coroutineScope, new ModuleDestroyedException("View destroyed, scope canceled"));
            return true;
        } catch (Exception e) {
            String message = e.getMessage();
            if (message == null) {
                message = "";
            }
            Log.w("ScannerViewFinder", message, e);
            return true;
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        this.finderSurfaceTexture = surface;
    }

    public final double getRatio() {
        return ExpoBarCodeScanner.INSTANCE.getInstance().getPreviewWidth(this.cameraType) / ExpoBarCodeScanner.INSTANCE.getInstance().getPreviewHeight(this.cameraType);
    }

    public final void setCameraType(final int type) {
        if (this.cameraType == type) {
            return;
        }
        new Thread(new Runnable() { // from class: expo.modules.barcodescanner.BarCodeScannerViewFinder$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BarCodeScannerViewFinder.setCameraType$lambda$0(BarCodeScannerViewFinder.this, type);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setCameraType$lambda$0(BarCodeScannerViewFinder this$0, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isChanging = true;
        this$0.stopPreview();
        this$0.cameraType = i;
        this$0.startPreview();
        this$0.isChanging = false;
    }

    private final void startPreview() {
        if (this.finderSurfaceTexture != null) {
            startCamera();
        }
    }

    private final void stopPreview() {
        if (this.camera != null) {
            stopCamera();
        }
    }

    private final synchronized void startCamera() {
        if (!this.isStarting && !this.isStopping) {
            this.isStarting = true;
            try {
                try {
                    Camera acquireCameraInstance = ExpoBarCodeScanner.INSTANCE.getInstance().acquireCameraInstance(this.cameraType);
                    this.camera = acquireCameraInstance;
                    if (acquireCameraInstance != null) {
                        Camera.Parameters parameters = acquireCameraInstance.getParameters();
                        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
                        if (supportedFocusModes != null && supportedFocusModes.contains("continuous-picture")) {
                            parameters.setFocusMode("continuous-picture");
                        }
                        ExpoBarCodeScanner companion = ExpoBarCodeScanner.INSTANCE.getInstance();
                        List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
                        Intrinsics.checkNotNullExpressionValue(supportedPictureSizes, "temporaryParameters.supportedPictureSizes");
                        Camera.Size bestSize = companion.getBestSize(supportedPictureSizes, Integer.MAX_VALUE, Integer.MAX_VALUE);
                        if (parameters != null) {
                            parameters.setPictureSize(bestSize.width, bestSize.height);
                        }
                        acquireCameraInstance.setParameters(parameters);
                        acquireCameraInstance.setPreviewTexture(this.finderSurfaceTexture);
                        acquireCameraInstance.startPreview();
                        acquireCameraInstance.setPreviewCallback(this);
                        this.barCodeScannerView.layoutViewFinder();
                    }
                } catch (NullPointerException e) {
                    e.printStackTrace();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    stopCamera();
                }
            } finally {
                this.isStarting = false;
            }
        }
    }

    private final synchronized void stopCamera() {
        if (!this.isStopping) {
            this.isStopping = true;
            try {
                try {
                    Camera camera = this.camera;
                    if (camera != null) {
                        camera.stopPreview();
                        camera.setPreviewCallback(null);
                        ExpoBarCodeScanner.INSTANCE.getInstance().releaseCameraInstance();
                    }
                    this.camera = null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                this.isStopping = false;
            }
        }
    }

    private final void initBarCodeScanner() {
        Object obj;
        try {
            obj = this.appContext.getLegacyModuleRegistry().getModule(BarCodeScannerProviderInterface.class);
        } catch (Exception unused) {
            obj = null;
        }
        BarCodeScannerProviderInterface barCodeScannerProviderInterface = (BarCodeScannerProviderInterface) obj;
        this.barCodeScanner = barCodeScannerProviderInterface != null ? barCodeScannerProviderInterface.createBarCodeDetectorWithContext(getContext()) : null;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] data, Camera innerCamera) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(innerCamera, "innerCamera");
        if (barCodeScannerTaskLock) {
            return;
        }
        barCodeScannerTaskLock = true;
        scanForBarcodes(innerCamera, data);
    }

    public final void setBarCodeScannerSettings(BarCodeScannerSettings settings) {
        BarCodeScannerInterface barCodeScannerInterface = this.barCodeScanner;
        if (barCodeScannerInterface != null) {
            barCodeScannerInterface.setSettings(settings);
        }
    }

    private final void scanForBarcodes(Camera camera, byte[] mImageData) {
        if (CoroutineScopeKt.isActive(this.coroutineScope)) {
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new BarCodeScannerViewFinder$scanForBarcodes$1(this, camera, mImageData, null), 3, null);
        } else {
            barCodeScannerTaskLock = false;
        }
    }

    /* compiled from: BarCodeScannerViewFinder.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lexpo/modules/barcodescanner/BarCodeScannerViewFinder$Companion;", "", "()V", "barCodeScannerTaskLock", "", "getBarCodeScannerTaskLock", "()Z", "setBarCodeScannerTaskLock", "(Z)V", "expo-barcode-scanner_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getBarCodeScannerTaskLock() {
            return BarCodeScannerViewFinder.barCodeScannerTaskLock;
        }

        public final void setBarCodeScannerTaskLock(boolean z) {
            BarCodeScannerViewFinder.barCodeScannerTaskLock = z;
        }
    }
}
