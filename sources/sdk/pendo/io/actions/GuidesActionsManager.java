package sdk.pendo.io.actions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import sdk.pendo.io.actions.PendoCommand;
import sdk.pendo.io.actions.PendoCommandAction;
import sdk.pendo.io.actions.PendoCommandEventType;
import sdk.pendo.io.actions.handlers.PendoGlobalCommandHandler;
import sdk.pendo.io.i8.g;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.w6.a;

/* loaded from: classes6.dex */
public final class GuidesActionsManager implements GuidesActionsManagerInterface {
    private static volatile GuidesActionsManager INSTANCE = null;
    private static final String TAG = "GuidesActionsManager";
    private final HashSet<String> mFullyDisplayedGuidesAfterAnimation = new HashSet<>();
    private static final AtomicBoolean S_ACTIVITY_DESTROYED = new AtomicBoolean(false);
    private static final Map<String, a<Boolean>> sGuideInited = new HashMap();
    private static final Object GUIDE_INITED_LOCK = new Object();

    private GuidesActionsManager() {
    }

    public static synchronized GuidesActionsManagerInterface getInstance() {
        GuidesActionsManager guidesActionsManager;
        synchronized (GuidesActionsManager.class) {
            if (INSTANCE == null) {
                throw new IllegalStateException("Need to be instantiated first!");
            }
            guidesActionsManager = INSTANCE;
        }
        return guidesActionsManager;
    }

    public static synchronized void init() {
        synchronized (GuidesActionsManager.class) {
            if (INSTANCE != null) {
                PendoLogger.w(TAG, "Cannot init more than once.");
                throw new g("GuidesActionsManager already initiated.");
            }
            INSTANCE = new GuidesActionsManager();
        }
    }

    public static boolean isActivityDestroyed() {
        return S_ACTIVITY_DESTROYED.getAndSet(false);
    }

    public static synchronized boolean isInited() {
        boolean z;
        synchronized (GuidesActionsManager.class) {
            z = INSTANCE != null;
        }
        return z;
    }

    static void removeVisualGuideInitedObservable(String str) {
        a<Boolean> remove;
        synchronized (GUIDE_INITED_LOCK) {
            if (!str.isEmpty() && (remove = sGuideInited.remove(str)) != null) {
                remove.onComplete();
            }
        }
    }

    public static void setVisualGuideStepInited(String str, boolean z) {
        synchronized (GUIDE_INITED_LOCK) {
            if (!str.isEmpty()) {
                a<Boolean> b = a.b(Boolean.valueOf(z));
                Map<String, a<Boolean>> map = sGuideInited;
                if (map.containsKey(str)) {
                    map.get(str).onNext(Boolean.valueOf(z));
                } else {
                    map.put(str, b);
                }
            }
        }
    }

    @Override // sdk.pendo.io.actions.GuidesActionsManagerInterface
    public void dismissVisibleGuides() {
        if (!isInited()) {
            throw new g("Pendo SDK must be initialized before calling this method.");
        }
        PendoLogger.d(TAG, "dismissing visible guides");
        PendoCommandDispatcher.getInstance().dispatchCommand(new PendoCommand.Builder(PendoCommandAction.PendoCommandGlobalAction.DISMISS_GUIDE, PendoCommandEventType.SdkEventType.HOST_APP_DEVELOPER_CALL).setSourceId(VisualGuideBase.DISMISS_VISIBLE_GUIDES).setDestinationId(PendoGlobalCommandHandler.PENDO_GLOBAL_COMMAND_DEST).build(), true);
    }

    @Override // sdk.pendo.io.actions.GuidesActionsManagerInterface
    public void removeGuideFullyDisplayedAfterAnimation(String str) {
        this.mFullyDisplayedGuidesAfterAnimation.remove(str);
    }

    @Override // sdk.pendo.io.actions.GuidesActionsManagerInterface
    public void setGuideFullyDisplayedAfterAnimation(String str) {
        this.mFullyDisplayedGuidesAfterAnimation.add(str);
    }

    @Override // sdk.pendo.io.actions.GuidesActionsManagerInterface
    public boolean wasGuideFullyDisplayedAfterAnimation(String str) {
        return this.mFullyDisplayedGuidesAfterAnimation.contains(str);
    }
}
