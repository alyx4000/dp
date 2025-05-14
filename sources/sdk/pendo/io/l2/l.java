package sdk.pendo.io.l2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\n"}, d2 = {"Lsdk/pendo/io/l2/l;", "Lsdk/pendo/io/l2/a;", "", "d", "Lsdk/pendo/io/l2/f;", "configuration", "Lsdk/pendo/io/n2/c;", "module", "<init>", "(Lkotlinx/serialization/json/JsonConfiguration;Lkotlinx/serialization/modules/SerializersModule;)V", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
final class l extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(f configuration, sdk.pendo.io.n2.c module) {
        super(configuration, module, null);
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(module, "module");
        d();
    }

    private final void d() {
        if (Intrinsics.areEqual(getSerializersModule(), sdk.pendo.io.n2.e.a())) {
            return;
        }
        getSerializersModule().a(new sdk.pendo.io.m2.s(getConfiguration().getUseArrayPolymorphism(), getConfiguration().getClassDiscriminator()));
    }
}
