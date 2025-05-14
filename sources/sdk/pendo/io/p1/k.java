package sdk.pendo.io.p1;

import com.facebook.hermes.intl.Constants;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import sdk.pendo.io.n1.l;
import sdk.pendo.io.v1.m;

/* loaded from: classes6.dex */
public interface k {

    /* renamed from: a, reason: collision with root package name */
    public static final d f1489a = new d();
    public static final a b = new a("true");
    public static final a c = new a(Constants.CASEFIRST_FALSE);
    public static final j d = new j();

    public static class a extends sdk.pendo.io.p1.j {
        private final Boolean f;

        private a(CharSequence charSequence) {
            this.f = Boolean.valueOf(Boolean.parseBoolean(charSequence.toString()));
        }

        @Override // sdk.pendo.io.p1.j
        public a a() {
            return this;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof i) {
                i iVar = (i) obj;
                if (iVar.s().equalsIgnoreCase("true") || iVar.s().equalsIgnoreCase(Constants.CASEFIRST_FALSE)) {
                    obj = new a(iVar.s());
                }
            }
            if (!(obj instanceof a)) {
                return false;
            }
            Boolean bool = this.f;
            Boolean bool2 = ((a) obj).f;
            if (bool != null) {
                if (bool.equals(bool2)) {
                    return true;
                }
            } else if (bool2 == null) {
                return true;
            }
            return false;
        }

        @Override // sdk.pendo.io.p1.j
        public boolean k() {
            return true;
        }

        public boolean s() {
            return this.f.booleanValue();
        }

        public String toString() {
            return this.f.toString();
        }

        @Override // sdk.pendo.io.p1.j
        public Class<?> a(l.a aVar) {
            return Boolean.class;
        }
    }

    public static class b extends sdk.pendo.io.p1.j {
        private final Class f;

        b(Class cls) {
            this.f = cls;
        }

        @Override // sdk.pendo.io.p1.j
        public Class<?> a(l.a aVar) {
            return Class.class;
        }

        @Override // sdk.pendo.io.p1.j
        public b b() {
            return this;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            Class cls = this.f;
            Class cls2 = ((b) obj).f;
            if (cls != null) {
                if (cls.equals(cls2)) {
                    return true;
                }
            } else if (cls2 == null) {
                return true;
            }
            return false;
        }

        public Class s() {
            return this.f;
        }

        public String toString() {
            return this.f.getName();
        }
    }

    public static class c extends sdk.pendo.io.p1.j {
        private final Object f;
        private final boolean s = false;

        c(CharSequence charSequence) {
            this.f = charSequence.toString();
        }

        public boolean a(c cVar, l.a aVar) {
            if (this == cVar) {
                return true;
            }
            Object obj = this.f;
            if (obj != null) {
                if (obj.equals(cVar.g(aVar))) {
                    return true;
                }
            } else if (cVar.f == null) {
                return true;
            }
            return false;
        }

        public sdk.pendo.io.p1.j b(l.a aVar) {
            return !c(aVar) ? k.d : new C0224k(Collections.unmodifiableList((List) g(aVar)));
        }

        @Override // sdk.pendo.io.p1.j
        public c c() {
            return this;
        }

        public boolean d(l.a aVar) {
            return (c(aVar) || e(aVar)) ? ((Collection) g(aVar)).size() == 0 : !(g(aVar) instanceof String) || ((String) g(aVar)).length() == 0;
        }

        public boolean e(l.a aVar) {
            return g(aVar) instanceof Map;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            Object obj2 = this.f;
            Object obj3 = ((c) obj).f;
            if (obj2 != null) {
                if (obj2.equals(obj3)) {
                    return true;
                }
            } else if (obj3 == null) {
                return true;
            }
            return false;
        }

        public int f(l.a aVar) {
            if (c(aVar)) {
                return ((List) g(aVar)).size();
            }
            return -1;
        }

        public Object g(l.a aVar) {
            try {
                return this.s ? this.f : new sdk.pendo.io.d2.a(-1).a(this.f.toString());
            } catch (sdk.pendo.io.d2.e e) {
                throw new IllegalArgumentException(e);
            }
        }

        @Override // sdk.pendo.io.p1.j
        public boolean l() {
            return true;
        }

        public String toString() {
            return this.f.toString();
        }

        c(Object obj) {
            this.f = obj;
        }

        @Override // sdk.pendo.io.p1.j
        public Class<?> a(l.a aVar) {
            return c(aVar) ? List.class : e(aVar) ? Map.class : g(aVar) instanceof Number ? Number.class : g(aVar) instanceof String ? String.class : g(aVar) instanceof Boolean ? Boolean.class : Void.class;
        }

        public boolean c(l.a aVar) {
            return g(aVar) instanceof List;
        }
    }

    public static class d extends sdk.pendo.io.p1.j {
        private d() {
        }

        @Override // sdk.pendo.io.p1.j
        public Class<?> a(l.a aVar) {
            return Void.class;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof d);
        }

        public String toString() {
            return "null";
        }
    }

    public static class e extends sdk.pendo.io.p1.j {
        public static e s = new e((BigDecimal) null);
        private final BigDecimal f;

        e(CharSequence charSequence) {
            this.f = new BigDecimal(charSequence.toString());
        }

        @Override // sdk.pendo.io.p1.j
        public Class<?> a(l.a aVar) {
            return Number.class;
        }

        @Override // sdk.pendo.io.p1.j
        public e d() {
            return this;
        }

        public boolean equals(Object obj) {
            e d;
            if (this == obj) {
                return true;
            }
            return ((obj instanceof e) || (obj instanceof i)) && (d = ((sdk.pendo.io.p1.j) obj).d()) != s && this.f.compareTo(d.f) == 0;
        }

        @Override // sdk.pendo.io.p1.j
        public i h() {
            return new i(this.f.toString(), false);
        }

        @Override // sdk.pendo.io.p1.j
        public boolean m() {
            return true;
        }

        public BigDecimal s() {
            return this.f;
        }

        public String toString() {
            return this.f.toString();
        }

        e(BigDecimal bigDecimal) {
            this.f = bigDecimal;
        }
    }

    public static class f extends sdk.pendo.io.p1.j {
        private static final sdk.pendo.io.h7.a f0 = sdk.pendo.io.h7.b.a((Class<?>) f.class);
        private final boolean A;
        private final sdk.pendo.io.o1.g f;
        private final boolean s;

        f(CharSequence charSequence, boolean z, boolean z2) {
            this(sdk.pendo.io.v1.i.a(charSequence.toString(), new l[0]), z, z2);
        }

        public f a(boolean z) {
            return new f(this.f, true, z);
        }

        public sdk.pendo.io.p1.j b(l.a aVar) {
            Object value;
            if (s()) {
                try {
                    return this.f.a(aVar.c(), aVar.b(), sdk.pendo.io.n1.a.a().a(aVar.a().f()).a(sdk.pendo.io.n1.i.REQUIRE_PROPERTIES).a()).a(false) == sdk.pendo.io.x1.b.f1745a ? k.c : k.b;
                } catch (sdk.pendo.io.n1.k unused) {
                    return k.c;
                }
            }
            try {
                if (aVar instanceof m) {
                    value = ((m) aVar).a(this.f);
                } else {
                    value = this.f.a(this.f.b() ? aVar.b() : aVar.c(), aVar.b(), aVar.a()).getValue();
                }
                Object g = aVar.a().f().g(value);
                if (g instanceof Number) {
                    return sdk.pendo.io.p1.j.c((CharSequence) g.toString());
                }
                if (g instanceof String) {
                    return sdk.pendo.io.p1.j.a(g.toString(), false);
                }
                if (g instanceof Boolean) {
                    return sdk.pendo.io.p1.j.a((CharSequence) g.toString());
                }
                if (g == null) {
                    return k.f1489a;
                }
                if (aVar.a().f().e(g)) {
                    return sdk.pendo.io.p1.j.a(aVar.a().g().a(g, List.class, aVar.a()));
                }
                if (aVar.a().f().a(g)) {
                    return sdk.pendo.io.p1.j.a(aVar.a().g().a(g, Map.class, aVar.a()));
                }
                throw new sdk.pendo.io.n1.h("Could not convert " + g.toString() + " to a ValueNode");
            } catch (sdk.pendo.io.n1.k unused2) {
                return k.d;
            }
        }

        @Override // sdk.pendo.io.p1.j
        public f e() {
            return this;
        }

        @Override // sdk.pendo.io.p1.j
        public boolean n() {
            return true;
        }

        public boolean s() {
            return this.s;
        }

        public boolean t() {
            return this.A;
        }

        public String toString() {
            return (!this.s || this.A) ? this.f.toString() : sdk.pendo.io.o1.i.a("!", this.f.toString());
        }

        f(sdk.pendo.io.o1.g gVar, boolean z, boolean z2) {
            this.f = gVar;
            this.s = z;
            this.A = z2;
            f0.b("PathNode {} existsCheck: {}", gVar, Boolean.valueOf(z));
        }

        @Override // sdk.pendo.io.p1.j
        public Class<?> a(l.a aVar) {
            return Void.class;
        }
    }

    public static class g extends sdk.pendo.io.p1.j {
        private final String A;
        private final String f;
        private final Pattern s;

        g(CharSequence charSequence) {
            String obj = charSequence.toString();
            int indexOf = obj.indexOf(47);
            int lastIndexOf = obj.lastIndexOf(47);
            String substring = obj.substring(indexOf + 1, lastIndexOf);
            this.f = substring;
            int i = lastIndexOf + 1;
            String substring2 = obj.length() > i ? obj.substring(i) : "";
            this.A = substring2;
            this.s = Pattern.compile(substring, sdk.pendo.io.p1.g.a(substring2.toCharArray()));
        }

        @Override // sdk.pendo.io.p1.j
        public Class<?> a(l.a aVar) {
            return Void.TYPE;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            Pattern pattern = this.s;
            Pattern pattern2 = ((g) obj).s;
            if (pattern != null) {
                if (pattern.equals(pattern2)) {
                    return true;
                }
            } else if (pattern2 == null) {
                return true;
            }
            return false;
        }

        @Override // sdk.pendo.io.p1.j
        public g f() {
            return this;
        }

        @Override // sdk.pendo.io.p1.j
        public boolean o() {
            return true;
        }

        Pattern s() {
            return this.s;
        }

        public String toString() {
            return !this.f.startsWith("/") ? "/" + this.f + "/" + this.A : this.f;
        }

        g(Pattern pattern) {
            this.f = pattern.pattern();
            this.s = pattern;
            this.A = sdk.pendo.io.p1.g.a(pattern.flags());
        }
    }

    public static class h extends sdk.pendo.io.p1.j {
    }

    public static class i extends sdk.pendo.io.p1.j {
        private final String f;
        private boolean s;

        i(CharSequence charSequence, boolean z) {
            String obj;
            this.s = true;
            if (!z || charSequence.length() <= 1) {
                obj = charSequence.toString();
            } else {
                char charAt = charSequence.charAt(0);
                char charAt2 = charSequence.charAt(charSequence.length() - 1);
                if (charAt == '\'' && charAt2 == '\'') {
                    charSequence = charSequence.subSequence(1, charSequence.length() - 1);
                } else if (charAt == '\"' && charAt2 == '\"') {
                    charSequence = charSequence.subSequence(1, charSequence.length() - 1);
                    this.s = false;
                }
                obj = sdk.pendo.io.o1.i.a(charSequence.toString());
            }
            this.f = obj;
        }

        public boolean a(String str) {
            return s().contains(str);
        }

        @Override // sdk.pendo.io.p1.j
        public e d() {
            try {
                return new e(new BigDecimal(this.f));
            } catch (NumberFormatException unused) {
                return e.s;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i) && !(obj instanceof e) && !(obj instanceof a)) {
                return false;
            }
            i iVar = obj instanceof a ? new i(((a) obj).f.toString(), false) : ((sdk.pendo.io.p1.j) obj).h();
            String str = this.f;
            if (str != null) {
                if (str.equals(iVar.s())) {
                    return true;
                }
            } else if (iVar.s() == null) {
                return true;
            }
            return false;
        }

        @Override // sdk.pendo.io.p1.j
        public i h() {
            return this;
        }

        public boolean isEmpty() {
            return s().isEmpty();
        }

        @Override // sdk.pendo.io.p1.j
        public boolean p() {
            return true;
        }

        public String s() {
            return this.f;
        }

        public int t() {
            return s().length();
        }

        public String toString() {
            String str = this.s ? "'" : "\"";
            return str + sdk.pendo.io.o1.i.a(this.f, true) + str;
        }

        @Override // sdk.pendo.io.p1.j
        public Class<?> a(l.a aVar) {
            return String.class;
        }
    }

    public static class j extends sdk.pendo.io.p1.j {
        @Override // sdk.pendo.io.p1.j
        public Class<?> a(l.a aVar) {
            return Void.class;
        }

        public boolean equals(Object obj) {
            return false;
        }

        @Override // sdk.pendo.io.p1.j
        public boolean q() {
            return true;
        }
    }

    /* renamed from: sdk.pendo.io.p1.k$k, reason: collision with other inner class name */
    public static class C0224k extends sdk.pendo.io.p1.j implements Iterable<sdk.pendo.io.p1.j> {
        private List<sdk.pendo.io.p1.j> f = new ArrayList();

        public C0224k(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                this.f.add(sdk.pendo.io.p1.j.d(it.next()));
            }
        }

        public boolean a(sdk.pendo.io.p1.j jVar) {
            return this.f.contains(jVar);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof C0224k) {
                return this.f.equals(((C0224k) obj).f);
            }
            return false;
        }

        @Override // sdk.pendo.io.p1.j
        public C0224k i() {
            return this;
        }

        @Override // java.lang.Iterable
        public Iterator<sdk.pendo.io.p1.j> iterator() {
            return this.f.iterator();
        }

        @Override // sdk.pendo.io.p1.j
        public boolean r() {
            return true;
        }

        public String toString() {
            return "[" + sdk.pendo.io.o1.i.a(",", this.f) + "]";
        }

        public boolean a(C0224k c0224k) {
            Iterator<sdk.pendo.io.p1.j> it = this.f.iterator();
            while (it.hasNext()) {
                if (!c0224k.f.contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // sdk.pendo.io.p1.j
        public Class<?> a(l.a aVar) {
            return List.class;
        }
    }
}
