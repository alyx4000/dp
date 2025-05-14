package sdk.pendo.io.k2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\n"}, d2 = {"Lsdk/pendo/io/k2/d;", "Lsdk/pendo/io/k2/e0;", "", "a", "()Ljava/lang/String;", "serialName", "Lsdk/pendo/io/i2/f;", "elementDesc", "<init>", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class d extends e0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(sdk.pendo.io.i2.f elementDesc) {
        super(elementDesc, null);
        Intrinsics.checkNotNullParameter(elementDesc, "elementDesc");
    }

    @Override // sdk.pendo.io.i2.f
    /* renamed from: a */
    public String getSerialName() {
        return "kotlin.collections.ArrayList";
    }
}
