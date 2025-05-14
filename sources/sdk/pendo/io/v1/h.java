package sdk.pendo.io.v1;

import java.util.List;

/* loaded from: classes4.dex */
public class h extends j {
    private final String f;
    private final String g;
    private List<sdk.pendo.io.q1.b> h;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1658a;

        static {
            int[] iArr = new int[sdk.pendo.io.q1.a.values().length];
            f1658a = iArr;
            try {
                iArr[sdk.pendo.io.q1.a.PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1658a[sdk.pendo.io.q1.a.JSON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public h(String str, List<sdk.pendo.io.q1.b> list) {
        this.g = str + ((list == null || list.size() <= 0) ? "()" : "(...)");
        if (str != null) {
            this.f = str;
            this.h = list;
        } else {
            this.f = null;
            this.h = null;
        }
    }

    private void b(String str, sdk.pendo.io.o1.h hVar, Object obj, g gVar) {
        sdk.pendo.io.s1.a cVar;
        List<sdk.pendo.io.q1.b> list = this.h;
        if (list != null) {
            for (sdk.pendo.io.q1.b bVar : list) {
                if (!bVar.e()) {
                    int i = a.f1658a[bVar.c().ordinal()];
                    if (i == 1) {
                        cVar = new sdk.pendo.io.s1.c(bVar.b(), gVar.g(), gVar.a());
                    } else if (i == 2) {
                        cVar = new sdk.pendo.io.s1.b(gVar.a().f(), bVar);
                    }
                    bVar.a(cVar);
                    bVar.a(Boolean.TRUE);
                }
            }
        }
    }

    @Override // sdk.pendo.io.v1.j
    public void a(String str, sdk.pendo.io.o1.h hVar, Object obj, g gVar) {
        sdk.pendo.io.q1.c a2 = sdk.pendo.io.q1.d.a(this.f);
        b(str, hVar, obj, gVar);
        Object a3 = a2.a(str, hVar, obj, gVar, this.h);
        gVar.a(str + "." + this.f, hVar, a3);
        if (b()) {
            return;
        }
        g().a(str, hVar, a3, gVar);
    }

    @Override // sdk.pendo.io.v1.j
    public boolean e() {
        return true;
    }

    @Override // sdk.pendo.io.v1.j
    public String a() {
        return "." + this.g;
    }

    public void a(List<sdk.pendo.io.q1.b> list) {
        this.h = list;
    }
}
