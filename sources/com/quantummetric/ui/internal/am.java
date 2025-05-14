package com.quantummetric.ui.internal;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.quantummetric.ui.QuantumMetric;
import com.quantummetric.ui.internal.an;
import com.quantummetric.ui.internal.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: classes5.dex */
final class am extends FragmentManager.FragmentLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    volatile boolean f54a = false;
    private final List<String> b;
    private final List<String> c;
    private final List<String> d;
    private e.AnonymousClass2 e;

    static class a {

        /* renamed from: a, reason: collision with root package name */
        String f55a;
        int b;
        int c;
        int d;

        a(Fragment fragment, View view) {
            this.f55a = fragment.getClass().getSimpleName();
            this.b = fragment.hashCode();
            this.c = view.hashCode();
            if (fragment instanceof DialogFragment) {
                this.d = de.f(view);
            }
        }

        public final boolean equals(Object obj) {
            return (obj instanceof a) && obj.hashCode() == hashCode();
        }

        public final int hashCode() {
            return this.b * 31;
        }

        public final String toString() {
            return this.f55a + " | " + this.b + " | " + this.c;
        }
    }

    am(e.AnonymousClass2 anonymousClass2) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.c = arrayList2;
        this.d = new CopyOnWriteArrayList();
        if (QuantumMetric.f9a != null) {
            arrayList.addAll(y.a((JSONObject) QuantumMetric.f9a, "fragment_event_blacklist"));
            arrayList2.addAll(y.a((JSONObject) QuantumMetric.f9a, "fragment_event_regex_blacklist"));
        }
        this.e = anonymousClass2;
    }

    final void a() {
        this.f54a = false;
        if (this.d.size() > 0) {
            Iterator<String> it = this.d.iterator();
            while (it.hasNext()) {
                QuantumMetric.a(-35, it.next(), new j[0]);
            }
            this.d.clear();
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public final void onFragmentActivityCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        super.onFragmentActivityCreated(fragmentManager, fragment, bundle);
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public final void onFragmentAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        super.onFragmentAttached(fragmentManager, fragment, context);
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public final void onFragmentCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        super.onFragmentCreated(fragmentManager, fragment, bundle);
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public final void onFragmentDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentDestroyed(fragmentManager, fragment);
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public final void onFragmentDetached(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentDetached(fragmentManager, fragment);
        if (an.f56a == null) {
            an.f56a = new an();
        }
        try {
            an.a a2 = an.f56a.a(fragment.getClass().getSimpleName());
            if (a2 == null || a2.e == -1) {
                return;
            }
            a2.e = -1;
            QuantumMetric.sendPage();
        } catch (Exception unused) {
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public final void onFragmentPaused(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentPaused(fragmentManager, fragment);
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public final void onFragmentPreAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        super.onFragmentPreAttached(fragmentManager, fragment, context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0053, code lost:
    
        if (r3.f54a == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0055, code lost:
    
        r3.d.add(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005b, code lost:
    
        com.quantummetric.ui.QuantumMetric.a(-35, r5, new com.quantummetric.ui.internal.j[0]);
     */
    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onFragmentResumed(androidx.fragment.app.FragmentManager r4, androidx.fragment.app.Fragment r5) {
        /*
            r3 = this;
            super.onFragmentResumed(r4, r5)
            com.quantummetric.instrument.internal.bu r4 = com.quantummetric.ui.QuantumMetric.b     // Catch: java.lang.Throwable -> La3
            r0 = 1
            r1 = 0
            if (r4 != 0) goto Lb
            r4 = r0
            goto Lc
        Lb:
            r4 = r1
        Lc:
            if (r4 != 0) goto La3
            android.view.View r4 = r5.getView()     // Catch: java.lang.Throwable -> La3
            java.lang.Class r5 = r5.getClass()     // Catch: java.lang.Throwable -> La3
            java.lang.String r5 = r5.getSimpleName()     // Catch: java.lang.Throwable -> La3
            if (r4 == 0) goto L37
            com.quantummetric.instrument.internal.an r2 = com.quantummetric.ui.internal.an.f56a     // Catch: java.lang.Throwable -> La3
            if (r2 != 0) goto L27
            com.quantummetric.instrument.internal.an r2 = new com.quantummetric.instrument.internal.an     // Catch: java.lang.Throwable -> La3
            r2.<init>()     // Catch: java.lang.Throwable -> La3
            com.quantummetric.ui.internal.an.f56a = r2     // Catch: java.lang.Throwable -> La3
        L27:
            com.quantummetric.instrument.internal.an r2 = com.quantummetric.ui.internal.an.f56a     // Catch: java.lang.Throwable -> La3
            com.quantummetric.instrument.internal.an$a r2 = r2.a(r5)     // Catch: java.lang.Throwable -> La3
            if (r2 == 0) goto L37
            if (r4 == 0) goto L37
            int r4 = com.quantummetric.ui.internal.de.f(r4)     // Catch: java.lang.Throwable -> La3
            r2.e = r4     // Catch: java.lang.Throwable -> La3
        L37:
            boolean r4 = com.quantummetric.ui.internal.cd.f161a     // Catch: java.lang.Throwable -> La3
            if (r4 != 0) goto La3
            java.util.List<java.lang.String> r4 = r3.b     // Catch: java.lang.Throwable -> La3
            if (r4 == 0) goto L45
            boolean r4 = r4.contains(r5)     // Catch: java.lang.Throwable -> La3
            if (r4 != 0) goto L4f
        L45:
            java.util.List<java.lang.String> r4 = r3.c     // Catch: java.lang.Throwable -> La3
            boolean r4 = com.quantummetric.ui.internal.de.a(r5, r4)     // Catch: java.lang.Throwable -> La3
            if (r4 == 0) goto L4e
            goto L4f
        L4e:
            r0 = r1
        L4f:
            if (r0 != 0) goto L62
            boolean r4 = r3.f54a     // Catch: java.lang.Throwable -> La3
            if (r4 == 0) goto L5b
            java.util.List<java.lang.String> r4 = r3.d     // Catch: java.lang.Throwable -> La3
            r4.add(r5)     // Catch: java.lang.Throwable -> La3
            goto L62
        L5b:
            com.quantummetric.instrument.internal.j[] r4 = new com.quantummetric.ui.internal.j[r1]     // Catch: java.lang.Throwable -> La3
            r0 = -35
            com.quantummetric.ui.QuantumMetric.a(r0, r5, r4)     // Catch: java.lang.Throwable -> La3
        L62:
            com.quantummetric.instrument.internal.af r4 = com.quantummetric.ui.internal.af.f26a     // Catch: java.lang.Throwable -> La3
            if (r4 != 0) goto L6d
            com.quantummetric.instrument.internal.af r4 = new com.quantummetric.instrument.internal.af     // Catch: java.lang.Throwable -> La3
            r4.<init>()     // Catch: java.lang.Throwable -> La3
            com.quantummetric.ui.internal.af.f26a = r4     // Catch: java.lang.Throwable -> La3
        L6d:
            com.quantummetric.instrument.internal.af r4 = com.quantummetric.ui.internal.af.f26a     // Catch: java.lang.Throwable -> La3
            r4.a(r5)     // Catch: java.lang.Throwable -> La3
            com.quantummetric.instrument.internal.k r4 = com.quantummetric.ui.internal.k.f262a     // Catch: java.lang.Throwable -> La3
            if (r4 != 0) goto L7d
            com.quantummetric.instrument.internal.k r4 = new com.quantummetric.instrument.internal.k     // Catch: java.lang.Throwable -> La3
            r4.<init>()     // Catch: java.lang.Throwable -> La3
            com.quantummetric.ui.internal.k.f262a = r4     // Catch: java.lang.Throwable -> La3
        L7d:
            com.quantummetric.instrument.internal.k r4 = com.quantummetric.ui.internal.k.f262a     // Catch: java.lang.Throwable -> La3
            java.util.List<com.quantummetric.instrument.internal.k$a> r5 = r4.c     // Catch: java.lang.Throwable -> La3
            boolean r5 = r5.isEmpty()     // Catch: java.lang.Throwable -> La3
            if (r5 != 0) goto La3
            java.util.List<com.quantummetric.instrument.internal.k$a> r4 = r4.c     // Catch: java.lang.Throwable -> La3
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> La3
        L8d:
            boolean r5 = r4.hasNext()     // Catch: java.lang.Throwable -> La3
            if (r5 == 0) goto La3
            java.lang.Object r5 = r4.next()     // Catch: java.lang.Throwable -> La3
            com.quantummetric.instrument.internal.k$a r5 = (com.quantummetric.instrument.internal.k.a) r5     // Catch: java.lang.Throwable -> La3
            com.quantummetric.instrument.internal.k$b r0 = r5.g     // Catch: java.lang.Throwable -> La3
            if (r0 == 0) goto L8d
            com.quantummetric.instrument.internal.k$b r5 = r5.g     // Catch: java.lang.Throwable -> La3
            r5.a()     // Catch: java.lang.Throwable -> La3
            goto L8d
        La3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.am.onFragmentResumed(androidx.fragment.app.FragmentManager, androidx.fragment.app.Fragment):void");
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public final void onFragmentSaveInstanceState(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        super.onFragmentSaveInstanceState(fragmentManager, fragment, bundle);
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public final void onFragmentStarted(FragmentManager fragmentManager, Fragment fragment) {
        View view;
        super.onFragmentStarted(fragmentManager, fragment);
        try {
            if ((QuantumMetric.b == null) || (view = fragment.getView()) == null) {
                return;
            }
            this.e.a(new a(fragment, view));
        } catch (Throwable unused) {
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public final void onFragmentStopped(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentStopped(fragmentManager, fragment);
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public final void onFragmentViewCreated(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
        super.onFragmentViewCreated(fragmentManager, fragment, view, bundle);
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public final void onFragmentViewDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentViewDestroyed(fragmentManager, fragment);
        try {
            this.e.a(fragment.hashCode());
        } catch (Throwable unused) {
        }
    }
}
