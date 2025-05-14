package sdk.pendo.io.a3;

import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.time.DurationKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u001a\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b\u001a7\u0010\u000e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0080\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, d2 = {"Lsdk/pendo/io/a3/a;", "task", "Lsdk/pendo/io/a3/d;", "queue", "", "message", "", "b", "", "ns", "a", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function0;", "block", "logElapsed", "(Lokhttp3/internal/concurrent/Task;Lokhttp3/internal/concurrent/TaskQueue;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "okhttp"}, k = 2, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class b {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(a aVar, d dVar, String str) {
        Logger a2 = e.h.a();
        StringBuilder append = new StringBuilder().append(dVar.getName()).append(' ');
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        a2.fine(append.append(format).append(": ").append(aVar.getName()).toString());
    }

    public static final String a(long j) {
        StringBuilder sb;
        long j2;
        StringBuilder sb2;
        long j3;
        StringBuilder sb3;
        long j4;
        StringBuilder append;
        if (j > -999500000) {
            if (j > -999500) {
                if (j <= 0) {
                    sb3 = new StringBuilder();
                    j4 = j - 500;
                } else if (j < 999500) {
                    sb3 = new StringBuilder();
                    j4 = j + 500;
                } else if (j < 999500000) {
                    sb2 = new StringBuilder();
                    j3 = j + 500000;
                } else {
                    sb = new StringBuilder();
                    j2 = j + 500000000;
                }
                append = sb3.append(j4 / 1000).append(" µs");
                String sb4 = append.toString();
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("%6s", Arrays.copyOf(new Object[]{sb4}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                return format;
            }
            sb2 = new StringBuilder();
            j3 = j - 500000;
            append = sb2.append(j3 / DurationKt.NANOS_IN_MILLIS).append(" ms");
            String sb42 = append.toString();
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("%6s", Arrays.copyOf(new Object[]{sb42}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            return format2;
        }
        sb = new StringBuilder();
        j2 = j - 500000000;
        append = sb.append(j2 / 1000000000).append(" s ");
        String sb422 = append.toString();
        StringCompanionObject stringCompanionObject22 = StringCompanionObject.INSTANCE;
        String format22 = String.format("%6s", Arrays.copyOf(new Object[]{sb422}, 1));
        Intrinsics.checkNotNullExpressionValue(format22, "format(format, *args)");
        return format22;
    }
}
