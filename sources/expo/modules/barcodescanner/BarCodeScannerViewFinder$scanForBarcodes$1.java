package expo.modules.barcodescanner;

import android.hardware.Camera;
import android.util.Log;
import com.google.mlkit.common.MlKitException;
import expo.modules.core.errors.ModuleDestroyedException;
import expo.modules.interfaces.barcodescanner.BarCodeScannerInterface;
import expo.modules.interfaces.barcodescanner.BarCodeScannerResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* compiled from: BarCodeScannerViewFinder.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.barcodescanner.BarCodeScannerViewFinder$scanForBarcodes$1", f = "BarCodeScannerViewFinder.kt", i = {}, l = {MlKitException.CODE_SCANNER_GOOGLE_PLAY_SERVICES_VERSION_TOO_OLD}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class BarCodeScannerViewFinder$scanForBarcodes$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Camera $camera;
    final /* synthetic */ byte[] $mImageData;
    int label;
    final /* synthetic */ BarCodeScannerViewFinder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BarCodeScannerViewFinder$scanForBarcodes$1(BarCodeScannerViewFinder barCodeScannerViewFinder, Camera camera, byte[] bArr, Continuation<? super BarCodeScannerViewFinder$scanForBarcodes$1> continuation) {
        super(2, continuation);
        this.this$0 = barCodeScannerViewFinder;
        this.$camera = camera;
        this.$mImageData = bArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BarCodeScannerViewFinder$scanForBarcodes$1(this.this$0, this.$camera, this.$mImageData, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BarCodeScannerViewFinder$scanForBarcodes$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        boolean z;
        Camera camera;
        BarCodeScannerInterface barCodeScannerInterface;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    coroutineScope = this.this$0.coroutineScope;
                    if (CoroutineScopeKt.isActive(coroutineScope)) {
                        z = this.this$0.isChanging;
                        if (!z && (camera = this.$camera) != null) {
                            Camera.Size previewSize = camera.getParameters().getPreviewSize();
                            int i2 = previewSize.width;
                            int i3 = previewSize.height;
                            int rotation = ExpoBarCodeScanner.INSTANCE.getInstance().getRotation();
                            barCodeScannerInterface = this.this$0.barCodeScanner;
                            BarCodeScannerResult scan = barCodeScannerInterface != null ? barCodeScannerInterface.scan(this.$mImageData, i2, i3, rotation) : null;
                            if (scan != null) {
                                this.label = 1;
                                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.this$0, scan, null), this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        }
                    } else {
                        return Unit.INSTANCE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (ModuleDestroyedException e) {
                String message = e.getMessage();
                if (message == null) {
                    message = "";
                }
                Log.w("BarCodeScanner", message, e);
            }
            return Unit.INSTANCE;
        } finally {
            BarCodeScannerViewFinder.INSTANCE.setBarCodeScannerTaskLock(false);
        }
    }

    /* compiled from: BarCodeScannerViewFinder.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.barcodescanner.BarCodeScannerViewFinder$scanForBarcodes$1$1", f = "BarCodeScannerViewFinder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: expo.modules.barcodescanner.BarCodeScannerViewFinder$scanForBarcodes$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
        final /* synthetic */ BarCodeScannerResult $result;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ BarCodeScannerViewFinder this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BarCodeScannerViewFinder barCodeScannerViewFinder, BarCodeScannerResult barCodeScannerResult, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = barCodeScannerViewFinder;
            this.$result = barCodeScannerResult;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$result, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Job> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: BarCodeScannerViewFinder.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "expo.modules.barcodescanner.BarCodeScannerViewFinder$scanForBarcodes$1$1$1", f = "BarCodeScannerViewFinder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: expo.modules.barcodescanner.BarCodeScannerViewFinder$scanForBarcodes$1$1$1, reason: invalid class name and collision with other inner class name */
        static final class C00491 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ BarCodeScannerResult $result;
            int label;
            final /* synthetic */ BarCodeScannerViewFinder this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00491(BarCodeScannerViewFinder barCodeScannerViewFinder, BarCodeScannerResult barCodeScannerResult, Continuation<? super C00491> continuation) {
                super(2, continuation);
                this.this$0 = barCodeScannerViewFinder;
                this.$result = barCodeScannerResult;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00491(this.this$0, this.$result, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00491) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineScope coroutineScope;
                BarCodeScannerView barCodeScannerView;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    coroutineScope = this.this$0.coroutineScope;
                    if (CoroutineScopeKt.isActive(coroutineScope)) {
                        barCodeScannerView = this.this$0.barCodeScannerView;
                        barCodeScannerView.onBarCodeScanned(this.$result);
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Job launch$default;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                launch$default = BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.L$0, null, null, new C00491(this.this$0, this.$result, null), 3, null);
                return launch$default;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
