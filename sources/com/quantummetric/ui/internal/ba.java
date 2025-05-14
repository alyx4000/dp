package com.quantummetric.ui.internal;

import android.view.View;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
final class ba {

    /* renamed from: a, reason: collision with root package name */
    static ba f99a;
    boolean b;
    boolean c;
    Map<String, a> d = new HashMap();

    static class a {

        /* renamed from: a, reason: collision with root package name */
        Set<b> f100a;
        private String b;
        private String c;

        a(String str, String str2, Set<b> set) {
            this.b = str;
            this.c = str2;
            HashSet hashSet = new HashSet();
            this.f100a = hashSet;
            hashSet.addAll(set);
        }

        public final String toString() {
            return this.b + " " + this.c + " " + this.f100a;
        }
    }

    enum b {
        LAYOUT,
        Text,
        Click,
        Hierarchy,
        Scroll,
        Visibility,
        All
    }

    ba() {
    }

    final a a(View view) {
        if (view == null) {
            return null;
        }
        a aVar = this.b ? this.d.get(de.a(view)) : null;
        return (aVar == null && this.c) ? this.d.get(view.getClass().getSimpleName()) : aVar;
    }
}
