package sdk.pendo.io.o5;

import io.sentry.SentryEvent;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\u001a \u0010\u0006\u001a\u00020\u00052\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u00002\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0001\u001a\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¨\u0006\u000b"}, d2 = {"Lsdk/pendo/io/m5/b;", "factory", "", "Lexternal/sdk/pendo/io/org/koin/core/definition/IndexKey;", "mapping", "", "a", "", "Lsdk/pendo/io/o5/a;", SentryEvent.JsonKeys.MODULES, "", "koin-core"}, k = 2, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class b {
    public static final Set<a> a(List<a> modules) {
        Intrinsics.checkNotNullParameter(modules, "modules");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        a(modules, linkedHashSet);
        return linkedHashSet;
    }

    private static final void a(List<a> list, Set<a> set) {
        for (a aVar : list) {
            set.add(aVar);
            a(aVar.b(), set);
        }
    }

    public static final void a(sdk.pendo.io.m5.b<?> factory, String mapping) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(mapping, "mapping");
        throw new sdk.pendo.io.k5.b("Already existing definition for " + factory.a() + " at " + mapping);
    }
}
