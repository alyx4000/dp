package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: flexibleTypes.kt */
/* loaded from: classes2.dex */
public final class FlexibleTypesKt {
    public static final boolean isFlexible(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return kotlinType.unwrap() instanceof FlexibleType;
    }

    public static final FlexibleType asFlexibleType(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        UnwrappedType unwrap = kotlinType.unwrap();
        Intrinsics.checkNotNull(unwrap, "null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
        return (FlexibleType) unwrap;
    }

    public static final SimpleType lowerIfFlexible(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        UnwrappedType unwrap = kotlinType.unwrap();
        if (unwrap instanceof FlexibleType) {
            return ((FlexibleType) unwrap).getLowerBound();
        }
        if (unwrap instanceof SimpleType) {
            return (SimpleType) unwrap;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final SimpleType upperIfFlexible(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        UnwrappedType unwrap = kotlinType.unwrap();
        if (unwrap instanceof FlexibleType) {
            return ((FlexibleType) unwrap).getUpperBound();
        }
        if (unwrap instanceof SimpleType) {
            return (SimpleType) unwrap;
        }
        throw new NoWhenBranchMatchedException();
    }
}
