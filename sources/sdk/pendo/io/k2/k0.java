package sdk.pendo.io.k2;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import sdk.pendo.io.j2.b;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0014\b\u0003\u0010\u0005*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042 \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006B%\b\u0004\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001b\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010\u001b¢\u0006\u0004\b(\u0010)J/\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00028\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0004¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00028\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010\u001b8\u0006¢\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010\u001fR\u0014\u0010'\u001a\u00020$8&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&\u0082\u0001\u0001*¨\u0006+"}, d2 = {"Lsdk/pendo/io/k2/k0;", "Key", "Value", "Collection", "", "Builder", "Lsdk/pendo/io/k2/a;", "", "Lsdk/pendo/io/j2/b;", "decoder", "builder", "", "startIndex", "size", "", "readAll", "(Lkotlinx/serialization/encoding/CompositeDecoder;Ljava/util/Map;II)V", "index", "", "checkIndex", "readElement", "(Lkotlinx/serialization/encoding/CompositeDecoder;ILjava/util/Map;Z)V", "Lsdk/pendo/io/j2/e;", "encoder", "value", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "Lsdk/pendo/io/g2/b;", "a", "Lsdk/pendo/io/g2/b;", "getKeySerializer", "()Lkotlinx/serialization/KSerializer;", "keySerializer", "b", "getValueSerializer", "valueSerializer", "Lsdk/pendo/io/i2/f;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "Lsdk/pendo/io/k2/d0;", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public abstract class k0<Key, Value, Collection, Builder extends Map<Key, Value>> extends a<Map.Entry<? extends Key, ? extends Value>, Collection, Builder> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final sdk.pendo.io.g2.b<Key> keySerializer;

    /* renamed from: b, reason: from kotlin metadata */
    private final sdk.pendo.io.g2.b<Value> valueSerializer;

    private k0(sdk.pendo.io.g2.b<Key> bVar, sdk.pendo.io.g2.b<Value> bVar2) {
        super(null);
        this.keySerializer = bVar;
        this.valueSerializer = bVar2;
    }

    @Override // sdk.pendo.io.g2.b, sdk.pendo.io.g2.a
    public abstract sdk.pendo.io.i2.f getDescriptor();

    public /* synthetic */ k0(sdk.pendo.io.g2.b bVar, sdk.pendo.io.g2.b bVar2, DefaultConstructorMarker defaultConstructorMarker) {
        this(bVar, bVar2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sdk.pendo.io.k2.a
    public final void a(sdk.pendo.io.j2.b decoder, Builder builder, int i, int i2) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(builder, "builder");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL".toString());
        }
        IntProgression step = RangesKt.step(RangesKt.until(0, i2 * 2), 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 <= 0 || first > last) && (step2 >= 0 || last > first)) {
            return;
        }
        while (true) {
            int i3 = first + step2;
            a(decoder, i + first, (int) builder, false);
            if (first == last) {
                return;
            } else {
                first = i3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sdk.pendo.io.k2.a
    public final void a(sdk.pendo.io.j2.b decoder, int i, Builder builder, boolean z) {
        int i2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Object a2 = b.a.a(decoder, getDescriptor(), i, this.keySerializer, null, 8, null);
        if (z) {
            i2 = decoder.e(getDescriptor());
            if (!(i2 == i + 1)) {
                throw new IllegalArgumentException(("Value must follow key in a map, index for key: " + i + ", returned index for value: " + i2).toString());
            }
        } else {
            i2 = i + 1;
        }
        int i3 = i2;
        builder.put(a2, (!builder.containsKey(a2) || (this.valueSerializer.getDescriptor().getKind() instanceof sdk.pendo.io.i2.e)) ? b.a.a(decoder, getDescriptor(), i3, this.valueSerializer, null, 8, null) : decoder.b(getDescriptor(), i3, this.valueSerializer, MapsKt.getValue(builder, a2)));
    }
}
