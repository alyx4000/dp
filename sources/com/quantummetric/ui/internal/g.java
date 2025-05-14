package com.quantummetric.ui.internal;

import java.util.ArrayList;

/* loaded from: classes5.dex */
final class g<T> extends ArrayList<T> {

    /* renamed from: a, reason: collision with root package name */
    private a<T> f259a;

    interface a<T> {
        void a();

        void a(T t);
    }

    g(a<T> aVar) {
        this.f259a = aVar;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(T t) {
        boolean add = super.add(t);
        a<T> aVar = this.f259a;
        if (aVar != null) {
            aVar.a(t);
        }
        return add;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final T remove(int i) {
        T t = (T) super.remove(i);
        a<T> aVar = this.f259a;
        if (aVar != null && t != null) {
            aVar.a();
        }
        return t;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        boolean remove = super.remove(obj);
        try {
            a<T> aVar = this.f259a;
            if (aVar != null && remove) {
                aVar.a();
            }
        } catch (Throwable unused) {
        }
        return remove;
    }
}
