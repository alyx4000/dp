package sdk.pendo.io.y4;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import kotlin.UByte;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.bouncycastle.jcajce.spec.TLSKeyMaterialSpec;
import org.tensorflow.lite.schema.BuiltinOptions;
import sdk.pendo.io.y4.l;
import sdk.pendo.io.y4.s0;

/* loaded from: classes4.dex */
public class l3 {

    /* renamed from: a, reason: collision with root package name */
    private static byte[] f1787a = sdk.pendo.io.e5.f.a("444F574E47524400");
    private static byte[] b = sdk.pendo.io.e5.f.a("444F574E47524401");
    private static final Hashtable c = a();
    private static final Vector d = b();
    public static final byte[] e = new byte[0];
    public static final short[] f = new short[0];
    public static final int[] g = new int[0];
    public static final long[] h = new long[0];
    public static final String[] i = new String[0];

    public static sdk.pendo.io.z4.b0 a(a1 a1Var, sdk.pendo.io.z4.b0 b0Var, String str, byte[] bArr, int i2) {
        return b0Var.a(a1Var.t(), str, bArr, i2);
    }

    static boolean a(short s, int i2) {
        if (i2 == 0) {
            return s != 0;
        }
        if (i2 != 3) {
            if (i2 != 5) {
                if (i2 == 17) {
                    return s == 3 || s == 7 || s == 8;
                }
                if (i2 != 19) {
                    if (i2 != 22) {
                        if (i2 != 23) {
                            return false;
                        }
                    }
                }
            }
            if (s != 1 && s != 4 && s != 5 && s != 6) {
                switch (s) {
                }
                return false;
            }
            return true;
        }
        return 2 == s;
    }

    public static void b(int i2) {
        if (!p(i2)) {
            throw new h2((short) 80);
        }
    }

    public static boolean b(long j) {
        return (16777215 & j) == j;
    }

    public static short c(short s) {
        short s2 = 1;
        if (s != 1) {
            s2 = 2;
            if (s != 2) {
                return s != 3 ? (short) -1 : (short) 64;
            }
        }
        return s2;
    }

    public static void c(int i2) {
        if (!q(i2)) {
            throw new h2((short) 80);
        }
    }

    public static boolean c(long j) {
        return (BodyPartID.bodyIdMax & j) == j;
    }

    public static short[] d(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("'buf' cannot be null");
        }
        int i2 = 0;
        int d2 = d(bArr, 0);
        if (bArr.length != d2 + 1) {
            throw new h2((short) 50);
        }
        short[] sArr = new short[d2];
        while (i2 < d2) {
            int i3 = i2 + 1;
            sArr[i2] = d(bArr, i3);
            i2 = i3;
        }
        return sArr;
    }

    public static boolean e(short s) {
        return (s & 255) == s;
    }

    public static byte[] e(byte[] bArr) {
        a(bArr.length);
        byte[] bArr2 = new byte[bArr.length + 2];
        a(bArr.length, bArr2, 0);
        System.arraycopy(bArr, 0, bArr2, 2, bArr.length);
        return bArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0088 A[FALL_THROUGH, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x005b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0071 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0075 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0079 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int f(int r8) {
        /*
            r0 = 2
            r1 = 0
            if (r8 == r0) goto L88
            r0 = 10
            if (r8 == r0) goto L86
            r2 = 13
            if (r8 == r2) goto L86
            r3 = 16
            if (r8 == r3) goto L86
            r4 = 19
            if (r8 == r4) goto L86
            r5 = 22
            if (r8 == r5) goto L86
            r6 = 27
            if (r8 == r6) goto L86
            r7 = 49153(0xc001, float:6.8878E-41)
            if (r8 == r7) goto L88
            r7 = 53253(0xd005, float:7.4623E-41)
            if (r8 == r7) goto L83
            switch(r8) {
                case 147: goto L86;
                case 148: goto L80;
                case 149: goto L7d;
                case 150: goto L7a;
                case 151: goto L7a;
                case 152: goto L7a;
                case 153: goto L7a;
                case 154: goto L7a;
                case 155: goto L7a;
                case 156: goto L79;
                case 157: goto L76;
                case 158: goto L79;
                case 159: goto L76;
                case 160: goto L79;
                case 161: goto L76;
                case 162: goto L79;
                case 163: goto L76;
                case 164: goto L79;
                case 165: goto L76;
                case 166: goto L79;
                case 167: goto L76;
                case 168: goto L79;
                case 169: goto L76;
                case 170: goto L79;
                case 171: goto L76;
                case 172: goto L79;
                case 173: goto L76;
                case 174: goto L80;
                case 175: goto L7d;
                case 176: goto L75;
                case 177: goto L75;
                case 178: goto L80;
                case 179: goto L7d;
                case 180: goto L75;
                case 181: goto L75;
                case 182: goto L80;
                case 183: goto L7d;
                case 184: goto L75;
                case 185: goto L75;
                case 186: goto L72;
                case 187: goto L72;
                case 188: goto L72;
                case 189: goto L72;
                case 190: goto L72;
                case 191: goto L72;
                case 192: goto L71;
                case 193: goto L71;
                case 194: goto L71;
                case 195: goto L71;
                case 196: goto L71;
                case 197: goto L71;
                case 198: goto L70;
                case 199: goto L6d;
                default: goto L29;
            }
        L29:
            switch(r8) {
                case 49170: goto L86;
                case 49171: goto L80;
                case 49172: goto L7d;
                case 49173: goto L88;
                default: goto L2c;
            }
        L2c:
            switch(r8) {
                case 49175: goto L86;
                case 49176: goto L80;
                case 49177: goto L7d;
                case 49178: goto L86;
                case 49179: goto L86;
                case 49180: goto L86;
                case 49181: goto L80;
                case 49182: goto L80;
                case 49183: goto L80;
                case 49184: goto L7d;
                case 49185: goto L7d;
                case 49186: goto L7d;
                case 49187: goto L80;
                case 49188: goto L7d;
                case 49189: goto L80;
                case 49190: goto L7d;
                case 49191: goto L80;
                case 49192: goto L7d;
                case 49193: goto L80;
                case 49194: goto L7d;
                case 49195: goto L79;
                case 49196: goto L76;
                case 49197: goto L79;
                case 49198: goto L76;
                case 49199: goto L79;
                case 49200: goto L76;
                case 49201: goto L79;
                case 49202: goto L76;
                default: goto L2f;
            }
        L2f:
            switch(r8) {
                case 49204: goto L86;
                case 49205: goto L80;
                case 49206: goto L7d;
                case 49207: goto L80;
                case 49208: goto L7d;
                case 49209: goto L88;
                case 49210: goto L75;
                case 49211: goto L75;
                case 49212: goto L6c;
                case 49213: goto L69;
                case 49214: goto L6c;
                case 49215: goto L69;
                case 49216: goto L6c;
                case 49217: goto L69;
                case 49218: goto L6c;
                case 49219: goto L69;
                case 49220: goto L6c;
                case 49221: goto L69;
                case 49222: goto L6c;
                case 49223: goto L69;
                case 49224: goto L6c;
                case 49225: goto L69;
                case 49226: goto L6c;
                case 49227: goto L69;
                case 49228: goto L6c;
                case 49229: goto L69;
                case 49230: goto L6c;
                case 49231: goto L69;
                case 49232: goto L66;
                case 49233: goto L63;
                case 49234: goto L66;
                case 49235: goto L63;
                case 49236: goto L66;
                case 49237: goto L63;
                case 49238: goto L66;
                case 49239: goto L63;
                case 49240: goto L66;
                case 49241: goto L63;
                case 49242: goto L66;
                case 49243: goto L63;
                case 49244: goto L66;
                case 49245: goto L63;
                case 49246: goto L66;
                case 49247: goto L63;
                case 49248: goto L66;
                case 49249: goto L63;
                case 49250: goto L66;
                case 49251: goto L63;
                case 49252: goto L6c;
                case 49253: goto L69;
                case 49254: goto L6c;
                case 49255: goto L69;
                case 49256: goto L6c;
                case 49257: goto L69;
                case 49258: goto L66;
                case 49259: goto L63;
                case 49260: goto L66;
                case 49261: goto L63;
                case 49262: goto L66;
                case 49263: goto L63;
                case 49264: goto L6c;
                case 49265: goto L69;
                case 49266: goto L72;
                case 49267: goto L71;
                case 49268: goto L72;
                case 49269: goto L71;
                case 49270: goto L72;
                case 49271: goto L71;
                case 49272: goto L72;
                case 49273: goto L71;
                case 49274: goto L62;
                case 49275: goto L5f;
                case 49276: goto L62;
                case 49277: goto L5f;
                case 49278: goto L62;
                case 49279: goto L5f;
                case 49280: goto L62;
                case 49281: goto L5f;
                case 49282: goto L62;
                case 49283: goto L5f;
                case 49284: goto L62;
                case 49285: goto L5f;
                case 49286: goto L62;
                case 49287: goto L5f;
                case 49288: goto L62;
                case 49289: goto L5f;
                case 49290: goto L62;
                case 49291: goto L5f;
                case 49292: goto L62;
                case 49293: goto L5f;
                case 49294: goto L62;
                case 49295: goto L5f;
                case 49296: goto L62;
                case 49297: goto L5f;
                case 49298: goto L62;
                case 49299: goto L5f;
                case 49300: goto L72;
                case 49301: goto L71;
                case 49302: goto L72;
                case 49303: goto L71;
                case 49304: goto L72;
                case 49305: goto L71;
                case 49306: goto L72;
                case 49307: goto L71;
                case 49308: goto L83;
                case 49309: goto L5c;
                case 49310: goto L83;
                case 49311: goto L5c;
                case 49312: goto L5b;
                case 49313: goto L58;
                case 49314: goto L5b;
                case 49315: goto L58;
                case 49316: goto L83;
                case 49317: goto L5c;
                case 49318: goto L83;
                case 49319: goto L5c;
                case 49320: goto L5b;
                case 49321: goto L58;
                case 49322: goto L5b;
                case 49323: goto L58;
                case 49324: goto L83;
                case 49325: goto L5c;
                case 49326: goto L5b;
                case 49327: goto L58;
                default: goto L32;
            }
        L32:
            switch(r8) {
                case 52392: goto L55;
                case 52393: goto L55;
                case 52394: goto L55;
                case 52395: goto L55;
                case 52396: goto L55;
                case 52397: goto L55;
                case 52398: goto L55;
                default: goto L35;
            }
        L35:
            switch(r8) {
                case 53249: goto L79;
                case 53250: goto L76;
                case 53251: goto L5b;
                default: goto L38;
            }
        L38:
            switch(r8) {
                case 44: goto L88;
                case 45: goto L88;
                case 46: goto L88;
                case 47: goto L80;
                case 48: goto L80;
                case 49: goto L80;
                case 50: goto L80;
                case 51: goto L80;
                case 52: goto L80;
                case 53: goto L7d;
                case 54: goto L7d;
                case 55: goto L7d;
                case 56: goto L7d;
                case 57: goto L7d;
                case 58: goto L7d;
                case 59: goto L75;
                case 60: goto L80;
                case 61: goto L7d;
                case 62: goto L80;
                case 63: goto L80;
                case 64: goto L80;
                case 65: goto L72;
                case 66: goto L72;
                case 67: goto L72;
                case 68: goto L72;
                case 69: goto L72;
                case 70: goto L72;
                default: goto L3b;
            }
        L3b:
            switch(r8) {
                case 103: goto L80;
                case 104: goto L7d;
                case 105: goto L7d;
                case 106: goto L7d;
                case 107: goto L7d;
                case 108: goto L80;
                case 109: goto L7d;
                default: goto L3e;
            }
        L3e:
            switch(r8) {
                case 132: goto L71;
                case 133: goto L71;
                case 134: goto L71;
                case 135: goto L71;
                case 136: goto L71;
                case 137: goto L71;
                default: goto L41;
            }
        L41:
            switch(r8) {
                case 139: goto L86;
                case 140: goto L80;
                case 141: goto L7d;
                default: goto L44;
            }
        L44:
            switch(r8) {
                case 143: goto L86;
                case 144: goto L80;
                case 145: goto L7d;
                default: goto L47;
            }
        L47:
            switch(r8) {
                case 4865: goto L79;
                case 4866: goto L76;
                case 4867: goto L55;
                case 4868: goto L83;
                case 4869: goto L5b;
                default: goto L4a;
            }
        L4a:
            switch(r8) {
                case 49155: goto L86;
                case 49156: goto L80;
                case 49157: goto L7d;
                case 49158: goto L88;
                default: goto L4d;
            }
        L4d:
            switch(r8) {
                case 49160: goto L86;
                case 49161: goto L80;
                case 49162: goto L7d;
                case 49163: goto L88;
                default: goto L50;
            }
        L50:
            switch(r8) {
                case 49165: goto L86;
                case 49166: goto L80;
                case 49167: goto L7d;
                case 49168: goto L88;
                default: goto L53;
            }
        L53:
            r8 = -1
            return r8
        L55:
            r8 = 21
            return r8
        L58:
            r8 = 18
            return r8
        L5b:
            return r3
        L5c:
            r8 = 17
            return r8
        L5f:
            r8 = 20
            return r8
        L62:
            return r4
        L63:
            r8 = 25
            return r8
        L66:
            r8 = 24
            return r8
        L69:
            r8 = 23
            return r8
        L6c:
            return r5
        L6d:
            r8 = 26
            return r8
        L70:
            return r6
        L71:
            return r2
        L72:
            r8 = 12
            return r8
        L75:
            return r1
        L76:
            r8 = 11
            return r8
        L79:
            return r0
        L7a:
            r8 = 14
            return r8
        L7d:
            r8 = 9
            return r8
        L80:
            r8 = 8
            return r8
        L83:
            r8 = 15
            return r8
        L86:
            r8 = 7
            return r8
        L88:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.y4.l3.f(int):int");
    }

    public static byte[] f(byte[] bArr) {
        c(bArr.length);
        return sdk.pendo.io.d5.a.b(bArr, (byte) bArr.length);
    }

    public static int g(int i2) {
        switch (i2) {
            case 0:
            case 1:
            case 2:
                return 0;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 12:
            case 13:
            case 14:
            case 22:
            case 23:
            case 28:
                return 1;
            case 10:
            case 11:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 24:
            case 25:
            case 26:
            case 27:
                return 2;
            default:
                return -1;
        }
    }

    public static short h(int i2) {
        if (i2 == 0 || i2 == 1) {
            throw new IllegalArgumentException("legacy PRF not a valid algorithm");
        }
        if (i2 != 2) {
            if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        throw new IllegalArgumentException("unknown PRFAlgorithm: " + t0.b(i2));
                    }
                }
            }
            return (short) 5;
        }
        return (short) 4;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0064 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x006a A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int i(int r5) {
        /*
            r0 = 2
            if (r5 == r0) goto L7e
            r0 = 10
            if (r5 == r0) goto L7e
            r0 = 13
            if (r5 == r0) goto L7c
            r1 = 16
            if (r5 == r1) goto L79
            r2 = 19
            if (r5 == r2) goto L77
            r3 = 22
            if (r5 == r3) goto L75
            r4 = 27
            if (r5 == r4) goto L72
            r4 = 49153(0xc001, float:6.8878E-41)
            if (r5 == r4) goto L71
            r4 = 53253(0xd005, float:7.4623E-41)
            if (r5 == r4) goto L6e
            switch(r5) {
                case 147: goto L6b;
                case 148: goto L6b;
                case 149: goto L6b;
                case 150: goto L7e;
                case 151: goto L7c;
                case 152: goto L79;
                case 153: goto L77;
                case 154: goto L75;
                case 155: goto L72;
                case 156: goto L7e;
                case 157: goto L7e;
                case 158: goto L75;
                case 159: goto L75;
                case 160: goto L79;
                case 161: goto L79;
                case 162: goto L77;
                case 163: goto L77;
                case 164: goto L7c;
                case 165: goto L7c;
                case 166: goto L72;
                case 167: goto L72;
                case 168: goto L6a;
                case 169: goto L6a;
                case 170: goto L67;
                case 171: goto L67;
                case 172: goto L6b;
                case 173: goto L6b;
                case 174: goto L6a;
                case 175: goto L6a;
                case 176: goto L6a;
                case 177: goto L6a;
                case 178: goto L67;
                case 179: goto L67;
                case 180: goto L67;
                case 181: goto L67;
                case 182: goto L6b;
                case 183: goto L6b;
                case 184: goto L6b;
                case 185: goto L6b;
                case 186: goto L7e;
                case 187: goto L7c;
                case 188: goto L79;
                case 189: goto L77;
                case 190: goto L75;
                case 191: goto L72;
                case 192: goto L7e;
                case 193: goto L7c;
                case 194: goto L79;
                case 195: goto L77;
                case 196: goto L75;
                case 197: goto L72;
                case 198: goto L65;
                case 199: goto L65;
                default: goto L28;
            }
        L28:
            switch(r5) {
                case 49170: goto L64;
                case 49171: goto L64;
                case 49172: goto L64;
                case 49173: goto L61;
                default: goto L2b;
            }
        L2b:
            switch(r5) {
                case 49175: goto L61;
                case 49176: goto L61;
                case 49177: goto L61;
                case 49178: goto L5e;
                case 49179: goto L5b;
                case 49180: goto L5a;
                case 49181: goto L5e;
                case 49182: goto L5b;
                case 49183: goto L5a;
                case 49184: goto L5e;
                case 49185: goto L5b;
                case 49186: goto L5a;
                case 49187: goto L57;
                case 49188: goto L57;
                case 49189: goto L71;
                case 49190: goto L71;
                case 49191: goto L64;
                case 49192: goto L64;
                case 49193: goto L54;
                case 49194: goto L54;
                case 49195: goto L57;
                case 49196: goto L57;
                case 49197: goto L71;
                case 49198: goto L71;
                case 49199: goto L64;
                case 49200: goto L64;
                case 49201: goto L54;
                case 49202: goto L54;
                default: goto L2e;
            }
        L2e:
            switch(r5) {
                case 49204: goto L6e;
                case 49205: goto L6e;
                case 49206: goto L6e;
                case 49207: goto L6e;
                case 49208: goto L6e;
                case 49209: goto L6e;
                case 49210: goto L6e;
                case 49211: goto L6e;
                case 49212: goto L7e;
                case 49213: goto L7e;
                case 49214: goto L7c;
                case 49215: goto L7c;
                case 49216: goto L79;
                case 49217: goto L79;
                case 49218: goto L77;
                case 49219: goto L77;
                case 49220: goto L75;
                case 49221: goto L75;
                case 49222: goto L72;
                case 49223: goto L72;
                case 49224: goto L57;
                case 49225: goto L57;
                case 49226: goto L71;
                case 49227: goto L71;
                case 49228: goto L64;
                case 49229: goto L64;
                case 49230: goto L54;
                case 49231: goto L54;
                case 49232: goto L7e;
                case 49233: goto L7e;
                case 49234: goto L75;
                case 49235: goto L75;
                case 49236: goto L79;
                case 49237: goto L79;
                case 49238: goto L77;
                case 49239: goto L77;
                case 49240: goto L7c;
                case 49241: goto L7c;
                case 49242: goto L72;
                case 49243: goto L72;
                case 49244: goto L57;
                case 49245: goto L57;
                case 49246: goto L71;
                case 49247: goto L71;
                case 49248: goto L64;
                case 49249: goto L64;
                case 49250: goto L54;
                case 49251: goto L54;
                case 49252: goto L6a;
                case 49253: goto L6a;
                case 49254: goto L67;
                case 49255: goto L67;
                case 49256: goto L6b;
                case 49257: goto L6b;
                case 49258: goto L6a;
                case 49259: goto L6a;
                case 49260: goto L67;
                case 49261: goto L67;
                case 49262: goto L6b;
                case 49263: goto L6b;
                case 49264: goto L6e;
                case 49265: goto L6e;
                case 49266: goto L57;
                case 49267: goto L57;
                case 49268: goto L71;
                case 49269: goto L71;
                case 49270: goto L64;
                case 49271: goto L64;
                case 49272: goto L54;
                case 49273: goto L54;
                case 49274: goto L7e;
                case 49275: goto L7e;
                case 49276: goto L75;
                case 49277: goto L75;
                case 49278: goto L79;
                case 49279: goto L79;
                case 49280: goto L77;
                case 49281: goto L77;
                case 49282: goto L7c;
                case 49283: goto L7c;
                case 49284: goto L72;
                case 49285: goto L72;
                case 49286: goto L57;
                case 49287: goto L57;
                case 49288: goto L71;
                case 49289: goto L71;
                case 49290: goto L64;
                case 49291: goto L64;
                case 49292: goto L54;
                case 49293: goto L54;
                case 49294: goto L6a;
                case 49295: goto L6a;
                case 49296: goto L67;
                case 49297: goto L67;
                case 49298: goto L6b;
                case 49299: goto L6b;
                case 49300: goto L6a;
                case 49301: goto L6a;
                case 49302: goto L67;
                case 49303: goto L67;
                case 49304: goto L6b;
                case 49305: goto L6b;
                case 49306: goto L6e;
                case 49307: goto L6e;
                case 49308: goto L7e;
                case 49309: goto L7e;
                case 49310: goto L75;
                case 49311: goto L75;
                case 49312: goto L7e;
                case 49313: goto L7e;
                case 49314: goto L75;
                case 49315: goto L75;
                case 49316: goto L6a;
                case 49317: goto L6a;
                case 49318: goto L67;
                case 49319: goto L67;
                case 49320: goto L6a;
                case 49321: goto L6a;
                case 49322: goto L67;
                case 49323: goto L67;
                case 49324: goto L57;
                case 49325: goto L57;
                case 49326: goto L57;
                case 49327: goto L57;
                default: goto L31;
            }
        L31:
            switch(r5) {
                case 52392: goto L64;
                case 52393: goto L57;
                case 52394: goto L75;
                case 52395: goto L6a;
                case 52396: goto L6e;
                case 52397: goto L67;
                case 52398: goto L6b;
                default: goto L34;
            }
        L34:
            switch(r5) {
                case 53249: goto L6e;
                case 53250: goto L6e;
                case 53251: goto L6e;
                default: goto L37;
            }
        L37:
            switch(r5) {
                case 44: goto L6a;
                case 45: goto L67;
                case 46: goto L6b;
                case 47: goto L7e;
                case 48: goto L7c;
                case 49: goto L79;
                case 50: goto L77;
                case 51: goto L75;
                case 52: goto L72;
                case 53: goto L7e;
                case 54: goto L7c;
                case 55: goto L79;
                case 56: goto L77;
                case 57: goto L75;
                case 58: goto L72;
                case 59: goto L7e;
                case 60: goto L7e;
                case 61: goto L7e;
                case 62: goto L7c;
                case 63: goto L79;
                case 64: goto L77;
                case 65: goto L7e;
                case 66: goto L7c;
                case 67: goto L79;
                case 68: goto L77;
                case 69: goto L75;
                case 70: goto L72;
                default: goto L3a;
            }
        L3a:
            switch(r5) {
                case 103: goto L75;
                case 104: goto L7c;
                case 105: goto L79;
                case 106: goto L77;
                case 107: goto L75;
                case 108: goto L72;
                case 109: goto L72;
                default: goto L3d;
            }
        L3d:
            switch(r5) {
                case 132: goto L7e;
                case 133: goto L7c;
                case 134: goto L79;
                case 135: goto L77;
                case 136: goto L75;
                case 137: goto L72;
                default: goto L40;
            }
        L40:
            switch(r5) {
                case 139: goto L6a;
                case 140: goto L6a;
                case 141: goto L6a;
                default: goto L43;
            }
        L43:
            switch(r5) {
                case 143: goto L67;
                case 144: goto L67;
                case 145: goto L67;
                default: goto L46;
            }
        L46:
            switch(r5) {
                case 4865: goto L65;
                case 4866: goto L65;
                case 4867: goto L65;
                case 4868: goto L65;
                case 4869: goto L65;
                default: goto L49;
            }
        L49:
            switch(r5) {
                case 49155: goto L71;
                case 49156: goto L71;
                case 49157: goto L71;
                case 49158: goto L57;
                default: goto L4c;
            }
        L4c:
            switch(r5) {
                case 49160: goto L57;
                case 49161: goto L57;
                case 49162: goto L57;
                case 49163: goto L54;
                default: goto L4f;
            }
        L4f:
            switch(r5) {
                case 49165: goto L54;
                case 49166: goto L54;
                case 49167: goto L54;
                case 49168: goto L64;
                default: goto L52;
            }
        L52:
            r5 = -1
            return r5
        L54:
            r5 = 18
            return r5
        L57:
            r5 = 17
            return r5
        L5a:
            return r3
        L5b:
            r5 = 23
            return r5
        L5e:
            r5 = 21
            return r5
        L61:
            r5 = 20
            return r5
        L64:
            return r2
        L65:
            r5 = 0
            return r5
        L67:
            r5 = 14
            return r5
        L6a:
            return r0
        L6b:
            r5 = 15
            return r5
        L6e:
            r5 = 24
            return r5
        L71:
            return r1
        L72:
            r5 = 11
            return r5
        L75:
            r5 = 5
            return r5
        L77:
            r5 = 3
            return r5
        L79:
            r5 = 9
            return r5
        L7c:
            r5 = 7
            return r5
        L7e:
            r5 = 1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.y4.l3.i(int):int");
    }

    public static short j(int i2) {
        if (i2 == 3) {
            return (short) 2;
        }
        if (i2 == 5) {
            return (short) 1;
        }
        if (i2 == 17) {
            return (short) 3;
        }
        if (i2 == 19) {
            return (short) 1;
        }
        if (i2 != 22) {
            return i2 != 23 ? (short) -1 : (short) 1;
        }
        return (short) 2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:51:0x005a A[FALL_THROUGH, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int k(int r2) {
        /*
            r0 = 2
            if (r2 == r0) goto L5a
            r1 = 10
            if (r2 == r1) goto L5a
            r1 = 13
            if (r2 == r1) goto L5a
            r1 = 16
            if (r2 == r1) goto L5a
            r1 = 19
            if (r2 == r1) goto L5a
            r1 = 22
            if (r2 == r1) goto L5a
            r1 = 27
            if (r2 == r1) goto L5a
            r1 = 49153(0xc001, float:6.8878E-41)
            if (r2 == r1) goto L5a
            r1 = 53253(0xd005, float:7.4623E-41)
            if (r2 == r1) goto L58
            switch(r2) {
                case 147: goto L5a;
                case 148: goto L5a;
                case 149: goto L5a;
                case 150: goto L5a;
                case 151: goto L5a;
                case 152: goto L5a;
                case 153: goto L5a;
                case 154: goto L5a;
                case 155: goto L5a;
                case 156: goto L58;
                case 157: goto L58;
                case 158: goto L58;
                case 159: goto L58;
                case 160: goto L58;
                case 161: goto L58;
                case 162: goto L58;
                case 163: goto L58;
                case 164: goto L58;
                case 165: goto L58;
                case 166: goto L58;
                case 167: goto L58;
                case 168: goto L58;
                case 169: goto L58;
                case 170: goto L58;
                case 171: goto L58;
                case 172: goto L58;
                case 173: goto L58;
                case 174: goto L56;
                case 175: goto L54;
                case 176: goto L56;
                case 177: goto L54;
                case 178: goto L56;
                case 179: goto L54;
                case 180: goto L56;
                case 181: goto L54;
                case 182: goto L56;
                case 183: goto L54;
                case 184: goto L56;
                case 185: goto L54;
                case 186: goto L56;
                case 187: goto L56;
                case 188: goto L56;
                case 189: goto L56;
                case 190: goto L56;
                case 191: goto L56;
                case 192: goto L56;
                case 193: goto L56;
                case 194: goto L56;
                case 195: goto L56;
                case 196: goto L56;
                case 197: goto L56;
                case 198: goto L58;
                case 199: goto L58;
                default: goto L28;
            }
        L28:
            switch(r2) {
                case 49170: goto L5a;
                case 49171: goto L5a;
                case 49172: goto L5a;
                case 49173: goto L5a;
                default: goto L2b;
            }
        L2b:
            switch(r2) {
                case 49175: goto L5a;
                case 49176: goto L5a;
                case 49177: goto L5a;
                case 49178: goto L5a;
                case 49179: goto L5a;
                case 49180: goto L5a;
                case 49181: goto L5a;
                case 49182: goto L5a;
                case 49183: goto L5a;
                case 49184: goto L5a;
                case 49185: goto L5a;
                case 49186: goto L5a;
                case 49187: goto L56;
                case 49188: goto L54;
                case 49189: goto L56;
                case 49190: goto L54;
                case 49191: goto L56;
                case 49192: goto L54;
                case 49193: goto L56;
                case 49194: goto L54;
                case 49195: goto L58;
                case 49196: goto L58;
                case 49197: goto L58;
                case 49198: goto L58;
                case 49199: goto L58;
                case 49200: goto L58;
                case 49201: goto L58;
                case 49202: goto L58;
                default: goto L2e;
            }
        L2e:
            switch(r2) {
                case 49204: goto L5a;
                case 49205: goto L5a;
                case 49206: goto L5a;
                case 49207: goto L56;
                case 49208: goto L54;
                case 49209: goto L5a;
                case 49210: goto L56;
                case 49211: goto L54;
                case 49212: goto L56;
                case 49213: goto L54;
                case 49214: goto L56;
                case 49215: goto L54;
                case 49216: goto L56;
                case 49217: goto L54;
                case 49218: goto L56;
                case 49219: goto L54;
                case 49220: goto L56;
                case 49221: goto L54;
                case 49222: goto L56;
                case 49223: goto L54;
                case 49224: goto L56;
                case 49225: goto L54;
                case 49226: goto L56;
                case 49227: goto L54;
                case 49228: goto L56;
                case 49229: goto L54;
                case 49230: goto L56;
                case 49231: goto L54;
                case 49232: goto L58;
                case 49233: goto L58;
                case 49234: goto L58;
                case 49235: goto L58;
                case 49236: goto L58;
                case 49237: goto L58;
                case 49238: goto L58;
                case 49239: goto L58;
                case 49240: goto L58;
                case 49241: goto L58;
                case 49242: goto L58;
                case 49243: goto L58;
                case 49244: goto L58;
                case 49245: goto L58;
                case 49246: goto L58;
                case 49247: goto L58;
                case 49248: goto L58;
                case 49249: goto L58;
                case 49250: goto L58;
                case 49251: goto L58;
                case 49252: goto L56;
                case 49253: goto L54;
                case 49254: goto L56;
                case 49255: goto L54;
                case 49256: goto L56;
                case 49257: goto L54;
                case 49258: goto L58;
                case 49259: goto L58;
                case 49260: goto L58;
                case 49261: goto L58;
                case 49262: goto L58;
                case 49263: goto L58;
                case 49264: goto L56;
                case 49265: goto L54;
                case 49266: goto L56;
                case 49267: goto L54;
                case 49268: goto L56;
                case 49269: goto L54;
                case 49270: goto L56;
                case 49271: goto L54;
                case 49272: goto L56;
                case 49273: goto L54;
                case 49274: goto L58;
                case 49275: goto L58;
                case 49276: goto L58;
                case 49277: goto L58;
                case 49278: goto L58;
                case 49279: goto L58;
                case 49280: goto L58;
                case 49281: goto L58;
                case 49282: goto L58;
                case 49283: goto L58;
                case 49284: goto L58;
                case 49285: goto L58;
                case 49286: goto L58;
                case 49287: goto L58;
                case 49288: goto L58;
                case 49289: goto L58;
                case 49290: goto L58;
                case 49291: goto L58;
                case 49292: goto L58;
                case 49293: goto L58;
                case 49294: goto L58;
                case 49295: goto L58;
                case 49296: goto L58;
                case 49297: goto L58;
                case 49298: goto L58;
                case 49299: goto L58;
                case 49300: goto L56;
                case 49301: goto L54;
                case 49302: goto L56;
                case 49303: goto L54;
                case 49304: goto L56;
                case 49305: goto L54;
                case 49306: goto L56;
                case 49307: goto L54;
                case 49308: goto L58;
                case 49309: goto L58;
                case 49310: goto L58;
                case 49311: goto L58;
                case 49312: goto L58;
                case 49313: goto L58;
                case 49314: goto L58;
                case 49315: goto L58;
                case 49316: goto L58;
                case 49317: goto L58;
                case 49318: goto L58;
                case 49319: goto L58;
                case 49320: goto L58;
                case 49321: goto L58;
                case 49322: goto L58;
                case 49323: goto L58;
                case 49324: goto L58;
                case 49325: goto L58;
                case 49326: goto L58;
                case 49327: goto L58;
                default: goto L31;
            }
        L31:
            switch(r2) {
                case 52392: goto L58;
                case 52393: goto L58;
                case 52394: goto L58;
                case 52395: goto L58;
                case 52396: goto L58;
                case 52397: goto L58;
                case 52398: goto L58;
                default: goto L34;
            }
        L34:
            switch(r2) {
                case 53249: goto L58;
                case 53250: goto L58;
                case 53251: goto L58;
                default: goto L37;
            }
        L37:
            switch(r2) {
                case 44: goto L5a;
                case 45: goto L5a;
                case 46: goto L5a;
                case 47: goto L5a;
                case 48: goto L5a;
                case 49: goto L5a;
                case 50: goto L5a;
                case 51: goto L5a;
                case 52: goto L5a;
                case 53: goto L5a;
                case 54: goto L5a;
                case 55: goto L5a;
                case 56: goto L5a;
                case 57: goto L5a;
                case 58: goto L5a;
                case 59: goto L56;
                case 60: goto L56;
                case 61: goto L56;
                case 62: goto L56;
                case 63: goto L56;
                case 64: goto L56;
                case 65: goto L5a;
                case 66: goto L5a;
                case 67: goto L5a;
                case 68: goto L5a;
                case 69: goto L5a;
                case 70: goto L5a;
                default: goto L3a;
            }
        L3a:
            switch(r2) {
                case 103: goto L56;
                case 104: goto L56;
                case 105: goto L56;
                case 106: goto L56;
                case 107: goto L56;
                case 108: goto L56;
                case 109: goto L56;
                default: goto L3d;
            }
        L3d:
            switch(r2) {
                case 132: goto L5a;
                case 133: goto L5a;
                case 134: goto L5a;
                case 135: goto L5a;
                case 136: goto L5a;
                case 137: goto L5a;
                default: goto L40;
            }
        L40:
            switch(r2) {
                case 139: goto L5a;
                case 140: goto L5a;
                case 141: goto L5a;
                default: goto L43;
            }
        L43:
            switch(r2) {
                case 143: goto L5a;
                case 144: goto L5a;
                case 145: goto L5a;
                default: goto L46;
            }
        L46:
            switch(r2) {
                case 4865: goto L58;
                case 4866: goto L58;
                case 4867: goto L58;
                case 4868: goto L58;
                case 4869: goto L58;
                default: goto L49;
            }
        L49:
            switch(r2) {
                case 49155: goto L5a;
                case 49156: goto L5a;
                case 49157: goto L5a;
                case 49158: goto L5a;
                default: goto L4c;
            }
        L4c:
            switch(r2) {
                case 49160: goto L5a;
                case 49161: goto L5a;
                case 49162: goto L5a;
                case 49163: goto L5a;
                default: goto L4f;
            }
        L4f:
            switch(r2) {
                case 49165: goto L5a;
                case 49166: goto L5a;
                case 49167: goto L5a;
                case 49168: goto L5a;
                default: goto L52;
            }
        L52:
            r2 = -1
            return r2
        L54:
            r2 = 4
            return r2
        L56:
            r2 = 3
            return r2
        L58:
            r2 = 0
            return r2
        L5a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.y4.l3.k(int):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static sdk.pendo.io.y4.v0 l(int r1) {
        /*
            switch(r1) {
                case 59: goto L2a;
                case 60: goto L2a;
                case 61: goto L2a;
                case 62: goto L2a;
                case 63: goto L2a;
                case 64: goto L2a;
                default: goto L3;
            }
        L3:
            switch(r1) {
                case 103: goto L2a;
                case 104: goto L2a;
                case 105: goto L2a;
                case 106: goto L2a;
                case 107: goto L2a;
                case 108: goto L2a;
                case 109: goto L2a;
                default: goto L6;
            }
        L6:
            switch(r1) {
                case 156: goto L2a;
                case 157: goto L2a;
                case 158: goto L2a;
                case 159: goto L2a;
                case 160: goto L2a;
                case 161: goto L2a;
                case 162: goto L2a;
                case 163: goto L2a;
                case 164: goto L2a;
                case 165: goto L2a;
                case 166: goto L2a;
                case 167: goto L2a;
                case 168: goto L2a;
                case 169: goto L2a;
                case 170: goto L2a;
                case 171: goto L2a;
                case 172: goto L2a;
                case 173: goto L2a;
                default: goto L9;
            }
        L9:
            switch(r1) {
                case 186: goto L2a;
                case 187: goto L2a;
                case 188: goto L2a;
                case 189: goto L2a;
                case 190: goto L2a;
                case 191: goto L2a;
                case 192: goto L2a;
                case 193: goto L2a;
                case 194: goto L2a;
                case 195: goto L2a;
                case 196: goto L2a;
                case 197: goto L2a;
                case 198: goto L13;
                case 199: goto L13;
                default: goto Lc;
            }
        Lc:
            switch(r1) {
                case 4865: goto L13;
                case 4866: goto L13;
                case 4867: goto L13;
                case 4868: goto L13;
                case 4869: goto L13;
                default: goto Lf;
            }
        Lf:
            switch(r1) {
                case 49187: goto L2a;
                case 49188: goto L2a;
                case 49189: goto L2a;
                case 49190: goto L2a;
                case 49191: goto L2a;
                case 49192: goto L2a;
                case 49193: goto L2a;
                case 49194: goto L2a;
                case 49195: goto L2a;
                case 49196: goto L2a;
                case 49197: goto L2a;
                case 49198: goto L2a;
                case 49199: goto L2a;
                case 49200: goto L2a;
                case 49201: goto L2a;
                case 49202: goto L2a;
                default: goto L12;
            }
        L12:
            goto L16
        L13:
            sdk.pendo.io.y4.v0 r1 = sdk.pendo.io.y4.v0.g
            return r1
        L16:
            r0 = 53253(0xd005, float:7.4623E-41)
            if (r1 == r0) goto L2a
            switch(r1) {
                case 49212: goto L2a;
                case 49213: goto L2a;
                case 49214: goto L2a;
                case 49215: goto L2a;
                case 49216: goto L2a;
                case 49217: goto L2a;
                case 49218: goto L2a;
                case 49219: goto L2a;
                case 49220: goto L2a;
                case 49221: goto L2a;
                case 49222: goto L2a;
                case 49223: goto L2a;
                case 49224: goto L2a;
                case 49225: goto L2a;
                case 49226: goto L2a;
                case 49227: goto L2a;
                case 49228: goto L2a;
                case 49229: goto L2a;
                case 49230: goto L2a;
                case 49231: goto L2a;
                case 49232: goto L2a;
                case 49233: goto L2a;
                case 49234: goto L2a;
                case 49235: goto L2a;
                case 49236: goto L2a;
                case 49237: goto L2a;
                case 49238: goto L2a;
                case 49239: goto L2a;
                case 49240: goto L2a;
                case 49241: goto L2a;
                case 49242: goto L2a;
                case 49243: goto L2a;
                case 49244: goto L2a;
                case 49245: goto L2a;
                case 49246: goto L2a;
                case 49247: goto L2a;
                case 49248: goto L2a;
                case 49249: goto L2a;
                case 49250: goto L2a;
                case 49251: goto L2a;
                case 49252: goto L2a;
                case 49253: goto L2a;
                case 49254: goto L2a;
                case 49255: goto L2a;
                case 49256: goto L2a;
                case 49257: goto L2a;
                case 49258: goto L2a;
                case 49259: goto L2a;
                case 49260: goto L2a;
                case 49261: goto L2a;
                case 49262: goto L2a;
                case 49263: goto L2a;
                case 49264: goto L2a;
                case 49265: goto L2a;
                case 49266: goto L2a;
                case 49267: goto L2a;
                case 49268: goto L2a;
                case 49269: goto L2a;
                case 49270: goto L2a;
                case 49271: goto L2a;
                case 49272: goto L2a;
                case 49273: goto L2a;
                case 49274: goto L2a;
                case 49275: goto L2a;
                case 49276: goto L2a;
                case 49277: goto L2a;
                case 49278: goto L2a;
                case 49279: goto L2a;
                case 49280: goto L2a;
                case 49281: goto L2a;
                case 49282: goto L2a;
                case 49283: goto L2a;
                case 49284: goto L2a;
                case 49285: goto L2a;
                case 49286: goto L2a;
                case 49287: goto L2a;
                case 49288: goto L2a;
                case 49289: goto L2a;
                case 49290: goto L2a;
                case 49291: goto L2a;
                case 49292: goto L2a;
                case 49293: goto L2a;
                case 49294: goto L2a;
                case 49295: goto L2a;
                case 49296: goto L2a;
                case 49297: goto L2a;
                case 49298: goto L2a;
                case 49299: goto L2a;
                default: goto L1e;
            }
        L1e:
            switch(r1) {
                case 49308: goto L2a;
                case 49309: goto L2a;
                case 49310: goto L2a;
                case 49311: goto L2a;
                case 49312: goto L2a;
                case 49313: goto L2a;
                case 49314: goto L2a;
                case 49315: goto L2a;
                case 49316: goto L2a;
                case 49317: goto L2a;
                case 49318: goto L2a;
                case 49319: goto L2a;
                case 49320: goto L2a;
                case 49321: goto L2a;
                case 49322: goto L2a;
                case 49323: goto L2a;
                case 49324: goto L2a;
                case 49325: goto L2a;
                case 49326: goto L2a;
                case 49327: goto L2a;
                default: goto L21;
            }
        L21:
            switch(r1) {
                case 52392: goto L2a;
                case 52393: goto L2a;
                case 52394: goto L2a;
                case 52395: goto L2a;
                case 52396: goto L2a;
                case 52397: goto L2a;
                case 52398: goto L2a;
                default: goto L24;
            }
        L24:
            switch(r1) {
                case 53249: goto L2a;
                case 53250: goto L2a;
                case 53251: goto L2a;
                default: goto L27;
            }
        L27:
            sdk.pendo.io.y4.v0 r1 = sdk.pendo.io.y4.v0.c
            return r1
        L2a:
            sdk.pendo.io.y4.v0 r1 = sdk.pendo.io.y4.v0.f
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.y4.l3.l(int):sdk.pendo.io.y4.v0");
    }

    static int m(int i2) {
        if (i2 == 198 || i2 == 199) {
            return 7;
        }
        switch (i2) {
            case 4865:
            case 4867:
            case 4868:
            case 4869:
                return 4;
            case 4866:
                return 5;
            default:
                return -1;
        }
    }

    public static boolean n(int i2) {
        return 1 == e(i2);
    }

    public static boolean o(int i2) {
        return (65535 & i2) == i2;
    }

    public static boolean p(int i2) {
        return (16777215 & i2) == i2;
    }

    public static boolean q(int i2) {
        return (i2 & 255) == i2;
    }

    private static void a(Hashtable hashtable, sdk.pendo.io.m3.v vVar, i1 i1Var) {
        hashtable.put(vVar.l(), i1Var);
    }

    static byte[] b(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static short c(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("'buf' cannot be null");
        }
        if (bArr.length == 1) {
            return d(bArr, 0);
        }
        throw new h2((short) 50);
    }

    public static byte[] d(int i2) {
        a(i2);
        byte[] bArr = new byte[2];
        a(i2, bArr, 0);
        return bArr;
    }

    public static int e(int i2) {
        return g(f(i2));
    }

    public static boolean g(byte[] bArr) {
        return bArr == null || bArr.length < 1;
    }

    public static sdk.pendo.io.m3.a0 h(byte[] bArr) {
        sdk.pendo.io.m3.p pVar = new sdk.pendo.io.m3.p(bArr);
        sdk.pendo.io.m3.a0 b2 = pVar.b();
        if (b2 == null) {
            throw new h2((short) 50);
        }
        if (pVar.b() == null) {
            return b2;
        }
        throw new h2((short) 50);
    }

    private static void a(Hashtable hashtable, sdk.pendo.io.m3.v vVar, short s, short s2) {
        a(hashtable, vVar, i1.b(s, s2));
    }

    private static Vector b() {
        Vector vector = new Vector();
        vector.addElement(i1.f);
        vector.addElement(i1.g);
        vector.addElement(i1.b((short) 4, (short) 3));
        vector.addElement(i1.b((short) 5, (short) 3));
        vector.addElement(i1.b((short) 6, (short) 3));
        vector.addElement(i1.j);
        vector.addElement(i1.k);
        vector.addElement(i1.l);
        vector.addElement(i1.m);
        vector.addElement(i1.n);
        vector.addElement(i1.o);
        vector.addElement(i1.b((short) 4, (short) 1));
        vector.addElement(i1.b((short) 5, (short) 1));
        vector.addElement(i1.b((short) 6, (short) 1));
        vector.addElement(i1.b((short) 4, (short) 2));
        vector.addElement(i1.b((short) 5, (short) 2));
        vector.addElement(i1.b((short) 6, (short) 2));
        vector.addElement(i1.b((short) 3, (short) 3));
        vector.addElement(i1.b((short) 3, (short) 1));
        vector.addElement(i1.b((short) 3, (short) 2));
        vector.addElement(i1.b((short) 2, (short) 3));
        vector.addElement(i1.b((short) 2, (short) 1));
        vector.addElement(i1.b((short) 2, (short) 2));
        return vector;
    }

    public static sdk.pendo.io.m3.v d(short s) {
        switch (s) {
            case 1:
                return sdk.pendo.io.y3.a.K;
            case 2:
                return sdk.pendo.io.e4.k.j;
            case 3:
                return sdk.pendo.io.v3.b.f;
            case 4:
                return sdk.pendo.io.v3.b.c;
            case 5:
                return sdk.pendo.io.v3.b.d;
            case 6:
                return sdk.pendo.io.v3.b.e;
            default:
                throw new IllegalArgumentException("invalid HashAlgorithm: " + i0.c(s));
        }
    }

    public static boolean e(int[] iArr) {
        return iArr == null || iArr.length < 1;
    }

    public static long f(InputStream inputStream) {
        int read = inputStream.read();
        int read2 = inputStream.read();
        int read3 = inputStream.read();
        if (inputStream.read() >= 0) {
            return (r4 | (read << 24) | (read2 << 16) | (read3 << 8)) & BodyPartID.bodyIdMax;
        }
        throw new EOFException();
    }

    public static short g(InputStream inputStream) {
        int read = inputStream.read();
        if (read >= 0) {
            return (short) read;
        }
        throw new EOFException();
    }

    public static v0 h(InputStream inputStream) {
        int read = inputStream.read();
        int read2 = inputStream.read();
        if (read2 >= 0) {
            return v0.a(read, read2);
        }
        throw new EOFException();
    }

    static Hashtable a(n1 n1Var, m1 m1Var, Hashtable hashtable) {
        if (!e(n1Var.j()) || !hashtable.containsKey(g2.z)) {
            return null;
        }
        int[] x = g2.x(hashtable);
        Vector e2 = m1Var.e();
        Hashtable hashtable2 = new Hashtable(3);
        Vector vector = new Vector(2);
        a(n1Var.b(), x, e2, hashtable2, vector);
        g2.c(hashtable, vector);
        return hashtable2;
    }

    public static int b(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("'buf' cannot be null");
        }
        if (bArr.length == 2) {
            return c(bArr, 0);
        }
        throw new h2((short) 50);
    }

    public static Vector c() {
        Vector vector = new Vector(3);
        vector.add(i1.b((short) 2, (short) 2));
        vector.add(i1.b((short) 2, (short) 3));
        vector.add(i1.b((short) 2, (short) 1));
        return vector;
    }

    static int[] d(int[] iArr) {
        int[] iArr2 = new int[Math.min(3, iArr.length)];
        int i2 = 0;
        for (int i3 : iArr) {
            int m = m(i3);
            if (m >= 0 && !sdk.pendo.io.d5.a.b(iArr2, m)) {
                iArr2[i2] = m;
                i2++;
            }
        }
        return b(iArr2, i2);
    }

    public static boolean e(v0 v0Var) {
        return v0.g.d(v0Var.a());
    }

    static void f(r1 r1Var) {
        a(r1Var, !r1Var.i());
    }

    static Hashtable a(n1 n1Var, Hashtable hashtable, int i2) {
        int[] iArr = {i2};
        Vector a2 = a(sdk.pendo.io.d5.d.b(i2));
        Hashtable hashtable2 = new Hashtable(1, 1.0f);
        Vector vector = new Vector(1);
        a(n1Var.b(), iArr, a2, hashtable2, vector);
        g2.c(hashtable, vector);
        if (hashtable2.isEmpty() || vector.isEmpty()) {
            throw new h2((short) 80);
        }
        return hashtable2;
    }

    public static byte[] b(short s) {
        a(s);
        byte[] bArr = new byte[1];
        a(s, bArr, 0);
        return bArr;
    }

    public static Vector c(int[] iArr) {
        return a(b(iArr));
    }

    public static boolean d(v0 v0Var) {
        return v0.f.d(v0Var.a());
    }

    public static void f(byte[] bArr, int i2) {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        bArr[i2] = (byte) (currentTimeMillis >>> 24);
        bArr[i2 + 1] = (byte) (currentTimeMillis >>> 16);
        bArr[i2 + 2] = (byte) (currentTimeMillis >>> 8);
        bArr[i2 + 3] = (byte) currentTimeMillis;
    }

    static void a(q2[] q2VarArr, Hashtable hashtable) {
        Vector vector = new Vector(q2VarArr.length);
        for (q2 q2Var : q2VarArr) {
            vector.add(new w0(q2Var.b(), 0L));
        }
        g2.a(hashtable, new s0(vector));
    }

    static void b(r1 r1Var, byte[] bArr, y0 y0Var) {
        a1 d2 = r1Var.d();
        a(r1Var, bArr, d2.m(), "c hs traffic", "s hs traffic", y0Var);
        d2.l = d2.H();
        d2.m = d2.I();
    }

    public static boolean c(Vector vector) {
        return vector == null || vector.isEmpty();
    }

    public static boolean d(r1 r1Var) {
        return e(r1Var.a());
    }

    public static int e(InputStream inputStream) {
        int read = inputStream.read();
        int read2 = inputStream.read();
        int read3 = inputStream.read();
        if (read3 >= 0) {
            return read3 | (read << 16) | (read2 << 8);
        }
        throw new EOFException();
    }

    static s0.a a(n1 n1Var, m1 m1Var, Hashtable hashtable, int[] iArr) {
        r2[] a2;
        if (!e(n1Var.j()) || (a2 = a(m1Var, iArr)) == null) {
            return null;
        }
        short[] M = m1Var.M();
        if (b(M)) {
            throw new h2((short) 80, "External PSKs configured but no PskKeyExchangeMode available");
        }
        sdk.pendo.io.z4.b0[] a3 = a(n1Var.b(), a2);
        int a4 = s0.a(a2);
        a(a2, hashtable);
        g2.a(hashtable, M);
        return new s0.a(a2, M, a3, a4);
    }

    static v1 b(l1 l1Var, n nVar) {
        return e(l1Var.a(nVar));
    }

    public static boolean c(v0 v0Var) {
        return v0.e.d(v0Var.a());
    }

    public static int d(InputStream inputStream) {
        int read = inputStream.read();
        int read2 = inputStream.read();
        if (read2 >= 0) {
            return read2 | (read << 8);
        }
        throw new EOFException();
    }

    public static v0 e(byte[] bArr, int i2) {
        return v0.a(bArr[i2] & UByte.MAX_VALUE, bArr[i2 + 1] & UByte.MAX_VALUE);
    }

    static s0.a a(n1 n1Var, s0.a aVar, Hashtable hashtable) {
        Vector a2 = a(aVar.f1800a, m(n1Var.d().e()));
        if (a2.isEmpty()) {
            return null;
        }
        int size = a2.size();
        if (size < aVar.f1800a.length) {
            q2[] q2VarArr = new q2[size];
            sdk.pendo.io.z4.b0[] b0VarArr = new sdk.pendo.io.z4.b0[size];
            for (int i2 = 0; i2 < size; i2++) {
                int intValue = ((Integer) a2.elementAt(i2)).intValue();
                q2VarArr[i2] = aVar.f1800a[intValue];
                b0VarArr[i2] = aVar.c[intValue];
            }
            aVar = new s0.a(q2VarArr, aVar.b, b0VarArr, s0.a(q2VarArr));
        }
        a(aVar.f1800a, hashtable);
        return aVar;
    }

    static v1 b(d3 d3Var) {
        return e(d3Var.N());
    }

    public static boolean c(r1 r1Var) {
        return d(r1Var.a());
    }

    public static short d(byte[] bArr, int i2) {
        return (short) (bArr[i2] & UByte.MAX_VALUE);
    }

    static void e(r1 r1Var) {
        a(r1Var, r1Var.i());
    }

    public static boolean a(Vector vector, int i2) {
        boolean z = !vector.contains(sdk.pendo.io.d5.d.b(i2));
        if (z) {
            vector.add(sdk.pendo.io.d5.d.b(i2));
        }
        return z;
    }

    static byte[] b(j2 j2Var) {
        return j2Var.f().c();
    }

    public static short[] d(InputStream inputStream, int i2) {
        short g2 = g(inputStream);
        if (g2 >= i2) {
            return c(g2, inputStream);
        }
        throw new h2((short) 50);
    }

    static v1 e(v1 v1Var) {
        if (v1Var == null || (v1Var instanceof s1 ? 1 : 0) + 0 + (v1Var instanceof t1 ? 1 : 0) + (v1Var instanceof u1 ? 1 : 0) == 1) {
            return v1Var;
        }
        throw new h2((short) 80);
    }

    static void a(j2 j2Var) {
        byte[] b2 = b(j2Var);
        j2Var.reset();
        int length = b2.length;
        c(length);
        int i2 = length + 4;
        byte[] bArr = new byte[i2];
        a((short) 254, bArr, 0);
        b(length, bArr, 1);
        System.arraycopy(b2, 0, bArr, 4, length);
        j2Var.b(bArr, 0, i2);
    }

    public static Vector b(int[] iArr) {
        Vector vector = new Vector();
        if (iArr != null) {
            for (int i2 : iArr) {
                a(vector, i(i2));
            }
            vector.removeElement(sdk.pendo.io.d5.d.b(-1));
        }
        return vector;
    }

    public static byte[] c(InputStream inputStream) {
        return a(g(inputStream), inputStream);
    }

    static u1 d(v1 v1Var) {
        if (v1Var == null) {
            return null;
        }
        if (v1Var instanceof u1) {
            return (u1) v1Var;
        }
        throw new h2((short) 80);
    }

    private static boolean a(l lVar, l lVar2) {
        int c2 = lVar.c();
        if (lVar2.c() == c2) {
            for (int i2 = 0; i2 < c2; i2++) {
                try {
                    if (!sdk.pendo.io.d5.a.a(lVar.a(i2).getEncoded(), lVar2.a(i2).getEncoded())) {
                        return false;
                    }
                } catch (IOException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public static Vector b(Vector vector) {
        if (vector == null) {
            Vector vector2 = new Vector(3);
            vector2.addElement(sdk.pendo.io.d5.h.a((short) 1));
            vector2.addElement(sdk.pendo.io.d5.h.a((short) 2));
            vector2.addElement(sdk.pendo.io.d5.h.a((short) 3));
            return vector2;
        }
        Vector vector3 = new Vector();
        for (int i2 = 0; i2 < vector.size(); i2++) {
            i1 i1Var = (i1) vector.elementAt(i2);
            if (i1Var.a() >= 2) {
                Short a2 = sdk.pendo.io.d5.h.a(i1Var.b());
                if (!vector3.contains(a2)) {
                    vector3.addElement(a2);
                }
            }
        }
        return vector3;
    }

    public static byte[] c(InputStream inputStream, int i2) {
        short g2 = g(inputStream);
        if (g2 >= i2) {
            return a(g2, inputStream);
        }
        throw new h2((short) 50);
    }

    static byte[] a(r1 r1Var, sdk.pendo.io.z4.f fVar, byte[] bArr) {
        return a(r1Var, fVar, bArr, 0, bArr.length);
    }

    public static boolean b(String str) {
        return str == null || str.length() < 1;
    }

    public static int c(byte[] bArr, int i2) {
        return (bArr[i2 + 1] & UByte.MAX_VALUE) | ((bArr[i2] & UByte.MAX_VALUE) << 8);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static byte[] a(sdk.pendo.io.y4.r1 r4, sdk.pendo.io.z4.f r5, byte[] r6, int r7, int r8) {
        /*
            java.lang.String r0 = r5.a()
            r1 = 4
            r2 = 0
            if (r0 == 0) goto L53
            sdk.pendo.io.m3.v r3 = sdk.pendo.io.y3.a.k
            java.lang.String r3 = r3.l()
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L44
            sdk.pendo.io.m3.g r5 = r5.c()
            sdk.pendo.io.y3.c r5 = sdk.pendo.io.y3.c.a(r5)
            if (r5 == 0) goto L53
            sdk.pendo.io.e4.a r5 = r5.h()
            sdk.pendo.io.m3.v r5 = r5.h()
            sdk.pendo.io.m3.v r0 = sdk.pendo.io.v3.b.c
            boolean r0 = r0.b(r5)
            if (r0 == 0) goto L30
            r5 = r1
            goto L54
        L30:
            sdk.pendo.io.m3.v r0 = sdk.pendo.io.v3.b.d
            boolean r0 = r0.b(r5)
            if (r0 == 0) goto L3a
            r5 = 5
            goto L54
        L3a:
            sdk.pendo.io.m3.v r0 = sdk.pendo.io.v3.b.e
            boolean r5 = r0.b(r5)
            if (r5 == 0) goto L53
            r5 = 6
            goto L54
        L44:
            java.util.Hashtable r5 = sdk.pendo.io.y4.l3.c
            java.lang.Object r5 = r5.get(r0)
            sdk.pendo.io.y4.i1 r5 = (sdk.pendo.io.y4.i1) r5
            if (r5 == 0) goto L53
            short r5 = r5.a()
            goto L54
        L53:
            r5 = r2
        L54:
            r0 = 1
            if (r5 == r0) goto L61
            r0 = 2
            if (r5 == r0) goto L61
            r0 = 8
            if (r5 == r0) goto L60
            r1 = r5
            goto L61
        L60:
            r1 = r2
        L61:
            if (r1 == 0) goto L75
            sdk.pendo.io.z4.h r4 = r4.b()
            sdk.pendo.io.z4.t r4 = a(r4, r1)
            if (r4 == 0) goto L75
            r4.b(r6, r7, r8)
            byte[] r4 = r4.c()
            return r4
        L75:
            byte[] r4 = sdk.pendo.io.y4.l3.e
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.y4.l3.a(sdk.pendo.io.y4.r1, sdk.pendo.io.z4.f, byte[], int, int):byte[]");
    }

    public static boolean b(Object[] objArr) {
        return objArr == null || objArr.length < 1;
    }

    public static short[] c(int i2, InputStream inputStream) {
        short[] sArr = new short[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            sArr[i3] = g(inputStream);
        }
        return sArr;
    }

    private static byte[] a(int i2, int i3, sdk.pendo.io.z4.b0 b0Var, byte[] bArr) {
        sdk.pendo.io.z4.b0 a2 = sdk.pendo.io.z4.k.a(b0Var, i2, "finished", e, i3);
        try {
            return a2.a(i2, bArr, 0, bArr.length);
        } finally {
            a2.destroy();
        }
    }

    public static boolean b(short[] sArr) {
        return sArr == null || sArr.length < 1;
    }

    static u1 c(v1 v1Var) {
        if (v1Var instanceof u1) {
            return (u1) v1Var;
        }
        throw new h2((short) 80);
    }

    private static byte[] a(a1 a1Var, sdk.pendo.io.z4.b0 b0Var, byte[] bArr) {
        return a(a1Var.u(), a1Var.v(), b0Var, bArr);
    }

    public static boolean b(r1 r1Var) {
        return r1Var.a().g();
    }

    public static void c(byte[] bArr, OutputStream outputStream) {
        c(bArr.length);
        c(bArr.length, outputStream);
        outputStream.write(bArr);
    }

    static sdk.pendo.io.z4.b0 a(r1 r1Var, sdk.pendo.io.z4.b0 b0Var) {
        byte[] b2;
        String str;
        a1 d2 = r1Var.d();
        if (d2.M()) {
            b2 = d2.E();
            str = "extended master secret";
        } else {
            b2 = b(d2.f(), d2.A());
            str = TLSKeyMaterialSpec.MASTER_SECRET;
        }
        return a(d2, b0Var, str, b2, 48);
    }

    public static boolean b(v0 v0Var) {
        return v0Var != null && v0.f.d(v0Var.a());
    }

    public static void c(int i2, OutputStream outputStream) {
        outputStream.write(i2);
    }

    static byte[] a(sdk.pendo.io.z4.h hVar, boolean z, int i2, sdk.pendo.io.z4.b0 b0Var, byte[] bArr) {
        int d2 = sdk.pendo.io.z4.k.d(i2);
        sdk.pendo.io.z4.b0 a2 = a(i2, d2, b0Var, z ? "ext binder" : "res binder", hVar.d(i2).c());
        try {
            return a(i2, d2, a2, bArr);
        } finally {
            a2.destroy();
        }
    }

    public static boolean b(sdk.pendo.io.z4.h hVar, int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 3) {
                    return hVar.d() && hVar.a((short) 2);
                }
                if (i2 == 5) {
                    return hVar.d() && a(hVar);
                }
                if (i2 != 7 && i2 != 9 && i2 != 11) {
                    switch (i2) {
                        case 17:
                            if (!hVar.c() || (!hVar.a((short) 3) && !hVar.a((short) 7) && !hVar.a((short) 8))) {
                                break;
                            }
                            break;
                        case 19:
                            if (!hVar.c() || !a(hVar)) {
                                break;
                            }
                            break;
                        case 22:
                            if (!hVar.e() || !hVar.a((short) 2)) {
                                break;
                            }
                            break;
                        case 23:
                            if (!hVar.e() || !a(hVar)) {
                                break;
                            }
                            break;
                    }
                    return false;
                }
                return hVar.d();
            }
            return hVar.a();
        }
        return true;
    }

    public static void c(int i2, byte[] bArr, int i3) {
        bArr[i3] = (byte) i2;
    }

    static byte[] a(r1 r1Var, i1 i1Var, byte[] bArr, c0 c0Var) {
        sdk.pendo.io.z4.h b2 = r1Var.b();
        sdk.pendo.io.z4.t tVar = i1Var == null ? new t(b2) : a(b2, i1Var.a());
        a1 d2 = r1Var.d();
        byte[] c2 = sdk.pendo.io.d5.a.c(d2.f(), d2.A());
        tVar.b(c2, 0, c2.length);
        if (bArr != null) {
            tVar.b(bArr, 0, bArr.length);
        }
        c0Var.a(tVar);
        return tVar.c();
    }

    public static boolean b(int i2, int i3) {
        return a(j1.e(i2), i3);
    }

    static byte[] a(r1 r1Var, j2 j2Var, boolean z) {
        a1 d2 = r1Var.d();
        v0 s = d2.s();
        if (e(s)) {
            return a(d2, z ? d2.d() : d2.c(), b(j2Var));
        }
        if (s.g()) {
            return z0.a(j2Var, z);
        }
        return a(d2, d2.q(), z ? "server finished" : "client finished", b(j2Var), d2.J()).a();
    }

    static void a(v0 v0Var, byte[] bArr) {
        v0 a2 = v0Var.a();
        if (a2.d(v0.e)) {
            a(bArr, f1787a);
        }
        if (a2.d(v0.f)) {
            a(bArr, b);
        }
    }

    static void b(a1 a1Var, int i2) {
        int i3;
        a1Var.d = i2;
        a1Var.Q = i(i2);
        int a2 = a(a1Var, i2);
        a1Var.g = a2;
        if (a2 == 0 || a2 == 1) {
            i3 = -1;
            a1Var.h = -1;
            a1Var.i = (short) -1;
        } else {
            int b2 = sdk.pendo.io.z4.k.b(a2);
            a1Var.h = b2;
            a1Var.i = h(a2);
            i3 = sdk.pendo.io.z4.k.d(b2);
        }
        a1Var.j = i3;
        v0 s = a1Var.s();
        a1Var.k = e(s) ? a1Var.v() : s.g() ? 36 : 12;
    }

    private static void a(byte[] bArr, byte[] bArr2) {
        int length = bArr2.length;
        if (a(length, bArr2, 0, bArr, bArr.length - length)) {
            throw new h2((short) 47);
        }
    }

    static void b(n1 n1Var, m1 m1Var) {
        a1 d2 = n1Var.d();
        v0 s = d2.s();
        if (!v0.g(s)) {
            throw new h2((short) 80);
        }
        a(d2);
        m1Var.b(s);
    }

    static void a(Hashtable hashtable, int i2, short s) {
        Enumeration keys = hashtable.keys();
        while (keys.hasMoreElements()) {
            Integer num = (Integer) keys.nextElement();
            if (num == null || !a(i2, num.intValue())) {
                throw new h2(s, "Invalid extension: " + e0.b(num.intValue()));
            }
        }
    }

    public static int b(byte[] bArr, int i2) {
        int i3 = bArr[i2] << BuiltinOptions.BatchToSpaceNDOptions;
        int i4 = i2 + 1;
        int i5 = i3 | ((bArr[i4] & UByte.MAX_VALUE) << 16);
        int i6 = i4 + 1;
        return (bArr[i6 + 1] & UByte.MAX_VALUE) | i5 | ((bArr[i6] & UByte.MAX_VALUE) << 8);
    }

    static void a(l lVar, Hashtable hashtable, Hashtable hashtable2) {
        byte[] a2 = lVar.a(0).a(o2.f1792a);
        if (a2 != null) {
            sdk.pendo.io.m3.d0 d0Var = (sdk.pendo.io.m3.d0) h(a2);
            for (int i2 = 0; i2 < d0Var.size(); i2++) {
                if (!(d0Var.a(i2) instanceof sdk.pendo.io.m3.q)) {
                    throw new h2((short) 42);
                }
            }
            a(d0Var, a2);
            for (int i3 = 0; i3 < d0Var.size(); i3++) {
                BigInteger k = ((sdk.pendo.io.m3.q) d0Var.a(i3)).k();
                if (k.bitLength() <= 16) {
                    Integer b2 = sdk.pendo.io.d5.d.b(k.intValue());
                    if (hashtable.containsKey(b2) && !hashtable2.containsKey(b2)) {
                        throw new h2((short) 46);
                    }
                }
            }
        }
    }

    public static byte[] b(InputStream inputStream) {
        return a(d(inputStream), inputStream);
    }

    public static void a(int i2) {
        if (!o(i2)) {
            throw new h2((short) 80);
        }
    }

    public static byte[] b(InputStream inputStream, int i2) {
        int e2 = e(inputStream);
        if (e2 >= i2) {
            return a(e2, inputStream);
        }
        throw new h2((short) 50);
    }

    public static void a(long j) {
        if (!b(j)) {
            throw new h2((short) 80);
        }
    }

    public static int[] b(int i2, InputStream inputStream) {
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = d(inputStream);
        }
        return iArr;
    }

    public static void a(short s) {
        if (!e(s)) {
            throw new h2((short) 80);
        }
    }

    static l1 b(n1 n1Var, m1 m1Var, ByteArrayInputStream byteArrayInputStream) {
        a1 d2 = n1Var.d();
        if (d2.x() != null) {
            throw new h2((short) 10);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        l a2 = l.a(new l.a().a(m1Var.p()), n1Var, byteArrayInputStream, byteArrayOutputStream);
        w2.a(byteArrayInputStream);
        if (a2.d()) {
            throw new h2((short) 50);
        }
        if (d2.O() && !a(n1Var, a2)) {
            throw new h2((short) 46, "Server certificate changed unsafely in renegotiation handshake");
        }
        d2.S = a2;
        d2.A = byteArrayOutputStream.toByteArray();
        l1 H = m1Var.H();
        if (H != null) {
            return H;
        }
        throw new h2((short) 80);
    }

    public static byte[] a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return bArr.length == 0 ? e : (byte[]) bArr.clone();
    }

    static t1 b(v1 v1Var) {
        if (v1Var instanceof t1) {
            return (t1) v1Var;
        }
        throw new h2((short) 80);
    }

    public static String[] a(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        return strArr.length < 1 ? i : (String[]) strArr.clone();
    }

    static short[] b(short[] sArr, short[] sArr2) {
        short[] sArr3 = new short[Math.min(sArr.length, sArr2.length)];
        int i2 = 0;
        for (int i3 = 0; i3 < sArr2.length; i3++) {
            if (sdk.pendo.io.d5.a.b(sArr, sArr2[i3])) {
                sArr3[i2] = sArr2[i3];
                i2++;
            }
        }
        return a(sArr3, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0074 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(sdk.pendo.io.z4.h r6, int[] r7, java.util.Vector r8, java.util.Hashtable r9, java.util.Vector r10) {
        /*
            boolean r0 = e(r7)
            if (r0 == 0) goto L7
            return
        L7:
            if (r8 == 0) goto L77
            boolean r0 = r8.isEmpty()
            if (r0 == 0) goto L10
            goto L77
        L10:
            r0 = 0
        L11:
            int r1 = r7.length
            if (r0 >= r1) goto L77
            r1 = r7[r0]
            java.lang.Integer r2 = sdk.pendo.io.d5.d.b(r1)
            boolean r3 = r8.contains(r2)
            if (r3 == 0) goto L74
            boolean r3 = r9.containsKey(r2)
            if (r3 != 0) goto L74
            boolean r3 = r6.f(r1)
            if (r3 != 0) goto L2d
            goto L74
        L2d:
            boolean r3 = sdk.pendo.io.y4.p0.k(r1)
            if (r3 == 0) goto L47
            boolean r3 = r6.c()
            if (r3 == 0) goto L62
            sdk.pendo.io.z4.o r3 = new sdk.pendo.io.z4.o
            r3.<init>(r1)
            sdk.pendo.io.z4.p r3 = r6.a(r3)
            sdk.pendo.io.z4.e r3 = r3.a()
            goto L63
        L47:
            boolean r3 = sdk.pendo.io.y4.p0.l(r1)
            if (r3 == 0) goto L62
            boolean r3 = r6.d()
            if (r3 == 0) goto L62
            sdk.pendo.io.z4.l r3 = new sdk.pendo.io.z4.l
            r4 = 1
            r3.<init>(r1, r4)
            sdk.pendo.io.z4.m r3 = r6.a(r3)
            sdk.pendo.io.z4.e r3 = r3.a()
            goto L63
        L62:
            r3 = 0
        L63:
            if (r3 == 0) goto L74
            byte[] r4 = r3.a()
            sdk.pendo.io.y4.k0 r5 = new sdk.pendo.io.y4.k0
            r5.<init>(r1, r4)
            r10.addElement(r5)
            r9.put(r2, r3)
        L74:
            int r0 = r0 + 1
            goto L11
        L77:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.y4.l3.a(sdk.pendo.io.z4.h, int[], java.util.Vector, java.util.Hashtable, java.util.Vector):void");
    }

    static void b(r1 r1Var, j2 j2Var, boolean z) {
        if (z || !r1Var.b().b()) {
            j2Var.e();
        }
        j2Var.g();
    }

    public static boolean a(int i2, byte[] bArr, int i3, byte[] bArr2, int i4) {
        int i5 = 0;
        for (int i6 = 0; i6 < i2; i6++) {
            i5 |= bArr[i3 + i6] ^ bArr2[i4 + i6];
        }
        return i5 == 0;
    }

    static k0 b(Vector vector, int i2) {
        k0 k0Var;
        if (vector == null || 1 != vector.size() || (k0Var = (k0) vector.elementAt(0)) == null || k0Var.b() != i2) {
            return null;
        }
        return k0Var;
    }

    static boolean a(int[] iArr, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < i3; i5++) {
            if (i4 == iArr[i2 + i5]) {
                return true;
            }
        }
        return false;
    }

    static int[] b(int[] iArr, int i2) {
        if (i2 >= iArr.length) {
            return iArr;
        }
        int[] iArr2 = new int[i2];
        System.arraycopy(iArr, 0, iArr2, 0, i2);
        return iArr2;
    }

    static boolean a(short[] sArr, short[] sArr2) {
        for (short s : sArr2) {
            if (!sdk.pendo.io.d5.a.b(sArr, s)) {
                return false;
            }
        }
        return true;
    }

    static void b(g3 g3Var, n nVar, d0 d0Var, j2 j2Var) {
        short b2;
        boolean a2;
        a1 d2 = g3Var.d();
        sdk.pendo.io.z4.f a3 = d2.x().a(0);
        i1 a4 = d0Var.a();
        if (a4 == null) {
            b2 = a3.b();
            short c2 = c(b2);
            if (c2 < 0 || !sdk.pendo.io.d5.a.b(nVar.c(), c2)) {
                throw new h2((short) 43);
            }
        } else {
            b2 = a4.b();
            if (!a(b2, nVar.c())) {
                throw new h2((short) 47);
            }
            b(d2.B(), a4);
        }
        try {
            sdk.pendo.io.z4.f0 a5 = a3.a(b2);
            sdk.pendo.io.z4.e0 a6 = a5.a(d0Var);
            if (a6 != null) {
                j2Var.a(a6.a());
                a2 = a6.b();
            } else {
                a2 = a5.a(d0Var, c(g3Var) ? j2Var.a(j1.a(j1.a(a4))) : d2.E());
            }
            if (!a2) {
                throw new h2((short) 51);
            }
        } catch (h2 e2) {
            throw e2;
        } catch (Exception e3) {
            throw new h2((short) 51, (Throwable) e3);
        }
    }

    public static boolean a(Vector vector, short s) {
        for (int i2 = 0; i2 < vector.size(); i2++) {
            if (((i1) vector.elementAt(i2)).b() == s) {
                return true;
            }
        }
        return false;
    }

    public static void b(Vector vector, i1 i1Var) {
        if (vector == null || vector.size() < 1 || vector.size() >= 32768) {
            throw new IllegalArgumentException("'supportedSignatureAlgorithms' must have length from 1 to (2^15 - 1)");
        }
        if (i1Var == null) {
            throw new IllegalArgumentException("'signatureAlgorithm' cannot be null");
        }
        if (i1Var.b() == 0 || !a(vector, i1Var)) {
            throw new h2((short) 47);
        }
    }

    public static boolean a(Vector vector, i1 i1Var) {
        for (int i2 = 0; i2 < vector.size(); i2++) {
            if (((i1) vector.elementAt(i2)).equals(i1Var)) {
                return true;
            }
        }
        return false;
    }

    static void b(v0 v0Var, byte[] bArr) {
        byte[] bArr2;
        v0 a2 = v0Var.a();
        if (v0.f == a2) {
            bArr2 = b;
        } else {
            if (!a2.d(v0.e)) {
                throw new h2((short) 80);
            }
            bArr2 = f1787a;
        }
        System.arraycopy(bArr2, 0, bArr, bArr.length - bArr2.length, bArr2.length);
    }

    public static byte[] a(byte[] bArr, int i2, int i3) {
        int i4 = i3 - i2;
        byte[] bArr2 = new byte[i4];
        System.arraycopy(bArr, i2, bArr2, 0, i4);
        return bArr2;
    }

    public static void b(byte[] bArr, OutputStream outputStream) {
        b(bArr.length);
        b(bArr.length, outputStream);
        outputStream.write(bArr);
    }

    private static Hashtable a() {
        Hashtable hashtable = new Hashtable();
        a(hashtable, sdk.pendo.io.v3.b.X, (short) 3, (short) 2);
        a(hashtable, sdk.pendo.io.v3.b.Y, (short) 4, (short) 2);
        a(hashtable, sdk.pendo.io.v3.b.Z, (short) 5, (short) 2);
        a(hashtable, sdk.pendo.io.v3.b.a0, (short) 6, (short) 2);
        a(hashtable, sdk.pendo.io.x3.a.j, (short) 2, (short) 2);
        a(hashtable, sdk.pendo.io.x3.a.k, (short) 2, (short) 1);
        a(hashtable, sdk.pendo.io.y3.a.f, (short) 2, (short) 1);
        a(hashtable, sdk.pendo.io.y3.a.o, (short) 3, (short) 1);
        a(hashtable, sdk.pendo.io.y3.a.l, (short) 4, (short) 1);
        a(hashtable, sdk.pendo.io.y3.a.m, (short) 5, (short) 1);
        a(hashtable, sdk.pendo.io.y3.a.n, (short) 6, (short) 1);
        a(hashtable, sdk.pendo.io.f4.h.j, (short) 2, (short) 3);
        a(hashtable, sdk.pendo.io.f4.h.n, (short) 3, (short) 3);
        a(hashtable, sdk.pendo.io.f4.h.o, (short) 4, (short) 3);
        a(hashtable, sdk.pendo.io.f4.h.p, (short) 5, (short) 3);
        a(hashtable, sdk.pendo.io.f4.h.q, (short) 6, (short) 3);
        a(hashtable, sdk.pendo.io.f4.h.Y, (short) 2, (short) 2);
        a(hashtable, sdk.pendo.io.s3.a.s, (short) 2, (short) 3);
        a(hashtable, sdk.pendo.io.s3.a.t, (short) 3, (short) 3);
        a(hashtable, sdk.pendo.io.s3.a.u, (short) 4, (short) 3);
        a(hashtable, sdk.pendo.io.s3.a.v, (short) 5, (short) 3);
        a(hashtable, sdk.pendo.io.s3.a.w, (short) 6, (short) 3);
        a(hashtable, sdk.pendo.io.s3.a.l, (short) 2, (short) 1);
        a(hashtable, sdk.pendo.io.s3.a.m, (short) 4, (short) 1);
        a(hashtable, sdk.pendo.io.o3.a.d, (short) 2, (short) 3);
        a(hashtable, sdk.pendo.io.o3.a.e, (short) 3, (short) 3);
        a(hashtable, sdk.pendo.io.o3.a.f, (short) 4, (short) 3);
        a(hashtable, sdk.pendo.io.o3.a.g, (short) 5, (short) 3);
        a(hashtable, sdk.pendo.io.o3.a.h, (short) 6, (short) 3);
        a(hashtable, sdk.pendo.io.t3.a.d, i1.f);
        a(hashtable, sdk.pendo.io.t3.a.e, i1.g);
        a(hashtable, sdk.pendo.io.z3.a.i, i1.h);
        a(hashtable, sdk.pendo.io.z3.a.j, i1.i);
        return hashtable;
    }

    public static void b(int[] iArr, OutputStream outputStream) {
        int length = iArr.length * 2;
        a(length);
        a(length, outputStream);
        a(iArr, outputStream);
    }

    private static sdk.pendo.io.z4.t a(sdk.pendo.io.z4.h hVar, short s) {
        return hVar.d(sdk.pendo.io.z4.k.a(s));
    }

    public static void b(int[] iArr, byte[] bArr, int i2) {
        int length = iArr.length * 2;
        a(length);
        a(length, bArr, i2);
        a(iArr, bArr, i2 + 2);
    }

    private static l2 a(m1 m1Var, int i2) {
        m2 z = m1Var.z();
        if (i2 == 1) {
            return z.a(i2);
        }
        if (i2 == 3 || i2 == 5) {
            return z.b(i2, m1Var.C());
        }
        if (i2 == 7 || i2 == 9) {
            return z.e(i2);
        }
        if (i2 == 11) {
            return z.a(i2, m1Var.C());
        }
        switch (i2) {
            case 13:
            case 15:
            case 24:
                m1Var.y();
                return z.a(i2, (s2) null, (x1) null);
            case 14:
                m1Var.y();
                return z.a(i2, (s2) null, m1Var.C());
            case 16:
            case 18:
                return z.d(i2);
            case 17:
            case 19:
                return z.c(i2);
            case 20:
                return z.b(i2);
            case 21:
            case 22:
            case 23:
                m1Var.D();
                return z.a(i2, (z2) null, m1Var.s());
            default:
                throw new h2((short) 80);
        }
    }

    public static void b(int i2, OutputStream outputStream) {
        outputStream.write((byte) (i2 >>> 16));
        outputStream.write((byte) (i2 >>> 8));
        outputStream.write((byte) i2);
    }

    private static l2 a(d3 d3Var, int i2) {
        m2 z = d3Var.z();
        if (i2 == 1) {
            return z.a(i2);
        }
        if (i2 == 3 || i2 == 5) {
            return z.a(i2, d3Var.j());
        }
        if (i2 == 7 || i2 == 9) {
            return z.e(i2);
        }
        if (i2 == 11) {
            return z.b(i2, d3Var.j());
        }
        switch (i2) {
            case 13:
            case 15:
                d3Var.E();
                return z.a(i2, null, null, null);
            case 14:
                d3Var.E();
                return z.a(i2, null, d3Var.j(), null);
            case 16:
            case 18:
                return z.d(i2);
            case 17:
            case 19:
                return z.a(i2, d3Var.L());
            case 20:
                return z.b(i2, d3Var.L());
            case 21:
            case 22:
            case 23:
                d3Var.F();
                return z.a(i2, (b3) null);
            case 24:
                d3Var.E();
                return z.a(i2, null, null, d3Var.L());
            default:
                throw new h2((short) 80);
        }
    }

    public static void b(int i2, byte[] bArr, int i3) {
        bArr[i3] = (byte) (i2 >>> 16);
        bArr[i3 + 1] = (byte) (i2 >>> 8);
        bArr[i3 + 2] = (byte) i2;
    }

    public static byte[] a(byte[] bArr, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("'buf' cannot be null");
        }
        if (bArr.length < 2) {
            throw new h2((short) 50);
        }
        int c2 = c(bArr, 0);
        if (bArr.length != c2 + 2 || c2 < i2) {
            throw new h2((short) 50);
        }
        return a(bArr, 2, bArr.length);
    }

    public static void b(short[] sArr, OutputStream outputStream) {
        c(sArr.length);
        c(sArr.length, outputStream);
        a(sArr, outputStream);
    }

    static sdk.pendo.io.z4.b0 a(int i2, int i3, sdk.pendo.io.z4.b0 b0Var, String str, byte[] bArr) {
        if (bArr.length == i3) {
            return sdk.pendo.io.z4.k.a(b0Var, i2, str, bArr, i3);
        }
        throw new h2((short) 80);
    }

    public static void b(short[] sArr, byte[] bArr, int i2) {
        c(sArr.length);
        c(sArr.length, bArr, i2);
        a(sArr, bArr, i2 + 1);
    }

    static sdk.pendo.io.z4.b0 a(a1 a1Var, sdk.pendo.io.z4.b0 b0Var, String str, byte[] bArr) {
        return a(a1Var.u(), a1Var.v(), b0Var, str, bArr);
    }

    public static void a(Vector vector, OutputStream outputStream) {
        if (vector == null || vector.size() < 1 || vector.size() >= 32768) {
            throw new IllegalArgumentException("'supportedSignatureAlgorithms' must have length from 1 to (2^15 - 1)");
        }
        int size = vector.size() * 2;
        a(size);
        a(size, outputStream);
        for (int i2 = 0; i2 < vector.size(); i2++) {
            i1 i1Var = (i1) vector.elementAt(i2);
            if (i1Var.b() == 0) {
                throw new IllegalArgumentException("SignatureAlgorithm.anonymous MUST NOT appear in the signature_algorithms extension");
            }
            i1Var.a(outputStream);
        }
    }

    public static byte[] a(int[] iArr) {
        byte[] bArr = new byte[(iArr.length * 2) + 2];
        b(iArr, bArr, 0);
        return bArr;
    }

    public static byte[] a(short[] sArr) {
        byte[] bArr = new byte[sArr.length + 1];
        b(sArr, bArr, 0);
        return bArr;
    }

    public static byte[] a(v0 v0Var) {
        return new byte[]{(byte) v0Var.c(), (byte) v0Var.d()};
    }

    static u1 a(l1 l1Var, n nVar) {
        return d(l1Var.a(nVar));
    }

    static void a(r1 r1Var, byte[] bArr, y0 y0Var) {
        a1 d2 = r1Var.d();
        sdk.pendo.io.z4.b0 q = d2.q();
        a(r1Var, bArr, q, "c ap traffic", "s ap traffic", y0Var);
        d2.p = a(d2, q, "exp master", bArr);
    }

    static void a(r1 r1Var, sdk.pendo.io.z4.b0 b0Var, sdk.pendo.io.z4.b0 b0Var2) {
        sdk.pendo.io.z4.h b2 = r1Var.b();
        a1 d2 = r1Var.d();
        int u = d2.u();
        sdk.pendo.io.z4.b0 c2 = b2.c(u);
        byte[] c3 = b2.d(u).c();
        if (b0Var == null) {
            b0Var = b2.c(u).a(u, c2);
        }
        if (b0Var2 == null) {
            b0Var2 = c2;
        }
        sdk.pendo.io.z4.b0 a2 = a(d2, b0Var, "derived", c3).a(u, b0Var2);
        if (b0Var2 != c2) {
            b0Var2.destroy();
        }
        sdk.pendo.io.z4.b0 a3 = a(d2, a2, "derived", c3).a(u, c2);
        d2.o = b0Var;
        d2.q = a2;
        d2.r = a3;
    }

    static u1 a(d3 d3Var) {
        return d(d3Var.N());
    }

    private static void a(r1 r1Var, byte[] bArr, sdk.pendo.io.z4.b0 b0Var, String str, String str2, y0 y0Var) {
        a1 d2 = r1Var.d();
        d2.s = a(d2, b0Var, str, bArr);
        if (str2 != null) {
            d2.t = a(d2, b0Var, str2, bArr);
        }
        y0Var.a(a(r1Var));
    }

    static void a(a1 a1Var, Hashtable hashtable) {
        a1Var.K = g2.u(hashtable);
        a1Var.L = g2.t(hashtable);
    }

    static void a(a1 a1Var, n nVar) {
        a1Var.I = nVar.c();
        a1Var.N = nVar.d();
        a1Var.O = nVar.e();
        if (a1Var.C() == null) {
            a1Var.O = a1Var.B();
        }
    }

    static d0 a(r1 r1Var, u1 u1Var, j2 j2Var) {
        i1 c2 = u1Var.c();
        if (c2 != null) {
            return new d0(c2, a(r1Var.b(), u1Var, r1Var.i() ? "TLS 1.3, server CertificateVerify" : "TLS 1.3, client CertificateVerify", j2Var, c2));
        }
        throw new h2((short) 80);
    }

    private static byte[] a(sdk.pendo.io.z4.h hVar, u1 u1Var, String str, j2 j2Var, i1 i1Var) {
        sdk.pendo.io.z4.d0 b2 = u1Var.b();
        byte[] a2 = a(str);
        byte[] b3 = b(j2Var);
        if (b2 != null) {
            OutputStream a3 = b2.a();
            a3.write(a2, 0, a2.length);
            a3.write(b3, 0, b3.length);
            return b2.b();
        }
        sdk.pendo.io.z4.t d2 = hVar.d(j1.a(j1.a(i1Var)));
        d2.b(a2, 0, a2.length);
        d2.b(b3, 0, b3.length);
        return u1Var.a(d2.c());
    }

    static d0 a(n1 n1Var, u1 u1Var, sdk.pendo.io.z4.d0 d0Var, j2 j2Var) {
        byte[] a2;
        a1 d2 = n1Var.d();
        v0 s = d2.s();
        if (e(s)) {
            throw new h2((short) 80);
        }
        i1 a3 = a(s, u1Var);
        if (d0Var != null) {
            j2Var.a(d0Var.a());
            a2 = d0Var.b();
        } else {
            a2 = u1Var.a(a3 == null ? d2.E() : j2Var.a(j1.a(j1.a(a3))));
        }
        return new d0(a3, a2);
    }

    public static sdk.pendo.io.z4.b0 a(r1 r1Var, sdk.pendo.io.z4.r rVar, OutputStream outputStream) {
        sdk.pendo.io.z4.b0 a2 = r1Var.b().a(r1Var.g());
        a(r1Var, a2.a(rVar), outputStream);
        return a2;
    }

    static void a(r1 r1Var, u1 u1Var, byte[] bArr, c0 c0Var) {
        byte[] a2;
        i1 a3 = a(r1Var, u1Var);
        sdk.pendo.io.z4.d0 b2 = u1Var.b();
        if (b2 != null) {
            a(r1Var, bArr, c0Var, b2.a());
            a2 = b2.b();
        } else {
            a2 = u1Var.a(a(r1Var, a3, bArr, c0Var));
        }
        new d0(a3, a2).a(c0Var);
    }

    private static byte[] a(String str) {
        int length = str.length();
        int i2 = length + 64;
        byte[] bArr = new byte[i2 + 1];
        for (int i3 = 0; i3 < 64; i3++) {
            bArr[i3] = BuiltinOptions.StridedSliceOptions;
        }
        for (int i4 = 0; i4 < length; i4++) {
            bArr[i4 + 64] = (byte) str.charAt(i4);
        }
        bArr[i2] = 0;
        return bArr;
    }

    public static int a(v0 v0Var, int[] iArr, int[] iArr2, boolean z) {
        if (z) {
            iArr2 = iArr;
            iArr = iArr2;
        }
        for (int i2 : iArr) {
            if (sdk.pendo.io.d5.a.b(iArr2, i2) && a(i2, v0Var)) {
                return i2;
            }
        }
        return -1;
    }

    public static int[] a(int[] iArr, int[] iArr2, boolean z) {
        if (z) {
            iArr2 = iArr;
            iArr = iArr2;
        }
        int min = Math.min(iArr.length, iArr2.length);
        int[] iArr3 = new int[min];
        int i2 = 0;
        for (int i3 : iArr) {
            if (!a(iArr3, 0, i2, i3) && sdk.pendo.io.d5.a.b(iArr2, i3)) {
                iArr3[i2] = i3;
                i2++;
            }
        }
        return i2 < min ? sdk.pendo.io.d5.a.c(iArr3, i2) : iArr3;
    }

    public static byte[] a(Hashtable hashtable, Integer num) {
        if (hashtable == null) {
            return null;
        }
        return (byte[]) hashtable.get(num);
    }

    public static Vector a(Vector vector) {
        Vector vector2 = new Vector();
        for (int i2 = 0; i2 < vector.size(); i2++) {
            int intValue = ((Integer) vector.elementAt(i2)).intValue();
            if (intValue != 0) {
                if (intValue != 3 && intValue != 5 && intValue != 7 && intValue != 9 && intValue != 11 && intValue != 14) {
                    if (intValue != 24) {
                        switch (intValue) {
                            case 16:
                            case 17:
                                a(vector2, 2);
                                a(vector2, 3);
                                break;
                        }
                    }
                } else {
                    a(vector2, 1);
                }
            } else {
                a(vector2, 1);
            }
            a(vector2, 2);
        }
        return vector2;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0074 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0076 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static int a(sdk.pendo.io.y4.a1 r7, int r8) {
        /*
            sdk.pendo.io.y4.v0 r7 = r7.s()
            boolean r0 = e(r7)
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L14
            boolean r3 = d(r7)
            if (r3 == 0) goto L14
            r3 = r1
            goto L15
        L14:
            r3 = r2
        L15:
            boolean r7 = r7.g()
            r4 = 2
            r5 = 47
            switch(r8) {
                case 59: goto L74;
                case 60: goto L74;
                case 61: goto L74;
                case 62: goto L74;
                case 63: goto L74;
                case 64: goto L74;
                default: goto L1f;
            }
        L1f:
            switch(r8) {
                case 103: goto L74;
                case 104: goto L74;
                case 105: goto L74;
                case 106: goto L74;
                case 107: goto L74;
                case 108: goto L74;
                case 109: goto L74;
                default: goto L22;
            }
        L22:
            r6 = 3
            switch(r8) {
                case 156: goto L74;
                case 157: goto L6b;
                case 158: goto L74;
                case 159: goto L6b;
                case 160: goto L74;
                case 161: goto L6b;
                case 162: goto L74;
                case 163: goto L6b;
                case 164: goto L74;
                case 165: goto L6b;
                case 166: goto L74;
                case 167: goto L6b;
                case 168: goto L74;
                case 169: goto L6b;
                case 170: goto L74;
                case 171: goto L6b;
                case 172: goto L74;
                case 173: goto L6b;
                default: goto L26;
            }
        L26:
            switch(r8) {
                case 175: goto L7d;
                case 177: goto L7d;
                case 179: goto L7d;
                case 181: goto L7d;
                case 183: goto L7d;
                case 49208: goto L7d;
                case 49301: goto L7d;
                case 49303: goto L7d;
                case 49305: goto L7d;
                case 53253: goto L74;
                default: goto L29;
            }
        L29:
            switch(r8) {
                case 49211: goto L7d;
                case 49212: goto L74;
                case 49213: goto L6b;
                case 49214: goto L74;
                case 49215: goto L6b;
                case 49216: goto L74;
                case 49217: goto L6b;
                case 49218: goto L74;
                case 49219: goto L6b;
                case 49220: goto L74;
                case 49221: goto L6b;
                case 49222: goto L74;
                case 49223: goto L6b;
                case 49224: goto L74;
                case 49225: goto L6b;
                case 49226: goto L74;
                case 49227: goto L6b;
                case 49228: goto L74;
                case 49229: goto L6b;
                case 49230: goto L74;
                case 49231: goto L6b;
                case 49232: goto L74;
                case 49233: goto L6b;
                case 49234: goto L74;
                case 49235: goto L6b;
                case 49236: goto L74;
                case 49237: goto L6b;
                case 49238: goto L74;
                case 49239: goto L6b;
                case 49240: goto L74;
                case 49241: goto L6b;
                case 49242: goto L74;
                case 49243: goto L6b;
                case 49244: goto L74;
                case 49245: goto L6b;
                case 49246: goto L74;
                case 49247: goto L6b;
                case 49248: goto L74;
                case 49249: goto L6b;
                case 49250: goto L74;
                case 49251: goto L6b;
                case 49252: goto L74;
                case 49253: goto L6b;
                case 49254: goto L74;
                case 49255: goto L6b;
                case 49256: goto L74;
                case 49257: goto L6b;
                case 49258: goto L74;
                case 49259: goto L6b;
                case 49260: goto L74;
                case 49261: goto L6b;
                case 49262: goto L74;
                case 49263: goto L6b;
                case 49264: goto L74;
                case 49265: goto L6b;
                case 49266: goto L74;
                case 49267: goto L6b;
                case 49268: goto L74;
                case 49269: goto L6b;
                case 49270: goto L74;
                case 49271: goto L6b;
                case 49272: goto L74;
                case 49273: goto L6b;
                case 49274: goto L74;
                case 49275: goto L6b;
                case 49276: goto L74;
                case 49277: goto L6b;
                case 49278: goto L74;
                case 49279: goto L6b;
                case 49280: goto L74;
                case 49281: goto L6b;
                case 49282: goto L74;
                case 49283: goto L6b;
                case 49284: goto L74;
                case 49285: goto L6b;
                case 49286: goto L74;
                case 49287: goto L6b;
                case 49288: goto L74;
                case 49289: goto L6b;
                case 49290: goto L74;
                case 49291: goto L6b;
                case 49292: goto L74;
                case 49293: goto L6b;
                case 49294: goto L74;
                case 49295: goto L6b;
                case 49296: goto L74;
                case 49297: goto L6b;
                case 49298: goto L74;
                case 49299: goto L6b;
                default: goto L2c;
            }
        L2c:
            switch(r8) {
                case 185: goto L7d;
                case 186: goto L74;
                case 187: goto L74;
                case 188: goto L74;
                case 189: goto L74;
                case 190: goto L74;
                case 191: goto L74;
                case 192: goto L74;
                case 193: goto L74;
                case 194: goto L74;
                case 195: goto L74;
                case 196: goto L74;
                case 197: goto L74;
                case 198: goto L43;
                case 199: goto L43;
                default: goto L2f;
            }
        L2f:
            switch(r8) {
                case 4865: goto L57;
                case 4866: goto L4d;
                case 4867: goto L57;
                case 4868: goto L57;
                case 4869: goto L57;
                default: goto L32;
            }
        L32:
            switch(r8) {
                case 49187: goto L74;
                case 49188: goto L6b;
                case 49189: goto L74;
                case 49190: goto L6b;
                case 49191: goto L74;
                case 49192: goto L6b;
                case 49193: goto L74;
                case 49194: goto L6b;
                case 49195: goto L74;
                case 49196: goto L6b;
                case 49197: goto L74;
                case 49198: goto L6b;
                case 49199: goto L74;
                case 49200: goto L6b;
                case 49201: goto L74;
                case 49202: goto L6b;
                default: goto L35;
            }
        L35:
            switch(r8) {
                case 49307: goto L7d;
                case 49308: goto L74;
                case 49309: goto L74;
                case 49310: goto L74;
                case 49311: goto L74;
                case 49312: goto L74;
                case 49313: goto L74;
                case 49314: goto L74;
                case 49315: goto L74;
                case 49316: goto L74;
                case 49317: goto L74;
                case 49318: goto L74;
                case 49319: goto L74;
                case 49320: goto L74;
                case 49321: goto L74;
                case 49322: goto L74;
                case 49323: goto L74;
                case 49324: goto L74;
                case 49325: goto L74;
                case 49326: goto L74;
                case 49327: goto L74;
                default: goto L38;
            }
        L38:
            switch(r8) {
                case 52392: goto L74;
                case 52393: goto L74;
                case 52394: goto L74;
                case 52395: goto L74;
                case 52396: goto L74;
                case 52397: goto L74;
                case 52398: goto L74;
                default: goto L3b;
            }
        L3b:
            switch(r8) {
                case 53249: goto L74;
                case 53250: goto L6b;
                case 53251: goto L74;
                default: goto L3e;
            }
        L3e:
            if (r0 != 0) goto L65
            if (r3 == 0) goto L61
            return r4
        L43:
            if (r0 == 0) goto L47
            r7 = 7
            return r7
        L47:
            sdk.pendo.io.y4.h2 r7 = new sdk.pendo.io.y4.h2
            r7.<init>(r5)
            throw r7
        L4d:
            if (r0 == 0) goto L51
            r7 = 5
            return r7
        L51:
            sdk.pendo.io.y4.h2 r7 = new sdk.pendo.io.y4.h2
            r7.<init>(r5)
            throw r7
        L57:
            if (r0 == 0) goto L5b
            r7 = 4
            return r7
        L5b:
            sdk.pendo.io.y4.h2 r7 = new sdk.pendo.io.y4.h2
            r7.<init>(r5)
            throw r7
        L61:
            if (r7 == 0) goto L64
            return r2
        L64:
            return r1
        L65:
            sdk.pendo.io.y4.h2 r7 = new sdk.pendo.io.y4.h2
            r7.<init>(r5)
            throw r7
        L6b:
            if (r3 == 0) goto L6e
            return r6
        L6e:
            sdk.pendo.io.y4.h2 r7 = new sdk.pendo.io.y4.h2
            r7.<init>(r5)
            throw r7
        L74:
            if (r3 == 0) goto L77
            return r4
        L77:
            sdk.pendo.io.y4.h2 r7 = new sdk.pendo.io.y4.h2
            r7.<init>(r5)
            throw r7
        L7d:
            if (r0 != 0) goto L86
            if (r3 == 0) goto L82
            return r6
        L82:
            if (r7 == 0) goto L85
            return r2
        L85:
            return r1
        L86:
            sdk.pendo.io.y4.h2 r7 = new sdk.pendo.io.y4.h2
            r7.<init>(r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.y4.l3.a(sdk.pendo.io.y4.a1, int):int");
    }

    static sdk.pendo.io.z4.b0 a(sdk.pendo.io.z4.h hVar, q2 q2Var) {
        int b2 = sdk.pendo.io.z4.k.b(q2Var.a());
        return hVar.c(b2).a(b2, q2Var.getKey());
    }

    static sdk.pendo.io.z4.b0[] a(sdk.pendo.io.z4.h hVar, q2[] q2VarArr) {
        int length = q2VarArr.length;
        sdk.pendo.io.z4.b0[] b0VarArr = new sdk.pendo.io.z4.b0[length];
        for (int i2 = 0; i2 < length; i2++) {
            b0VarArr[i2] = a(hVar, q2VarArr[i2]);
        }
        return b0VarArr;
    }

    static r2[] a(m1 m1Var, int[] iArr) {
        Vector l = m1Var.l();
        if (c(l)) {
            return null;
        }
        int[] d2 = d(iArr);
        int size = l.size();
        r2[] r2VarArr = new r2[size];
        for (int i2 = 0; i2 < size; i2++) {
            Object elementAt = l.elementAt(i2);
            if (!(elementAt instanceof r2)) {
                throw new h2((short) 80, "External PSKs element is not a TlsPSKExternal");
            }
            r2 r2Var = (r2) elementAt;
            if (!sdk.pendo.io.d5.a.b(d2, r2Var.a())) {
                throw new h2((short) 80, "External PSK incompatible with offered cipher suites");
            }
            r2VarArr[i2] = r2Var;
        }
        return r2VarArr;
    }

    static Vector a(q2[] q2VarArr, int i2) {
        Vector vector = new Vector(q2VarArr.length);
        for (int i3 = 0; i3 < q2VarArr.length; i3++) {
            if (q2VarArr[i3].a() == i2) {
                vector.add(sdk.pendo.io.d5.d.b(i3));
            }
        }
        return vector;
    }

    static byte[] a(j3 j3Var) {
        byte[] a2;
        return (j3Var == null || (a2 = j3Var.a()) == null || a2.length <= 0 || a2.length > 32) ? e : a2;
    }

    static sdk.pendo.io.z4.b0 a(sdk.pendo.io.z4.h hVar, sdk.pendo.io.z4.b0 b0Var) {
        if (b0Var == null) {
            return null;
        }
        synchronized (b0Var) {
            if (!b0Var.b()) {
                return null;
            }
            return hVar.a(b0Var);
        }
    }

    static i1 a(v0 v0Var, u1 u1Var) {
        if (!d(v0Var)) {
            return null;
        }
        i1 c2 = u1Var.c();
        if (c2 != null) {
            return c2;
        }
        throw new h2((short) 80);
    }

    public static i1 a(r1 r1Var, u1 u1Var) {
        return a(r1Var.a(), u1Var);
    }

    public static int[] a(sdk.pendo.io.z4.h hVar, int[] iArr, int i2, int i3) {
        int[] iArr2 = new int[i3];
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = iArr[i2 + i5];
            if (a(hVar, i6)) {
                iArr2[i4] = i6;
                i4++;
            }
        }
        return i4 < i3 ? sdk.pendo.io.d5.a.c(iArr2, i4) : iArr2;
    }

    static boolean a(sdk.pendo.io.z4.h hVar) {
        return hVar.a((short) 1) || hVar.a((short) 4) || hVar.a((short) 5) || hVar.a((short) 6) || hVar.a((short) 9) || hVar.a((short) 10) || hVar.a((short) 11);
    }

    public static boolean a(Hashtable hashtable, Integer num, short s) {
        byte[] a2 = a(hashtable, num);
        if (a2 == null) {
            return false;
        }
        if (a2.length == 0) {
            return true;
        }
        throw new h2(s);
    }

    public static j3 a(byte[] bArr, g1 g1Var) {
        return new k3(bArr, g1Var);
    }

    static sdk.pendo.io.z4.g a(r1 r1Var) {
        int e2 = r1Var.d().e();
        int f2 = f(e2);
        int k = k(e2);
        if (f2 < 0 || k < 0) {
            throw new h2((short) 80);
        }
        return r1Var.b().a(new sdk.pendo.io.z4.j(r1Var), f2, k);
    }

    static l2 a(n1 n1Var, m1 m1Var) {
        l2 a2 = a(m1Var, n1Var.d().n());
        a2.a(n1Var);
        return a2;
    }

    static l2 a(g3 g3Var, d3 d3Var) {
        l2 a2 = a(d3Var, g3Var.d().n());
        a2.a(g3Var);
        return a2;
    }

    static boolean a(v0[] v0VarArr) {
        return v0.a(v0VarArr, v0.f) || v0.a(v0VarArr, v0.e) || v0.a(v0VarArr, v0.d);
    }

    public static boolean a(Object[] objArr) {
        if (objArr == null) {
            return true;
        }
        for (Object obj : objArr) {
            if (obj == null) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static boolean a(int r6, int r7) {
        /*
            r0 = 8
            r1 = 0
            r2 = 1
            if (r7 == 0) goto L5e
            if (r7 == r2) goto L5e
            r3 = 5
            r4 = 13
            if (r7 == r3) goto L54
            r3 = 10
            if (r7 == r3) goto L5e
            r3 = 27
            if (r7 == r3) goto L4e
            switch(r7) {
                case 13: goto L4e;
                case 14: goto L5e;
                case 15: goto L5e;
                case 16: goto L5e;
                default: goto L18;
            }
        L18:
            switch(r7) {
                case 18: goto L54;
                case 19: goto L5e;
                case 20: goto L5e;
                case 21: goto L46;
                default: goto L1b;
            }
        L1b:
            r3 = 6
            r5 = 2
            switch(r7) {
                case 41: goto L38;
                case 42: goto L2f;
                case 43: goto L3e;
                case 44: goto L29;
                case 45: goto L46;
                default: goto L20;
            }
        L20:
            switch(r7) {
                case 47: goto L4e;
                case 48: goto L4a;
                case 49: goto L46;
                case 50: goto L4e;
                case 51: goto L3e;
                default: goto L23;
            }
        L23:
            boolean r6 = sdk.pendo.io.y4.e0.c(r7)
            r6 = r6 ^ r2
            return r6
        L29:
            if (r6 == r2) goto L2e
            if (r6 == r3) goto L2e
            return r1
        L2e:
            return r2
        L2f:
            if (r6 == r2) goto L37
            r7 = 4
            if (r6 == r7) goto L37
            if (r6 == r0) goto L37
            return r1
        L37:
            return r2
        L38:
            if (r6 == r2) goto L3d
            if (r6 == r5) goto L3d
            return r1
        L3d:
            return r2
        L3e:
            if (r6 == r2) goto L45
            if (r6 == r5) goto L45
            if (r6 == r3) goto L45
            return r1
        L45:
            return r2
        L46:
            if (r6 == r2) goto L49
            return r1
        L49:
            return r2
        L4a:
            if (r6 == r4) goto L4d
            return r1
        L4d:
            return r2
        L4e:
            if (r6 == r2) goto L53
            if (r6 == r4) goto L53
            return r1
        L53:
            return r2
        L54:
            if (r6 == r2) goto L5d
            r7 = 11
            if (r6 == r7) goto L5d
            if (r6 == r4) goto L5d
            return r1
        L5d:
            return r2
        L5e:
            if (r6 == r2) goto L63
            if (r6 == r0) goto L63
            return r1
        L63:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.y4.l3.a(int, int):boolean");
    }

    private static boolean a(n1 n1Var, l lVar) {
        l x;
        a1 e2 = n1Var.e();
        if (e2 == null || (x = e2.x()) == null) {
            return false;
        }
        return a(x, lVar);
    }

    public static boolean a(sdk.pendo.io.z4.h hVar, int i2) {
        int f2;
        if (!b(hVar, i(i2)) || (f2 = f(i2)) < 0 || !hVar.a(f2)) {
            return false;
        }
        int k = k(i2);
        if (k != 0) {
            return k >= 0 && hVar.e(k);
        }
        return true;
    }

    public static boolean a(int i2, Vector vector) {
        int i3 = i(i2);
        if (i3 != 0 && i3 != 3 && i3 != 5 && i3 != 17 && i3 != 19 && i3 != 22 && i3 != 23) {
            return true;
        }
        int size = vector.size();
        for (int i4 = 0; i4 < size; i4++) {
            Short sh = (Short) vector.elementAt(i4);
            if (sh != null && a(sh.shortValue(), i3)) {
                return true;
            }
        }
        return false;
    }

    static boolean a(int[] iArr, int i2) {
        return (iArr == null || !sdk.pendo.io.d5.a.b(iArr, i2) || i2 == 0 || r.a(i2)) ? false : true;
    }

    static boolean a(v0 v0Var, int[] iArr, Hashtable hashtable, int i2) {
        return iArr != null && sdk.pendo.io.d5.a.b(iArr, i2) && !hashtable.containsKey(sdk.pendo.io.d5.d.b(i2)) && p0.a(i2, v0Var);
    }

    static boolean a(short s, short[] sArr) {
        short a2 = h1.a(s);
        return a2 >= 0 && sdk.pendo.io.d5.a.b(sArr, a2);
    }

    public static boolean a(int i2, v0 v0Var) {
        v0 a2 = v0Var.a();
        v0 l = l(i2);
        if (l == a2) {
            return true;
        }
        if (!l.c(a2)) {
            return false;
        }
        v0 v0Var2 = v0.g;
        return v0Var2.d(l) || v0Var2.f(a2);
    }

    static void a(a1 a1Var) {
        if (!b(a1Var.s())) {
            a1Var.K = null;
            a1Var.L = null;
            return;
        }
        if (a1Var.h() == null) {
            a1Var.K = c();
        }
        if (a1Var.i() == null) {
            a1Var.L = a1Var.h();
        }
    }

    static void a(g3 g3Var) {
        a1 d2 = g3Var.d();
        if (!v0.h(d2.s())) {
            throw new h2((short) 80);
        }
        a(d2);
    }

    static n a(n nVar, short[] sArr) {
        if (a(sArr, nVar.c())) {
            return nVar;
        }
        short[] b2 = b(nVar.c(), sArr);
        if (b2.length < 1) {
            return null;
        }
        return new n(b2, nVar.d(), nVar.a());
    }

    public static Vector a(InputStream inputStream) {
        int d2 = d(inputStream);
        if (d2 < 2 || (d2 & 1) != 0) {
            throw new h2((short) 50);
        }
        int i2 = d2 / 2;
        Vector vector = new Vector(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            i1 a2 = i1.a(inputStream);
            if (a2.b() != 0) {
                vector.addElement(a2);
            }
        }
        return vector;
    }

    static void a(g3 g3Var, l lVar, l2 l2Var, d3 d3Var) {
        a1 d2 = g3Var.d();
        if (d2.x() != null) {
            throw new h2((short) 10);
        }
        if (!e(d2.s())) {
            if (lVar.d()) {
                l2Var.c();
            } else {
                l2Var.b(lVar);
            }
        }
        d2.S = lVar;
        d3Var.a(lVar);
    }

    static void a(n1 n1Var, o oVar, l2 l2Var, l1 l1Var, Hashtable hashtable, Hashtable hashtable2) {
        a1 d2 = n1Var.d();
        boolean e2 = e(d2.s());
        if (l1Var != null) {
            l x = d2.x();
            a(x, hashtable, hashtable2);
            if (!e2) {
                l2Var.a(x);
            }
            l1Var.a(new f3(x, oVar));
            return;
        }
        if (e2) {
            throw new h2((short) 80);
        }
        if (d2.O()) {
            throw new h2((short) 40);
        }
        l2Var.e();
        d2.A = e;
    }

    static byte[] a(r1 r1Var, InputStream inputStream) {
        return b(r1Var) ? z0.a(inputStream) : b(inputStream);
    }

    public static byte[] a(int i2, InputStream inputStream) {
        if (i2 < 1) {
            return e;
        }
        byte[] bArr = new byte[i2];
        if (i2 == sdk.pendo.io.f5.a.a(inputStream, bArr)) {
            return bArr;
        }
        throw new EOFException();
    }

    public static byte[] a(InputStream inputStream, int i2) {
        int d2 = d(inputStream);
        if (d2 >= i2) {
            return a(d2, inputStream);
        }
        throw new h2((short) 50);
    }

    public static byte[] a(InputStream inputStream, int i2, int i3) {
        short g2 = g(inputStream);
        if (g2 < i2 || i3 < g2) {
            throw new h2((short) 50);
        }
        return a(g2, inputStream);
    }

    static l1 a(n1 n1Var, m1 m1Var, ByteArrayInputStream byteArrayInputStream) {
        a1 d2 = n1Var.d();
        if (d2.x() != null) {
            throw new h2((short) 10);
        }
        l a2 = l.a(new l.a().a(m1Var.p()), n1Var, byteArrayInputStream, (OutputStream) null);
        w2.a(byteArrayInputStream);
        if (a2.a().length > 0) {
            throw new h2((short) 47);
        }
        if (a2.d()) {
            throw new h2((short) 50);
        }
        d2.S = a2;
        d2.A = null;
        l1 H = m1Var.H();
        if (H != null) {
            return H;
        }
        throw new h2((short) 80);
    }

    static s1 a(v1 v1Var) {
        if (v1Var instanceof s1) {
            return (s1) v1Var;
        }
        throw new h2((short) 80);
    }

    public static void a(sdk.pendo.io.m3.t tVar, byte[] bArr) {
        if (!sdk.pendo.io.d5.a.a(tVar.a(ASN1Encoding.DER), bArr)) {
            throw new h2((short) 50);
        }
    }

    static k0 a(sdk.pendo.io.z4.h hVar, v0 v0Var, Vector vector, int[] iArr, int[] iArr2) {
        if (vector == null || e(iArr) || e(iArr2)) {
            return null;
        }
        for (int i2 = 0; i2 < vector.size(); i2++) {
            k0 k0Var = (k0) vector.elementAt(i2);
            int b2 = k0Var.b();
            if (p0.a(b2, v0Var) && sdk.pendo.io.d5.a.b(iArr2, b2) && sdk.pendo.io.d5.a.b(iArr, b2) && hVar.f(b2) && ((!p0.k(b2) || hVar.c()) && (!p0.l(b2) || hVar.d()))) {
                return k0Var;
            }
        }
        return null;
    }

    static int a(sdk.pendo.io.z4.h hVar, v0 v0Var, int[] iArr, int[] iArr2) {
        if (e(iArr) || e(iArr2)) {
            return -1;
        }
        for (int i2 : iArr) {
            if (p0.a(i2, v0Var) && sdk.pendo.io.d5.a.b(iArr2, i2) && hVar.f(i2) && ((!p0.k(i2) || hVar.c()) && (!p0.l(i2) || hVar.d()))) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static sdk.pendo.io.y4.s0.b a(sdk.pendo.io.y4.g3 r7, sdk.pendo.io.y4.d3 r8, java.util.Hashtable r9, sdk.pendo.io.y4.f0 r10, sdk.pendo.io.y4.j2 r11, boolean r12) {
        /*
            sdk.pendo.io.y4.s0 r0 = sdk.pendo.io.y4.g2.q(r9)
            if (r0 == 0) goto L85
            short[] r9 = sdk.pendo.io.y4.g2.o(r9)
            boolean r1 = b(r9)
            if (r1 != 0) goto L7d
            r1 = 1
            boolean r2 = sdk.pendo.io.d5.a.b(r9, r1)
            if (r2 == 0) goto L85
            java.util.Vector r2 = r0.c()
            sdk.pendo.io.y4.r2 r8 = r8.b(r2)
            if (r8 == 0) goto L85
            sdk.pendo.io.y4.w0 r2 = new sdk.pendo.io.y4.w0
            byte[] r3 = r8.b()
            r4 = 0
            r2.<init>(r3, r4)
            int r2 = r0.a(r2)
            if (r2 < 0) goto L85
            java.util.Vector r3 = r0.a()
            java.lang.Object r3 = r3.elementAt(r2)
            byte[] r3 = (byte[]) r3
            sdk.pendo.io.z4.h r7 = r7.b()
            sdk.pendo.io.z4.b0 r4 = a(r7, r8)
            int r5 = r8.a()
            int r5 = sdk.pendo.io.z4.k.b(r5)
            int r0 = r0.b()
            r10.a(r11, r0)
            if (r12 == 0) goto L5a
            byte[] r12 = r11.a(r5)
            goto L6a
        L5a:
            sdk.pendo.io.z4.t r12 = r7.d(r5)
            sdk.pendo.io.z4.u r6 = new sdk.pendo.io.z4.u
            r6.<init>(r12)
            r11.a(r6)
            byte[] r12 = r12.c()
        L6a:
            r10.b(r11, r0)
            byte[] r7 = a(r7, r1, r5, r4, r12)
            boolean r7 = sdk.pendo.io.d5.a.d(r7, r3)
            if (r7 == 0) goto L86
            sdk.pendo.io.y4.s0$b r7 = new sdk.pendo.io.y4.s0$b
            r7.<init>(r2, r8, r9, r4)
            return r7
        L7d:
            sdk.pendo.io.y4.h2 r7 = new sdk.pendo.io.y4.h2
            r8 = 109(0x6d, float:1.53E-43)
            r7.<init>(r8)
            throw r7
        L85:
            r1 = 0
        L86:
            if (r1 != 0) goto L8b
            r10.a(r11)
        L8b:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.y4.l3.a(sdk.pendo.io.y4.g3, sdk.pendo.io.y4.d3, java.util.Hashtable, sdk.pendo.io.y4.f0, sdk.pendo.io.y4.j2, boolean):sdk.pendo.io.y4.s0$b");
    }

    static void a(r1 r1Var, byte[] bArr, c0 c0Var, OutputStream outputStream) {
        a1 d2 = r1Var.d();
        outputStream.write(sdk.pendo.io.d5.a.c(d2.f(), d2.A()));
        if (bArr != null) {
            outputStream.write(bArr);
        }
        c0Var.a(outputStream);
        outputStream.close();
    }

    static l1 a(n1 n1Var) {
        a1 d2 = n1Var.d();
        if (d2.x() != null) {
            throw new h2((short) 80);
        }
        d2.S = null;
        d2.A = null;
        return null;
    }

    static void a(j2 j2Var, Vector vector) {
        if (vector != null) {
            for (int i2 = 0; i2 < vector.size(); i2++) {
                i1 i1Var = (i1) vector.elementAt(i2);
                int a2 = j1.a(j1.a(i1Var));
                if (a2 >= 0) {
                    j2Var.b(a2);
                } else if (8 == i1Var.a()) {
                    j2Var.e();
                }
            }
        }
    }

    static short[] a(short[] sArr, int i2) {
        if (i2 >= sArr.length) {
            return sArr;
        }
        short[] sArr2 = new short[i2];
        System.arraycopy(sArr, 0, sArr2, 0, i2);
        return sArr2;
    }

    private static sdk.pendo.io.z4.b0 a(a1 a1Var, sdk.pendo.io.z4.b0 b0Var) {
        return sdk.pendo.io.z4.k.a(b0Var, a1Var.u(), "traffic upd", e, a1Var.v());
    }

    private static void a(r1 r1Var, boolean z) {
        sdk.pendo.io.z4.b0 H;
        a1 e2 = r1Var.e();
        if (z) {
            H = e2.I();
            e2.t = a(e2, H);
        } else {
            H = e2.H();
            e2.s = a(e2, H);
        }
        if (H != null) {
            H.destroy();
        }
    }

    static n a(n nVar, l2 l2Var) {
        short[] f2 = l2Var.f();
        if (b(f2)) {
            throw new h2((short) 10);
        }
        n a2 = a(nVar, f2);
        if (a2 != null) {
            return a2;
        }
        throw new h2((short) 47);
    }

    public static Vector a(Object obj) {
        Vector vector = new Vector(1);
        vector.addElement(obj);
        return vector;
    }

    private static boolean a(sdk.pendo.io.z4.h hVar, d0 d0Var, sdk.pendo.io.z4.f0 f0Var, String str, j2 j2Var) {
        sdk.pendo.io.z4.e0 a2 = f0Var.a(d0Var);
        byte[] a3 = a(str);
        byte[] b2 = b(j2Var);
        if (a2 != null) {
            OutputStream a4 = a2.a();
            a4.write(a3, 0, a3.length);
            a4.write(b2, 0, b2.length);
            return a2.b();
        }
        sdk.pendo.io.z4.t d2 = hVar.d(j1.a(j1.a(d0Var.a())));
        d2.b(a3, 0, a3.length);
        d2.b(b2, 0, b2.length);
        return f0Var.a(d0Var, d2.c());
    }

    static void a(g3 g3Var, n nVar, d0 d0Var, j2 j2Var) {
        a1 d2 = g3Var.d();
        sdk.pendo.io.z4.f a2 = d2.x().a(0);
        i1 a3 = d0Var.a();
        b(d2.B(), a3);
        try {
            if (!a(g3Var.b(), d0Var, a2.b(j1.a(a3)), "TLS 1.3, client CertificateVerify", j2Var)) {
                throw new h2((short) 51);
            }
        } catch (h2 e2) {
            throw e2;
        } catch (Exception e3) {
            throw new h2((short) 51, (Throwable) e3);
        }
    }

    static void a(n1 n1Var, d0 d0Var, j2 j2Var) {
        a1 d2 = n1Var.d();
        sdk.pendo.io.z4.f a2 = d2.x().a(0);
        i1 a3 = d0Var.a();
        b(d2.h(), a3);
        try {
            if (!a(n1Var.b(), d0Var, a2.b(j1.a(a3)), "TLS 1.3, server CertificateVerify", j2Var)) {
                throw new h2((short) 51);
            }
        } catch (h2 e2) {
            throw e2;
        } catch (Exception e3) {
            throw new h2((short) 51, (Throwable) e3);
        }
    }

    static void a(r1 r1Var, InputStream inputStream, sdk.pendo.io.z4.f fVar, byte[] bArr, c0 c0Var) {
        short s;
        boolean a2;
        d0 a3 = d0.a(r1Var, inputStream);
        a1 d2 = r1Var.d();
        int n = d2.n();
        i1 a4 = a3.a();
        if (a4 == null) {
            s = j(n);
        } else {
            short b2 = a4.b();
            if (!a(b2, n)) {
                throw new h2((short) 47);
            }
            b(d2.h(), a4);
            s = b2;
        }
        sdk.pendo.io.z4.f0 a5 = fVar.a(s);
        sdk.pendo.io.z4.e0 a6 = a5.a(a3);
        if (a6 != null) {
            a(r1Var, bArr, c0Var, a6.a());
            a2 = a6.b();
        } else {
            a2 = a5.a(a3, a(r1Var, a4, bArr, c0Var));
        }
        if (!a2) {
            throw new h2((short) 51);
        }
    }

    static void a(r1 r1Var, byte[] bArr, OutputStream outputStream) {
        if (b(r1Var)) {
            z0.a(bArr, outputStream);
        } else {
            a(bArr, outputStream);
        }
    }

    public static void a(byte[] bArr, OutputStream outputStream) {
        a(bArr.length);
        a(bArr.length, outputStream);
        outputStream.write(bArr);
    }

    public static void a(byte[] bArr, byte[] bArr2, int i2) {
        c(bArr.length);
        c(bArr.length, bArr2, i2);
        System.arraycopy(bArr, 0, bArr2, i2 + 1, bArr.length);
    }

    public static void a(int i2, OutputStream outputStream) {
        outputStream.write(i2 >>> 8);
        outputStream.write(i2);
    }

    public static void a(int i2, byte[] bArr, int i3) {
        bArr[i3] = (byte) (i2 >>> 8);
        bArr[i3 + 1] = (byte) i2;
    }

    public static void a(int[] iArr, OutputStream outputStream) {
        for (int i2 : iArr) {
            a(i2, outputStream);
        }
    }

    public static void a(int[] iArr, byte[] bArr, int i2) {
        for (int i3 : iArr) {
            a(i3, bArr, i2);
            i2 += 2;
        }
    }

    public static void a(long j, OutputStream outputStream) {
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) j);
    }

    public static void a(long j, byte[] bArr, int i2) {
        bArr[i2] = (byte) (j >>> 56);
        bArr[i2 + 1] = (byte) (j >>> 48);
        bArr[i2 + 2] = (byte) (j >>> 40);
        bArr[i2 + 3] = (byte) (j >>> 32);
        bArr[i2 + 4] = (byte) (j >>> 24);
        bArr[i2 + 5] = (byte) (j >>> 16);
        bArr[i2 + 6] = (byte) (j >>> 8);
        bArr[i2 + 7] = (byte) j;
    }

    public static void a(short s, OutputStream outputStream) {
        outputStream.write(s);
    }

    public static void a(short s, byte[] bArr, int i2) {
        bArr[i2] = (byte) s;
    }

    public static void a(short[] sArr, OutputStream outputStream) {
        for (short s : sArr) {
            a(s, outputStream);
        }
    }

    public static void a(short[] sArr, byte[] bArr, int i2) {
        for (short s : sArr) {
            a(s, bArr, i2);
            i2++;
        }
    }

    public static void a(v0 v0Var, OutputStream outputStream) {
        outputStream.write(v0Var.c());
        outputStream.write(v0Var.d());
    }

    public static void a(v0 v0Var, byte[] bArr, int i2) {
        bArr[i2] = (byte) v0Var.c();
        bArr[i2 + 1] = (byte) v0Var.d();
    }
}
