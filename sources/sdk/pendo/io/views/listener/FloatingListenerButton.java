package sdk.pendo.io.views.listener;

import android.R;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.view.MotionEventCompat;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.g9.m0;
import sdk.pendo.io.g9.q0;
import sdk.pendo.io.g9.x;
import sdk.pendo.io.h8.b;
import sdk.pendo.io.h8.c;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.y8.a;

/* loaded from: classes4.dex */
public final class FloatingListenerButton extends AppCompatImageButton implements View.OnClickListener {
    private static final int BUTTON_STATE_CHANGE_TIMEOUT = 1000;
    private static final int FIRST_STATE_SHOW_NUMBER_THREE = 1;
    private static final int FLASH_STATE = 4;
    private static final int FLOATING_BUTTON_ELEVATION = 0;
    private static final int INVALID_POINTER_ID = -1;
    private static final int LIMBO_STATE = 5;
    private static final long MAX_CLICK_DURATION = 250;
    private static final int PRE_FLASH_TIMEOUT = 200;
    private static final int PRE_PROGRESS_BAR_TIMEOUT = 500;
    public static final String SCREEN_SEND_MODE_TAG = "screenSend";
    private static final int SECOND_STATE_SHOW_NUMBER_TWO = 2;
    private static final String TEST_MODE_TAG = "testMode";
    private static final int THIRD_STATE_SHOW_NUMBER_ONE = 3;
    private static float sLastTouchX;
    private static float sLastTouchY;
    private AccessibilityManager mAccessibilityManager;
    private int mActivePointerId;
    private Handler mAnimationTimeoutHandler;
    private boolean mButtonClicked;
    private Rect mDisplayRect;
    private AtomicInteger mDrawableResource;
    private Runnable mFinishedRunnable;
    private Runnable mFlashRunnable;
    private long mPressStartTime;
    private float mPressedX;
    private float mPressedY;
    private Runnable mShowFirstButtonRunnable;
    private Runnable mShowSecondButtonRunnable;
    private Rect mViewRealRect;
    private c testModeDialog;
    private static final float MAX_CLICK_DISTANCE = q0.a(15.0f);
    private static final Object LOCK = new Object();
    private static float sPosX = -1.0f;
    private static float sPosY = -1.0f;
    private static boolean sMovedOrTookScreenshot = false;
    private static int sLastButtonState = 1;
    private static volatile AtomicInteger sButtonState = new AtomicInteger(1);
    private static boolean sFinishedAnimation = false;
    private static WeakReference<b> sDialogFragment = null;

    public static final class Builder {
        private int mGravity = 81;
        private FrameLayout.LayoutParams mParams;

        public Builder() {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            this.mParams = layoutParams;
            layoutParams.gravity = this.mGravity;
        }

        public static void removeActiveInstances() {
            synchronized (FloatingListenerButton.LOCK) {
                for (final Activity activity : sdk.pendo.io.n8.c.g().d()) {
                    activity.runOnUiThread(new Runnable() { // from class: sdk.pendo.io.views.listener.FloatingListenerButton.Builder.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.content);
                                FloatingListenerButton floatingListenerButton = viewGroup != null ? (FloatingListenerButton) viewGroup.findViewWithTag(activity.getString(sdk.pendo.io.R.string.pnd_pairing_button_name_tag)) : null;
                                if (floatingListenerButton != null) {
                                    viewGroup.removeView(floatingListenerButton);
                                }
                            } catch (Exception e) {
                                PendoLogger.w(e, "Error in removing the pairing button", new Object[0]);
                            }
                        }
                    });
                }
            }
        }

        public FloatingListenerButton create() {
            final Activity f = sdk.pendo.io.n8.c.g().f();
            final ViewGroup viewGroup = (ViewGroup) f.findViewById(R.id.content);
            f.runOnUiThread(new Runnable() { // from class: sdk.pendo.io.views.listener.FloatingListenerButton.Builder.2
                @Override // java.lang.Runnable
                public void run() {
                    Activity activity;
                    int i;
                    FloatingListenerButton floatingListenerButton = new FloatingListenerButton();
                    floatingListenerButton.setTag(f.getString(sdk.pendo.io.R.string.pnd_pairing_button_name_tag));
                    floatingListenerButton.setContentDescription(f.getString(sdk.pendo.io.R.string.pnd_capture_button_accessibility_description));
                    if (!a.d().o()) {
                        if (a.d().t()) {
                            if (a.r().booleanValue()) {
                                activity = f;
                                i = sdk.pendo.io.R.string.pnd_test_mode_connected_button_accessibility_description;
                            } else {
                                activity = f;
                                i = sdk.pendo.io.R.string.pnd_test_mode_disconnected_button_accessibility_description;
                            }
                        }
                        floatingListenerButton.setVisibility(0);
                        Builder builder = Builder.this;
                        builder.mParams.gravity = builder.mGravity;
                        builder.withMargins(0, 0, 0, 16);
                        viewGroup.addView(floatingListenerButton, Builder.this.mParams);
                    }
                    if (a.r().booleanValue()) {
                        activity = f;
                        i = sdk.pendo.io.R.string.pnd_paired_connected_button_accessibility_description;
                    } else {
                        activity = f;
                        i = sdk.pendo.io.R.string.pnd_paired_disconnected_button_accessibility_description;
                    }
                    floatingListenerButton.setContentDescription(activity.getString(i));
                    floatingListenerButton.setVisibility(0);
                    Builder builder2 = Builder.this;
                    builder2.mParams.gravity = builder2.mGravity;
                    builder2.withMargins(0, 0, 0, 16);
                    viewGroup.addView(floatingListenerButton, Builder.this.mParams);
                }
            });
            return null;
        }

        public Builder withMargins(int i, int i2, int i3, int i4) {
            this.mParams.setMargins(q0.a(i), q0.a(i2), q0.a(i3), q0.a(i4));
            return this;
        }
    }

    public FloatingListenerButton() {
        super(PendoInternal.m());
        this.testModeDialog = null;
        this.mActivePointerId = -1;
        this.mButtonClicked = false;
        this.mDrawableResource = new AtomicInteger(-1);
        this.mDisplayRect = new Rect();
        this.mViewRealRect = new Rect();
        init();
    }

    private boolean captureButtonRequired() {
        return a.d().g();
    }

    public static void clearDialogFragment() {
        WeakReference<b> weakReference = sDialogFragment;
        if (weakReference != null && weakReference.get() != null) {
            sDialogFragment.get().getDialog().dismiss();
        }
        sDialogFragment = null;
    }

    public static b getProgressDialog() {
        WeakReference<b> weakReference = sDialogFragment;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleReadyToCapture() {
        PendoLogger.i("Sending view to Pendo.", new Object[0]);
        this.mButtonClicked = false;
        sFinishedAnimation = true;
        x.a();
    }

    private void init() {
        int i;
        try {
            this.mAccessibilityManager = (AccessibilityManager) PendoInternal.m().getSystemService("accessibility");
            this.mButtonClicked = false;
            sFinishedAnimation = false;
            sButtonState.set(1);
            if (a.d().o()) {
                i = a.r().booleanValue() ? sdk.pendo.io.R.drawable.pnd_pair_connected : sdk.pendo.io.R.drawable.pnd_pair;
            } else if (a.d().t()) {
                i = a.r().booleanValue() ? sdk.pendo.io.R.drawable.pnd_test_mode_connected : sdk.pendo.io.R.drawable.pnd_test_mode;
            } else {
                if (!a.d().i()) {
                    setImageResource(sdk.pendo.io.R.drawable.pnd_camcam);
                    setContentDescription(getContext().getString(sdk.pendo.io.R.string.pnd_capture_mode_accessibility_description));
                    setId(sdk.pendo.io.R.id.pnd_pairingButton);
                    this.mAnimationTimeoutHandler = new Handler();
                    this.mShowSecondButtonRunnable = new Runnable() { // from class: sdk.pendo.io.views.listener.FloatingListenerButton.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FloatingListenerButton.sButtonState.set(2);
                            FloatingListenerButton.this.invalidate();
                        }
                    };
                    this.mShowFirstButtonRunnable = new Runnable() { // from class: sdk.pendo.io.views.listener.FloatingListenerButton.2
                        @Override // java.lang.Runnable
                        public void run() {
                            FloatingListenerButton.sButtonState.set(3);
                            FloatingListenerButton.this.invalidate();
                        }
                    };
                    this.mFlashRunnable = new Runnable() { // from class: sdk.pendo.io.views.listener.FloatingListenerButton.3
                        @Override // java.lang.Runnable
                        public void run() {
                            FloatingListenerButton.sButtonState.set(4);
                            FloatingListenerButton.this.invalidate();
                        }
                    };
                    this.mFinishedRunnable = new Runnable() { // from class: sdk.pendo.io.views.listener.FloatingListenerButton.4
                        @Override // java.lang.Runnable
                        public void run() {
                            FloatingListenerButton.this.handleReadyToCapture();
                        }
                    };
                    setBackgroundColor(0);
                    setOnClickListener(this);
                    setClickable(true);
                    invalidate();
                }
                i = a.r().booleanValue() ? sdk.pendo.io.R.drawable.pendo_debug_icon : sdk.pendo.io.R.drawable.pendo_debug_offline_icon;
            }
            setImageResource(i);
            setId(sdk.pendo.io.R.id.pnd_pairingButton);
            this.mAnimationTimeoutHandler = new Handler();
            this.mShowSecondButtonRunnable = new Runnable() { // from class: sdk.pendo.io.views.listener.FloatingListenerButton.1
                @Override // java.lang.Runnable
                public void run() {
                    FloatingListenerButton.sButtonState.set(2);
                    FloatingListenerButton.this.invalidate();
                }
            };
            this.mShowFirstButtonRunnable = new Runnable() { // from class: sdk.pendo.io.views.listener.FloatingListenerButton.2
                @Override // java.lang.Runnable
                public void run() {
                    FloatingListenerButton.sButtonState.set(3);
                    FloatingListenerButton.this.invalidate();
                }
            };
            this.mFlashRunnable = new Runnable() { // from class: sdk.pendo.io.views.listener.FloatingListenerButton.3
                @Override // java.lang.Runnable
                public void run() {
                    FloatingListenerButton.sButtonState.set(4);
                    FloatingListenerButton.this.invalidate();
                }
            };
            this.mFinishedRunnable = new Runnable() { // from class: sdk.pendo.io.views.listener.FloatingListenerButton.4
                @Override // java.lang.Runnable
                public void run() {
                    FloatingListenerButton.this.handleReadyToCapture();
                }
            };
            setBackgroundColor(0);
            setOnClickListener(this);
            setClickable(true);
            invalidate();
        } catch (Exception e) {
            PendoLogger.e(e, e.getMessage(), new Object[0]);
            Toast.makeText(getContext(), getResources().getString(sdk.pendo.io.R.string.pnd_pairing_error_occurred), 1).show();
        }
    }

    private void resetPosition() {
        sPosX = getX();
        sPosY = getY();
    }

    public static void setProgressDialog(b bVar) {
        sDialogFragment = new WeakReference<>(bVar);
    }

    public static void setVisibility(final boolean z) {
        final FloatingListenerButton floatingListenerButton;
        Activity f = sdk.pendo.io.n8.c.g().f();
        ViewGroup viewGroup = (ViewGroup) f.findViewById(R.id.content);
        if (viewGroup == null || (floatingListenerButton = (FloatingListenerButton) viewGroup.findViewWithTag(f.getString(sdk.pendo.io.R.string.pnd_pairing_button_name_tag))) == null) {
            return;
        }
        f.runOnUiThread(new Runnable() { // from class: sdk.pendo.io.views.listener.FloatingListenerButton$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                boolean z2 = z;
                floatingListenerButton.setVisibility(r0 ? 0 : 8);
            }
        });
    }

    public void flashFinished() {
        this.mAnimationTimeoutHandler.postDelayed(new Runnable() { // from class: sdk.pendo.io.views.listener.FloatingListenerButton$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                FloatingListenerButton.this.m3227x2040654e();
            }
        }, 500L);
    }

    /* renamed from: lambda$flashFinished$0$sdk-pendo-io-views-listener-FloatingListenerButton, reason: not valid java name */
    /* synthetic */ void m3227x2040654e() {
        if (sdk.pendo.io.n8.c.g().f() == null) {
            return;
        }
        Builder.removeActiveInstances();
        x.a(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        sFinishedAnimation = false;
        if (sMovedOrTookScreenshot) {
            PendoLogger.i("Not sending view.", new Object[0]);
            sMovedOrTookScreenshot = false;
        } else {
            this.mButtonClicked = true;
            invalidate();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x011f, code lost:
    
        if (r0 != r1) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0204, code lost:
    
        setImageResource(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x012d, code lost:
    
        if (r0 != r1) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01e4, code lost:
    
        if (r0 != r1) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01f3, code lost:
    
        if (r0 != r1) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0202, code lost:
    
        if (r0 != r1) goto L100;
     */
    @Override // android.widget.ImageView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onDraw(android.graphics.Canvas r9) {
        /*
            Method dump skipped, instructions count: 689
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.views.listener.FloatingListenerButton.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (this.mAccessibilityManager.isTouchExplorationEnabled() && motionEvent.getPointerCount() == 1) {
            return onTouchEvent(sdk.pendo.io.g9.b.a(motionEvent));
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked;
        float rawX;
        float rawY;
        int pointerId;
        Activity f;
        try {
            actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            rawX = motionEvent.getRawX();
            rawY = motionEvent.getRawY();
        } catch (Exception e) {
            String message = e.getMessage();
            Object[] objArr = new Object[1];
            objArr[0] = "event: " + (motionEvent != null ? "motion event: " + motionEvent.getAction() + " rawx: " + motionEvent.getRawX() + " rawy: " + motionEvent.getRawY() : "no event");
            PendoLogger.e(e, message, objArr);
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    PendoLogger.d("MotionEvents - ActionMove", new Object[0]);
                    float f2 = rawX - sLastTouchX;
                    float f3 = rawY - sLastTouchY;
                    sPosX += f2;
                    sPosY += f3;
                    invalidate();
                    sLastTouchX = rawX;
                    sLastTouchY = rawY;
                    sMovedOrTookScreenshot = true;
                } else if (actionMasked == 3) {
                    PendoLogger.d("MotionEvents - ActionCancel", new Object[0]);
                } else if (actionMasked != 6) {
                    PendoLogger.d("Unknown action: " + actionMasked, new Object[0]);
                } else {
                    PendoLogger.d("MotionEvents - ActionPointerUp", new Object[0]);
                    int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                    if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.mActivePointerId) {
                        int i = actionIndex == 0 ? 1 : 0;
                        sLastTouchX = motionEvent.getRawX();
                        sLastTouchY = motionEvent.getRawY();
                        pointerId = MotionEventCompat.getPointerId(motionEvent, i);
                    }
                }
                return super.onTouchEvent(motionEvent);
            }
            PendoLogger.d("MotionEvents - ActionUp", new Object[0]);
            if (System.currentTimeMillis() - this.mPressStartTime < MAX_CLICK_DURATION && m0.a(this.mPressedX, this.mPressedY, motionEvent.getX(), motionEvent.getY()) < MAX_CLICK_DISTANCE) {
                if ((a.d().t() || a.d().o() || a.d().i()) && (f = sdk.pendo.io.n8.c.g().f()) != null && f.getFragmentManager() != null) {
                    c a2 = c.a();
                    this.testModeDialog = a2;
                    a2.show(f.getFragmentManager(), TEST_MODE_TAG);
                }
                sMovedOrTookScreenshot = false;
                performClick();
            }
            this.mActivePointerId = -1;
            return super.onTouchEvent(motionEvent);
        }
        PendoLogger.d("MotionEvents - ActionDown", new Object[0]);
        sLastTouchX = rawX;
        sLastTouchY = rawY;
        this.mPressStartTime = System.currentTimeMillis();
        this.mPressedX = motionEvent.getX();
        this.mPressedY = motionEvent.getY();
        pointerId = MotionEventCompat.getPointerId(motionEvent, 0);
        this.mActivePointerId = pointerId;
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(0.0f);
    }
}
