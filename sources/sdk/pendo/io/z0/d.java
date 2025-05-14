package sdk.pendo.io.z0;

import java.io.Reader;
import java.math.BigInteger;
import kotlin.text.Typography;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.CharUtils;

/* loaded from: classes4.dex */
class d {
    private static final int[] o = {0, 0, 1, 1};
    private static final char[] p = a("\t\u0000\u0001\u0007\u0001\u0007\u0002\u0000\u0001\u0007\u0012\u0000\u0001\u0007\u0001\u0000\u0001\t\b\u0000\u0001\u0006\u0001\u0019\u0001\u0002\u0001\u0004\u0001\n\n\u0003\u0001\u001a\u0006\u0000\u0004\u0001\u0001\u0005\u0001\u0001\u0014\u0000\u0001\u0017\u0001\b\u0001\u0018\u0003\u0000\u0001\u0012\u0001\u000b\u0002\u0001\u0001\u0011\u0001\f\u0005\u0000\u0001\u0013\u0001\u0000\u0001\r\u0003\u0000\u0001\u000e\u0001\u0014\u0001\u000f\u0001\u0010\u0005\u0000\u0001\u0015\u0001\u0000\u0001\u0016ﾂ\u0000");
    private static final int[] q = e();
    private static final int[] r = g();
    private static final int[] s = {2, 2, 3, 4, 2, 2, 2, 5, 2, 6, 2, 2, 7, 8, 2, 9, 2, 2, 2, 2, 2, 10, 11, 12, 13, 14, 15, 16, 16, 16, 16, 16, 16, 16, 16, 17, 18, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 4, 19, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 5, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 21, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 22, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 23, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 16, 16, 16, 16, 16, 16, 16, 16, -1, -1, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, -1, -1, -1, -1, -1, -1, -1, -1, 24, 25, 26, 27, 28, 29, 30, 31, 32, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 33, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 34, 35, -1, -1, 34, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 37, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 38, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 39, -1, 39, -1, 39, -1, -1, -1, -1, -1, 39, 39, -1, -1, -1, -1, 39, 39, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 33, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 35, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 38, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 40, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 41, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 42, -1, 42, -1, 42, -1, -1, -1, -1, -1, 42, 42, -1, -1, -1, -1, 42, 42, -1, -1, -1, -1, -1, -1, -1, -1, -1, 43, -1, 43, -1, 43, -1, -1, -1, -1, -1, 43, 43, -1, -1, -1, -1, 43, 43, -1, -1, -1, -1, -1, -1, -1, -1, -1, 44, -1, 44, -1, 44, -1, -1, -1, -1, -1, 44, 44, -1, -1, -1, -1, 44, 44, -1, -1, -1, -1, -1, -1, -1, -1};
    private static final String[] t = {"Unkown internal scanner error", "Error: could not match input", "Error: pushback value was too large"};
    private static final int[] u = f();

    /* renamed from: a, reason: collision with root package name */
    private Reader f1865a;
    private int b;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private boolean m;
    private int c = 0;
    private char[] d = new char[16384];
    private boolean l = true;
    private StringBuilder n = new StringBuilder();

    d(Reader reader) {
        this.f1865a = reader;
    }

    private boolean d() {
        int read;
        int i = this.g;
        if (i > 0) {
            char[] cArr = this.d;
            System.arraycopy(cArr, i, cArr, 0, this.h - i);
            int i2 = this.h;
            int i3 = this.g;
            this.h = i2 - i3;
            this.f -= i3;
            this.e -= i3;
            this.g = 0;
        }
        int i4 = this.f;
        char[] cArr2 = this.d;
        if (i4 >= cArr2.length) {
            char[] cArr3 = new char[i4 * 2];
            System.arraycopy(cArr2, 0, cArr3, 0, cArr2.length);
            this.d = cArr3;
        }
        Reader reader = this.f1865a;
        char[] cArr4 = this.d;
        int i5 = this.h;
        int read2 = reader.read(cArr4, i5, cArr4.length - i5);
        if (read2 > 0) {
            this.h += read2;
            return false;
        }
        if (read2 != 0 || (read = this.f1865a.read()) == -1) {
            return true;
        }
        char[] cArr5 = this.d;
        int i6 = this.h;
        this.h = i6 + 1;
        cArr5[i6] = (char) read;
        return false;
    }

    private static int[] e() {
        int[] iArr = new int[45];
        a("\u0002\u0000\u0002\u0001\u0001\u0002\u0001\u0003\u0001\u0004\u0003\u0001\u0001\u0005\u0001\u0006\u0001\u0007\u0001\b\u0001\t\u0001\n\u0001\u000b\u0001\f\u0001\r\u0005\u0000\u0001\f\u0001\u000e\u0001\u000f\u0001\u0010\u0001\u0011\u0001\u0012\u0001\u0013\u0001\u0014\u0001\u0000\u0001\u0015\u0001\u0000\u0001\u0015\u0004\u0000\u0001\u0016\u0001\u0017\u0002\u0000\u0001\u0018", 0, iArr);
        return iArr;
    }

    private static int[] f() {
        int[] iArr = new int[45];
        b("\u0002\u0000\u0001\t\u0003\u0001\u0001\t\u0003\u0001\u0006\t\u0002\u0001\u0001\t\u0005\u0000\b\t\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0004\u0000\u0002\t\u0002\u0000\u0001\t", 0, iArr);
        return iArr;
    }

    private static int[] g() {
        int[] iArr = new int[45];
        c("\u0000\u0000\u0000\u001b\u00006\u0000Q\u0000l\u0000\u0087\u00006\u0000¢\u0000½\u0000Ø\u00006\u00006\u00006\u00006\u00006\u00006\u0000ó\u0000Ď\u00006\u0000ĩ\u0000ń\u0000ş\u0000ź\u0000ƕ\u00006\u00006\u00006\u00006\u00006\u00006\u00006\u00006\u0000ư\u0000ǋ\u0000Ǧ\u0000Ǧ\u0000ȁ\u0000Ȝ\u0000ȷ\u0000ɒ\u00006\u00006\u0000ɭ\u0000ʈ\u00006", 0, iArr);
        return iArr;
    }

    int a() {
        return this.j;
    }

    public final char b(int i) {
        return this.d[this.g + i];
    }

    public final String c() {
        char[] cArr = this.d;
        int i = this.g;
        return new String(cArr, i, this.e - i);
    }

    private void c(int i) {
        String str;
        try {
            str = t[i];
        } catch (ArrayIndexOutOfBoundsException unused) {
            str = t[0];
        }
        throw new Error(str);
    }

    public final void a(int i) {
        this.c = i;
    }

    public e b() {
        char c;
        int i;
        StringBuilder sb;
        char c2;
        int i2 = this.h;
        char[] cArr = this.d;
        char[] cArr2 = p;
        int[] iArr = s;
        int[] iArr2 = r;
        int[] iArr3 = u;
        while (true) {
            int i3 = this.e;
            this.j += i3 - this.g;
            this.g = i3;
            this.f = i3;
            this.b = o[this.c];
            char c3 = 65535;
            int i4 = i3;
            int i5 = -1;
            while (true) {
                if (i3 < i2) {
                    i = i3 + 1;
                    c = cArr[i3];
                } else if (this.m) {
                    c = c3;
                } else {
                    this.f = i3;
                    this.e = i4;
                    boolean d = d();
                    int i6 = this.f;
                    i4 = this.e;
                    char[] cArr3 = this.d;
                    int i7 = this.h;
                    if (d) {
                        cArr = cArr3;
                        c = c3;
                        i2 = i7;
                    } else {
                        i = i6 + 1;
                        i2 = i7;
                        c = cArr3[i6];
                        cArr = cArr3;
                    }
                }
                int i8 = iArr[iArr2[this.b] + cArr2[c]];
                if (i8 != c3) {
                    this.b = i8;
                    int i9 = iArr3[i8];
                    if ((i9 & 1) != 1) {
                        c3 = 65535;
                    } else if ((i9 & 8) == 8) {
                        i4 = i;
                        i5 = i8;
                    } else {
                        c3 = 65535;
                        i4 = i;
                        i5 = i8;
                    }
                    i3 = i;
                }
            }
            this.e = i4;
            if (i5 >= 0) {
                i5 = q[i5];
            }
            switch (i5) {
                case 1:
                    throw new c(this.j, 0, new Character(b(0)));
                case 2:
                    String c4 = c();
                    try {
                        return new e(0, Long.valueOf(c4));
                    } catch (NumberFormatException unused) {
                        return new e(0, new BigInteger(c4));
                    }
                case 3:
                case 25:
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
                case 4:
                    this.n = null;
                    this.n = new StringBuilder();
                    a(2);
                    continue;
                case 5:
                    return new e(1, null);
                case 6:
                    return new e(2, null);
                case 7:
                    return new e(3, null);
                case 8:
                    return new e(4, null);
                case 9:
                    return new e(5, null);
                case 10:
                    return new e(6, null);
                case 11:
                    this.n.append(c());
                    continue;
                case 12:
                    sb = this.n;
                    c2 = IOUtils.DIR_SEPARATOR_WINDOWS;
                    break;
                case 13:
                    a(0);
                    return new e(0, this.n.toString());
                case 14:
                    sb = this.n;
                    c2 = Typography.quote;
                    break;
                case 15:
                    sb = this.n;
                    c2 = IOUtils.DIR_SEPARATOR_UNIX;
                    break;
                case 16:
                    this.n.append('\b');
                    continue;
                case 17:
                    sb = this.n;
                    c2 = '\f';
                    break;
                case 18:
                    sb = this.n;
                    c2 = '\n';
                    break;
                case 19:
                    sb = this.n;
                    c2 = CharUtils.CR;
                    break;
                case 20:
                    sb = this.n;
                    c2 = '\t';
                    break;
                case 21:
                    return new e(0, Double.valueOf(c()));
                case 22:
                    return new e(0, null);
                case 23:
                    return new e(0, Boolean.valueOf(c()));
                case 24:
                    try {
                        this.n.append((char) Integer.parseInt(c().substring(2), 16));
                        continue;
                    } catch (Exception e) {
                        throw new c(this.j, 2, e);
                    }
                default:
                    if (c == 65535 && this.g == this.f) {
                        this.m = true;
                        return null;
                    }
                    c(1);
                    continue;
                    break;
            }
            sb.append(c2);
        }
    }

    private static int b(String str, int i, int[] iArr) {
        int i2;
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            int i4 = i3 + 1;
            int charAt = str.charAt(i3);
            int i5 = i4 + 1;
            char charAt2 = str.charAt(i4);
            while (true) {
                i2 = i + 1;
                iArr[i] = charAt2;
                charAt--;
                if (charAt <= 0) {
                    break;
                }
                i = i2;
            }
            i3 = i5;
            i = i2;
        }
        return i;
    }

    private static int c(String str, int i, int[] iArr) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            iArr[i] = (str.charAt(i2) << 16) | str.charAt(i3);
            i++;
            i2 = i3 + 1;
        }
        return i;
    }

    public final void a(Reader reader) {
        this.f1865a = reader;
        this.l = true;
        this.m = false;
        this.g = 0;
        this.h = 0;
        this.e = 0;
        this.f = 0;
        this.k = 0;
        this.j = 0;
        this.i = 0;
        this.c = 0;
    }

    private static int a(String str, int i, int[] iArr) {
        int i2;
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            int i4 = i3 + 1;
            int charAt = str.charAt(i3);
            int i5 = i4 + 1;
            char charAt2 = str.charAt(i4);
            while (true) {
                i2 = i + 1;
                iArr[i] = charAt2;
                charAt--;
                if (charAt <= 0) {
                    break;
                }
                i = i2;
            }
            i3 = i5;
            i = i2;
        }
        return i;
    }

    private static char[] a(String str) {
        int i;
        char[] cArr = new char[65536];
        int i2 = 0;
        int i3 = 0;
        while (i2 < 90) {
            int i4 = i2 + 1;
            int charAt = str.charAt(i2);
            int i5 = i4 + 1;
            char charAt2 = str.charAt(i4);
            while (true) {
                i = i3 + 1;
                cArr[i3] = charAt2;
                charAt--;
                if (charAt <= 0) {
                    break;
                }
                i3 = i;
            }
            i2 = i5;
            i3 = i;
        }
        return cArr;
    }
}
