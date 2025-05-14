package sdk.pendo.io.g2;

import androidx.exifinterface.media.ExifInterface;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.Grouping;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlin.text.Typography;
import sdk.pendo.io.i2.d;
import sdk.pendo.io.i2.i;
import sdk.pendo.io.i2.j;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0007\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003BY\b\u0011\u0012\u0006\u0010&\u001a\u00020\u0006\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\u0014\u0010(\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00100'\u0012\u0014\u0010)\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000 0'\u0012\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00150'¢\u0006\u0004\b+\u0010,BI\u0012\u0006\u0010&\u001a\u00020\u0006\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\u0014\u0010(\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00100'\u0012\u0014\u0010)\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000 0'¢\u0006\u0004\b+\u0010-J$\u0010\t\u001a\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J'\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR \u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00108\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u0011\u001a\u0004\b\t\u0010\u0012R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001e\u001a\u00020\u00198VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR0\u0010#\u001a\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000 0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R(\u0010%\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000 0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010\"¨\u0006."}, d2 = {"Lsdk/pendo/io/g2/e;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lsdk/pendo/io/k2/b;", "Lsdk/pendo/io/j2/b;", "decoder", "", "klassName", "Lsdk/pendo/io/g2/a;", "a", "Lsdk/pendo/io/j2/e;", "encoder", "value", "Lsdk/pendo/io/g2/g;", "findPolymorphicSerializerOrNull", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/KClass;", "()Lkotlin/reflect/KClass;", "baseClass", "", "", "b", "Ljava/util/List;", "_annotations", "Lsdk/pendo/io/i2/f;", "c", "Lkotlin/Lazy;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "", "Lsdk/pendo/io/g2/b;", "d", "Ljava/util/Map;", "class2Serializer", "e", "serialName2Serializer", "serialName", "", "subclasses", "subclassSerializers", "classAnnotations", "<init>", "(Ljava/lang/String;Lkotlin/reflect/KClass;[Lkotlin/reflect/KClass;[Lkotlinx/serialization/KSerializer;[Ljava/lang/annotation/Annotation;)V", "(Ljava/lang/String;Lkotlin/reflect/KClass;[Lkotlin/reflect/KClass;[Lkotlinx/serialization/KSerializer;)V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class e<T> extends sdk.pendo.io.k2.b<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final KClass<T> baseClass;

    /* renamed from: b, reason: from kotlin metadata */
    private List<? extends Annotation> _annotations;

    /* renamed from: c, reason: from kotlin metadata */
    private final Lazy descriptor;

    /* renamed from: d, reason: from kotlin metadata */
    private final Map<KClass<? extends T>, sdk.pendo.io.g2.b<? extends T>> class2Serializer;

    /* renamed from: e, reason: from kotlin metadata */
    private final Map<String, sdk.pendo.io.g2.b<? extends T>> serialName2Serializer;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lsdk/pendo/io/i2/f;", "a", "()Lsdk/pendo/io/i2/f;"}, k = 3, mv = {1, 6, 0})
    static final class a extends Lambda implements Function0<sdk.pendo.io.i2.f> {
        final /* synthetic */ sdk.pendo.io.g2.b<? extends T>[] A;
        final /* synthetic */ String f;
        final /* synthetic */ e<T> s;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lsdk/pendo/io/i2/a;", "", "a", "(Lsdk/pendo/io/i2/a;)V"}, k = 3, mv = {1, 6, 0})
        /* renamed from: sdk.pendo.io.g2.e$a$a, reason: collision with other inner class name */
        static final class C0141a extends Lambda implements Function1<sdk.pendo.io.i2.a, Unit> {
            final /* synthetic */ e<T> f;
            final /* synthetic */ sdk.pendo.io.g2.b<? extends T>[] s;

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lsdk/pendo/io/i2/a;", "", "a", "(Lsdk/pendo/io/i2/a;)V"}, k = 3, mv = {1, 6, 0})
            /* renamed from: sdk.pendo.io.g2.e$a$a$a, reason: collision with other inner class name */
            static final class C0142a extends Lambda implements Function1<sdk.pendo.io.i2.a, Unit> {
                final /* synthetic */ sdk.pendo.io.g2.b<? extends T>[] f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0142a(sdk.pendo.io.g2.b<? extends T>[] bVarArr) {
                    super(1);
                    this.f = bVarArr;
                }

                public final void a(sdk.pendo.io.i2.a buildSerialDescriptor) {
                    Intrinsics.checkNotNullParameter(buildSerialDescriptor, "$this$buildSerialDescriptor");
                    sdk.pendo.io.g2.b<? extends T>[] bVarArr = this.f;
                    int length = bVarArr.length;
                    int i = 0;
                    while (i < length) {
                        sdk.pendo.io.g2.b<? extends T> bVar = bVarArr[i];
                        i++;
                        sdk.pendo.io.i2.f descriptor = bVar.getDescriptor();
                        sdk.pendo.io.i2.a.a(buildSerialDescriptor, descriptor.getSerialName(), descriptor, null, false, 12, null);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(sdk.pendo.io.i2.a aVar) {
                    a(aVar);
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0141a(e<T> eVar, sdk.pendo.io.g2.b<? extends T>[] bVarArr) {
                super(1);
                this.f = eVar;
                this.s = bVarArr;
            }

            public final void a(sdk.pendo.io.i2.a buildSerialDescriptor) {
                Intrinsics.checkNotNullParameter(buildSerialDescriptor, "$this$buildSerialDescriptor");
                sdk.pendo.io.i2.a.a(buildSerialDescriptor, "type", sdk.pendo.io.h2.a.a(StringCompanionObject.INSTANCE).getDescriptor(), null, false, 12, null);
                sdk.pendo.io.i2.a.a(buildSerialDescriptor, "value", i.a("external.sdk.pendo.io.kotlinx.serialization.Sealed<" + ((Object) this.f.a().getSimpleName()) + Typography.greater, j.a.f1195a, new sdk.pendo.io.i2.f[0], new C0142a(this.s)), null, false, 12, null);
                buildSerialDescriptor.a(((e) this.f)._annotations);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(sdk.pendo.io.i2.a aVar) {
                a(aVar);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, e<T> eVar, sdk.pendo.io.g2.b<? extends T>[] bVarArr) {
            super(0);
            this.f = str;
            this.s = eVar;
            this.A = bVarArr;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final sdk.pendo.io.i2.f invoke() {
            return i.a(this.f, d.a.f1184a, new sdk.pendo.io.i2.f[0], new C0141a(this.s, this.A));
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016J\u0017\u0010\u0005\u001a\u00028\u00012\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlin/collections/CollectionsKt___CollectionsKt$groupingBy$1", "Lkotlin/collections/Grouping;", "", "sourceIterator", "element", "keyOf", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    public static final class b implements Grouping<Map.Entry<? extends KClass<? extends T>, ? extends sdk.pendo.io.g2.b<? extends T>>, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterable f1106a;

        public b(Iterable iterable) {
            this.f1106a = iterable;
        }

        @Override // kotlin.collections.Grouping
        public String keyOf(Map.Entry<? extends KClass<? extends T>, ? extends sdk.pendo.io.g2.b<? extends T>> element) {
            return element.getValue().getDescriptor().getSerialName();
        }

        @Override // kotlin.collections.Grouping
        public Iterator<Map.Entry<? extends KClass<? extends T>, ? extends sdk.pendo.io.g2.b<? extends T>>> sourceIterator() {
            return this.f1106a.iterator();
        }
    }

    public e(String serialName, KClass<T> baseClass, KClass<? extends T>[] subclasses, sdk.pendo.io.g2.b<? extends T>[] subclassSerializers) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(subclasses, "subclasses");
        Intrinsics.checkNotNullParameter(subclassSerializers, "subclassSerializers");
        this.baseClass = baseClass;
        this._annotations = CollectionsKt.emptyList();
        this.descriptor = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new a(serialName, this, subclassSerializers));
        if (subclasses.length != subclassSerializers.length) {
            throw new IllegalArgumentException("All subclasses of sealed class " + ((Object) a().getSimpleName()) + " should be marked @Serializable");
        }
        Map<KClass<? extends T>, sdk.pendo.io.g2.b<? extends T>> map = MapsKt.toMap(ArraysKt.zip(subclasses, subclassSerializers));
        this.class2Serializer = map;
        Grouping bVar = new b(map.entrySet());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> sourceIterator = bVar.sourceIterator();
        while (sourceIterator.hasNext()) {
            T next = sourceIterator.next();
            Object keyOf = bVar.keyOf(next);
            Object obj = linkedHashMap.get(keyOf);
            if (obj == null) {
                linkedHashMap.containsKey(keyOf);
            }
            Map.Entry entry = (Map.Entry) next;
            Map.Entry entry2 = (Map.Entry) obj;
            String str = (String) keyOf;
            if (entry2 != null) {
                throw new IllegalStateException(("Multiple sealed subclasses of '" + a() + "' have the same serial name '" + str + "': '" + entry2.getKey() + "', '" + entry.getKey() + '\'').toString());
            }
            linkedHashMap.put(keyOf, entry);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry3 : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry3.getKey(), (sdk.pendo.io.g2.b) ((Map.Entry) entry3.getValue()).getValue());
        }
        this.serialName2Serializer = linkedHashMap2;
    }

    @Override // sdk.pendo.io.g2.b, sdk.pendo.io.g2.a
    public sdk.pendo.io.i2.f getDescriptor() {
        return (sdk.pendo.io.i2.f) this.descriptor.getValue();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(String serialName, KClass<T> baseClass, KClass<? extends T>[] subclasses, sdk.pendo.io.g2.b<? extends T>[] subclassSerializers, Annotation[] classAnnotations) {
        this(serialName, baseClass, subclasses, subclassSerializers);
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(subclasses, "subclasses");
        Intrinsics.checkNotNullParameter(subclassSerializers, "subclassSerializers");
        Intrinsics.checkNotNullParameter(classAnnotations, "classAnnotations");
        this._annotations = ArraysKt.asList(classAnnotations);
    }

    @Override // sdk.pendo.io.k2.b
    public sdk.pendo.io.g2.a<? extends T> a(sdk.pendo.io.j2.b decoder, String klassName) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        sdk.pendo.io.g2.b<? extends T> bVar = this.serialName2Serializer.get(klassName);
        return bVar == null ? super.a(decoder, klassName) : bVar;
    }

    @Override // sdk.pendo.io.k2.b
    public KClass<T> a() {
        return this.baseClass;
    }
}
