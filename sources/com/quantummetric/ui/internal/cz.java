package com.quantummetric.ui.internal;

import android.graphics.drawable.Drawable;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.quantummetric.ui.internal.af;
import com.quantummetric.ui.internal.bd;
import com.quantummetric.ui.internal.cj;

/* loaded from: classes5.dex */
final class cz extends da implements cj.b {
    short[] A;
    private boolean F;
    private boolean G;
    private int H;
    private int I;
    boolean o;
    boolean p;
    boolean q;
    boolean r;
    boolean s;
    int t;
    boolean u;
    boolean v;
    int w;
    String[] x;
    String y;
    String z;

    cz(View view) {
        super(view);
        this.w = 0;
        this.A = new short[2];
        try {
            TextView textView = (TextView) this.B.get();
            if (textView != null) {
                this.G = textView instanceof EditText;
                String a2 = de.a((View) textView);
                if (!de.b(a2)) {
                    if (af.f26a == null) {
                        af.f26a = new af();
                    }
                    boolean z = true;
                    this.v = af.f26a.b(a2) != null;
                    bd a3 = bd.a();
                    bd.b bVar = a3.e.get(a2);
                    if (bVar == null) {
                        z = false;
                    } else if (!de.b(bVar.b)) {
                        z = bd.a((View) textView, bVar.b, true);
                    } else if (!de.b(bVar.c)) {
                        z = bd.a((View) textView, bVar.c, false);
                    } else if (!de.b(bVar.d)) {
                        z = e.a().a(bVar.d, false);
                    }
                    r3 = z ? bVar : null;
                    if (r3 != null) {
                        a3.a(textView, r3.toString());
                    }
                }
                if (r3 == null && bd.b) {
                    r3 = bd.a().a((da) this, textView.getClass().getSimpleName());
                }
                if (r3 == null && bd.d) {
                    r3 = bd.a().b(this);
                }
                if (r3 != null) {
                    a(r3.i, false, r3.g, r3.h);
                }
                cj.b(this, textView.getText() != null ? textView.getText().toString() : "");
            }
        } catch (Exception unused) {
        }
        l();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0029 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean b(android.widget.TextView r1) {
        /*
            int r0 = r1.getWidth()
            if (r0 <= 0) goto L24
            int r0 = r1.getHeight()
            if (r0 <= 0) goto L24
            boolean r0 = com.quantummetric.ui.internal.ag.i(r1)
            if (r0 == 0) goto L19
            androidx.appcompat.widget.SwitchCompat r1 = (androidx.appcompat.widget.SwitchCompat) r1
            android.graphics.drawable.Drawable r1 = r1.getThumbDrawable()
            goto L25
        L19:
            boolean r0 = r1 instanceof android.widget.Switch
            if (r0 == 0) goto L24
            android.widget.Switch r1 = (android.widget.Switch) r1
            android.graphics.drawable.Drawable r1 = r1.getThumbDrawable()
            goto L25
        L24:
            r1 = 0
        L25:
            if (r1 == 0) goto L29
            r1 = 1
            return r1
        L29:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.cz.b(android.widget.TextView):boolean");
    }

    @Override // com.quantummetric.instrument.internal.cj.b
    public final void a(ar arVar) {
        if (this.H > 0) {
            ar a2 = arVar.a((ar) "style=\"");
            a2.f65a.append(aa.Z).append(":").append((Object) (de.b(this.H) + "px")).append(";");
            a2.a((ar) "\" ");
        }
    }

    @Override // com.quantummetric.ui.internal.da, com.quantummetric.ui.internal.c
    final void a(Object obj) {
        af.k b;
        super.a(obj);
        if (obj instanceof TextView) {
            TextView textView = (TextView) obj;
            if (m() != null) {
                this.s = !de.b(cy.b(r0));
                if (ag.d((View) textView)) {
                    this.H = textView.getCompoundPaddingLeft() - textView.getPaddingLeft();
                }
            }
            this.r = a(textView);
            this.t = textView.getCurrentTextColor();
            this.w = de.a(textView.getText());
            if (this.v) {
                if (af.f26a == null) {
                    af.f26a = new af();
                }
                af afVar = af.f26a;
                String a2 = de.a((View) textView);
                if (!de.b(a2) && (b = afVar.b(a2)) != null) {
                    b.a(textView.getText(), this);
                }
            }
            if (this.u) {
                return;
            }
            if (cu.f176a == null) {
                cu.f176a = new cu();
            }
            boolean contains = cu.f176a.b.contains(Integer.valueOf(textView.hashCode()));
            if (!contains && (textView.getTransformationMethod() instanceof PasswordTransformationMethod)) {
                if (cu.f176a == null) {
                    cu.f176a = new cu();
                }
                cu.f176a.b.add(Integer.valueOf(textView.hashCode()));
                contains = true;
            }
            this.u = contains;
            if (contains) {
                bd a3 = bd.a();
                if (a3.q) {
                    a3.a(textView, "mask_passwords");
                }
                if (a3.q) {
                    this.o = true;
                }
            }
        }
    }

    @Override // com.quantummetric.instrument.internal.cj.b
    public final void a(boolean z) {
        this.o = z;
    }

    @Override // com.quantummetric.instrument.internal.cj.b
    public final boolean a() {
        return this.o;
    }

    @Override // com.quantummetric.ui.internal.da
    final boolean a(View view) {
        if (!super.a(view)) {
            if (!((view instanceof TextView) && this.t != ((TextView) view).getCurrentTextColor())) {
                return false;
            }
        }
        return true;
    }

    final boolean a(TextView textView) {
        return (this.s || textView == null || !de.b(textView.getText().toString()) || textView.getHint() == null || de.b(textView.getHint().toString())) ? false : true;
    }

    @Override // com.quantummetric.instrument.internal.cj.b
    public final void b(boolean z) {
        this.p = z;
    }

    @Override // com.quantummetric.instrument.internal.cj.b
    public final boolean b() {
        return this.p;
    }

    @Override // com.quantummetric.instrument.internal.cj.b
    public final boolean c() {
        return this.e;
    }

    @Override // com.quantummetric.instrument.internal.cj.b
    public final void d() {
        this.e = true;
    }

    @Override // com.quantummetric.instrument.internal.cj.b
    public final boolean e() {
        return this.F;
    }

    @Override // com.quantummetric.instrument.internal.cj.b
    public final void f() {
        this.F = true;
    }

    @Override // com.quantummetric.instrument.internal.cj.b
    public final boolean g() {
        return this.r;
    }

    @Override // com.quantummetric.instrument.internal.cj.b
    public final Object h() {
        return this.B.get();
    }

    @Override // com.quantummetric.instrument.internal.cj.b
    public final short[] i() {
        return this.A;
    }

    @Override // com.quantummetric.instrument.internal.cj.b
    public final boolean j() {
        return this.G;
    }

    final boolean k() {
        if (this.I <= 0 || !(this.B.get() instanceof TextView)) {
            return false;
        }
        boolean z = false;
        for (Drawable drawable : ((TextView) this.B.get()).getCompoundDrawables()) {
            if (drawable != null) {
                z = this.I != drawable.hashCode();
                if (z) {
                    break;
                }
            }
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x005d, code lost:
    
        if (b(r0) == false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void l() {
        /*
            r7 = this;
            java.lang.ref.WeakReference<android.view.View> r0 = r7.B
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            boolean r1 = r0 instanceof android.widget.TextView
            if (r1 == 0) goto L62
            android.widget.TextView r0 = (android.widget.TextView) r0
            android.graphics.drawable.Drawable[] r1 = r0.getCompoundDrawables()
            java.lang.String[] r2 = r7.x
            if (r2 != 0) goto L1b
            int r2 = r1.length
            java.lang.String[] r2 = new java.lang.String[r2]
            r7.x = r2
        L1b:
            int r2 = r1.length
            r3 = 0
            r4 = r3
        L1e:
            r5 = 1
            if (r4 >= r2) goto L31
            r6 = r1[r4]
            if (r6 == 0) goto L2e
            r7.q = r5
            int r1 = r6.hashCode()
            r7.I = r1
            goto L31
        L2e:
            int r4 = r4 + 1
            goto L1e
        L31:
            boolean r1 = r7.q
            if (r1 != 0) goto L62
            boolean r1 = r0 instanceof android.widget.CompoundButton
            if (r1 == 0) goto L44
            r1 = r0
            android.widget.CompoundButton r1 = (android.widget.CompoundButton) r1
            android.graphics.drawable.Drawable r1 = r1.getButtonDrawable()
            if (r1 == 0) goto L44
            r1 = r5
            goto L45
        L44:
            r1 = r3
        L45:
            if (r1 != 0) goto L5f
            boolean r1 = r0 instanceof android.widget.CheckedTextView
            if (r1 == 0) goto L56
            r1 = r0
            android.widget.CheckedTextView r1 = (android.widget.CheckedTextView) r1
            android.graphics.drawable.Drawable r1 = r1.getCheckMarkDrawable()
            if (r1 == 0) goto L56
            r1 = r5
            goto L57
        L56:
            r1 = r3
        L57:
            if (r1 != 0) goto L5f
            boolean r0 = b(r0)
            if (r0 == 0) goto L60
        L5f:
            r3 = r5
        L60:
            r7.q = r3
        L62:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.cz.l():void");
    }

    final View m() {
        View view;
        View view2;
        TextView textView = (TextView) this.B.get();
        if (!(textView instanceof EditText) || (view = (View) textView.getParent()) == null || (view2 = (View) view.getParent()) == null || !ag.c(view2)) {
            return null;
        }
        return view2;
    }
}
