package sdk.pendo.io.m2;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import sdk.pendo.io.actions.GuideActionConfiguration;
import sdk.pendo.io.i2.j;
import sdk.pendo.io.i2.k;
import sdk.pendo.io.n2.d;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010!\u001a\u00020\u001f\u0012\u0006\u0010#\u001a\u00020\u001b¢\u0006\u0004\b$\u0010%J\u001c\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002J\u001c\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002JQ\u0010\u0007\u001a\u00020\u0006\"\b\b\u0000\u0010\n*\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042/\u0010\u0012\u001a+\u0012\u001d\u0012\u001b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\r¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\fH\u0016JF\u0010\b\u001a\u00020\u0006\"\b\b\u0000\u0010\u0013*\u00020\t\"\b\b\u0001\u0010\u0014*\u00028\u00002\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u000eH\u0016JK\u0010\u001a\u001a\u00020\u0006\"\b\b\u0000\u0010\u0013*\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042)\u0010\u0019\u001a%\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0017\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00180\fH\u0016JO\u0010\b\u001a\u00020\u0006\"\b\b\u0000\u0010\u0013*\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042-\u0010\u001e\u001a)\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u001c\u0012\u000e\u0012\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u001d0\fH\u0016R\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010 R\u0014\u0010#\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\"¨\u0006&"}, d2 = {"Lsdk/pendo/io/m2/s;", "Lsdk/pendo/io/n2/d;", "Lsdk/pendo/io/i2/f;", "descriptor", "Lkotlin/reflect/KClass;", "actualClass", "", "b", "a", "", ExifInterface.GPS_DIRECTION_TRUE, "kClass", "Lkotlin/Function1;", "", "Lsdk/pendo/io/g2/b;", "Lkotlin/ParameterName;", "name", "typeArgumentsSerializers", "provider", GuideActionConfiguration.GUIDE_WIDGET_BASE_BUILDING_BLOCK_NAME, "Sub", "baseClass", "actualSerializer", "value", "Lsdk/pendo/io/g2/g;", "defaultSerializerProvider", "c", "", "className", "Lsdk/pendo/io/g2/a;", "defaultDeserializerProvider", "", "Z", "useArrayPolymorphism", "Ljava/lang/String;", "discriminator", "<init>", "(ZLjava/lang/String;)V", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class s implements sdk.pendo.io.n2.d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean useArrayPolymorphism;

    /* renamed from: b, reason: from kotlin metadata */
    private final String discriminator;

    public s(boolean z, String discriminator) {
        Intrinsics.checkNotNullParameter(discriminator, "discriminator");
        this.useArrayPolymorphism = z;
        this.discriminator = discriminator;
    }

    private final void a(sdk.pendo.io.i2.f descriptor, KClass<?> actualClass) {
        int elementsCount = descriptor.getElementsCount();
        int i = 0;
        while (i < elementsCount) {
            int i2 = i + 1;
            String a2 = descriptor.a(i);
            if (Intrinsics.areEqual(a2, this.discriminator)) {
                throw new IllegalArgumentException("Polymorphic serializer for " + actualClass + " has property '" + a2 + "' that conflicts with JSON class discriminator. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism");
            }
            i = i2;
        }
    }

    private final void b(sdk.pendo.io.i2.f descriptor, KClass<?> actualClass) {
        sdk.pendo.io.i2.j kind = descriptor.getKind();
        if ((kind instanceof sdk.pendo.io.i2.d) || Intrinsics.areEqual(kind, j.a.f1195a)) {
            throw new IllegalArgumentException("Serializer for " + ((Object) actualClass.getSimpleName()) + " can't be registered as a subclass for polymorphic serialization because its kind " + kind + " is not concrete. To work with multiple hierarchies, register it as a base class.");
        }
        if (this.useArrayPolymorphism) {
            return;
        }
        if (Intrinsics.areEqual(kind, k.b.f1198a) || Intrinsics.areEqual(kind, k.c.f1199a) || (kind instanceof sdk.pendo.io.i2.e) || (kind instanceof j.b)) {
            throw new IllegalArgumentException("Serializer for " + ((Object) actualClass.getSimpleName()) + " of kind " + kind + " cannot be serialized polymorphically with class discriminator.");
        }
    }

    @Override // sdk.pendo.io.n2.d
    public <Base> void c(KClass<Base> baseClass, Function1<? super Base, ? extends sdk.pendo.io.g2.g<? super Base>> defaultSerializerProvider) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(defaultSerializerProvider, "defaultSerializerProvider");
    }

    @Override // sdk.pendo.io.n2.d
    public <T> void a(KClass<T> kClass, sdk.pendo.io.g2.b<T> bVar) {
        d.a.a(this, kClass, bVar);
    }

    @Override // sdk.pendo.io.n2.d
    public <T> void b(KClass<T> kClass, Function1<? super List<? extends sdk.pendo.io.g2.b<?>>, ? extends sdk.pendo.io.g2.b<?>> provider) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(provider, "provider");
    }

    @Override // sdk.pendo.io.n2.d
    public <Base, Sub extends Base> void a(KClass<Base> baseClass, KClass<Sub> actualClass, sdk.pendo.io.g2.b<Sub> actualSerializer) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(actualClass, "actualClass");
        Intrinsics.checkNotNullParameter(actualSerializer, "actualSerializer");
        sdk.pendo.io.i2.f descriptor = actualSerializer.getDescriptor();
        b(descriptor, (KClass<?>) actualClass);
        if (this.useArrayPolymorphism) {
            return;
        }
        a(descriptor, (KClass<?>) actualClass);
    }

    @Override // sdk.pendo.io.n2.d
    public <Base> void a(KClass<Base> baseClass, Function1<? super String, ? extends sdk.pendo.io.g2.a<? extends Base>> defaultDeserializerProvider) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(defaultDeserializerProvider, "defaultDeserializerProvider");
    }
}
