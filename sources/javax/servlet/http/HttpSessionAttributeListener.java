package javax.servlet.http;

import java.util.EventListener;

/* loaded from: classes2.dex */
public interface HttpSessionAttributeListener extends EventListener {
    default void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
    }

    default void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
    }

    default void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
    }
}
