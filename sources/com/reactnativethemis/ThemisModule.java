package com.reactnativethemis;

import com.cossacklabs.themis.Keypair;
import com.cossacklabs.themis.KeypairGenerator;
import com.cossacklabs.themis.PrivateKey;
import com.cossacklabs.themis.PublicKey;
import com.cossacklabs.themis.SecureCell;
import com.cossacklabs.themis.SecureCellData;
import com.cossacklabs.themis.SecureCompare;
import com.cossacklabs.themis.SecureMessage;
import com.cossacklabs.themis.SymmetricKey;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.iterable.iterableapi.IterableConstants;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes5.dex */
public class ThemisModule extends ReactContextBaseJavaModule {
    private static final int comparator_error = -1;
    private static final int comparator_match = 21;
    private static final int comparator_not_match = 22;
    private static final int comparator_not_ready = 0;
    private static final String contextRequired = "Context required";
    private static final String privateKeyRequired = "Private key can not be null or blank";
    private static final String publicKeyRequired = "Public key can not be null or blank";
    Map<String, SecureCompare> cmprs;

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "Themis";
    }

    public static class ByteOverflowException extends Exception {
        public ByteOverflowException(String str) {
            super(str);
        }
    }

    ThemisModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.cmprs = new HashMap();
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("COMPARATOR_NOT_READY", 0);
        hashMap.put("COMPARATOR_NOT_MATCH", 22);
        hashMap.put("COMPARATOR_MATCH", 21);
        hashMap.put("COMPARATOR_ERROR", -1);
        hashMap.put("KEYTYPE_RSA", 1);
        hashMap.put("KEYTYPE_EC", 0);
        return hashMap;
    }

    /* renamed from: com.reactnativethemis.ThemisModule$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$cossacklabs$themis$SecureCompare$CompareResult;

        static {
            int[] iArr = new int[SecureCompare.CompareResult.values().length];
            $SwitchMap$com$cossacklabs$themis$SecureCompare$CompareResult = iArr;
            try {
                iArr[SecureCompare.CompareResult.NOT_READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$cossacklabs$themis$SecureCompare$CompareResult[SecureCompare.CompareResult.NO_MATCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$cossacklabs$themis$SecureCompare$CompareResult[SecureCompare.CompareResult.MATCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static int compareResultSerialize(SecureCompare.CompareResult compareResult) {
        int i = AnonymousClass1.$SwitchMap$com$cossacklabs$themis$SecureCompare$CompareResult[compareResult.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i != 2) {
            return i != 3 ? -1 : 21;
        }
        return 22;
    }

    private static WritableArray dataSerialize(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        for (byte b : bArr) {
            writableNativeArray.pushInt(b);
        }
        return writableNativeArray;
    }

    private static byte[] dataDeserialize(ReadableArray readableArray) throws ByteOverflowException {
        if (readableArray == null || readableArray.size() == 0) {
            return null;
        }
        byte[] bArr = new byte[readableArray.size()];
        for (int i = 0; i < readableArray.size(); i++) {
            if (readableArray.getInt(i) >= 0 && readableArray.getInt(i) <= 255) {
                bArr[i] = (byte) readableArray.getInt(i);
            } else {
                throw new ByteOverflowException("Value " + readableArray.getInt(i) + " is out of range");
            }
        }
        return bArr;
    }

    @ReactMethod
    public void stringSerialize(String str, Callback callback) {
        callback.invoke(dataSerialize(str.getBytes(StandardCharsets.UTF_8)));
    }

    @ReactMethod
    public void keyPair(int i, Callback callback) {
        Keypair generateKeypair;
        if (i == 1) {
            generateKeypair = KeypairGenerator.generateKeypair(1);
        } else {
            generateKeypair = KeypairGenerator.generateKeypair(0);
        }
        KeypairGenerator.generateKeypair();
        PrivateKey privateKey = generateKeypair.getPrivateKey();
        PublicKey publicKey = generateKeypair.getPublicKey();
        WritableArray dataSerialize = dataSerialize(privateKey.toByteArray());
        WritableArray dataSerialize2 = dataSerialize(publicKey.toByteArray());
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putArray("private", dataSerialize);
        writableNativeMap.putArray("public", dataSerialize2);
        callback.invoke(writableNativeMap);
    }

    @ReactMethod
    public void symmetricKey(Callback callback) {
        callback.invoke(dataSerialize(new SymmetricKey().toByteArray()));
    }

    @ReactMethod
    public void secureCellSealWithSymmetricKeyEncrypt(ReadableArray readableArray, String str, String str2, Callback callback, Callback callback2) {
        try {
            callback.invoke(dataSerialize(SecureCell.SealWithKey(dataDeserialize(readableArray)).encrypt(str.getBytes(StandardCharsets.UTF_8), str2.getBytes(StandardCharsets.UTF_8))));
        } catch (Exception e) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("message", e.toString());
            callback2.invoke(writableNativeMap);
        }
    }

    @ReactMethod
    public void secureCellSealWithSymmetricKeyDecrypt(ReadableArray readableArray, ReadableArray readableArray2, String str, Callback callback, Callback callback2) {
        try {
            callback.invoke(dataSerialize(SecureCell.SealWithKey(dataDeserialize(readableArray)).decrypt(dataDeserialize(readableArray2), str.getBytes(StandardCharsets.UTF_8))));
        } catch (Exception e) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("message", e.toString());
            callback2.invoke(writableNativeMap);
        }
    }

    @ReactMethod
    public void secureCellSealWithPassphraseEncrypt(String str, String str2, String str3, Callback callback, Callback callback2) {
        try {
            callback.invoke(dataSerialize(SecureCell.SealWithPassphrase(str).encrypt(str2.getBytes(StandardCharsets.UTF_8), str3.getBytes(StandardCharsets.UTF_8))));
        } catch (Exception e) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("message", e.toString());
            callback2.invoke(writableNativeMap);
        }
    }

    @ReactMethod
    public void secureCellSealWithPassphraseDecrypt(String str, ReadableArray readableArray, String str2, Callback callback, Callback callback2) {
        try {
            callback.invoke(dataSerialize(SecureCell.SealWithPassphrase(str).decrypt(dataDeserialize(readableArray), str2.getBytes(StandardCharsets.UTF_8))));
        } catch (Exception e) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("message", e.toString());
            callback2.invoke(writableNativeMap);
        }
    }

    @ReactMethod
    public void secureCellTokenProtectEncrypt(ReadableArray readableArray, String str, String str2, Callback callback, Callback callback2) {
        try {
            SecureCellData encrypt = SecureCell.TokenProtectWithKey(dataDeserialize(readableArray)).encrypt(str.getBytes(StandardCharsets.UTF_8), str2.getBytes(StandardCharsets.UTF_8));
            byte[] protectedData = encrypt.getProtectedData();
            byte[] additionalData = encrypt.getAdditionalData();
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putArray("encrypted", dataSerialize(protectedData));
            writableNativeMap.putArray(IterableConstants.KEY_TOKEN, dataSerialize(additionalData));
            callback.invoke(writableNativeMap);
        } catch (Exception e) {
            WritableNativeMap writableNativeMap2 = new WritableNativeMap();
            writableNativeMap2.putString("message", e.toString());
            callback2.invoke(writableNativeMap2);
        }
    }

    @ReactMethod
    public void secureCellTokenProtectDecrypt(ReadableArray readableArray, ReadableArray readableArray2, ReadableArray readableArray3, String str, Callback callback, Callback callback2) {
        try {
            byte[] dataDeserialize = dataDeserialize(readableArray);
            callback.invoke(dataSerialize(SecureCell.TokenProtectWithKey(dataDeserialize).decrypt(dataDeserialize(readableArray2), dataDeserialize(readableArray3), str.getBytes(StandardCharsets.UTF_8))));
        } catch (Exception e) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("message", e.toString());
            callback2.invoke(writableNativeMap);
        }
    }

    @ReactMethod
    public void secureCellContextImprintEncrypt(ReadableArray readableArray, String str, String str2, Callback callback, Callback callback2) {
        if (str2 == null || str2.length() == 0) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("message", contextRequired);
            callback2.invoke(writableNativeMap);
        } else {
            try {
                callback.invoke(dataSerialize(SecureCell.ContextImprintWithKey(dataDeserialize(readableArray)).encrypt(str.getBytes(StandardCharsets.UTF_8), str2.getBytes(StandardCharsets.UTF_8))));
            } catch (Exception e) {
                WritableNativeMap writableNativeMap2 = new WritableNativeMap();
                writableNativeMap2.putString("message", e.toString());
                callback2.invoke(writableNativeMap2);
            }
        }
    }

    @ReactMethod
    public void secureCellContextImprintDecrypt(ReadableArray readableArray, ReadableArray readableArray2, String str, Callback callback, Callback callback2) {
        if (str == null || str.length() == 0) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("message", contextRequired);
            callback2.invoke(writableNativeMap);
            return;
        }
        try {
            byte[] dataDeserialize = dataDeserialize(readableArray);
            callback.invoke(dataSerialize(SecureCell.ContextImprintWithKey(dataDeserialize).decrypt(dataDeserialize(readableArray2), str.getBytes(StandardCharsets.UTF_8))));
        } catch (Exception e) {
            WritableNativeMap writableNativeMap2 = new WritableNativeMap();
            writableNativeMap2.putString("message", e.toString());
            callback2.invoke(writableNativeMap2);
        }
    }

    @ReactMethod
    public void secureMessageSign(String str, ReadableArray readableArray, Callback callback, Callback callback2) {
        if (readableArray == null || readableArray.size() == 0) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("message", privateKeyRequired);
            callback2.invoke(writableNativeMap);
            return;
        }
        try {
            PrivateKey privateKey = new PrivateKey(dataDeserialize(readableArray));
            callback.invoke(dataSerialize(new SecureMessage(privateKey).sign(str.getBytes(StandardCharsets.UTF_8))));
        } catch (Exception e) {
            WritableNativeMap writableNativeMap2 = new WritableNativeMap();
            writableNativeMap2.putString("message", e.toString());
            callback2.invoke(writableNativeMap2);
        }
    }

    @ReactMethod
    public void secureMessageVerify(ReadableArray readableArray, ReadableArray readableArray2, Callback callback, Callback callback2) {
        if (readableArray2 == null || readableArray2.size() == 0) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("message", publicKeyRequired);
            callback2.invoke(writableNativeMap);
            return;
        }
        try {
            PublicKey publicKey = new PublicKey(dataDeserialize(readableArray2));
            callback.invoke(dataSerialize(new SecureMessage(publicKey).verify(dataDeserialize(readableArray), publicKey)));
        } catch (Exception e) {
            WritableNativeMap writableNativeMap2 = new WritableNativeMap();
            writableNativeMap2.putString("message", e.toString());
            callback2.invoke(writableNativeMap2);
        }
    }

    @ReactMethod
    public void secureMessageEncrypt(String str, ReadableArray readableArray, ReadableArray readableArray2, Callback callback, Callback callback2) {
        if (readableArray == null || readableArray.size() == 0) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("message", privateKeyRequired);
            callback2.invoke(writableNativeMap);
            return;
        }
        if (readableArray2 == null || readableArray2.size() == 0) {
            WritableNativeMap writableNativeMap2 = new WritableNativeMap();
            writableNativeMap2.putString("message", publicKeyRequired);
            callback2.invoke(writableNativeMap2);
            return;
        }
        try {
            PrivateKey privateKey = new PrivateKey(dataDeserialize(readableArray));
            PublicKey publicKey = new PublicKey(dataDeserialize(readableArray2));
            callback.invoke(dataSerialize(new SecureMessage(privateKey, publicKey).wrap(str.getBytes(StandardCharsets.UTF_8))));
        } catch (Exception e) {
            WritableNativeMap writableNativeMap3 = new WritableNativeMap();
            writableNativeMap3.putString("message", e.toString());
            callback2.invoke(writableNativeMap3);
        }
    }

    @ReactMethod
    public void secureMessageDecrypt(ReadableArray readableArray, ReadableArray readableArray2, ReadableArray readableArray3, Callback callback, Callback callback2) {
        if (readableArray2 == null || readableArray2.size() == 0) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("message", privateKeyRequired);
            callback2.invoke(writableNativeMap);
            return;
        }
        if (readableArray3 == null || readableArray3.size() == 0) {
            WritableNativeMap writableNativeMap2 = new WritableNativeMap();
            writableNativeMap2.putString("message", publicKeyRequired);
            callback2.invoke(writableNativeMap2);
            return;
        }
        try {
            PrivateKey privateKey = new PrivateKey(dataDeserialize(readableArray2));
            PublicKey publicKey = new PublicKey(dataDeserialize(readableArray3));
            callback.invoke(dataSerialize(new SecureMessage(privateKey, publicKey).unwrap(dataDeserialize(readableArray), publicKey)));
        } catch (Exception e) {
            WritableNativeMap writableNativeMap3 = new WritableNativeMap();
            writableNativeMap3.putString("message", e.toString());
            callback2.invoke(writableNativeMap3);
        }
    }

    @ReactMethod
    public void initComparator(ReadableArray readableArray, Callback callback, Callback callback2) {
        try {
            SecureCompare secureCompare = new SecureCompare(dataDeserialize(readableArray));
            String uuid = UUID.randomUUID().toString();
            this.cmprs.put(uuid, secureCompare);
            callback.invoke(uuid);
        } catch (Exception e) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("message", e.toString());
            callback2.invoke(writableNativeMap);
        }
    }

    @ReactMethod
    public void statusOfComparator(String str, Callback callback) {
        SecureCompare secureCompare = this.cmprs.get(str);
        if (secureCompare == null) {
            callback.invoke(-1);
        } else {
            callback.invoke(Integer.valueOf(compareResultSerialize(secureCompare.getResult())));
        }
    }

    @ReactMethod
    public void beginCompare(String str, Callback callback, Callback callback2) {
        SecureCompare secureCompare = this.cmprs.get(str);
        if (secureCompare == null) {
            callback2.invoke(-1);
        } else {
            callback.invoke(dataSerialize(secureCompare.begin()));
        }
    }

    @ReactMethod
    public void proceedCompare(String str, ReadableArray readableArray, Callback callback, Callback callback2) {
        SecureCompare secureCompare = this.cmprs.get(str);
        if (secureCompare == null) {
            callback2.invoke(-1);
            return;
        }
        try {
            WritableArray dataSerialize = dataSerialize(secureCompare.proceed(dataDeserialize(readableArray)));
            SecureCompare.CompareResult result = secureCompare.getResult();
            int compareResultSerialize = compareResultSerialize(result);
            if (result != SecureCompare.CompareResult.NOT_READY) {
                this.cmprs.remove(str);
            }
            callback.invoke(dataSerialize, Integer.valueOf(compareResultSerialize));
        } catch (Exception e) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("message", e.toString());
            callback2.invoke(writableNativeMap);
        }
    }
}
