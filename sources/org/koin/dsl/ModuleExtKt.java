package org.koin.dsl;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.annotation.KoinReflectAPI;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.definition.KoinDefinition;
import org.koin.core.instance.FactoryInstanceFactory;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.module.Module;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.qualifier.StringQualifier;
import org.koin.core.registry.ScopeRegistry;

/* compiled from: ModuleExt.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a+\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0087\b\u001a5\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\tH\u0087\b¨\u0006\n"}, d2 = {"factory", "Lorg/koin/core/definition/KoinDefinition;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lorg/koin/core/module/Module;", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "single", "createOnStart", "", "koin-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ModuleExtKt {
    public static /* synthetic */ KoinDefinition single$default(Module module, Qualifier qualifier, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        Qualifier qualifier2 = qualifier;
        if ((i & 2) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.needClassReification();
        ModuleExtKt$single$1 moduleExtKt$single$1 = ModuleExtKt$single$1.INSTANCE;
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier2, moduleExtKt$single$1, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (z || module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return new KoinDefinition(module, singleInstanceFactory2);
    }

    @Deprecated(message = "API is deprecated in favor of singleOf DSL")
    @KoinReflectAPI
    public static final /* synthetic */ <T> KoinDefinition<T> single(Module module, Qualifier qualifier, boolean z) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.needClassReification();
        ModuleExtKt$single$1 moduleExtKt$single$1 = ModuleExtKt$single$1.INSTANCE;
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Singleton;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        SingleInstanceFactory<?> singleInstanceFactory = new SingleInstanceFactory<>(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, moduleExtKt$single$1, kind, emptyList));
        SingleInstanceFactory<?> singleInstanceFactory2 = singleInstanceFactory;
        module.indexPrimaryType(singleInstanceFactory2);
        if (z || module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        return new KoinDefinition<>(module, singleInstanceFactory2);
    }

    public static /* synthetic */ KoinDefinition factory$default(Module module, Qualifier qualifier, int i, Object obj) {
        if ((i & 1) != 0) {
            qualifier = null;
        }
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.needClassReification();
        ModuleExtKt$factory$1 moduleExtKt$factory$1 = ModuleExtKt$factory$1.INSTANCE;
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, moduleExtKt$factory$1, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new KoinDefinition(module, factoryInstanceFactory);
    }

    @Deprecated(message = "API is deprecated in favor of factoryOf DSL")
    @KoinReflectAPI
    public static final /* synthetic */ <T> KoinDefinition<T> factory(Module module, Qualifier qualifier) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.needClassReification();
        ModuleExtKt$factory$1 moduleExtKt$factory$1 = ModuleExtKt$factory$1.INSTANCE;
        StringQualifier rootScopeQualifier = ScopeRegistry.INSTANCE.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), qualifier, moduleExtKt$factory$1, kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new KoinDefinition<>(module, factoryInstanceFactory);
    }
}
