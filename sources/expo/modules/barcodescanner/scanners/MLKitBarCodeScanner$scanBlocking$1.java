package expo.modules.barcodescanner.scanners;

import com.google.mlkit.vision.common.InputImage;
import expo.modules.interfaces.barcodescanner.BarCodeScannerResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: MLKitBarCodeScanner.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lexpo/modules/interfaces/barcodescanner/BarCodeScannerResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.barcodescanner.scanners.MLKitBarCodeScanner$scanBlocking$1", f = "MLKitBarCodeScanner.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class MLKitBarCodeScanner$scanBlocking$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends BarCodeScannerResult>>, Object> {
    final /* synthetic */ InputImage $inputImage;
    int label;
    final /* synthetic */ MLKitBarCodeScanner this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MLKitBarCodeScanner$scanBlocking$1(MLKitBarCodeScanner mLKitBarCodeScanner, InputImage inputImage, Continuation<? super MLKitBarCodeScanner$scanBlocking$1> continuation) {
        super(2, continuation);
        this.this$0 = mLKitBarCodeScanner;
        this.$inputImage = inputImage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MLKitBarCodeScanner$scanBlocking$1(this.this$0, this.$inputImage, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends BarCodeScannerResult>> continuation) {
        return ((MLKitBarCodeScanner$scanBlocking$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0091 A[Catch: Exception -> 0x000f, TryCatch #0 {Exception -> 0x000f, blocks: (B:5:0x000b, B:6:0x003a, B:10:0x004f, B:11:0x0053, B:13:0x0059, B:15:0x0065, B:17:0x006b, B:18:0x0076, B:21:0x0083, B:23:0x0091, B:25:0x0096, B:27:0x00b7, B:29:0x007e, B:38:0x001d), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007e A[Catch: Exception -> 0x000f, TryCatch #0 {Exception -> 0x000f, blocks: (B:5:0x000b, B:6:0x003a, B:10:0x004f, B:11:0x0053, B:13:0x0059, B:15:0x0065, B:17:0x006b, B:18:0x0076, B:21:0x0083, B:23:0x0091, B:25:0x0096, B:27:0x00b7, B:29:0x007e, B:38:0x001d), top: B:2:0x0007 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.barcodescanner.scanners.MLKitBarCodeScanner$scanBlocking$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
