package expo.modules.barcodescanner.scanners;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.facebook.react.uimanager.ViewProps;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.BarcodeScanning;
import com.google.mlkit.vision.common.InputImage;
import expo.modules.interfaces.barcodescanner.BarCodeScannerResult;
import expo.modules.interfaces.barcodescanner.BarCodeScannerSettings;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: MLKitBarCodeScanner.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J*\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000b¨\u0006 "}, d2 = {"Lexpo/modules/barcodescanner/scanners/MLKitBarCodeScanner;", "Lexpo/modules/barcodescanner/scanners/ExpoBarCodeScanner;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "barcodeScanner", "Lcom/google/mlkit/vision/barcode/BarcodeScanner;", "barcodeScannerOptions", "Lcom/google/mlkit/vision/barcode/BarcodeScannerOptions;", "isAvailable", "", "()Z", "scan", "Lexpo/modules/interfaces/barcodescanner/BarCodeScannerResult;", "imageData", "", "width", "", "height", ViewProps.ROTATION, "scanBlocking", "", "inputImage", "Lcom/google/mlkit/vision/common/InputImage;", "scanMultiple", "bitmap", "Landroid/graphics/Bitmap;", "setSettings", "", "settings", "Lexpo/modules/interfaces/barcodescanner/BarCodeScannerSettings;", "Companion", "expo-barcode-scanner_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MLKitBarCodeScanner extends ExpoBarCodeScanner {
    private static final String TAG = "MLKitBarCodeScanner";
    private BarcodeScanner barcodeScanner;
    private BarcodeScannerOptions barcodeScannerOptions;

    @Override // expo.modules.barcodescanner.scanners.ExpoBarCodeScanner
    public boolean isAvailable() {
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MLKitBarCodeScanner(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        BarcodeScannerOptions build = new BarcodeScannerOptions.Builder().setBarcodeFormats(0, new int[0]).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n      .setBarc…L_FORMATS)\n      .build()");
        this.barcodeScannerOptions = build;
        BarcodeScanner client = BarcodeScanning.getClient(build);
        Intrinsics.checkNotNullExpressionValue(client, "getClient(barcodeScannerOptions)");
        this.barcodeScanner = client;
    }

    @Override // expo.modules.interfaces.barcodescanner.BarCodeScannerInterface
    public BarCodeScannerResult scan(byte[] imageData, int width, int height, int rotation) {
        Intrinsics.checkNotNullParameter(imageData, "imageData");
        try {
            InputImage fromByteArray = InputImage.fromByteArray(imageData, width, height, rotation, 17);
            Intrinsics.checkNotNullExpressionValue(fromByteArray, "fromByteArray(imageData,…tImage.IMAGE_FORMAT_NV21)");
            List<BarCodeScannerResult> scanBlocking = scanBlocking(fromByteArray);
            if (!scanBlocking.isEmpty()) {
                return scanBlocking.get(0);
            }
            return null;
        } catch (Exception e) {
            Log.e(TAG, "Failed to detect barcode: " + e.getMessage());
            return null;
        }
    }

    @Override // expo.modules.interfaces.barcodescanner.BarCodeScannerInterface
    public List<BarCodeScannerResult> scanMultiple(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        InputImage fromBitmap = InputImage.fromBitmap(bitmap, 0);
        Intrinsics.checkNotNullExpressionValue(fromBitmap, "fromBitmap(bitmap, 0)");
        return scanBlocking(fromBitmap);
    }

    private final List<BarCodeScannerResult> scanBlocking(InputImage inputImage) {
        return (List) BuildersKt.runBlocking(Dispatchers.getIO(), new MLKitBarCodeScanner$scanBlocking$1(this, inputImage, null));
    }

    @Override // expo.modules.interfaces.barcodescanner.BarCodeScannerInterface
    public void setSettings(BarCodeScannerSettings settings) {
        int i;
        Intrinsics.checkNotNullParameter(settings, "settings");
        List<Integer> parseBarCodeTypesFromSettings = parseBarCodeTypesFromSettings(settings);
        if (areNewAndOldBarCodeTypesEqual(parseBarCodeTypesFromSettings)) {
            return;
        }
        if (parseBarCodeTypesFromSettings != null) {
            Iterator<T> it = parseBarCodeTypesFromSettings.iterator();
            if (!it.hasNext()) {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
            Object next = it.next();
            while (it.hasNext()) {
                next = Integer.valueOf(((Number) next).intValue() | ((Number) it.next()).intValue());
            }
            i = ((Number) next).intValue();
        } else {
            i = 0;
        }
        setBarCodeTypes(parseBarCodeTypesFromSettings);
        BarcodeScannerOptions build = new BarcodeScannerOptions.Builder().setBarcodeFormats(i, new int[0]).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n      .setBarc…deFormats)\n      .build()");
        this.barcodeScannerOptions = build;
        BarcodeScanner client = BarcodeScanning.getClient(build);
        Intrinsics.checkNotNullExpressionValue(client, "getClient(barcodeScannerOptions)");
        this.barcodeScanner = client;
    }
}
