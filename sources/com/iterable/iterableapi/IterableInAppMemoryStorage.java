package com.iterable.iterableapi;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
class IterableInAppMemoryStorage implements IterableInAppStorage {
    private List<IterableInAppMessage> messages = new ArrayList();

    @Override // com.iterable.iterableapi.IterableInAppStorage
    public String getHTML(String str) {
        return null;
    }

    @Override // com.iterable.iterableapi.IterableInAppStorage
    public void removeHTML(String str) {
    }

    @Override // com.iterable.iterableapi.IterableInAppStorage
    public void saveHTML(String str, String str2) {
    }

    IterableInAppMemoryStorage() {
    }

    @Override // com.iterable.iterableapi.IterableInAppStorage
    public synchronized List<IterableInAppMessage> getMessages() {
        return new ArrayList(this.messages);
    }

    @Override // com.iterable.iterableapi.IterableInAppStorage
    public synchronized IterableInAppMessage getMessage(String str) {
        for (IterableInAppMessage iterableInAppMessage : this.messages) {
            if (iterableInAppMessage.getMessageId().equals(str)) {
                return iterableInAppMessage;
            }
        }
        return null;
    }

    @Override // com.iterable.iterableapi.IterableInAppStorage
    public synchronized void addMessage(IterableInAppMessage iterableInAppMessage) {
        this.messages.add(iterableInAppMessage);
    }

    @Override // com.iterable.iterableapi.IterableInAppStorage
    public synchronized void removeMessage(IterableInAppMessage iterableInAppMessage) {
        this.messages.remove(iterableInAppMessage);
    }
}
