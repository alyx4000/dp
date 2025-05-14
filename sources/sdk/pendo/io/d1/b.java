package sdk.pendo.io.d1;

import java.io.Serializable;
import java.security.Key;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import sdk.pendo.io.k1.g;
import sdk.pendo.io.k1.h;

/* loaded from: classes6.dex */
public abstract class b implements Serializable {
    private String A;
    private String f;
    private List<String> f0;
    private String s;
    protected Map<String, Object> t0;
    protected Key u0;

    public static class a {
        public static b a(String str) {
            return a(sdk.pendo.io.x0.a.a(str));
        }

        public static b a(Map<String, Object> map) {
            String b;
            b = b.b(map, "kty");
            b.hashCode();
            b.hashCode();
            switch (b) {
                case "EC":
                    return new sdk.pendo.io.d1.a(map);
                case "OKP":
                    return new c(map);
                case "RSA":
                    return new f(map);
                case "oct":
                    return new d(map);
                default:
                    throw new g("Unknown key type algorithm: '" + b + "'");
            }
        }
    }

    /* renamed from: sdk.pendo.io.d1.b$b, reason: collision with other inner class name */
    public enum EnumC0109b {
        INCLUDE_PRIVATE,
        INCLUDE_SYMMETRIC,
        PUBLIC_ONLY
    }

    protected b(Key key) {
        this.t0 = new LinkedHashMap();
        this.u0 = key;
    }

    public Key a() {
        return this.u0;
    }

    protected abstract void a(Map<String, Object> map, EnumC0109b enumC0109b);

    public String b() {
        return this.s;
    }

    public abstract String c();

    public void c(String str) {
        this.f = str;
    }

    public String e() {
        return this.f;
    }

    public String getAlgorithm() {
        return this.A;
    }

    public String toString() {
        return getClass().getName() + a(EnumC0109b.PUBLIC_ONLY);
    }

    protected b(Map<String, Object> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.t0 = linkedHashMap;
        linkedHashMap.putAll(map);
        a("kty", "use", "kid", "alg", "key_ops");
        c(a(map, "use"));
        b(a(map, "kid"));
        a(a(map, "alg"));
        if (map.containsKey("key_ops")) {
            this.f0 = h.c(map, "key_ops");
        }
    }

    protected static String a(Map<String, Object> map, String str) {
        return h.d(map, str);
    }

    protected static String b(Map<String, Object> map, String str) {
        return a(map, str, true);
    }

    protected static String a(Map<String, Object> map, String str, boolean z) {
        String a2 = a(map, str);
        if (a2 == null && z) {
            throw new g("Missing required '" + str + "' parameter.");
        }
        return a2;
    }

    public void b(String str) {
        this.s = str;
    }

    protected void a(String str, Object obj, Map<String, Object> map) {
        if (obj != null) {
            map.put(str, obj);
        }
    }

    protected void a(String... strArr) {
        for (String str : strArr) {
            this.t0.remove(str);
        }
    }

    public void a(String str) {
        this.A = str;
    }

    public Map<String, Object> a(EnumC0109b enumC0109b) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("kty", c());
        a("kid", b(), linkedHashMap);
        a("use", e(), linkedHashMap);
        a("key_ops", this.f0, linkedHashMap);
        a("alg", getAlgorithm(), linkedHashMap);
        a(linkedHashMap, enumC0109b);
        linkedHashMap.putAll(this.t0);
        return linkedHashMap;
    }
}
