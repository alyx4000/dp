package sdk.pendo.io.p1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.n1.l;
import sdk.pendo.io.v1.m;

/* loaded from: classes6.dex */
public class e extends c {

    /* renamed from: a, reason: collision with root package name */
    protected List<c> f1487a;
    private final f b;

    private e(c cVar, f fVar, c cVar2) {
        ArrayList arrayList = new ArrayList();
        this.f1487a = arrayList;
        arrayList.add(cVar);
        this.f1487a.add(cVar2);
        this.b = fVar;
    }

    public static e b(Collection<c> collection) {
        return new e(f.OR, collection);
    }

    @Override // sdk.pendo.io.n1.l
    public boolean a(l.a aVar) {
        f fVar = this.b;
        if (fVar == f.OR) {
            for (c cVar : this.f1487a) {
                if (cVar.a(aVar)) {
                    return true;
                }
                if (PendoInternal.I()) {
                    PendoLogger.d(String.format("FAILED logicalOperatorOR due to:\n expression = %s,\n testedPath = %s", cVar, ((m) aVar).d()), new Object[0]);
                }
            }
            PendoLogger.d("All logicalOR expressions failed - overall predicate didn't match", new Object[0]);
            return false;
        }
        if (fVar != f.AND) {
            return !this.f1487a.get(0).a(aVar);
        }
        for (c cVar2 : this.f1487a) {
            if (!cVar2.a(aVar)) {
                if (PendoInternal.I()) {
                    PendoLogger.d(String.format("FAILED logicalOperatorAND due to:\n expression = %s,\n testedPath = %s", cVar2, ((m) aVar).d()), new Object[0]);
                }
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return "(" + sdk.pendo.io.o1.i.a(" " + this.b.b() + " ", this.f1487a) + ")";
    }

    private e(f fVar, Collection<c> collection) {
        ArrayList arrayList = new ArrayList();
        this.f1487a = arrayList;
        arrayList.addAll(collection);
        this.b = fVar;
    }

    public static e a(Collection<c> collection) {
        return new e(f.AND, collection);
    }

    public static c a(c cVar) {
        return new e(cVar, f.NOT, null);
    }
}
