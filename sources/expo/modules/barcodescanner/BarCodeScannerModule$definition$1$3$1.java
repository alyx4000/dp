package expo.modules.barcodescanner;

import android.content.Context;
import android.graphics.Bitmap;
import expo.modules.interfaces.barcodescanner.BarCodeScannerInterface;
import expo.modules.interfaces.barcodescanner.BarCodeScannerSettings;
import expo.modules.interfaces.imageloader.ImageLoaderInterface;
import expo.modules.kotlin.Promise;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BarCodeScannerModule.kt */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"expo/modules/barcodescanner/BarCodeScannerModule$definition$1$3$1", "Lexpo/modules/interfaces/imageloader/ImageLoaderInterface$ResultListener;", "onFailure", "", "cause", "", "onSuccess", "bitmap", "Landroid/graphics/Bitmap;", "expo-barcode-scanner_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BarCodeScannerModule$definition$1$3$1 implements ImageLoaderInterface.ResultListener {
    final /* synthetic */ List<Integer> $barCodeTypes;
    final /* synthetic */ Promise $promise;
    final /* synthetic */ String $url;
    final /* synthetic */ BarCodeScannerModule this$0;

    BarCodeScannerModule$definition$1$3$1(BarCodeScannerModule barCodeScannerModule, List<Integer> list, Promise promise, String str) {
        this.this$0 = barCodeScannerModule;
        this.$barCodeTypes = list;
        this.$promise = promise;
        this.$url = str;
    }

    @Override // expo.modules.interfaces.imageloader.ImageLoaderInterface.ResultListener
    public void onSuccess(Bitmap bitmap) {
        BarCodeScannerProvider barCodeScannerProvider;
        Context context;
        CoroutineScope coroutineScope;
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        barCodeScannerProvider = this.this$0.barCodeScannerProvider;
        context = this.this$0.getContext();
        BarCodeScannerInterface createBarCodeDetectorWithContext = barCodeScannerProvider.createBarCodeDetectorWithContext(context);
        BarCodeScannerSettings barCodeScannerSettings = new BarCodeScannerSettings();
        barCodeScannerSettings.putTypes(this.$barCodeTypes);
        createBarCodeDetectorWithContext.setSettings(barCodeScannerSettings);
        coroutineScope = this.this$0.moduleCoroutineScope;
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new BarCodeScannerModule$definition$1$3$1$onSuccess$2(createBarCodeDetectorWithContext, bitmap, this.$promise, this.$barCodeTypes, null), 3, null);
    }

    @Override // expo.modules.interfaces.imageloader.ImageLoaderInterface.ResultListener
    public void onFailure(Throwable cause) {
        this.$promise.reject(new ImageRetrievalException(this.$url));
    }
}
