package sdk.pendo.io.k2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\u001a\u001e\u0010\u0005\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0001¨\u0006\u0006"}, d2 = {"", "subClassName", "Lkotlin/reflect/KClass;", "baseClass", "", "a", "kotlinx-serialization-core"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class c {
    public static final Void a(String str, KClass<?> baseClass) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        String str2 = "in the scope of '" + ((Object) baseClass.getSimpleName()) + '\'';
        throw new sdk.pendo.io.g2.f(str == null ? Intrinsics.stringPlus("Class discriminator was missing and no default polymorphic serializers were registered ", str2) : "Class '" + ((Object) str) + "' is not registered for polymorphic serialization " + str2 + ".\nMark the base class as 'sealed' or register the serializer explicitly.");
    }
}
