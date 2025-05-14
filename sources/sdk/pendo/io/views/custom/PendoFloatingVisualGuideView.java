package sdk.pendo.io.views.custom;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import sdk.pendo.io.R;
import sdk.pendo.io.a8.b;
import sdk.pendo.io.a8.d;
import sdk.pendo.io.actions.PendoCommand;
import sdk.pendo.io.actions.PendoCommandAction;
import sdk.pendo.io.actions.PendoCommandEventType;
import sdk.pendo.io.actions.PendoCommandsEventBus;
import sdk.pendo.io.actions.PendoFloatingVisualGuideManager;
import sdk.pendo.io.actions.VisualGuideBase;
import sdk.pendo.io.actions.VisualGuidesManager;
import sdk.pendo.io.actions.handlers.PendoGlobalCommandHandler;
import sdk.pendo.io.c7.a;
import sdk.pendo.io.d6.e;
import sdk.pendo.io.g9.k0;
import sdk.pendo.io.g9.q0;
import sdk.pendo.io.logging.PendoLogger;

/* loaded from: classes4.dex */
public abstract class PendoFloatingVisualGuideView extends ViewGroup implements b {
    protected static final List<Integer> GRAVITY_LIST = new ArrayList(Arrays.asList(0, 1, 2, 3, 4));
    private static final String TAG = "PendoFloatingVisualGuideView";
    protected AccessibilityManager mAccessibilityManager;
    private boolean mAccessibilityNeeded;
    protected final View.OnAttachStateChangeListener mAnchorViewAttachedStateListener;
    protected WeakReference<View> mAnchorViewWeakRef;
    protected boolean mAttached;
    protected final int mBorderPadding;
    protected final PendoFloatingVisualGuideManager.FloatingGuideViewCallbacks mCloseCallback;
    private final AtomicBoolean mClosed;
    protected int mDialogMargin;
    private long mDisplayDuration;
    protected final Rect mDrawRect;
    protected final d mDrawable;
    protected final String mFloatingGuideId;
    public OnFloatingGuideListener mFloatingGuideListener;
    protected final int mFloatingGuideMarginBottomPx;
    protected final int mFloatingGuideMarginLeftPx;
    protected final int mFloatingGuideMarginRightPx;
    protected final int mFloatingGuideMarginTopPx;
    protected int mGlobalLayoutCount;
    protected int mGravity;
    protected View mGuideView;
    protected boolean mInitialized;
    protected final View mRootView;
    protected Rect mScreenRect;
    protected Rect mScreenRectWithoutMargins;
    protected final boolean mSeeThrough;
    protected long mStartTime;
    protected final int mTopRule;
    protected final boolean mTouchPassThrough;
    private final AtomicBoolean mWasShown;

    public interface OnFloatingGuideListener {
        void onShowFailed(PendoFloatingVisualGuideView pendoFloatingVisualGuideView);
    }

    protected PendoFloatingVisualGuideView(Context context, PendoFloatingVisualGuideManager.Builder builder) {
        super(context);
        this.mScreenRect = new Rect();
        this.mGlobalLayoutCount = 0;
        this.mDisplayDuration = 0L;
        this.mStartTime = 0L;
        this.mWasShown = new AtomicBoolean(false);
        this.mClosed = new AtomicBoolean(false);
        this.mAccessibilityNeeded = false;
        this.mAnchorViewAttachedStateListener = new View.OnAttachStateChangeListener() { // from class: sdk.pendo.io.views.custom.PendoFloatingVisualGuideView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                PendoFloatingVisualGuideView.this.removeViewListeners(view);
                PendoFloatingVisualGuideView pendoFloatingVisualGuideView = PendoFloatingVisualGuideView.this;
                PendoFloatingVisualGuideManager.FloatingGuideViewCallbacks floatingGuideViewCallbacks = pendoFloatingVisualGuideView.mCloseCallback;
                if (floatingGuideViewCallbacks != null) {
                    floatingGuideViewCallbacks.onClosing(true, pendoFloatingVisualGuideView.mDisplayDuration, pendoFloatingVisualGuideView.mWasShown.get());
                }
                PendoFloatingVisualGuideView pendoFloatingVisualGuideView2 = PendoFloatingVisualGuideView.this;
                if (!pendoFloatingVisualGuideView2.mAttached) {
                    PendoLogger.w(PendoFloatingVisualGuideView.TAG + " not attached", new Object[0]);
                    return;
                }
                Activity activity = (Activity) pendoFloatingVisualGuideView2.getContext();
                if (activity != null) {
                    if (activity.isFinishing()) {
                        PendoLogger.w(PendoFloatingVisualGuideView.TAG + " skipped because activity is finishing...", new Object[0]);
                    } else {
                        if (activity.isDestroyed()) {
                            return;
                        }
                        PendoFloatingVisualGuideView.this.onClose(false, false, true);
                    }
                }
            }
        };
        this.mAccessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        setId(R.id.pnd_containerId);
        this.mFloatingGuideId = builder.getId();
        this.mGravity = builder.getGravity();
        this.mTopRule = builder.getActionbarSize();
        this.mTouchPassThrough = builder.getIsTouchPassThrough();
        this.mSeeThrough = builder.getIsSeeThrough();
        this.mCloseCallback = builder.getCloseCallback();
        this.mBorderPadding = builder.getStrokeWidth();
        this.mFloatingGuideMarginTopPx = builder.getMarginTopPx();
        this.mFloatingGuideMarginLeftPx = builder.getMarginLeftPx();
        this.mFloatingGuideMarginRightPx = builder.getMarginRightPx();
        this.mFloatingGuideMarginBottomPx = builder.getMarginBottomPx();
        this.mRootView = builder.getRootView();
        setClipChildren(false);
        setClipToPadding(false);
        this.mDrawRect = new Rect();
        this.mDrawable = builder.getCustomView() != null ? new d(builder.getStrokeWidth(), builder.getBgColor(), builder.getStrokeColor(), builder.getFrameRadius()) : null;
        View customView = builder.getCustomView();
        this.mGuideView = customView;
        customView.setVisibility(4);
        setVisibility(4);
        setupAccessibilityIfNeeded();
        PendoCommandsEventBus.getInstance().subscribe(a.a(this).a(sdk.pendo.io.x5.a.BUFFER), PendoCommand.createFilter(VisualGuideBase.DISMISS_VISIBLE_GUIDES, PendoGlobalCommandHandler.PENDO_GLOBAL_COMMAND_DEST, PendoCommandAction.PendoCommandGlobalAction.DISMISS_GUIDE, PendoCommandEventType.SdkEventType.HOST_APP_DEVELOPER_CALL, PendoCommand.PendoCommandScope.PENDO_COMMAND_SCOPE_ANY), new e() { // from class: sdk.pendo.io.views.custom.PendoFloatingVisualGuideView$$ExternalSyntheticLambda1
            @Override // sdk.pendo.io.d6.e
            public final void accept(Object obj) {
                PendoFloatingVisualGuideView.this.m3214x5a64021e((PendoCommand) obj);
            }
        });
    }

    static /* synthetic */ void lambda$setupAccessibilityIfNeeded$1(View view, boolean z) {
        if (!z || view == null) {
            return;
        }
        view.performAccessibilityAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_ACCESSIBILITY_FOCUS.getId(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onClose(boolean z, boolean z2, boolean z3) {
        if (this.mClosed.getAndSet(true)) {
            return;
        }
        if (isAttached()) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            this.mDisplayDuration = currentTimeMillis;
            PendoFloatingVisualGuideManager.FloatingGuideViewCallbacks floatingGuideViewCallbacks = this.mCloseCallback;
            if (floatingGuideViewCallbacks != null) {
                floatingGuideViewCallbacks.onClosing(z, currentTimeMillis, this.mWasShown.get());
            }
        }
    }

    private void removeOnAttachStateObserver(View view) {
        WeakReference<View> weakReference;
        if (view != null && (weakReference = this.mAnchorViewWeakRef) != null) {
            view = weakReference.get();
        }
        if (view != null) {
            view.removeOnAttachStateChangeListener(this.mAnchorViewAttachedStateListener);
        } else {
            PendoLogger.e(TAG + " removeOnAttachStateObserver failed", new Object[0]);
        }
    }

    private void requestFocusForAccessibilityIfNeeded() {
        if (this.mAccessibilityNeeded) {
            this.mAccessibilityNeeded = false;
            try {
                this.mGuideView.sendAccessibilityEvent(128);
                this.mGuideView.postDelayed(new Runnable() { // from class: sdk.pendo.io.views.custom.PendoFloatingVisualGuideView$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        PendoFloatingVisualGuideView.this.m3215xbf415ba2();
                    }
                }, 200L);
            } catch (Exception e) {
                PendoLogger.w(e, e.getMessage(), TAG + " requestFocusForAccessibilityIfNeeded");
            }
        }
    }

    private void setfloatingGuideContentFocusableForAccessibility() {
        try {
            this.mGuideView.setFocusableInTouchMode(true);
            this.mGuideView.setFocusable(true);
            if (this.mGuideView instanceof ViewGroup) {
                ViewGroup viewGroupToTraverse = getViewGroupToTraverse();
                if (k0.a(viewGroupToTraverse)) {
                    for (int i = 0; i < viewGroupToTraverse.getChildCount(); i++) {
                        View childAt = viewGroupToTraverse.getChildAt(i);
                        if (childAt != null) {
                            childAt.setFocusable(true);
                        }
                    }
                }
            }
        } catch (Exception e) {
            PendoLogger.w(e, e.getMessage(), TAG + " setfloatingGuideContentFocusableForAccessibility");
        }
    }

    private void setupAccessibilityIfNeeded() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        if (accessibilityManager == null || !accessibilityManager.isEnabled() || this.mGuideView == null) {
            return;
        }
        this.mAccessibilityNeeded = true;
        try {
            setfloatingGuideContentFocusableForAccessibility();
            WeakReference<View> weakReference = this.mAnchorViewWeakRef;
            if (weakReference != null && weakReference.get() != null) {
                ViewCompat.setAccessibilityDelegate(this.mGuideView, new AccessibilityDelegateCompat() { // from class: sdk.pendo.io.views.custom.PendoFloatingVisualGuideView.2
                    @Override // androidx.core.view.AccessibilityDelegateCompat
                    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                        accessibilityNodeInfoCompat.setTraversalBefore(PendoFloatingVisualGuideView.this.mAnchorViewWeakRef.get());
                    }
                });
            }
            this.mGuideView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: sdk.pendo.io.views.custom.PendoFloatingVisualGuideView$$ExternalSyntheticLambda2
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    PendoFloatingVisualGuideView.lambda$setupAccessibilityIfNeeded$1(view, z);
                }
            });
        } catch (Exception e) {
            PendoLogger.w(e, e.getMessage(), TAG + " setupAccessibilityIfNeeded");
        }
    }

    protected void calcScreenWithoutMargins() {
        Rect rect = new Rect();
        this.mScreenRectWithoutMargins = rect;
        Rect rect2 = this.mScreenRect;
        if (rect2 == null) {
            return;
        }
        rect.top = rect2.top + this.mFloatingGuideMarginTopPx;
        rect.left = rect2.left + this.mFloatingGuideMarginLeftPx;
        rect.right = rect2.right - this.mFloatingGuideMarginRightPx;
        rect.bottom = rect2.bottom - this.mFloatingGuideMarginBottomPx;
    }

    public String getFloatingGuideId() {
        return this.mFloatingGuideId;
    }

    protected abstract ViewGroup getViewGroupToTraverse();

    protected void initializeView() {
        if (!isAttached() || this.mInitialized || this.mGuideView == null) {
            return;
        }
        this.mInitialized = true;
        this.mGuideView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        d dVar = this.mDrawable;
        if (dVar != null) {
            this.mGuideView.setBackground(dVar);
            View view = this.mGuideView;
            view.setPadding(view.getPaddingLeft() + this.mBorderPadding, this.mGuideView.getPaddingTop() + this.mBorderPadding, this.mGuideView.getPaddingRight() + this.mBorderPadding, this.mGuideView.getPaddingBottom() + this.mBorderPadding);
        }
        calcScreenWithoutMargins();
        addView(this.mGuideView);
        setVisibility(4);
    }

    public boolean isAttached() {
        return this.mAttached;
    }

    /* renamed from: lambda$new$0$sdk-pendo-io-views-custom-PendoFloatingVisualGuideView, reason: not valid java name */
    /* synthetic */ void m3214x5a64021e(PendoCommand pendoCommand) {
        PendoLogger.d(pendoCommand.toString(), new Object[0]);
        onClose(false, false, true);
    }

    /* renamed from: lambda$requestFocusForAccessibilityIfNeeded$2$sdk-pendo-io-views-custom-PendoFloatingVisualGuideView, reason: not valid java name */
    /* synthetic */ void m3215xbf415ba2() {
        try {
            View view = this.mGuideView;
            if (view != null) {
                view.setFocusableInTouchMode(true);
                this.mGuideView.setFocusable(true);
                this.mGuideView.requestFocus();
            }
        } catch (Exception e) {
            PendoLogger.e(TAG + "- postDelayed - " + e.getMessage(), e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mAttached = true;
        View view = this.mRootView;
        if (view != null) {
            try {
                Rect a2 = q0.a(view);
                this.mScreenRect = a2;
                int i = a2.left;
                if (i > 0) {
                    this.mDialogMargin = i;
                }
            } catch (Exception e) {
                PendoLogger.d(e, TAG + " Attempt to read from field mVisibleInsets on a null attachInfo of the view in question.", new Object[0]);
            }
        } else {
            WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getRectSize(this.mScreenRect);
            }
        }
        initializeView();
        show();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        PendoFloatingVisualGuideManager.FloatingGuideViewCallbacks floatingGuideViewCallbacks = this.mCloseCallback;
        if (floatingGuideViewCallbacks != null) {
            floatingGuideViewCallbacks.onDetach();
        }
        this.mAttached = false;
        removeListeners();
        this.mAnchorViewWeakRef = null;
        this.mGuideView = null;
        setOnFloatingGuideListener(null);
        VisualGuidesManager.getInstance().setIsFullScreenGuideShowing(false);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mAttached) {
            super.onDraw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected abstract void onLayout(boolean z, int i, int i2, int i3, int i4);

    @Override // android.view.View
    public abstract boolean onTouchEvent(MotionEvent motionEvent);

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (view == this && i == 0) {
            requestFocusForAccessibilityIfNeeded();
        }
    }

    public abstract void removeFromParent();

    protected void removeListeners() {
        this.mFloatingGuideListener = null;
        WeakReference<View> weakReference = this.mAnchorViewWeakRef;
        if (weakReference != null) {
            removeViewListeners(weakReference.get());
        }
    }

    protected void removeViewListeners(View view) {
        removeOnAttachStateObserver(view);
    }

    public void setFloatingGuideVisible() {
        View view = this.mGuideView;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public void setOnFloatingGuideListener(OnFloatingGuideListener onFloatingGuideListener) {
        this.mFloatingGuideListener = onFloatingGuideListener;
    }

    public synchronized void show() {
        if (!isAttached()) {
            PendoLogger.e(TAG + "  not attached!", new Object[0]);
            return;
        }
        setVisibility(0);
        this.mStartTime = System.currentTimeMillis();
        this.mCloseCallback.onReadyForShow(this);
    }

    protected synchronized void touchOutsideOfFloatingGuide() {
        PendoFloatingVisualGuideManager.FloatingGuideViewCallbacks floatingGuideViewCallbacks = this.mCloseCallback;
        if (floatingGuideViewCallbacks != null) {
            floatingGuideViewCallbacks.onTouchOutside(this.mFloatingGuideId);
        }
    }
}
