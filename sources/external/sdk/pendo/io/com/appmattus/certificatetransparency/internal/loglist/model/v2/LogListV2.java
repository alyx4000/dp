package external.sdk.pendo.io.com.appmattus.certificatetransparency.internal.loglist.model.v2;

import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.g2.b;
import sdk.pendo.io.i2.f;
import sdk.pendo.io.j2.c;
import sdk.pendo.io.k2.d1;
import sdk.pendo.io.k2.e;
import sdk.pendo.io.k2.p0;
import sdk.pendo.io.k2.z0;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0081\b\u0018\u0000 &2\u00020\u0001:\u0002'&B9\b\u0017\u0012\u0006\u0010 \u001a\u00020\u0012\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0001\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0004\b#\u0010$B!\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b#\u0010%J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J%\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\t\u0010\u0011\u001a\u00020\tHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u000e\u0010\u0017\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R&\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u000f\u0010\u001c\u0012\u0004\b\u001f\u0010\u001b\u001a\u0004\b\u001d\u0010\u001e¨\u0006("}, d2 = {"Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/LogListV2;", "", "self", "Lsdk/pendo/io/j2/c;", "output", "Lsdk/pendo/io/i2/f;", "serialDesc", "", "write$Self", "", "component1", "", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/Operator;", "component2", "version", "operators", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getVersion", "()Ljava/lang/String;", "getVersion$annotations", "()V", "Ljava/util/List;", "getOperators", "()Ljava/util/List;", "getOperators$annotations", "seen1", "Lsdk/pendo/io/k2/z0;", "serializationConstructorMarker", "<init>", "(ILjava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/util/List;)V", "Companion", "$serializer", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes2.dex */
public final /* data */ class LogListV2 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<Operator> operators;
    private final String version;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¨\u0006\u0007"}, d2 = {"Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/LogListV2$Companion;", "", "Lsdk/pendo/io/g2/b;", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/LogListV2;", "serializer", "<init>", "()V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final b<LogListV2> serializer() {
            return LogListV2$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ LogListV2(int i, String str, List list, z0 z0Var) {
        if (2 != (i & 2)) {
            p0.a(i, 2, LogListV2$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.version = null;
        } else {
            this.version = str;
        }
        this.operators = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LogListV2 copy$default(LogListV2 logListV2, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = logListV2.version;
        }
        if ((i & 2) != 0) {
            list = logListV2.operators;
        }
        return logListV2.copy(str, list);
    }

    public static /* synthetic */ void getOperators$annotations() {
    }

    public static /* synthetic */ void getVersion$annotations() {
    }

    @JvmStatic
    public static final void write$Self(LogListV2 self, c output, f serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        if (output.a(serialDesc, 0) || self.version != null) {
            output.a(serialDesc, 0, d1.f1255a, self.version);
        }
        output.b(serialDesc, 1, new e(Operator$$serializer.INSTANCE), self.operators);
    }

    /* renamed from: component1, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public final List<Operator> component2() {
        return this.operators;
    }

    public final LogListV2 copy(String version, List<Operator> operators) {
        Intrinsics.checkNotNullParameter(operators, "operators");
        return new LogListV2(version, operators);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LogListV2)) {
            return false;
        }
        LogListV2 logListV2 = (LogListV2) other;
        return Intrinsics.areEqual(this.version, logListV2.version) && Intrinsics.areEqual(this.operators, logListV2.operators);
    }

    public final List<Operator> getOperators() {
        return this.operators;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        String str = this.version;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.operators.hashCode();
    }

    public String toString() {
        return "LogListV2(version=" + this.version + ", operators=" + this.operators + ')';
    }

    public LogListV2(String str, List<Operator> operators) {
        Intrinsics.checkNotNullParameter(operators, "operators");
        this.version = str;
        this.operators = operators;
    }

    public /* synthetic */ LogListV2(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, list);
    }
}
