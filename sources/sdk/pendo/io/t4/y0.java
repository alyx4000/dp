package sdk.pendo.io.t4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* loaded from: classes6.dex */
class y0 extends w0 {
    protected final sdk.pendo.io.y4.a1 j;
    protected final y k;

    y0(x0 x0Var, String str, int i, sdk.pendo.io.y4.a1 a1Var, y yVar) {
        super(x0Var, str, i);
        this.j = a1Var;
        this.k = yVar;
    }

    @Override // sdk.pendo.io.r4.b
    public String[] a() {
        return w1.a((Collection<w1>) this.k.c);
    }

    @Override // sdk.pendo.io.r4.b
    public String[] b() {
        return w1.b(this.k.c);
    }

    @Override // sdk.pendo.io.r4.b
    public String[] c() {
        return w1.a((Collection<w1>) this.k.e);
    }

    @Override // sdk.pendo.io.r4.b
    public String[] d() {
        return w1.b(this.k.e);
    }

    @Override // sdk.pendo.io.r4.b
    public List<sdk.pendo.io.r4.e> e() {
        return a0.a((Vector<sdk.pendo.io.y4.c1>) this.j.g());
    }

    @Override // sdk.pendo.io.r4.b
    public List<byte[]> f() {
        List<byte[]> list = this.k.f;
        if (list == null || list.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<byte[]> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().clone());
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // sdk.pendo.io.t4.w0
    protected int h() {
        return this.j.e();
    }

    @Override // sdk.pendo.io.t4.w0
    protected byte[] j() {
        return this.j.F();
    }

    @Override // sdk.pendo.io.t4.w0
    protected sdk.pendo.io.y4.l k() {
        return this.j.o();
    }

    @Override // sdk.pendo.io.t4.w0
    protected sdk.pendo.io.y4.l l() {
        return this.j.x();
    }

    @Override // sdk.pendo.io.t4.w0
    protected sdk.pendo.io.y4.v0 m() {
        return this.j.s();
    }

    @Override // sdk.pendo.io.t4.w0
    protected void n() {
    }

    String p() {
        return a0.a(this.j);
    }

    protected y q() {
        return this.k;
    }
}
