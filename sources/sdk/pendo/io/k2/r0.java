package sdk.pendo.io.k2;

import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001aP\u0010\n\u001a\u00020\b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00028\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0080\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a!\u0010\u000f\u001a\u00020\u000e*\u00020\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00000\fH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0011"}, d2 = {"Lsdk/pendo/io/i2/f;", "SD", "", "other", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "otherDescriptor", "", "typeParamsAreEqual", "equalsImpl", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Z", "", "typeParams", "", "hashCodeImpl", "(Lkotlinx/serialization/descriptors/SerialDescriptor;[Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "kotlinx-serialization-core"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class r0 {
    public static final int a(sdk.pendo.io.i2.f fVar, sdk.pendo.io.i2.f[] typeParams) {
        Intrinsics.checkNotNullParameter(fVar, "<this>");
        Intrinsics.checkNotNullParameter(typeParams, "typeParams");
        int hashCode = (fVar.getSerialName().hashCode() * 31) + Arrays.hashCode(typeParams);
        Iterable<sdk.pendo.io.i2.f> a2 = sdk.pendo.io.i2.h.a(fVar);
        Iterator<sdk.pendo.io.i2.f> it = a2.iterator();
        int i = 1;
        int i2 = 1;
        while (true) {
            int i3 = 0;
            if (!it.hasNext()) {
                break;
            }
            int i4 = i2 * 31;
            String serialName = it.next().getSerialName();
            if (serialName != null) {
                i3 = serialName.hashCode();
            }
            i2 = i4 + i3;
        }
        Iterator<sdk.pendo.io.i2.f> it2 = a2.iterator();
        while (it2.hasNext()) {
            int i5 = i * 31;
            sdk.pendo.io.i2.j kind = it2.next().getKind();
            i = i5 + (kind == null ? 0 : kind.hashCode());
        }
        return (((hashCode * 31) + i2) * 31) + i;
    }
}
