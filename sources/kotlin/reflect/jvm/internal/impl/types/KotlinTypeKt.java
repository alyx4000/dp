package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;

/* compiled from: KotlinType.kt */
/* loaded from: classes2.dex */
public final class KotlinTypeKt {
    public static final boolean isNullable(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return TypeUtils.isNullableType(kotlinType);
    }

    public static final boolean isError(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        UnwrappedType unwrap = kotlinType.unwrap();
        return (unwrap instanceof ErrorType) || ((unwrap instanceof FlexibleType) && (((FlexibleType) unwrap).getDelegate() instanceof ErrorType));
    }
}
