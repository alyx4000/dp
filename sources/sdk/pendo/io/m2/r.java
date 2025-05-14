package sdk.pendo.io.m2;

import androidx.exifinterface.media.ExifInterface;
import java.lang.annotation.Annotation;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000B\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u001a\u0014\u0010\u0005\u001a\u00020\u0000*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0000\u001a'\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\t*\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0000¢\u0006\u0004\b\r\u0010\u000e\u001aG\u0010\u0016\u001a\u00020\u0014\"\u0004\b\u0000\u0010\t*\u00020\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010\u0012\u001a\u00028\u00002\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00140\u0013H\u0080\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, d2 = {"", "type", "Lsdk/pendo/io/l2/s;", "jsonTree", "", "a", "Lsdk/pendo/io/i2/f;", "Lsdk/pendo/io/l2/a;", "json", ExifInterface.GPS_DIRECTION_TRUE, "Lsdk/pendo/io/l2/g;", "Lsdk/pendo/io/g2/a;", "deserializer", "decodeSerializableValuePolymorphic", "(Lkotlinx/serialization/json/JsonDecoder;Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "", "Lsdk/pendo/io/g2/g;", "serializer", "value", "Lkotlin/Function1;", "", "ifPolymorphic", "encodePolymorphically", "(Lkotlinx/serialization/json/JsonEncoder;Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "kotlinx-serialization-json"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class r {
    public static final String a(sdk.pendo.io.i2.f fVar, sdk.pendo.io.l2.a json) {
        Intrinsics.checkNotNullParameter(fVar, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        for (Annotation annotation : fVar.getAnnotations()) {
            if (annotation instanceof sdk.pendo.io.l2.e) {
                return ((sdk.pendo.io.l2.e) annotation).discriminator();
            }
        }
        return json.getConfiguration().getClassDiscriminator();
    }

    public static final <T> T a(sdk.pendo.io.l2.g gVar, sdk.pendo.io.g2.a<T> deserializer) {
        sdk.pendo.io.l2.u a2;
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        if (!(deserializer instanceof sdk.pendo.io.k2.b) || gVar.getJson().getConfiguration().getUseArrayPolymorphism()) {
            return deserializer.deserialize(gVar);
        }
        sdk.pendo.io.l2.h g = gVar.g();
        sdk.pendo.io.i2.f descriptor = deserializer.getDescriptor();
        if (!(g instanceof sdk.pendo.io.l2.s)) {
            throw k.a(-1, "Expected " + Reflection.getOrCreateKotlinClass(sdk.pendo.io.l2.s.class) + " as the serialized body of " + descriptor.getSerialName() + ", but had " + Reflection.getOrCreateKotlinClass(g.getClass()));
        }
        sdk.pendo.io.l2.s sVar = (sdk.pendo.io.l2.s) g;
        String a3 = a(deserializer.getDescriptor(), gVar.getJson());
        sdk.pendo.io.l2.h hVar = (sdk.pendo.io.l2.h) sVar.get(a3);
        String content = (hVar == null || (a2 = sdk.pendo.io.l2.i.a(hVar)) == null) ? null : a2.getContent();
        sdk.pendo.io.g2.a<? extends T> a4 = ((sdk.pendo.io.k2.b) deserializer).a(gVar, content);
        if (a4 != null) {
            return (T) w.a(gVar.getJson(), a3, sVar, a4);
        }
        a(content, sVar);
        throw new KotlinNothingValueException();
    }

    private static final Void a(String str, sdk.pendo.io.l2.s sVar) {
        throw k.a(-1, Intrinsics.stringPlus("Polymorphic serializer was not found for ", str == null ? "missing class discriminator ('null')" : "class discriminator '" + ((Object) str) + '\''), sVar.toString());
    }
}
