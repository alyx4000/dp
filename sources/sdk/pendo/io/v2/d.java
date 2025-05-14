package sdk.pendo.io.v2;

import external.sdk.pendo.io.mozilla.javascript.ObjToIntMap;
import external.sdk.pendo.io.mozilla.javascript.UintMap;
import kotlin.UShort;

/* loaded from: classes4.dex */
final class d {

    /* renamed from: a, reason: collision with root package name */
    private c f1672a;
    private UintMap b = new UintMap();
    private ObjToIntMap c = new ObjToIntMap();
    private ObjToIntMap d = new ObjToIntMap();
    private ObjToIntMap e = new ObjToIntMap();
    private ObjToIntMap f = new ObjToIntMap();
    private ObjToIntMap g = new ObjToIntMap();
    private UintMap j = new UintMap();
    private UintMap k = new UintMap();
    private int i = 1;
    private byte[] l = new byte[256];
    private int h = 0;

    d(c cVar) {
        this.f1672a = cVar;
    }

    short a(String str) {
        String str2;
        int i = this.f.get(str, -1);
        if (i == -1) {
            if (str.indexOf(46) > 0) {
                String i2 = c.i(str);
                int i3 = this.f.get(i2, -1);
                if (i3 != -1) {
                    this.f.put(str, i3);
                }
                str2 = i2;
                i = i3;
            } else {
                str2 = str;
            }
            if (i == -1) {
                short c = c(str2);
                b(3);
                byte[] bArr = this.l;
                int i4 = this.h;
                int i5 = i4 + 1;
                this.h = i5;
                bArr[i4] = 7;
                this.h = c.a((int) c, bArr, i5);
                i = this.i;
                this.i = i + 1;
                this.f.put(str2, i);
                if (!str.equals(str2)) {
                    this.f.put(str, i);
                }
            }
        }
        a(i, str);
        this.k.put(i, 7);
        return (short) i;
    }

    int b(String str) {
        int c = c(str) & UShort.MAX_VALUE;
        int i = this.b.getInt(c, -1);
        if (i == -1) {
            i = this.i;
            this.i = i + 1;
            b(3);
            byte[] bArr = this.l;
            int i2 = this.h;
            int i3 = i2 + 1;
            this.h = i3;
            bArr[i2] = 8;
            this.h = c.a(c, bArr, i3);
            this.b.put(c, i);
        }
        this.k.put(i, 8);
        return i;
    }

    short c(String str, String str2, String str3) {
        f fVar = new f(str, str2, str3);
        int i = this.e.get(fVar, -1);
        if (i == -1) {
            short a2 = a(str2, str3);
            short a3 = a(str);
            b(5);
            byte[] bArr = this.l;
            int i2 = this.h;
            int i3 = i2 + 1;
            this.h = i3;
            bArr[i2] = 10;
            int a4 = c.a((int) a3, bArr, i3);
            this.h = a4;
            this.h = c.a((int) a2, this.l, a4);
            i = this.i;
            this.i = i + 1;
            this.e.put(fVar, i);
        }
        a(i, fVar);
        this.k.put(i, 10);
        return (short) i;
    }

    byte d(int i) {
        return (byte) this.k.getInt(i, 0);
    }

    int a(double d) {
        b(9);
        byte[] bArr = this.l;
        int i = this.h;
        this.h = i + 1;
        bArr[i] = 6;
        this.h = c.a(Double.doubleToLongBits(d), this.l, this.h);
        int i2 = this.i;
        this.i = i2 + 2;
        this.k.put(i2, 6);
        return i2;
    }

    short b(String str, String str2, String str3) {
        short a2 = a(str2, str3);
        short a3 = a(str);
        b(5);
        byte[] bArr = this.l;
        int i = this.h;
        int i2 = i + 1;
        this.h = i2;
        bArr[i] = 11;
        int a4 = c.a((int) a3, bArr, i2);
        this.h = a4;
        this.h = c.a((int) a2, this.l, a4);
        a(this.i, new f(str, str2, str3));
        this.k.put(this.i, 11);
        int i3 = this.i;
        this.i = i3 + 1;
        return (short) i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    short c(java.lang.String r13) {
        /*
            r12 = this;
            external.sdk.pendo.io.mozilla.javascript.ObjToIntMap r0 = r12.c
            r1 = -1
            int r0 = r0.get(r13, r1)
            r2 = 1
            if (r0 != r1) goto Laf
            int r1 = r13.length()
            r3 = 65535(0xffff, float:9.1834E-41)
            if (r1 <= r3) goto L15
            goto L89
        L15:
            int r4 = r1 * 3
            int r4 = r4 + 3
            r12.b(r4)
            int r4 = r12.h
            byte[] r5 = r12.l
            int r6 = r4 + 1
            r5[r4] = r2
            int r6 = r6 + 2
            sdk.pendo.io.v2.c r4 = r12.f1672a
            char[] r4 = r4.t(r1)
            r5 = 0
            r13.getChars(r5, r1, r4, r5)
            r7 = r5
        L31:
            if (r7 == r1) goto L7f
            char r8 = r4[r7]
            if (r8 == 0) goto L43
            r9 = 127(0x7f, float:1.78E-43)
            if (r8 > r9) goto L43
            byte[] r9 = r12.l
            int r10 = r6 + 1
            byte r8 = (byte) r8
            r9[r6] = r8
            goto L66
        L43:
            r9 = 2047(0x7ff, float:2.868E-42)
            if (r8 <= r9) goto L68
            byte[] r9 = r12.l
            int r10 = r6 + 1
            int r11 = r8 >> 12
            r11 = r11 | 224(0xe0, float:3.14E-43)
            byte r11 = (byte) r11
            r9[r6] = r11
            int r6 = r10 + 1
            int r11 = r8 >> 6
            r11 = r11 & 63
            r11 = r11 | 128(0x80, float:1.8E-43)
            byte r11 = (byte) r11
            r9[r10] = r11
            int r10 = r6 + 1
            r8 = r8 & 63
            r8 = r8 | 128(0x80, float:1.8E-43)
            byte r8 = (byte) r8
            r9[r6] = r8
        L66:
            r6 = r10
            goto L7c
        L68:
            byte[] r9 = r12.l
            int r10 = r6 + 1
            int r11 = r8 >> 6
            r11 = r11 | 192(0xc0, float:2.69E-43)
            byte r11 = (byte) r11
            r9[r6] = r11
            int r6 = r10 + 1
            r8 = r8 & 63
            r8 = r8 | 128(0x80, float:1.8E-43)
            byte r8 = (byte) r8
            r9[r10] = r8
        L7c:
            int r7 = r7 + 1
            goto L31
        L7f:
            int r1 = r12.h
            int r4 = r1 + 1
            int r7 = r4 + 2
            int r7 = r6 - r7
            if (r7 <= r3) goto L8b
        L89:
            r5 = r2
            goto La4
        L8b:
            byte[] r0 = r12.l
            int r3 = r7 >>> 8
            byte r3 = (byte) r3
            r0[r4] = r3
            int r1 = r1 + 2
            byte r3 = (byte) r7
            r0[r1] = r3
            r12.h = r6
            int r0 = r12.i
            int r1 = r0 + 1
            r12.i = r1
            external.sdk.pendo.io.mozilla.javascript.ObjToIntMap r1 = r12.c
            r1.put(r13, r0)
        La4:
            if (r5 != 0) goto La7
            goto Laf
        La7:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Too big string"
            r13.<init>(r0)
            throw r13
        Laf:
            r12.a(r0, r13)
            external.sdk.pendo.io.mozilla.javascript.UintMap r13 = r12.k
            r13.put(r0, r2)
            short r13 = (short) r0
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.v2.d.c(java.lang.String):short");
    }

    private void b(int i) {
        int i2 = this.h;
        int i3 = i + i2;
        byte[] bArr = this.l;
        if (i3 > bArr.length) {
            int length = bArr.length * 2;
            if (i3 <= length) {
                i3 = length;
            }
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, 0, bArr2, 0, i2);
            this.l = bArr2;
        }
    }

    int a(int i) {
        b(5);
        byte[] bArr = this.l;
        int i2 = this.h;
        int i3 = i2 + 1;
        this.h = i3;
        bArr[i2] = 3;
        this.h = c.b(i, bArr, i3);
        this.k.put(this.i, 3);
        int i4 = this.i;
        this.i = i4 + 1;
        return (short) i4;
    }

    Object c(int i) {
        return this.j.getObject(i);
    }

    int a(long j) {
        b(9);
        byte[] bArr = this.l;
        int i = this.h;
        int i2 = i + 1;
        this.h = i2;
        bArr[i] = 5;
        this.h = c.a(j, bArr, i2);
        int i3 = this.i;
        this.i = i3 + 2;
        this.k.put(i3, 5);
        return i3;
    }

    short a(String str, String str2, String str3) {
        f fVar = new f(str, str2, str3);
        int i = this.d.get(fVar, -1);
        if (i == -1) {
            short a2 = a(str2, str3);
            short a3 = a(str);
            b(5);
            byte[] bArr = this.l;
            int i2 = this.h;
            int i3 = i2 + 1;
            this.h = i3;
            bArr[i2] = 9;
            int a4 = c.a((int) a3, bArr, i3);
            this.h = a4;
            this.h = c.a((int) a2, this.l, a4);
            i = this.i;
            this.i = i + 1;
            this.d.put(fVar, i);
        }
        a(i, fVar);
        this.k.put(i, 9);
        return (short) i;
    }

    private short a(String str, String str2) {
        short c = c(str);
        short c2 = c(str2);
        b(5);
        byte[] bArr = this.l;
        int i = this.h;
        int i2 = i + 1;
        this.h = i2;
        bArr[i] = 12;
        int a2 = c.a((int) c, bArr, i2);
        this.h = a2;
        this.h = c.a((int) c2, this.l, a2);
        this.k.put(this.i, 12);
        int i3 = this.i;
        this.i = i3 + 1;
        return (short) i3;
    }

    int a(String str, int i, int i2) {
        int i3 = 65535;
        if ((i2 - i) * 3 <= 65535) {
            return i2;
        }
        while (i != i2) {
            char charAt = str.charAt(i);
            i3 = (charAt == 0 || charAt > 127) ? charAt < 2047 ? i3 - 2 : i3 - 3 : i3 - 1;
            if (i3 < 0) {
                return i;
            }
            i++;
        }
        return i2;
    }

    int a() {
        return this.h + 2;
    }

    void a(int i, Object obj) {
        this.j.put(i, obj);
    }

    int a(byte[] bArr, int i) {
        int a2 = c.a((int) ((short) this.i), bArr, i);
        System.arraycopy(this.l, 0, bArr, a2, this.h);
        return a2 + this.h;
    }
}
