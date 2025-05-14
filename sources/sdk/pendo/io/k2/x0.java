package sdk.pendo.io.k2;

import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.ShortCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\u001a\f\u0010\u0005\u001a\u00020\u0000*\u00020\u0000H\u0002\"6\u0010\u000f\u001a\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\u000b0\b8\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0005\u0010\f\u0012\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"", "serialName", "Lsdk/pendo/io/i2/e;", "kind", "Lsdk/pendo/io/i2/f;", "a", "", "b", "", "Lkotlin/reflect/KClass;", "", "Lsdk/pendo/io/g2/b;", "Ljava/util/Map;", "getBUILTIN_SERIALIZERS$annotations", "()V", "BUILTIN_SERIALIZERS", "kotlinx-serialization-core"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class x0 {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<KClass<? extends Object>, sdk.pendo.io.g2.b<? extends Object>> f1281a = MapsKt.mapOf(TuplesKt.to(Reflection.getOrCreateKotlinClass(String.class), sdk.pendo.io.h2.a.a(StringCompanionObject.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(Character.TYPE), sdk.pendo.io.h2.a.a(CharCompanionObject.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(char[].class), sdk.pendo.io.h2.a.c()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Double.TYPE), sdk.pendo.io.h2.a.a(DoubleCompanionObject.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(double[].class), sdk.pendo.io.h2.a.d()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Float.TYPE), sdk.pendo.io.h2.a.a(FloatCompanionObject.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(float[].class), sdk.pendo.io.h2.a.e()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Long.TYPE), sdk.pendo.io.h2.a.a(LongCompanionObject.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(long[].class), sdk.pendo.io.h2.a.g()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Integer.TYPE), sdk.pendo.io.h2.a.a(IntCompanionObject.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(int[].class), sdk.pendo.io.h2.a.f()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Short.TYPE), sdk.pendo.io.h2.a.a(ShortCompanionObject.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(short[].class), sdk.pendo.io.h2.a.h()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Byte.TYPE), sdk.pendo.io.h2.a.a(ByteCompanionObject.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(byte[].class), sdk.pendo.io.h2.a.b()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Boolean.TYPE), sdk.pendo.io.h2.a.a(BooleanCompanionObject.INSTANCE)), TuplesKt.to(Reflection.getOrCreateKotlinClass(boolean[].class), sdk.pendo.io.h2.a.a()), TuplesKt.to(Reflection.getOrCreateKotlinClass(Unit.class), sdk.pendo.io.h2.a.a(Unit.INSTANCE)));

    public static final sdk.pendo.io.i2.f a(String serialName, sdk.pendo.io.i2.e kind) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(kind, "kind");
        b(serialName);
        return new w0(serialName, kind);
    }

    private static final void b(String str) {
        Iterator<KClass<? extends Object>> it = f1281a.keySet().iterator();
        while (it.hasNext()) {
            String simpleName = it.next().getSimpleName();
            Intrinsics.checkNotNull(simpleName);
            String a2 = a(simpleName);
            if (StringsKt.equals(str, Intrinsics.stringPlus("kotlin.", a2), true) || StringsKt.equals(str, a2, true)) {
                throw new IllegalArgumentException(StringsKt.trimIndent("\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name " + str + " there already exist " + a(a2) + "Serializer.\n                Please refer to SerialDescriptor documentation for additional information.\n            "));
            }
        }
    }

    private static final String a(String str) {
        if (!(str.length() > 0)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char charAt = str.charAt(0);
        StringBuilder append = sb.append((Object) (Character.isLowerCase(charAt) ? CharsKt.titlecase(charAt) : String.valueOf(charAt)));
        String substring = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return append.append(substring).toString();
    }
}
