package sdk.pendo.io.h5;

import io.sentry.SentryEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.n5.c;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0006B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J!\u0010\u0006\u001a\u00020\u00002\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0007\"\u00020\u0003¢\u0006\u0004\b\u0006\u0010\bJ\u0014\u0010\t\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0006\u0010\u0006\u001a\u00020\u0005R\u0017\u0010\r\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000b\u001a\u0004\b\t\u0010\fR\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u000f¨\u0006\u0014"}, d2 = {"Lsdk/pendo/io/h5/b;", "", "", "Lsdk/pendo/io/o5/a;", SentryEvent.JsonKeys.MODULES, "", "a", "", "([Lsdk/pendo/io/o5/a;)Lsdk/pendo/io/h5/b;", "b", "Lsdk/pendo/io/h5/a;", "Lsdk/pendo/io/h5/a;", "()Lsdk/pendo/io/h5/a;", "koin", "", "Z", "allowOverride", "<init>", "()V", "c", "koin-core"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: c, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final a koin;

    /* renamed from: b, reason: from kotlin metadata */
    private boolean allowOverride;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0006"}, d2 = {"Lsdk/pendo/io/h5/b$a;", "", "Lsdk/pendo/io/h5/b;", "a", "<init>", "()V", "koin-core"}, k = 1, mv = {1, 9, 0})
    /* renamed from: sdk.pendo.io.h5.b$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final b a() {
            return new b(null);
        }
    }

    private b() {
        this.koin = new a();
        this.allowOverride = true;
    }

    public final void a() {
        this.koin.a();
    }

    /* renamed from: b, reason: from getter */
    public final a getKoin() {
        return this.koin;
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final void a(List<sdk.pendo.io.o5.a> modules) {
        this.koin.a(modules, this.allowOverride, false);
    }

    public final b b(List<sdk.pendo.io.o5.a> modules) {
        Intrinsics.checkNotNullParameter(modules, "modules");
        c cVar = this.koin.getIo.sentry.SentryEvent.JsonKeys.LOGGER java.lang.String();
        sdk.pendo.io.n5.b bVar = sdk.pendo.io.n5.b.INFO;
        if (cVar.a(bVar)) {
            long a2 = sdk.pendo.io.v5.a.f1683a.a();
            a(modules);
            this.koin.getIo.sentry.SentryEvent.JsonKeys.LOGGER java.lang.String().a(bVar, "Started " + this.koin.getInstanceRegistry().b() + " definitions in " + ((Number) new Pair(Unit.INSTANCE, Double.valueOf((r0.a() - a2) / 1000000.0d)).getSecond()).doubleValue() + " ms");
        } else {
            a(modules);
        }
        return this;
    }

    public final b a(sdk.pendo.io.o5.a... modules) {
        Intrinsics.checkNotNullParameter(modules, "modules");
        return b(ArraysKt.toList(modules));
    }
}
