package sdk.pendo.io.n2;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0014\u0010\u0015J<\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0012\b\u0002\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005H'J6\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\f\"\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0010\t\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\nH'J\u0010\u0010\b\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH'J9\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0011\"\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0010\t\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00032\u0006\u0010\u0010\u001a\u00028\u0000H'¢\u0006\u0004\b\u0012\u0010\u0013\u0082\u0001\u0001\u0016¨\u0006\u0017"}, d2 = {"Lsdk/pendo/io/n2/c;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/KClass;", "kClass", "", "Lsdk/pendo/io/g2/b;", "typeArgumentsSerializers", "a", "baseClass", "", "serializedClassName", "Lsdk/pendo/io/g2/a;", "Lsdk/pendo/io/n2/d;", "collector", "", "value", "Lsdk/pendo/io/g2/g;", "getPolymorphic", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "<init>", "()V", "Lsdk/pendo/io/n2/b;", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public abstract class c {
    private c() {
    }

    public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ sdk.pendo.io.g2.b a(c cVar, KClass kClass, List list, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContextual");
        }
        if ((i & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        return cVar.a(kClass, (List<? extends sdk.pendo.io.g2.b<?>>) list);
    }

    public abstract <T> sdk.pendo.io.g2.a<? extends T> a(KClass<? super T> baseClass, String serializedClassName);

    public abstract <T> sdk.pendo.io.g2.b<T> a(KClass<T> kClass, List<? extends sdk.pendo.io.g2.b<?>> typeArgumentsSerializers);

    public abstract void a(d collector);
}
