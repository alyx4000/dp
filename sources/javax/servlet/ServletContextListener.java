package javax.servlet;

import java.util.EventListener;

/* loaded from: classes2.dex */
public interface ServletContextListener extends EventListener {
    default void contextDestroyed(ServletContextEvent servletContextEvent) {
    }

    default void contextInitialized(ServletContextEvent servletContextEvent) {
    }
}
