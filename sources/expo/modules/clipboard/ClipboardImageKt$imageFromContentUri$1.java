package expo.modules.clipboard;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ClipboardImage.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.clipboard.ClipboardImageKt", f = "ClipboardImage.kt", i = {0, 1, 1, 1}, l = {58, 66}, m = "imageFromContentUri", n = {"options", "bitmap", "format", "outputStream"}, s = {"L$0", "L$0", "L$1", "L$2"})
/* loaded from: classes3.dex */
final class ClipboardImageKt$imageFromContentUri$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    ClipboardImageKt$imageFromContentUri$1(Continuation<? super ClipboardImageKt$imageFromContentUri$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ClipboardImageKt.imageFromContentUri(null, null, null, this);
    }
}
