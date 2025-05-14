package sdk.pendo.io.i2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import sdk.pendo.io.k2.y0;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\"$\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004*\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lsdk/pendo/io/n2/c;", "Lsdk/pendo/io/i2/f;", "descriptor", "a", "Lkotlin/reflect/KClass;", "getCapturedKClass", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlin/reflect/KClass;", "getCapturedKClass$annotations", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "capturedKClass", "kotlinx-serialization-core"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class b {
    public static final KClass<?> a(f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "<this>");
        if (fVar instanceof c) {
            return ((c) fVar).kClass;
        }
        if (fVar instanceof y0) {
            return a(((y0) fVar).getOriginal());
        }
        return null;
    }

    public static final f a(sdk.pendo.io.n2.c cVar, f descriptor) {
        sdk.pendo.io.g2.b a2;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        KClass<?> a3 = a(descriptor);
        if (a3 == null || (a2 = sdk.pendo.io.n2.c.a(cVar, a3, null, 2, null)) == null) {
            return null;
        }
        return a2.getDescriptor();
    }
}
