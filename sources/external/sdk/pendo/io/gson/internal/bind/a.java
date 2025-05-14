package external.sdk.pendo.io.gson.internal.bind;

import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import sdk.pendo.io.k0.f;
import sdk.pendo.io.k0.i;
import sdk.pendo.io.k0.k;
import sdk.pendo.io.k0.l;
import sdk.pendo.io.k0.n;
import sdk.pendo.io.r0.b;

/* loaded from: classes2.dex */
public final class a extends sdk.pendo.io.r0.a {
    private static final Reader I0 = new C0068a();
    private static final Object J0 = new Object();
    private Object[] E0;
    private int F0;
    private String[] G0;
    private int[] H0;

    /* renamed from: external.sdk.pendo.io.gson.internal.bind.a$a, reason: collision with other inner class name */
    class C0068a extends Reader {
        C0068a() {
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }
    }

    public a(i iVar) {
        super(I0);
        this.E0 = new Object[32];
        this.F0 = 0;
        this.G0 = new String[32];
        this.H0 = new int[32];
        a(iVar);
    }

    private Object L() {
        return this.E0[this.F0 - 1];
    }

    private Object M() {
        Object[] objArr = this.E0;
        int i = this.F0 - 1;
        this.F0 = i;
        Object obj = objArr[i];
        objArr[i] = null;
        return obj;
    }

    private String u() {
        return " at path " + q();
    }

    @Override // sdk.pendo.io.r0.a
    public void A() {
        a(b.NULL);
        M();
        int i = this.F0;
        if (i > 0) {
            int[] iArr = this.H0;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // sdk.pendo.io.r0.a
    public String B() {
        b D = D();
        b bVar = b.STRING;
        if (D != bVar && D != b.NUMBER) {
            throw new IllegalStateException("Expected " + bVar + " but was " + D + u());
        }
        String g = ((n) M()).g();
        int i = this.F0;
        if (i > 0) {
            int[] iArr = this.H0;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return g;
    }

    @Override // sdk.pendo.io.r0.a
    public b D() {
        if (this.F0 == 0) {
            return b.END_DOCUMENT;
        }
        Object L = L();
        if (L instanceof Iterator) {
            boolean z = this.E0[this.F0 - 2] instanceof l;
            Iterator it = (Iterator) L;
            if (!it.hasNext()) {
                return z ? b.END_OBJECT : b.END_ARRAY;
            }
            if (z) {
                return b.NAME;
            }
            a(it.next());
            return D();
        }
        if (L instanceof l) {
            return b.BEGIN_OBJECT;
        }
        if (L instanceof f) {
            return b.BEGIN_ARRAY;
        }
        if (!(L instanceof n)) {
            if (L instanceof k) {
                return b.NULL;
            }
            if (L == J0) {
                throw new IllegalStateException("JsonReader is closed");
            }
            throw new AssertionError();
        }
        n nVar = (n) L;
        if (nVar.q()) {
            return b.STRING;
        }
        if (nVar.o()) {
            return b.BOOLEAN;
        }
        if (nVar.p()) {
            return b.NUMBER;
        }
        throw new AssertionError();
    }

    @Override // sdk.pendo.io.r0.a
    public void J() {
        if (D() == b.NAME) {
            z();
            this.G0[this.F0 - 2] = "null";
        } else {
            M();
            int i = this.F0;
            if (i > 0) {
                this.G0[i - 1] = "null";
            }
        }
        int i2 = this.F0;
        if (i2 > 0) {
            int[] iArr = this.H0;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    i K() {
        b D = D();
        if (D == b.NAME || D == b.END_ARRAY || D == b.END_OBJECT || D == b.END_DOCUMENT) {
            throw new IllegalStateException("Unexpected " + D + " when reading a JsonElement.");
        }
        i iVar = (i) L();
        J();
        return iVar;
    }

    public void N() {
        a(b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) L()).next();
        a(entry.getValue());
        a(new n((String) entry.getKey()));
    }

    @Override // sdk.pendo.io.r0.a
    public void a() {
        a(b.BEGIN_ARRAY);
        a(((f) L()).iterator());
        this.H0[this.F0 - 1] = 0;
    }

    @Override // sdk.pendo.io.r0.a
    public void b() {
        a(b.BEGIN_OBJECT);
        a(((l) L()).l().iterator());
    }

    @Override // sdk.pendo.io.r0.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.E0 = new Object[]{J0};
        this.F0 = 1;
    }

    @Override // sdk.pendo.io.r0.a
    public void o() {
        a(b.END_ARRAY);
        M();
        M();
        int i = this.F0;
        if (i > 0) {
            int[] iArr = this.H0;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // sdk.pendo.io.r0.a
    public void p() {
        a(b.END_OBJECT);
        M();
        M();
        int i = this.F0;
        if (i > 0) {
            int[] iArr = this.H0;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // sdk.pendo.io.r0.a
    public String q() {
        return a(false);
    }

    @Override // sdk.pendo.io.r0.a
    public String r() {
        return a(true);
    }

    @Override // sdk.pendo.io.r0.a
    public boolean s() {
        b D = D();
        return (D == b.END_OBJECT || D == b.END_ARRAY || D == b.END_DOCUMENT) ? false : true;
    }

    @Override // sdk.pendo.io.r0.a
    public String toString() {
        return "a" + u();
    }

    @Override // sdk.pendo.io.r0.a
    public boolean v() {
        a(b.BOOLEAN);
        boolean a2 = ((n) M()).a();
        int i = this.F0;
        if (i > 0) {
            int[] iArr = this.H0;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return a2;
    }

    @Override // sdk.pendo.io.r0.a
    public double w() {
        b D = D();
        b bVar = b.NUMBER;
        if (D != bVar && D != b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + D + u());
        }
        double l = ((n) L()).l();
        if (!t() && (Double.isNaN(l) || Double.isInfinite(l))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + l);
        }
        M();
        int i = this.F0;
        if (i > 0) {
            int[] iArr = this.H0;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return l;
    }

    @Override // sdk.pendo.io.r0.a
    public int x() {
        b D = D();
        b bVar = b.NUMBER;
        if (D != bVar && D != b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + D + u());
        }
        int c = ((n) L()).c();
        M();
        int i = this.F0;
        if (i > 0) {
            int[] iArr = this.H0;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return c;
    }

    @Override // sdk.pendo.io.r0.a
    public long y() {
        b D = D();
        b bVar = b.NUMBER;
        if (D != bVar && D != b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + D + u());
        }
        long m = ((n) L()).m();
        M();
        int i = this.F0;
        if (i > 0) {
            int[] iArr = this.H0;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return m;
    }

    @Override // sdk.pendo.io.r0.a
    public String z() {
        a(b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) L()).next();
        String str = (String) entry.getKey();
        this.G0[this.F0 - 1] = str;
        a(entry.getValue());
        return str;
    }

    private void a(b bVar) {
        if (D() != bVar) {
            throw new IllegalStateException("Expected " + bVar + " but was " + D() + u());
        }
    }

    private String a(boolean z) {
        StringBuilder sb = new StringBuilder("$");
        int i = 0;
        while (true) {
            int i2 = this.F0;
            if (i >= i2) {
                return sb.toString();
            }
            Object[] objArr = this.E0;
            Object obj = objArr[i];
            if (obj instanceof f) {
                i++;
                if (i < i2 && (objArr[i] instanceof Iterator)) {
                    int i3 = this.H0[i];
                    if (z && i3 > 0 && (i == i2 - 1 || i == i2 - 2)) {
                        i3--;
                    }
                    sb.append('[').append(i3).append(']');
                }
            } else if ((obj instanceof l) && (i = i + 1) < i2 && (objArr[i] instanceof Iterator)) {
                sb.append('.');
                String str = this.G0[i];
                if (str != null) {
                    sb.append(str);
                }
            }
            i++;
        }
    }

    private void a(Object obj) {
        int i = this.F0;
        Object[] objArr = this.E0;
        if (i == objArr.length) {
            int i2 = i * 2;
            this.E0 = Arrays.copyOf(objArr, i2);
            this.H0 = Arrays.copyOf(this.H0, i2);
            this.G0 = (String[]) Arrays.copyOf(this.G0, i2);
        }
        Object[] objArr2 = this.E0;
        int i3 = this.F0;
        this.F0 = i3 + 1;
        objArr2[i3] = obj;
    }
}
