package sdk.pendo.io.a8;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import sdk.pendo.io.a8.c;
import sdk.pendo.io.g9.q0;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.views.custom.PendoFloatingVisualGuideView;
import sdk.pendo.io.views.custom.PendoLinearLayout;

/* loaded from: classes6.dex */
public class e extends PendoFloatingVisualGuideView {
    private static final String p = "e";
    private static final List<Integer> q = new ArrayList(PendoFloatingVisualGuideView.GRAVITY_LIST);

    /* renamed from: a, reason: collision with root package name */
    private final int[] f863a;
    private int[] b;
    private Rect c;
    private Rect d;
    private Rect e;
    private final boolean f;
    private final Point g;
    private final int h;
    private final int i;
    private int j;
    private a k;
    private boolean l;
    protected ViewTreeObserver.OnGlobalLayoutListener m;
    private final ViewTreeObserver.OnPreDrawListener n;
    private final ViewTreeObserver.OnGlobalLayoutListener o;

    public e(Context context, c.a aVar) {
        super(context, aVar);
        int[] iArr = new int[2];
        this.f863a = iArr;
        this.d = new Rect();
        this.e = new Rect();
        this.g = new Point();
        this.j = 4;
        this.n = new ViewTreeObserver.OnPreDrawListener() { // from class: sdk.pendo.io.a8.e$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                boolean a2;
                a2 = e.this.a();
                return a2;
            }
        };
        this.o = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: sdk.pendo.io.a8.e$$ExternalSyntheticLambda1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                e.this.b();
            }
        };
        this.h = aVar.caretWidthPx;
        this.i = aVar.caretHeightPx;
        this.f = aVar.getIsHideArrow();
        this.l = aVar.getIsRestrictToScreenEdges();
        ViewCompat.setAccessibilityPaneTitle(this, aVar.getPaneTitle());
        setClipChildren(false);
        setClipToPadding(false);
        final View anchorView = aVar.getAnchorView();
        if (anchorView != null) {
            this.c = new Rect();
            this.d = q0.a(anchorView);
            anchorView.getLocationInWindow(iArr);
            this.c.set(this.d);
            this.c.offsetTo(iArr[0], iArr[1]);
            this.mAnchorViewWeakRef = new WeakReference<>(anchorView);
            if (anchorView.getViewTreeObserver().isAlive()) {
                sdk.pendo.io.i9.a.f1211a.a(new Runnable() { // from class: sdk.pendo.io.a8.e$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.this.a(anchorView);
                    }
                });
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004f A[Catch: Exception -> 0x005a, TryCatch #0 {Exception -> 0x005a, blocks: (B:3:0x0001, B:5:0x0024, B:7:0x002e, B:9:0x0038, B:10:0x0040, B:11:0x0043, B:15:0x004f, B:17:0x0055, B:19:0x003a, B:21:0x003e), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean b(boolean r6, int r7, int r8, int r9, int r10) {
        /*
            r5 = this;
            r0 = 0
            android.graphics.Rect r1 = r5.mDrawRect     // Catch: java.lang.Exception -> L5a
            android.graphics.Rect r2 = r5.c     // Catch: java.lang.Exception -> L5a
            int r3 = r2.left     // Catch: java.lang.Exception -> L5a
            int r3 = r3 - r9
            int r3 = r3 - r7
            int r9 = r5.i     // Catch: java.lang.Exception -> L5a
            int r3 = r3 - r9
            int r9 = r2.centerY()     // Catch: java.lang.Exception -> L5a
            int r2 = r10 / 2
            int r9 = r9 - r2
            android.graphics.Rect r2 = r5.c     // Catch: java.lang.Exception -> L5a
            int r4 = r2.left     // Catch: java.lang.Exception -> L5a
            int r4 = r4 - r7
            int r7 = r2.centerY()     // Catch: java.lang.Exception -> L5a
            int r10 = r10 / 2
            int r7 = r7 + r10
            r1.set(r3, r9, r4, r7)     // Catch: java.lang.Exception -> L5a
            if (r6 == 0) goto L7b
            android.graphics.Rect r6 = r5.mScreenRectWithoutMargins     // Catch: java.lang.Exception -> L5a
            android.graphics.Rect r7 = r5.mDrawRect     // Catch: java.lang.Exception -> L5a
            boolean r6 = sdk.pendo.io.g9.k0.a(r6, r7)     // Catch: java.lang.Exception -> L5a
            if (r6 != 0) goto L7b
            android.graphics.Rect r6 = r5.mDrawRect     // Catch: java.lang.Exception -> L5a
            int r7 = r6.bottom     // Catch: java.lang.Exception -> L5a
            android.graphics.Rect r9 = r5.mScreenRectWithoutMargins     // Catch: java.lang.Exception -> L5a
            int r9 = r9.bottom     // Catch: java.lang.Exception -> L5a
            if (r7 <= r9) goto L3a
            int r9 = r9 - r7
            goto L40
        L3a:
            int r7 = r6.top     // Catch: java.lang.Exception -> L5a
            if (r7 >= r8) goto L43
            int r9 = r8 - r7
        L40:
            r6.offset(r0, r9)     // Catch: java.lang.Exception -> L5a
        L43:
            android.graphics.Rect r6 = r5.mDrawRect     // Catch: java.lang.Exception -> L5a
            int r7 = r6.left     // Catch: java.lang.Exception -> L5a
            android.graphics.Rect r8 = r5.mScreenRectWithoutMargins     // Catch: java.lang.Exception -> L5a
            int r9 = r8.left     // Catch: java.lang.Exception -> L5a
            if (r7 >= r9) goto L4f
            r6 = 1
            return r6
        L4f:
            int r7 = r6.right     // Catch: java.lang.Exception -> L5a
            int r8 = r8.right     // Catch: java.lang.Exception -> L5a
            if (r7 <= r8) goto L7b
            int r8 = r8 - r7
            r6.offset(r8, r0)     // Catch: java.lang.Exception -> L5a
            goto L7b
        L5a:
            r6 = move-exception
            java.lang.String r7 = r6.getMessage()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = sdk.pendo.io.a8.e.p
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.String r9 = " calculatePositionLeft"
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.Object[] r8 = new java.lang.Object[]{r8}
            sdk.pendo.io.logging.PendoLogger.w(r6, r7, r8)
        L7b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.a8.e.b(boolean, int, int, int, int):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004f A[Catch: Exception -> 0x005a, TryCatch #0 {Exception -> 0x005a, blocks: (B:3:0x0001, B:5:0x0024, B:7:0x002e, B:9:0x0038, B:10:0x0040, B:11:0x0043, B:15:0x004f, B:17:0x0055, B:19:0x003a, B:21:0x003e), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean c(boolean r7, int r8, int r9, int r10, int r11) {
        /*
            r6 = this;
            r0 = 0
            android.graphics.Rect r1 = r6.mDrawRect     // Catch: java.lang.Exception -> L5a
            android.graphics.Rect r2 = r6.c     // Catch: java.lang.Exception -> L5a
            int r3 = r2.right     // Catch: java.lang.Exception -> L5a
            int r3 = r3 + r8
            int r2 = r2.centerY()     // Catch: java.lang.Exception -> L5a
            int r4 = r11 / 2
            int r2 = r2 - r4
            android.graphics.Rect r4 = r6.c     // Catch: java.lang.Exception -> L5a
            int r5 = r4.right     // Catch: java.lang.Exception -> L5a
            int r5 = r5 + r10
            int r10 = r6.i     // Catch: java.lang.Exception -> L5a
            int r5 = r5 + r10
            int r5 = r5 + r8
            int r8 = r4.centerY()     // Catch: java.lang.Exception -> L5a
            int r11 = r11 / 2
            int r8 = r8 + r11
            r1.set(r3, r2, r5, r8)     // Catch: java.lang.Exception -> L5a
            if (r7 == 0) goto L7b
            android.graphics.Rect r7 = r6.mScreenRectWithoutMargins     // Catch: java.lang.Exception -> L5a
            android.graphics.Rect r8 = r6.mDrawRect     // Catch: java.lang.Exception -> L5a
            boolean r7 = sdk.pendo.io.g9.k0.a(r7, r8)     // Catch: java.lang.Exception -> L5a
            if (r7 != 0) goto L7b
            android.graphics.Rect r7 = r6.mDrawRect     // Catch: java.lang.Exception -> L5a
            int r8 = r7.bottom     // Catch: java.lang.Exception -> L5a
            android.graphics.Rect r10 = r6.mScreenRectWithoutMargins     // Catch: java.lang.Exception -> L5a
            int r10 = r10.bottom     // Catch: java.lang.Exception -> L5a
            if (r8 <= r10) goto L3a
            int r10 = r10 - r8
            goto L40
        L3a:
            int r8 = r7.top     // Catch: java.lang.Exception -> L5a
            if (r8 >= r9) goto L43
            int r10 = r9 - r8
        L40:
            r7.offset(r0, r10)     // Catch: java.lang.Exception -> L5a
        L43:
            android.graphics.Rect r7 = r6.mDrawRect     // Catch: java.lang.Exception -> L5a
            int r8 = r7.right     // Catch: java.lang.Exception -> L5a
            android.graphics.Rect r9 = r6.mScreenRectWithoutMargins     // Catch: java.lang.Exception -> L5a
            int r10 = r9.right     // Catch: java.lang.Exception -> L5a
            if (r8 <= r10) goto L4f
            r7 = 1
            return r7
        L4f:
            int r8 = r7.left     // Catch: java.lang.Exception -> L5a
            int r9 = r9.left     // Catch: java.lang.Exception -> L5a
            if (r8 >= r9) goto L7b
            int r9 = r9 - r8
            r7.offset(r9, r0)     // Catch: java.lang.Exception -> L5a
            goto L7b
        L5a:
            r7 = move-exception
            java.lang.String r8 = r7.getMessage()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = sdk.pendo.io.a8.e.p
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.String r10 = " calculatePositionRight"
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.String r9 = r9.toString()
            java.lang.Object[] r9 = new java.lang.Object[]{r9}
            sdk.pendo.io.logging.PendoLogger.w(r7, r8, r9)
        L7b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.a8.e.c(boolean, int, int, int, int):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004f A[Catch: Exception -> 0x005c, TryCatch #0 {Exception -> 0x005c, blocks: (B:3:0x0001, B:5:0x0026, B:7:0x0030, B:9:0x003a, B:10:0x0044, B:11:0x0047, B:15:0x004f, B:17:0x0057, B:19:0x003c, B:21:0x0042), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean d(boolean r6, int r7, int r8, int r9, int r10) {
        /*
            r5 = this;
            r0 = 0
            android.graphics.Rect r1 = r5.mDrawRect     // Catch: java.lang.Exception -> L5c
            android.graphics.Rect r2 = r5.c     // Catch: java.lang.Exception -> L5c
            int r2 = r2.centerX()     // Catch: java.lang.Exception -> L5c
            int r3 = r9 / 2
            int r2 = r2 - r3
            android.graphics.Rect r3 = r5.c     // Catch: java.lang.Exception -> L5c
            int r4 = r3.top     // Catch: java.lang.Exception -> L5c
            int r4 = r4 - r10
            int r4 = r4 - r7
            int r10 = r5.i     // Catch: java.lang.Exception -> L5c
            int r4 = r4 - r10
            int r10 = r3.centerX()     // Catch: java.lang.Exception -> L5c
            int r9 = r9 / 2
            int r10 = r10 + r9
            android.graphics.Rect r9 = r5.c     // Catch: java.lang.Exception -> L5c
            int r9 = r9.top     // Catch: java.lang.Exception -> L5c
            int r9 = r9 - r7
            r1.set(r2, r4, r10, r9)     // Catch: java.lang.Exception -> L5c
            if (r6 == 0) goto L7d
            android.graphics.Rect r6 = r5.mScreenRectWithoutMargins     // Catch: java.lang.Exception -> L5c
            android.graphics.Rect r7 = r5.mDrawRect     // Catch: java.lang.Exception -> L5c
            boolean r6 = sdk.pendo.io.g9.k0.a(r6, r7)     // Catch: java.lang.Exception -> L5c
            if (r6 != 0) goto L7d
            android.graphics.Rect r6 = r5.mDrawRect     // Catch: java.lang.Exception -> L5c
            int r7 = r6.right     // Catch: java.lang.Exception -> L5c
            android.graphics.Rect r9 = r5.mScreenRectWithoutMargins     // Catch: java.lang.Exception -> L5c
            int r10 = r9.right     // Catch: java.lang.Exception -> L5c
            if (r7 <= r10) goto L3c
            int r10 = r10 - r7
            goto L44
        L3c:
            int r7 = r6.left     // Catch: java.lang.Exception -> L5c
            int r9 = r9.left     // Catch: java.lang.Exception -> L5c
            if (r7 >= r9) goto L47
            int r10 = r9 - r7
        L44:
            r6.offset(r10, r0)     // Catch: java.lang.Exception -> L5c
        L47:
            android.graphics.Rect r6 = r5.mDrawRect     // Catch: java.lang.Exception -> L5c
            int r7 = r6.top     // Catch: java.lang.Exception -> L5c
            if (r7 >= r8) goto L4f
            r6 = 1
            return r6
        L4f:
            int r7 = r6.bottom     // Catch: java.lang.Exception -> L5c
            android.graphics.Rect r8 = r5.mScreenRectWithoutMargins     // Catch: java.lang.Exception -> L5c
            int r8 = r8.bottom     // Catch: java.lang.Exception -> L5c
            if (r7 <= r8) goto L7d
            int r8 = r8 - r7
            r6.offset(r0, r8)     // Catch: java.lang.Exception -> L5c
            goto L7d
        L5c:
            r6 = move-exception
            java.lang.String r7 = r6.getMessage()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = sdk.pendo.io.a8.e.p
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.String r9 = " calculatePositionTop"
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.Object[] r8 = new java.lang.Object[]{r8}
            sdk.pendo.io.logging.PendoLogger.w(r6, r7, r8)
        L7d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.a8.e.d(boolean, int, int, int, int):boolean");
    }

    private List<Integer> getGravitiesOrderedAccordingToPreference() {
        ArrayList arrayList = new ArrayList(q);
        try {
            arrayList.remove(this.mGravity);
            arrayList.add(0, Integer.valueOf(this.mGravity));
        } catch (Exception e) {
            PendoLogger.w(e, e.getMessage(), p + " getGravitiesOrderedAccordingToPreference");
        }
        return arrayList;
    }

    public void a(int i, int i2, int i3) {
        if (i3 == i) {
            return;
        }
        int paddingLeft = this.mGuideView.getPaddingLeft();
        int paddingTop = this.mGuideView.getPaddingTop();
        int paddingRight = this.mGuideView.getPaddingRight();
        int paddingBottom = this.mGuideView.getPaddingBottom();
        if (i3 == 0) {
            paddingRight -= i2;
        } else if (i3 == 1) {
            paddingLeft -= i2;
        } else if (i3 == 2) {
            paddingBottom -= i2;
        } else if (i3 == 3) {
            paddingTop -= i2;
        }
        if (i == 0) {
            paddingRight += i2;
            setTooltipPosition(0);
        } else if (i == 1) {
            paddingLeft += i2;
            setTooltipPosition(1);
        } else if (i == 2) {
            paddingBottom += i2;
            setTooltipPosition(2);
        } else if (i == 3) {
            paddingTop += i2;
            setTooltipPosition(3);
        } else if (i == 4) {
            setTooltipPosition(4);
        }
        this.mGuideView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    protected void e(final View view) {
        WeakReference<View> weakReference;
        if (view != null && (weakReference = this.mAnchorViewWeakRef) != null) {
            view = weakReference.get();
        }
        if (view == null || !view.getViewTreeObserver().isAlive()) {
            PendoLogger.e(p + " removePreDrawObserver failed", new Object[0]);
        } else {
            sdk.pendo.io.i9.a.f1211a.a(new Runnable() { // from class: sdk.pendo.io.a8.e$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.c(view);
                }
            });
        }
    }

    @Override // sdk.pendo.io.views.custom.PendoFloatingVisualGuideView
    public ViewGroup getViewGroupToTraverse() {
        return (ViewGroup) this.mGuideView;
    }

    @Override // sdk.pendo.io.views.custom.PendoFloatingVisualGuideView
    public boolean isAttached() {
        return this.mAttached;
    }

    @Override // sdk.pendo.io.views.custom.PendoFloatingVisualGuideView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mAttached) {
            super.onDraw(canvas);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (this.mAccessibilityManager.isTouchExplorationEnabled() && motionEvent.getPointerCount() == 1) {
            return onTouchEvent(sdk.pendo.io.g9.b.a(motionEvent));
        }
        return false;
    }

    @Override // sdk.pendo.io.views.custom.PendoFloatingVisualGuideView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View view;
        View view2 = this.mGuideView;
        if (view2 != null) {
            view2.layout(view2.getLeft(), this.mGuideView.getTop(), this.mGuideView.getMeasuredWidth(), this.mGuideView.getMeasuredHeight());
        }
        if (z) {
            WeakReference<View> weakReference = this.mAnchorViewWeakRef;
            if (weakReference != null && (view = weakReference.get()) != null) {
                this.e = q0.a(view);
                view.getLocationInWindow(this.f863a);
                Rect rect = this.e;
                int[] iArr = this.f863a;
                rect.offsetTo(iArr[0], iArr[1]);
                this.c.set(this.e);
            }
            Rect rect2 = this.mScreenRectWithoutMargins;
            float f = rect2.right - rect2.left;
            if (this.mGuideView == null || r3.getWidth() > f) {
                a(getGravitiesOrderedAccordingToPreference(), this.l, (int) f);
            } else {
                a(getGravitiesOrderedAccordingToPreference(), this.l);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i3 = 0;
        if (mode == 0) {
            size = 0;
        }
        if (mode2 == 0) {
            size2 = 0;
        }
        View view = this.mGuideView;
        if (view != null) {
            if (view.getVisibility() == 8) {
                size2 = 0;
                setMeasuredDimension(i3, size2);
            } else {
                this.mGuideView.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
            }
        }
        i3 = size;
        setMeasuredDimension(i3, size2);
    }

    @Override // sdk.pendo.io.views.custom.PendoFloatingVisualGuideView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        View view;
        if (!isAttached() || !isShown() || motionEvent.getActionMasked() != 0) {
            return false;
        }
        if (q0.a(motionEvent, this.mGuideView, this.mDialogMargin).booleanValue()) {
            return true;
        }
        if (this.k == null) {
            touchOutsideOfFloatingGuide();
            return !this.mTouchPassThrough;
        }
        if (!this.mSeeThrough || (view = this.mAnchorViewWeakRef.get()) == null || !q0.a(motionEvent, view, this.mDialogMargin).booleanValue()) {
            return true;
        }
        touchOutsideOfFloatingGuide();
        return false;
    }

    @Override // sdk.pendo.io.views.custom.PendoFloatingVisualGuideView
    public void removeFromParent() {
        ViewParent parent = getParent();
        if (parent == null || !isAttached()) {
            return;
        }
        c();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this);
        }
    }

    @Override // sdk.pendo.io.views.custom.PendoFloatingVisualGuideView
    protected void removeViewListeners(View view) {
        e(view);
        d(view);
        super.removeViewListeners(view);
    }

    void setBackDrop(a aVar) {
        this.k = aVar;
    }

    public void setTooltipPosition(int i) {
        this.j = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0051 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0053 A[Catch: Exception -> 0x005c, TryCatch #0 {Exception -> 0x005c, blocks: (B:3:0x0001, B:5:0x0026, B:7:0x0030, B:9:0x003a, B:10:0x0044, B:11:0x0047, B:15:0x0053, B:17:0x0057, B:19:0x003c, B:21:0x0042), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(boolean r6, int r7, int r8, int r9, int r10) {
        /*
            r5 = this;
            r0 = 0
            android.graphics.Rect r1 = r5.mDrawRect     // Catch: java.lang.Exception -> L5c
            android.graphics.Rect r2 = r5.c     // Catch: java.lang.Exception -> L5c
            int r2 = r2.centerX()     // Catch: java.lang.Exception -> L5c
            int r3 = r9 / 2
            int r2 = r2 - r3
            android.graphics.Rect r3 = r5.c     // Catch: java.lang.Exception -> L5c
            int r4 = r3.bottom     // Catch: java.lang.Exception -> L5c
            int r4 = r4 + r7
            int r3 = r3.centerX()     // Catch: java.lang.Exception -> L5c
            int r9 = r9 / 2
            int r3 = r3 + r9
            android.graphics.Rect r9 = r5.c     // Catch: java.lang.Exception -> L5c
            int r9 = r9.bottom     // Catch: java.lang.Exception -> L5c
            int r9 = r9 + r10
            int r9 = r9 + r7
            int r7 = r5.i     // Catch: java.lang.Exception -> L5c
            int r9 = r9 + r7
            r1.set(r2, r4, r3, r9)     // Catch: java.lang.Exception -> L5c
            if (r6 == 0) goto L7d
            android.graphics.Rect r6 = r5.mScreenRectWithoutMargins     // Catch: java.lang.Exception -> L5c
            android.graphics.Rect r7 = r5.mDrawRect     // Catch: java.lang.Exception -> L5c
            boolean r6 = sdk.pendo.io.g9.k0.a(r6, r7)     // Catch: java.lang.Exception -> L5c
            if (r6 != 0) goto L7d
            android.graphics.Rect r6 = r5.mDrawRect     // Catch: java.lang.Exception -> L5c
            int r7 = r6.right     // Catch: java.lang.Exception -> L5c
            android.graphics.Rect r9 = r5.mScreenRectWithoutMargins     // Catch: java.lang.Exception -> L5c
            int r10 = r9.right     // Catch: java.lang.Exception -> L5c
            if (r7 <= r10) goto L3c
            int r10 = r10 - r7
            goto L44
        L3c:
            int r7 = r6.left     // Catch: java.lang.Exception -> L5c
            int r9 = r9.left     // Catch: java.lang.Exception -> L5c
            if (r7 >= r9) goto L47
            int r10 = r9 - r7
        L44:
            r6.offset(r10, r0)     // Catch: java.lang.Exception -> L5c
        L47:
            android.graphics.Rect r6 = r5.mDrawRect     // Catch: java.lang.Exception -> L5c
            int r7 = r6.bottom     // Catch: java.lang.Exception -> L5c
            android.graphics.Rect r9 = r5.mScreenRectWithoutMargins     // Catch: java.lang.Exception -> L5c
            int r9 = r9.bottom     // Catch: java.lang.Exception -> L5c
            if (r7 <= r9) goto L53
            r6 = 1
            return r6
        L53:
            int r7 = r6.top     // Catch: java.lang.Exception -> L5c
            if (r7 >= r8) goto L7d
            int r8 = r8 - r7
            r6.offset(r0, r8)     // Catch: java.lang.Exception -> L5c
            goto L7d
        L5c:
            r6 = move-exception
            java.lang.String r7 = r6.getMessage()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = sdk.pendo.io.a8.e.p
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.String r9 = " calculatePositionBottom"
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.Object[] r8 = new java.lang.Object[]{r8}
            sdk.pendo.io.logging.PendoLogger.w(r6, r7, r8)
        L7d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.a8.e.a(boolean, int, int, int, int):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b() {
        if (!this.mAttached) {
            d(null);
            return;
        }
        WeakReference<View> weakReference = this.mAnchorViewWeakRef;
        if (weakReference != null) {
            View view = weakReference.get();
            boolean z = false;
            if (view == null) {
                PendoLogger.w(p + " AnchorView is null", new Object[0]);
                return;
            }
            this.e = q0.a(view);
            view.getLocationInWindow(this.f863a);
            if (this.e.equals(this.d)) {
                return;
            }
            this.d.set(this.e);
            Rect rect = this.e;
            int[] iArr = this.f863a;
            rect.offsetTo(iArr[0], iArr[1]);
            this.c.set(this.e);
            List<Integer> gravitiesOrderedAccordingToPreference = getGravitiesOrderedAccordingToPreference();
            int i = this.mGlobalLayoutCount + 1;
            this.mGlobalLayoutCount = i;
            if (i <= 1 && this.l) {
                z = true;
            }
            a(gravitiesOrderedAccordingToPreference, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        view.getViewTreeObserver().removeOnPreDrawListener(this.n);
    }

    protected void d(final View view) {
        WeakReference<View> weakReference;
        if (view != null && (weakReference = this.mAnchorViewWeakRef) != null) {
            view = weakReference.get();
        }
        if (view == null || !view.getViewTreeObserver().isAlive()) {
            PendoLogger.e(p + " removeGlobalLayoutObserver failed", new Object[0]);
        } else {
            sdk.pendo.io.i9.a.f1211a.a(new Runnable() { // from class: sdk.pendo.io.a8.e$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.b(view);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0055 A[Catch: Exception -> 0x0063, TryCatch #0 {Exception -> 0x0063, blocks: (B:2:0x0000, B:4:0x002b, B:6:0x0035, B:8:0x0040, B:9:0x0048, B:10:0x004b, B:12:0x0055, B:13:0x005f, B:17:0x0057, B:19:0x005d, B:21:0x0042, B:23:0x0046), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0057 A[Catch: Exception -> 0x0063, TryCatch #0 {Exception -> 0x0063, blocks: (B:2:0x0000, B:4:0x002b, B:6:0x0035, B:8:0x0040, B:9:0x0048, B:10:0x004b, B:12:0x0055, B:13:0x005f, B:17:0x0057, B:19:0x005d, B:21:0x0042, B:23:0x0046), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(boolean r5, int r6, int r7, int r8) {
        /*
            r4 = this;
            android.graphics.Rect r0 = r4.mDrawRect     // Catch: java.lang.Exception -> L63
            android.graphics.Rect r1 = r4.c     // Catch: java.lang.Exception -> L63
            int r1 = r1.centerX()     // Catch: java.lang.Exception -> L63
            int r2 = r7 / 2
            int r1 = r1 - r2
            android.graphics.Rect r2 = r4.c     // Catch: java.lang.Exception -> L63
            int r2 = r2.centerY()     // Catch: java.lang.Exception -> L63
            int r3 = r8 / 2
            int r2 = r2 - r3
            android.graphics.Rect r3 = r4.c     // Catch: java.lang.Exception -> L63
            int r3 = r3.centerX()     // Catch: java.lang.Exception -> L63
            int r7 = r7 / 2
            int r3 = r3 + r7
            android.graphics.Rect r7 = r4.c     // Catch: java.lang.Exception -> L63
            int r7 = r7.centerY()     // Catch: java.lang.Exception -> L63
            int r8 = r8 / 2
            int r7 = r7 + r8
            r0.set(r1, r2, r3, r7)     // Catch: java.lang.Exception -> L63
            if (r5 == 0) goto L84
            android.graphics.Rect r5 = r4.mScreenRectWithoutMargins     // Catch: java.lang.Exception -> L63
            android.graphics.Rect r7 = r4.mDrawRect     // Catch: java.lang.Exception -> L63
            boolean r5 = sdk.pendo.io.g9.k0.a(r5, r7)     // Catch: java.lang.Exception -> L63
            if (r5 != 0) goto L84
            android.graphics.Rect r5 = r4.mDrawRect     // Catch: java.lang.Exception -> L63
            int r7 = r5.bottom     // Catch: java.lang.Exception -> L63
            android.graphics.Rect r8 = r4.mScreenRectWithoutMargins     // Catch: java.lang.Exception -> L63
            int r8 = r8.bottom     // Catch: java.lang.Exception -> L63
            r0 = 0
            if (r7 <= r8) goto L42
            int r8 = r8 - r7
            goto L48
        L42:
            int r7 = r5.top     // Catch: java.lang.Exception -> L63
            if (r7 >= r6) goto L4b
            int r8 = r6 - r7
        L48:
            r5.offset(r0, r8)     // Catch: java.lang.Exception -> L63
        L4b:
            android.graphics.Rect r5 = r4.mDrawRect     // Catch: java.lang.Exception -> L63
            int r6 = r5.right     // Catch: java.lang.Exception -> L63
            android.graphics.Rect r7 = r4.mScreenRectWithoutMargins     // Catch: java.lang.Exception -> L63
            int r8 = r7.right     // Catch: java.lang.Exception -> L63
            if (r6 <= r8) goto L57
            int r8 = r8 - r6
            goto L5f
        L57:
            int r6 = r5.left     // Catch: java.lang.Exception -> L63
            int r7 = r7.left     // Catch: java.lang.Exception -> L63
            if (r6 >= r7) goto L84
            int r8 = r7 - r6
        L5f:
            r5.offset(r8, r0)     // Catch: java.lang.Exception -> L63
            goto L84
        L63:
            r5 = move-exception
            java.lang.String r6 = r5.getMessage()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = sdk.pendo.io.a8.e.p
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r8 = " calculatePositionCenter"
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r7 = new java.lang.Object[]{r7}
            sdk.pendo.io.logging.PendoLogger.w(r5, r6, r7)
        L84:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.a8.e.a(boolean, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(final List list, final boolean z) {
        sdk.pendo.io.i9.a.f1211a.a(new Runnable() { // from class: sdk.pendo.io.a8.e$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                e.this.b(list, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(List list, boolean z) {
        this.mGuideView.getViewTreeObserver().removeOnGlobalLayoutListener(this.m);
        a((List<Integer>) list, z);
    }

    private void c() {
        a aVar;
        View findViewById = getRootView().findViewById(R.id.content);
        if (!(findViewById instanceof ViewGroup) || (aVar = this.k) == null) {
            return;
        }
        ((ViewGroup) findViewById).removeView(aVar);
        this.k = null;
    }

    protected void a(List<Integer> list, boolean z) {
        int i;
        int i2;
        try {
            if (isAttached()) {
                if (list != null && !list.isEmpty()) {
                    int intValue = list.remove(0).intValue();
                    a aVar = this.k;
                    if (aVar != null) {
                        i = (int) aVar.getBackDropPaddingTop();
                        i2 = (int) this.k.getBackDropPaddingRight();
                    } else {
                        i = 0;
                        i2 = 0;
                    }
                    int i3 = this.mScreenRectWithoutMargins.top + this.mTopRule;
                    int width = this.mGuideView.getWidth();
                    int height = this.mGuideView.getHeight();
                    if (intValue == 3) {
                        if (a(z, i, i3, width, height)) {
                            PendoLogger.w(p + " not enough space for BOTTOM", new Object[0]);
                            a(list, z);
                            return;
                        }
                    } else if (intValue == 2) {
                        if (d(z, i, i3, width, height)) {
                            PendoLogger.w(p + " not enough space for TOP", new Object[0]);
                            a(list, z);
                            return;
                        }
                    } else if (intValue == 1) {
                        if (c(z, i2, i3, width, height)) {
                            PendoLogger.w(p + " not enough space for RIGHT", new Object[0]);
                            a(list, z);
                            return;
                        }
                    } else if (intValue == 0) {
                        if (b(z, i2, i3, width, height)) {
                            PendoLogger.w(p + " not enough space for LEFT", new Object[0]);
                            a(list, z);
                            return;
                        }
                    } else if (intValue == 4) {
                        a(z, i3, width, height);
                    }
                    if (intValue != this.mGravity) {
                        PendoLogger.w(p + " gravity changed from " + this.mGravity + " to " + intValue, new Object[0]);
                        this.mGravity = intValue;
                    }
                    Rect a2 = q0.a(this);
                    this.mGuideView.setTranslationX((this.mDrawRect.left - this.mDialogMargin) - a2.left);
                    this.mGuideView.setTranslationY((this.mDrawRect.top - this.mDialogMargin) - a2.top);
                    if (this.mDrawable != null) {
                        a(intValue, this.g);
                        d dVar = this.mDrawable;
                        int i4 = this.mBorderPadding / 2;
                        boolean z2 = this.f;
                        dVar.a(intValue, i4, z2 ? null : this.g, z2 ? 0 : this.i, z2 ? 0 : this.h);
                    }
                    Rect rect = this.mScreenRectWithoutMargins;
                    int i5 = rect.right - rect.left;
                    if (i5 > 0) {
                        ((PendoLinearLayout) this.mGuideView).setLayoutMaxWidth(i5);
                        return;
                    }
                    return;
                }
                PendoFloatingVisualGuideView.OnFloatingGuideListener onFloatingGuideListener = this.mFloatingGuideListener;
                if (onFloatingGuideListener != null) {
                    onFloatingGuideListener.onShowFailed(this);
                }
                setVisibility(8);
            }
        } catch (Exception e) {
            PendoLogger.w(e, e.getMessage(), p + " calculatePositions");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(int r8, android.graphics.Point r9) {
        /*
            r7 = this;
            r0 = 1
            r1 = 2
            r2 = 3
            if (r8 != r2) goto L15
            android.graphics.Rect r3 = r7.c     // Catch: java.lang.Exception -> L12
            int r3 = r3.centerX()     // Catch: java.lang.Exception -> L12
            r9.x = r3     // Catch: java.lang.Exception -> L12
            android.graphics.Rect r3 = r7.c     // Catch: java.lang.Exception -> L12
            int r3 = r3.bottom     // Catch: java.lang.Exception -> L12
            goto L4a
        L12:
            r8 = move-exception
            goto L82
        L15:
            if (r8 != r1) goto L24
            android.graphics.Rect r3 = r7.c     // Catch: java.lang.Exception -> L12
            int r3 = r3.centerX()     // Catch: java.lang.Exception -> L12
            r9.x = r3     // Catch: java.lang.Exception -> L12
            android.graphics.Rect r3 = r7.c     // Catch: java.lang.Exception -> L12
            int r3 = r3.top     // Catch: java.lang.Exception -> L12
            goto L4a
        L24:
            if (r8 != r0) goto L31
            android.graphics.Rect r3 = r7.c     // Catch: java.lang.Exception -> L12
            int r4 = r3.right     // Catch: java.lang.Exception -> L12
            r9.x = r4     // Catch: java.lang.Exception -> L12
        L2c:
            int r3 = r3.centerY()     // Catch: java.lang.Exception -> L12
            goto L4a
        L31:
            if (r8 != 0) goto L3a
            android.graphics.Rect r3 = r7.c     // Catch: java.lang.Exception -> L12
            int r4 = r3.left     // Catch: java.lang.Exception -> L12
            r9.x = r4     // Catch: java.lang.Exception -> L12
            goto L2c
        L3a:
            int r3 = r7.mGravity     // Catch: java.lang.Exception -> L12
            r4 = 4
            if (r3 != r4) goto L4c
            android.graphics.Rect r3 = r7.c     // Catch: java.lang.Exception -> L12
            int r3 = r3.centerX()     // Catch: java.lang.Exception -> L12
            r9.x = r3     // Catch: java.lang.Exception -> L12
            android.graphics.Rect r3 = r7.c     // Catch: java.lang.Exception -> L12
            goto L2c
        L4a:
            r9.y = r3     // Catch: java.lang.Exception -> L12
        L4c:
            int r3 = r9.x     // Catch: java.lang.Exception -> L12
            android.graphics.Rect r4 = r7.mDrawRect     // Catch: java.lang.Exception -> L12
            int r5 = r4.left     // Catch: java.lang.Exception -> L12
            int r6 = r7.mDialogMargin     // Catch: java.lang.Exception -> L12
            int r5 = r5 - r6
            int r3 = r3 - r5
            r9.x = r3     // Catch: java.lang.Exception -> L12
            int r5 = r9.y     // Catch: java.lang.Exception -> L12
            int r4 = r4.top     // Catch: java.lang.Exception -> L12
            int r4 = r4 - r6
            int r5 = r5 - r4
            r9.y = r5     // Catch: java.lang.Exception -> L12
            boolean r4 = r7.f     // Catch: java.lang.Exception -> L12
            if (r4 != 0) goto La2
            if (r8 == 0) goto L74
            if (r8 != r0) goto L69
            goto L74
        L69:
            if (r8 == r1) goto L6d
            if (r8 != r2) goto L7a
        L6d:
            int r0 = r7.mBorderPadding     // Catch: java.lang.Exception -> L12
            int r0 = r0 / r1
            int r3 = r3 - r0
            r9.x = r3     // Catch: java.lang.Exception -> L12
            goto L7a
        L74:
            int r0 = r7.mBorderPadding     // Catch: java.lang.Exception -> L12
            int r0 = r0 / r1
            int r5 = r5 - r0
            r9.y = r5     // Catch: java.lang.Exception -> L12
        L7a:
            int r9 = r7.i     // Catch: java.lang.Exception -> L12
            int r0 = r7.j     // Catch: java.lang.Exception -> L12
            r7.a(r8, r9, r0)     // Catch: java.lang.Exception -> L12
            goto La2
        L82:
            java.lang.String r9 = r8.getMessage()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = sdk.pendo.io.a8.e.p
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = " getAnchorPoint"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            sdk.pendo.io.logging.PendoLogger.w(r8, r9, r0)
        La2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.a8.e.a(int, android.graphics.Point):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
    
        if (r3 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0056, code lost:
    
        r3.onShowFailed(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0054, code lost:
    
        if (r3 != null) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ boolean a() {
        /*
            r6 = this;
            boolean r0 = r6.mAttached
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L26
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = sdk.pendo.io.a8.e.p
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r3 = " onPreDraw. not attached"
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r2 = new java.lang.Object[r2]
            sdk.pendo.io.logging.PendoLogger.w(r0, r2)
            r0 = 0
            r6.e(r0)
            goto Lb7
        L26:
            java.lang.ref.WeakReference<android.view.View> r0 = r6.mAnchorViewWeakRef
            if (r0 == 0) goto Lb7
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto Lb7
            java.lang.ref.WeakReference<android.view.View> r0 = r6.mAnchorViewWeakRef
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            boolean r3 = sdk.pendo.io.g9.q0.a(r0, r2)
            if (r3 != 0) goto L43
            sdk.pendo.io.views.custom.PendoFloatingVisualGuideView$OnFloatingGuideListener r3 = r6.mFloatingGuideListener
            if (r3 == 0) goto L59
            goto L56
        L43:
            android.view.accessibility.AccessibilityNodeInfo r3 = android.view.accessibility.AccessibilityNodeInfo.obtain()
            r0.onInitializeAccessibilityNodeInfo(r3)
            if (r3 == 0) goto L59
            boolean r3 = r3.isVisibleToUser()
            if (r3 != 0) goto L59
            sdk.pendo.io.views.custom.PendoFloatingVisualGuideView$OnFloatingGuideListener r3 = r6.mFloatingGuideListener
            if (r3 == 0) goto L59
        L56:
            r3.onShowFailed(r6)
        L59:
            int[] r3 = r6.f863a
            r0.getLocationInWindow(r3)
            int[] r0 = r6.b
            if (r0 != 0) goto L6e
            int[] r0 = r6.f863a
            r3 = r0[r2]
            r0 = r0[r1]
            int[] r0 = new int[]{r3, r0}
            r6.b = r0
        L6e:
            android.view.View r0 = r6.mGuideView
            if (r0 == 0) goto L88
            int[] r3 = r6.f863a
            r3 = r3[r2]
            int[] r4 = r6.b
            r4 = r4[r2]
            if (r3 == r4) goto L88
            int r3 = r3 - r4
            float r3 = (float) r3
            float r4 = r0.getTranslationX()
            float r3 = r3 + r4
            r0.setTranslationX(r3)
            r0 = r1
            goto L89
        L88:
            r0 = r2
        L89:
            android.view.View r3 = r6.mGuideView
            if (r3 == 0) goto La2
            int[] r4 = r6.f863a
            r4 = r4[r1]
            int[] r5 = r6.b
            r5 = r5[r1]
            if (r4 == r5) goto La2
            int r4 = r4 - r5
            float r0 = (float) r4
            float r4 = r3.getTranslationY()
            float r0 = r0 + r4
            r3.setTranslationY(r0)
            r0 = r1
        La2:
            int[] r3 = r6.b
            int[] r4 = r6.f863a
            r5 = r4[r2]
            r3[r2] = r5
            r2 = r4[r1]
            r3[r1] = r2
            if (r0 == 0) goto Lb7
            sdk.pendo.io.a8.a r0 = r6.k
            if (r0 == 0) goto Lb7
            r0.b()
        Lb7:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.a8.e.a():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.o);
        view.getViewTreeObserver().addOnPreDrawListener(this.n);
        view.addOnAttachStateChangeListener(this.mAnchorViewAttachedStateListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i) {
        this.mGuideView.getViewTreeObserver().addOnGlobalLayoutListener(this.m);
        ((PendoLinearLayout) this.mGuideView).setLayoutMaxWidth(i);
        this.mGuideView.requestLayout();
    }

    private void a(final List<Integer> list, final boolean z, final int i) {
        if (i <= 0) {
            return;
        }
        try {
            this.m = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: sdk.pendo.io.a8.e$$ExternalSyntheticLambda5
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    e.this.c(list, z);
                }
            };
            sdk.pendo.io.i9.a.f1211a.a(new Runnable() { // from class: sdk.pendo.io.a8.e$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.a(i);
                }
            });
        } catch (Exception e) {
            PendoLogger.w(e, e.getMessage(), p + " resizeAndCalcPositions");
        }
    }
}
