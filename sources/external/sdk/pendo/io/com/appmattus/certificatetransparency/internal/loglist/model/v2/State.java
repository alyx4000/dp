package external.sdk.pendo.io.com.appmattus.certificatetransparency.internal.loglist.model.v2;

import external.sdk.pendo.io.com.appmattus.certificatetransparency.internal.loglist.model.v2.State;
import java.lang.annotation.Annotation;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import sdk.pendo.io.g2.b;
import sdk.pendo.io.g2.e;
import sdk.pendo.io.i2.f;
import sdk.pendo.io.j2.c;
import sdk.pendo.io.k2.p0;
import sdk.pendo.io.k2.z0;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u0000 \u00142\u00020\u0001:\u0007\u0014\u0015\u0016\u0017\u0018\u0019\u001aB\u001b\b\u0017\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012B\t\b\u0004¢\u0006\u0004\b\u0011\u0010\u0013J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001R\u0014\u0010\f\u001a\u00020\t8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0006\u001b\u001c\u001d\u001e\u001f ¨\u0006!"}, d2 = {"Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/State;", "", "self", "Lsdk/pendo/io/j2/c;", "output", "Lsdk/pendo/io/i2/f;", "serialDesc", "", "write$Self", "", "getTimestamp", "()J", "timestamp", "", "seen1", "Lsdk/pendo/io/k2/z0;", "serializationConstructorMarker", "<init>", "(ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "()V", "Companion", "Pending", "Qualified", "ReadOnly", "Rejected", "Retired", "Usable", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/State$Pending;", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/State$Qualified;", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/State$Usable;", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/State$ReadOnly;", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/State$Retired;", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/State$Rejected;", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes2.dex */
public abstract class State {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<b<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<b<Object>>() { // from class: external.sdk.pendo.io.com.appmattus.certificatetransparency.internal.loglist.model.v2.State$Companion$$cachedSerializer$delegate$1
        @Override // kotlin.jvm.functions.Function0
        public final b<Object> invoke() {
            return new e("external.sdk.pendo.io.com.appmattus.certificatetransparency.internal.loglist.model.v2.State", Reflection.getOrCreateKotlinClass(State.class), new KClass[]{Reflection.getOrCreateKotlinClass(State.Pending.class), Reflection.getOrCreateKotlinClass(State.Qualified.class), Reflection.getOrCreateKotlinClass(State.Usable.class), Reflection.getOrCreateKotlinClass(State.ReadOnly.class), Reflection.getOrCreateKotlinClass(State.Retired.class), Reflection.getOrCreateKotlinClass(State.Rejected.class)}, new b[]{State$Pending$$serializer.INSTANCE, State$Qualified$$serializer.INSTANCE, State$Usable$$serializer.INSTANCE, State$ReadOnly$$serializer.INSTANCE, State$Retired$$serializer.INSTANCE, State$Rejected$$serializer.INSTANCE}, new Annotation[0]);
        }
    });

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¨\u0006\u0007"}, d2 = {"Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/State$Companion;", "", "Lsdk/pendo/io/g2/b;", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/State;", "serializer", "<init>", "()V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ Lazy get$cachedSerializer$delegate() {
            return State.$cachedSerializer$delegate;
        }

        public final b<State> serializer() {
            return (b) get$cachedSerializer$delegate().getValue();
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0002! B%\b\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u000f\u0012\b\b\u0001\u0010\u000b\u001a\u00020\t\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001d\u0010\u001eB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u001fJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\t\u0010\n\u001a\u00020\tHÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\tHÆ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003R \u0010\u000b\u001a\u00020\t8\u0016X\u0097\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010\u0015\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/State$Pending;", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/State;", "self", "Lsdk/pendo/io/j2/c;", "output", "Lsdk/pendo/io/i2/f;", "serialDesc", "", "write$Self", "", "component1", "timestamp", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "J", "getTimestamp", "()J", "getTimestamp$annotations", "()V", "seen1", "Lsdk/pendo/io/k2/z0;", "serializationConstructorMarker", "<init>", "(IJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(J)V", "Companion", "$serializer", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
    public static final /* data */ class Pending extends State {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long timestamp;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¨\u0006\u0007"}, d2 = {"Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/State$Pending$Companion;", "", "Lsdk/pendo/io/g2/b;", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/State$Pending;", "serializer", "<init>", "()V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final b<Pending> serializer() {
                return State$Pending$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ Pending(int i, long j, z0 z0Var) {
            super(i, z0Var);
            if (1 != (i & 1)) {
                p0.a(i, 1, State$Pending$$serializer.INSTANCE.getDescriptor());
            }
            this.timestamp = j;
        }

        public static /* synthetic */ Pending copy$default(Pending pending, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = pending.getTimestamp();
            }
            return pending.copy(j);
        }

        public static /* synthetic */ void getTimestamp$annotations() {
        }

        @JvmStatic
        public static final void write$Self(Pending self, c output, f serialDesc) {
            Intrinsics.checkNotNullParameter(self, "self");
            Intrinsics.checkNotNullParameter(output, "output");
            Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
            State.write$Self(self, output, serialDesc);
            output.b(serialDesc, 0, new sdk.pendo.io.g.c(), Long.valueOf(self.getTimestamp()));
        }

        public final long component1() {
            return getTimestamp();
        }

        public final Pending copy(long timestamp) {
            return new Pending(timestamp);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Pending) && getTimestamp() == ((Pending) other).getTimestamp();
        }

        @Override // external.sdk.pendo.io.com.appmattus.certificatetransparency.internal.loglist.model.v2.State
        public long getTimestamp() {
            return this.timestamp;
        }

        public int hashCode() {
            return Long.hashCode(getTimestamp());
        }

        public String toString() {
            return "Pending(timestamp=" + getTimestamp() + ')';
        }

        public Pending(long j) {
            super(null);
            this.timestamp = j;
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0002! B%\b\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u000f\u0012\b\b\u0001\u0010\u000b\u001a\u00020\t\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001d\u0010\u001eB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u001fJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\t\u0010\n\u001a\u00020\tHÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\tHÆ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003R \u0010\u000b\u001a\u00020\t8\u0016X\u0097\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010\u0015\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/State$Qualified;", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/State;", "self", "Lsdk/pendo/io/j2/c;", "output", "Lsdk/pendo/io/i2/f;", "serialDesc", "", "write$Self", "", "component1", "timestamp", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "J", "getTimestamp", "()J", "getTimestamp$annotations", "()V", "seen1", "Lsdk/pendo/io/k2/z0;", "serializationConstructorMarker", "<init>", "(IJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(J)V", "Companion", "$serializer", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
    public static final /* data */ class Qualified extends State {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long timestamp;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¨\u0006\u0007"}, d2 = {"Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/State$Qualified$Companion;", "", "Lsdk/pendo/io/g2/b;", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/State$Qualified;", "serializer", "<init>", "()V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final b<Qualified> serializer() {
                return State$Qualified$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ Qualified(int i, long j, z0 z0Var) {
            super(i, z0Var);
            if (1 != (i & 1)) {
                p0.a(i, 1, State$Qualified$$serializer.INSTANCE.getDescriptor());
            }
            this.timestamp = j;
        }

        public static /* synthetic */ Qualified copy$default(Qualified qualified, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = qualified.getTimestamp();
            }
            return qualified.copy(j);
        }

        public static /* synthetic */ void getTimestamp$annotations() {
        }

        @JvmStatic
        public static final void write$Self(Qualified self, c output, f serialDesc) {
            Intrinsics.checkNotNullParameter(self, "self");
            Intrinsics.checkNotNullParameter(output, "output");
            Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
            State.write$Self(self, output, serialDesc);
            output.b(serialDesc, 0, new sdk.pendo.io.g.c(), Long.valueOf(self.getTimestamp()));
        }

        public final long component1() {
            return getTimestamp();
        }

        public final Qualified copy(long timestamp) {
            return new Qualified(timestamp);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Qualified) && getTimestamp() == ((Qualified) other).getTimestamp();
        }

        @Override // external.sdk.pendo.io.com.appmattus.certificatetransparency.internal.loglist.model.v2.State
        public long getTimestamp() {
            return this.timestamp;
        }

        public int hashCode() {
            return Long.hashCode(getTimestamp());
        }

        public String toString() {
            return "Qualified(timestamp=" + getTimestamp() + ')';
        }

        public Qualified(long j) {
            super(null);
            this.timestamp = j;
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002('B1\b\u0017\u0012\u0006\u0010!\u001a\u00020\u0012\u0012\b\b\u0001\u0010\r\u001a\u00020\t\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010#\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b$\u0010%B\u0017\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b$\u0010&J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\t\u0010\n\u001a\u00020\tHÆ\u0003J\t\u0010\f\u001a\u00020\u000bHÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000bHÆ\u0001J\t\u0010\u0011\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003R \u0010\r\u001a\u00020\t8\u0016X\u0097\u0004¢\u0006\u0012\n\u0004\b\r\u0010\u0018\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR \u0010\u000e\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u000e\u0010\u001d\u0012\u0004\b \u0010\u001c\u001a\u0004\b\u001e\u0010\u001f¨\u0006)"}, d2 = {"Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/State$ReadOnly;", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/State;", "self", "Lsdk/pendo/io/j2/c;", "output", "Lsdk/pendo/io/i2/f;", "serialDesc", "", "write$Self", "", "component1", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/FinalTreeHead;", "component2", "timestamp", "finalTreeHead", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "J", "getTimestamp", "()J", "getTimestamp$annotations", "()V", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/FinalTreeHead;", "getFinalTreeHead", "()Lcom/appmattus/certificatetransparency/internal/loglist/model/v2/FinalTreeHead;", "getFinalTreeHead$annotations", "seen1", "Lsdk/pendo/io/k2/z0;", "serializationConstructorMarker", "<init>", "(IJLcom/appmattus/certificatetransparency/internal/loglist/model/v2/FinalTreeHead;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(JLcom/appmattus/certificatetransparency/internal/loglist/model/v2/FinalTreeHead;)V", "Companion", "$serializer", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
    public static final /* data */ class ReadOnly extends State {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final FinalTreeHead finalTreeHead;
        private final long timestamp;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¨\u0006\u0007"}, d2 = {"Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/State$ReadOnly$Companion;", "", "Lsdk/pendo/io/g2/b;", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/State$ReadOnly;", "serializer", "<init>", "()V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final b<ReadOnly> serializer() {
                return State$ReadOnly$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ ReadOnly(int i, long j, FinalTreeHead finalTreeHead, z0 z0Var) {
            super(i, z0Var);
            if (3 != (i & 3)) {
                p0.a(i, 3, State$ReadOnly$$serializer.INSTANCE.getDescriptor());
            }
            this.timestamp = j;
            this.finalTreeHead = finalTreeHead;
        }

        public static /* synthetic */ ReadOnly copy$default(ReadOnly readOnly, long j, FinalTreeHead finalTreeHead, int i, Object obj) {
            if ((i & 1) != 0) {
                j = readOnly.getTimestamp();
            }
            if ((i & 2) != 0) {
                finalTreeHead = readOnly.finalTreeHead;
            }
            return readOnly.copy(j, finalTreeHead);
        }

        public static /* synthetic */ void getFinalTreeHead$annotations() {
        }

        public static /* synthetic */ void getTimestamp$annotations() {
        }

        @JvmStatic
        public static final void write$Self(ReadOnly self, c output, f serialDesc) {
            Intrinsics.checkNotNullParameter(self, "self");
            Intrinsics.checkNotNullParameter(output, "output");
            Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
            State.write$Self(self, output, serialDesc);
            output.b(serialDesc, 0, new sdk.pendo.io.g.c(), Long.valueOf(self.getTimestamp()));
            output.b(serialDesc, 1, FinalTreeHead$$serializer.INSTANCE, self.finalTreeHead);
        }

        public final long component1() {
            return getTimestamp();
        }

        /* renamed from: component2, reason: from getter */
        public final FinalTreeHead getFinalTreeHead() {
            return this.finalTreeHead;
        }

        public final ReadOnly copy(long timestamp, FinalTreeHead finalTreeHead) {
            Intrinsics.checkNotNullParameter(finalTreeHead, "finalTreeHead");
            return new ReadOnly(timestamp, finalTreeHead);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReadOnly)) {
                return false;
            }
            ReadOnly readOnly = (ReadOnly) other;
            return getTimestamp() == readOnly.getTimestamp() && Intrinsics.areEqual(this.finalTreeHead, readOnly.finalTreeHead);
        }

        public final FinalTreeHead getFinalTreeHead() {
            return this.finalTreeHead;
        }

        @Override // external.sdk.pendo.io.com.appmattus.certificatetransparency.internal.loglist.model.v2.State
        public long getTimestamp() {
            return this.timestamp;
        }

        public int hashCode() {
            return (Long.hashCode(getTimestamp()) * 31) + this.finalTreeHead.hashCode();
        }

        public String toString() {
            return "ReadOnly(timestamp=" + getTimestamp() + ", finalTreeHead=" + this.finalTreeHead + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReadOnly(long j, FinalTreeHead finalTreeHead) {
            super(null);
            Intrinsics.checkNotNullParameter(finalTreeHead, "finalTreeHead");
            this.timestamp = j;
            this.finalTreeHead = finalTreeHead;
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0002! B%\b\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u000f\u0012\b\b\u0001\u0010\u000b\u001a\u00020\t\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001d\u0010\u001eB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u001fJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\t\u0010\n\u001a\u00020\tHÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\tHÆ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003R \u0010\u000b\u001a\u00020\t8\u0016X\u0097\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010\u0015\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/State$Rejected;", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/State;", "self", "Lsdk/pendo/io/j2/c;", "output", "Lsdk/pendo/io/i2/f;", "serialDesc", "", "write$Self", "", "component1", "timestamp", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "J", "getTimestamp", "()J", "getTimestamp$annotations", "()V", "seen1", "Lsdk/pendo/io/k2/z0;", "serializationConstructorMarker", "<init>", "(IJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(J)V", "Companion", "$serializer", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
    public static final /* data */ class Rejected extends State {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long timestamp;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¨\u0006\u0007"}, d2 = {"Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/State$Rejected$Companion;", "", "Lsdk/pendo/io/g2/b;", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/State$Rejected;", "serializer", "<init>", "()V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final b<Rejected> serializer() {
                return State$Rejected$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ Rejected(int i, long j, z0 z0Var) {
            super(i, z0Var);
            if (1 != (i & 1)) {
                p0.a(i, 1, State$Rejected$$serializer.INSTANCE.getDescriptor());
            }
            this.timestamp = j;
        }

        public static /* synthetic */ Rejected copy$default(Rejected rejected, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = rejected.getTimestamp();
            }
            return rejected.copy(j);
        }

        public static /* synthetic */ void getTimestamp$annotations() {
        }

        @JvmStatic
        public static final void write$Self(Rejected self, c output, f serialDesc) {
            Intrinsics.checkNotNullParameter(self, "self");
            Intrinsics.checkNotNullParameter(output, "output");
            Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
            State.write$Self(self, output, serialDesc);
            output.b(serialDesc, 0, new sdk.pendo.io.g.c(), Long.valueOf(self.getTimestamp()));
        }

        public final long component1() {
            return getTimestamp();
        }

        public final Rejected copy(long timestamp) {
            return new Rejected(timestamp);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Rejected) && getTimestamp() == ((Rejected) other).getTimestamp();
        }

        @Override // external.sdk.pendo.io.com.appmattus.certificatetransparency.internal.loglist.model.v2.State
        public long getTimestamp() {
            return this.timestamp;
        }

        public int hashCode() {
            return Long.hashCode(getTimestamp());
        }

        public String toString() {
            return "Rejected(timestamp=" + getTimestamp() + ')';
        }

        public Rejected(long j) {
            super(null);
            this.timestamp = j;
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0002! B%\b\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u000f\u0012\b\b\u0001\u0010\u000b\u001a\u00020\t\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001d\u0010\u001eB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u001fJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\t\u0010\n\u001a\u00020\tHÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\tHÆ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003R \u0010\u000b\u001a\u00020\t8\u0016X\u0097\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010\u0015\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/State$Retired;", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/State;", "self", "Lsdk/pendo/io/j2/c;", "output", "Lsdk/pendo/io/i2/f;", "serialDesc", "", "write$Self", "", "component1", "timestamp", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "J", "getTimestamp", "()J", "getTimestamp$annotations", "()V", "seen1", "Lsdk/pendo/io/k2/z0;", "serializationConstructorMarker", "<init>", "(IJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(J)V", "Companion", "$serializer", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
    public static final /* data */ class Retired extends State {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long timestamp;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¨\u0006\u0007"}, d2 = {"Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/State$Retired$Companion;", "", "Lsdk/pendo/io/g2/b;", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/State$Retired;", "serializer", "<init>", "()V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final b<Retired> serializer() {
                return State$Retired$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ Retired(int i, long j, z0 z0Var) {
            super(i, z0Var);
            if (1 != (i & 1)) {
                p0.a(i, 1, State$Retired$$serializer.INSTANCE.getDescriptor());
            }
            this.timestamp = j;
        }

        public static /* synthetic */ Retired copy$default(Retired retired, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = retired.getTimestamp();
            }
            return retired.copy(j);
        }

        public static /* synthetic */ void getTimestamp$annotations() {
        }

        @JvmStatic
        public static final void write$Self(Retired self, c output, f serialDesc) {
            Intrinsics.checkNotNullParameter(self, "self");
            Intrinsics.checkNotNullParameter(output, "output");
            Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
            State.write$Self(self, output, serialDesc);
            output.b(serialDesc, 0, new sdk.pendo.io.g.c(), Long.valueOf(self.getTimestamp()));
        }

        public final long component1() {
            return getTimestamp();
        }

        public final Retired copy(long timestamp) {
            return new Retired(timestamp);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Retired) && getTimestamp() == ((Retired) other).getTimestamp();
        }

        @Override // external.sdk.pendo.io.com.appmattus.certificatetransparency.internal.loglist.model.v2.State
        public long getTimestamp() {
            return this.timestamp;
        }

        public int hashCode() {
            return Long.hashCode(getTimestamp());
        }

        public String toString() {
            return "Retired(timestamp=" + getTimestamp() + ')';
        }

        public Retired(long j) {
            super(null);
            this.timestamp = j;
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0002! B%\b\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u000f\u0012\b\b\u0001\u0010\u000b\u001a\u00020\t\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001d\u0010\u001eB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u001fJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\t\u0010\n\u001a\u00020\tHÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\tHÆ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003R \u0010\u000b\u001a\u00020\t8\u0016X\u0097\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010\u0015\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/State$Usable;", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/State;", "self", "Lsdk/pendo/io/j2/c;", "output", "Lsdk/pendo/io/i2/f;", "serialDesc", "", "write$Self", "", "component1", "timestamp", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "J", "getTimestamp", "()J", "getTimestamp$annotations", "()V", "seen1", "Lsdk/pendo/io/k2/z0;", "serializationConstructorMarker", "<init>", "(IJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(J)V", "Companion", "$serializer", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
    public static final /* data */ class Usable extends State {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long timestamp;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¨\u0006\u0007"}, d2 = {"Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/State$Usable$Companion;", "", "Lsdk/pendo/io/g2/b;", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/State$Usable;", "serializer", "<init>", "()V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final b<Usable> serializer() {
                return State$Usable$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ Usable(int i, long j, z0 z0Var) {
            super(i, z0Var);
            if (1 != (i & 1)) {
                p0.a(i, 1, State$Usable$$serializer.INSTANCE.getDescriptor());
            }
            this.timestamp = j;
        }

        public static /* synthetic */ Usable copy$default(Usable usable, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = usable.getTimestamp();
            }
            return usable.copy(j);
        }

        public static /* synthetic */ void getTimestamp$annotations() {
        }

        @JvmStatic
        public static final void write$Self(Usable self, c output, f serialDesc) {
            Intrinsics.checkNotNullParameter(self, "self");
            Intrinsics.checkNotNullParameter(output, "output");
            Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
            State.write$Self(self, output, serialDesc);
            output.b(serialDesc, 0, new sdk.pendo.io.g.c(), Long.valueOf(self.getTimestamp()));
        }

        public final long component1() {
            return getTimestamp();
        }

        public final Usable copy(long timestamp) {
            return new Usable(timestamp);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Usable) && getTimestamp() == ((Usable) other).getTimestamp();
        }

        @Override // external.sdk.pendo.io.com.appmattus.certificatetransparency.internal.loglist.model.v2.State
        public long getTimestamp() {
            return this.timestamp;
        }

        public int hashCode() {
            return Long.hashCode(getTimestamp());
        }

        public String toString() {
            return "Usable(timestamp=" + getTimestamp() + ')';
        }

        public Usable(long j) {
            super(null);
            this.timestamp = j;
        }
    }

    private State() {
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ State(int i, z0 z0Var) {
    }

    public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final void write$Self(State self, c output, f serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
    }

    public abstract long getTimestamp();
}
