package sdk.pendo.io.q1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import sdk.pendo.io.o1.g;

/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private a f1509a;
    private g b;
    private sdk.pendo.io.s1.a c;
    private Boolean d;
    private String e;

    public b() {
        this.d = Boolean.FALSE;
    }

    public static void a(Class cls, sdk.pendo.io.o1.d dVar, Collection collection, Object obj) {
        if (!dVar.a().f().e(obj)) {
            if (obj == null || !cls.isAssignableFrom(obj.getClass())) {
                return;
            }
            collection.add(obj);
            return;
        }
        for (Object obj2 : dVar.a().f().f(obj)) {
            if (obj2 == null || !cls.isAssignableFrom(obj2.getClass())) {
                if (obj2 != null && cls == String.class) {
                    obj2 = obj2.toString();
                }
            }
            collection.add(obj2);
        }
    }

    public g b() {
        return this.b;
    }

    public a c() {
        return this.f1509a;
    }

    public Object d() {
        return this.c.get();
    }

    public boolean e() {
        return this.d.booleanValue();
    }

    public b(String str) {
        this.d = Boolean.FALSE;
        this.e = str;
        this.f1509a = a.JSON;
    }

    public String a() {
        return this.e;
    }

    public b(g gVar) {
        this.d = Boolean.FALSE;
        this.b = gVar;
        this.f1509a = a.PATH;
    }

    public void a(Boolean bool) {
        this.d = bool;
    }

    public void a(sdk.pendo.io.s1.a aVar) {
        this.c = aVar;
    }

    public void a(g gVar) {
        this.b = gVar;
    }

    public void a(a aVar) {
        this.f1509a = aVar;
    }

    public static <T> List<T> a(Class<T> cls, sdk.pendo.io.o1.d dVar, List<b> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                a(cls, dVar, arrayList, it.next().d());
            }
        }
        return arrayList;
    }
}
