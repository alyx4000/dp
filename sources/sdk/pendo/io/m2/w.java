package sdk.pendo.io.m2;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a7\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\n2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0000¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lsdk/pendo/io/l2/a;", "Lsdk/pendo/io/l2/h;", "element", "Lsdk/pendo/io/g2/a;", "deserializer", "readJson", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonElement;Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "", "discriminator", "Lsdk/pendo/io/l2/s;", "readPolymorphicJson", "(Lkotlinx/serialization/json/Json;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "kotlinx-serialization-json"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class w {
    public static final <T> T a(sdk.pendo.io.l2.a aVar, sdk.pendo.io.l2.h element, sdk.pendo.io.g2.a<T> deserializer) {
        sdk.pendo.io.j2.d mVar;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(element, "element");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        if (element instanceof sdk.pendo.io.l2.s) {
            mVar = new n(aVar, (sdk.pendo.io.l2.s) element, null, null, 12, null);
        } else if (element instanceof sdk.pendo.io.l2.b) {
            mVar = new o(aVar, (sdk.pendo.io.l2.b) element);
        } else {
            if (!(element instanceof sdk.pendo.io.l2.n ? true : Intrinsics.areEqual(element, sdk.pendo.io.l2.q.INSTANCE))) {
                throw new NoWhenBranchMatchedException();
            }
            mVar = new m(aVar, (sdk.pendo.io.l2.u) element);
        }
        return (T) mVar.a(deserializer);
    }

    public static final <T> T a(sdk.pendo.io.l2.a aVar, String discriminator, sdk.pendo.io.l2.s element, sdk.pendo.io.g2.a<T> deserializer) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(discriminator, "discriminator");
        Intrinsics.checkNotNullParameter(element, "element");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        return (T) new n(aVar, element, discriminator, deserializer.getDescriptor()).a((sdk.pendo.io.g2.a) deserializer);
    }
}
