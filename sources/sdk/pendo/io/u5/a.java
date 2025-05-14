package sdk.pendo.io.u5;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import sdk.pendo.io.v5.b;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\u001a\u000e\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000\u001a\u000e\u0010\u0003\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000\"$\u0010\u0006\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0000\u0012\u0004\u0012\u00020\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0005¨\u0006\u0007"}, d2 = {"Lkotlin/reflect/KClass;", "", "a", "b", "", "Ljava/util/Map;", "classNames", "koin-core"}, k = 2, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<KClass<?>, String> f1642a = b.f1684a.c();

    public static final String a(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        String str = f1642a.get(kClass);
        return str == null ? b(kClass) : str;
    }

    public static final String b(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        String a2 = b.f1684a.a(kClass);
        f1642a.put(kClass, a2);
        return a2;
    }
}
