package org.koin.core;

import androidx.exifinterface.media.ExifInterface;
import com.amplitude.reactnative.DatabaseConstants;
import io.sentry.SentryEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.component.KoinScopeComponentKt;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.BeanDefinitionKt;
import org.koin.core.definition.Kind;
import org.koin.core.error.ScopeNotCreatedException;
import org.koin.core.extension.ExtensionManager;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.logger.EmptyLogger;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;
import org.koin.core.module.Module;
import org.koin.core.module.ModuleKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.qualifier.TypeQualifier;
import org.koin.core.registry.InstanceRegistry;
import org.koin.core.registry.PropertyRegistry;
import org.koin.core.registry.ScopeRegistry;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTimeTools;
import org.koin.mp.KoinPlatformTools;

/* compiled from: Koin.kt */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001dJ\u001d\u0010\u001f\u001a\u00020 \"\b\b\u0000\u0010!*\u00020\"2\u0006\u0010#\u001a\u0002H!¢\u0006\u0002\u0010$J#\u0010\u001f\u001a\u00020 \"\n\b\u0000\u0010!\u0018\u0001*\u00020\u00012\f\b\u0002\u0010%\u001a\u00060&j\u0002`'H\u0086\bJ-\u0010\u001f\u001a\u00020 \"\n\b\u0000\u0010!\u0018\u0001*\u00020\u00012\n\u0010%\u001a\u00060&j\u0002`'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0001H\u0086\bJ&\u0010\u001f\u001a\u00020 2\n\u0010%\u001a\u00060&j\u0002`'2\u0006\u0010)\u001a\u00020*2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0001JH\u0010+\u001a\u00020\u001d\"\u0006\b\u0000\u0010!\u0018\u00012\u0006\u0010,\u001a\u0002H!2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\u0012\b\u0002\u0010-\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030/0.2\b\b\u0002\u00100\u001a\u000201H\u0086\b¢\u0006\u0002\u00102J\u000e\u00103\u001a\u00020\u001d2\u0006\u00104\u001a\u00020&J\u0012\u00105\u001a\u00020\u001d2\n\u0010%\u001a\u00060&j\u0002`'JA\u00106\u001a\u0002H!\"\u0004\b\u0000\u0010!2\n\u00107\u001a\u0006\u0012\u0002\b\u00030/2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\u0016\b\u0002\u00108\u001a\u0010\u0012\u0004\u0012\u00020:\u0018\u000109j\u0004\u0018\u0001`;¢\u0006\u0002\u0010<JA\u00106\u001a\u0002H!\"\n\b\u0000\u0010!\u0018\u0001*\u00020\u00012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\u0016\b\n\u00108\u001a\u0010\u0012\u0004\u0012\u00020:\u0018\u000109j\u0004\u0018\u0001`;H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010=J\u0017\u0010>\u001a\b\u0012\u0004\u0012\u0002H!0.\"\u0006\b\u0000\u0010!\u0018\u0001H\u0086\bJ!\u0010?\u001a\u00020 \"\n\b\u0000\u0010!\u0018\u0001*\u00020\u00012\n\u0010%\u001a\u00060&j\u0002`'H\u0086\bJ&\u0010?\u001a\u00020 2\n\u0010%\u001a\u00060&j\u0002`'2\u0006\u0010)\u001a\u00020*2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0001JC\u0010@\u001a\u0004\u0018\u0001H!\"\u0004\b\u0000\u0010!2\n\u00107\u001a\u0006\u0012\u0002\b\u00030/2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\u0016\b\u0002\u00108\u001a\u0010\u0012\u0004\u0012\u00020:\u0018\u000109j\u0004\u0018\u0001`;¢\u0006\u0002\u0010<JC\u0010@\u001a\u0004\u0018\u0001H!\"\n\b\u0000\u0010!\u0018\u0001*\u00020\u00012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\u0016\b\n\u00108\u001a\u0010\u0012\u0004\u0012\u00020:\u0018\u000109j\u0004\u0018\u0001`;H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010=J\u001f\u0010A\u001a\u0004\u0018\u0001H!\"\b\b\u0000\u0010!*\u00020\u00012\u0006\u00104\u001a\u00020&¢\u0006\u0002\u0010BJ%\u0010A\u001a\u0002H!\"\b\b\u0000\u0010!*\u00020\u00012\u0006\u00104\u001a\u00020&2\u0006\u0010C\u001a\u0002H!¢\u0006\u0002\u0010DJ\u0012\u0010E\u001a\u00020 2\n\u0010%\u001a\u00060&j\u0002`'J\u0014\u0010F\u001a\u0004\u0018\u00010 2\n\u0010%\u001a\u00060&j\u0002`'JL\u0010G\u001a\b\u0012\u0004\u0012\u0002H!0H\"\n\b\u0000\u0010!\u0018\u0001*\u00020\u00012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\b\b\u0002\u0010I\u001a\u00020J2\u0016\b\n\u00108\u001a\u0010\u0012\u0004\u0012\u00020:\u0018\u000109j\u0004\u0018\u0001`;H\u0086\bø\u0001\u0000JN\u0010K\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H!0H\"\n\b\u0000\u0010!\u0018\u0001*\u00020\u00012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\b\b\u0002\u0010I\u001a\u00020J2\u0016\b\n\u00108\u001a\u0010\u0012\u0004\u0012\u00020:\u0018\u000109j\u0004\u0018\u0001`;H\u0086\bø\u0001\u0000J\u001e\u0010L\u001a\u00020\u001d2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020N0.2\b\b\u0002\u00100\u001a\u000201J\u0016\u0010O\u001a\u00020\u001d2\u0006\u00104\u001a\u00020&2\u0006\u0010P\u001a\u00020\u0001J\u0010\u0010Q\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007J\u0014\u0010R\u001a\u00020\u001d2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020N0.R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0002\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u00020\u00188\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0002\u001a\u0004\b\u001a\u0010\u001b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006S"}, d2 = {"Lorg/koin/core/Koin;", "", "()V", "extensionManager", "Lorg/koin/core/extension/ExtensionManager;", "getExtensionManager$annotations", "getExtensionManager", "()Lorg/koin/core/extension/ExtensionManager;", "instanceRegistry", "Lorg/koin/core/registry/InstanceRegistry;", "getInstanceRegistry$annotations", "getInstanceRegistry", "()Lorg/koin/core/registry/InstanceRegistry;", "<set-?>", "Lorg/koin/core/logger/Logger;", SentryEvent.JsonKeys.LOGGER, "getLogger", "()Lorg/koin/core/logger/Logger;", "propertyRegistry", "Lorg/koin/core/registry/PropertyRegistry;", "getPropertyRegistry$annotations", "getPropertyRegistry", "()Lorg/koin/core/registry/PropertyRegistry;", "scopeRegistry", "Lorg/koin/core/registry/ScopeRegistry;", "getScopeRegistry$annotations", "getScopeRegistry", "()Lorg/koin/core/registry/ScopeRegistry;", "close", "", "createEagerInstances", "createScope", "Lorg/koin/core/scope/Scope;", ExifInterface.GPS_DIRECTION_TRUE, "Lorg/koin/core/component/KoinScopeComponent;", "t", "(Lorg/koin/core/component/KoinScopeComponent;)Lorg/koin/core/scope/Scope;", "scopeId", "", "Lorg/koin/core/scope/ScopeID;", "source", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "declare", "instance", "secondaryTypes", "", "Lkotlin/reflect/KClass;", "allowOverride", "", "(Ljava/lang/Object;Lorg/koin/core/qualifier/Qualifier;Ljava/util/List;Z)V", "deleteProperty", DatabaseConstants.KEY_FIELD, "deleteScope", "get", "clazz", "parameters", "Lkotlin/Function0;", "Lorg/koin/core/parameter/ParametersHolder;", "Lorg/koin/core/parameter/ParametersDefinition;", "(Lkotlin/reflect/KClass;Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "(Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getAll", "getOrCreateScope", "getOrNull", "getProperty", "(Ljava/lang/String;)Ljava/lang/Object;", "defaultValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "getScope", "getScopeOrNull", "inject", "Lkotlin/Lazy;", "mode", "Lkotlin/LazyThreadSafetyMode;", "injectOrNull", "loadModules", SentryEvent.JsonKeys.MODULES, "Lorg/koin/core/module/Module;", "setProperty", "value", "setupLogger", "unloadModules", "koin-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class Koin {
    private final ScopeRegistry scopeRegistry = new ScopeRegistry(this);
    private final InstanceRegistry instanceRegistry = new InstanceRegistry(this);
    private final PropertyRegistry propertyRegistry = new PropertyRegistry(this);
    private final ExtensionManager extensionManager = new ExtensionManager(this);
    private Logger logger = new EmptyLogger();

    public static /* synthetic */ void getExtensionManager$annotations() {
    }

    public static /* synthetic */ void getInstanceRegistry$annotations() {
    }

    public static /* synthetic */ void getPropertyRegistry$annotations() {
    }

    public static /* synthetic */ void getScopeRegistry$annotations() {
    }

    public final ScopeRegistry getScopeRegistry() {
        return this.scopeRegistry;
    }

    public final InstanceRegistry getInstanceRegistry() {
        return this.instanceRegistry;
    }

    public final PropertyRegistry getPropertyRegistry() {
        return this.propertyRegistry;
    }

    public final ExtensionManager getExtensionManager() {
        return this.extensionManager;
    }

    public final Logger getLogger() {
        return this.logger;
    }

    public final void setupLogger(Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.logger = logger;
    }

    public static /* synthetic */ Lazy inject$default(Koin koin, Qualifier qualifier, LazyThreadSafetyMode mode, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            mode = KoinPlatformTools.INSTANCE.defaultLazyMode();
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        Intrinsics.checkNotNullParameter(mode, "mode");
        Scope rootScope = koin.getScopeRegistry().getRootScope();
        Intrinsics.needClassReification();
        return LazyKt.lazy(mode, (Function0) new Koin$inject$$inlined$inject$1(rootScope, qualifier, function0));
    }

    public final /* synthetic */ <T> Lazy<T> inject(Qualifier qualifier, LazyThreadSafetyMode mode, Function0<? extends ParametersHolder> parameters) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Scope rootScope = getScopeRegistry().getRootScope();
        Intrinsics.needClassReification();
        return LazyKt.lazy(mode, (Function0) new Koin$inject$$inlined$inject$1(rootScope, qualifier, parameters));
    }

    public static /* synthetic */ Lazy injectOrNull$default(Koin koin, Qualifier qualifier, LazyThreadSafetyMode mode, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            mode = KoinPlatformTools.INSTANCE.defaultLazyMode();
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        Intrinsics.checkNotNullParameter(mode, "mode");
        Scope rootScope = koin.getScopeRegistry().getRootScope();
        Intrinsics.needClassReification();
        return LazyKt.lazy(mode, (Function0) new Koin$injectOrNull$$inlined$injectOrNull$1(rootScope, qualifier, function0));
    }

    public final /* synthetic */ <T> Lazy<T> injectOrNull(Qualifier qualifier, LazyThreadSafetyMode mode, Function0<? extends ParametersHolder> parameters) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Scope rootScope = getScopeRegistry().getRootScope();
        Intrinsics.needClassReification();
        return LazyKt.lazy(mode, (Function0) new Koin$injectOrNull$$inlined$injectOrNull$1(rootScope, qualifier, parameters));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object get$default(Koin koin, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        Scope rootScope = koin.getScopeRegistry().getRootScope();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return rootScope.get(Reflection.getOrCreateKotlinClass(Object.class), qualifier, function0);
    }

    public final /* synthetic */ <T> T get(Qualifier qualifier, Function0<? extends ParametersHolder> parameters) {
        Scope rootScope = getScopeRegistry().getRootScope();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) rootScope.get(Reflection.getOrCreateKotlinClass(Object.class), qualifier, parameters);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object getOrNull$default(Koin koin, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        Scope rootScope = koin.getScopeRegistry().getRootScope();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return rootScope.getOrNull(Reflection.getOrCreateKotlinClass(Object.class), qualifier, function0);
    }

    public final /* synthetic */ <T> T getOrNull(Qualifier qualifier, Function0<? extends ParametersHolder> parameters) {
        Scope rootScope = getScopeRegistry().getRootScope();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) rootScope.getOrNull(Reflection.getOrCreateKotlinClass(Object.class), qualifier, parameters);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object get$default(Koin koin, KClass kClass, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            qualifier = null;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        return koin.get(kClass, qualifier, function0);
    }

    public final <T> T get(KClass<?> clazz, Qualifier qualifier, Function0<? extends ParametersHolder> parameters) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return (T) this.scopeRegistry.getRootScope().get(clazz, qualifier, parameters);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object getOrNull$default(Koin koin, KClass kClass, Qualifier qualifier, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            qualifier = null;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        return koin.getOrNull(kClass, qualifier, function0);
    }

    public final <T> T getOrNull(KClass<?> clazz, Qualifier qualifier, Function0<? extends ParametersHolder> parameters) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return (T) this.scopeRegistry.getRootScope().getOrNull(clazz, qualifier, parameters);
    }

    public static /* synthetic */ void declare$default(Koin koin, Object obj, Qualifier qualifier, List list, boolean z, int i, Object obj2) {
        Qualifier qualifier2 = (i & 2) != 0 ? null : qualifier;
        List secondaryTypes = (i & 4) != 0 ? CollectionsKt.emptyList() : list;
        boolean z2 = (i & 8) != 0 ? true : z;
        Intrinsics.checkNotNullParameter(secondaryTypes, "secondaryTypes");
        InstanceRegistry instanceRegistry = koin.getInstanceRegistry();
        Qualifier scopeQualifier = instanceRegistry.get_koin().getScopeRegistry().getRootScope().getScopeQualifier();
        Kind kind = Kind.Scoped;
        Intrinsics.needClassReification();
        Koin$declare$$inlined$declareRootInstance$1 koin$declare$$inlined$declareRootInstance$1 = new Koin$declare$$inlined$declareRootInstance$1(obj);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        BeanDefinition beanDefinition = new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier2, koin$declare$$inlined$declareRootInstance$1, kind, secondaryTypes);
        SingleInstanceFactory singleInstanceFactory = new SingleInstanceFactory(beanDefinition);
        InstanceRegistry.saveMapping$default(instanceRegistry, z2, BeanDefinitionKt.indexKey(beanDefinition.getPrimaryType(), beanDefinition.getQualifier(), beanDefinition.getScopeQualifier()), singleInstanceFactory, false, 8, null);
        Iterator<T> it = beanDefinition.getSecondaryTypes().iterator();
        while (it.hasNext()) {
            InstanceRegistry.saveMapping$default(instanceRegistry, z2, BeanDefinitionKt.indexKey((KClass) it.next(), beanDefinition.getQualifier(), beanDefinition.getScopeQualifier()), singleInstanceFactory, false, 8, null);
        }
    }

    public final /* synthetic */ <T> void declare(T instance, Qualifier qualifier, List<? extends KClass<?>> secondaryTypes, boolean allowOverride) {
        Intrinsics.checkNotNullParameter(secondaryTypes, "secondaryTypes");
        InstanceRegistry instanceRegistry = getInstanceRegistry();
        Qualifier scopeQualifier = instanceRegistry.get_koin().getScopeRegistry().getRootScope().getScopeQualifier();
        Kind kind = Kind.Scoped;
        Intrinsics.needClassReification();
        Koin$declare$$inlined$declareRootInstance$1 koin$declare$$inlined$declareRootInstance$1 = new Koin$declare$$inlined$declareRootInstance$1(instance);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        BeanDefinition beanDefinition = new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, koin$declare$$inlined$declareRootInstance$1, kind, secondaryTypes);
        SingleInstanceFactory singleInstanceFactory = new SingleInstanceFactory(beanDefinition);
        InstanceRegistry.saveMapping$default(instanceRegistry, allowOverride, BeanDefinitionKt.indexKey(beanDefinition.getPrimaryType(), beanDefinition.getQualifier(), beanDefinition.getScopeQualifier()), singleInstanceFactory, false, 8, null);
        Iterator<T> it = beanDefinition.getSecondaryTypes().iterator();
        while (it.hasNext()) {
            InstanceRegistry.saveMapping$default(instanceRegistry, allowOverride, BeanDefinitionKt.indexKey((KClass) it.next(), beanDefinition.getQualifier(), beanDefinition.getScopeQualifier()), singleInstanceFactory, false, 8, null);
        }
    }

    public final /* synthetic */ <T> List<T> getAll() {
        Scope rootScope = getScopeRegistry().getRootScope();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return rootScope.getAll(Reflection.getOrCreateKotlinClass(Object.class));
    }

    public static /* synthetic */ Scope createScope$default(Koin koin, String str, Qualifier qualifier, Object obj, int i, Object obj2) {
        if ((i & 4) != 0) {
            obj = null;
        }
        return koin.createScope(str, qualifier, obj);
    }

    public final Scope createScope(String scopeId, Qualifier qualifier, Object source) {
        Intrinsics.checkNotNullParameter(scopeId, "scopeId");
        Intrinsics.checkNotNullParameter(qualifier, "qualifier");
        return this.scopeRegistry.createScope(scopeId, qualifier, source);
    }

    public static /* synthetic */ Scope createScope$default(Koin koin, String scopeId, Object obj, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        Intrinsics.checkNotNullParameter(scopeId, "scopeId");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return koin.getScopeRegistry().createScope(scopeId, new TypeQualifier(Reflection.getOrCreateKotlinClass(Object.class)), obj);
    }

    public final /* synthetic */ <T> Scope createScope(String scopeId, Object source) {
        Intrinsics.checkNotNullParameter(scopeId, "scopeId");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return getScopeRegistry().createScope(scopeId, new TypeQualifier(Reflection.getOrCreateKotlinClass(Object.class)), source);
    }

    public static /* synthetic */ Scope createScope$default(Koin koin, String scopeId, int i, Object obj) {
        if ((i & 1) != 0) {
            scopeId = KoinPlatformTools.INSTANCE.generateId();
        }
        Intrinsics.checkNotNullParameter(scopeId, "scopeId");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return koin.getScopeRegistry().createScope(scopeId, new TypeQualifier(Reflection.getOrCreateKotlinClass(Object.class)), null);
    }

    public final /* synthetic */ <T> Scope createScope(String scopeId) {
        Intrinsics.checkNotNullParameter(scopeId, "scopeId");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return getScopeRegistry().createScope(scopeId, new TypeQualifier(Reflection.getOrCreateKotlinClass(Object.class)), null);
    }

    public final <T extends KoinScopeComponent> Scope createScope(T t) {
        Intrinsics.checkNotNullParameter(t, "t");
        return this.scopeRegistry.createScope(KoinScopeComponentKt.getScopeId(t), KoinScopeComponentKt.getScopeName(t), null);
    }

    public static /* synthetic */ Scope getOrCreateScope$default(Koin koin, String str, Qualifier qualifier, Object obj, int i, Object obj2) {
        if ((i & 4) != 0) {
            obj = null;
        }
        return koin.getOrCreateScope(str, qualifier, obj);
    }

    public final Scope getOrCreateScope(String scopeId, Qualifier qualifier, Object source) {
        Intrinsics.checkNotNullParameter(scopeId, "scopeId");
        Intrinsics.checkNotNullParameter(qualifier, "qualifier");
        Scope scopeOrNull = this.scopeRegistry.getScopeOrNull(scopeId);
        return scopeOrNull == null ? createScope(scopeId, qualifier, source) : scopeOrNull;
    }

    public final /* synthetic */ <T> Scope getOrCreateScope(String scopeId) {
        Intrinsics.checkNotNullParameter(scopeId, "scopeId");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        TypeQualifier typeQualifier = new TypeQualifier(Reflection.getOrCreateKotlinClass(Object.class));
        Scope scopeOrNull = getScopeRegistry().getScopeOrNull(scopeId);
        return scopeOrNull == null ? createScope$default(this, scopeId, typeQualifier, null, 4, null) : scopeOrNull;
    }

    public final Scope getScope(String scopeId) {
        Intrinsics.checkNotNullParameter(scopeId, "scopeId");
        Scope scopeOrNull = this.scopeRegistry.getScopeOrNull(scopeId);
        if (scopeOrNull != null) {
            return scopeOrNull;
        }
        throw new ScopeNotCreatedException("No scope found for id '" + scopeId + '\'');
    }

    public final Scope getScopeOrNull(String scopeId) {
        Intrinsics.checkNotNullParameter(scopeId, "scopeId");
        return this.scopeRegistry.getScopeOrNull(scopeId);
    }

    public final void deleteScope(String scopeId) {
        Intrinsics.checkNotNullParameter(scopeId, "scopeId");
        this.scopeRegistry.deleteScope$koin_core(scopeId);
    }

    public final <T> T getProperty(String key, T defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        T t = (T) this.propertyRegistry.getProperty(key);
        return t == null ? defaultValue : t;
    }

    public final <T> T getProperty(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (T) this.propertyRegistry.getProperty(key);
    }

    public final void setProperty(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.propertyRegistry.saveProperty$koin_core(key, value);
    }

    public final void deleteProperty(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.propertyRegistry.deleteProperty(key);
    }

    public final void close() {
        this.scopeRegistry.close$koin_core();
        this.instanceRegistry.close$koin_core();
        this.propertyRegistry.close();
        this.extensionManager.close();
    }

    public static /* synthetic */ void loadModules$default(Koin koin, List list, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        koin.loadModules(list, z);
    }

    public final void loadModules(List<Module> modules, boolean allowOverride) {
        Intrinsics.checkNotNullParameter(modules, "modules");
        Set<Module> flatten$default = ModuleKt.flatten$default(modules, null, 2, null);
        this.instanceRegistry.loadModules$koin_core(flatten$default, allowOverride);
        this.scopeRegistry.loadScopes(flatten$default);
    }

    public final void unloadModules(List<Module> modules) {
        Intrinsics.checkNotNullParameter(modules, "modules");
        this.instanceRegistry.unloadModules$koin_core(ModuleKt.flatten$default(modules, null, 2, null));
    }

    public final void createEagerInstances() {
        Logger logger = this.logger;
        Level level = Level.DEBUG;
        if (logger.isAt(level)) {
            logger.display(level, "Eager instances ...");
        }
        long timeInNanoSeconds = KoinPlatformTimeTools.INSTANCE.getTimeInNanoSeconds();
        this.instanceRegistry.createAllEagerInstances$koin_core();
        double doubleValue = ((Number) new Pair(Unit.INSTANCE, Double.valueOf((KoinPlatformTimeTools.INSTANCE.getTimeInNanoSeconds() - timeInNanoSeconds) / 1000000.0d)).getSecond()).doubleValue();
        Logger logger2 = this.logger;
        String str = "Eager instances created in " + doubleValue + " ms";
        Level level2 = Level.DEBUG;
        if (logger2.isAt(level2)) {
            logger2.display(level2, str);
        }
    }
}
