package sdk.pendo.io.k2;

import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import sdk.pendo.io.i2.j;
import sdk.pendo.io.i2.k;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\n\u0012\u0006\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016R\u001a\u0010\u0012\u001a\u00020\r8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"Lsdk/pendo/io/k2/t;", "Lsdk/pendo/io/k2/q0;", "", "index", "Lsdk/pendo/io/i2/f;", "c", "", "other", "", "equals", "", "toString", "hashCode", "Lsdk/pendo/io/i2/j;", "m", "Lsdk/pendo/io/i2/j;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "kind", "", "n", "Lkotlin/Lazy;", "getElementDescriptors", "()[Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementDescriptors", "name", "elementsCount", "<init>", "(Ljava/lang/String;I)V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class t extends q0 {

    /* renamed from: m, reason: from kotlin metadata */
    private final sdk.pendo.io.i2.j kind;

    /* renamed from: n, reason: from kotlin metadata */
    private final Lazy elementDescriptors;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lsdk/pendo/io/i2/f;", "invoke", "()[Lkotlinx/serialization/descriptors/SerialDescriptor;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    static final class a extends Lambda implements Function0<sdk.pendo.io.i2.f[]> {
        final /* synthetic */ t A;
        final /* synthetic */ int f;
        final /* synthetic */ String s;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i, String str, t tVar) {
            super(0);
            this.f = i;
            this.s = str;
            this.A = tVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final sdk.pendo.io.i2.f[] invoke() {
            int i = this.f;
            sdk.pendo.io.i2.f[] fVarArr = new sdk.pendo.io.i2.f[i];
            for (int i2 = 0; i2 < i; i2++) {
                fVarArr[i2] = sdk.pendo.io.i2.i.a(this.s + '.' + this.A.a(i2), k.d.f1200a, new sdk.pendo.io.i2.f[0], null, 8, null);
            }
            return fVarArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(String name, int i) {
        super(name, null, i, 2, null);
        Intrinsics.checkNotNullParameter(name, "name");
        this.kind = j.b.f1196a;
        this.elementDescriptors = LazyKt.lazy(new a(i, name, this));
    }

    private final sdk.pendo.io.i2.f[] j() {
        return (sdk.pendo.io.i2.f[]) this.elementDescriptors.getValue();
    }

    @Override // sdk.pendo.io.k2.q0, sdk.pendo.io.i2.f
    /* renamed from: b, reason: from getter */
    public sdk.pendo.io.i2.j getKind() {
        return this.kind;
    }

    @Override // sdk.pendo.io.k2.q0, sdk.pendo.io.i2.f
    public sdk.pendo.io.i2.f c(int index) {
        return j()[index];
    }

    @Override // sdk.pendo.io.k2.q0
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof sdk.pendo.io.i2.f)) {
            return false;
        }
        sdk.pendo.io.i2.f fVar = (sdk.pendo.io.i2.f) other;
        return fVar.getKind() == j.b.f1196a && Intrinsics.areEqual(getSerialName(), fVar.getSerialName()) && Intrinsics.areEqual(o0.a(this), o0.a(fVar));
    }

    @Override // sdk.pendo.io.k2.q0
    public int hashCode() {
        int hashCode = getSerialName().hashCode();
        Iterator<String> it = sdk.pendo.io.i2.h.b(this).iterator();
        int i = 1;
        while (it.hasNext()) {
            int i2 = i * 31;
            String next = it.next();
            i = i2 + (next == null ? 0 : next.hashCode());
        }
        return (hashCode * 31) + i;
    }

    @Override // sdk.pendo.io.k2.q0
    public String toString() {
        return CollectionsKt.joinToString$default(sdk.pendo.io.i2.h.b(this), ", ", Intrinsics.stringPlus(getSerialName(), "("), ")", 0, null, null, 56, null);
    }
}
