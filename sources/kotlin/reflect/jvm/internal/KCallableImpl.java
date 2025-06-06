package kotlin.reflect.jvm.internal;

import androidx.core.app.NotificationCompat;
import io.sentry.protocol.ViewHierarchyNode;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.reflect.full.IllegalCallableAccessException;
import kotlin.reflect.jvm.KTypesJvm;
import kotlin.reflect.jvm.ReflectJvmMapping;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: KCallableImpl.kt */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J%\u00109\u001a\u00028\u00002\u0016\u0010:\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u0007\"\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010;J#\u0010<\u001a\u00028\u00002\u0014\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\b0=H\u0002¢\u0006\u0002\u0010>J#\u0010?\u001a\u00028\u00002\u0014\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\b0=H\u0016¢\u0006\u0002\u0010>J3\u0010@\u001a\u00028\u00002\u0014\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\b0=2\f\u0010A\u001a\b\u0012\u0002\b\u0003\u0018\u00010BH\u0000¢\u0006\u0004\bC\u0010DJ\u0010\u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020/H\u0002J\n\u0010G\u001a\u0004\u0018\u00010HH\u0002J\u0015\u0010I\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u0010JR,\u0010\u0005\u001a \u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u00010\b \t*\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\n\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\f \t*\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\u000b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\r\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000f \t*\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e0\u000e0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00110\u00110\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0012\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0013 \t*\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000b0\u000b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0012\u0010\u001b\u001a\u00020\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u001f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001aR\u0012\u0010!\u001a\u00020\"X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010'R\u0014\u0010(\u001a\u00020&8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b(\u0010'R\u0012\u0010)\u001a\u00020&X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010'R\u0014\u0010*\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010'R\u0014\u0010+\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010'R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0016R\u0014\u0010.\u001a\u00020/8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u001a\u00102\u001a\b\u0012\u0004\u0012\u0002030\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\u0016R\u0016\u00105\u001a\u0004\u0018\u0001068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u00108¨\u0006K"}, d2 = {"Lkotlin/reflect/jvm/internal/KCallableImpl;", "R", "Lkotlin/reflect/KCallable;", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "()V", "_absentArguments", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "", "", "kotlin.jvm.PlatformType", "_annotations", "", "", "_parameters", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "_returnType", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "_typeParameters", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "annotations", "getAnnotations", "()Ljava/util/List;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;", "isAbstract", "", "()Z", "isAnnotationConstructor", "isBound", "isFinal", "isOpen", "parameters", "getParameters", "returnType", "Lkotlin/reflect/KType;", "getReturnType", "()Lkotlin/reflect/KType;", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", ViewHierarchyNode.JsonKeys.VISIBILITY, "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", NotificationCompat.CATEGORY_CALL, "args", "([Ljava/lang/Object;)Ljava/lang/Object;", "callAnnotationConstructor", "", "(Ljava/util/Map;)Ljava/lang/Object;", "callBy", "callDefaultMethod", "continuationArgument", "Lkotlin/coroutines/Continuation;", "callDefaultMethod$kotlin_reflection", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "defaultEmptyArray", "type", "extractContinuationArgument", "Ljava/lang/reflect/Type;", "getAbsentArguments", "()[Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class KCallableImpl<R> implements KCallable<R>, KTypeParameterOwnerImpl {
    private final ReflectProperties.LazySoftVal<Object[]> _absentArguments;
    private final ReflectProperties.LazySoftVal<List<Annotation>> _annotations;
    private final ReflectProperties.LazySoftVal<ArrayList<KParameter>> _parameters;
    private final ReflectProperties.LazySoftVal<KTypeImpl> _returnType;
    private final ReflectProperties.LazySoftVal<List<KTypeParameterImpl>> _typeParameters;

    public abstract Caller<?> getCaller();

    public abstract KDeclarationContainerImpl getContainer();

    public abstract Caller<?> getDefaultCaller();

    public abstract CallableMemberDescriptor getDescriptor();

    public abstract boolean isBound();

    public KCallableImpl() {
        ReflectProperties.LazySoftVal<List<Annotation>> lazySoft = ReflectProperties.lazySoft(new Function0<List<? extends Annotation>>(this) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_annotations$1
            final /* synthetic */ KCallableImpl<R> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends Annotation> invoke() {
                return UtilKt.computeAnnotations(this.this$0.getDescriptor());
            }
        });
        Intrinsics.checkNotNullExpressionValue(lazySoft, "lazySoft { descriptor.computeAnnotations() }");
        this._annotations = lazySoft;
        ReflectProperties.LazySoftVal<ArrayList<KParameter>> lazySoft2 = ReflectProperties.lazySoft(new Function0<ArrayList<KParameter>>(this) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_parameters$1
            final /* synthetic */ KCallableImpl<R> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final ArrayList<KParameter> invoke() {
                int i;
                final CallableMemberDescriptor descriptor = this.this$0.getDescriptor();
                ArrayList<KParameter> arrayList = new ArrayList<>();
                final int i2 = 0;
                if (this.this$0.isBound()) {
                    i = 0;
                } else {
                    final ReceiverParameterDescriptor instanceReceiverParameter = UtilKt.getInstanceReceiverParameter(descriptor);
                    if (instanceReceiverParameter != null) {
                        arrayList.add(new KParameterImpl(this.this$0, 0, KParameter.Kind.INSTANCE, new Function0<ParameterDescriptor>() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_parameters$1.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final ParameterDescriptor invoke() {
                                return ReceiverParameterDescriptor.this;
                            }
                        }));
                        i = 1;
                    } else {
                        i = 0;
                    }
                    final ReceiverParameterDescriptor extensionReceiverParameter = descriptor.getExtensionReceiverParameter();
                    if (extensionReceiverParameter != null) {
                        arrayList.add(new KParameterImpl(this.this$0, i, KParameter.Kind.EXTENSION_RECEIVER, new Function0<ParameterDescriptor>() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_parameters$1.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final ParameterDescriptor invoke() {
                                return ReceiverParameterDescriptor.this;
                            }
                        }));
                        i++;
                    }
                }
                int size = descriptor.getValueParameters().size();
                while (i2 < size) {
                    arrayList.add(new KParameterImpl(this.this$0, i, KParameter.Kind.VALUE, new Function0<ParameterDescriptor>() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_parameters$1.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final ParameterDescriptor invoke() {
                            ValueParameterDescriptor valueParameterDescriptor = CallableMemberDescriptor.this.getValueParameters().get(i2);
                            Intrinsics.checkNotNullExpressionValue(valueParameterDescriptor, "descriptor.valueParameters[i]");
                            return valueParameterDescriptor;
                        }
                    }));
                    i2++;
                    i++;
                }
                if (this.this$0.isAnnotationConstructor() && (descriptor instanceof JavaCallableMemberDescriptor)) {
                    ArrayList<KParameter> arrayList2 = arrayList;
                    if (arrayList2.size() > 1) {
                        CollectionsKt.sortWith(arrayList2, new Comparator() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_parameters$1$invoke$$inlined$sortBy$1
                            @Override // java.util.Comparator
                            public final int compare(T t, T t2) {
                                return ComparisonsKt.compareValues(((KParameter) t).getName(), ((KParameter) t2).getName());
                            }
                        });
                    }
                }
                arrayList.trimToSize();
                return arrayList;
            }
        });
        Intrinsics.checkNotNullExpressionValue(lazySoft2, "lazySoft {\n        val d…ze()\n        result\n    }");
        this._parameters = lazySoft2;
        ReflectProperties.LazySoftVal<KTypeImpl> lazySoft3 = ReflectProperties.lazySoft(new Function0<KTypeImpl>(this) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_returnType$1
            final /* synthetic */ KCallableImpl<R> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final KTypeImpl invoke() {
                KotlinType returnType = this.this$0.getDescriptor().getReturnType();
                Intrinsics.checkNotNull(returnType);
                final KCallableImpl<R> kCallableImpl = this.this$0;
                return new KTypeImpl(returnType, new Function0<Type>() { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_returnType$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Type invoke() {
                        Type extractContinuationArgument;
                        extractContinuationArgument = kCallableImpl.extractContinuationArgument();
                        return extractContinuationArgument == null ? kCallableImpl.getCaller().getReturnType() : extractContinuationArgument;
                    }
                });
            }
        });
        Intrinsics.checkNotNullExpressionValue(lazySoft3, "lazySoft {\n        KType…eturnType\n        }\n    }");
        this._returnType = lazySoft3;
        ReflectProperties.LazySoftVal<List<KTypeParameterImpl>> lazySoft4 = ReflectProperties.lazySoft(new Function0<List<? extends KTypeParameterImpl>>(this) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_typeParameters$1
            final /* synthetic */ KCallableImpl<R> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends KTypeParameterImpl> invoke() {
                List<TypeParameterDescriptor> typeParameters = this.this$0.getDescriptor().getTypeParameters();
                Intrinsics.checkNotNullExpressionValue(typeParameters, "descriptor.typeParameters");
                List<TypeParameterDescriptor> list = typeParameters;
                KTypeParameterOwnerImpl kTypeParameterOwnerImpl = this.this$0;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (TypeParameterDescriptor descriptor : list) {
                    Intrinsics.checkNotNullExpressionValue(descriptor, "descriptor");
                    arrayList.add(new KTypeParameterImpl(kTypeParameterOwnerImpl, descriptor));
                }
                return arrayList;
            }
        });
        Intrinsics.checkNotNullExpressionValue(lazySoft4, "lazySoft {\n        descr…this, descriptor) }\n    }");
        this._typeParameters = lazySoft4;
        ReflectProperties.LazySoftVal<Object[]> lazySoft5 = ReflectProperties.lazySoft(new Function0<Object[]>(this) { // from class: kotlin.reflect.jvm.internal.KCallableImpl$_absentArguments$1
            final /* synthetic */ KCallableImpl<R> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object[] invoke() {
                Object defaultEmptyArray;
                int size = this.this$0.getParameters().size() + (this.this$0.isSuspend() ? 1 : 0);
                int size2 = ((this.this$0.getParameters().size() + 32) - 1) / 32;
                Object[] objArr = new Object[size + size2 + 1];
                List<KParameter> parameters = this.this$0.getParameters();
                KCallableImpl<R> kCallableImpl = this.this$0;
                for (KParameter kParameter : parameters) {
                    if (kParameter.isOptional() && !UtilKt.isInlineClassType(kParameter.getType())) {
                        objArr[kParameter.getIndex()] = UtilKt.defaultPrimitiveValue(ReflectJvmMapping.getJavaType(kParameter.getType()));
                    } else if (kParameter.isVararg()) {
                        int index = kParameter.getIndex();
                        defaultEmptyArray = kCallableImpl.defaultEmptyArray(kParameter.getType());
                        objArr[index] = defaultEmptyArray;
                    }
                }
                for (int i = 0; i < size2; i++) {
                    objArr[size + i] = 0;
                }
                return objArr;
            }
        });
        Intrinsics.checkNotNullExpressionValue(lazySoft5, "lazySoft {\n        val p…\n\n        arguments\n    }");
        this._absentArguments = lazySoft5;
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        List<Annotation> invoke = this._annotations.invoke();
        Intrinsics.checkNotNullExpressionValue(invoke, "_annotations()");
        return invoke;
    }

    @Override // kotlin.reflect.KCallable
    public List<KParameter> getParameters() {
        ArrayList<KParameter> invoke = this._parameters.invoke();
        Intrinsics.checkNotNullExpressionValue(invoke, "_parameters()");
        return invoke;
    }

    @Override // kotlin.reflect.KCallable
    public KType getReturnType() {
        KTypeImpl invoke = this._returnType.invoke();
        Intrinsics.checkNotNullExpressionValue(invoke, "_returnType()");
        return invoke;
    }

    @Override // kotlin.reflect.KCallable
    public List<KTypeParameter> getTypeParameters() {
        List<KTypeParameterImpl> invoke = this._typeParameters.invoke();
        Intrinsics.checkNotNullExpressionValue(invoke, "_typeParameters()");
        return invoke;
    }

    @Override // kotlin.reflect.KCallable
    public KVisibility getVisibility() {
        DescriptorVisibility visibility = getDescriptor().getVisibility();
        Intrinsics.checkNotNullExpressionValue(visibility, "descriptor.visibility");
        return UtilKt.toKVisibility(visibility);
    }

    @Override // kotlin.reflect.KCallable
    public boolean isFinal() {
        return getDescriptor().getModality() == Modality.FINAL;
    }

    @Override // kotlin.reflect.KCallable
    public boolean isOpen() {
        return getDescriptor().getModality() == Modality.OPEN;
    }

    @Override // kotlin.reflect.KCallable
    public boolean isAbstract() {
        return getDescriptor().getModality() == Modality.ABSTRACT;
    }

    protected final boolean isAnnotationConstructor() {
        return Intrinsics.areEqual(getName(), "<init>") && getContainer().getJClass().isAnnotation();
    }

    @Override // kotlin.reflect.KCallable
    public R call(Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        try {
            return (R) getCaller().call(args);
        } catch (IllegalAccessException e) {
            throw new IllegalCallableAccessException(e);
        }
    }

    @Override // kotlin.reflect.KCallable
    public R callBy(Map<KParameter, ? extends Object> args) {
        Intrinsics.checkNotNullParameter(args, "args");
        return isAnnotationConstructor() ? callAnnotationConstructor(args) : callDefaultMethod$kotlin_reflection(args, null);
    }

    private final Object[] getAbsentArguments() {
        return (Object[]) this._absentArguments.invoke().clone();
    }

    public final R callDefaultMethod$kotlin_reflection(Map<KParameter, ? extends Object> args, Continuation<?> continuationArgument) {
        Intrinsics.checkNotNullParameter(args, "args");
        List<KParameter> parameters = getParameters();
        boolean z = false;
        if (!parameters.isEmpty()) {
            int size = parameters.size() + (isSuspend() ? 1 : 0);
            Object[] absentArguments = getAbsentArguments();
            if (isSuspend()) {
                absentArguments[parameters.size()] = continuationArgument;
            }
            int i = 0;
            for (KParameter kParameter : parameters) {
                if (args.containsKey(kParameter)) {
                    absentArguments[kParameter.getIndex()] = args.get(kParameter);
                } else if (kParameter.isOptional()) {
                    int i2 = (i / 32) + size;
                    Object obj = absentArguments[i2];
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                    absentArguments[i2] = Integer.valueOf(((Integer) obj).intValue() | (1 << (i % 32)));
                    z = true;
                } else if (!kParameter.isVararg()) {
                    throw new IllegalArgumentException("No argument provided for a required parameter: " + kParameter);
                }
                if (kParameter.getKind() == KParameter.Kind.VALUE) {
                    i++;
                }
            }
            if (!z) {
                try {
                    Caller<?> caller = getCaller();
                    Object[] copyOf = Arrays.copyOf(absentArguments, size);
                    Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                    return (R) caller.call(copyOf);
                } catch (IllegalAccessException e) {
                    throw new IllegalCallableAccessException(e);
                }
            }
            Caller<?> defaultCaller = getDefaultCaller();
            if (defaultCaller == null) {
                throw new KotlinReflectionInternalError("This callable does not support a default call: " + getDescriptor());
            }
            try {
                return (R) defaultCaller.call(absentArguments);
            } catch (IllegalAccessException e2) {
                throw new IllegalCallableAccessException(e2);
            }
        }
        try {
            return (R) getCaller().call(isSuspend() ? new Continuation[]{continuationArgument} : new Continuation[0]);
        } catch (IllegalAccessException e3) {
            throw new IllegalCallableAccessException(e3);
        }
    }

    private final R callAnnotationConstructor(Map<KParameter, ? extends Object> args) {
        Object defaultEmptyArray;
        List<KParameter> parameters = getParameters();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(parameters, 10));
        for (KParameter kParameter : parameters) {
            if (args.containsKey(kParameter)) {
                defaultEmptyArray = args.get(kParameter);
                if (defaultEmptyArray == null) {
                    throw new IllegalArgumentException("Annotation argument value cannot be null (" + kParameter + ')');
                }
            } else if (kParameter.isOptional()) {
                defaultEmptyArray = null;
            } else {
                if (!kParameter.isVararg()) {
                    throw new IllegalArgumentException("No argument provided for a required parameter: " + kParameter);
                }
                defaultEmptyArray = defaultEmptyArray(kParameter.getType());
            }
            arrayList.add(defaultEmptyArray);
        }
        ArrayList arrayList2 = arrayList;
        Caller<?> defaultCaller = getDefaultCaller();
        if (defaultCaller == null) {
            throw new KotlinReflectionInternalError("This callable does not support a default call: " + getDescriptor());
        }
        try {
            return (R) defaultCaller.call(arrayList2.toArray(new Object[0]));
        } catch (IllegalAccessException e) {
            throw new IllegalCallableAccessException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object defaultEmptyArray(KType type) {
        Class javaClass = JvmClassMappingKt.getJavaClass((KClass) KTypesJvm.getJvmErasure(type));
        if (javaClass.isArray()) {
            Object newInstance = Array.newInstance(javaClass.getComponentType(), 0);
            Intrinsics.checkNotNullExpressionValue(newInstance, "type.jvmErasure.java.run…\"\n            )\n        }");
            return newInstance;
        }
        throw new KotlinReflectionInternalError("Cannot instantiate the default empty array of type " + javaClass.getSimpleName() + ", because it is not an array type");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Type extractContinuationArgument() {
        Type[] lowerBounds;
        if (!isSuspend()) {
            return null;
        }
        Object lastOrNull = CollectionsKt.lastOrNull((List<? extends Object>) getCaller().getParameterTypes());
        ParameterizedType parameterizedType = lastOrNull instanceof ParameterizedType ? (ParameterizedType) lastOrNull : null;
        if (!Intrinsics.areEqual(parameterizedType != null ? parameterizedType.getRawType() : null, Continuation.class)) {
            return null;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Intrinsics.checkNotNullExpressionValue(actualTypeArguments, "continuationType.actualTypeArguments");
        Object single = ArraysKt.single(actualTypeArguments);
        WildcardType wildcardType = single instanceof WildcardType ? (WildcardType) single : null;
        if (wildcardType == null || (lowerBounds = wildcardType.getLowerBounds()) == null) {
            return null;
        }
        return (Type) ArraysKt.first(lowerBounds);
    }
}
