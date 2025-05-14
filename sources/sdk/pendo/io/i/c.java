package sdk.pendo.io.i;

import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\u001a\u001c\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001a\u001c\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0000¨\u0006\n"}, d2 = {"Ljava/io/OutputStream;", "", "value", "", "numBytes", "", "a", "", "data", "maxDataLength", "certificatetransparency"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class c {
    public static final void a(OutputStream outputStream, long j, int i) {
        Intrinsics.checkNotNullParameter(outputStream, "<this>");
        if (!(j >= 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(((double) j) < Math.pow(256.0d, (double) i))) {
            throw new IllegalArgumentException(("Value " + j + " cannot be stored in " + i + " bytes").toString());
        }
        while (i > 0) {
            int i2 = (i - 1) * 8;
            outputStream.write((byte) (((255 << i2) & j) >> i2));
            i--;
        }
    }

    public static final void a(OutputStream outputStream, byte[] data, int i) {
        Intrinsics.checkNotNullParameter(outputStream, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        if (!(data.length <= i)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        a(outputStream, data.length, a.f1170a.a(i));
        outputStream.write(data, 0, data.length);
    }
}
