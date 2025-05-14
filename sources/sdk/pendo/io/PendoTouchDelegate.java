package sdk.pendo.io;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;
import sdk.pendo.io.actions.PendoCommand;
import sdk.pendo.io.e9.a;
import sdk.pendo.io.g9.o0;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.sdk.react.PlatformStateManager;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 82\u00020\u00012\u00020\u0002:\u0002\t9B'\u0012\b\u00105\u001a\u0004\u0018\u000104\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b6\u00107J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u001a\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u000e\u0010\t\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0001J\u0010\u0010\t\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0017J\u0006\u0010\t\u001a\u00020\u000fR\u0014\u0010\u0013\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0012R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R*\u0010!\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u001a\u0010\u001b\u0012\u0004\b\u001f\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\t\u0010\u001eR\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\"\u0010+\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b\u0016\u0010)\"\u0004\b\t\u0010*R*\u00103\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b,\u0010-\u0012\u0004\b2\u0010 \u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u0006:"}, d2 = {"Lsdk/pendo/io/PendoTouchDelegate;", "Landroid/view/TouchDelegate;", "Landroid/view/View$OnTouchListener;", "Landroid/view/MotionEvent;", "event", "", "b", "Lorg/json/JSONObject;", "viewElementInfo", "a", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "v", "onTouch", "touchDelegate", "", "onTouchEvent", "onTouchExplorationHoverEvent", "Landroid/view/View;", "delegateView", "Ljava/lang/ref/WeakReference;", "analyticsView", "c", "Landroid/view/TouchDelegate;", "originalTouchDelegate", "Lsdk/pendo/io/b6/b;", "d", "Lsdk/pendo/io/b6/b;", "getMSubscription", "()Lsdk/pendo/io/b6/b;", "(Lsdk/pendo/io/b6/b;)V", "getMSubscription$annotations", "()V", "mSubscription", "", "e", "J", "mLastEventTime", "Lsdk/pendo/io/PendoTouchDelegate$OnTouchEventState;", "f", "Lsdk/pendo/io/PendoTouchDelegate$OnTouchEventState;", "()Lsdk/pendo/io/PendoTouchDelegate$OnTouchEventState;", "(Lsdk/pendo/io/PendoTouchDelegate$OnTouchEventState;)V", "onTouchEventHandlerState", "g", "Landroid/view/MotionEvent;", "getEventOnClick", "()Landroid/view/MotionEvent;", "setEventOnClick", "(Landroid/view/MotionEvent;)V", "getEventOnClick$annotations", "eventOnClick", "Landroid/graphics/Rect;", "bounds", "<init>", "(Landroid/graphics/Rect;Landroid/view/View;Ljava/lang/ref/WeakReference;)V", "h", "OnTouchEventState", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class PendoTouchDelegate extends TouchDelegate implements View.OnTouchListener {
    private static String i = "";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final View delegateView;

    /* renamed from: b, reason: from kotlin metadata */
    private final WeakReference<View> analyticsView;

    /* renamed from: c, reason: from kotlin metadata */
    private TouchDelegate originalTouchDelegate;

    /* renamed from: d, reason: from kotlin metadata */
    private sdk.pendo.io.b6.b mSubscription;

    /* renamed from: e, reason: from kotlin metadata */
    private long mLastEventTime;

    /* renamed from: f, reason: from kotlin metadata */
    private OnTouchEventState onTouchEventHandlerState;

    /* renamed from: g, reason: from kotlin metadata */
    private MotionEvent eventOnClick;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lsdk/pendo/io/PendoTouchDelegate$OnTouchEventState;", "", "(Ljava/lang/String;I)V", "PENDO_TOUCH_DELEGATE", "EXTERNAL_API", "NONE", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class OnTouchEventState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ OnTouchEventState[] $VALUES;
        public static final OnTouchEventState PENDO_TOUCH_DELEGATE = new OnTouchEventState("PENDO_TOUCH_DELEGATE", 0);
        public static final OnTouchEventState EXTERNAL_API = new OnTouchEventState("EXTERNAL_API", 1);
        public static final OnTouchEventState NONE = new OnTouchEventState("NONE", 2);

        static {
            OnTouchEventState[] a2 = a();
            $VALUES = a2;
            $ENTRIES = EnumEntriesKt.enumEntries(a2);
        }

        private OnTouchEventState(String str, int i) {
        }

        private static final /* synthetic */ OnTouchEventState[] a() {
            return new OnTouchEventState[]{PENDO_TOUCH_DELEGATE, EXTERNAL_API, NONE};
        }

        public static OnTouchEventState valueOf(String str) {
            return (OnTouchEventState) Enum.valueOf(OnTouchEventState.class, str);
        }

        public static OnTouchEventState[] values() {
            return (OnTouchEventState[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lsdk/pendo/io/actions/PendoCommand;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lsdk/pendo/io/actions/PendoCommand;)V"}, k = 3, mv = {1, 9, 0})
    static final class b extends Lambda implements Function1<PendoCommand, Unit> {
        final /* synthetic */ MotionEvent s;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(MotionEvent motionEvent) {
            super(1);
            this.s = motionEvent;
        }

        public final void a(PendoCommand pendoCommand) {
            PendoTouchDelegate.this.a(this.s);
            PendoTouchDelegate.this.a((sdk.pendo.io.b6.b) null);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PendoCommand pendoCommand) {
            a(pendoCommand);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PendoTouchDelegate(Rect rect, View delegateView, WeakReference<View> analyticsView) {
        super(rect, delegateView);
        Intrinsics.checkNotNullParameter(delegateView, "delegateView");
        Intrinsics.checkNotNullParameter(analyticsView, "analyticsView");
        this.delegateView = delegateView;
        this.analyticsView = analyticsView;
        this.onTouchEventHandlerState = OnTouchEventState.NONE;
    }

    public final void a() {
        sdk.pendo.io.b6.b bVar = this.mSubscription;
        if (bVar != null) {
            bVar.dispose();
        }
        this.mSubscription = null;
        MotionEvent motionEvent = this.eventOnClick;
        if (motionEvent != null) {
            a(motionEvent);
        }
        this.eventOnClick = null;
    }

    public final WeakReference<View> b() {
        return this.analyticsView;
    }

    /* renamed from: c, reason: from getter */
    public final OnTouchEventState getOnTouchEventHandlerState() {
        return this.onTouchEventHandlerState;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return onTouchEvent(event);
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!PendoInternal.U()) {
            return b(event);
        }
        if (this.onTouchEventHandlerState == OnTouchEventState.NONE) {
            this.onTouchEventHandlerState = OnTouchEventState.PENDO_TOUCH_DELEGATE;
        }
        if (this.onTouchEventHandlerState == OnTouchEventState.EXTERNAL_API) {
            return b(event);
        }
        if (event.getAction() == 1) {
            PlatformStateManager platformStateManager = PlatformStateManager.INSTANCE;
            if (platformStateManager.isReactNativeAnalyticsEnabled()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.mLastEventTime < 500) {
                    return b(event);
                }
                this.mLastEventTime = currentTimeMillis;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                View view = this.analyticsView.get();
                if (!platformStateManager.isAppAnalyticsDisabled() && view != null) {
                    jSONObject = o0.f1142a.b(view);
                    a.f1035a.a(jSONObject, false);
                }
                if (event.getEventTime() - event.getDownTime() < ViewConfiguration.getLongPressTimeout()) {
                    this.eventOnClick = event;
                    return a(event, jSONObject);
                }
            } catch (Exception e) {
                PendoLogger.e(e, e.getMessage(), "PendoTouchDelegate onTouchEvent event action " + event.getAction());
            }
        }
        return b(event);
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchExplorationHoverEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        TouchDelegate touchDelegate = this.originalTouchDelegate;
        if (touchDelegate != null) {
            return touchDelegate.onTouchExplorationHoverEvent(event);
        }
        return false;
    }

    private final boolean b(MotionEvent event) {
        TouchDelegate touchDelegate = this.originalTouchDelegate;
        if (touchDelegate != null) {
            return touchDelegate.onTouchEvent(event);
        }
        return false;
    }

    public final void a(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        TouchDelegate touchDelegate = this.originalTouchDelegate;
        if (touchDelegate != null) {
            touchDelegate.onTouchEvent(event);
        } else {
            this.delegateView.performClick();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean a(android.view.MotionEvent r7, org.json.JSONObject r8) {
        /*
            r6 = this;
            java.lang.String r0 = "Clicked view: "
            java.lang.String r1 = ""
            boolean r2 = sdk.pendo.io.actions.GuidesActionsManager.isActivityDestroyed()
            r3 = 1
            android.view.View r4 = r6.delegateView     // Catch: java.lang.Exception -> L3f
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L3f
            r5.<init>(r0)     // Catch: java.lang.Exception -> L3f
            java.lang.StringBuilder r0 = r5.append(r4)     // Catch: java.lang.Exception -> L3f
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L3f
            r4 = 0
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Exception -> L3f
            sdk.pendo.io.logging.PendoLogger.d(r0, r4)     // Catch: java.lang.Exception -> L3f
            if (r2 != 0) goto L43
            sdk.pendo.io.n9.a r0 = sdk.pendo.io.n9.a.f1445a     // Catch: java.lang.Exception -> L3f
            android.view.View r2 = r6.delegateView     // Catch: java.lang.Exception -> L3f
            sdk.pendo.io.sdk.react.PlatformStateManager r4 = sdk.pendo.io.sdk.react.PlatformStateManager.INSTANCE     // Catch: java.lang.Exception -> L3f
            r0.a(r2, r4)     // Catch: java.lang.Exception -> L3f
            sdk.pendo.io.actions.ActivationManager r0 = sdk.pendo.io.actions.ActivationManager.INSTANCE     // Catch: java.lang.Exception -> L3f
            java.lang.ref.WeakReference r2 = new java.lang.ref.WeakReference     // Catch: java.lang.Exception -> L3f
            android.view.View r4 = r6.delegateView     // Catch: java.lang.Exception -> L3f
            r2.<init>(r4)     // Catch: java.lang.Exception -> L3f
            java.lang.String r8 = r0.handleClick(r8, r2)     // Catch: java.lang.Exception -> L3f
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r1)     // Catch: java.lang.Exception -> L3c
            r1 = r8
            goto L44
        L3c:
            r0 = move-exception
            r1 = r8
            goto L40
        L3f:
            r0 = move-exception
        L40:
            sdk.pendo.io.logging.PendoLogger.d(r0)
        L43:
            r0 = r3
        L44:
            if (r0 != 0) goto L84
            sdk.pendo.io.sdk.react.PlatformStateManager r8 = sdk.pendo.io.sdk.react.PlatformStateManager.INSTANCE
            boolean r8 = r8.isReactNativeAnalyticsEnabled()
            if (r8 != 0) goto L84
            sdk.pendo.io.b6.b r8 = r6.mSubscription
            if (r8 == 0) goto L53
            goto L84
        L53:
            sdk.pendo.io.actions.PendoCommandsEventBus r8 = sdk.pendo.io.actions.PendoCommandsEventBus.getInstance()     // Catch: java.lang.Exception -> L7f
            sdk.pendo.io.x5.d r8 = r8.getCommandEventBus()     // Catch: java.lang.Exception -> L7f
            sdk.pendo.io.x5.f r0 = sdk.pendo.io.actions.VisualAnimationManager.waitForAnimationDoneAndNotifyClose(r1)     // Catch: java.lang.Exception -> L7f
            sdk.pendo.io.x5.d r8 = r8.a(r0)     // Catch: java.lang.Exception -> L7f
            sdk.pendo.io.x5.g r8 = r8.b()     // Catch: java.lang.Exception -> L7f
            sdk.pendo.io.PendoTouchDelegate$b r0 = new sdk.pendo.io.PendoTouchDelegate$b     // Catch: java.lang.Exception -> L7f
            r0.<init>(r7)     // Catch: java.lang.Exception -> L7f
            sdk.pendo.io.PendoTouchDelegate$$ExternalSyntheticLambda0 r7 = new sdk.pendo.io.PendoTouchDelegate$$ExternalSyntheticLambda0     // Catch: java.lang.Exception -> L7f
            r7.<init>()     // Catch: java.lang.Exception -> L7f
            sdk.pendo.io.a9.a r0 = new sdk.pendo.io.a9.a     // Catch: java.lang.Exception -> L7f
            java.lang.String r1 = "PendoTouchDelegate runGuideFollowedByHostAppClicks command bus error consumer"
            r0.<init>(r1)     // Catch: java.lang.Exception -> L7f
            sdk.pendo.io.b6.b r7 = r8.a(r7, r0)     // Catch: java.lang.Exception -> L7f
            r6.mSubscription = r7     // Catch: java.lang.Exception -> L7f
            goto L83
        L7f:
            r7 = move-exception
            sdk.pendo.io.logging.PendoLogger.e(r7)
        L83:
            return r3
        L84:
            boolean r7 = r6.b(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.PendoTouchDelegate.a(android.view.MotionEvent, org.json.JSONObject):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void a(sdk.pendo.io.b6.b bVar) {
        this.mSubscription = bVar;
    }

    public final void a(OnTouchEventState onTouchEventState) {
        Intrinsics.checkNotNullParameter(onTouchEventState, "<set-?>");
        this.onTouchEventHandlerState = onTouchEventState;
    }

    public final void a(TouchDelegate touchDelegate) {
        Intrinsics.checkNotNullParameter(touchDelegate, "touchDelegate");
        this.originalTouchDelegate = touchDelegate;
    }
}
