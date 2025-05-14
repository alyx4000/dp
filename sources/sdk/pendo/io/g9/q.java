package sdk.pendo.io.g9;

import java.util.Iterator;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¨\u0006\t"}, d2 = {"Lsdk/pendo/io/g9/q;", "", "", "delimiter", "Ljava/util/TreeSet;", "tokens", "a", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static final q f1144a = new q();

    private q() {
    }

    public final String a(String delimiter, TreeSet<String> tokens) {
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(tokens, "tokens");
        StringBuilder sb = new StringBuilder("");
        Iterator<String> it = tokens.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(delimiter);
        }
        if (!Intrinsics.areEqual(delimiter, "")) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
