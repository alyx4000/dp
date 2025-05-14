package sdk.pendo.io.y4;

/* loaded from: classes4.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f1780a;
    private int b;
    private int c;
    private boolean d;

    public i() {
        this(0);
    }

    public static int a(int i) {
        int i2 = i | (i >> 1);
        int i3 = i2 | (i2 >> 2);
        int i4 = i3 | (i3 >> 4);
        int i5 = i4 | (i4 >> 8);
        return (i5 | (i5 >> 16)) + 1;
    }

    public void a(byte[] bArr, int i, int i2) {
        if (this.d) {
            throw new IllegalStateException("Cannot add data to read-only buffer");
        }
        int i3 = this.b;
        int i4 = this.c;
        if (i3 + i4 + i2 > this.f1780a.length) {
            int a2 = a(i4 + i2);
            byte[] bArr2 = this.f1780a;
            if (a2 > bArr2.length) {
                byte[] bArr3 = new byte[a2];
                System.arraycopy(bArr2, this.b, bArr3, 0, this.c);
                this.f1780a = bArr3;
            } else {
                System.arraycopy(bArr2, this.b, bArr2, 0, this.c);
            }
            this.b = 0;
        }
        System.arraycopy(bArr, i, this.f1780a, this.b + this.c, i2);
        this.c += i2;
    }

    f0 b(int i) {
        int i2 = this.c;
        if (i > i2) {
            throw new IllegalStateException("Cannot read " + i + " bytes, only got " + this.c);
        }
        int i3 = this.b;
        this.c = i2 - i;
        this.b = i3 + i;
        return new f0(this.f1780a, i3, i);
    }

    public void c(int i) {
        int i2 = this.c;
        if (i > i2) {
            throw new IllegalStateException("Cannot remove " + i + " bytes, only got " + this.c);
        }
        this.c = i2 - i;
        this.b += i;
    }

    public i(int i) {
        this.b = 0;
        this.c = 0;
        this.d = false;
        this.f1780a = i == 0 ? l3.e : new byte[i];
    }

    public int a() {
        return this.c;
    }

    public int b() {
        if (this.c >= 4) {
            return l3.b(this.f1780a, this.b);
        }
        throw new IllegalStateException("Not enough data to read");
    }

    public void c() {
        int i = this.c;
        if (i == 0) {
            this.f1780a = l3.e;
        } else {
            int a2 = a(i);
            byte[] bArr = this.f1780a;
            if (a2 >= bArr.length) {
                return;
            }
            byte[] bArr2 = new byte[a2];
            System.arraycopy(bArr, this.b, bArr2, 0, this.c);
            this.f1780a = bArr2;
        }
        this.b = 0;
    }

    public i(byte[] bArr, int i, int i2) {
        this.f1780a = bArr;
        this.b = i;
        this.c = i2;
        this.d = true;
    }

    public void b(byte[] bArr, int i, int i2, int i3) {
        a(bArr, i, i2, i3);
        c(i3 + i2);
    }

    public void a(byte[] bArr, int i, int i2, int i3) {
        if (bArr.length - i < i2) {
            throw new IllegalArgumentException("Buffer size of " + bArr.length + " is too small for a read of " + i2 + " bytes");
        }
        if (this.c - i3 < i2) {
            throw new IllegalStateException("Not enough data to read");
        }
        System.arraycopy(this.f1780a, this.b + i3, bArr, i, i2);
    }

    public byte[] a(int i, int i2) {
        byte[] bArr = new byte[i];
        b(bArr, 0, i, i2);
        return bArr;
    }
}
