package sdk.pendo.io.m1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import sdk.pendo.io.k1.g;

/* loaded from: classes6.dex */
public class b implements a {
    @Override // sdk.pendo.io.m1.a
    public byte[] a(byte[] bArr) {
        Inflater inflater = new Inflater(true);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                InflaterInputStream inflaterInputStream = new InflaterInputStream(new ByteArrayInputStream(bArr), inflater);
                try {
                    byte[] bArr2 = new byte[256];
                    while (true) {
                        int read = inflaterInputStream.read(bArr2);
                        if (read == -1) {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            inflaterInputStream.close();
                            return byteArray;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                } catch (Throwable th) {
                    try {
                        inflaterInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e) {
                throw new g("Problem decompressing data.", e);
            }
        } finally {
            inflater.end();
        }
    }

    @Override // sdk.pendo.io.a1.a
    public String c() {
        return "DEF";
    }

    @Override // sdk.pendo.io.a1.a
    public boolean d() {
        return true;
    }
}
