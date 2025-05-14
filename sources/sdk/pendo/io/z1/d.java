package sdk.pendo.io.z1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public abstract class d<T> {
    private static ConcurrentHashMap<Class<?>, d<?>> c = new ConcurrentHashMap<>();

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, b> f1869a;
    private b[] b;

    private static void a(d<?> dVar, HashMap<String, String> hashMap) {
        if (hashMap == null) {
            return;
        }
        HashMap hashMap2 = new HashMap();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            b bVar = ((d) dVar).f1869a.get(entry.getValue());
            if (bVar != null) {
                hashMap2.put(entry.getValue(), bVar);
            }
        }
        ((d) dVar).f1869a.putAll(hashMap2);
    }

    public abstract Object a(T t, int i);

    public abstract void a(T t, int i, Object obj);

    public HashMap<String, b> b() {
        return this.f1869a;
    }

    public abstract T c();

    public static <P> d<P> a(Class<P> cls, j jVar) {
        Class<?> cls2;
        d<P> dVar = (d) c.get(cls);
        if (dVar != null) {
            return dVar;
        }
        b[] a2 = a.a((Class<?>) cls, jVar);
        String name = cls.getName();
        String concat = name.startsWith("java.util.") ? "external.sdk.pendo.io.jsonsmart.asm." + name + "AccAccess" : name.concat("AccAccess");
        i iVar = new i(cls.getClassLoader());
        try {
            cls2 = iVar.loadClass(concat);
        } catch (ClassNotFoundException unused) {
            cls2 = null;
        }
        LinkedList<Class<?>> a3 = a((Class<?>) cls);
        if (cls2 == null) {
            e eVar = new e(cls, a2, iVar);
            Iterator<Class<?>> it = a3.iterator();
            while (it.hasNext()) {
                eVar.a(f.f1871a.get(it.next()));
            }
            cls2 = eVar.a();
        }
        try {
            d<P> dVar2 = (d) cls2.newInstance();
            dVar2.a(a2);
            c.putIfAbsent(cls, dVar2);
            Iterator<Class<?>> it2 = a3.iterator();
            while (it2.hasNext()) {
                a((d<?>) dVar2, f.b.get(it2.next()));
            }
            return dVar2;
        } catch (Exception e) {
            throw new RuntimeException("Error constructing accessor class: " + concat, e);
        }
    }

    public b[] a() {
        return this.b;
    }

    public int a(String str) {
        b bVar = this.f1869a.get(str);
        if (bVar == null) {
            return -1;
        }
        return bVar.d;
    }

    private static LinkedList<Class<?>> a(Class<?> cls) {
        LinkedList<Class<?>> linkedList = new LinkedList<>();
        while (cls != null && !cls.equals(Object.class)) {
            linkedList.addLast(cls);
            for (Class<?> cls2 : cls.getInterfaces()) {
                linkedList.addLast(cls2);
            }
            cls = cls.getSuperclass();
        }
        linkedList.addLast(Object.class);
        return linkedList;
    }

    public void a(T t, String str, Object obj) {
        int a2 = a(str);
        if (a2 == -1) {
            throw new sdk.pendo.io.a2.a(str + " in " + t.getClass() + " to put value : " + obj);
        }
        a((d<T>) t, a2, obj);
    }

    protected void a(b[] bVarArr) {
        this.b = bVarArr;
        this.f1869a = new HashMap<>();
        int length = bVarArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            b bVar = bVarArr[i];
            bVar.d = i2;
            this.f1869a.put(bVar.c(), bVar);
            i++;
            i2++;
        }
    }
}
