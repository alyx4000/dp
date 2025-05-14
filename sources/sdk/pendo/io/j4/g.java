package sdk.pendo.io.j4;

import java.security.SecureRandom;

/* loaded from: classes6.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final SecureRandom f1228a;
    private final d b;
    private byte[] c;
    private int d = 256;
    private int e = 256;

    private static class a implements b {

        /* renamed from: a, reason: collision with root package name */
        private final sdk.pendo.io.g4.c f1229a;
        private final byte[] b;
        private final byte[] c;
        private final int d;

        public a(sdk.pendo.io.g4.c cVar, byte[] bArr, byte[] bArr2, int i) {
            this.f1229a = cVar;
            this.b = bArr;
            this.c = bArr2;
            this.d = i;
        }

        @Override // sdk.pendo.io.j4.b
        public sdk.pendo.io.k4.b a(c cVar) {
            return new sdk.pendo.io.k4.a(this.f1229a, this.d, cVar, this.c, this.b);
        }

        @Override // sdk.pendo.io.j4.b
        public String getAlgorithm() {
            return "HASH-DRBG-" + g.b(this.f1229a);
        }
    }

    public g(SecureRandom secureRandom, boolean z) {
        this.f1228a = secureRandom;
        this.b = new sdk.pendo.io.j4.a(secureRandom, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(sdk.pendo.io.g4.c cVar) {
        String a2 = cVar.a();
        int indexOf = a2.indexOf(45);
        return (indexOf <= 0 || a2.startsWith("SHA3")) ? a2 : a2.substring(0, indexOf) + a2.substring(indexOf + 1);
    }

    public f a(sdk.pendo.io.g4.c cVar, byte[] bArr, boolean z) {
        return new f(this.f1228a, this.b.get(this.e), new a(cVar, bArr, this.c, this.d), z);
    }

    public g a(byte[] bArr) {
        this.c = sdk.pendo.io.d5.a.a(bArr);
        return this;
    }
}
