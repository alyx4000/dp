package javax.servlet.http;

import java.util.EventListener;

/* loaded from: classes2.dex */
public interface HttpSessionActivationListener extends EventListener {
    default void sessionDidActivate(HttpSessionEvent httpSessionEvent) {
    }

    default void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {
    }
}
