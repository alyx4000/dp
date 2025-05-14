package sdk.pendo.io.m3;

import androidx.core.view.InputDeviceCompat;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import okhttp3.HttpUrl;
import sdk.pendo.io.d5.a;

/* loaded from: classes6.dex */
public abstract class d0 extends a0 implements Iterable {
    static final o0 s = new a(d0.class, 16);
    g[] f;

    static class a extends o0 {
        a(Class cls, int i) {
            super(cls, i);
        }

        @Override // sdk.pendo.io.m3.o0
        a0 a(d0 d0Var) {
            return d0Var;
        }
    }

    class b implements Enumeration {

        /* renamed from: a, reason: collision with root package name */
        private int f1386a = 0;

        b() {
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.f1386a < d0.this.f.length;
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            int i = this.f1386a;
            g[] gVarArr = d0.this.f;
            if (i >= gVarArr.length) {
                throw new NoSuchElementException();
            }
            this.f1386a = i + 1;
            return gVarArr[i];
        }
    }

    protected d0() {
        this.f = h.d;
    }

    @Override // sdk.pendo.io.m3.a0
    boolean a(a0 a0Var) {
        if (!(a0Var instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) a0Var;
        int size = size();
        if (d0Var.size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            a0 b2 = this.f[i].b();
            a0 b3 = d0Var.f[i].b();
            if (b2 != b3 && !b2.a(b3)) {
                return false;
            }
        }
        return true;
    }

    @Override // sdk.pendo.io.m3.a0
    boolean h() {
        return true;
    }

    @Override // sdk.pendo.io.m3.a0, sdk.pendo.io.m3.t
    public int hashCode() {
        int length = this.f.length;
        int i = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            i = (i * InputDeviceCompat.SOURCE_KEYBOARD) ^ this.f[length].b().hashCode();
        }
    }

    @Override // sdk.pendo.io.m3.a0
    a0 i() {
        return new w1(this.f, false);
    }

    @Override // java.lang.Iterable
    public Iterator<g> iterator() {
        return new a.C0112a(this.f);
    }

    @Override // sdk.pendo.io.m3.a0
    a0 j() {
        return new k2(this.f, false);
    }

    c[] k() {
        int size = size();
        c[] cVarArr = new c[size];
        for (int i = 0; i < size; i++) {
            cVarArr[i] = c.a(this.f[i]);
        }
        return cVarArr;
    }

    w[] l() {
        int size = size();
        w[] wVarArr = new w[size];
        for (int i = 0; i < size; i++) {
            wVarArr[i] = w.a(this.f[i]);
        }
        return wVarArr;
    }

    public Enumeration m() {
        return new b();
    }

    abstract c n();

    abstract k o();

    abstract w p();

    abstract e0 q();

    g[] r() {
        return this.f;
    }

    public int size() {
        return this.f.length;
    }

    public String toString() {
        int size = size();
        if (size == 0) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuffer stringBuffer = new StringBuffer("[");
        int i = 0;
        while (true) {
            stringBuffer.append(this.f[i]);
            i++;
            if (i >= size) {
                stringBuffer.append(']');
                return stringBuffer.toString();
            }
            stringBuffer.append(", ");
        }
    }

    protected d0(g gVar) {
        if (gVar == null) {
            throw new NullPointerException("'element' cannot be null");
        }
        this.f = new g[]{gVar};
    }

    public static d0 a(Object obj) {
        if (obj == null || (obj instanceof d0)) {
            return (d0) obj;
        }
        if (obj instanceof g) {
            a0 b2 = ((g) obj).b();
            if (b2 instanceof d0) {
                return (d0) b2;
            }
        } else if (obj instanceof byte[]) {
            try {
                return (d0) s.a((byte[]) obj);
            } catch (IOException e) {
                throw new IllegalArgumentException("failed to construct sequence from byte[]: " + e.getMessage());
            }
        }
        throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
    }

    protected d0(h hVar) {
        if (hVar == null) {
            throw new NullPointerException("'elementVector' cannot be null");
        }
        this.f = hVar.c();
    }

    public static d0 a(j0 j0Var, boolean z) {
        return (d0) s.a(j0Var, z);
    }

    protected d0(g[] gVarArr) {
        if (sdk.pendo.io.d5.a.a(gVarArr)) {
            throw new NullPointerException("'elements' cannot be null, or contain null");
        }
        this.f = h.a(gVarArr);
    }

    public g a(int i) {
        return this.f[i];
    }

    d0(g[] gVarArr, boolean z) {
        this.f = z ? h.a(gVarArr) : gVarArr;
    }
}
