package external.sdk.pendo.io.jose4j.jwt.consumer;

import external.sdk.pendo.io.jose4j.jwt.consumer.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import sdk.pendo.io.b1.o;

/* loaded from: classes2.dex */
public class JwtConsumer {

    /* renamed from: a, reason: collision with root package name */
    private sdk.pendo.io.j1.b f750a;
    private sdk.pendo.io.j1.a b;
    private List<b> c;
    private sdk.pendo.io.a1.c d;
    private sdk.pendo.io.a1.c e;
    private sdk.pendo.io.a1.c f;
    private boolean g = true;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private sdk.pendo.io.w0.a o;
    private sdk.pendo.io.w0.a p;

    JwtConsumer() {
    }

    private boolean a(sdk.pendo.io.h1.c cVar) {
        String d = cVar.d();
        return d != null && (d.equalsIgnoreCase("jwt") || d.equalsIgnoreCase("application/jwt"));
    }

    void a(sdk.pendo.io.g1.a aVar) {
    }

    void a(sdk.pendo.io.g1.b bVar) {
    }

    public sdk.pendo.io.f1.b b(String str) {
        return a(str).c();
    }

    void c(sdk.pendo.io.a1.c cVar) {
        this.d = cVar;
    }

    void d(boolean z) {
        this.h = z;
    }

    void e(boolean z) {
        this.i = z;
    }

    void f(boolean z) {
        this.g = z;
    }

    void g(boolean z) {
        this.k = z;
    }

    public void h(boolean z) {
        this.m = z;
    }

    public g a(String str) {
        String s;
        LinkedList linkedList = new LinkedList();
        sdk.pendo.io.f1.b bVar = null;
        g gVar = new g(str, null, Collections.unmodifiableList(linkedList));
        String str2 = str;
        while (bVar == null) {
            try {
                try {
                    try {
                        sdk.pendo.io.h1.c a2 = sdk.pendo.io.h1.c.a(str2);
                        if (a2 instanceof sdk.pendo.io.e1.e) {
                            s = ((sdk.pendo.io.e1.e) a2).q();
                        } else {
                            o oVar = (o) a2;
                            sdk.pendo.io.w0.a aVar = this.p;
                            if (aVar != null) {
                                oVar.a(aVar);
                            }
                            if (this.n) {
                                oVar.a(false);
                            }
                            sdk.pendo.io.a1.c cVar = this.f;
                            if (cVar != null) {
                                oVar.b(cVar);
                            }
                            oVar.a(this.b.a(oVar, Collections.unmodifiableList(linkedList)));
                            sdk.pendo.io.a1.c cVar2 = this.e;
                            if (cVar2 != null) {
                                oVar.a(cVar2);
                            }
                            s = oVar.s();
                        }
                        if (!a(a2)) {
                            try {
                                bVar = sdk.pendo.io.f1.b.a(s, gVar);
                                gVar.a(bVar);
                            } catch (c e) {
                                if (this.j) {
                                    try {
                                        sdk.pendo.io.h1.c.a(str);
                                    } catch (sdk.pendo.io.k1.g unused) {
                                        throw e;
                                    }
                                }
                                throw e;
                            }
                            linkedList.addFirst(a2);
                        }
                        str2 = s;
                        linkedList.addFirst(a2);
                    } catch (sdk.pendo.io.k1.g e2) {
                        StringBuilder sb = new StringBuilder("Unable to process");
                        if (!linkedList.isEmpty()) {
                            sb.append(" nested");
                        }
                        sb.append(" JOSE object (cause: ").append(e2).append("): ").append(str2);
                        throw new c("JWT processing failed.", new b.a(17, sb.toString()), e2, gVar);
                    }
                } catch (Exception e3) {
                    StringBuilder sb2 = new StringBuilder("Unexpected exception encountered while processing");
                    if (!linkedList.isEmpty()) {
                        sb2.append(" nested");
                    }
                    sb2.append(" JOSE object (").append(e3).append("): ").append(str2);
                    throw new c("JWT processing failed.", new b.a(17, sb2.toString()), e3, gVar);
                }
            } catch (c e4) {
                throw e4;
            }
        }
        a(gVar);
        return gVar;
    }

    void b(sdk.pendo.io.a1.c cVar) {
        this.f = cVar;
    }

    void c(boolean z) {
        this.l = z;
    }

    public void a(g gVar) {
        ArrayList arrayList = new ArrayList(gVar.a());
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            List subList = arrayList.subList(size + 1, arrayList.size());
            List<sdk.pendo.io.h1.c> unmodifiableList = Collections.unmodifiableList(subList);
            sdk.pendo.io.h1.c cVar = (sdk.pendo.io.h1.c) arrayList.get(size);
            try {
                if (cVar instanceof sdk.pendo.io.e1.e) {
                    sdk.pendo.io.e1.e eVar = (sdk.pendo.io.e1.e) cVar;
                    boolean equals = "none".equals(eVar.c());
                    if (!this.k) {
                        sdk.pendo.io.w0.a aVar = this.o;
                        if (aVar != null) {
                            eVar.a(aVar);
                        }
                        if (this.l) {
                            eVar.a(false);
                        }
                        sdk.pendo.io.a1.c cVar2 = this.d;
                        if (cVar2 != null) {
                            eVar.a(cVar2);
                        }
                        if (!equals || !this.m) {
                            eVar.a(this.f750a.a(eVar, unmodifiableList));
                        }
                        if (!eVar.s()) {
                            throw new d(eVar, gVar);
                        }
                    }
                    if (!equals) {
                        z = true;
                    }
                } else {
                    o oVar = (o) cVar;
                    sdk.pendo.io.a1.c cVar3 = this.e;
                    if (cVar3 != null) {
                        cVar3.a(oVar.c());
                    }
                    sdk.pendo.io.a1.c cVar4 = this.f;
                    if (cVar4 != null) {
                        cVar4.a(oVar.q());
                    }
                    z2 = true;
                    z3 = oVar.r().a() == sdk.pendo.io.i1.h.SYMMETRIC;
                }
            } catch (c e) {
                throw e;
            } catch (sdk.pendo.io.k1.g e2) {
                StringBuilder sb = new StringBuilder("Unable to process");
                if (!subList.isEmpty()) {
                    sb.append(" nested");
                }
                sb.append(" JOSE object (cause: ").append(e2).append("): ").append(cVar);
                throw new c("JWT processing failed.", new b.a(17, sb.toString()), e2, gVar);
            } catch (Exception e3) {
                StringBuilder sb2 = new StringBuilder("Unexpected exception encountered while processing");
                if (!subList.isEmpty()) {
                    sb2.append(" nested");
                }
                sb2.append(" JOSE object (").append(e3).append("): ").append(cVar);
                throw new c("JWT processing failed.", new b.a(17, sb2.toString()), e3, gVar);
            }
        }
        if (this.g && !z) {
            throw new c("The JWT has no signature but the JWT Consumer is configured to require one: " + gVar.b(), Collections.singletonList(new b.a(10, "Missing signature.")), gVar);
        }
        if (this.h && !z2) {
            throw new c("The JWT has no encryption but the JWT Consumer is configured to require it: " + gVar.b(), Collections.singletonList(new b.a(19, "No encryption.")), gVar);
        }
        if (this.i && !z && !z3) {
            throw new c("The JWT has no integrity protection (signature/MAC or symmetric AEAD encryption) but the JWT Consumer is configured to require it: " + gVar.b(), Collections.singletonList(new b.a(20, "Missing Integrity Protection")), gVar);
        }
        b(gVar);
    }

    void b(sdk.pendo.io.w0.a aVar) {
        this.o = aVar;
    }

    void a(sdk.pendo.io.j1.a aVar) {
        this.b = aVar;
    }

    void b(boolean z) {
        this.n = z;
    }

    void a(sdk.pendo.io.a1.c cVar) {
        this.e = cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x000b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x005d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void b(external.sdk.pendo.io.jose4j.jwt.consumer.g r7) {
        /*
            r6 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List<external.sdk.pendo.io.jose4j.jwt.consumer.b> r1 = r6.c
            java.util.Iterator r1 = r1.iterator()
        Lb:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L61
            java.lang.Object r2 = r1.next()
            external.sdk.pendo.io.jose4j.jwt.consumer.b r2 = (external.sdk.pendo.io.jose4j.jwt.consumer.b) r2
            external.sdk.pendo.io.jose4j.jwt.consumer.b$a r2 = r2.a(r7)     // Catch: java.lang.Exception -> L1c sdk.pendo.io.f1.c -> L4e
            goto L5b
        L1c:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Unexpected exception thrown from validator "
            r4.<init>(r5)
            java.lang.Class r2 = r2.getClass()
            java.lang.String r2 = r2.getName()
            java.lang.StringBuilder r2 = r4.append(r2)
            java.lang.String r4 = ": "
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.Class r4 = r6.getClass()
            java.lang.String r3 = sdk.pendo.io.k1.b.a(r3, r4)
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            external.sdk.pendo.io.jose4j.jwt.consumer.b$a r3 = new external.sdk.pendo.io.jose4j.jwt.consumer.b$a
            r4 = 17
            r3.<init>(r4, r2)
            goto L5a
        L4e:
            r2 = move-exception
            external.sdk.pendo.io.jose4j.jwt.consumer.b$a r3 = new external.sdk.pendo.io.jose4j.jwt.consumer.b$a
            java.lang.String r2 = r2.getMessage()
            r4 = 18
            r3.<init>(r4, r2)
        L5a:
            r2 = r3
        L5b:
            if (r2 == 0) goto Lb
            r0.add(r2)
            goto Lb
        L61:
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L68
            return
        L68:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "JWT (claims->"
            r1.<init>(r2)
            sdk.pendo.io.f1.b r2 = r7.c()
            java.lang.String r2 = r2.g()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = ") rejected due to invalid claims or other invalid content."
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            external.sdk.pendo.io.jose4j.jwt.consumer.c r2 = new external.sdk.pendo.io.jose4j.jwt.consumer.c
            r2.<init>(r1, r0, r7)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.jose4j.jwt.consumer.JwtConsumer.b(external.sdk.pendo.io.jose4j.jwt.consumer.g):void");
    }

    void a(sdk.pendo.io.w0.a aVar) {
        this.p = aVar;
    }

    void a(boolean z) {
        this.j = z;
    }

    void a(List<b> list) {
        this.c = list;
    }

    void a(sdk.pendo.io.j1.b bVar) {
        this.f750a = bVar;
    }
}
