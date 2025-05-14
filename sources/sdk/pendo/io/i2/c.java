package sdk.pendo.io.i2;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0013\u001a\u00020\u0001\u0012\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0014¢\u0006\u0004\b'\u0010(J\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0097\u0001J\u0011\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0097\u0001J\u0011\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0097\u0001J\u0011\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0097\u0001J\u0011\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0097\u0001J\u0013\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016R\u0014\u0010\u0013\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0012R\u0018\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00148\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\n\u0010\u0018R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048VX\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00028\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u000b8VX\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020\u000b8VX\u0097\u0005¢\u0006\u0006\u001a\u0004\b!\u0010 R\u0014\u0010&\u001a\u00020#8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lsdk/pendo/io/i2/c;", "Lsdk/pendo/io/i2/f;", "", "index", "", "", "b", "c", "", "name", "a", "", "d", "", "other", "equals", "hashCode", "toString", "Lsdk/pendo/io/i2/f;", "original", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/KClass;", "kClass", "Ljava/lang/String;", "()Ljava/lang/String;", "serialName", "getAnnotations", "()Ljava/util/List;", "annotations", "()I", "elementsCount", "isInline", "()Z", "e", "isNullable", "Lsdk/pendo/io/i2/j;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "kind", "<init>", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/reflect/KClass;)V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
final class c implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final f original;

    /* renamed from: b, reason: from kotlin metadata */
    public final KClass<?> kClass;

    /* renamed from: c, reason: from kotlin metadata */
    private final String serialName;

    @Override // sdk.pendo.io.i2.f
    public int a(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.original.a(name);
    }

    @Override // sdk.pendo.io.i2.f
    public List<Annotation> b(int index) {
        return this.original.b(index);
    }

    @Override // sdk.pendo.io.i2.f
    public f c(int index) {
        return this.original.c(index);
    }

    @Override // sdk.pendo.io.i2.f
    public boolean d(int index) {
        return this.original.d(index);
    }

    @Override // sdk.pendo.io.i2.f
    public boolean e() {
        return this.original.e();
    }

    public boolean equals(Object other) {
        c cVar = other instanceof c ? (c) other : null;
        return cVar != null && Intrinsics.areEqual(this.original, cVar.original) && Intrinsics.areEqual(cVar.kClass, this.kClass);
    }

    @Override // sdk.pendo.io.i2.f
    public List<Annotation> getAnnotations() {
        return this.original.getAnnotations();
    }

    public int hashCode() {
        return (this.kClass.hashCode() * 31) + getSerialName().hashCode();
    }

    @Override // sdk.pendo.io.i2.f
    public boolean isInline() {
        return this.original.isInline();
    }

    public String toString() {
        return "ContextDescriptor(kClass: " + this.kClass + ", original: " + this.original + ')';
    }

    @Override // sdk.pendo.io.i2.f
    public String a(int index) {
        return this.original.a(index);
    }

    @Override // sdk.pendo.io.i2.f
    /* renamed from: b */
    public j getKind() {
        return this.original.getKind();
    }

    @Override // sdk.pendo.io.i2.f
    /* renamed from: c */
    public int getElementsCount() {
        return this.original.getElementsCount();
    }

    @Override // sdk.pendo.io.i2.f
    /* renamed from: a, reason: from getter */
    public String getSerialName() {
        return this.serialName;
    }
}
