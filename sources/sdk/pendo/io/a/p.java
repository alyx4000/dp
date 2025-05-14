package sdk.pendo.io.a;

import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* loaded from: classes6.dex */
class p {

    /* renamed from: a, reason: collision with root package name */
    s f827a;
    private int[] b;
    private int[] c;
    private int[] d;
    private int[] e;
    private short f;
    private short g;
    private int h;
    private int[] i;

    p(s sVar) {
        this.f827a = sVar;
    }

    private int b(int i) {
        int[] iArr = this.d;
        if (iArr == null || i >= iArr.length) {
            return i | 16777216;
        }
        int i2 = iArr[i];
        if (i2 != 0) {
            return i2;
        }
        int i3 = i | 16777216;
        iArr[i] = i3;
        return i3;
    }

    private void c(int i) {
        short s;
        short s2 = this.g;
        if (s2 >= i) {
            s = (short) (s2 - i);
        } else {
            this.f = (short) (this.f - (i - s2));
            s = 0;
        }
        this.g = s;
    }

    private void d(int i) {
        if (this.e == null) {
            this.e = new int[10];
        }
        int length = this.e.length;
        short s = this.g;
        if (s >= length) {
            int[] iArr = new int[Math.max(s + 1, length * 2)];
            System.arraycopy(this.e, 0, iArr, 0, length);
            this.e = iArr;
        }
        int[] iArr2 = this.e;
        short s2 = this.g;
        short s3 = (short) (s2 + 1);
        this.g = s3;
        iArr2[s2] = i;
        short s4 = (short) (this.f + s3);
        s sVar = this.f827a;
        if (s4 > sVar.h) {
            sVar.h = s4;
        }
    }

    final void a(v vVar) {
        int[] iArr = this.b;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = 2;
            if (i2 >= iArr.length) {
                break;
            }
            int i6 = iArr[i2];
            if (i6 != 4194308 && i6 != 4194307) {
                i5 = 1;
            }
            i2 += i5;
            i4++;
            if (i6 != 4194304) {
                i3 += i4;
                i4 = 0;
            }
        }
        int[] iArr2 = this.c;
        int i7 = 0;
        int i8 = 0;
        while (i7 < iArr2.length) {
            int i9 = iArr2[i7];
            i7 += (i9 == 4194308 || i9 == 4194307) ? 2 : 1;
            i8++;
        }
        int a2 = vVar.a(this.f827a.d, i3, i8);
        int i10 = 0;
        while (true) {
            int i11 = i3 - 1;
            if (i3 <= 0) {
                break;
            }
            int i12 = iArr[i10];
            i10 += (i12 == 4194308 || i12 == 4194307) ? 2 : 1;
            vVar.g(a2, i12);
            i3 = i11;
            a2++;
        }
        while (true) {
            int i13 = i8 - 1;
            if (i8 <= 0) {
                vVar.k();
                return;
            }
            int i14 = iArr2[i];
            i += (i14 == 4194308 || i14 == 4194307) ? 2 : 1;
            vVar.g(a2, i14);
            a2++;
            i8 = i13;
        }
    }

    private void a(int i) {
        if (this.i == null) {
            this.i = new int[2];
        }
        int length = this.i.length;
        int i2 = this.h;
        if (i2 >= length) {
            int[] iArr = new int[Math.max(i2 + 1, length * 2)];
            System.arraycopy(this.i, 0, iArr, 0, length);
            this.i = iArr;
        }
        int[] iArr2 = this.i;
        int i3 = this.h;
        this.h = i3 + 1;
        iArr2[i3] = i;
    }

    private int b() {
        short s = this.g;
        if (s <= 0) {
            short s2 = (short) (this.f - 1);
            this.f = s2;
            return (-s2) | 20971520;
        }
        int[] iArr = this.e;
        short s3 = (short) (s - 1);
        this.g = s3;
        return iArr[s3];
    }

    private void b(c0 c0Var, String str) {
        int a2 = a(c0Var, str, str.charAt(0) == '(' ? d0.e(str) : 0);
        if (a2 != 0) {
            d(a2);
            if (a2 == 4194308 || a2 == 4194307) {
                d(4194304);
            }
        }
    }

    final void a(p pVar) {
        this.b = pVar.b;
        this.c = pVar.c;
        this.f = (short) 0;
        this.d = pVar.d;
        this.e = pVar.e;
        this.g = pVar.g;
        this.h = pVar.h;
        this.i = pVar.i;
    }

    private void b(int i, int i2) {
        if (this.d == null) {
            this.d = new int[10];
        }
        int length = this.d.length;
        if (i >= length) {
            int[] iArr = new int[Math.max(i + 1, length * 2)];
            System.arraycopy(this.d, 0, iArr, 0, length);
            this.d = iArr;
        }
        this.d[i] = i2;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:202)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:61)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.processFallThroughCases(SwitchRegionMaker.java:105)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:64)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.processFallThroughCases(SwitchRegionMaker.java:105)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:64)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.processFallThroughCases(SwitchRegionMaker.java:105)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:64)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.processFallThroughCases(SwitchRegionMaker.java:105)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:64)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01ba A[FALL_THROUGH, PHI: r10
  0x01ba: PHI (r10v1 int) = (r10v0 int), (r10v2 int), (r10v0 int), (r10v0 int), (r10v0 int), (r10v0 int), (r10v0 int) binds: [B:2:0x001a, B:125:0x0068, B:116:0x003e, B:3:0x001d, B:111:0x0190, B:60:0x01ac, B:54:0x0194] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0172  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void a(int r17, int r18, sdk.pendo.io.a.b0 r19, sdk.pendo.io.a.c0 r20) {
        /*
            Method dump skipped, instructions count: 962
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.a.p.a(int, int, sdk.pendo.io.a.b0, sdk.pendo.io.a.c0):void");
    }

    static int a(c0 c0Var, Object obj) {
        return obj instanceof Integer ? ((Integer) obj).intValue() | 4194304 : obj instanceof String ? a(c0Var, d0.d((String) obj).a(), 0) : c0Var.a("", ((s) obj).d) | 12582912;
    }

    private static int a(c0 c0Var, String str, int i) {
        char charAt = str.charAt(i);
        int i2 = 4194306;
        if (charAt == 'F') {
            return 4194306;
        }
        if (charAt == 'L') {
            return c0Var.g(str.substring(i + 1, str.length() - 1)) | 8388608;
        }
        if (charAt != 'S') {
            if (charAt == 'V') {
                return 0;
            }
            if (charAt != 'I') {
                if (charAt == 'J') {
                    return 4194308;
                }
                if (charAt != 'Z') {
                    if (charAt == '[') {
                        int i3 = i + 1;
                        while (str.charAt(i3) == '[') {
                            i3++;
                        }
                        char charAt2 = str.charAt(i3);
                        if (charAt2 != 'F') {
                            if (charAt2 == 'L') {
                                i2 = c0Var.g(str.substring(i3 + 1, str.length() - 1)) | 8388608;
                            } else if (charAt2 == 'S') {
                                i2 = 4194316;
                            } else if (charAt2 == 'Z') {
                                i2 = 4194313;
                            } else if (charAt2 == 'I') {
                                i2 = 4194305;
                            } else if (charAt2 != 'J') {
                                switch (charAt2) {
                                    case 'B':
                                        i2 = 4194314;
                                        break;
                                    case 'C':
                                        i2 = 4194315;
                                        break;
                                    case 'D':
                                        i2 = 4194307;
                                        break;
                                    default:
                                        throw new IllegalArgumentException();
                                }
                            } else {
                                i2 = 4194308;
                            }
                        }
                        return ((i3 - i) << 26) | i2;
                    }
                    switch (charAt) {
                        case 'B':
                        case 'C':
                            break;
                        case 'D':
                            return 4194307;
                        default:
                            throw new IllegalArgumentException();
                    }
                }
            }
        }
        return 4194305;
    }

    static int a(c0 c0Var, String str) {
        return c0Var.g(str) | 8388608;
    }

    private int a(int i, int i2) {
        int i3 = (-67108864) & i;
        int i4 = 62914560 & i;
        if (i4 == 16777216) {
            int i5 = i3 + this.b[i & 1048575];
            if ((i & 1048576) == 0 || !(i5 == 4194308 || i5 == 4194307)) {
                return i5;
            }
            return 4194304;
        }
        if (i4 != 20971520) {
            return i;
        }
        int i6 = i3 + this.c[i2 - (i & 1048575)];
        if ((i & 1048576) == 0 || !(i6 == 4194308 || i6 == 4194307)) {
            return i6;
        }
        return 4194304;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004d A[LOOP:0: B:8:0x000d->B:15:0x004d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0037 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int a(sdk.pendo.io.a.c0 r9, int r10) {
        /*
            r8 = this;
            r0 = 4194310(0x400006, float:5.87748E-39)
            if (r10 == r0) goto Lc
            r1 = -4194304(0xffffffffffc00000, float:NaN)
            r1 = r1 & r10
            r2 = 12582912(0xc00000, float:1.7632415E-38)
            if (r1 != r2) goto L50
        Lc:
            r1 = 0
        Ld:
            int r2 = r8.h
            if (r1 >= r2) goto L50
            int[] r2 = r8.i
            r2 = r2[r1]
            r3 = -67108864(0xfffffffffc000000, float:-2.658456E36)
            r3 = r3 & r2
            r4 = 62914560(0x3c00000, float:1.1284746E-36)
            r4 = r4 & r2
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r2 & r5
            r7 = 16777216(0x1000000, float:2.3509887E-38)
            if (r4 != r7) goto L2a
            int[] r2 = r8.b
            r2 = r2[r6]
        L28:
            int r2 = r2 + r3
            goto L35
        L2a:
            r7 = 20971520(0x1400000, float:3.526483E-38)
            if (r4 != r7) goto L35
            int[] r2 = r8.c
            int r4 = r2.length
            int r4 = r4 - r6
            r2 = r2[r4]
            goto L28
        L35:
            if (r10 != r2) goto L4d
            r1 = 8388608(0x800000, float:1.1754944E-38)
            if (r10 != r0) goto L45
            java.lang.String r10 = r9.b()
        L3f:
            int r9 = r9.g(r10)
            r9 = r9 | r1
            return r9
        L45:
            r10 = r10 & r5
            sdk.pendo.io.a.b0 r10 = r9.c(r10)
            java.lang.String r10 = r10.e
            goto L3f
        L4d:
            int r1 = r1 + 1
            goto Ld
        L50:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.a.p.a(sdk.pendo.io.a.c0, int):int");
    }

    final int a() {
        return this.c.length;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0030, code lost:
    
        if ((r11 & 62914560) == 8388608) goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(sdk.pendo.io.a.c0 r10, int r11, int[] r12, int r13) {
        /*
            r0 = r12[r13]
            r1 = 0
            if (r0 != r11) goto L6
            return r1
        L6:
            r2 = 67108863(0x3ffffff, float:1.5046327E-36)
            r2 = r2 & r11
            r3 = 4194309(0x400005, float:5.877479E-39)
            if (r2 != r3) goto L13
            if (r0 != r3) goto L12
            return r1
        L12:
            r11 = r3
        L13:
            r2 = 1
            if (r0 != 0) goto L19
            r12[r13] = r11
            return r2
        L19:
            r4 = -67108864(0xfffffffffc000000, float:-2.658456E36)
            r5 = r0 & r4
            r6 = 62914560(0x3c00000, float:1.1284746E-36)
            r7 = 8388608(0x800000, float:1.1754944E-38)
            if (r5 != 0) goto L33
            r8 = r0 & r6
            if (r8 != r7) goto L28
            goto L33
        L28:
            if (r0 != r3) goto L64
            r10 = r11 & r4
            if (r10 != 0) goto L79
            r10 = r11 & r6
            if (r10 != r7) goto L64
            goto L79
        L33:
            if (r11 != r3) goto L36
            return r1
        L36:
            r3 = -4194304(0xffffffffffc00000, float:NaN)
            r8 = r11 & r3
            r3 = r3 & r0
            java.lang.String r9 = "java/lang/Object"
            if (r8 != r3) goto L5b
            r3 = r0 & r6
            if (r3 != r7) goto L52
            r3 = r11 & r4
            r3 = r3 | r7
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r11 = r11 & r4
            r4 = r4 & r0
            int r10 = r10.b(r11, r4)
            r11 = r3 | r10
            goto L79
        L52:
            r11 = r11 & r4
            int r11 = r11 + r4
        L54:
            r11 = r11 | r7
            int r10 = r10.g(r9)
            r11 = r11 | r10
            goto L79
        L5b:
            r3 = r11 & r4
            if (r3 != 0) goto L67
            r8 = r11 & r6
            if (r8 != r7) goto L64
            goto L67
        L64:
            r11 = 4194304(0x400000, float:5.877472E-39)
            goto L79
        L67:
            if (r3 == 0) goto L6d
            r11 = r11 & r6
            if (r11 == r7) goto L6d
            int r3 = r3 + r4
        L6d:
            if (r5 == 0) goto L74
            r11 = r0 & r6
            if (r11 == r7) goto L74
            int r5 = r5 + r4
        L74:
            int r11 = java.lang.Math.min(r3, r5)
            goto L54
        L79:
            if (r11 == r0) goto L7e
            r12[r13] = r11
            return r2
        L7e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.a.p.a(sdk.pendo.io.a.c0, int, int[], int):boolean");
    }

    final boolean a(c0 c0Var, p pVar, int i) {
        boolean z;
        int i2;
        int length = this.b.length;
        int length2 = this.c.length;
        boolean z2 = true;
        if (pVar.b == null) {
            pVar.b = new int[length];
            z = true;
        } else {
            z = false;
        }
        for (int i3 = 0; i3 < length; i3++) {
            int[] iArr = this.d;
            if (iArr == null || i3 >= iArr.length) {
                i2 = this.b[i3];
            } else {
                int i4 = iArr[i3];
                i2 = i4 == 0 ? this.b[i3] : a(i4, length2);
            }
            if (this.i != null) {
                i2 = a(c0Var, i2);
            }
            z |= a(c0Var, i2, pVar.b, i3);
        }
        if (i > 0) {
            for (int i5 = 0; i5 < length; i5++) {
                z |= a(c0Var, this.b[i5], pVar.b, i5);
            }
            if (pVar.c == null) {
                pVar.c = new int[1];
            } else {
                z2 = z;
            }
            return a(c0Var, i, pVar.c, 0) | z2;
        }
        int length3 = this.c.length + this.f;
        if (pVar.c == null) {
            pVar.c = new int[this.g + length3];
        } else {
            z2 = z;
        }
        for (int i6 = 0; i6 < length3; i6++) {
            int i7 = this.c[i6];
            if (this.i != null) {
                i7 = a(c0Var, i7);
            }
            z2 |= a(c0Var, i7, pVar.c, i6);
        }
        for (int i8 = 0; i8 < this.g; i8++) {
            int a2 = a(this.e[i8], length2);
            if (this.i != null) {
                a2 = a(c0Var, a2);
            }
            z2 |= a(c0Var, a2, pVar.c, length3 + i8);
        }
        return z2;
    }

    private void a(String str) {
        char charAt = str.charAt(0);
        if (charAt == '(') {
            c((d0.b(str) >> 2) - 1);
        } else if (charAt == 'J' || charAt == 'D') {
            c(2);
        } else {
            c(1);
        }
    }

    static void a(c0 c0Var, int i, d dVar) {
        char c;
        d b;
        String sb;
        int i2;
        int i3 = ((-67108864) & i) >> 26;
        if (i3 == 0) {
            int i4 = i & 1048575;
            int i5 = i & 62914560;
            if (i5 == 4194304) {
                dVar.b(i4);
                return;
            }
            if (i5 != 8388608) {
                if (i5 != 12582912) {
                    throw new AssertionError();
                }
                b = dVar.b(8);
                i2 = (int) c0Var.c(i4).f;
                b.d(i2);
            }
            b = dVar.b(7);
            sb = c0Var.c(i4).e;
        } else {
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                int i6 = i3 - 1;
                if (i3 <= 0) {
                    break;
                }
                sb2.append('[');
                i3 = i6;
            }
            if ((i & 62914560) == 8388608) {
                sb2.append(Matrix.MATRIX_TYPE_RANDOM_LT).append(c0Var.c(i & 1048575).e).append(';');
            } else {
                int i7 = i & 1048575;
                if (i7 == 1) {
                    c = 'I';
                } else if (i7 == 2) {
                    c = 'F';
                } else if (i7 == 3) {
                    c = 'D';
                } else if (i7 != 4) {
                    switch (i7) {
                        case 9:
                            c = Matrix.MATRIX_TYPE_ZERO;
                            break;
                        case 10:
                            c = 'B';
                            break;
                        case 11:
                            c = 'C';
                            break;
                        case 12:
                            c = 'S';
                            break;
                        default:
                            throw new AssertionError();
                    }
                } else {
                    c = 'J';
                }
                sb2.append(c);
            }
            b = dVar.b(7);
            sb = sb2.toString();
        }
        i2 = c0Var.a(sb).f814a;
        b.d(i2);
    }

    final void a(c0 c0Var, int i, Object[] objArr, int i2, Object[] objArr2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            this.b[i3] = a(c0Var, objArr[i4]);
            Object obj = objArr[i4];
            if (obj == y.e || obj == y.d) {
                this.b[i5] = 4194304;
                i3 = i5 + 1;
            } else {
                i3 = i5;
            }
        }
        while (true) {
            int[] iArr = this.b;
            if (i3 >= iArr.length) {
                break;
            }
            iArr[i3] = 4194304;
            i3++;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < i2; i7++) {
            Object obj2 = objArr2[i7];
            if (obj2 == y.e || obj2 == y.d) {
                i6++;
            }
        }
        this.c = new int[i6 + i2];
        int i8 = 0;
        for (int i9 = 0; i9 < i2; i9++) {
            int i10 = i8 + 1;
            this.c[i8] = a(c0Var, objArr2[i9]);
            Object obj3 = objArr2[i9];
            if (obj3 == y.e || obj3 == y.d) {
                this.c[i10] = 4194304;
                i8 = i10 + 1;
            } else {
                i8 = i10;
            }
        }
        this.g = (short) 0;
        this.h = 0;
    }

    final void a(c0 c0Var, int i, String str, int i2) {
        int i3;
        int[] iArr = new int[i2];
        this.b = iArr;
        this.c = new int[0];
        if ((i & 8) == 0) {
            i3 = 1;
            if ((i & 262144) == 0) {
                iArr[0] = c0Var.g(c0Var.b()) | 8388608;
            } else {
                iArr[0] = 4194310;
            }
        } else {
            i3 = 0;
        }
        for (d0 d0Var : d0.a(str)) {
            int a2 = a(c0Var, d0Var.a(), 0);
            int[] iArr2 = this.b;
            int i4 = i3 + 1;
            iArr2[i3] = a2;
            if (a2 == 4194308 || a2 == 4194307) {
                i3 = i4 + 1;
                iArr2[i4] = 4194304;
            } else {
                i3 = i4;
            }
        }
        while (i3 < i2) {
            this.b[i3] = 4194304;
            i3++;
        }
    }
}
