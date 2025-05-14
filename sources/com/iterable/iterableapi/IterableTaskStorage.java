package com.iterable.iterableapi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/* loaded from: classes5.dex */
class IterableTaskStorage {
    static final String ATTEMPTS = "attempts";
    static final String BLOCKING = "blocking";
    static final String CREATED_AT = "created";
    static final String DATA = "data";
    static final String ERROR = "error";
    static final String FAILED = "failed";
    static final String ITERABLE_TASK_TABLE_NAME = "OfflineTask";
    static final String LAST_ATTEMPTED_AT = "last_attempt";
    static final String MODIFIED_AT = "modified";
    static final String NAME = "name";
    static final String OFFLINE_TASK_COLUMN_DATA = " (task_id TEXT PRIMARY KEY,name TEXT,version INTEGER,created BIGINT,modified BIGINT,last_attempt BIGINT,scheduled BIGINT,requested BIGINT,processing BOOLEAN,failed BOOLEAN,blocking BOOLEAN,data TEXT,error TEXT,type TEXT,attempts INTEGER)";
    static final String PROCESSING = "processing";
    private static final String QUERY_GET_TASK_BY_ID = "select * from OfflineTask where task_id = ?";
    static final String REQUESTED_AT = "requested";
    static final String SCHEDULED_AT = "scheduled";
    private static final String TAG = "IterableTaskStorage";
    static final String TASK_ID = "task_id";
    static final String TYPE = "type";
    static final String VERSION = "version";
    private static IterableTaskStorage sharedInstance;
    private SQLiteDatabase database;
    private IterableDatabaseManager databaseManager;
    private ArrayList<TaskCreatedListener> taskCreatedListeners = new ArrayList<>();
    private ArrayList<IterableDatabaseStatusListeners> databaseStatusListeners = new ArrayList<>();

    public interface IterableDatabaseStatusListeners {
        void isReady();

        void onDBError();
    }

    interface TaskCreatedListener {
        void onTaskCreated(IterableTask iterableTask);
    }

    private IterableTaskStorage(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (this.databaseManager == null) {
                this.databaseManager = new IterableDatabaseManager(context);
            }
            this.database = this.databaseManager.getWritableDatabase();
        } catch (SQLException unused) {
            IterableLogger.e(TAG, "Database cannot be opened for writing");
        }
    }

    static IterableTaskStorage sharedInstance(Context context) {
        if (sharedInstance == null) {
            sharedInstance = new IterableTaskStorage(context);
        }
        return sharedInstance;
    }

    void addTaskCreatedListener(TaskCreatedListener taskCreatedListener) {
        this.taskCreatedListeners.add(taskCreatedListener);
    }

    void removeDatabaseStatusListener(TaskCreatedListener taskCreatedListener) {
        this.taskCreatedListeners.remove(taskCreatedListener);
    }

    String createTask(String str, IterableTaskType iterableTaskType, String str2) {
        if (!isDatabaseReady()) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        final IterableTask iterableTask = new IterableTask(str, IterableTaskType.API, str2);
        contentValues.put(TASK_ID, iterableTask.id);
        contentValues.put("name", iterableTask.name);
        contentValues.put("version", Integer.valueOf(iterableTask.version));
        contentValues.put(CREATED_AT, Long.valueOf(iterableTask.createdAt));
        if (iterableTask.modifiedAt != 0) {
            contentValues.put(MODIFIED_AT, Long.valueOf(iterableTask.modifiedAt));
        }
        if (iterableTask.lastAttemptedAt != 0) {
            contentValues.put(LAST_ATTEMPTED_AT, Long.valueOf(iterableTask.lastAttemptedAt));
        }
        if (iterableTask.scheduledAt != 0) {
            contentValues.put(SCHEDULED_AT, Long.valueOf(iterableTask.scheduledAt));
        }
        if (iterableTask.requestedAt != 0) {
            contentValues.put(REQUESTED_AT, Long.valueOf(iterableTask.requestedAt));
        }
        contentValues.put(PROCESSING, Boolean.valueOf(iterableTask.processing));
        contentValues.put(FAILED, Boolean.valueOf(iterableTask.failed));
        contentValues.put(BLOCKING, Boolean.valueOf(iterableTask.blocking));
        if (iterableTask.data != null) {
            contentValues.put("data", iterableTask.data);
        }
        if (iterableTask.taskFailureData != null) {
            contentValues.put("error", iterableTask.taskFailureData);
        }
        contentValues.put("type", iterableTask.taskType.toString());
        contentValues.put(ATTEMPTS, Integer.valueOf(iterableTask.attempts));
        if (this.database.insert(ITERABLE_TASK_TABLE_NAME, null, contentValues) == -1) {
            notifyDBError();
            return null;
        }
        contentValues.clear();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.iterable.iterableapi.IterableTaskStorage.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = IterableTaskStorage.this.taskCreatedListeners.iterator();
                while (it.hasNext()) {
                    ((TaskCreatedListener) it.next()).onTaskCreated(iterableTask);
                }
            }
        });
        return iterableTask.id;
    }

    IterableTask getTask(String str) {
        if (!isDatabaseReady()) {
            return null;
        }
        Cursor rawQuery = this.database.rawQuery(QUERY_GET_TASK_BY_ID, new String[]{str});
        if (!rawQuery.moveToFirst()) {
            IterableLogger.d(TAG, "No record found");
            return null;
        }
        IterableTask createTaskFromCursor = createTaskFromCursor(rawQuery);
        IterableLogger.v(TAG, "Found " + rawQuery.getColumnCount() + "columns");
        rawQuery.close();
        return createTaskFromCursor;
    }

    private IterableTask createTaskFromCursor(Cursor cursor) {
        boolean z;
        boolean z2;
        String string = cursor.getString(cursor.getColumnIndex(TASK_ID));
        String string2 = cursor.getString(cursor.getColumnIndex("name"));
        int i = cursor.getInt(cursor.getColumnIndex("version"));
        long j = cursor.getLong(cursor.getColumnIndex(CREATED_AT));
        long j2 = !cursor.isNull(cursor.getColumnIndex(MODIFIED_AT)) ? cursor.getLong(cursor.getColumnIndex(MODIFIED_AT)) : 0L;
        long j3 = !cursor.isNull(cursor.getColumnIndex(LAST_ATTEMPTED_AT)) ? cursor.getLong(cursor.getColumnIndex(LAST_ATTEMPTED_AT)) : 0L;
        long j4 = !cursor.isNull(cursor.getColumnIndex(SCHEDULED_AT)) ? cursor.getLong(cursor.getColumnIndex(SCHEDULED_AT)) : 0L;
        long j5 = !cursor.isNull(cursor.getColumnIndex(REQUESTED_AT)) ? cursor.getLong(cursor.getColumnIndex(REQUESTED_AT)) : 0L;
        boolean z3 = !cursor.isNull(cursor.getColumnIndex(PROCESSING)) && cursor.getInt(cursor.getColumnIndex(PROCESSING)) > 0;
        if (cursor.isNull(cursor.getColumnIndex(FAILED))) {
            z = false;
        } else {
            z = cursor.getInt(cursor.getColumnIndex(FAILED)) > 0;
        }
        if (cursor.isNull(cursor.getColumnIndex(BLOCKING))) {
            z2 = false;
        } else {
            z2 = cursor.getInt(cursor.getColumnIndex(BLOCKING)) > 0;
        }
        return new IterableTask(string, string2, i, j, j2, j3, j4, j5, z3, z, z2, !cursor.isNull(cursor.getColumnIndex("data")) ? cursor.getString(cursor.getColumnIndex("data")) : null, !cursor.isNull(cursor.getColumnIndex("error")) ? cursor.getString(cursor.getColumnIndex("error")) : null, !cursor.isNull(cursor.getColumnIndex("type")) ? IterableTaskType.valueOf(cursor.getString(cursor.getColumnIndex("type"))) : null, !cursor.isNull(cursor.getColumnIndex(ATTEMPTS)) ? cursor.getInt(cursor.getColumnIndex(ATTEMPTS)) : 0);
    }

    ArrayList<String> getAllTaskIds() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (!isDatabaseReady()) {
            return arrayList;
        }
        Cursor rawQuery = this.database.rawQuery("SELECT task_id FROM OfflineTask", null);
        if (rawQuery.moveToFirst()) {
            do {
                arrayList.add(rawQuery.getString(0));
            } while (rawQuery.moveToNext());
        }
        IterableLogger.v(TAG, "Found " + rawQuery.getColumnCount() + " columns");
        rawQuery.close();
        return arrayList;
    }

    long getNumberOfTasks() throws IllegalStateException {
        if (!isDatabaseReady()) {
            throw new IllegalStateException("Database is not ready");
        }
        return DatabaseUtils.queryNumEntries(this.database, ITERABLE_TASK_TABLE_NAME);
    }

    IterableTask getNextScheduledTask() {
        if (!isDatabaseReady()) {
            return null;
        }
        Cursor rawQuery = this.database.rawQuery("select * from OfflineTask order by scheduled limit 1", null);
        IterableTask createTaskFromCursor = rawQuery.moveToFirst() ? createTaskFromCursor(rawQuery) : null;
        rawQuery.close();
        return createTaskFromCursor;
    }

    void deleteAllTasks() {
        if (isDatabaseReady()) {
            IterableLogger.v(TAG, "Deleted " + this.database.delete(ITERABLE_TASK_TABLE_NAME, null, null) + " offline tasks");
        }
    }

    boolean deleteTask(String str) {
        if (!isDatabaseReady()) {
            return false;
        }
        IterableLogger.v(TAG, "Deleted entry - " + this.database.delete(ITERABLE_TASK_TABLE_NAME, "task_id =?", new String[]{str}));
        return true;
    }

    boolean updateModifiedAt(String str, Date date) {
        if (!isDatabaseReady()) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(MODIFIED_AT, date.toString());
        return updateTaskWithContentValues(str, contentValues);
    }

    boolean updateLastAttemptedAt(String str, Date date) {
        if (!isDatabaseReady()) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(LAST_ATTEMPTED_AT, date.toString());
        return updateTaskWithContentValues(str, contentValues);
    }

    boolean updateRequestedAt(String str, Date date) {
        if (!isDatabaseReady()) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(REQUESTED_AT, date.toString());
        return updateTaskWithContentValues(str, contentValues);
    }

    boolean updateScheduledAt(String str, Date date) {
        if (isDatabaseReady()) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(SCHEDULED_AT, date.toString());
        return updateTaskWithContentValues(str, contentValues);
    }

    boolean updateIsProcessing(String str, Boolean bool) {
        if (!isDatabaseReady()) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(PROCESSING, bool);
        return updateTaskWithContentValues(str, contentValues);
    }

    boolean updateHasFailed(String str, boolean z) {
        if (!isDatabaseReady()) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(FAILED, Boolean.valueOf(z));
        return updateTaskWithContentValues(str, contentValues);
    }

    boolean incrementAttempts(String str, int i) {
        if (!isDatabaseReady()) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(ATTEMPTS, Integer.valueOf(i));
        return updateTaskWithContentValues(str, contentValues);
    }

    boolean incrementAttempts(String str) {
        if (!isDatabaseReady()) {
            return false;
        }
        IterableTask task = getTask(str);
        if (task == null) {
            IterableLogger.e(TAG, "No task found for id " + str);
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(ATTEMPTS, Integer.valueOf(task.attempts + 1));
        return updateTaskWithContentValues(str, contentValues);
    }

    boolean updateError(String str, String str2) {
        if (!isDatabaseReady()) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("error", str2);
        return updateTaskWithContentValues(str, contentValues);
    }

    boolean updateData(String str, String str2) {
        if (!isDatabaseReady()) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("data", str2);
        return updateTaskWithContentValues(str, contentValues);
    }

    private boolean updateTaskWithContentValues(String str, ContentValues contentValues) {
        return this.database.update(ITERABLE_TASK_TABLE_NAME, contentValues, "task_id=?", new String[]{str}) < 0;
    }

    private boolean isDatabaseReady() {
        SQLiteDatabase sQLiteDatabase = this.database;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            return true;
        }
        notifyDBError();
        IterableLogger.e(TAG, "Database not initialized or is closed");
        return false;
    }

    void addDatabaseStatusListener(IterableDatabaseStatusListeners iterableDatabaseStatusListeners) {
        if (isDatabaseReady()) {
            iterableDatabaseStatusListeners.isReady();
        } else {
            iterableDatabaseStatusListeners.onDBError();
        }
        this.databaseStatusListeners.add(iterableDatabaseStatusListeners);
    }

    void removeDatabaseStatusListener(IterableDatabaseStatusListeners iterableDatabaseStatusListeners) {
        this.databaseStatusListeners.remove(iterableDatabaseStatusListeners);
    }

    private void notifyDBError() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.iterable.iterableapi.IterableTaskStorage.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = IterableTaskStorage.this.databaseStatusListeners.iterator();
                while (it.hasNext()) {
                    ((IterableDatabaseStatusListeners) it.next()).onDBError();
                }
            }
        });
    }
}
