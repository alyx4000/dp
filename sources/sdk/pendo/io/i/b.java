package sdk.pendo.io.i;

import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\t\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0001H\u0000¨\u0006\n"}, d2 = {"Ljava/io/InputStream;", "", "numBytes", "", "b", "dataLength", "", "a", "maxDataLength", "c", "certificatetransparency"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class b {
    public static final byte[] a(InputStream inputStream, int i) {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        byte[] bArr = new byte[i];
        int read = inputStream.read(bArr);
        if (read >= i) {
            return bArr;
        }
        throw new IOException("Not enough bytes: Expected " + i + ", got " + read + '.');
    }

    public static final long b(InputStream inputStream, int i) {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        if (!(i <= 8)) {
            throw new IllegalArgumentException("Could not read a number of more than 8 bytes.".toString());
        }
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            int read = inputStream.read();
            if (read < 0) {
                throw new IOException("Missing length bytes: Expected " + i + ", got " + i2 + '.');
            }
            j = (j << 8) | read;
        }
        return j;
    }

    public static final byte[] c(InputStream inputStream, int i) {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        int b = (int) b(inputStream, a.f1170a.a(i));
        byte[] bArr = new byte[b];
        try {
            int read = inputStream.read(bArr);
            if (read == b) {
                return bArr;
            }
            throw new IOException("Incomplete data. Expected " + b + " bytes, had " + read + '.');
        } catch (IOException e) {
            throw new IOException("Error while reading variable-length data", e);
        }
    }
}
