package sdk.pendo.io.listeners.views;

import android.os.Build;
import android.view.View;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.actions.StepSeenManager;
import sdk.pendo.io.actions.VisualGuidesManager;
import sdk.pendo.io.constants.b;
import sdk.pendo.io.logging.PendoLogger;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\fJ\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u0006\u0010\t\u001a\u00020\u000eJ\u0010\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\u0018\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\fH\u0016J\u0010\u0010\u001d\u001a\u00020\u00152\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003J\u000e\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\fJ\u000e\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u000eR\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lsdk/pendo/io/listeners/views/PendoDrawerListener;", "Landroidx/drawerlayout/widget/DrawerLayout$DrawerListener;", "drawerLayout", "Landroid/view/View;", "(Landroid/view/View;)V", "drawerLayoutReference", "Ljava/lang/ref/WeakReference;", "drawerState", "Ljava/util/concurrent/atomic/AtomicInteger;", "isDrawerOpened", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getDrawerState", "", "isDrawerOpen", "", "drawer", "Landroidx/drawerlayout/widget/DrawerLayout;", "isDrawerOpenedAndRelatesToCurrentScreen", "activity", "Landroid/app/Activity;", "onDrawerClosed", "", "drawerView", "onDrawerOpened", "onDrawerSlide", "slideOffset", "", "onDrawerStateChanged", "newState", "setDrawerLayoutReference", "setDrawerState", "state", "setIsDrawerOpened", "opened", "Companion", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PendoDrawerListener implements DrawerLayout.DrawerListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "PendoDrawerListener";
    private WeakReference<View> drawerLayoutReference;
    private final AtomicInteger drawerState = new AtomicInteger(0);
    private final AtomicBoolean isDrawerOpened;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lsdk/pendo/io/listeners/views/PendoDrawerListener$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "extractDrawerListener", "drawerLayout", "Landroidx/drawerlayout/widget/DrawerLayout;", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Object extractDrawerListener(DrawerLayout drawerLayout) {
            try {
                Field declaredField = DrawerLayout.class.getDeclaredField("mListeners");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(drawerLayout);
                if (obj != null) {
                    return obj;
                }
                return null;
            } catch (IllegalAccessException e) {
                PendoLogger.e(e, PendoDrawerListener.TAG + " extractDrawerListener", e.getMessage());
                return null;
            } catch (NoSuchFieldException e2) {
                PendoLogger.e(e2, PendoDrawerListener.TAG + " extractDrawerListener -> SDK version: " + Build.VERSION.SDK_INT, e2.getMessage());
                return null;
            }
        }
    }

    public PendoDrawerListener(View view) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.isDrawerOpened = atomicBoolean;
        this.drawerLayoutReference = new WeakReference<>(view);
        atomicBoolean.set(isDrawerOpen(view instanceof DrawerLayout ? (DrawerLayout) view : null));
    }

    @JvmStatic
    public static final Object extractDrawerListener(DrawerLayout drawerLayout) {
        return INSTANCE.extractDrawerListener(drawerLayout);
    }

    private final boolean isDrawerOpen(DrawerLayout drawer) {
        if (drawer != null) {
            return drawer.isDrawerOpen(GravityCompat.START) || drawer.isDrawerOpen(GravityCompat.END);
        }
        return false;
    }

    public final synchronized int getDrawerState() {
        return this.drawerState.get();
    }

    public final synchronized boolean isDrawerOpened() {
        return this.isDrawerOpened.get();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0023 A[Catch: all -> 0x000f, TRY_ENTER, TryCatch #0 {all -> 0x000f, blocks: (B:25:0x0004, B:27:0x000a, B:7:0x0016, B:11:0x0023, B:13:0x002d, B:15:0x0033, B:19:0x0042), top: B:24:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016 A[Catch: all -> 0x000f, TRY_LEAVE, TryCatch #0 {all -> 0x000f, blocks: (B:25:0x0004, B:27:0x000a, B:7:0x0016, B:11:0x0023, B:13:0x002d, B:15:0x0033, B:19:0x0042), top: B:24:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized boolean isDrawerOpenedAndRelatesToCurrentScreen(android.app.Activity r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            if (r5 == 0) goto L11
            android.view.Window r5 = r5.getWindow()     // Catch: java.lang.Throwable -> Lf
            if (r5 == 0) goto L11
            android.view.View r5 = r5.getDecorView()     // Catch: java.lang.Throwable -> Lf
            goto L12
        Lf:
            r5 = move-exception
            goto L4e
        L11:
            r5 = r0
        L12:
            r1 = 1
            r2 = 0
            if (r5 != 0) goto L23
            java.lang.String r5 = sdk.pendo.io.listeners.views.PendoDrawerListener.TAG     // Catch: java.lang.Throwable -> Lf
            java.lang.Object[] r0 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> Lf
            java.lang.String r1 = " isDrawerOpenedAndRelatesToCurrentScreen -> Current activity or activity's window is null"
            r0[r2] = r1     // Catch: java.lang.Throwable -> Lf
            sdk.pendo.io.logging.PendoLogger.w(r5, r0)     // Catch: java.lang.Throwable -> Lf
            monitor-exit(r4)
            return r2
        L23:
            java.lang.ref.WeakReference<android.view.View> r3 = r4.drawerLayoutReference     // Catch: java.lang.Throwable -> Lf
            java.lang.Object r3 = r3.get()     // Catch: java.lang.Throwable -> Lf
            android.view.View r3 = (android.view.View) r3     // Catch: java.lang.Throwable -> Lf
            if (r3 == 0) goto L31
            android.view.View r0 = r3.getRootView()     // Catch: java.lang.Throwable -> Lf
        L31:
            if (r0 != 0) goto L40
            java.lang.String r5 = sdk.pendo.io.listeners.views.PendoDrawerListener.TAG     // Catch: java.lang.Throwable -> Lf
            java.lang.Object[] r0 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> Lf
            java.lang.String r1 = " isDrawerOpenedAndRelatesToCurrentScreen -> Drawer Layout ref is null"
            r0[r2] = r1     // Catch: java.lang.Throwable -> Lf
            sdk.pendo.io.logging.PendoLogger.w(r5, r0)     // Catch: java.lang.Throwable -> Lf
            monitor-exit(r4)
            return r2
        L40:
            if (r5 != r0) goto L4b
            java.util.concurrent.atomic.AtomicBoolean r5 = r4.isDrawerOpened     // Catch: java.lang.Throwable -> Lf
            boolean r5 = r5.get()     // Catch: java.lang.Throwable -> Lf
            if (r5 == 0) goto L4b
            goto L4c
        L4b:
            r1 = r2
        L4c:
            monitor-exit(r4)
            return r1
        L4e:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.listeners.views.PendoDrawerListener.isDrawerOpenedAndRelatesToCurrentScreen(android.app.Activity):boolean");
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerClosed(View drawerView) {
        Intrinsics.checkNotNullParameter(drawerView, "drawerView");
        if (StepSeenManager.getInstance().isBannerGuideStep()) {
            PendoLogger.d(TAG, "Displayed guide is of type Banner, won't dismiss guide");
        } else {
            VisualGuidesManager.getInstance().removeShowingGuide();
        }
        this.isDrawerOpened.set(false);
        PendoInternal.x().f();
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerOpened(View drawerView) {
        Intrinsics.checkNotNullParameter(drawerView, "drawerView");
        this.isDrawerOpened.set(true);
        PendoInternal.x().f();
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerSlide(View drawerView, float slideOffset) {
        Intrinsics.checkNotNullParameter(drawerView, "drawerView");
        Float DRAWER_CLOSE_SLIDE_OFFSET = b.f969a;
        Intrinsics.checkNotNullExpressionValue(DRAWER_CLOSE_SLIDE_OFFSET, "DRAWER_CLOSE_SLIDE_OFFSET");
        if (slideOffset < DRAWER_CLOSE_SLIDE_OFFSET.floatValue()) {
            this.isDrawerOpened.set(false);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerStateChanged(int newState) {
        View view;
        this.drawerState.set(newState);
        if (newState != 0 || (view = this.drawerLayoutReference.get()) == null) {
            return;
        }
        this.isDrawerOpened.set(isDrawerOpen(view instanceof DrawerLayout ? (DrawerLayout) view : null));
        PendoInternal.x().f();
    }

    public final void setDrawerLayoutReference(View drawerLayout) {
        this.drawerLayoutReference = new WeakReference<>(drawerLayout);
    }

    public final synchronized void setDrawerState(int state) {
        this.drawerState.set(state);
    }

    public final synchronized void setIsDrawerOpened(boolean opened) {
        this.isDrawerOpened.set(opened);
    }
}
