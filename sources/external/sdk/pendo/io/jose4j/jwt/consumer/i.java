package external.sdk.pendo.io.jose4j.jwt.consumer;

import java.security.Key;
import java.util.List;
import sdk.pendo.io.b1.o;

/* loaded from: classes2.dex */
class i implements sdk.pendo.io.j1.b, sdk.pendo.io.j1.a {

    /* renamed from: a, reason: collision with root package name */
    private Key f758a;

    i(Key key) {
        this.f758a = key;
    }

    @Override // sdk.pendo.io.j1.a
    public Key a(o oVar, List<sdk.pendo.io.h1.c> list) {
        return this.f758a;
    }

    @Override // sdk.pendo.io.j1.b
    public Key a(sdk.pendo.io.e1.e eVar, List<sdk.pendo.io.h1.c> list) {
        return this.f758a;
    }
}
