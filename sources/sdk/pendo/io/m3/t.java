package sdk.pendo.io.m3;

import java.io.ByteArrayOutputStream;

/* loaded from: classes6.dex */
public abstract class t implements g {
    public byte[] a(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        b().a(byteArrayOutputStream, str);
        return byteArrayOutputStream.toByteArray();
    }

    @Override // sdk.pendo.io.m3.g
    public abstract a0 b();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            return b().b(((g) obj).b());
        }
        return false;
    }

    public byte[] g() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        b().a(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public int hashCode() {
        return b().hashCode();
    }
}
