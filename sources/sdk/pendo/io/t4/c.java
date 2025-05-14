package sdk.pendo.io.t4;

import androidx.exifinterface.media.ExifInterface;
import java.security.AccessController;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes6.dex */
public class c extends Provider {
    private static final Map<Map<String, String>, Map<String, String>> f0 = new HashMap();
    private final boolean A;
    private Map<String, j> f;
    private Map<String, sdk.pendo.io.t4.j> s;

    class a implements sdk.pendo.io.t4.j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f1556a;
        final /* synthetic */ sdk.pendo.io.b5.i b;

        a(boolean z, sdk.pendo.io.b5.i iVar) {
            this.f1556a = z;
            this.b = iVar;
        }

        @Override // sdk.pendo.io.t4.j
        public Object a(Object obj) {
            return new n0(this.f1556a, this.b.a());
        }
    }

    class b implements sdk.pendo.io.t4.j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f1557a;
        final /* synthetic */ sdk.pendo.io.b5.i b;

        b(boolean z, sdk.pendo.io.b5.i iVar) {
            this.f1557a = z;
            this.b = iVar;
        }

        @Override // sdk.pendo.io.t4.j
        public Object a(Object obj) {
            return new m1(this.f1557a, this.b.a());
        }
    }

    /* renamed from: sdk.pendo.io.t4.c$c, reason: collision with other inner class name */
    class C0239c implements sdk.pendo.io.t4.j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f1558a;
        final /* synthetic */ sdk.pendo.io.b5.i b;

        C0239c(boolean z, sdk.pendo.io.b5.i iVar) {
            this.f1558a = z;
            this.b = iVar;
        }

        @Override // sdk.pendo.io.t4.j
        public Object a(Object obj) {
            return new p0(this.f1558a, this.b, null);
        }
    }

    class d implements sdk.pendo.io.t4.j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f1559a;
        final /* synthetic */ sdk.pendo.io.b5.i b;

        d(boolean z, sdk.pendo.io.b5.i iVar) {
            this.f1559a = z;
            this.b = iVar;
        }

        @Override // sdk.pendo.io.t4.j
        public Object a(Object obj) {
            return new p0(this.f1559a, this.b, c.b("TLSv1"));
        }
    }

    class e implements sdk.pendo.io.t4.j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f1560a;
        final /* synthetic */ sdk.pendo.io.b5.i b;

        e(boolean z, sdk.pendo.io.b5.i iVar) {
            this.f1560a = z;
            this.b = iVar;
        }

        @Override // sdk.pendo.io.t4.j
        public Object a(Object obj) {
            return new p0(this.f1560a, this.b, c.b("TLSv1.1", "TLSv1"));
        }
    }

    class f implements sdk.pendo.io.t4.j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f1561a;
        final /* synthetic */ sdk.pendo.io.b5.i b;

        f(boolean z, sdk.pendo.io.b5.i iVar) {
            this.f1561a = z;
            this.b = iVar;
        }

        @Override // sdk.pendo.io.t4.j
        public Object a(Object obj) {
            return new p0(this.f1561a, this.b, c.b("TLSv1.2", "TLSv1.1", "TLSv1"));
        }
    }

    class g implements sdk.pendo.io.t4.j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f1562a;
        final /* synthetic */ sdk.pendo.io.b5.i b;

        g(boolean z, sdk.pendo.io.b5.i iVar) {
            this.f1562a = z;
            this.b = iVar;
        }

        @Override // sdk.pendo.io.t4.j
        public Object a(Object obj) {
            return new p0(this.f1562a, this.b, c.b("TLSv1.3", "TLSv1.2", "TLSv1.1", "TLSv1"));
        }
    }

    class h implements sdk.pendo.io.t4.j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f1563a;
        final /* synthetic */ sdk.pendo.io.b5.i b;

        h(boolean z, sdk.pendo.io.b5.i iVar) {
            this.f1563a = z;
            this.b = iVar;
        }

        @Override // sdk.pendo.io.t4.j
        public Object a(Object obj) {
            return new sdk.pendo.io.t4.f(this.f1563a, this.b);
        }
    }

    static class i implements PrivilegedAction<String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f1564a;
        final /* synthetic */ String b;

        i(String str, String str2) {
            this.f1564a = str;
            this.b = str2;
        }

        @Override // java.security.PrivilegedAction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String run() {
            String property = Security.getProperty(this.f1564a);
            if (property != null) {
                return property;
            }
            String property2 = System.getProperty(this.f1564a);
            return property2 != null ? property2 : this.b;
        }
    }

    private static class j extends Provider.Service {

        /* renamed from: a, reason: collision with root package name */
        private final sdk.pendo.io.t4.j f1565a;

        public j(Provider provider, String str, String str2, String str3, List<String> list, Map<String, String> map, sdk.pendo.io.t4.j jVar) {
            super(provider, str, str2, str3, list, map);
            this.f1565a = jVar;
        }

        @Override // java.security.Provider.Service
        public Object newInstance(Object obj) {
            try {
                Object a2 = this.f1565a.a(obj);
                if (a2 != null) {
                    return a2;
                }
                throw new NoSuchAlgorithmException("No such algorithm in FIPS approved mode: " + getAlgorithm());
            } catch (NoSuchAlgorithmException e) {
                throw e;
            } catch (Exception e2) {
                throw new NoSuchAlgorithmException("Unable to invoke creator for " + getAlgorithm() + ": " + e2.getMessage(), e2);
            }
        }
    }

    public c() {
        this(b("external.sdk.pendo.io.org.bouncycastle.jsse.config", "default"));
    }

    private static String b(String str, String str2) {
        return (String) AccessController.doPrivileged(new i(str, str2));
    }

    @Override // java.security.Provider
    public final synchronized Provider.Service getService(String str, String str2) {
        String d2 = sdk.pendo.io.d5.i.d(str2);
        j jVar = this.f.get(str + "." + d2);
        if (jVar == null) {
            String str3 = "Alg.Alias." + str + ".";
            String str4 = (String) get(str3 + d2);
            if (str4 == null) {
                str4 = d2;
            }
            String str5 = (String) get(str + "." + str4);
            if (str5 == null) {
                return null;
            }
            String str6 = str + "." + d2 + " ";
            ArrayList arrayList = new ArrayList();
            HashMap hashMap = new HashMap();
            for (Object obj : keySet()) {
                String str7 = (String) obj;
                if (str7.startsWith(str3) && get(obj).equals(str2)) {
                    arrayList.add(str7.substring(str3.length()));
                }
                if (str7.startsWith(str6)) {
                    hashMap.put(str7.substring(str6.length()), (String) get(str7));
                }
            }
            j jVar2 = new j(this, str, d2, str5, arrayList, a(hashMap), this.s.get(str5));
            this.f.put(str + "." + d2, jVar2);
            jVar = jVar2;
        }
        return jVar;
    }

    @Override // java.security.Provider
    public final synchronized Set<Provider.Service> getServices() {
        HashSet hashSet;
        Set<Provider.Service> services = super.getServices();
        hashSet = new HashSet();
        for (Provider.Service service : services) {
            hashSet.add(getService(service.getType(), service.getAlgorithm()));
        }
        return hashSet;
    }

    public c(String str) {
        super("BCJSSE", 1.0013d, "Bouncy Castle JSSE Provider Version 1.0.13");
        this.f = new HashMap();
        this.s = new HashMap();
        String trim = str.trim();
        int indexOf = trim.indexOf(58);
        boolean z = false;
        if (indexOf >= 0) {
            String trim2 = trim.substring(0, indexOf).trim();
            trim = trim.substring(indexOf + 1).trim();
            z = trim2.equalsIgnoreCase("fips");
        }
        try {
            this.A = a(z, a(trim));
        } catch (GeneralSecurityException e2) {
            throw new IllegalArgumentException("unable to set up JcaTlsCryptoProvider: " + e2.getMessage(), e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<String> b(String... strArr) {
        return Arrays.asList(strArr);
    }

    void a(String str, String str2, sdk.pendo.io.t4.j jVar) {
        if (containsKey(str)) {
            throw new IllegalStateException("duplicate provider key (" + str + ") found");
        }
        a(str, "ImplementedIn", ExifInterface.TAG_SOFTWARE);
        put(str, str2);
        this.s.put(str2, jVar);
    }

    void a(String str, String str2) {
        if (containsKey(str)) {
            throw new IllegalStateException("duplicate provider key (" + str + ") found");
        }
        put(str, str2);
    }

    void a(String str, String str2, String str3) {
        String str4 = str + " " + str2;
        if (containsKey(str4)) {
            throw new IllegalStateException("duplicate provider attribute key (" + str4 + ") found");
        }
        put(str4, str3);
    }

    private boolean a(boolean z, sdk.pendo.io.b5.i iVar) {
        a("KeyManagerFactory.X.509", "external.sdk.pendo.io.org.bouncycastle.jsse.provider.KeyManagerFactory", new a(z, iVar));
        a("Alg.Alias.KeyManagerFactory.X509", "X.509");
        a("Alg.Alias.KeyManagerFactory.PKIX", "X.509");
        a("TrustManagerFactory.PKIX", "external.sdk.pendo.io.org.bouncycastle.jsse.provider.TrustManagerFactory", new b(z, iVar));
        a("Alg.Alias.TrustManagerFactory.X.509", "PKIX");
        a("Alg.Alias.TrustManagerFactory.X509", "PKIX");
        a("SSLContext.TLS", "external.sdk.pendo.io.org.bouncycastle.jsse.provider.SSLContext.TLS", new C0239c(z, iVar));
        a("SSLContext.TLSV1", "external.sdk.pendo.io.org.bouncycastle.jsse.provider.SSLContext.TLSv1", new d(z, iVar));
        a("SSLContext.TLSV1.1", "external.sdk.pendo.io.org.bouncycastle.jsse.provider.SSLContext.TLSv1_1", new e(z, iVar));
        a("SSLContext.TLSV1.2", "external.sdk.pendo.io.org.bouncycastle.jsse.provider.SSLContext.TLSv1_2", new f(z, iVar));
        a("SSLContext.TLSV1.3", "external.sdk.pendo.io.org.bouncycastle.jsse.provider.SSLContext.TLSv1_3", new g(z, iVar));
        a("SSLContext.DEFAULT", "external.sdk.pendo.io.org.bouncycastle.jsse.provider.SSLContext.Default", new h(z, iVar));
        a("Alg.Alias.SSLContext.SSL", "TLS");
        a("Alg.Alias.SSLContext.SSLV3", "TLSV1");
        return z;
    }

    private sdk.pendo.io.b5.i a(String str) {
        if (str.equalsIgnoreCase("default")) {
            return new sdk.pendo.io.b5.i();
        }
        Provider provider = Security.getProvider(str);
        if (provider != null) {
            return new sdk.pendo.io.b5.i().a(provider);
        }
        try {
            Object newInstance = Class.forName(str).newInstance();
            if (newInstance instanceof sdk.pendo.io.b5.i) {
                return (sdk.pendo.io.b5.i) newInstance;
            }
            if (newInstance instanceof Provider) {
                return new sdk.pendo.io.b5.i().a((Provider) newInstance);
            }
            throw new IllegalArgumentException("unrecognized class: " + str);
        } catch (ClassNotFoundException unused) {
            throw new IllegalArgumentException("unable to find Provider/JcaTlsCryptoProvider class: " + str);
        } catch (IllegalAccessException e2) {
            throw new IllegalArgumentException("unable to create Provider/JcaTlsCryptoProvider class '" + str + "': " + e2.getMessage(), e2);
        } catch (InstantiationException e3) {
            throw new IllegalArgumentException("unable to create Provider/JcaTlsCryptoProvider class '" + str + "': " + e3.getMessage(), e3);
        }
    }

    private static Map<String, String> a(Map<String, String> map) {
        Map<Map<String, String>, Map<String, String>> map2 = f0;
        Map<String, String> map3 = map2.get(map);
        if (map3 != null) {
            return map3;
        }
        map2.put(map, map);
        return map;
    }
}
