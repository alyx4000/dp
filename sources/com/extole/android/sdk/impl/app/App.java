package com.extole.android.sdk.impl.app;

import com.extole.android.sdk.ExtoleLogger;
import com.extole.android.sdk.impl.ExtoleInternal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: App.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0013\u001a\u0004\u0018\u00010\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/extole/android/sdk/impl/app/App;", "", "()V", "LOAD_DONE_EVENT", "", "LOAD_EVENTS", "", "appInitialized", "", "eventsQueue", "Ljava/util/LinkedList;", "Lcom/extole/android/sdk/impl/app/AppEvent;", "extole", "Lcom/extole/android/sdk/impl/ExtoleInternal;", "getExtole", "()Lcom/extole/android/sdk/impl/ExtoleInternal;", "setExtole", "(Lcom/extole/android/sdk/impl/ExtoleInternal;)V", "eventCanBeProcessed", "appEvent", "onMessageEvent", "", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class App {
    public static final String LOAD_DONE_EVENT = "load_done";
    private static boolean appInitialized;
    public static ExtoleInternal extole;
    public static final App INSTANCE = new App();
    private static final LinkedList<AppEvent> eventsQueue = new LinkedList<>();
    private static final List<String> LOAD_EVENTS = CollectionsKt.listOf((Object[]) new String[]{"on_load", "app_initialized"});

    private App() {
    }

    public final ExtoleInternal getExtole() {
        ExtoleInternal extoleInternal = extole;
        if (extoleInternal != null) {
            return extoleInternal;
        }
        Intrinsics.throwUninitializedPropertyAccessException("extole");
        return null;
    }

    public final void setExtole(ExtoleInternal extoleInternal) {
        Intrinsics.checkNotNullParameter(extoleInternal, "<set-?>");
        extole = extoleInternal;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessageEvent(AppEvent appEvent) {
        if (appEvent != null) {
            eventsQueue.add(appEvent);
        }
        if (Intrinsics.areEqual(appEvent != null ? appEvent.getEventName() : null, LOAD_DONE_EVENT)) {
            appInitialized = true;
            ExtoleLogger logger = getExtole().getLogger();
            StringBuilder sb = new StringBuilder("App initialized, queued events ");
            LinkedList<AppEvent> linkedList = eventsQueue;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(linkedList, 10));
            Iterator<T> it = linkedList.iterator();
            while (it.hasNext()) {
                arrayList.add(((AppEvent) it.next()).getEventName());
            }
            logger.debug(sb.append(arrayList).toString(), new Object[0]);
        }
        while (eventCanBeProcessed(appEvent)) {
            BuildersKt__BuildersKt.runBlocking$default(null, new App$onMessageEvent$3(eventsQueue.poll(), null), 1, null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0014, code lost:
    
        if (kotlin.collections.CollectionsKt.contains(com.extole.android.sdk.impl.app.App.LOAD_EVENTS, r2 != null ? r2.getEventName() : null) != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean eventCanBeProcessed(com.extole.android.sdk.impl.app.AppEvent r2) {
        /*
            r1 = this;
            boolean r0 = com.extole.android.sdk.impl.app.App.appInitialized
            if (r0 != 0) goto L16
            java.util.List<java.lang.String> r0 = com.extole.android.sdk.impl.app.App.LOAD_EVENTS
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            if (r2 == 0) goto Lf
            java.lang.String r2 = r2.getEventName()
            goto L10
        Lf:
            r2 = 0
        L10:
            boolean r2 = kotlin.collections.CollectionsKt.contains(r0, r2)
            if (r2 == 0) goto L23
        L16:
            java.util.LinkedList<com.extole.android.sdk.impl.app.AppEvent> r2 = com.extole.android.sdk.impl.app.App.eventsQueue
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r0 = 1
            r2 = r2 ^ r0
            if (r2 == 0) goto L23
            goto L24
        L23:
            r0 = 0
        L24:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.extole.android.sdk.impl.app.App.eventCanBeProcessed(com.extole.android.sdk.impl.app.AppEvent):boolean");
    }
}
