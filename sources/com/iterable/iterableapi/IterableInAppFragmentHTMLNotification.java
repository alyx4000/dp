package com.iterable.iterableapi;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.iterable.iterableapi.IterableHelper;
import com.iterable.iterableapi.IterableInAppMessage;
import com.iterable.iterableapi.IterableWebView;

/* loaded from: classes5.dex */
public class IterableInAppFragmentHTMLNotification extends DialogFragment implements IterableWebView.HTMLNotificationCallbacks {
    private static final String BACKGROUND_ALPHA = "BackgroundAlpha";
    private static final String BACK_BUTTON = "itbl://backButton";
    private static final String CALLBACK_ON_CANCEL = "CallbackOnCancel";
    private static final int DELAY_THRESHOLD_MS = 500;
    private static final String HTML_STRING = "HTML";
    private static final String INSET_PADDING = "InsetPadding";
    private static final String IN_APP_BG_ALPHA = "InAppBgAlpha";
    private static final String IN_APP_BG_COLOR = "InAppBgColor";
    private static final String IN_APP_OPEN_TRACKED = "InAppOpenTracked";
    private static final String IN_APP_SHOULD_ANIMATE = "ShouldAnimate";
    private static final String MESSAGE_ID = "MessageId";
    private static final String TAG = "IterableInAppFragmentHTMLNotification";
    static IterableHelper.IterableUrlCallback clickCallback;
    static IterableInAppLocation location;
    static IterableInAppFragmentHTMLNotification notification;
    private String htmlString;
    private double inAppBackgroundAlpha;
    private String inAppBackgroundColor;
    private OrientationEventListener orientationListener;
    private boolean shouldAnimate;
    private IterableWebView webView;
    private boolean callbackOnCancel = false;
    private boolean loaded = false;
    private double backgroundAlpha = 0.0d;
    private String messageId = "";
    private Rect insetPadding = new Rect();

    public static IterableInAppFragmentHTMLNotification createInstance(String str, boolean z, IterableHelper.IterableUrlCallback iterableUrlCallback, IterableInAppLocation iterableInAppLocation, String str2, Double d, Rect rect) {
        return createInstance(str, z, iterableUrlCallback, iterableInAppLocation, str2, d, rect, false, new IterableInAppMessage.InAppBgColor(null, 0.0d));
    }

    public static IterableInAppFragmentHTMLNotification createInstance(String str, boolean z, IterableHelper.IterableUrlCallback iterableUrlCallback, IterableInAppLocation iterableInAppLocation, String str2, Double d, Rect rect, boolean z2, IterableInAppMessage.InAppBgColor inAppBgColor) {
        notification = new IterableInAppFragmentHTMLNotification();
        Bundle bundle = new Bundle();
        bundle.putString(HTML_STRING, str);
        bundle.putBoolean(CALLBACK_ON_CANCEL, z);
        bundle.putString(MESSAGE_ID, str2);
        bundle.putDouble(BACKGROUND_ALPHA, d.doubleValue());
        bundle.putParcelable(INSET_PADDING, rect);
        bundle.putString(IN_APP_BG_COLOR, inAppBgColor.bgHexColor);
        bundle.putDouble(IN_APP_BG_ALPHA, inAppBgColor.bgAlpha);
        bundle.putBoolean(IN_APP_SHOULD_ANIMATE, z2);
        clickCallback = iterableUrlCallback;
        location = iterableInAppLocation;
        notification.setArguments(bundle);
        return notification;
    }

    public static IterableInAppFragmentHTMLNotification getInstance() {
        return notification;
    }

    public IterableInAppFragmentHTMLNotification() {
        setStyle(2, R.style.Theme_AppCompat_NoActionBar);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.htmlString = arguments.getString(HTML_STRING, null);
            this.callbackOnCancel = arguments.getBoolean(CALLBACK_ON_CANCEL, false);
            this.messageId = arguments.getString(MESSAGE_ID);
            this.backgroundAlpha = arguments.getDouble(BACKGROUND_ALPHA);
            this.insetPadding = (Rect) arguments.getParcelable(INSET_PADDING);
            this.inAppBackgroundAlpha = arguments.getDouble(IN_APP_BG_ALPHA);
            this.inAppBackgroundColor = arguments.getString(IN_APP_BG_COLOR, null);
            this.shouldAnimate = arguments.getBoolean(IN_APP_SHOULD_ANIMATE);
        }
        notification = this;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = new Dialog(getActivity(), getTheme()) { // from class: com.iterable.iterableapi.IterableInAppFragmentHTMLNotification.1
            @Override // android.app.Dialog
            public void onBackPressed() {
                IterableInAppFragmentHTMLNotification.this.onBackPressed();
                IterableInAppFragmentHTMLNotification.this.hideWebView();
            }
        };
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.iterable.iterableapi.IterableInAppFragmentHTMLNotification.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (!IterableInAppFragmentHTMLNotification.this.callbackOnCancel || IterableInAppFragmentHTMLNotification.clickCallback == null) {
                    return;
                }
                IterableInAppFragmentHTMLNotification.clickCallback.execute(null);
            }
        });
        dialog.requestWindowFeature(1);
        if (getInAppLayout(this.insetPadding) == InAppLayout.FULLSCREEN) {
            dialog.getWindow().setFlags(1024, 1024);
        } else if (getInAppLayout(this.insetPadding) != InAppLayout.TOP) {
            dialog.getWindow().setFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL, AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        }
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (getInAppLayout(this.insetPadding) == InAppLayout.FULLSCREEN) {
            getDialog().getWindow().setFlags(1024, 1024);
        }
        IterableWebView iterableWebView = new IterableWebView(getContext());
        this.webView = iterableWebView;
        iterableWebView.setId(R.id.webView);
        this.webView.createWithHtml(this, this.htmlString);
        this.webView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.iterable.iterableapi.IterableInAppFragmentHTMLNotification.3
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                IterableInAppFragmentHTMLNotification.this.runResizeScript();
                return true;
            }
        });
        if (this.orientationListener == null) {
            this.orientationListener = new OrientationEventListener(getContext(), 3) { // from class: com.iterable.iterableapi.IterableInAppFragmentHTMLNotification.4
                @Override // android.view.OrientationEventListener
                public void onOrientationChanged(int i) {
                    if (IterableInAppFragmentHTMLNotification.this.loaded) {
                        new Handler().postDelayed(new Runnable() { // from class: com.iterable.iterableapi.IterableInAppFragmentHTMLNotification.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                IterableInAppFragmentHTMLNotification.this.runResizeScript();
                            }
                        }, 1000L);
                    }
                }
            };
        }
        this.orientationListener.enable();
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout.setVerticalGravity(getVerticalLocation(this.insetPadding));
        relativeLayout.addView(this.webView, layoutParams);
        if (bundle == null || !bundle.getBoolean(IN_APP_OPEN_TRACKED, false)) {
            IterableApi.sharedInstance.trackInAppOpen(this.messageId, location);
        }
        prepareToShowWebView();
        return relativeLayout;
    }

    @Override // com.iterable.iterableapi.IterableWebView.HTMLNotificationCallbacks
    public void setLoaded(boolean z) {
        this.loaded = z;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(IN_APP_OPEN_TRACKED, true);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        this.orientationListener.disable();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (getActivity() == null || !getActivity().isChangingConfigurations()) {
            notification = null;
            clickCallback = null;
            location = null;
        }
    }

    @Override // com.iterable.iterableapi.IterableWebView.HTMLNotificationCallbacks
    public void onUrlClicked(String str) {
        IterableApi.sharedInstance.trackInAppClick(this.messageId, str, location);
        IterableApi.sharedInstance.trackInAppClose(this.messageId, str, IterableInAppCloseAction.LINK, location);
        IterableHelper.IterableUrlCallback iterableUrlCallback = clickCallback;
        if (iterableUrlCallback != null) {
            iterableUrlCallback.execute(Uri.parse(str));
        }
        processMessageRemoval();
        hideWebView();
    }

    public void onBackPressed() {
        IterableApi.sharedInstance.trackInAppClick(this.messageId, BACK_BUTTON);
        IterableApi.sharedInstance.trackInAppClose(this.messageId, BACK_BUTTON, IterableInAppCloseAction.BACK, location);
        processMessageRemoval();
    }

    private void prepareToShowWebView() {
        try {
            this.webView.setAlpha(0.0f);
            this.webView.postDelayed(new Runnable() { // from class: com.iterable.iterableapi.IterableInAppFragmentHTMLNotification.5
                @Override // java.lang.Runnable
                public void run() {
                    if (IterableInAppFragmentHTMLNotification.this.getContext() == null || IterableInAppFragmentHTMLNotification.this.getDialog() == null || IterableInAppFragmentHTMLNotification.this.getDialog().getWindow() == null) {
                        return;
                    }
                    IterableInAppFragmentHTMLNotification.this.showInAppBackground();
                    IterableInAppFragmentHTMLNotification.this.showAndAnimateWebView();
                }
            }, 500L);
        } catch (NullPointerException unused) {
            IterableLogger.e(TAG, "View not present. Failed to hide before resizing inapp");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showInAppBackground() {
        animateBackground(new ColorDrawable(0), getInAppBackgroundDrawable());
    }

    private void hideInAppBackground() {
        animateBackground(getInAppBackgroundDrawable(), new ColorDrawable(0));
    }

    private void animateBackground(Drawable drawable, Drawable drawable2) {
        if (drawable == null || drawable2 == null) {
            return;
        }
        if (getDialog() == null || getDialog().getWindow() == null) {
            IterableLogger.e(TAG, "Dialog or Window not present. Skipping background animation");
            return;
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{drawable, drawable2});
        transitionDrawable.setCrossFadeEnabled(true);
        getDialog().getWindow().setBackgroundDrawable(transitionDrawable);
        transitionDrawable.startTransition(300);
    }

    private ColorDrawable getInAppBackgroundDrawable() {
        String str = this.inAppBackgroundColor;
        if (str == null) {
            IterableLogger.d(TAG, "Background Color does not exist. In App background animation will not be performed");
            return null;
        }
        try {
            return new ColorDrawable(ColorUtils.setAlphaComponent(Color.parseColor(str), (int) (this.inAppBackgroundAlpha * 255.0d)));
        } catch (IllegalArgumentException unused) {
            IterableLogger.e(TAG, "Background color could not be identified for input string \"" + this.inAppBackgroundColor + "\". Failed to load in-app background.");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAndAnimateWebView() {
        int i;
        this.webView.setAlpha(1.0f);
        this.webView.setVisibility(0);
        if (this.shouldAnimate) {
            int i2 = AnonymousClass8.$SwitchMap$com$iterable$iterableapi$InAppLayout[getInAppLayout(this.insetPadding).ordinal()];
            if (i2 == 1) {
                i = R.anim.slide_down_custom;
            } else if (i2 == 2 || i2 == 3) {
                i = R.anim.fade_in_custom;
            } else if (i2 == 4) {
                i = R.anim.slide_up_custom;
            } else {
                i = R.anim.fade_in_custom;
            }
            try {
                Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), i);
                loadAnimation.setDuration(500L);
                this.webView.startAnimation(loadAnimation);
            } catch (Exception unused) {
                IterableLogger.e(TAG, "Failed to show inapp with animation");
            }
        }
    }

    /* renamed from: com.iterable.iterableapi.IterableInAppFragmentHTMLNotification$8, reason: invalid class name */
    static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] $SwitchMap$com$iterable$iterableapi$InAppLayout;

        static {
            int[] iArr = new int[InAppLayout.values().length];
            $SwitchMap$com$iterable$iterableapi$InAppLayout = iArr;
            try {
                iArr[InAppLayout.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$iterable$iterableapi$InAppLayout[InAppLayout.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$iterable$iterableapi$InAppLayout[InAppLayout.FULLSCREEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$iterable$iterableapi$InAppLayout[InAppLayout.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideWebView() {
        int i;
        if (this.shouldAnimate) {
            int i2 = AnonymousClass8.$SwitchMap$com$iterable$iterableapi$InAppLayout[getInAppLayout(this.insetPadding).ordinal()];
            if (i2 == 1) {
                i = R.anim.top_exit;
            } else if (i2 == 2 || i2 == 3) {
                i = R.anim.fade_out_custom;
            } else if (i2 == 4) {
                i = R.anim.bottom_exit;
            } else {
                i = R.anim.fade_out_custom;
            }
            try {
                Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), i);
                loadAnimation.setDuration(500L);
                this.webView.startAnimation(loadAnimation);
            } catch (Exception unused) {
                IterableLogger.e(TAG, "Failed to hide inapp with animation");
            }
        }
        hideInAppBackground();
        this.webView.postOnAnimationDelayed(new Runnable() { // from class: com.iterable.iterableapi.IterableInAppFragmentHTMLNotification.6
            @Override // java.lang.Runnable
            public void run() {
                if (IterableInAppFragmentHTMLNotification.this.getContext() == null || IterableInAppFragmentHTMLNotification.this.getDialog() == null || IterableInAppFragmentHTMLNotification.this.getDialog().getWindow() == null) {
                    return;
                }
                IterableInAppFragmentHTMLNotification.this.dismissAllowingStateLoss();
            }
        }, 400L);
    }

    private void processMessageRemoval() {
        IterableInAppMessage messageById = IterableApi.sharedInstance.getInAppManager().getMessageById(this.messageId);
        if (messageById == null) {
            IterableLogger.e(TAG, "Message with id " + this.messageId + " does not exist");
        } else {
            if (!messageById.isMarkedForDeletion() || messageById.isConsumed()) {
                return;
            }
            IterableApi.sharedInstance.getInAppManager().removeMessage(messageById, null, null);
        }
    }

    @Override // com.iterable.iterableapi.IterableWebView.HTMLNotificationCallbacks
    public void runResizeScript() {
        resize(this.webView.getContentHeight());
    }

    public void resize(final float f) {
        final FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.iterable.iterableapi.IterableInAppFragmentHTMLNotification.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (IterableInAppFragmentHTMLNotification.this.getContext() != null && IterableInAppFragmentHTMLNotification.notification != null && IterableInAppFragmentHTMLNotification.notification.getDialog() != null && IterableInAppFragmentHTMLNotification.notification.getDialog().getWindow() != null && IterableInAppFragmentHTMLNotification.notification.getDialog().isShowing()) {
                        activity.getResources().getDisplayMetrics();
                        Window window = IterableInAppFragmentHTMLNotification.notification.getDialog().getWindow();
                        Rect rect = IterableInAppFragmentHTMLNotification.notification.insetPadding;
                        Display defaultDisplay = ((WindowManager) IterableInAppFragmentHTMLNotification.this.getContext().getSystemService("window")).getDefaultDisplay();
                        Point point = new Point();
                        defaultDisplay.getRealSize(point);
                        int i = point.x;
                        int i2 = point.y;
                        if (rect.bottom == 0 && rect.top == 0) {
                            window.setLayout(i, i2);
                            IterableInAppFragmentHTMLNotification.this.getDialog().getWindow().setFlags(1024, 1024);
                        } else {
                            IterableInAppFragmentHTMLNotification.this.webView.setLayoutParams(new RelativeLayout.LayoutParams(IterableInAppFragmentHTMLNotification.this.getResources().getDisplayMetrics().widthPixels, (int) (f * IterableInAppFragmentHTMLNotification.this.getResources().getDisplayMetrics().density)));
                        }
                    }
                } catch (IllegalArgumentException e) {
                    IterableLogger.e(IterableInAppFragmentHTMLNotification.TAG, "Exception while trying to resize an in-app message", e);
                }
            }
        });
    }

    int getVerticalLocation(Rect rect) {
        if (rect.top != 0 || rect.bottom >= 0) {
            return (rect.top >= 0 || rect.bottom != 0) ? 16 : 80;
        }
        return 48;
    }

    InAppLayout getInAppLayout(Rect rect) {
        if (rect.top == 0 && rect.bottom == 0) {
            return InAppLayout.FULLSCREEN;
        }
        if (rect.top == 0 && rect.bottom < 0) {
            return InAppLayout.TOP;
        }
        if (rect.top < 0 && rect.bottom == 0) {
            return InAppLayout.BOTTOM;
        }
        return InAppLayout.CENTER;
    }
}
