package external.sdk.pendo.io.com.appmattus.certificatetransparency.internal.loglist.model.v2;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.g2.b;
import sdk.pendo.io.g2.h;
import sdk.pendo.io.i2.f;
import sdk.pendo.io.j2.d;
import sdk.pendo.io.j2.e;
import sdk.pendo.io.k2.a0;
import sdk.pendo.io.k2.d1;
import sdk.pendo.io.k2.q0;
import sdk.pendo.io.k2.x;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002HÖ\u0001J\u001a\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000bHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u000f8VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"external/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/FinalTreeHead.$serializer", "Lsdk/pendo/io/k2/x;", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/FinalTreeHead;", "Lsdk/pendo/io/j2/d;", "decoder", "deserialize", "Lsdk/pendo/io/j2/e;", "encoder", "value", "", "serialize", "", "Lsdk/pendo/io/g2/b;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lsdk/pendo/io/i2/f;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "<init>", "()V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes2.dex */
public final class FinalTreeHead$$serializer implements x<FinalTreeHead> {
    public static final FinalTreeHead$$serializer INSTANCE;
    public static final /* synthetic */ f descriptor;

    static {
        FinalTreeHead$$serializer finalTreeHead$$serializer = new FinalTreeHead$$serializer();
        INSTANCE = finalTreeHead$$serializer;
        q0 q0Var = new q0("external.sdk.pendo.io.com.appmattus.certificatetransparency.internal.loglist.model.v2.FinalTreeHead", finalTreeHead$$serializer, 2);
        q0Var.a("tree_size", false);
        q0Var.a("sha256_root_hash", false);
        descriptor = q0Var;
    }

    private FinalTreeHead$$serializer() {
    }

    @Override // sdk.pendo.io.k2.x
    public b<?>[] childSerializers() {
        return new b[]{a0.f1252a, d1.f1255a};
    }

    @Override // sdk.pendo.io.g2.a
    public FinalTreeHead deserialize(d decoder) {
        int i;
        String str;
        int i2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        f descriptor2 = getDescriptor();
        sdk.pendo.io.j2.b a2 = decoder.a(descriptor2);
        if (a2.e()) {
            i = a2.h(descriptor2, 0);
            str = a2.a(descriptor2, 1);
            i2 = 3;
        } else {
            boolean z = true;
            i = 0;
            int i3 = 0;
            String str2 = null;
            while (z) {
                int e = a2.e(descriptor2);
                if (e == -1) {
                    z = false;
                } else if (e == 0) {
                    i = a2.h(descriptor2, 0);
                    i3 |= 1;
                } else {
                    if (e != 1) {
                        throw new h(e);
                    }
                    str2 = a2.a(descriptor2, 1);
                    i3 |= 2;
                }
            }
            str = str2;
            i2 = i3;
        }
        a2.c(descriptor2);
        return new FinalTreeHead(i2, i, str, null);
    }

    @Override // sdk.pendo.io.g2.b, sdk.pendo.io.g2.a
    public f getDescriptor() {
        return descriptor;
    }

    public void serialize(e encoder, FinalTreeHead value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        f descriptor2 = getDescriptor();
        encoder.a(descriptor2);
        FinalTreeHead.write$Self(value, null, descriptor2);
        throw null;
    }

    @Override // sdk.pendo.io.k2.x
    public b<?>[] typeParametersSerializers() {
        return x.a.a(this);
    }
}
