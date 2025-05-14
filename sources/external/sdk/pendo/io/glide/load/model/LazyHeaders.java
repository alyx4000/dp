package external.sdk.pendo.io.glide.load.model;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class LazyHeaders implements external.sdk.pendo.io.glide.load.model.a {
    private volatile Map<String, String> combinedHeaders;
    private final Map<String, List<sdk.pendo.io.x.a>> headers;

    public static final class a {
        private static final String d;
        private static final Map<String, List<sdk.pendo.io.x.a>> e;

        /* renamed from: a, reason: collision with root package name */
        private boolean f680a = true;
        private Map<String, List<sdk.pendo.io.x.a>> b = e;
        private boolean c = true;

        static {
            String b = b();
            d = b;
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(b)) {
                hashMap.put("User-Agent", Collections.singletonList(new b(b)));
            }
            e = Collections.unmodifiableMap(hashMap);
        }

        static String b() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i = 0; i < length; i++) {
                char charAt = property.charAt(i);
                if ((charAt <= 31 && charAt != '\t') || charAt >= 127) {
                    charAt = '?';
                }
                sb.append(charAt);
            }
            return sb.toString();
        }

        public LazyHeaders a() {
            this.f680a = true;
            return new LazyHeaders(this.b);
        }
    }

    static final class b implements sdk.pendo.io.x.a {

        /* renamed from: a, reason: collision with root package name */
        private final String f681a;

        b(String str) {
            this.f681a = str;
        }

        @Override // sdk.pendo.io.x.a
        public String a() {
            return this.f681a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f681a.equals(((b) obj).f681a);
            }
            return false;
        }

        public int hashCode() {
            return this.f681a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f681a + "'}";
        }
    }

    LazyHeaders(Map<String, List<sdk.pendo.io.x.a>> map) {
        this.headers = Collections.unmodifiableMap(map);
    }

    private String buildHeaderValue(List<sdk.pendo.io.x.a> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String a2 = list.get(i).a();
            if (!TextUtils.isEmpty(a2)) {
                sb.append(a2);
                if (i != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }

    private Map<String, String> generateHeaders() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<sdk.pendo.io.x.a>> entry : this.headers.entrySet()) {
            String buildHeaderValue = buildHeaderValue(entry.getValue());
            if (!TextUtils.isEmpty(buildHeaderValue)) {
                hashMap.put(entry.getKey(), buildHeaderValue);
            }
        }
        return hashMap;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LazyHeaders) {
            return this.headers.equals(((LazyHeaders) obj).headers);
        }
        return false;
    }

    @Override // external.sdk.pendo.io.glide.load.model.a
    public Map<String, String> getHeaders() {
        if (this.combinedHeaders == null) {
            synchronized (this) {
                if (this.combinedHeaders == null) {
                    this.combinedHeaders = Collections.unmodifiableMap(generateHeaders());
                }
            }
        }
        return this.combinedHeaders;
    }

    public int hashCode() {
        return this.headers.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.headers + '}';
    }
}
