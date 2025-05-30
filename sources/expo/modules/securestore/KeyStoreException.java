package expo.modules.securestore;

import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;

/* compiled from: SecureStoreExceptions.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lexpo/modules/securestore/KeyStoreException;", "Lexpo/modules/kotlin/exception/CodedException;", "message", "", "(Ljava/lang/String;)V", "expo-secure-store_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class KeyStoreException extends CodedException {
    public KeyStoreException(String str) {
        super("An error occurred when accessing the keystore: " + (str == null ? "unknown" : str), null, 2, null);
    }
}
