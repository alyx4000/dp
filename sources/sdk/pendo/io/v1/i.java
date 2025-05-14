package sdk.pendo.io.v1;

import androidx.webkit.ProxyConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes4.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private final LinkedList<sdk.pendo.io.n1.l> f1659a;
    private final sdk.pendo.io.o1.a b;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1660a;

        static {
            int[] iArr = new int[sdk.pendo.io.q1.a.values().length];
            f1660a = iArr;
            try {
                iArr[sdk.pendo.io.q1.a.JSON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1660a[sdk.pendo.io.q1.a.PATH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private i(String str, LinkedList<sdk.pendo.io.n1.l> linkedList) {
        this(new sdk.pendo.io.o1.a(str), linkedList);
    }

    private sdk.pendo.io.o1.g a() {
        p b = b();
        return new f(b, b.a().equals("$"));
    }

    private boolean b(char c) {
        return c == ' ' || c == '\t' || c == '\n' || c == '\r';
    }

    private boolean c(k kVar) {
        sdk.pendo.io.o1.a aVar;
        int i;
        if (this.b.a('.') && this.b.d('.')) {
            kVar.a(l.a());
            aVar = this.b;
            i = 2;
        } else {
            if (!this.b.c()) {
                throw new sdk.pendo.io.n1.f("Path must not end with a '.");
            }
            aVar = this.b;
            i = 1;
        }
        aVar.d(i);
        if (this.b.a('.')) {
            throw new sdk.pendo.io.n1.f("Character '.' on position " + this.b.h() + " is not valid.");
        }
        return e(kVar);
    }

    private boolean d(k kVar) {
        int a2;
        int a3;
        if (!this.b.a('[') && !this.b.f('?')) {
            return false;
        }
        int h = this.b.h();
        int b = this.b.b('?');
        if (b == -1 || (a2 = this.b.a(b, '(')) == -1 || (a3 = this.b.a(a2, true, true)) == -1 || !this.b.d(a3, ']')) {
            return false;
        }
        int a4 = this.b.a(a3, ']') + 1;
        kVar.a(l.a(sdk.pendo.io.p1.d.a(this.b.a(h, a4).toString())));
        this.b.k(a4);
        return this.b.b() || e(kVar);
    }

    private boolean e(k kVar) {
        boolean h;
        char a2 = this.b.a();
        String str = "Could not parse token starting at position " + this.b.h();
        if (a2 == '*') {
            h = h(kVar);
        } else if (a2 == '.') {
            h = c(kVar);
        } else if (a2 != '[') {
            h = g(kVar);
        } else {
            str = str + ". Expected ?, ', 0-9, * ";
            h = b(kVar) || a(kVar) || h(kVar) || d(kVar) || f(kVar);
        }
        return h || a(str);
    }

    private boolean f(k kVar) {
        int b;
        int h;
        int b2;
        if (!this.b.a('[') || (b = this.b.b('?')) == -1) {
            return false;
        }
        char h2 = this.b.h(b);
        if ((h2 != ']' && h2 != ',') || (b2 = this.b.b((h = this.b.h() + 1), ']')) == -1) {
            return false;
        }
        String obj = this.b.a(h, b2).toString();
        String[] split = obj.split(",");
        if (this.f1659a.size() < split.length) {
            throw new sdk.pendo.io.n1.f("Not enough predicates supplied for filter [" + obj + "] at position " + this.b.h());
        }
        ArrayList arrayList = new ArrayList();
        int length = split.length;
        for (int i = 0; i < length; i++) {
            String str = split[i];
            String trim = str != null ? str.trim() : null;
            if (!"?".equals(trim == null ? "" : trim)) {
                throw new sdk.pendo.io.n1.f("Expected '?' but found " + trim);
            }
            arrayList.add(this.f1659a.pop());
        }
        kVar.a(l.a(arrayList));
        this.b.k(b2 + 1);
        return this.b.b() || e(kVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0052, code lost:
    
        r3 = false;
        r1 = r5;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean g(sdk.pendo.io.v1.k r10) {
        /*
            r9 = this;
            sdk.pendo.io.o1.a r0 = r9.b
            r1 = 91
            boolean r0 = r0.a(r1)
            r2 = 0
            if (r0 != 0) goto Ldf
            sdk.pendo.io.o1.a r0 = r9.b
            r3 = 42
            boolean r0 = r0.a(r3)
            if (r0 != 0) goto Ldf
            sdk.pendo.io.o1.a r0 = r9.b
            r3 = 46
            boolean r0 = r0.a(r3)
            if (r0 != 0) goto Ldf
            sdk.pendo.io.o1.a r0 = r9.b
            r4 = 32
            boolean r0 = r0.a(r4)
            if (r0 == 0) goto L2b
            goto Ldf
        L2b:
            sdk.pendo.io.o1.a r0 = r9.b
            int r0 = r0.h()
            r5 = r0
        L32:
            sdk.pendo.io.o1.a r6 = r9.b
            boolean r6 = r6.c(r5)
            r7 = 1
            if (r6 == 0) goto L70
            sdk.pendo.io.o1.a r6 = r9.b
            char r6 = r6.a(r5)
            if (r6 == r4) goto L55
            if (r6 == r3) goto L52
            if (r6 != r1) goto L48
            goto L52
        L48:
            r8 = 40
            if (r6 != r8) goto L4f
            r1 = r5
            r3 = r7
            goto L72
        L4f:
            int r5 = r5 + 1
            goto L32
        L52:
            r3 = r2
            r1 = r5
            goto L72
        L55:
            sdk.pendo.io.n1.f r10 = new sdk.pendo.io.n1.f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Use bracket notion ['my prop'] if your property contains blank characters. position: "
            r0.<init>(r1)
            sdk.pendo.io.o1.a r1 = r9.b
            int r1 = r1.h()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            r10.<init>(r0)
            throw r10
        L70:
            r1 = r2
            r3 = r1
        L72:
            if (r1 != 0) goto L7a
            sdk.pendo.io.o1.a r1 = r9.b
            int r1 = r1.f()
        L7a:
            sdk.pendo.io.o1.a r4 = r9.b
            if (r3 == 0) goto Lb2
            int r6 = r5 + 1
            boolean r4 = r4.c(r6)
            if (r4 == 0) goto Lac
            sdk.pendo.io.o1.a r4 = r9.b
            char r4 = r4.a(r6)
            r5 = 41
            if (r4 == r5) goto La6
            sdk.pendo.io.o1.a r4 = r9.b
            int r5 = r1 + 1
            r4.k(r5)
            sdk.pendo.io.o1.a r4 = r9.b
            java.lang.CharSequence r4 = r4.a(r0, r1)
            java.lang.String r4 = r4.toString()
            java.util.List r4 = r9.b(r4)
            goto Lb6
        La6:
            sdk.pendo.io.o1.a r4 = r9.b
            r4.k(r6)
            goto Lb5
        Lac:
            sdk.pendo.io.o1.a r4 = r9.b
            r4.k(r5)
            goto Lb5
        Lb2:
            r4.k(r1)
        Lb5:
            r4 = 0
        Lb6:
            sdk.pendo.io.o1.a r5 = r9.b
            java.lang.CharSequence r0 = r5.a(r0, r1)
            java.lang.String r0 = r0.toString()
            if (r3 == 0) goto Lc7
            sdk.pendo.io.v1.j r0 = sdk.pendo.io.v1.l.a(r0, r4)
            goto Lcd
        Lc7:
            r1 = 39
            sdk.pendo.io.v1.j r0 = sdk.pendo.io.v1.l.a(r0, r1)
        Lcd:
            r10.a(r0)
            sdk.pendo.io.o1.a r0 = r9.b
            boolean r0 = r0.b()
            if (r0 != 0) goto Lde
            boolean r10 = r9.e(r10)
            if (r10 == 0) goto Ldf
        Lde:
            r2 = r7
        Ldf:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.v1.i.g(sdk.pendo.io.v1.k):boolean");
    }

    private boolean h(k kVar) {
        boolean a2 = this.b.a('[');
        if (a2 && !this.b.f('*')) {
            return false;
        }
        if (!this.b.a('*')) {
            sdk.pendo.io.o1.a aVar = this.b;
            if (aVar.g(aVar.h() + 1)) {
                return false;
            }
        }
        if (a2) {
            int b = this.b.b('*');
            if (!this.b.d(b, ']')) {
                throw new sdk.pendo.io.n1.f("Expected wildcard token to end with ']' on position " + (b + 1));
            }
            this.b.k(this.b.a(b, ']') + 1);
        } else {
            this.b.d(1);
        }
        kVar.a(l.b());
        return this.b.b() || e(kVar);
    }

    private i(sdk.pendo.io.o1.a aVar, LinkedList<sdk.pendo.io.n1.l> linkedList) {
        this.f1659a = linkedList;
        this.b = aVar;
    }

    public static sdk.pendo.io.o1.g a(String str, sdk.pendo.io.n1.l... lVarArr) {
        try {
            sdk.pendo.io.o1.a aVar = new sdk.pendo.io.o1.a(str);
            aVar.l();
            if (aVar.a(0) != '$' && aVar.a(0) != '@') {
                aVar = new sdk.pendo.io.o1.a("$." + str);
                aVar.l();
            }
            if (aVar.c('.')) {
                a("Path must not end with a '.' or '..'");
            }
            return new i(aVar, (LinkedList<sdk.pendo.io.n1.l>) new LinkedList(Arrays.asList(lVarArr))).a();
        } catch (Exception e) {
            if (e instanceof sdk.pendo.io.n1.f) {
                throw ((sdk.pendo.io.n1.f) e);
            }
            throw new sdk.pendo.io.n1.f(e);
        }
    }

    private List<sdk.pendo.io.q1.b> b(String str) {
        int intValue;
        int intValue2;
        Integer num = 1;
        Integer num2 = 0;
        Boolean bool = Boolean.FALSE;
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        char c = 0;
        Integer num3 = num2;
        Boolean bool2 = bool;
        sdk.pendo.io.q1.a aVar = null;
        Integer num4 = num3;
        while (this.b.d() && !bool2.booleanValue()) {
            char a2 = this.b.a();
            this.b.d(1);
            if (aVar == null) {
                if (b(a2)) {
                    continue;
                } else if (a2 == '{' || Character.isDigit(a2) || '\"' == a2) {
                    aVar = sdk.pendo.io.q1.a.JSON;
                } else if (a(a2).booleanValue()) {
                    aVar = sdk.pendo.io.q1.a.PATH;
                }
            }
            if (a2 != '\"') {
                if (a2 != ',') {
                    if (a2 == '[') {
                        intValue = num4.intValue() + 1;
                    } else if (a2 != ']') {
                        if (a2 == '{') {
                            intValue2 = num2.intValue() + 1;
                        } else if (a2 != '}') {
                            if (a2 == '(') {
                                num = Integer.valueOf(num.intValue() + 1);
                            } else if (a2 == ')') {
                                num = Integer.valueOf(num.intValue() - 1);
                                if (num.intValue() != 0) {
                                    sb.append(a2);
                                }
                            }
                        } else {
                            if (num2.intValue() == 0) {
                                throw new sdk.pendo.io.n1.f("Unexpected close brace '}' at character position: " + this.b.h());
                            }
                            intValue2 = num2.intValue() - 1;
                        }
                        num2 = Integer.valueOf(intValue2);
                    } else {
                        if (num4.intValue() == 0) {
                            throw new sdk.pendo.io.n1.f("Unexpected close bracket ']' at character position: " + this.b.h());
                        }
                        intValue = num4.intValue() - 1;
                    }
                    num4 = Integer.valueOf(intValue);
                }
                if (num3.intValue() == 0 && num2.intValue() == 0 && num4.intValue() == 0 && ((num.intValue() == 0 && ')' == a2) || 1 == num.intValue())) {
                    bool2 = Boolean.valueOf(num.intValue() == 0);
                    if (aVar != null) {
                        int i = a.f1660a[aVar.ordinal()];
                        sdk.pendo.io.q1.b bVar = i != 1 ? i != 2 ? null : new sdk.pendo.io.q1.b(new i(sb.toString(), (LinkedList<sdk.pendo.io.n1.l>) new LinkedList()).a()) : new sdk.pendo.io.q1.b(sb.toString());
                        if (bVar != null) {
                            arrayList.add(bVar);
                        }
                        sb.delete(0, sb.length());
                        aVar = null;
                    }
                }
            } else {
                num3 = Integer.valueOf((c == '\\' || num3.intValue() <= 0) ? num3.intValue() + 1 : num3.intValue() - 1);
            }
            if (aVar != null && (a2 != ',' || num2.intValue() != 0 || num4.intValue() != 0 || 1 != num.intValue())) {
                sb.append(a2);
            }
            c = a2;
        }
        if (num2.intValue() == 0 && num.intValue() == 0 && num4.intValue() == 0) {
            return arrayList;
        }
        throw new sdk.pendo.io.n1.f("Arguments to function: '" + str + "' are not closed properly.");
    }

    private void c() {
        while (this.b.d() && b(this.b.a())) {
            this.b.d(1);
        }
    }

    public static boolean a(String str) {
        throw new sdk.pendo.io.n1.f(str);
    }

    private boolean b(k kVar) {
        if (!this.b.a('[')) {
            return false;
        }
        char g = this.b.g();
        if (g != '\'' && g != '\"') {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        int h = this.b.h() + 1;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        int i2 = h;
        while (true) {
            if (!this.b.c(h)) {
                break;
            }
            char a2 = this.b.a(h);
            if (z) {
                z = false;
            } else if ('\\' == a2) {
                z = true;
            } else if (a2 != ']' || z2) {
                if (a2 == g) {
                    if (z2) {
                        char h2 = this.b.h(h);
                        if (h2 != ']' && h2 != ',') {
                            a("Property must be separated by comma or Property must be terminated close square bracket at index " + h);
                        }
                        arrayList.add(sdk.pendo.io.o1.i.a(this.b.a(i2, h).toString()));
                        z2 = false;
                        i = h;
                    } else {
                        i2 = h + 1;
                        z3 = false;
                        z2 = true;
                    }
                } else if (a2 == ',') {
                    if (z3) {
                        a("Found empty property at index " + h);
                    }
                    z3 = true;
                }
            } else if (z3) {
                a("Found empty property at index " + h);
            }
            h++;
        }
        if (z2) {
            a("Property has not been closed - missing closing " + g);
        }
        this.b.k(this.b.a(i, ']') + 1);
        kVar.a(l.a(arrayList, g));
        return this.b.b() || e(kVar);
    }

    private Boolean a(char c) {
        return Boolean.valueOf(c == '$' || c == '@');
    }

    private p b() {
        c();
        if (!a(this.b.a()).booleanValue()) {
            throw new sdk.pendo.io.n1.f("Path must start with '$' or '@'");
        }
        p a2 = l.a(this.b.a());
        if (this.b.b()) {
            return a2;
        }
        this.b.d(1);
        if (this.b.a() != '.' && this.b.a() != '[') {
            a("Illegal character at position " + this.b.h() + " expected '.' or '['");
        }
        e(a2.h());
        return a2;
    }

    private boolean a(k kVar) {
        int h;
        int b;
        if (!this.b.a('[')) {
            return false;
        }
        char g = this.b.g();
        if ((!Character.isDigit(g) && g != '-' && g != ':') || (b = this.b.b((h = this.b.h() + 1), ']')) == -1) {
            return false;
        }
        String trim = this.b.a(h, b).toString().trim();
        if (ProxyConfig.MATCH_ALL_SCHEMES.equals(trim)) {
            return false;
        }
        for (int i = 0; i < trim.length(); i++) {
            char charAt = trim.charAt(i);
            if (!Character.isDigit(charAt) && charAt != ',' && charAt != '-' && charAt != ':' && charAt != ' ') {
                return false;
            }
        }
        kVar.a(trim.contains(":") ? l.a(d.a(trim)) : l.a(sdk.pendo.io.v1.a.a(trim)));
        this.b.k(b + 1);
        return this.b.b() || e(kVar);
    }
}
