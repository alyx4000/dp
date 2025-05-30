package com.squareup.moshi;

import androidx.exifinterface.media.ExifInterface;
import com.squareup.moshi.internal.Util;
import java.lang.annotation.Annotation;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;

/* compiled from: -MoshiKotlinTypesExtensions.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u001b\n\u0000\u001a\u0011\u0010\u0005\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u0007\u0018\u0001H\u0087\b\u001a\u0011\u0010\b\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u0007\u0018\u0001H\u0087\b\u001a\n\u0010\t\u001a\u00020\n*\u00020\u0002\u001a\u000e\u0010\t\u001a\u00020\n*\u0006\u0012\u0002\b\u00030\u000b\u001a\f\u0010\t\u001a\u00020\n*\u00020\fH\u0007\u001a'\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\"\n\b\u0000\u0010\u0007\u0018\u0001*\u00020\u000f*\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0086\b\"\u0019\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0010"}, d2 = {"rawType", "Ljava/lang/Class;", "Ljava/lang/reflect/Type;", "getRawType", "(Ljava/lang/reflect/Type;)Ljava/lang/Class;", "subtypeOf", "Ljava/lang/reflect/WildcardType;", ExifInterface.GPS_DIRECTION_TRUE, "supertypeOf", "asArrayType", "Ljava/lang/reflect/GenericArrayType;", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/KType;", "nextAnnotations", "", "", "moshi"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class _MoshiKotlinTypesExtensionsKt {
    public static final Class<?> getRawType(Type type) {
        Intrinsics.checkNotNullParameter(type, "<this>");
        Class<?> rawType = Types.getRawType(type);
        Intrinsics.checkNotNullExpressionValue(rawType, "getRawType(this)");
        return rawType;
    }

    public static final /* synthetic */ <T extends Annotation> Set<Annotation> nextAnnotations(Set<? extends Annotation> set) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return Types.nextAnnotations(set, Annotation.class);
    }

    public static final /* synthetic */ <T> WildcardType subtypeOf() {
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        Class javaType = TypesJVMKt.getJavaType((KType) null);
        if (javaType instanceof Class) {
            Class boxIfPrimitive = Util.boxIfPrimitive((Class) javaType);
            Intrinsics.checkNotNullExpressionValue(boxIfPrimitive, "boxIfPrimitive(type)");
            javaType = boxIfPrimitive;
        }
        WildcardType subtypeOf = Types.subtypeOf(javaType);
        Intrinsics.checkNotNullExpressionValue(subtypeOf, "subtypeOf(type)");
        return subtypeOf;
    }

    public static final /* synthetic */ <T> WildcardType supertypeOf() {
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        Class javaType = TypesJVMKt.getJavaType((KType) null);
        if (javaType instanceof Class) {
            Class boxIfPrimitive = Util.boxIfPrimitive((Class) javaType);
            Intrinsics.checkNotNullExpressionValue(boxIfPrimitive, "boxIfPrimitive(type)");
            javaType = boxIfPrimitive;
        }
        WildcardType supertypeOf = Types.supertypeOf(javaType);
        Intrinsics.checkNotNullExpressionValue(supertypeOf, "supertypeOf(type)");
        return supertypeOf;
    }

    public static final GenericArrayType asArrayType(KType kType) {
        Intrinsics.checkNotNullParameter(kType, "<this>");
        return asArrayType(TypesJVMKt.getJavaType(kType));
    }

    public static final GenericArrayType asArrayType(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        return asArrayType(JvmClassMappingKt.getJavaClass((KClass) kClass));
    }

    public static final GenericArrayType asArrayType(Type type) {
        Intrinsics.checkNotNullParameter(type, "<this>");
        GenericArrayType arrayOf = Types.arrayOf(type);
        Intrinsics.checkNotNullExpressionValue(arrayOf, "arrayOf(this)");
        return arrayOf;
    }
}
