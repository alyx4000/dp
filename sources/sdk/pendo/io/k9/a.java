package sdk.pendo.io.k9;

import android.content.Context;
import io.sentry.protocol.Request;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sdk.pendo.io.g9.i0;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R$\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\u0005\u0010\n¨\u0006\u000f"}, d2 = {"Lsdk/pendo/io/k9/a;", "", "Landroid/content/Context;", "context", "", "a", "", "Ljava/lang/String;", "getEnv", "()Ljava/lang/String;", "(Ljava/lang/String;)V", Request.JsonKeys.ENV, "<init>", "()V", "b", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: b, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static a c;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String env;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\b\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0006¨\u0006\u000b"}, d2 = {"Lsdk/pendo/io/k9/a$a;", "", "Lsdk/pendo/io/k9/a;", "_INSTANCE", "Lsdk/pendo/io/k9/a;", "b", "()Lsdk/pendo/io/k9/a;", "a", "INSTANCE", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    /* renamed from: sdk.pendo.io.k9.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final a b() {
            a aVar = a.c;
            if (aVar != null) {
                return aVar;
            }
            a.c = new a();
            return a.c;
        }

        public final a a() {
            a b = b();
            Intrinsics.checkNotNull(b);
            return b;
        }
    }

    public final void a(String str) {
        this.env = str;
    }

    public final boolean a(Context context) {
        String str = this.env;
        boolean z = true;
        if ((str == null || StringsKt.isBlank(str)) || context == null) {
            return false;
        }
        String str2 = this.env;
        if (!StringsKt.equals("DEV", str2, true) && !StringsKt.equals("STAGING", str2, true)) {
            z = false;
        }
        if (z) {
            return i0.c(context);
        }
        return false;
    }
}
