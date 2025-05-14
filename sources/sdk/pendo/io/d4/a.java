package sdk.pendo.io.d4;

import java.util.Enumeration;
import java.util.Hashtable;
import sdk.pendo.io.c4.d;
import sdk.pendo.io.m3.g;

/* loaded from: classes6.dex */
public abstract class a implements d {
    @Override // sdk.pendo.io.c4.d
    public boolean a(sdk.pendo.io.c4.c cVar, sdk.pendo.io.c4.c cVar2) {
        sdk.pendo.io.c4.b[] h = cVar.h();
        sdk.pendo.io.c4.b[] h2 = cVar2.h();
        if (h.length != h2.length) {
            return false;
        }
        boolean z = (h[0].h() == null || h2[0].h() == null) ? false : !h[0].h().h().b(h2[0].h().h());
        for (int i = 0; i != h.length; i++) {
            if (!a(z, h[i], h2)) {
                return false;
            }
        }
        return true;
    }

    @Override // sdk.pendo.io.c4.d
    public int b(sdk.pendo.io.c4.c cVar) {
        sdk.pendo.io.c4.b[] h = cVar.h();
        int i = 0;
        for (int i2 = 0; i2 != h.length; i2++) {
            if (h[i2].j()) {
                sdk.pendo.io.c4.a[] i3 = h[i2].i();
                for (int i4 = 0; i4 != i3.length; i4++) {
                    i = (i ^ i3[i4].h().hashCode()) ^ a(i3[i4].i());
                }
            } else {
                i = (i ^ h[i2].h().h().hashCode()) ^ a(h[i2].h().i());
            }
        }
        return i;
    }

    private int a(g gVar) {
        return c.a(gVar).hashCode();
    }

    public static Hashtable a(Hashtable hashtable) {
        Hashtable hashtable2 = new Hashtable();
        Enumeration keys = hashtable.keys();
        while (keys.hasMoreElements()) {
            Object nextElement = keys.nextElement();
            hashtable2.put(nextElement, hashtable.get(nextElement));
        }
        return hashtable2;
    }

    private boolean a(boolean z, sdk.pendo.io.c4.b bVar, sdk.pendo.io.c4.b[] bVarArr) {
        if (z) {
            for (int length = bVarArr.length - 1; length >= 0; length--) {
                sdk.pendo.io.c4.b bVar2 = bVarArr[length];
                if (bVar2 != null && a(bVar, bVar2)) {
                    bVarArr[length] = null;
                    return true;
                }
            }
        } else {
            for (int i = 0; i != bVarArr.length; i++) {
                sdk.pendo.io.c4.b bVar3 = bVarArr[i];
                if (bVar3 != null && a(bVar, bVar3)) {
                    bVarArr[i] = null;
                    return true;
                }
            }
        }
        return false;
    }

    protected boolean a(sdk.pendo.io.c4.b bVar, sdk.pendo.io.c4.b bVar2) {
        return c.a(bVar, bVar2);
    }
}
