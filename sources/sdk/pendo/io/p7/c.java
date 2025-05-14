package sdk.pendo.io.p7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.UByte;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;
import sdk.pendo.io.v7.a;

/* loaded from: classes6.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final int f1499a = String.valueOf(Integer.MAX_VALUE).length();
    private static final Map<String, Integer> b;
    private static final Map<Integer, String> c;
    private static sdk.pendo.io.p7.b<String> d;
    private static a.C0252a e;

    class a extends HashMap<String, Integer> {
        a() {
            put(AbstractCircuitBreaker.PROPERTY_NAME, 0);
            put("close", 1);
            put("ping", 2);
            put("pong", 3);
            put("message", 4);
            put("upgrade", 5);
            put("noop", 6);
        }
    }

    class b implements f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ StringBuilder f1500a;

        b(StringBuilder sb) {
            this.f1500a = sb;
        }

        @Override // sdk.pendo.io.p7.c.f
        public void a(Object obj) {
            this.f1500a.append(c.b((String) obj));
        }
    }

    /* renamed from: sdk.pendo.io.p7.c$c, reason: collision with other inner class name */
    class C0226c implements f<byte[]> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f1501a;

        C0226c(ArrayList arrayList) {
            this.f1501a = arrayList;
        }

        @Override // sdk.pendo.io.p7.c.f
        public void a(byte[] bArr) {
            this.f1501a.add(bArr);
        }
    }

    class d implements f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f1502a;

        d(f fVar) {
            this.f1502a = fVar;
        }

        @Override // sdk.pendo.io.p7.c.f
        public void a(Object obj) {
            if (obj instanceof String) {
                String str = (String) obj;
                String valueOf = String.valueOf(str.length());
                int length = valueOf.length() + 2;
                byte[] bArr = new byte[length];
                bArr[0] = 0;
                int i = 0;
                while (i < valueOf.length()) {
                    int i2 = i + 1;
                    bArr[i2] = (byte) Character.getNumericValue(valueOf.charAt(i));
                    i = i2;
                }
                bArr[length - 1] = -1;
                this.f1502a.a(sdk.pendo.io.p7.a.a(new byte[][]{bArr, c.c(str)}));
                return;
            }
            byte[] bArr2 = (byte[]) obj;
            String valueOf2 = String.valueOf(bArr2.length);
            int length2 = valueOf2.length() + 2;
            byte[] bArr3 = new byte[length2];
            bArr3[0] = 1;
            int i3 = 0;
            while (i3 < valueOf2.length()) {
                int i4 = i3 + 1;
                bArr3[i4] = (byte) Character.getNumericValue(valueOf2.charAt(i3));
                i3 = i4;
            }
            bArr3[length2 - 1] = -1;
            this.f1502a.a(sdk.pendo.io.p7.a.a(new byte[][]{bArr3, bArr2}));
        }
    }

    public interface e<T> {
        boolean a(sdk.pendo.io.p7.b<T> bVar, int i, int i2);
    }

    public interface f<T> {
        void a(T t);
    }

    static {
        a aVar = new a();
        b = aVar;
        c = new HashMap();
        for (Map.Entry<String, Integer> entry : aVar.entrySet()) {
            c.put(entry.getValue(), entry.getKey());
        }
        d = new sdk.pendo.io.p7.b<>("error", "parser error");
        a.C0252a c0252a = new a.C0252a();
        e = c0252a;
        c0252a.f1691a = false;
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            sb.appendCodePoint(b2 & UByte.MAX_VALUE);
        }
        return sb.toString();
    }

    public static sdk.pendo.io.p7.b<byte[]> b(byte[] bArr) {
        byte b2 = bArr[0];
        int length = bArr.length - 1;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 1, bArr2, 0, length);
        return new sdk.pendo.io.p7.b<>(c.get(Integer.valueOf(b2)), bArr2);
    }

    public static void c(sdk.pendo.io.p7.b bVar, f fVar) {
        a(bVar, false, fVar);
    }

    public static sdk.pendo.io.p7.b<String> a(String str) {
        return a(str, false);
    }

    private static void b(sdk.pendo.io.p7.b bVar, f<byte[]> fVar) {
        a(bVar, true, new d(fVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] c(String str) {
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) Character.codePointAt(str, i);
        }
        return bArr;
    }

    public static sdk.pendo.io.p7.b<String> a(String str, boolean z) {
        int i;
        if (str == null) {
            return d;
        }
        try {
            i = Character.getNumericValue(str.charAt(0));
        } catch (IndexOutOfBoundsException unused) {
            i = -1;
        }
        if (z) {
            try {
                str = sdk.pendo.io.v7.a.a(str, e);
            } catch (sdk.pendo.io.v7.b unused2) {
                return d;
            }
        }
        if (i >= 0) {
            Map<Integer, String> map = c;
            if (i < map.size()) {
                return str.length() > 1 ? new sdk.pendo.io.p7.b<>(map.get(Integer.valueOf(i)), str.substring(1)) : new sdk.pendo.io.p7.b<>(map.get(Integer.valueOf(i)));
            }
        }
        return d;
    }

    private static void b(sdk.pendo.io.p7.b[] bVarArr, f<byte[]> fVar) {
        if (bVarArr.length == 0) {
            fVar.a(new byte[0]);
            return;
        }
        ArrayList arrayList = new ArrayList(bVarArr.length);
        for (sdk.pendo.io.p7.b bVar : bVarArr) {
            b(bVar, new C0226c(arrayList));
        }
        fVar.a(sdk.pendo.io.p7.a.a((byte[][]) arrayList.toArray(new byte[arrayList.size()][])));
    }

    public static void a(String str, e<String> eVar) {
        if (str != null && str.length() != 0) {
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            int i = 0;
            while (i < length) {
                char charAt = str.charAt(i);
                if (':' != charAt) {
                    sb.append(charAt);
                } else {
                    try {
                        int parseInt = Integer.parseInt(sb.toString());
                        int i2 = i + 1;
                        String substring = str.substring(i2, i2 + parseInt);
                        if (substring.length() != 0) {
                            sdk.pendo.io.p7.b<String> a2 = a(substring, false);
                            if (!d.f1498a.equals(a2.f1498a) || !d.b.equals(a2.b)) {
                                if (!eVar.a(a2, i + parseInt, length)) {
                                    return;
                                }
                            }
                        }
                        i += parseInt;
                        sb = new StringBuilder();
                    } catch (IndexOutOfBoundsException | NumberFormatException unused) {
                    }
                }
                i++;
            }
            if (sb.length() > 0) {
                eVar.a(d, 0, 1);
                return;
            }
            return;
        }
        eVar.a(d, 0, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str) {
        return str.length() + ":" + str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002a, code lost:
    
        r10.position(r1.length() + 1);
        r10 = r10.slice();
        r1 = java.lang.Integer.parseInt(r1.toString());
        r10.position(1);
        r1 = r1 + 1;
        r10.limit(r1);
        r2 = new byte[r10.remaining()];
        r10.get(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004e, code lost:
    
        if (r4 == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0050, code lost:
    
        r0.add(a(r2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0058, code lost:
    
        r0.add(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(byte[] r10, sdk.pendo.io.p7.c.e r11) {
        /*
            java.nio.ByteBuffer r10 = java.nio.ByteBuffer.wrap(r10)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L9:
            int r1 = r10.capacity()
            r2 = 0
            r3 = 1
            if (r1 <= 0) goto L7a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            byte r4 = r10.get(r2)
            r5 = 255(0xff, float:3.57E-43)
            r4 = r4 & r5
            if (r4 != 0) goto L21
            r4 = r3
            goto L22
        L21:
            r4 = r2
        L22:
            r6 = r3
        L23:
            byte r7 = r10.get(r6)
            r7 = r7 & r5
            if (r7 != r5) goto L66
            int r2 = r1.length()
            int r2 = r2 + r3
            r10.position(r2)
            java.nio.ByteBuffer r10 = r10.slice()
            java.lang.String r1 = r1.toString()
            int r1 = java.lang.Integer.parseInt(r1)
            r10.position(r3)
            int r1 = r1 + r3
            r10.limit(r1)
            int r2 = r10.remaining()
            byte[] r2 = new byte[r2]
            r10.get(r2)
            if (r4 == 0) goto L58
            java.lang.String r2 = a(r2)
            r0.add(r2)
            goto L5b
        L58:
            r0.add(r2)
        L5b:
            r10.clear()
            r10.position(r1)
            java.nio.ByteBuffer r10 = r10.slice()
            goto L9
        L66:
            int r8 = r1.length()
            int r9 = sdk.pendo.io.p7.c.f1499a
            if (r8 <= r9) goto L74
            sdk.pendo.io.p7.b<java.lang.String> r10 = sdk.pendo.io.p7.c.d
            r11.a(r10, r2, r3)
            return
        L74:
            r1.append(r7)
            int r6 = r6 + 1
            goto L23
        L7a:
            int r10 = r0.size()
        L7e:
            if (r2 >= r10) goto La0
            java.lang.Object r1 = r0.get(r2)
            boolean r4 = r1 instanceof java.lang.String
            if (r4 == 0) goto L92
            java.lang.String r1 = (java.lang.String) r1
            sdk.pendo.io.p7.b r1 = a(r1, r3)
        L8e:
            r11.a(r1, r2, r10)
            goto L9d
        L92:
            boolean r4 = r1 instanceof byte[]
            if (r4 == 0) goto L9d
            byte[] r1 = (byte[]) r1
            sdk.pendo.io.p7.b r1 = b(r1)
            goto L8e
        L9d:
            int r2 = r2 + 1
            goto L7e
        La0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.p7.c.a(byte[], sdk.pendo.io.p7.c$e):void");
    }

    private static void a(sdk.pendo.io.p7.b<byte[]> bVar, f<byte[]> fVar) {
        byte[] bArr = bVar.b;
        byte[] bArr2 = new byte[bArr.length + 1];
        bArr2[0] = b.get(bVar.f1498a).byteValue();
        System.arraycopy(bArr, 0, bArr2, 1, bArr.length);
        fVar.a(bArr2);
    }

    public static void a(sdk.pendo.io.p7.b bVar, boolean z, f fVar) {
        if (bVar.b instanceof byte[]) {
            a((sdk.pendo.io.p7.b<byte[]>) bVar, (f<byte[]>) fVar);
            return;
        }
        String valueOf = String.valueOf(b.get(bVar.f1498a));
        if (bVar.b != 0) {
            StringBuilder append = new StringBuilder().append(valueOf);
            String valueOf2 = String.valueOf(bVar.b);
            if (z) {
                valueOf2 = sdk.pendo.io.v7.a.b(valueOf2, e);
            }
            valueOf = append.append(valueOf2).toString();
        }
        fVar.a(valueOf);
    }

    public static void a(sdk.pendo.io.p7.b[] bVarArr, f fVar) {
        String sb;
        for (sdk.pendo.io.p7.b bVar : bVarArr) {
            if (bVar.b instanceof byte[]) {
                b(bVarArr, (f<byte[]>) fVar);
                return;
            }
        }
        if (bVarArr.length == 0) {
            sb = "0:";
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (sdk.pendo.io.p7.b bVar2 : bVarArr) {
                a(bVar2, false, new b(sb2));
            }
            sb = sb2.toString();
        }
        fVar.a(sb);
    }
}
