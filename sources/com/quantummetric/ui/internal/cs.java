package com.quantummetric.ui.internal;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* loaded from: classes5.dex */
final class cs extends da {
    int o;
    boolean p;
    boolean q;
    private WeakReference<Drawable> r;
    private boolean s;

    cs(View view) {
        super(view);
    }

    private void a(Drawable drawable) {
        View view = this.B.get();
        this.p = de.b(this.m) && (view instanceof ImageView) && (drawable != null && (bz.a().b(drawable) || bz.a().b(drawable.getCurrent()))) && view.getHeight() == 0 && view.getWidth() == 0;
    }

    static boolean b(View view) {
        return (view instanceof ImageView) && (view.getParent() instanceof View) && ag.h((View) view.getParent());
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0049, code lost:
    
        if (((r0 == null || r0.get() == null) && !e()) == false) goto L34;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void a(com.quantummetric.ui.internal.bp r5, final com.quantummetric.ui.internal.h<java.lang.String> r6) {
        /*
            r4 = this;
            boolean r0 = r4.q
            if (r0 != 0) goto L75
            java.lang.ref.WeakReference<android.view.View> r0 = r4.B
            java.lang.Object r0 = r0.get()
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            java.lang.String r1 = r4.m
            boolean r1 = com.quantummetric.ui.internal.de.b(r1)
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L23
            boolean r1 = r4.s
            if (r1 != 0) goto L23
            boolean r1 = r4.b()
            if (r1 == 0) goto L21
            goto L23
        L21:
            r1 = r3
            goto L24
        L23:
            r1 = r2
        L24:
            if (r1 == 0) goto L4c
            if (r0 == 0) goto L4c
            boolean r0 = com.quantummetric.ui.internal.cd.f161a
            if (r0 != 0) goto L33
            com.quantummetric.instrument.internal.bu r0 = com.quantummetric.ui.QuantumMetric.b
            if (r0 != 0) goto L31
            goto L33
        L31:
            r0 = r3
            goto L34
        L33:
            r0 = r2
        L34:
            if (r0 != 0) goto L4c
            java.lang.ref.WeakReference<android.graphics.drawable.Drawable> r0 = r4.r
            if (r0 == 0) goto L40
            java.lang.Object r0 = r0.get()
            if (r0 != 0) goto L48
        L40:
            boolean r0 = r4.e()
            if (r0 != 0) goto L48
            r0 = r2
            goto L49
        L48:
            r0 = r3
        L49:
            if (r0 != 0) goto L4c
            goto L4d
        L4c:
            r2 = r3
        L4d:
            r4.s = r3
            if (r2 == 0) goto L75
            java.lang.ref.WeakReference<android.view.View> r0 = r4.B
            java.lang.Object r0 = r0.get()
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            android.graphics.drawable.Drawable r1 = r0.getDrawable()
            if (r1 == 0) goto L64
            android.graphics.drawable.Drawable r0 = r0.getDrawable()
            goto L68
        L64:
            android.graphics.drawable.Drawable r0 = r0.getBackground()
        L68:
            if (r0 == 0) goto L75
            java.lang.String r1 = r4.m
            com.quantummetric.instrument.internal.cs$1 r2 = new com.quantummetric.instrument.internal.cs$1
            r2.<init>()
            r5.a(r4, r0, r1, r2)
            return
        L75:
            if (r6 == 0) goto L7c
            java.lang.String r5 = ""
            r6.a(r5)
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.cs.a(com.quantummetric.instrument.internal.bp, com.quantummetric.instrument.internal.df$26):void");
    }

    @Override // com.quantummetric.ui.internal.da, com.quantummetric.ui.internal.c
    final void a(Object obj) {
        super.a(obj);
        if (obj instanceof ImageView) {
            this.o = ((ImageView) obj).getImageAlpha();
            c();
        }
    }

    @Override // com.quantummetric.ui.internal.da
    final boolean a(View view) {
        return super.a(view) || this.o != ((ImageView) view).getImageAlpha();
    }

    final boolean b() {
        boolean z = this.p && de.b(this.m);
        Drawable drawable = this.r.get();
        ImageView imageView = (ImageView) this.B.get();
        return !this.q && (drawable != ((imageView == null || imageView.getDrawable() == null) ? null : imageView.getDrawable()) || z || ag.b(drawable) || b(this.B.get()));
    }

    final void c() {
        ImageView imageView = (ImageView) this.B.get();
        Drawable drawable = (imageView == null || imageView.getDrawable() == null) ? null : imageView.getDrawable();
        WeakReference<Drawable> weakReference = this.r;
        this.s = weakReference == null || drawable != weakReference.get();
        WeakReference<Drawable> weakReference2 = new WeakReference<>(drawable);
        this.r = weakReference2;
        a(weakReference2.get());
    }

    final boolean d() {
        WeakReference<Drawable> weakReference = this.r;
        return !((weakReference == null || weakReference.get() == null) && !e()) && ag.c(this.r.get());
    }

    final boolean e() {
        return this.B.get() != null && (this.B.get().getBackground() instanceof BitmapDrawable);
    }
}
