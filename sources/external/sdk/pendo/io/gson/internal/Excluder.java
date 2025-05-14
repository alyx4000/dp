package external.sdk.pendo.io.gson.internal;

import external.sdk.pendo.io.gson.Gson;
import external.sdk.pendo.io.gson.TypeAdapter;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import sdk.pendo.io.k0.a;
import sdk.pendo.io.k0.b;
import sdk.pendo.io.k0.u;
import sdk.pendo.io.l0.d;
import sdk.pendo.io.l0.e;
import sdk.pendo.io.r0.c;

/* loaded from: classes2.dex */
public final class Excluder implements u, Cloneable {
    public static final Excluder v0 = new Excluder();
    private boolean f0;
    private double f = -1.0d;
    private int s = 136;
    private boolean A = true;
    private List<a> t0 = Collections.emptyList();
    private List<a> u0 = Collections.emptyList();

    private boolean b(Class<?> cls, boolean z) {
        Iterator<a> it = (z ? this.t0 : this.u0).iterator();
        while (it.hasNext()) {
            if (it.next().a(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // sdk.pendo.io.k0.u
    public <T> TypeAdapter<T> a(final Gson gson, final sdk.pendo.io.q0.a<T> aVar) {
        Class<? super T> a2 = aVar.a();
        boolean a3 = a(a2);
        final boolean z = a3 || b(a2, true);
        final boolean z2 = a3 || b(a2, false);
        if (z || z2) {
            return new TypeAdapter<T>() { // from class: external.sdk.pendo.io.gson.internal.Excluder.1

                /* renamed from: a, reason: collision with root package name */
                private TypeAdapter<T> f725a;

                private TypeAdapter<T> b() {
                    TypeAdapter<T> typeAdapter = this.f725a;
                    if (typeAdapter != null) {
                        return typeAdapter;
                    }
                    TypeAdapter<T> a4 = gson.a(Excluder.this, aVar);
                    this.f725a = a4;
                    return a4;
                }

                @Override // external.sdk.pendo.io.gson.TypeAdapter
                public T a(sdk.pendo.io.r0.a aVar2) {
                    if (!z2) {
                        return b().a(aVar2);
                    }
                    aVar2.J();
                    return null;
                }

                @Override // external.sdk.pendo.io.gson.TypeAdapter
                public void a(c cVar, T t) {
                    if (z) {
                        cVar.s();
                    } else {
                        b().a(cVar, t);
                    }
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Excluder clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public Excluder d() {
        Excluder clone = clone();
        clone.f0 = true;
        return clone;
    }

    private boolean b(Class<?> cls) {
        return (Enum.class.isAssignableFrom(cls) || d(cls) || (!cls.isAnonymousClass() && !cls.isLocalClass())) ? false : true;
    }

    private boolean c(Class<?> cls) {
        return cls.isMemberClass() && !d(cls);
    }

    private boolean d(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    public boolean a(Class<?> cls, boolean z) {
        return a(cls) || b(cls, z);
    }

    private boolean a(Class<?> cls) {
        if (this.f == -1.0d || a((d) cls.getAnnotation(d.class), (e) cls.getAnnotation(e.class))) {
            return (!this.A && c(cls)) || b(cls);
        }
        return true;
    }

    public boolean a(Field field, boolean z) {
        sdk.pendo.io.l0.a aVar;
        if ((this.s & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f != -1.0d && !a((d) field.getAnnotation(d.class), (e) field.getAnnotation(e.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.f0 && ((aVar = (sdk.pendo.io.l0.a) field.getAnnotation(sdk.pendo.io.l0.a.class)) == null || (!z ? aVar.deserialize() : aVar.serialize()))) {
            return true;
        }
        if ((!this.A && c(field.getType())) || b(field.getType())) {
            return true;
        }
        List<a> list = z ? this.t0 : this.u0;
        if (list.isEmpty()) {
            return false;
        }
        b bVar = new b(field);
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().a(bVar)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(d dVar) {
        return dVar == null || dVar.value() <= this.f;
    }

    private boolean a(e eVar) {
        return eVar == null || eVar.value() > this.f;
    }

    private boolean a(d dVar, e eVar) {
        return a(dVar) && a(eVar);
    }
}
