package sdk.pendo.io.n2;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import sdk.pendo.io.actions.GuideActionConfiguration;
import sdk.pendo.io.g2.g;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J.\u0010\b\u001a\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016JQ\u0010\u000f\u001a\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032/\u0010\u000e\u001a+\u0012\u001d\u0012\u001b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\tH&JF\u0010\b\u001a\u00020\u0007\"\b\b\u0000\u0010\u0010*\u00020\u0001\"\b\b\u0001\u0010\u0011*\u00028\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H&JK\u0010\u0018\u001a\u00020\u0007\"\b\b\u0000\u0010\u0010*\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032)\u0010\u0017\u001a%\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0015\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00160\tH'JO\u0010\b\u001a\u00020\u0007\"\b\b\u0000\u0010\u0010*\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032-\u0010\u001c\u001a)\u0012\u0015\u0012\u0013\u0018\u00010\u0019¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001a\u0012\u000e\u0012\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u001b0\tH'¨\u0006\u001d"}, d2 = {"Lsdk/pendo/io/n2/d;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/KClass;", "kClass", "Lsdk/pendo/io/g2/b;", "serializer", "", "a", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "typeArgumentsSerializers", "provider", "b", GuideActionConfiguration.GUIDE_WIDGET_BASE_BUILDING_BLOCK_NAME, "Sub", "baseClass", "actualClass", "actualSerializer", "value", "Lsdk/pendo/io/g2/g;", "defaultSerializerProvider", "c", "", "className", "Lsdk/pendo/io/g2/a;", "defaultDeserializerProvider", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public interface d {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0003\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "", "Lsdk/pendo/io/g2/b;", "it", "a", "(Ljava/util/List;)Lsdk/pendo/io/g2/b;"}, k = 3, mv = {1, 6, 0})
        /* renamed from: sdk.pendo.io.n2.d$a$a, reason: collision with other inner class name */
        static final class C0204a extends Lambda implements Function1<List<? extends sdk.pendo.io.g2.b<?>>, sdk.pendo.io.g2.b<?>> {
            final /* synthetic */ sdk.pendo.io.g2.b<T> f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0204a(sdk.pendo.io.g2.b<T> bVar) {
                super(1);
                this.f = bVar;
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final sdk.pendo.io.g2.b<?> invoke(List<? extends sdk.pendo.io.g2.b<?>> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return this.f;
            }
        }

        public static <T> void a(d dVar, KClass<T> kClass, sdk.pendo.io.g2.b<T> serializer) {
            Intrinsics.checkNotNullParameter(dVar, "this");
            Intrinsics.checkNotNullParameter(kClass, "kClass");
            Intrinsics.checkNotNullParameter(serializer, "serializer");
            dVar.b(kClass, new C0204a(serializer));
        }
    }

    <Base> void a(KClass<Base> baseClass, Function1<? super String, ? extends sdk.pendo.io.g2.a<? extends Base>> defaultDeserializerProvider);

    <Base, Sub extends Base> void a(KClass<Base> baseClass, KClass<Sub> actualClass, sdk.pendo.io.g2.b<Sub> actualSerializer);

    <T> void a(KClass<T> kClass, sdk.pendo.io.g2.b<T> serializer);

    <T> void b(KClass<T> kClass, Function1<? super List<? extends sdk.pendo.io.g2.b<?>>, ? extends sdk.pendo.io.g2.b<?>> provider);

    <Base> void c(KClass<Base> baseClass, Function1<? super Base, ? extends g<? super Base>> defaultSerializerProvider);
}
