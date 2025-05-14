package sdk.pendo.io.h5;

import io.sentry.SentryEvent;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.r5.c;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b+\u0010\u000fJ(\u0010\t\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\bR \u0010\u0010\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\t\u0010\u000b\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR \u0010\u0016\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u0012\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0012\u0010\u0014R \u0010\u001d\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u0012\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001a\u0010\u001bR \u0010#\u001a\u00020\u001e8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\f\u0010\u001f\u0012\u0004\b\"\u0010\u000f\u001a\u0004\b \u0010!R*\u0010*\u001a\u00020$2\u0006\u0010%\u001a\u00020$8\u0006@BX\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u0012\u0004\b)\u0010\u000f\u001a\u0004\b\u0018\u0010(¨\u0006,"}, d2 = {"Lsdk/pendo/io/h5/a;", "", "", "Lsdk/pendo/io/o5/a;", SentryEvent.JsonKeys.MODULES, "", "allowOverride", "createEagerInstances", "", "a", "Lsdk/pendo/io/r5/c;", "Lsdk/pendo/io/r5/c;", "d", "()Lsdk/pendo/io/r5/c;", "getScopeRegistry$annotations", "()V", "scopeRegistry", "Lsdk/pendo/io/r5/a;", "b", "Lsdk/pendo/io/r5/a;", "()Lsdk/pendo/io/r5/a;", "getInstanceRegistry$annotations", "instanceRegistry", "Lsdk/pendo/io/r5/b;", "c", "Lsdk/pendo/io/r5/b;", "getPropertyRegistry", "()Lsdk/pendo/io/r5/b;", "getPropertyRegistry$annotations", "propertyRegistry", "Lsdk/pendo/io/l5/a;", "Lsdk/pendo/io/l5/a;", "getExtensionManager", "()Lsdk/pendo/io/l5/a;", "getExtensionManager$annotations", "extensionManager", "Lsdk/pendo/io/n5/c;", "<set-?>", "e", "Lsdk/pendo/io/n5/c;", "()Lsdk/pendo/io/n5/c;", "getLogger$annotations", SentryEvent.JsonKeys.LOGGER, "<init>", "koin-core"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final c scopeRegistry = new c(this);

    /* renamed from: b, reason: from kotlin metadata */
    private final sdk.pendo.io.r5.a instanceRegistry = new sdk.pendo.io.r5.a(this);

    /* renamed from: c, reason: from kotlin metadata */
    private final sdk.pendo.io.r5.b propertyRegistry = new sdk.pendo.io.r5.b(this);

    /* renamed from: d, reason: from kotlin metadata */
    private final sdk.pendo.io.l5.a extensionManager = new sdk.pendo.io.l5.a(this);

    /* renamed from: e, reason: from kotlin metadata */
    private sdk.pendo.io.n5.c logger = new sdk.pendo.io.n5.a();

    public final void a() {
        this.logger.a("Create eager instances ...");
        long a2 = sdk.pendo.io.v5.a.f1683a.a();
        this.instanceRegistry.a();
        this.logger.a("Created eager instances in " + ((Number) new Pair(Unit.INSTANCE, Double.valueOf((r0.a() - a2) / 1000000.0d)).getSecond()).doubleValue() + " ms");
    }

    /* renamed from: b, reason: from getter */
    public final sdk.pendo.io.r5.a getInstanceRegistry() {
        return this.instanceRegistry;
    }

    /* renamed from: c, reason: from getter */
    public final sdk.pendo.io.n5.c getLogger() {
        return this.logger;
    }

    /* renamed from: d, reason: from getter */
    public final c getScopeRegistry() {
        return this.scopeRegistry;
    }

    public final void a(List<sdk.pendo.io.o5.a> modules, boolean allowOverride, boolean createEagerInstances) {
        Intrinsics.checkNotNullParameter(modules, "modules");
        Set<sdk.pendo.io.o5.a> a2 = sdk.pendo.io.o5.b.a(modules);
        this.instanceRegistry.a(a2, allowOverride);
        this.scopeRegistry.a(a2);
        if (createEagerInstances) {
            a();
        }
    }
}
