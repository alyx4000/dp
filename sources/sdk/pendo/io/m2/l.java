package sdk.pendo.io.m2;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.m2.f;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0018\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0000H\u0000\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a\u001c\u0010\b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\"2\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00010\t8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0004\u0010\n\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lsdk/pendo/io/i2/f;", "", "", "", "a", "Lsdk/pendo/io/l2/a;", "json", "name", "b", "Lsdk/pendo/io/m2/f$a;", "Lsdk/pendo/io/m2/f$a;", "getJsonAlternativeNamesKey", "()Lkotlinx/serialization/json/internal/DescriptorSchemaCache$Key;", "getJsonAlternativeNamesKey$annotations", "()V", "JsonAlternativeNamesKey", "kotlinx-serialization-json"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    private static final f.a<Map<String, Integer>> f1380a = new f.a<>();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* synthetic */ class a extends FunctionReferenceImpl implements Function0<Map<String, ? extends Integer>> {
        a(Object obj) {
            super(0, obj, l.class, "buildAlternativeNamesMap", "buildAlternativeNamesMap(Lkotlinx/serialization/descriptors/SerialDescriptor;)Ljava/util/Map;", 1);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map<String, Integer> invoke() {
            return l.a((sdk.pendo.io.i2.f) this.receiver);
        }
    }

    public static final Map<String, Integer> a(sdk.pendo.io.i2.f fVar) {
        String[] names;
        Intrinsics.checkNotNullParameter(fVar, "<this>");
        int elementsCount = fVar.getElementsCount();
        Map<String, Integer> map = null;
        int i = 0;
        while (i < elementsCount) {
            int i2 = i + 1;
            List<Annotation> b = fVar.b(i);
            ArrayList arrayList = new ArrayList();
            for (Object obj : b) {
                if (obj instanceof sdk.pendo.io.l2.p) {
                    arrayList.add(obj);
                }
            }
            sdk.pendo.io.l2.p pVar = (sdk.pendo.io.l2.p) CollectionsKt.singleOrNull((List) arrayList);
            if (pVar != null && (names = pVar.names()) != null) {
                int length = names.length;
                int i3 = 0;
                while (i3 < length) {
                    String str = names[i3];
                    i3++;
                    if (map == null) {
                        map = e.a(fVar.getElementsCount());
                    }
                    Intrinsics.checkNotNull(map);
                    a(map, fVar, str, i);
                }
            }
            i = i2;
        }
        return map == null ? MapsKt.emptyMap() : map;
    }

    public static final int b(sdk.pendo.io.i2.f fVar, sdk.pendo.io.l2.a json, String name) {
        Intrinsics.checkNotNullParameter(fVar, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(name, "name");
        int a2 = a(fVar, json, name);
        if (a2 != -3) {
            return a2;
        }
        throw new sdk.pendo.io.g2.f(fVar.getSerialName() + " does not contain element with name '" + name + '\'');
    }

    private static final void a(Map<String, Integer> map, sdk.pendo.io.i2.f fVar, String str, int i) {
        if (map.containsKey(str)) {
            throw new j("The suggested name '" + str + "' for property " + fVar.a(i) + " is already one of the names for property " + fVar.a(((Number) MapsKt.getValue(map, str)).intValue()) + " in " + fVar);
        }
        map.put(str, Integer.valueOf(i));
    }

    public static final f.a<Map<String, Integer>> a() {
        return f1380a;
    }

    public static final int a(sdk.pendo.io.i2.f fVar, sdk.pendo.io.l2.a json, String name) {
        Intrinsics.checkNotNullParameter(fVar, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(name, "name");
        int a2 = fVar.a(name);
        if (a2 != -3 || !json.getConfiguration().getUseAlternativeNames()) {
            return a2;
        }
        Integer num = (Integer) ((Map) sdk.pendo.io.l2.w.a(json).a(fVar, (f.a) f1380a, (Function0) new a(fVar))).get(name);
        if (num == null) {
            return -3;
        }
        return num.intValue();
    }
}
