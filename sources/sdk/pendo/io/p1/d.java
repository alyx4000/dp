package sdk.pendo.io.p1;

import com.facebook.hermes.intl.Constants;
import java.util.ArrayList;
import kotlin.text.Typography;
import org.apache.commons.io.IOUtils;
import sdk.pendo.io.n1.l;
import sdk.pendo.io.p1.k;

/* loaded from: classes6.dex */
public class d {
    private static final sdk.pendo.io.h7.a b = sdk.pendo.io.h7.b.a((Class<?>) d.class);
    static final /* synthetic */ boolean c = true;

    /* renamed from: a, reason: collision with root package name */
    private sdk.pendo.io.o1.a f1485a;

    private static final class a extends sdk.pendo.io.n1.d {

        /* renamed from: a, reason: collision with root package name */
        private final l f1486a;

        private a(l lVar) {
            this.f1486a = lVar;
        }

        @Override // sdk.pendo.io.n1.l
        public boolean a(l.a aVar) {
            return this.f1486a.a(aVar);
        }

        public String toString() {
            StringBuilder append;
            String str;
            String obj = this.f1486a.toString();
            if (obj.startsWith("(")) {
                append = new StringBuilder("[?").append(obj);
                str = "]";
            } else {
                append = new StringBuilder("[?(").append(obj);
                str = ")]";
            }
            return append.append(str).toString();
        }
    }

    private d(String str) {
        sdk.pendo.io.o1.a aVar = new sdk.pendo.io.o1.a(str);
        this.f1485a = aVar;
        aVar.l();
        if (!this.f1485a.a('[') || !this.f1485a.c(']')) {
            throw new sdk.pendo.io.n1.f("Filter must start with '[' and end with ']'. " + str);
        }
        this.f1485a.d(1);
        this.f1485a.b(1);
        this.f1485a.l();
        if (!this.f1485a.a('?')) {
            throw new sdk.pendo.io.n1.f("Filter must start with '[?' and end with ']'. " + str);
        }
        this.f1485a.d(1);
        this.f1485a.l();
        if (!this.f1485a.a('(') || !this.f1485a.c(')')) {
            throw new sdk.pendo.io.n1.f("Filter must start with '[?(' and end with ')]'. " + str);
        }
    }

    public static sdk.pendo.io.n1.d a(String str) {
        return new a(new d(str).a());
    }

    private boolean a(char c2) {
        return c2 == '<' || c2 == '>' || c2 == '=' || c2 == '~' || c2 == '!';
    }

    private int b(int i) {
        char[] cArr = new char[1];
        while (this.f1485a.c(i)) {
            cArr[0] = this.f1485a.a(i);
            if (g.a(cArr) <= 0) {
                break;
            }
            i++;
        }
        return i;
    }

    private h c() {
        j n = n();
        try {
            return new h(n, m(), n());
        } catch (sdk.pendo.io.n1.f unused) {
            this.f1485a.k(this.f1485a.h());
            k.f e = n.e();
            k.f a2 = e.a(e.t());
            return new h(a2, i.EXISTS, a2.e().t() ? k.b : k.c);
        }
    }

    private k.c d() {
        int h = this.f1485a.h();
        char a2 = this.f1485a.a();
        if (!c && a2 != '[' && a2 != '{') {
            throw new AssertionError();
        }
        char c2 = a2 == '[' ? ']' : '}';
        sdk.pendo.io.o1.a aVar = this.f1485a;
        int a3 = aVar.a(aVar.h(), a2, c2, true, false);
        if (a3 == -1) {
            throw new sdk.pendo.io.n1.f("String not closed. Expected ' in " + this.f1485a);
        }
        this.f1485a.k(a3 + 1);
        sdk.pendo.io.o1.a aVar2 = this.f1485a;
        CharSequence a4 = aVar2.a(h, aVar2.h());
        b.b("JsonLiteral from {} to {} -> [{}]", Integer.valueOf(h), Integer.valueOf(this.f1485a.h()), a4);
        return j.b(a4);
    }

    private j e() {
        char a2 = this.f1485a.j().a();
        return a2 != '\"' ? a2 != '\'' ? a2 != '-' ? a2 != '/' ? a2 != '[' ? a2 != 'f' ? a2 != 'n' ? a2 != 't' ? a2 != '{' ? j() : d() : b() : i() : b() : d() : l() : j() : b('\'') : b(Typography.quote);
    }

    private c f() {
        int h;
        ArrayList arrayList = new ArrayList();
        do {
            arrayList.add(g());
            h = this.f1485a.h();
        } while (this.f1485a.a(f.AND.b()));
        this.f1485a.k(h);
        return 1 == arrayList.size() ? (c) arrayList.get(0) : e.a(arrayList);
    }

    private c g() {
        int h = this.f1485a.j().h();
        if (this.f1485a.j().a('!')) {
            this.f1485a.g('!');
            char a2 = this.f1485a.j().a();
            if (a2 != '$' && a2 != '@') {
                return e.a(g());
            }
            this.f1485a.k(h);
        }
        if (!this.f1485a.j().a('(')) {
            return c();
        }
        this.f1485a.g('(');
        c h2 = h();
        this.f1485a.g(')');
        return h2;
    }

    private c h() {
        int h;
        ArrayList arrayList = new ArrayList();
        do {
            arrayList.add(f());
            h = this.f1485a.h();
        } while (this.f1485a.a(f.OR.b()));
        this.f1485a.k(h);
        return 1 == arrayList.size() ? (c) arrayList.get(0) : e.b(arrayList);
    }

    private k.d i() {
        int h = this.f1485a.h();
        if (this.f1485a.a() == 'n') {
            sdk.pendo.io.o1.a aVar = this.f1485a;
            if (aVar.c(aVar.h() + 3)) {
                sdk.pendo.io.o1.a aVar2 = this.f1485a;
                CharSequence a2 = aVar2.a(aVar2.h(), this.f1485a.h() + 4);
                if ("null".equals(a2.toString())) {
                    b.b("NullLiteral from {} to {} -> [{}]", Integer.valueOf(h), Integer.valueOf(this.f1485a.h() + 3), a2);
                    this.f1485a.d(a2.length());
                    return j.j();
                }
            }
        }
        throw new sdk.pendo.io.n1.f("Expected <null> value");
    }

    private k.e j() {
        int h = this.f1485a.h();
        while (this.f1485a.d()) {
            sdk.pendo.io.o1.a aVar = this.f1485a;
            if (!aVar.f(aVar.h())) {
                break;
            }
            this.f1485a.d(1);
        }
        sdk.pendo.io.o1.a aVar2 = this.f1485a;
        CharSequence a2 = aVar2.a(h, aVar2.h());
        b.b("NumberLiteral from {} to {} -> [{}]", Integer.valueOf(h), Integer.valueOf(this.f1485a.h()), a2);
        return j.c(a2);
    }

    private k.f k() {
        char i = this.f1485a.i();
        int h = this.f1485a.h();
        sdk.pendo.io.o1.a aVar = this.f1485a;
        while (true) {
            aVar.d(1);
            if (!this.f1485a.d()) {
                break;
            }
            if (this.f1485a.a() == '[') {
                sdk.pendo.io.o1.a aVar2 = this.f1485a;
                int a2 = aVar2.a(aVar2.h(), '[', ']', true, false);
                if (a2 == -1) {
                    throw new sdk.pendo.io.n1.f("Square brackets does not match in filter " + this.f1485a);
                }
                this.f1485a.k(a2 + 1);
            }
            boolean z = this.f1485a.a() == ')' && !(this.f1485a.a() == ')' && a(h));
            if (!this.f1485a.d() || a(this.f1485a.a()) || this.f1485a.a() == ' ' || z) {
                break;
            }
            aVar = this.f1485a;
        }
        boolean z2 = i != '!';
        sdk.pendo.io.o1.a aVar3 = this.f1485a;
        return j.a(aVar3.a(h, aVar3.h()), false, z2);
    }

    private k.g l() {
        int b2;
        int h = this.f1485a.h();
        int e = this.f1485a.e(IOUtils.DIR_SEPARATOR_UNIX);
        if (e == -1) {
            throw new sdk.pendo.io.n1.f("Pattern not closed. Expected / in " + this.f1485a);
        }
        int i = e + 1;
        if (this.f1485a.c(i) && (b2 = b(i)) > e) {
            e += this.f1485a.a(i, b2).length();
        }
        this.f1485a.k(e + 1);
        sdk.pendo.io.o1.a aVar = this.f1485a;
        CharSequence a2 = aVar.a(h, aVar.h());
        b.b("PatternNode from {} to {} -> [{}]", Integer.valueOf(h), Integer.valueOf(this.f1485a.h()), a2);
        return j.d(a2);
    }

    private i m() {
        int h = this.f1485a.j().h();
        if (a(this.f1485a.a())) {
            while (this.f1485a.d() && a(this.f1485a.a())) {
                this.f1485a.d(1);
            }
        } else {
            while (this.f1485a.d() && this.f1485a.a() != ' ') {
                this.f1485a.d(1);
            }
        }
        sdk.pendo.io.o1.a aVar = this.f1485a;
        CharSequence a2 = aVar.a(h, aVar.h());
        b.b("Operator from {} to {} -> [{}]", Integer.valueOf(h), Integer.valueOf(this.f1485a.h() - 1), a2);
        return i.a(a2.toString());
    }

    private j n() {
        char a2 = this.f1485a.j().a();
        if (a2 != '!') {
            if (a2 != '$' && a2 != '@') {
                return e();
            }
            return k();
        }
        this.f1485a.d(1);
        char a3 = this.f1485a.j().a();
        if (a3 != '$' && a3 != '@') {
            throw new sdk.pendo.io.n1.f(String.format("Unexpected character: %c", '!'));
        }
        return k();
    }

    private k.a b() {
        int h = this.f1485a.h();
        int h2 = this.f1485a.a() == 't' ? this.f1485a.h() + 3 : this.f1485a.h() + 4;
        if (!this.f1485a.c(h2)) {
            throw new sdk.pendo.io.n1.f("Expected boolean literal");
        }
        CharSequence a2 = this.f1485a.a(h, h2 + 1);
        if (!a2.equals("true") && !a2.equals(Constants.CASEFIRST_FALSE)) {
            throw new sdk.pendo.io.n1.f("Expected boolean literal");
        }
        this.f1485a.d(a2.length());
        b.b("BooleanLiteral from {} to {} -> [{}]", Integer.valueOf(h), Integer.valueOf(h2), a2);
        return j.a(a2);
    }

    public l a() {
        try {
            c h = h();
            this.f1485a.j();
            if (!this.f1485a.d()) {
                return h;
            }
            sdk.pendo.io.o1.a aVar = this.f1485a;
            throw new sdk.pendo.io.n1.f(String.format("Expected end of filter expression instead of: %s", aVar.a(aVar.h(), this.f1485a.f())));
        } catch (sdk.pendo.io.n1.f e) {
            throw e;
        } catch (Exception unused) {
            throw new sdk.pendo.io.n1.f("Failed to parse filter: " + this.f1485a + ", error on position: " + this.f1485a.h() + ", char: " + this.f1485a.a());
        }
    }

    private boolean a(int i) {
        int e;
        if (this.f1485a.a() == ')' && (e = this.f1485a.e()) != -1 && this.f1485a.a(e) == '(') {
            do {
                e--;
                if (this.f1485a.c(e) && e > i) {
                }
            } while (this.f1485a.a(e) != '.');
            return true;
        }
        return false;
    }

    private k.i b(char c2) {
        int h = this.f1485a.h();
        int e = this.f1485a.e(c2);
        if (e == -1) {
            throw new sdk.pendo.io.n1.f("String literal does not have matching quotes. Expected " + c2 + " in " + this.f1485a);
        }
        this.f1485a.k(e + 1);
        sdk.pendo.io.o1.a aVar = this.f1485a;
        CharSequence a2 = aVar.a(h, aVar.h());
        b.b("StringLiteral from {} to {} -> [{}]", Integer.valueOf(h), Integer.valueOf(this.f1485a.h()), a2);
        return j.a(a2, true);
    }
}
