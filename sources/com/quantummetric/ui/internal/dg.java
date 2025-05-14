package com.quantummetric.ui.internal;

import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AlertDialogLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.quantummetric.ui.internal.ce;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* loaded from: classes5.dex */
class dg extends b {
    protected WeakReference<View> F;

    public dg() {
    }

    public dg(View view) {
        this.F = new WeakReference<>(view);
        this.b = -1;
        View view2 = this.F.get();
        if (view2 != null && view2.getParent() != null && view2.getParent().getParent() != null) {
            this.b = ((ViewGroup) view2.getParent()).indexOfChild(view2);
        }
        this.f = view.hashCode();
        this.g = view.getClass().getSimpleName();
        if (view instanceof ViewGroup) {
            this.z = true;
            this.s = true;
        }
        ViewParent parent = view.getParent();
        this.r = (parent == null || parent.getParent() != null || (parent instanceof View)) ? false : true;
    }

    static dg a(da daVar) {
        dg fVar;
        if (daVar == null || daVar.B.get() == null) {
            return null;
        }
        View view = daVar.B.get();
        if (view instanceof TextView) {
            fVar = new ck(view);
        } else if (view instanceof ImageView) {
            fVar = new au(view);
        } else if (cc.a(view)) {
            fVar = new cc(view);
        } else if (ag.c(view)) {
            fVar = new ci(view);
        } else if (ae.a(view)) {
            fVar = new ae(view);
        } else if (view instanceof WebView) {
            fVar = new dj(view);
        } else if (view instanceof ProgressBar) {
            fVar = new bq(view);
        } else {
            fVar = view != null && ((ag.d && (view instanceof AlertDialogLayout)) || view.getClass().getName().contains("internal.widget.AlertDialogLayout")) ? new f(view) : ag.l(view) ? new bw(view) : ag.k(view) ? new bv(view) : ag.m(view) ? new v(view) : new dg(view);
        }
        fVar.e = daVar;
        fVar.j();
        fVar.m();
        fVar.d = daVar.m;
        if (fVar instanceof ck) {
            ck ckVar = (ck) fVar;
            cz czVar = (cz) daVar;
            ckVar.A = czVar.x;
            ckVar.B = czVar.y;
            ckVar.C = czVar.z;
        }
        return fVar;
    }

    private void a(View view) {
        Drawable background = view.getBackground();
        if (background instanceof InsetDrawable) {
            Rect b = de.b(background);
            if (!de.a(b) || this.i < b.left || this.h < b.top) {
                return;
            }
            this.h -= b.top;
            this.i -= b.left;
        }
    }

    private void a(View view, ViewParent viewParent) {
        if (((cx) df.i.get(Integer.valueOf(viewParent.hashCode()))) != null) {
            this.i = de.b(view.getLeft() + r4.s);
            this.h = de.b(view.getTop() + r4.t);
        }
    }

    static boolean a(Drawable drawable, String str) {
        Drawable a2;
        while (true) {
            if (drawable instanceof StateListDrawable) {
                drawable = drawable.getCurrent();
            } else {
                if (!(drawable instanceof LayerDrawable) || (a2 = de.a((LayerDrawable) drawable)) == null) {
                    break;
                }
                drawable = a2;
            }
        }
        return (drawable instanceof BitmapDrawable) || (drawable instanceof NinePatchDrawable) || (drawable instanceof VectorDrawable) || ag.a(str) || (drawable instanceof ah);
    }

    @Override // com.quantummetric.ui.internal.b
    public void a(ar arVar) {
        if (!this.w || this.F.get() == null) {
            return;
        }
        d(arVar);
    }

    protected void a(bp bpVar) {
        if (this.e instanceof da) {
            da daVar = (da) this.e;
            Drawable drawable = daVar.C.get();
            if (!this.w || drawable == null) {
                return;
            }
            bpVar.a(daVar, drawable, this.d, new h<String>() { // from class: com.quantummetric.instrument.internal.dg.1
                @Override // com.quantummetric.ui.internal.h
                public final /* bridge */ /* synthetic */ void a(String str) {
                    dg.this.a(str);
                }
            });
        }
    }

    @Override // com.quantummetric.ui.internal.b
    protected final void a(String str) {
        this.d = str;
        this.e.m = str;
        da daVar = (da) this.e;
        Drawable drawable = daVar.C.get();
        if (de.b(str) && this.j == 0 && this.k == 0 && !ah.a(drawable)) {
            daVar.C = new WeakReference<>(null);
        }
    }

    boolean a(Drawable drawable) {
        return a(drawable, this.g);
    }

    @Override // com.quantummetric.ui.internal.b
    public void j() {
        int childDrawingOrder;
        ce.a aVar;
        k();
        View view = this.F.get();
        Drawable drawable = null;
        ah ahVar = null;
        if (view != null) {
            Drawable background = view.getBackground();
            ce a2 = ce.a();
            if (!a2.f162a.isEmpty()) {
                Iterator<ce.a> it = a2.f162a.iterator();
                while (it.hasNext()) {
                    aVar = it.next();
                    boolean z = !de.b(aVar.f163a) && aVar.f163a.equals(de.a(view));
                    if (!z) {
                        z = !de.b(aVar.b) && aVar.b.equals(view.getClass().getSimpleName());
                    }
                    if (z) {
                        break;
                    }
                }
            }
            aVar = null;
            if (aVar != null) {
                Iterator<ah> it2 = ce.a().b.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    ah next = it2.next();
                    if (next.f37a.get() == view) {
                        ahVar = next;
                        break;
                    }
                }
                if (ahVar == null) {
                    ah ahVar2 = new ah(view, aVar);
                    ce.a().b.add(ahVar2);
                    drawable = ahVar2;
                } else if (ahVar.c) {
                    ahVar.a(view);
                    drawable = ahVar;
                } else {
                    ahVar.setBounds(0, 0, view.getWidth(), view.getHeight());
                    drawable = ahVar;
                }
            } else {
                drawable = background;
            }
        }
        if (view != null && drawable != null) {
            this.w = a(drawable);
            boolean z2 = this.w && de.a(drawable);
            if (!this.w) {
                this.l = de.a(view, this.v, this);
            } else if (this.e instanceof da) {
                ((da) this.e).C = new WeakReference<>(drawable);
            }
            if (z2) {
                this.x = true;
                Drawable drawable2 = ((LayerDrawable) drawable).getDrawable(0);
                if (drawable2 != null) {
                    this.l = de.a(drawable2, this.v, this);
                }
            }
        }
        if (this.r && view != null && aa.q != 0 && view.getTag(aa.q) != null) {
            this.l = aa.r;
        }
        View view2 = this.F.get();
        if (view2 != null) {
            this.n = view2.getAlpha();
            this.o = view2.getRotation();
            this.f98a = view2.getVisibility() != 0;
            if (aa.u) {
                this.m = (int) (view2.getZ() > 0.0f ? view2.getZ() : view2.getElevation());
            }
            if (!aa.E || Build.VERSION.SDK_INT < 29 || !(view2.getParent() instanceof ViewGroup) || (childDrawingOrder = ((ViewGroup) view2.getParent()).getChildDrawingOrder(this.b)) < 0 || childDrawingOrder == this.b) {
                return;
            }
            this.m = childDrawingOrder;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.quantummetric.ui.internal.b
    final void k() {
        View view = this.F.get();
        if (view != null) {
            ViewParent parent = view.getParent();
            if (this.r) {
                view.getLocationOnScreen(new int[]{0, 0});
                this.i = de.b(r4[0]);
                this.h = de.b(r4[1]);
                this.e.j = r4[0];
                this.e.k = r4[1];
            } else if ((parent instanceof View) && ag.a((View) parent)) {
                try {
                    if (df.i != null) {
                        a(view, parent);
                    }
                    RecyclerView.LayoutManager layoutManager = ((RecyclerView) parent).getLayoutManager();
                    if (layoutManager != null) {
                        ((da) this.e).D = layoutManager.getPosition(view);
                    }
                } catch (Throwable unused) {
                }
            } else if (parent instanceof AbsListView) {
                a(view, parent);
            } else {
                this.h = de.b(view.getY());
                this.i = de.b(view.getX());
            }
            this.j = de.b(view.getWidth());
            this.k = de.b(view.getHeight());
            this.p = view.getScaleX();
            this.q = view.getScaleY();
            if (this.e != null && !this.e.f && this.j != 0 && this.k != 0) {
                this.e.f = true;
            }
            if (parent instanceof View) {
                View view2 = (View) parent;
                if (!ae.a(view2) || this.j <= 0 || this.k <= 0) {
                    return;
                }
                a(view2);
            }
        }
    }
}
