package sdk.pendo.io.k2;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0001J \u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0096\u0001¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lsdk/pendo/io/k2/f1;", "Lsdk/pendo/io/g2/b;", "", "Lsdk/pendo/io/j2/d;", "decoder", "a", "Lsdk/pendo/io/j2/e;", "encoder", "value", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lkotlin/Unit;)V", "Lsdk/pendo/io/i2/f;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "<init>", "()V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class f1 implements sdk.pendo.io.g2.b<Unit> {
    public static final f1 b = new f1();

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ n0<Unit> f1260a = new n0<>("kotlin.Unit", Unit.INSTANCE);

    private f1() {
    }

    public void a(sdk.pendo.io.j2.d decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        this.f1260a.deserialize(decoder);
    }

    @Override // sdk.pendo.io.g2.a
    public /* bridge */ /* synthetic */ Object deserialize(sdk.pendo.io.j2.d dVar) {
        a(dVar);
        return Unit.INSTANCE;
    }

    @Override // sdk.pendo.io.g2.b, sdk.pendo.io.g2.a
    public sdk.pendo.io.i2.f getDescriptor() {
        return this.f1260a.getDescriptor();
    }
}
