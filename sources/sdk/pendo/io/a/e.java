package sdk.pendo.io.a;

import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.tensorflow.lite.schema.BuiltinOptions;

/* loaded from: classes6.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    public final byte[] f820a;
    public final int b;
    final byte[] c;
    private final int[] d;
    private final String[] e;
    private final i[] f;
    private final int[] g;
    private final int h;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    e(byte[] bArr, int i, boolean z) {
        this.c = bArr;
        this.f820a = bArr;
        if (z) {
            int i2 = i + 6;
            if (f(i2) > 61) {
                throw new IllegalArgumentException("Unsupported class file major version " + ((int) f(i2)));
            }
        }
        int g = g(i + 8);
        this.d = new int[g];
        this.e = new String[g];
        int i3 = i + 10;
        boolean z2 = false;
        int i4 = 0;
        boolean z3 = false;
        int i5 = 1;
        while (i5 < g) {
            int i6 = i5 + 1;
            int i7 = i3 + 1;
            this.d[i5] = i7;
            int i8 = 3;
            switch (bArr[i3]) {
                case 1:
                    i8 = 3 + g(i7);
                    if (i8 > i4) {
                        i4 = i8;
                    }
                    i5 = i6;
                    i3 += i8;
                case 2:
                case 13:
                case 14:
                default:
                    throw new IllegalArgumentException();
                case 3:
                case 4:
                case 9:
                case 10:
                case 11:
                case 12:
                    i5 = i6;
                    i8 = 5;
                    i3 += i8;
                case 5:
                case 6:
                    i6++;
                    i8 = 9;
                    i5 = i6;
                    i3 += i8;
                case 7:
                case 8:
                case 16:
                case 19:
                case 20:
                    i5 = i6;
                    i3 += i8;
                case 15:
                    i8 = 4;
                    i5 = i6;
                    i3 += i8;
                case 17:
                    z2 = true;
                    z3 = true;
                    i5 = i6;
                    i8 = 5;
                    i3 += i8;
                case 18:
                    z3 = true;
                    i5 = i6;
                    i8 = 5;
                    i3 += i8;
            }
        }
        this.h = i4;
        this.b = i3;
        this.f = z2 ? new i[g] : null;
        this.g = z3 ? b(i4) : null;
    }

    private s b(int i, s[] sVarArr) {
        s c = c(i, sVarArr);
        c.f830a = (short) (c.f830a & (-2));
        return c;
    }

    public void a(g gVar, c[] cVarArr, int i) {
        int i2;
        int i3;
        int i4;
        String[] strArr;
        k kVar = new k();
        kVar.f824a = cVarArr;
        kVar.b = i;
        char[] cArr = new char[this.h];
        kVar.c = cArr;
        int i5 = this.b;
        int g = g(i5);
        String a2 = a(i5 + 2, cArr);
        String a3 = a(i5 + 4, cArr);
        int g2 = g(i5 + 6);
        String[] strArr2 = new String[g2];
        int i6 = i5 + 8;
        for (int i7 = 0; i7 < g2; i7++) {
            strArr2[i7] = a(i6, cArr);
            i6 += 2;
        }
        int a4 = a();
        int i8 = g;
        int g3 = g(a4 - 2);
        String str = null;
        String str2 = null;
        int i9 = 0;
        String str3 = null;
        int i10 = 0;
        String str4 = null;
        String str5 = null;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        c cVar = null;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        while (g3 > 0) {
            String g4 = g(a4, cArr);
            int d = d(a4 + 2);
            int i20 = a4 + 6;
            String str6 = str;
            if ("SourceFile".equals(g4)) {
                i2 = i20;
                str2 = g(i20, cArr);
            } else if ("InnerClasses".equals(g4)) {
                i18 = i20;
                i2 = i18;
            } else if ("EnclosingMethod".equals(g4)) {
                i11 = i20;
                i2 = i11;
            } else if ("NestHost".equals(g4)) {
                i2 = i20;
                str5 = a(i20, cArr);
            } else if ("NestMembers".equals(g4)) {
                i16 = i20;
                i2 = i16;
            } else if ("PermittedSubclasses".equals(g4)) {
                i17 = i20;
                i2 = i17;
            } else {
                if ("Signature".equals(g4)) {
                    str3 = g(i20, cArr);
                } else if ("RuntimeVisibleAnnotations".equals(g4)) {
                    i12 = i20;
                    i2 = i12;
                } else if ("RuntimeVisibleTypeAnnotations".equals(g4)) {
                    i14 = i20;
                    i2 = i14;
                } else if ("Deprecated".equals(g4)) {
                    i8 |= 131072;
                } else if ("Synthetic".equals(g4)) {
                    i8 |= 4096;
                } else if ("SourceDebugExtension".equals(g4)) {
                    if (d > this.c.length - i20) {
                        throw new IllegalArgumentException();
                    }
                    str = a(i20, d, new char[d]);
                    i2 = i20;
                    i3 = i6;
                    i4 = d;
                    strArr = strArr2;
                    a4 = i2 + i4;
                    g3--;
                    strArr2 = strArr;
                    i6 = i3;
                } else if ("RuntimeInvisibleAnnotations".equals(g4)) {
                    i13 = i20;
                    i2 = i13;
                } else if ("RuntimeInvisibleTypeAnnotations".equals(g4)) {
                    i15 = i20;
                    i2 = i15;
                } else if ("Record".equals(g4)) {
                    i8 |= 65536;
                    i19 = i20;
                    i2 = i19;
                } else if ("Module".equals(g4)) {
                    i9 = i20;
                    i2 = i9;
                } else if ("ModuleMainClass".equals(g4)) {
                    str4 = a(i20, cArr);
                } else if ("ModulePackages".equals(g4)) {
                    i10 = i20;
                    i2 = i10;
                } else {
                    if ("BootstrapMethods".equals(g4)) {
                        i2 = i20;
                        i3 = i6;
                        i4 = d;
                        strArr = strArr2;
                        str = str6;
                    } else {
                        i2 = i20;
                        i3 = i6;
                        i4 = d;
                        strArr = strArr2;
                        c a5 = a(cVarArr, g4, i2, d, cArr, -1, null);
                        a5.c = cVar;
                        cVar = a5;
                        i8 = i8;
                        str = str6;
                        str2 = str2;
                    }
                    a4 = i2 + i4;
                    g3--;
                    strArr2 = strArr;
                    i6 = i3;
                }
                i2 = i20;
            }
            i3 = i6;
            i4 = d;
            strArr = strArr2;
            str = str6;
            a4 = i2 + i4;
            g3--;
            strArr2 = strArr;
            i6 = i3;
        }
        String str7 = str;
        String str8 = str2;
        int i21 = i6;
        String[] strArr3 = strArr2;
        c cVar2 = cVar;
        gVar.a(d(this.d[1] - 7), i8, a2, str3, a3, strArr3);
        if ((i & 2) == 0 && (str8 != null || str7 != null)) {
            gVar.a(str8, str7);
        }
        if (i9 != 0) {
            a(gVar, kVar, i9, i10, str4);
        }
        String str9 = str5;
        if (str9 != null) {
            gVar.a(str9);
        }
        int i22 = i11;
        if (i22 != 0) {
            String a6 = a(i22, cArr);
            int g5 = g(i22 + 2);
            gVar.a(a6, g5 == 0 ? null : g(this.d[g5], cArr), g5 == 0 ? null : g(this.d[g5] + 2, cArr));
        }
        int i23 = i12;
        if (i23 != 0) {
            int g6 = g(i23);
            int i24 = i23 + 2;
            while (true) {
                int i25 = g6 - 1;
                if (g6 <= 0) {
                    break;
                }
                i24 = a(gVar.a(g(i24, cArr), true), i24 + 2, true, cArr);
                g6 = i25;
            }
        }
        int i26 = i13;
        if (i26 != 0) {
            int g7 = g(i26);
            int i27 = i26 + 2;
            while (true) {
                int i28 = g7 - 1;
                if (g7 <= 0) {
                    break;
                }
                i27 = a(gVar.a(g(i27, cArr), false), i27 + 2, true, cArr);
                g7 = i28;
            }
        }
        int i29 = i14;
        if (i29 != 0) {
            int g8 = g(i29);
            int i30 = i29 + 2;
            while (true) {
                int i31 = g8 - 1;
                if (g8 <= 0) {
                    break;
                }
                int a7 = a(kVar, i30);
                i30 = a(gVar.a(kVar.h, kVar.i, g(a7, cArr), true), a7 + 2, true, cArr);
                g8 = i31;
            }
        }
        int i32 = i15;
        if (i32 != 0) {
            int g9 = g(i32);
            int i33 = i32 + 2;
            while (true) {
                int i34 = g9 - 1;
                if (g9 <= 0) {
                    break;
                }
                int a8 = a(kVar, i33);
                i33 = a(gVar.a(kVar.h, kVar.i, g(a8, cArr), false), a8 + 2, true, cArr);
                g9 = i34;
            }
        }
        while (cVar2 != null) {
            c cVar3 = cVar2.c;
            cVar2.c = null;
            gVar.a(cVar2);
            cVar2 = cVar3;
        }
        int i35 = i16;
        if (i35 != 0) {
            int g10 = g(i35);
            int i36 = i35 + 2;
            while (true) {
                int i37 = g10 - 1;
                if (g10 <= 0) {
                    break;
                }
                gVar.b(a(i36, cArr));
                i36 += 2;
                g10 = i37;
            }
        }
        int i38 = i17;
        if (i38 != 0) {
            int g11 = g(i38);
            int i39 = i38 + 2;
            while (true) {
                int i40 = g11 - 1;
                if (g11 <= 0) {
                    break;
                }
                gVar.c(a(i39, cArr));
                i39 += 2;
                g11 = i40;
            }
        }
        int i41 = i18;
        if (i41 != 0) {
            int g12 = g(i41);
            int i42 = i41 + 2;
            while (true) {
                int i43 = g12 - 1;
                if (g12 <= 0) {
                    break;
                }
                gVar.a(a(i42, cArr), a(i42 + 2, cArr), g(i42 + 4, cArr), g(i42 + 6));
                i42 += 8;
                g12 = i43;
            }
        }
        int i44 = i19;
        if (i44 != 0) {
            int g13 = g(i44);
            int i45 = i44 + 2;
            while (true) {
                int i46 = g13 - 1;
                if (g13 <= 0) {
                    break;
                }
                i45 = c(gVar, kVar, i45);
                g13 = i46;
            }
        }
        int g14 = g(i21);
        int i47 = i21 + 2;
        while (true) {
            int i48 = g14 - 1;
            if (g14 <= 0) {
                break;
            }
            i47 = a(gVar, kVar, i47);
            g14 = i48;
        }
        int g15 = g(i47);
        int i49 = i47 + 2;
        while (true) {
            int i50 = g15 - 1;
            if (g15 <= 0) {
                gVar.a();
                return;
            } else {
                i49 = b(gVar, kVar, i49);
                g15 = i50;
            }
        }
    }

    public int c() {
        return this.h;
    }

    public int d(int i) {
        byte[] bArr = this.c;
        return (bArr[i + 3] & UByte.MAX_VALUE) | ((bArr[i] & UByte.MAX_VALUE) << 24) | ((bArr[i + 1] & UByte.MAX_VALUE) << 16) | ((bArr[i + 2] & UByte.MAX_VALUE) << 8);
    }

    public long e(int i) {
        return (d(i) << 32) | (d(i + 4) & BodyPartID.bodyIdMax);
    }

    public short f(int i) {
        byte[] bArr = this.c;
        return (short) ((bArr[i + 1] & UByte.MAX_VALUE) | ((bArr[i] & UByte.MAX_VALUE) << 8));
    }

    public String g(int i, char[] cArr) {
        int g = g(i);
        if (i == 0 || g == 0) {
            return null;
        }
        return h(g, cArr);
    }

    final String h(int i, char[] cArr) {
        String[] strArr = this.e;
        String str = strArr[i];
        if (str != null) {
            return str;
        }
        int i2 = this.d[i];
        String a2 = a(i2 + 2, g(i2), cArr);
        strArr[i] = a2;
        return a2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0050, code lost:
    
        r11.o = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0052, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(sdk.pendo.io.a.k r11) {
        /*
            r10 = this;
            java.lang.String r0 = r11.f
            java.lang.Object[] r1 = r11.q
            int r2 = r11.d
            r2 = r2 & 8
            r3 = 1
            r4 = 0
            if (r2 != 0) goto L28
            java.lang.String r2 = r11.e
            java.lang.String r5 = "<init>"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L1b
            java.lang.Integer r2 = sdk.pendo.io.a.y.g
            r1[r4] = r2
            goto L27
        L1b:
            int r2 = r10.b
            int r2 = r2 + 2
            char[] r5 = r11.c
            java.lang.String r2 = r10.a(r2, r5)
            r1[r4] = r2
        L27:
            r4 = r3
        L28:
            r2 = r3
        L29:
            int r5 = r2 + 1
            char r6 = r0.charAt(r2)
            r7 = 70
            if (r6 == r7) goto La4
            r7 = 59
            r8 = 76
            if (r6 == r8) goto L8d
            r9 = 83
            if (r6 == r9) goto L84
            r9 = 73
            if (r6 == r9) goto L84
            r9 = 74
            if (r6 == r9) goto L7d
            r9 = 90
            if (r6 == r9) goto L84
            r9 = 91
            if (r6 == r9) goto L5a
            switch(r6) {
                case 66: goto L84;
                case 67: goto L84;
                case 68: goto L53;
                default: goto L50;
            }
        L50:
            r11.o = r4
            return
        L53:
            int r2 = r4 + 1
            java.lang.Integer r6 = sdk.pendo.io.a.y.d
            r1[r4] = r6
            goto L8a
        L5a:
            char r6 = r0.charAt(r5)
            if (r6 != r9) goto L63
            int r5 = r5 + 1
            goto L5a
        L63:
            char r6 = r0.charAt(r5)
            if (r6 != r8) goto L71
        L69:
            int r5 = r5 + r3
            char r6 = r0.charAt(r5)
            if (r6 == r7) goto L71
            goto L69
        L71:
            int r6 = r4 + 1
            int r5 = r5 + r3
            java.lang.String r2 = r0.substring(r2, r5)
            r1[r4] = r2
            r2 = r5
            r4 = r6
            goto L29
        L7d:
            int r2 = r4 + 1
            java.lang.Integer r6 = sdk.pendo.io.a.y.e
            r1[r4] = r6
            goto L8a
        L84:
            int r2 = r4 + 1
            java.lang.Integer r6 = sdk.pendo.io.a.y.b
            r1[r4] = r6
        L8a:
            r4 = r2
            r2 = r5
            goto L29
        L8d:
            r2 = r5
        L8e:
            char r6 = r0.charAt(r2)
            if (r6 == r7) goto L97
            int r2 = r2 + 1
            goto L8e
        L97:
            int r6 = r4 + 1
            int r7 = r2 + 1
            java.lang.String r2 = r0.substring(r5, r2)
            r1[r4] = r2
            r4 = r6
            r2 = r7
            goto L29
        La4:
            int r2 = r4 + 1
            java.lang.Integer r6 = sdk.pendo.io.a.y.c
            r1[r4] = r6
            goto L8a
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.a.e.a(sdk.pendo.io.a.k):void");
    }

    private String f(int i, char[] cArr) {
        return g(this.d[g(i)], cArr);
    }

    public int b() {
        return this.d.length;
    }

    public int c(int i) {
        return this.c[i] & UByte.MAX_VALUE;
    }

    public String d(int i, char[] cArr) {
        return f(i, cArr);
    }

    public String e(int i, char[] cArr) {
        return f(i, cArr);
    }

    public int g(int i) {
        byte[] bArr = this.c;
        return (bArr[i + 1] & UByte.MAX_VALUE) | ((bArr[i] & UByte.MAX_VALUE) << 8);
    }

    private void a(int i, s[] sVarArr) {
        if (sVarArr[i] == null) {
            s c = c(i, sVarArr);
            c.f830a = (short) (c.f830a | 1);
        }
    }

    private int[] b(int i) {
        char[] cArr = new char[i];
        int a2 = a();
        for (int g = g(a2 - 2); g > 0; g--) {
            String g2 = g(a2, cArr);
            int d = d(a2 + 2);
            int i2 = a2 + 6;
            if ("BootstrapMethods".equals(g2)) {
                int g3 = g(i2);
                int[] iArr = new int[g3];
                int i3 = i2 + 2;
                for (int i4 = 0; i4 < g3; i4++) {
                    iArr[i4] = i3;
                    i3 += (g(i3 + 2) * 2) + 4;
                }
                return iArr;
            }
            a2 = i2 + d;
        }
        throw new IllegalArgumentException();
    }

    private i c(int i, char[] cArr) {
        i iVar = this.f[i];
        if (iVar != null) {
            return iVar;
        }
        int[] iArr = this.d;
        int i2 = iArr[i];
        int i3 = iArr[g(i2 + 2)];
        String g = g(i3, cArr);
        String g2 = g(i3 + 2, cArr);
        int i4 = this.g[g(i2)];
        q qVar = (q) b(g(i4), cArr);
        int g3 = g(i4 + 2);
        Object[] objArr = new Object[g3];
        int i5 = i4 + 4;
        for (int i6 = 0; i6 < g3; i6++) {
            objArr[i6] = b(g(i5), cArr);
            i5 += 2;
        }
        i[] iVarArr = this.f;
        i iVar2 = new i(g, g2, qVar, objArr);
        iVarArr[i] = iVar2;
        return iVar2;
    }

    final int a() {
        int i = this.b;
        int g = i + 8 + (g(i + 6) * 2);
        int g2 = g(g);
        int i2 = g + 2;
        while (true) {
            int i3 = g2 - 1;
            if (g2 <= 0) {
                break;
            }
            int g3 = g(i2 + 6);
            i2 += 8;
            while (true) {
                int i4 = g3 - 1;
                if (g3 > 0) {
                    i2 += d(i2 + 2) + 6;
                    g3 = i4;
                }
            }
            g2 = i3;
        }
        int g4 = g(i2);
        int i5 = i2 + 2;
        while (true) {
            int i6 = g4 - 1;
            if (g4 <= 0) {
                return i5 + 2;
            }
            int g5 = g(i5 + 6);
            i5 += 8;
            while (true) {
                int i7 = g5 - 1;
                if (g5 > 0) {
                    i5 += d(i5 + 2) + 6;
                    g5 = i7;
                }
            }
            g4 = i6;
        }
    }

    public Object b(int i, char[] cArr) {
        int i2 = this.d[i];
        byte b = this.c[i2 - 1];
        switch (b) {
            case 3:
                return Integer.valueOf(d(i2));
            case 4:
                return Float.valueOf(Float.intBitsToFloat(d(i2)));
            case 5:
                return Long.valueOf(e(i2));
            case 6:
                return Double.valueOf(Double.longBitsToDouble(e(i2)));
            case 7:
                return d0.d(g(i2, cArr));
            case 8:
                return g(i2, cArr);
            default:
                switch (b) {
                    case 15:
                        int c = c(i2);
                        int i3 = this.d[g(i2 + 1)];
                        int i4 = this.d[g(i3 + 2)];
                        return new q(c, a(i3, cArr), g(i4, cArr), g(i4 + 2, cArr), this.c[i3 - 1] == 11);
                    case 16:
                        return d0.c(g(i2, cArr));
                    case 17:
                        return c(i, cArr);
                    default:
                        throw new IllegalArgumentException();
                }
        }
    }

    protected s c(int i, s[] sVarArr) {
        if (sVarArr[i] == null) {
            sVarArr[i] = new s();
        }
        return sVarArr[i];
    }

    private int b(g gVar, k kVar, int i) {
        int i2;
        int i3;
        int i4;
        char[] cArr = kVar.c;
        kVar.d = g(i);
        kVar.e = g(i + 2, cArr);
        int i5 = i + 4;
        kVar.f = g(i5, cArr);
        int i6 = i + 6;
        int g = g(i6);
        int i7 = i6 + 2;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        c cVar = null;
        boolean z = false;
        int i14 = 0;
        String[] strArr = null;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (true) {
            int i19 = g - 1;
            if (g <= 0) {
                break;
            }
            String g2 = g(i7, cArr);
            int d = d(i7 + 2);
            int i20 = i7 + 6;
            int i21 = i8;
            if (!"Code".equals(g2)) {
                if ("Exceptions".equals(g2)) {
                    int g3 = g(i20);
                    String[] strArr2 = new String[g3];
                    int i22 = i9;
                    int i23 = i10;
                    int i24 = i20 + 2;
                    for (int i25 = 0; i25 < g3; i25++) {
                        strArr2[i25] = a(i24, cArr);
                        i24 += 2;
                    }
                    strArr = strArr2;
                    i14 = i20;
                    i8 = i21;
                    i9 = i22;
                    i10 = i23;
                    i4 = i14;
                } else {
                    i2 = i9;
                    i3 = i10;
                    if ("Signature".equals(g2)) {
                        i13 = g(i20);
                    } else if ("Deprecated".equals(g2)) {
                        kVar.d |= 131072;
                    } else if ("RuntimeVisibleAnnotations".equals(g2)) {
                        i10 = i20;
                        i8 = i21;
                        i9 = i2;
                        i4 = i10;
                    } else if ("RuntimeVisibleTypeAnnotations".equals(g2)) {
                        i8 = i20;
                        i4 = i8;
                        i9 = i2;
                        i10 = i3;
                    } else if ("AnnotationDefault".equals(g2)) {
                        i11 = i20;
                        i8 = i21;
                        i9 = i2;
                        i10 = i3;
                        i4 = i11;
                    } else if ("Synthetic".equals(g2)) {
                        kVar.d |= 4096;
                        i8 = i21;
                        i9 = i2;
                        i10 = i3;
                        z = true;
                    } else if ("RuntimeInvisibleAnnotations".equals(g2)) {
                        i9 = i20;
                        i8 = i21;
                        i10 = i3;
                        i4 = i9;
                    } else if ("RuntimeInvisibleTypeAnnotations".equals(g2)) {
                        i15 = i20;
                        i8 = i21;
                        i9 = i2;
                        i10 = i3;
                        i4 = i15;
                    } else if ("RuntimeVisibleParameterAnnotations".equals(g2)) {
                        i16 = i20;
                        i8 = i21;
                        i9 = i2;
                        i10 = i3;
                        i4 = i16;
                    } else if ("RuntimeInvisibleParameterAnnotations".equals(g2)) {
                        i17 = i20;
                        i8 = i21;
                        i9 = i2;
                        i10 = i3;
                        i4 = i17;
                    } else if ("MethodParameters".equals(g2)) {
                        i12 = i20;
                        i8 = i21;
                        i9 = i2;
                        i10 = i3;
                        i4 = i12;
                    } else {
                        i4 = i20;
                        c a2 = a(kVar.f824a, g2, i20, d, cArr, -1, null);
                        a2.c = cVar;
                        cVar = a2;
                        i13 = i13;
                        i9 = i2;
                        i10 = i3;
                        i8 = i21;
                        i11 = i11;
                        i12 = i12;
                    }
                    i8 = i21;
                    i9 = i2;
                    i10 = i3;
                }
                i7 = i4 + d;
                g = i19;
            } else if ((kVar.b & 1) == 0) {
                i18 = i20;
                i8 = i21;
                i4 = i18;
                i7 = i4 + d;
                g = i19;
            } else {
                i2 = i9;
                i3 = i10;
                i8 = i21;
                i9 = i2;
                i10 = i3;
            }
            i4 = i20;
            i7 = i4 + d;
            g = i19;
        }
        int i26 = i8;
        int i27 = i9;
        int i28 = i10;
        int i29 = i11;
        int i30 = i12;
        int i31 = i13;
        u a3 = gVar.a(kVar.d, kVar.e, kVar.f, i31 == 0 ? null : h(i31, cArr), strArr);
        if (a3 == null) {
            return i7;
        }
        if (a3 instanceof v) {
            v vVar = (v) a3;
            if (vVar.a(this, z, (kVar.d & 131072) != 0, g(i5), i31, i14)) {
                vVar.f(i, i7 - i);
                return i7;
            }
        }
        if (i30 != 0 && (kVar.b & 2) == 0) {
            int c = c(i30);
            int i32 = i30 + 1;
            while (true) {
                int i33 = c - 1;
                if (c <= 0) {
                    break;
                }
                a3.b(g(i32, cArr), g(i32 + 2));
                i32 += 4;
                c = i33;
            }
        }
        if (i29 != 0) {
            a a4 = a3.a();
            a(a4, i29, (String) null, cArr);
            if (a4 != null) {
                a4.a();
            }
        }
        if (i28 != 0) {
            int g4 = g(i28);
            int i34 = i28 + 2;
            while (true) {
                int i35 = g4 - 1;
                if (g4 <= 0) {
                    break;
                }
                i34 = a(a3.a(g(i34, cArr), true), i34 + 2, true, cArr);
                g4 = i35;
            }
        }
        if (i27 != 0) {
            int g5 = g(i27);
            int i36 = i27 + 2;
            while (true) {
                int i37 = g5 - 1;
                if (g5 <= 0) {
                    break;
                }
                i36 = a(a3.a(g(i36, cArr), false), i36 + 2, true, cArr);
                g5 = i37;
            }
        }
        if (i26 != 0) {
            int g6 = g(i26);
            int i38 = i26 + 2;
            while (true) {
                int i39 = g6 - 1;
                if (g6 <= 0) {
                    break;
                }
                int a5 = a(kVar, i38);
                i38 = a(a3.c(kVar.h, kVar.i, g(a5, cArr), true), a5 + 2, true, cArr);
                g6 = i39;
            }
        }
        int i40 = i15;
        if (i40 != 0) {
            int g7 = g(i40);
            int i41 = i40 + 2;
            while (true) {
                int i42 = g7 - 1;
                if (g7 <= 0) {
                    break;
                }
                int a6 = a(kVar, i41);
                i41 = a(a3.c(kVar.h, kVar.i, g(a6, cArr), false), a6 + 2, true, cArr);
                g7 = i42;
            }
        }
        int i43 = i16;
        if (i43 != 0) {
            a(a3, kVar, i43, true);
        }
        int i44 = i17;
        if (i44 != 0) {
            a(a3, kVar, i44, false);
        }
        while (cVar != null) {
            c cVar2 = cVar.c;
            cVar.c = null;
            a3.a(cVar);
            cVar = cVar2;
        }
        int i45 = i18;
        if (i45 != 0) {
            a3.b();
            a(a3, kVar, i45);
        }
        a3.c();
        return i7;
    }

    private int c(g gVar, k kVar, int i) {
        int i2;
        k kVar2 = kVar;
        char[] cArr = kVar2.c;
        String g = g(i, cArr);
        String g2 = g(i + 2, cArr);
        int i3 = i + 4;
        int g3 = g(i3);
        int i4 = i3 + 2;
        int i5 = 0;
        c cVar = null;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        String str = null;
        while (true) {
            int i9 = g3 - 1;
            if (g3 <= 0) {
                break;
            }
            String g4 = g(i4, cArr);
            int d = d(i4 + 2);
            int i10 = i4 + 6;
            if ("Signature".equals(g4)) {
                str = g(i10, cArr);
                i2 = i10;
            } else if ("RuntimeVisibleAnnotations".equals(g4)) {
                i8 = i10;
                i2 = i8;
            } else if ("RuntimeVisibleTypeAnnotations".equals(g4)) {
                i6 = i10;
                i2 = i6;
            } else if ("RuntimeInvisibleAnnotations".equals(g4)) {
                i7 = i10;
                i2 = i7;
            } else if ("RuntimeInvisibleTypeAnnotations".equals(g4)) {
                i5 = i10;
                i2 = i5;
            } else {
                i2 = i10;
                c cVar2 = cVar;
                cVar = a(kVar2.f824a, g4, i2, d, cArr, -1, null);
                cVar.c = cVar2;
                i8 = i8;
                i7 = i7;
                i6 = i6;
                i5 = i5;
            }
            i4 = i2 + d;
            kVar2 = kVar;
            g3 = i9;
        }
        int i11 = i5;
        c cVar3 = cVar;
        int i12 = i6;
        int i13 = i7;
        int i14 = i8;
        z b = gVar.b(g, g2, str);
        if (b == null) {
            return i4;
        }
        if (i14 != 0) {
            int g5 = g(i14);
            int i15 = i14 + 2;
            while (true) {
                int i16 = g5 - 1;
                if (g5 <= 0) {
                    break;
                }
                i15 = a(b.a(g(i15, cArr), true), i15 + 2, true, cArr);
                g5 = i16;
            }
        }
        if (i13 != 0) {
            int g6 = g(i13);
            int i17 = i13 + 2;
            while (true) {
                int i18 = g6 - 1;
                if (g6 <= 0) {
                    break;
                }
                i17 = a(b.a(g(i17, cArr), false), i17 + 2, true, cArr);
                g6 = i18;
            }
        }
        if (i12 != 0) {
            int g7 = g(i12);
            int i19 = i12 + 2;
            while (true) {
                int i20 = g7 - 1;
                if (g7 <= 0) {
                    break;
                }
                int a2 = a(kVar, i19);
                i19 = a(b.a(kVar.h, kVar.i, g(a2, cArr), true), a2 + 2, true, cArr);
                g7 = i20;
            }
        }
        if (i11 != 0) {
            int g8 = g(i11);
            int i21 = i11 + 2;
            while (true) {
                int i22 = g8 - 1;
                if (g8 <= 0) {
                    break;
                }
                int a3 = a(kVar, i21);
                i21 = a(b.a(kVar.h, kVar.i, g(a3, cArr), false), a3 + 2, true, cArr);
                g8 = i22;
            }
        }
        c cVar4 = cVar3;
        while (cVar4 != null) {
            c cVar5 = cVar4.c;
            cVar4.c = null;
            b.a(cVar4);
            cVar4 = cVar5;
        }
        b.a();
        return i4;
    }

    public int a(int i) {
        return this.d[i];
    }

    private int a(int[] iArr, int i) {
        if (iArr == null || i >= iArr.length || c(iArr[i]) < 67) {
            return -1;
        }
        return g(iArr[i] + 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int[] b(sdk.pendo.io.a.u r11, sdk.pendo.io.a.k r12, int r13, boolean r14) {
        /*
            r10 = this;
            char[] r0 = r12.c
            int r1 = r10.g(r13)
            int[] r2 = new int[r1]
            int r13 = r13 + 2
            r3 = 0
        Lb:
            if (r3 >= r1) goto L84
            r2[r3] = r13
            int r4 = r10.d(r13)
            int r5 = r4 >>> 24
            r6 = 23
            if (r5 == r6) goto L4d
            switch(r5) {
                case 16: goto L4d;
                case 17: goto L4d;
                case 18: goto L4d;
                default: goto L1c;
            }
        L1c:
            switch(r5) {
                case 64: goto L28;
                case 65: goto L28;
                case 66: goto L4d;
                case 67: goto L4d;
                case 68: goto L4d;
                case 69: goto L4d;
                case 70: goto L4d;
                case 71: goto L25;
                case 72: goto L25;
                case 73: goto L25;
                case 74: goto L25;
                case 75: goto L25;
                default: goto L1f;
            }
        L1f:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            r11.<init>()
            throw r11
        L25:
            int r13 = r13 + 4
            goto L4f
        L28:
            int r6 = r13 + 1
            int r6 = r10.g(r6)
            int r13 = r13 + 3
        L30:
            int r7 = r6 + (-1)
            if (r6 <= 0) goto L4f
            int r6 = r10.g(r13)
            int r8 = r13 + 2
            int r8 = r10.g(r8)
            int r13 = r13 + 6
            sdk.pendo.io.a.s[] r9 = r12.g
            r10.b(r6, r9)
            int r6 = r6 + r8
            sdk.pendo.io.a.s[] r8 = r12.g
            r10.b(r6, r8)
            r6 = r7
            goto L30
        L4d:
            int r13 = r13 + 3
        L4f:
            int r6 = r10.c(r13)
            r7 = 66
            r8 = 0
            r9 = 1
            if (r5 != r7) goto L78
            if (r6 != 0) goto L5c
            goto L63
        L5c:
            sdk.pendo.io.a.e0 r8 = new sdk.pendo.io.a.e0
            byte[] r5 = r10.c
            r8.<init>(r5, r13)
        L63:
            int r6 = r6 * 2
            int r6 = r6 + r9
            int r13 = r13 + r6
            java.lang.String r5 = r10.g(r13, r0)
            int r13 = r13 + 2
            r4 = r4 & (-256(0xffffffffffffff00, float:NaN))
            sdk.pendo.io.a.a r4 = r11.b(r4, r8, r5, r14)
            int r13 = r10.a(r4, r13, r9, r0)
            goto L81
        L78:
            int r6 = r6 * 2
            int r6 = r6 + 3
            int r13 = r13 + r6
            int r13 = r10.a(r8, r13, r9, r0)
        L81:
            int r3 = r3 + 1
            goto Lb
        L84:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.a.e.b(sdk.pendo.io.a.u, sdk.pendo.io.a.k, int, boolean):int[]");
    }

    private c a(c[] cVarArr, String str, int i, int i2, char[] cArr, int i3, s[] sVarArr) {
        for (c cVar : cVarArr) {
            if (cVar.f815a.equals(str)) {
                return cVar.a(this, i, i2, cArr, i3, sVarArr);
            }
        }
        return new c(str).a(this, i, i2, (char[]) null, -1, (s[]) null);
    }

    public String a(int i, char[] cArr) {
        return f(i, cArr);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    private void a(sdk.pendo.io.a.u r46, sdk.pendo.io.a.k r47, int r48) {
        /*
            Method dump skipped, instructions count: 3428
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.a.e.a(sdk.pendo.io.a.u, sdk.pendo.io.a.k, int):void");
    }

    private int a(a aVar, int i, String str, char[] cArr) {
        Object b;
        int i2 = 0;
        if (aVar == null) {
            int i3 = this.c[i] & UByte.MAX_VALUE;
            return i3 != 64 ? i3 != 91 ? i3 != 101 ? i + 3 : i + 5 : a((a) null, i + 1, false, cArr) : a((a) null, i + 3, true, cArr);
        }
        int i4 = i + 1;
        int i5 = this.c[i] & UByte.MAX_VALUE;
        if (i5 == 64) {
            return a(aVar.a(str, g(i4, cArr)), i4 + 2, true, cArr);
        }
        if (i5 != 70) {
            if (i5 == 83) {
                b = Short.valueOf((short) d(this.d[g(i4)]));
            } else if (i5 == 99) {
                b = d0.f(g(i4, cArr));
            } else {
                if (i5 == 101) {
                    aVar.a(str, g(i4, cArr), g(i4 + 2, cArr));
                    return i4 + 4;
                }
                if (i5 == 115) {
                    b = g(i4, cArr);
                } else if (i5 != 73 && i5 != 74) {
                    if (i5 == 90) {
                        b = d(this.d[g(i4)]) == 0 ? Boolean.FALSE : Boolean.TRUE;
                    } else {
                        if (i5 == 91) {
                            int g = g(i4);
                            int i6 = i4 + 2;
                            if (g == 0) {
                                return a(aVar.a(str), i6 - 2, false, cArr);
                            }
                            int i7 = this.c[i6] & UByte.MAX_VALUE;
                            if (i7 == 70) {
                                float[] fArr = new float[g];
                                while (i2 < g) {
                                    fArr[i2] = Float.intBitsToFloat(d(this.d[g(i6 + 1)]));
                                    i6 += 3;
                                    i2++;
                                }
                                aVar.a(str, fArr);
                                return i6;
                            }
                            if (i7 == 83) {
                                short[] sArr = new short[g];
                                while (i2 < g) {
                                    sArr[i2] = (short) d(this.d[g(i6 + 1)]);
                                    i6 += 3;
                                    i2++;
                                }
                                aVar.a(str, sArr);
                                return i6;
                            }
                            if (i7 == 90) {
                                boolean[] zArr = new boolean[g];
                                for (int i8 = 0; i8 < g; i8++) {
                                    zArr[i8] = d(this.d[g(i6 + 1)]) != 0;
                                    i6 += 3;
                                }
                                aVar.a(str, zArr);
                                return i6;
                            }
                            if (i7 == 73) {
                                int[] iArr = new int[g];
                                while (i2 < g) {
                                    iArr[i2] = d(this.d[g(i6 + 1)]);
                                    i6 += 3;
                                    i2++;
                                }
                                aVar.a(str, iArr);
                                return i6;
                            }
                            if (i7 == 74) {
                                long[] jArr = new long[g];
                                while (i2 < g) {
                                    jArr[i2] = e(this.d[g(i6 + 1)]);
                                    i6 += 3;
                                    i2++;
                                }
                                aVar.a(str, jArr);
                                return i6;
                            }
                            switch (i7) {
                                case 66:
                                    byte[] bArr = new byte[g];
                                    while (i2 < g) {
                                        bArr[i2] = (byte) d(this.d[g(i6 + 1)]);
                                        i6 += 3;
                                        i2++;
                                    }
                                    aVar.a(str, bArr);
                                    return i6;
                                case 67:
                                    char[] cArr2 = new char[g];
                                    while (i2 < g) {
                                        cArr2[i2] = (char) d(this.d[g(i6 + 1)]);
                                        i6 += 3;
                                        i2++;
                                    }
                                    aVar.a(str, cArr2);
                                    return i6;
                                case 68:
                                    double[] dArr = new double[g];
                                    while (i2 < g) {
                                        dArr[i2] = Double.longBitsToDouble(e(this.d[g(i6 + 1)]));
                                        i6 += 3;
                                        i2++;
                                    }
                                    aVar.a(str, dArr);
                                    return i6;
                                default:
                                    return a(aVar.a(str), i6 - 2, false, cArr);
                            }
                        }
                        switch (i5) {
                            case 66:
                                b = Byte.valueOf((byte) d(this.d[g(i4)]));
                                break;
                            case 67:
                                b = Character.valueOf((char) d(this.d[g(i4)]));
                                break;
                            case 68:
                                break;
                            default:
                                throw new IllegalArgumentException();
                        }
                    }
                }
            }
            aVar.a(str, b);
            return i4 + 2;
        }
        b = b(g(i4), cArr);
        aVar.a(str, b);
        return i4 + 2;
    }

    private int a(a aVar, int i, boolean z, char[] cArr) {
        int g = g(i);
        int i2 = i + 2;
        if (!z) {
            while (true) {
                int i3 = g - 1;
                if (g <= 0) {
                    break;
                }
                i2 = a(aVar, i2, (String) null, cArr);
                g = i3;
            }
        } else {
            while (true) {
                int i4 = g - 1;
                if (g <= 0) {
                    break;
                }
                i2 = a(aVar, i2 + 2, g(i2, cArr), cArr);
                g = i4;
            }
        }
        if (aVar != null) {
            aVar.a();
        }
        return i2;
    }

    private int a(g gVar, k kVar, int i) {
        int i2;
        int i3;
        k kVar2 = kVar;
        char[] cArr = kVar2.c;
        int g = g(i);
        String g2 = g(i + 2, cArr);
        String g3 = g(i + 4, cArr);
        int i4 = i + 6;
        int g4 = g(i4);
        int i5 = i4 + 2;
        int i6 = g;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        c cVar = null;
        String str = null;
        Object obj = null;
        while (true) {
            int i11 = g4 - 1;
            if (g4 <= 0) {
                break;
            }
            String g5 = g(i5, cArr);
            int d = d(i5 + 2);
            int i12 = i5 + 6;
            if ("ConstantValue".equals(g5)) {
                int g6 = g(i12);
                if (g6 == 0) {
                    i2 = i12;
                    obj = null;
                } else {
                    obj = b(g6, cArr);
                    i2 = i12;
                }
            } else {
                if ("Signature".equals(g5)) {
                    str = g(i12, cArr);
                } else {
                    if ("Deprecated".equals(g5)) {
                        i3 = 131072 | i6;
                    } else if ("Synthetic".equals(g5)) {
                        i3 = i6 | 4096;
                    } else if ("RuntimeVisibleAnnotations".equals(g5)) {
                        i10 = i12;
                        i2 = i10;
                    } else if ("RuntimeVisibleTypeAnnotations".equals(g5)) {
                        i8 = i12;
                        i2 = i8;
                    } else if ("RuntimeInvisibleAnnotations".equals(g5)) {
                        i9 = i12;
                        i2 = i9;
                    } else if ("RuntimeInvisibleTypeAnnotations".equals(g5)) {
                        i7 = i12;
                        i2 = i7;
                    } else {
                        i2 = i12;
                        c cVar2 = cVar;
                        cVar = a(kVar2.f824a, g5, i2, d, cArr, -1, null);
                        cVar.c = cVar2;
                        i9 = i9;
                        i10 = i10;
                        i7 = i7;
                        i8 = i8;
                    }
                    i6 = i3;
                }
                i2 = i12;
            }
            i5 = i2 + d;
            kVar2 = kVar;
            g4 = i11;
        }
        c cVar3 = cVar;
        int i13 = i7;
        int i14 = i8;
        int i15 = i9;
        int i16 = i10;
        n a2 = gVar.a(i6, g2, g3, str, obj);
        if (a2 == null) {
            return i5;
        }
        if (i16 != 0) {
            int g7 = g(i16);
            int i17 = i16 + 2;
            while (true) {
                int i18 = g7 - 1;
                if (g7 <= 0) {
                    break;
                }
                i17 = a(a2.a(g(i17, cArr), true), i17 + 2, true, cArr);
                g7 = i18;
            }
        }
        if (i15 != 0) {
            int g8 = g(i15);
            int i19 = i15 + 2;
            while (true) {
                int i20 = g8 - 1;
                if (g8 <= 0) {
                    break;
                }
                i19 = a(a2.a(g(i19, cArr), false), i19 + 2, true, cArr);
                g8 = i20;
            }
        }
        if (i14 != 0) {
            int g9 = g(i14);
            int i21 = i14 + 2;
            while (true) {
                int i22 = g9 - 1;
                if (g9 <= 0) {
                    break;
                }
                int a3 = a(kVar, i21);
                i21 = a(a2.a(kVar.h, kVar.i, g(a3, cArr), true), a3 + 2, true, cArr);
                g9 = i22;
            }
        }
        if (i13 != 0) {
            int g10 = g(i13);
            int i23 = i13 + 2;
            while (true) {
                int i24 = g10 - 1;
                if (g10 <= 0) {
                    break;
                }
                int a4 = a(kVar, i23);
                i23 = a(a2.a(kVar.h, kVar.i, g(a4, cArr), false), a4 + 2, true, cArr);
                g10 = i24;
            }
        }
        while (true) {
            c cVar4 = cVar3;
            if (cVar4 == null) {
                a2.a();
                return i5;
            }
            cVar3 = cVar4.c;
            cVar4.c = null;
            a2.a(cVar4);
        }
    }

    private void a(g gVar, k kVar, int i, int i2, String str) {
        String[] strArr;
        char[] cArr = kVar.c;
        String d = d(i, cArr);
        int g = g(i + 2);
        String g2 = g(i + 4, cArr);
        int i3 = i + 6;
        w a2 = gVar.a(d, g, g2);
        if (a2 == null) {
            return;
        }
        if (str != null) {
            a2.a(str);
        }
        if (i2 != 0) {
            int g3 = g(i2);
            int i4 = i2 + 2;
            while (true) {
                int i5 = g3 - 1;
                if (g3 <= 0) {
                    break;
                }
                a2.b(e(i4, cArr));
                i4 += 2;
                g3 = i5;
            }
        }
        int g4 = g(i3);
        int i6 = i3 + 2;
        while (true) {
            int i7 = g4 - 1;
            if (g4 <= 0) {
                break;
            }
            String d2 = d(i6, cArr);
            int g5 = g(i6 + 2);
            String g6 = g(i6 + 4, cArr);
            i6 += 6;
            a2.a(d2, g5, g6);
            g4 = i7;
        }
        int g7 = g(i6);
        int i8 = i6 + 2;
        while (true) {
            int i9 = g7 - 1;
            String[] strArr2 = null;
            if (g7 <= 0) {
                break;
            }
            String e = e(i8, cArr);
            int g8 = g(i8 + 2);
            int g9 = g(i8 + 4);
            i8 += 6;
            if (g9 != 0) {
                strArr2 = new String[g9];
                for (int i10 = 0; i10 < g9; i10++) {
                    strArr2[i10] = d(i8, cArr);
                    i8 += 2;
                }
            }
            a2.a(e, g8, strArr2);
            g7 = i9;
        }
        int g10 = g(i8);
        int i11 = i8 + 2;
        while (true) {
            int i12 = g10 - 1;
            if (g10 <= 0) {
                break;
            }
            String e2 = e(i11, cArr);
            int g11 = g(i11 + 2);
            int g12 = g(i11 + 4);
            i11 += 6;
            if (g12 != 0) {
                strArr = new String[g12];
                for (int i13 = 0; i13 < g12; i13++) {
                    strArr[i13] = d(i11, cArr);
                    i11 += 2;
                }
            } else {
                strArr = null;
            }
            a2.b(e2, g11, strArr);
            g10 = i12;
        }
        int g13 = g(i11);
        int i14 = i11 + 2;
        while (true) {
            int i15 = g13 - 1;
            if (g13 <= 0) {
                break;
            }
            a2.c(a(i14, cArr));
            i14 += 2;
            g13 = i15;
        }
        int g14 = g(i14);
        int i16 = i14 + 2;
        while (true) {
            int i17 = g14 - 1;
            if (g14 <= 0) {
                a2.a();
                return;
            }
            String a3 = a(i16, cArr);
            int g15 = g(i16 + 2);
            i16 += 4;
            String[] strArr3 = new String[g15];
            for (int i18 = 0; i18 < g15; i18++) {
                strArr3[i18] = a(i16, cArr);
                i16 += 2;
            }
            a2.a(a3, strArr3);
            g14 = i17;
        }
    }

    private void a(u uVar, k kVar, int i, boolean z) {
        int i2 = i + 1;
        int i3 = this.c[i] & UByte.MAX_VALUE;
        uVar.a(i3, z);
        char[] cArr = kVar.c;
        for (int i4 = 0; i4 < i3; i4++) {
            int g = g(i2);
            i2 += 2;
            while (true) {
                int i5 = g - 1;
                if (g > 0) {
                    i2 = a(uVar.a(i4, g(i2, cArr), z), i2 + 2, true, cArr);
                    g = i5;
                }
            }
        }
    }

    private int a(int i, boolean z, boolean z2, k kVar) {
        int i2;
        int i3;
        char[] cArr = kVar.c;
        s[] sVarArr = kVar.g;
        if (z) {
            i2 = i + 1;
            i3 = this.c[i] & UByte.MAX_VALUE;
        } else {
            kVar.m = -1;
            i2 = i;
            i3 = 255;
        }
        kVar.p = 0;
        if (i3 < 64) {
            kVar.n = 3;
            kVar.r = 0;
        } else if (i3 < 128) {
            i3 -= 64;
            i2 = a(i2, kVar.s, 0, cArr, sVarArr);
            kVar.n = 4;
            kVar.r = 1;
        } else {
            if (i3 < 247) {
                throw new IllegalArgumentException();
            }
            int g = g(i2);
            i2 += 2;
            if (i3 == 247) {
                i2 = a(i2, kVar.s, 0, cArr, sVarArr);
                kVar.n = 4;
                kVar.r = 1;
            } else {
                if (i3 >= 248 && i3 < 251) {
                    kVar.n = 2;
                    int i4 = 251 - i3;
                    kVar.p = i4;
                    kVar.o -= i4;
                } else if (i3 == 251) {
                    kVar.n = 3;
                } else if (i3 < 255) {
                    int i5 = i3 - 251;
                    int i6 = z2 ? kVar.o : 0;
                    int i7 = i5;
                    while (i7 > 0) {
                        i2 = a(i2, kVar.q, i6, cArr, sVarArr);
                        i7--;
                        i6++;
                    }
                    kVar.n = 1;
                    kVar.p = i5;
                    kVar.o += i5;
                } else {
                    int g2 = g(i2);
                    int i8 = i2 + 2;
                    kVar.n = 0;
                    kVar.p = g2;
                    kVar.o = g2;
                    for (int i9 = 0; i9 < g2; i9++) {
                        i8 = a(i8, kVar.q, i9, cArr, sVarArr);
                    }
                    int g3 = g(i8);
                    i2 = i8 + 2;
                    kVar.r = g3;
                    for (int i10 = 0; i10 < g3; i10++) {
                        i2 = a(i2, kVar.s, i10, cArr, sVarArr);
                    }
                }
                kVar.r = 0;
            }
            i3 = g;
        }
        int i11 = kVar.m + i3 + 1;
        kVar.m = i11;
        b(i11, sVarArr);
        return i2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int a(sdk.pendo.io.a.k r10, int r11) {
        /*
            r9 = this;
            int r0 = r9.d(r11)
            int r1 = r0 >>> 24
            r2 = 1
            if (r1 == 0) goto L70
            if (r1 == r2) goto L70
            r3 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            switch(r1) {
                case 16: goto L25;
                case 17: goto L25;
                case 18: goto L25;
                case 19: goto L19;
                case 20: goto L19;
                case 21: goto L19;
                case 22: goto L70;
                case 23: goto L25;
                default: goto L10;
            }
        L10:
            switch(r1) {
                case 64: goto L2a;
                case 65: goto L2a;
                case 66: goto L25;
                case 67: goto L23;
                case 68: goto L23;
                case 69: goto L23;
                case 70: goto L23;
                case 71: goto L1c;
                case 72: goto L1c;
                case 73: goto L1c;
                case 74: goto L1c;
                case 75: goto L1c;
                default: goto L13;
            }
        L13:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            r10.<init>()
            throw r10
        L19:
            r0 = r0 & r3
            int r11 = r11 + r2
            goto L75
        L1c:
            r1 = -16776961(0xffffffffff0000ff, float:-1.7014636E38)
            r0 = r0 & r1
            int r11 = r11 + 4
            goto L75
        L23:
            r0 = r0 & r3
            goto L27
        L25:
            r0 = r0 & (-256(0xffffffffffffff00, float:NaN))
        L27:
            int r11 = r11 + 3
            goto L75
        L2a:
            r0 = r0 & r3
            int r1 = r11 + 1
            int r1 = r9.g(r1)
            int r11 = r11 + 3
            sdk.pendo.io.a.s[] r3 = new sdk.pendo.io.a.s[r1]
            r10.j = r3
            sdk.pendo.io.a.s[] r3 = new sdk.pendo.io.a.s[r1]
            r10.k = r3
            int[] r3 = new int[r1]
            r10.l = r3
            r3 = 0
        L40:
            if (r3 >= r1) goto L75
            int r4 = r9.g(r11)
            int r5 = r11 + 2
            int r5 = r9.g(r5)
            int r6 = r11 + 4
            int r6 = r9.g(r6)
            int r11 = r11 + 6
            sdk.pendo.io.a.s[] r7 = r10.j
            sdk.pendo.io.a.s[] r8 = r10.g
            sdk.pendo.io.a.s r8 = r9.b(r4, r8)
            r7[r3] = r8
            sdk.pendo.io.a.s[] r7 = r10.k
            int r4 = r4 + r5
            sdk.pendo.io.a.s[] r5 = r10.g
            sdk.pendo.io.a.s r4 = r9.b(r4, r5)
            r7[r3] = r4
            int[] r4 = r10.l
            r4[r3] = r6
            int r3 = r3 + 1
            goto L40
        L70:
            r1 = -65536(0xffffffffffff0000, float:NaN)
            r0 = r0 & r1
            int r11 = r11 + 2
        L75:
            r10.h = r0
            int r0 = r9.c(r11)
            if (r0 != 0) goto L7f
            r1 = 0
            goto L86
        L7f:
            sdk.pendo.io.a.e0 r1 = new sdk.pendo.io.a.e0
            byte[] r3 = r9.c
            r1.<init>(r3, r11)
        L86:
            r10.i = r1
            int r11 = r11 + r2
            int r0 = r0 * 2
            int r11 = r11 + r0
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.a.e.a(sdk.pendo.io.a.k, int):int");
    }

    private String a(int i, int i2, char[] cArr) {
        int i3;
        int i4 = i2 + i;
        byte[] bArr = this.c;
        int i5 = 0;
        while (i < i4) {
            int i6 = i + 1;
            byte b = bArr[i];
            if ((b & ByteCompanionObject.MIN_VALUE) == 0) {
                i3 = i5 + 1;
                cArr[i5] = (char) (b & ByteCompanionObject.MAX_VALUE);
            } else if ((b & 224) == 192) {
                cArr[i5] = (char) (((b & BuiltinOptions.SequenceRNNOptions) << 6) + (bArr[i6] & 63));
                i5++;
                i = i6 + 1;
            } else {
                i3 = i5 + 1;
                int i7 = i6 + 1;
                int i8 = ((b & 15) << 12) + ((bArr[i6] & 63) << 6);
                i6 = i7 + 1;
                cArr[i5] = (char) (i8 + (bArr[i7] & 63));
            }
            i = i6;
            i5 = i3;
        }
        return new String(cArr, 0, i5);
    }

    private int a(int i, Object[] objArr, int i2, char[] cArr, s[] sVarArr) {
        int i3 = i + 1;
        switch (this.c[i] & UByte.MAX_VALUE) {
            case 0:
                objArr[i2] = y.f833a;
                return i3;
            case 1:
                objArr[i2] = y.b;
                return i3;
            case 2:
                objArr[i2] = y.c;
                return i3;
            case 3:
                objArr[i2] = y.d;
                return i3;
            case 4:
                objArr[i2] = y.e;
                return i3;
            case 5:
                objArr[i2] = y.f;
                return i3;
            case 6:
                objArr[i2] = y.g;
                return i3;
            case 7:
                objArr[i2] = a(i3, cArr);
                break;
            case 8:
                objArr[i2] = b(g(i3), sVarArr);
                break;
            default:
                throw new IllegalArgumentException();
        }
        return i3 + 2;
    }
}
