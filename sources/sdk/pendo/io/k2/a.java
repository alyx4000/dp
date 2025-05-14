package sdk.pendo.io.k2;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u00028\u00010\u0004B\t\b\u0004¢\u0006\u0004\b'\u0010(J\u000f\u0010\u0005\u001a\u00028\u0002H$¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0005\u001a\u00020\u0007*\u00028\u0002H$¢\u0006\u0004\b\u0005\u0010\bJ\u0013\u0010\t\u001a\u00028\u0001*\u00028\u0002H$¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u000b\u001a\u00028\u0002*\u00028\u0001H$¢\u0006\u0004\b\u000b\u0010\nJ\u001b\u0010\u0005\u001a\u00020\r*\u00028\u00022\u0006\u0010\f\u001a\u00020\u0007H$¢\u0006\u0004\b\u0005\u0010\u000eJ\u0017\u0010\u0011\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0014\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00018\u0001H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00028\u00022\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H$¢\u0006\u0004\b\u0019\u0010\u001aJ1\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00028\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u001cH$¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010 \u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00028\u0002H\u0002¢\u0006\u0004\b \u0010!J\u001f\u0010%\u001a\u00020\r2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00028\u0001H&¢\u0006\u0004\b%\u0010&\u0082\u0001\u0002)*¨\u0006+"}, d2 = {"Lsdk/pendo/io/k2/a;", "Element", "Collection", "Builder", "Lsdk/pendo/io/g2/b;", "a", "()Ljava/lang/Object;", "", "(Ljava/lang/Object;)I", "c", "(Ljava/lang/Object;)Ljava/lang/Object;", "b", "size", "", "(Ljava/lang/Object;I)V", "Lsdk/pendo/io/j2/d;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "previous", "merge", "(Lkotlinx/serialization/encoding/Decoder;Ljava/lang/Object;)Ljava/lang/Object;", "Lsdk/pendo/io/j2/b;", "builder", "startIndex", "readAll", "(Lkotlinx/serialization/encoding/CompositeDecoder;Ljava/lang/Object;II)V", "index", "", "checkIndex", "readElement", "(Lkotlinx/serialization/encoding/CompositeDecoder;ILjava/lang/Object;Z)V", "readSize", "(Lkotlinx/serialization/encoding/CompositeDecoder;Ljava/lang/Object;)I", "Lsdk/pendo/io/j2/e;", "encoder", "value", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "<init>", "()V", "Lsdk/pendo/io/k2/f0;", "Lsdk/pendo/io/k2/k0;", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public abstract class a<Element, Collection, Builder> implements sdk.pendo.io.g2.b<Collection> {
    private a() {
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    protected abstract int a(Builder builder);

    protected abstract Builder a();

    /* JADX WARN: Multi-variable type inference failed */
    public final Collection a(sdk.pendo.io.j2.d decoder, Collection collection) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Object b = collection == null ? null : b(collection);
        if (b == null) {
            b = a();
        }
        int a2 = a(b);
        sdk.pendo.io.j2.b a3 = decoder.a(getDescriptor());
        if (a3.e()) {
            a(a3, (sdk.pendo.io.j2.b) b, a2, a(a3, (sdk.pendo.io.j2.b) b));
        } else {
            while (true) {
                int e = a3.e(getDescriptor());
                if (e == -1) {
                    break;
                }
                a(this, a3, a2 + e, b, false, 8, null);
            }
        }
        a3.c(getDescriptor());
        return (Collection) c(b);
    }

    protected abstract void a(Builder builder, int i);

    protected abstract void a(sdk.pendo.io.j2.b bVar, int i, Builder builder, boolean z);

    protected abstract void a(sdk.pendo.io.j2.b bVar, Builder builder, int i, int i2);

    protected abstract Builder b(Collection collection);

    protected abstract Collection c(Builder builder);

    @Override // sdk.pendo.io.g2.a
    public Collection deserialize(sdk.pendo.io.j2.d decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return a(decoder, (sdk.pendo.io.j2.d) null);
    }

    public static /* synthetic */ void a(a aVar, sdk.pendo.io.j2.b bVar, int i, Object obj, boolean z, int i2, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readElement");
        }
        if ((i2 & 8) != 0) {
            z = true;
        }
        aVar.a(bVar, i, (int) obj, z);
    }

    private final int a(sdk.pendo.io.j2.b bVar, Builder builder) {
        int d = bVar.d(getDescriptor());
        a((a<Element, Collection, Builder>) builder, d);
        return d;
    }
}
