package com.quantummetric.ui.internal;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes5.dex */
final class an {

    /* renamed from: a, reason: collision with root package name */
    static an f56a;
    boolean d;
    boolean e;
    boolean f;
    List<a> b = new ArrayList();
    List<String> c = new ArrayList();
    final Set<String> g = Collections.newSetFromMap(new ConcurrentHashMap());

    static class a {

        /* renamed from: a, reason: collision with root package name */
        String f57a;
        String b;
        String c;
        String d;
        int e = -1;

        public a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f57a = jSONObject.optString("p_id");
                this.b = jSONObject.optString("c_id");
                this.c = jSONObject.optString("activity");
                String optString = jSONObject.optString("new_window_fragment");
                this.d = optString;
                if (de.b(optString)) {
                    return;
                }
                if (an.f56a == null) {
                    an.f56a = new an();
                }
                an.f56a.f = true;
            }
        }
    }

    an() {
    }

    final a a(String str) {
        if (this.d && this.f) {
            for (a aVar : this.b) {
                if (!de.b(aVar.d) && aVar.d.equals(str)) {
                    return aVar;
                }
            }
        }
        return null;
    }

    final String a(FragmentActivity fragmentActivity) {
        FragmentManager supportFragmentManager;
        try {
            if (!this.d || !this.e || (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) == null) {
                return null;
            }
            for (Fragment fragment : supportFragmentManager.getFragments()) {
                View view = fragment.getView();
                if (view != null && (view.getParent() instanceof View)) {
                    View view2 = (View) view.getParent();
                    String simpleName = fragment.getClass().getSimpleName();
                    if (f56a == null) {
                        f56a = new an();
                    }
                    if (f56a.a(simpleName, view2, view)) {
                        return simpleName;
                    }
                }
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    final String a(String str, String str2) {
        String str3 = str + "/" + str2;
        this.g.add(str3);
        return str3;
    }

    final boolean a(String str, View view, View view2) {
        String str2;
        String a2;
        if (!this.d) {
            return false;
        }
        boolean z = false;
        for (a aVar : this.b) {
            if (de.b(aVar.f57a)) {
                if (!de.b(aVar.b)) {
                    str2 = aVar.b;
                    a2 = de.a(view2);
                }
                if (z && !de.b(aVar.c) && e.a() != null) {
                    z = de.a(e.a().c(), aVar.c);
                }
            } else {
                str2 = aVar.f57a;
                a2 = de.a(view);
            }
            z = str2.equals(a2);
            if (z) {
                z = de.a(e.a().c(), aVar.c);
            }
        }
        return (!z || this.c.isEmpty()) ? z : (de.a(str, this.c) || de.a(de.a(view2), this.c)) ? false : true;
    }
}
