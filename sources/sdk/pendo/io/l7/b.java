package sdk.pendo.io.l7;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import sdk.pendo.io.l7.c;

/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f1319a = Logger.getLogger(b.class.getName());
    private static final ConcurrentHashMap<String, c> b = new ConcurrentHashMap<>();
    public static int c = 4;

    public static class a extends c.o {
        public boolean A = true;
        public boolean z;
    }

    private b() {
    }

    public static e a(URI uri, a aVar) {
        c cVar;
        String str;
        if (aVar == null) {
            aVar = new a();
        }
        URL a2 = g.a(uri);
        try {
            URI uri2 = a2.toURI();
            String a3 = g.a(a2);
            String path = a2.getPath();
            ConcurrentHashMap<String, c> concurrentHashMap = b;
            boolean z = true;
            boolean z2 = concurrentHashMap.containsKey(a3) && concurrentHashMap.get(a3).v.containsKey(path);
            if (!aVar.z && aVar.A && !z2) {
                z = false;
            }
            if (z) {
                Logger logger = f1319a;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(String.format("ignoring socket cache for %s", uri2));
                }
                cVar = new c(uri2, aVar);
            } else {
                if (!concurrentHashMap.containsKey(a3)) {
                    Logger logger2 = f1319a;
                    if (logger2.isLoggable(Level.FINE)) {
                        logger2.fine(String.format("new io instance for %s", uri2));
                    }
                    concurrentHashMap.putIfAbsent(a3, new c(uri2, aVar));
                }
                cVar = concurrentHashMap.get(a3);
            }
            String query = a2.getQuery();
            if (query != null && ((str = aVar.p) == null || str.isEmpty())) {
                aVar.p = query;
            }
            return cVar.a(a2.getPath(), aVar);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
