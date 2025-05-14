package sdk.pendo.io.r5;

import androidx.exifinterface.media.ExifInterface;
import io.sentry.SentryEvent;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010%\u001a\u00020!¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\u0005\u001a\u00020\u00042\u0010\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bH\u0002J%\u0010\u0005\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0005\u0010\rJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0005\u0010\u000eJ2\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u00102\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u0006H\u0007J3\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00122\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0000¢\u0006\u0004\b\u0005\u0010\u001aJ=\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001cH\u0000¢\u0006\u0004\b\u0005\u0010\u001eJ\u0006\u0010 \u001a\u00020\u001fR\u0017\u0010%\u001a\u00020!8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010$R(\u0010(\u001a\u0016\u0012\b\u0012\u00060\u000fj\u0002`\u0010\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00120&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010'R8\u0010\n\u001a&\u0012\u0004\u0012\u00020\u001f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0)j\u0012\u0012\u0004\u0012\u00020\u001f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t`*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006/"}, d2 = {"Lsdk/pendo/io/r5/a;", "", "Lsdk/pendo/io/o5/a;", "module", "", "a", "", "allowOverride", "", "Lsdk/pendo/io/m5/c;", "eagerInstances", "", SentryEvent.JsonKeys.MODULES, "(Ljava/util/Set;Z)V", "()V", "", "Lexternal/sdk/pendo/io/org/koin/core/definition/IndexKey;", "mapping", "Lsdk/pendo/io/m5/b;", "factory", "logWarning", "Lkotlin/reflect/KClass;", "clazz", "Lsdk/pendo/io/q5/a;", "qualifier", "scopeQualifier", "(Lkotlin/reflect/KClass;Lsdk/pendo/io/q5/a;Lsdk/pendo/io/q5/a;)Lsdk/pendo/io/m5/b;", ExifInterface.GPS_DIRECTION_TRUE, "Lsdk/pendo/io/m5/a;", "instanceContext", "(Lsdk/pendo/io/q5/a;Lkotlin/reflect/KClass;Lsdk/pendo/io/q5/a;Lsdk/pendo/io/m5/a;)Ljava/lang/Object;", "", "b", "Lsdk/pendo/io/h5/a;", "Lsdk/pendo/io/h5/a;", "get_koin", "()Lsdk/pendo/io/h5/a;", "_koin", "", "Ljava/util/Map;", "_instances", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "c", "Ljava/util/HashMap;", "<init>", "(Lsdk/pendo/io/h5/a;)V", "koin-core"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final sdk.pendo.io.h5.a _koin;

    /* renamed from: b, reason: from kotlin metadata */
    private final Map<String, sdk.pendo.io.m5.b<?>> _instances;

    /* renamed from: c, reason: from kotlin metadata */
    private final HashMap<Integer, sdk.pendo.io.m5.c<?>> eagerInstances;

    public a(sdk.pendo.io.h5.a _koin) {
        Intrinsics.checkNotNullParameter(_koin, "_koin");
        this._koin = _koin;
        this._instances = sdk.pendo.io.v5.b.f1684a.c();
        this.eagerInstances = new HashMap<>();
    }

    private final void a(sdk.pendo.io.o5.a module) {
        for (sdk.pendo.io.m5.c<?> cVar : module.a()) {
            this.eagerInstances.put(Integer.valueOf(cVar.hashCode()), cVar);
        }
    }

    public final int b() {
        return this._instances.size();
    }

    public final void a() {
        Collection<sdk.pendo.io.m5.c<?>> values = this.eagerInstances.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        a(values);
        this.eagerInstances.clear();
    }

    private final void a(Collection<? extends sdk.pendo.io.m5.c<?>> eagerInstances) {
        if (!eagerInstances.isEmpty()) {
            sdk.pendo.io.m5.a aVar = new sdk.pendo.io.m5.a(this._koin.getIo.sentry.SentryEvent.JsonKeys.LOGGER java.lang.String(), this._koin.getScopeRegistry().getRootScope(), null, 4, null);
            Iterator<T> it = eagerInstances.iterator();
            while (it.hasNext()) {
                ((sdk.pendo.io.m5.c) it.next()).b(aVar);
            }
        }
    }

    private final void a(sdk.pendo.io.o5.a module, boolean allowOverride) {
        for (Map.Entry<String, sdk.pendo.io.m5.b<?>> entry : module.c().entrySet()) {
            a(this, allowOverride, entry.getKey(), entry.getValue(), false, 8, null);
        }
    }

    public final void a(Set<sdk.pendo.io.o5.a> modules, boolean allowOverride) {
        Intrinsics.checkNotNullParameter(modules, "modules");
        for (sdk.pendo.io.o5.a aVar : modules) {
            a(aVar, allowOverride);
            a(aVar);
        }
    }

    public final sdk.pendo.io.m5.b<?> a(KClass<?> clazz, sdk.pendo.io.q5.a qualifier, sdk.pendo.io.q5.a scopeQualifier) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        return this._instances.get(sdk.pendo.io.j5.b.a(clazz, qualifier, scopeQualifier));
    }

    public final <T> T a(sdk.pendo.io.q5.a qualifier, KClass<?> clazz, sdk.pendo.io.q5.a scopeQualifier, sdk.pendo.io.m5.a instanceContext) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Intrinsics.checkNotNullParameter(instanceContext, "instanceContext");
        sdk.pendo.io.m5.b<?> a2 = a(clazz, qualifier, scopeQualifier);
        Object b = a2 != null ? a2.b(instanceContext) : null;
        if (b == null) {
            return null;
        }
        return (T) b;
    }

    public final void a(boolean allowOverride, String mapping, sdk.pendo.io.m5.b<?> factory, boolean logWarning) {
        Intrinsics.checkNotNullParameter(mapping, "mapping");
        Intrinsics.checkNotNullParameter(factory, "factory");
        if (this._instances.containsKey(mapping)) {
            if (!allowOverride) {
                sdk.pendo.io.o5.b.a(factory, mapping);
            } else if (logWarning) {
                this._koin.getIo.sentry.SentryEvent.JsonKeys.LOGGER java.lang.String().c("(+) override index '" + mapping + "' -> '" + factory.a() + '\'');
            }
        }
        this._koin.getIo.sentry.SentryEvent.JsonKeys.LOGGER java.lang.String().a("(+) index '" + mapping + "' -> '" + factory.a() + '\'');
        this._instances.put(mapping, factory);
    }

    public static /* synthetic */ void a(a aVar, boolean z, String str, sdk.pendo.io.m5.b bVar, boolean z2, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = true;
        }
        aVar.a(z, str, (sdk.pendo.io.m5.b<?>) bVar, z2);
    }
}
