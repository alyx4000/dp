package sdk.pendo.io.i4;

/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f1205a;
    private int b;

    public b(byte[] bArr, int i) {
        this.f1205a = sdk.pendo.io.d5.a.a(bArr);
        this.b = i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (bVar.b != this.b) {
            return false;
        }
        return sdk.pendo.io.d5.a.a(this.f1205a, bVar.f1205a);
    }

    public int hashCode() {
        return this.b ^ sdk.pendo.io.d5.a.b(this.f1205a);
    }
}
