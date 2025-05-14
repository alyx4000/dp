package sdk.pendo.io.r4;

import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLSession;

/* loaded from: classes6.dex */
public abstract class b implements SSLSession {
    public abstract String[] a();

    public String[] b() {
        return a();
    }

    public abstract String[] c();

    public String[] d() {
        return c();
    }

    public List<e> e() {
        throw new UnsupportedOperationException();
    }

    public List<byte[]> f() {
        return Collections.emptyList();
    }

    public abstract boolean g();
}
