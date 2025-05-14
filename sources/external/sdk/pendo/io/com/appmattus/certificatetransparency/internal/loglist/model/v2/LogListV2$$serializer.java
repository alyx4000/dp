package external.sdk.pendo.io.com.appmattus.certificatetransparency.internal.loglist.model.v2;

import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.g2.b;
import sdk.pendo.io.g2.h;
import sdk.pendo.io.h2.a;
import sdk.pendo.io.i2.f;
import sdk.pendo.io.j2.d;
import sdk.pendo.io.k2.d1;
import sdk.pendo.io.k2.e;
import sdk.pendo.io.k2.q0;
import sdk.pendo.io.k2.x;
import sdk.pendo.io.k2.z0;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002HÖ\u0001J\u001a\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000bHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u000f8VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"external/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/LogListV2.$serializer", "Lsdk/pendo/io/k2/x;", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/LogListV2;", "Lsdk/pendo/io/j2/d;", "decoder", "deserialize", "Lsdk/pendo/io/j2/e;", "encoder", "value", "", "serialize", "", "Lsdk/pendo/io/g2/b;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lsdk/pendo/io/i2/f;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "<init>", "()V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes2.dex */
public final class LogListV2$$serializer implements x<LogListV2> {
    public static final LogListV2$$serializer INSTANCE;
    public static final /* synthetic */ f descriptor;

    static {
        LogListV2$$serializer logListV2$$serializer = new LogListV2$$serializer();
        INSTANCE = logListV2$$serializer;
        q0 q0Var = new q0("external.sdk.pendo.io.com.appmattus.certificatetransparency.internal.loglist.model.v2.LogListV2", logListV2$$serializer, 2);
        q0Var.a("version", true);
        q0Var.a("operators", false);
        descriptor = q0Var;
    }

    private LogListV2$$serializer() {
    }

    @Override // sdk.pendo.io.k2.x
    public b<?>[] childSerializers() {
        return new b[]{a.b(d1.f1255a), new e(Operator$$serializer.INSTANCE)};
    }

    @Override // sdk.pendo.io.g2.a
    public LogListV2 deserialize(d decoder) {
        Object obj;
        Object obj2;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        f descriptor2 = getDescriptor();
        sdk.pendo.io.j2.b a2 = decoder.a(descriptor2);
        if (a2.e()) {
            obj = a2.a(descriptor2, 0, d1.f1255a, null);
            obj2 = a2.b(descriptor2, 1, new e(Operator$$serializer.INSTANCE), null);
            i = 3;
        } else {
            boolean z = true;
            int i2 = 0;
            obj = null;
            Object obj3 = null;
            while (z) {
                int e = a2.e(descriptor2);
                if (e == -1) {
                    z = false;
                } else if (e == 0) {
                    obj = a2.a(descriptor2, 0, d1.f1255a, obj);
                    i2 |= 1;
                } else {
                    if (e != 1) {
                        throw new h(e);
                    }
                    obj3 = a2.b(descriptor2, 1, new e(Operator$$serializer.INSTANCE), obj3);
                    i2 |= 2;
                }
            }
            obj2 = obj3;
            i = i2;
        }
        a2.c(descriptor2);
        return new LogListV2(i, (String) obj, (List) obj2, (z0) null);
    }

    @Override // sdk.pendo.io.g2.b, sdk.pendo.io.g2.a
    public f getDescriptor() {
        return descriptor;
    }

    public void serialize(sdk.pendo.io.j2.e encoder, LogListV2 value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        f descriptor2 = getDescriptor();
        encoder.a(descriptor2);
        LogListV2.write$Self(value, null, descriptor2);
        throw null;
    }

    @Override // sdk.pendo.io.k2.x
    public b<?>[] typeParametersSerializers() {
        return x.a.a(this);
    }
}
