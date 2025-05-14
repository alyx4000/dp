package sdk.pendo.io.m8;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.events.ConditionData;
import sdk.pendo.io.events.IdentificationData;
import sdk.pendo.io.g9.a0;
import sdk.pendo.io.g9.g0;
import sdk.pendo.io.g9.q0;
import sdk.pendo.io.logging.PendoLogger;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f1401a;
    private static final sdk.pendo.io.f8.a<Integer, View> b = new sdk.pendo.io.f8.a<>();
    private static final ReentrantReadWriteLock c;
    private static final ReentrantReadWriteLock.WriteLock d;
    private static final ReentrantReadWriteLock.WriteLock e;

    static {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        c = reentrantReadWriteLock;
        d = reentrantReadWriteLock.writeLock();
        e = reentrantReadWriteLock.writeLock();
    }

    private a() {
    }

    public static <T> View a(View view, String str) {
        return a(view, str, (HashSet<View>) new HashSet());
    }

    public static void b() {
        a();
    }

    public static View a(View view, IdentificationData identificationData, List<View> list, boolean z, ConditionData conditionData) {
        View a2;
        if (view == null || identificationData == null) {
            return null;
        }
        sdk.pendo.io.t2.b bVar = new sdk.pendo.io.t2.b();
        if (bVar.e()) {
            bVar.g();
        }
        if (!bVar.d()) {
            bVar.h();
        }
        try {
            int hashCode = (view.hashCode() * 7) + (identificationData.hashCode() * 31);
            if (list == null && (a2 = a(Integer.valueOf(hashCode))) != null && a0.a(identificationData, a2, conditionData)) {
                PendoLogger.d("View cache found!", new Object[0]);
                if (!z || q0.a(a2, 0)) {
                    if (bVar.d() || bVar.f()) {
                        bVar.i();
                    }
                    PendoLogger.i("Finding view took: " + bVar.c() + " Millis", new Object[0]);
                    return a2;
                }
                PendoLogger.d("Outside the display.", new Object[0]);
                if (bVar.d() || bVar.f()) {
                    bVar.i();
                }
                PendoLogger.i("Finding view took: " + bVar.c() + " Millis", new Object[0]);
                return null;
            }
            HashSet hashSet = new HashSet();
            String id = identificationData.getId();
            if (id != null) {
                PendoLogger.d("Identification data has ID.", new Object[0]);
                int b2 = g0.b(id);
                if (b2 != -1) {
                    a(view, (HashSet<View>) new HashSet(), hashSet, b2);
                    HashSet hashSet2 = new HashSet();
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        View a3 = a((View) it.next(), identificationData, (HashSet<View>) hashSet2, z, conditionData);
                        if (a3 != null) {
                            if (list == null) {
                                a(Integer.valueOf(hashCode), a3);
                                if (bVar.d() || bVar.f()) {
                                    bVar.i();
                                }
                                PendoLogger.i("Finding view took: " + bVar.c() + " Millis", new Object[0]);
                                return a3;
                            }
                            list.add(a3);
                        }
                    }
                    if (list != null && !list.isEmpty()) {
                        View remove = list.remove(0);
                        if (bVar.d() || bVar.f()) {
                            bVar.i();
                        }
                        PendoLogger.i("Finding view took: " + bVar.c() + " Millis", new Object[0]);
                        return remove;
                    }
                    if (bVar.d() || bVar.f()) {
                        bVar.i();
                    }
                    PendoLogger.i("Finding view took: " + bVar.c() + " Millis", new Object[0]);
                    return null;
                }
            }
            ArrayList<String> idOfParents = identificationData.getIdOfParents();
            if (idOfParents == null || idOfParents.isEmpty()) {
                View a4 = a(view, identificationData, (HashSet<View>) new HashSet(), true, conditionData);
                if (a4 != null) {
                    a(Integer.valueOf(hashCode), a4);
                }
                if (bVar.d() || bVar.f()) {
                    bVar.i();
                }
                PendoLogger.i("Finding view took: " + bVar.c() + " Millis", new Object[0]);
                return a4;
            }
            PendoLogger.d("Identification data has parents IDs.", new Object[0]);
            a(view, (HashSet<View>) new HashSet(), idOfParents, hashSet);
            HashSet hashSet3 = new HashSet();
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                View a5 = a((View) it2.next(), identificationData, (HashSet<View>) hashSet3, z, conditionData);
                if (a5 != null) {
                    if (list == null) {
                        a(Integer.valueOf(hashCode), a5);
                        if (bVar.d() || bVar.f()) {
                            bVar.i();
                        }
                        PendoLogger.i("Finding view took: " + bVar.c() + " Millis", new Object[0]);
                        return a5;
                    }
                    list.add(a5);
                }
            }
            if (list != null && !list.isEmpty()) {
                View remove2 = list.remove(0);
                if (bVar.d() || bVar.f()) {
                    bVar.i();
                }
                PendoLogger.i("Finding view took: " + bVar.c() + " Millis", new Object[0]);
                return remove2;
            }
            if (bVar.d() || bVar.f()) {
                bVar.i();
            }
            PendoLogger.i("Finding view took: " + bVar.c() + " Millis", new Object[0]);
            return null;
        } catch (Throwable th) {
            if (bVar.d() || bVar.f()) {
                bVar.i();
            }
            PendoLogger.i("Finding view took: " + bVar.c() + " Millis", new Object[0]);
            throw th;
        }
    }

    public static View a(View view, IdentificationData identificationData, boolean z, ConditionData conditionData) {
        return a(view, identificationData, (List<View>) null, z, conditionData);
    }

    public static <T> View a(View view, Object obj) {
        return a(view, obj, (HashSet<View>) new HashSet());
    }

    private static <T> View a(View view, Object obj, HashSet<View> hashSet) {
        View a2;
        if (view == null) {
            return null;
        }
        hashSet.add(view);
        if (view instanceof ViewGroup) {
            View findViewWithTag = view.findViewWithTag(obj);
            if (findViewWithTag != null) {
                return findViewWithTag;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (!hashSet.contains(childAt) && (a2 = a(childAt, obj, hashSet)) != null) {
                        return a2;
                    }
                }
            }
        }
        return null;
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f1401a == null) {
                f1401a = new a();
            }
            aVar = f1401a;
        }
        return aVar;
    }

    private static View a(Integer num) {
        ReentrantReadWriteLock.WriteLock writeLock = e;
        writeLock.lock();
        try {
            View view = b.get(num);
            writeLock.unlock();
            return view;
        } catch (Throwable th) {
            e.unlock();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0025, code lost:
    
        sdk.pendo.io.m8.a.b.put(r2, r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(java.lang.Integer r2, android.view.View r3) {
        /*
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = sdk.pendo.io.m8.a.d
            r0.lock()
            android.view.ViewParent r0 = r3.getParent()     // Catch: java.lang.Throwable -> L2b
        L9:
            boolean r1 = r0 instanceof android.view.View     // Catch: java.lang.Throwable -> L2b
            if (r1 == 0) goto L25
            android.view.View r0 = (android.view.View) r0     // Catch: java.lang.Throwable -> L2b
            boolean r1 = r0 instanceof androidx.viewpager.widget.PagerTabStrip     // Catch: java.lang.Throwable -> L2b
            if (r1 != 0) goto L1f
            boolean r1 = sdk.pendo.io.g9.q0.j(r0)     // Catch: java.lang.Throwable -> L2b
            if (r1 == 0) goto L1a
            goto L1f
        L1a:
            android.view.ViewParent r0 = r0.getParent()     // Catch: java.lang.Throwable -> L2b
            goto L9
        L1f:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r2 = sdk.pendo.io.m8.a.d
            r2.unlock()
            return
        L25:
            sdk.pendo.io.f8.a<java.lang.Integer, android.view.View> r0 = sdk.pendo.io.m8.a.b     // Catch: java.lang.Throwable -> L2b
            r0.put(r2, r3)     // Catch: java.lang.Throwable -> L2b
            goto L1f
        L2b:
            r2 = move-exception
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r3 = sdk.pendo.io.m8.a.d
            r3.unlock()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.m8.a.a(java.lang.Integer, android.view.View):void");
    }

    private static <T> View a(View view, String str, HashSet<View> hashSet) {
        ViewGroup viewGroup;
        int childCount;
        View a2;
        if (view == null) {
            return null;
        }
        CharSequence contentDescription = view.getContentDescription();
        if (contentDescription != null && str.equals(contentDescription.toString())) {
            return view;
        }
        hashSet.add(view);
        if ((view instanceof ViewGroup) && (childCount = (viewGroup = (ViewGroup) view).getChildCount()) > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (!hashSet.contains(childAt) && (a2 = a(childAt, str, hashSet)) != null) {
                    return a2;
                }
            }
        }
        return null;
    }

    private static View a(View view, IdentificationData identificationData, HashSet<View> hashSet, boolean z, ConditionData conditionData) {
        ViewGroup viewGroup;
        int childCount;
        View a2;
        if (view != null && view.getVisibility() == 0) {
            if (!z || q0.a(view, 0)) {
                if (b.a(identificationData, b.a(view, Boolean.valueOf(PendoInternal.w().c()), Boolean.FALSE), false, conditionData).a().booleanValue()) {
                    return view;
                }
                hashSet.add(view);
                if ((view instanceof ViewGroup) && (childCount = (viewGroup = (ViewGroup) view).getChildCount()) > 0) {
                    for (int i = 0; i < childCount; i++) {
                        View childAt = viewGroup.getChildAt(i);
                        if (childAt != null && !hashSet.contains(childAt) && (a2 = a(childAt, identificationData, hashSet, z, conditionData)) != null) {
                            return a2;
                        }
                    }
                }
            }
        }
        return null;
    }

    private static void a(View view, HashSet<View> hashSet, ArrayList<String> arrayList, Set<View> set) {
        ViewGroup viewGroup;
        int childCount;
        View findViewById;
        try {
            hashSet.add(view);
            if (!(view instanceof ViewGroup) || (childCount = (viewGroup = (ViewGroup) view).getChildCount()) <= 0) {
                return;
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt != null) {
                    Iterator<String> it = arrayList.iterator();
                    View view2 = childAt;
                    while (it.hasNext()) {
                        int b2 = g0.b(it.next());
                        if (b2 != -1 && (findViewById = view2.findViewById(b2)) != null) {
                            view2 = findViewById;
                        }
                    }
                    if (!view2.equals(childAt)) {
                        set.add(view2);
                    }
                    if (!hashSet.contains(childAt)) {
                        a(childAt, hashSet, arrayList, set);
                    }
                }
            }
        } catch (NullPointerException e2) {
            PendoLogger.d(e2);
        }
    }

    private static void a(View view, HashSet<View> hashSet, Set<View> set, int i) {
        ViewGroup viewGroup;
        int childCount;
        if (view == null) {
            return;
        }
        if (view.getId() == i) {
            set.add(view);
        }
        hashSet.add(view);
        if (!(view instanceof ViewGroup) || (childCount = (viewGroup = (ViewGroup) view).getChildCount()) <= 0) {
            return;
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (!hashSet.contains(childAt)) {
                a(childAt, hashSet, set, i);
            }
        }
    }
}
