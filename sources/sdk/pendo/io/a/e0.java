package sdk.pendo.io.a;

/* loaded from: classes6.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f821a;
    private final int b;

    e0(byte[] bArr, int i) {
        this.f821a = bArr;
        this.b = i;
    }

    public int a() {
        return this.f821a[this.b];
    }

    public int b(int i) {
        return this.f821a[this.b + (i * 2) + 2];
    }

    public String toString() {
        char c;
        int a2 = a();
        StringBuilder sb = new StringBuilder(a2 * 2);
        for (int i = 0; i < a2; i++) {
            int a3 = a(i);
            if (a3 == 0) {
                c = '[';
            } else if (a3 == 1) {
                c = '.';
            } else if (a3 == 2) {
                c = '*';
            } else {
                if (a3 != 3) {
                    throw new AssertionError();
                }
                sb.append(b(i)).append(';');
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public int a(int i) {
        return this.f821a[this.b + (i * 2) + 1];
    }

    static void a(e0 e0Var, d dVar) {
        if (e0Var == null) {
            dVar.b(0);
            return;
        }
        byte[] bArr = e0Var.f821a;
        int i = e0Var.b;
        dVar.a(bArr, i, (bArr[i] * 2) + 1);
    }
}
