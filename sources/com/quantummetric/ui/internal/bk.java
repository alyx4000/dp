package com.quantummetric.ui.internal;

import android.os.AsyncTask;
import com.extole.android.sdk.impl.http.HttpRequest;
import com.quantummetric.ui.QuantumMetric;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okio.Buffer;
import okio.GzipSource;

/* loaded from: classes5.dex */
final class bk {
    static List<String> h;
    static boolean l;
    private static final List<String> p = Arrays.asList("image", "video", "audio");
    List<String> c;
    List<String> d;
    List<Pattern> e;
    boolean m;
    private Map<String, List<d>> n;
    private Map<Integer, String> o;
    long i = 5242880;
    int j = 3000;
    boolean k = true;

    /* renamed from: a, reason: collision with root package name */
    List<String> f111a = new ArrayList();
    List<String> b = new ArrayList();
    List<String> f = new ArrayList();
    List<String> g = new ArrayList();

    /* renamed from: com.quantummetric.instrument.internal.bk$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f112a;

        static {
            int[] iArr = new int[a.values$771b8f51().length];
            f112a = iArr;
            try {
                iArr[a.f113a - 1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f112a[a.b - 1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f112a[a.c - 1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final int f113a = 1;
        public static final int b = 2;
        public static final int c = 3;
        private static final /* synthetic */ int[] d = {1, 2, 3};

        public static int[] values$771b8f51() {
            return (int[]) d.clone();
        }
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        String f114a;
        String b;
        long c;
        long d;
        int e;
        Object f;
        Object g;
        Buffer h;
        Map<String, ?> i;
        Map<String, ?> j;

        b() {
        }

        private b(String str, String str2, long j, long j2, int i, Object obj, Object obj2, Buffer buffer, Map<String, ?> map, Map<String, ?> map2) {
            this.f114a = str;
            this.b = str2;
            this.c = j;
            this.d = j2;
            this.e = i;
            this.f = obj;
            this.g = obj2;
            this.h = buffer;
            this.i = map;
            this.j = map2;
        }

        /* synthetic */ b(String str, String str2, long j, long j2, int i, Object obj, Object obj2, Buffer buffer, Map map, Map map2, byte b) {
            this(str, str2, j, j2, i, obj, obj2, buffer, map, map2);
        }
    }

    static class c extends AsyncTask<b, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        private final n f115a;

        public c() {
            this.f115a = ag.c() ? new n() : null;
        }

        private static String a(Object obj) {
            if (QuantumMetric.b == null) {
                return "";
            }
            if (obj instanceof String) {
                String str = (String) obj;
                if (!de.b(str)) {
                    return str;
                }
            }
            if (!ag.a(obj)) {
                return "";
            }
            try {
                Request request = (Request) obj;
                if (request.method().equalsIgnoreCase("GET") || request.body() == null) {
                    return "";
                }
                Buffer buffer = null;
                try {
                    Buffer buffer2 = new Buffer();
                    try {
                        request.body().writeTo(buffer2);
                        String readUtf8 = buffer2.readUtf8();
                        buffer2.close();
                        return readUtf8;
                    } catch (Exception unused) {
                        buffer = buffer2;
                        if (buffer == null) {
                            return "";
                        }
                        buffer.close();
                        return "";
                    } catch (Throwable th) {
                        th = th;
                        buffer = buffer2;
                        if (buffer != null) {
                            buffer.close();
                        }
                        throw th;
                    }
                } catch (Exception unused2) {
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable unused3) {
                return "";
            }
        }

        private String a(Object obj, Buffer buffer) {
            if (QuantumMetric.b == null) {
                return "";
            }
            if (obj instanceof String) {
                String str = (String) obj;
                if (!de.b(str)) {
                    return str;
                }
            }
            if (!ag.b(obj)) {
                return "";
            }
            try {
                Response response = (Response) obj;
                if (response.body() == null) {
                    return "";
                }
                long contentLength = response.body().getContentLength();
                if (buffer == null) {
                    return "";
                }
                String header = response.header(HttpRequest.HEADER_CONTENT_ENCODING);
                if (HttpRequest.ENCODING_GZIP.equalsIgnoreCase(header)) {
                    buffer = a(buffer);
                } else if ("br".equalsIgnoreCase(header) && this.f115a != null) {
                    buffer = n.a(buffer);
                }
                Charset charset = de.f180a;
                MediaType mediaType = response.body().get$contentType();
                if (mediaType != null) {
                    charset = mediaType.charset(de.f180a);
                }
                return (charset == null || contentLength == 0) ? "" : buffer.readString(charset);
            } catch (Throwable unused) {
                return "";
            }
        }

        private static String a(String str, String str2, boolean z) {
            if (QuantumMetric.b == null) {
                return str;
            }
            boolean a2 = a(str2, z);
            if (str.length() >= de.l().i || a2) {
                return bk.a(str.length(), a2 ? a.f113a : a.b);
            }
            bk l = de.l();
            Set<Map.Entry> entrySet = l.n.entrySet();
            Collection<String> values = l.o.values();
            for (Map.Entry entry : entrySet) {
                if (de.b((String) entry.getKey()) || de.a(str2, (String) entry.getKey())) {
                    for (d dVar : (List) entry.getValue()) {
                        if (de.b(dVar.b) || str.contains(dVar.b)) {
                            str = de.a(dVar.f116a, str, aa.g);
                        }
                    }
                }
            }
            for (String str3 : values) {
                if (str.contains(str3)) {
                    str = str.replace(str3, aa.g);
                }
            }
            return str;
        }

        private static String a(Map<String, ?> map, boolean z) {
            bf bfVar = new bf();
            if (map != null && map.size() > 0 && QuantumMetric.b != null) {
                bk l = de.l();
                Set<String> keySet = map.keySet();
                List list = z ? l.f111a : l.b;
                for (String str : keySet) {
                    if (!de.a(str, list)) {
                        bfVar.put(str, map.get(str) == null ? "" : de.l(map.get(str).toString()));
                    }
                }
            }
            return de.b(bfVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:106:0x02d6 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:121:0x0317 A[Catch: Exception -> 0x0265, all -> 0x052f, TryCatch #1 {Exception -> 0x0265, blocks: (B:82:0x0272, B:86:0x0276, B:91:0x0280, B:93:0x0288, B:94:0x0296, B:96:0x029c, B:99:0x02a9, B:101:0x02b5, B:103:0x02bd, B:109:0x02db, B:112:0x02e1, B:114:0x02ef, B:116:0x030d, B:121:0x0317, B:123:0x0322, B:125:0x032e, B:127:0x0336, B:128:0x033c, B:131:0x0342, B:134:0x0349, B:136:0x034f, B:138:0x0357, B:141:0x0361, B:143:0x0372, B:146:0x037b, B:148:0x0381, B:151:0x038d, B:153:0x0393, B:155:0x039b, B:157:0x03a3, B:158:0x03a7, B:161:0x03ad, B:168:0x02c4, B:170:0x02cc), top: B:81:0x0272 }] */
        /* JADX WARN: Removed duplicated region for block: B:160:0x03ad A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:164:0x0265 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:167:? A[LOOP:2: B:94:0x0296->B:167:?, LOOP_END, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:186:0x03bc A[Catch: all -> 0x052f, TryCatch #3 {all -> 0x052f, blocks: (B:35:0x0091, B:36:0x0098, B:38:0x009e, B:39:0x00a4, B:41:0x00aa, B:42:0x00b1, B:45:0x010d, B:47:0x0113, B:48:0x0169, B:50:0x016f, B:53:0x0176, B:55:0x017c, B:56:0x0185, B:58:0x018b, B:59:0x0194, B:61:0x019a, B:62:0x01a3, B:64:0x01a9, B:65:0x01b2, B:67:0x01b7, B:68:0x01bf, B:69:0x01c7, B:71:0x01d6, B:73:0x01df, B:74:0x0248, B:76:0x0250, B:77:0x0257, B:78:0x0265, B:80:0x026c, B:82:0x0272, B:86:0x0276, B:91:0x0280, B:93:0x0288, B:94:0x0296, B:96:0x029c, B:99:0x02a9, B:101:0x02b5, B:103:0x02bd, B:109:0x02db, B:112:0x02e1, B:114:0x02ef, B:116:0x030d, B:121:0x0317, B:123:0x0322, B:125:0x032e, B:127:0x0336, B:128:0x033c, B:131:0x0342, B:134:0x0349, B:136:0x034f, B:138:0x0357, B:141:0x0361, B:143:0x0372, B:146:0x037b, B:148:0x0381, B:151:0x038d, B:153:0x0393, B:155:0x039b, B:157:0x03a3, B:158:0x03a7, B:161:0x03ad, B:168:0x02c4, B:170:0x02cc, B:184:0x03b2, B:186:0x03bc, B:187:0x03c6, B:189:0x03cc, B:191:0x03d6, B:196:0x03df, B:199:0x03e5, B:202:0x03f1, B:205:0x03fc, B:207:0x040a, B:209:0x0416, B:213:0x0429, B:219:0x0431, B:221:0x0439, B:224:0x0446, B:227:0x0441, B:239:0x0449, B:241:0x0457, B:242:0x045d, B:244:0x0463, B:246:0x046d, B:251:0x0476, B:254:0x047c, B:258:0x0485, B:260:0x048d, B:261:0x0493, B:264:0x0499, B:267:0x04a4, B:278:0x04ac, B:280:0x04b8, B:282:0x04c0, B:283:0x04cb, B:285:0x04d1, B:287:0x04db, B:291:0x04e4, B:299:0x04ec, B:301:0x04f4, B:302:0x0515, B:305:0x051b, B:308:0x0526), top: B:34:0x0091 }] */
        /* JADX WARN: Removed duplicated region for block: B:215:0x042c  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0058 A[Catch: all -> 0x052d, TRY_ENTER, TryCatch #2 {all -> 0x052d, blocks: (B:9:0x001f, B:11:0x002d, B:13:0x0031, B:14:0x0038, B:16:0x0042, B:20:0x0050, B:23:0x0058, B:24:0x0060, B:26:0x0066, B:28:0x0075, B:30:0x0081, B:32:0x008b), top: B:8:0x001f }] */
        /* JADX WARN: Removed duplicated region for block: B:241:0x0457 A[Catch: all -> 0x052f, TryCatch #3 {all -> 0x052f, blocks: (B:35:0x0091, B:36:0x0098, B:38:0x009e, B:39:0x00a4, B:41:0x00aa, B:42:0x00b1, B:45:0x010d, B:47:0x0113, B:48:0x0169, B:50:0x016f, B:53:0x0176, B:55:0x017c, B:56:0x0185, B:58:0x018b, B:59:0x0194, B:61:0x019a, B:62:0x01a3, B:64:0x01a9, B:65:0x01b2, B:67:0x01b7, B:68:0x01bf, B:69:0x01c7, B:71:0x01d6, B:73:0x01df, B:74:0x0248, B:76:0x0250, B:77:0x0257, B:78:0x0265, B:80:0x026c, B:82:0x0272, B:86:0x0276, B:91:0x0280, B:93:0x0288, B:94:0x0296, B:96:0x029c, B:99:0x02a9, B:101:0x02b5, B:103:0x02bd, B:109:0x02db, B:112:0x02e1, B:114:0x02ef, B:116:0x030d, B:121:0x0317, B:123:0x0322, B:125:0x032e, B:127:0x0336, B:128:0x033c, B:131:0x0342, B:134:0x0349, B:136:0x034f, B:138:0x0357, B:141:0x0361, B:143:0x0372, B:146:0x037b, B:148:0x0381, B:151:0x038d, B:153:0x0393, B:155:0x039b, B:157:0x03a3, B:158:0x03a7, B:161:0x03ad, B:168:0x02c4, B:170:0x02cc, B:184:0x03b2, B:186:0x03bc, B:187:0x03c6, B:189:0x03cc, B:191:0x03d6, B:196:0x03df, B:199:0x03e5, B:202:0x03f1, B:205:0x03fc, B:207:0x040a, B:209:0x0416, B:213:0x0429, B:219:0x0431, B:221:0x0439, B:224:0x0446, B:227:0x0441, B:239:0x0449, B:241:0x0457, B:242:0x045d, B:244:0x0463, B:246:0x046d, B:251:0x0476, B:254:0x047c, B:258:0x0485, B:260:0x048d, B:261:0x0493, B:264:0x0499, B:267:0x04a4, B:278:0x04ac, B:280:0x04b8, B:282:0x04c0, B:283:0x04cb, B:285:0x04d1, B:287:0x04db, B:291:0x04e4, B:299:0x04ec, B:301:0x04f4, B:302:0x0515, B:305:0x051b, B:308:0x0526), top: B:34:0x0091 }] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0081 A[Catch: all -> 0x052d, TryCatch #2 {all -> 0x052d, blocks: (B:9:0x001f, B:11:0x002d, B:13:0x0031, B:14:0x0038, B:16:0x0042, B:20:0x0050, B:23:0x0058, B:24:0x0060, B:26:0x0066, B:28:0x0075, B:30:0x0081, B:32:0x008b), top: B:8:0x001f }] */
        /* JADX WARN: Removed duplicated region for block: B:321:0x0246  */
        /* JADX WARN: Removed duplicated region for block: B:322:0x00af  */
        /* JADX WARN: Removed duplicated region for block: B:323:0x00a3  */
        /* JADX WARN: Removed duplicated region for block: B:327:0x0096  */
        /* JADX WARN: Removed duplicated region for block: B:328:0x0088  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x008b A[Catch: all -> 0x052d, TRY_LEAVE, TryCatch #2 {all -> 0x052d, blocks: (B:9:0x001f, B:11:0x002d, B:13:0x0031, B:14:0x0038, B:16:0x0042, B:20:0x0050, B:23:0x0058, B:24:0x0060, B:26:0x0066, B:28:0x0075, B:30:0x0081, B:32:0x008b), top: B:8:0x001f }] */
        /* JADX WARN: Removed duplicated region for block: B:38:0x009e A[Catch: all -> 0x052f, TryCatch #3 {all -> 0x052f, blocks: (B:35:0x0091, B:36:0x0098, B:38:0x009e, B:39:0x00a4, B:41:0x00aa, B:42:0x00b1, B:45:0x010d, B:47:0x0113, B:48:0x0169, B:50:0x016f, B:53:0x0176, B:55:0x017c, B:56:0x0185, B:58:0x018b, B:59:0x0194, B:61:0x019a, B:62:0x01a3, B:64:0x01a9, B:65:0x01b2, B:67:0x01b7, B:68:0x01bf, B:69:0x01c7, B:71:0x01d6, B:73:0x01df, B:74:0x0248, B:76:0x0250, B:77:0x0257, B:78:0x0265, B:80:0x026c, B:82:0x0272, B:86:0x0276, B:91:0x0280, B:93:0x0288, B:94:0x0296, B:96:0x029c, B:99:0x02a9, B:101:0x02b5, B:103:0x02bd, B:109:0x02db, B:112:0x02e1, B:114:0x02ef, B:116:0x030d, B:121:0x0317, B:123:0x0322, B:125:0x032e, B:127:0x0336, B:128:0x033c, B:131:0x0342, B:134:0x0349, B:136:0x034f, B:138:0x0357, B:141:0x0361, B:143:0x0372, B:146:0x037b, B:148:0x0381, B:151:0x038d, B:153:0x0393, B:155:0x039b, B:157:0x03a3, B:158:0x03a7, B:161:0x03ad, B:168:0x02c4, B:170:0x02cc, B:184:0x03b2, B:186:0x03bc, B:187:0x03c6, B:189:0x03cc, B:191:0x03d6, B:196:0x03df, B:199:0x03e5, B:202:0x03f1, B:205:0x03fc, B:207:0x040a, B:209:0x0416, B:213:0x0429, B:219:0x0431, B:221:0x0439, B:224:0x0446, B:227:0x0441, B:239:0x0449, B:241:0x0457, B:242:0x045d, B:244:0x0463, B:246:0x046d, B:251:0x0476, B:254:0x047c, B:258:0x0485, B:260:0x048d, B:261:0x0493, B:264:0x0499, B:267:0x04a4, B:278:0x04ac, B:280:0x04b8, B:282:0x04c0, B:283:0x04cb, B:285:0x04d1, B:287:0x04db, B:291:0x04e4, B:299:0x04ec, B:301:0x04f4, B:302:0x0515, B:305:0x051b, B:308:0x0526), top: B:34:0x0091 }] */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00aa A[Catch: all -> 0x052f, TryCatch #3 {all -> 0x052f, blocks: (B:35:0x0091, B:36:0x0098, B:38:0x009e, B:39:0x00a4, B:41:0x00aa, B:42:0x00b1, B:45:0x010d, B:47:0x0113, B:48:0x0169, B:50:0x016f, B:53:0x0176, B:55:0x017c, B:56:0x0185, B:58:0x018b, B:59:0x0194, B:61:0x019a, B:62:0x01a3, B:64:0x01a9, B:65:0x01b2, B:67:0x01b7, B:68:0x01bf, B:69:0x01c7, B:71:0x01d6, B:73:0x01df, B:74:0x0248, B:76:0x0250, B:77:0x0257, B:78:0x0265, B:80:0x026c, B:82:0x0272, B:86:0x0276, B:91:0x0280, B:93:0x0288, B:94:0x0296, B:96:0x029c, B:99:0x02a9, B:101:0x02b5, B:103:0x02bd, B:109:0x02db, B:112:0x02e1, B:114:0x02ef, B:116:0x030d, B:121:0x0317, B:123:0x0322, B:125:0x032e, B:127:0x0336, B:128:0x033c, B:131:0x0342, B:134:0x0349, B:136:0x034f, B:138:0x0357, B:141:0x0361, B:143:0x0372, B:146:0x037b, B:148:0x0381, B:151:0x038d, B:153:0x0393, B:155:0x039b, B:157:0x03a3, B:158:0x03a7, B:161:0x03ad, B:168:0x02c4, B:170:0x02cc, B:184:0x03b2, B:186:0x03bc, B:187:0x03c6, B:189:0x03cc, B:191:0x03d6, B:196:0x03df, B:199:0x03e5, B:202:0x03f1, B:205:0x03fc, B:207:0x040a, B:209:0x0416, B:213:0x0429, B:219:0x0431, B:221:0x0439, B:224:0x0446, B:227:0x0441, B:239:0x0449, B:241:0x0457, B:242:0x045d, B:244:0x0463, B:246:0x046d, B:251:0x0476, B:254:0x047c, B:258:0x0485, B:260:0x048d, B:261:0x0493, B:264:0x0499, B:267:0x04a4, B:278:0x04ac, B:280:0x04b8, B:282:0x04c0, B:283:0x04cb, B:285:0x04d1, B:287:0x04db, B:291:0x04e4, B:299:0x04ec, B:301:0x04f4, B:302:0x0515, B:305:0x051b, B:308:0x0526), top: B:34:0x0091 }] */
        /* JADX WARN: Removed duplicated region for block: B:45:0x010d A[Catch: all -> 0x052f, TRY_ENTER, TryCatch #3 {all -> 0x052f, blocks: (B:35:0x0091, B:36:0x0098, B:38:0x009e, B:39:0x00a4, B:41:0x00aa, B:42:0x00b1, B:45:0x010d, B:47:0x0113, B:48:0x0169, B:50:0x016f, B:53:0x0176, B:55:0x017c, B:56:0x0185, B:58:0x018b, B:59:0x0194, B:61:0x019a, B:62:0x01a3, B:64:0x01a9, B:65:0x01b2, B:67:0x01b7, B:68:0x01bf, B:69:0x01c7, B:71:0x01d6, B:73:0x01df, B:74:0x0248, B:76:0x0250, B:77:0x0257, B:78:0x0265, B:80:0x026c, B:82:0x0272, B:86:0x0276, B:91:0x0280, B:93:0x0288, B:94:0x0296, B:96:0x029c, B:99:0x02a9, B:101:0x02b5, B:103:0x02bd, B:109:0x02db, B:112:0x02e1, B:114:0x02ef, B:116:0x030d, B:121:0x0317, B:123:0x0322, B:125:0x032e, B:127:0x0336, B:128:0x033c, B:131:0x0342, B:134:0x0349, B:136:0x034f, B:138:0x0357, B:141:0x0361, B:143:0x0372, B:146:0x037b, B:148:0x0381, B:151:0x038d, B:153:0x0393, B:155:0x039b, B:157:0x03a3, B:158:0x03a7, B:161:0x03ad, B:168:0x02c4, B:170:0x02cc, B:184:0x03b2, B:186:0x03bc, B:187:0x03c6, B:189:0x03cc, B:191:0x03d6, B:196:0x03df, B:199:0x03e5, B:202:0x03f1, B:205:0x03fc, B:207:0x040a, B:209:0x0416, B:213:0x0429, B:219:0x0431, B:221:0x0439, B:224:0x0446, B:227:0x0441, B:239:0x0449, B:241:0x0457, B:242:0x045d, B:244:0x0463, B:246:0x046d, B:251:0x0476, B:254:0x047c, B:258:0x0485, B:260:0x048d, B:261:0x0493, B:264:0x0499, B:267:0x04a4, B:278:0x04ac, B:280:0x04b8, B:282:0x04c0, B:283:0x04cb, B:285:0x04d1, B:287:0x04db, B:291:0x04e4, B:299:0x04ec, B:301:0x04f4, B:302:0x0515, B:305:0x051b, B:308:0x0526), top: B:34:0x0091 }] */
        /* JADX WARN: Removed duplicated region for block: B:71:0x01d6 A[Catch: all -> 0x052f, TryCatch #3 {all -> 0x052f, blocks: (B:35:0x0091, B:36:0x0098, B:38:0x009e, B:39:0x00a4, B:41:0x00aa, B:42:0x00b1, B:45:0x010d, B:47:0x0113, B:48:0x0169, B:50:0x016f, B:53:0x0176, B:55:0x017c, B:56:0x0185, B:58:0x018b, B:59:0x0194, B:61:0x019a, B:62:0x01a3, B:64:0x01a9, B:65:0x01b2, B:67:0x01b7, B:68:0x01bf, B:69:0x01c7, B:71:0x01d6, B:73:0x01df, B:74:0x0248, B:76:0x0250, B:77:0x0257, B:78:0x0265, B:80:0x026c, B:82:0x0272, B:86:0x0276, B:91:0x0280, B:93:0x0288, B:94:0x0296, B:96:0x029c, B:99:0x02a9, B:101:0x02b5, B:103:0x02bd, B:109:0x02db, B:112:0x02e1, B:114:0x02ef, B:116:0x030d, B:121:0x0317, B:123:0x0322, B:125:0x032e, B:127:0x0336, B:128:0x033c, B:131:0x0342, B:134:0x0349, B:136:0x034f, B:138:0x0357, B:141:0x0361, B:143:0x0372, B:146:0x037b, B:148:0x0381, B:151:0x038d, B:153:0x0393, B:155:0x039b, B:157:0x03a3, B:158:0x03a7, B:161:0x03ad, B:168:0x02c4, B:170:0x02cc, B:184:0x03b2, B:186:0x03bc, B:187:0x03c6, B:189:0x03cc, B:191:0x03d6, B:196:0x03df, B:199:0x03e5, B:202:0x03f1, B:205:0x03fc, B:207:0x040a, B:209:0x0416, B:213:0x0429, B:219:0x0431, B:221:0x0439, B:224:0x0446, B:227:0x0441, B:239:0x0449, B:241:0x0457, B:242:0x045d, B:244:0x0463, B:246:0x046d, B:251:0x0476, B:254:0x047c, B:258:0x0485, B:260:0x048d, B:261:0x0493, B:264:0x0499, B:267:0x04a4, B:278:0x04ac, B:280:0x04b8, B:282:0x04c0, B:283:0x04cb, B:285:0x04d1, B:287:0x04db, B:291:0x04e4, B:299:0x04ec, B:301:0x04f4, B:302:0x0515, B:305:0x051b, B:308:0x0526), top: B:34:0x0091 }] */
        /* JADX WARN: Removed duplicated region for block: B:73:0x01df A[Catch: all -> 0x052f, TryCatch #3 {all -> 0x052f, blocks: (B:35:0x0091, B:36:0x0098, B:38:0x009e, B:39:0x00a4, B:41:0x00aa, B:42:0x00b1, B:45:0x010d, B:47:0x0113, B:48:0x0169, B:50:0x016f, B:53:0x0176, B:55:0x017c, B:56:0x0185, B:58:0x018b, B:59:0x0194, B:61:0x019a, B:62:0x01a3, B:64:0x01a9, B:65:0x01b2, B:67:0x01b7, B:68:0x01bf, B:69:0x01c7, B:71:0x01d6, B:73:0x01df, B:74:0x0248, B:76:0x0250, B:77:0x0257, B:78:0x0265, B:80:0x026c, B:82:0x0272, B:86:0x0276, B:91:0x0280, B:93:0x0288, B:94:0x0296, B:96:0x029c, B:99:0x02a9, B:101:0x02b5, B:103:0x02bd, B:109:0x02db, B:112:0x02e1, B:114:0x02ef, B:116:0x030d, B:121:0x0317, B:123:0x0322, B:125:0x032e, B:127:0x0336, B:128:0x033c, B:131:0x0342, B:134:0x0349, B:136:0x034f, B:138:0x0357, B:141:0x0361, B:143:0x0372, B:146:0x037b, B:148:0x0381, B:151:0x038d, B:153:0x0393, B:155:0x039b, B:157:0x03a3, B:158:0x03a7, B:161:0x03ad, B:168:0x02c4, B:170:0x02cc, B:184:0x03b2, B:186:0x03bc, B:187:0x03c6, B:189:0x03cc, B:191:0x03d6, B:196:0x03df, B:199:0x03e5, B:202:0x03f1, B:205:0x03fc, B:207:0x040a, B:209:0x0416, B:213:0x0429, B:219:0x0431, B:221:0x0439, B:224:0x0446, B:227:0x0441, B:239:0x0449, B:241:0x0457, B:242:0x045d, B:244:0x0463, B:246:0x046d, B:251:0x0476, B:254:0x047c, B:258:0x0485, B:260:0x048d, B:261:0x0493, B:264:0x0499, B:267:0x04a4, B:278:0x04ac, B:280:0x04b8, B:282:0x04c0, B:283:0x04cb, B:285:0x04d1, B:287:0x04db, B:291:0x04e4, B:299:0x04ec, B:301:0x04f4, B:302:0x0515, B:305:0x051b, B:308:0x0526), top: B:34:0x0091 }] */
        /* JADX WARN: Removed duplicated region for block: B:76:0x0250 A[Catch: all -> 0x052f, TryCatch #3 {all -> 0x052f, blocks: (B:35:0x0091, B:36:0x0098, B:38:0x009e, B:39:0x00a4, B:41:0x00aa, B:42:0x00b1, B:45:0x010d, B:47:0x0113, B:48:0x0169, B:50:0x016f, B:53:0x0176, B:55:0x017c, B:56:0x0185, B:58:0x018b, B:59:0x0194, B:61:0x019a, B:62:0x01a3, B:64:0x01a9, B:65:0x01b2, B:67:0x01b7, B:68:0x01bf, B:69:0x01c7, B:71:0x01d6, B:73:0x01df, B:74:0x0248, B:76:0x0250, B:77:0x0257, B:78:0x0265, B:80:0x026c, B:82:0x0272, B:86:0x0276, B:91:0x0280, B:93:0x0288, B:94:0x0296, B:96:0x029c, B:99:0x02a9, B:101:0x02b5, B:103:0x02bd, B:109:0x02db, B:112:0x02e1, B:114:0x02ef, B:116:0x030d, B:121:0x0317, B:123:0x0322, B:125:0x032e, B:127:0x0336, B:128:0x033c, B:131:0x0342, B:134:0x0349, B:136:0x034f, B:138:0x0357, B:141:0x0361, B:143:0x0372, B:146:0x037b, B:148:0x0381, B:151:0x038d, B:153:0x0393, B:155:0x039b, B:157:0x03a3, B:158:0x03a7, B:161:0x03ad, B:168:0x02c4, B:170:0x02cc, B:184:0x03b2, B:186:0x03bc, B:187:0x03c6, B:189:0x03cc, B:191:0x03d6, B:196:0x03df, B:199:0x03e5, B:202:0x03f1, B:205:0x03fc, B:207:0x040a, B:209:0x0416, B:213:0x0429, B:219:0x0431, B:221:0x0439, B:224:0x0446, B:227:0x0441, B:239:0x0449, B:241:0x0457, B:242:0x045d, B:244:0x0463, B:246:0x046d, B:251:0x0476, B:254:0x047c, B:258:0x0485, B:260:0x048d, B:261:0x0493, B:264:0x0499, B:267:0x04a4, B:278:0x04ac, B:280:0x04b8, B:282:0x04c0, B:283:0x04cb, B:285:0x04d1, B:287:0x04db, B:291:0x04e4, B:299:0x04ec, B:301:0x04f4, B:302:0x0515, B:305:0x051b, B:308:0x0526), top: B:34:0x0091 }] */
        /* JADX WARN: Removed duplicated region for block: B:80:0x026c A[Catch: all -> 0x052f, TRY_LEAVE, TryCatch #3 {all -> 0x052f, blocks: (B:35:0x0091, B:36:0x0098, B:38:0x009e, B:39:0x00a4, B:41:0x00aa, B:42:0x00b1, B:45:0x010d, B:47:0x0113, B:48:0x0169, B:50:0x016f, B:53:0x0176, B:55:0x017c, B:56:0x0185, B:58:0x018b, B:59:0x0194, B:61:0x019a, B:62:0x01a3, B:64:0x01a9, B:65:0x01b2, B:67:0x01b7, B:68:0x01bf, B:69:0x01c7, B:71:0x01d6, B:73:0x01df, B:74:0x0248, B:76:0x0250, B:77:0x0257, B:78:0x0265, B:80:0x026c, B:82:0x0272, B:86:0x0276, B:91:0x0280, B:93:0x0288, B:94:0x0296, B:96:0x029c, B:99:0x02a9, B:101:0x02b5, B:103:0x02bd, B:109:0x02db, B:112:0x02e1, B:114:0x02ef, B:116:0x030d, B:121:0x0317, B:123:0x0322, B:125:0x032e, B:127:0x0336, B:128:0x033c, B:131:0x0342, B:134:0x0349, B:136:0x034f, B:138:0x0357, B:141:0x0361, B:143:0x0372, B:146:0x037b, B:148:0x0381, B:151:0x038d, B:153:0x0393, B:155:0x039b, B:157:0x03a3, B:158:0x03a7, B:161:0x03ad, B:168:0x02c4, B:170:0x02cc, B:184:0x03b2, B:186:0x03bc, B:187:0x03c6, B:189:0x03cc, B:191:0x03d6, B:196:0x03df, B:199:0x03e5, B:202:0x03f1, B:205:0x03fc, B:207:0x040a, B:209:0x0416, B:213:0x0429, B:219:0x0431, B:221:0x0439, B:224:0x0446, B:227:0x0441, B:239:0x0449, B:241:0x0457, B:242:0x045d, B:244:0x0463, B:246:0x046d, B:251:0x0476, B:254:0x047c, B:258:0x0485, B:260:0x048d, B:261:0x0493, B:264:0x0499, B:267:0x04a4, B:278:0x04ac, B:280:0x04b8, B:282:0x04c0, B:283:0x04cb, B:285:0x04d1, B:287:0x04db, B:291:0x04e4, B:299:0x04ec, B:301:0x04f4, B:302:0x0515, B:305:0x051b, B:308:0x0526), top: B:34:0x0091 }] */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Void doInBackground(com.quantummetric.instrument.internal.bk.b... r23) {
            /*
                Method dump skipped, instructions count: 1329
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.instrument.internal.bk.c.doInBackground(com.quantummetric.instrument.internal.bk$b[]):java.lang.Void");
        }

        private static Buffer a(Buffer buffer) throws IOException {
            GzipSource gzipSource;
            Buffer buffer2 = new Buffer();
            GzipSource gzipSource2 = null;
            try {
                gzipSource = new GzipSource(buffer);
            } catch (Throwable th) {
                th = th;
            }
            try {
                buffer2.writeAll(gzipSource);
                gzipSource.close();
                return buffer2;
            } catch (Throwable th2) {
                th = th2;
                gzipSource2 = gzipSource;
                if (gzipSource2 != null) {
                    gzipSource2.close();
                }
                throw th;
            }
        }

        private static boolean a(String str, boolean z) {
            Iterator it = (z ? de.l().f : de.l().g).iterator();
            while (it.hasNext()) {
                if (de.a(str, (String) it.next())) {
                    return true;
                }
            }
            return false;
        }
    }

    static class d {

        /* renamed from: a, reason: collision with root package name */
        Pattern f116a;
        String b;

        d(Pattern pattern, String str) {
            this.f116a = pattern;
            this.b = str;
        }
    }

    bk() {
        h = new ArrayList();
        this.n = new ConcurrentHashMap();
        this.o = new ConcurrentHashMap();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new ArrayList();
    }

    static b a(String str, String str2, long j, long j2, int i, Object obj, Object obj2, Buffer buffer, Map<String, ?> map, Map<String, ?> map2) {
        return new b(str, str2, j, j2, i, obj, obj2, buffer, map, map2, (byte) 0);
    }

    static String a(int i) {
        return a(0L, i);
    }

    static String a(long j, int i) {
        int i2 = AnonymousClass1.f112a[i - 1];
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? "" : "QM: API response body type (image, video, audio) is not captured." : "QM: API Body length of " + j + " exceeds configured limit of " + de.l().i : "QM: API Body was blocked via configuration.";
    }

    static void a(b bVar) {
        new c().execute(bVar);
    }

    static boolean a() {
        return l;
    }

    static boolean a(String str, Collection<String> collection) {
        for (String str2 : collection) {
            if (!de.b(str2) && de.a(str, str2)) {
                return true;
            }
        }
        return false;
    }

    static boolean a(List<String> list) {
        if (list != null && list.size() > 0) {
            String str = list.get(0);
            for (String str2 : p) {
                if (str != null && str.contains(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    final void a(String str, int i) {
        if (this.k) {
            if (de.b(str) || str.length() <= 2) {
                this.o.remove(Integer.valueOf(i));
            } else {
                this.o.put(Integer.valueOf(i), str);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void a(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            boolean r0 = com.quantummetric.ui.internal.de.b(r5)
            if (r0 != 0) goto L48
            boolean r0 = r3.m
            if (r0 == 0) goto L25
            java.lang.String r0 = "\""
            boolean r1 = r5.startsWith(r0)
            if (r1 == 0) goto L25
            java.lang.String r1 = "\":\"([^\"]+)\""
            boolean r1 = r5.endsWith(r1)
            if (r1 == 0) goto L25
            java.lang.String[] r0 = r5.split(r0)
            int r1 = r0.length
            r2 = 1
            if (r1 <= r2) goto L25
            r0 = r0[r2]
            goto L27
        L25:
            java.lang.String r0 = ""
        L27:
            java.util.Map<java.lang.String, java.util.List<com.quantummetric.instrument.internal.bk$d>> r1 = r3.n
            java.lang.Object r1 = r1.get(r4)
            java.util.List r1 = (java.util.List) r1
            if (r1 != 0) goto L3b
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Map<java.lang.String, java.util.List<com.quantummetric.instrument.internal.bk$d>> r2 = r3.n
            r2.put(r4, r1)
        L3b:
            com.quantummetric.instrument.internal.bk$d r4 = new com.quantummetric.instrument.internal.bk$d
            r2 = 2
            java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r5, r2)
            r4.<init>(r5, r0)
            r1.add(r4)
        L48:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.bk.a(java.lang.String, java.lang.String):void");
    }

    final boolean a(String str) {
        if ((cd.f161a || QuantumMetric.b == null) || str.contains("quantum") || str.contains(".png") || str.contains(".jpg") || str.contains(".jpeg") || str.contains(".gif") || str.contains(".mp4") || str.contains(".mov") || str.contains(".webm") || str.contains(".m4s") || str.contains(".aac") || str.contains(".mp3") || str.contains(".wav") || str.contains(".flac")) {
            return false;
        }
        return !a(str, this.d);
    }
}
