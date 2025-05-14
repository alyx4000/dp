package sdk.pendo.io.l2;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002HÆ\u0001R\u001a\u0010\t\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lsdk/pendo/io/l2/q;", "Lsdk/pendo/io/l2/u;", "Lsdk/pendo/io/g2/b;", "serializer", "", "f", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "content", "<init>", "()V", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class q extends u {
    public static final q INSTANCE = new q();

    /* renamed from: f, reason: from kotlin metadata */
    private static final String content = "null";
    private static final /* synthetic */ Lazy<sdk.pendo.io.g2.b<Object>> s = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) a.f);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends Lambda implements Function0<sdk.pendo.io.g2.b<Object>> {
        public static final a f = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final sdk.pendo.io.g2.b<Object> invoke() {
            return r.f1309a;
        }
    }

    private q() {
        super(null);
    }

    private final /* synthetic */ Lazy b() {
        return s;
    }

    @Override // sdk.pendo.io.l2.u
    public String a() {
        return content;
    }

    public final sdk.pendo.io.g2.b<q> serializer() {
        return (sdk.pendo.io.g2.b) b().getValue();
    }
}
