package io.castle.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import io.castle.highwind.android.Highwind;

/* loaded from: classes2.dex */
class StorageHelper {
    private static final String BUILD_KEY = "build_key";
    private static final String DEVICE_ID_KEY = "device_id_key";
    private static final String DEVICE_ID_SOURCE_KEY = "device_id_source_key";
    private static final String STORAGE_PREFERENCE = "castle_storage";
    private static final String USER_JWT_KEY = "user_jwt_key";
    private static final String VERSION_KEY = "version_key";
    private SharedPreferences preferences;

    StorageHelper(Context context) {
        this.preferences = context.getSharedPreferences(STORAGE_PREFERENCE, 0);
    }

    int getBuild() {
        return getPreferences().getInt(BUILD_KEY, -1);
    }

    void setBuild(int i) {
        getPreferencesEditor().putInt(BUILD_KEY, i).commit();
    }

    String getDeviceId() {
        String string = getPreferences().getString(DEVICE_ID_KEY, null);
        if (string != null) {
            return string;
        }
        Pair<String, Integer> deviceId = DeviceIdUtils.deviceId();
        String str = (String) deviceId.first;
        setDeviceId((String) deviceId.first);
        setDeviceIdSource(((Integer) deviceId.second).intValue());
        return str;
    }

    private void setDeviceId(String str) {
        getPreferencesEditor().putString(DEVICE_ID_KEY, str).commit();
    }

    Integer getDeviceIdSource() {
        return Integer.valueOf(getPreferences().getInt(DEVICE_ID_SOURCE_KEY, Highwind.ID_SOURCE_GENERATED));
    }

    private void setDeviceIdSource(int i) {
        getPreferencesEditor().putInt(DEVICE_ID_SOURCE_KEY, i).commit();
    }

    String getUserJwt() {
        return getPreferences().getString(USER_JWT_KEY, null);
    }

    void setUserJwt(String str) {
        getPreferencesEditor().putString(USER_JWT_KEY, str).commit();
    }

    private SharedPreferences getPreferences() {
        return this.preferences;
    }

    private SharedPreferences.Editor getPreferencesEditor() {
        return this.preferences.edit();
    }

    String getVersion() {
        return getPreferences().getString(VERSION_KEY, null);
    }

    void setVersion(String str) {
        getPreferencesEditor().putString(VERSION_KEY, str).commit();
    }
}
