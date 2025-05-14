package com.iterable.iterableapi;

import java.util.List;

/* loaded from: classes5.dex */
interface IterableInAppStorage {
    void addMessage(IterableInAppMessage iterableInAppMessage);

    String getHTML(String str);

    IterableInAppMessage getMessage(String str);

    List<IterableInAppMessage> getMessages();

    void removeHTML(String str);

    void removeMessage(IterableInAppMessage iterableInAppMessage);

    void saveHTML(String str, String str2);
}
