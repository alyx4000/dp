package sdk.pendo.io.t7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONTokener;
import sdk.pendo.io.t7.a;
import sdk.pendo.io.t7.d;

/* loaded from: classes6.dex */
public final class b implements d {
    private static final Logger b = Logger.getLogger(b.class.getName());

    static class a {

        /* renamed from: a, reason: collision with root package name */
        public sdk.pendo.io.t7.c f1633a;
        List<byte[]> b = new ArrayList();

        a(sdk.pendo.io.t7.c cVar) {
            this.f1633a = cVar;
        }

        public void a() {
            this.f1633a = null;
            this.b = new ArrayList();
        }

        public sdk.pendo.io.t7.c a(byte[] bArr) {
            this.b.add(bArr);
            int size = this.b.size();
            sdk.pendo.io.t7.c cVar = this.f1633a;
            if (size != cVar.e) {
                return null;
            }
            List<byte[]> list = this.b;
            sdk.pendo.io.t7.c a2 = sdk.pendo.io.t7.a.a(cVar, (byte[][]) list.toArray(new byte[list.size()][]));
            a();
            return a2;
        }
    }

    /* renamed from: sdk.pendo.io.t7.b$b, reason: collision with other inner class name */
    public static final class C0241b implements d.a {

        /* renamed from: a, reason: collision with root package name */
        a f1634a = null;
        private d.a.InterfaceC0242a b;

        /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
        private static sdk.pendo.io.t7.c b(String str) {
            String str2;
            int length = str.length();
            int i = 0;
            sdk.pendo.io.t7.c cVar = new sdk.pendo.io.t7.c(Character.getNumericValue(str.charAt(0)));
            int i2 = cVar.f1635a;
            if (i2 < 0 || i2 > d.f1636a.length - 1) {
                return b.a();
            }
            if (5 == i2 || 6 == i2) {
                if (!str.contains("-") || length <= 1) {
                    return b.a();
                }
                StringBuilder sb = new StringBuilder();
                while (true) {
                    i++;
                    if (str.charAt(i) == '-') {
                        break;
                    }
                    sb.append(str.charAt(i));
                }
                cVar.e = Integer.parseInt(sb.toString());
            }
            int i3 = i + 1;
            if (length <= i3 || '/' != str.charAt(i3)) {
                str2 = "/";
            } else {
                StringBuilder sb2 = new StringBuilder();
                do {
                    i++;
                    char charAt = str.charAt(i);
                    if (',' == charAt) {
                        break;
                    }
                    sb2.append(charAt);
                } while (i + 1 != length);
                str2 = sb2.toString();
            }
            cVar.c = str2;
            int i4 = i + 1;
            if (length > i4 && Character.getNumericValue(Character.valueOf(str.charAt(i4)).charValue()) > -1) {
                StringBuilder sb3 = new StringBuilder();
                do {
                    i++;
                    char charAt2 = str.charAt(i);
                    if (Character.getNumericValue(charAt2) < 0) {
                        i--;
                        break;
                    }
                    sb3.append(charAt2);
                } while (i + 1 != length);
                try {
                    cVar.b = Integer.parseInt(sb3.toString());
                } catch (NumberFormatException unused) {
                    return b.a();
                }
            }
            int i5 = i + 1;
            if (length > i5) {
                try {
                    str.charAt(i5);
                    cVar.d = new JSONTokener(str.substring(i5)).nextValue();
                } catch (JSONException e) {
                    b.b.log(Level.WARNING, "An error occured while retrieving data from JSONTokener", (Throwable) e);
                    return b.a();
                }
            }
            Logger logger = b.b;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(String.format("decoded %s as %s", str, cVar));
            }
            return cVar;
        }

        @Override // sdk.pendo.io.t7.d.a
        public void a(String str) {
            d.a.InterfaceC0242a interfaceC0242a;
            sdk.pendo.io.t7.c b = b(str);
            int i = b.f1635a;
            if (5 == i || 6 == i) {
                a aVar = new a(b);
                this.f1634a = aVar;
                if (aVar.f1633a.e != 0 || (interfaceC0242a = this.b) == null) {
                    return;
                }
            } else {
                interfaceC0242a = this.b;
                if (interfaceC0242a == null) {
                    return;
                }
            }
            interfaceC0242a.a(b);
        }

        @Override // sdk.pendo.io.t7.d.a
        public void destroy() {
            a aVar = this.f1634a;
            if (aVar != null) {
                aVar.a();
            }
            this.b = null;
        }

        @Override // sdk.pendo.io.t7.d.a
        public void a(byte[] bArr) {
            a aVar = this.f1634a;
            if (aVar == null) {
                throw new RuntimeException("got binary data when not reconstructing a packet");
            }
            sdk.pendo.io.t7.c a2 = aVar.a(bArr);
            if (a2 != null) {
                this.f1634a = null;
                d.a.InterfaceC0242a interfaceC0242a = this.b;
                if (interfaceC0242a != null) {
                    interfaceC0242a.a(a2);
                }
            }
        }

        @Override // sdk.pendo.io.t7.d.a
        public void a(d.a.InterfaceC0242a interfaceC0242a) {
            this.b = interfaceC0242a;
        }
    }

    public static final class c implements d.b {
        private void b(sdk.pendo.io.t7.c cVar, d.b.a aVar) {
            a.C0240a a2 = sdk.pendo.io.t7.a.a(cVar);
            String a3 = a(a2.f1632a);
            ArrayList arrayList = new ArrayList(Arrays.asList(a2.b));
            arrayList.add(0, a3);
            aVar.call(arrayList.toArray());
        }

        @Override // sdk.pendo.io.t7.d.b
        public void a(sdk.pendo.io.t7.c cVar, d.b.a aVar) {
            int i = cVar.f1635a;
            if ((i == 2 || i == 3) && sdk.pendo.io.r7.a.b(cVar.d)) {
                cVar.f1635a = cVar.f1635a == 2 ? 5 : 6;
            }
            Logger logger = b.b;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(String.format("encoding packet %s", cVar));
            }
            int i2 = cVar.f1635a;
            if (5 == i2 || 6 == i2) {
                b(cVar, aVar);
            } else {
                aVar.call(new String[]{a(cVar)});
            }
        }

        private String a(sdk.pendo.io.t7.c cVar) {
            StringBuilder sb = new StringBuilder("" + cVar.f1635a);
            int i = cVar.f1635a;
            if (5 == i || 6 == i) {
                sb.append(cVar.e);
                sb.append("-");
            }
            String str = cVar.c;
            if (str != null && str.length() != 0 && !"/".equals(cVar.c)) {
                sb.append(cVar.c);
                sb.append(",");
            }
            int i2 = cVar.b;
            if (i2 >= 0) {
                sb.append(i2);
            }
            Object obj = cVar.d;
            if (obj != null) {
                sb.append(obj);
            }
            Logger logger = b.b;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(String.format("encoded %s as %s", cVar, sb));
            }
            return sb.toString();
        }
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static sdk.pendo.io.t7.c<String> a() {
        return new sdk.pendo.io.t7.c<>(4, "parser error");
    }
}
