package sdk.pendo.io.r4;

import java.util.Locale;
import sdk.pendo.io.t4.q;
import sdk.pendo.io.y4.o0;

/* loaded from: classes6.dex */
public final class c extends e {
    private final String c;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public c(java.lang.String r3) {
        /*
            r2 = this;
            java.lang.String r3 = a(r3)
            byte[] r0 = sdk.pendo.io.d5.i.a(r3)
            r1 = 0
            r2.<init>(r1, r0)
            r2.c = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.r4.c.<init>(java.lang.String):void");
    }

    private static String a(String str) {
        if (str == null) {
            throw new NullPointerException("'hostName' cannot be null");
        }
        String b = q.b(str, q.b);
        if (b.length() < 1) {
            throw new IllegalArgumentException("SNI host_name cannot be empty");
        }
        if (b.endsWith(".")) {
            throw new IllegalArgumentException("SNI host_name cannot end with a separator");
        }
        return b;
    }

    public String c() {
        return this.c;
    }

    @Override // sdk.pendo.io.r4.e
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            return this.c.equalsIgnoreCase(((c) obj).c);
        }
        return false;
    }

    @Override // sdk.pendo.io.r4.e
    public int hashCode() {
        return this.c.toUpperCase(Locale.ENGLISH).hashCode();
    }

    @Override // sdk.pendo.io.r4.e
    public String toString() {
        return "{type=" + o0.b((short) 0) + ", value=" + this.c + "}";
    }

    public c(byte[] bArr) {
        super(0, bArr);
        this.c = a(sdk.pendo.io.d5.i.c(bArr));
    }
}
