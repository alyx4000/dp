package com.iterable.iterableapi;

import com.iterable.iterableapi.IterableInboxSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public class InboxSessionManager {
    private static final String TAG = "InboxSessionManager";
    IterableInboxSession session = new IterableInboxSession();
    Map<String, ImpressionData> impressions = new HashMap();
    Set<String> previousImpressions = new HashSet();

    public boolean isTracking() {
        return this.session.sessionStartTime != null;
    }

    public void startSession() {
        if (isTracking()) {
            IterableLogger.e(TAG, "Inbox session started twice");
        } else {
            this.session = new IterableInboxSession(new Date(), null, IterableApi.getInstance().getInAppManager().getInboxMessages().size(), IterableApi.getInstance().getInAppManager().getUnreadInboxMessagesCount(), 0, 0, null);
            IterableApi.getInstance().setInboxSessionId(this.session.sessionId);
        }
    }

    public void startSession(List<IterableInboxSession.Impression> list) {
        startSession();
        updateVisibleRows(list);
    }

    public void endSession() {
        if (!isTracking()) {
            IterableLogger.e(TAG, "Inbox Session ended without start");
            return;
        }
        endAllImpressions();
        IterableApi.getInstance().trackInboxSession(new IterableInboxSession(this.session.sessionStartTime, new Date(), this.session.startTotalMessageCount, this.session.startUnreadMessageCount, IterableApi.getInstance().getInAppManager().getInboxMessages().size(), IterableApi.getInstance().getInAppManager().getUnreadInboxMessagesCount(), getImpressionList()));
        IterableApi.getInstance().clearInboxSessionId();
        this.session = new IterableInboxSession();
        this.impressions = new HashMap();
        this.previousImpressions = new HashSet();
    }

    public void updateVisibleRows(List<IterableInboxSession.Impression> list) {
        IterableLogger.printInfo();
        HashSet hashSet = new HashSet();
        Iterator<IterableInboxSession.Impression> it = list.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().messageId);
        }
        HashSet hashSet2 = new HashSet(hashSet);
        hashSet2.removeAll(this.previousImpressions);
        HashSet hashSet3 = new HashSet(this.previousImpressions);
        hashSet3.removeAll(hashSet);
        HashSet hashSet4 = new HashSet(hashSet);
        this.previousImpressions = hashSet4;
        hashSet4.removeAll(hashSet3);
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            onMessageImpressionStarted(IterableApi.getInstance().getInAppManager().getMessageById((String) it2.next()));
        }
        Iterator it3 = hashSet3.iterator();
        while (it3.hasNext()) {
            endImpression((String) it3.next());
        }
    }

    public void onMessageImpressionStarted(IterableInAppMessage iterableInAppMessage) {
        IterableLogger.printInfo();
        startImpression(iterableInAppMessage.getMessageId(), iterableInAppMessage.isSilentInboxMessage());
    }

    public void onMessageImpressionEnded(IterableInAppMessage iterableInAppMessage) {
        IterableLogger.printInfo();
        endImpression(iterableInAppMessage.getMessageId());
    }

    private void startImpression(String str, boolean z) {
        ImpressionData impressionData = this.impressions.get(str);
        if (impressionData == null) {
            impressionData = new ImpressionData(str, z);
            this.impressions.put(str, impressionData);
        }
        impressionData.startImpression();
    }

    private void endImpression(String str) {
        ImpressionData impressionData = this.impressions.get(str);
        if (impressionData == null) {
            IterableLogger.e(TAG, "onMessageImpressionEnded: impressionData not found");
        } else if (impressionData.impressionStarted == null) {
            IterableLogger.e(TAG, "onMessageImpressionEnded: impressionStarted is null");
        } else {
            impressionData.endImpression();
        }
    }

    private void endAllImpressions() {
        Iterator<ImpressionData> it = this.impressions.values().iterator();
        while (it.hasNext()) {
            it.next().endImpression();
        }
    }

    private List<IterableInboxSession.Impression> getImpressionList() {
        ArrayList arrayList = new ArrayList();
        for (ImpressionData impressionData : this.impressions.values()) {
            arrayList.add(new IterableInboxSession.Impression(impressionData.messageId, impressionData.silentInbox, impressionData.displayCount, impressionData.duration));
        }
        return arrayList;
    }
}
