package expo.modules.core.utilities;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KotlinUtilities.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u0004\u0018\u0001H\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0003H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a\u001e\u0010\u0005\u001a\u0004\u0018\u0001H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u0004\u0018\u00010\u0006H\u0086\b¢\u0006\u0002\u0010\u0007\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\b"}, d2 = {"ifNull", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "takeIfInstanceOf", "", "(Ljava/lang/Object;)Ljava/lang/Object;", "expo-modules-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class KotlinUtilitiesKt {
    public static final <T> T ifNull(T t, Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return t == null ? block.invoke() : t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <T> T takeIfInstanceOf(Object obj) {
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        if (obj instanceof Object) {
            return obj;
        }
        return null;
    }
}
