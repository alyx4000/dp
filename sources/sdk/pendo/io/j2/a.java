package sdk.pendo.io.j2;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.callercontext.ContextChain;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.i2.f;
import sdk.pendo.io.j2.b;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b'\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b)\u0010*J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0016\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\fJ\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\fJ\u0016\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\fJ\u0016\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\fJ\u0016\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\fJ\u0016\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\fJ\u0016\u0010\u0004\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\fJ\u0016\u0010\u000f\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\fJC\u0010$\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010 *\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\f2\u000e\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000!2\b\u0010#\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b$\u0010%J;\u0010&\u001a\u00028\u0000\"\u0004\b\u0000\u0010 2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000!2\b\u0010#\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b&\u0010%J/\u0010'\u001a\u00028\u0000\"\u0004\b\u0000\u0010 2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000!2\n\b\u0002\u0010#\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lsdk/pendo/io/j2/a;", "Lsdk/pendo/io/j2/d;", "Lsdk/pendo/io/j2/b;", "", "c", "", "k", "b", "", "j", "", "l", "", "h", "", "a", "", "n", "", "o", "", "d", "", "m", "Lsdk/pendo/io/i2/f;", "descriptor", "index", "f", "e", ContextChain.TAG_INFRA, "g", "", ExifInterface.GPS_DIRECTION_TRUE, "Lsdk/pendo/io/g2/a;", "deserializer", "previousValue", "decodeNullableSerializableElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeSerializableElement", "decodeSerializableValue", "(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "<init>", "()V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public abstract class a implements d, b {
    @Override // sdk.pendo.io.j2.d
    public abstract long a();

    @Override // sdk.pendo.io.j2.d
    public abstract <T> T a(sdk.pendo.io.g2.a<T> aVar);

    @Override // sdk.pendo.io.j2.b
    public final <T> T a(f descriptor, int i, sdk.pendo.io.g2.a<T> deserializer, T t) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        return (deserializer.getDescriptor().e() || c()) ? (T) a((sdk.pendo.io.g2.a<sdk.pendo.io.g2.a<T>>) deserializer, (sdk.pendo.io.g2.a<T>) t) : (T) k();
    }

    @Override // sdk.pendo.io.j2.b
    public final byte b(f descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return j();
    }

    @Override // sdk.pendo.io.j2.d
    public abstract boolean b();

    @Override // sdk.pendo.io.j2.b
    public final char c(f descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return d();
    }

    @Override // sdk.pendo.io.j2.d
    public abstract boolean c();

    @Override // sdk.pendo.io.j2.d
    public abstract char d();

    @Override // sdk.pendo.io.j2.b
    public int d(f fVar) {
        return b.a.a(this, fVar);
    }

    @Override // sdk.pendo.io.j2.b
    public final long e(f descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return a();
    }

    @Override // sdk.pendo.io.j2.b
    public final boolean f(f descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return b();
    }

    @Override // sdk.pendo.io.j2.b
    public final double g(f descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return o();
    }

    @Override // sdk.pendo.io.j2.d
    public abstract int h();

    @Override // sdk.pendo.io.j2.b
    public final int h(f descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return h();
    }

    @Override // sdk.pendo.io.j2.b
    public final float i(f descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return n();
    }

    @Override // sdk.pendo.io.j2.d
    public abstract byte j();

    @Override // sdk.pendo.io.j2.d
    public abstract Void k();

    @Override // sdk.pendo.io.j2.d
    public abstract short l();

    @Override // sdk.pendo.io.j2.d
    public abstract String m();

    @Override // sdk.pendo.io.j2.d
    public abstract float n();

    @Override // sdk.pendo.io.j2.d
    public abstract double o();

    public <T> T a(sdk.pendo.io.g2.a<T> deserializer, T t) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        return (T) a(deserializer);
    }

    @Override // sdk.pendo.io.j2.b
    public final <T> T b(f descriptor, int i, sdk.pendo.io.g2.a<T> deserializer, T t) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        return (T) a((sdk.pendo.io.g2.a<sdk.pendo.io.g2.a<T>>) deserializer, (sdk.pendo.io.g2.a<T>) t);
    }

    @Override // sdk.pendo.io.j2.b
    public final short d(f descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return l();
    }

    @Override // sdk.pendo.io.j2.b
    public boolean e() {
        return b.a.a(this);
    }

    @Override // sdk.pendo.io.j2.b
    public final String a(f descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return m();
    }
}
