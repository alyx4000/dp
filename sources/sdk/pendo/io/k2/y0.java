package sdk.pendo.io.k2;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0001¢\u0006\u0004\b+\u0010,J\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0097\u0001J\u0011\u0010\b\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0097\u0001J\u0011\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0097\u0001J\u0011\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0097\u0001J\u0011\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0003H\u0097\u0001J\u0013\u0010\u0010\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u0011\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u001a\u0010\u0016\u001a\u00020\u00018\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u000b\u0010\u0018R \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u001a8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\r\u0010\u001cR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u00058VX\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\u00038\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\b\u0010!R\u0014\u0010#\u001a\u00020\f8VX\u0097\u0005¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010$R\u0014\u0010*\u001a\u00020'8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lsdk/pendo/io/k2/y0;", "Lsdk/pendo/io/i2/f;", "Lsdk/pendo/io/k2/l;", "", "index", "", "", "b", "c", "", "name", "a", "", "d", "", "other", "equals", "toString", "hashCode", "Lsdk/pendo/io/i2/f;", "getOriginal$kotlinx_serialization_core", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "original", "Ljava/lang/String;", "()Ljava/lang/String;", "serialName", "", "Ljava/util/Set;", "()Ljava/util/Set;", "serialNames", "getAnnotations", "()Ljava/util/List;", "annotations", "()I", "elementsCount", "isInline", "()Z", "e", "isNullable", "Lsdk/pendo/io/i2/j;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "kind", "<init>", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class y0 implements sdk.pendo.io.i2.f, l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final sdk.pendo.io.i2.f original;

    /* renamed from: b, reason: from kotlin metadata */
    private final String serialName;

    /* renamed from: c, reason: from kotlin metadata */
    private final Set<String> serialNames;

    public y0(sdk.pendo.io.i2.f original) {
        Intrinsics.checkNotNullParameter(original, "original");
        this.original = original;
        this.serialName = Intrinsics.stringPlus(original.getSerialName(), "?");
        this.serialNames = o0.a(original);
    }

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
    public sdk.pendo.io.i2.f c(int index) {
        return this.original.c(index);
    }

    @Override // sdk.pendo.io.k2.l
    public Set<String> d() {
        return this.serialNames;
    }

    @Override // sdk.pendo.io.i2.f
    public boolean e() {
        return true;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof y0) && Intrinsics.areEqual(this.original, ((y0) other).original);
    }

    /* renamed from: f, reason: from getter */
    public final sdk.pendo.io.i2.f getOriginal() {
        return this.original;
    }

    @Override // sdk.pendo.io.i2.f
    public List<Annotation> getAnnotations() {
        return this.original.getAnnotations();
    }

    public int hashCode() {
        return this.original.hashCode() * 31;
    }

    @Override // sdk.pendo.io.i2.f
    public boolean isInline() {
        return this.original.isInline();
    }

    public String toString() {
        return new StringBuilder().append(this.original).append('?').toString();
    }

    @Override // sdk.pendo.io.i2.f
    public String a(int index) {
        return this.original.a(index);
    }

    @Override // sdk.pendo.io.i2.f
    /* renamed from: b */
    public sdk.pendo.io.i2.j getKind() {
        return this.original.getKind();
    }

    @Override // sdk.pendo.io.i2.f
    /* renamed from: c */
    public int getElementsCount() {
        return this.original.getElementsCount();
    }

    @Override // sdk.pendo.io.i2.f
    public boolean d(int index) {
        return this.original.d(index);
    }

    @Override // sdk.pendo.io.i2.f
    /* renamed from: a, reason: from getter */
    public String getSerialName() {
        return this.serialName;
    }
}
