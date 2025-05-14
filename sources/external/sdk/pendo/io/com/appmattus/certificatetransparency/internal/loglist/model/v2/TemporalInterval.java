package external.sdk.pendo.io.com.appmattus.certificatetransparency.internal.loglist.model.v2;

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
import sdk.pendo.io.k2.p0;
import sdk.pendo.io.k2.z0;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0081\b\u0018\u0000 #2\u00020\u0001:\u0002$#B/\b\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u0011\u0012\b\b\u0001\u0010\f\u001a\u00020\t\u0012\b\b\u0001\u0010\r\u001a\u00020\t\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b \u0010!B\u0017\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b \u0010\"J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\t\u0010\n\u001a\u00020\tHÆ\u0003J\t\u0010\u000b\u001a\u00020\tHÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\tHÆ\u0001J\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003R \u0010\f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\f\u0010\u0016\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R \u0010\r\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\r\u0010\u0016\u0012\u0004\b\u001c\u0010\u001a\u001a\u0004\b\u001b\u0010\u0018¨\u0006%"}, d2 = {"Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/TemporalInterval;", "", "self", "Lsdk/pendo/io/j2/c;", "output", "Lsdk/pendo/io/i2/f;", "serialDesc", "", "write$Self", "", "component1", "component2", "startInclusive", "endExclusive", "copy", "", "toString", "", "hashCode", "other", "", "equals", "J", "getStartInclusive", "()J", "getStartInclusive$annotations", "()V", "getEndExclusive", "getEndExclusive$annotations", "seen1", "Lsdk/pendo/io/k2/z0;", "serializationConstructorMarker", "<init>", "(IJJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(JJ)V", "Companion", "$serializer", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes2.dex */
public final /* data */ class TemporalInterval {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long endExclusive;
    private final long startInclusive;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¨\u0006\u0007"}, d2 = {"Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/TemporalInterval$Companion;", "", "Lsdk/pendo/io/g2/b;", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/TemporalInterval;", "serializer", "<init>", "()V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final b<TemporalInterval> serializer() {
            return TemporalInterval$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ TemporalInterval(int i, long j, long j2, z0 z0Var) {
        if (3 != (i & 3)) {
            p0.a(i, 3, TemporalInterval$$serializer.INSTANCE.getDescriptor());
        }
        this.startInclusive = j;
        this.endExclusive = j2;
    }

    public static /* synthetic */ TemporalInterval copy$default(TemporalInterval temporalInterval, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = temporalInterval.startInclusive;
        }
        if ((i & 2) != 0) {
            j2 = temporalInterval.endExclusive;
        }
        return temporalInterval.copy(j, j2);
    }

    public static /* synthetic */ void getEndExclusive$annotations() {
    }

    public static /* synthetic */ void getStartInclusive$annotations() {
    }

    @JvmStatic
    public static final void write$Self(TemporalInterval self, c output, f serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        output.b(serialDesc, 0, new sdk.pendo.io.g.c(), Long.valueOf(self.startInclusive));
        output.b(serialDesc, 1, new sdk.pendo.io.g.c(), Long.valueOf(self.endExclusive));
    }

    /* renamed from: component1, reason: from getter */
    public final long getStartInclusive() {
        return this.startInclusive;
    }

    /* renamed from: component2, reason: from getter */
    public final long getEndExclusive() {
        return this.endExclusive;
    }

    public final TemporalInterval copy(long startInclusive, long endExclusive) {
        return new TemporalInterval(startInclusive, endExclusive);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TemporalInterval)) {
            return false;
        }
        TemporalInterval temporalInterval = (TemporalInterval) other;
        return this.startInclusive == temporalInterval.startInclusive && this.endExclusive == temporalInterval.endExclusive;
    }

    public final long getEndExclusive() {
        return this.endExclusive;
    }

    public final long getStartInclusive() {
        return this.startInclusive;
    }

    public int hashCode() {
        return (Long.hashCode(this.startInclusive) * 31) + Long.hashCode(this.endExclusive);
    }

    public String toString() {
        return "TemporalInterval(startInclusive=" + this.startInclusive + ", endExclusive=" + this.endExclusive + ')';
    }

    public TemporalInterval(long j, long j2) {
        this.startInclusive = j;
        this.endExclusive = j2;
    }
}
