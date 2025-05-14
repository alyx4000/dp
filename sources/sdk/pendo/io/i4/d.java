package sdk.pendo.io.i4;

/* loaded from: classes6.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private int f1207a;
    private byte[] b;
    private int c;

    public d(byte[] bArr, int i) {
        this(bArr, i, -1);
    }

    public int a() {
        return this.c;
    }

    public byte[] b() {
        return sdk.pendo.io.d5.a.a(this.b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (dVar.c != this.c) {
            return false;
        }
        return sdk.pendo.io.d5.a.a(this.b, dVar.b);
    }

    public int hashCode() {
        return this.c ^ sdk.pendo.io.d5.a.b(this.b);
    }

    public d(byte[] bArr, int i, int i2) {
        this.b = sdk.pendo.io.d5.a.a(bArr);
        this.c = i;
        this.f1207a = i2;
    }
}
