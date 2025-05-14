package sdk.pendo.io.f2;

import java.util.Date;
import java.util.HashMap;

/* loaded from: classes6.dex */
public abstract class b<T> extends k<T> {
    public static k<Date> c = new a(null);

    class a extends sdk.pendo.io.f2.a<Date> {
        a(j jVar) {
            super(jVar);
        }

        @Override // sdk.pendo.io.f2.k
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Date a(Object obj) {
            return sdk.pendo.io.z1.g.a(obj);
        }
    }

    /* renamed from: sdk.pendo.io.f2.b$b, reason: collision with other inner class name */
    public static class C0132b<T> extends k<T> {
        final Class<T> c;
        final sdk.pendo.io.z1.d<T> d;
        final HashMap<String, sdk.pendo.io.z1.b> e;

        public C0132b(j jVar, Class<T> cls) {
            super(jVar);
            this.c = cls;
            sdk.pendo.io.z1.d<T> a2 = sdk.pendo.io.z1.d.a(cls, sdk.pendo.io.b2.h.f883a);
            this.d = a2;
            this.e = a2.b();
        }

        @Override // sdk.pendo.io.f2.k
        public void a(Object obj, String str, Object obj2) {
            this.d.a((sdk.pendo.io.z1.d<T>) obj, str, obj2);
        }

        @Override // sdk.pendo.io.f2.k
        public Object b() {
            return this.d.c();
        }

        @Override // sdk.pendo.io.f2.k
        public k<?> a(String str) {
            sdk.pendo.io.z1.b bVar = this.e.get(str);
            if (bVar != null) {
                return this.f1073a.a(bVar.a());
            }
            throw new RuntimeException("Can not find Array '" + str + "' field in " + this.c);
        }

        @Override // sdk.pendo.io.f2.k
        public k<?> b(String str) {
            sdk.pendo.io.z1.b bVar = this.e.get(str);
            if (bVar != null) {
                return this.f1073a.a(bVar.a());
            }
            throw new RuntimeException("Can not find Object '" + str + "' field in " + this.c);
        }
    }
}
