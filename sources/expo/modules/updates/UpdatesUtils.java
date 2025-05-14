package expo.modules.updates;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.facebook.common.util.UriUtil;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.iterable.iterableapi.IterableConstants;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.db.entity.AssetEntity;
import expo.modules.updates.logging.UpdatesErrorCode;
import expo.modules.updates.logging.UpdatesLogger;
import io.sentry.SentryEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.io.NoSuchFileException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.TimeZones;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: UpdatesUtils.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eJ\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00102\u0006\u0010\u0011\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00172\u0006\u0010\u0011\u001a\u00020\u0006J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0006J8\u0010\u001b\u001a\u00020\u001c2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010%J\u000e\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u0013J\u000e\u0010&\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006J\u0016\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0014\u001a\u00020\u0015J \u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00132\b\u00101\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lexpo/modules/updates/UpdatesUtils;", "", "()V", "HEX_ARRAY", "", "TAG", "", "kotlin.jvm.PlatformType", "UPDATES_DIRECTORY_NAME", "bytesToHex", "bytes", "", "createFilenameForAsset", UriUtil.LOCAL_ASSET_SCHEME, "Lexpo/modules/updates/db/entity/AssetEntity;", "getMapFromJSONString", "", "stringifiedJSON", "getOrCreateUpdatesDirectory", "Ljava/io/File;", "context", "Landroid/content/Context;", "getStringListFromJSONString", "", "parseDateString", "Ljava/util/Date;", "dateString", "sendEventToReactNative", "", "reactNativeHost", "Ljava/lang/ref/WeakReference;", "Lcom/facebook/react/ReactNativeHost;", SentryEvent.JsonKeys.LOGGER, "Lexpo/modules/updates/logging/UpdatesLogger;", IterableConstants.KEY_EVENT_NAME, "eventType", "params", "Lcom/facebook/react/bridge/WritableMap;", "sha256", "file", "string", "shouldCheckForUpdateOnLaunch", "", "updatesConfiguration", "Lexpo/modules/updates/UpdatesConfiguration;", "verifySHA256AndWriteToFile", "inputStream", "Ljava/io/InputStream;", "destination", "expectedBase64URLEncodedHash", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UpdatesUtils {
    private static final char[] HEX_ARRAY;
    public static final UpdatesUtils INSTANCE = new UpdatesUtils();
    private static final String TAG = "UpdatesUtils";
    private static final String UPDATES_DIRECTORY_NAME = ".expo-internal";

    /* compiled from: UpdatesUtils.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[UpdatesConfiguration.CheckAutomaticallyConfiguration.values().length];
            try {
                iArr[UpdatesConfiguration.CheckAutomaticallyConfiguration.NEVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UpdatesConfiguration.CheckAutomaticallyConfiguration.ERROR_RECOVERY_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[UpdatesConfiguration.CheckAutomaticallyConfiguration.WIFI_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[UpdatesConfiguration.CheckAutomaticallyConfiguration.ALWAYS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private UpdatesUtils() {
    }

    static {
        char[] charArray = "0123456789ABCDEF".toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
        HEX_ARRAY = charArray;
    }

    public final Map<String, String> getMapFromJSONString(String stringifiedJSON) throws Exception {
        Intrinsics.checkNotNullParameter(stringifiedJSON, "stringifiedJSON");
        JSONObject jSONObject = new JSONObject(stringifiedJSON);
        Iterator<String> keys = jSONObject.keys();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (keys.hasNext()) {
            String key = keys.next();
            Intrinsics.checkNotNullExpressionValue(key, "key");
            try {
                Object obj = jSONObject.get(key);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                linkedHashMap.put(key, (String) obj);
            } catch (ClassCastException unused) {
                throw new Exception("The values in the JSON object must be strings");
            }
        }
        return linkedHashMap;
    }

    public final List<String> getStringListFromJSONString(String stringifiedJSON) throws Exception {
        Intrinsics.checkNotNullParameter(stringifiedJSON, "stringifiedJSON");
        JSONArray jSONArray = new JSONArray(stringifiedJSON);
        int length = jSONArray.length();
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return arrayList;
    }

    public final File getOrCreateUpdatesDirectory(Context context) throws Exception {
        Intrinsics.checkNotNullParameter(context, "context");
        File file = new File(context.getFilesDir(), UPDATES_DIRECTORY_NAME);
        if (file.exists()) {
            if (file.isFile()) {
                throw new Exception("File already exists at the location of the Updates Directory: " + file + " ; aborting");
            }
        } else if (!file.mkdir()) {
            throw new Exception("Failed to create Updates Directory: mkdir() returned false");
        }
        return file;
    }

    public final String sha256(String string) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Intrinsics.checkNotNullParameter(string, "string");
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            Charset forName = Charset.forName("UTF-8");
            Intrinsics.checkNotNullExpressionValue(forName, "forName(charsetName)");
            byte[] bytes = string.getBytes(forName);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            messageDigest.update(bytes, 0, bytes.length);
            byte[] sha1hash = messageDigest.digest();
            Intrinsics.checkNotNullExpressionValue(sha1hash, "sha1hash");
            return bytesToHex(sha1hash);
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, "Failed to checksum string via SHA-256", e);
            throw e;
        } catch (NoSuchAlgorithmException e2) {
            Log.e(TAG, "Failed to checksum string via SHA-256", e2);
            throw e2;
        }
    }

    public final byte[] sha256(File file) throws NoSuchAlgorithmException, IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        try {
            DigestInputStream fileInputStream = new FileInputStream(file);
            try {
                fileInputStream = new DigestInputStream(fileInputStream, MessageDigest.getInstance("SHA-256"));
                try {
                    byte[] digest = fileInputStream.getMessageDigest().digest();
                    Intrinsics.checkNotNullExpressionValue(digest, "md.digest()");
                    CloseableKt.closeFinally(fileInputStream, null);
                    CloseableKt.closeFinally(fileInputStream, null);
                    return digest;
                } finally {
                }
            } finally {
            }
        } catch (IOException e) {
            Log.e(TAG, "Failed to checksum file via SHA-256: " + file, e);
            throw e;
        } catch (NoSuchAlgorithmException e2) {
            Log.e(TAG, "Failed to checksum file via SHA-256: " + file, e2);
            throw e2;
        }
    }

    public final byte[] verifySHA256AndWriteToFile(InputStream inputStream, File destination, String expectedBase64URLEncodedHash) throws NoSuchAlgorithmException, IOException {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(destination, "destination");
        DigestInputStream digestInputStream = new DigestInputStream(inputStream, MessageDigest.getInstance("SHA-256"));
        try {
            DigestInputStream digestInputStream2 = digestInputStream;
            File file = new File(destination.getAbsolutePath() + DefaultDiskStorage.FileType.TEMP);
            FileUtils.copyInputStreamToFile(digestInputStream2, file);
            byte[] hash = digestInputStream2.getMessageDigest().digest();
            String encodeToString = Base64.encodeToString(hash, 11);
            if (expectedBase64URLEncodedHash != null && !Intrinsics.areEqual(expectedBase64URLEncodedHash, encodeToString)) {
                throw new IOException("File download was successful but base64url-encoded SHA-256 did not match expected; expected: " + expectedBase64URLEncodedHash + "; actual: " + encodeToString);
            }
            try {
                try {
                    FilesKt.copyTo$default(file, destination, true, 0, 4, null);
                    file.delete();
                    Intrinsics.checkNotNullExpressionValue(hash, "hash");
                    CloseableKt.closeFinally(digestInputStream, null);
                    return hash;
                } catch (NoSuchFileException unused) {
                    throw new IOException("File download was successful, but temp file " + file.getAbsolutePath() + " does not exist");
                } catch (Exception e) {
                    throw new IOException("File download was successful, but an exception occurred: " + e);
                }
            } catch (Throwable th) {
                file.delete();
                throw th;
            }
        } finally {
        }
    }

    public final String createFilenameForAsset(AssetEntity asset) {
        String str;
        Intrinsics.checkNotNullParameter(asset, "asset");
        if (asset.getType() != null) {
            String type = asset.getType();
            Intrinsics.checkNotNull(type);
            if (StringsKt.startsWith$default(type, ".", false, 2, (Object) null)) {
                str = asset.getType();
            } else {
                str = "." + asset.getType();
            }
        } else {
            str = "";
        }
        if (asset.getKey() == null) {
            return "asset-" + new Date().getTime() + "-" + new Random().nextInt() + str;
        }
        return asset.getKey() + str;
    }

    public final void sendEventToReactNative(WeakReference<ReactNativeHost> reactNativeHost, final UpdatesLogger logger, final String eventName, final String eventType, final WritableMap params) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        final ReactNativeHost reactNativeHost2 = reactNativeHost != null ? reactNativeHost.get() : null;
        if (reactNativeHost2 != null) {
            AsyncTask.execute(new Runnable() { // from class: expo.modules.updates.UpdatesUtils$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    UpdatesUtils.sendEventToReactNative$lambda$4(ReactNativeHost.this, params, eventType, logger, eventName);
                }
            });
        } else {
            UpdatesLogger.error$default(logger, "Could not emit " + eventType + " event; UpdatesController was not initialized with an instance of ReactApplication.", UpdatesErrorCode.Unknown, null, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendEventToReactNative$lambda$4(ReactNativeHost reactNativeHost, WritableMap writableMap, String eventType, UpdatesLogger logger, String eventName) {
        DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter;
        Intrinsics.checkNotNullParameter(eventType, "$eventType");
        Intrinsics.checkNotNullParameter(logger, "$logger");
        Intrinsics.checkNotNullParameter(eventName, "$eventName");
        ReactContext reactContext = null;
        for (int i = 0; i < 5; i++) {
            try {
                if (reactNativeHost.hasInstance() && (reactContext = reactNativeHost.getReactInstanceManager().getCurrentReactContext()) != null) {
                    break;
                }
                Thread.sleep(1000L);
            } catch (Exception unused) {
                UpdatesLogger.error$default(logger, "Could not emit " + eventName + " " + eventType + " event; no react context was found.", UpdatesErrorCode.JSRuntimeError, null, 4, null);
                return;
            }
        }
        if (reactContext != null && (rCTDeviceEventEmitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)) != null) {
            WritableMap createMap = writableMap == null ? Arguments.createMap() : writableMap;
            Intrinsics.checkNotNull(createMap);
            createMap.putString("type", eventType);
            UpdatesLogger.info$default(logger, "Emitted event: name = " + eventName + ", type = " + eventType, null, 2, null);
            rCTDeviceEventEmitter.emit(eventName, createMap);
            return;
        }
        UpdatesLogger.error$default(logger, "Could not emit " + eventName + " " + eventType + " event; no event emitter was found.", UpdatesErrorCode.JSRuntimeError, null, 4, null);
    }

    public final boolean shouldCheckForUpdateOnLaunch(UpdatesConfiguration updatesConfiguration, Context context) {
        Intrinsics.checkNotNullParameter(updatesConfiguration, "updatesConfiguration");
        Intrinsics.checkNotNullParameter(context, "context");
        int i = WhenMappings.$EnumSwitchMapping$0[updatesConfiguration.getCheckOnLaunch().ordinal()];
        if (i != 1 && i != 2) {
            if (i != 3) {
                if (i == 4) {
                    return true;
                }
                throw new NoWhenBranchMatchedException();
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                Log.e(TAG, "Could not determine active network connection is metered; not checking for updates");
                return false;
            }
            if (!connectivityManager.isActiveNetworkMetered()) {
                return true;
            }
        }
        return false;
    }

    public final String bytesToHex(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        char[] cArr = new char[bytes.length * 2];
        int length = bytes.length;
        for (int i = 0; i < length; i++) {
            byte b = (byte) (bytes[i] & (-1));
            int i2 = i * 2;
            char[] cArr2 = HEX_ARRAY;
            cArr[i2] = cArr2[b >>> 4];
            cArr[i2 + 1] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public final Date parseDateString(String dateString) throws ParseException {
        Intrinsics.checkNotNullParameter(dateString, "dateString");
        try {
            Date parse = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'X'", Locale.US).parse(dateString);
            Intrinsics.checkNotNull(parse, "null cannot be cast to non-null type java.util.Date");
            return parse;
        } catch (Exception unused) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(TimeZones.GMT_ID));
            Date parse2 = simpleDateFormat.parse(dateString);
            Intrinsics.checkNotNull(parse2, "null cannot be cast to non-null type java.util.Date");
            return parse2;
        }
    }
}
