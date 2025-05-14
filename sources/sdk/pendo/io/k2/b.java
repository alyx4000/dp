package sdk.pendo.io.k2;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.KClass;
import sdk.pendo.io.j2.b;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\t\b\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ$\u0010\t\u001a\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0017J\u0017\u0010\u000b\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00028\u0000H\u0017¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00028\u0000¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00198&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u001a¨\u0006\u001e"}, d2 = {"Lsdk/pendo/io/k2/b;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lsdk/pendo/io/g2/b;", "Lsdk/pendo/io/j2/b;", "decoder", "", "klassName", "Lsdk/pendo/io/g2/a;", "a", "compositeDecoder", "decodeSequentially", "(Lkotlinx/serialization/encoding/CompositeDecoder;)Ljava/lang/Object;", "Lsdk/pendo/io/j2/d;", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "Lsdk/pendo/io/j2/e;", "encoder", "value", "Lsdk/pendo/io/g2/g;", "findPolymorphicSerializerOrNull", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "Lkotlin/reflect/KClass;", "()Lkotlin/reflect/KClass;", "baseClass", "<init>", "()V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public abstract class b<T> implements sdk.pendo.io.g2.b<T> {
    private final T a(sdk.pendo.io.j2.b bVar) {
        return (T) b.a.a(bVar, getDescriptor(), 1, sdk.pendo.io.g2.d.a(this, bVar, bVar.a(getDescriptor(), 0)), null, 8, null);
    }

    public abstract KClass<T> a();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // sdk.pendo.io.g2.a
    public final T deserialize(sdk.pendo.io.j2.d decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        sdk.pendo.io.i2.f descriptor = getDescriptor();
        sdk.pendo.io.j2.b a2 = decoder.a(descriptor);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (a2.e()) {
            T a3 = a(a2);
            a2.c(descriptor);
            return a3;
        }
        T t = null;
        while (true) {
            int e = a2.e(getDescriptor());
            if (e == -1) {
                if (t == null) {
                    throw new IllegalArgumentException(Intrinsics.stringPlus("Polymorphic value has not been read for class ", objectRef.element).toString());
                }
                a2.c(descriptor);
                return t;
            }
            if (e == 0) {
                objectRef.element = (T) a2.a(getDescriptor(), e);
            } else {
                if (e != 1) {
                    StringBuilder sb = new StringBuilder("Invalid index in polymorphic deserialization of ");
                    String str = (String) objectRef.element;
                    if (str == null) {
                        str = "unknown class";
                    }
                    throw new sdk.pendo.io.g2.f(sb.append(str).append("\n Expected 0, 1 or DECODE_DONE(-1), but found ").append(e).toString());
                }
                T t2 = objectRef.element;
                if (t2 == 0) {
                    throw new IllegalArgumentException("Cannot read polymorphic value before its type token".toString());
                }
                objectRef.element = t2;
                t = (T) b.a.a(a2, getDescriptor(), e, sdk.pendo.io.g2.d.a(this, a2, (String) t2), null, 8, null);
            }
        }
    }

    public sdk.pendo.io.g2.a<? extends T> a(sdk.pendo.io.j2.b decoder, String klassName) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return decoder.getSerializersModule().a(a(), klassName);
    }
}
