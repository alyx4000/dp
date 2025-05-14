package com.quantummetric.ui.internal;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.quantummetric.ui.QuantumMetric;
import com.socure.docv.capturesdk.common.utils.ConstantsKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes5.dex */
final class cb {
    boolean d;
    cx e;
    a f;
    int g;
    int h;
    boolean j;
    long k;
    private long l;
    private long n;
    boolean i = true;
    private final long[] m = new long[10];

    /* renamed from: a, reason: collision with root package name */
    boolean f158a = true;
    List<String> b = new ArrayList();
    List<String> c = new ArrayList();

    static abstract class a {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        abstract int a();

        abstract int b();

        abstract int c();

        abstract int d();
    }

    static class b extends a {

        /* renamed from: a, reason: collision with root package name */
        private cw f159a;
        private final int b;

        b(cw cwVar) {
            super((byte) 0);
            this.b = 10;
            this.f159a = cwVar;
        }

        @Override // com.quantummetric.instrument.internal.cb.a
        final int a() {
            return this.f159a.p * 10;
        }

        @Override // com.quantummetric.instrument.internal.cb.a
        final int b() {
            return this.f159a.q * 10;
        }

        @Override // com.quantummetric.instrument.internal.cb.a
        final int c() {
            return (this.f159a.o - 1) * 10;
        }

        @Override // com.quantummetric.instrument.internal.cb.a
        final int d() {
            return this.f159a.q * 10;
        }
    }

    static class c extends a {

        /* renamed from: a, reason: collision with root package name */
        private cx f160a;
        private int b;

        c(cx cxVar) {
            super((byte) 0);
            this.f160a = cxVar;
            e();
        }

        private void e() {
            cx cxVar = this.f160a;
            if (cxVar == null || cxVar.B.get() == null) {
                return;
            }
            this.b = this.f160a.B.get().getHeight();
        }

        @Override // com.quantummetric.instrument.internal.cb.a
        final int a() {
            return this.f160a.t;
        }

        @Override // com.quantummetric.instrument.internal.cb.a
        final int b() {
            return this.f160a.t + this.b;
        }

        @Override // com.quantummetric.instrument.internal.cb.a
        final int c() {
            cx cxVar = this.f160a;
            if (cxVar != null && cxVar.B.get() != null) {
                ViewGroup viewGroup = (ViewGroup) this.f160a.B.get();
                View childAt = viewGroup.getChildCount() > 0 ? viewGroup.getChildAt(0) : null;
                if (childAt != null) {
                    return childAt.getHeight();
                }
            }
            return 0;
        }

        @Override // com.quantummetric.instrument.internal.cb.a
        final int d() {
            e();
            return this.b;
        }
    }

    cb() {
    }

    private void a(long j) {
        long j2 = j - this.l;
        this.n = j;
        for (int i = 0; i < this.m.length; i++) {
            QuantumMetric.a("sd".concat(String.valueOf(i)), Long.valueOf((this.m[i] * 100) / j2));
        }
    }

    final void a() {
        cx cxVar = this.e;
        if (cxVar != null) {
            cxVar.y = false;
        }
        this.e = null;
        this.h = 0;
        this.g = 0;
        this.i = true;
        this.k = 0L;
        Arrays.fill(this.m, 0L);
        this.n = 0L;
        this.j = false;
    }

    final void a(long j, long j2) {
        this.k = j;
        int i = this.g / 10;
        if (i > 0) {
            float f = i;
            int round = Math.round(this.f.a() / f);
            int round2 = Math.round(this.f.b() / f);
            if (round >= round2 || round2 > this.m.length) {
                return;
            }
            while (round < round2) {
                long[] jArr = this.m;
                jArr[round] = jArr[round] + j2;
                round++;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void a(com.quantummetric.ui.internal.cx r7) {
        /*
            r6 = this;
            if (r7 == 0) goto Lc6
            java.lang.ref.WeakReference<android.view.View> r0 = r7.B
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto Lc6
            java.lang.ref.WeakReference<android.view.View> r0 = r7.B
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            boolean r1 = r6.d
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L5d
            java.lang.String r1 = com.quantummetric.ui.internal.de.a(r0)
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r0.getSimpleName()
            java.util.List<java.lang.String> r4 = r6.b
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L3f
            java.util.List<java.lang.String> r4 = r6.b
            boolean r4 = r4.contains(r1)
            if (r4 != 0) goto L3f
            java.util.List<java.lang.String> r4 = r6.b
            boolean r4 = r4.contains(r0)
            if (r4 == 0) goto L3d
            goto L3f
        L3d:
            r4 = r2
            goto L40
        L3f:
            r4 = r3
        L40:
            if (r4 == 0) goto L5e
            java.util.List<java.lang.String> r5 = r6.c
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L5e
            java.util.List<java.lang.String> r4 = r6.c
            boolean r1 = r4.contains(r1)
            if (r1 != 0) goto L5b
            java.util.List<java.lang.String> r1 = r6.c
            boolean r0 = r1.contains(r0)
            if (r0 != 0) goto L5b
            goto L5d
        L5b:
            r4 = r2
            goto L5e
        L5d:
            r4 = r3
        L5e:
            if (r4 == 0) goto Lc6
            java.lang.ref.WeakReference<android.view.View> r0 = r7.B
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            boolean r1 = r0 instanceof android.widget.ScrollView
            if (r1 != 0) goto L78
            boolean r1 = com.quantummetric.ui.internal.ag.g(r0)
            if (r1 != 0) goto L78
            boolean r1 = com.quantummetric.ui.internal.ag.a(r0)
            if (r1 == 0) goto Lc6
        L78:
            int r1 = r0.getHeight()
            float r1 = (float) r1
            int r4 = com.quantummetric.ui.internal.de.b()
            float r4 = (float) r4
            float r1 = r1 / r4
            r4 = 1058642330(0x3f19999a, float:0.6)
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 <= 0) goto L9e
            int r0 = r0.getWidth()
            float r0 = (float) r0
            int r1 = com.quantummetric.ui.internal.de.a()
            float r1 = (float) r1
            float r0 = r0 / r1
            r1 = 1063675494(0x3f666666, float:0.9)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L9e
            r0 = r3
            goto L9f
        L9e:
            r0 = r2
        L9f:
            if (r0 == 0) goto Lc6
            r6.i = r2
            r6.e = r7
            boolean r0 = r7 instanceof com.quantummetric.ui.internal.cw
            if (r0 == 0) goto Lb2
            com.quantummetric.instrument.internal.cb$b r0 = new com.quantummetric.instrument.internal.cb$b
            r1 = r7
            com.quantummetric.instrument.internal.cw r1 = (com.quantummetric.ui.internal.cw) r1
            r0.<init>(r1)
            goto Lb7
        Lb2:
            com.quantummetric.instrument.internal.cb$c r0 = new com.quantummetric.instrument.internal.cb$c
            r0.<init>(r7)
        Lb7:
            r6.f = r0
            long r0 = java.lang.System.currentTimeMillis()
            r6.k = r0
            r6.l = r0
            r6.b()
            r7.y = r3
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.cb.a(com.quantummetric.instrument.internal.cx):void");
    }

    final void a(boolean z, long j) {
        cx cxVar;
        try {
            if (!this.f158a || (cxVar = this.e) == null || cxVar.B.get() == null || this.g <= 0) {
                return;
            }
            if (this.n == 0) {
                this.n = j;
            }
            if (!z || !this.j) {
                if (j - this.n > DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM) {
                    a(j);
                }
            } else {
                this.j = false;
                if (j - this.n < ConstantsKt.PREVIEW_UPLOAD_DELAY) {
                    a(j, j - this.k);
                    a(j);
                }
            }
        } catch (Exception unused) {
        }
    }

    final void b() {
        int c2 = this.f.c();
        if (c2 == this.g || c2 <= 0) {
            this.i = false;
            return;
        }
        int d = this.f.d();
        this.g = c2;
        this.h = (d * 100) / c2;
    }
}
