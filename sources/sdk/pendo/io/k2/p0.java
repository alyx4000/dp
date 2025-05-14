package sdk.pendo.io.k2;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a \u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¨\u0006\u0007"}, d2 = {"", "seen", "goldenMask", "Lsdk/pendo/io/i2/f;", "descriptor", "", "a", "kotlinx-serialization-core"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class p0 {
    public static final void a(int i, int i2, sdk.pendo.io.i2.f descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        ArrayList arrayList = new ArrayList();
        int i3 = (~i) & i2;
        int i4 = 0;
        while (i4 < 32) {
            int i5 = i4 + 1;
            if ((i3 & 1) != 0) {
                arrayList.add(descriptor.a(i4));
            }
            i3 >>>= 1;
            i4 = i5;
        }
        throw new sdk.pendo.io.g2.c(arrayList, descriptor.a());
    }
}
