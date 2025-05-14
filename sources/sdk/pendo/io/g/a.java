package sdk.pendo.io.g;

import external.sdk.pendo.io.com.appmattus.certificatetransparency.internal.loglist.model.v2.Hostname;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.i2.e;
import sdk.pendo.io.i2.f;
import sdk.pendo.io.i2.i;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u001a\u0010\n\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lsdk/pendo/io/g/a;", "Lsdk/pendo/io/g2/b;", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/Hostname;", "Lsdk/pendo/io/j2/d;", "decoder", "a", "Lsdk/pendo/io/i2/f;", "Lsdk/pendo/io/i2/f;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "<init>", "()V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class a implements sdk.pendo.io.g2.b<Hostname> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final f descriptor = i.a("Hostname", e.i.f1193a);

    @Override // sdk.pendo.io.g2.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Hostname deserialize(sdk.pendo.io.j2.d decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return new Hostname(decoder.m());
    }

    @Override // sdk.pendo.io.g2.b, sdk.pendo.io.g2.a
    public f getDescriptor() {
        return this.descriptor;
    }
}
