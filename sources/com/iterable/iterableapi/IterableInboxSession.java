package com.iterable.iterableapi;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/* loaded from: classes5.dex */
public class IterableInboxSession {
    public final int endTotalMessageCount;
    public final int endUnreadMessageCount;
    public final List<Impression> impressions;
    public final Date sessionEndTime;
    public final String sessionId;
    public final Date sessionStartTime;
    public final int startTotalMessageCount;
    public final int startUnreadMessageCount;

    public IterableInboxSession(Date date, Date date2, int i, int i2, int i3, int i4, List<Impression> list) {
        this.sessionStartTime = date;
        this.sessionEndTime = date2;
        this.startTotalMessageCount = i;
        this.startUnreadMessageCount = i2;
        this.endTotalMessageCount = i3;
        this.endUnreadMessageCount = i4;
        this.impressions = list;
        this.sessionId = UUID.randomUUID().toString();
    }

    public IterableInboxSession() {
        this.sessionStartTime = null;
        this.sessionEndTime = null;
        this.startTotalMessageCount = 0;
        this.startUnreadMessageCount = 0;
        this.endTotalMessageCount = 0;
        this.endUnreadMessageCount = 0;
        this.impressions = null;
        this.sessionId = UUID.randomUUID().toString();
    }

    public static class Impression {
        final int displayCount;
        final float duration;
        final String messageId;
        final boolean silentInbox;

        public Impression(String str, boolean z, int i, float f) {
            this.messageId = str;
            this.silentInbox = z;
            this.displayCount = i;
            this.duration = f;
        }
    }
}
