package com.iterable.iterableapi;

import com.iterable.iterableapi.IterableTaskStorage;

/* loaded from: classes5.dex */
public class HealthMonitor implements IterableTaskStorage.IterableDatabaseStatusListeners {
    private static final String TAG = "HealthMonitor";
    private boolean databaseErrored = false;
    private IterableTaskStorage iterableTaskStorage;

    public HealthMonitor(IterableTaskStorage iterableTaskStorage) {
        this.iterableTaskStorage = iterableTaskStorage;
        iterableTaskStorage.addDatabaseStatusListener(this);
    }

    public boolean canSchedule() {
        IterableLogger.d(TAG, "canSchedule");
        try {
            return this.iterableTaskStorage.getNumberOfTasks() < 1000;
        } catch (IllegalStateException e) {
            IterableLogger.e(TAG, e.getLocalizedMessage());
            this.databaseErrored = true;
            return false;
        }
    }

    public boolean canProcess() {
        IterableLogger.d(TAG, "Health monitor can process: " + (!this.databaseErrored));
        return !this.databaseErrored;
    }

    @Override // com.iterable.iterableapi.IterableTaskStorage.IterableDatabaseStatusListeners
    public void onDBError() {
        IterableLogger.e(TAG, "DB Error notified to healthMonitor");
        this.databaseErrored = true;
    }

    @Override // com.iterable.iterableapi.IterableTaskStorage.IterableDatabaseStatusListeners
    public void isReady() {
        IterableLogger.v(TAG, "DB Ready notified to healthMonitor");
        this.databaseErrored = false;
    }
}
