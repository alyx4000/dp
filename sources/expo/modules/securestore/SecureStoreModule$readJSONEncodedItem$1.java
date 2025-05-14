package expo.modules.securestore;

import com.amplitude.reactnative.DatabaseConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SecureStoreModule.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.securestore.SecureStoreModule", f = "SecureStoreModule.kt", i = {0, 0, 0, 1, 1, 1}, l = {129, 134}, m = "readJSONEncodedItem", n = {DatabaseConstants.KEY_FIELD, "options", "legacyReadFailedWarning", DatabaseConstants.KEY_FIELD, "options", "legacyReadFailedWarning"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
/* loaded from: classes2.dex */
final class SecureStoreModule$readJSONEncodedItem$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SecureStoreModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SecureStoreModule$readJSONEncodedItem$1(SecureStoreModule secureStoreModule, Continuation<? super SecureStoreModule$readJSONEncodedItem$1> continuation) {
        super(continuation);
        this.this$0 = secureStoreModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object readJSONEncodedItem;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        readJSONEncodedItem = this.this$0.readJSONEncodedItem(null, null, null, this);
        return readJSONEncodedItem;
    }
}
