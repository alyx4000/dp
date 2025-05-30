package com.squareup.kotlinpoet.jvm;

import com.squareup.kotlinpoet.AnnotationSpec;
import com.squareup.kotlinpoet.FileSpec;
import com.squareup.kotlinpoet.FunSpec;
import com.squareup.kotlinpoet.PropertySpec;
import com.squareup.kotlinpoet.TypeName;
import com.squareup.kotlinpoet.TypeNames;
import com.squareup.kotlinpoet.TypeSpec;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmDefault;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmInline;
import kotlin.jvm.JvmMultifileClass;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmRecord;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.JvmSuppressWildcards;
import kotlin.jvm.JvmWildcard;
import kotlin.jvm.Strictfp;
import kotlin.jvm.Synchronized;
import kotlin.jvm.Throws;
import kotlin.jvm.Transient;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: JvmAnnotations.kt */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0005H\u0007\u001a\f\u0010\u0004\u001a\u00020\u0006*\u00020\u0006H\u0007\u001a\n\u0010\u0007\u001a\u00020\u0006*\u00020\u0006\u001a\n\u0010\b\u001a\u00020\t*\u00020\t\u001a\n\u0010\n\u001a\u00020\u000b*\u00020\u000b\u001a\u0012\u0010\f\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e\u001a\u0012\u0010\f\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e\u001a\n\u0010\u000f\u001a\u00020\u0005*\u00020\u0005\u001a\n\u0010\u0010\u001a\u00020\t*\u00020\t\u001a\n\u0010\u0011\u001a\u00020\u0005*\u00020\u0005\u001a\n\u0010\u0011\u001a\u00020\u0006*\u00020\u0006\u001a\u0014\u0010\u0012\u001a\u00020\u0005*\u00020\u00052\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a\u0014\u0010\u0012\u001a\u00020\u0006*\u00020\u00062\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a\u0014\u0010\u0012\u001a\u00020\u0013*\u00020\u00132\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a\u0014\u0010\u0012\u001a\u00020\t*\u00020\t2\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a\n\u0010\u0014\u001a\u00020\u0013*\u00020\u0013\u001a\n\u0010\u0015\u001a\u00020\u0005*\u00020\u0005\u001a\n\u0010\u0016\u001a\u00020\u0005*\u00020\u0005\u001a#\u0010\u0017\u001a\u00020\u0005*\u00020\u00052\u0012\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0019\"\u00020\u0013¢\u0006\u0002\u0010\u001a\u001a#\u0010\u0017\u001a\u00020\u0005*\u00020\u00052\u0012\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001b0\u0019\"\u00020\u001b¢\u0006\u0002\u0010\u001c\u001a3\u0010\u0017\u001a\u00020\u0005*\u00020\u00052\"\u0010\u0018\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001e0\u001d0\u0019\"\n\u0012\u0006\b\u0001\u0012\u00020\u001e0\u001d¢\u0006\u0002\u0010\u001f\u001a\u0018\u0010\u0017\u001a\u00020\u0005*\u00020\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130 \u001a\n\u0010!\u001a\u00020\u0006*\u00020\u0006\u001a\n\u0010\"\u001a\u00020\u0006*\u00020\u0006¨\u0006#"}, d2 = {"jvmSuppressWildcardsAnnotation", "Lcom/squareup/kotlinpoet/AnnotationSpec;", "suppress", "", "jvmDefault", "Lcom/squareup/kotlinpoet/FunSpec$Builder;", "Lcom/squareup/kotlinpoet/PropertySpec$Builder;", "jvmField", "jvmInline", "Lcom/squareup/kotlinpoet/TypeSpec$Builder;", "jvmMultifileClass", "Lcom/squareup/kotlinpoet/FileSpec$Builder;", "jvmName", "name", "", "jvmOverloads", "jvmRecord", "jvmStatic", "jvmSuppressWildcards", "Lcom/squareup/kotlinpoet/TypeName;", "jvmWildcard", "strictfp", "synchronized", "throws", "exceptionClasses", "", "(Lcom/squareup/kotlinpoet/FunSpec$Builder;[Lcom/squareup/kotlinpoet/TypeName;)Lcom/squareup/kotlinpoet/FunSpec$Builder;", "Ljava/lang/reflect/Type;", "(Lcom/squareup/kotlinpoet/FunSpec$Builder;[Ljava/lang/reflect/Type;)Lcom/squareup/kotlinpoet/FunSpec$Builder;", "Lkotlin/reflect/KClass;", "", "(Lcom/squareup/kotlinpoet/FunSpec$Builder;[Lkotlin/reflect/KClass;)Lcom/squareup/kotlinpoet/FunSpec$Builder;", "", "transient", "volatile", "kotlinpoet"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class JvmAnnotations {
    public static final FileSpec.Builder jvmName(FileSpec.Builder builder, String name) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        return builder.addAnnotation(AnnotationSpec.INSTANCE.builder(Reflection.getOrCreateKotlinClass(JvmName.class)).useSiteTarget(AnnotationSpec.UseSiteTarget.FILE).addMember("%S", name).build());
    }

    public static final FileSpec.Builder jvmMultifileClass(FileSpec.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return builder.addAnnotation(AnnotationSpec.INSTANCE.builder(Reflection.getOrCreateKotlinClass(JvmMultifileClass.class)).useSiteTarget(AnnotationSpec.UseSiteTarget.FILE).build());
    }

    public static /* synthetic */ TypeSpec.Builder jvmSuppressWildcards$default(TypeSpec.Builder builder, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return jvmSuppressWildcards(builder, z);
    }

    public static final TypeSpec.Builder jvmSuppressWildcards(TypeSpec.Builder builder, boolean z) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return builder.addAnnotation(jvmSuppressWildcardsAnnotation(z));
    }

    static /* synthetic */ AnnotationSpec jvmSuppressWildcardsAnnotation$default(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return jvmSuppressWildcardsAnnotation(z);
    }

    private static final AnnotationSpec jvmSuppressWildcardsAnnotation(boolean z) {
        AnnotationSpec.Builder builder = AnnotationSpec.INSTANCE.builder(Reflection.getOrCreateKotlinClass(JvmSuppressWildcards.class));
        if (!z) {
            builder.addMember("suppress = false", new Object[0]);
        }
        return builder.build();
    }

    public static final TypeSpec.Builder jvmInline(TypeSpec.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return builder.addAnnotation(Reflection.getOrCreateKotlinClass(JvmInline.class));
    }

    public static final TypeSpec.Builder jvmRecord(TypeSpec.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return builder.addAnnotation(Reflection.getOrCreateKotlinClass(JvmRecord.class));
    }

    public static final FunSpec.Builder jvmStatic(FunSpec.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        if (!(!FunSpec.INSTANCE.isConstructor$kotlinpoet(builder.getName()))) {
            throw new IllegalStateException("Can't apply @JvmStatic to a constructor!".toString());
        }
        builder.addAnnotation(Reflection.getOrCreateKotlinClass(JvmStatic.class));
        return builder;
    }

    public static final FunSpec.Builder jvmOverloads(FunSpec.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        if (!(!FunSpec.INSTANCE.isAccessor$kotlinpoet(builder.getName()))) {
            throw new IllegalStateException("Can't apply @JvmOverloads to a ".concat(Intrinsics.areEqual(builder.getName(), FunSpec.GETTER) ? "getter!" : "setter!").toString());
        }
        builder.addAnnotation(Reflection.getOrCreateKotlinClass(JvmOverloads.class));
        return builder;
    }

    public static final FunSpec.Builder jvmName(FunSpec.Builder builder, String name) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        if (!(!FunSpec.INSTANCE.isConstructor$kotlinpoet(builder.getName()))) {
            throw new IllegalStateException("Can't apply @JvmName to a constructor!".toString());
        }
        builder.addAnnotation(AnnotationSpec.INSTANCE.builder(Reflection.getOrCreateKotlinClass(JvmName.class)).addMember("%S", name).build());
        return builder;
    }

    /* renamed from: throws, reason: not valid java name */
    public static final FunSpec.Builder m971throws(FunSpec.Builder builder, TypeName... exceptionClasses) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(exceptionClasses, "exceptionClasses");
        return m970throws(builder, ArraysKt.toList(exceptionClasses));
    }

    /* renamed from: throws, reason: not valid java name */
    public static final FunSpec.Builder m970throws(FunSpec.Builder builder, Iterable<? extends TypeName> exceptionClasses) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(exceptionClasses, "exceptionClasses");
        AnnotationSpec.Builder builder2 = AnnotationSpec.INSTANCE.builder(Reflection.getOrCreateKotlinClass(Throws.class));
        Iterator<? extends TypeName> it = exceptionClasses.iterator();
        while (it.hasNext()) {
            builder2.addMember("%T::class", it.next());
        }
        return builder.addAnnotation(builder2.build());
    }

    public static /* synthetic */ FunSpec.Builder jvmSuppressWildcards$default(FunSpec.Builder builder, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return jvmSuppressWildcards(builder, z);
    }

    public static final FunSpec.Builder jvmSuppressWildcards(FunSpec.Builder builder, boolean z) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        if (!(!FunSpec.INSTANCE.isConstructor$kotlinpoet(builder.getName()))) {
            throw new IllegalStateException("Can't apply @JvmSuppressWildcards to a constructor!".toString());
        }
        if (!(!FunSpec.INSTANCE.isAccessor$kotlinpoet(builder.getName()))) {
            throw new IllegalStateException("Can't apply @JvmSuppressWildcards to a ".concat(Intrinsics.areEqual(builder.getName(), FunSpec.GETTER) ? "getter!" : "setter!").toString());
        }
        builder.addAnnotation(jvmSuppressWildcardsAnnotation(z));
        return builder;
    }

    /* renamed from: synchronized, reason: not valid java name */
    public static final FunSpec.Builder m969synchronized(FunSpec.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        if (!(!FunSpec.INSTANCE.isConstructor$kotlinpoet(builder.getName()))) {
            throw new IllegalStateException("Can't apply @Synchronized to a constructor!".toString());
        }
        builder.addAnnotation(Reflection.getOrCreateKotlinClass(Synchronized.class));
        return builder;
    }

    /* renamed from: strictfp, reason: not valid java name */
    public static final FunSpec.Builder m968strictfp(FunSpec.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return builder.addAnnotation(Reflection.getOrCreateKotlinClass(Strictfp.class));
    }

    public static final PropertySpec.Builder jvmField(PropertySpec.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return builder.addAnnotation(Reflection.getOrCreateKotlinClass(JvmField.class));
    }

    public static final PropertySpec.Builder jvmStatic(PropertySpec.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return builder.addAnnotation(Reflection.getOrCreateKotlinClass(JvmStatic.class));
    }

    public static /* synthetic */ PropertySpec.Builder jvmSuppressWildcards$default(PropertySpec.Builder builder, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return jvmSuppressWildcards(builder, z);
    }

    public static final PropertySpec.Builder jvmSuppressWildcards(PropertySpec.Builder builder, boolean z) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return builder.addAnnotation(jvmSuppressWildcardsAnnotation(z));
    }

    /* renamed from: transient, reason: not valid java name */
    public static final PropertySpec.Builder m974transient(PropertySpec.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return builder.addAnnotation(Reflection.getOrCreateKotlinClass(Transient.class));
    }

    /* renamed from: volatile, reason: not valid java name */
    public static final PropertySpec.Builder m975volatile(PropertySpec.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return builder.addAnnotation(Reflection.getOrCreateKotlinClass(Volatile.class));
    }

    public static /* synthetic */ TypeName jvmSuppressWildcards$default(TypeName typeName, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return jvmSuppressWildcards(typeName, z);
    }

    public static final TypeName jvmSuppressWildcards(TypeName typeName, boolean z) {
        Intrinsics.checkNotNullParameter(typeName, "<this>");
        return TypeName.copy$default(typeName, false, CollectionsKt.plus((Collection<? extends AnnotationSpec>) typeName.getAnnotations(), jvmSuppressWildcardsAnnotation(z)), 1, null);
    }

    public static final TypeName jvmWildcard(TypeName typeName) {
        Intrinsics.checkNotNullParameter(typeName, "<this>");
        return TypeName.copy$default(typeName, false, CollectionsKt.plus((Collection<? extends AnnotationSpec>) typeName.getAnnotations(), AnnotationSpec.INSTANCE.builder(Reflection.getOrCreateKotlinClass(JvmWildcard.class)).build()), 1, null);
    }

    @Deprecated(message = "'JvmDefault' is deprecated. Switch to new -Xjvm-default modes: `all` or `all-compatibility`")
    public static final PropertySpec.Builder jvmDefault(PropertySpec.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return builder.addAnnotation(Reflection.getOrCreateKotlinClass(JvmDefault.class));
    }

    @Deprecated(message = "'JvmDefault' is deprecated. Switch to new -Xjvm-default modes: `all` or `all-compatibility`")
    public static final FunSpec.Builder jvmDefault(FunSpec.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return builder.addAnnotation(Reflection.getOrCreateKotlinClass(JvmDefault.class));
    }

    /* renamed from: throws, reason: not valid java name */
    public static final FunSpec.Builder m973throws(FunSpec.Builder builder, KClass<? extends Throwable>... exceptionClasses) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(exceptionClasses, "exceptionClasses");
        ArrayList arrayList = new ArrayList(exceptionClasses.length);
        for (KClass<? extends Throwable> kClass : exceptionClasses) {
            arrayList.add(TypeNames.get(kClass));
        }
        return m970throws(builder, arrayList);
    }

    /* renamed from: throws, reason: not valid java name */
    public static final FunSpec.Builder m972throws(FunSpec.Builder builder, Type... exceptionClasses) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(exceptionClasses, "exceptionClasses");
        ArrayList arrayList = new ArrayList(exceptionClasses.length);
        for (Type type : exceptionClasses) {
            arrayList.add(TypeNames.get(type));
        }
        return m970throws(builder, arrayList);
    }
}
