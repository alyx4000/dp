package sdk.pendo.io.l2;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 *2\u00020\u0001:\u0001\u0015B\u0019\b\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\u001f\u001a\u00020\u001a¢\u0006\u0004\b(\u0010)J)\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0010\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0012\u001a\u00020\t\"\u0004\b\u0000\u0010\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001f\u001a\u00020\u001a8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR \u0010'\u001a\u00020 8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b!\u0010\"\u0012\u0004\b%\u0010&\u001a\u0004\b#\u0010$\u0082\u0001\u0002+,¨\u0006-"}, d2 = {"Lsdk/pendo/io/l2/a;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lsdk/pendo/io/g2/a;", "deserializer", "Lsdk/pendo/io/l2/h;", "element", "decodeFromJsonElement", "(Lkotlinx/serialization/DeserializationStrategy;Lkotlinx/serialization/json/JsonElement;)Ljava/lang/Object;", "", "string", "decodeFromString", "(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/String;)Ljava/lang/Object;", "Lsdk/pendo/io/g2/g;", "serializer", "value", "encodeToJsonElement", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Lkotlinx/serialization/json/JsonElement;", "encodeToString", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Ljava/lang/String;", "Lsdk/pendo/io/l2/f;", "a", "Lsdk/pendo/io/l2/f;", "getConfiguration", "()Lkotlinx/serialization/json/JsonConfiguration;", "configuration", "Lsdk/pendo/io/n2/c;", "b", "Lsdk/pendo/io/n2/c;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "Lsdk/pendo/io/m2/f;", "c", "Lsdk/pendo/io/m2/f;", "get_schemaCache$kotlinx_serialization_json", "()Lkotlinx/serialization/json/internal/DescriptorSchemaCache;", "get_schemaCache$kotlinx_serialization_json$annotations", "()V", "_schemaCache", "<init>", "(Lkotlinx/serialization/json/JsonConfiguration;Lkotlinx/serialization/modules/SerializersModule;)V", "d", "Lsdk/pendo/io/l2/a$a;", "Lsdk/pendo/io/l2/l;", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public abstract class a {

    /* renamed from: d, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final f configuration;

    /* renamed from: b, reason: from kotlin metadata */
    private final sdk.pendo.io.n2.c serializersModule;

    /* renamed from: c, reason: from kotlin metadata */
    private final sdk.pendo.io.m2.f _schemaCache;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lsdk/pendo/io/l2/a$a;", "Lsdk/pendo/io/l2/a;", "<init>", "()V", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0})
    /* renamed from: sdk.pendo.io.l2.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion extends a {
        private Companion() {
            super(new f(false, false, false, false, false, false, null, false, false, null, false, false, 4095, null), sdk.pendo.io.n2.e.a(), null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private a(f fVar, sdk.pendo.io.n2.c cVar) {
        this.configuration = fVar;
        this.serializersModule = cVar;
        this._schemaCache = new sdk.pendo.io.m2.f();
    }

    public final <T> T a(sdk.pendo.io.g2.a<T> deserializer, h element) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        Intrinsics.checkNotNullParameter(element, "element");
        return (T) sdk.pendo.io.m2.w.a(this, element, deserializer);
    }

    /* renamed from: b, reason: from getter */
    public sdk.pendo.io.n2.c getSerializersModule() {
        return this.serializersModule;
    }

    /* renamed from: c, reason: from getter */
    public final sdk.pendo.io.m2.f get_schemaCache() {
        return this._schemaCache;
    }

    public /* synthetic */ a(f fVar, sdk.pendo.io.n2.c cVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(fVar, cVar);
    }

    public final <T> T a(sdk.pendo.io.g2.a<T> deserializer, String string) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        Intrinsics.checkNotNullParameter(string, "string");
        sdk.pendo.io.m2.u uVar = new sdk.pendo.io.m2.u(string);
        T t = (T) new sdk.pendo.io.m2.t(this, sdk.pendo.io.m2.x.OBJ, uVar, deserializer.getDescriptor()).a(deserializer);
        uVar.k();
        return t;
    }

    /* renamed from: a, reason: from getter */
    public final f getConfiguration() {
        return this.configuration;
    }
}
