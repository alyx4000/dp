package sdk.pendo.io.j7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Queue;

/* loaded from: classes6.dex */
public class e implements sdk.pendo.io.h7.a {
    private Boolean A;
    private final String f;
    private Method f0;
    private volatile sdk.pendo.io.h7.a s;
    private sdk.pendo.io.i7.a t0;
    private Queue<sdk.pendo.io.i7.d> u0;
    private final boolean v0;

    public e(String str, Queue<sdk.pendo.io.i7.d> queue, boolean z) {
        this.f = str;
        this.u0 = queue;
        this.v0 = z;
    }

    private sdk.pendo.io.h7.a c() {
        if (this.t0 == null) {
            this.t0 = new sdk.pendo.io.i7.a(this, this.u0);
        }
        return this.t0;
    }

    @Override // sdk.pendo.io.h7.a
    public void a(String str) {
        b().a(str);
    }

    @Override // sdk.pendo.io.h7.a
    public void b(String str, Object obj) {
        b().b(str, obj);
    }

    public boolean d() {
        Boolean bool = this.A;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            this.f0 = this.s.getClass().getMethod("log", sdk.pendo.io.i7.c.class);
            this.A = Boolean.TRUE;
        } catch (NoSuchMethodException unused) {
            this.A = Boolean.FALSE;
        }
        return this.A.booleanValue();
    }

    public boolean e() {
        return this.s instanceof b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f.equals(((e) obj).f);
    }

    public boolean f() {
        return this.s == null;
    }

    @Override // sdk.pendo.io.h7.a
    public String getName() {
        return this.f;
    }

    public int hashCode() {
        return this.f.hashCode();
    }

    @Override // sdk.pendo.io.h7.a
    public void a(String str, Object obj, Object obj2) {
        b().a(str, obj, obj2);
    }

    sdk.pendo.io.h7.a b() {
        return this.s != null ? this.s : this.v0 ? b.f : c();
    }

    @Override // sdk.pendo.io.h7.a
    public void a(String str, Throwable th) {
        b().a(str, th);
    }

    @Override // sdk.pendo.io.h7.a
    public void b(String str, Object obj, Object obj2) {
        b().b(str, obj, obj2);
    }

    @Override // sdk.pendo.io.h7.a
    public void a(String str, Object... objArr) {
        b().a(str, objArr);
    }

    @Override // sdk.pendo.io.h7.a
    public void b(String str, Object... objArr) {
        b().b(str, objArr);
    }

    @Override // sdk.pendo.io.h7.a
    public boolean a() {
        return b().a();
    }

    public void a(sdk.pendo.io.i7.c cVar) {
        if (d()) {
            try {
                this.f0.invoke(this.s, cVar);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
    }

    public void a(sdk.pendo.io.h7.a aVar) {
        this.s = aVar;
    }

    @Override // sdk.pendo.io.h7.a
    public void a(String str, Object obj) {
        b().a(str, obj);
    }
}
