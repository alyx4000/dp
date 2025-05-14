package sdk.pendo.io.c1;

import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;

/* loaded from: classes6.dex */
public class a implements c {
    private static final sdk.pendo.io.h7.a c = sdk.pendo.io.h7.b.a((Class<?>) a.class);

    /* renamed from: a, reason: collision with root package name */
    private int f941a;
    private MessageDigest b;

    public a(String str, String str2) {
        this.b = sdk.pendo.io.k1.c.a(str, str2);
        a();
    }

    private boolean b() {
        return false;
    }

    long a(int i) {
        return (int) Math.ceil(i / this.f941a);
    }

    private void a() {
        this.f941a = sdk.pendo.io.k1.a.a(this.b.getDigestLength());
        if (b()) {
            c.b("Hash Algorithm: {} with hashlen: {} bits", this.b.getAlgorithm(), Integer.valueOf(this.f941a));
        }
    }

    @Override // sdk.pendo.io.c1.c
    public byte[] a(byte[] bArr, int i, byte[] bArr2) {
        long a2 = a(i);
        if (b()) {
            sdk.pendo.io.h7.a aVar = c;
            aVar.a("reps: {}", String.valueOf(a2));
            aVar.a("otherInfo: {}", sdk.pendo.io.k1.a.f(bArr2));
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i2 = 1; i2 <= a2; i2++) {
            byte[] c2 = sdk.pendo.io.k1.a.c(i2);
            if (b()) {
                sdk.pendo.io.h7.a aVar2 = c;
                aVar2.a("rep {} hashing ", Integer.valueOf(i2));
                aVar2.a(" counter: {}", sdk.pendo.io.k1.a.f(c2));
                aVar2.a(" z: {}", sdk.pendo.io.k1.a.f(bArr));
                aVar2.a(" otherInfo: {}", sdk.pendo.io.k1.a.f(bArr2));
            }
            this.b.update(c2);
            this.b.update(bArr);
            this.b.update(bArr2);
            byte[] digest = this.b.digest();
            if (b()) {
                c.b(" k({}): {}", Integer.valueOf(i2), sdk.pendo.io.k1.a.f(digest));
            }
            byteArrayOutputStream.write(digest, 0, digest.length);
        }
        int b = sdk.pendo.io.k1.a.b(i);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (b()) {
            c.a("derived key material: {}", sdk.pendo.io.k1.a.f(byteArray));
        }
        if (byteArray.length != b) {
            byteArray = sdk.pendo.io.k1.a.a(byteArray, 0, b);
            if (b()) {
                c.b("first {} bits of derived key material: {}", Integer.valueOf(i), sdk.pendo.io.k1.a.f(byteArray));
            }
        }
        if (b()) {
            c.a("final derived key material: {}", sdk.pendo.io.k1.a.f(byteArray));
        }
        return byteArray;
    }
}
