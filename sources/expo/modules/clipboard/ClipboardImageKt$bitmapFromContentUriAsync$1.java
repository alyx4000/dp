package expo.modules.clipboard;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ClipboardImage.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.clipboard.ClipboardImageKt", f = "ClipboardImage.kt", i = {}, l = {131}, m = "bitmapFromContentUriAsync", n = {}, s = {})
/* loaded from: classes3.dex */
final class ClipboardImageKt$bitmapFromContentUriAsync$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    ClipboardImageKt$bitmapFromContentUriAsync$1(Continuation<? super ClipboardImageKt$bitmapFromContentUriAsync$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ClipboardImageKt.bitmapFromContentUriAsync(null, null, this);
    }
}
