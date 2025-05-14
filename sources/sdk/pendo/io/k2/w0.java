package sdk.pendo.io.k2;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.i2.f;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0012¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016R\u001a\u0010\u0011\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u000f\u001a\u0004\b\u0007\u0010\u0010R\u001a\u0010\u0016\u001a\u00020\u00128\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0017¨\u0006\u001b"}, d2 = {"Lsdk/pendo/io/k2/w0;", "Lsdk/pendo/io/i2/f;", "", "d", "", "index", "", "a", "name", "", "c", "", "", "b", "toString", "Ljava/lang/String;", "()Ljava/lang/String;", "serialName", "Lsdk/pendo/io/i2/e;", "Lsdk/pendo/io/i2/e;", "getKind", "()Lkotlinx/serialization/descriptors/PrimitiveKind;", "kind", "()I", "elementsCount", "<init>", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/PrimitiveKind;)V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class w0 implements sdk.pendo.io.i2.f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String serialName;

    /* renamed from: b, reason: from kotlin metadata */
    private final sdk.pendo.io.i2.e kind;

    public w0(String serialName, sdk.pendo.io.i2.e kind) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(kind, "kind");
        this.serialName = serialName;
        this.kind = kind;
    }

    private final Void d() {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // sdk.pendo.io.i2.f
    public int a(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        d();
        throw new KotlinNothingValueException();
    }

    @Override // sdk.pendo.io.i2.f
    public List<Annotation> b(int index) {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // sdk.pendo.io.i2.f
    /* renamed from: c */
    public int getElementsCount() {
        return 0;
    }

    @Override // sdk.pendo.io.i2.f
    public sdk.pendo.io.i2.f c(int index) {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // sdk.pendo.io.i2.f
    public boolean e() {
        return f.a.c(this);
    }

    @Override // sdk.pendo.io.i2.f
    /* renamed from: f, reason: from getter */
    public sdk.pendo.io.i2.e getKind() {
        return this.kind;
    }

    @Override // sdk.pendo.io.i2.f
    public List<Annotation> getAnnotations() {
        return f.a.a(this);
    }

    @Override // sdk.pendo.io.i2.f
    public boolean isInline() {
        return f.a.b(this);
    }

    public String toString() {
        return "PrimitiveDescriptor(" + getSerialName() + ')';
    }

    @Override // sdk.pendo.io.i2.f
    public String a(int index) {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // sdk.pendo.io.i2.f
    public boolean d(int index) {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // sdk.pendo.io.i2.f
    /* renamed from: a, reason: from getter */
    public String getSerialName() {
        return this.serialName;
    }
}
