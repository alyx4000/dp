package sdk.pendo.io.j;

import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u0002*\u00060\u0000j\u0002`\u0001H\u0000¨\u0006\u0004"}, d2 = {"Ljava/lang/Exception;", "Lkotlin/Exception;", "", "a", "certificatetransparency"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class c {
    public static final String a(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "<this>");
        StringWriter stringWriter = new StringWriter();
        try {
            PrintWriter printWriter = new PrintWriter(stringWriter);
            try {
                exc.printStackTrace(printWriter);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(printWriter, null);
                String stringWriter2 = stringWriter.toString();
                CloseableKt.closeFinally(stringWriter, null);
                Intrinsics.checkNotNullExpressionValue(stringWriter2, "StringWriter().use { str…stringWriter.toString()\n}");
                return stringWriter2;
            } finally {
            }
        } finally {
        }
    }
}
