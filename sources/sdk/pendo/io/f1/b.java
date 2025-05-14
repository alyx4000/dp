package sdk.pendo.io.f1;

import external.sdk.pendo.io.jose4j.jwt.consumer.b;
import external.sdk.pendo.io.jose4j.jwt.consumer.g;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, Object> f1070a;
    private String b;

    private b(String str, g gVar) {
        this.b = str;
        try {
            this.f1070a = new LinkedHashMap(sdk.pendo.io.x0.a.a(str));
        } catch (sdk.pendo.io.k1.g e) {
            throw new external.sdk.pendo.io.jose4j.jwt.consumer.c("Unable to parse what was expected to be the JWT Claim Set JSON: \"" + str + "\"", new b.a(16, "Invalid JSON."), e, gVar);
        }
    }

    private String a(ClassCastException classCastException, Object obj) {
        return "(" + obj + " - " + classCastException.getMessage() + ")";
    }

    public d b() {
        return b("exp");
    }

    public d c() {
        return b("iat");
    }

    public String d() {
        return (String) a("iss", String.class);
    }

    public String e() {
        return (String) a("jti", String.class);
    }

    public d f() {
        return b("nbf");
    }

    public String g() {
        return this.b;
    }

    public String h() {
        return (String) a("sub", String.class);
    }

    public boolean i() {
        return c("aud");
    }

    public String j() {
        return sdk.pendo.io.x0.a.a((Map<String, ?>) this.f1070a);
    }

    public String toString() {
        return "JWT Claims Set:" + this.f1070a;
    }

    public List<String> a() {
        Object obj = this.f1070a.get("aud");
        if (obj instanceof String) {
            return Collections.singletonList((String) obj);
        }
        if ((obj instanceof List) || obj == null) {
            return a((List) obj, "aud");
        }
        throw new c("The value of the 'aud' claim is not an array of strings or a single string value.");
    }

    public d b(String str) {
        Number number = (Number) a(str, Number.class);
        if (number instanceof BigInteger) {
            throw new c(number + " is unreasonable for a NumericDate");
        }
        if (number != null) {
            return d.b(number.longValue());
        }
        return null;
    }

    public boolean c(String str) {
        return a(str) != null;
    }

    public Object a(String str) {
        return this.f1070a.get(str);
    }

    public <T> T a(String str, Class<T> cls) {
        Object obj = this.f1070a.get(str);
        try {
            return cls.cast(obj);
        } catch (ClassCastException e) {
            throw new c("The value of the '" + str + "' claim is not the expected type " + a(e, obj), e);
        }
    }

    public static b a(String str, g gVar) {
        return new b(str, gVar);
    }

    private List<String> a(List list, String str) {
        if (list == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            try {
                arrayList.add((String) obj);
            } catch (ClassCastException e) {
                throw new c("The array value of the '" + str + "' claim contains non string values " + a(e, obj), e);
            }
        }
        return arrayList;
    }
}
