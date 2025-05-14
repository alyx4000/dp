package sdk.pendo.io.f9;

import android.app.Activity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import sdk.pendo.io.Pendo;
import sdk.pendo.io.g9.q0;
import sdk.pendo.io.listeners.views.PendoDrawerListener;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.sdk.react.PlatformStateManager;
import sdk.pendo.io.sdk.xamarin.XamarinBridge;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016JV\u0010\u0006\u001a\u00020\u00042\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J.\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J`\u0010\u0006\u001a\u00020\u00042\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0006\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0007J8\u0010\u0006\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000fH\u0007R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u001b¨\u0006 "}, d2 = {"Lsdk/pendo/io/f9/j;", "Lsdk/pendo/io/f9/e;", "Lsdk/pendo/io/sdk/react/PlatformStateManager;", "platformStateManager", "", "currentScreenId", "a", "Ljava/util/ArrayList;", "Lsdk/pendo/io/f9/d;", "Lkotlin/collections/ArrayList;", "fragmentsInfoList", "Landroid/app/Activity;", "activity", "Lsdk/pendo/io/g9/q0$b;", "rootViewData", "", "isOldScreenIdFormat", "isIgnoreDynamicFragmentsInScrollView", "Lsdk/pendo/io/listeners/views/PendoDrawerListener;", "drawerListener", "Lsdk/pendo/io/sdk/xamarin/XamarinBridge;", Pendo.PendoOptions.XAMARIN_BRIDGE, "synchronizedScan", "", "isDialogType", "isPopupWindowType", "Lsdk/pendo/io/f9/b;", "Lsdk/pendo/io/f9/b;", "fragmentHelper", "<init>", "()V", "b", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class j implements e {
    private static final Regex c = new Regex("[^\\dA-Za-z0-9_|]");

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private b fragmentHelper = new b();

    public final String a() {
        return "__DRAWER__";
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001f A[Catch: all -> 0x006e, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x000e, B:9:0x0019, B:13:0x001f, B:15:0x0029, B:17:0x0040, B:21:0x004b, B:23:0x005d, B:24:0x0064), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0019 A[Catch: all -> 0x006e, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x000e, B:9:0x0019, B:13:0x001f, B:15:0x0029, B:17:0x0040, B:21:0x004b, B:23:0x005d, B:24:0x0064), top: B:2:0x0001 }] */
    @Override // sdk.pendo.io.f9.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.lang.String a(java.util.ArrayList<sdk.pendo.io.f9.d> r4, android.app.Activity r5, sdk.pendo.io.g9.q0.b r6, boolean r7, java.lang.String r8, boolean r9, sdk.pendo.io.listeners.views.PendoDrawerListener r10) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = "fragmentsInfoList"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)     // Catch: java.lang.Throwable -> L6e
            java.lang.String r0 = "currentScreenId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)     // Catch: java.lang.Throwable -> L6e
            r0 = 0
            if (r10 == 0) goto L16
            boolean r10 = r10.isDrawerOpenedAndRelatesToCurrentScreen(r5)     // Catch: java.lang.Throwable -> L6e
            r1 = 1
            if (r10 != r1) goto L16
            goto L17
        L16:
            r1 = r0
        L17:
            if (r1 == 0) goto L1f
            java.lang.String r4 = r3.a()     // Catch: java.lang.Throwable -> L6e
            monitor-exit(r3)
            return r4
        L1f:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6e
            java.lang.String r1 = ""
            r10.<init>(r1)     // Catch: java.lang.Throwable -> L6e
            r1 = 0
            if (r5 == 0) goto L3d
            java.lang.Class r2 = r5.getClass()     // Catch: java.lang.Throwable -> L6e
            java.lang.String r2 = r2.getSimpleName()     // Catch: java.lang.Throwable -> L6e
            r10.append(r2)     // Catch: java.lang.Throwable -> L6e
            java.lang.String r4 = r3.a(r5, r4, r9, r7)     // Catch: java.lang.Throwable -> L6e
            java.lang.StringBuilder r4 = r10.append(r4)     // Catch: java.lang.Throwable -> L6e
            goto L3e
        L3d:
            r4 = r1
        L3e:
            if (r4 != 0) goto L49
            java.lang.Object[] r4 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L6e
            java.lang.String r5 = "ScreenManagerHelper.calculateNativeScreenId -> activity is null"
            sdk.pendo.io.logging.PendoLogger.w(r5, r4)     // Catch: java.lang.Throwable -> L6e
            monitor-exit(r3)
            return r8
        L49:
            if (r6 == 0) goto L5b
            boolean r4 = r6.e()     // Catch: java.lang.Throwable -> L6e
            boolean r5 = r6.f()     // Catch: java.lang.Throwable -> L6e
            java.lang.String r4 = r3.a(r4, r5)     // Catch: java.lang.Throwable -> L6e
            java.lang.StringBuilder r1 = r10.append(r4)     // Catch: java.lang.Throwable -> L6e
        L5b:
            if (r1 != 0) goto L64
            java.lang.Object[] r4 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L6e
            java.lang.String r5 = "ScreenManagerHelper.calculateNativeScreenId -> root view is null"
            sdk.pendo.io.logging.PendoLogger.w(r5, r4)     // Catch: java.lang.Throwable -> L6e
        L64:
            kotlin.text.Regex r4 = sdk.pendo.io.f9.j.c     // Catch: java.lang.Throwable -> L6e
            java.lang.String r5 = ""
            java.lang.String r4 = r4.replace(r10, r5)     // Catch: java.lang.Throwable -> L6e
            monitor-exit(r3)
            return r4
        L6e:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.f9.j.a(java.util.ArrayList, android.app.Activity, sdk.pendo.io.g9.q0$b, boolean, java.lang.String, boolean, sdk.pendo.io.listeners.views.PendoDrawerListener):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001f A[Catch: all -> 0x0083, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x000e, B:9:0x0019, B:13:0x001f, B:16:0x002a, B:17:0x0033, B:18:0x004c, B:20:0x0055, B:22:0x0069, B:23:0x0070, B:27:0x0037, B:28:0x007a), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0019 A[Catch: all -> 0x0083, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x000e, B:9:0x0019, B:13:0x001f, B:16:0x002a, B:17:0x0033, B:18:0x004c, B:20:0x0055, B:22:0x0069, B:23:0x0070, B:27:0x0037, B:28:0x007a), top: B:2:0x0001 }] */
    @Override // sdk.pendo.io.f9.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.lang.String a(java.util.ArrayList<sdk.pendo.io.f9.d> r3, android.app.Activity r4, sdk.pendo.io.g9.q0.b r5, boolean r6, java.lang.String r7, sdk.pendo.io.sdk.xamarin.XamarinBridge r8, boolean r9, sdk.pendo.io.listeners.views.PendoDrawerListener r10) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = "fragmentsInfoList"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)     // Catch: java.lang.Throwable -> L83
            java.lang.String r0 = "currentScreenId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)     // Catch: java.lang.Throwable -> L83
            r0 = 0
            if (r10 == 0) goto L16
            boolean r10 = r10.isDrawerOpened()     // Catch: java.lang.Throwable -> L83
            r1 = 1
            if (r10 != r1) goto L16
            goto L17
        L16:
            r1 = r0
        L17:
            if (r1 == 0) goto L1f
            java.lang.String r3 = r2.a()     // Catch: java.lang.Throwable -> L83
            monitor-exit(r2)
            return r3
        L1f:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L83
            java.lang.String r1 = ""
            r10.<init>(r1)     // Catch: java.lang.Throwable -> L83
            if (r4 == 0) goto L7a
            if (r8 == 0) goto L37
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L83
            java.lang.String r8 = r8.getScreenId()     // Catch: java.lang.Throwable -> L83
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L83
        L33:
            r10.append(r7)     // Catch: java.lang.Throwable -> L83
            goto L4c
        L37:
            java.lang.Object[] r7 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L83
            java.lang.String r8 = "ScreenManagerHelper.calculateOldXamarinScreenId -> xamarinBridge is null"
            sdk.pendo.io.logging.PendoLogger.w(r8, r7)     // Catch: java.lang.Throwable -> L83
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L83
            java.lang.Class r8 = r4.getClass()     // Catch: java.lang.Throwable -> L83
            java.lang.String r8 = r8.getSimpleName()     // Catch: java.lang.Throwable -> L83
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L83
            goto L33
        L4c:
            java.lang.String r3 = r2.a(r4, r3, r9, r6)     // Catch: java.lang.Throwable -> L83
            r10.append(r3)     // Catch: java.lang.Throwable -> L83
            if (r5 == 0) goto L66
            boolean r3 = r5.e()     // Catch: java.lang.Throwable -> L83
            boolean r4 = r5.f()     // Catch: java.lang.Throwable -> L83
            java.lang.String r3 = r2.a(r3, r4)     // Catch: java.lang.Throwable -> L83
            java.lang.StringBuilder r3 = r10.append(r3)     // Catch: java.lang.Throwable -> L83
            goto L67
        L66:
            r3 = 0
        L67:
            if (r3 != 0) goto L70
            java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L83
            java.lang.String r4 = "ScreenManagerHelper.calculateOldXamarinScreenId -> root view is null"
            sdk.pendo.io.logging.PendoLogger.w(r4, r3)     // Catch: java.lang.Throwable -> L83
        L70:
            kotlin.text.Regex r3 = sdk.pendo.io.f9.j.c     // Catch: java.lang.Throwable -> L83
            java.lang.String r4 = ""
            java.lang.String r3 = r3.replace(r10, r4)     // Catch: java.lang.Throwable -> L83
            monitor-exit(r2)
            return r3
        L7a:
            java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L83
            java.lang.String r4 = "ScreenManagerHelper.calculateOldXamarinScreenId -> activity is null"
            sdk.pendo.io.logging.PendoLogger.w(r4, r3)     // Catch: java.lang.Throwable -> L83
            monitor-exit(r2)
            return r7
        L83:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.f9.j.a(java.util.ArrayList, android.app.Activity, sdk.pendo.io.g9.q0$b, boolean, java.lang.String, sdk.pendo.io.sdk.xamarin.XamarinBridge, boolean, sdk.pendo.io.listeners.views.PendoDrawerListener):java.lang.String");
    }

    @Override // sdk.pendo.io.f9.e
    public String a(PlatformStateManager platformStateManager, String currentScreenId) {
        Intrinsics.checkNotNullParameter(platformStateManager, "platformStateManager");
        Intrinsics.checkNotNullParameter(currentScreenId, "currentScreenId");
        String screenName = platformStateManager.getScreenName();
        return screenName != null ? screenName : currentScreenId;
    }

    @Override // sdk.pendo.io.f9.e
    public synchronized String a(String currentScreenId, q0.b rootViewData, XamarinBridge xamarinBridge, PendoDrawerListener drawerListener) {
        Intrinsics.checkNotNullParameter(currentScreenId, "currentScreenId");
        boolean z = false;
        if (drawerListener != null && drawerListener.isDrawerOpened()) {
            return a();
        }
        if (xamarinBridge == null) {
            PendoLogger.w("ScreenManagerHelper.calculateXamarinScreenId -> xamarinBridge is null", new Object[0]);
            return currentScreenId;
        }
        if (rootViewData != null && rootViewData.e()) {
            return "__DIALOG__";
        }
        if (rootViewData != null && rootViewData.f()) {
            z = true;
        }
        if (z) {
            return "__PANEL__";
        }
        return xamarinBridge.getScreenId();
    }

    public final String a(boolean isDialogType, boolean isPopupWindowType) {
        StringBuilder sb = new StringBuilder("");
        if (isDialogType) {
            sb.append("__DIALOG__" + sdk.pendo.io.n9.a.f1445a.a());
        }
        if (isPopupWindowType) {
            sb.append("__PANEL__" + sdk.pendo.io.n9.a.f1445a.a());
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public final String a(Activity activity, ArrayList<d> fragmentsInfoList, boolean isIgnoreDynamicFragmentsInScrollView, boolean isOldScreenIdFormat) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(fragmentsInfoList, "fragmentsInfoList");
        fragmentsInfoList.clear();
        fragmentsInfoList.addAll(this.fragmentHelper.a(activity, isIgnoreDynamicFragmentsInScrollView));
        return this.fragmentHelper.a(this.fragmentHelper.a(fragmentsInfoList, isOldScreenIdFormat), isOldScreenIdFormat);
    }

    @Override // sdk.pendo.io.f9.e
    public synchronized void a(boolean synchronizedScan) {
        b cVar;
        if (synchronizedScan) {
            try {
                if (!(this.fragmentHelper instanceof c)) {
                    cVar = new c();
                    this.fragmentHelper = cVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!synchronizedScan && (this.fragmentHelper instanceof c)) {
            cVar = new b();
            this.fragmentHelper = cVar;
        }
    }
}
