package sdk.pendo.io.k2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u0006\u001a\u00020\u0002*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0004J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0014¨\u0006\u000f"}, d2 = {"Lsdk/pendo/io/k2/l0;", "Lsdk/pendo/io/k2/e1;", "", "Lsdk/pendo/io/i2/f;", "", "index", "l", "nestedName", "a", "desc", "k", "parentName", "childName", "<init>", "()V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public abstract class l0 extends e1<String> {
    protected final String a(String nestedName) {
        Intrinsics.checkNotNullParameter(nestedName, "nestedName");
        String p = p();
        if (p == null) {
            p = "";
        }
        return a(p, nestedName);
    }

    protected abstract String a(String parentName, String childName);

    protected String k(sdk.pendo.io.i2.f desc, int index) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        return desc.a(index);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sdk.pendo.io.k2.e1
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final String j(sdk.pendo.io.i2.f fVar, int i) {
        Intrinsics.checkNotNullParameter(fVar, "<this>");
        return a(k(fVar, i));
    }
}
