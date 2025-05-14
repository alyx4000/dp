package sdk.pendo.io.l2;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a)\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0002\b\u0005\u001a$\u0010\u000b\u001a\u00028\u0000\"\u0006\b\u0000\u0010\b\u0018\u0001*\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0086\b¢\u0006\u0004\b\u000b\u0010\f\u001a$\u0010\u000e\u001a\u00020\t\"\u0006\b\u0000\u0010\b\u0018\u0001*\u00020\u00002\u0006\u0010\r\u001a\u00028\u0000H\u0086\b¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lsdk/pendo/io/l2/a;", Constants.MessagePayloadKeys.FROM, "Lkotlin/Function1;", "Lsdk/pendo/io/l2/d;", "", "Lkotlin/ExtensionFunctionType;", "builderAction", "a", ExifInterface.GPS_DIRECTION_TRUE, "Lsdk/pendo/io/l2/h;", "json", "decodeFromJsonElement", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonElement;)Ljava/lang/Object;", "value", "encodeToJsonElement", "(Lkotlinx/serialization/json/Json;Ljava/lang/Object;)Lkotlinx/serialization/json/JsonElement;", "kotlinx-serialization-json"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class m {
    public static final a a(a from, Function1<? super d, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        d dVar = new d(from);
        builderAction.invoke(dVar);
        return new l(dVar.a(), dVar.getSerializersModule());
    }

    public static /* synthetic */ a a(a aVar, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            aVar = a.INSTANCE;
        }
        return a(aVar, function1);
    }
}
