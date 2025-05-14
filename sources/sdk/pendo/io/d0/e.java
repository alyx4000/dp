package sdk.pendo.io.d0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sdk.pendo.io.q.i;

/* loaded from: classes6.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final List<String> f978a = new ArrayList();
    private final Map<String, List<a<?, ?>>> b = new HashMap();

    private static class a<T, R> {

        /* renamed from: a, reason: collision with root package name */
        private final Class<T> f979a;
        final Class<R> b;
        final i<T, R> c;

        public a(Class<T> cls, Class<R> cls2, i<T, R> iVar) {
            this.f979a = cls;
            this.b = cls2;
            this.c = iVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return this.f979a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.b);
        }
    }

    public synchronized <T, R> void a(String str, i<T, R> iVar, Class<T> cls, Class<R> cls2) {
        a(str).add(new a<>(cls, cls2, iVar));
    }

    public synchronized <T, R> List<Class<R>> b(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.f978a.iterator();
        while (it.hasNext()) {
            List<a<?, ?>> list = this.b.get(it.next());
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2) && !arrayList.contains(aVar.b)) {
                        arrayList.add(aVar.b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> List<i<T, R>> a(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.f978a.iterator();
        while (it.hasNext()) {
            List<a<?, ?>> list = this.b.get(it.next());
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.c);
                    }
                }
            }
        }
        return arrayList;
    }

    private synchronized List<a<?, ?>> a(String str) {
        List<a<?, ?>> list;
        if (!this.f978a.contains(str)) {
            this.f978a.add(str);
        }
        list = this.b.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.b.put(str, list);
        }
        return list;
    }

    public synchronized void a(List<String> list) {
        ArrayList<String> arrayList = new ArrayList(this.f978a);
        this.f978a.clear();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            this.f978a.add(it.next());
        }
        for (String str : arrayList) {
            if (!list.contains(str)) {
                this.f978a.add(str);
            }
        }
    }
}
