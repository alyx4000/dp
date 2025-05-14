package com.quantummetric.ui.internal;

import androidx.compose.runtime.AbstractApplier;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.Recomposer;
import com.quantummetric.ui.internal.g;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
final class bx {

    /* renamed from: a, reason: collision with root package name */
    boolean f146a;

    public final class a implements g.a<Object> {
        public a() {
        }

        @Override // com.quantummetric.instrument.internal.g.a
        public final void a() {
        }

        @Override // com.quantummetric.instrument.internal.g.a
        public final void a(Object obj) {
            try {
                if (obj instanceof Composition) {
                    Composition composition = (Composition) obj;
                    Composer a2 = bx.a(composition);
                    if (composition == null || a2 == null) {
                        return;
                    }
                    bx.a((Object) composition);
                }
            } catch (Throwable unused) {
            }
        }
    }

    static Composer a(Composition composition) {
        if (composition == null) {
            return null;
        }
        if (Intrinsics.areEqual(composition.getClass().getSimpleName(), "WrappedComposition")) {
            composition = (Composition) by.b(composition, "original");
        }
        return (Composer) by.b(composition, Class.forName("androidx.compose.runtime.CompositionImpl"), "composer");
    }

    private void a(Recomposer recomposer, Field field, ArrayList<?> arrayList) {
        g gVar = new g(new a());
        gVar.addAll(arrayList);
        field.set(recomposer, gVar);
        a(arrayList);
    }

    static void a(Object obj) {
        AbstractApplier<?> a2;
        Field declaredField = obj.getClass().getDeclaredField("applier");
        declaredField.setAccessible(true);
        Object obj2 = declaredField.get(obj);
        if (obj2 == null || (obj2 instanceof dd) || (a2 = dd.a((Applier<?>) obj2)) == null) {
            return;
        }
        declaredField.set(obj, a2);
    }

    private final void a(ArrayList<?> arrayList) {
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            Composition composition = (Composition) it.next();
            Composer a2 = a(composition);
            if (composition != null && a2 != null) {
                a((Object) composition);
            }
        }
        this.f146a = true;
    }

    final void a(Recomposer recomposer) {
        Field declaredField;
        try {
            declaredField = recomposer.getClass().getDeclaredField("knownCompositions");
        } catch (Throwable unused) {
            declaredField = recomposer.getClass().getDeclaredField("_knownCompositions");
        }
        declaredField.setAccessible(true);
        ArrayList<?> arrayList = (ArrayList) declaredField.get(recomposer);
        if (arrayList instanceof g) {
            return;
        }
        Object b = by.b(recomposer, "stateLock");
        if (b == null) {
            a(recomposer, declaredField, arrayList);
            return;
        }
        synchronized (b) {
            a(recomposer, declaredField, arrayList);
            Unit unit = Unit.INSTANCE;
        }
    }
}
