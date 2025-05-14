package com.iterable.iterableapi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: classes5.dex */
class IterableDatabaseManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "iterable_sdk.db";
    private static final int DATABASE_VERSION = 1;

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    IterableDatabaseManager(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS OfflineTask (task_id TEXT PRIMARY KEY,name TEXT,version INTEGER,created BIGINT,modified BIGINT,last_attempt BIGINT,scheduled BIGINT,requested BIGINT,processing BOOLEAN,failed BOOLEAN,blocking BOOLEAN,data TEXT,error TEXT,type TEXT,attempts INTEGER)");
    }
}
