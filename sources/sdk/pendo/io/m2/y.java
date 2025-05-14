package sdk.pendo.io.m2;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.i2.j;
import sdk.pendo.io.i2.k;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001aU\u0010\u000e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00028\u0000\"\b\b\u0002\u0010\t*\u00028\u0000*\u00020\u00002\u0006\u0010\n\u001a\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00020\u000bH\u0080\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, d2 = {"Lsdk/pendo/io/l2/a;", "Lsdk/pendo/io/i2/f;", "desc", "Lsdk/pendo/io/m2/x;", "a", "Lsdk/pendo/io/n2/c;", "module", ExifInterface.GPS_DIRECTION_TRUE, "R1", "R2", "mapDescriptor", "Lkotlin/Function0;", "ifMap", "ifList", "selectMapMode", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlinx-serialization-json"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class y {
    public static final sdk.pendo.io.i2.f a(sdk.pendo.io.i2.f fVar, sdk.pendo.io.n2.c module) {
        sdk.pendo.io.i2.f a2;
        Intrinsics.checkNotNullParameter(fVar, "<this>");
        Intrinsics.checkNotNullParameter(module, "module");
        if (!Intrinsics.areEqual(fVar.getKind(), j.a.f1195a)) {
            return fVar.isInline() ? a(fVar.c(0), module) : fVar;
        }
        sdk.pendo.io.i2.f a3 = sdk.pendo.io.i2.b.a(module, fVar);
        return (a3 == null || (a2 = a(a3, module)) == null) ? fVar : a2;
    }

    public static final x a(sdk.pendo.io.l2.a aVar, sdk.pendo.io.i2.f desc) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(desc, "desc");
        sdk.pendo.io.i2.j kind = desc.getKind();
        if (kind instanceof sdk.pendo.io.i2.d) {
            return x.POLY_OBJ;
        }
        if (!Intrinsics.areEqual(kind, k.b.f1198a)) {
            if (!Intrinsics.areEqual(kind, k.c.f1199a)) {
                return x.OBJ;
            }
            sdk.pendo.io.i2.f a2 = a(desc.c(0), aVar.getSerializersModule());
            sdk.pendo.io.i2.j kind2 = a2.getKind();
            if ((kind2 instanceof sdk.pendo.io.i2.e) || Intrinsics.areEqual(kind2, j.b.f1196a)) {
                return x.MAP;
            }
            if (!aVar.getConfiguration().getAllowStructuredMapKeys()) {
                throw k.a(a2);
            }
        }
        return x.LIST;
    }
}
