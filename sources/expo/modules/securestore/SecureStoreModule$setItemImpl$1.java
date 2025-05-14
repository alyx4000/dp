package expo.modules.securestore;

import com.amplitude.reactnative.DatabaseConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SecureStoreModule.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.securestore.SecureStoreModule", f = "SecureStoreModule.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {180, 191}, m = "setItemImpl", n = {"this", DatabaseConstants.KEY_FIELD, "value", "options", "keychainAwareKey", "prefs", "keyIsInvalidated"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0"})
/* loaded from: classes2.dex */
final class SecureStoreModule$setItemImpl$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SecureStoreModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SecureStoreModule$setItemImpl$1(SecureStoreModule secureStoreModule, Continuation<? super SecureStoreModule$setItemImpl$1> continuation) {
        super(continuation);
        this.this$0 = secureStoreModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object itemImpl;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        itemImpl = this.this$0.setItemImpl(null, null, null, false, this);
        return itemImpl;
    }
}
