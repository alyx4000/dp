package com.iterable.iterableapi;

import android.os.AsyncTask;

/* compiled from: IterableFirebaseMessagingService.java */
/* loaded from: classes5.dex */
class IterableNotificationManager extends AsyncTask<IterableNotificationBuilder, Void, Void> {
    IterableNotificationManager() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public Void doInBackground(IterableNotificationBuilder... iterableNotificationBuilderArr) {
        IterableNotificationBuilder iterableNotificationBuilder;
        if (iterableNotificationBuilderArr == null || (iterableNotificationBuilder = iterableNotificationBuilderArr[0]) == null) {
            return null;
        }
        IterableNotificationHelper.postNotificationOnDevice(iterableNotificationBuilder.context, iterableNotificationBuilder);
        return null;
    }
}
