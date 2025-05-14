package sdk.pendo.io.g3;

import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import sdk.pendo.io.w2.a0;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J(\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH&J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¨\u0006\r"}, d2 = {"Lsdk/pendo/io/g3/k;", "", "", "a", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "hostname", "", "Lsdk/pendo/io/w2/a0;", "protocols", "", "b", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public interface k {
    void a(SSLSocket sslSocket, String hostname, List<? extends a0> protocols);

    boolean a();

    boolean a(SSLSocket sslSocket);

    String b(SSLSocket sslSocket);
}
