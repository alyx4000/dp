package sdk.pendo.io.t4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLSocket;
import sdk.pendo.io.y4.l3;

/* loaded from: classes6.dex */
final class s0 {

    /* renamed from: a, reason: collision with root package name */
    private final p0 f1611a;
    private String[] b;
    private String[] c;
    private String g;
    private List<sdk.pendo.io.r4.d> j;
    private List<sdk.pendo.io.r4.e> k;
    private sdk.pendo.io.r4.a<SSLEngine> m;
    private sdk.pendo.io.r4.a<SSLSocket> n;
    private v0 o;
    private boolean d = false;
    private boolean e = false;
    private sdk.pendo.io.s4.a f = k0.h;
    private boolean h = true;
    private int i = 0;
    private String[] l = l3.i;

    s0(p0 p0Var, String[] strArr, String[] strArr2) {
        this.f1611a = p0Var;
        this.b = strArr;
        this.c = strArr2;
    }

    s0 a() {
        s0 s0Var = new s0(this.f1611a, this.b, this.c);
        s0Var.d = this.d;
        s0Var.e = this.e;
        s0Var.f = this.f;
        s0Var.g = this.g;
        s0Var.h = this.h;
        s0Var.j = this.j;
        s0Var.k = this.k;
        s0Var.l = this.l;
        s0Var.m = this.m;
        s0Var.n = this.n;
        s0Var.o = this.o;
        return s0Var;
    }

    s0 b() {
        s0 a2 = a();
        if (k0.h != a2.f) {
            a2.f = new k0(a2.f, true);
        }
        return a2;
    }

    public sdk.pendo.io.s4.a c() {
        return this.f;
    }

    public String[] d() {
        return (String[]) this.l.clone();
    }

    public String[] e() {
        return (String[]) this.b.clone();
    }

    String[] f() {
        return this.b;
    }

    public String g() {
        return this.g;
    }

    public sdk.pendo.io.r4.a<SSLEngine> h() {
        return this.m;
    }

    public int i() {
        return this.i;
    }

    public boolean j() {
        return this.d;
    }

    public String[] k() {
        return (String[]) this.c.clone();
    }

    String[] l() {
        return this.c;
    }

    public Collection<sdk.pendo.io.r4.d> m() {
        return a(this.j);
    }

    public List<sdk.pendo.io.r4.e> n() {
        return a((Collection) this.k);
    }

    public v0 o() {
        return this.o;
    }

    public sdk.pendo.io.r4.a<SSLSocket> p() {
        return this.n;
    }

    public boolean q() {
        return this.h;
    }

    public boolean r() {
        return this.e;
    }

    private static <T> List<T> a(Collection<T> collection) {
        if (collection == null) {
            return null;
        }
        return collection.isEmpty() ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(collection));
    }

    public void b(String[] strArr) {
        this.b = this.f1611a.a(strArr);
    }

    void c(String[] strArr) {
        this.b = strArr;
    }

    public void d(String[] strArr) {
        if (!this.f1611a.b(strArr)) {
            throw new IllegalArgumentException("'protocols' cannot be null, or contain unsupported protocols");
        }
        this.c = (String[]) strArr.clone();
    }

    void e(String[] strArr) {
        this.c = strArr;
    }

    public void a(sdk.pendo.io.s4.a aVar) {
        this.f = aVar;
    }

    public void b(Collection<sdk.pendo.io.r4.d> collection) {
        this.j = a(collection);
    }

    public void c(boolean z) {
        this.d = false;
        this.e = z;
    }

    public void a(String[] strArr) {
        this.l = (String[]) strArr.clone();
    }

    public void b(sdk.pendo.io.r4.a<SSLSocket> aVar) {
        this.n = aVar;
    }

    public void a(String str) {
        this.g = str;
    }

    public void b(boolean z) {
        this.h = z;
    }

    public void a(sdk.pendo.io.r4.a<SSLEngine> aVar) {
        this.m = aVar;
    }

    public void a(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("The maximum packet size cannot be negative");
        }
        this.i = i;
    }

    public void a(boolean z) {
        this.d = z;
        this.e = false;
    }

    public void a(List<sdk.pendo.io.r4.e> list) {
        this.k = a((Collection) list);
    }
}
