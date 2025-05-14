package sdk.pendo.io.v2;

import androidx.core.view.ViewCompat;
import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.ObjArray;
import external.sdk.pendo.io.mozilla.javascript.Token;
import external.sdk.pendo.io.mozilla.javascript.UintMap;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import kotlin.UByte;
import org.apache.commons.io.IOUtils;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* loaded from: classes4.dex */
public class c {
    private static final int E;
    private static final int F;
    private static final boolean G;
    private ObjArray A;
    private ObjArray B;
    private String d;
    private e[] e;
    private int f;
    private int[] g;
    private int h;
    private int j;
    private d k;
    private sdk.pendo.io.v2.b l;
    private short m;
    private short n;
    private short o;
    private short s;
    private short t;
    private short u;
    private short v;
    private int[] w;
    private int x;
    private long[] y;
    private int z;

    /* renamed from: a, reason: collision with root package name */
    private int[] f1669a = null;
    private int b = 0;
    private UintMap c = null;
    private byte[] i = new byte[256];
    private ObjArray p = new ObjArray();
    private ObjArray q = new ObjArray();
    private ObjArray r = new ObjArray();
    private int C = 0;
    private char[] D = new char[64];

    final class a {

        /* renamed from: a, reason: collision with root package name */
        final byte[] f1670a;

        public boolean equals(Object obj) {
            return (obj instanceof a) && Arrays.equals(this.f1670a, ((a) obj).f1670a);
        }

        public int hashCode() {
            return ~Arrays.hashCode(this.f1670a);
        }
    }

    public static class b extends RuntimeException {
        b(String str) {
            super(str);
        }
    }

    /* renamed from: sdk.pendo.io.v2.c$c, reason: collision with other inner class name */
    final class C0247c {
        private g[] g = null;
        private int[] c = null;

        /* renamed from: a, reason: collision with root package name */
        private int[] f1671a = null;
        private g[] e = null;
        private byte[] h = null;
        private int b = 0;
        private int d = 0;
        private int f = 0;
        private int i = 0;
        private boolean j = false;

        C0247c() {
        }

        private void a(g gVar) {
            if (gVar.g()) {
                return;
            }
            gVar.a(true);
            gVar.b(true);
            int i = this.f;
            g[] gVarArr = this.e;
            if (i == gVarArr.length) {
                g[] gVarArr2 = new g[i * 2];
                System.arraycopy(gVarArr, 0, gVarArr2, 0, i);
                this.e = gVarArr2;
            }
            g[] gVarArr3 = this.e;
            int i2 = this.f;
            this.f = i2 + 1;
            gVarArr3[i2] = gVar;
        }

        private void b() {
            int[] f = this.g[0].f();
            int i = -1;
            int i2 = 1;
            while (true) {
                g[] gVarArr = this.g;
                if (i2 >= gVarArr.length) {
                    return;
                }
                g gVar = gVarArr[i2];
                int[] f2 = gVar.f();
                int[] d = gVar.d();
                int e = (gVar.e() - i) - 1;
                if (d.length == 0) {
                    int length = f.length > f2.length ? f2.length : f.length;
                    int abs = Math.abs(f.length - f2.length);
                    int i3 = 0;
                    while (i3 < length && f[i3] == f2[i3]) {
                        i3++;
                    }
                    if (i3 == f2.length && abs == 0) {
                        k(e);
                    } else if (i3 != f2.length || abs > 3) {
                        if (i3 == f.length && abs <= 3) {
                            a(f2, abs, e);
                        }
                        a(f2, d, e);
                    } else {
                        e(abs, e);
                    }
                } else {
                    if (d.length == 1 && Arrays.equals(f, f2)) {
                        a(d, e);
                    }
                    a(f2, d, e);
                }
                i = gVar.e();
                i2++;
                f = f2;
            }
        }

        private void d() {
            while (true) {
                int i = this.f;
                if (i <= 0) {
                    return;
                }
                g[] gVarArr = this.e;
                int i2 = i - 1;
                this.f = i2;
                g gVar = gVarArr[i2];
                gVar.a(false);
                this.f1671a = gVar.c();
                int[] d = gVar.d();
                this.c = d;
                this.b = this.f1671a.length;
                this.d = d.length;
                b(gVar);
            }
        }

        private int f(int i) {
            return b(i, 1);
        }

        private g g(int i) {
            g gVar;
            int i2 = 0;
            while (true) {
                g[] gVarArr = this.g;
                if (i2 >= gVarArr.length || (gVar = gVarArr[i2]) == null) {
                    break;
                }
                if (i >= gVar.e() && i < gVar.a()) {
                    return gVar;
                }
                i2++;
            }
            throw new IllegalArgumentException("bad offset: " + i);
        }

        private boolean h(int i) {
            switch (i) {
                case 153:
                case 154:
                case 155:
                case 156:
                case 157:
                case 158:
                case Token.LETEXPR /* 159 */:
                case 160:
                case Token.DEBUGGER /* 161 */:
                case Token.COMMENT /* 162 */:
                case Token.GENEXPR /* 163 */:
                case Token.METHOD /* 164 */:
                case Token.ARROW /* 165 */:
                case Token.YIELD_STAR /* 166 */:
                case Token.LAST_TOKEN /* 167 */:
                    return true;
                default:
                    switch (i) {
                        case 198:
                        case 199:
                        case 200:
                            return true;
                        default:
                            return false;
                    }
            }
        }

        private boolean i(int i) {
            if (i == 167 || i == 191 || i == 200 || i == 176 || i == 177) {
                return true;
            }
            switch (i) {
                case Context.VERSION_1_7 /* 170 */:
                case 171:
                case 172:
                case 173:
                case 174:
                    return true;
                default:
                    return false;
            }
        }

        private void j(int i) {
            int i2 = this.d;
            if (i2 == this.c.length) {
                int[] iArr = new int[Math.max(i2 * 2, 4)];
                System.arraycopy(this.c, 0, iArr, 0, this.d);
                this.c = iArr;
            }
            int[] iArr2 = this.c;
            int i3 = this.d;
            this.d = i3 + 1;
            iArr2[i3] = i;
        }

        private void k(int i) {
            if (i <= 63) {
                byte[] bArr = this.h;
                int i2 = this.i;
                this.i = i2 + 1;
                bArr[i2] = (byte) i;
                return;
            }
            byte[] bArr2 = this.h;
            int i3 = this.i;
            int i4 = i3 + 1;
            this.i = i4;
            bArr2[i3] = -5;
            this.i = c.a(i, bArr2, i4);
        }

        private int l(int i) {
            int i2 = i & 255;
            byte[] bArr = this.h;
            int i3 = this.i;
            int i4 = i3 + 1;
            this.i = i4;
            bArr[i3] = (byte) i2;
            if (i2 == 7 || i2 == 8) {
                this.i = c.a(i >>> 8, bArr, i4);
            }
            return this.i;
        }

        int c() {
            this.h = new byte[f()];
            b();
            return this.i + 2;
        }

        void e() {
            this.g = new g[c.this.b];
            int[] c = c.this.c();
            int i = 0;
            while (i < c.this.b) {
                this.g[i] = new g(i, c.this.f1669a[i], i == c.this.b + (-1) ? c.this.j : c.this.f1669a[i + 1], c);
                i++;
            }
            i();
        }

        private void a() {
            this.d = 0;
        }

        private void b(int i) {
            int e = e(i);
            int d = h.d(e);
            if (d != 7 && d != 6 && d != 8 && d != 5) {
                throw new IllegalStateException("bad local variable type: " + e + " at index: " + i);
            }
            j(e);
        }

        private void c(int i) {
            d(i, g());
        }

        private g d(int i) {
            return g(i + ((c.this.i[i] & UByte.MAX_VALUE) == 200 ? b(i + 1, 4) : (short) b(i + 1, 2)));
        }

        private int e(int i) {
            if (i < this.b) {
                return this.f1671a[i];
            }
            return 0;
        }

        private int f() {
            return (this.g.length - 1) * ((c.this.o * 3) + 7 + (c.this.n * 3));
        }

        private int g() {
            int[] iArr = this.c;
            int i = this.d - 1;
            this.d = i;
            return iArr[i];
        }

        private long h() {
            long g = g();
            return h.e((int) g) ? g : (g << 32) | (g() & ViewCompat.MEASURED_SIZE_MASK);
        }

        private void i() {
            int[] c = c.this.c();
            int i = 0;
            this.g[0].a(c, c.length, new int[0], 0, c.this.k);
            this.e = new g[]{this.g[0]};
            this.f = 1;
            d();
            while (true) {
                g[] gVarArr = this.g;
                if (i >= gVarArr.length) {
                    d();
                    return;
                }
                g gVar = gVarArr[i];
                if (!gVar.h()) {
                    d(gVar);
                }
                i++;
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x00e1, code lost:
        
            if (r12.equals(androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_INTERRUPTED) == false) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x014f, code lost:
        
            if (r12.equals(androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_INTERRUPTED) == false) goto L37;
         */
        /* JADX WARN: Removed duplicated region for block: B:41:0x031e  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0328  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private int a(int r12) {
            /*
                Method dump skipped, instructions count: 1222
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.v2.c.C0247c.a(int):int");
        }

        private void b(g gVar) {
            int e = gVar.e();
            int i = 0;
            while (e < gVar.a()) {
                i = c.this.i[e] & UByte.MAX_VALUE;
                int a2 = a(e);
                if (h(i)) {
                    c(d(e));
                } else if (i == 170) {
                    int i2 = e + 1 + ((~e) & 3);
                    c(g(b(i2, 4) + e));
                    int b = (b(i2 + 8, 4) - b(i2 + 4, 4)) + 1;
                    int i3 = i2 + 12;
                    for (int i4 = 0; i4 < b; i4++) {
                        c(g(b((i4 * 4) + i3, 4) + e));
                    }
                }
                for (int i5 = 0; i5 < c.this.f; i5++) {
                    e eVar = c.this.e[i5];
                    int u = c.this.u(eVar.f1673a);
                    int u2 = c.this.u(eVar.b);
                    if (e >= u && e < u2) {
                        g g = g(c.this.u(eVar.c));
                        short s = eVar.d;
                        if (s == 0) {
                            s = c.this.k.a("java/lang/Throwable");
                        }
                        g.a(this.f1671a, this.b, new int[]{h.a(s)}, 1, c.this.k);
                        a(g);
                    }
                }
                e += a2;
            }
            if (i(i)) {
                return;
            }
            int b2 = gVar.b() + 1;
            g[] gVarArr = this.g;
            if (b2 < gVarArr.length) {
                c(gVarArr[b2]);
            }
        }

        private void c(g gVar) {
            if (gVar.a(this.f1671a, this.b, this.c, this.d, c.this.k)) {
                a(gVar);
            }
        }

        private void d(g gVar) {
            int[] iArr = new int[0];
            int[] iArr2 = {h.a("java/lang/Throwable", c.this.k)};
            for (int i = 0; i < c.this.f; i++) {
                e eVar = c.this.e[i];
                int u = c.this.u(eVar.f1673a);
                int u2 = c.this.u(eVar.b);
                g g = g(c.this.u(eVar.c));
                if ((gVar.e() > u && gVar.e() < u2) || (u > gVar.e() && u < gVar.a() && g.h())) {
                    iArr = g.c();
                    break;
                }
            }
            int[] iArr3 = iArr;
            int i2 = 0;
            while (i2 < c.this.f) {
                if (c.this.u(c.this.e[i2].f1673a) == gVar.e()) {
                    for (int i3 = i2 + 1; i3 < c.this.f; i3++) {
                        c.this.e[i3 - 1] = c.this.e[i3];
                    }
                    c.i(c.this);
                    i2--;
                }
                i2++;
            }
            gVar.a(iArr3, iArr3.length, iArr2, 1, c.this.k);
            int a2 = gVar.a() - 1;
            c.this.i[a2] = -65;
            for (int e = gVar.e(); e < a2; e++) {
                c.this.i[e] = 0;
            }
        }

        private void e(int i, int i2) {
            byte[] bArr = this.h;
            int i3 = this.i;
            int i4 = i3 + 1;
            this.i = i4;
            bArr[i3] = (byte) (251 - i);
            this.i = c.a(i2, bArr, i4);
        }

        private void a(int i, int i2) {
            g();
            d(i, i2);
        }

        private int b(int i, int i2) {
            if (i2 > 4) {
                throw new IllegalArgumentException("bad operand size");
            }
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                i3 = (i3 << 8) | (c.this.i[i + i4] & UByte.MAX_VALUE);
            }
            return i3;
        }

        private void c(int i, int i2) {
            a(i, i2, this.f1671a, this.b);
            a(i, i2, this.c, this.d);
        }

        private void d(int i, int i2) {
            int i3 = this.b;
            if (i >= i3) {
                int i4 = i + 1;
                int[] iArr = new int[i4];
                System.arraycopy(this.f1671a, 0, iArr, 0, i3);
                this.f1671a = iArr;
                this.b = i4;
            }
            this.f1671a[i] = i2;
        }

        private void a(int i, int i2, int[] iArr, int i3) {
            for (int i4 = 0; i4 < i3; i4++) {
                if (iArr[i4] == i) {
                    iArr[i4] = i2;
                }
            }
        }

        private int b(int[] iArr, int i) {
            while (i < iArr.length) {
                this.i = l(iArr[i]);
                i++;
            }
            return this.i;
        }

        private void a(long j) {
            j((int) (j & 16777215));
            long j2 = j >>> 32;
            if (j2 != 0) {
                j((int) (j2 & 16777215));
            }
        }

        int a(byte[] bArr, int i) {
            int a2 = c.a(this.g.length - 1, bArr, c.b(this.i + 2, bArr, i));
            System.arraycopy(this.h, 0, bArr, a2, this.i);
            return a2 + this.i;
        }

        private void a(int[] iArr, int i, int i2) {
            int length = iArr.length - i;
            byte[] bArr = this.h;
            int i3 = this.i;
            int i4 = i3 + 1;
            this.i = i4;
            bArr[i3] = (byte) (i + 251);
            this.i = c.a(i2, bArr, i4);
            this.i = b(iArr, length);
        }

        private void a(int[] iArr, int[] iArr2, int i) {
            byte[] bArr = this.h;
            int i2 = this.i;
            int i3 = i2 + 1;
            this.i = i3;
            bArr[i2] = -1;
            int a2 = c.a(i, bArr, i3);
            this.i = a2;
            this.i = c.a(iArr.length, this.h, a2);
            int a3 = a(iArr);
            this.i = a3;
            this.i = c.a(iArr2.length, this.h, a3);
            this.i = a(iArr2);
        }

        private void a(int[] iArr, int i) {
            if (i <= 63) {
                byte[] bArr = this.h;
                int i2 = this.i;
                this.i = i2 + 1;
                bArr[i2] = (byte) (i + 64);
            } else {
                byte[] bArr2 = this.h;
                int i3 = this.i;
                int i4 = i3 + 1;
                this.i = i4;
                bArr2[i3] = -9;
                this.i = c.a(i, bArr2, i4);
            }
            l(iArr[0]);
        }

        private int a(int[] iArr) {
            return b(iArr, 0);
        }
    }

    static {
        int i;
        InputStream inputStream = null;
        try {
            inputStream = c.class.getResourceAsStream("ClassFileWriter.class");
            if (inputStream == null) {
                inputStream = ClassLoader.getSystemResourceAsStream("external/sdk/pendo/io/mozilla/classfile/ClassFileWriter.class");
            }
            byte[] bArr = new byte[8];
            int i2 = 0;
            while (i2 < 8) {
                int read = inputStream.read(bArr, i2, 8 - i2);
                if (read < 0) {
                    throw new IOException();
                }
                i2 += read;
            }
            i = (bArr[4] << 8) | (bArr[5] & UByte.MAX_VALUE);
            try {
                int i3 = (bArr[7] & UByte.MAX_VALUE) | (bArr[6] << 8);
                F = i;
                E = i3;
                G = i3 >= 50;
                if (inputStream == null) {
                    return;
                }
            } catch (Exception unused) {
                F = i;
                E = 48;
                G = false;
                if (inputStream == null) {
                    return;
                }
                inputStream.close();
            } catch (Throwable th) {
                th = th;
                F = i;
                E = 48;
                G = false;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Exception unused3) {
            i = 0;
        } catch (Throwable th2) {
            th = th2;
            i = 0;
        }
        try {
            inputStream.close();
        } catch (IOException unused4) {
        }
    }

    public c(String str, String str2, String str3) {
        this.d = str;
        d dVar = new d(this);
        this.k = dVar;
        this.t = dVar.a(str);
        this.u = this.k.a(str2);
        if (str3 != null) {
            this.v = this.k.c(str3);
        }
        this.s = (short) 33;
    }

    static /* synthetic */ int i(c cVar) {
        int i = cVar.f;
        cVar.f = i - 1;
        return i;
    }

    private int m(int i) {
        if (this.l == null) {
            throw new IllegalArgumentException("No method to add to");
        }
        int i2 = this.j;
        int i3 = i + i2;
        byte[] bArr = this.i;
        if (i3 > bArr.length) {
            int length = bArr.length * 2;
            if (i3 > length) {
                length = i3;
            }
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, i2);
            this.i = bArr2;
        }
        this.j = i3;
        return i2;
    }

    private void n(int i) {
        if (G) {
            int[] iArr = this.f1669a;
            if (iArr == null) {
                this.f1669a = new int[4];
            } else {
                int length = iArr.length;
                int i2 = this.b;
                if (length == i2) {
                    int[] iArr2 = new int[i2 * 2];
                    System.arraycopy(iArr, 0, iArr2, 0, i2);
                    this.f1669a = iArr2;
                }
            }
            int[] iArr3 = this.f1669a;
            int i3 = this.b;
            this.b = i3 + 1;
            iArr3[i3] = i;
        }
    }

    private void o(int i) {
        this.i[m(1)] = (byte) i;
    }

    private void p(int i) {
        a(i, this.i, m(2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static char r(int i) {
        switch (i) {
            case 4:
                return Matrix.MATRIX_TYPE_ZERO;
            case 5:
                return 'C';
            case 6:
                return 'F';
            case 7:
                return 'D';
            case 8:
                return 'B';
            case 9:
                return 'S';
            case 10:
                return 'I';
            case 11:
                return 'J';
            default:
                throw new IllegalArgumentException("bad operand");
        }
    }

    private static void s(int i) {
        throw new IllegalStateException((i < 0 ? new StringBuilder("Stack underflow: ") : new StringBuilder("Too big stack: ")).append(i).toString());
    }

    private static int y(int i) {
        if (i == 254 || i == 255) {
            return 0;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
            case 131:
            case 133:
            case 134:
            case 135:
            case 136:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 144:
            case 145:
            case 146:
            case 147:
            case 148:
            case 149:
            case 150:
            case 151:
            case 152:
            case 172:
            case 173:
            case 174:
            case 175:
            case 176:
            case 177:
                return 0;
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case Token.LETEXPR /* 159 */:
            case 160:
            case Token.DEBUGGER /* 161 */:
            case Token.COMMENT /* 162 */:
            case Token.GENEXPR /* 163 */:
            case Token.METHOD /* 164 */:
            case Token.ARROW /* 165 */:
            case Token.YIELD_STAR /* 166 */:
            case Token.LAST_TOKEN /* 167 */:
            case 168:
            case 169:
            case 178:
            case 179:
            case 180:
            case 181:
            case 182:
            case 183:
            case 184:
            case 185:
                return 1;
            case 132:
                return 2;
            case Context.VERSION_1_7 /* 170 */:
            case 171:
                return -1;
            default:
                switch (i) {
                    case 187:
                    case 188:
                    case 189:
                    case 192:
                    case 193:
                    case 198:
                    case 199:
                    case 200:
                    case 201:
                        return 1;
                    case 190:
                    case 191:
                    case 194:
                    case 195:
                    case 196:
                    case 202:
                        return 0;
                    case 197:
                        return 2;
                    default:
                        throw new IllegalArgumentException("Bad opcode: " + i);
                }
        }
    }

    private static int z(int i) {
        if (i == 254 || i == 255) {
            return 0;
        }
        switch (i) {
            case 0:
            case 47:
            case 49:
            case 95:
            case 116:
            case 117:
            case 118:
            case 119:
            case 132:
            case 134:
            case 138:
            case 139:
            case 143:
            case 145:
            case 146:
            case 147:
            case Token.LAST_TOKEN /* 167 */:
            case 169:
            case 177:
            case 178:
            case 179:
            case 184:
            case 186:
            case 188:
            case 189:
            case 190:
            case 192:
            case 193:
            case 196:
            case 200:
            case 202:
                return 0;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 12:
            case 13:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 23:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 34:
            case 35:
            case 36:
            case 37:
            case 42:
            case 43:
            case 44:
            case 45:
            case 89:
            case 90:
            case 91:
            case 133:
            case 135:
            case 140:
            case 141:
            case 168:
            case 187:
            case 197:
            case 201:
                return 1;
            case 9:
            case 10:
            case 14:
            case 15:
            case 20:
            case 22:
            case 24:
            case 30:
            case 31:
            case 32:
            case 33:
            case 38:
            case 39:
            case 40:
            case 41:
            case 92:
            case 93:
            case 94:
                return 2;
            case 46:
            case 48:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 56:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 67:
            case 68:
            case 69:
            case 70:
            case 75:
            case 76:
            case 77:
            case 78:
            case 87:
            case 96:
            case 98:
            case 100:
            case 102:
            case 104:
            case 106:
            case 108:
            case 110:
            case 112:
            case 114:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 128:
            case 130:
            case 136:
            case 137:
            case 142:
            case 144:
            case 149:
            case 150:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case Context.VERSION_1_7 /* 170 */:
            case 171:
            case 172:
            case 174:
            case 176:
            case 180:
            case 181:
            case 182:
            case 183:
            case 185:
            case 191:
            case 194:
            case 195:
            case 198:
            case 199:
                return -1;
            case 55:
            case 57:
            case 63:
            case 64:
            case 65:
            case 66:
            case 71:
            case 72:
            case 73:
            case 74:
            case 88:
            case 97:
            case 99:
            case 101:
            case 103:
            case 105:
            case 107:
            case 109:
            case 111:
            case 113:
            case 115:
            case 127:
            case 129:
            case 131:
            case Token.LETEXPR /* 159 */:
            case 160:
            case Token.DEBUGGER /* 161 */:
            case Token.COMMENT /* 162 */:
            case Token.GENEXPR /* 163 */:
            case Token.METHOD /* 164 */:
            case Token.ARROW /* 165 */:
            case Token.YIELD_STAR /* 166 */:
            case 173:
            case 175:
                return -2;
            case 79:
            case 81:
            case 83:
            case 84:
            case 85:
            case 86:
            case 148:
            case 151:
            case 152:
                return -3;
            case 80:
            case 82:
                return -4;
            default:
                throw new IllegalArgumentException("Bad opcode: " + i);
        }
    }

    public void q(int i) {
        int i2 = this.m + i;
        if (i2 < 0 || 32767 < i2) {
            s(i2);
        }
        short s = (short) i2;
        this.m = s;
        if (i2 > this.n) {
            this.n = s;
        }
    }

    final char[] t(int i) {
        char[] cArr = this.D;
        if (i > cArr.length) {
            int length = cArr.length * 2;
            if (i <= length) {
                i = length;
            }
            this.D = new char[i];
        }
        return this.D;
    }

    public int u(int i) {
        if (i >= 0) {
            throw new IllegalArgumentException("Bad label, no biscuit");
        }
        int i2 = i & Integer.MAX_VALUE;
        if (i2 < this.x) {
            return this.w[i2];
        }
        throw new IllegalArgumentException("Bad label");
    }

    public void v(int i) {
        this.m = (short) 1;
        w(i);
    }

    public void w(int i) {
        if (i >= 0) {
            throw new IllegalArgumentException("Bad label, no biscuit");
        }
        int i2 = i & Integer.MAX_VALUE;
        if (i2 > this.x) {
            throw new IllegalArgumentException("Bad label");
        }
        int[] iArr = this.w;
        if (iArr[i2] != -1) {
            throw new IllegalStateException("Can only mark label once");
        }
        iArr[i2] = this.j;
    }

    public final void x(int i) {
        n(this.j);
        this.c.put(this.j, i);
        b(i, -1, this.j);
    }

    public void c(int i) {
        c(42, 25, i);
    }

    public void d(int i) {
        c(75, 58, i);
    }

    public void e(int i) {
        c(38, 24, i);
    }

    public void f(int i) {
        c(71, 57, i);
    }

    public void g(int i) {
        c(34, 23, i);
    }

    public void h(int i) {
        c(26, 21, i);
    }

    public void i(int i) {
        c(59, 54, i);
    }

    public void j(int i) {
        c(30, 22, i);
    }

    public void k(int i) {
        int i2;
        if (i == 0) {
            b(3);
            return;
        }
        if (i == 1) {
            b(4);
            return;
        }
        if (i == 2) {
            b(5);
            return;
        }
        if (i == 3) {
            i2 = 6;
        } else if (i == 4) {
            i2 = 7;
        } else {
            if (i != 5) {
                a(18, this.k.a(i));
                return;
            }
            i2 = 8;
        }
        b(i2);
    }

    public void l(int i) {
        int i2;
        byte b2;
        int i3 = (byte) i;
        if (i3 == i) {
            if (i == -1) {
                b2 = 2;
            } else if (i < 0 || i > 5) {
                i2 = 16;
            } else {
                b2 = (byte) (i + 3);
            }
            b((int) b2);
            return;
        }
        i3 = (short) i;
        if (i3 != i) {
            k(i);
            return;
        }
        i2 = 17;
        a(i2, i3);
    }

    private static String f(String str) {
        return str.substring(1, str.length() - 1);
    }

    public static String g(String str) {
        int length = str.length();
        int i = length + 1;
        int i2 = i + 1;
        char[] cArr = new char[i2];
        cArr[0] = Matrix.MATRIX_TYPE_RANDOM_LT;
        cArr[i] = ';';
        str.getChars(0, length, cArr, 1);
        for (int i3 = 1; i3 != i; i3++) {
            if (cArr[i3] == '.') {
                cArr[i3] = IOUtils.DIR_SEPARATOR_UNIX;
            }
        }
        return new String(cArr, 0, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String h(String str) {
        char charAt = str.charAt(0);
        if (charAt == 'F') {
            return str;
        }
        if (charAt == 'L') {
            return f(str);
        }
        if (charAt == 'S' || charAt == 'V' || charAt == 'I' || charAt == 'J' || charAt == 'Z' || charAt == '[') {
            return str;
        }
        switch (charAt) {
            case 'B':
            case 'C':
            case 'D':
                return str;
            default:
                throw new IllegalArgumentException("bad descriptor:" + str);
        }
    }

    static String i(String str) {
        return str.replace('.', IOUtils.DIR_SEPARATOR_UNIX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:44:0x0096. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:66:0x0042. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int j(java.lang.String r15) {
        /*
            int r0 = r15.length()
            r1 = 41
            int r1 = r15.lastIndexOf(r1)
            r2 = 3
            if (r2 > r0) goto Lab
            r2 = 0
            char r3 = r15.charAt(r2)
            r4 = 40
            if (r3 != r4) goto Lab
            r3 = 1
            if (r3 > r1) goto Lab
            int r4 = r1 + 1
            if (r4 >= r0) goto Lab
            r5 = r2
            r6 = r5
            r0 = r3
        L20:
            r7 = 91
            r8 = 90
            r9 = 74
            r10 = 73
            r11 = 83
            r12 = 76
            r13 = 70
            if (r0 == r1) goto L7d
            char r14 = r15.charAt(r0)
            if (r14 == r13) goto L77
            if (r14 == r12) goto L61
            if (r14 == r11) goto L77
            if (r14 == r10) goto L77
            if (r14 == r9) goto L5e
            if (r14 == r8) goto L77
            if (r14 == r7) goto L46
            switch(r14) {
                case 66: goto L77;
                case 67: goto L77;
                case 68: goto L5e;
                default: goto L45;
            }
        L45:
            goto L75
        L46:
            int r0 = r0 + r3
            char r14 = r15.charAt(r0)
            if (r14 != r7) goto L4e
            goto L46
        L4e:
            if (r14 == r13) goto L77
            if (r14 == r12) goto L61
            if (r14 == r11) goto L77
            if (r14 == r8) goto L77
            if (r14 == r10) goto L77
            if (r14 == r9) goto L77
            switch(r14) {
                case 66: goto L77;
                case 67: goto L77;
                case 68: goto L77;
                default: goto L5d;
            }
        L5d:
            goto L75
        L5e:
            int r5 = r5 + (-1)
            goto L77
        L61:
            int r5 = r5 + (-1)
            int r6 = r6 + 1
            int r0 = r0 + r3
            r14 = 59
            int r14 = r15.indexOf(r14, r0)
            int r0 = r0 + r3
            if (r0 > r14) goto L75
            if (r14 < r1) goto L72
            goto L75
        L72:
            int r0 = r14 + 1
            goto L20
        L75:
            r0 = r2
            goto L7e
        L77:
            int r5 = r5 + (-1)
            int r6 = r6 + 1
            int r0 = r0 + r3
            goto L20
        L7d:
            r0 = r3
        L7e:
            if (r0 == 0) goto Lab
            char r1 = r15.charAt(r4)
            if (r1 == r13) goto L9f
            if (r1 == r12) goto L9f
            if (r1 == r11) goto L9f
            r4 = 86
            if (r1 == r4) goto L9d
            if (r1 == r10) goto L9f
            if (r1 == r9) goto L9a
            if (r1 == r8) goto L9f
            if (r1 == r7) goto L9f
            switch(r1) {
                case 66: goto L9f;
                case 67: goto L9f;
                case 68: goto L9a;
                default: goto L99;
            }
        L99:
            goto La1
        L9a:
            int r5 = r5 + 1
            goto L9f
        L9d:
            r2 = r0
            goto La1
        L9f:
            int r5 = r5 + r3
            goto L9d
        La1:
            if (r2 == 0) goto Lab
            int r15 = r6 << 16
            r0 = 65535(0xffff, float:9.1834E-41)
            r0 = r0 & r5
            r15 = r15 | r0
            return r15
        Lab:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Bad parameter signature: "
            r1.<init>(r2)
            java.lang.StringBuilder r15 = r1.append(r15)
            java.lang.String r15 = r15.toString()
            r0.<init>(r15)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.v2.c.j(java.lang.String):int");
    }

    public void b(int i) {
        if (y(i) != 0) {
            throw new IllegalArgumentException("Unexpected operands");
        }
        int z = this.m + z(i);
        if (z < 0 || 32767 < z) {
            s(z);
        }
        o(i);
        short s = (short) z;
        this.m = s;
        if (z > this.n) {
            this.n = s;
        }
        if (i == 191) {
            n(this.j);
        }
    }

    public void c(String str) {
        this.r.add(Short.valueOf(this.k.a(str)));
    }

    public void d(String str) {
        a(18, this.k.b(str));
    }

    public void e(String str) {
        int length = str.length();
        int i = 0;
        int a2 = this.k.a(str, 0, length);
        if (a2 == length) {
            d(str);
            return;
        }
        a(187, "java/lang/StringBuilder");
        b(89);
        l(length);
        b(183, "java/lang/StringBuilder", "<init>", "(I)V");
        while (true) {
            int i2 = i;
            i = a2;
            b(89);
            d(str.substring(i2, i));
            b(182, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
            b(87);
            if (i == length) {
                b(182, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
                return;
            }
            a2 = this.k.a(str, i, length);
        }
    }

    private void d() {
        if (G) {
            for (int i = 0; i < this.f; i++) {
                n(u(this.e[i].c));
            }
            Arrays.sort(this.f1669a, 0, this.b);
            int i2 = this.f1669a[0];
            int i3 = 1;
            for (int i4 = 1; i4 < this.b; i4++) {
                int[] iArr = this.f1669a;
                int i5 = iArr[i4];
                if (i2 != i5) {
                    if (i3 != i4) {
                        iArr[i3] = i5;
                    }
                    i3++;
                    i2 = i5;
                }
            }
            this.b = i3;
            int i6 = i3 - 1;
            if (this.f1669a[i6] == this.j) {
                this.b = i6;
            }
        }
    }

    private void e() {
        byte[] bArr = this.i;
        for (int i = 0; i < this.z; i++) {
            long j = this.y[i];
            int i2 = (int) (j >> 32);
            int i3 = (int) j;
            int i4 = this.w[i2];
            if (i4 == -1) {
                throw new RuntimeException("unlocated label");
            }
            n(i4);
            int i5 = i3 - 1;
            this.c.put(i4, i5);
            int i6 = i4 - i5;
            if (((short) i6) != i6) {
                throw new b("Program too complex: too big jump offset");
            }
            bArr[i3] = (byte) (i6 >> 8);
            bArr[i3 + 1] = (byte) i6;
        }
        this.z = 0;
    }

    private int i() {
        if (this.v != 0) {
            this.k.c("SourceFile");
        }
        int a2 = this.k.a() + 8 + 2 + 2 + 2 + 2 + (this.r.size() * 2) + 2;
        for (int i = 0; i < this.q.size(); i++) {
            a2 += ((sdk.pendo.io.v2.a) this.q.get(i)).a();
        }
        int i2 = a2 + 2;
        for (int i3 = 0; i3 < this.p.size(); i3++) {
            i2 += ((sdk.pendo.io.v2.b) this.p.get(i3)).d();
        }
        int i4 = i2 + 2;
        if (this.v != 0) {
            i4 = i4 + 2 + 4 + 2;
        }
        return this.B != null ? i4 + 2 + 4 + 2 + this.C : i4;
    }

    public void b(int i, String str, String str2, String str3) {
        int j = j(str3);
        int i2 = j >>> 16;
        int z = this.m + ((short) j) + z(i);
        if (z < 0 || 32767 < z) {
            s(z);
        }
        switch (i) {
            case 182:
            case 183:
            case 184:
            case 185:
                o(i);
                if (i == 185) {
                    p(this.k.b(str, str2, str3));
                    o(i2 + 1);
                    o(0);
                } else {
                    p(this.k.c(str, str2, str3));
                }
                short s = (short) z;
                this.m = s;
                if (z > this.n) {
                    this.n = s;
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException("bad opcode for method reference");
        }
    }

    public int c(int i, int i2) {
        if (i > i2) {
            throw new b("Bad bounds: " + i + ' ' + i2);
        }
        int z = this.m + z(Context.VERSION_1_7);
        if (z < 0 || 32767 < z) {
            s(z);
        }
        int i3 = (~this.j) & 3;
        int m = m(i3 + 1 + (((i2 - i) + 1 + 3) * 4));
        int i4 = m + 1;
        this.i[m] = -86;
        while (i3 != 0) {
            this.i[i4] = 0;
            i3--;
            i4++;
        }
        b(i2, this.i, b(i, this.i, i4 + 4));
        short s = (short) z;
        this.m = s;
        if (z > this.n) {
            this.n = s;
        }
        return m;
    }

    public final String f() {
        return this.d;
    }

    public int g() {
        return this.j;
    }

    public short h() {
        return this.m;
    }

    public byte[] j() {
        short s;
        int i;
        short s2;
        if (this.B != null) {
            s = this.k.c("BootstrapMethods");
            i = 1;
        } else {
            s = 0;
            i = 0;
        }
        if (this.v != 0) {
            i++;
            s2 = this.k.c("SourceFile");
        } else {
            s2 = 0;
        }
        int i2 = i();
        byte[] bArr = new byte[i2];
        int a2 = a(this.r.size(), bArr, a((int) this.u, bArr, a((int) this.t, bArr, a((int) this.s, bArr, this.k.a(bArr, a(E, bArr, a(F, bArr, b(-889275714, bArr, 0))))))));
        for (int i3 = 0; i3 < this.r.size(); i3++) {
            a2 = a((int) ((Short) this.r.get(i3)).shortValue(), bArr, a2);
        }
        int a3 = a(this.q.size(), bArr, a2);
        for (int i4 = 0; i4 < this.q.size(); i4++) {
            a3 = ((sdk.pendo.io.v2.a) this.q.get(i4)).a(bArr, a3);
        }
        int a4 = a(this.p.size(), bArr, a3);
        for (int i5 = 0; i5 < this.p.size(); i5++) {
            a4 = ((sdk.pendo.io.v2.b) this.p.get(i5)).a(bArr, a4);
        }
        int a5 = a(i, bArr, a4);
        if (this.B != null) {
            a5 = a(this.B.size(), bArr, b(this.C + 2, bArr, a((int) s, bArr, a5)));
            for (int i6 = 0; i6 < this.B.size(); i6++) {
                a aVar = (a) this.B.get(i6);
                byte[] bArr2 = aVar.f1670a;
                System.arraycopy(bArr2, 0, bArr, a5, bArr2.length);
                a5 += aVar.f1670a.length;
            }
        }
        if (this.v != 0) {
            a5 = a((int) this.v, bArr, b(2, bArr, a((int) s2, bArr, a5)));
        }
        if (a5 == i2) {
            return bArr;
        }
        throw new RuntimeException();
    }

    private void b(int i, int i2) {
        if (i >= 0) {
            throw new IllegalArgumentException("Bad label, no biscuit");
        }
        int i3 = i & Integer.MAX_VALUE;
        if (i3 >= this.x) {
            throw new IllegalArgumentException("Bad label");
        }
        int i4 = this.z;
        long[] jArr = this.y;
        if (jArr == null || i4 == jArr.length) {
            if (jArr == null) {
                this.y = new long[40];
            } else {
                long[] jArr2 = new long[jArr.length * 2];
                System.arraycopy(jArr, 0, jArr2, 0, i4);
                this.y = jArr2;
            }
        }
        this.z = i4 + 1;
        this.y[i4] = i2 | (i3 << 32);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int[] c() {
        /*
            r10 = this;
            short r0 = r10.o
            int[] r0 = new int[r0]
            sdk.pendo.io.v2.b r1 = r10.l
            short r1 = r1.a()
            r1 = r1 & 8
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L2c
            sdk.pendo.io.v2.b r1 = r10.l
            java.lang.String r1 = r1.b()
            java.lang.String r4 = "<init>"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L22
            r1 = 6
            r0[r3] = r1
            goto L2a
        L22:
            short r1 = r10.t
            int r1 = sdk.pendo.io.v2.h.a(r1)
            r0[r3] = r1
        L2a:
            r1 = r2
            goto L2d
        L2c:
            r1 = r3
        L2d:
            sdk.pendo.io.v2.b r4 = r10.l
            java.lang.String r4 = r4.c()
            r5 = 40
            int r5 = r4.indexOf(r5)
            r6 = 41
            int r6 = r4.indexOf(r6)
            if (r5 != 0) goto Lae
            if (r6 < 0) goto Lae
            int r5 = r5 + r2
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
        L49:
            if (r5 >= r6) goto Lad
            char r8 = r4.charAt(r5)
            r9 = 70
            if (r8 == r9) goto L85
            r9 = 76
            if (r8 == r9) goto L75
            r9 = 83
            if (r8 == r9) goto L85
            r9 = 73
            if (r8 == r9) goto L85
            r9 = 74
            if (r8 == r9) goto L85
            r9 = 90
            if (r8 == r9) goto L85
            r9 = 91
            if (r8 == r9) goto L6f
            switch(r8) {
                case 66: goto L85;
                case 67: goto L85;
                case 68: goto L85;
                default: goto L6e;
            }
        L6e:
            goto L8e
        L6f:
            r7.append(r9)
            int r5 = r5 + 1
            goto L49
        L75:
            r8 = 59
            int r8 = r4.indexOf(r8, r5)
            int r8 = r8 + r2
            java.lang.String r5 = r4.substring(r5, r8)
            r7.append(r5)
            r5 = r8
            goto L8e
        L85:
            char r8 = r4.charAt(r5)
            r7.append(r8)
            int r5 = r5 + 1
        L8e:
            java.lang.String r8 = r7.toString()
            java.lang.String r8 = h(r8)
            sdk.pendo.io.v2.d r9 = r10.k
            int r8 = sdk.pendo.io.v2.h.b(r8, r9)
            int r9 = r1 + 1
            r0[r1] = r8
            boolean r1 = sdk.pendo.io.v2.h.e(r8)
            if (r1 == 0) goto La8
            int r9 = r9 + 1
        La8:
            r1 = r9
            r7.setLength(r3)
            goto L49
        Lad:
            return r0
        Lae:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "bad method type"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.v2.c.c():int[]");
    }

    public int a() {
        int i = this.x;
        int[] iArr = this.w;
        if (iArr == null || i == iArr.length) {
            if (iArr == null) {
                this.w = new int[32];
            } else {
                int[] iArr2 = new int[iArr.length * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                this.w = iArr2;
            }
        }
        this.x = i + 1;
        this.w[i] = -1;
        return i | Integer.MIN_VALUE;
    }

    public final void d(int i, int i2) {
        n(this.j);
        this.c.put(this.j, i);
        b(i, i2, this.j);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0078 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r6, int r7) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.v2.c.a(int, int):void");
    }

    public void b() {
        b(42);
    }

    public void c(short s) {
        C0247c c0247c;
        int a2;
        int c;
        if (this.l == null) {
            throw new IllegalStateException("No method to stop");
        }
        e();
        this.o = s;
        if (G) {
            d();
            c0247c = new C0247c();
            c0247c.e();
        } else {
            c0247c = null;
        }
        int i = this.g != null ? (this.h * 4) + 8 : 0;
        ObjArray objArray = this.A;
        int size = objArray != null ? (objArray.size() * 10) + 8 : 0;
        int i2 = (c0247c == null || (c = c0247c.c()) <= 0) ? 0 : c + 6;
        int i3 = this.j + 14 + 2 + (this.f * 8) + 2 + i + size + i2;
        if (i3 > 65536) {
            throw new b("generated bytecode for method exceeds 64K limit.");
        }
        byte[] bArr = new byte[i3];
        int b2 = b(this.j, bArr, a((int) this.o, bArr, a((int) this.n, bArr, b(i3 - 6, bArr, a((int) this.k.c("Code"), bArr, 0)))));
        System.arraycopy(this.i, 0, bArr, b2, this.j);
        int i4 = b2 + this.j;
        int i5 = this.f;
        if (i5 > 0) {
            a2 = a(i5, bArr, i4);
            for (int i6 = 0; i6 < this.f; i6++) {
                e eVar = this.e[i6];
                int u = u(eVar.f1673a);
                int u2 = u(eVar.b);
                int u3 = u(eVar.c);
                short s2 = eVar.d;
                if (u == -1) {
                    throw new IllegalStateException("start label not defined");
                }
                if (u2 == -1) {
                    throw new IllegalStateException("end label not defined");
                }
                if (u3 == -1) {
                    throw new IllegalStateException("handler label not defined");
                }
                a2 = a((int) s2, bArr, a(u3, bArr, a(u2, bArr, a(u, bArr, a2))));
            }
        } else {
            a2 = a(0, bArr, i4);
        }
        int i7 = this.g != null ? 1 : 0;
        if (this.A != null) {
            i7++;
        }
        if (i2 > 0) {
            i7++;
        }
        int a3 = a(i7, bArr, a2);
        if (this.g != null) {
            a3 = a(this.h, bArr, b((this.h * 4) + 2, bArr, a((int) this.k.c("LineNumberTable"), bArr, a3)));
            for (int i8 = 0; i8 < this.h; i8++) {
                a3 = b(this.g[i8], bArr, a3);
            }
        }
        if (this.A != null) {
            int a4 = a((int) this.k.c("LocalVariableTable"), bArr, a3);
            int size2 = this.A.size();
            a3 = a(size2, bArr, b((size2 * 10) + 2, bArr, a4));
            for (int i9 = 0; i9 < size2; i9++) {
                int[] iArr = (int[]) this.A.get(i9);
                int i10 = iArr[0];
                int i11 = iArr[1];
                int i12 = iArr[2];
                a3 = a(iArr[3], bArr, a(i11, bArr, a(i10, bArr, a(this.j - i12, bArr, a(i12, bArr, a3)))));
            }
        }
        if (i2 > 0) {
            c0247c.a(bArr, a((int) this.k.c("StackMapTable"), bArr, a3));
        }
        this.l.a(bArr);
        this.e = null;
        this.f = 0;
        this.h = 0;
        this.j = 0;
        this.l = null;
        this.n = (short) 0;
        this.m = (short) 0;
        this.x = 0;
        this.z = 0;
        this.A = null;
        this.f1669a = null;
        this.b = 0;
        this.c = null;
    }

    private void c(int i, int i2, int i3) {
        if (i3 != 0) {
            int i4 = 1;
            if (i3 != 1) {
                i4 = 2;
                if (i3 != 2) {
                    i4 = 3;
                    if (i3 != 3) {
                        a(i2, i3);
                        return;
                    }
                }
            }
            i += i4;
        }
        b(i);
    }

    public void a(int i, String str) {
        int z = this.m + z(i);
        if (z < 0 || 32767 < z) {
            s(z);
        }
        if (i != 187 && i != 189 && i != 192 && i != 193) {
            throw new IllegalArgumentException("bad opcode for class reference");
        }
        short a2 = this.k.a(str);
        o(i);
        p(a2);
        short s = (short) z;
        this.m = s;
        if (z > this.n) {
            this.n = s;
        }
    }

    public void b(double d) {
        if (d == 0.0d) {
            b(14);
            if (1.0d / d >= 0.0d) {
                return;
            }
        } else if (d != 1.0d && d != -1.0d) {
            a(d);
            return;
        } else {
            b(15);
            if (d >= 0.0d) {
                return;
            }
        }
        b(119);
    }

    public void a(int i, String str, String str2, String str3) {
        int i2;
        int z = this.m + z(i);
        char charAt = str3.charAt(0);
        int i3 = (charAt == 'J' || charAt == 'D') ? 2 : 1;
        switch (i) {
            case 178:
            case 180:
                i2 = z + i3;
                break;
            case 179:
            case 181:
                i2 = z - i3;
                break;
            default:
                throw new IllegalArgumentException("bad opcode for field reference");
        }
        if (i2 < 0 || 32767 < i2) {
            s(i2);
        }
        short a2 = this.k.a(str, str2, str3);
        o(i);
        p(a2);
        short s = (short) i2;
        this.m = s;
        if (i2 > this.n) {
            this.n = s;
        }
    }

    public void b(long j) {
        int i = (int) j;
        if (i != j) {
            a(j);
        } else {
            l(i);
            b(133);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0031 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0033 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int b(int r3, boolean r4) {
        /*
            r0 = 254(0xfe, float:3.56E-43)
            if (r3 == r0) goto L34
            r0 = 255(0xff, float:3.57E-43)
            if (r3 == r0) goto L34
            r0 = 5
            r1 = 2
            r2 = 3
            switch(r3) {
                case 0: goto L34;
                case 1: goto L34;
                case 2: goto L34;
                case 3: goto L34;
                case 4: goto L34;
                case 5: goto L34;
                case 6: goto L34;
                case 7: goto L34;
                case 8: goto L34;
                case 9: goto L34;
                case 10: goto L34;
                case 11: goto L34;
                case 12: goto L34;
                case 13: goto L34;
                case 14: goto L34;
                case 15: goto L34;
                case 16: goto L31;
                case 17: goto L33;
                case 18: goto L31;
                case 19: goto L33;
                case 20: goto L33;
                case 21: goto L2b;
                case 22: goto L2b;
                case 23: goto L2b;
                case 24: goto L2b;
                case 25: goto L2b;
                case 26: goto L34;
                case 27: goto L34;
                case 28: goto L34;
                case 29: goto L34;
                case 30: goto L34;
                case 31: goto L34;
                case 32: goto L34;
                case 33: goto L34;
                case 34: goto L34;
                case 35: goto L34;
                case 36: goto L34;
                case 37: goto L34;
                case 38: goto L34;
                case 39: goto L34;
                case 40: goto L34;
                case 41: goto L34;
                case 42: goto L34;
                case 43: goto L34;
                case 44: goto L34;
                case 45: goto L34;
                case 46: goto L34;
                case 47: goto L34;
                case 48: goto L34;
                case 49: goto L34;
                case 50: goto L34;
                case 51: goto L34;
                case 52: goto L34;
                case 53: goto L34;
                case 54: goto L2b;
                case 55: goto L2b;
                case 56: goto L2b;
                case 57: goto L2b;
                case 58: goto L2b;
                case 59: goto L34;
                case 60: goto L34;
                case 61: goto L34;
                case 62: goto L34;
                case 63: goto L34;
                case 64: goto L34;
                case 65: goto L34;
                case 66: goto L34;
                case 67: goto L34;
                case 68: goto L34;
                case 69: goto L34;
                case 70: goto L34;
                case 71: goto L34;
                case 72: goto L34;
                case 73: goto L34;
                case 74: goto L34;
                case 75: goto L34;
                case 76: goto L34;
                case 77: goto L34;
                case 78: goto L34;
                case 79: goto L34;
                case 80: goto L34;
                case 81: goto L34;
                case 82: goto L34;
                case 83: goto L34;
                case 84: goto L34;
                case 85: goto L34;
                case 86: goto L34;
                case 87: goto L34;
                case 88: goto L34;
                case 89: goto L34;
                case 90: goto L34;
                case 91: goto L34;
                case 92: goto L34;
                case 93: goto L34;
                case 94: goto L34;
                case 95: goto L34;
                case 96: goto L34;
                case 97: goto L34;
                case 98: goto L34;
                case 99: goto L34;
                case 100: goto L34;
                case 101: goto L34;
                case 102: goto L34;
                case 103: goto L34;
                case 104: goto L34;
                case 105: goto L34;
                case 106: goto L34;
                case 107: goto L34;
                case 108: goto L34;
                case 109: goto L34;
                case 110: goto L34;
                case 111: goto L34;
                case 112: goto L34;
                case 113: goto L34;
                case 114: goto L34;
                case 115: goto L34;
                case 116: goto L34;
                case 117: goto L34;
                case 118: goto L34;
                case 119: goto L34;
                case 120: goto L34;
                case 121: goto L34;
                case 122: goto L34;
                case 123: goto L34;
                case 124: goto L34;
                case 125: goto L34;
                case 126: goto L34;
                case 127: goto L34;
                case 128: goto L34;
                case 129: goto L34;
                case 130: goto L34;
                case 131: goto L34;
                case 132: goto L26;
                case 133: goto L34;
                case 134: goto L34;
                case 135: goto L34;
                case 136: goto L34;
                case 137: goto L34;
                case 138: goto L34;
                case 139: goto L34;
                case 140: goto L34;
                case 141: goto L34;
                case 142: goto L34;
                case 143: goto L34;
                case 144: goto L34;
                case 145: goto L34;
                case 146: goto L34;
                case 147: goto L34;
                case 148: goto L34;
                case 149: goto L34;
                case 150: goto L34;
                case 151: goto L34;
                case 152: goto L34;
                case 153: goto L33;
                case 154: goto L33;
                case 155: goto L33;
                case 156: goto L33;
                case 157: goto L33;
                case 158: goto L33;
                case 159: goto L33;
                case 160: goto L33;
                case 161: goto L33;
                case 162: goto L33;
                case 163: goto L33;
                case 164: goto L33;
                case 165: goto L33;
                case 166: goto L33;
                case 167: goto L33;
                case 168: goto L33;
                case 169: goto L2b;
                default: goto Le;
            }
        Le:
            switch(r3) {
                case 172: goto L34;
                case 173: goto L34;
                case 174: goto L34;
                case 175: goto L34;
                case 176: goto L34;
                case 177: goto L34;
                case 178: goto L33;
                case 179: goto L33;
                case 180: goto L33;
                case 181: goto L33;
                case 182: goto L33;
                case 183: goto L33;
                case 184: goto L33;
                case 185: goto L32;
                case 186: goto L32;
                case 187: goto L33;
                case 188: goto L31;
                case 189: goto L33;
                case 190: goto L34;
                case 191: goto L34;
                case 192: goto L33;
                case 193: goto L33;
                case 194: goto L34;
                case 195: goto L34;
                case 196: goto L34;
                case 197: goto L2f;
                case 198: goto L33;
                case 199: goto L33;
                case 200: goto L32;
                case 201: goto L32;
                case 202: goto L34;
                default: goto L11;
            }
        L11:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Bad opcode: "
            r0.<init>(r1)
            java.lang.StringBuilder r3 = r0.append(r3)
            java.lang.String r3 = r3.toString()
            r4.<init>(r3)
            throw r4
        L26:
            if (r4 == 0) goto L29
            goto L2a
        L29:
            r0 = r2
        L2a:
            return r0
        L2b:
            if (r4 == 0) goto L2e
            r1 = r2
        L2e:
            return r1
        L2f:
            r3 = 4
            return r3
        L31:
            return r1
        L32:
            return r0
        L33:
            return r2
        L34:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.v2.c.b(int, boolean):int");
    }

    public void a(int i, int i2, int i3, String str) {
        if ((i & Integer.MIN_VALUE) != Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Bad startLabel");
        }
        if ((i2 & Integer.MIN_VALUE) != Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Bad endLabel");
        }
        if ((i3 & Integer.MIN_VALUE) != Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Bad handlerLabel");
        }
        e eVar = new e(i, i2, i3, str == null ? (short) 0 : this.k.a(str));
        int i4 = this.f;
        if (i4 == 0) {
            this.e = new e[4];
        } else {
            e[] eVarArr = this.e;
            if (i4 == eVarArr.length) {
                e[] eVarArr2 = new e[i4 * 2];
                System.arraycopy(eVarArr, 0, eVarArr2, 0, i4);
                this.e = eVarArr2;
            }
        }
        this.e[i4] = eVar;
        this.f = i4 + 1;
    }

    static int b(int i, byte[] bArr, int i2) {
        bArr[i2 + 0] = (byte) (i >>> 24);
        bArr[i2 + 1] = (byte) (i >>> 16);
        bArr[i2 + 2] = (byte) (i >>> 8);
        bArr[i2 + 3] = (byte) i;
        return i2 + 4;
    }

    public void a(String str, String str2, short s) {
        this.q.add(new sdk.pendo.io.v2.a(this.k.c(str), this.k.c(str2), s));
    }

    public void a(short s) {
        if (this.l == null) {
            throw new IllegalArgumentException("No method to stop");
        }
        int i = this.h;
        if (i == 0) {
            this.g = new int[16];
        } else {
            int[] iArr = this.g;
            if (i == iArr.length) {
                int[] iArr2 = new int[i * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                this.g = iArr2;
            }
        }
        this.g[i] = (this.j << 16) + s;
        this.h = i + 1;
    }

    public void b(short s) {
        this.m = s;
    }

    public void a(double d) {
        a(20, this.k.a(d));
    }

    public void b(int i, int i2, int i3) {
        int i4;
        if (i3 < 0 || (i4 = this.j) < i3) {
            throw new IllegalArgumentException("Bad jump target: " + i3);
        }
        if (i2 < -1) {
            throw new IllegalArgumentException("Bad case index: " + i2);
        }
        int i5 = i + 1 + ((~i) & 3);
        if (i2 >= 0) {
            i5 += (i2 + 3) * 4;
        }
        if (i < 0 || ((i4 - 16) - r1) - 1 < i) {
            throw new IllegalArgumentException(i + " is outside a possible range of tableswitch in already generated code");
        }
        byte[] bArr = this.i;
        if ((bArr[i] & UByte.MAX_VALUE) != 170) {
            throw new IllegalArgumentException(i + " is not offset of tableswitch statement");
        }
        if (i5 < 0 || i4 < i5 + 4) {
            throw new b("Too big case index: " + i2);
        }
        b(i3 - i, bArr, i5);
    }

    public void a(long j) {
        a(20, this.k.a(j));
    }

    public void b(String str, String str2, short s) {
        this.l = new sdk.pendo.io.v2.b(str, this.k.c(str), str2, this.k.c(str2), s);
        this.c = new UintMap();
        this.p.add(this.l);
        n(0);
    }

    public void a(boolean z) {
        b(z ? 4 : 3);
    }

    public void a(String str, String str2, int i, int i2) {
        int[] iArr = {this.k.c(str), this.k.c(str2), i, i2};
        if (this.A == null) {
            this.A = new ObjArray();
        }
        this.A.add(iArr);
    }

    public void a(int i, short s) {
        w(i);
        this.m = s;
    }

    public final void a(int i, int i2, int i3) {
        if (i3 < 0 || i3 > this.n) {
            throw new IllegalArgumentException("Bad stack index: " + i3);
        }
        this.m = (short) i3;
        n(this.j);
        this.c.put(this.j, i);
        b(i, i2, this.j);
    }

    static int a(int i, byte[] bArr, int i2) {
        bArr[i2 + 0] = (byte) (i >>> 8);
        bArr[i2 + 1] = (byte) i;
        return i2 + 2;
    }

    static int a(long j, byte[] bArr, int i) {
        return b((int) j, bArr, b((int) (j >>> 32), bArr, i));
    }
}
