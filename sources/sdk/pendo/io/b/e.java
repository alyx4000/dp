package sdk.pendo.io.b;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.b.d;
import sdk.pendo.io.m.b;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00042\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lsdk/pendo/io/b/e;", "", "<init>", "()V", "a", "b", "c", "Lsdk/pendo/io/b/e$c;", "Lsdk/pendo/io/b/e$b;", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0002¨\u0006\t"}, d2 = {"Lsdk/pendo/io/b/e$a;", "", "", "", "Lsdk/pendo/io/b/d;", "", "a", "<init>", "()V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
    /* renamed from: sdk.pendo.io.b.e$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<String> a(Map<String, ? extends d> map) {
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry<String, ? extends d> entry : map.entrySet()) {
                arrayList.add(entry.getKey() + ':' + entry.getValue());
            }
            return arrayList;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lsdk/pendo/io/b/e$b;", "Lsdk/pendo/io/b/e;", "<init>", "()V", "a", "b", "c", "d", "e", "Lsdk/pendo/io/b/e$b$b;", "Lsdk/pendo/io/b/e$b$a;", "Lsdk/pendo/io/b/e$b$c;", "Lsdk/pendo/io/b/e$b$d;", "Lsdk/pendo/io/b/e$b$e;", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
    public static abstract class b extends e {

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lsdk/pendo/io/b/e$b$a;", "Lsdk/pendo/io/b/e$b;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lsdk/pendo/io/m/b$a;", "b", "Lsdk/pendo/io/m/b$a;", "getLogListResult", "()Lcom/appmattus/certificatetransparency/loglist/LogListResult$Invalid;", "logListResult", "<init>", "(Lcom/appmattus/certificatetransparency/loglist/LogListResult$Invalid;)V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
        public static final /* data */ class a extends b {

            /* renamed from: b, reason: from kotlin metadata */
            private final b.a logListResult;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b.a logListResult) {
                super(null);
                Intrinsics.checkNotNullParameter(logListResult, "logListResult");
                this.logListResult = logListResult;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof a) && Intrinsics.areEqual(this.logListResult, ((a) other).logListResult);
            }

            public int hashCode() {
                return this.logListResult.hashCode();
            }

            public String toString() {
                return "Failure: Unable to load log servers with " + this.logListResult;
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"Lsdk/pendo/io/b/e$b$b;", "Lsdk/pendo/io/b/e$b;", "", "toString", "<init>", "()V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
        /* renamed from: sdk.pendo.io.b.e$b$b, reason: collision with other inner class name */
        public static final class C0085b extends b {
            public static final C0085b b = new C0085b();

            private C0085b() {
                super(null);
            }

            public String toString() {
                return "Failure: No certificates";
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"Lsdk/pendo/io/b/e$b$c;", "Lsdk/pendo/io/b/e$b;", "", "toString", "<init>", "()V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
        public static final class c extends b {
            public static final c b = new c();

            private c() {
                super(null);
            }

            public String toString() {
                return "Failure: This certificate does not have any Signed Certificate Timestamps in it.";
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R#\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lsdk/pendo/io/b/e$b$d;", "Lsdk/pendo/io/b/e$b;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "Lsdk/pendo/io/b/d;", "b", "Ljava/util/Map;", "getScts", "()Ljava/util/Map;", "scts", "c", "I", "getMinSctCount", "()I", "minSctCount", "<init>", "(Ljava/util/Map;I)V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
        public static final /* data */ class d extends b {

            /* renamed from: b, reason: from kotlin metadata */
            private final Map<String, sdk.pendo.io.b.d> scts;

            /* renamed from: c, reason: from kotlin metadata */
            private final int minSctCount;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public d(Map<String, ? extends sdk.pendo.io.b.d> scts, int i) {
                super(null);
                Intrinsics.checkNotNullParameter(scts, "scts");
                this.scts = scts;
                this.minSctCount = i;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof d)) {
                    return false;
                }
                d dVar = (d) other;
                return Intrinsics.areEqual(this.scts, dVar.scts) && this.minSctCount == dVar.minSctCount;
            }

            public int hashCode() {
                return (this.scts.hashCode() * 31) + Integer.hashCode(this.minSctCount);
            }

            public String toString() {
                Map<String, sdk.pendo.io.b.d> map = this.scts;
                int i = 0;
                if (!map.isEmpty()) {
                    Iterator<Map.Entry<String, sdk.pendo.io.b.d>> it = map.entrySet().iterator();
                    while (it.hasNext()) {
                        if (it.next().getValue() instanceof d.b) {
                            i++;
                        }
                    }
                }
                return "Failure: Too few trusted SCTs, required " + this.minSctCount + ", found " + i + " in " + e.INSTANCE.a(this.scts);
            }
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lsdk/pendo/io/b/e$b$e;", "Lsdk/pendo/io/b/e$b;", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/io/IOException;", "b", "Ljava/io/IOException;", "getIoException", "()Ljava/io/IOException;", "ioException", "<init>", "(Ljava/io/IOException;)V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
        /* renamed from: sdk.pendo.io.b.e$b$e, reason: collision with other inner class name */
        public static final /* data */ class C0086e extends b {

            /* renamed from: b, reason: from kotlin metadata */
            private final IOException ioException;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0086e(IOException ioException) {
                super(null);
                Intrinsics.checkNotNullParameter(ioException, "ioException");
                this.ioException = ioException;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof C0086e) && Intrinsics.areEqual(this.ioException, ((C0086e) other).ioException);
            }

            public int hashCode() {
                return this.ioException.hashCode();
            }

            public String toString() {
                return "Failure: IOException " + this.ioException;
            }
        }

        private b() {
            super(null);
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lsdk/pendo/io/b/e$c;", "Lsdk/pendo/io/b/e;", "<init>", "()V", "a", "b", "c", "Lsdk/pendo/io/b/e$c$a;", "Lsdk/pendo/io/b/e$c$c;", "Lsdk/pendo/io/b/e$c$b;", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
    public static abstract class c extends e {

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lsdk/pendo/io/b/e$c$a;", "Lsdk/pendo/io/b/e$c;", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "Ljava/lang/String;", "getHost", "()Ljava/lang/String;", "host", "<init>", "(Ljava/lang/String;)V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
        public static final /* data */ class a extends c {

            /* renamed from: b, reason: from kotlin metadata */
            private final String host;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String host) {
                super(null);
                Intrinsics.checkNotNullParameter(host, "host");
                this.host = host;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof a) && Intrinsics.areEqual(this.host, ((a) other).host);
            }

            public int hashCode() {
                return this.host.hashCode();
            }

            public String toString() {
                return "Success: SCT not enabled for " + this.host;
            }
        }

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lsdk/pendo/io/b/e$c$b;", "Lsdk/pendo/io/b/e$c;", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "Ljava/lang/String;", "getHost", "()Ljava/lang/String;", "host", "<init>", "(Ljava/lang/String;)V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
        public static final /* data */ class b extends c {

            /* renamed from: b, reason: from kotlin metadata */
            private final String host;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String host) {
                super(null);
                Intrinsics.checkNotNullParameter(host, "host");
                this.host = host;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof b) && Intrinsics.areEqual(this.host, ((b) other).host);
            }

            public int hashCode() {
                return this.host.hashCode();
            }

            public String toString() {
                return "Success: SCT not enabled for insecure connection to " + this.host;
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R#\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lsdk/pendo/io/b/e$c$c;", "Lsdk/pendo/io/b/e$c;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "Lsdk/pendo/io/b/d;", "b", "Ljava/util/Map;", "getScts", "()Ljava/util/Map;", "scts", "<init>", "(Ljava/util/Map;)V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
        /* renamed from: sdk.pendo.io.b.e$c$c, reason: collision with other inner class name */
        public static final /* data */ class C0087c extends c {

            /* renamed from: b, reason: from kotlin metadata */
            private final Map<String, d> scts;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0087c(Map<String, ? extends d> scts) {
                super(null);
                Intrinsics.checkNotNullParameter(scts, "scts");
                this.scts = scts;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof C0087c) && Intrinsics.areEqual(this.scts, ((C0087c) other).scts);
            }

            public int hashCode() {
                return this.scts.hashCode();
            }

            public String toString() {
                return "Success: SCT trusted logs " + e.INSTANCE.a(this.scts);
            }
        }

        private c() {
            super(null);
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private e() {
    }

    public /* synthetic */ e(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
