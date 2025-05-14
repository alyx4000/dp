package sdk.pendo.io.d2;

import com.google.android.material.internal.ViewUtils;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import kotlin.text.Typography;
import okio.internal._BufferKt;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.CharUtils;
import sdk.pendo.io.f2.j;
import sdk.pendo.io.f2.k;

/* loaded from: classes6.dex */
abstract class b {
    protected static boolean[] t;
    protected static boolean[] u;
    protected static boolean[] v;
    protected static boolean[] w;
    protected static boolean[] x;

    /* renamed from: a, reason: collision with root package name */
    protected char f983a;
    j b;
    private String c;
    protected final a d = new a(15);
    protected Object e;
    protected String f;
    protected int g;
    protected final boolean h;
    protected final boolean i;
    protected final boolean j;
    protected final boolean k;
    protected final boolean l;
    protected final boolean m;
    protected final boolean n;
    protected final boolean o;
    protected final boolean p;
    protected final boolean q;
    protected final boolean r;
    protected final boolean s;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        char[] f984a;
        int b = -1;

        public a(int i) {
            this.f984a = new char[i];
        }

        public void a(char c) {
            int i = this.b + 1;
            this.b = i;
            char[] cArr = this.f984a;
            if (cArr.length <= i) {
                char[] cArr2 = new char[(cArr.length * 2) + 1];
                System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                this.f984a = cArr2;
            }
            this.f984a[this.b] = c;
        }

        public String toString() {
            return new String(this.f984a, 0, this.b + 1);
        }

        public void a() {
            this.b = -1;
        }
    }

    static {
        boolean[] zArr = new boolean[126];
        t = zArr;
        boolean[] zArr2 = new boolean[126];
        u = zArr2;
        boolean[] zArr3 = new boolean[126];
        v = zArr3;
        boolean[] zArr4 = new boolean[126];
        w = zArr4;
        boolean[] zArr5 = new boolean[126];
        x = zArr5;
        zArr3[26] = true;
        zArr3[58] = true;
        zArr4[26] = true;
        zArr4[125] = true;
        zArr4[44] = true;
        zArr2[26] = true;
        zArr2[93] = true;
        zArr2[44] = true;
        zArr5[26] = true;
        zArr[58] = true;
        zArr[44] = true;
        zArr[26] = true;
        zArr[125] = true;
        zArr[93] = true;
    }

    public b(int i) {
        this.i = (i & 4) > 0;
        this.j = (i & 2) > 0;
        this.k = (i & 1) > 0;
        this.o = (i & 8) > 0;
        this.q = (i & 16) > 0;
        this.h = (i & 32) > 0;
        this.l = (i & 64) > 0;
        this.p = (i & 128) > 0;
        this.m = (i & ViewUtils.EDGE_TO_EDGE_FLAGS) != 768;
        this.n = (i & 512) == 0;
        this.r = (i & 1024) > 0;
        this.s = (i & 2048) > 0;
    }

    public void a() {
        if (this.o) {
            return;
        }
        int length = this.f.length();
        for (int i = 0; i < length; i++) {
            char charAt = this.f.charAt(i);
            if (charAt >= 0) {
                if (charAt <= 31) {
                    throw new e(this.g + i, 0, Character.valueOf(charAt));
                }
                if (charAt == 127 && this.r) {
                    throw new e(this.g + i, 0, Character.valueOf(charAt));
                }
            }
        }
    }

    protected abstract void a(boolean[] zArr);

    protected abstract Object b(boolean[] zArr);

    public void b() {
        int length = this.f.length();
        if (length == 1) {
            return;
        }
        if (length == 2) {
            if (this.f.equals("00")) {
                throw new e(this.g, 6, this.f);
            }
            return;
        }
        char charAt = this.f.charAt(0);
        char charAt2 = this.f.charAt(1);
        if (charAt != '-') {
            if (charAt == '0' && charAt2 >= '0' && charAt2 <= '9') {
                throw new e(this.g, 6, this.f);
            }
            return;
        }
        char charAt3 = this.f.charAt(2);
        if (charAt2 == '0' && charAt3 >= '0' && charAt3 <= '9') {
            throw new e(this.g, 6, this.f);
        }
    }

    protected Number c() {
        if (!this.h) {
            b();
        }
        try {
            if (!this.p) {
                return Float.valueOf(Float.parseFloat(this.f));
            }
            if (this.f.length() <= 18) {
                return Double.valueOf(Double.parseDouble(this.f));
            }
            if (!this.s) {
                double parseDouble = Double.parseDouble(this.f);
                if (a(String.valueOf(parseDouble), this.f)) {
                    return Double.valueOf(parseDouble);
                }
            }
            return new BigDecimal(this.f);
        } catch (NumberFormatException unused) {
            throw new e(this.g, 1, this.f);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x00d8, code lost:
    
        throw new sdk.pendo.io.d2.e(r12.g, 0, java.lang.Character.valueOf(r12.f983a));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected <T> T d(sdk.pendo.io.f2.k<T> r13) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.d2.b.d(sdk.pendo.io.f2.k):java.lang.Object");
    }

    protected abstract void d();

    protected abstract void e();

    abstract void f();

    protected abstract void g();

    protected void h() {
        a aVar;
        int i;
        char c = this.f983a;
        while (true) {
            d();
            char c2 = this.f983a;
            char c3 = Typography.quote;
            if (c2 == '\"' || c2 == '\'') {
                if (c == c2) {
                    d();
                    this.f = this.d.toString();
                    return;
                }
            } else if (c2 == '\\') {
                d();
                char c4 = this.f983a;
                if (c4 != '\"') {
                    if (c4 != '\'') {
                        c3 = IOUtils.DIR_SEPARATOR_UNIX;
                        if (c4 != '/') {
                            if (c4 != '\\') {
                                if (c4 == 'b') {
                                    aVar = this.d;
                                    c3 = '\b';
                                } else if (c4 == 'f') {
                                    aVar = this.d;
                                    c3 = '\f';
                                } else if (c4 == 'n') {
                                    aVar = this.d;
                                    c3 = '\n';
                                } else if (c4 != 'r') {
                                    if (c4 == 'x') {
                                        aVar = this.d;
                                        i = 2;
                                    } else if (c4 == 't') {
                                        aVar = this.d;
                                        c3 = '\t';
                                    } else if (c4 == 'u') {
                                        aVar = this.d;
                                        i = 4;
                                    }
                                    c3 = a(i);
                                } else {
                                    aVar = this.d;
                                    c3 = CharUtils.CR;
                                }
                                aVar.a(c3);
                            } else {
                                this.d.a(IOUtils.DIR_SEPARATOR_WINDOWS);
                            }
                        }
                    } else {
                        this.d.a('\'');
                    }
                }
                aVar = this.d;
                aVar.a(c3);
            } else if (c2 != 127) {
                switch (c2) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case '\b':
                    case '\t':
                    case '\n':
                    case 11:
                    case '\f':
                    case '\r':
                    case 14:
                    case 15:
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
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                        if (!this.o) {
                            throw new e(this.g, 0, Character.valueOf(this.f983a));
                        }
                        continue;
                    case 26:
                        throw new e(this.g - 1, 3, null);
                }
            } else if (this.o) {
                continue;
            } else if (this.r) {
                throw new e(this.g, 0, Character.valueOf(this.f983a));
            }
            this.d.a(c2);
        }
    }

    protected void i() {
        while (true) {
            char c = this.f983a;
            if (c < '0' || c > '9') {
                return;
            } else {
                f();
            }
        }
    }

    protected void j() {
        while (true) {
            char c = this.f983a;
            if (c > ' ' || c == 26) {
                return;
            } else {
                f();
            }
        }
    }

    private boolean a(String str, String str2) {
        int i;
        char[] charArray = str.toCharArray();
        char[] charArray2 = str2.toCharArray();
        if (charArray.length > charArray2.length) {
            return false;
        }
        int i2 = 0;
        for (char c : charArray) {
            if (c < '0' || c > '9') {
                char c2 = charArray2[i2];
                if (c2 >= '0' && c2 <= '9') {
                    return false;
                }
                i2++;
                i = charArray2[i2] != '+' ? i + 1 : 0;
            } else if (c != charArray2[i2]) {
                return false;
            }
            i2++;
        }
        return i2 == charArray2.length;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0043, code lost:
    
        if (r4 == ':') goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0047, code lost:
    
        if (r4 == ']') goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x004b, code lost:
    
        if (r4 == '}') goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0081, code lost:
    
        throw new sdk.pendo.io.d2.e(r7.g, 0, java.lang.Character.valueOf(r7.f983a));
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0057, code lost:
    
        if (r1 == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x005b, code lost:
    
        if (r7.l == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x006b, code lost:
    
        throw new sdk.pendo.io.d2.e(r7.g, 0, java.lang.Character.valueOf(r7.f983a));
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x006c, code lost:
    
        d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0073, code lost:
    
        return r8.a(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected <T> T b(sdk.pendo.io.f2.k<T> r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r8.a()
            char r1 = r7.f983a
            r2 = 91
            if (r1 != r2) goto Lad
            r7.d()
            char r1 = r7.f983a
            r2 = 44
            r3 = 0
            if (r1 != r2) goto L27
            boolean r1 = r7.l
            if (r1 == 0) goto L19
            goto L27
        L19:
            sdk.pendo.io.d2.e r8 = new sdk.pendo.io.d2.e
            int r0 = r7.g
            char r1 = r7.f983a
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            r8.<init>(r0, r3, r1)
            throw r8
        L27:
            r1 = r3
        L28:
            char r4 = r7.f983a
            r5 = 9
            if (r4 == r5) goto La8
            r5 = 10
            if (r4 == r5) goto La8
            r5 = 13
            if (r4 == r5) goto La8
            r5 = 26
            r6 = 1
            if (r4 == r5) goto L9c
            r5 = 32
            if (r4 == r5) goto La8
            if (r4 == r2) goto L82
            r5 = 58
            if (r4 == r5) goto L74
            r5 = 93
            if (r4 == r5) goto L57
            r1 = 125(0x7d, float:1.75E-43)
            if (r4 == r1) goto L74
            boolean[] r1 = sdk.pendo.io.d2.b.u
            java.lang.Object r1 = r7.a(r8, r1)
            r8.a(r0, r1)
            goto L27
        L57:
            if (r1 == 0) goto L6c
            boolean r1 = r7.l
            if (r1 == 0) goto L5e
            goto L6c
        L5e:
            sdk.pendo.io.d2.e r8 = new sdk.pendo.io.d2.e
            int r0 = r7.g
            char r1 = r7.f983a
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            r8.<init>(r0, r3, r1)
            throw r8
        L6c:
            r7.d()
            java.lang.Object r8 = r8.a(r0)
            return r8
        L74:
            sdk.pendo.io.d2.e r8 = new sdk.pendo.io.d2.e
            int r0 = r7.g
            char r1 = r7.f983a
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            r8.<init>(r0, r3, r1)
            throw r8
        L82:
            if (r1 == 0) goto L97
            boolean r1 = r7.l
            if (r1 == 0) goto L89
            goto L97
        L89:
            sdk.pendo.io.d2.e r8 = new sdk.pendo.io.d2.e
            int r0 = r7.g
            char r1 = r7.f983a
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            r8.<init>(r0, r3, r1)
            throw r8
        L97:
            r7.d()
            r1 = r6
            goto L28
        L9c:
            sdk.pendo.io.d2.e r8 = new sdk.pendo.io.d2.e
            int r0 = r7.g
            int r0 = r0 - r6
            r1 = 3
            java.lang.String r2 = "EOF"
            r8.<init>(r0, r1, r2)
            throw r8
        La8:
            r7.d()
            goto L28
        Lad:
            java.lang.RuntimeException r8 = new java.lang.RuntimeException
            java.lang.String r0 = "Internal Error"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.d2.b.b(sdk.pendo.io.f2.k):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001a, code lost:
    
        r0 = r3.f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00d5, code lost:
    
        throw new sdk.pendo.io.d2.e(r3.g, 0, java.lang.Character.valueOf(r3.f983a));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected <T> T c(sdk.pendo.io.f2.k<T> r4) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.d2.b.c(sdk.pendo.io.f2.k):java.lang.Object");
    }

    protected <T> T a(k<T> kVar) {
        this.g = -1;
        try {
            d();
            T t2 = (T) c(kVar);
            if (this.m) {
                if (!this.n) {
                    j();
                }
                if (this.f983a != 26) {
                    throw new e(this.g - 1, 1, Character.valueOf(this.f983a));
                }
            }
            this.f = null;
            this.e = null;
            return t2;
        } catch (IOException e) {
            throw new e(this.g, e);
        }
    }

    protected void c(boolean[] zArr) {
        while (true) {
            char c = this.f983a;
            if (c == 26) {
                return;
            }
            if (c >= 0 && c < '~' && zArr[c]) {
                return;
            } else {
                f();
            }
        }
    }

    protected Number a(String str) {
        int i;
        int i2;
        boolean z;
        int i3;
        int length = str.length();
        boolean z2 = false;
        if (str.charAt(0) == '-') {
            if (!this.h && length >= 3 && str.charAt(1) == '0') {
                throw new e(this.g, 6, str);
            }
            i = 20;
            i2 = 1;
        } else {
            if (!this.h && length >= 2 && str.charAt(0) == '0') {
                throw new e(this.g, 6, str);
            }
            i = 19;
            i2 = 0;
        }
        int i4 = i2;
        if (length < i) {
            z = false;
        } else {
            if (length > i) {
                return new BigInteger(str, 10);
            }
            length--;
            z = true;
        }
        long j = 0;
        while (i2 < length) {
            j = (j * 10) + ('0' - str.charAt(i2));
            i2++;
        }
        if (z) {
            if (j <= _BufferKt.OVERFLOW_ZONE) {
                if (j >= _BufferKt.OVERFLOW_ZONE) {
                    char charAt = str.charAt(i2);
                    if (i4 == 0) {
                    }
                }
                z2 = true;
            }
            if (z2) {
                return new BigInteger(str, 10);
            }
            j = (j * 10) + ('0' - str.charAt(i2));
        }
        if (i4 == 0) {
            long j2 = -j;
            if (!this.q || j2 > 2147483647L) {
                return Long.valueOf(j2);
            }
            i3 = (int) j2;
        } else {
            if (!this.q || j < -2147483648L) {
                return Long.valueOf(j);
            }
            i3 = (int) j;
        }
        return Integer.valueOf(i3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00da, code lost:
    
        throw new sdk.pendo.io.d2.e(r2.g, 0, java.lang.Character.valueOf(r2.f983a));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected java.lang.Object a(sdk.pendo.io.f2.k<?> r3, boolean[] r4) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.d2.b.a(sdk.pendo.io.f2.k, boolean[]):java.lang.Object");
    }

    protected char a(int i) {
        int i2;
        int i3;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            int i6 = i4 * 16;
            d();
            char c = this.f983a;
            if (c > '9' || c < '0') {
                if (c <= 'F' && c >= 'A') {
                    i2 = c - 'A';
                } else {
                    if (c < 'a' || c > 'f') {
                        if (c == 26) {
                            throw new e(this.g, 3, "EOF");
                        }
                        throw new e(this.g, 4, Character.valueOf(this.f983a));
                    }
                    i2 = c - 'a';
                }
                i3 = i2 + 10;
            } else {
                i3 = c - '0';
            }
            i4 = i6 + i3;
        }
        return (char) i4;
    }
}
