package sdk.pendo.io.l2;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \t2\u00020\u0001:\u0001\u0004B\t\b\u0004¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0006\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lsdk/pendo/io/l2/u;", "Lsdk/pendo/io/l2/h;", "", "toString", "a", "()Ljava/lang/String;", "content", "<init>", "()V", "Companion", "Lsdk/pendo/io/l2/n;", "Lsdk/pendo/io/l2/q;", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public abstract class u extends h {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¨\u0006\u0007"}, d2 = {"Lsdk/pendo/io/l2/u$a;", "", "Lsdk/pendo/io/g2/b;", "Lsdk/pendo/io/l2/u;", "serializer", "<init>", "()V", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0})
    /* renamed from: sdk.pendo.io.l2.u$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final sdk.pendo.io.g2.b<u> serializer() {
            return v.f1312a;
        }
    }

    private u() {
        super(null);
    }

    public abstract String a();

    public String toString() {
        return a();
    }

    public /* synthetic */ u(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
