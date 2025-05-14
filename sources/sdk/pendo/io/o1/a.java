package sdk.pendo.io.o1;

import org.apache.commons.io.IOUtils;

/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final CharSequence f1449a;
    private int b = 0;
    private int c;

    public a(CharSequence charSequence) {
        this.f1449a = charSequence;
        this.c = charSequence.length() - 1;
    }

    private int j(int i) {
        this.c = i;
        return i;
    }

    public char a(int i) {
        return this.f1449a.charAt(i);
    }

    public boolean b() {
        return this.b >= this.c;
    }

    public boolean c() {
        return c(this.b + 1);
    }

    public boolean d() {
        return c(this.b);
    }

    public int e() {
        return e(this.b);
    }

    public boolean f(int i) {
        char a2 = a(i);
        return Character.isDigit(a2) || a2 == '-' || a2 == '.';
    }

    public boolean g(int i) {
        return !c(i);
    }

    public char h(int i) {
        do {
            i++;
            if (g(i)) {
                break;
            }
        } while (a(i) == ' ');
        if (g(i)) {
            return ' ';
        }
        return a(i);
    }

    public char i() {
        return i(this.b);
    }

    public int k(int i) {
        this.b = i;
        return i;
    }

    public a l() {
        j();
        k();
        return this;
    }

    public String toString() {
        return this.f1449a.toString();
    }

    private a k() {
        while (d() && this.b < this.c && c(' ')) {
            b(1);
        }
        return this;
    }

    public char a() {
        return this.f1449a.charAt(this.b);
    }

    public int b(int i) {
        return j(this.c - i);
    }

    public boolean c(int i) {
        return i >= 0 && i <= this.c;
    }

    public int d(int i) {
        return k(this.b + i);
    }

    public int e(int i) {
        do {
            i--;
            if (g(i)) {
                break;
            }
        } while (a(i) == ' ');
        if (g(i)) {
            return -1;
        }
        return i;
    }

    public int f() {
        return this.c + 1;
    }

    public char g() {
        return h(this.b);
    }

    public int h() {
        return this.b;
    }

    public char i(int i) {
        int e = e(i);
        if (e == -1) {
            return ' ';
        }
        return a(e);
    }

    public a j() {
        while (d() && this.b < this.c && a() == ' ') {
            d(1);
        }
        return this;
    }

    public boolean a(char c) {
        return this.f1449a.charAt(this.b) == c;
    }

    public int b(char c) {
        return a(this.b, c);
    }

    public boolean c(char c) {
        return this.f1449a.charAt(this.c) == c;
    }

    public boolean d(char c) {
        return c(this.b + 1) && this.f1449a.charAt(this.b + 1) == c;
    }

    public int e(char c) {
        return c(this.b, c);
    }

    public boolean f(char c) {
        return d(this.b, c);
    }

    public void g(char c) {
        if (j().a() != c) {
            throw new sdk.pendo.io.n1.f(String.format("Expected character: %c", Character.valueOf(c)));
        }
        d(1);
    }

    public boolean a(CharSequence charSequence) {
        j();
        if (!c((this.b + charSequence.length()) - 1)) {
            return false;
        }
        int i = this.b;
        if (!a(i, charSequence.length() + i).equals(charSequence)) {
            return false;
        }
        d(charSequence.length());
        return true;
    }

    public int b(int i, char c) {
        while (!g(i)) {
            if (a(i) == c) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public int c(int i, char c) {
        boolean z = false;
        for (int i2 = i + 1; !g(i2); i2++) {
            if (z) {
                z = false;
            } else if ('\\' == a(i2)) {
                z = true;
            } else if (c == a(i2)) {
                return i2;
            }
        }
        return -1;
    }

    public boolean d(int i, char c) {
        int i2 = i + 1;
        while (!g(i2) && a(i2) == ' ') {
            i2++;
        }
        return !g(i2) && a(i2) == c;
    }

    public int a(int i, boolean z, boolean z2) {
        return a(i, '(', ')', z, z2);
    }

    public int a(int i, char c, char c2, boolean z, boolean z2) {
        char a2;
        if (a(i) != c) {
            throw new sdk.pendo.io.n1.f("Expected " + c + " but found " + a(i));
        }
        int i2 = 1;
        int i3 = i + 1;
        while (c(i3)) {
            if (z && ((a2 = a(i3)) == '\'' || a2 == '\"')) {
                int c3 = c(i3, a2);
                if (c3 == -1) {
                    throw new sdk.pendo.io.n1.f("Could not find matching close quote for " + a2 + " when parsing : " + ((Object) this.f1449a));
                }
                i3 = c3 + 1;
            }
            if (z2 && a(i3) == '/') {
                int c4 = c(i3, IOUtils.DIR_SEPARATOR_UNIX);
                if (c4 == -1) {
                    throw new sdk.pendo.io.n1.f("Could not find matching close for / when parsing regex in : " + ((Object) this.f1449a));
                }
                i3 = c4 + 1;
            }
            if (a(i3) == c) {
                i2++;
            }
            if (a(i3) == c2 && i2 - 1 == 0) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public int a(int i, char c) {
        do {
            i++;
            if (g(i)) {
                break;
            }
        } while (a(i) == ' ');
        if (a(i) == c) {
            return i;
        }
        return -1;
    }

    public CharSequence a(int i, int i2) {
        return this.f1449a.subSequence(i, i2);
    }
}
