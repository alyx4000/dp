package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
/* loaded from: classes2.dex */
public final class BinaryClassAnnotationAndConstantLoaderImplKt {
    public static final BinaryClassAnnotationAndConstantLoaderImpl createBinaryClassAnnotationAndConstantLoader(ModuleDescriptor module, NotFoundClasses notFoundClasses, StorageManager storageManager, KotlinClassFinder kotlinClassFinder, JvmMetadataVersion jvmMetadataVersion) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(kotlinClassFinder, "kotlinClassFinder");
        Intrinsics.checkNotNullParameter(jvmMetadataVersion, "jvmMetadataVersion");
        BinaryClassAnnotationAndConstantLoaderImpl binaryClassAnnotationAndConstantLoaderImpl = new BinaryClassAnnotationAndConstantLoaderImpl(module, notFoundClasses, storageManager, kotlinClassFinder);
        binaryClassAnnotationAndConstantLoaderImpl.setJvmMetadataVersion(jvmMetadataVersion);
        return binaryClassAnnotationAndConstantLoaderImpl;
    }
}
