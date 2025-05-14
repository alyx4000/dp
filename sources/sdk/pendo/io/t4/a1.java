package sdk.pendo.io.t4;

import java.io.Closeable;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

/* loaded from: classes6.dex */
abstract class a1 extends SSLSocket implements sdk.pendo.io.r4.i {
    protected static final boolean A = i0.b("external.sdk.pendo.io.org.bouncycastle.jsse.client.assumeOriginalHostName", false);
    protected static final boolean f0 = i0.b("jdk.tls.trustNameService", false);
    protected final Closeable f = new a();
    protected final Map<HandshakeCompletedListener, AccessControlContext> s = Collections.synchronizedMap(new HashMap(4));

    class a implements Closeable {
        a() {
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            a1.this.m();
        }
    }

    class b implements Runnable {
        final /* synthetic */ Collection f;
        final /* synthetic */ HandshakeCompletedEvent s;

        class a implements PrivilegedAction<Void> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ HandshakeCompletedListener f1552a;

            a(HandshakeCompletedListener handshakeCompletedListener) {
                this.f1552a = handshakeCompletedListener;
            }

            @Override // java.security.PrivilegedAction
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void run() {
                this.f1552a.handshakeCompleted(b.this.s);
                return null;
            }
        }

        b(Collection collection, HandshakeCompletedEvent handshakeCompletedEvent) {
            this.f = collection;
            this.s = handshakeCompletedEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (Map.Entry entry : this.f) {
                HandshakeCompletedListener handshakeCompletedListener = (HandshakeCompletedListener) entry.getKey();
                AccessController.doPrivileged(new a(handshakeCompletedListener), (AccessControlContext) entry.getValue());
            }
        }
    }

    protected a1() {
    }

    private Collection<Map.Entry<HandshakeCompletedListener, AccessControlContext>> n() {
        ArrayList arrayList;
        synchronized (this.s) {
            arrayList = this.s.isEmpty() ? null : new ArrayList(this.s.entrySet());
        }
        return arrayList;
    }

    protected InetSocketAddress a(String str, int i) {
        return str == null ? new InetSocketAddress(InetAddress.getByName(null), i) : new InetSocketAddress(str, i);
    }

    @Override // javax.net.ssl.SSLSocket
    public void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        if (handshakeCompletedListener == null) {
            throw new IllegalArgumentException("'listener' cannot be null");
        }
        this.s.put(handshakeCompletedListener, AccessController.getContext());
    }

    protected void b(InetAddress inetAddress, int i) {
        bind(a(inetAddress, i));
    }

    protected void c(InetAddress inetAddress, int i) {
        connect(a(inetAddress, i), 0);
    }

    @Override // java.net.Socket
    public final boolean getOOBInline() {
        throw new SocketException("This method is ineffective, since sending urgent data is not supported by SSLSockets");
    }

    protected void m() {
        super.close();
    }

    @Override // javax.net.ssl.SSLSocket
    public void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        if (handshakeCompletedListener == null) {
            throw new IllegalArgumentException("'listener' cannot be null");
        }
        if (this.s.remove(handshakeCompletedListener) == null) {
            throw new IllegalArgumentException("'listener' is not registered");
        }
    }

    @Override // java.net.Socket
    public final void sendUrgentData(int i) {
        throw new SocketException("This method is not supported by SSLSockets");
    }

    @Override // java.net.Socket
    public final void setOOBInline(boolean z) {
        throw new SocketException("This method is ineffective, since sending urgent data is not supported by SSLSockets");
    }

    protected InetSocketAddress a(InetAddress inetAddress, int i) {
        return new InetSocketAddress(inetAddress, i);
    }

    protected void b(String str, int i) {
        connect(a(str, i), 0);
    }

    protected void a(SSLSession sSLSession) {
        Collection<Map.Entry<HandshakeCompletedListener, AccessControlContext>> n = n();
        if (n == null) {
            return;
        }
        v1.a(new b(n, new HandshakeCompletedEvent(this, sSLSession)));
    }
}
