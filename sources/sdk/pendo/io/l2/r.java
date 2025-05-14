package sdk.pendo.io.l2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.i2.j;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u001a\u0010\u000b\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lsdk/pendo/io/l2/r;", "Lsdk/pendo/io/g2/b;", "Lsdk/pendo/io/l2/q;", "Lsdk/pendo/io/j2/d;", "decoder", "a", "Lsdk/pendo/io/i2/f;", "b", "Lsdk/pendo/io/i2/f;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "<init>", "()V", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class r implements sdk.pendo.io.g2.b<q> {

    /* renamed from: a, reason: collision with root package name */
    public static final r f1309a = new r();

    /* renamed from: b, reason: from kotlin metadata */
    private static final sdk.pendo.io.i2.f descriptor = sdk.pendo.io.i2.i.a("external.sdk.pendo.io.kotlinx.serialization.json.JsonNull", j.b.f1196a, new sdk.pendo.io.i2.f[0], null, 8, null);

    private r() {
    }

    @Override // sdk.pendo.io.g2.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public q deserialize(sdk.pendo.io.j2.d decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        k.c(decoder);
        if (decoder.c()) {
            throw new sdk.pendo.io.m2.g("Expected 'null' literal");
        }
        decoder.k();
        return q.INSTANCE;
    }

    @Override // sdk.pendo.io.g2.b, sdk.pendo.io.g2.a
    public sdk.pendo.io.i2.f getDescriptor() {
        return descriptor;
    }
}
