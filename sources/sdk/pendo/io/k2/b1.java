package sdk.pendo.io.k2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.ShortCompanionObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0017\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0003B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\f\u0010\u0006\u001a\u00020\u0005*\u00020\u0002H\u0014J\b\u0010\u0007\u001a\u00020\u0002H\u0014J(\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0014¨\u0006\u0012"}, d2 = {"Lsdk/pendo/io/k2/b1;", "Lsdk/pendo/io/g2/b;", "", "Lsdk/pendo/io/k2/v0;", "", "Lsdk/pendo/io/k2/a1;", "a", "d", "Lsdk/pendo/io/j2/b;", "decoder", "", "index", "builder", "", "checkIndex", "", "<init>", "()V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class b1 extends v0<Short, short[], a1> {
    public static final b1 c = new b1();

    private b1() {
        super(sdk.pendo.io.h2.a.a(ShortCompanionObject.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sdk.pendo.io.k2.v0
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public short[] c() {
        return new short[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sdk.pendo.io.k2.f0, sdk.pendo.io.k2.a
    public void a(sdk.pendo.io.j2.b decoder, int index, a1 builder, boolean checkIndex) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.a(decoder.d(getDescriptor(), index));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sdk.pendo.io.k2.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a1 b(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return new a1(sArr);
    }
}
