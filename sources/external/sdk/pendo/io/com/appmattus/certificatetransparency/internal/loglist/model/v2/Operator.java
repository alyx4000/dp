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

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0081\b\u0018\u0000 *2\u00020\u0001:\u0002+*BK\b\u0017\u0012\u0006\u0010$\u001a\u00020\u0014\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0001\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b\u0012\u0010\b\u0001\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b\u0012\b\u0010&\u001a\u0004\u0018\u00010%¢\u0006\u0004\b'\u0010(B+\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0004\b'\u0010)J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\t\u0010\n\u001a\u00020\tHÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000bHÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000bHÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\t2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u000bHÆ\u0001J\t\u0010\u0013\u001a\u00020\tHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003R \u0010\u000f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u000f\u0010\u0019\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR&\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u000b8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010\u001e\u0012\u0004\b!\u0010\u001d\u001a\u0004\b\u001f\u0010 R&\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u000b8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0011\u0010\u001e\u0012\u0004\b#\u0010\u001d\u001a\u0004\b\"\u0010 ¨\u0006,"}, d2 = {"Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/Operator;", "", "self", "Lsdk/pendo/io/j2/c;", "output", "Lsdk/pendo/io/i2/f;", "serialDesc", "", "write$Self", "", "component1", "", "component2", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/Log;", "component3", "name", "email", "logs", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "getName$annotations", "()V", "Ljava/util/List;", "getEmail", "()Ljava/util/List;", "getEmail$annotations", "getLogs", "getLogs$annotations", "seen1", "Lsdk/pendo/io/k2/z0;", "serializationConstructorMarker", "<init>", "(ILjava/lang/String;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "Companion", "$serializer", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes2.dex */
public final /* data */ class Operator {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<String> email;
    private final List<Log> logs;
    private final String name;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¨\u0006\u0007"}, d2 = {"Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/Operator$Companion;", "", "Lsdk/pendo/io/g2/b;", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/Operator;", "serializer", "<init>", "()V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final b<Operator> serializer() {
            return Operator$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ Operator(int i, String str, List list, List list2, z0 z0Var) {
        if (7 != (i & 7)) {
            p0.a(i, 7, Operator$$serializer.INSTANCE.getDescriptor());
        }
        this.name = str;
        this.email = list;
        this.logs = list2;
        if (!(str.length() > 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(!list.isEmpty())) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(!list2.isEmpty())) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Operator copy$default(Operator operator, String str, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = operator.name;
        }
        if ((i & 2) != 0) {
            list = operator.email;
        }
        if ((i & 4) != 0) {
            list2 = operator.logs;
        }
        return operator.copy(str, list, list2);
    }

    public static /* synthetic */ void getEmail$annotations() {
    }

    public static /* synthetic */ void getLogs$annotations() {
    }

    public static /* synthetic */ void getName$annotations() {
    }

    @JvmStatic
    public static final void write$Self(Operator self, c output, f serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        output.a(serialDesc, 0, self.name);
        output.b(serialDesc, 1, new e(d1.f1255a), self.email);
        output.b(serialDesc, 2, new e(Log$$serializer.INSTANCE), self.logs);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final List<String> component2() {
        return this.email;
    }

    public final List<Log> component3() {
        return this.logs;
    }

    public final Operator copy(String name, List<String> email, List<Log> logs) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(logs, "logs");
        return new Operator(name, email, logs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Operator)) {
            return false;
        }
        Operator operator = (Operator) other;
        return Intrinsics.areEqual(this.name, operator.name) && Intrinsics.areEqual(this.email, operator.email) && Intrinsics.areEqual(this.logs, operator.logs);
    }

    public final List<String> getEmail() {
        return this.email;
    }

    public final List<Log> getLogs() {
        return this.logs;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.email.hashCode()) * 31) + this.logs.hashCode();
    }

    public String toString() {
        return "Operator(name=" + this.name + ", email=" + this.email + ", logs=" + this.logs + ')';
    }

    public Operator(String name, List<String> email, List<Log> logs) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(logs, "logs");
        this.name = name;
        this.email = email;
        this.logs = logs;
        if (!(name.length() > 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(!email.isEmpty())) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(!logs.isEmpty())) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }
}
