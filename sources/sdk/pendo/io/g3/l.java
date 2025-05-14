package sdk.pendo.io.g3;

import com.facebook.common.callercontext.ContextChain;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB3\u0012\u000e\u0010\n\u001a\n\u0012\u0006\b\u0000\u0012\u00020\t0\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00030\u0002\u0012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0006\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0018\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0005¨\u0006\u000f"}, d2 = {"Lsdk/pendo/io/g3/l;", "Lsdk/pendo/io/g3/f;", "Ljava/lang/Class;", "Ljavax/net/ssl/SSLSocketFactory;", "h", "Ljava/lang/Class;", "sslSocketFactoryClass", ContextChain.TAG_INFRA, "paramClass", "Ljavax/net/ssl/SSLSocket;", "sslSocketClass", "<init>", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;)V", "j", "a", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class l extends f {

    /* renamed from: j, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: h, reason: from kotlin metadata */
    private final Class<? super SSLSocketFactory> sslSocketFactoryClass;

    /* renamed from: i, reason: from kotlin metadata */
    private final Class<?> paramClass;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lsdk/pendo/io/g3/l$a;", "", "", "packageName", "Lsdk/pendo/io/g3/k;", "a", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    /* renamed from: sdk.pendo.io.g3.l$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final k a(String packageName) {
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            try {
                Class<?> cls = Class.forName(packageName + ".OpenSSLSocketImpl");
                Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<in javax.net.ssl.SSLSocket>");
                Class<?> cls2 = Class.forName(packageName + ".OpenSSLSocketFactoryImpl");
                Intrinsics.checkNotNull(cls2, "null cannot be cast to non-null type java.lang.Class<in javax.net.ssl.SSLSocketFactory>");
                Class<?> paramsClass = Class.forName(packageName + ".SSLParametersImpl");
                Intrinsics.checkNotNullExpressionValue(paramsClass, "paramsClass");
                return new l(cls, cls2, paramsClass);
            } catch (Exception e) {
                sdk.pendo.io.f3.h.INSTANCE.d().a("unable to load android socket classes", 5, e);
                return null;
            }
        }

        public static /* synthetic */ k a(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = "com.android.org.conscrypt";
            }
            return companion.a(str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Class<? super SSLSocket> sslSocketClass, Class<? super SSLSocketFactory> sslSocketFactoryClass, Class<?> paramClass) {
        super(sslSocketClass);
        Intrinsics.checkNotNullParameter(sslSocketClass, "sslSocketClass");
        Intrinsics.checkNotNullParameter(sslSocketFactoryClass, "sslSocketFactoryClass");
        Intrinsics.checkNotNullParameter(paramClass, "paramClass");
        this.sslSocketFactoryClass = sslSocketFactoryClass;
        this.paramClass = paramClass;
    }
}
