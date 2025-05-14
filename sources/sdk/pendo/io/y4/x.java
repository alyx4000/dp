package sdk.pendo.io.y4;

import java.math.BigInteger;
import java.util.Vector;

/* loaded from: classes4.dex */
public class x implements x1 {
    private static final Vector c = new Vector();

    /* renamed from: a, reason: collision with root package name */
    protected Vector f1808a;
    protected int b;

    static {
        b(sdk.pendo.io.z4.b.f);
        b(sdk.pendo.io.z4.b.h);
        b(sdk.pendo.io.z4.b.j);
        b(sdk.pendo.io.z4.b.l);
        b(sdk.pendo.io.z4.b.n);
        b(sdk.pendo.io.z4.b.t);
        b(sdk.pendo.io.z4.b.v);
        b(sdk.pendo.io.z4.b.x);
        b(sdk.pendo.io.z4.b.z);
        b(sdk.pendo.io.z4.b.B);
    }

    public x(int i) {
        this(c, i);
    }

    private static void b(sdk.pendo.io.z4.a aVar) {
        c.addElement(aVar);
    }

    @Override // sdk.pendo.io.y4.x1
    public boolean a(sdk.pendo.io.z4.a aVar) {
        return d(aVar) && c(aVar);
    }

    protected boolean c(sdk.pendo.io.z4.a aVar) {
        for (int i = 0; i < this.f1808a.size(); i++) {
            if (a(aVar, (sdk.pendo.io.z4.a) this.f1808a.elementAt(i))) {
                return true;
            }
        }
        return false;
    }

    protected boolean d(sdk.pendo.io.z4.a aVar) {
        return aVar.c().bitLength() >= a();
    }

    public x(Vector vector, int i) {
        this.f1808a = new Vector(vector);
        this.b = i;
    }

    protected boolean a(sdk.pendo.io.z4.a aVar, sdk.pendo.io.z4.a aVar2) {
        return aVar == aVar2 || (a(aVar.c(), aVar2.c()) && a(aVar.a(), aVar2.a()));
    }

    protected boolean a(BigInteger bigInteger, BigInteger bigInteger2) {
        return bigInteger == bigInteger2 || bigInteger.equals(bigInteger2);
    }

    public int a() {
        return this.b;
    }
}
