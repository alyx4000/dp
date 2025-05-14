package sdk.pendo.io.t7;

import com.google.firebase.perf.FirebasePerformance;

/* loaded from: classes6.dex */
public interface d {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f1636a = {FirebasePerformance.HttpMethod.CONNECT, "DISCONNECT", "EVENT", "ACK", "ERROR", "BINARY_EVENT", "BINARY_ACK"};

    public interface a {

        /* renamed from: sdk.pendo.io.t7.d$a$a, reason: collision with other inner class name */
        public interface InterfaceC0242a {
            void a(c cVar);
        }

        void a(String str);

        void a(InterfaceC0242a interfaceC0242a);

        void a(byte[] bArr);

        void destroy();
    }

    public interface b {

        public interface a {
            void call(Object[] objArr);
        }

        void a(c cVar, a aVar);
    }
}
