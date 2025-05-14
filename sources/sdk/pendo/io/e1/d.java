package sdk.pendo.io.e1;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

/* loaded from: classes6.dex */
public class d extends sdk.pendo.io.a1.f implements f {
    private int f;

    public static class a extends d {
        public a() {
            super("HS256", "HmacSHA256", 256);
        }
    }

    public static class b extends d {
        public b() {
            super("HS384", "HmacSHA384", BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT);
        }
    }

    public static class c extends d {
        public c() {
            super("HS512", "HmacSHA512", 512);
        }
    }

    public d(String str, String str2, int i) {
        a(str);
        b(str2);
        a(sdk.pendo.io.i1.h.SYMMETRIC);
        c("oct");
        this.f = i;
    }

    private Mac a(Key key, sdk.pendo.io.w0.a aVar) {
        return sdk.pendo.io.l1.a.a(e(), key, aVar.c().e());
    }

    void b(Key key) {
        int a2;
        if (key == null) {
            throw new sdk.pendo.io.k1.f("key is null");
        }
        if (key.getEncoded() != null && (a2 = sdk.pendo.io.k1.a.a(key.getEncoded())) < this.f) {
            throw new sdk.pendo.io.k1.f("A key of the same size as the hash output (i.e. " + this.f + " bits for " + c() + ") or larger MUST be used with the HMAC SHA algorithms but this key is only " + a2 + " bits");
        }
    }

    @Override // sdk.pendo.io.a1.a
    public boolean d() {
        try {
            Mac.getInstance(e());
            return true;
        } catch (NoSuchAlgorithmException unused) {
            return false;
        }
    }

    @Override // sdk.pendo.io.e1.f
    public void a(Key key) {
        b(key);
    }

    @Override // sdk.pendo.io.e1.f
    public boolean a(byte[] bArr, Key key, byte[] bArr2, sdk.pendo.io.w0.a aVar) {
        if (key instanceof SecretKey) {
            return sdk.pendo.io.k1.a.a(bArr, a(key, aVar).doFinal(bArr2));
        }
        throw new sdk.pendo.io.k1.f(key.getClass() + " cannot be used for HMAC verification.");
    }
}
