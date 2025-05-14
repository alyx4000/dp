package sdk.pendo.io.y4;

import java.io.EOFException;

/* loaded from: classes4.dex */
public class n2 extends EOFException {
    public n2() {
        super("No close_notify alert received before connection closed");
    }
}
