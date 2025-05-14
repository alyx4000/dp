package sdk.pendo.io.actions;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.modules.appstate.AppStateModule;
import com.iterable.iterableapi.IterableConstants;
import io.sentry.protocol.OperatingSystem;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import sdk.pendo.io.R;
import sdk.pendo.io.a8.b;
import sdk.pendo.io.actions.PendoFloatingVisualGuideManager;
import sdk.pendo.io.g9.j0;
import sdk.pendo.io.g9.k0;
import sdk.pendo.io.g9.q0;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.views.custom.PendoFloatingVisualGuideView;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 \u00192\u00020\u0001:\u0004\u001a\u0019\u001b\u001cB\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u0002R<\u0010\u0010\u001a*\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u000ej\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b`\u000f8\u0004X\u0085\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00018\u0004X\u0085\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lsdk/pendo/io/actions/PendoFloatingVisualGuideManager;", "", "", "id", "Lsdk/pendo/io/a8/b;", "get", "", "", AppStateModule.APP_STATE_ACTIVE, "", "remove", "Ljava/lang/ref/WeakReference;", "Lsdk/pendo/io/views/custom/PendoFloatingVisualGuideView;", "removeFromMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "mFloatingGuides", "Ljava/util/HashMap;", "mLock", "Ljava/lang/Object;", "Lsdk/pendo/io/views/custom/PendoFloatingVisualGuideView$OnFloatingGuideListener;", "mFloatingGuideListener", "Lsdk/pendo/io/views/custom/PendoFloatingVisualGuideView$OnFloatingGuideListener;", "<init>", "()V", "Companion", "Builder", "FloatingGuideViewCallbacks", "Gravity", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public abstract class PendoFloatingVisualGuideManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final float DEFAULT_MARGIN_IN_DP = 0.0f;
    public static final float DEFAULT_STROKE_WIDTH = 1.3f;
    private static final String TAG;
    protected static WeakReference<Context> mContextRef;
    private static Map<String, Integer> sGravityMap;
    protected final HashMap<String, WeakReference<PendoFloatingVisualGuideView>> mFloatingGuides = new HashMap<>();
    protected final Object mLock = new Object();
    public PendoFloatingVisualGuideView.OnFloatingGuideListener mFloatingGuideListener = new PendoFloatingVisualGuideView.OnFloatingGuideListener() { // from class: sdk.pendo.io.actions.PendoFloatingVisualGuideManager$$ExternalSyntheticLambda0
        @Override // sdk.pendo.io.views.custom.PendoFloatingVisualGuideView.OnFloatingGuideListener
        public final void onShowFailed(PendoFloatingVisualGuideView pendoFloatingVisualGuideView) {
            PendoFloatingVisualGuideManager.mFloatingGuideListener$lambda$0(PendoFloatingVisualGuideManager.this, pendoFloatingVisualGuideView);
        }
    };

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\u0007\n\u0002\b\u001e\n\u0002\u0010\u0002\n\u0002\b\u0014\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010l\u001a\u00020\u00002\u0006\u0010l\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010m\u001a\u00020\fJ\u0018\u0010n\u001a\u00020\u00002\b\u0010o\u001a\u0004\u0018\u00010\u00122\u0006\u0010-\u001a\u00020\u0006J\u0010\u0010p\u001a\u00020\u00002\b\u0010q\u001a\u0004\u0018\u00010\u0003J\b\u0010r\u001a\u00020\u0000H\u0016J\u000e\u0010s\u001a\u00020\u00002\u0006\u0010t\u001a\u00020\fJ\u000e\u0010*\u001a\u00020\u00002\u0006\u0010u\u001a\u00020\u0003J\u000e\u00102\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u0003J\u000e\u0010Y\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020ZJ\u0010\u0010#\u001a\u00020\u00002\b\u0010 \u001a\u0004\u0018\u00010\u0003J\u0010\u0010U\u001a\u00020\u00002\b\u0010v\u001a\u0004\u0018\u00010\u0003J\u0010\u0010b\u001a\u00020\u00002\b\u0010q\u001a\u0004\u0018\u00010\u0003J\u000e\u0010e\u001a\u00020\u00002\u0006\u0010w\u001a\u00020\u0003J\b\u0010x\u001a\u00020yH\u0002J\u000e\u0010z\u001a\u00020\u00002\u0006\u0010{\u001a\u000208J\u0012\u0010|\u001a\u0004\u0018\u00010\u00002\u0006\u0010}\u001a\u000208H\u0016J\u0010\u0010~\u001a\u00020\u00002\b\u0010\u007f\u001a\u0004\u0018\u00010\u001bJ\u0011\u0010\u0080\u0001\u001a\u00020\u00002\b\u0010o\u001a\u0004\u0018\u00010\u0012J\u001b\u0010\u0080\u0001\u001a\u00020\u00002\u0007\u0010\u0081\u0001\u001a\u00020\u00062\u0007\u0010\u0082\u0001\u001a\u000208H\u0002J\t\u0010\u0083\u0001\u001a\u00020\u0000H\u0002J3\u0010\u0084\u0001\u001a\u00020\u00002\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u00032\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00032\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00032\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0089\u0001\u001a\u00020\u00002\u0007\u0010\u008a\u0001\u001a\u000208J\u0010\u0010\u008b\u0001\u001a\u00020\u00002\u0007\u0010\u008c\u0001\u001a\u000208R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010\u0004R\u001c\u0010$\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0014\"\u0004\b&\u0010\u0016R\u001a\u0010'\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u000e\"\u0004\b)\u0010\u0010R\u001a\u0010*\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\b\"\u0004\b,\u0010\nR \u0010-\u001a\u00020\u0006X\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b.\u0010/\u001a\u0004\b0\u0010\b\"\u0004\b1\u0010\nR\u001a\u00102\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\"\"\u0004\b4\u0010\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\"\"\u0004\b6\u0010\u0004R\u001a\u00107\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00109\"\u0004\b:\u0010;R\u001a\u0010<\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00109\"\u0004\b&\u0010;R\u001a\u0010=\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00109\"\u0004\b>\u0010;R\u001a\u0010?\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u00109\"\u0004\b@\u0010;R\u001a\u0010A\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u00109\"\u0004\bB\u0010;R\u001a\u0010C\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u00109\"\u0004\bD\u0010;R\u001a\u0010E\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u00109\"\u0004\bF\u0010;R\u001a\u0010G\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\b\"\u0004\bI\u0010\nR\u001a\u0010J\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\b\"\u0004\bL\u0010\nR\u001a\u0010M\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\b\"\u0004\bO\u0010\nR\u001a\u0010P\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\b\"\u0004\bR\u0010\nR\u001c\u0010S\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\"\"\u0004\bU\u0010\u0004R\u001c\u0010V\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u0014\"\u0004\bX\u0010\u0016R\u001a\u0010Y\u001a\u00020ZX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u001a\u0010_\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u000e\"\u0004\ba\u0010\u0010R\u001e\u0010b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\b\"\u0004\bd\u0010\nR\u001a\u0010e\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010\b\"\u0004\bg\u0010\nR\u001a\u0010h\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\b\"\u0004\bj\u0010\nR\u000e\u0010k\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u008d\u0001"}, d2 = {"Lsdk/pendo/io/actions/PendoFloatingVisualGuideManager$Builder;", "", "id", "", "(Ljava/lang/String;)V", "actionbarSize", "", "getActionbarSize", "()I", "setActionbarSize", "(I)V", "activateDelay", "", "getActivateDelay", "()J", "setActivateDelay", "(J)V", "anchorView", "Landroid/view/View;", "getAnchorView", "()Landroid/view/View;", "setAnchorView", "(Landroid/view/View;)V", IterableConstants.ITERABLE_IN_APP_BGCOLOR, "getBgColor", "setBgColor", "closeCallback", "Lsdk/pendo/io/actions/PendoFloatingVisualGuideManager$FloatingGuideViewCallbacks;", "getCloseCallback", "()Lsdk/pendo/io/actions/PendoFloatingVisualGuideManager$FloatingGuideViewCallbacks;", "setCloseCallback", "(Lsdk/pendo/io/actions/PendoFloatingVisualGuideManager$FloatingGuideViewCallbacks;)V", "contentDescription", "getContentDescription", "()Ljava/lang/String;", "setContentDescription", "customView", "getCustomView", "setCustomView", "fadeDuration", "getFadeDuration", "setFadeDuration", "frameRadius", "getFrameRadius", "setFrameRadius", "gravity", "getGravity$annotations", "()V", "getGravity", "setGravity", "guideId", "getGuideId", "setGuideId", "getId", "setId", "isCompleted", "", "()Z", "setCompleted", "(Z)V", "isCustomView", "isHideArrow", "setHideArrow", "isRestrictToScreenEdges", "setRestrictToScreenEdges", "isSeeThrough", "setSeeThrough", "isShowBackDrop", "setShowBackDrop", "isTouchPassThrough", "setTouchPassThrough", "marginBottomPx", "getMarginBottomPx", "setMarginBottomPx", "marginLeftPx", "getMarginLeftPx", "setMarginLeftPx", "marginRightPx", "getMarginRightPx", "setMarginRightPx", "marginTopPx", "getMarginTopPx", "setMarginTopPx", "paneTitle", "getPaneTitle", "setPaneTitle", "rootView", "getRootView", "setRootView", "seeThroughRadius", "", "getSeeThroughRadius", "()F", "setSeeThroughRadius", "(F)V", "showDuration", "getShowDuration", "setShowDuration", "strokeColor", "getStrokeColor", "setStrokeColor", "strokeWidth", "getStrokeWidth", "setStrokeWidth", "textResId", "getTextResId", "setTextResId", "tooltipDefaultMarginPx", "actionBarSize", "ms", "anchor", "view", AppStateModule.APP_STATE_BACKGROUND, "color", OperatingSystem.JsonKeys.BUILD, "closePolicy", "milliseconds", "frameRadiusDpString", "title", "strokeWidthDpString", "throwIfCompleted", "", "toggleArrow", "show", "withBackDrop", "showBackDrop", "withCallback", "callback", "withCustomView", "resId", "replaceBackground", "withDefaultMargins", "withMargins", "marginTopDp", "marginLeftDp", "marginRightDp", "marginBottomDp", "withSeeThrough", "seeThrough", "withTouchPassThrough", "passThrough", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static class Builder {
        private int actionbarSize;
        private long activateDelay;
        private View anchorView;
        private FloatingGuideViewCallbacks closeCallback;
        private String contentDescription;
        private View customView;
        private int frameRadius;
        private int gravity;
        private String id;
        private boolean isCompleted;
        private boolean isCustomView;
        private boolean isHideArrow;
        private boolean isShowBackDrop;
        private boolean isTouchPassThrough;
        private int marginBottomPx;
        private int marginLeftPx;
        private int marginRightPx;
        private int marginTopPx;
        private String paneTitle;
        private View rootView;
        private float seeThroughRadius;
        private long showDuration;
        private final int tooltipDefaultMarginPx = q0.a(0.0f);
        private int textResId = R.layout.pnd_tooltip_textview;
        private String guideId = "";
        private boolean isRestrictToScreenEdges = true;
        private long fadeDuration = 200;
        private int bgColor = -12303292;
        private int strokeColor = -12303292;
        private int strokeWidth = q0.a(1.3f);
        private boolean isSeeThrough = true;

        public Builder(String str) {
            this.id = str;
            withDefaultMargins();
        }

        public static /* synthetic */ void getGravity$annotations() {
        }

        private final void throwIfCompleted() {
            if (!(!this.isCompleted)) {
                throw new IllegalStateException("Builder cannot be modified".toString());
            }
        }

        private final Builder withCustomView(int resId, boolean replaceBackground) {
            this.textResId = resId;
            this.isCustomView = replaceBackground;
            return this;
        }

        private final Builder withDefaultMargins() {
            int i = this.tooltipDefaultMarginPx;
            this.marginBottomPx = i;
            this.marginRightPx = i;
            this.marginLeftPx = i;
            this.marginTopPx = i;
            return this;
        }

        public final Builder actionBarSize(int actionBarSize) {
            throwIfCompleted();
            this.actionbarSize = actionBarSize;
            return this;
        }

        public final Builder activateDelay(long ms) {
            throwIfCompleted();
            this.activateDelay = ms;
            return this;
        }

        public final Builder anchor(View view, int gravity) {
            throwIfCompleted();
            this.anchorView = view;
            this.gravity = gravity;
            return this;
        }

        public final Builder background(String color) {
            this.bgColor = Color.parseColor(color);
            return this;
        }

        public Builder build() {
            throwIfCompleted();
            this.isCompleted = true;
            return this;
        }

        public final Builder closePolicy(long milliseconds) {
            throwIfCompleted();
            this.showDuration = milliseconds;
            return this;
        }

        public final Builder frameRadius(String frameRadiusDpString) {
            Intrinsics.checkNotNullParameter(frameRadiusDpString, "frameRadiusDpString");
            this.frameRadius = k0.a(frameRadiusDpString, this.frameRadius);
            return this;
        }

        public final int getActionbarSize() {
            return this.actionbarSize;
        }

        public final long getActivateDelay() {
            return this.activateDelay;
        }

        public final View getAnchorView() {
            return this.anchorView;
        }

        public final int getBgColor() {
            return this.bgColor;
        }

        public final FloatingGuideViewCallbacks getCloseCallback() {
            return this.closeCallback;
        }

        public final String getContentDescription() {
            return this.contentDescription;
        }

        public final View getCustomView() {
            return this.customView;
        }

        public final long getFadeDuration() {
            return this.fadeDuration;
        }

        public final int getFrameRadius() {
            return this.frameRadius;
        }

        public final int getGravity() {
            return this.gravity;
        }

        public final String getGuideId() {
            return this.guideId;
        }

        public final String getId() {
            return this.id;
        }

        public final int getMarginBottomPx() {
            return this.marginBottomPx;
        }

        public final int getMarginLeftPx() {
            return this.marginLeftPx;
        }

        public final int getMarginRightPx() {
            return this.marginRightPx;
        }

        public final int getMarginTopPx() {
            return this.marginTopPx;
        }

        public final String getPaneTitle() {
            return this.paneTitle;
        }

        public final View getRootView() {
            return this.rootView;
        }

        public final float getSeeThroughRadius() {
            return this.seeThroughRadius;
        }

        public final long getShowDuration() {
            return this.showDuration;
        }

        public final int getStrokeColor() {
            return this.strokeColor;
        }

        public final int getStrokeWidth() {
            return this.strokeWidth;
        }

        public final int getTextResId() {
            return this.textResId;
        }

        public final Builder guideId(String guideId) {
            Intrinsics.checkNotNullParameter(guideId, "guideId");
            throwIfCompleted();
            this.guideId = guideId;
            return this;
        }

        /* renamed from: isCompleted, reason: from getter */
        public final boolean getIsCompleted() {
            return this.isCompleted;
        }

        /* renamed from: isCustomView, reason: from getter */
        public final boolean getIsCustomView() {
            return this.isCustomView;
        }

        /* renamed from: isHideArrow, reason: from getter */
        public final boolean getIsHideArrow() {
            return this.isHideArrow;
        }

        /* renamed from: isRestrictToScreenEdges, reason: from getter */
        public final boolean getIsRestrictToScreenEdges() {
            return this.isRestrictToScreenEdges;
        }

        /* renamed from: isSeeThrough, reason: from getter */
        public final boolean getIsSeeThrough() {
            return this.isSeeThrough;
        }

        /* renamed from: isShowBackDrop, reason: from getter */
        public final boolean getIsShowBackDrop() {
            return this.isShowBackDrop;
        }

        /* renamed from: isTouchPassThrough, reason: from getter */
        public final boolean getIsTouchPassThrough() {
            return this.isTouchPassThrough;
        }

        public final Builder seeThroughRadius(float seeThroughRadius) {
            this.seeThroughRadius = seeThroughRadius;
            return this;
        }

        public final void setActionbarSize(int i) {
            this.actionbarSize = i;
        }

        public final void setActivateDelay(long j) {
            this.activateDelay = j;
        }

        public final void setAnchorView(View view) {
            this.anchorView = view;
        }

        public final void setBgColor(int i) {
            this.bgColor = i;
        }

        public final void setCloseCallback(FloatingGuideViewCallbacks floatingGuideViewCallbacks) {
            this.closeCallback = floatingGuideViewCallbacks;
        }

        public final void setCompleted(boolean z) {
            this.isCompleted = z;
        }

        public final Builder setContentDescription(String contentDescription) {
            this.contentDescription = contentDescription;
            return this;
        }

        public final void setCustomView(View view) {
            this.customView = view;
        }

        public final void setFadeDuration(long j) {
            this.fadeDuration = j;
        }

        public final void setFrameRadius(int i) {
            this.frameRadius = i;
        }

        public final void setGravity(int i) {
            this.gravity = i;
        }

        public final void setGuideId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.guideId = str;
        }

        public final void setHideArrow(boolean z) {
            this.isHideArrow = z;
        }

        public final void setId(String str) {
            this.id = str;
        }

        public final void setMarginBottomPx(int i) {
            this.marginBottomPx = i;
        }

        public final void setMarginLeftPx(int i) {
            this.marginLeftPx = i;
        }

        public final void setMarginRightPx(int i) {
            this.marginRightPx = i;
        }

        public final void setMarginTopPx(int i) {
            this.marginTopPx = i;
        }

        public final Builder setPaneTitle(final String title) {
            j0.a(title, new Function1<String, Unit>() { // from class: sdk.pendo.io.actions.PendoFloatingVisualGuideManager$Builder$setPaneTitle$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                    PendoFloatingVisualGuideManager.Builder.this.m3026setPaneTitle(title);
                }
            });
            return this;
        }

        public final void setRestrictToScreenEdges(boolean z) {
            this.isRestrictToScreenEdges = z;
        }

        public final void setRootView(View view) {
            this.rootView = view;
        }

        public final void setSeeThrough(boolean z) {
            this.isSeeThrough = z;
        }

        public final void setSeeThroughRadius(float f) {
            this.seeThroughRadius = f;
        }

        public final void setShowBackDrop(boolean z) {
            this.isShowBackDrop = z;
        }

        public final void setShowDuration(long j) {
            this.showDuration = j;
        }

        public final void setStrokeColor(int i) {
            this.strokeColor = i;
        }

        public final void setStrokeWidth(int i) {
            this.strokeWidth = i;
        }

        public final void setTextResId(int i) {
            this.textResId = i;
        }

        public final void setTouchPassThrough(boolean z) {
            this.isTouchPassThrough = z;
        }

        public final Builder strokeColor(String color) {
            this.strokeColor = Color.parseColor(color);
            return this;
        }

        public final Builder strokeWidth(String strokeWidthDpString) {
            Intrinsics.checkNotNullParameter(strokeWidthDpString, "strokeWidthDpString");
            this.strokeWidth = k0.a(strokeWidthDpString, this.strokeWidth);
            return this;
        }

        public final Builder toggleArrow(boolean show) {
            throwIfCompleted();
            this.isHideArrow = !show;
            return this;
        }

        public Builder withBackDrop(boolean showBackDrop) {
            this.isShowBackDrop = showBackDrop;
            return this;
        }

        public final Builder withCallback(FloatingGuideViewCallbacks callback) {
            throwIfCompleted();
            this.closeCallback = callback;
            return this;
        }

        public final Builder withMargins(String marginTopDp, String marginLeftDp, String marginRightDp, String marginBottomDp) {
            this.marginTopPx = k0.a(marginTopDp, this.tooltipDefaultMarginPx);
            this.marginLeftPx = k0.a(marginLeftDp, this.tooltipDefaultMarginPx);
            this.marginRightPx = k0.a(marginRightDp, this.tooltipDefaultMarginPx);
            this.marginBottomPx = k0.a(marginBottomDp, this.tooltipDefaultMarginPx);
            return this;
        }

        public final Builder withSeeThrough(boolean seeThrough) {
            this.isSeeThrough = seeThrough;
            return this;
        }

        public final Builder withTouchPassThrough(boolean passThrough) {
            this.isTouchPassThrough = passThrough;
            return this;
        }

        /* renamed from: setContentDescription, reason: collision with other method in class */
        public final void m3025setContentDescription(String str) {
            this.contentDescription = str;
        }

        public final void setCustomView(boolean z) {
            this.isCustomView = z;
        }

        /* renamed from: setPaneTitle, reason: collision with other method in class */
        public final void m3026setPaneTitle(String str) {
            this.paneTitle = str;
        }

        public final Builder withCustomView(View view) {
            throwIfCompleted();
            this.customView = view;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e0\rH\u0004J\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bH\u0007J\u0017\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0019\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R&\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e0\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Lsdk/pendo/io/actions/PendoFloatingVisualGuideManager$Companion;", "", "()V", "DEFAULT_MARGIN_IN_DP", "", "DEFAULT_STROKE_WIDTH", "TAG", "", "kotlin.jvm.PlatformType", "mContextRef", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "sGravityMap", "", "", "getSGravityMap", "()Ljava/util/Map;", "setSGravityMap", "(Ljava/util/Map;)V", "createGravityMap", "getContextRef", "resetContext", "", "context", "valueOfGravity", "property", "(Ljava/lang/String;)Ljava/lang/Integer;", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        protected final Map<String, Integer> createGravityMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("TOP", 2);
            hashMap.put("LEFT", 0);
            hashMap.put("BOTTOM", 3);
            hashMap.put("RIGHT", 1);
            hashMap.put("CENTER", 4);
            return hashMap;
        }

        public final WeakReference<Context> getContextRef() {
            return PendoFloatingVisualGuideManager.mContextRef;
        }

        public final Map<String, Integer> getSGravityMap() {
            return PendoFloatingVisualGuideManager.sGravityMap;
        }

        @JvmStatic
        public final void resetContext(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            PendoFloatingVisualGuideManager.mContextRef = new WeakReference<>(context);
        }

        public final void setSGravityMap(Map<String, Integer> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            PendoFloatingVisualGuideManager.sGravityMap = map;
        }

        @JvmStatic
        public final Integer valueOfGravity(String property) {
            Intrinsics.checkNotNullParameter(property, "property");
            return getSGravityMap().get(property);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\u0003H&J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&¨\u0006\u0010"}, d2 = {"Lsdk/pendo/io/actions/PendoFloatingVisualGuideManager$FloatingGuideViewCallbacks;", "", "onClosing", "", "fromUser", "", IterableConstants.ITERABLE_INBOX_IMP_DISPLAY_DURATION, "", "wasShown", "onDetach", "onReadyForShow", GuideActionConfiguration.GUIDE_SCREEN_CONTENT_GUIDE, "Landroid/view/ViewGroup;", "onTouchOutside", "id", "", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface FloatingGuideViewCallbacks {
        void onClosing(boolean fromUser, long displayDuration, boolean wasShown);

        void onDetach();

        void onReadyForShow(ViewGroup guide);

        void onTouchOutside(String id);
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lsdk/pendo/io/actions/PendoFloatingVisualGuideManager$Gravity;", "", "Companion", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Gravity {
        public static final int BOTTOM = 3;
        public static final String BOTTOM_STR = "BOTTOM";
        public static final int CENTER = 4;
        public static final String CENTER_STR = "CENTER";

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int LEFT = 0;
        public static final String LEFT_STR = "LEFT";
        public static final int RIGHT = 1;
        public static final String RIGHT_STR = "RIGHT";
        public static final int TOP = 2;
        public static final String TOP_STR = "TOP";

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lsdk/pendo/io/actions/PendoFloatingVisualGuideManager$Gravity$Companion;", "", "()V", "BOTTOM", "", "BOTTOM_STR", "", "CENTER", "CENTER_STR", "LEFT", "LEFT_STR", "RIGHT", "RIGHT_STR", "TOP", "TOP_STR", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int BOTTOM = 3;
            public static final String BOTTOM_STR = "BOTTOM";
            public static final int CENTER = 4;
            public static final String CENTER_STR = "CENTER";
            public static final int LEFT = 0;
            public static final String LEFT_STR = "LEFT";
            public static final int RIGHT = 1;
            public static final String RIGHT_STR = "RIGHT";
            public static final int TOP = 2;
            public static final String TOP_STR = "TOP";

            private Companion() {
            }
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        TAG = "PendoFloatingVisualGuideManager";
        sGravityMap = companion.createGravityMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mFloatingGuideListener$lambda$0(PendoFloatingVisualGuideManager this$0, PendoFloatingVisualGuideView layout) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(layout, "layout");
        String str = TAG;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(" onHideCompleted guideId: %s", Arrays.copyOf(new Object[]{layout.getFloatingGuideId()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        PendoLogger.i(str + format, new Object[0]);
        String floatingGuideId = layout.getFloatingGuideId();
        Intrinsics.checkNotNullExpressionValue(floatingGuideId, "getFloatingGuideId(...)");
        this$0.remove(floatingGuideId);
    }

    @JvmStatic
    public static final void resetContext(Context context) {
        INSTANCE.resetContext(context);
    }

    @JvmStatic
    public static final Integer valueOfGravity(String str) {
        return INSTANCE.valueOfGravity(str);
    }

    public final boolean active(int id) {
        boolean containsKey;
        synchronized (this.mLock) {
            containsKey = this.mFloatingGuides.containsKey(String.valueOf(id));
        }
        return containsKey;
    }

    public final b get(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        synchronized (this.mLock) {
            WeakReference<PendoFloatingVisualGuideView> weakReference = this.mFloatingGuides.get(id);
            if (weakReference != null) {
                return weakReference.get();
            }
            Unit unit = Unit.INSTANCE;
            return null;
        }
    }

    public final void remove(String id) {
        PendoFloatingVisualGuideView pendoFloatingVisualGuideView;
        Intrinsics.checkNotNullParameter(id, "id");
        WeakReference<PendoFloatingVisualGuideView> removeFromMap = removeFromMap(id);
        if (removeFromMap == null || (pendoFloatingVisualGuideView = removeFromMap.get()) == null) {
            return;
        }
        pendoFloatingVisualGuideView.removeFromParent();
    }

    public final WeakReference<PendoFloatingVisualGuideView> removeFromMap(String id) {
        WeakReference<PendoFloatingVisualGuideView> remove;
        Intrinsics.checkNotNullParameter(id, "id");
        synchronized (this.mLock) {
            remove = this.mFloatingGuides.remove(id);
        }
        return remove;
    }
}
