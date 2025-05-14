package sdk.pendo.io.k2;

import com.facebook.common.callercontext.ContextChain;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import sdk.pendo.io.i2.f;
import sdk.pendo.io.i2.k;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0018\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001a\u0012\u0006\u0010\u001f\u001a\u00020\u0005¢\u0006\u0004\bH\u0010IJ\u0014\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\bJ\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u0013\u0010\u0014\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016R\u001a\u0010\u0019\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u000b\u0010\u0018R\u001a\u0010\u001c\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001bR\u0017\u0010\u001f\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\r\u0010\u001eR\u0016\u0010 \u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u001dR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\"\u0010'\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010%0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010&R\u001e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\"\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R%\u00107\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R!\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00010!8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b8\u00104\u001a\u0004\b9\u0010:R\u001b\u0010=\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u00104\u001a\u0004\b/\u0010\u001eR\u001a\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00040A8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010BR\u0014\u0010G\u001a\u00020D8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010F¨\u0006J"}, d2 = {"Lsdk/pendo/io/k2/q0;", "Lsdk/pendo/io/i2/f;", "Lsdk/pendo/io/k2/l;", "", "", "", "f", "name", "", "isOptional", "", "a", "index", "c", "d", "", "", "b", "", "other", "equals", "hashCode", "toString", "Ljava/lang/String;", "()Ljava/lang/String;", "serialName", "Lsdk/pendo/io/k2/x;", "Lsdk/pendo/io/k2/x;", "generatedSerializer", "I", "()I", "elementsCount", "added", "", "e", "[Ljava/lang/String;", "names", "", "[Ljava/util/List;", "propertiesAnnotations", "g", "Ljava/util/List;", "classAnnotations", "", "h", "[Z", "elementsOptionality", ContextChain.TAG_INFRA, "Ljava/util/Map;", "indices", "Lsdk/pendo/io/g2/b;", "j", "Lkotlin/Lazy;", "getChildSerializers", "()[Lkotlinx/serialization/KSerializer;", "childSerializers", "k", "getTypeParameterDescriptors$kotlinx_serialization_core", "()[Lkotlinx/serialization/descriptors/SerialDescriptor;", "typeParameterDescriptors", "l", "_hashCode", "getAnnotations", "()Ljava/util/List;", "annotations", "", "()Ljava/util/Set;", "serialNames", "Lsdk/pendo/io/i2/j;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "kind", "<init>", "(Ljava/lang/String;Lkotlinx/serialization/internal/GeneratedSerializer;I)V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public class q0 implements sdk.pendo.io.i2.f, l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String serialName;

    /* renamed from: b, reason: from kotlin metadata */
    private final x<?> generatedSerializer;

    /* renamed from: c, reason: from kotlin metadata */
    private final int elementsCount;

    /* renamed from: d, reason: from kotlin metadata */
    private int added;

    /* renamed from: e, reason: from kotlin metadata */
    private final String[] names;

    /* renamed from: f, reason: from kotlin metadata */
    private final List<Annotation>[] propertiesAnnotations;

    /* renamed from: g, reason: from kotlin metadata */
    private List<Annotation> classAnnotations;

    /* renamed from: h, reason: from kotlin metadata */
    private final boolean[] elementsOptionality;

    /* renamed from: i, reason: from kotlin metadata */
    private Map<String, Integer> indices;

    /* renamed from: j, reason: from kotlin metadata */
    private final Lazy childSerializers;

    /* renamed from: k, reason: from kotlin metadata */
    private final Lazy typeParameterDescriptors;

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
            q0 q0Var = q0.this;
            return Integer.valueOf(r0.a(q0Var, q0Var.h()));
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lsdk/pendo/io/g2/b;", "invoke", "()[Lkotlinx/serialization/KSerializer;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    static final class b extends Lambda implements Function0<sdk.pendo.io.g2.b<?>[]> {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final sdk.pendo.io.g2.b<?>[] invoke() {
            x xVar = q0.this.generatedSerializer;
            sdk.pendo.io.g2.b<?>[] childSerializers = xVar == null ? null : xVar.childSerializers();
            return childSerializers == null ? s0.f1277a : childSerializers;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", ContextChain.TAG_INFRA, "", "a", "(I)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 6, 0})
    static final class c extends Lambda implements Function1<Integer, CharSequence> {
        c() {
            super(1);
        }

        public final CharSequence a(int i) {
            return q0.this.a(i) + ": " + q0.this.c(i).getSerialName();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(Integer num) {
            return a(num.intValue());
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lsdk/pendo/io/i2/f;", "invoke", "()[Lkotlinx/serialization/descriptors/SerialDescriptor;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    static final class d extends Lambda implements Function0<sdk.pendo.io.i2.f[]> {
        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final sdk.pendo.io.i2.f[] invoke() {
            ArrayList arrayList;
            sdk.pendo.io.g2.b<?>[] typeParametersSerializers;
            x xVar = q0.this.generatedSerializer;
            if (xVar == null || (typeParametersSerializers = xVar.typeParametersSerializers()) == null) {
                arrayList = null;
            } else {
                ArrayList arrayList2 = new ArrayList(typeParametersSerializers.length);
                int length = typeParametersSerializers.length;
                int i = 0;
                while (i < length) {
                    sdk.pendo.io.g2.b<?> bVar = typeParametersSerializers[i];
                    i++;
                    arrayList2.add(bVar.getDescriptor());
                }
                arrayList = arrayList2;
            }
            return o0.a(arrayList);
        }
    }

    public q0(String serialName, x<?> xVar, int i) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        this.serialName = serialName;
        this.generatedSerializer = xVar;
        this.elementsCount = i;
        this.added = -1;
        String[] strArr = new String[i];
        for (int i2 = 0; i2 < i; i2++) {
            strArr[i2] = "[UNINITIALIZED]";
        }
        this.names = strArr;
        int i3 = this.elementsCount;
        this.propertiesAnnotations = new List[i3];
        this.elementsOptionality = new boolean[i3];
        this.indices = MapsKt.emptyMap();
        this.childSerializers = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new b());
        this.typeParameterDescriptors = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new d());
        this._hashCode = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new a());
    }

    private final Map<String, Integer> f() {
        HashMap hashMap = new HashMap();
        int length = this.names.length;
        for (int i = 0; i < length; i++) {
            hashMap.put(this.names[i], Integer.valueOf(i));
        }
        return hashMap;
    }

    private final sdk.pendo.io.g2.b<?>[] g() {
        return (sdk.pendo.io.g2.b[]) this.childSerializers.getValue();
    }

    private final int i() {
        return ((Number) this._hashCode.getValue()).intValue();
    }

    @Override // sdk.pendo.io.i2.f
    public List<Annotation> b(int index) {
        List<Annotation> list = this.propertiesAnnotations[index];
        return list == null ? CollectionsKt.emptyList() : list;
    }

    @Override // sdk.pendo.io.i2.f
    public sdk.pendo.io.i2.f c(int index) {
        return g()[index].getDescriptor();
    }

    @Override // sdk.pendo.io.k2.l
    public Set<String> d() {
        return this.indices.keySet();
    }

    @Override // sdk.pendo.io.i2.f
    public boolean e() {
        return f.a.c(this);
    }

    public boolean equals(Object other) {
        if (this != other) {
            if (!(other instanceof q0)) {
                return false;
            }
            sdk.pendo.io.i2.f fVar = (sdk.pendo.io.i2.f) other;
            if (!Intrinsics.areEqual(getSerialName(), fVar.getSerialName()) || !Arrays.equals(h(), ((q0) other).h()) || getElementsCount() != fVar.getElementsCount()) {
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
        List<Annotation> list = this.classAnnotations;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public final sdk.pendo.io.i2.f[] h() {
        return (sdk.pendo.io.i2.f[]) this.typeParameterDescriptors.getValue();
    }

    public int hashCode() {
        return i();
    }

    @Override // sdk.pendo.io.i2.f
    public boolean isInline() {
        return f.a.b(this);
    }

    public String toString() {
        return CollectionsKt.joinToString$default(RangesKt.until(0, this.elementsCount), ", ", Intrinsics.stringPlus(getSerialName(), "("), ")", 0, null, new c(), 24, null);
    }

    public /* synthetic */ q0(String str, x xVar, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? null : xVar, i);
    }

    public final void a(String name, boolean isOptional) {
        Intrinsics.checkNotNullParameter(name, "name");
        String[] strArr = this.names;
        int i = this.added + 1;
        this.added = i;
        strArr[i] = name;
        this.elementsOptionality[i] = isOptional;
        this.propertiesAnnotations[i] = null;
        if (i == this.elementsCount - 1) {
            this.indices = f();
        }
    }

    @Override // sdk.pendo.io.i2.f
    /* renamed from: b */
    public sdk.pendo.io.i2.j getKind() {
        return k.a.f1197a;
    }

    @Override // sdk.pendo.io.i2.f
    /* renamed from: c, reason: from getter */
    public final int getElementsCount() {
        return this.elementsCount;
    }

    @Override // sdk.pendo.io.i2.f
    public boolean d(int index) {
        return this.elementsOptionality[index];
    }

    @Override // sdk.pendo.io.i2.f
    public int a(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Integer num = this.indices.get(name);
        if (num == null) {
            return -3;
        }
        return num.intValue();
    }

    @Override // sdk.pendo.io.i2.f
    public String a(int index) {
        return this.names[index];
    }

    @Override // sdk.pendo.io.i2.f
    /* renamed from: a, reason: from getter */
    public String getSerialName() {
        return this.serialName;
    }
}
