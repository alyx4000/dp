package sdk.pendo.io.n2;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import sdk.pendo.io.g2.g;
import sdk.pendo.io.n2.a;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001Bæ\u0001\u0012\u0016\u0010\u0018\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u00160\u0015\u0012*\u0010\u001a\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0018\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u00150\u0015\u0012.\u0010\u001e\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u001c\u0012\u001a\u0012\u0002\b\u0003\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00120\u001bj\u0006\u0012\u0002\b\u0003`\u001c0\u0015\u0012&\u0010 \u001a\"\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u00150\u0015\u0012A\u0010&\u001a=\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012/\u0012-\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u001bj\u0006\u0012\u0002\b\u0003`$0\u0015¢\u0006\u0004\b'\u0010(J6\u0010\t\u001a\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\b\"\b\b\u0000\u0010\u0003*\u00020\u00022\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J:\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0010\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000bH\u0016J\u0010\u0010\t\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J9\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012\"\b\b\u0000\u0010\u0003*\u00020\u00022\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00042\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0018\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u00160\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0017R8\u0010\u001a\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0018\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u00150\u00158\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R<\u0010\u001e\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u001c\u0012\u001a\u0012\u0002\b\u0003\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00120\u001bj\u0006\u0012\u0002\b\u0003`\u001c0\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0017R4\u0010 \u001a\"\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u00150\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0017RO\u0010&\u001a=\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012/\u0012-\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u001bj\u0006\u0012\u0002\b\u0003`$0\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010\u0017¨\u0006)"}, d2 = {"Lsdk/pendo/io/n2/b;", "Lsdk/pendo/io/n2/c;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/KClass;", "baseClass", "", "serializedClassName", "Lsdk/pendo/io/g2/a;", "a", "kClass", "", "Lsdk/pendo/io/g2/b;", "typeArgumentsSerializers", "Lsdk/pendo/io/n2/d;", "collector", "", "value", "Lsdk/pendo/io/g2/g;", "getPolymorphic", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "", "Lsdk/pendo/io/n2/a;", "Ljava/util/Map;", "class2ContextualFactory", "b", "polyBase2Serializers", "Lkotlin/Function1;", "Lexternal/sdk/pendo/io/kotlinx/serialization/modules/PolymorphicSerializerProvider;", "c", "polyBase2DefaultSerializerProvider", "d", "polyBase2NamedSerializers", "Lkotlin/ParameterName;", "name", "className", "Lexternal/sdk/pendo/io/kotlinx/serialization/modules/PolymorphicDeserializerProvider;", "e", "polyBase2DefaultDeserializerProvider", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class b extends c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Map<KClass<?>, a> class2ContextualFactory;

    /* renamed from: b, reason: from kotlin metadata */
    public final Map<KClass<?>, Map<KClass<?>, sdk.pendo.io.g2.b<?>>> polyBase2Serializers;

    /* renamed from: c, reason: from kotlin metadata */
    private final Map<KClass<?>, Function1<?, g<?>>> polyBase2DefaultSerializerProvider;

    /* renamed from: d, reason: from kotlin metadata */
    private final Map<KClass<?>, Map<String, sdk.pendo.io.g2.b<?>>> polyBase2NamedSerializers;

    /* renamed from: e, reason: from kotlin metadata */
    private final Map<KClass<?>, Function1<String, sdk.pendo.io.g2.a<?>>> polyBase2DefaultDeserializerProvider;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public b(Map<KClass<?>, ? extends a> class2ContextualFactory, Map<KClass<?>, ? extends Map<KClass<?>, ? extends sdk.pendo.io.g2.b<?>>> polyBase2Serializers, Map<KClass<?>, ? extends Function1<?, ? extends g<?>>> polyBase2DefaultSerializerProvider, Map<KClass<?>, ? extends Map<String, ? extends sdk.pendo.io.g2.b<?>>> polyBase2NamedSerializers, Map<KClass<?>, ? extends Function1<? super String, ? extends sdk.pendo.io.g2.a<?>>> polyBase2DefaultDeserializerProvider) {
        super(null);
        Intrinsics.checkNotNullParameter(class2ContextualFactory, "class2ContextualFactory");
        Intrinsics.checkNotNullParameter(polyBase2Serializers, "polyBase2Serializers");
        Intrinsics.checkNotNullParameter(polyBase2DefaultSerializerProvider, "polyBase2DefaultSerializerProvider");
        Intrinsics.checkNotNullParameter(polyBase2NamedSerializers, "polyBase2NamedSerializers");
        Intrinsics.checkNotNullParameter(polyBase2DefaultDeserializerProvider, "polyBase2DefaultDeserializerProvider");
        this.class2ContextualFactory = class2ContextualFactory;
        this.polyBase2Serializers = polyBase2Serializers;
        this.polyBase2DefaultSerializerProvider = polyBase2DefaultSerializerProvider;
        this.polyBase2NamedSerializers = polyBase2NamedSerializers;
        this.polyBase2DefaultDeserializerProvider = polyBase2DefaultDeserializerProvider;
    }

    @Override // sdk.pendo.io.n2.c
    public void a(d collector) {
        Intrinsics.checkNotNullParameter(collector, "collector");
        for (Map.Entry<KClass<?>, a> entry : this.class2ContextualFactory.entrySet()) {
            KClass<?> key = entry.getKey();
            a value = entry.getValue();
            if (value instanceof a.C0203a) {
                collector.a(key, ((a.C0203a) value).a());
            } else if (value instanceof a.b) {
                collector.b(key, ((a.b) value).a());
            }
        }
        for (Map.Entry<KClass<?>, Map<KClass<?>, sdk.pendo.io.g2.b<?>>> entry2 : this.polyBase2Serializers.entrySet()) {
            KClass<?> key2 = entry2.getKey();
            for (Map.Entry<KClass<?>, sdk.pendo.io.g2.b<?>> entry3 : entry2.getValue().entrySet()) {
                collector.a(key2, entry3.getKey(), entry3.getValue());
            }
        }
        for (Map.Entry<KClass<?>, Function1<?, g<?>>> entry4 : this.polyBase2DefaultSerializerProvider.entrySet()) {
            collector.c(entry4.getKey(), (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(entry4.getValue(), 1));
        }
        for (Map.Entry<KClass<?>, Function1<String, sdk.pendo.io.g2.a<?>>> entry5 : this.polyBase2DefaultDeserializerProvider.entrySet()) {
            collector.a(entry5.getKey(), (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(entry5.getValue(), 1));
        }
    }

    @Override // sdk.pendo.io.n2.c
    public <T> sdk.pendo.io.g2.b<T> a(KClass<T> kClass, List<? extends sdk.pendo.io.g2.b<?>> typeArgumentsSerializers) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(typeArgumentsSerializers, "typeArgumentsSerializers");
        a aVar = this.class2ContextualFactory.get(kClass);
        sdk.pendo.io.g2.b<?> a2 = aVar == null ? null : aVar.a(typeArgumentsSerializers);
        if (a2 instanceof sdk.pendo.io.g2.b) {
            return (sdk.pendo.io.g2.b<T>) a2;
        }
        return null;
    }

    @Override // sdk.pendo.io.n2.c
    public <T> sdk.pendo.io.g2.a<? extends T> a(KClass<? super T> baseClass, String serializedClassName) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Map<String, sdk.pendo.io.g2.b<?>> map = this.polyBase2NamedSerializers.get(baseClass);
        sdk.pendo.io.g2.b<?> bVar = map == null ? null : map.get(serializedClassName);
        if (!(bVar instanceof sdk.pendo.io.g2.b)) {
            bVar = null;
        }
        if (bVar != null) {
            return bVar;
        }
        Function1<String, sdk.pendo.io.g2.a<?>> function1 = this.polyBase2DefaultDeserializerProvider.get(baseClass);
        Function1<String, sdk.pendo.io.g2.a<?>> function12 = TypeIntrinsics.isFunctionOfArity(function1, 1) ? function1 : null;
        if (function12 == null) {
            return null;
        }
        return (sdk.pendo.io.g2.a) function12.invoke(serializedClassName);
    }
}
