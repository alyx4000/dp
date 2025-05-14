package expo.modules.securestore;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AuthenticationHelper.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.securestore.AuthenticationHelper", f = "AuthenticationHelper.kt", i = {}, l = {24}, m = "authenticateCipher", n = {}, s = {})
/* loaded from: classes2.dex */
final class AuthenticationHelper$authenticateCipher$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AuthenticationHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AuthenticationHelper$authenticateCipher$1(AuthenticationHelper authenticationHelper, Continuation<? super AuthenticationHelper$authenticateCipher$1> continuation) {
        super(continuation);
        this.this$0 = authenticationHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.authenticateCipher(null, false, null, this);
    }
}
