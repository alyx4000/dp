package external.sdk.pendo.io.gson;

import external.sdk.pendo.io.gson.internal.Excluder;
import external.sdk.pendo.io.gson.internal.bind.DefaultDateTypeAdapter;
import external.sdk.pendo.io.gson.internal.bind.TreeTypeAdapter;
import external.sdk.pendo.io.gson.internal.bind.TypeAdapters;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sdk.pendo.io.k0.c;
import sdk.pendo.io.k0.d;
import sdk.pendo.io.k0.e;
import sdk.pendo.io.k0.h;
import sdk.pendo.io.k0.p;
import sdk.pendo.io.k0.r;
import sdk.pendo.io.k0.t;
import sdk.pendo.io.k0.u;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private Excluder f724a = Excluder.v0;
    private r b = r.DEFAULT;
    private d c = c.IDENTITY;
    private final Map<Type, e<?>> d = new HashMap();
    private final List<u> e = new ArrayList();
    private final List<u> f = new ArrayList();
    private boolean g = false;
    private String h = Gson.y;
    private int i = 2;
    private int j = 2;
    private boolean k = false;
    private boolean l = false;
    private boolean m = true;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private boolean q = true;
    private t r = Gson.A;
    private t s = Gson.B;

    private void a(String str, int i, int i2, List<u> list) {
        u uVar;
        u uVar2;
        boolean z = external.sdk.pendo.io.gson.internal.sql.a.f749a;
        u uVar3 = null;
        if (str != null && !str.trim().isEmpty()) {
            uVar = DefaultDateTypeAdapter.b.b.a(str);
            if (z) {
                uVar3 = external.sdk.pendo.io.gson.internal.sql.a.c.a(str);
                uVar2 = external.sdk.pendo.io.gson.internal.sql.a.b.a(str);
            }
            uVar2 = null;
        } else {
            if (i == 2 || i2 == 2) {
                return;
            }
            u a2 = DefaultDateTypeAdapter.b.b.a(i, i2);
            if (z) {
                uVar3 = external.sdk.pendo.io.gson.internal.sql.a.c.a(i, i2);
                u a3 = external.sdk.pendo.io.gson.internal.sql.a.b.a(i, i2);
                uVar = a2;
                uVar2 = a3;
            } else {
                uVar = a2;
                uVar2 = null;
            }
        }
        list.add(uVar);
        if (z) {
            list.add(uVar3);
            list.add(uVar2);
        }
    }

    public a b() {
        this.m = false;
        return this;
    }

    public a c() {
        this.f724a = this.f724a.d();
        return this;
    }

    public Gson a() {
        List<u> arrayList = new ArrayList<>(this.e.size() + this.f.size() + 3);
        arrayList.addAll(this.e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        a(this.h, this.i, this.j, arrayList);
        return new Gson(this.f724a, this.c, this.d, this.g, this.k, this.o, this.m, this.n, this.p, this.l, this.q, this.b, this.h, this.i, this.j, this.e, this.f, arrayList, this.r, this.s);
    }

    public a a(Type type, Object obj) {
        boolean z = obj instanceof p;
        sdk.pendo.io.m0.a.a(z || (obj instanceof h) || (obj instanceof e) || (obj instanceof TypeAdapter));
        if (obj instanceof e) {
            this.d.put(type, (e) obj);
        }
        if (z || (obj instanceof h)) {
            this.e.add(TreeTypeAdapter.a(sdk.pendo.io.q0.a.a(type), obj));
        }
        if (obj instanceof TypeAdapter) {
            this.e.add(TypeAdapters.a(sdk.pendo.io.q0.a.a(type), (TypeAdapter) obj));
        }
        return this;
    }
}
