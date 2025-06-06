package expo.modules.kotlin.records;

import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.full.KClassifiers;

/* compiled from: ValidationBinder.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lexpo/modules/kotlin/records/SizeBinder;", "Lexpo/modules/kotlin/records/ValidationBinder;", "()V", "bind", "Lexpo/modules/kotlin/records/FieldValidator;", "annotation", "", "fieldType", "Lkotlin/reflect/KType;", "expo-modules-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SizeBinder implements ValidationBinder {
    @Override // expo.modules.kotlin.records.ValidationBinder
    public FieldValidator<?> bind(Annotation annotation, KType fieldType) {
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        Intrinsics.checkNotNullParameter(fieldType, "fieldType");
        Size size = (Size) annotation;
        if (Intrinsics.areEqual(fieldType, KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(int[].class), null, false, null, 7, null))) {
            return new IntArraySizeValidator(size.min(), size.max());
        }
        if (Intrinsics.areEqual(fieldType, KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(double[].class), null, false, null, 7, null))) {
            return new DoubleArraySizeValidator(size.min(), size.max());
        }
        if (Intrinsics.areEqual(fieldType, KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(float[].class), null, false, null, 7, null))) {
            return new FloatArraySizeValidator(size.min(), size.max());
        }
        KClassifier classifier = fieldType.getClassifier();
        Intrinsics.checkNotNull(classifier, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
        KClass kClass = (KClass) classifier;
        if (KClasses.isSubclassOf(kClass, Reflection.getOrCreateKotlinClass(String.class))) {
            return new StringSizeValidator(size.min(), size.max());
        }
        if (KClasses.isSubclassOf(kClass, Reflection.getOrCreateKotlinClass(Object[].class)) || JvmClassMappingKt.getJavaClass(kClass).isArray()) {
            return new ArraySizeValidator(size.min(), size.max());
        }
        return new CollectionSizeValidator(size.min(), size.max());
    }
}
