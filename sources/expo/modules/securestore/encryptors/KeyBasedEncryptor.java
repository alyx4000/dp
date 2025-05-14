package expo.modules.securestore.encryptors;

import androidx.exifinterface.media.ExifInterface;
import com.amplitude.reactnative.DatabaseConstants;
import expo.modules.securestore.AuthenticationHelper;
import expo.modules.securestore.SecureStoreOptions;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStore.Entry;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: KeyBasedEncryptor.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J9\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ9\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H&J\u001d\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u0013H&¢\u0006\u0002\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lexpo/modules/securestore/encryptors/KeyBasedEncryptor;", ExifInterface.LONGITUDE_EAST, "Ljava/security/KeyStore$Entry;", "", "createEncryptedItem", "Lorg/json/JSONObject;", "plaintextValue", "", "keyStoreEntry", AuthenticationHelper.REQUIRE_AUTHENTICATION_PROPERTY, "", "authenticationPrompt", "authenticationHelper", "Lexpo/modules/securestore/AuthenticationHelper;", "(Ljava/lang/String;Ljava/security/KeyStore$Entry;ZLjava/lang/String;Lexpo/modules/securestore/AuthenticationHelper;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "decryptItem", DatabaseConstants.KEY_FIELD, "encryptedItem", "options", "Lexpo/modules/securestore/SecureStoreOptions;", "(Ljava/lang/String;Lorg/json/JSONObject;Ljava/security/KeyStore$Entry;Lexpo/modules/securestore/SecureStoreOptions;Lexpo/modules/securestore/AuthenticationHelper;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getExtendedKeyStoreAlias", "getKeyStoreAlias", "initializeKeyStoreEntry", "keyStore", "Ljava/security/KeyStore;", "(Ljava/security/KeyStore;Lexpo/modules/securestore/SecureStoreOptions;)Ljava/security/KeyStore$Entry;", "expo-secure-store_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface KeyBasedEncryptor<E extends KeyStore.Entry> {
    Object createEncryptedItem(String str, E e, boolean z, String str2, AuthenticationHelper authenticationHelper, Continuation<? super JSONObject> continuation) throws GeneralSecurityException, JSONException;

    Object decryptItem(String str, JSONObject jSONObject, E e, SecureStoreOptions secureStoreOptions, AuthenticationHelper authenticationHelper, Continuation<? super String> continuation) throws GeneralSecurityException, JSONException;

    String getExtendedKeyStoreAlias(SecureStoreOptions options, boolean requireAuthentication);

    String getKeyStoreAlias(SecureStoreOptions options);

    E initializeKeyStoreEntry(KeyStore keyStore, SecureStoreOptions options) throws GeneralSecurityException;
}
