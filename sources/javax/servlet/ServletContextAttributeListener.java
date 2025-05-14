package javax.servlet;

import java.util.EventListener;

/* loaded from: classes2.dex */
public interface ServletContextAttributeListener extends EventListener {
    default void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
    }

    default void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
    }

    default void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
    }
}
