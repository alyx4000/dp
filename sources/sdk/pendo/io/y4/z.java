package sdk.pendo.io.y4;

import java.math.BigInteger;
import java.util.Vector;

/* loaded from: classes4.dex */
public class z implements y2 {
    private static final Vector b;

    /* renamed from: a, reason: collision with root package name */
    protected final Vector f1813a;

    static {
        Vector vector = new Vector();
        b = vector;
        vector.addElement(sdk.pendo.io.z4.d.f1882a);
        vector.addElement(sdk.pendo.io.z4.d.b);
        vector.addElement(sdk.pendo.io.z4.d.c);
        vector.addElement(sdk.pendo.io.z4.d.d);
        vector.addElement(sdk.pendo.io.z4.d.e);
        vector.addElement(sdk.pendo.io.z4.d.f);
        vector.addElement(sdk.pendo.io.z4.d.g);
    }

    public z() {
        this(b);
    }

    @Override // sdk.pendo.io.y4.y2
    public boolean a(sdk.pendo.io.z4.a0 a0Var) {
        for (int i = 0; i < this.f1813a.size(); i++) {
            if (a(a0Var, (sdk.pendo.io.z4.c) this.f1813a.elementAt(i))) {
                return true;
            }
        }
        return false;
    }

    public z(Vector vector) {
        this.f1813a = new Vector(vector);
    }

    protected boolean a(sdk.pendo.io.z4.a0 a0Var, sdk.pendo.io.z4.c cVar) {
        BigInteger[] a2 = a0Var.a();
        return a(a2[0], cVar.b()) && a(a2[1], cVar.a());
    }

    protected boolean a(BigInteger bigInteger, BigInteger bigInteger2) {
        return bigInteger == bigInteger2 || bigInteger.equals(bigInteger2);
    }
}
