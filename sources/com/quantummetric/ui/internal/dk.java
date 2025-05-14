package com.quantummetric.ui.internal;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import com.quantummetric.ui.QuantumMetric;
import com.quantummetric.ui.internal.e;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes5.dex */
final class dk implements Window.Callback {

    /* renamed from: a, reason: collision with root package name */
    static boolean f241a = true;
    private static int b = 0;
    private static int c = 0;
    private static float d = 0.0f;
    private static int e = 0;
    private static long f = 0;
    private static boolean g = false;
    private static String h = "";
    private static int i = 0;
    private static long j = 0;
    private static float k = 0.0f;
    private static float l = 0.0f;
    private static int m = 0;
    private static long o = 0;
    private static long p = 0;
    private static long q = 0;
    private static int r = 15000;
    private final Window.Callback s;
    private final WeakReference<Window> t;
    private final e.AnonymousClass13 u;
    private final float[] v = {-1.0f, -1.0f};
    private final double n = de.a(40.0d);

    dk(Window window, e.AnonymousClass13 anonymousClass13) {
        this.t = new WeakReference<>(window);
        this.s = window.getCallback();
        this.u = anonymousClass13;
    }

    static void a() {
        b = 0;
        c = 0;
        d = 0.0f;
        o = 0L;
        p = 0L;
        q = 0L;
    }

    static void a(int i2) {
        r = i2 * 1000;
    }

    static void a(int i2, int i3) {
        if (cd.f161a || QuantumMetric.b == null) {
            return;
        }
        f = System.currentTimeMillis();
        if (e == 0) {
            e = Math.max(de.a(), de.b());
        }
        d += (Math.abs(i2) + Math.abs(i3)) / e;
    }

    static void a(boolean z) {
        if (cd.f161a || QuantumMetric.b == null) {
            return;
        }
        if (q == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            q = currentTimeMillis;
            p = currentTimeMillis;
            return;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        long j2 = p;
        long j3 = currentTimeMillis2 - j2;
        int i2 = r;
        if (j3 < i2) {
            o += currentTimeMillis2 - j2;
        }
        if (z || currentTimeMillis2 - q > i2) {
            long j4 = o / 1000;
            if (j4 > 0 || c > 0) {
                q = currentTimeMillis2;
                QuantumMetric.a("e", Long.valueOf(j4));
                QuantumMetric.a("s", Float.valueOf(d));
                QuantumMetric.a("c", Integer.valueOf(b));
                QuantumMetric.a("k", Integer.valueOf(c));
            }
        }
        if (!z) {
            p = currentTimeMillis2;
        } else {
            q = 0L;
            p = 0L;
        }
    }

    static void b() {
        a(true);
        b = 0;
        c = 0;
        d = 0.0f;
        o = 0L;
        p = 0L;
        q = 0L;
        a(false);
    }

    static void b(boolean z) {
        g = z;
    }

    static void c() {
        f = System.currentTimeMillis();
    }

    static void d() {
        c++;
        a(false);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        Window.Callback callback = this.s;
        if (callback != null) {
            return callback.dispatchGenericMotionEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!(cd.f161a || QuantumMetric.b == null) && keyEvent != null && keyEvent.getAction() == 1 && keyEvent.getKeyCode() == 4) {
            QuantumMetric.a(-30, "", new j[0]);
        }
        Window.Callback callback = this.s;
        if (callback != null) {
            return callback.dispatchKeyEvent(keyEvent);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        Window.Callback callback = this.s;
        if (callback != null) {
            return callback.dispatchKeyShortcutEvent(keyEvent);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Window.Callback callback = this.s;
        if (callback != null) {
            return callback.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0104  */
    @Override // android.view.Window.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean dispatchTouchEvent(android.view.MotionEvent r14) {
        /*
            Method dump skipped, instructions count: 409
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.dk.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        Window.Callback callback = this.s;
        if (callback != null) {
            return callback.dispatchTrackballEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final void onActionModeFinished(ActionMode actionMode) {
        Window.Callback callback = this.s;
        if (callback != null) {
            callback.onActionModeFinished(actionMode);
        }
    }

    @Override // android.view.Window.Callback
    public final void onActionModeStarted(ActionMode actionMode) {
        Window.Callback callback = this.s;
        if (callback != null) {
            callback.onActionModeStarted(actionMode);
        }
    }

    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        Window.Callback callback = this.s;
        if (callback != null) {
            callback.onAttachedToWindow();
        }
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        Window.Callback callback = this.s;
        if (callback != null) {
            callback.onContentChanged();
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i2, Menu menu) {
        Window.Callback callback = this.s;
        if (callback != null) {
            return callback.onCreatePanelMenu(i2, menu);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final View onCreatePanelView(int i2) {
        Window.Callback callback = this.s;
        if (callback != null) {
            return callback.onCreatePanelView(i2);
        }
        return null;
    }

    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        Window.Callback callback = this.s;
        if (callback != null) {
            callback.onDetachedFromWindow();
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        Window.Callback callback = this.s;
        if (callback != null) {
            return callback.onMenuItemSelected(i2, menuItem);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuOpened(int i2, Menu menu) {
        Window.Callback callback = this.s;
        if (callback != null) {
            return callback.onMenuOpened(i2, menu);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final void onPanelClosed(int i2, Menu menu) {
        Window.Callback callback = this.s;
        if (callback != null) {
            callback.onPanelClosed(i2, menu);
        }
    }

    @Override // android.view.Window.Callback
    public final void onPointerCaptureChanged(boolean z) {
        Window.Callback callback = this.s;
        if (callback != null) {
            callback.onPointerCaptureChanged(z);
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int i2, View view, Menu menu) {
        Window.Callback callback = this.s;
        if (callback != null) {
            return callback.onPreparePanel(i2, view, menu);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i2) {
        Window.Callback callback = this.s;
        if (callback != null) {
            callback.onProvideKeyboardShortcuts(list, menu, i2);
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        Window.Callback callback = this.s;
        if (callback != null) {
            return callback.onSearchRequested();
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested(SearchEvent searchEvent) {
        Window.Callback callback = this.s;
        if (callback != null) {
            return callback.onSearchRequested(searchEvent);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        Window.Callback callback = this.s;
        if (callback != null) {
            callback.onWindowAttributesChanged(layoutParams);
        }
    }

    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        Window.Callback callback = this.s;
        if (callback != null) {
            callback.onWindowFocusChanged(z);
        }
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        Window.Callback callback2 = this.s;
        if (callback2 != null) {
            return callback2.onWindowStartingActionMode(callback);
        }
        return null;
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) {
        Window.Callback callback2 = this.s;
        if (callback2 != null) {
            return callback2.onWindowStartingActionMode(callback, i2);
        }
        return null;
    }
}
