package expo.modules.barcodescanner;

import android.graphics.Bitmap;
import expo.modules.barcodescanner.utils.BarCodeScannerResultSerializer;
import expo.modules.interfaces.barcodescanner.BarCodeScannerInterface;
import expo.modules.interfaces.barcodescanner.BarCodeScannerResult;
import expo.modules.kotlin.Promise;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BarCodeScannerModule.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.barcodescanner.BarCodeScannerModule$definition$1$3$1$onSuccess$2", f = "BarCodeScannerModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class BarCodeScannerModule$definition$1$3$1$onSuccess$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Integer> $barCodeTypes;
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ Promise $promise;
    final /* synthetic */ BarCodeScannerInterface $scanner;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BarCodeScannerModule$definition$1$3$1$onSuccess$2(BarCodeScannerInterface barCodeScannerInterface, Bitmap bitmap, Promise promise, List<Integer> list, Continuation<? super BarCodeScannerModule$definition$1$3$1$onSuccess$2> continuation) {
        super(2, continuation);
        this.$scanner = barCodeScannerInterface;
        this.$bitmap = bitmap;
        this.$promise = promise;
        this.$barCodeTypes = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BarCodeScannerModule$definition$1$3$1$onSuccess$2(this.$scanner, this.$bitmap, this.$promise, this.$barCodeTypes, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BarCodeScannerModule$definition$1$3$1$onSuccess$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List<BarCodeScannerResult> scanMultiple = this.$scanner.scanMultiple(this.$bitmap);
        Intrinsics.checkNotNullExpressionValue(scanMultiple, "scanner.scanMultiple(bitmap)");
        List<Integer> list = this.$barCodeTypes;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : scanMultiple) {
            if (list.contains(Boxing.boxInt(((BarCodeScannerResult) obj2).getType()))) {
                arrayList.add(obj2);
            }
        }
        ArrayList<BarCodeScannerResult> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (BarCodeScannerResult it : arrayList2) {
            BarCodeScannerResultSerializer barCodeScannerResultSerializer = BarCodeScannerResultSerializer.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList3.add(barCodeScannerResultSerializer.toBundle(it, 1.0f));
        }
        this.$promise.resolve(arrayList3);
        return Unit.INSTANCE;
    }
}
