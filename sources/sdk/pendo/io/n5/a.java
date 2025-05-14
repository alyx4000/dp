package sdk.pendo.io.n5;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0016¨\u0006\u000b"}, d2 = {"Lsdk/pendo/io/n5/a;", "Lsdk/pendo/io/n5/c;", "Lsdk/pendo/io/n5/b;", "level", "", "Lexternal/sdk/pendo/io/org/koin/core/logger/MESSAGE;", "msg", "", "a", "<init>", "()V", "koin-core"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class a extends c {
    public a() {
        super(b.NONE);
    }

    @Override // sdk.pendo.io.n5.c
    public void a(b level, String msg) {
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(msg, "msg");
    }
}
