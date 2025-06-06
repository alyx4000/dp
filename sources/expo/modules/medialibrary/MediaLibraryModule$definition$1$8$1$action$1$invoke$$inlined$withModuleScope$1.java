package expo.modules.medialibrary;

import expo.modules.core.errors.ModuleDestroyedException;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.medialibrary.assets.DeleteAssets;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: MediaLibraryModule.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "expo/modules/medialibrary/MediaLibraryModule$withModuleScope$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.medialibrary.MediaLibraryModule$definition$1$8$1$action$1$invoke$$inlined$withModuleScope$1", f = "MediaLibraryModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class MediaLibraryModule$definition$1$8$1$action$1$invoke$$inlined$withModuleScope$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List $assetsId$inlined;
    final /* synthetic */ Promise $promise;
    final /* synthetic */ Promise $promise$inlined;
    int label;
    final /* synthetic */ MediaLibraryModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaLibraryModule$definition$1$8$1$action$1$invoke$$inlined$withModuleScope$1(Promise promise, Continuation continuation, MediaLibraryModule mediaLibraryModule, List list, Promise promise2) {
        super(2, continuation);
        this.$promise = promise;
        this.this$0 = mediaLibraryModule;
        this.$assetsId$inlined = list;
        this.$promise$inlined = promise2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MediaLibraryModule$definition$1$8$1$action$1$invoke$$inlined$withModuleScope$1(this.$promise, continuation, this.this$0, this.$assetsId$inlined, this.$promise$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MediaLibraryModule$definition$1$8$1$action$1$invoke$$inlined$withModuleScope$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        try {
            new DeleteAssets(this.this$0.getContext(), (String[]) this.$assetsId$inlined.toArray(new String[0]), this.$promise$inlined).execute();
        } catch (ModuleDestroyedException e) {
            Promise promise = this.$promise;
            String TAG = MediaLibraryModule.INSTANCE.getTAG$expo_media_library_release();
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            promise.reject(TAG, "MediaLibrary module destroyed", e);
        } catch (CodedException e2) {
            this.$promise.reject(e2);
        }
        return Unit.INSTANCE;
    }
}
