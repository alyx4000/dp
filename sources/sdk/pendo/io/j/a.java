package sdk.pendo.io.j;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0005\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¨\u0006\b"}, d2 = {"Lsdk/pendo/io/j/a;", "", "", "data", "", "a", "<init>", "()V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f1212a = new a();

    private a() {
    }

    public final byte[] a(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        byte[] a2 = sdk.pendo.io.e5.a.a(data);
        Intrinsics.checkNotNullExpressionValue(a2, "decode(data)");
        return a2;
    }

    public final String a(byte[] data) {
        String a2 = sdk.pendo.io.e5.a.a(data);
        Intrinsics.checkNotNullExpressionValue(a2, "toBase64String(data)");
        return a2;
    }
}
