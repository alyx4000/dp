package javax.servlet;

import java.util.EventListener;

/* loaded from: classes2.dex */
public interface ServletRequestListener extends EventListener {
    default void requestDestroyed(ServletRequestEvent servletRequestEvent) {
    }

    default void requestInitialized(ServletRequestEvent servletRequestEvent) {
    }
}
