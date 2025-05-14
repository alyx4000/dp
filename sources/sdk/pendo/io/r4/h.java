package sdk.pendo.io.r4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import sdk.pendo.io.y4.l3;

/* loaded from: classes6.dex */
public final class h {
    private String[] b;
    private String[] c;
    private boolean d;
    private boolean e;
    private String f;
    private sdk.pendo.io.s4.a g;
    private List<e> h;
    private List<d> i;
    private boolean j;

    /* renamed from: a, reason: collision with root package name */
    private String[] f1526a = l3.i;
    private int k = 0;

    public h(String[] strArr, String[] strArr2) {
        b(strArr);
        c(strArr2);
    }

    private static <T> List<T> a(Collection<T> collection) {
        if (collection == null) {
            return null;
        }
        return collection.isEmpty() ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(collection));
    }

    public String[] b() {
        return l3.a(this.f1526a);
    }

    public String[] c() {
        return l3.a(this.b);
    }

    public String d() {
        return this.f;
    }

    public int e() {
        return this.k;
    }

    public boolean f() {
        return this.e;
    }

    public String[] g() {
        return l3.a(this.c);
    }

    public Collection<d> h() {
        return a(this.i);
    }

    public List<e> i() {
        return a((Collection) this.h);
    }

    public boolean j() {
        return this.j;
    }

    public boolean k() {
        return this.d;
    }

    public sdk.pendo.io.s4.a a() {
        return this.g;
    }

    public void b(String[] strArr) {
        this.b = l3.a(strArr);
    }

    public void c(String[] strArr) {
        this.c = l3.a(strArr);
    }

    public void a(sdk.pendo.io.s4.a aVar) {
        this.g = aVar;
    }

    public void b(Collection<d> collection) {
        List<d> a2;
        if (collection == null) {
            a2 = null;
        } else {
            a2 = a(collection);
            HashSet hashSet = new HashSet();
            Iterator<d> it = a2.iterator();
            while (it.hasNext()) {
                int a3 = it.next().a();
                if (!hashSet.add(Integer.valueOf(a3))) {
                    throw new IllegalArgumentException("Found duplicate SNI matcher entry of type " + a3);
                }
            }
        }
        this.i = a2;
    }

    public void c(boolean z) {
        this.d = z;
        this.e = false;
    }

    public void a(String[] strArr) {
        if (strArr == null) {
            throw new NullPointerException("'applicationProtocols' cannot be null");
        }
        String[] a2 = l3.a(strArr);
        for (String str : a2) {
            if (l3.b(str)) {
                throw new IllegalArgumentException("'applicationProtocols' entries cannot be null or empty strings");
            }
        }
        this.f1526a = a2;
    }

    public void b(boolean z) {
        this.j = z;
    }

    public void a(String str) {
        this.f = str;
    }

    public void a(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("The maximum packet size cannot be negative");
        }
        this.k = i;
    }

    public void a(boolean z) {
        this.e = z;
        this.d = false;
    }

    public void a(List<e> list) {
        List<e> a2;
        if (list == null) {
            a2 = null;
        } else {
            a2 = a((Collection) list);
            HashSet hashSet = new HashSet();
            Iterator<e> it = a2.iterator();
            while (it.hasNext()) {
                int b = it.next().b();
                if (!hashSet.add(Integer.valueOf(b))) {
                    throw new IllegalArgumentException("Found duplicate SNI server name entry of type " + b);
                }
            }
        }
        this.h = a2;
    }
}
