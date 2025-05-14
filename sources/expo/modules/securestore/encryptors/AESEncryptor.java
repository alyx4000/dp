package expo.modules.securestore.encryptors;

import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import com.amplitude.reactnative.DatabaseConstants;
import com.google.android.gms.stats.CodePackage;
import expo.modules.securestore.AuthenticationHelper;
import expo.modules.securestore.SecureStoreModule;
import expo.modules.securestore.SecureStoreOptions;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.UnrecoverableEntryException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.GCMParameterSpec;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: AESEncryptor.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0003J9\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ%\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0014J9\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\rH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u0018\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0017\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Lexpo/modules/securestore/encryptors/AESEncryptor;", "Lexpo/modules/securestore/encryptors/KeyBasedEncryptor;", "Ljava/security/KeyStore$SecretKeyEntry;", "()V", "createEncryptedItem", "Lorg/json/JSONObject;", "plaintextValue", "", "keyStoreEntry", AuthenticationHelper.REQUIRE_AUTHENTICATION_PROPERTY, "", "authenticationPrompt", "authenticationHelper", "Lexpo/modules/securestore/AuthenticationHelper;", "(Ljava/lang/String;Ljava/security/KeyStore$SecretKeyEntry;ZLjava/lang/String;Lexpo/modules/securestore/AuthenticationHelper;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createEncryptedItemWithCipher", "cipher", "Ljavax/crypto/Cipher;", "gcmSpec", "Ljavax/crypto/spec/GCMParameterSpec;", "createEncryptedItemWithCipher$expo_secure_store_release", "decryptItem", DatabaseConstants.KEY_FIELD, "encryptedItem", "options", "Lexpo/modules/securestore/SecureStoreOptions;", "(Ljava/lang/String;Lorg/json/JSONObject;Ljava/security/KeyStore$SecretKeyEntry;Lexpo/modules/securestore/SecureStoreOptions;Lexpo/modules/securestore/AuthenticationHelper;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getExtendedKeyStoreAlias", "getKeyStoreAlias", "initializeKeyStoreEntry", "keyStore", "Ljava/security/KeyStore;", "Companion", "expo-secure-store_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AESEncryptor implements KeyBasedEncryptor<KeyStore.SecretKeyEntry> {
    public static final String AES_CIPHER = "AES/GCM/NoPadding";
    public static final int AES_KEY_SIZE_BITS = 256;
    private static final String CIPHERTEXT_PROPERTY = "ct";
    private static final String GCM_AUTHENTICATION_TAG_LENGTH_PROPERTY = "tlen";
    public static final String IV_PROPERTY = "iv";
    private static final int MIN_GCM_AUTHENTICATION_TAG_LENGTH = 96;
    public static final String NAME = "aes";

    @Override // expo.modules.securestore.encryptors.KeyBasedEncryptor
    public /* bridge */ /* synthetic */ Object createEncryptedItem(String str, KeyStore.SecretKeyEntry secretKeyEntry, boolean z, String str2, AuthenticationHelper authenticationHelper, Continuation continuation) {
        return createEncryptedItem2(str, secretKeyEntry, z, str2, authenticationHelper, (Continuation<? super JSONObject>) continuation);
    }

    @Override // expo.modules.securestore.encryptors.KeyBasedEncryptor
    public /* bridge */ /* synthetic */ Object decryptItem(String str, JSONObject jSONObject, KeyStore.SecretKeyEntry secretKeyEntry, SecureStoreOptions secureStoreOptions, AuthenticationHelper authenticationHelper, Continuation continuation) {
        return decryptItem2(str, jSONObject, secretKeyEntry, secureStoreOptions, authenticationHelper, (Continuation<? super String>) continuation);
    }

    @Override // expo.modules.securestore.encryptors.KeyBasedEncryptor
    public String getKeyStoreAlias(SecureStoreOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        return "AES/GCM/NoPadding:" + options.getKeychainService();
    }

    @Override // expo.modules.securestore.encryptors.KeyBasedEncryptor
    public String getExtendedKeyStoreAlias(SecureStoreOptions options, boolean requireAuthentication) {
        Intrinsics.checkNotNullParameter(options, "options");
        return getKeyStoreAlias(options) + ":" + (requireAuthentication ? SecureStoreModule.AUTHENTICATED_KEYSTORE_SUFFIX : SecureStoreModule.UNAUTHENTICATED_KEYSTORE_SUFFIX);
    }

    @Override // expo.modules.securestore.encryptors.KeyBasedEncryptor
    public KeyStore.SecretKeyEntry initializeKeyStoreEntry(KeyStore keyStore, SecureStoreOptions options) throws GeneralSecurityException {
        Intrinsics.checkNotNullParameter(keyStore, "keyStore");
        Intrinsics.checkNotNullParameter(options, "options");
        String extendedKeyStoreAlias = getExtendedKeyStoreAlias(options, options.getRequireAuthentication());
        KeyGenParameterSpec build = new KeyGenParameterSpec.Builder(extendedKeyStoreAlias, 3).setKeySize(256).setBlockModes(CodePackage.GCM).setEncryptionPaddings("NoPadding").setUserAuthenticationRequired(options.getRequireAuthentication()).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder(extendedKeystore…ntication)\n      .build()");
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", keyStore.getProvider());
        keyGenerator.init(build);
        keyGenerator.generateKey();
        KeyStore.Entry entry = keyStore.getEntry(extendedKeyStoreAlias, null);
        KeyStore.SecretKeyEntry secretKeyEntry = entry instanceof KeyStore.SecretKeyEntry ? (KeyStore.SecretKeyEntry) entry : null;
        if (secretKeyEntry != null) {
            return secretKeyEntry;
        }
        throw new UnrecoverableEntryException("Could not retrieve the newly generated secret key entry");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: createEncryptedItem, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object createEncryptedItem2(java.lang.String r6, java.security.KeyStore.SecretKeyEntry r7, boolean r8, java.lang.String r9, expo.modules.securestore.AuthenticationHelper r10, kotlin.coroutines.Continuation<? super org.json.JSONObject> r11) throws javax.crypto.IllegalBlockSizeException, java.security.GeneralSecurityException {
        /*
            r5 = this;
            boolean r0 = r11 instanceof expo.modules.securestore.encryptors.AESEncryptor$createEncryptedItem$1
            if (r0 == 0) goto L14
            r0 = r11
            expo.modules.securestore.encryptors.AESEncryptor$createEncryptedItem$1 r0 = (expo.modules.securestore.encryptors.AESEncryptor$createEncryptedItem$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            expo.modules.securestore.encryptors.AESEncryptor$createEncryptedItem$1 r0 = new expo.modules.securestore.encryptors.AESEncryptor$createEncryptedItem$1
            r0.<init>(r5, r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L41
            if (r2 != r3) goto L39
            java.lang.Object r6 = r0.L$2
            javax.crypto.spec.GCMParameterSpec r6 = (javax.crypto.spec.GCMParameterSpec) r6
            java.lang.Object r7 = r0.L$1
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r0.L$0
            expo.modules.securestore.encryptors.AESEncryptor r8 = (expo.modules.securestore.encryptors.AESEncryptor) r8
            kotlin.ResultKt.throwOnFailure(r11)
            r4 = r7
            r7 = r6
            r6 = r4
            goto L74
        L39:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L41:
            kotlin.ResultKt.throwOnFailure(r11)
            javax.crypto.SecretKey r7 = r7.getSecretKey()
            java.lang.String r11 = "AES/GCM/NoPadding"
            javax.crypto.Cipher r11 = javax.crypto.Cipher.getInstance(r11)
            java.security.Key r7 = (java.security.Key) r7
            r11.init(r3, r7)
            java.security.AlgorithmParameters r7 = r11.getParameters()
            java.lang.Class<javax.crypto.spec.GCMParameterSpec> r2 = javax.crypto.spec.GCMParameterSpec.class
            java.security.spec.AlgorithmParameterSpec r7 = r7.getParameterSpec(r2)
            javax.crypto.spec.GCMParameterSpec r7 = (javax.crypto.spec.GCMParameterSpec) r7
            java.lang.String r2 = "cipher"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r2)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.label = r3
            java.lang.Object r11 = r10.authenticateCipher(r11, r8, r9, r0)
            if (r11 != r1) goto L73
            return r1
        L73:
            r8 = r5
        L74:
            javax.crypto.Cipher r11 = (javax.crypto.Cipher) r11
            java.lang.String r9 = "gcmSpec"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r9)
            org.json.JSONObject r6 = r8.createEncryptedItemWithCipher$expo_secure_store_release(r6, r11, r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.securestore.encryptors.AESEncryptor.createEncryptedItem2(java.lang.String, java.security.KeyStore$SecretKeyEntry, boolean, java.lang.String, expo.modules.securestore.AuthenticationHelper, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final JSONObject createEncryptedItemWithCipher$expo_secure_store_release(String plaintextValue, Cipher cipher, GCMParameterSpec gcmSpec) {
        Intrinsics.checkNotNullParameter(plaintextValue, "plaintextValue");
        Intrinsics.checkNotNullParameter(cipher, "cipher");
        Intrinsics.checkNotNullParameter(gcmSpec, "gcmSpec");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        byte[] bytes = plaintextValue.getBytes(UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        String encodeToString = Base64.encodeToString(cipher.doFinal(bytes), 2);
        String encodeToString2 = Base64.encodeToString(gcmSpec.getIV(), 2);
        JSONObject put = new JSONObject().put(CIPHERTEXT_PROPERTY, encodeToString).put(IV_PROPERTY, encodeToString2).put(GCM_AUTHENTICATION_TAG_LENGTH_PROPERTY, gcmSpec.getTLen());
        Intrinsics.checkNotNullExpressionValue(put, "JSONObject()\n      .put(… authenticationTagLength)");
        return put;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: decryptItem, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object decryptItem2(java.lang.String r9, org.json.JSONObject r10, java.security.KeyStore.SecretKeyEntry r11, expo.modules.securestore.SecureStoreOptions r12, expo.modules.securestore.AuthenticationHelper r13, kotlin.coroutines.Continuation<? super java.lang.String> r14) throws java.security.GeneralSecurityException, org.json.JSONException {
        /*
            r8 = this;
            boolean r0 = r14 instanceof expo.modules.securestore.encryptors.AESEncryptor$decryptItem$1
            if (r0 == 0) goto L14
            r0 = r14
            expo.modules.securestore.encryptors.AESEncryptor$decryptItem$1 r0 = (expo.modules.securestore.encryptors.AESEncryptor$decryptItem$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L19
        L14:
            expo.modules.securestore.encryptors.AESEncryptor$decryptItem$1 r0 = new expo.modules.securestore.encryptors.AESEncryptor$decryptItem$1
            r0.<init>(r8, r14)
        L19:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r9 = r0.L$0
            byte[] r9 = (byte[]) r9
            kotlin.ResultKt.throwOnFailure(r14)
            goto L8c
        L2e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L36:
            kotlin.ResultKt.throwOnFailure(r14)
            java.lang.String r14 = "ct"
            java.lang.String r14 = r10.getString(r14)
            java.lang.String r2 = "iv"
            java.lang.String r2 = r10.getString(r2)
            java.lang.String r4 = "tlen"
            int r4 = r10.getInt(r4)
            r5 = 0
            byte[] r14 = android.util.Base64.decode(r14, r5)
            byte[] r2 = android.util.Base64.decode(r2, r5)
            javax.crypto.spec.GCMParameterSpec r5 = new javax.crypto.spec.GCMParameterSpec
            r5.<init>(r4, r2)
            java.lang.String r2 = "AES/GCM/NoPadding"
            javax.crypto.Cipher r2 = javax.crypto.Cipher.getInstance(r2)
            java.lang.String r6 = "requireAuthentication"
            boolean r10 = r10.optBoolean(r6)
            r6 = 96
            if (r4 < r6) goto La4
            javax.crypto.SecretKey r9 = r11.getSecretKey()
            java.security.Key r9 = (java.security.Key) r9
            java.security.spec.AlgorithmParameterSpec r5 = (java.security.spec.AlgorithmParameterSpec) r5
            r11 = 2
            r2.init(r11, r9, r5)
            java.lang.String r9 = "cipher"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r9)
            java.lang.String r9 = r12.getAuthenticationPrompt()
            r0.L$0 = r14
            r0.label = r3
            java.lang.Object r9 = r13.authenticateCipher(r2, r10, r9, r0)
            if (r9 != r1) goto L89
            return r1
        L89:
            r7 = r14
            r14 = r9
            r9 = r7
        L8c:
            javax.crypto.Cipher r14 = (javax.crypto.Cipher) r14
            byte[] r9 = r14.doFinal(r9)
            java.lang.String r10 = "unlockedCipher.doFinal(ciphertextBytes)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            java.nio.charset.Charset r10 = java.nio.charset.StandardCharsets.UTF_8
            java.lang.String r11 = "UTF_8"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)
            java.lang.String r11 = new java.lang.String
            r11.<init>(r9, r10)
            return r11
        La4:
            expo.modules.securestore.DecryptException r10 = new expo.modules.securestore.DecryptException
            java.lang.String r1 = "Authentication tag length must be at least 96 bits long"
            java.lang.String r3 = r12.getKeychainService()
            r4 = 0
            r5 = 8
            r6 = 0
            r0 = r10
            r2 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.securestore.encryptors.AESEncryptor.decryptItem2(java.lang.String, org.json.JSONObject, java.security.KeyStore$SecretKeyEntry, expo.modules.securestore.SecureStoreOptions, expo.modules.securestore.AuthenticationHelper, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
