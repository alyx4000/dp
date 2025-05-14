package sdk.pendo.io.k2;

import kotlin.Metadata;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0019\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0003B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\f\u0010\u0006\u001a\u00020\u0005*\u00020\u0002H\u0014J\b\u0010\u0007\u001a\u00020\u0002H\u0014J(\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0014¨\u0006\u0012"}, d2 = {"Lsdk/pendo/io/k2/n;", "Lsdk/pendo/io/g2/b;", "", "Lsdk/pendo/io/k2/v0;", "", "Lsdk/pendo/io/k2/m;", "a", "d", "Lsdk/pendo/io/j2/b;", "decoder", "", "index", "builder", "", "checkIndex", "", "<init>", "()V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class n extends v0<Character, char[], m> {
    public static final n c = new n();

    private n() {
        super(sdk.pendo.io.h2.a.a(CharCompanionObject.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sdk.pendo.io.k2.v0
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public char[] c() {
        return new char[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sdk.pendo.io.k2.f0, sdk.pendo.io.k2.a
    public void a(sdk.pendo.io.j2.b decoder, int index, m builder, boolean checkIndex) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.a(decoder.c(getDescriptor(), index));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sdk.pendo.io.k2.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public m b(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return new m(cArr);
    }
}
