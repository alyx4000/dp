package external.sdk.pendo.io.com.appmattus.certificatetransparency.internal.loglist.model.v2;

import com.amplitude.reactnative.DatabaseConstants;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.g.d;
import sdk.pendo.io.g2.b;
import sdk.pendo.io.g2.h;
import sdk.pendo.io.h2.a;
import sdk.pendo.io.i2.f;
import sdk.pendo.io.j2.e;
import sdk.pendo.io.k2.a0;
import sdk.pendo.io.k2.d1;
import sdk.pendo.io.k2.q0;
import sdk.pendo.io.k2.x;
import sdk.pendo.io.k2.z0;
import sdk.pendo.io.w2.v;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002HÖ\u0001J\u001a\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000bHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u000f8VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"external/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/Log.$serializer", "Lsdk/pendo/io/k2/x;", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/Log;", "Lsdk/pendo/io/j2/d;", "decoder", "deserialize", "Lsdk/pendo/io/j2/e;", "encoder", "value", "", "serialize", "", "Lsdk/pendo/io/g2/b;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lsdk/pendo/io/i2/f;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "<init>", "()V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes2.dex */
public final class Log$$serializer implements x<Log> {
    public static final Log$$serializer INSTANCE;
    public static final /* synthetic */ f descriptor;

    static {
        Log$$serializer log$$serializer = new Log$$serializer();
        INSTANCE = log$$serializer;
        q0 q0Var = new q0("external.sdk.pendo.io.com.appmattus.certificatetransparency.internal.loglist.model.v2.Log", log$$serializer, 9);
        q0Var.a("description", true);
        q0Var.a(DatabaseConstants.KEY_FIELD, false);
        q0Var.a("log_id", false);
        q0Var.a("mmd", false);
        q0Var.a("url", false);
        q0Var.a("dns", true);
        q0Var.a("temporal_interval", true);
        q0Var.a("log_type", true);
        q0Var.a("state", true);
        descriptor = q0Var;
    }

    private Log$$serializer() {
    }

    @Override // sdk.pendo.io.k2.x
    public b<?>[] childSerializers() {
        d1 d1Var = d1.f1255a;
        return new b[]{a.b(d1Var), d1Var, d1Var, a0.f1252a, new sdk.pendo.io.g.b(), a.b(Hostname.INSTANCE.serializer()), a.b(TemporalInterval$$serializer.INSTANCE), a.b(LogType$$serializer.INSTANCE), a.b(new d())};
    }

    @Override // sdk.pendo.io.g2.a
    public Log deserialize(sdk.pendo.io.j2.d decoder) {
        int i;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        String str;
        String str2;
        int i2;
        Object obj6;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        f descriptor2 = getDescriptor();
        sdk.pendo.io.j2.b a2 = decoder.a(descriptor2);
        int i3 = 7;
        int i4 = 6;
        if (a2.e()) {
            obj6 = a2.a(descriptor2, 0, d1.f1255a, null);
            String a3 = a2.a(descriptor2, 1);
            String a4 = a2.a(descriptor2, 2);
            int h = a2.h(descriptor2, 3);
            obj5 = a2.b(descriptor2, 4, new sdk.pendo.io.g.b(), null);
            obj4 = a2.a(descriptor2, 5, Hostname.INSTANCE.serializer(), null);
            obj3 = a2.a(descriptor2, 6, TemporalInterval$$serializer.INSTANCE, null);
            obj = a2.a(descriptor2, 7, LogType$$serializer.INSTANCE, null);
            obj2 = a2.a(descriptor2, 8, new d(), null);
            i = 511;
            i2 = h;
            str2 = a4;
            str = a3;
        } else {
            boolean z = true;
            int i5 = 0;
            Object obj7 = null;
            Object obj8 = null;
            Object obj9 = null;
            Object obj10 = null;
            Object obj11 = null;
            String str3 = null;
            String str4 = null;
            Object obj12 = null;
            i = 0;
            while (z) {
                int e = a2.e(descriptor2);
                switch (e) {
                    case -1:
                        z = false;
                        i4 = 6;
                    case 0:
                        obj11 = a2.a(descriptor2, 0, d1.f1255a, obj11);
                        i |= 1;
                        i3 = 7;
                        i4 = 6;
                    case 1:
                        i |= 2;
                        str3 = a2.a(descriptor2, 1);
                        i3 = 7;
                    case 2:
                        i |= 4;
                        str4 = a2.a(descriptor2, 2);
                        i3 = 7;
                    case 3:
                        i5 = a2.h(descriptor2, 3);
                        i |= 8;
                        i3 = 7;
                    case 4:
                        obj12 = a2.b(descriptor2, 4, new sdk.pendo.io.g.b(), obj12);
                        i |= 16;
                        i3 = 7;
                    case 5:
                        obj10 = a2.a(descriptor2, 5, Hostname.INSTANCE.serializer(), obj10);
                        i |= 32;
                        i3 = 7;
                    case 6:
                        obj9 = a2.a(descriptor2, i4, TemporalInterval$$serializer.INSTANCE, obj9);
                        i |= 64;
                    case 7:
                        obj7 = a2.a(descriptor2, i3, LogType$$serializer.INSTANCE, obj7);
                        i |= 128;
                    case 8:
                        obj8 = a2.a(descriptor2, 8, new d(), obj8);
                        i |= 256;
                    default:
                        throw new h(e);
                }
            }
            obj = obj7;
            obj2 = obj8;
            obj3 = obj9;
            obj4 = obj10;
            obj5 = obj12;
            str = str3;
            str2 = str4;
            i2 = i5;
            obj6 = obj11;
        }
        a2.c(descriptor2);
        return new Log(i, (String) obj6, str, str2, i2, (v) obj5, (Hostname) obj4, (TemporalInterval) obj3, (LogType) obj, (State) obj2, (z0) null);
    }

    @Override // sdk.pendo.io.g2.b, sdk.pendo.io.g2.a
    public f getDescriptor() {
        return descriptor;
    }

    public void serialize(e encoder, Log value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        f descriptor2 = getDescriptor();
        encoder.a(descriptor2);
        Log.write$Self(value, null, descriptor2);
        throw null;
    }

    @Override // sdk.pendo.io.k2.x
    public b<?>[] typeParametersSerializers() {
        return x.a.a(this);
    }
}
