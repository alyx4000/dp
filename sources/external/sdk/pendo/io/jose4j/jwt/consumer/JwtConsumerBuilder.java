package external.sdk.pendo.io.jose4j.jwt.consumer;

import java.security.Key;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class JwtConsumerBuilder {
    private sdk.pendo.io.a1.c c;
    private sdk.pendo.io.a1.c d;
    private sdk.pendo.io.a1.c e;
    private boolean f;
    private a g;
    private e h;
    private boolean i;
    private String j;
    private boolean k;
    private boolean o;
    private boolean p;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean w;
    private sdk.pendo.io.w0.a x;
    private sdk.pendo.io.w0.a y;

    /* renamed from: a, reason: collision with root package name */
    private sdk.pendo.io.j1.b f751a = new i(null);
    private sdk.pendo.io.j1.a b = new i(null);
    private h l = new h();
    private List<b> m = new ArrayList();
    private boolean n = true;
    private boolean q = false;
    private boolean u = false;
    private boolean v = false;

    public JwtConsumer a() {
        ArrayList arrayList = new ArrayList();
        if (!this.u) {
            if (!this.v) {
                if (!this.f) {
                    if (this.g == null) {
                        this.g = new a(Collections.emptySet(), false);
                    }
                    arrayList.add(this.g);
                }
                if (this.h == null) {
                    this.h = new e(null, false);
                }
                arrayList.add(this.h);
                arrayList.add(this.l);
                arrayList.add(this.j == null ? new j(this.i) : new j(this.j));
                arrayList.add(new f(this.k));
            }
            arrayList.addAll(this.m);
        }
        JwtConsumer jwtConsumer = new JwtConsumer();
        jwtConsumer.a(arrayList);
        jwtConsumer.a(this.f751a);
        jwtConsumer.a(this.b);
        jwtConsumer.c(this.c);
        jwtConsumer.a(this.d);
        jwtConsumer.b(this.e);
        jwtConsumer.f(this.n);
        jwtConsumer.d(this.o);
        jwtConsumer.e(this.p);
        jwtConsumer.a(this.w);
        jwtConsumer.g(this.q);
        jwtConsumer.h(this.s);
        jwtConsumer.c(this.r);
        jwtConsumer.b(this.t);
        jwtConsumer.a((sdk.pendo.io.g1.b) null);
        jwtConsumer.a((sdk.pendo.io.g1.a) null);
        jwtConsumer.b(this.x);
        jwtConsumer.a(this.y);
        return jwtConsumer;
    }

    public JwtConsumerBuilder b() {
        this.r = true;
        return this;
    }

    public JwtConsumerBuilder a(sdk.pendo.io.a1.c cVar) {
        this.d = cVar;
        return this;
    }

    public JwtConsumerBuilder a(Key key) {
        return a(new i(key));
    }

    public JwtConsumerBuilder a(sdk.pendo.io.j1.b bVar) {
        this.f751a = bVar;
        return this;
    }
}
