package com.iterable.iterableapi;

import java.util.Date;

/* loaded from: classes5.dex */
class ImpressionData {
    int displayCount = 0;
    float duration = 0.0f;
    Date impressionStarted = null;
    final String messageId;
    final boolean silentInbox;

    ImpressionData(String str, boolean z) {
        this.messageId = str;
        this.silentInbox = z;
    }

    void startImpression() {
        this.impressionStarted = new Date();
    }

    void endImpression() {
        if (this.impressionStarted != null) {
            this.displayCount++;
            this.duration += (new Date().getTime() - this.impressionStarted.getTime()) / 1000.0f;
            this.impressionStarted = null;
        }
    }
}
