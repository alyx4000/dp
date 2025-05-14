package com.amplitude.reactnative;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: LegacyDatabaseStorage.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0005¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u0005J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\"\u0010 \u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\bH\u0016JY\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0010\u0010%\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010\u00052\u0010\u0010(\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010&2\b\u0010)\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010*J\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,J\u0016\u0010.\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\f\u0010/\u001a\b\u0012\u0004\u0012\u00020-0,J\f\u00100\u001a\b\u0012\u0004\u0012\u00020-0,J\u000e\u00101\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\bJ\u0018\u00103\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u00102\u001a\u00020\bH\u0002J\u000e\u00104\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\bJ\u000e\u00105\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\bJ\u000e\u00106\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0005J\u000e\u00107\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0005J\u0018\u00108\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/amplitude/reactnative/LegacyDatabaseStorage;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "databaseName", "", "(Landroid/content/Context;Ljava/lang/String;)V", "<set-?>", "", "currentDbVersion", "getCurrentDbVersion", "()I", "file", "Ljava/io/File;", "closeDb", "", "convertIfCursorWindowException", "e", "Ljava/lang/RuntimeException;", "getLongValue", "", DatabaseConstants.KEY_FIELD, "(Ljava/lang/String;)Ljava/lang/Long;", "getValue", "getValueFromTable", "", "table", "handleIfCursorRowTooLargeException", "Ljava/lang/IllegalStateException;", "onCreate", "db", "Landroid/database/sqlite/SQLiteDatabase;", "onUpgrade", "oldVersion", "newVersion", "queryDb", "Landroid/database/Cursor;", "columns", "", "selection", "selectionArgs", "orderBy", "(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "readEvents", "", "Lorg/json/JSONObject;", "readEventsFromTable", "readIdentifies", "readInterceptedIdentifies", "removeEvent", "eventId", "removeEventFromTable", "removeIdentify", "removeInterceptedIdentify", "removeLongValue", "removeValue", "removeValueFromTable", "amplitude_analytics-react-native_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LegacyDatabaseStorage extends SQLiteOpenHelper {
    private int currentDbVersion;
    private File file;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LegacyDatabaseStorage(Context context, String databaseName) {
        super(context, databaseName, (SQLiteDatabase.CursorFactory) null, 4);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(databaseName, "databaseName");
        File databasePath = context.getDatabasePath(databaseName);
        Intrinsics.checkNotNullExpressionValue(databasePath, "context.getDatabasePath(databaseName)");
        this.file = databasePath;
        this.currentDbVersion = 4;
    }

    public final int getCurrentDbVersion() {
        return this.currentDbVersion;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        throw new NotImplementedError(null, 1, null);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        this.currentDbVersion = oldVersion;
    }

    private final Cursor queryDb(SQLiteDatabase db, String table, String[] columns, String selection, String[] selectionArgs, String orderBy) {
        return db.query(table, columns, selection, selectionArgs, null, null, orderBy, null);
    }

    private final void handleIfCursorRowTooLargeException(IllegalStateException e) {
        String message = e.getMessage();
        if (message == null || message.length() == 0) {
            throw e;
        }
        if (!StringsKt.contains$default((CharSequence) message, (CharSequence) "Couldn't read", false, 2, (Object) null)) {
            throw e;
        }
        if (StringsKt.contains$default((CharSequence) message, (CharSequence) "CursorWindow", false, 2, (Object) null)) {
            closeDb();
            return;
        }
        throw e;
    }

    private final void convertIfCursorWindowException(RuntimeException e) {
        String message = e.getMessage();
        String str = message;
        if (str == null || str.length() == 0) {
            throw e;
        }
        if (StringsKt.startsWith$default(message, "Cursor window allocation of", false, 2, (Object) null) || StringsKt.startsWith$default(message, "Could not allocate CursorWindow", false, 2, (Object) null)) {
            throw new CursorWindowAllocationException(message);
        }
        throw e;
    }

    private final void closeDb() {
        try {
            close();
        } catch (Exception e) {
            LogcatLogger.INSTANCE.getLogger().error("close failed: " + e.getMessage());
        }
    }

    public final synchronized List<JSONObject> readEvents() {
        return readEventsFromTable(DatabaseConstants.EVENT_TABLE_NAME);
    }

    public final synchronized List<JSONObject> readIdentifies() {
        return readEventsFromTable(DatabaseConstants.IDENTIFY_TABLE_NAME);
    }

    public final synchronized List<JSONObject> readInterceptedIdentifies() {
        if (this.currentDbVersion < 4) {
            return CollectionsKt.emptyList();
        }
        return readEventsFromTable(DatabaseConstants.IDENTIFY_INTERCEPTOR_TABLE_NAME);
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00dc, code lost:
    
        if (r3 == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x007e, code lost:
    
        if (r3 == null) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List<org.json.JSONObject> readEventsFromTable(java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.reactnative.LegacyDatabaseStorage.readEventsFromTable(java.lang.String):java.util.List");
    }

    public final synchronized void removeEvent(int eventId) {
        removeEventFromTable(DatabaseConstants.EVENT_TABLE_NAME, eventId);
    }

    public final synchronized void removeIdentify(int eventId) {
        removeEventFromTable(DatabaseConstants.IDENTIFY_TABLE_NAME, eventId);
    }

    public final synchronized void removeInterceptedIdentify(int eventId) {
        if (this.currentDbVersion < 4) {
            return;
        }
        removeEventFromTable(DatabaseConstants.IDENTIFY_INTERCEPTOR_TABLE_NAME, eventId);
    }

    private final void removeEventFromTable(String table, int eventId) {
        try {
            try {
                getWritableDatabase().delete(table, "id = ?", new String[]{String.valueOf(eventId)});
            } catch (SQLiteException e) {
                LogcatLogger.INSTANCE.getLogger().error("remove events from " + table + " failed: " + e.getMessage());
                closeDb();
            } catch (StackOverflowError e2) {
                LogcatLogger.INSTANCE.getLogger().error("remove events from " + table + " failed: " + e2.getMessage());
                closeDb();
            }
        } finally {
            close();
        }
    }

    public final synchronized String getValue(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (String) getValueFromTable(DatabaseConstants.STORE_TABLE_NAME, key);
    }

    public final synchronized Long getLongValue(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (Long) getValueFromTable(DatabaseConstants.LONG_STORE_TABLE_NAME, key);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00c4, code lost:
    
        if (r14 == null) goto L14;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.Object getValueFromTable(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            java.lang.String r0 = " failed: "
            java.lang.String r1 = "getValue from "
            java.io.File r2 = r12.file
            boolean r2 = r2.exists()
            r3 = 0
            if (r2 != 0) goto Le
            return r3
        Le:
            android.database.sqlite.SQLiteDatabase r5 = r12.getReadableDatabase()     // Catch: java.lang.Throwable -> L60 java.lang.RuntimeException -> L63 java.lang.IllegalStateException -> L6b java.lang.StackOverflowError -> L73 android.database.sqlite.SQLiteException -> L9d
            java.lang.String r2 = "db"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r2)     // Catch: java.lang.Throwable -> L60 java.lang.RuntimeException -> L63 java.lang.IllegalStateException -> L6b java.lang.StackOverflowError -> L73 android.database.sqlite.SQLiteException -> L9d
            r2 = 2
            java.lang.String[] r7 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L60 java.lang.RuntimeException -> L63 java.lang.IllegalStateException -> L6b java.lang.StackOverflowError -> L73 android.database.sqlite.SQLiteException -> L9d
            java.lang.String r2 = "key"
            r4 = 0
            r7[r4] = r2     // Catch: java.lang.Throwable -> L60 java.lang.RuntimeException -> L63 java.lang.IllegalStateException -> L6b java.lang.StackOverflowError -> L73 android.database.sqlite.SQLiteException -> L9d
            java.lang.String r2 = "value"
            r11 = 1
            r7[r11] = r2     // Catch: java.lang.Throwable -> L60 java.lang.RuntimeException -> L63 java.lang.IllegalStateException -> L6b java.lang.StackOverflowError -> L73 android.database.sqlite.SQLiteException -> L9d
            java.lang.String r8 = "key = ?"
            java.lang.String[] r9 = new java.lang.String[]{r14}     // Catch: java.lang.Throwable -> L60 java.lang.RuntimeException -> L63 java.lang.IllegalStateException -> L6b java.lang.StackOverflowError -> L73 android.database.sqlite.SQLiteException -> L9d
            r10 = 0
            r4 = r12
            r6 = r13
            android.database.Cursor r14 = r4.queryDb(r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L60 java.lang.RuntimeException -> L63 java.lang.IllegalStateException -> L6b java.lang.StackOverflowError -> L73 android.database.sqlite.SQLiteException -> L9d
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14)     // Catch: java.lang.RuntimeException -> L58 java.lang.IllegalStateException -> L5a java.lang.StackOverflowError -> L5c android.database.sqlite.SQLiteException -> L5e java.lang.Throwable -> Lc8
            boolean r2 = r14.moveToFirst()     // Catch: java.lang.RuntimeException -> L58 java.lang.IllegalStateException -> L5a java.lang.StackOverflowError -> L5c android.database.sqlite.SQLiteException -> L5e java.lang.Throwable -> Lc8
            if (r2 == 0) goto L50
            java.lang.String r2 = "store"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r13, r2)     // Catch: java.lang.RuntimeException -> L58 java.lang.IllegalStateException -> L5a java.lang.StackOverflowError -> L5c android.database.sqlite.SQLiteException -> L5e java.lang.Throwable -> Lc8
            if (r2 == 0) goto L47
            java.lang.String r13 = r14.getString(r11)     // Catch: java.lang.RuntimeException -> L58 java.lang.IllegalStateException -> L5a java.lang.StackOverflowError -> L5c android.database.sqlite.SQLiteException -> L5e java.lang.Throwable -> Lc8
            goto L4f
        L47:
            long r4 = r14.getLong(r11)     // Catch: java.lang.RuntimeException -> L58 java.lang.IllegalStateException -> L5a java.lang.StackOverflowError -> L5c android.database.sqlite.SQLiteException -> L5e java.lang.Throwable -> Lc8
            java.lang.Long r13 = java.lang.Long.valueOf(r4)     // Catch: java.lang.RuntimeException -> L58 java.lang.IllegalStateException -> L5a java.lang.StackOverflowError -> L5c android.database.sqlite.SQLiteException -> L5e java.lang.Throwable -> Lc8
        L4f:
            r3 = r13
        L50:
            r14.close()
        L53:
            r12.close()
            goto Lc7
        L58:
            r13 = move-exception
            goto L65
        L5a:
            r13 = move-exception
            goto L6d
        L5c:
            r2 = move-exception
            goto L75
        L5e:
            r2 = move-exception
            goto L9f
        L60:
            r13 = move-exception
            goto Lca
        L63:
            r13 = move-exception
            r14 = r3
        L65:
            r12.convertIfCursorWindowException(r13)     // Catch: java.lang.Throwable -> Lc8
            if (r14 == 0) goto L53
            goto L50
        L6b:
            r13 = move-exception
            r14 = r3
        L6d:
            r12.handleIfCursorRowTooLargeException(r13)     // Catch: java.lang.Throwable -> Lc8
            if (r14 == 0) goto L53
            goto L50
        L73:
            r2 = move-exception
            r14 = r3
        L75:
            com.amplitude.reactnative.LogcatLogger$Companion r4 = com.amplitude.reactnative.LogcatLogger.INSTANCE     // Catch: java.lang.Throwable -> Lc8
            com.amplitude.reactnative.LogcatLogger r4 = r4.getLogger()     // Catch: java.lang.Throwable -> Lc8
            java.lang.String r2 = r2.getMessage()     // Catch: java.lang.Throwable -> Lc8
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc8
            r5.<init>(r1)     // Catch: java.lang.Throwable -> Lc8
            java.lang.StringBuilder r13 = r5.append(r13)     // Catch: java.lang.Throwable -> Lc8
            java.lang.StringBuilder r13 = r13.append(r0)     // Catch: java.lang.Throwable -> Lc8
            java.lang.StringBuilder r13 = r13.append(r2)     // Catch: java.lang.Throwable -> Lc8
            java.lang.String r13 = r13.toString()     // Catch: java.lang.Throwable -> Lc8
            r4.error(r13)     // Catch: java.lang.Throwable -> Lc8
            r12.closeDb()     // Catch: java.lang.Throwable -> Lc8
            if (r14 == 0) goto L53
            goto L50
        L9d:
            r2 = move-exception
            r14 = r3
        L9f:
            com.amplitude.reactnative.LogcatLogger$Companion r4 = com.amplitude.reactnative.LogcatLogger.INSTANCE     // Catch: java.lang.Throwable -> Lc8
            com.amplitude.reactnative.LogcatLogger r4 = r4.getLogger()     // Catch: java.lang.Throwable -> Lc8
            java.lang.String r2 = r2.getMessage()     // Catch: java.lang.Throwable -> Lc8
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc8
            r5.<init>(r1)     // Catch: java.lang.Throwable -> Lc8
            java.lang.StringBuilder r13 = r5.append(r13)     // Catch: java.lang.Throwable -> Lc8
            java.lang.StringBuilder r13 = r13.append(r0)     // Catch: java.lang.Throwable -> Lc8
            java.lang.StringBuilder r13 = r13.append(r2)     // Catch: java.lang.Throwable -> Lc8
            java.lang.String r13 = r13.toString()     // Catch: java.lang.Throwable -> Lc8
            r4.error(r13)     // Catch: java.lang.Throwable -> Lc8
            r12.closeDb()     // Catch: java.lang.Throwable -> Lc8
            if (r14 == 0) goto L53
            goto L50
        Lc7:
            return r3
        Lc8:
            r13 = move-exception
            r3 = r14
        Lca:
            if (r3 == 0) goto Lcf
            r3.close()
        Lcf:
            r12.close()
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.reactnative.LegacyDatabaseStorage.getValueFromTable(java.lang.String, java.lang.String):java.lang.Object");
    }

    public final synchronized void removeValue(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        removeValueFromTable(DatabaseConstants.STORE_TABLE_NAME, key);
    }

    public final synchronized void removeLongValue(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        removeValueFromTable(DatabaseConstants.LONG_STORE_TABLE_NAME, key);
    }

    private final void removeValueFromTable(String table, String key) {
        try {
            try {
                try {
                    getWritableDatabase().delete(table, "key = ?", new String[]{key});
                } catch (SQLiteException e) {
                    LogcatLogger.INSTANCE.getLogger().error("remove value from " + table + " failed: " + e.getMessage());
                    closeDb();
                }
            } catch (StackOverflowError e2) {
                LogcatLogger.INSTANCE.getLogger().error("remove value from " + table + " failed: " + e2.getMessage());
                closeDb();
            }
        } finally {
            close();
        }
    }
}
