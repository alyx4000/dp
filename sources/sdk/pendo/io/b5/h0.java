package sdk.pendo.io.b5;

import com.google.android.gms.stats.CodePackage;
import java.security.AccessController;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.PrivilegedAction;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes6.dex */
public class h0 implements sdk.pendo.io.a5.e {
    private static final boolean h = a();

    /* renamed from: a, reason: collision with root package name */
    private final sdk.pendo.io.p4.b f909a;
    private final int b;
    private final Cipher c;
    private final String d;
    private final int e;
    private final String f;
    private SecretKey g;

    static class a implements PrivilegedAction {
        a() {
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            try {
                boolean z = true;
                if (Cipher.class.getMethod("updateAAD", byte[].class) == null) {
                    z = false;
                }
                return Boolean.valueOf(z);
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        }
    }

    public h0(sdk.pendo.io.p4.b bVar, String str, String str2, int i, boolean z) {
        this.f909a = bVar;
        this.c = bVar.d(str);
        this.d = str2;
        this.e = i;
        this.b = z ? 1 : 2;
        this.f = a(bVar, str);
    }

    private static boolean a() {
        return ((Boolean) AccessController.doPrivileged(new a())).booleanValue();
    }

    @Override // sdk.pendo.io.a5.e
    public int a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        try {
            return this.c.doFinal(bArr, i, i2, bArr2, i3);
        } catch (GeneralSecurityException e) {
            throw c.b("", e);
        }
    }

    private static String a(sdk.pendo.io.p4.b bVar, String str) {
        String str2 = "CCM";
        try {
            if (!str.contains("CCM")) {
                str2 = CodePackage.GCM;
            }
            bVar.e(str2);
            return str2;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // sdk.pendo.io.a5.e
    public int a(int i) {
        return this.c.getOutputSize(i);
    }

    @Override // sdk.pendo.io.a5.e
    public void a(byte[] bArr, int i, byte[] bArr2) {
        String str;
        try {
            if (!h || (str = this.f) == null) {
                this.c.init(this.b, this.g, new sdk.pendo.io.o4.a(bArr, i * 8, bArr2), (SecureRandom) null);
                return;
            }
            AlgorithmParameters e = this.f909a.e(str);
            e.init(new sdk.pendo.io.p3.a(bArr, i).g());
            this.c.init(this.b, this.g, e, (SecureRandom) null);
            if (bArr2 == null || bArr2.length <= 0) {
                return;
            }
            this.c.updateAAD(bArr2);
        } catch (Exception e2) {
            throw c.b(e2.getMessage(), e2);
        }
    }

    @Override // sdk.pendo.io.a5.e
    public void a(byte[] bArr, int i, int i2) {
        if (this.e != i2) {
            throw new IllegalStateException();
        }
        this.g = new SecretKeySpec(bArr, i, i2, this.d);
    }
}
