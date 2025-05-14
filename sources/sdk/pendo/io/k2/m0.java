package sdk.pendo.io.k2;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0003B\u0015\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0019\u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u00168\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lsdk/pendo/io/k2/m0;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lsdk/pendo/io/g2/b;", "other", "", "equals", "", "hashCode", "Lsdk/pendo/io/j2/d;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "Lsdk/pendo/io/j2/e;", "encoder", "value", "", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "a", "Lsdk/pendo/io/g2/b;", "serializer", "Lsdk/pendo/io/i2/f;", "b", "Lsdk/pendo/io/i2/f;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "<init>", "(Lkotlinx/serialization/KSerializer;)V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class m0<T> implements sdk.pendo.io.g2.b<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final sdk.pendo.io.g2.b<T> serializer;

    /* renamed from: b, reason: from kotlin metadata */
    private final sdk.pendo.io.i2.f descriptor;

    public m0(sdk.pendo.io.g2.b<T> serializer) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        this.serializer = serializer;
        this.descriptor = new y0(serializer.getDescriptor());
    }

    @Override // sdk.pendo.io.g2.a
    public T deserialize(sdk.pendo.io.j2.d decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return decoder.c() ? (T) decoder.a(this.serializer) : (T) decoder.k();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return other != null && Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(m0.class), Reflection.getOrCreateKotlinClass(other.getClass())) && Intrinsics.areEqual(this.serializer, ((m0) other).serializer);
    }

    @Override // sdk.pendo.io.g2.b, sdk.pendo.io.g2.a
    public sdk.pendo.io.i2.f getDescriptor() {
        return this.descriptor;
    }

    public int hashCode() {
        return this.serializer.hashCode();
    }
}
