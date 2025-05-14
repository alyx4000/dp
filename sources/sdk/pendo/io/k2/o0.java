package sdk.pendo.io.k2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0011\n\u0002\b\u0007\u001a\u0012\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u0000\u001a!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00000\u0005*\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\" \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00000\u00058\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0003\u0010\b\u0012\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lsdk/pendo/io/i2/f;", "", "", "a", "", "", "compactArray", "(Ljava/util/List;)[Lkotlinx/serialization/descriptors/SerialDescriptor;", "[Lsdk/pendo/io/i2/f;", "getEMPTY_DESCRIPTOR_ARRAY$annotations", "()V", "EMPTY_DESCRIPTOR_ARRAY", "kotlinx-serialization-core"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class o0 {

    /* renamed from: a, reason: collision with root package name */
    private static final sdk.pendo.io.i2.f[] f1272a = new sdk.pendo.io.i2.f[0];

    public static final Set<String> a(sdk.pendo.io.i2.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "<this>");
        if (fVar instanceof l) {
            return ((l) fVar).d();
        }
        HashSet hashSet = new HashSet(fVar.c());
        int c = fVar.c();
        for (int i = 0; i < c; i++) {
            hashSet.add(fVar.a(i));
        }
        return hashSet;
    }

    public static final sdk.pendo.io.i2.f[] a(List<? extends sdk.pendo.io.i2.f> list) {
        sdk.pendo.io.i2.f[] fVarArr = null;
        if (list == null || list.isEmpty()) {
            list = null;
        }
        if (list != null) {
            Object[] array = list.toArray(new sdk.pendo.io.i2.f[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            fVarArr = (sdk.pendo.io.i2.f[]) array;
        }
        return fVarArr == null ? f1272a : fVarArr;
    }
}
