package sdk.pendo.io.a;

/* loaded from: classes6.dex */
final class r {

    /* renamed from: a, reason: collision with root package name */
    final s f829a;
    final s b;
    final s c;
    final int d;
    final String e;
    r f;

    r(r rVar, s sVar, s sVar2) {
        this(sVar, sVar2, rVar.c, rVar.d, rVar.e);
        this.f = rVar.f;
    }

    static int a(r rVar) {
        int i = 0;
        while (rVar != null) {
            i++;
            rVar = rVar.f;
        }
        return i;
    }

    static int b(r rVar) {
        return (a(rVar) * 8) + 2;
    }

    r(s sVar, s sVar2, s sVar3, int i, String str) {
        this.f829a = sVar;
        this.b = sVar2;
        this.c = sVar3;
        this.d = i;
        this.e = str;
    }

    static void a(r rVar, d dVar) {
        dVar.d(a(rVar));
        while (rVar != null) {
            dVar.d(rVar.f829a.d).d(rVar.b.d).d(rVar.c.d).d(rVar.d);
            rVar = rVar.f;
        }
    }

    static r a(r rVar, s sVar, s sVar2) {
        if (rVar == null) {
            return null;
        }
        r a2 = a(rVar.f, sVar, sVar2);
        rVar.f = a2;
        s sVar3 = rVar.f829a;
        int i = sVar3.d;
        s sVar4 = rVar.b;
        int i2 = sVar4.d;
        int i3 = sVar.d;
        int i4 = sVar2 == null ? Integer.MAX_VALUE : sVar2.d;
        if (i3 >= i2 || i4 <= i) {
            return rVar;
        }
        if (i3 <= i) {
            return i4 >= i2 ? a2 : new r(rVar, sVar2, sVar4);
        }
        if (i4 >= i2) {
            return new r(rVar, sVar3, sVar);
        }
        rVar.f = new r(rVar, sVar2, sVar4);
        return new r(rVar, rVar.f829a, sVar);
    }
}
