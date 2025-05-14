package sdk.pendo.io.k2;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.callercontext.ContextChain;
import io.sentry.protocol.ViewHierarchyNode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import sdk.pendo.io.j2.b;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\bQ\u0010RJ+\u0010\b\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00042\u0006\u0010\u0005\u001a\u00028\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\b\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020!2\u0006\u0010\u0005\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\"\u0010#J\b\u0010\u001f\u001a\u00020\nH\u0016J\b\u0010%\u001a\u0004\u0018\u00010$J\u0006\u0010\r\u001a\u00020\nJ\u0006\u0010&\u001a\u00020\fJ\u0006\u0010'\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0012J\u0006\u0010\b\u001a\u00020\u0015J\u0006\u0010(\u001a\u00020\u0018J\u0006\u0010)\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001eJ\u0006\u0010*\u001a\u00020!J\u000e\u0010\r\u001a\u00020\u00122\u0006\u0010,\u001a\u00020+J\u0016\u0010\u0013\u001a\u00020\n2\u0006\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020\u0012J\u0016\u0010\r\u001a\u00020\f2\u0006\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020\u0012J\u0016\u0010\u001c\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020\u0012J\u0016\u0010\u0010\u001a\u00020\u00122\u0006\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020\u0012J\u0016\u0010\u0019\u001a\u00020\u00152\u0006\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020\u0012J\u0016\u0010\"\u001a\u00020\u00182\u0006\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020\u0012J\u0016\u0010\u0016\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020\u0012J\u0016\u0010\u001f\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020\u0012J\u0016\u0010\b\u001a\u00020!2\u0006\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020\u0012J\u0017\u0010&\u001a\u0002002\u0006\u0010/\u001a\u00028\u0000H\u0004¢\u0006\u0004\b&\u00101J\u000f\u00102\u001a\u00028\u0000H\u0004¢\u0006\u0004\b2\u00103JC\u00109\u001a\u0004\u0018\u00018\u0001\"\b\b\u0001\u00105*\u0002042\u0006\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020\u00122\u000e\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u0001062\b\u00108\u001a\u0004\u0018\u00018\u0001¢\u0006\u0004\b9\u0010:J;\u0010;\u001a\u00028\u0001\"\u0004\b\u0001\u001052\u0006\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020\u00122\f\u00107\u001a\b\u0012\u0004\u0012\u00028\u0001062\b\u00108\u001a\u0004\u0018\u00018\u0001¢\u0006\u0004\b;\u0010:J-\u0010<\u001a\u00028\u0001\"\u0004\b\u0001\u001052\f\u00107\u001a\b\u0012\u0004\u0012\u00028\u0001062\b\u00108\u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0004\b<\u0010=J\u001f\u0010>\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010,\u001a\u00020+H\u0014¢\u0006\u0004\b>\u0010?J\u001f\u0010A\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010@\u001a\u00020+H\u0014¢\u0006\u0004\bA\u0010BJ\u001b\u0010C\u001a\u00028\u0000*\u00020+2\u0006\u0010.\u001a\u00020\u0012H$¢\u0006\u0004\bC\u0010DR$\u0010H\u001a\u0012\u0012\u0004\u0012\u00028\u00000Ej\b\u0012\u0004\u0012\u00028\u0000`F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010GR\u0016\u0010J\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010IR\u0016\u0010L\u001a\u0004\u0018\u00018\u00008DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bK\u00103R\u0014\u0010P\u001a\u00020M8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bN\u0010O¨\u0006S"}, d2 = {"Lsdk/pendo/io/k2/e1;", "Tag", "Lsdk/pendo/io/j2/d;", "Lsdk/pendo/io/j2/b;", ExifInterface.LONGITUDE_EAST, ViewHierarchyNode.JsonKeys.TAG, "Lkotlin/Function0;", "block", "a", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "", "(Ljava/lang/Object;)Z", "", "b", "(Ljava/lang/Object;)B", "", "h", "(Ljava/lang/Object;)S", "", "f", "(Ljava/lang/Object;)I", "", "g", "(Ljava/lang/Object;)J", "", "e", "(Ljava/lang/Object;)F", "", "d", "(Ljava/lang/Object;)D", "", "c", "(Ljava/lang/Object;)C", "", ContextChain.TAG_INFRA, "(Ljava/lang/Object;)Ljava/lang/String;", "", "k", "j", "l", "n", "o", "m", "Lsdk/pendo/io/i2/f;", "enumDescriptor", "descriptor", "index", "name", "", "(Ljava/lang/Object;)V", "q", "()Ljava/lang/Object;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lsdk/pendo/io/g2/a;", "deserializer", "previousValue", "decodeNullableSerializableElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeSerializableElement", "decodeSerializableValue", "(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeTaggedEnum", "(Ljava/lang/Object;Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "inlineDescriptor", "decodeTaggedInline", "(Ljava/lang/Object;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Decoder;", "getTag", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/Object;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "tagStack", "Z", "flag", ContextChain.TAG_PRODUCT, "currentTagOrNull", "Lsdk/pendo/io/n2/c;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "<init>", "()V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public abstract class e1<Tag> implements sdk.pendo.io.j2.d, sdk.pendo.io.j2.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<Tag> tagStack = new ArrayList<>();

    /* renamed from: b, reason: from kotlin metadata */
    private boolean flag;

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "", "Tag", "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a<T> extends Lambda implements Function0<T> {
        final /* synthetic */ T A;
        final /* synthetic */ e1<Tag> f;
        final /* synthetic */ sdk.pendo.io.g2.a<T> s;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(e1<Tag> e1Var, sdk.pendo.io.g2.a<T> aVar, T t) {
            super(0);
            this.f = e1Var;
            this.s = aVar;
            this.A = t;
        }

        @Override // kotlin.jvm.functions.Function0
        public final T invoke() {
            return this.f.c() ? (T) this.f.a((sdk.pendo.io.g2.a<sdk.pendo.io.g2.a<T>>) this.s, (sdk.pendo.io.g2.a<T>) this.A) : (T) this.f.k();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Tag", "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class b<T> extends Lambda implements Function0<T> {
        final /* synthetic */ T A;
        final /* synthetic */ e1<Tag> f;
        final /* synthetic */ sdk.pendo.io.g2.a<T> s;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(e1<Tag> e1Var, sdk.pendo.io.g2.a<T> aVar, T t) {
            super(0);
            this.f = e1Var;
            this.s = aVar;
            this.A = t;
        }

        @Override // kotlin.jvm.functions.Function0
        public final T invoke() {
            return (T) this.f.a((sdk.pendo.io.g2.a<sdk.pendo.io.g2.a<T>>) this.s, (sdk.pendo.io.g2.a<T>) this.A);
        }
    }

    protected abstract int a(Tag tag, sdk.pendo.io.i2.f fVar);

    @Override // sdk.pendo.io.j2.d
    public final long a() {
        return g(q());
    }

    @Override // sdk.pendo.io.j2.d
    public abstract <T> T a(sdk.pendo.io.g2.a<T> aVar);

    protected abstract boolean a(Tag tag);

    protected abstract byte b(Tag tag);

    @Override // sdk.pendo.io.j2.d
    public final boolean b() {
        return a((e1<Tag>) q());
    }

    protected abstract char c(Tag tag);

    @Override // sdk.pendo.io.j2.b
    public final char c(sdk.pendo.io.i2.f descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return c((e1<Tag>) j(descriptor, index));
    }

    @Override // sdk.pendo.io.j2.d
    public abstract boolean c();

    @Override // sdk.pendo.io.j2.d
    public final char d() {
        return c((e1<Tag>) q());
    }

    protected abstract double d(Tag tag);

    protected abstract float e(Tag tag);

    @Override // sdk.pendo.io.j2.b
    public final long e(sdk.pendo.io.i2.f descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return g(j(descriptor, index));
    }

    protected abstract int f(Tag tag);

    @Override // sdk.pendo.io.j2.b
    public final boolean f(sdk.pendo.io.i2.f descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return a((e1<Tag>) j(descriptor, index));
    }

    @Override // sdk.pendo.io.j2.b
    public final double g(sdk.pendo.io.i2.f descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return d((e1<Tag>) j(descriptor, index));
    }

    protected abstract long g(Tag tag);

    @Override // sdk.pendo.io.j2.d
    public final int h() {
        return f(q());
    }

    protected abstract short h(Tag tag);

    @Override // sdk.pendo.io.j2.b
    public final float i(sdk.pendo.io.i2.f descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return e((e1<Tag>) j(descriptor, index));
    }

    protected abstract String i(Tag tag);

    @Override // sdk.pendo.io.j2.d
    public final byte j() {
        return b((e1<Tag>) q());
    }

    protected abstract Tag j(sdk.pendo.io.i2.f fVar, int i);

    @Override // sdk.pendo.io.j2.d
    public final Void k() {
        return null;
    }

    @Override // sdk.pendo.io.j2.d
    public final short l() {
        return h(q());
    }

    @Override // sdk.pendo.io.j2.d
    public final String m() {
        return i(q());
    }

    @Override // sdk.pendo.io.j2.d
    public final float n() {
        return e((e1<Tag>) q());
    }

    @Override // sdk.pendo.io.j2.d
    public final double o() {
        return d((e1<Tag>) q());
    }

    protected final Tag p() {
        return (Tag) CollectionsKt.lastOrNull((List) this.tagStack);
    }

    protected final Tag q() {
        ArrayList<Tag> arrayList = this.tagStack;
        Tag remove = arrayList.remove(CollectionsKt.getLastIndex(arrayList));
        this.flag = true;
        return remove;
    }

    @Override // sdk.pendo.io.j2.b
    public final <T> T a(sdk.pendo.io.i2.f descriptor, int i, sdk.pendo.io.g2.a<T> deserializer, T t) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        return (T) a((e1<Tag>) j(descriptor, i), new a(this, deserializer, t));
    }

    @Override // sdk.pendo.io.j2.b
    public final byte b(sdk.pendo.io.i2.f descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return b((e1<Tag>) j(descriptor, index));
    }

    @Override // sdk.pendo.io.j2.b
    public int d(sdk.pendo.io.i2.f fVar) {
        return b.a.a(this, fVar);
    }

    @Override // sdk.pendo.io.j2.b
    public boolean e() {
        return b.a.a(this);
    }

    @Override // sdk.pendo.io.j2.b
    public final int h(sdk.pendo.io.i2.f descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return f(j(descriptor, index));
    }

    protected final void j(Tag name) {
        this.tagStack.add(name);
    }

    protected <T> T a(sdk.pendo.io.g2.a<T> deserializer, T t) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        return (T) a((sdk.pendo.io.g2.a) deserializer);
    }

    @Override // sdk.pendo.io.j2.d
    public final int b(sdk.pendo.io.i2.f enumDescriptor) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        return a((e1<Tag>) q(), enumDescriptor);
    }

    @Override // sdk.pendo.io.j2.b
    public final short d(sdk.pendo.io.i2.f descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return h(j(descriptor, index));
    }

    @Override // sdk.pendo.io.j2.b
    public final String a(sdk.pendo.io.i2.f descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return i(j(descriptor, index));
    }

    @Override // sdk.pendo.io.j2.b
    public final <T> T b(sdk.pendo.io.i2.f descriptor, int i, sdk.pendo.io.g2.a<T> deserializer, T t) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        return (T) a((e1<Tag>) j(descriptor, i), new b(this, deserializer, t));
    }

    private final <E> E a(Tag tag, Function0<? extends E> block) {
        j(tag);
        E invoke = block.invoke();
        if (!this.flag) {
            q();
        }
        this.flag = false;
        return invoke;
    }
}
