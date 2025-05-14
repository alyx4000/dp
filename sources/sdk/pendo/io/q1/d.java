package sdk.pendo.io.q1;

import io.sentry.SentryEnvelopeItemHeader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import sdk.pendo.io.t1.e;
import sdk.pendo.io.t1.f;

/* loaded from: classes6.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final Map<String, Class> f1510a;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("avg", sdk.pendo.io.t1.b.class);
        hashMap.put("stddev", e.class);
        hashMap.put("sum", f.class);
        hashMap.put("min", sdk.pendo.io.t1.d.class);
        hashMap.put("max", sdk.pendo.io.t1.c.class);
        hashMap.put("concat", sdk.pendo.io.u1.a.class);
        hashMap.put(SentryEnvelopeItemHeader.JsonKeys.LENGTH, sdk.pendo.io.u1.b.class);
        hashMap.put("size", sdk.pendo.io.u1.b.class);
        hashMap.put("append", sdk.pendo.io.r1.a.class);
        f1510a = Collections.unmodifiableMap(hashMap);
    }

    public static c a(String str) {
        Class cls = f1510a.get(str);
        if (cls == null) {
            throw new sdk.pendo.io.n1.f("Function with name: " + str + " does not exist.");
        }
        try {
            return (c) cls.newInstance();
        } catch (Exception e) {
            throw new sdk.pendo.io.n1.f("Function of name: " + str + " cannot be created", e);
        }
    }
}
