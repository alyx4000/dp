package expo.modules.barcodescanner;

import android.content.Context;
import expo.modules.barcodescanner.scanners.MLKitBarCodeScanner;
import expo.modules.core.interfaces.InternalModule;
import expo.modules.interfaces.barcodescanner.BarCodeScannerInterface;
import expo.modules.interfaces.barcodescanner.BarCodeScannerProviderInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BarCodeScannerProvider.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n0\tH\u0016¨\u0006\u000b"}, d2 = {"Lexpo/modules/barcodescanner/BarCodeScannerProvider;", "Lexpo/modules/core/interfaces/InternalModule;", "Lexpo/modules/interfaces/barcodescanner/BarCodeScannerProviderInterface;", "()V", "createBarCodeDetectorWithContext", "Lexpo/modules/interfaces/barcodescanner/BarCodeScannerInterface;", "context", "Landroid/content/Context;", "getExportedInterfaces", "", "Ljava/lang/Class;", "expo-barcode-scanner_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BarCodeScannerProvider implements InternalModule, BarCodeScannerProviderInterface {
    @Override // expo.modules.core.interfaces.InternalModule
    public List<Class<BarCodeScannerProviderInterface>> getExportedInterfaces() {
        return CollectionsKt.listOf(BarCodeScannerProviderInterface.class);
    }

    @Override // expo.modules.interfaces.barcodescanner.BarCodeScannerProviderInterface
    public BarCodeScannerInterface createBarCodeDetectorWithContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new MLKitBarCodeScanner(context);
    }
}
