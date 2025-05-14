package sdk.pendo.io.v4;

import androidx.core.view.InputDeviceCompat;
import java.math.BigInteger;
import java.util.Hashtable;
import sdk.pendo.io.v4.c;
import sdk.pendo.io.v4.d;

/* loaded from: classes4.dex */
public abstract class e {
    protected static final sdk.pendo.io.v4.d[] f = new sdk.pendo.io.v4.d[0];

    /* renamed from: a, reason: collision with root package name */
    protected sdk.pendo.io.v4.c f1680a;
    protected sdk.pendo.io.v4.d b;
    protected sdk.pendo.io.v4.d c;
    protected sdk.pendo.io.v4.d[] d;
    protected Hashtable e;

    class a implements g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f1681a;
        final /* synthetic */ boolean b;

        a(boolean z, boolean z2) {
            this.f1681a = z;
            this.b = z2;
        }

        @Override // sdk.pendo.io.v4.g
        public h a(h hVar) {
            i iVar = hVar instanceof i ? (i) hVar : null;
            if (iVar == null) {
                iVar = new i();
            }
            if (iVar.b()) {
                return iVar;
            }
            if (!iVar.a()) {
                if (!this.f1681a && !e.this.p()) {
                    iVar.e();
                    return iVar;
                }
                iVar.d();
            }
            if (this.b && !iVar.c()) {
                if (!e.this.q()) {
                    iVar.e();
                    return iVar;
                }
                iVar.f();
            }
            return iVar;
        }
    }

    public static abstract class b extends e {
        protected b(sdk.pendo.io.v4.c cVar, sdk.pendo.io.v4.d dVar, sdk.pendo.io.v4.d dVar2) {
            super(cVar, dVar, dVar2);
        }

        @Override // sdk.pendo.io.v4.e
        protected boolean p() {
            sdk.pendo.io.v4.d b;
            sdk.pendo.io.v4.d a2;
            sdk.pendo.io.v4.c e = e();
            sdk.pendo.io.v4.d dVar = this.b;
            sdk.pendo.io.v4.d a3 = e.a();
            sdk.pendo.io.v4.d b2 = e.b();
            int d = e.d();
            if (d != 6) {
                sdk.pendo.io.v4.d dVar2 = this.c;
                sdk.pendo.io.v4.d c = dVar2.a(dVar).c(dVar2);
                if (d != 0) {
                    if (d != 1) {
                        throw new IllegalStateException("unsupported coordinate system");
                    }
                    sdk.pendo.io.v4.d dVar3 = this.d[0];
                    if (!dVar3.f()) {
                        sdk.pendo.io.v4.d c2 = dVar3.c(dVar3.j());
                        c = c.c(dVar3);
                        a3 = a3.c(dVar3);
                        b2 = b2.c(c2);
                    }
                }
                return c.equals(dVar.a(a3).c(dVar.j()).a(b2));
            }
            sdk.pendo.io.v4.d dVar4 = this.d[0];
            boolean f = dVar4.f();
            if (dVar.g()) {
                sdk.pendo.io.v4.d j = this.c.j();
                if (!f) {
                    b2 = b2.c(dVar4.j());
                }
                return j.equals(b2);
            }
            sdk.pendo.io.v4.d dVar5 = this.c;
            sdk.pendo.io.v4.d j2 = dVar.j();
            if (f) {
                b = dVar5.j().a(dVar5).a(a3);
                a2 = j2.j().a(b2);
            } else {
                sdk.pendo.io.v4.d j3 = dVar4.j();
                sdk.pendo.io.v4.d j4 = j3.j();
                b = dVar5.a(dVar4).b(dVar5, a3, j3);
                a2 = j2.a(b2, j4);
            }
            return b.c(j2).equals(a2);
        }

        @Override // sdk.pendo.io.v4.e
        protected boolean q() {
            BigInteger c = this.f1680a.c();
            if (sdk.pendo.io.v4.b.c.equals(c)) {
                return ((d.a) o().b()).o() != 0;
            }
            if (!sdk.pendo.io.v4.b.e.equals(c)) {
                return super.q();
            }
            e o = o();
            sdk.pendo.io.v4.d b = o.b();
            sdk.pendo.io.v4.c cVar = this.f1680a;
            sdk.pendo.io.v4.d a2 = ((c.a) cVar).a(b.a(cVar.a()));
            if (a2 == null) {
                return false;
            }
            return ((d.a) b.c(a2).a(o.c())).o() == 0;
        }

        protected b(sdk.pendo.io.v4.c cVar, sdk.pendo.io.v4.d dVar, sdk.pendo.io.v4.d dVar2, sdk.pendo.io.v4.d[] dVarArr) {
            super(cVar, dVar, dVar2, dVarArr);
        }
    }

    public static abstract class c extends e {
        protected c(sdk.pendo.io.v4.c cVar, sdk.pendo.io.v4.d dVar, sdk.pendo.io.v4.d dVar2) {
            super(cVar, dVar, dVar2);
        }

        @Override // sdk.pendo.io.v4.e
        protected boolean d() {
            return c().k();
        }

        @Override // sdk.pendo.io.v4.e
        protected boolean p() {
            sdk.pendo.io.v4.d dVar = this.b;
            sdk.pendo.io.v4.d dVar2 = this.c;
            sdk.pendo.io.v4.d a2 = this.f1680a.a();
            sdk.pendo.io.v4.d b = this.f1680a.b();
            sdk.pendo.io.v4.d j = dVar2.j();
            int f = f();
            if (f != 0) {
                if (f == 1) {
                    sdk.pendo.io.v4.d dVar3 = this.d[0];
                    if (!dVar3.f()) {
                        sdk.pendo.io.v4.d j2 = dVar3.j();
                        sdk.pendo.io.v4.d c = dVar3.c(j2);
                        j = j.c(dVar3);
                        a2 = a2.c(j2);
                        b = b.c(c);
                    }
                } else {
                    if (f != 2 && f != 3 && f != 4) {
                        throw new IllegalStateException("unsupported coordinate system");
                    }
                    sdk.pendo.io.v4.d dVar4 = this.d[0];
                    if (!dVar4.f()) {
                        sdk.pendo.io.v4.d j3 = dVar4.j();
                        sdk.pendo.io.v4.d j4 = j3.j();
                        sdk.pendo.io.v4.d c2 = j3.c(j4);
                        a2 = a2.c(j4);
                        b = b.c(c2);
                    }
                }
            }
            return j.equals(dVar.j().a(a2).c(dVar).a(b));
        }

        protected c(sdk.pendo.io.v4.c cVar, sdk.pendo.io.v4.d dVar, sdk.pendo.io.v4.d dVar2, sdk.pendo.io.v4.d[] dVarArr) {
            super(cVar, dVar, dVar2, dVarArr);
        }
    }

    public static class d extends b {
        d(sdk.pendo.io.v4.c cVar, sdk.pendo.io.v4.d dVar, sdk.pendo.io.v4.d dVar2) {
            super(cVar, dVar, dVar2);
        }

        @Override // sdk.pendo.io.v4.e
        public e a(e eVar) {
            sdk.pendo.io.v4.d dVar;
            sdk.pendo.io.v4.d dVar2;
            sdk.pendo.io.v4.d dVar3;
            sdk.pendo.io.v4.d dVar4;
            sdk.pendo.io.v4.d dVar5;
            sdk.pendo.io.v4.d dVar6;
            if (k()) {
                return eVar;
            }
            if (eVar.k()) {
                return this;
            }
            sdk.pendo.io.v4.c e = e();
            int d = e.d();
            sdk.pendo.io.v4.d dVar7 = this.b;
            sdk.pendo.io.v4.d dVar8 = eVar.b;
            if (d == 0) {
                sdk.pendo.io.v4.d dVar9 = this.c;
                sdk.pendo.io.v4.d dVar10 = eVar.c;
                sdk.pendo.io.v4.d a2 = dVar7.a(dVar8);
                sdk.pendo.io.v4.d a3 = dVar9.a(dVar10);
                if (a2.g()) {
                    return a3.g() ? r() : e.g();
                }
                sdk.pendo.io.v4.d b = a3.b(a2);
                sdk.pendo.io.v4.d a4 = b.j().a(b).a(a2).a(e.a());
                return new d(e, a4, b.c(dVar7.a(a4)).a(a4).a(dVar9));
            }
            if (d == 1) {
                sdk.pendo.io.v4.d dVar11 = this.c;
                sdk.pendo.io.v4.d dVar12 = this.d[0];
                sdk.pendo.io.v4.d dVar13 = eVar.c;
                sdk.pendo.io.v4.d dVar14 = eVar.d[0];
                boolean f = dVar14.f();
                sdk.pendo.io.v4.d a5 = dVar12.c(dVar13).a(f ? dVar11 : dVar11.c(dVar14));
                sdk.pendo.io.v4.d a6 = dVar12.c(dVar8).a(f ? dVar7 : dVar7.c(dVar14));
                if (a6.g()) {
                    return a5.g() ? r() : e.g();
                }
                sdk.pendo.io.v4.d j = a6.j();
                sdk.pendo.io.v4.d c = j.c(a6);
                if (!f) {
                    dVar12 = dVar12.c(dVar14);
                }
                sdk.pendo.io.v4.d a7 = a5.a(a6);
                sdk.pendo.io.v4.d a8 = a7.b(a5, j, e.a()).c(dVar12).a(c);
                sdk.pendo.io.v4.d c2 = a6.c(a8);
                if (!f) {
                    j = j.c(dVar14);
                }
                return new d(e, c2, a5.b(dVar7, a6, dVar11).b(j, a7, a8), new sdk.pendo.io.v4.d[]{c.c(dVar12)});
            }
            if (d != 6) {
                throw new IllegalStateException("unsupported coordinate system");
            }
            if (dVar7.g()) {
                return dVar8.g() ? e.g() : eVar.a(this);
            }
            sdk.pendo.io.v4.d dVar15 = this.c;
            sdk.pendo.io.v4.d dVar16 = this.d[0];
            sdk.pendo.io.v4.d dVar17 = eVar.c;
            sdk.pendo.io.v4.d dVar18 = eVar.d[0];
            boolean f2 = dVar16.f();
            if (f2) {
                dVar = dVar8;
                dVar2 = dVar17;
            } else {
                dVar = dVar8.c(dVar16);
                dVar2 = dVar17.c(dVar16);
            }
            boolean f3 = dVar18.f();
            if (f3) {
                dVar3 = dVar15;
            } else {
                dVar7 = dVar7.c(dVar18);
                dVar3 = dVar15.c(dVar18);
            }
            sdk.pendo.io.v4.d a9 = dVar3.a(dVar2);
            sdk.pendo.io.v4.d a10 = dVar7.a(dVar);
            if (a10.g()) {
                return a9.g() ? r() : e.g();
            }
            if (dVar8.g()) {
                e o = o();
                sdk.pendo.io.v4.d i = o.i();
                sdk.pendo.io.v4.d j2 = o.j();
                sdk.pendo.io.v4.d b2 = j2.a(dVar17).b(i);
                dVar4 = b2.j().a(b2).a(i).a(e.a());
                if (dVar4.g()) {
                    return new d(e, dVar4, e.b().i());
                }
                dVar6 = b2.c(i.a(dVar4)).a(dVar4).a(j2).b(dVar4).a(dVar4);
                dVar5 = e.a(sdk.pendo.io.v4.b.b);
            } else {
                sdk.pendo.io.v4.d j3 = a10.j();
                sdk.pendo.io.v4.d c3 = a9.c(dVar7);
                sdk.pendo.io.v4.d c4 = a9.c(dVar);
                sdk.pendo.io.v4.d c5 = c3.c(c4);
                if (c5.g()) {
                    return new d(e, c5, e.b().i());
                }
                sdk.pendo.io.v4.d c6 = a9.c(j3);
                sdk.pendo.io.v4.d c7 = !f3 ? c6.c(dVar18) : c6;
                sdk.pendo.io.v4.d a11 = c4.a(j3).a(c7, dVar15.a(dVar16));
                if (!f2) {
                    c7 = c7.c(dVar16);
                }
                dVar4 = c5;
                dVar5 = c7;
                dVar6 = a11;
            }
            return new d(e, dVar4, dVar6, new sdk.pendo.io.v4.d[]{dVar5});
        }

        @Override // sdk.pendo.io.v4.e
        protected boolean d() {
            sdk.pendo.io.v4.d g = g();
            if (g.g()) {
                return false;
            }
            sdk.pendo.io.v4.d h = h();
            int f = f();
            return (f == 5 || f == 6) ? h.k() != g.k() : h.b(g).k();
        }

        @Override // sdk.pendo.io.v4.e
        public sdk.pendo.io.v4.d j() {
            int f = f();
            if (f != 5 && f != 6) {
                return this.c;
            }
            sdk.pendo.io.v4.d dVar = this.b;
            sdk.pendo.io.v4.d dVar2 = this.c;
            if (k() || dVar.g()) {
                return dVar2;
            }
            sdk.pendo.io.v4.d c = dVar2.a(dVar).c(dVar);
            if (6 != f) {
                return c;
            }
            sdk.pendo.io.v4.d dVar3 = this.d[0];
            return !dVar3.f() ? c.b(dVar3) : c;
        }

        @Override // sdk.pendo.io.v4.e
        public e n() {
            if (k()) {
                return this;
            }
            sdk.pendo.io.v4.d dVar = this.b;
            if (dVar.g()) {
                return this;
            }
            int f = f();
            if (f == 0) {
                return new d(this.f1680a, dVar, this.c.a(dVar));
            }
            if (f == 1) {
                return new d(this.f1680a, dVar, this.c.a(dVar), new sdk.pendo.io.v4.d[]{this.d[0]});
            }
            if (f == 5) {
                return new d(this.f1680a, dVar, this.c.a());
            }
            if (f != 6) {
                throw new IllegalStateException("unsupported coordinate system");
            }
            sdk.pendo.io.v4.d dVar2 = this.c;
            sdk.pendo.io.v4.d dVar3 = this.d[0];
            return new d(this.f1680a, dVar, dVar2.a(dVar3), new sdk.pendo.io.v4.d[]{dVar3});
        }

        @Override // sdk.pendo.io.v4.e
        public e r() {
            sdk.pendo.io.v4.d a2;
            if (k()) {
                return this;
            }
            sdk.pendo.io.v4.c e = e();
            sdk.pendo.io.v4.d dVar = this.b;
            if (dVar.g()) {
                return e.g();
            }
            int d = e.d();
            if (d == 0) {
                sdk.pendo.io.v4.d a3 = this.c.b(dVar).a(dVar);
                sdk.pendo.io.v4.d a4 = a3.j().a(a3).a(e.a());
                return new d(e, a4, dVar.a(a4, a3.a()));
            }
            if (d == 1) {
                sdk.pendo.io.v4.d dVar2 = this.c;
                sdk.pendo.io.v4.d dVar3 = this.d[0];
                boolean f = dVar3.f();
                sdk.pendo.io.v4.d c = f ? dVar : dVar.c(dVar3);
                if (!f) {
                    dVar2 = dVar2.c(dVar3);
                }
                sdk.pendo.io.v4.d j = dVar.j();
                sdk.pendo.io.v4.d a5 = j.a(dVar2);
                sdk.pendo.io.v4.d j2 = c.j();
                sdk.pendo.io.v4.d a6 = a5.a(c);
                sdk.pendo.io.v4.d b = a6.b(a5, j2, e.a());
                return new d(e, c.c(b), j.j().b(c, b, a6), new sdk.pendo.io.v4.d[]{c.c(j2)});
            }
            if (d != 6) {
                throw new IllegalStateException("unsupported coordinate system");
            }
            sdk.pendo.io.v4.d dVar4 = this.c;
            sdk.pendo.io.v4.d dVar5 = this.d[0];
            boolean f2 = dVar5.f();
            sdk.pendo.io.v4.d c2 = f2 ? dVar4 : dVar4.c(dVar5);
            sdk.pendo.io.v4.d j3 = f2 ? dVar5 : dVar5.j();
            sdk.pendo.io.v4.d a7 = e.a();
            sdk.pendo.io.v4.d c3 = f2 ? a7 : a7.c(j3);
            sdk.pendo.io.v4.d a8 = dVar4.j().a(c2).a(c3);
            if (a8.g()) {
                return new d(e, a8, e.b().i());
            }
            sdk.pendo.io.v4.d j4 = a8.j();
            sdk.pendo.io.v4.d c4 = f2 ? a8 : a8.c(j3);
            sdk.pendo.io.v4.d b2 = e.b();
            if (b2.b() < (e.f() >> 1)) {
                sdk.pendo.io.v4.d j5 = dVar4.a(dVar).j();
                a2 = j5.a(a8).a(j3).c(j5).a(b2.f() ? c3.a(j3).j() : c3.a(b2, j3.j())).a(j4);
                if (!a7.g()) {
                    if (!a7.f()) {
                        a2 = a2.a(a7.a().c(c4));
                    }
                    return new d(e, j4, a2, new sdk.pendo.io.v4.d[]{c4});
                }
            } else {
                if (!f2) {
                    dVar = dVar.c(dVar5);
                }
                a2 = dVar.a(a8, c2).a(j4);
            }
            a2 = a2.a(c4);
            return new d(e, j4, a2, new sdk.pendo.io.v4.d[]{c4});
        }

        d(sdk.pendo.io.v4.c cVar, sdk.pendo.io.v4.d dVar, sdk.pendo.io.v4.d dVar2, sdk.pendo.io.v4.d[] dVarArr) {
            super(cVar, dVar, dVar2, dVarArr);
        }
    }

    /* renamed from: sdk.pendo.io.v4.e$e, reason: collision with other inner class name */
    public static class C0250e extends c {
        C0250e(sdk.pendo.io.v4.c cVar, sdk.pendo.io.v4.d dVar, sdk.pendo.io.v4.d dVar2) {
            super(cVar, dVar, dVar2);
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x0128  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0136  */
        @Override // sdk.pendo.io.v4.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public sdk.pendo.io.v4.e a(sdk.pendo.io.v4.e r17) {
            /*
                Method dump skipped, instructions count: 532
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.v4.e.C0250e.a(sdk.pendo.io.v4.e):sdk.pendo.io.v4.e");
        }

        protected sdk.pendo.io.v4.d b(sdk.pendo.io.v4.d dVar, sdk.pendo.io.v4.d dVar2) {
            sdk.pendo.io.v4.d a2 = e().a();
            if (a2.g() || dVar.f()) {
                return a2;
            }
            if (dVar2 == null) {
                dVar2 = dVar.j();
            }
            sdk.pendo.io.v4.d j = dVar2.j();
            sdk.pendo.io.v4.d h = a2.h();
            return h.b() < a2.b() ? j.c(h).h() : j.c(a2);
        }

        protected sdk.pendo.io.v4.d c(sdk.pendo.io.v4.d dVar) {
            return e(e(dVar));
        }

        protected sdk.pendo.io.v4.d d(sdk.pendo.io.v4.d dVar) {
            return e(dVar).a(dVar);
        }

        protected sdk.pendo.io.v4.d e(sdk.pendo.io.v4.d dVar) {
            return dVar.a(dVar);
        }

        @Override // sdk.pendo.io.v4.e
        public e n() {
            if (k()) {
                return this;
            }
            sdk.pendo.io.v4.c e = e();
            return e.d() != 0 ? new C0250e(e, this.b, this.c.h(), this.d) : new C0250e(e, this.b, this.c.h());
        }

        @Override // sdk.pendo.io.v4.e
        public e r() {
            sdk.pendo.io.v4.d dVar;
            sdk.pendo.io.v4.d c;
            if (k()) {
                return this;
            }
            sdk.pendo.io.v4.c e = e();
            sdk.pendo.io.v4.d dVar2 = this.c;
            if (dVar2.g()) {
                return e.g();
            }
            int d = e.d();
            sdk.pendo.io.v4.d dVar3 = this.b;
            if (d == 0) {
                sdk.pendo.io.v4.d b = d(dVar3.j()).a(e().a()).b(e(dVar2));
                sdk.pendo.io.v4.d d2 = b.j().d(e(dVar3));
                return new C0250e(e, d2, b.c(dVar3.d(d2)).d(dVar2));
            }
            if (d == 1) {
                sdk.pendo.io.v4.d dVar4 = this.d[0];
                boolean f = dVar4.f();
                sdk.pendo.io.v4.d a2 = e.a();
                if (!a2.g() && !f) {
                    a2 = a2.c(dVar4.j());
                }
                sdk.pendo.io.v4.d a3 = a2.a(d(dVar3.j()));
                sdk.pendo.io.v4.d c2 = f ? dVar2 : dVar2.c(dVar4);
                sdk.pendo.io.v4.d j = f ? dVar2.j() : c2.c(dVar2);
                sdk.pendo.io.v4.d c3 = c(dVar3.c(j));
                sdk.pendo.io.v4.d d3 = a3.j().d(e(c3));
                sdk.pendo.io.v4.d e2 = e(c2);
                sdk.pendo.io.v4.d c4 = d3.c(e2);
                sdk.pendo.io.v4.d e3 = e(j);
                return new C0250e(e, c4, c3.d(d3).c(a3).d(e(e3.j())), new sdk.pendo.io.v4.d[]{e(f ? e(e3) : e2.j()).c(c2)});
            }
            if (d != 2) {
                if (d == 4) {
                    return b(true);
                }
                throw new IllegalStateException("unsupported coordinate system");
            }
            sdk.pendo.io.v4.d dVar5 = this.d[0];
            boolean f2 = dVar5.f();
            sdk.pendo.io.v4.d j2 = dVar2.j();
            sdk.pendo.io.v4.d j3 = j2.j();
            sdk.pendo.io.v4.d a4 = e.a();
            sdk.pendo.io.v4.d h = a4.h();
            if (h.l().equals(BigInteger.valueOf(3L))) {
                sdk.pendo.io.v4.d j4 = f2 ? dVar5 : dVar5.j();
                dVar = d(dVar3.a(j4).c(dVar3.d(j4)));
                c = j2.c(dVar3);
            } else {
                sdk.pendo.io.v4.d d4 = d(dVar3.j());
                if (!f2) {
                    if (a4.g()) {
                        dVar = d4;
                    } else {
                        sdk.pendo.io.v4.d j5 = dVar5.j().j();
                        if (h.b() < a4.b()) {
                            dVar = d4.d(j5.c(h));
                        } else {
                            a4 = j5.c(a4);
                        }
                    }
                    c = dVar3.c(j2);
                }
                dVar = d4.a(a4);
                c = dVar3.c(j2);
            }
            sdk.pendo.io.v4.d c5 = c(c);
            sdk.pendo.io.v4.d d5 = dVar.j().d(e(c5));
            sdk.pendo.io.v4.d d6 = c5.d(d5).c(dVar).d(b(j3));
            sdk.pendo.io.v4.d e4 = e(dVar2);
            if (!f2) {
                e4 = e4.c(dVar5);
            }
            return new C0250e(e, d5, d6, new sdk.pendo.io.v4.d[]{e4});
        }

        protected sdk.pendo.io.v4.d s() {
            sdk.pendo.io.v4.d[] dVarArr = this.d;
            sdk.pendo.io.v4.d dVar = dVarArr[1];
            if (dVar != null) {
                return dVar;
            }
            sdk.pendo.io.v4.d b = b(dVarArr[0], null);
            dVarArr[1] = b;
            return b;
        }

        C0250e(sdk.pendo.io.v4.c cVar, sdk.pendo.io.v4.d dVar, sdk.pendo.io.v4.d dVar2, sdk.pendo.io.v4.d[] dVarArr) {
            super(cVar, dVar, dVar2, dVarArr);
        }

        @Override // sdk.pendo.io.v4.e
        public sdk.pendo.io.v4.d a(int i) {
            return (i == 1 && 4 == f()) ? s() : super.a(i);
        }

        protected sdk.pendo.io.v4.d b(sdk.pendo.io.v4.d dVar) {
            return c(e(dVar));
        }

        protected C0250e b(boolean z) {
            sdk.pendo.io.v4.d dVar = this.b;
            sdk.pendo.io.v4.d dVar2 = this.c;
            sdk.pendo.io.v4.d dVar3 = this.d[0];
            sdk.pendo.io.v4.d s = s();
            sdk.pendo.io.v4.d a2 = d(dVar.j()).a(s);
            sdk.pendo.io.v4.d e = e(dVar2);
            sdk.pendo.io.v4.d c = e.c(dVar2);
            sdk.pendo.io.v4.d e2 = e(dVar.c(c));
            sdk.pendo.io.v4.d d = a2.j().d(e(e2));
            sdk.pendo.io.v4.d e3 = e(c.j());
            sdk.pendo.io.v4.d d2 = a2.c(e2.d(d)).d(e3);
            sdk.pendo.io.v4.d e4 = z ? e(e3.c(s)) : null;
            if (!dVar3.f()) {
                e = e.c(dVar3);
            }
            return new C0250e(e(), d, d2, new sdk.pendo.io.v4.d[]{e, e4});
        }
    }

    protected e(sdk.pendo.io.v4.c cVar, sdk.pendo.io.v4.d dVar, sdk.pendo.io.v4.d dVar2) {
        this(cVar, dVar, dVar2, a(cVar));
    }

    public abstract e a(e eVar);

    protected void a() {
        if (!l()) {
            throw new IllegalStateException("point not in normal form");
        }
    }

    public boolean b(e eVar) {
        e eVar2;
        if (eVar == null) {
            return false;
        }
        sdk.pendo.io.v4.c e = e();
        sdk.pendo.io.v4.c e2 = eVar.e();
        boolean z = e == null;
        boolean z2 = e2 == null;
        boolean k = k();
        boolean k2 = eVar.k();
        if (k || k2) {
            if (k && k2) {
                return z || z2 || e.a(e2);
            }
            return false;
        }
        if (!z || !z2) {
            if (!z) {
                if (z2) {
                    eVar2 = o();
                } else {
                    if (!e.a(e2)) {
                        return false;
                    }
                    e[] eVarArr = {this, e.b(eVar)};
                    e.a(eVarArr);
                    eVar2 = eVarArr[0];
                    eVar = eVarArr[1];
                }
                return eVar2.i().equals(eVar.i()) && eVar2.j().equals(eVar.j());
            }
            eVar = eVar.o();
        }
        eVar2 = this;
        if (eVar2.i().equals(eVar.i())) {
            return false;
        }
    }

    public sdk.pendo.io.v4.d c() {
        a();
        return j();
    }

    protected abstract boolean d();

    public sdk.pendo.io.v4.c e() {
        return this.f1680a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            return b((e) obj);
        }
        return false;
    }

    protected int f() {
        sdk.pendo.io.v4.c cVar = this.f1680a;
        if (cVar == null) {
            return 0;
        }
        return cVar.d();
    }

    public final sdk.pendo.io.v4.d g() {
        return this.b;
    }

    public final sdk.pendo.io.v4.d h() {
        return this.c;
    }

    public int hashCode() {
        sdk.pendo.io.v4.c e = e();
        int i = e == null ? 0 : ~e.hashCode();
        if (k()) {
            return i;
        }
        e o = o();
        return (i ^ (o.i().hashCode() * 17)) ^ (o.j().hashCode() * InputDeviceCompat.SOURCE_KEYBOARD);
    }

    public sdk.pendo.io.v4.d i() {
        return this.b;
    }

    public sdk.pendo.io.v4.d j() {
        return this.c;
    }

    public boolean k() {
        if (this.b != null && this.c != null) {
            sdk.pendo.io.v4.d[] dVarArr = this.d;
            if (dVarArr.length <= 0 || !dVarArr[0].g()) {
                return false;
            }
        }
        return true;
    }

    public boolean l() {
        int f2 = f();
        return f2 == 0 || f2 == 5 || k() || this.d[0].f();
    }

    public boolean m() {
        return a(false, true);
    }

    public abstract e n();

    public e o() {
        int f2;
        if (k() || (f2 = f()) == 0 || f2 == 5) {
            return this;
        }
        sdk.pendo.io.v4.d a2 = a(0);
        if (a2.f()) {
            return this;
        }
        if (this.f1680a == null) {
            throw new IllegalStateException("Detached points must be in affine coordinates");
        }
        sdk.pendo.io.v4.d a3 = this.f1680a.a(sdk.pendo.io.g4.b.a());
        return a(a2.c(a3).e().c(a3));
    }

    protected abstract boolean p();

    protected boolean q() {
        BigInteger h;
        return sdk.pendo.io.v4.b.b.equals(this.f1680a.c()) || (h = this.f1680a.h()) == null || sdk.pendo.io.v4.a.a(this, h).k();
    }

    public abstract e r();

    public String toString() {
        if (k()) {
            return "INF";
        }
        StringBuffer stringBuffer = new StringBuffer("(");
        stringBuffer.append(g());
        stringBuffer.append(',');
        stringBuffer.append(h());
        for (int i = 0; i < this.d.length; i++) {
            stringBuffer.append(',');
            stringBuffer.append(this.d[i]);
        }
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    protected e(sdk.pendo.io.v4.c cVar, sdk.pendo.io.v4.d dVar, sdk.pendo.io.v4.d dVar2, sdk.pendo.io.v4.d[] dVarArr) {
        this.e = null;
        this.f1680a = cVar;
        this.b = dVar;
        this.c = dVar2;
        this.d = dVarArr;
    }

    protected e a(sdk.pendo.io.v4.d dVar, sdk.pendo.io.v4.d dVar2) {
        return e().a(g().c(dVar), h().c(dVar2));
    }

    public sdk.pendo.io.v4.d b() {
        a();
        return i();
    }

    public byte[] a(boolean z) {
        if (k()) {
            return new byte[1];
        }
        e o = o();
        byte[] c2 = o.i().c();
        if (z) {
            byte[] bArr = new byte[c2.length + 1];
            bArr[0] = (byte) (o.d() ? 3 : 2);
            System.arraycopy(c2, 0, bArr, 1, c2.length);
            return bArr;
        }
        byte[] c3 = o.j().c();
        byte[] bArr2 = new byte[c2.length + c3.length + 1];
        bArr2[0] = 4;
        System.arraycopy(c2, 0, bArr2, 1, c2.length);
        System.arraycopy(c3, 0, bArr2, c2.length + 1, c3.length);
        return bArr2;
    }

    protected static sdk.pendo.io.v4.d[] a(sdk.pendo.io.v4.c cVar) {
        int d2 = cVar == null ? 0 : cVar.d();
        if (d2 == 0 || d2 == 5) {
            return f;
        }
        sdk.pendo.io.v4.d a2 = cVar.a(sdk.pendo.io.v4.b.b);
        if (d2 != 1 && d2 != 2) {
            if (d2 == 3) {
                return new sdk.pendo.io.v4.d[]{a2, a2, a2};
            }
            if (d2 == 4) {
                return new sdk.pendo.io.v4.d[]{a2, cVar.a()};
            }
            if (d2 != 6) {
                throw new IllegalArgumentException("unknown coordinate system");
            }
        }
        return new sdk.pendo.io.v4.d[]{a2};
    }

    public sdk.pendo.io.v4.d a(int i) {
        if (i >= 0) {
            sdk.pendo.io.v4.d[] dVarArr = this.d;
            if (i < dVarArr.length) {
                return dVarArr[i];
            }
        }
        return null;
    }

    boolean a(boolean z, boolean z2) {
        if (k()) {
            return true;
        }
        return !((i) e().a(this, "bc_validity", new a(z, z2))).b();
    }

    e a(sdk.pendo.io.v4.d dVar) {
        int f2 = f();
        if (f2 != 1) {
            if (f2 == 2 || f2 == 3 || f2 == 4) {
                sdk.pendo.io.v4.d j = dVar.j();
                return a(j, j.c(dVar));
            }
            if (f2 != 6) {
                throw new IllegalStateException("not a projective coordinate system");
            }
        }
        return a(dVar, dVar);
    }
}
