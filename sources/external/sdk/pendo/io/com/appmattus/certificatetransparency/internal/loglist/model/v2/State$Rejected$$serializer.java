package external.sdk.pendo.io.com.appmattus.certificatetransparency.internal.loglist.model.v2;

import external.sdk.pendo.io.com.appmattus.certificatetransparency.internal.loglist.model.v2.State;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.g.c;
import sdk.pendo.io.g2.b;
import sdk.pendo.io.g2.h;
import sdk.pendo.io.i2.f;
import sdk.pendo.io.j2.d;
import sdk.pendo.io.j2.e;
import sdk.pendo.io.k2.q0;
import sdk.pendo.io.k2.x;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002HÖ\u0001J\u001a\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000bHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u000f8VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"external/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/State.Rejected.$serializer", "Lsdk/pendo/io/k2/x;", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/State$Rejected;", "Lsdk/pendo/io/j2/d;", "decoder", "deserialize", "Lsdk/pendo/io/j2/e;", "encoder", "value", "", "serialize", "", "Lsdk/pendo/io/g2/b;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lsdk/pendo/io/i2/f;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "<init>", "()V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes2.dex */
public final class State$Rejected$$serializer implements x<State.Rejected> {
    public static final State$Rejected$$serializer INSTANCE;
    public static final /* synthetic */ f descriptor;

    static {
        State$Rejected$$serializer state$Rejected$$serializer = new State$Rejected$$serializer();
        INSTANCE = state$Rejected$$serializer;
        q0 q0Var = new q0("rejected", state$Rejected$$serializer, 1);
        q0Var.a("timestamp", false);
        descriptor = q0Var;
    }

    private State$Rejected$$serializer() {
    }

    @Override // sdk.pendo.io.k2.x
    public b<?>[] childSerializers() {
        return new b[]{new c()};
    }

    @Override // sdk.pendo.io.g2.a
    public State.Rejected deserialize(d decoder) {
        long j;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        f descriptor2 = getDescriptor();
        sdk.pendo.io.j2.b a2 = decoder.a(descriptor2);
        int i = 1;
        long j2 = 0;
        if (a2.e()) {
            j = ((Number) a2.b(descriptor2, 0, new c(), 0L)).longValue();
        } else {
            int i2 = 0;
            while (i != 0) {
                int e = a2.e(descriptor2);
                if (e == -1) {
                    i = 0;
                } else {
                    if (e != 0) {
                        throw new h(e);
                    }
                    j2 = ((Number) a2.b(descriptor2, 0, new c(), Long.valueOf(j2))).longValue();
                    i2 |= 1;
                }
            }
            i = i2;
            j = j2;
        }
        a2.c(descriptor2);
        return new State.Rejected(i, j, null);
    }

    @Override // sdk.pendo.io.g2.b, sdk.pendo.io.g2.a
    public f getDescriptor() {
        return descriptor;
    }

    public void serialize(e encoder, State.Rejected value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        f descriptor2 = getDescriptor();
        encoder.a(descriptor2);
        State.Rejected.write$Self(value, (sdk.pendo.io.j2.c) null, descriptor2);
        throw null;
    }

    @Override // sdk.pendo.io.k2.x
    public b<?>[] typeParametersSerializers() {
        return x.a.a(this);
    }
}
