package sdk.pendo.io.p2;

import com.squareup.kotlinpoet.FileSpecKt;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import kotlin.text.Typography;

/* loaded from: classes6.dex */
public abstract class k implements Serializable {
    public static final k J0 = new a();
    public static final k K0 = new c();
    public static final k L0 = new e();
    public static final k M0 = new f();
    public static final k N0 = new g();
    public static final k O0 = new d();
    public static final k P0 = new b();
    private static final ThreadLocal<WeakHashMap<Object, Object>> Q0 = new ThreadLocal<>();
    private boolean A;
    private boolean w0;
    private boolean x0;
    private boolean f = true;
    private boolean s = true;
    private boolean f0 = true;
    private String t0 = "[";
    private String u0 = "]";
    private String v0 = "=";
    private String y0 = ",";
    private String z0 = "{";
    private String A0 = ",";
    private boolean B0 = true;
    private String C0 = "}";
    private boolean D0 = true;
    private String E0 = "<null>";
    private String F0 = "<size=";
    private String G0 = ">";
    private String H0 = "<";
    private String I0 = ">";

    private static final class a extends k {
        a() {
        }
    }

    private static final class b extends k {
        b() {
            b(false);
            d(false);
            d("{");
            c("}");
            b("[");
            a("]");
            f(",");
            e(":");
            g("null");
            k("\"<");
            j(">\"");
            i("\"<size=");
            h(">\"");
        }

        private void d(StringBuffer stringBuffer, String str) {
            stringBuffer.append(Typography.quote).append(sdk.pendo.io.o2.f.a(str)).append(Typography.quote);
        }

        private boolean l(String str) {
            return str.startsWith(b()) && str.endsWith(a());
        }

        private boolean m(String str) {
            return str.startsWith(e()) && str.endsWith(c());
        }

        @Override // sdk.pendo.io.p2.k
        public void a(StringBuffer stringBuffer, String str, Object obj, Boolean bool) {
            if (str == null) {
                throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
            }
            if (!a(bool)) {
                throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
            }
            super.a(stringBuffer, str, obj, bool);
        }

        @Override // sdk.pendo.io.p2.k
        protected void b(StringBuffer stringBuffer, String str, Object obj) {
            if (obj == null) {
                c(stringBuffer, str);
                return;
            }
            if ((obj instanceof String) || (obj instanceof Character)) {
                d(stringBuffer, obj.toString());
                return;
            }
            if ((obj instanceof Number) || (obj instanceof Boolean)) {
                stringBuffer.append(obj);
                return;
            }
            String obj2 = obj.toString();
            if (m(obj2) || l(obj2)) {
                stringBuffer.append(obj);
            } else {
                b(stringBuffer, str, obj2);
            }
        }

        @Override // sdk.pendo.io.p2.k
        protected void a(StringBuffer stringBuffer, String str, char c) {
            d(stringBuffer, String.valueOf(c));
        }

        @Override // sdk.pendo.io.p2.k
        protected void b(StringBuffer stringBuffer, String str) {
            if (str == null) {
                throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
            }
            super.b(stringBuffer, "\"" + sdk.pendo.io.o2.f.a(str) + "\"");
        }

        @Override // sdk.pendo.io.p2.k
        protected void a(StringBuffer stringBuffer, String str, Collection<?> collection) {
            if (collection == null || collection.isEmpty()) {
                stringBuffer.append(collection);
                return;
            }
            stringBuffer.append(b());
            Iterator<?> it = collection.iterator();
            int i = 0;
            while (it.hasNext()) {
                a(stringBuffer, str, i, it.next());
                i++;
            }
            stringBuffer.append(a());
        }

        @Override // sdk.pendo.io.p2.k
        protected void a(StringBuffer stringBuffer, String str, Map<?, ?> map) {
            if (map == null || map.isEmpty()) {
                stringBuffer.append(map);
                return;
            }
            stringBuffer.append(e());
            boolean z = true;
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                String objects = Objects.toString(entry.getKey(), null);
                if (objects != null) {
                    if (z) {
                        z = false;
                    } else {
                        a(stringBuffer, objects);
                    }
                    b(stringBuffer, objects);
                    Object value = entry.getValue();
                    if (value == null) {
                        c(stringBuffer, objects);
                    } else {
                        a(stringBuffer, objects, value, true);
                    }
                }
            }
            stringBuffer.append(c());
        }
    }

    private static final class c extends k {
        c() {
            d("[");
            f(System.lineSeparator() + FileSpecKt.DEFAULT_INDENT);
            a(true);
            c(System.lineSeparator() + "]");
        }
    }

    private static final class d extends k {
        d() {
            b(false);
            d(false);
        }
    }

    private static final class e extends k {
        e() {
            c(false);
        }
    }

    private static final class f extends k {
        f() {
            e(true);
            d(false);
        }
    }

    private static final class g extends k {
        g() {
            b(false);
            d(false);
            c(false);
            d("");
            c("");
        }
    }

    protected k() {
    }

    static Map<Object, Object> h() {
        return Q0.get();
    }

    public void a(StringBuffer stringBuffer, String str, Object obj, Boolean bool) {
        b(stringBuffer, str);
        if (obj == null) {
            c(stringBuffer, str);
        } else {
            a(stringBuffer, str, obj, a(bool));
        }
        a(stringBuffer, str);
    }

    protected void b(StringBuffer stringBuffer) {
        stringBuffer.append(this.t0);
    }

    protected void c(StringBuffer stringBuffer) {
        stringBuffer.append(this.y0);
    }

    public void d(StringBuffer stringBuffer, Object obj) {
        if (obj != null) {
            a(stringBuffer, obj);
            c(stringBuffer, obj);
            b(stringBuffer);
            if (this.w0) {
                c(stringBuffer);
            }
        }
    }

    protected String e() {
        return this.t0;
    }

    protected void f(String str) {
        if (str == null) {
            str = "";
        }
        this.y0 = str;
    }

    protected String g() {
        return this.E0;
    }

    protected boolean i() {
        return this.f0;
    }

    protected void j(String str) {
        if (str == null) {
            str = "";
        }
        this.I0 = str;
    }

    protected void k(String str) {
        if (str == null) {
            str = "";
        }
        this.H0 = str;
    }

    protected void a(StringBuffer stringBuffer, Object obj) {
        if (!this.s || obj == null) {
            return;
        }
        b(obj);
        boolean z = this.A;
        Class<?> cls = obj.getClass();
        stringBuffer.append(z ? a(cls) : cls.getName());
    }

    protected void b(StringBuffer stringBuffer, String str, Object obj) {
        stringBuffer.append(obj);
    }

    protected void c(StringBuffer stringBuffer, Object obj) {
        if (!i() || obj == null) {
            return;
        }
        b(obj);
        stringBuffer.append('@');
        stringBuffer.append(Integer.toHexString(System.identityHashCode(obj)));
    }

    protected void d(StringBuffer stringBuffer) {
        if (sdk.pendo.io.o2.g.b(stringBuffer, this.y0)) {
            stringBuffer.setLength(stringBuffer.length() - this.y0.length());
        }
    }

    protected void e(String str) {
        if (str == null) {
            str = "";
        }
        this.v0 = str;
    }

    protected void g(String str) {
        if (str == null) {
            str = "";
        }
        this.E0 = str;
    }

    protected void h(String str) {
        if (str == null) {
            str = "";
        }
        this.G0 = str;
    }

    protected void i(String str) {
        if (str == null) {
            str = "";
        }
        this.F0 = str;
    }

    protected void a(StringBuffer stringBuffer) {
        stringBuffer.append(this.u0);
    }

    public void b(StringBuffer stringBuffer, Object obj) {
        if (!this.x0) {
            d(stringBuffer);
        }
        a(stringBuffer);
        c(obj);
    }

    protected void c(StringBuffer stringBuffer, String str) {
        stringBuffer.append(this.E0);
    }

    protected void d(String str) {
        if (str == null) {
            str = "";
        }
        this.t0 = str;
    }

    protected void e(boolean z) {
        this.A = z;
    }

    protected void a(StringBuffer stringBuffer, String str, Object obj) {
        sdk.pendo.io.o2.e.a(stringBuffer, obj);
    }

    protected void b(StringBuffer stringBuffer, String str) {
        if (!this.f || str == null) {
            return;
        }
        stringBuffer.append(str);
        stringBuffer.append(this.v0);
    }

    protected void c(StringBuffer stringBuffer, String str, Object obj) {
        stringBuffer.append(this.H0);
        stringBuffer.append(a(obj.getClass()));
        stringBuffer.append(this.I0);
    }

    protected void d(boolean z) {
        this.f0 = z;
    }

    protected void a(StringBuffer stringBuffer, String str, byte b2) {
        stringBuffer.append((int) b2);
    }

    protected void b(StringBuffer stringBuffer, String str, byte[] bArr) {
        b(stringBuffer, str, bArr.length);
    }

    protected String c() {
        return this.u0;
    }

    protected void a(StringBuffer stringBuffer, String str, char c2) {
        stringBuffer.append(c2);
    }

    protected void b(StringBuffer stringBuffer, String str, char[] cArr) {
        b(stringBuffer, str, cArr.length);
    }

    protected void c(String str) {
        if (str == null) {
            str = "";
        }
        this.u0 = str;
    }

    protected void a(StringBuffer stringBuffer, String str, double d2) {
        stringBuffer.append(d2);
    }

    protected void b(StringBuffer stringBuffer, String str, double[] dArr) {
        b(stringBuffer, str, dArr.length);
    }

    protected void c(boolean z) {
        this.f = z;
    }

    static void c(Object obj) {
        Map<Object, Object> h;
        if (obj == null || (h = h()) == null) {
            return;
        }
        h.remove(obj);
        if (h.isEmpty()) {
            Q0.remove();
        }
    }

    protected void a(StringBuffer stringBuffer, String str, float f2) {
        stringBuffer.append(f2);
    }

    protected void b(StringBuffer stringBuffer, String str, float[] fArr) {
        b(stringBuffer, str, fArr.length);
    }

    protected void a(StringBuffer stringBuffer, String str, int i) {
        stringBuffer.append(i);
    }

    protected void b(StringBuffer stringBuffer, String str, int[] iArr) {
        b(stringBuffer, str, iArr.length);
    }

    protected void a(StringBuffer stringBuffer, String str, int i, Object obj) {
        if (i > 0) {
            stringBuffer.append(this.A0);
        }
        if (obj == null) {
            c(stringBuffer, str);
        } else {
            a(stringBuffer, str, obj, this.B0);
        }
    }

    protected void b(StringBuffer stringBuffer, String str, long[] jArr) {
        b(stringBuffer, str, jArr.length);
    }

    protected void a(StringBuffer stringBuffer, String str, long j) {
        stringBuffer.append(j);
    }

    protected void b(StringBuffer stringBuffer, String str, Object[] objArr) {
        b(stringBuffer, str, objArr.length);
    }

    protected void a(StringBuffer stringBuffer, String str, Collection<?> collection) {
        stringBuffer.append(collection);
    }

    protected void b(StringBuffer stringBuffer, String str, short[] sArr) {
        b(stringBuffer, str, sArr.length);
    }

    protected void a(StringBuffer stringBuffer, String str, Map<?, ?> map) {
        stringBuffer.append(map);
    }

    protected void b(StringBuffer stringBuffer, String str, boolean[] zArr) {
        b(stringBuffer, str, zArr.length);
    }

    protected void a(StringBuffer stringBuffer, String str, short s) {
        stringBuffer.append((int) s);
    }

    protected void b(StringBuffer stringBuffer, String str, int i) {
        stringBuffer.append(this.F0);
        stringBuffer.append(i);
        stringBuffer.append(this.G0);
    }

    protected void a(StringBuffer stringBuffer, String str, boolean z) {
        stringBuffer.append(z);
    }

    protected String b() {
        return this.z0;
    }

    static void b(Object obj) {
        if (obj != null) {
            if (h() == null) {
                Q0.set(new WeakHashMap<>());
            }
            h().put(obj, null);
        }
    }

    protected void a(StringBuffer stringBuffer, String str, byte[] bArr) {
        stringBuffer.append(this.z0);
        for (int i = 0; i < bArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.A0);
            }
            a(stringBuffer, str, bArr[i]);
        }
        stringBuffer.append(this.C0);
    }

    protected void a(StringBuffer stringBuffer, String str, char[] cArr) {
        stringBuffer.append(this.z0);
        for (int i = 0; i < cArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.A0);
            }
            a(stringBuffer, str, cArr[i]);
        }
        stringBuffer.append(this.C0);
    }

    protected void b(String str) {
        if (str == null) {
            str = "";
        }
        this.z0 = str;
    }

    protected void a(StringBuffer stringBuffer, String str, double[] dArr) {
        stringBuffer.append(this.z0);
        for (int i = 0; i < dArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.A0);
            }
            a(stringBuffer, str, dArr[i]);
        }
        stringBuffer.append(this.C0);
    }

    protected void b(boolean z) {
        this.s = z;
    }

    protected void a(StringBuffer stringBuffer, String str, float[] fArr) {
        stringBuffer.append(this.z0);
        for (int i = 0; i < fArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.A0);
            }
            a(stringBuffer, str, fArr[i]);
        }
        stringBuffer.append(this.C0);
    }

    protected void a(StringBuffer stringBuffer, String str, int[] iArr) {
        stringBuffer.append(this.z0);
        for (int i = 0; i < iArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.A0);
            }
            a(stringBuffer, str, iArr[i]);
        }
        stringBuffer.append(this.C0);
    }

    protected void a(StringBuffer stringBuffer, String str, long[] jArr) {
        stringBuffer.append(this.z0);
        for (int i = 0; i < jArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.A0);
            }
            a(stringBuffer, str, jArr[i]);
        }
        stringBuffer.append(this.C0);
    }

    protected void a(StringBuffer stringBuffer, String str, Object[] objArr) {
        stringBuffer.append(this.z0);
        for (int i = 0; i < objArr.length; i++) {
            a(stringBuffer, str, i, objArr[i]);
        }
        stringBuffer.append(this.C0);
    }

    protected void a(StringBuffer stringBuffer, String str, short[] sArr) {
        stringBuffer.append(this.z0);
        for (int i = 0; i < sArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.A0);
            }
            a(stringBuffer, str, sArr[i]);
        }
        stringBuffer.append(this.C0);
    }

    protected void a(StringBuffer stringBuffer, String str, boolean[] zArr) {
        stringBuffer.append(this.z0);
        for (int i = 0; i < zArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(this.A0);
            }
            a(stringBuffer, str, zArr[i]);
        }
        stringBuffer.append(this.C0);
    }

    protected void a(StringBuffer stringBuffer, String str) {
        c(stringBuffer);
    }

    protected void a(StringBuffer stringBuffer, String str, Object obj, boolean z) {
        int size;
        if (a(obj) && !(obj instanceof Number) && !(obj instanceof Boolean) && !(obj instanceof Character)) {
            a(stringBuffer, str, obj);
            return;
        }
        b(obj);
        try {
            if (obj instanceof Collection) {
                if (z) {
                    a(stringBuffer, str, (Collection<?>) obj);
                } else {
                    size = ((Collection) obj).size();
                    b(stringBuffer, str, size);
                }
            } else if (obj instanceof Map) {
                if (z) {
                    a(stringBuffer, str, (Map<?, ?>) obj);
                } else {
                    size = ((Map) obj).size();
                    b(stringBuffer, str, size);
                }
            } else if (obj instanceof long[]) {
                if (z) {
                    a(stringBuffer, str, (long[]) obj);
                } else {
                    b(stringBuffer, str, (long[]) obj);
                }
            } else if (obj instanceof int[]) {
                if (z) {
                    a(stringBuffer, str, (int[]) obj);
                } else {
                    b(stringBuffer, str, (int[]) obj);
                }
            } else if (obj instanceof short[]) {
                if (z) {
                    a(stringBuffer, str, (short[]) obj);
                } else {
                    b(stringBuffer, str, (short[]) obj);
                }
            } else if (obj instanceof byte[]) {
                if (z) {
                    a(stringBuffer, str, (byte[]) obj);
                } else {
                    b(stringBuffer, str, (byte[]) obj);
                }
            } else if (obj instanceof char[]) {
                if (z) {
                    a(stringBuffer, str, (char[]) obj);
                } else {
                    b(stringBuffer, str, (char[]) obj);
                }
            } else if (obj instanceof double[]) {
                if (z) {
                    a(stringBuffer, str, (double[]) obj);
                } else {
                    b(stringBuffer, str, (double[]) obj);
                }
            } else if (obj instanceof float[]) {
                if (z) {
                    a(stringBuffer, str, (float[]) obj);
                } else {
                    b(stringBuffer, str, (float[]) obj);
                }
            } else if (obj instanceof boolean[]) {
                if (z) {
                    a(stringBuffer, str, (boolean[]) obj);
                } else {
                    b(stringBuffer, str, (boolean[]) obj);
                }
            } else if (obj.getClass().isArray()) {
                if (z) {
                    a(stringBuffer, str, (Object[]) obj);
                } else {
                    b(stringBuffer, str, (Object[]) obj);
                }
            } else if (z) {
                b(stringBuffer, str, obj);
            } else {
                c(stringBuffer, str, obj);
            }
        } finally {
            c(obj);
        }
    }

    protected String a() {
        return this.C0;
    }

    protected String a(Class<?> cls) {
        return sdk.pendo.io.o2.d.a(cls);
    }

    protected boolean a(Boolean bool) {
        return bool == null ? this.D0 : bool.booleanValue();
    }

    static boolean a(Object obj) {
        Map<Object, Object> h = h();
        return h != null && h.containsKey(obj);
    }

    protected void a(String str) {
        if (str == null) {
            str = "";
        }
        this.C0 = str;
    }

    protected void a(boolean z) {
        this.w0 = z;
    }
}
