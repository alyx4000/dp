package com.amplitude.reactnative;

import android.content.Context;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LegacyDatabaseStorage.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/amplitude/reactnative/LegacyDatabaseStorageProvider;", "", "()V", "instances", "", "", "Lcom/amplitude/reactnative/LegacyDatabaseStorage;", "getDatabaseName", "instanceName", "getStorage", "context", "Landroid/content/Context;", "amplitude_analytics-react-native_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LegacyDatabaseStorageProvider {
    public static final LegacyDatabaseStorageProvider INSTANCE = new LegacyDatabaseStorageProvider();
    private static final Map<String, LegacyDatabaseStorage> instances = new LinkedHashMap();

    private LegacyDatabaseStorageProvider() {
    }

    public final LegacyDatabaseStorage getStorage(Context context, String instanceName) {
        Intrinsics.checkNotNullParameter(context, "context");
        String databaseName = getDatabaseName(instanceName);
        Map<String, LegacyDatabaseStorage> map = instances;
        LegacyDatabaseStorage legacyDatabaseStorage = map.get(databaseName);
        if (legacyDatabaseStorage != null) {
            return legacyDatabaseStorage;
        }
        LegacyDatabaseStorage legacyDatabaseStorage2 = new LegacyDatabaseStorage(context, databaseName);
        map.put(databaseName, legacyDatabaseStorage2);
        return legacyDatabaseStorage2;
    }

    private final String getDatabaseName(String instanceName) {
        String str;
        if (instanceName != null) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            str = instanceName.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).toLowerCase(locale)");
        } else {
            str = null;
        }
        String str2 = str;
        return ((str2 == null || str2.length() == 0) || Intrinsics.areEqual(str, DatabaseConstants.DEFAULT_INSTANCE)) ? DatabaseConstants.DATABASE_NAME : "com.amplitude.api_" + str;
    }
}
