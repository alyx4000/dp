package sdk.pendo.io.d2;

import sdk.pendo.io.b2.i;
import sdk.pendo.io.f2.k;

/* loaded from: classes6.dex */
class d extends c {
    private String z;

    public d(int i) {
        super(i);
    }

    @Override // sdk.pendo.io.d2.c
    protected void a(int i, int i2) {
        this.f = this.z.substring(i, i2);
    }

    @Override // sdk.pendo.io.d2.c
    protected void b(int i, int i2) {
        while (i < i2 - 1 && Character.isWhitespace(this.z.charAt(i))) {
            i++;
        }
        while (true) {
            int i3 = i2 - 1;
            if (i3 <= i || !Character.isWhitespace(this.z.charAt(i3))) {
                break;
            } else {
                i2--;
            }
        }
        a(i, i2);
    }

    @Override // sdk.pendo.io.d2.b
    protected void d() {
        int i = this.g + 1;
        this.g = i;
        this.f983a = i >= this.y ? (char) 26 : this.z.charAt(i);
    }

    @Override // sdk.pendo.io.d2.b
    protected void e() {
        int i = this.g + 1;
        this.g = i;
        if (i < this.y) {
            this.f983a = this.z.charAt(i);
        } else {
            this.f983a = (char) 26;
            throw new e(this.g - 1, 3, "EOF");
        }
    }

    @Override // sdk.pendo.io.d2.b
    protected void f() {
        int i = this.g + 1;
        this.g = i;
        this.f983a = i >= this.y ? (char) 26 : this.z.charAt(i);
    }

    @Override // sdk.pendo.io.d2.c
    protected int a(char c, int i) {
        return this.z.indexOf(c, i);
    }

    public Object b(String str) {
        return a(str, i.c.b);
    }

    public <T> T a(String str, k<T> kVar) {
        this.b = kVar.f1073a;
        this.z = str;
        this.y = str.length();
        return (T) a(kVar);
    }
}
