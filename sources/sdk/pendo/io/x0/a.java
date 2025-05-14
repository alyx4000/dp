package sdk.pendo.io.x0;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import sdk.pendo.io.k1.g;
import sdk.pendo.io.y0.e;
import sdk.pendo.io.z0.c;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final sdk.pendo.io.z0.a f1744a = new C0267a();

    /* renamed from: sdk.pendo.io.x0.a$a, reason: collision with other inner class name */
    class C0267a implements sdk.pendo.io.z0.a {
        C0267a() {
        }

        @Override // sdk.pendo.io.z0.a
        public Map a() {
            return new b();
        }

        @Override // sdk.pendo.io.z0.a
        public List b() {
            return new ArrayList();
        }
    }

    static class b extends LinkedHashMap<String, Object> {
        b() {
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object put(String str, Object obj) {
            if (containsKey(str)) {
                throw new IllegalArgumentException("An entry for '" + str + "' already exists. Names must be unique.");
            }
            return super.put(str, obj);
        }
    }

    public static Map<String, Object> a(String str) {
        try {
            Object a2 = new sdk.pendo.io.z0.b().a(str, f1744a);
            if (a2 != null) {
                return (Map) a2;
            }
            throw new g("Parsing returned null");
        } catch (ClassCastException e) {
            throw new g("Expecting a JSON object at the root but " + e, e);
        } catch (IllegalArgumentException e2) {
            e = e2;
            throw new g("Parsing error: " + e, e);
        } catch (c e3) {
            e = e3;
            throw new g("Parsing error: " + e, e);
        }
    }

    public static String a(Map<String, ?> map) {
        return e.a(map);
    }
}
