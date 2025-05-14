package expo.modules.securestore.encryptors;

import expo.modules.securestore.AuthenticationHelper;
import java.security.KeyStore;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.json.JSONObject;

/* compiled from: AESEncryptor.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.securestore.encryptors.AESEncryptor", f = "AESEncryptor.kt", i = {0, 0, 0}, l = {88}, m = "createEncryptedItem", n = {"this", "plaintextValue", "gcmSpec"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes2.dex */
final class AESEncryptor$createEncryptedItem$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AESEncryptor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AESEncryptor$createEncryptedItem$1(AESEncryptor aESEncryptor, Continuation<? super AESEncryptor$createEncryptedItem$1> continuation) {
        super(continuation);
        this.this$0 = aESEncryptor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.createEncryptedItem2((String) null, (KeyStore.SecretKeyEntry) null, false, (String) null, (AuthenticationHelper) null, (Continuation<? super JSONObject>) this);
    }
}
