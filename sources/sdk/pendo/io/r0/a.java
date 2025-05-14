package sdk.pendo.io.r0;

import com.facebook.hermes.intl.Constants;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import kotlin.text.Typography;
import org.apache.commons.lang3.CharUtils;
import sdk.pendo.io.m0.e;

/* loaded from: classes6.dex */
public class a implements Closeable {
    private int[] A0;
    private String[] C0;
    private int[] D0;
    private final Reader f;
    private long x0;
    private int y0;
    private String z0;
    private boolean s = false;
    private final char[] A = new char[1024];
    private int f0 = 0;
    private int t0 = 0;
    private int u0 = 0;
    private int v0 = 0;
    int w0 = 0;
    private int B0 = 1;

    /* renamed from: sdk.pendo.io.r0.a$a, reason: collision with other inner class name */
    class C0230a extends e {
        C0230a() {
        }

        @Override // sdk.pendo.io.m0.e
        public void a(a aVar) {
            int i;
            if (aVar instanceof external.sdk.pendo.io.gson.internal.bind.a) {
                ((external.sdk.pendo.io.gson.internal.bind.a) aVar).N();
                return;
            }
            int i2 = aVar.w0;
            if (i2 == 0) {
                i2 = aVar.n();
            }
            if (i2 == 13) {
                i = 9;
            } else if (i2 == 12) {
                i = 8;
            } else {
                if (i2 != 14) {
                    throw new IllegalStateException("Expected a name but was " + aVar.D() + aVar.u());
                }
                i = 10;
            }
            aVar.w0 = i;
        }
    }

    static {
        e.f1372a = new C0230a();
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.A0 = iArr;
        iArr[0] = 6;
        this.C0 = new String[32];
        this.D0 = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.f = reader;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0048, code lost:
    
        e();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:54:0x0042. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String C() {
        /*
            r5 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = r1
        L3:
            int r3 = r5.f0
            int r3 = r3 + r2
            int r4 = r5.t0
            if (r3 >= r4) goto L4c
            char[] r4 = r5.A
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L5a
            r4 = 10
            if (r3 == r4) goto L5a
            r4 = 12
            if (r3 == r4) goto L5a
            r4 = 13
            if (r3 == r4) goto L5a
            r4 = 32
            if (r3 == r4) goto L5a
            r4 = 35
            if (r3 == r4) goto L48
            r4 = 44
            if (r3 == r4) goto L5a
            r4 = 47
            if (r3 == r4) goto L48
            r4 = 61
            if (r3 == r4) goto L48
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5a
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5a
            r4 = 58
            if (r3 == r4) goto L5a
            r4 = 59
            if (r3 == r4) goto L48
            switch(r3) {
                case 91: goto L5a;
                case 92: goto L48;
                case 93: goto L5a;
                default: goto L45;
            }
        L45:
            int r2 = r2 + 1
            goto L3
        L48:
            r5.e()
            goto L5a
        L4c:
            char[] r3 = r5.A
            int r3 = r3.length
            if (r2 >= r3) goto L5c
            int r3 = r2 + 1
            boolean r3 = r5.a(r3)
            if (r3 == 0) goto L5a
            goto L3
        L5a:
            r1 = r2
            goto L7c
        L5c:
            if (r0 != 0) goto L69
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L69:
            char[] r3 = r5.A
            int r4 = r5.f0
            r0.append(r3, r4, r2)
            int r3 = r5.f0
            int r3 = r3 + r2
            r5.f0 = r3
            r2 = 1
            boolean r2 = r5.a(r2)
            if (r2 != 0) goto L2
        L7c:
            if (r0 != 0) goto L88
            java.lang.String r0 = new java.lang.String
            char[] r2 = r5.A
            int r3 = r5.f0
            r0.<init>(r2, r3, r1)
            goto L94
        L88:
            char[] r2 = r5.A
            int r3 = r5.f0
            java.lang.StringBuilder r0 = r0.append(r2, r3, r1)
            java.lang.String r0 = r0.toString()
        L94:
            int r2 = r5.f0
            int r2 = r2 + r1
            r5.f0 = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.r0.a.C():java.lang.String");
    }

    private int E() {
        String str;
        String str2;
        int i;
        char c = this.A[this.f0];
        if (c == 't' || c == 'T') {
            str = "true";
            str2 = "TRUE";
            i = 5;
        } else if (c == 'f' || c == 'F') {
            str = Constants.CASEFIRST_FALSE;
            str2 = "FALSE";
            i = 6;
        } else {
            if (c != 'n' && c != 'N') {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i = 7;
        }
        int length = str.length();
        for (int i2 = 1; i2 < length; i2++) {
            if (this.f0 + i2 >= this.t0 && !a(i2 + 1)) {
                return 0;
            }
            char c2 = this.A[this.f0 + i2];
            if (c2 != str.charAt(i2) && c2 != str2.charAt(i2)) {
                return 0;
            }
        }
        if ((this.f0 + length < this.t0 || a(length + 1)) && a(this.A[this.f0 + length])) {
            return 0;
        }
        this.f0 += length;
        this.w0 = i;
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0093, code lost:
    
        if (r9 != 2) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0095, code lost:
    
        if (r13 == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x009b, code lost:
    
        if (r10 != Long.MIN_VALUE) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x009d, code lost:
    
        if (r12 == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00a3, code lost:
    
        if (r10 != 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00a5, code lost:
    
        if (r12 != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00a7, code lost:
    
        if (r12 == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00aa, code lost:
    
        r10 = -r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00ab, code lost:
    
        r18.x0 = r10;
        r18.f0 += r8;
        r1 = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00b4, code lost:
    
        r18.w0 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00b6, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00b7, code lost:
    
        if (r9 == 2) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ba, code lost:
    
        if (r9 == 4) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00bd, code lost:
    
        if (r9 != 7) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c0, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c2, code lost:
    
        r18.y0 = r8;
        r1 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0091, code lost:
    
        if (a(r14) != false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00c7, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int F() {
        /*
            Method dump skipped, instructions count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.r0.a.F():int");
    }

    private char G() {
        int i;
        int i2;
        if (this.f0 == this.t0 && !a(1)) {
            throw c("Unterminated escape sequence");
        }
        char[] cArr = this.A;
        int i3 = this.f0;
        int i4 = i3 + 1;
        this.f0 = i4;
        char c = cArr[i3];
        if (c == '\n') {
            this.u0++;
            this.v0 = i4;
        } else if (c != '\"' && c != '\'' && c != '/' && c != '\\') {
            if (c == 'b') {
                return '\b';
            }
            if (c == 'f') {
                return '\f';
            }
            if (c == 'n') {
                return '\n';
            }
            if (c == 'r') {
                return CharUtils.CR;
            }
            if (c == 't') {
                return '\t';
            }
            if (c != 'u') {
                throw c("Invalid escape sequence");
            }
            if (i4 + 4 > this.t0 && !a(4)) {
                throw c("Unterminated escape sequence");
            }
            int i5 = this.f0;
            int i6 = i5 + 4;
            char c2 = 0;
            while (i5 < i6) {
                char c3 = this.A[i5];
                char c4 = (char) (c2 << 4);
                if (c3 < '0' || c3 > '9') {
                    if (c3 >= 'a' && c3 <= 'f') {
                        i = c3 - 'a';
                    } else {
                        if (c3 < 'A' || c3 > 'F') {
                            throw new NumberFormatException("\\u".concat(new String(this.A, this.f0, 4)));
                        }
                        i = c3 - 'A';
                    }
                    i2 = i + 10;
                } else {
                    i2 = c3 - '0';
                }
                c2 = (char) (c4 + i2);
                i5++;
            }
            this.f0 += 4;
            return c2;
        }
        return c;
    }

    private void H() {
        char c;
        do {
            if (this.f0 >= this.t0 && !a(1)) {
                return;
            }
            char[] cArr = this.A;
            int i = this.f0;
            int i2 = i + 1;
            this.f0 = i2;
            c = cArr[i];
            if (c == '\n') {
                this.u0++;
                this.v0 = i2;
                return;
            }
        } while (c != '\r');
    }

    private void I() {
        do {
            int i = 0;
            while (true) {
                int i2 = this.f0 + i;
                if (i2 < this.t0) {
                    char c = this.A[i2];
                    if (c != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ') {
                        if (c != '#') {
                            if (c != ',') {
                                if (c != '/' && c != '=') {
                                    if (c != '{' && c != '}' && c != ':') {
                                        if (c != ';') {
                                            switch (c) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i++;
                                            }
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    this.f0 = i2;
                }
            }
            e();
            this.f0 += i;
            return;
        } while (a(1));
    }

    private void e() {
        if (!this.s) {
            throw c("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void m() {
        b(true);
        int i = this.f0 - 1;
        this.f0 = i;
        if (i + 5 <= this.t0 || a(5)) {
            int i2 = this.f0;
            char[] cArr = this.A;
            if (cArr[i2] == ')' && cArr[i2 + 1] == ']' && cArr[i2 + 2] == '}' && cArr[i2 + 3] == '\'' && cArr[i2 + 4] == '\n') {
                this.f0 = i2 + 5;
            }
        }
    }

    public void A() {
        int i = this.w0;
        if (i == 0) {
            i = n();
        }
        if (i != 7) {
            throw new IllegalStateException("Expected null but was " + D() + u());
        }
        this.w0 = 0;
        int[] iArr = this.D0;
        int i2 = this.B0 - 1;
        iArr[i2] = iArr[i2] + 1;
    }

    public String B() {
        String str;
        char c;
        int i = this.w0;
        if (i == 0) {
            i = n();
        }
        if (i == 10) {
            str = C();
        } else {
            if (i == 8) {
                c = '\'';
            } else if (i == 9) {
                c = Typography.quote;
            } else if (i == 11) {
                str = this.z0;
                this.z0 = null;
            } else if (i == 15) {
                str = Long.toString(this.x0);
            } else {
                if (i != 16) {
                    throw new IllegalStateException("Expected a string but was " + D() + u());
                }
                str = new String(this.A, this.f0, this.y0);
                this.f0 += this.y0;
            }
            str = b(c);
        }
        this.w0 = 0;
        int[] iArr = this.D0;
        int i2 = this.B0 - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public b D() {
        int i = this.w0;
        if (i == 0) {
            i = n();
        }
        switch (i) {
            case 1:
                return b.BEGIN_OBJECT;
            case 2:
                return b.END_OBJECT;
            case 3:
                return b.BEGIN_ARRAY;
            case 4:
                return b.END_ARRAY;
            case 5:
            case 6:
                return b.BOOLEAN;
            case 7:
                return b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return b.STRING;
            case 12:
            case 13:
            case 14:
                return b.NAME;
            case 15:
            case 16:
                return b.NUMBER;
            case 17:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public void J() {
        char c;
        int i = 0;
        do {
            int i2 = this.w0;
            if (i2 == 0) {
                i2 = n();
            }
            if (i2 == 3) {
                b(1);
            } else if (i2 == 1) {
                b(3);
            } else {
                if (i2 == 4 || i2 == 2) {
                    this.B0--;
                    i--;
                } else if (i2 == 14 || i2 == 10) {
                    I();
                } else {
                    if (i2 == 8 || i2 == 12) {
                        c = '\'';
                    } else if (i2 == 9 || i2 == 13) {
                        c = Typography.quote;
                    } else if (i2 == 16) {
                        this.f0 += this.y0;
                    }
                    c(c);
                }
                this.w0 = 0;
            }
            i++;
            this.w0 = 0;
        } while (i != 0);
        int[] iArr = this.D0;
        int i3 = this.B0 - 1;
        iArr[i3] = iArr[i3] + 1;
        this.C0[i3] = "null";
    }

    public void a() {
        int i = this.w0;
        if (i == 0) {
            i = n();
        }
        if (i != 3) {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + D() + u());
        }
        b(1);
        this.D0[this.B0 - 1] = 0;
        this.w0 = 0;
    }

    public void b() {
        int i = this.w0;
        if (i == 0) {
            i = n();
        }
        if (i != 1) {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + D() + u());
        }
        b(3);
        this.w0 = 0;
    }

    public final void c(boolean z) {
        this.s = z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.w0 = 0;
        this.A0[0] = 8;
        this.B0 = 1;
        this.f.close();
    }

    int n() {
        int i;
        int b;
        int[] iArr = this.A0;
        int i2 = this.B0 - 1;
        int i3 = iArr[i2];
        if (i3 == 1) {
            iArr[i2] = 2;
        } else {
            if (i3 != 2) {
                if (i3 == 3 || i3 == 5) {
                    iArr[i2] = 4;
                    if (i3 == 5 && (b = b(true)) != 44) {
                        if (b != 59) {
                            if (b != 125) {
                                throw c("Unterminated object");
                            }
                            this.w0 = 2;
                            return 2;
                        }
                        e();
                    }
                    int b2 = b(true);
                    if (b2 == 34) {
                        i = 13;
                    } else if (b2 == 39) {
                        e();
                        i = 12;
                    } else {
                        if (b2 == 125) {
                            if (i3 == 5) {
                                throw c("Expected name");
                            }
                            this.w0 = 2;
                            return 2;
                        }
                        e();
                        this.f0--;
                        if (!a((char) b2)) {
                            throw c("Expected name");
                        }
                        i = 14;
                    }
                } else if (i3 == 4) {
                    iArr[i2] = 5;
                    int b3 = b(true);
                    if (b3 != 58) {
                        if (b3 != 61) {
                            throw c("Expected ':'");
                        }
                        e();
                        if (this.f0 < this.t0 || a(1)) {
                            char[] cArr = this.A;
                            int i4 = this.f0;
                            if (cArr[i4] == '>') {
                                this.f0 = i4 + 1;
                            }
                        }
                    }
                } else if (i3 == 6) {
                    if (this.s) {
                        m();
                    }
                    this.A0[this.B0 - 1] = 7;
                } else if (i3 == 7) {
                    if (b(false) == -1) {
                        i = 17;
                    } else {
                        e();
                        this.f0--;
                    }
                } else if (i3 == 8) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                this.w0 = i;
                return i;
            }
            int b4 = b(true);
            if (b4 != 44) {
                if (b4 != 59) {
                    if (b4 != 93) {
                        throw c("Unterminated array");
                    }
                    this.w0 = 4;
                    return 4;
                }
                e();
            }
        }
        int b5 = b(true);
        if (b5 != 34) {
            if (b5 == 39) {
                e();
                this.w0 = 8;
                return 8;
            }
            if (b5 != 44 && b5 != 59) {
                if (b5 == 91) {
                    this.w0 = 3;
                    return 3;
                }
                if (b5 != 93) {
                    if (b5 == 123) {
                        this.w0 = 1;
                        return 1;
                    }
                    this.f0--;
                    int E = E();
                    if (E != 0) {
                        return E;
                    }
                    int F = F();
                    if (F != 0) {
                        return F;
                    }
                    if (!a(this.A[this.f0])) {
                        throw c("Expected value");
                    }
                    e();
                    i = 10;
                } else if (i3 == 1) {
                    this.w0 = 4;
                    return 4;
                }
            }
            if (i3 != 1 && i3 != 2) {
                throw c("Unexpected value");
            }
            e();
            this.f0--;
            this.w0 = 7;
            return 7;
        }
        i = 9;
        this.w0 = i;
        return i;
    }

    public void o() {
        int i = this.w0;
        if (i == 0) {
            i = n();
        }
        if (i != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + D() + u());
        }
        int i2 = this.B0 - 1;
        this.B0 = i2;
        int[] iArr = this.D0;
        int i3 = i2 - 1;
        iArr[i3] = iArr[i3] + 1;
        this.w0 = 0;
    }

    public void p() {
        int i = this.w0;
        if (i == 0) {
            i = n();
        }
        if (i != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + D() + u());
        }
        int i2 = this.B0 - 1;
        this.B0 = i2;
        this.C0[i2] = null;
        int[] iArr = this.D0;
        int i3 = i2 - 1;
        iArr[i3] = iArr[i3] + 1;
        this.w0 = 0;
    }

    public String q() {
        return a(false);
    }

    public String r() {
        return a(true);
    }

    public boolean s() {
        int i = this.w0;
        if (i == 0) {
            i = n();
        }
        return (i == 2 || i == 4 || i == 17) ? false : true;
    }

    public final boolean t() {
        return this.s;
    }

    public String toString() {
        return getClass().getSimpleName() + u();
    }

    String u() {
        return " at line " + (this.u0 + 1) + " column " + ((this.f0 - this.v0) + 1) + " path " + q();
    }

    public boolean v() {
        int i = this.w0;
        if (i == 0) {
            i = n();
        }
        if (i == 5) {
            this.w0 = 0;
            int[] iArr = this.D0;
            int i2 = this.B0 - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        }
        if (i != 6) {
            throw new IllegalStateException("Expected a boolean but was " + D() + u());
        }
        this.w0 = 0;
        int[] iArr2 = this.D0;
        int i3 = this.B0 - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return false;
    }

    public double w() {
        String b;
        int i = this.w0;
        if (i == 0) {
            i = n();
        }
        if (i == 15) {
            this.w0 = 0;
            int[] iArr = this.D0;
            int i2 = this.B0 - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.x0;
        }
        if (i == 16) {
            this.z0 = new String(this.A, this.f0, this.y0);
            this.f0 += this.y0;
        } else {
            if (i == 8 || i == 9) {
                b = b(i == 8 ? '\'' : Typography.quote);
            } else if (i == 10) {
                b = C();
            } else if (i != 11) {
                throw new IllegalStateException("Expected a double but was " + D() + u());
            }
            this.z0 = b;
        }
        this.w0 = 11;
        double parseDouble = Double.parseDouble(this.z0);
        if (!this.s && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new d("JSON forbids NaN and infinities: " + parseDouble + u());
        }
        this.z0 = null;
        this.w0 = 0;
        int[] iArr2 = this.D0;
        int i3 = this.B0 - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return parseDouble;
    }

    public int x() {
        String b;
        int i = this.w0;
        if (i == 0) {
            i = n();
        }
        if (i == 15) {
            long j = this.x0;
            int i2 = (int) j;
            if (j != i2) {
                throw new NumberFormatException("Expected an int but was " + this.x0 + u());
            }
            this.w0 = 0;
            int[] iArr = this.D0;
            int i3 = this.B0 - 1;
            iArr[i3] = iArr[i3] + 1;
            return i2;
        }
        if (i == 16) {
            this.z0 = new String(this.A, this.f0, this.y0);
            this.f0 += this.y0;
        } else {
            if (i != 8 && i != 9 && i != 10) {
                throw new IllegalStateException("Expected an int but was " + D() + u());
            }
            if (i == 10) {
                b = C();
            } else {
                b = b(i == 8 ? '\'' : Typography.quote);
            }
            this.z0 = b;
            try {
                int parseInt = Integer.parseInt(this.z0);
                this.w0 = 0;
                int[] iArr2 = this.D0;
                int i4 = this.B0 - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.w0 = 11;
        double parseDouble = Double.parseDouble(this.z0);
        int i5 = (int) parseDouble;
        if (i5 != parseDouble) {
            throw new NumberFormatException("Expected an int but was " + this.z0 + u());
        }
        this.z0 = null;
        this.w0 = 0;
        int[] iArr3 = this.D0;
        int i6 = this.B0 - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return i5;
    }

    public long y() {
        String b;
        int i = this.w0;
        if (i == 0) {
            i = n();
        }
        if (i == 15) {
            this.w0 = 0;
            int[] iArr = this.D0;
            int i2 = this.B0 - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.x0;
        }
        if (i == 16) {
            this.z0 = new String(this.A, this.f0, this.y0);
            this.f0 += this.y0;
        } else {
            if (i != 8 && i != 9 && i != 10) {
                throw new IllegalStateException("Expected a long but was " + D() + u());
            }
            if (i == 10) {
                b = C();
            } else {
                b = b(i == 8 ? '\'' : Typography.quote);
            }
            this.z0 = b;
            try {
                long parseLong = Long.parseLong(this.z0);
                this.w0 = 0;
                int[] iArr2 = this.D0;
                int i3 = this.B0 - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        this.w0 = 11;
        double parseDouble = Double.parseDouble(this.z0);
        long j = (long) parseDouble;
        if (j != parseDouble) {
            throw new NumberFormatException("Expected a long but was " + this.z0 + u());
        }
        this.z0 = null;
        this.w0 = 0;
        int[] iArr3 = this.D0;
        int i4 = this.B0 - 1;
        iArr3[i4] = iArr3[i4] + 1;
        return j;
    }

    public String z() {
        char c;
        String b;
        int i = this.w0;
        if (i == 0) {
            i = n();
        }
        if (i == 14) {
            b = C();
        } else {
            if (i == 12) {
                c = '\'';
            } else {
                if (i != 13) {
                    throw new IllegalStateException("Expected a name but was " + D() + u());
                }
                c = Typography.quote;
            }
            b = b(c);
        }
        this.w0 = 0;
        this.C0[this.B0 - 1] = b;
        return b;
    }

    private boolean a(int i) {
        int i2;
        int i3;
        char[] cArr = this.A;
        int i4 = this.v0;
        int i5 = this.f0;
        this.v0 = i4 - i5;
        int i6 = this.t0;
        if (i6 != i5) {
            int i7 = i6 - i5;
            this.t0 = i7;
            System.arraycopy(cArr, i5, cArr, 0, i7);
        } else {
            this.t0 = 0;
        }
        this.f0 = 0;
        do {
            Reader reader = this.f;
            int i8 = this.t0;
            int read = reader.read(cArr, i8, cArr.length - i8);
            if (read == -1) {
                return false;
            }
            i2 = this.t0 + read;
            this.t0 = i2;
            if (this.u0 == 0 && (i3 = this.v0) == 0 && i2 > 0 && cArr[0] == 65279) {
                this.f0++;
                this.v0 = i3 + 1;
                i++;
            }
        } while (i2 < i);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0051, code lost:
    
        if (r1 != '/') goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0053, code lost:
    
        r7.f0 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0056, code lost:
    
        if (r4 != r2) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0058, code lost:
    
        r7.f0 = r4 - 1;
        r2 = a(2);
        r7.f0++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0065, code lost:
    
        if (r2 != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0067, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0068, code lost:
    
        e();
        r2 = r7.f0;
        r3 = r0[r2];
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0071, code lost:
    
        if (r3 == '*') goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007b, code lost:
    
        r7.f0 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0085, code lost:
    
        if (b("*\/") == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0092, code lost:
    
        throw c("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0073, code lost:
    
        if (r3 == '/') goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0076, code lost:
    
        r7.f0 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0075, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0093, code lost:
    
        r7.f0 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0097, code lost:
    
        if (r1 != '#') goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0099, code lost:
    
        e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a1, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int b(boolean r8) {
        /*
            r7 = this;
            char[] r0 = r7.A
        L2:
            int r1 = r7.f0
        L4:
            int r2 = r7.t0
        L6:
            r3 = 1
            if (r1 != r2) goto L32
            r7.f0 = r1
            boolean r1 = r7.a(r3)
            if (r1 != 0) goto L2e
            if (r8 != 0) goto L15
            r8 = -1
            return r8
        L15:
            java.io.EOFException r8 = new java.io.EOFException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "End of input"
            r0.<init>(r1)
            java.lang.String r1 = r7.u()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        L2e:
            int r1 = r7.f0
            int r2 = r7.t0
        L32:
            int r4 = r1 + 1
            char r1 = r0[r1]
            r5 = 10
            if (r1 != r5) goto L42
            int r1 = r7.u0
            int r1 = r1 + r3
            r7.u0 = r1
            r7.v0 = r4
            goto La2
        L42:
            r5 = 32
            if (r1 == r5) goto La2
            r5 = 13
            if (r1 == r5) goto La2
            r5 = 9
            if (r1 != r5) goto L4f
            goto La2
        L4f:
            r5 = 47
            if (r1 != r5) goto L93
            r7.f0 = r4
            r6 = 2
            if (r4 != r2) goto L68
            int r4 = r4 + (-1)
            r7.f0 = r4
            boolean r2 = r7.a(r6)
            int r4 = r7.f0
            int r4 = r4 + r3
            r7.f0 = r4
            if (r2 != 0) goto L68
            return r1
        L68:
            r7.e()
            int r2 = r7.f0
            char r3 = r0[r2]
            r4 = 42
            if (r3 == r4) goto L7b
            if (r3 == r5) goto L76
            return r1
        L76:
            int r2 = r2 + 1
            r7.f0 = r2
            goto L9c
        L7b:
            int r2 = r2 + 1
            r7.f0 = r2
        */
        //  java.lang.String r1 = "*/"
        /*
            boolean r1 = r7.b(r1)
            if (r1 == 0) goto L8c
            int r1 = r7.f0
            int r1 = r1 + r6
            goto L4
        L8c:
            java.lang.String r8 = "Unterminated comment"
            java.io.IOException r8 = r7.c(r8)
            throw r8
        L93:
            r2 = 35
            r7.f0 = r4
            if (r1 != r2) goto La1
            r7.e()
        L9c:
            r7.H()
            goto L2
        La1:
            return r1
        La2:
            r1 = r4
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.r0.a.b(boolean):int");
    }

    private void c(char c) {
        char[] cArr = this.A;
        while (true) {
            int i = this.f0;
            int i2 = this.t0;
            while (true) {
                if (i < i2) {
                    int i3 = i + 1;
                    char c2 = cArr[i];
                    if (c2 == c) {
                        this.f0 = i3;
                        return;
                    }
                    if (c2 == '\\') {
                        this.f0 = i3;
                        G();
                        break;
                    } else {
                        if (c2 == '\n') {
                            this.u0++;
                            this.v0 = i3;
                        }
                        i = i3;
                    }
                } else {
                    this.f0 = i;
                    if (!a(1)) {
                        throw c("Unterminated string");
                    }
                }
            }
        }
    }

    private String a(boolean z) {
        StringBuilder sb = new StringBuilder("$");
        int i = 0;
        while (true) {
            int i2 = this.B0;
            if (i >= i2) {
                return sb.toString();
            }
            int i3 = this.A0[i];
            if (i3 == 1 || i3 == 2) {
                int i4 = this.D0[i];
                if (z && i4 > 0 && i == i2 - 1) {
                    i4--;
                }
                sb.append('[').append(i4).append(']');
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sb.append('.');
                String str = this.C0[i];
                if (str != null) {
                    sb.append(str);
                }
            }
            i++;
        }
    }

    private String b(char c) {
        char[] cArr = this.A;
        StringBuilder sb = null;
        do {
            int i = this.f0;
            int i2 = this.t0;
            int i3 = i;
            while (i < i2) {
                int i4 = i + 1;
                char c2 = cArr[i];
                if (c2 == c) {
                    this.f0 = i4;
                    int i5 = (i4 - i3) - 1;
                    if (sb == null) {
                        return new String(cArr, i3, i5);
                    }
                    sb.append(cArr, i3, i5);
                    return sb.toString();
                }
                if (c2 == '\\') {
                    this.f0 = i4;
                    int i6 = (i4 - i3) - 1;
                    if (sb == null) {
                        sb = new StringBuilder(Math.max((i6 + 1) * 2, 16));
                    }
                    sb.append(cArr, i3, i6);
                    sb.append(G());
                    i3 = this.f0;
                    i2 = this.t0;
                    i = i3;
                } else {
                    if (c2 == '\n') {
                        this.u0++;
                        this.v0 = i4;
                    }
                    i = i4;
                }
            }
            if (sb == null) {
                sb = new StringBuilder(Math.max((i - i3) * 2, 16));
            }
            sb.append(cArr, i3, i - i3);
            this.f0 = i;
        } while (a(1));
        throw c("Unterminated string");
    }

    private IOException c(String str) {
        throw new d(str + u());
    }

    private boolean a(char c) {
        if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
            return false;
        }
        if (c != '#') {
            if (c == ',') {
                return false;
            }
            if (c != '/' && c != '=') {
                if (c == '{' || c == '}' || c == ':') {
                    return false;
                }
                if (c != ';') {
                    switch (c) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        e();
        return false;
    }

    private void b(int i) {
        int i2 = this.B0;
        int[] iArr = this.A0;
        if (i2 == iArr.length) {
            int i3 = i2 * 2;
            this.A0 = Arrays.copyOf(iArr, i3);
            this.D0 = Arrays.copyOf(this.D0, i3);
            this.C0 = (String[]) Arrays.copyOf(this.C0, i3);
        }
        int[] iArr2 = this.A0;
        int i4 = this.B0;
        this.B0 = i4 + 1;
        iArr2[i4] = i;
    }

    private boolean b(String str) {
        int length = str.length();
        while (true) {
            if (this.f0 + length > this.t0 && !a(length)) {
                return false;
            }
            char[] cArr = this.A;
            int i = this.f0;
            if (cArr[i] != '\n') {
                for (int i2 = 0; i2 < length; i2++) {
                    if (this.A[this.f0 + i2] != str.charAt(i2)) {
                        break;
                    }
                }
                return true;
            }
            this.u0++;
            this.v0 = i + 1;
            this.f0++;
        }
    }
}
