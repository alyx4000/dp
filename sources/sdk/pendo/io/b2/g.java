package sdk.pendo.io.b2;

import kotlin.text.Typography;
import sdk.pendo.io.b2.j;

/* loaded from: classes6.dex */
public class g {
    public static final g h = new g(0);
    public static final g i = new g(-1);
    public static final g j = new g(2);

    /* renamed from: a, reason: collision with root package name */
    private boolean f882a;
    private boolean b;
    private boolean c;
    private boolean d;
    private j.g e;
    private j.g f;
    private j.h g;

    public g(int i2) {
        boolean z = (i2 & 1) == 0;
        this.f882a = z;
        boolean z2 = (i2 & 4) == 0;
        this.c = z2;
        boolean z3 = (i2 & 2) == 0;
        this.b = z3;
        this.d = (i2 & 16) > 0;
        j.g gVar = (i2 & 8) > 0 ? j.c : j.f885a;
        if (z2) {
            this.f = j.b;
        } else {
            this.f = gVar;
        }
        this.e = z ? j.b : gVar;
        this.g = z3 ? j.e : j.d;
    }

    public void a(Appendable appendable) {
        appendable.append(',');
    }

    public void b(Appendable appendable) {
    }

    public void c(Appendable appendable) {
        appendable.append('[');
    }

    public void d(Appendable appendable) {
        appendable.append(']');
    }

    public void e(Appendable appendable) {
    }

    public void f(Appendable appendable) {
    }

    public void g(Appendable appendable) {
        appendable.append(':');
    }

    public void h(Appendable appendable) {
    }

    public void i(Appendable appendable) {
        appendable.append(',');
    }

    public void j(Appendable appendable) {
        appendable.append('{');
    }

    public void k(Appendable appendable) {
        appendable.append('}');
    }

    public void a(String str, Appendable appendable) {
        this.g.a(str, appendable);
    }

    public boolean b(String str) {
        return this.f.a(str);
    }

    public boolean a() {
        return this.d;
    }

    public boolean a(String str) {
        return this.e.a(str);
    }

    public void a(Appendable appendable, String str) {
        if (!b(str)) {
            appendable.append(str);
            return;
        }
        appendable.append(Typography.quote);
        i.a(str, appendable, this);
        appendable.append(Typography.quote);
    }
}
