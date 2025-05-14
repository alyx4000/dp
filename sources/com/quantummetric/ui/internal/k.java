package com.quantummetric.ui.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes5.dex */
final class k {

    /* renamed from: a, reason: collision with root package name */
    static k f262a;
    List<a> b = new ArrayList();
    List<a> c = new CopyOnWriteArrayList();
    List<String> d = new ArrayList();
    List<String> e = new ArrayList();
    boolean f;
    boolean g;
    boolean h;

    static class a {

        /* renamed from: a, reason: collision with root package name */
        String f263a;
        String b;
        String c;
        String d;
        int e;
        int f;
        b g;
        private int h;

        a() {
        }

        a(String str, String str2, String str3, String str4, int i, int i2, int i3) {
            this.f263a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = i;
            this.f = i2;
            this.h = i3;
        }
    }

    interface b {
        void a();
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    static final class c {

        /* renamed from: a, reason: collision with root package name */
        public static final int f264a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        private static final /* synthetic */ int[] e = {1, 2, 3, 4};

        public static int[] values$7d63dbc9() {
            return (int[]) e.clone();
        }
    }

    k() {
    }

    static int a(String str) {
        if (de.b(str)) {
            return 0;
        }
        str.hashCode();
        switch (str) {
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0048, code lost:
    
        if (r7 == r1.e) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004c, code lost:
    
        if (r7 != r1.f) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final com.quantummetric.instrument.internal.k.a a(android.view.View r6, int r7) {
        /*
            r5 = this;
            boolean r0 = r5.f
            if (r0 == 0) goto L4f
            if (r6 == 0) goto L4f
            java.util.List<com.quantummetric.instrument.internal.k$a> r0 = r5.b
            java.util.Iterator r0 = r0.iterator()
        Lc:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L4f
            java.lang.Object r1 = r0.next()
            com.quantummetric.instrument.internal.k$a r1 = (com.quantummetric.instrument.internal.k.a) r1
            java.lang.String r2 = com.quantummetric.ui.internal.de.a(r6)
            java.lang.Class r3 = r6.getClass()
            java.lang.String r3 = r3.getSimpleName()
            java.lang.String r4 = r1.b
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L44
            java.lang.String r4 = r1.d
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L44
            java.lang.String r3 = r1.f263a
            boolean r3 = r2.equals(r3)
            if (r3 != 0) goto L44
            java.lang.String r3 = r1.c
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto Lc
        L44:
            if (r7 == 0) goto L4e
            int r2 = r1.e
            if (r7 == r2) goto L4e
            int r2 = r1.f
            if (r7 != r2) goto Lc
        L4e:
            return r1
        L4f:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.k.a(android.view.View, int):com.quantummetric.instrument.internal.k$a");
    }
}
