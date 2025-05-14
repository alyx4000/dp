package sdk.pendo.io.m;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lsdk/pendo/io/m/b;", "", "<init>", "()V", "a", "b", "Lsdk/pendo/io/m/b$b;", "Lsdk/pendo/io/m/b$a;", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public abstract class b {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lsdk/pendo/io/m/b$a;", "Lsdk/pendo/io/m/b;", "<init>", "()V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
    public static class a extends b {
        public a() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e¨\u0006\u0012"}, d2 = {"Lsdk/pendo/io/m/b$b;", "Lsdk/pendo/io/m/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "Lsdk/pendo/io/m/d;", "a", "Ljava/util/List;", "()Ljava/util/List;", "servers", "<init>", "(Ljava/util/List;)V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
    /* renamed from: sdk.pendo.io.m.b$b, reason: collision with other inner class name */
    public static final /* data */ class C0193b extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final List<d> servers;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0193b(List<d> servers) {
            super(null);
            Intrinsics.checkNotNullParameter(servers, "servers");
            this.servers = servers;
        }

        public final List<d> a() {
            return this.servers;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof C0193b) && Intrinsics.areEqual(this.servers, ((C0193b) other).servers);
        }

        public int hashCode() {
            return this.servers.hashCode();
        }

        public String toString() {
            return "Valid(servers=" + this.servers + ')';
        }
    }

    private b() {
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
