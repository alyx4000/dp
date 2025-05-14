package io.castle.android;

import android.media.MediaDrm;
import android.os.Build;
import android.util.Pair;
import io.castle.highwind.android.Highwind;
import java.security.MessageDigest;
import java.util.UUID;
import java.util.regex.Pattern;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: classes2.dex */
public class DeviceIdUtils {
    private static final Pattern HEX_REGEX_PATTERN = Pattern.compile("^[0-9a-f]+$");
    private static final UUID WIDEVINE_UUID = new UUID(-1301668207276963122L, -6645017420763422227L);

    public static Pair<String, Integer> deviceId() {
        try {
            String wideVineId = wideVineId();
            if (isValid(wideVineId)) {
                return new Pair<>(wideVineId, Integer.valueOf(Highwind.ID_SOURCE_WIDEVINE));
            }
        } catch (Exception unused) {
        }
        return new Pair<>(UUID.randomUUID().toString(), Integer.valueOf(Highwind.ID_SOURCE_GENERATED));
    }

    static String wideVineId() {
        MediaDrm mediaDrm;
        Throwable th;
        try {
            mediaDrm = new MediaDrm(WIDEVINE_UUID);
        } catch (Exception unused) {
            mediaDrm = null;
        } catch (Throwable th2) {
            mediaDrm = null;
            th = th2;
        }
        try {
            byte[] propertyByteArray = mediaDrm.getPropertyByteArray("deviceUniqueId");
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            messageDigest.update(propertyByteArray);
            String byteArrayToHexString = byteArrayToHexString(messageDigest.digest());
            if (Build.VERSION.SDK_INT >= 28) {
                mediaDrm.release();
            } else {
                mediaDrm.release();
            }
            return byteArrayToHexString;
        } catch (Exception unused2) {
            if (mediaDrm != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    mediaDrm.release();
                } else {
                    mediaDrm.release();
                }
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (mediaDrm != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    mediaDrm.release();
                } else {
                    mediaDrm.release();
                }
            }
            throw th;
        }
    }

    private static String byteArrayToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(String.format("%02x", Byte.valueOf(b)));
        }
        return sb.toString();
    }

    private static boolean isValid(String str) {
        if (str != null && str.length() == 32) {
            return HEX_REGEX_PATTERN.matcher(str).matches();
        }
        return false;
    }
}
