package sdk.pendo.io.views.custom;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.react.uimanager.ViewProps;
import io.sentry.protocol.ViewHierarchyNode;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.a8.d;
import sdk.pendo.io.actions.GuideTapOnManager;
import sdk.pendo.io.actions.PendoBannerGuideManager;
import sdk.pendo.io.g9.j0;
import sdk.pendo.io.g9.q0;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.n.a;
import sdk.pendo.io.views.custom.PendoFloatingVisualGuideView;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001-B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0007J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000eH\u0007J\b\u0010\u0015\u001a\u00020\u0016H\u0017J\b\u0010\u0017\u001a\u00020\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0018H\u0014J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J0\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000eH\u0014J\u0018\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000eH\u0014J\u0010\u0010&\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0017J\u0018\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000eH\u0017J\b\u0010+\u001a\u00020\u0018H\u0016J\b\u0010,\u001a\u00020\u0018H\u0016R\u0011\u0010\u0007\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006."}, d2 = {"Lsdk/pendo/io/views/custom/PendoBannerView;", "Lsdk/pendo/io/views/custom/PendoFloatingVisualGuideView;", "context", "Landroid/content/Context;", "builder", "Lsdk/pendo/io/actions/PendoBannerGuideManager$Builder;", "(Landroid/content/Context;Lsdk/pendo/io/actions/PendoBannerGuideManager$Builder;)V", "rootViewWindowInsets", "Landroidx/core/graphics/Insets;", "getRootViewWindowInsets", "()Landroidx/core/graphics/Insets;", "checkForManualScreenOrientation", "", "width", "", "height", "getBannerChildMeasureSpec", "myWidth", "getMaxWidthByCalculation", "guideViewRight", "guideViewLeft", "getViewGroupToTraverse", "Landroid/view/ViewGroup;", "initializeView", "", "onDetachedFromWindow", "onHoverEvent", "event", "Landroid/view/MotionEvent;", ViewProps.ON_LAYOUT, "changed", ViewProps.LEFT, ViewProps.TOP, ViewProps.RIGHT, ViewProps.BOTTOM, "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTouchEvent", "onVisibilityChanged", "changedView", "Landroid/view/View;", ViewHierarchyNode.JsonKeys.VISIBILITY, "removeFromParent", "show", "Companion", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PendoBannerView extends PendoFloatingVisualGuideView {
    private static final String TAG = "PendoBannerView";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PendoBannerView(Context context, PendoBannerGuideManager.Builder builder) {
        super(context, builder);
        PendoFloatingVisualGuideView.OnFloatingGuideListener onFloatingGuideListener;
        Intrinsics.checkNotNullParameter(builder, "builder");
        try {
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
            this.mRootView.onInitializeAccessibilityNodeInfo(obtain);
            if (obtain != null && !obtain.isVisibleToUser() && (onFloatingGuideListener = this.mFloatingGuideListener) != null) {
                onFloatingGuideListener.onShowFailed(this);
            }
            this.mAnchorViewWeakRef = new WeakReference<>(this.mRootView);
            View rootView = builder.getRootView();
            if (rootView != null && rootView.getViewTreeObserver().isAlive()) {
                rootView.addOnAttachStateChangeListener(this.mAnchorViewAttachedStateListener);
            }
            j0.b(builder.getPaneTitle(), new Function1<String, Unit>() { // from class: sdk.pendo.io.views.custom.PendoBannerView.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ViewCompat.setAccessibilityPaneTitle(PendoBannerView.this, it);
                }
            });
            View view = this.mGuideView;
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) view).setDescendantFocusability(131072);
        } catch (Exception e) {
            PendoLogger.w(e, e.getMessage(), TAG + " init");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x004e, code lost:
    
        if (r0.intValue() != 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0042, code lost:
    
        if (r0.intValue() != 3) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0044, code lost:
    
        if (r5 >= r6) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0046, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0038, code lost:
    
        if (r0.intValue() != 1) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean checkForManualScreenOrientation(int r5, int r6) {
        /*
            r4 = this;
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L5d
            r1 = 30
            if (r0 < r1) goto Lf
            android.content.Context r0 = r4.getContext()     // Catch: java.lang.Exception -> L5d
            android.view.Display r0 = r0.getDisplay()     // Catch: java.lang.Exception -> L5d
            goto L24
        Lf:
            android.content.Context r0 = r4.getContext()     // Catch: java.lang.Exception -> L5d
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch: java.lang.Exception -> L5d
            java.lang.String r1 = "null cannot be cast to non-null type android.view.WindowManager"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)     // Catch: java.lang.Exception -> L5d
            android.view.WindowManager r0 = (android.view.WindowManager) r0     // Catch: java.lang.Exception -> L5d
            android.view.Display r0 = r0.getDefaultDisplay()     // Catch: java.lang.Exception -> L5d
        L24:
            if (r0 == 0) goto L2f
            int r0 = r0.getRotation()     // Catch: java.lang.Exception -> L5d
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Exception -> L5d
            goto L30
        L2f:
            r0 = 0
        L30:
            r1 = 1
            if (r0 != 0) goto L34
            goto L3a
        L34:
            int r2 = r0.intValue()     // Catch: java.lang.Exception -> L5d
            if (r2 == r1) goto L44
        L3a:
            if (r0 != 0) goto L3d
            goto L47
        L3d:
            int r2 = r0.intValue()     // Catch: java.lang.Exception -> L5d
            r3 = 3
            if (r2 != r3) goto L47
        L44:
            if (r5 >= r6) goto L47
            return r1
        L47:
            if (r0 != 0) goto L4a
            goto L50
        L4a:
            int r2 = r0.intValue()     // Catch: java.lang.Exception -> L5d
            if (r2 == 0) goto L5a
        L50:
            if (r0 != 0) goto L53
            goto L68
        L53:
            int r0 = r0.intValue()     // Catch: java.lang.Exception -> L5d
            r2 = 2
            if (r0 != r2) goto L68
        L5a:
            if (r6 >= r5) goto L68
            return r1
        L5d:
            java.lang.String r5 = sdk.pendo.io.views.custom.PendoBannerView.TAG
            java.lang.String r6 = "checkForScreenRotationDimensions failed, returning original values"
            java.lang.Object[] r6 = new java.lang.Object[]{r6}
            sdk.pendo.io.logging.PendoLogger.w(r5, r6)
        L68:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.views.custom.PendoBannerView.checkForManualScreenOrientation(int, int):boolean");
    }

    public final int getBannerChildMeasureSpec(int myWidth) {
        int i;
        View view = this.mGuideView;
        if (view != null) {
            Class<?> cls = view.getClass();
            if (Intrinsics.areEqual(cls, PendoScrollView.class)) {
                i = ((PendoScrollView) view).getLayoutMaxWidth();
            } else if (Intrinsics.areEqual(cls, PendoLinearLayout.class)) {
                i = ((PendoLinearLayout) view).getLayoutMaxWidth();
            } else {
                PendoLogger.w(TAG, "Can't resolve the banner's view class");
            }
            return View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtMost(myWidth, i), 1073741824);
        }
        i = myWidth;
        return View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtMost(myWidth, i), 1073741824);
    }

    public final int getMaxWidthByCalculation(int guideViewRight, int guideViewLeft) {
        int layoutMaxWidth;
        View view = this.mGuideView;
        if (view == null) {
            return 0;
        }
        if (view instanceof PendoLinearLayout) {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type sdk.pendo.io.views.custom.PendoLinearLayout");
            layoutMaxWidth = ((PendoLinearLayout) view).getLayoutMaxWidth();
        } else {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type sdk.pendo.io.views.custom.PendoScrollView");
            layoutMaxWidth = ((PendoScrollView) view).getLayoutMaxWidth();
        }
        if (layoutMaxWidth == Integer.MAX_VALUE) {
            return 0;
        }
        return ((guideViewRight - guideViewLeft) - layoutMaxWidth) / 2;
    }

    public final Insets getRootViewWindowInsets() {
        try {
            WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(getRootView());
            if (rootWindowInsets != null) {
                Insets insets = rootWindowInsets.getInsets(WindowInsetsCompat.Type.systemBars());
                Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
                return insets;
            }
        } catch (Exception unused) {
            PendoLogger.w(TAG, "Unable to calculate rootWindowInsets");
        }
        Insets NONE = Insets.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    @Override // sdk.pendo.io.views.custom.PendoFloatingVisualGuideView
    public ViewGroup getViewGroupToTraverse() {
        View view = this.mGuideView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) view;
        View childAt = viewGroup.getChildAt(0);
        ViewGroup viewGroup2 = childAt instanceof ViewGroup ? (ViewGroup) childAt : null;
        return viewGroup2 == null ? viewGroup : viewGroup2;
    }

    @Override // sdk.pendo.io.views.custom.PendoFloatingVisualGuideView
    protected void initializeView() {
        if (!isAttached() || this.mInitialized || this.mGuideView == null) {
            return;
        }
        this.mInitialized = true;
        this.mGuideView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        if (this.mDrawable != null) {
            int paddingLeft = this.mGuideView.getPaddingLeft() + this.mBorderPadding;
            int paddingTop = this.mGuideView.getPaddingTop() + this.mBorderPadding;
            int paddingRight = this.mGuideView.getPaddingRight() + this.mBorderPadding;
            int paddingBottom = this.mGuideView.getPaddingBottom() + this.mBorderPadding;
            int i = this.mGravity;
            if (i == 2) {
                paddingTop += getRootViewWindowInsets().top;
            } else if (i == 3) {
                paddingBottom += getRootViewWindowInsets().bottom;
            }
            this.mGuideView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
        addView(this.mGuideView);
        setVisibility(4);
    }

    @Override // sdk.pendo.io.views.custom.PendoFloatingVisualGuideView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        PendoInternal.x().f();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Boolean a2 = q0.a(event, this.mGuideView, this.mDialogMargin);
        Intrinsics.checkNotNullExpressionValue(a2, "isClickTouchOrHoverInsideView(...)");
        if (a2.booleanValue()) {
            return true;
        }
        return super.onHoverEvent(event);
    }

    @Override // sdk.pendo.io.views.custom.PendoFloatingVisualGuideView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int measuredHeight;
        int i;
        int i2;
        try {
            if (this.mGuideView == null) {
                return;
            }
            Insets rootViewWindowInsets = getRootViewWindowInsets();
            int i3 = left + this.mFloatingGuideMarginLeftPx + rootViewWindowInsets.left;
            int i4 = (right - this.mFloatingGuideMarginRightPx) - rootViewWindowInsets.right;
            int maxWidthByCalculation = getMaxWidthByCalculation(i4, i3);
            int i5 = i3 + maxWidthByCalculation;
            int i6 = i4 - maxWidthByCalculation;
            int i7 = this.mGravity;
            if (i7 == 3) {
                measuredHeight = (bottom - top) - this.mGuideView.getMeasuredHeight();
            } else {
                if (i7 == 4) {
                    i = ((bottom - top) - this.mGuideView.getMeasuredHeight()) / 2;
                    i2 = this.mGuideView.getMeasuredHeight() + i;
                    this.mGuideView.layout(i5, i, i6, i2);
                }
                measuredHeight = top + this.mFloatingGuideMarginTopPx;
                bottom = this.mGuideView.getMeasuredHeight();
            }
            i2 = bottom - this.mFloatingGuideMarginBottomPx;
            i = measuredHeight;
            this.mGuideView.layout(i5, i, i6, i2);
        } catch (Exception e) {
            PendoLogger.w(e, e.getMessage(), TAG + " onLayout");
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        if (checkForManualScreenOrientation(size, size2)) {
            PendoLogger.d(TAG, "Orientation change was not detected alone.");
            removeFromParent();
            return;
        }
        int i = 0;
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
                setMeasuredDimension(i, size2);
            } else {
                Insets rootViewWindowInsets = getRootViewWindowInsets();
                this.mGuideView.measure(getBannerChildMeasureSpec((((size - this.mFloatingGuideMarginRightPx) - this.mFloatingGuideMarginLeftPx) - rootViewWindowInsets.right) - rootViewWindowInsets.left), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
            }
        }
        i = size;
        setMeasuredDimension(i, size2);
    }

    @Override // sdk.pendo.io.views.custom.PendoFloatingVisualGuideView, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!isAttached() || !isShown() || event.getActionMasked() != 0) {
            return false;
        }
        Boolean a2 = q0.a(event, this.mGuideView, this.mDialogMargin);
        Intrinsics.checkNotNull(a2);
        if (a2.booleanValue()) {
            return true;
        }
        touchOutsideOfFloatingGuide();
        return false;
    }

    @Override // sdk.pendo.io.views.custom.PendoFloatingVisualGuideView, android.view.View
    public void onVisibilityChanged(View changedView, int visibility) {
        View view;
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        try {
            if (visibility == 0) {
                d dVar = this.mDrawable;
                if (dVar != null && (view = this.mGuideView) != null) {
                    view.setBackground(dVar);
                }
                a.a(this.mGuideView);
            } else {
                Context context = getContext();
                Activity activity = context instanceof Activity ? (Activity) context : null;
                if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                    PendoLogger.d(TAG, "onVisibilityChanged to invisible/gone, removing the banner from view");
                    removeFromParent();
                }
            }
        } catch (Exception e) {
            PendoLogger.w(e, TAG + " onVisibilityChanged", e.getMessage());
        }
        super.onVisibilityChanged(changedView, visibility);
    }

    @Override // sdk.pendo.io.views.custom.PendoFloatingVisualGuideView
    public void removeFromParent() {
        ViewParent parent = getParent();
        if (parent != null && isAttached() && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this);
        }
    }

    @Override // sdk.pendo.io.views.custom.PendoFloatingVisualGuideView
    public synchronized void show() {
        super.show();
        GuideTapOnManager.resetTapOn();
    }
}
