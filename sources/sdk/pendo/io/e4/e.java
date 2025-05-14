package sdk.pendo.io.e4;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import sdk.pendo.io.m3.a0;
import sdk.pendo.io.m3.d0;
import sdk.pendo.io.m3.t;
import sdk.pendo.io.m3.v;
import sdk.pendo.io.m3.w1;

/* loaded from: classes6.dex */
public class e extends t {
    private Hashtable f = new Hashtable();
    private Vector s = new Vector();

    private e(d0 d0Var) {
        Enumeration m = d0Var.m();
        while (m.hasMoreElements()) {
            d a2 = d.a(m.nextElement());
            if (this.f.containsKey(a2.h())) {
                throw new IllegalArgumentException("repeated extension found: " + a2.h());
            }
            this.f.put(a2.h(), a2);
            this.s.addElement(a2.h());
        }
    }

    public d a(v vVar) {
        return (d) this.f.get(vVar);
    }

    @Override // sdk.pendo.io.m3.t, sdk.pendo.io.m3.g
    public a0 b() {
        sdk.pendo.io.m3.h hVar = new sdk.pendo.io.m3.h(this.s.size());
        Enumeration elements = this.s.elements();
        while (elements.hasMoreElements()) {
            hVar.a((d) this.f.get((v) elements.nextElement()));
        }
        return new w1(hVar);
    }

    public v[] h() {
        return a(this.s);
    }

    public e(d[] dVarArr) {
        for (int i = 0; i != dVarArr.length; i++) {
            d dVar = dVarArr[i];
            this.s.addElement(dVar.h());
            this.f.put(dVar.h(), dVar);
        }
    }

    public static e a(Object obj) {
        if (obj instanceof e) {
            return (e) obj;
        }
        if (obj != null) {
            return new e(d0.a(obj));
        }
        return null;
    }

    private v[] a(Vector vector) {
        int size = vector.size();
        v[] vVarArr = new v[size];
        for (int i = 0; i != size; i++) {
            vVarArr[i] = (v) vector.elementAt(i);
        }
        return vVarArr;
    }
}
