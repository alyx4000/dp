package sdk.pendo.io.b1;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* loaded from: classes6.dex */
public class d extends t {
    int i;

    public static class a extends d {
        public a() {
            super("A128KW", 16);
        }
    }

    public static class b extends d {
        public b() {
            super("A192KW", 24);
        }
    }

    public static class c extends d {
        public c() {
            super("A256KW", 32);
        }
    }

    public d(String str, int i) {
        super("AESWrap", str);
        c("oct");
        a(sdk.pendo.io.i1.h.SYMMETRIC);
        this.i = i;
    }

    @Override // sdk.pendo.io.b1.p
    public void a(Key key, g gVar) {
        b(key);
    }

    void b(Key key) {
        sdk.pendo.io.h1.d.a(key, c(), f());
    }

    @Override // sdk.pendo.io.a1.a
    public boolean d() {
        int f = f();
        String e = e();
        try {
            Cipher.getInstance(e);
            return e.a(e, f);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e2) {
            this.f.a("{} for {} is not available ({}).", e, c(), sdk.pendo.io.k1.b.a(e2));
            return false;
        }
    }

    int f() {
        return this.i;
    }

    d g() {
        this.h = false;
        return this;
    }
}
