package com.iterable.iterableapi;

import java.util.Date;
import java.util.UUID;

/* loaded from: classes5.dex */
class IterableTask {
    int attempts;
    boolean blocking;
    long createdAt;
    int currentVersion;
    String data;
    boolean failed;
    String id;
    long lastAttemptedAt;
    long modifiedAt;
    String name;
    boolean processing;
    long requestedAt;
    long scheduledAt;
    String taskFailureData;
    IterableTaskType taskType;
    int version;

    IterableTask(String str, String str2, int i, long j, long j2, long j3, long j4, long j5, boolean z, boolean z2, boolean z3, String str3, String str4, IterableTaskType iterableTaskType, int i2) {
        this.currentVersion = 1;
        this.id = str;
        this.name = str2;
        this.version = i;
        this.createdAt = j;
        this.modifiedAt = j2;
        this.lastAttemptedAt = j3;
        this.scheduledAt = j4;
        this.requestedAt = j5;
        this.processing = z;
        this.failed = z2;
        this.blocking = z3;
        this.data = str3;
        this.taskFailureData = str4;
        this.taskType = iterableTaskType;
        this.attempts = i2;
    }

    IterableTask(String str, IterableTaskType iterableTaskType, String str2) {
        this.currentVersion = 1;
        this.id = UUID.randomUUID().toString();
        this.name = str;
        this.createdAt = new Date().getTime();
        this.scheduledAt = new Date().getTime();
        this.requestedAt = new Date().getTime();
        this.data = str2;
        this.taskType = iterableTaskType;
    }
}
