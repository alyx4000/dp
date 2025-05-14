package sdk.pendo.io.w3;

import sdk.pendo.io.m3.a0;
import sdk.pendo.io.m3.i;
import sdk.pendo.io.m3.t;

/* loaded from: classes4.dex */
public class b extends t {
    private i f;

    private b(i iVar) {
        this.f = iVar;
    }

    public static b a(Object obj) {
        if (obj instanceof b) {
            return (b) obj;
        }
        if (obj != null) {
            return new b(i.a(obj));
        }
        return null;
    }

    @Override // sdk.pendo.io.m3.t, sdk.pendo.io.m3.g
    public a0 b() {
        return this.f;
    }
}
