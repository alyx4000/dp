package sdk.pendo.io.c4;

import sdk.pendo.io.m3.a0;
import sdk.pendo.io.m3.e0;
import sdk.pendo.io.m3.t;

/* loaded from: classes6.dex */
public class b extends t {
    private e0 f;

    private b(e0 e0Var) {
        this.f = e0Var;
    }

    public static b a(Object obj) {
        if (obj instanceof b) {
            return (b) obj;
        }
        if (obj != null) {
            return new b(e0.a(obj));
        }
        return null;
    }

    @Override // sdk.pendo.io.m3.t, sdk.pendo.io.m3.g
    public a0 b() {
        return this.f;
    }

    public a h() {
        if (this.f.size() == 0) {
            return null;
        }
        return a.a(this.f.a(0));
    }

    public a[] i() {
        int size = this.f.size();
        a[] aVarArr = new a[size];
        for (int i = 0; i != size; i++) {
            aVarArr[i] = a.a(this.f.a(i));
        }
        return aVarArr;
    }

    public boolean j() {
        return this.f.size() > 1;
    }

    public int size() {
        return this.f.size();
    }
}
