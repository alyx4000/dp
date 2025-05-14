package com.iterable.iterableapi;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IterableKeychain.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u0004\u0018\u00010\bJ\b\u0010\u0011\u001a\u0004\u0018\u00010\bJ\b\u0010\u0012\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0003H\u0003J\u0010\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0019\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/iterable/iterableapi/IterableKeychain;", "", "context", "Landroid/content/Context;", "encryptionEnforced", "", "(Landroid/content/Context;Z)V", "TAG", "", "authTokenKey", "emailKey", "encryptedSharedPrefsFileName", "encryptionEnabled", "sharedPrefs", "Landroid/content/SharedPreferences;", "userIdKey", "getAuthToken", "getEmail", "getUserId", "migrateAuthDataFromSharedPrefsToKeychain", "", "saveAuthToken", "authToken", "saveEmail", "email", "saveUserId", IterableConstants.KEY_USER_ID, "iterableapi_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class IterableKeychain {
    private final String TAG;
    private final String authTokenKey;
    private final String emailKey;
    private final String encryptedSharedPrefsFileName;
    private boolean encryptionEnabled;
    private SharedPreferences sharedPrefs;
    private final String userIdKey;

    public IterableKeychain(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "IterableKeychain";
        this.encryptedSharedPrefsFileName = "iterable-encrypted-shared-preferences";
        this.emailKey = "iterable-email";
        this.userIdKey = "iterable-user-id";
        this.authTokenKey = "iterable-auth-token";
        MasterKey build = new MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build();
        Intrinsics.checkNotNullExpressionValue(build, "MasterKey.Builder(contex…\n                .build()");
        try {
            SharedPreferences create = EncryptedSharedPreferences.create(context, "iterable-encrypted-shared-preferences", build, EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV, EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM);
            Intrinsics.checkNotNullExpressionValue(create, "EncryptedSharedPreferenc…256_GCM\n                )");
            this.sharedPrefs = create;
            this.encryptionEnabled = true;
        } catch (Throwable th) {
            if (th instanceof Error) {
                IterableLogger.e(this.TAG, "EncryptionSharedPreference creation failed with Error. Attempting to continue");
            }
            if (z) {
                IterableLogger.w(this.TAG, "Encryption is enforced. PII will not be persisted due to EncryptionSharedPreference failure. Email/UserId and Auth token will have to be passed for every app session.", th);
                Throwable fillInStackTrace = th.fillInStackTrace();
                Intrinsics.checkNotNullExpressionValue(fillInStackTrace, "e.fillInStackTrace()");
                throw fillInStackTrace;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.iterable.iterableapi", 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ATE\n                    )");
            this.sharedPrefs = sharedPreferences;
            IterableLogger.w(this.TAG, "Using SharedPreference as EncryptionSharedPreference creation failed.");
            this.encryptionEnabled = false;
        }
        if (this.encryptionEnabled) {
            migrateAuthDataFromSharedPrefsToKeychain(context);
        }
    }

    public final String getEmail() {
        return this.sharedPrefs.getString(this.emailKey, null);
    }

    public final void saveEmail(String email) {
        this.sharedPrefs.edit().putString(this.emailKey, email).apply();
    }

    public final String getUserId() {
        return this.sharedPrefs.getString(this.userIdKey, null);
    }

    public final void saveUserId(String userId) {
        this.sharedPrefs.edit().putString(this.userIdKey, userId).apply();
    }

    public final String getAuthToken() {
        return this.sharedPrefs.getString(this.authTokenKey, null);
    }

    public final void saveAuthToken(String authToken) {
        this.sharedPrefs.edit().putString(this.authTokenKey, authToken).apply();
    }

    private final void migrateAuthDataFromSharedPrefsToKeychain(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.iterable.iterableapi", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…xt.MODE_PRIVATE\n        )");
        String string = sharedPreferences.getString(IterableConstants.SHARED_PREFS_EMAIL_KEY, null);
        String string2 = sharedPreferences.getString(IterableConstants.SHARED_PREFS_USERID_KEY, null);
        String string3 = sharedPreferences.getString(IterableConstants.SHARED_PREFS_AUTH_TOKEN_KEY, null);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        Intrinsics.checkNotNullExpressionValue(edit, "oldPrefs.edit()");
        if (getEmail() == null && string != null) {
            saveEmail(string);
            edit.remove(IterableConstants.SHARED_PREFS_EMAIL_KEY);
            IterableLogger.v(this.TAG, "UPDATED: migrated email from SharedPreferences to IterableKeychain");
        } else if (string != null) {
            edit.remove(IterableConstants.SHARED_PREFS_EMAIL_KEY);
        }
        if (getUserId() == null && string2 != null) {
            saveUserId(string2);
            edit.remove(IterableConstants.SHARED_PREFS_USERID_KEY);
            IterableLogger.v(this.TAG, "UPDATED: migrated userId from SharedPreferences to IterableKeychain");
        } else if (string2 != null) {
            edit.remove(IterableConstants.SHARED_PREFS_USERID_KEY);
        }
        if (getAuthToken() == null && string3 != null) {
            saveAuthToken(string3);
            edit.remove(IterableConstants.SHARED_PREFS_AUTH_TOKEN_KEY);
            IterableLogger.v(this.TAG, "UPDATED: migrated authToken from SharedPreferences to IterableKeychain");
        } else if (string3 != null) {
            edit.remove(IterableConstants.SHARED_PREFS_AUTH_TOKEN_KEY);
        }
        edit.apply();
    }
}
