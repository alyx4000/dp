package sdk.pendo.io.n0;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import sdk.pendo.io.k0.f;
import sdk.pendo.io.k0.i;
import sdk.pendo.io.k0.k;
import sdk.pendo.io.k0.l;
import sdk.pendo.io.k0.n;
import sdk.pendo.io.r0.c;

/* loaded from: classes6.dex */
public final class a extends c {
    private static final Writer E0 = new C0201a();
    private static final n F0 = new n("closed");
    private final List<i> B0;
    private String C0;
    private i D0;

    /* renamed from: sdk.pendo.io.n0.a$a, reason: collision with other inner class name */
    class C0201a extends Writer {
        C0201a() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }
    }

    public a() {
        super(E0);
        this.B0 = new ArrayList();
        this.D0 = k.f;
    }

    private void a(i iVar) {
        if (this.C0 != null) {
            if (!iVar.i() || p()) {
                ((l) w()).a(this.C0, iVar);
            }
            this.C0 = null;
            return;
        }
        if (this.B0.isEmpty()) {
            this.D0 = iVar;
            return;
        }
        i w = w();
        if (!(w instanceof f)) {
            throw new IllegalStateException();
        }
        ((f) w).a(iVar);
    }

    private i w() {
        return this.B0.get(r0.size() - 1);
    }

    @Override // sdk.pendo.io.r0.c
    public c b(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.B0.isEmpty() || this.C0 != null) {
            throw new IllegalStateException();
        }
        if (!(w() instanceof l)) {
            throw new IllegalStateException();
        }
        this.C0 = str;
        return this;
    }

    @Override // sdk.pendo.io.r0.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.B0.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.B0.add(F0);
    }

    @Override // sdk.pendo.io.r0.c
    public c d(boolean z) {
        a(new n(Boolean.valueOf(z)));
        return this;
    }

    @Override // sdk.pendo.io.r0.c
    public c e() {
        f fVar = new f();
        a(fVar);
        this.B0.add(fVar);
        return this;
    }

    @Override // sdk.pendo.io.r0.c, java.io.Flushable
    public void flush() {
    }

    @Override // sdk.pendo.io.r0.c
    public c h(long j) {
        a(new n(Long.valueOf(j)));
        return this;
    }

    @Override // sdk.pendo.io.r0.c
    public c m() {
        l lVar = new l();
        a(lVar);
        this.B0.add(lVar);
        return this;
    }

    @Override // sdk.pendo.io.r0.c
    public c n() {
        if (this.B0.isEmpty() || this.C0 != null) {
            throw new IllegalStateException();
        }
        if (!(w() instanceof f)) {
            throw new IllegalStateException();
        }
        this.B0.remove(r0.size() - 1);
        return this;
    }

    @Override // sdk.pendo.io.r0.c
    public c o() {
        if (this.B0.isEmpty() || this.C0 != null) {
            throw new IllegalStateException();
        }
        if (!(w() instanceof l)) {
            throw new IllegalStateException();
        }
        this.B0.remove(r0.size() - 1);
        return this;
    }

    @Override // sdk.pendo.io.r0.c
    public c s() {
        a(k.f);
        return this;
    }

    public i v() {
        if (this.B0.isEmpty()) {
            return this.D0;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.B0);
    }

    @Override // sdk.pendo.io.r0.c
    public c a(Boolean bool) {
        if (bool == null) {
            return s();
        }
        a(new n(bool));
        return this;
    }

    @Override // sdk.pendo.io.r0.c
    public c e(String str) {
        if (str == null) {
            return s();
        }
        a(new n(str));
        return this;
    }

    @Override // sdk.pendo.io.r0.c
    public c a(Number number) {
        if (number == null) {
            return s();
        }
        if (!q()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        a(new n(number));
        return this;
    }
}
