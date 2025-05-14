package sdk.pendo.io.l2;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000V\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\u001a\u0010\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\u0014\u0010\u0003\u001a\u00020\u0006*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0000H\u0002\u001a\u0017\u0010\b\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\t\"\u0015\u0010\f\u001a\u00020\u0007*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u0007*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u0017\u0010\u0012\u001a\u0004\u0018\u00010\u0000*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\"\u0015\u0010\u0016\u001a\u00020\u0013*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\"\u0017\u0010\u0019\u001a\u0004\u0018\u00010\u0013*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\"\u0015\u0010\u001d\u001a\u00020\u001a*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"\u0017\u0010 \u001a\u0004\u0018\u00010\u001a*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\"\u0015\u0010$\u001a\u00020!*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\"\u0010#\"\u0017\u0010'\u001a\u0004\u0018\u00010!*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b%\u0010&\"\u0015\u0010+\u001a\u00020(*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b)\u0010*\"\u0015\u0010/\u001a\u00020,*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b-\u0010.\"\u0015\u00103\u001a\u000200*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b1\u00102\"\u0015\u00106\u001a\u00020\u0002*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b4\u00105\"\u0015\u0010:\u001a\u000207*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b8\u00109\"\u0017\u0010=\u001a\u0004\u0018\u000107*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b;\u0010<¨\u0006>"}, d2 = {"", "value", "Lsdk/pendo/io/l2/u;", "a", "Lsdk/pendo/io/l2/h;", "element", "", "", "JsonPrimitive", "(Ljava/lang/Boolean;)Lkotlinx/serialization/json/JsonPrimitive;", "getBoolean", "(Lkotlinx/serialization/json/JsonPrimitive;)Z", "boolean", "getBooleanOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/Boolean;", "booleanOrNull", "getContentOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/String;", "contentOrNull", "", "getDouble", "(Lkotlinx/serialization/json/JsonPrimitive;)D", "double", "getDoubleOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/Double;", "doubleOrNull", "", "getFloat", "(Lkotlinx/serialization/json/JsonPrimitive;)F", "float", "getFloatOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/Float;", "floatOrNull", "", "getInt", "(Lkotlinx/serialization/json/JsonPrimitive;)I", "int", "getIntOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/Integer;", "intOrNull", "Lsdk/pendo/io/l2/b;", "getJsonArray", "(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonArray;", "jsonArray", "Lsdk/pendo/io/l2/q;", "getJsonNull", "(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonNull;", "jsonNull", "Lsdk/pendo/io/l2/s;", "getJsonObject", "(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonObject;", "jsonObject", "getJsonPrimitive", "(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonPrimitive;", "jsonPrimitive", "", "getLong", "(Lkotlinx/serialization/json/JsonPrimitive;)J", "long", "getLongOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/Long;", "longOrNull", "kotlinx-serialization-json"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class i {
    public static final u a(String str) {
        return str == null ? q.INSTANCE : new n(str, true);
    }

    public static final String b(u uVar) {
        Intrinsics.checkNotNullParameter(uVar, "<this>");
        if (uVar instanceof q) {
            return null;
        }
        return uVar.getContent();
    }

    public static final double c(u uVar) {
        Intrinsics.checkNotNullParameter(uVar, "<this>");
        return Double.parseDouble(uVar.getContent());
    }

    public static final float d(u uVar) {
        Intrinsics.checkNotNullParameter(uVar, "<this>");
        return Float.parseFloat(uVar.getContent());
    }

    public static final int e(u uVar) {
        Intrinsics.checkNotNullParameter(uVar, "<this>");
        return Integer.parseInt(uVar.getContent());
    }

    public static final long f(u uVar) {
        Intrinsics.checkNotNullParameter(uVar, "<this>");
        return Long.parseLong(uVar.getContent());
    }

    private static final Void a(h hVar, String str) {
        throw new IllegalArgumentException("Element " + Reflection.getOrCreateKotlinClass(hVar.getClass()) + " is not a " + str);
    }

    public static final Boolean a(u uVar) {
        Intrinsics.checkNotNullParameter(uVar, "<this>");
        return sdk.pendo.io.m2.v.a(uVar.getContent());
    }

    public static final u a(h hVar) {
        Intrinsics.checkNotNullParameter(hVar, "<this>");
        u uVar = hVar instanceof u ? (u) hVar : null;
        if (uVar != null) {
            return uVar;
        }
        a(hVar, "JsonPrimitive");
        throw new KotlinNothingValueException();
    }
}
