package sdk.pendo.io.b2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class d extends HashMap<String, Object> implements c, f {
    public static String a(Map<String, ? extends Object> map, g gVar) {
        StringBuilder sb = new StringBuilder();
        try {
            a(map, sb, gVar);
        } catch (IOException unused) {
        }
        return sb.toString();
    }

    @Override // sdk.pendo.io.b2.b
    public String c() {
        return a(this, i.f884a);
    }

    @Override // java.util.AbstractMap
    public String toString() {
        return a(this, i.f884a);
    }

    @Override // sdk.pendo.io.b2.c
    public String a(g gVar) {
        return a(this, gVar);
    }

    public static void a(Map<String, ? extends Object> map, Appendable appendable, g gVar) {
        if (map == null) {
            appendable.append("null");
        } else {
            sdk.pendo.io.e2.d.i.a(map, appendable, gVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.lang.String r1, java.lang.Object r2, java.lang.Appendable r3, sdk.pendo.io.b2.g r4) {
        /*
            if (r1 != 0) goto L8
            java.lang.String r1 = "null"
        L4:
            r3.append(r1)
            goto L1a
        L8:
            boolean r0 = r4.a(r1)
            if (r0 != 0) goto Lf
            goto L4
        Lf:
            r0 = 34
            r3.append(r0)
            sdk.pendo.io.b2.i.a(r1, r3, r4)
            r3.append(r0)
        L1a:
            r1 = 58
            r3.append(r1)
            boolean r1 = r2 instanceof java.lang.String
            if (r1 == 0) goto L29
            java.lang.String r2 = (java.lang.String) r2
            r4.a(r3, r2)
            goto L2c
        L29:
            sdk.pendo.io.b2.i.a(r2, r3, r4)
        L2c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.b2.d.a(java.lang.String, java.lang.Object, java.lang.Appendable, sdk.pendo.io.b2.g):void");
    }

    @Override // sdk.pendo.io.b2.e
    public void a(Appendable appendable) {
        a(this, appendable, i.f884a);
    }

    @Override // sdk.pendo.io.b2.f
    public void a(Appendable appendable, g gVar) {
        a(this, appendable, gVar);
    }
}
