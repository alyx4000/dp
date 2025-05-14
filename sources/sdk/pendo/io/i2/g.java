package sdk.pendo.io.i2;

import com.facebook.common.callercontext.ContextChain;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import sdk.pendo.io.i2.f;
import sdk.pendo.io.k2.l;
import sdk.pendo.io.k2.o0;
import sdk.pendo.io.k2.r0;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0010\u0018\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00010\b\u0012\u0006\u0010@\u001a\u00020?¢\u0006\u0004\bA\u0010BJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0013\u0010\u0010\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016R\u001a\u0010\u0015\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0006\u0010\u0014R\u001a\u0010\u001a\u001a\u00020\u00168\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u000b\u0010\u001cR \u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u001f\u0010 R \u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\"8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b\r\u0010%R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00010'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R \u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R \u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0003058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00010'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010,R\u001b\u0010=\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b(\u0010\u001c¨\u0006C"}, d2 = {"Lsdk/pendo/io/i2/g;", "Lsdk/pendo/io/i2/f;", "Lsdk/pendo/io/k2/l;", "", "index", "", "a", "name", "", "", "b", "c", "", "d", "", "other", "equals", "hashCode", "toString", "Ljava/lang/String;", "()Ljava/lang/String;", "serialName", "Lsdk/pendo/io/i2/j;", "Lsdk/pendo/io/i2/j;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "kind", "I", "()I", "elementsCount", "Ljava/util/List;", "getAnnotations", "()Ljava/util/List;", "annotations", "", "e", "Ljava/util/Set;", "()Ljava/util/Set;", "serialNames", "", "f", "[Ljava/lang/String;", "elementNames", "g", "[Lsdk/pendo/io/i2/f;", "elementDescriptors", "h", "[Ljava/util/List;", "elementAnnotations", "", ContextChain.TAG_INFRA, "[Z", "elementOptionality", "", "j", "Ljava/util/Map;", "name2Index", "k", "typeParametersDescriptors", "l", "Lkotlin/Lazy;", "_hashCode", "typeParameters", "Lsdk/pendo/io/i2/a;", "builder", "<init>", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialKind;ILjava/util/List;Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;)V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class g implements f, l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String serialName;

    /* renamed from: b, reason: from kotlin metadata */
    private final j kind;

    /* renamed from: c, reason: from kotlin metadata */
    private final int elementsCount;

    /* renamed from: d, reason: from kotlin metadata */
    private final List<Annotation> annotations;

    /* renamed from: e, reason: from kotlin metadata */
    private final Set<String> serialNames;

    /* renamed from: f, reason: from kotlin metadata */
    private final String[] elementNames;

    /* renamed from: g, reason: from kotlin metadata */
    private final f[] elementDescriptors;

    /* renamed from: h, reason: from kotlin metadata */
    private final List<Annotation>[] elementAnnotations;

    /* renamed from: i, reason: from kotlin metadata */
    private final boolean[] elementOptionality;

    /* renamed from: j, reason: from kotlin metadata */
    private final Map<String, Integer> name2Index;

    /* renamed from: k, reason: from kotlin metadata */
    private final f[] typeParametersDescriptors;

    /* renamed from: l, reason: from kotlin metadata */
    private final Lazy _hashCode;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0})
    static final class a extends Lambda implements Function0<Integer> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            g gVar = g.this;
            return Integer.valueOf(r0.a(gVar, gVar.typeParametersDescriptors));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "a", "(I)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 6, 0})
    static final class b extends Lambda implements Function1<Integer, CharSequence> {
        b() {
            super(1);
        }

        public final CharSequence a(int i) {
            return g.this.a(i) + ": " + g.this.c(i).getSerialName();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(Integer num) {
            return a(num.intValue());
        }
    }

    public g(String serialName, j kind, int i, List<? extends f> typeParameters, sdk.pendo.io.i2.a builder) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(typeParameters, "typeParameters");
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.serialName = serialName;
        this.kind = kind;
        this.elementsCount = i;
        this.annotations = builder.a();
        this.serialNames = CollectionsKt.toHashSet(builder.d());
        Object[] array = builder.d().toArray(new String[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        String[] strArr = (String[]) array;
        this.elementNames = strArr;
        this.elementDescriptors = o0.a(builder.c());
        Object[] array2 = builder.b().toArray(new List[0]);
        if (array2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        this.elementAnnotations = (List[]) array2;
        this.elementOptionality = CollectionsKt.toBooleanArray(builder.e());
        Iterable<IndexedValue> withIndex = ArraysKt.withIndex(strArr);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(withIndex, 10));
        for (IndexedValue indexedValue : withIndex) {
            arrayList.add(TuplesKt.to(indexedValue.getValue(), Integer.valueOf(indexedValue.getIndex())));
        }
        this.name2Index = MapsKt.toMap(arrayList);
        this.typeParametersDescriptors = o0.a(typeParameters);
        this._hashCode = LazyKt.lazy(new a());
    }

    private final int f() {
        return ((Number) this._hashCode.getValue()).intValue();
    }

    @Override // sdk.pendo.io.i2.f
    public List<Annotation> b(int index) {
        return this.elementAnnotations[index];
    }

    @Override // sdk.pendo.io.i2.f
    public f c(int index) {
        return this.elementDescriptors[index];
    }

    @Override // sdk.pendo.io.k2.l
    public Set<String> d() {
        return this.serialNames;
    }

    @Override // sdk.pendo.io.i2.f
    public boolean e() {
        return f.a.c(this);
    }

    public boolean equals(Object other) {
        if (this != other) {
            if (!(other instanceof g)) {
                return false;
            }
            f fVar = (f) other;
            if (!Intrinsics.areEqual(getSerialName(), fVar.getSerialName()) || !Arrays.equals(this.typeParametersDescriptors, ((g) other).typeParametersDescriptors) || getElementsCount() != fVar.getElementsCount()) {
                return false;
            }
            int elementsCount = getElementsCount();
            int i = 0;
            while (i < elementsCount) {
                int i2 = i + 1;
                if (!Intrinsics.areEqual(c(i).getSerialName(), fVar.c(i).getSerialName()) || !Intrinsics.areEqual(c(i).getKind(), fVar.c(i).getKind())) {
                    return false;
                }
                i = i2;
            }
        }
        return true;
    }

    @Override // sdk.pendo.io.i2.f
    public List<Annotation> getAnnotations() {
        return this.annotations;
    }

    public int hashCode() {
        return f();
    }

    @Override // sdk.pendo.io.i2.f
    public boolean isInline() {
        return f.a.b(this);
    }

    public String toString() {
        return CollectionsKt.joinToString$default(RangesKt.until(0, getElementsCount()), ", ", Intrinsics.stringPlus(getSerialName(), "("), ")", 0, null, new b(), 24, null);
    }

    @Override // sdk.pendo.io.i2.f
    public int a(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Integer num = this.name2Index.get(name);
        if (num == null) {
            return -3;
        }
        return num.intValue();
    }

    @Override // sdk.pendo.io.i2.f
    /* renamed from: b, reason: from getter */
    public j getKind() {
        return this.kind;
    }

    @Override // sdk.pendo.io.i2.f
    /* renamed from: c, reason: from getter */
    public int getElementsCount() {
        return this.elementsCount;
    }

    @Override // sdk.pendo.io.i2.f
    public boolean d(int index) {
        return this.elementOptionality[index];
    }

    @Override // sdk.pendo.io.i2.f
    public String a(int index) {
        return this.elementNames[index];
    }

    @Override // sdk.pendo.io.i2.f
    /* renamed from: a, reason: from getter */
    public String getSerialName() {
        return this.serialName;
    }
}
