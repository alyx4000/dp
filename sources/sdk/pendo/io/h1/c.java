package sdk.pendo.io.h1;

import java.security.Key;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import sdk.pendo.io.b1.o;
import sdk.pendo.io.e1.e;
import sdk.pendo.io.k1.g;

/* loaded from: classes6.dex */
public abstract class c {
    private static final sdk.pendo.io.w0.a j = new sdk.pendo.io.w0.a();
    private byte[] c;
    private Key d;
    protected String f;

    /* renamed from: a, reason: collision with root package name */
    protected sdk.pendo.io.u0.b f1155a = new sdk.pendo.io.u0.b();
    protected b b = new b();
    protected boolean e = true;
    private sdk.pendo.io.a1.c g = sdk.pendo.io.a1.c.c;
    private Set<String> h = Collections.emptySet();
    private sdk.pendo.io.w0.a i = j;

    protected void a() {
        List<String> asList;
        Object b = this.b.b("crit");
        if (b != null) {
            if (b instanceof List) {
                asList = (List) b;
            } else {
                if (!(b instanceof String[])) {
                    throw new g("crit header value not an array (" + b.getClass() + ").");
                }
                asList = Arrays.asList((String[]) b);
            }
            for (String str : asList) {
                if (!this.h.contains(str) && !c(str)) {
                    throw new g("Unrecognized header '" + str + "' marked as critical.");
                }
            }
        }
    }

    protected abstract void a(String[] strArr);

    protected sdk.pendo.io.a1.c b() {
        return this.g;
    }

    public String c() {
        return b("alg");
    }

    protected boolean c(String str) {
        return false;
    }

    public String d() {
        return b("cty");
    }

    protected String e() {
        return this.b.a();
    }

    public b f() {
        return this.b;
    }

    protected byte[] g() {
        return this.c;
    }

    public Key h() {
        return this.d;
    }

    protected sdk.pendo.io.w0.a i() {
        return this.i;
    }

    public boolean j() {
        return this.e;
    }

    protected void k() {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append(f().b());
        if (this.f != null) {
            sb.append("->").append(this.f);
        }
        return sb.toString();
    }

    protected void a(String str, String str2) {
        if (str == null || str.length() == 0) {
            throw new g("The " + str2 + " cannot be empty.");
        }
    }

    public String b(String str) {
        return this.b.c(str);
    }

    protected void d(String str) {
        a(str, "Encoded Header");
        this.b.d(str);
    }

    public static c a(String str) {
        c eVar;
        String[] a2 = a.a(str);
        if (a2.length == 5) {
            eVar = new o();
        } else {
            if (a2.length != 3) {
                throw new g("Invalid JOSE Compact Serialization. Expecting either 3 or 5 parts for JWS or JWE respectively but was " + a2.length + ".");
            }
            eVar = new e();
        }
        eVar.a(a2);
        eVar.f = str;
        return eVar;
    }

    public void a(sdk.pendo.io.a1.c cVar) {
        this.g = cVar;
    }

    public void a(boolean z) {
        this.e = z;
    }

    protected void a(byte[] bArr) {
        this.c = bArr;
    }

    public void a(Key key) {
        Key key2 = this.d;
        if (!(key != null ? !(key2 == null || !key.equals(key2)) : key2 == null)) {
            k();
        }
        this.d = key;
    }

    public void a(sdk.pendo.io.w0.a aVar) {
        this.i = aVar;
    }
}
