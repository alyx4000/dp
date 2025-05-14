package sdk.pendo.io.r0;

import com.facebook.hermes.intl.Constants;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/* loaded from: classes6.dex */
public class c implements Closeable, Flushable {
    private static final String[] A0;
    private static final Pattern y0 = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");
    private static final String[] z0 = new String[128];
    private final Writer f;
    private String f0;
    private String t0;
    private boolean u0;
    private boolean v0;
    private String w0;
    private boolean x0;
    private int[] s = new int[32];
    private int A = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            z0[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = z0;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        A0 = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        a(6);
        this.t0 = ":";
        this.x0 = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.f = writer;
    }

    private void a() {
        int t = t();
        if (t == 5) {
            this.f.write(44);
        } else if (t != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        r();
        b(4);
    }

    private void b() {
        int t = t();
        if (t == 1) {
            b(2);
        } else {
            if (t != 2) {
                if (t == 4) {
                    this.f.append((CharSequence) this.t0);
                    b(5);
                    return;
                }
                if (t != 6) {
                    if (t != 7) {
                        throw new IllegalStateException("Nesting problem.");
                    }
                    if (!this.u0) {
                        throw new IllegalStateException("JSON must have only one top-level value.");
                    }
                }
                b(7);
                return;
            }
            this.f.append(',');
        }
        r();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d(java.lang.String r9) {
        /*
            r8 = this;
            boolean r0 = r8.v0
            if (r0 == 0) goto L7
            java.lang.String[] r0 = sdk.pendo.io.r0.c.A0
            goto L9
        L7:
            java.lang.String[] r0 = sdk.pendo.io.r0.c.z0
        L9:
            java.io.Writer r1 = r8.f
            r2 = 34
            r1.write(r2)
            int r1 = r9.length()
            r3 = 0
            r4 = r3
        L16:
            if (r3 >= r1) goto L45
            char r5 = r9.charAt(r3)
            r6 = 128(0x80, float:1.8E-43)
            if (r5 >= r6) goto L25
            r5 = r0[r5]
            if (r5 != 0) goto L32
            goto L42
        L25:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L2c
            java.lang.String r5 = "\\u2028"
            goto L32
        L2c:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L42
            java.lang.String r5 = "\\u2029"
        L32:
            if (r4 >= r3) goto L3b
            java.io.Writer r6 = r8.f
            int r7 = r3 - r4
            r6.write(r9, r4, r7)
        L3b:
            java.io.Writer r4 = r8.f
            r4.write(r5)
            int r4 = r3 + 1
        L42:
            int r3 = r3 + 1
            goto L16
        L45:
            if (r4 >= r1) goto L4d
            java.io.Writer r0 = r8.f
            int r1 = r1 - r4
            r0.write(r9, r4, r1)
        L4d:
            java.io.Writer r9 = r8.f
            r9.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.r0.c.d(java.lang.String):void");
    }

    private void r() {
        if (this.f0 == null) {
            return;
        }
        this.f.write(10);
        int i = this.A;
        for (int i2 = 1; i2 < i; i2++) {
            this.f.write(this.f0);
        }
    }

    private int t() {
        int i = this.A;
        if (i != 0) {
            return this.s[i - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void u() {
        if (this.w0 != null) {
            a();
            d(this.w0);
            this.w0 = null;
        }
    }

    public final void c(String str) {
        String str2;
        if (str.length() == 0) {
            this.f0 = null;
            str2 = ":";
        } else {
            this.f0 = str;
            str2 = ": ";
        }
        this.t0 = str2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f.close();
        int i = this.A;
        if (i > 1 || (i == 1 && this.s[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.A = 0;
    }

    public c e() {
        u();
        return a(1, '[');
    }

    public void flush() {
        if (this.A == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f.flush();
    }

    public c h(long j) {
        u();
        b();
        this.f.write(Long.toString(j));
        return this;
    }

    public c m() {
        u();
        return a(3, '{');
    }

    public c n() {
        return a(1, 2, ']');
    }

    public c o() {
        return a(3, 5, '}');
    }

    public final boolean p() {
        return this.x0;
    }

    public boolean q() {
        return this.u0;
    }

    public c s() {
        if (this.w0 != null) {
            if (!this.x0) {
                this.w0 = null;
                return this;
            }
            u();
        }
        b();
        this.f.write("null");
        return this;
    }

    private c a(int i, int i2, char c) {
        int t = t();
        if (t != i2 && t != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.w0 != null) {
            throw new IllegalStateException("Dangling name: " + this.w0);
        }
        this.A--;
        if (t == i2) {
            r();
        }
        this.f.write(c);
        return this;
    }

    public c b(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.w0 != null) {
            throw new IllegalStateException();
        }
        if (this.A == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.w0 = str;
        return this;
    }

    public final void c(boolean z) {
        this.x0 = z;
    }

    public c d(boolean z) {
        u();
        b();
        this.f.write(z ? "true" : Constants.CASEFIRST_FALSE);
        return this;
    }

    public c e(String str) {
        if (str == null) {
            return s();
        }
        u();
        b();
        d(str);
        return this;
    }

    private static boolean a(Class<? extends Number> cls) {
        return cls == Integer.class || cls == Long.class || cls == Double.class || cls == Float.class || cls == Byte.class || cls == Short.class || cls == BigDecimal.class || cls == BigInteger.class || cls == AtomicInteger.class || cls == AtomicLong.class;
    }

    private void b(int i) {
        this.s[this.A - 1] = i;
    }

    private c a(int i, char c) {
        b();
        a(i);
        this.f.write(c);
        return this;
    }

    public final void b(boolean z) {
        this.u0 = z;
    }

    private void a(int i) {
        int i2 = this.A;
        int[] iArr = this.s;
        if (i2 == iArr.length) {
            this.s = Arrays.copyOf(iArr, i2 * 2);
        }
        int[] iArr2 = this.s;
        int i3 = this.A;
        this.A = i3 + 1;
        iArr2[i3] = i;
    }

    public final void a(boolean z) {
        this.v0 = z;
    }

    public c a(Boolean bool) {
        if (bool == null) {
            return s();
        }
        u();
        b();
        this.f.write(bool.booleanValue() ? "true" : Constants.CASEFIRST_FALSE);
        return this;
    }

    public c a(Number number) {
        if (number == null) {
            return s();
        }
        u();
        String obj = number.toString();
        if (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN")) {
            Class<?> cls = number.getClass();
            if (!a((Class<? extends Number>) cls) && !y0.matcher(obj).matches()) {
                throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + obj);
            }
        } else if (!this.u0) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + obj);
        }
        b();
        this.f.append((CharSequence) obj);
        return this;
    }
}
