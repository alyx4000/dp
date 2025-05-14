package javax.servlet.http;

import java.util.EventListener;

/* loaded from: classes2.dex */
public interface HttpSessionBindingListener extends EventListener {
    default void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
    }

    default void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
    }
}
