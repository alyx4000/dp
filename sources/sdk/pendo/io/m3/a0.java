package sdk.pendo.io.m3;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes6.dex */
public abstract class a0 extends t {
    a0() {
    }

    abstract int a(boolean z);

    public void a(OutputStream outputStream) {
        y a2 = y.a(outputStream);
        a2.a(this, true);
        a2.a();
    }

    abstract void a(y yVar, boolean z);

    abstract boolean a(a0 a0Var);

    @Override // sdk.pendo.io.m3.t, sdk.pendo.io.m3.g
    public final a0 b() {
        return this;
    }

    public final boolean b(a0 a0Var) {
        return this == a0Var || a(a0Var);
    }

    @Override // sdk.pendo.io.m3.t
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g) && a(((g) obj).b());
    }

    abstract boolean h();

    @Override // sdk.pendo.io.m3.t
    public abstract int hashCode();

    a0 i() {
        return this;
    }

    a0 j() {
        return this;
    }

    public void a(OutputStream outputStream, String str) {
        y a2 = y.a(outputStream, str);
        a2.a(this, true);
        a2.a();
    }

    public static a0 a(byte[] bArr) {
        p pVar = new p(bArr);
        try {
            a0 b = pVar.b();
            if (pVar.available() == 0) {
                return b;
            }
            throw new IOException("Extra data detected in stream");
        } catch (ClassCastException unused) {
            throw new IOException("cannot recognise object in stream");
        }
    }
}
