package javax.servlet.http;

import java.util.EventObject;

/* loaded from: classes2.dex */
public class HttpSessionEvent extends EventObject {
    private static final long serialVersionUID = -7622791603672342895L;

    public HttpSessionEvent(HttpSession httpSession) {
        super(httpSession);
    }

    public HttpSession getSession() {
        return (HttpSession) super.getSource();
    }
}
