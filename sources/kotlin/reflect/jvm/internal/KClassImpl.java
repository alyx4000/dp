package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import io.sentry.protocol.ViewHierarchyNode;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KClassImpl.Data;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMappingUtilsKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.text.StringsKt;

/* compiled from: KClassImpl.kt */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u00052\u00020\u0006:\u0001eB\u0013\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\tJ\u0013\u0010T\u001a\u00020&2\b\u0010U\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u0016\u0010V\u001a\b\u0012\u0004\u0012\u00020W0\u00142\u0006\u0010X\u001a\u00020YH\u0016J\u0012\u0010Z\u001a\u0004\u0018\u00010[2\u0006\u0010\\\u001a\u00020]H\u0016J\u0016\u0010^\u001a\b\u0012\u0004\u0012\u00020[0\u00142\u0006\u0010X\u001a\u00020YH\u0016J\b\u0010_\u001a\u00020]H\u0016J\u0012\u0010`\u001a\u00020&2\b\u0010a\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010b\u001a\u00020cH\u0002J\b\u0010d\u001a\u00020AH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00190\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0017R3\u0010\u001b\u001a$\u0012 \u0012\u001e \u001e*\u000e\u0018\u00010\u001dR\b\u0012\u0004\u0012\u00028\u00000\u00000\u001dR\b\u0012\u0004\u0012\u00028\u00000\u00000\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010'R\u0014\u0010(\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010'R\u0014\u0010)\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010'R\u0014\u0010*\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010'R\u0014\u0010+\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010'R\u0014\u0010,\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010'R\u0014\u0010-\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010'R\u0014\u0010.\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010'R\u001a\u0010/\u001a\u00020&8VX\u0096\u0004¢\u0006\f\u0012\u0004\b0\u00101\u001a\u0004\b/\u0010'R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0014\u00104\u001a\u0002058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u001e\u00108\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003090\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010\u0017R\u001e\u0010;\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\u0017R\u0016\u0010=\u001a\u0004\u0018\u00018\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0016\u0010@\u001a\u0004\u0018\u00010A8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\"\u0010D\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00040\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010\u000eR\u0016\u0010F\u001a\u0004\u0018\u00010A8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bG\u0010CR\u0014\u0010H\u001a\u0002058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bI\u00107R\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020K0\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bL\u0010\u000eR\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020N0\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bO\u0010\u000eR\u0016\u0010P\u001a\u0004\u0018\u00010Q8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bR\u0010S¨\u0006f"}, d2 = {"Lkotlin/reflect/jvm/internal/KClassImpl;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "constructors", "Lkotlin/reflect/KFunction;", "getConstructors", "data", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "kotlin.jvm.PlatformType", "getData", "()Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "isAbstract", "", "()Z", "isCompanion", "isData", "isFinal", "isFun", "isInner", "isOpen", "isSealed", "isValue", "isValue$annotations", "()V", "getJClass", "()Ljava/lang/Class;", "memberScope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getMemberScope$kotlin_reflection", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "getSealedSubclasses", "simpleName", "getSimpleName", "staticScope", "getStaticScope$kotlin_reflection", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", ViewHierarchyNode.JsonKeys.VISIBILITY, "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "index", "", "getProperties", "hashCode", "isInstance", "value", "reportUnresolvedClass", "", "toString", "Data", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class KClassImpl<T> extends KDeclarationContainerImpl implements KClass<T>, KClassifierImpl, KTypeParameterOwnerImpl {
    private final ReflectProperties.LazyVal<KClassImpl<T>.Data> data;
    private final Class<T> jClass;

    /* compiled from: KClassImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KotlinClassHeader.Kind.values().length];
            try {
                iArr[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[KotlinClassHeader.Kind.SYNTHETIC_CLASS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[KotlinClassHeader.Kind.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[KotlinClassHeader.Kind.CLASS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public Class<T> getJClass() {
        return this.jClass;
    }

    /* compiled from: KClassImpl.kt */
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010N\u001a\u00020<2\n\u0010O\u001a\u0006\u0012\u0002\b\u00030PH\u0002R%\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR%\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\bR%\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000f\u0010\bR!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0014\u0010\u0015R-\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00180\u00058FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\n\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\bR%\u0010\u001d\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\n\u001a\u0004\b\u001e\u0010\bR%\u0010 \u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\n\u001a\u0004\b!\u0010\bR%\u0010#\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\n\u001a\u0004\b$\u0010\bR\u001b\u0010&\u001a\u00020'8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\n\u001a\u0004\b(\u0010)R%\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\n\u001a\u0004\b,\u0010\bR%\u0010.\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\n\u001a\u0004\b/\u0010\bR%\u00101\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\n\u001a\u0004\b3\u0010\bR#\u00105\u001a\u0004\u0018\u00018\u00008FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b9\u0010:\u0012\u0004\b6\u0010\u001a\u001a\u0004\b7\u00108R\u001d\u0010;\u001a\u0004\u0018\u00010<8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\n\u001a\u0004\b=\u0010>R)\u0010@\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u0000020\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\n\u001a\u0004\bA\u0010\u0015R\u001d\u0010C\u001a\u0004\u0018\u00010<8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\n\u001a\u0004\bD\u0010>R!\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bI\u0010\n\u001a\u0004\bH\u0010\u0015R!\u0010J\u001a\b\u0012\u0004\u0012\u00020K0\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\n\u001a\u0004\bL\u0010\u0015¨\u0006Q"}, d2 = {"Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "(Lkotlin/reflect/jvm/internal/KClassImpl;)V", "allMembers", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getAllMembers", "()Ljava/util/Collection;", "allMembers$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "allNonStaticMembers", "getAllNonStaticMembers", "allNonStaticMembers$delegate", "allStaticMembers", "getAllStaticMembers", "allStaticMembers$delegate", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "constructors", "Lkotlin/reflect/KFunction;", "getConstructors$annotations", "()V", "getConstructors", "constructors$delegate", "declaredMembers", "getDeclaredMembers", "declaredMembers$delegate", "declaredNonStaticMembers", "getDeclaredNonStaticMembers", "declaredNonStaticMembers$delegate", "declaredStaticMembers", "getDeclaredStaticMembers", "declaredStaticMembers$delegate", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor$delegate", "inheritedNonStaticMembers", "getInheritedNonStaticMembers", "inheritedNonStaticMembers$delegate", "inheritedStaticMembers", "getInheritedStaticMembers", "inheritedStaticMembers$delegate", "nestedClasses", "Lkotlin/reflect/KClass;", "getNestedClasses", "nestedClasses$delegate", "objectInstance", "getObjectInstance$annotations", "getObjectInstance", "()Ljava/lang/Object;", "objectInstance$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "qualifiedName$delegate", "sealedSubclasses", "getSealedSubclasses", "sealedSubclasses$delegate", "simpleName", "getSimpleName", "simpleName$delegate", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "supertypes$delegate", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "typeParameters$delegate", "calculateLocalClassName", "jClass", "Ljava/lang/Class;", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class Data extends KDeclarationContainerImpl.Data {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "annotations", "getAnnotations()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "simpleName", "getSimpleName()Ljava/lang/String;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "qualifiedName", "getQualifiedName()Ljava/lang/String;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "constructors", "getConstructors()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "nestedClasses", "getNestedClasses()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "objectInstance", "getObjectInstance()Ljava/lang/Object;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "typeParameters", "getTypeParameters()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "supertypes", "getSupertypes()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Data.class), "allMembers", "getAllMembers()Ljava/util/Collection;"))};

        /* renamed from: allMembers$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal allMembers;

        /* renamed from: allNonStaticMembers$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal allNonStaticMembers;

        /* renamed from: allStaticMembers$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal allStaticMembers;

        /* renamed from: annotations$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal annotations;

        /* renamed from: constructors$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal constructors;

        /* renamed from: declaredMembers$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal declaredMembers;

        /* renamed from: declaredNonStaticMembers$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal declaredNonStaticMembers;

        /* renamed from: declaredStaticMembers$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal declaredStaticMembers;

        /* renamed from: descriptor$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal descriptor;

        /* renamed from: inheritedNonStaticMembers$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal inheritedNonStaticMembers;

        /* renamed from: inheritedStaticMembers$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal inheritedStaticMembers;

        /* renamed from: nestedClasses$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal nestedClasses;

        /* renamed from: objectInstance$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazyVal objectInstance;

        /* renamed from: qualifiedName$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal qualifiedName;

        /* renamed from: sealedSubclasses$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal sealedSubclasses;

        /* renamed from: simpleName$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal simpleName;

        /* renamed from: supertypes$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal supertypes;

        /* renamed from: typeParameters$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal typeParameters;

        public Data() {
            super();
            this.descriptor = ReflectProperties.lazySoft(new Function0<ClassDescriptor>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$descriptor$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final ClassDescriptor invoke() {
                    ClassId classId;
                    classId = r1.getClassId();
                    RuntimeModuleData moduleData = ((KClassImpl.Data) r1.getData().invoke()).getModuleData();
                    ClassDescriptor deserializeClass = classId.isLocal() ? moduleData.getDeserialization().deserializeClass(classId) : FindClassInModuleKt.findClassAcrossModuleDependencies(moduleData.getModule(), classId);
                    if (deserializeClass != null) {
                        return deserializeClass;
                    }
                    r1.reportUnresolvedClass();
                    throw null;
                }
            });
            this.annotations = ReflectProperties.lazySoft(new Function0<List<? extends Annotation>>(this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$annotations$2
                final /* synthetic */ KClassImpl<T>.Data this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public final List<? extends Annotation> invoke() {
                    return UtilKt.computeAnnotations(this.this$0.getDescriptor());
                }
            });
            this.simpleName = ReflectProperties.lazySoft(new Function0<String>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$simpleName$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    ClassId classId;
                    String calculateLocalClassName;
                    if (r1.getJClass().isAnonymousClass()) {
                        return null;
                    }
                    classId = r1.getClassId();
                    if (classId.isLocal()) {
                        calculateLocalClassName = this.calculateLocalClassName(r1.getJClass());
                        return calculateLocalClassName;
                    }
                    String asString = classId.getShortClassName().asString();
                    Intrinsics.checkNotNullExpressionValue(asString, "classId.shortClassName.asString()");
                    return asString;
                }
            });
            this.qualifiedName = ReflectProperties.lazySoft(new Function0<String>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$qualifiedName$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    ClassId classId;
                    if (r1.getJClass().isAnonymousClass()) {
                        return null;
                    }
                    classId = r1.getClassId();
                    if (classId.isLocal()) {
                        return null;
                    }
                    return classId.asSingleFqName().asString();
                }
            });
            this.constructors = ReflectProperties.lazySoft(new Function0<List<? extends KFunction<? extends T>>>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$constructors$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final List<KFunction<T>> invoke() {
                    Collection<ConstructorDescriptor> constructorDescriptors = r1.getConstructorDescriptors();
                    KClassImpl<T> kClassImpl = r1;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(constructorDescriptors, 10));
                    Iterator<T> it = constructorDescriptors.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new KFunctionImpl(kClassImpl, (ConstructorDescriptor) it.next()));
                    }
                    return arrayList;
                }
            });
            this.nestedClasses = ReflectProperties.lazySoft(new Function0<List<? extends KClassImpl<? extends Object>>>(this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$nestedClasses$2
                final /* synthetic */ KClassImpl<T>.Data this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public final List<? extends KClassImpl<? extends Object>> invoke() {
                    MemberScope unsubstitutedInnerClassesScope = this.this$0.getDescriptor().getUnsubstitutedInnerClassesScope();
                    Intrinsics.checkNotNullExpressionValue(unsubstitutedInnerClassesScope, "descriptor.unsubstitutedInnerClassesScope");
                    Collection contributedDescriptors$default = ResolutionScope.DefaultImpls.getContributedDescriptors$default(unsubstitutedInnerClassesScope, null, null, 3, null);
                    ArrayList<DeclarationDescriptor> arrayList = new ArrayList();
                    for (Object obj : contributedDescriptors$default) {
                        if (!DescriptorUtils.isEnumEntry((DeclarationDescriptor) obj)) {
                            arrayList.add(obj);
                        }
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (DeclarationDescriptor declarationDescriptor : arrayList) {
                        ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
                        Class<?> javaClass = classDescriptor != null ? UtilKt.toJavaClass(classDescriptor) : null;
                        KClassImpl kClassImpl = javaClass != null ? new KClassImpl(javaClass) : null;
                        if (kClassImpl != null) {
                            arrayList2.add(kClassImpl);
                        }
                    }
                    return arrayList2;
                }
            });
            this.objectInstance = ReflectProperties.lazy(new Function0<T>(this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$objectInstance$2
                final /* synthetic */ KClassImpl<T>.Data this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public final T invoke() {
                    Field declaredField;
                    ClassDescriptor descriptor = this.this$0.getDescriptor();
                    if (descriptor.getKind() != ClassKind.OBJECT) {
                        return null;
                    }
                    if (descriptor.isCompanionObject() && !CompanionObjectMappingUtilsKt.isMappedIntrinsicCompanionObject(CompanionObjectMapping.INSTANCE, descriptor)) {
                        declaredField = r2.getJClass().getEnclosingClass().getDeclaredField(descriptor.getName().asString());
                    } else {
                        declaredField = r2.getJClass().getDeclaredField("INSTANCE");
                    }
                    T t = (T) declaredField.get(null);
                    Intrinsics.checkNotNull(t, "null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.KClassImpl");
                    return t;
                }
            });
            this.typeParameters = ReflectProperties.lazySoft(new Function0<List<? extends KTypeParameterImpl>>(this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$typeParameters$2
                final /* synthetic */ KClassImpl<T>.Data this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public final List<? extends KTypeParameterImpl> invoke() {
                    List<TypeParameterDescriptor> declaredTypeParameters = this.this$0.getDescriptor().getDeclaredTypeParameters();
                    Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "descriptor.declaredTypeParameters");
                    List<TypeParameterDescriptor> list = declaredTypeParameters;
                    KTypeParameterOwnerImpl kTypeParameterOwnerImpl = r2;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    for (TypeParameterDescriptor descriptor : list) {
                        Intrinsics.checkNotNullExpressionValue(descriptor, "descriptor");
                        arrayList.add(new KTypeParameterImpl(kTypeParameterOwnerImpl, descriptor));
                    }
                    return arrayList;
                }
            });
            this.supertypes = ReflectProperties.lazySoft(new Function0<List<? extends KTypeImpl>>(this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$supertypes$2
                final /* synthetic */ KClassImpl<T>.Data this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public final List<? extends KTypeImpl> invoke() {
                    Collection<KotlinType> mo2508getSupertypes = this.this$0.getDescriptor().getTypeConstructor().mo2508getSupertypes();
                    Intrinsics.checkNotNullExpressionValue(mo2508getSupertypes, "descriptor.typeConstructor.supertypes");
                    ArrayList arrayList = new ArrayList(mo2508getSupertypes.size());
                    final KClassImpl<T>.Data data = this.this$0;
                    final KClassImpl<T> kClassImpl = r2;
                    for (final KotlinType kotlinType : mo2508getSupertypes) {
                        Intrinsics.checkNotNullExpressionValue(kotlinType, "kotlinType");
                        arrayList.add(new KTypeImpl(kotlinType, new Function0<Type>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$supertypes$2$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Type invoke() {
                                ClassifierDescriptor mo2507getDeclarationDescriptor = KotlinType.this.getConstructor().mo2507getDeclarationDescriptor();
                                if (!(mo2507getDeclarationDescriptor instanceof ClassDescriptor)) {
                                    throw new KotlinReflectionInternalError("Supertype not a class: " + mo2507getDeclarationDescriptor);
                                }
                                Class<?> javaClass = UtilKt.toJavaClass((ClassDescriptor) mo2507getDeclarationDescriptor);
                                if (javaClass == null) {
                                    throw new KotlinReflectionInternalError("Unsupported superclass of " + data + ": " + mo2507getDeclarationDescriptor);
                                }
                                if (Intrinsics.areEqual(kClassImpl.getJClass().getSuperclass(), javaClass)) {
                                    Type genericSuperclass = kClassImpl.getJClass().getGenericSuperclass();
                                    Intrinsics.checkNotNullExpressionValue(genericSuperclass, "{\n                      …ass\n                    }");
                                    return genericSuperclass;
                                }
                                Class<?>[] interfaces = kClassImpl.getJClass().getInterfaces();
                                Intrinsics.checkNotNullExpressionValue(interfaces, "jClass.interfaces");
                                int indexOf = ArraysKt.indexOf(interfaces, javaClass);
                                if (indexOf < 0) {
                                    throw new KotlinReflectionInternalError("No superclass of " + data + " in Java reflection for " + mo2507getDeclarationDescriptor);
                                }
                                Type type = kClassImpl.getJClass().getGenericInterfaces()[indexOf];
                                Intrinsics.checkNotNullExpressionValue(type, "{\n                      …ex]\n                    }");
                                return type;
                            }
                        }));
                    }
                    ArrayList arrayList2 = arrayList;
                    if (!KotlinBuiltIns.isSpecialClassWithNoSupertypes(this.this$0.getDescriptor())) {
                        ArrayList arrayList3 = arrayList;
                        boolean z = true;
                        if (!(arrayList3 instanceof Collection) || !arrayList3.isEmpty()) {
                            Iterator it = arrayList3.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                ClassKind kind = DescriptorUtils.getClassDescriptorForType(((KTypeImpl) it.next()).getType()).getKind();
                                Intrinsics.checkNotNullExpressionValue(kind, "getClassDescriptorForType(it.type).kind");
                                if (!(kind == ClassKind.INTERFACE || kind == ClassKind.ANNOTATION_CLASS)) {
                                    z = false;
                                    break;
                                }
                            }
                        }
                        if (z) {
                            SimpleType anyType = DescriptorUtilsKt.getBuiltIns(this.this$0.getDescriptor()).getAnyType();
                            Intrinsics.checkNotNullExpressionValue(anyType, "descriptor.builtIns.anyType");
                            arrayList2.add(new KTypeImpl(anyType, new Function0<Type>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$supertypes$2.3
                                @Override // kotlin.jvm.functions.Function0
                                public final Type invoke() {
                                    return Object.class;
                                }
                            }));
                        }
                    }
                    return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(arrayList);
                }
            });
            this.sealedSubclasses = ReflectProperties.lazySoft(new Function0<List<? extends KClassImpl<? extends T>>>(this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$sealedSubclasses$2
                final /* synthetic */ KClassImpl<T>.Data this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public final List<KClassImpl<? extends T>> invoke() {
                    Collection<ClassDescriptor> sealedSubclasses = this.this$0.getDescriptor().getSealedSubclasses();
                    Intrinsics.checkNotNullExpressionValue(sealedSubclasses, "descriptor.sealedSubclasses");
                    ArrayList arrayList = new ArrayList();
                    for (ClassDescriptor classDescriptor : sealedSubclasses) {
                        Intrinsics.checkNotNull(classDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                        Class<?> javaClass = UtilKt.toJavaClass(classDescriptor);
                        KClassImpl kClassImpl = javaClass != null ? new KClassImpl(javaClass) : null;
                        if (kClassImpl != null) {
                            arrayList.add(kClassImpl);
                        }
                    }
                    return arrayList;
                }
            });
            this.declaredNonStaticMembers = ReflectProperties.lazySoft(new Function0<Collection<? extends KCallableImpl<?>>>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$declaredNonStaticMembers$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Collection<? extends KCallableImpl<?>> invoke() {
                    KClassImpl<T> kClassImpl = r1;
                    return kClassImpl.getMembers(kClassImpl.getMemberScope$kotlin_reflection(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
                }
            });
            this.declaredStaticMembers = ReflectProperties.lazySoft(new Function0<Collection<? extends KCallableImpl<?>>>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$declaredStaticMembers$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Collection<? extends KCallableImpl<?>> invoke() {
                    KClassImpl<T> kClassImpl = r1;
                    return kClassImpl.getMembers(kClassImpl.getStaticScope$kotlin_reflection(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
                }
            });
            this.inheritedNonStaticMembers = ReflectProperties.lazySoft(new Function0<Collection<? extends KCallableImpl<?>>>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$inheritedNonStaticMembers$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Collection<? extends KCallableImpl<?>> invoke() {
                    KClassImpl<T> kClassImpl = r1;
                    return kClassImpl.getMembers(kClassImpl.getMemberScope$kotlin_reflection(), KDeclarationContainerImpl.MemberBelonginess.INHERITED);
                }
            });
            this.inheritedStaticMembers = ReflectProperties.lazySoft(new Function0<Collection<? extends KCallableImpl<?>>>() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$inheritedStaticMembers$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Collection<? extends KCallableImpl<?>> invoke() {
                    KClassImpl<T> kClassImpl = r1;
                    return kClassImpl.getMembers(kClassImpl.getStaticScope$kotlin_reflection(), KDeclarationContainerImpl.MemberBelonginess.INHERITED);
                }
            });
            this.allNonStaticMembers = ReflectProperties.lazySoft(new Function0<List<? extends KCallableImpl<?>>>(this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$allNonStaticMembers$2
                final /* synthetic */ KClassImpl<T>.Data this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public final List<? extends KCallableImpl<?>> invoke() {
                    Collection inheritedNonStaticMembers;
                    Collection<KCallableImpl<?>> declaredNonStaticMembers = this.this$0.getDeclaredNonStaticMembers();
                    inheritedNonStaticMembers = this.this$0.getInheritedNonStaticMembers();
                    return CollectionsKt.plus((Collection) declaredNonStaticMembers, (Iterable) inheritedNonStaticMembers);
                }
            });
            this.allStaticMembers = ReflectProperties.lazySoft(new Function0<List<? extends KCallableImpl<?>>>(this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$allStaticMembers$2
                final /* synthetic */ KClassImpl<T>.Data this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public final List<? extends KCallableImpl<?>> invoke() {
                    Collection declaredStaticMembers;
                    Collection inheritedStaticMembers;
                    declaredStaticMembers = this.this$0.getDeclaredStaticMembers();
                    inheritedStaticMembers = this.this$0.getInheritedStaticMembers();
                    return CollectionsKt.plus(declaredStaticMembers, (Iterable) inheritedStaticMembers);
                }
            });
            this.declaredMembers = ReflectProperties.lazySoft(new Function0<List<? extends KCallableImpl<?>>>(this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$declaredMembers$2
                final /* synthetic */ KClassImpl<T>.Data this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public final List<? extends KCallableImpl<?>> invoke() {
                    Collection declaredStaticMembers;
                    Collection<KCallableImpl<?>> declaredNonStaticMembers = this.this$0.getDeclaredNonStaticMembers();
                    declaredStaticMembers = this.this$0.getDeclaredStaticMembers();
                    return CollectionsKt.plus((Collection) declaredNonStaticMembers, (Iterable) declaredStaticMembers);
                }
            });
            this.allMembers = ReflectProperties.lazySoft(new Function0<List<? extends KCallableImpl<?>>>(this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$allMembers$2
                final /* synthetic */ KClassImpl<T>.Data this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public final List<? extends KCallableImpl<?>> invoke() {
                    return CollectionsKt.plus((Collection) this.this$0.getAllNonStaticMembers(), (Iterable) this.this$0.getAllStaticMembers());
                }
            });
        }

        public final ClassDescriptor getDescriptor() {
            T value = this.descriptor.getValue(this, $$delegatedProperties[0]);
            Intrinsics.checkNotNullExpressionValue(value, "<get-descriptor>(...)");
            return (ClassDescriptor) value;
        }

        public final List<Annotation> getAnnotations() {
            T value = this.annotations.getValue(this, $$delegatedProperties[1]);
            Intrinsics.checkNotNullExpressionValue(value, "<get-annotations>(...)");
            return (List) value;
        }

        public final String getSimpleName() {
            return (String) this.simpleName.getValue(this, $$delegatedProperties[2]);
        }

        public final String getQualifiedName() {
            return (String) this.qualifiedName.getValue(this, $$delegatedProperties[3]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String calculateLocalClassName(Class<?> jClass) {
            String name = jClass.getSimpleName();
            Method enclosingMethod = jClass.getEnclosingMethod();
            if (enclosingMethod != null) {
                Intrinsics.checkNotNullExpressionValue(name, "name");
                return StringsKt.substringAfter$default(name, enclosingMethod.getName() + '$', (String) null, 2, (Object) null);
            }
            Constructor<?> enclosingConstructor = jClass.getEnclosingConstructor();
            if (enclosingConstructor != null) {
                Intrinsics.checkNotNullExpressionValue(name, "name");
                return StringsKt.substringAfter$default(name, enclosingConstructor.getName() + '$', (String) null, 2, (Object) null);
            }
            Intrinsics.checkNotNullExpressionValue(name, "name");
            return StringsKt.substringAfter$default(name, '$', (String) null, 2, (Object) null);
        }

        public final Collection<KFunction<T>> getConstructors() {
            T value = this.constructors.getValue(this, $$delegatedProperties[4]);
            Intrinsics.checkNotNullExpressionValue(value, "<get-constructors>(...)");
            return (Collection) value;
        }

        public final Collection<KClass<?>> getNestedClasses() {
            T value = this.nestedClasses.getValue(this, $$delegatedProperties[5]);
            Intrinsics.checkNotNullExpressionValue(value, "<get-nestedClasses>(...)");
            return (Collection) value;
        }

        public final T getObjectInstance() {
            return this.objectInstance.getValue(this, $$delegatedProperties[6]);
        }

        public final List<KTypeParameter> getTypeParameters() {
            T value = this.typeParameters.getValue(this, $$delegatedProperties[7]);
            Intrinsics.checkNotNullExpressionValue(value, "<get-typeParameters>(...)");
            return (List) value;
        }

        public final List<KType> getSupertypes() {
            T value = this.supertypes.getValue(this, $$delegatedProperties[8]);
            Intrinsics.checkNotNullExpressionValue(value, "<get-supertypes>(...)");
            return (List) value;
        }

        public final List<KClass<? extends T>> getSealedSubclasses() {
            T value = this.sealedSubclasses.getValue(this, $$delegatedProperties[9]);
            Intrinsics.checkNotNullExpressionValue(value, "<get-sealedSubclasses>(...)");
            return (List) value;
        }

        public final Collection<KCallableImpl<?>> getDeclaredNonStaticMembers() {
            T value = this.declaredNonStaticMembers.getValue(this, $$delegatedProperties[10]);
            Intrinsics.checkNotNullExpressionValue(value, "<get-declaredNonStaticMembers>(...)");
            return (Collection) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection<KCallableImpl<?>> getDeclaredStaticMembers() {
            T value = this.declaredStaticMembers.getValue(this, $$delegatedProperties[11]);
            Intrinsics.checkNotNullExpressionValue(value, "<get-declaredStaticMembers>(...)");
            return (Collection) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection<KCallableImpl<?>> getInheritedNonStaticMembers() {
            T value = this.inheritedNonStaticMembers.getValue(this, $$delegatedProperties[12]);
            Intrinsics.checkNotNullExpressionValue(value, "<get-inheritedNonStaticMembers>(...)");
            return (Collection) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection<KCallableImpl<?>> getInheritedStaticMembers() {
            T value = this.inheritedStaticMembers.getValue(this, $$delegatedProperties[13]);
            Intrinsics.checkNotNullExpressionValue(value, "<get-inheritedStaticMembers>(...)");
            return (Collection) value;
        }

        public final Collection<KCallableImpl<?>> getAllNonStaticMembers() {
            T value = this.allNonStaticMembers.getValue(this, $$delegatedProperties[14]);
            Intrinsics.checkNotNullExpressionValue(value, "<get-allNonStaticMembers>(...)");
            return (Collection) value;
        }

        public final Collection<KCallableImpl<?>> getAllStaticMembers() {
            T value = this.allStaticMembers.getValue(this, $$delegatedProperties[15]);
            Intrinsics.checkNotNullExpressionValue(value, "<get-allStaticMembers>(...)");
            return (Collection) value;
        }

        public final Collection<KCallableImpl<?>> getDeclaredMembers() {
            T value = this.declaredMembers.getValue(this, $$delegatedProperties[16]);
            Intrinsics.checkNotNullExpressionValue(value, "<get-declaredMembers>(...)");
            return (Collection) value;
        }

        public final Collection<KCallableImpl<?>> getAllMembers() {
            T value = this.allMembers.getValue(this, $$delegatedProperties[17]);
            Intrinsics.checkNotNullExpressionValue(value, "<get-allMembers>(...)");
            return (Collection) value;
        }
    }

    public KClassImpl(Class<T> jClass) {
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        this.jClass = jClass;
        ReflectProperties.LazyVal<KClassImpl<T>.Data> lazy = ReflectProperties.lazy(new Function0<KClassImpl<T>.Data>(this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$data$1
            final /* synthetic */ KClassImpl<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final KClassImpl<T>.Data invoke() {
                return this.this$0.new Data();
            }
        });
        Intrinsics.checkNotNullExpressionValue(lazy, "lazy { Data() }");
        this.data = lazy;
    }

    public final ReflectProperties.LazyVal<KClassImpl<T>.Data> getData() {
        return this.data;
    }

    @Override // kotlin.reflect.jvm.internal.KClassifierImpl
    public ClassDescriptor getDescriptor() {
        return this.data.invoke().getDescriptor();
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        return this.data.invoke().getAnnotations();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassId getClassId() {
        return RuntimeTypeMapper.INSTANCE.mapJvmClassToKotlinClassId(getJClass());
    }

    public final MemberScope getMemberScope$kotlin_reflection() {
        return getDescriptor().getDefaultType().getMemberScope();
    }

    public final MemberScope getStaticScope$kotlin_reflection() {
        MemberScope staticScope = getDescriptor().getStaticScope();
        Intrinsics.checkNotNullExpressionValue(staticScope, "descriptor.staticScope");
        return staticScope;
    }

    @Override // kotlin.reflect.KDeclarationContainer
    public Collection<KCallable<?>> getMembers() {
        return this.data.invoke().getAllMembers();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<ConstructorDescriptor> getConstructorDescriptors() {
        ClassDescriptor descriptor = getDescriptor();
        if (descriptor.getKind() == ClassKind.INTERFACE || descriptor.getKind() == ClassKind.OBJECT) {
            return CollectionsKt.emptyList();
        }
        Collection<ClassConstructorDescriptor> constructors = descriptor.getConstructors();
        Intrinsics.checkNotNullExpressionValue(constructors, "descriptor.constructors");
        return constructors;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<PropertyDescriptor> getProperties(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return CollectionsKt.plus((Collection) getMemberScope$kotlin_reflection().getContributedVariables(name, NoLookupLocation.FROM_REFLECTION), (Iterable) getStaticScope$kotlin_reflection().getContributedVariables(name, NoLookupLocation.FROM_REFLECTION));
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<FunctionDescriptor> getFunctions(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return CollectionsKt.plus((Collection) getMemberScope$kotlin_reflection().getContributedFunctions(name, NoLookupLocation.FROM_REFLECTION), (Iterable) getStaticScope$kotlin_reflection().getContributedFunctions(name, NoLookupLocation.FROM_REFLECTION));
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public PropertyDescriptor getLocalProperty(int index) {
        Class<?> declaringClass;
        if (Intrinsics.areEqual(getJClass().getSimpleName(), "DefaultImpls") && (declaringClass = getJClass().getDeclaringClass()) != null && declaringClass.isInterface()) {
            KClass kotlinClass = JvmClassMappingKt.getKotlinClass(declaringClass);
            Intrinsics.checkNotNull(kotlinClass, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
            return ((KClassImpl) kotlinClass).getLocalProperty(index);
        }
        ClassDescriptor descriptor = getDescriptor();
        DeserializedClassDescriptor deserializedClassDescriptor = descriptor instanceof DeserializedClassDescriptor ? (DeserializedClassDescriptor) descriptor : null;
        if (deserializedClassDescriptor == null) {
            return null;
        }
        ProtoBuf.Class classProto = deserializedClassDescriptor.getClassProto();
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, List<ProtoBuf.Property>> classLocalVariable = JvmProtoBuf.classLocalVariable;
        Intrinsics.checkNotNullExpressionValue(classLocalVariable, "classLocalVariable");
        ProtoBuf.Property property = (ProtoBuf.Property) ProtoBufUtilKt.getExtensionOrNull(classProto, classLocalVariable, index);
        if (property != null) {
            return (PropertyDescriptor) UtilKt.deserializeToDescriptor(getJClass(), property, deserializedClassDescriptor.getC().getNameResolver(), deserializedClassDescriptor.getC().getTypeTable(), deserializedClassDescriptor.getMetadataVersion(), KClassImpl$getLocalProperty$2$1$1.INSTANCE);
        }
        return null;
    }

    @Override // kotlin.reflect.KClass
    public String getSimpleName() {
        return this.data.invoke().getSimpleName();
    }

    @Override // kotlin.reflect.KClass
    public String getQualifiedName() {
        return this.data.invoke().getQualifiedName();
    }

    @Override // kotlin.reflect.KClass
    public Collection<KFunction<T>> getConstructors() {
        return this.data.invoke().getConstructors();
    }

    @Override // kotlin.reflect.KClass
    public Collection<KClass<?>> getNestedClasses() {
        return this.data.invoke().getNestedClasses();
    }

    @Override // kotlin.reflect.KClass
    public T getObjectInstance() {
        return this.data.invoke().getObjectInstance();
    }

    @Override // kotlin.reflect.KClass
    public boolean isInstance(Object value) {
        Integer functionClassArity = ReflectClassUtilKt.getFunctionClassArity(getJClass());
        if (functionClassArity != null) {
            return TypeIntrinsics.isFunctionOfArity(value, functionClassArity.intValue());
        }
        Class wrapperByPrimitive = ReflectClassUtilKt.getWrapperByPrimitive(getJClass());
        if (wrapperByPrimitive == null) {
            wrapperByPrimitive = getJClass();
        }
        return wrapperByPrimitive.isInstance(value);
    }

    @Override // kotlin.reflect.KClass
    public List<KTypeParameter> getTypeParameters() {
        return this.data.invoke().getTypeParameters();
    }

    @Override // kotlin.reflect.KClass
    public List<KType> getSupertypes() {
        return this.data.invoke().getSupertypes();
    }

    @Override // kotlin.reflect.KClass
    public List<KClass<? extends T>> getSealedSubclasses() {
        return this.data.invoke().getSealedSubclasses();
    }

    @Override // kotlin.reflect.KClass
    public KVisibility getVisibility() {
        DescriptorVisibility visibility = getDescriptor().getVisibility();
        Intrinsics.checkNotNullExpressionValue(visibility, "descriptor.visibility");
        return UtilKt.toKVisibility(visibility);
    }

    @Override // kotlin.reflect.KClass
    public boolean isFinal() {
        return getDescriptor().getModality() == Modality.FINAL;
    }

    @Override // kotlin.reflect.KClass
    public boolean isOpen() {
        return getDescriptor().getModality() == Modality.OPEN;
    }

    @Override // kotlin.reflect.KClass
    public boolean isAbstract() {
        return getDescriptor().getModality() == Modality.ABSTRACT;
    }

    @Override // kotlin.reflect.KClass
    public boolean isSealed() {
        return getDescriptor().getModality() == Modality.SEALED;
    }

    @Override // kotlin.reflect.KClass
    public boolean isData() {
        return getDescriptor().isData();
    }

    @Override // kotlin.reflect.KClass
    public boolean isInner() {
        return getDescriptor().isInner();
    }

    @Override // kotlin.reflect.KClass
    public boolean isCompanion() {
        return getDescriptor().isCompanionObject();
    }

    @Override // kotlin.reflect.KClass
    public boolean isFun() {
        return getDescriptor().isFun();
    }

    @Override // kotlin.reflect.KClass
    public boolean isValue() {
        return getDescriptor().isValue();
    }

    @Override // kotlin.reflect.KClass
    public boolean equals(Object other) {
        return (other instanceof KClassImpl) && Intrinsics.areEqual(JvmClassMappingKt.getJavaObjectType(this), JvmClassMappingKt.getJavaObjectType((KClass) other));
    }

    @Override // kotlin.reflect.KClass
    public int hashCode() {
        return JvmClassMappingKt.getJavaObjectType(this).hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("class ");
        ClassId classId = getClassId();
        FqName packageFqName = classId.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
        String str = packageFqName.isRoot() ? "" : packageFqName.asString() + '.';
        String asString = classId.getRelativeClassName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "classId.relativeClassName.asString()");
        return sb.append(str + StringsKt.replace$default(asString, '.', '$', false, 4, (Object) null)).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Void reportUnresolvedClass() {
        KotlinClassHeader classHeader;
        ReflectKotlinClass create = ReflectKotlinClass.Factory.create(getJClass());
        KotlinClassHeader.Kind kind = (create == null || (classHeader = create.getClassHeader()) == null) ? null : classHeader.getKind();
        switch (kind == null ? -1 : WhenMappings.$EnumSwitchMapping$0[kind.ordinal()]) {
            case -1:
            case 6:
                throw new KotlinReflectionInternalError("Unresolved class: " + getJClass());
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
            case 2:
            case 3:
                throw new UnsupportedOperationException("Packages and file facades are not yet supported in Kotlin reflection. Meanwhile please use Java reflection to inspect this class: " + getJClass());
            case 4:
                throw new UnsupportedOperationException("This class is an internal synthetic class generated by the Kotlin compiler, such as an anonymous class for a lambda, a SAM wrapper, a callable reference, etc. It's not a Kotlin class or interface, so the reflection library has no idea what declarations it has. Please use Java reflection to inspect this class: " + getJClass());
            case 5:
                throw new KotlinReflectionInternalError("Unknown class: " + getJClass() + " (kind = " + kind + ')');
        }
    }
}
