package expo.modules.clipboard;

import android.content.ClipData;
import android.content.Context;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AsyncFunctionBuilder.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u0001*\u00020\u00042\u0010\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0006H\u008a@¨\u0006\b"}, d2 = {"<anonymous>", "", "R", "P0", "Lkotlinx/coroutines/CoroutineScope;", "it", "", "expo/modules/kotlin/functions/AsyncFunctionBuilder$SuspendBody$4", "expo/modules/kotlin/functions/AsyncFunctionBuilderKt$Coroutine$$inlined$SuspendBody$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$Coroutine$4", f = "ClipboardModule.kt", i = {}, l = {174}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class ClipboardModule$definition$lambda$12$$inlined$Coroutine$4 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ClipboardModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClipboardModule$definition$lambda$12$$inlined$Coroutine$4(Continuation continuation, ClipboardModule clipboardModule) {
        super(3, continuation);
        this.this$0 = clipboardModule;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
        ClipboardModule$definition$lambda$12$$inlined$Coroutine$4 clipboardModule$definition$lambda$12$$inlined$Coroutine$4 = new ClipboardModule$definition$lambda$12$$inlined$Coroutine$4(continuation, this.this$0);
        clipboardModule$definition$lambda$12$$inlined$Coroutine$4.L$0 = objArr;
        return clipboardModule$definition$lambda$12$$inlined$Coroutine$4.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Context context;
        File clipboardCacheDir;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Object obj2 = ((Object[]) this.L$0)[0];
                if (obj2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                String str = (String) obj2;
                context = this.this$0.getContext();
                clipboardCacheDir = this.this$0.getClipboardCacheDir();
                this.label = 1;
                obj = ClipboardImageKt.clipDataFromBase64Image(context, str, clipboardCacheDir, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.this$0.getClipboardManager().setPrimaryClip((ClipData) obj);
            return Unit.INSTANCE;
        } finally {
        }
    }
}
