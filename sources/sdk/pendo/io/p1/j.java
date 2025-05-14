package sdk.pendo.io.p1;

import java.util.regex.Pattern;
import sdk.pendo.io.n1.l;
import sdk.pendo.io.p1.k;

/* loaded from: classes6.dex */
public abstract class j {
    public static k.d j() {
        return k.f1489a;
    }

    public abstract Class<?> a(l.a aVar);

    public k.a a() {
        throw new sdk.pendo.io.n1.f("Expected boolean node");
    }

    public k.b b() {
        throw new sdk.pendo.io.n1.f("Expected class node");
    }

    public k.c c() {
        throw new sdk.pendo.io.n1.f("Expected json node");
    }

    public k.e d() {
        throw new sdk.pendo.io.n1.f("Expected number node");
    }

    public k.f e() {
        throw new sdk.pendo.io.n1.f("Expected path node");
    }

    public k.g f() {
        throw new sdk.pendo.io.n1.f("Expected regexp node");
    }

    public k.h g() {
        throw new sdk.pendo.io.n1.f("Expected predicate node");
    }

    public k.i h() {
        throw new sdk.pendo.io.n1.f("Expected string node");
    }

    public k.C0224k i() {
        throw new sdk.pendo.io.n1.f("Expected value list node");
    }

    public boolean k() {
        return false;
    }

    public boolean l() {
        return false;
    }

    public boolean m() {
        return false;
    }

    public boolean n() {
        return false;
    }

    public boolean o() {
        return false;
    }

    public boolean p() {
        return false;
    }

    public boolean q() {
        return false;
    }

    public boolean r() {
        return false;
    }

    public static k.a a(CharSequence charSequence) {
        return Boolean.parseBoolean(charSequence.toString()) ? k.b : k.c;
    }

    public static k.c b(CharSequence charSequence) {
        return new k.c(charSequence);
    }

    public static k.e c(CharSequence charSequence) {
        return new k.e(charSequence);
    }

    public static k.g d(CharSequence charSequence) {
        return new k.g(charSequence);
    }

    public static k.b a(Class<?> cls) {
        return new k.b(cls);
    }

    private static boolean b(Object obj) {
        if (obj != null && (obj instanceof String)) {
            String trim = obj.toString().trim();
            if (trim.length() <= 1) {
                return false;
            }
            char charAt = trim.charAt(0);
            char charAt2 = trim.charAt(trim.length() - 1);
            if ((charAt == '[' && charAt2 == ']') || (charAt == '{' && charAt2 == '}')) {
                try {
                    new sdk.pendo.io.d2.a(-1).a(trim);
                    return true;
                } catch (Exception unused) {
                }
            }
        }
        return false;
    }

    private static boolean c(Object obj) {
        if (obj != null && (obj instanceof String)) {
            String trim = obj.toString().trim();
            if (trim.length() <= 0) {
                return false;
            }
            char charAt = trim.charAt(0);
            if (charAt != '@' && charAt != '$') {
                return false;
            }
            try {
                sdk.pendo.io.v1.i.a(trim, new l[0]);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static j d(Object obj) {
        if (obj == null) {
            return k.f1489a;
        }
        if (obj instanceof j) {
            return (j) obj;
        }
        if (obj instanceof Class) {
            return a((Class<?>) obj);
        }
        if (c(obj)) {
            return new k.f((CharSequence) obj.toString(), false, false);
        }
        if (b(obj)) {
            return b((CharSequence) obj.toString());
        }
        if (obj instanceof String) {
            return a(obj.toString(), true);
        }
        if (obj instanceof Character) {
            return a(obj.toString(), false);
        }
        if (obj instanceof Number) {
            return c((CharSequence) obj.toString());
        }
        if (obj instanceof Boolean) {
            return a((CharSequence) obj.toString());
        }
        if (obj instanceof Pattern) {
            return a((Pattern) obj);
        }
        throw new sdk.pendo.io.n1.h("Could not determine value type");
    }

    public static k.c a(Object obj) {
        return new k.c(obj);
    }

    public static k.f a(CharSequence charSequence, boolean z, boolean z2) {
        return new k.f(charSequence, z, z2);
    }

    public static k.g a(Pattern pattern) {
        return new k.g(pattern);
    }

    public static k.i a(CharSequence charSequence, boolean z) {
        return new k.i(charSequence, z);
    }
}
