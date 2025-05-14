package sdk.pendo.io.k2;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sdk.pendo.io.i2.f;
import sdk.pendo.io.i2.k;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001B\u0011\b\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u000f\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016R\u0017\u0010\u0015\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u00028\u0016X\u0096D¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\f\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u0082\u0001\u0002\u001f ¨\u0006!"}, d2 = {"Lsdk/pendo/io/k2/e0;", "Lsdk/pendo/io/i2/f;", "", "index", "", "a", "name", "", "d", "", "", "b", "c", "", "other", "equals", "hashCode", "toString", "Lsdk/pendo/io/i2/f;", "getElementDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementDescriptor", "I", "()I", "elementsCount", "Lsdk/pendo/io/i2/j;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "kind", "<init>", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "Lsdk/pendo/io/k2/u0;", "Lsdk/pendo/io/k2/d;", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public abstract class e0 implements sdk.pendo.io.i2.f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final sdk.pendo.io.i2.f elementDescriptor;

    /* renamed from: b, reason: from kotlin metadata */
    private final int elementsCount;

    private e0(sdk.pendo.io.i2.f fVar) {
        this.elementDescriptor = fVar;
        this.elementsCount = 1;
    }

    @Override // sdk.pendo.io.i2.f
    public int a(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Integer intOrNull = StringsKt.toIntOrNull(name);
        if (intOrNull != null) {
            return intOrNull.intValue();
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus(name, " is not a valid list index"));
    }

    @Override // sdk.pendo.io.i2.f
    public List<Annotation> b(int index) {
        if (index >= 0) {
            return CollectionsKt.emptyList();
        }
        throw new IllegalArgumentException(("Illegal index " + index + ", " + getSerialName() + " expects only non-negative indices").toString());
    }

    @Override // sdk.pendo.io.i2.f
    public sdk.pendo.io.i2.f c(int index) {
        if (index >= 0) {
            return this.elementDescriptor;
        }
        throw new IllegalArgumentException(("Illegal index " + index + ", " + getSerialName() + " expects only non-negative indices").toString());
    }

    @Override // sdk.pendo.io.i2.f
    public boolean d(int index) {
        if (index >= 0) {
            return false;
        }
        throw new IllegalArgumentException(("Illegal index " + index + ", " + getSerialName() + " expects only non-negative indices").toString());
    }

    @Override // sdk.pendo.io.i2.f
    public boolean e() {
        return f.a.c(this);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) other;
        return Intrinsics.areEqual(this.elementDescriptor, e0Var.elementDescriptor) && Intrinsics.areEqual(getSerialName(), e0Var.getSerialName());
    }

    @Override // sdk.pendo.io.i2.f
    public List<Annotation> getAnnotations() {
        return f.a.a(this);
    }

    public int hashCode() {
        return (this.elementDescriptor.hashCode() * 31) + getSerialName().hashCode();
    }

    @Override // sdk.pendo.io.i2.f
    public boolean isInline() {
        return f.a.b(this);
    }

    public String toString() {
        return getSerialName() + '(' + this.elementDescriptor + ')';
    }

    public /* synthetic */ e0(sdk.pendo.io.i2.f fVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(fVar);
    }

    @Override // sdk.pendo.io.i2.f
    public String a(int index) {
        return String.valueOf(index);
    }

    @Override // sdk.pendo.io.i2.f
    /* renamed from: b */
    public sdk.pendo.io.i2.j getKind() {
        return k.b.f1198a;
    }

    @Override // sdk.pendo.io.i2.f
    /* renamed from: c, reason: from getter */
    public int getElementsCount() {
        return this.elementsCount;
    }
}
