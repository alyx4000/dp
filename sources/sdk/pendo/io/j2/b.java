package sdk.pendo.io.j2;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.callercontext.ContextChain;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.i2.f;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0002\u0010\n\n\u0000\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H\u0017J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\bH&J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\bH&J\u0018\u0010\u0005\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\bH&J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\bH&J\u0018\u0010\u0007\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\bH&J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\bH&J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\bH&J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\bH&JG\u0010\u001c\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0018*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\b2\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00018\u0000H'¢\u0006\u0004\b\u001c\u0010\u001dJ?\u0010\u001e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0004\b\u001e\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lsdk/pendo/io/j2/b;", "", "Lsdk/pendo/io/i2/f;", "descriptor", "", "c", "", "e", "", "d", "index", "f", "", "b", "", "", "h", "", "", ContextChain.TAG_INFRA, "", "g", "", "a", ExifInterface.GPS_DIRECTION_TRUE, "Lsdk/pendo/io/g2/a;", "deserializer", "previousValue", "decodeNullableSerializableElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeSerializableElement", "Lsdk/pendo/io/n2/c;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public interface b {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public static int a(b bVar, f descriptor) {
            Intrinsics.checkNotNullParameter(bVar, "this");
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            return -1;
        }

        public static boolean a(b bVar) {
            Intrinsics.checkNotNullParameter(bVar, "this");
            return false;
        }

        public static /* synthetic */ Object a(b bVar, f fVar, int i, sdk.pendo.io.g2.a aVar, Object obj, int i2, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeSerializableElement");
            }
            if ((i2 & 8) != 0) {
                obj = null;
            }
            return bVar.b(fVar, i, aVar, obj);
        }
    }

    <T> T a(f fVar, int i, sdk.pendo.io.g2.a<T> aVar, T t);

    String a(f descriptor, int index);

    byte b(f descriptor, int index);

    <T> T b(f fVar, int i, sdk.pendo.io.g2.a<T> aVar, T t);

    char c(f descriptor, int index);

    void c(f descriptor);

    int d(f descriptor);

    short d(f descriptor, int index);

    int e(f descriptor);

    long e(f descriptor, int index);

    boolean e();

    boolean f(f descriptor, int index);

    double g(f descriptor, int index);

    int h(f descriptor, int index);

    float i(f descriptor, int index);

    sdk.pendo.io.n2.c i();
}
