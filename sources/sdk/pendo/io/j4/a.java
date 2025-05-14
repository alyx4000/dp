package sdk.pendo.io.j4;

import java.security.SecureRandom;

/* loaded from: classes6.dex */
public class a implements d {

    /* renamed from: a, reason: collision with root package name */
    private final SecureRandom f1226a;
    private final boolean b;

    /* renamed from: sdk.pendo.io.j4.a$a, reason: collision with other inner class name */
    class C0160a implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f1227a;

        C0160a(int i) {
            this.f1227a = i;
        }

        @Override // sdk.pendo.io.j4.c
        public byte[] a() {
            if (!(a.this.f1226a instanceof f)) {
                SecureRandom unused = a.this.f1226a;
                return a.this.f1226a.generateSeed((this.f1227a + 7) / 8);
            }
            byte[] bArr = new byte[(this.f1227a + 7) / 8];
            a.this.f1226a.nextBytes(bArr);
            return bArr;
        }

        @Override // sdk.pendo.io.j4.c
        public int b() {
            return this.f1227a;
        }
    }

    public a(SecureRandom secureRandom, boolean z) {
        this.f1226a = secureRandom;
        this.b = z;
    }

    @Override // sdk.pendo.io.j4.d
    public c get(int i) {
        return new C0160a(i);
    }
}
