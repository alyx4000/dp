package sdk.pendo.io.a;

/* loaded from: classes6.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f815a;
    private byte[] b;
    c c;

    static final class a {

        /* renamed from: a, reason: collision with root package name */
        private int f816a;
        private c[] b = new c[6];

        a() {
        }

        private void a(c cVar) {
            int i = this.f816a;
            c[] cVarArr = this.b;
            if (i >= cVarArr.length) {
                c[] cVarArr2 = new c[cVarArr.length + 6];
                System.arraycopy(cVarArr, 0, cVarArr2, 0, i);
                this.b = cVarArr2;
            }
            c[] cVarArr3 = this.b;
            int i2 = this.f816a;
            this.f816a = i2 + 1;
            cVarArr3[i2] = cVar;
        }

        private boolean c(c cVar) {
            for (int i = 0; i < this.f816a; i++) {
                if (this.b[i].f815a.equals(cVar.f815a)) {
                    return true;
                }
            }
            return false;
        }

        void b(c cVar) {
            while (cVar != null) {
                if (!c(cVar)) {
                    a(cVar);
                }
                cVar = cVar.c;
            }
        }

        c[] a() {
            int i = this.f816a;
            c[] cVarArr = new c[i];
            System.arraycopy(this.b, 0, cVarArr, 0, i);
            return cVarArr;
        }
    }

    protected c(String str) {
        this.f815a = str;
    }

    final int a(c0 c0Var) {
        return a(c0Var, (byte[]) null, 0, -1, -1);
    }

    public boolean b() {
        return false;
    }

    static int a(c0 c0Var, int i, int i2) {
        int i3;
        if ((i & 4096) == 0 || c0Var.e() >= 49) {
            i3 = 0;
        } else {
            c0Var.f("Synthetic");
            i3 = 6;
        }
        if (i2 != 0) {
            c0Var.f("Signature");
            i3 += 8;
        }
        if ((i & 131072) == 0) {
            return i3;
        }
        c0Var.f("Deprecated");
        return i3 + 6;
    }

    final int a(c0 c0Var, byte[] bArr, int i, int i2, int i3) {
        h hVar = c0Var.f817a;
        int i4 = 0;
        for (c cVar = this; cVar != null; cVar = cVar.c) {
            c0Var.f(cVar.f815a);
            i4 += cVar.a(hVar, bArr, i, i2, i3).b + 6;
        }
        return i4;
    }

    final int a() {
        int i = 0;
        for (c cVar = this; cVar != null; cVar = cVar.c) {
            i++;
        }
        return i;
    }

    static void a(c0 c0Var, int i, int i2, d dVar) {
        if ((i & 4096) != 0 && c0Var.e() < 49) {
            dVar.d(c0Var.f("Synthetic")).c(0);
        }
        if (i2 != 0) {
            dVar.d(c0Var.f("Signature")).c(2).d(i2);
        }
        if ((i & 131072) != 0) {
            dVar.d(c0Var.f("Deprecated")).c(0);
        }
    }

    final void a(c0 c0Var, d dVar) {
        a(c0Var, (byte[]) null, 0, -1, -1, dVar);
    }

    final void a(c0 c0Var, byte[] bArr, int i, int i2, int i3, d dVar) {
        h hVar = c0Var.f817a;
        for (c cVar = this; cVar != null; cVar = cVar.c) {
            d a2 = cVar.a(hVar, bArr, i, i2, i3);
            dVar.d(c0Var.f(cVar.f815a)).c(a2.b);
            dVar.a(a2.f818a, 0, a2.b);
        }
    }

    protected c a(e eVar, int i, int i2, char[] cArr, int i3, s[] sVarArr) {
        c cVar = new c(this.f815a);
        byte[] bArr = new byte[i2];
        cVar.b = bArr;
        System.arraycopy(eVar.c, i, bArr, 0, i2);
        return cVar;
    }

    protected d a(h hVar, byte[] bArr, int i, int i2, int i3) {
        return new d(this.b);
    }
}
