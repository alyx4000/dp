package javax.servlet.http;

import java.util.EventListener;

/* loaded from: classes2.dex */
public interface HttpSessionListener extends EventListener {
    default void sessionCreated(HttpSessionEvent httpSessionEvent) {
    }

    default void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
    }
}
