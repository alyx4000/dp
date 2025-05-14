package sdk.pendo.io.m;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lsdk/pendo/io/m/e;", "", "<init>", "()V", "a", "b", "Lsdk/pendo/io/m/e$b;", "Lsdk/pendo/io/m/e$a;", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public abstract class e {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lsdk/pendo/io/m/e$a;", "Lsdk/pendo/io/m/e;", "<init>", "()V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
    public static class a extends e {
        public a() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\t\u001a\u00020\bHÆ\u0003J\t\u0010\n\u001a\u00020\bHÆ\u0003J\t\u0010\f\u001a\u00020\u000bHÖ\u0001R\u0017\u0010\u0010\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\r\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0015"}, d2 = {"Lsdk/pendo/io/m/e$b;", "Lsdk/pendo/io/m/e;", "", "other", "", "equals", "", "hashCode", "", "a", "b", "", "toString", "[B", "getLogList", "()[B", "logList", "getSignature", "signature", "<init>", "([B[B)V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
    public static final /* data */ class b extends e {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final byte[] logList;

        /* renamed from: b, reason: from kotlin metadata */
        private final byte[] signature;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(byte[] logList, byte[] signature) {
            super(null);
            Intrinsics.checkNotNullParameter(logList, "logList");
            Intrinsics.checkNotNullParameter(signature, "signature");
            this.logList = logList;
            this.signature = signature;
        }

        /* renamed from: a, reason: from getter */
        public final byte[] getLogList() {
            return this.logList;
        }

        /* renamed from: b, reason: from getter */
        public final byte[] getSignature() {
            return this.signature;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!Intrinsics.areEqual(b.class, other != null ? other.getClass() : null)) {
                return false;
            }
            if (other == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.appmattus.certificatetransparency.loglist.RawLogListResult.Success");
            }
            b bVar = (b) other;
            return Arrays.equals(this.logList, bVar.logList) && Arrays.equals(this.signature, bVar.signature);
        }

        public int hashCode() {
            return (Arrays.hashCode(this.logList) * 31) + Arrays.hashCode(this.signature);
        }

        public String toString() {
            return "Success(logList=" + Arrays.toString(this.logList) + ", signature=" + Arrays.toString(this.signature) + ')';
        }
    }

    private e() {
    }

    public /* synthetic */ e(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
