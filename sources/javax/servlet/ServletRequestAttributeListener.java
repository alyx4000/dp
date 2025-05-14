package javax.servlet;

import java.util.EventListener;

/* loaded from: classes2.dex */
public interface ServletRequestAttributeListener extends EventListener {
    default void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {
    }

    default void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {
    }

    default void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {
    }
}
