package sdk.pendo.io.l8;

import androidx.credentials.playservices.controllers.CredentialProviderBaseController;
import com.facebook.common.callercontext.ContextChain;
import com.iterable.iterableapi.IterableConstants;
import io.sentry.protocol.OperatingSystem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00022\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lsdk/pendo/io/l8/b;", "", "a", "b", "c", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String b = IterableConstants.DEVICE_ID;
    private static final String c = "idType";
    private static final String d = "locale";
    private static final String e = "installedApps";
    private static final String f = OperatingSystem.TYPE;
    private static final String g = "osVersion";
    private static final String h = "brand";
    private static final String i = "manufacturer";
    private static final String j = "model";
    private static final String k = "board";
    private static final String l = "features";
    private static final String m = "type";

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006¨\u0006\u001b"}, d2 = {"Lsdk/pendo/io/l8/b$a;", "", "", "DEVICE_ID", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "ID_TYPE", "d", "LOCALE", "e", "OS", "h", "OS_VERSION", ContextChain.TAG_INFRA, "BRAND", "b", "MANUFACTURER", "f", "MODEL", "g", "BOARD", "a", CredentialProviderBaseController.TYPE_TAG, "j", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    /* renamed from: sdk.pendo.io.l8.b$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return b.k;
        }

        public final String b() {
            return b.h;
        }

        public final String c() {
            return b.b;
        }

        public final String d() {
            return b.c;
        }

        public final String e() {
            return b.d;
        }

        public final String f() {
            return b.i;
        }

        public final String g() {
            return b.j;
        }

        public final String h() {
            return b.f;
        }

        public final String i() {
            return b.g;
        }

        public final String j() {
            return b.m;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u0010"}, d2 = {"Lsdk/pendo/io/l8/b$b;", "", "", "b", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "NETWORK", "c", "NET_TYPE", "d", "NET_ROAMING", "e", "WIFI_MAC", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    /* renamed from: sdk.pendo.io.l8.b$b, reason: collision with other inner class name */
    public static final class C0190b {

        /* renamed from: a, reason: collision with root package name */
        public static final C0190b f1342a = new C0190b();

        /* renamed from: b, reason: from kotlin metadata */
        private static final String NETWORK = "network";

        /* renamed from: c, reason: from kotlin metadata */
        private static final String NET_TYPE = "net_type";

        /* renamed from: d, reason: from kotlin metadata */
        private static final String NET_ROAMING = "net_roaming";

        /* renamed from: e, reason: from kotlin metadata */
        private static final String WIFI_MAC = "wifi_MAC";

        private C0190b() {
        }

        public final String a() {
            return NETWORK;
        }

        public final String b() {
            return NET_ROAMING;
        }

        public final String c() {
            return NET_TYPE;
        }

        public final String d() {
            return WIFI_MAC;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\n\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u0010"}, d2 = {"Lsdk/pendo/io/l8/b$c;", "", "", "b", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "SIM", "c", "a", "COUNTRY_ISO", "OPERATOR", "e", "OPERATOR_NAME", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public static final c f1343a = new c();

        /* renamed from: b, reason: from kotlin metadata */
        private static final String SIM = "sim";

        /* renamed from: c, reason: from kotlin metadata */
        private static final String COUNTRY_ISO = "country_iso";

        /* renamed from: d, reason: from kotlin metadata */
        private static final String OPERATOR = "operator";

        /* renamed from: e, reason: from kotlin metadata */
        private static final String OPERATOR_NAME = "operator_name";

        private c() {
        }

        public final String a() {
            return COUNTRY_ISO;
        }

        public final String b() {
            return OPERATOR;
        }

        public final String c() {
            return OPERATOR_NAME;
        }

        public final String d() {
            return SIM;
        }
    }
}
