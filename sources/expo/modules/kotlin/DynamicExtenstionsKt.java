package expo.modules.kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.DynamicFromObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DynamicExtenstions.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0005*\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00050\b¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\n\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, d2 = {"DynamicNull", "Lcom/facebook/react/bridge/DynamicFromObject;", "getDynamicNull", "()Lcom/facebook/react/bridge/DynamicFromObject;", "recycle", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/facebook/react/bridge/Dynamic;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lcom/facebook/react/bridge/Dynamic;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "expo-modules-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DynamicExtenstionsKt {
    private static final DynamicFromObject DynamicNull = new DynamicFromObject(null);

    public static final <T> T recycle(Dynamic dynamic, Function1<? super Dynamic, ? extends T> block) {
        Intrinsics.checkNotNullParameter(dynamic, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            return block.invoke(dynamic);
        } finally {
            InlineMarker.finallyStart(1);
            dynamic.recycle();
            InlineMarker.finallyEnd(1);
        }
    }

    public static final DynamicFromObject getDynamicNull() {
        return DynamicNull;
    }
}
