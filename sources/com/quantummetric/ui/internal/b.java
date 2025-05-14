package com.quantummetric.ui.internal;

import com.quantummetric.ui.internal.ac;
import com.quantummetric.ui.internal.cj;
import io.sentry.protocol.ViewHierarchyNode;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
abstract class b implements ch {

    /* renamed from: a, reason: collision with root package name */
    protected boolean f98a;
    protected int b;
    protected List<b> c;
    protected String d;
    c e;
    int f;
    String g;
    int h;
    int i;
    int j;
    int k;
    int l;
    int m;
    float n;
    float o;
    boolean r;
    boolean s;
    float t;
    boolean w;
    boolean x;
    boolean y;
    boolean z;
    float p = 1.0f;
    float q = 1.0f;
    ac u = new ac();
    ar v = new ar();

    b() {
    }

    @Override // com.quantummetric.ui.internal.ch
    public final int a() {
        return this.j;
    }

    @Override // com.quantummetric.ui.internal.ch
    public final void a(float f) {
        this.t = f;
    }

    abstract void a(ar arVar);

    final void a(b bVar) {
        if (this.c == null) {
            this.c = new ArrayList();
        }
        this.c.add(bVar);
    }

    protected void a(String str) {
        this.d = str;
        this.e.m = str;
    }

    @Override // com.quantummetric.ui.internal.ch
    public final int b() {
        return this.k;
    }

    protected void b(ar arVar) {
    }

    @Override // com.quantummetric.ui.internal.ch
    public final int c() {
        return this.h;
    }

    protected void c(ar arVar) {
    }

    @Override // com.quantummetric.ui.internal.ch
    public final int d() {
        return this.i;
    }

    final void d(ar arVar) {
        c cVar;
        if (!de.b(this.d) || (this instanceof t)) {
            if (this.z && (cVar = this.e) != null) {
                cVar.l = (short) 1;
            }
            arVar.a((ar) "<img src=\"").a((ar) this.d).a((ar) "\", style=\"").a((ar) o()).a((ar) "\" class=\"bi\">");
        }
    }

    @Override // com.quantummetric.ui.internal.ch
    public final int e() {
        return this.l;
    }

    final void e(ar arVar) {
        if (this.r) {
            arVar.a((ar) ("<div style=\"" + n() + "\" id=\"" + a.c(this.f) + "\">"));
        }
    }

    @Override // com.quantummetric.ui.internal.ch
    public final float f() {
        return this.n;
    }

    @Override // com.quantummetric.ui.internal.ch
    public final float g() {
        return this.t;
    }

    @Override // com.quantummetric.ui.internal.ch
    public final ar h() {
        return this.v;
    }

    @Override // com.quantummetric.ui.internal.ch
    public final boolean i() {
        return this.s;
    }

    abstract void j();

    abstract void k();

    public void l() {
    }

    public void m() {
    }

    String n() {
        return "";
    }

    final String o() {
        String str = this.x ? "scale-down" : this.y ? "cover" : "";
        ar arVar = new ar();
        arVar.f65a.append(aa.ae).append(":").append((Object) "100%").append(";");
        arVar.f65a.append(aa.af).append(":").append((Object) "100%").append(";");
        String str2 = aa.ab;
        if (de.b(this.d)) {
            arVar.f65a.append(ViewHierarchyNode.JsonKeys.VISIBILITY).append(":").append((Object) str2).append(";");
        }
        if (!de.b(str)) {
            arVar.f65a.append("object-fit").append(":").append((Object) str).append(";");
        }
        return arVar.toString();
    }

    final boolean p() {
        return this.f98a;
    }

    final List<b> q() {
        return this.c;
    }

    final void r() {
        ac.a aVar;
        ArrayList arrayList;
        ac.a aVar2;
        ArrayList arrayList2;
        ac acVar = this.u;
        if (acVar == null || this.e == null) {
            return;
        }
        int i = this.l;
        if (i == -1) {
            aVar = ac.a.WHITE_BACKGROUND;
            if (acVar.f23a == null) {
                arrayList = new ArrayList(3);
                acVar.f23a = arrayList;
            }
            acVar.f23a.add(aVar);
        } else if (i == -16777216) {
            aVar = ac.a.BLACK_BACKGROUND;
            if (acVar.f23a == null) {
                arrayList = new ArrayList(3);
                acVar.f23a = arrayList;
            }
            acVar.f23a.add(aVar);
        }
        acVar.b = (acVar.f23a != null && acVar.f23a.size() > 0) || this.s;
        if (this instanceof ck) {
            ck ckVar = (ck) this;
            if (-1 == ckVar.D) {
                aVar2 = ac.a.WHITE_TEXT_COLOR;
                if (acVar.f23a == null) {
                    arrayList2 = new ArrayList(3);
                    acVar.f23a = arrayList2;
                }
                acVar.f23a.add(aVar2);
            } else if (-16777216 == ckVar.D) {
                aVar2 = ac.a.BLACK_TEXT_COLOR;
                if (acVar.f23a == null) {
                    arrayList2 = new ArrayList(3);
                    acVar.f23a = arrayList2;
                }
                acVar.f23a.add(aVar2);
            }
            if (ckVar.E == 1) {
                ac.a aVar3 = ac.a.SINGLE_LINE;
                if (acVar.f23a == null) {
                    acVar.f23a = new ArrayList(3);
                }
                acVar.f23a.add(aVar3);
            }
        }
        this.e.n = this.u;
    }

    /* JADX WARN: Multi-variable type inference failed */
    final void s() {
        if (this.e.n == null) {
            r();
            return;
        }
        ac acVar = this.e.n;
        this.u = acVar;
        if (acVar.f23a == null || acVar.f23a.size() <= 0) {
            return;
        }
        if (acVar.f23a.contains(ac.a.WHITE_BACKGROUND) && this.l != -1) {
            acVar.f23a.remove(ac.a.WHITE_BACKGROUND);
        }
        if (acVar.f23a.contains(ac.a.BLACK_BACKGROUND) && this.l != -16777216) {
            acVar.f23a.remove(ac.a.BLACK_BACKGROUND);
        }
        if (this instanceof cj.a) {
            int t = ((cj.a) this).t();
            if (acVar.f23a.contains(ac.a.WHITE_TEXT_COLOR) && t != -1) {
                acVar.f23a.remove(ac.a.WHITE_TEXT_COLOR);
            }
            if (!acVar.f23a.contains(ac.a.BLACK_TEXT_COLOR) || t == -16777216) {
                return;
            }
            acVar.f23a.remove(ac.a.BLACK_TEXT_COLOR);
        }
    }

    public String toString() {
        List<b> list = this.c;
        return getClass().getSimpleName() + " " + this.g + " " + this.f + " sidx:" + this.b + " subs: " + (list != null ? list.toString() : "") + " f: " + this.h + " " + this.i + " " + this.j + " " + this.k;
    }
}
