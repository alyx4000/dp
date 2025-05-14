package sdk.pendo.io.k2;

import kotlin.Metadata;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0003B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\f\u0010\u0006\u001a\u00020\u0005*\u00020\u0002H\u0014J\b\u0010\u0007\u001a\u00020\u0002H\u0014J(\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0004H\u0014¨\u0006\u0011"}, d2 = {"Lsdk/pendo/io/k2/g;", "Lsdk/pendo/io/g2/b;", "", "Lsdk/pendo/io/k2/v0;", "", "Lsdk/pendo/io/k2/f;", "a", "d", "Lsdk/pendo/io/j2/b;", "decoder", "", "index", "builder", "checkIndex", "", "<init>", "()V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class g extends v0<Boolean, boolean[], f> {
    public static final g c = new g();

    private g() {
        super(sdk.pendo.io.h2.a.a(BooleanCompanionObject.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sdk.pendo.io.k2.v0
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean[] c() {
        return new boolean[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sdk.pendo.io.k2.f0, sdk.pendo.io.k2.a
    public void a(sdk.pendo.io.j2.b decoder, int index, f builder, boolean checkIndex) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.a(decoder.f(getDescriptor(), index));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sdk.pendo.io.k2.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public f b(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return new f(zArr);
    }
}
