package sdk.pendo.io.g9;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.amplitude.reactnative.AndroidContextProvider;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.PendoTouchDelegate;
import sdk.pendo.io.listeners.views.PendoDrawerListener;
import sdk.pendo.io.listeners.views.PendoOnItemClickListener;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.sdk.react.PlatformStateManager;

/* loaded from: classes6.dex */
public class q0 {

    class a extends DataSetObserver {
        a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<View> f1145a;
        private final Rect b;
        private final WindowManager.LayoutParams c;
        public final WeakReference<Object> d = null;

        b(WeakReference<View> weakReference, WindowManager.LayoutParams layoutParams) {
            this.f1145a = weakReference;
            View view = weakReference.get();
            if (view != null) {
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                int i = iArr[0];
                int i2 = iArr[1];
                this.b = new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2);
            } else {
                this.b = null;
            }
            this.c = layoutParams;
        }

        public WindowManager.LayoutParams a() {
            return this.c;
        }

        public Rect b() {
            return this.b;
        }

        IBinder c() {
            return this.c.token;
        }

        public boolean d() {
            WindowManager.LayoutParams layoutParams = this.c;
            return layoutParams == null || layoutParams.type == 1;
        }

        public boolean e() {
            WindowManager.LayoutParams layoutParams = this.c;
            return layoutParams != null && layoutParams.type == 2;
        }

        public boolean f() {
            WindowManager.LayoutParams layoutParams = this.c;
            return layoutParams != null && layoutParams.type == 1002;
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private String f1146a;
        private String b;
        private final ArrayList<String> c = new ArrayList<>();

        public String a() {
            return this.b;
        }

        public ArrayList<String> b() {
            return this.c;
        }

        public String c() {
            return this.f1146a;
        }

        public void a(String str) {
            this.b = str;
        }

        public void b(String str) {
            this.f1146a = str;
        }
    }

    public static Rect a(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        return new Rect(i, iArr[1], view.getMeasuredWidth() + i, iArr[1] + view.getMeasuredHeight());
    }

    public static boolean a(int i) {
        return ((-16777216) & i) == 0 && (i & ViewCompat.MEASURED_SIZE_MASK) != 0;
    }

    public static int b(float f) {
        return a(2, f);
    }

    public static String c(View view) {
        CharSequence contentDescription = view.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            return null;
        }
        return contentDescription.toString();
    }

    public static TextView d(View view) {
        return a(view, false);
    }

    public static View e(View view) {
        if (view == null) {
            return null;
        }
        Object parent = view.getParent();
        if (!(parent instanceof View)) {
            return null;
        }
        View view2 = (View) parent;
        return j(view2) ? view2 : e(view2);
    }

    public static String f(View view) {
        try {
            int id = view.getId();
            if (id == -1 || a(id)) {
                return null;
            }
            return view.getResources().getResourceName(id);
        } catch (Resources.NotFoundException unused) {
            return null;
        } catch (Exception e) {
            PendoLogger.d(e, "ViewUtils", e.getMessage());
            return null;
        }
    }

    public static Rect g(View view) {
        Rect rect = new Rect();
        try {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            return new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2);
        } catch (Exception e) {
            PendoLogger.d(e, "Attempt to read from field mVisibleInsets on a null attachInfo of the view in question.", new Object[0]);
            return rect;
        }
    }

    public static boolean h(View view) {
        WindowInsetsCompat rootWindowInsets;
        if (view == null || (rootWindowInsets = ViewCompat.getRootWindowInsets(view)) == null) {
            return false;
        }
        return rootWindowInsets.isVisible(WindowInsetsCompat.Type.ime());
    }

    private static boolean i(View view) {
        return view != null && view.isShown();
    }

    public static boolean j(View view) {
        return (view instanceof AbsListView) || (view instanceof RecyclerView);
    }

    public static boolean k(View view) {
        return view.getClass().getSimpleName().toLowerCase(Locale.US).contains("tabview");
    }

    public static boolean l(View view) {
        return e(view) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m(View view) {
        a(view, (WeakReference<View>) new WeakReference(view));
    }

    public static MotionEvent n(View view) {
        view.getLocationOnScreen(new int[2]);
        return MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, r0[0], r0[1], 0);
    }

    protected static void o(View view) {
        try {
            Context context = view.getContext();
            if (PendoInternal.w().i() && sdk.pendo.io.g9.b.a(context)) {
                sdk.pendo.io.g9.b.a(view);
            }
        } catch (Exception e) {
            PendoLogger.w("ViewUtils Unable to set click action listener on view for accessibility: %s", e.getMessage());
        }
    }

    public static void p(final View view) {
        sdk.pendo.io.a6.a.a().a(new Runnable() { // from class: sdk.pendo.io.g9.q0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                q0.m(view);
            }
        });
    }

    public static String a(Bitmap.CompressFormat compressFormat, int i, Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(compressFormat, i, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    public static void b(View view) {
        if (view == null) {
            return;
        }
        view.dispatchTouchEvent(n(view));
    }

    public static int c() {
        Resources b2 = g0.b();
        int identifier = b2.getIdentifier("status_bar_height", "dimen", AndroidContextProvider.OS_NAME);
        if (identifier > 0) {
            return b2.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static boolean d() {
        WeakReference<PendoDrawerListener> e = PendoInternal.x().e();
        if (e == null || e.get() == null) {
            return false;
        }
        return e.get().isDrawerOpened();
    }

    public static int a(float f) {
        return a(1, f);
    }

    public static int b() {
        Resources b2 = g0.b();
        int identifier = b2.getIdentifier("navigation_bar_height", "dimen", AndroidContextProvider.OS_NAME);
        if (identifier > 0) {
            return b2.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private static void c(List<b> list) {
        int i;
        int i2;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<b> it = list.iterator();
        int i3 = Integer.MAX_VALUE;
        int i4 = Integer.MAX_VALUE;
        while (it.hasNext()) {
            Rect rect = it.next().b;
            if (rect != null && (i2 = rect.top) < i3) {
                i3 = i2;
            }
            if (rect != null && (i = rect.left) < i4) {
                i4 = i;
            }
        }
        Iterator<b> it2 = list.iterator();
        while (it2.hasNext()) {
            Rect rect2 = it2.next().b;
            if (rect2 != null) {
                rect2.offset(-i4, -i3);
            }
        }
    }

    private static int a(int i, float f) {
        DisplayMetrics a2 = a();
        if (a2 != null) {
            return (int) TypedValue.applyDimension(i, f, a2);
        }
        return -1;
    }

    public static List<b> b(List<Object> list) {
        ArrayList arrayList = new ArrayList();
        try {
            Iterator it = new ArrayList(list).iterator();
            while (it.hasNext()) {
                View view = (View) f0.a("mView", it.next());
                if (i(view)) {
                    WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) view.getLayoutParams();
                    if (layoutParams == null || layoutParams.getTitle() == null || !layoutParams.getTitle().toString().contains("PendoGuideVisualActivity")) {
                        if (i(view)) {
                            arrayList.add(new b(new WeakReference(view), layoutParams));
                        }
                    }
                } else {
                    PendoLogger.w("ViewUtils getRootViewsDataList -> root view is null ", new Object[0]);
                }
            }
        } catch (Exception e) {
            PendoLogger.e("ViewUtils getRootViewsDataList -> " + e.getMessage(), new Object[0]);
        }
        return arrayList;
    }

    private static void a(List<b> list, Bitmap bitmap, sdk.pendo.io.h9.c cVar) {
        if (list == null) {
            PendoLogger.e("drawRootsToBitmap() viewRoot can't be null", new Object[0]);
        } else if (list.isEmpty()) {
            PendoLogger.e("drawRootsToBitmap() viewRoot can't be empty", new Object[0]);
        } else {
            new sdk.pendo.io.h9.b(list, bitmap, cVar).a();
        }
    }

    protected static void b(AbsListView absListView) {
        AdapterView.OnItemClickListener onItemClickListener = absListView.getOnItemClickListener();
        if (onItemClickListener == null || (onItemClickListener instanceof PendoOnItemClickListener)) {
            return;
        }
        PendoOnItemClickListener pendoOnItemClickListener = new PendoOnItemClickListener();
        pendoOnItemClickListener.addListener(onItemClickListener);
        absListView.setOnItemClickListener(pendoOnItemClickListener);
    }

    private static void a(Activity activity, final List<b> list, final Bitmap bitmap, final sdk.pendo.io.h9.c cVar) {
        final AtomicReference atomicReference = new AtomicReference();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        activity.runOnUiThread(new Runnable() { // from class: sdk.pendo.io.g9.q0$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                q0.a(list, bitmap, cVar, atomicReference, countDownLatch);
            }
        });
        countDownLatch.await();
        Exception exc = (Exception) atomicReference.get();
        if (exc != null) {
            PendoLogger.e(exc);
        }
    }

    public static Bitmap b(Activity activity, sdk.pendo.io.h9.c cVar) {
        if (activity == null) {
            throw new IllegalArgumentException("Parameter activity cannot be null.");
        }
        try {
            return a(activity, cVar);
        } catch (Exception e) {
            PendoLogger.e("Unable to take screenshot to bitmap of activity " + activity.getClass().getName(), e);
            return null;
        }
    }

    private static void a(List<b> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        int i = 0;
        while (i < list.size() - 1) {
            b bVar = list.get(i);
            if (bVar.c() == null) {
                return;
            }
            int i2 = i + 1;
            int i3 = i2;
            while (true) {
                if (i3 < list.size()) {
                    b bVar2 = list.get(i3);
                    if (bVar2.d() && bVar2.c() == bVar.c()) {
                        list.remove(bVar2);
                        list.add(i, bVar2);
                        break;
                    }
                    i3++;
                }
            }
            i = i2;
        }
    }

    public static DisplayMetrics a() {
        Context m = PendoInternal.m();
        if (m != null) {
            return m.getResources().getDisplayMetrics();
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0015, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.widget.TextView a(android.view.View r5, boolean r6) {
        /*
            boolean r0 = r5 instanceof android.widget.TextView
            if (r0 == 0) goto L7
            android.widget.TextView r5 = (android.widget.TextView) r5
            return r5
        L7:
            boolean r0 = r5 instanceof android.view.ViewGroup
            r1 = 0
            if (r0 != 0) goto Ld
            return r1
        Ld:
            java.util.Stack r0 = new java.util.Stack
            r0.<init>()
            r0.push(r5)
        L15:
            boolean r5 = r0.empty()
            if (r5 != 0) goto L4f
            java.lang.Object r5 = r0.pop()
            android.view.View r5 = (android.view.View) r5
            boolean r2 = a(r6, r5)
            if (r2 == 0) goto L2a
            android.widget.TextView r5 = (android.widget.TextView) r5
            return r5
        L2a:
            boolean r2 = r5 instanceof android.view.ViewGroup
            if (r2 == 0) goto L15
            r2 = 0
        L2f:
            r3 = r5
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            int r4 = r3.getChildCount()
            if (r2 >= r4) goto L15
            android.view.View r3 = r3.getChildAt(r2)
            boolean r4 = a(r6, r3)
            if (r4 == 0) goto L45
            android.widget.TextView r3 = (android.widget.TextView) r3
            return r3
        L45:
            boolean r4 = r3 instanceof android.view.ViewGroup
            if (r4 == 0) goto L4c
            r0.push(r3)
        L4c:
            int r2 = r2 + 1
            goto L2f
        L4f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.g9.q0.a(android.view.View, boolean):android.widget.TextView");
    }

    public static Integer a(View view, View view2) {
        try {
            if (view instanceof AbsListView) {
                return Integer.valueOf(((AbsListView) view).getPositionForView(view2));
            }
            if (view instanceof RecyclerView) {
                return Integer.valueOf(((RecyclerView) view).getChildLayoutPosition(view2));
            }
            return null;
        } catch (Exception e) {
            PendoLogger.e(e, "Position in list could not be obtained", new Object[0]);
            return null;
        }
    }

    static List<b> a(Activity activity) {
        try {
            Object a2 = f0.a("mRoots", f0.a("mGlobal", activity.getWindowManager()));
            if (!(a2 instanceof ArrayList)) {
                return Collections.emptyList();
            }
            ArrayList arrayList = (ArrayList) a2;
            if (arrayList.isEmpty()) {
                return Collections.emptyList();
            }
            List<b> b2 = b(arrayList);
            if (b2.isEmpty()) {
                return Collections.emptyList();
            }
            c(b2);
            a(b2);
            return b2;
        } catch (Exception e) {
            PendoLogger.w("ViewUtils getRootViews -> " + e.getMessage(), new Object[0]);
            return Collections.emptyList();
        }
    }

    public static void a(View view, boolean z, c cVar) {
        a(view, z, cVar, false);
    }

    public static void a(View view, boolean z, c cVar, boolean z2) {
        if (view == null) {
            return;
        }
        if (cVar.a() == null) {
            cVar.a(c(view));
        }
        int i = 0;
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (!z2 ? !TextUtils.isEmpty(text) : text != null) {
                i = 1;
            }
            if (i != 0) {
                String obj = ((TextView) view).getText().toString();
                if (cVar.c() == null) {
                    cVar.b(obj);
                }
                if (z || z2) {
                    cVar.b().add(obj);
                    return;
                }
                return;
            }
            return;
        }
        if (!(view instanceof ViewGroup)) {
            return;
        }
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return;
            }
            a(viewGroup.getChildAt(i), z, cVar, z2);
            i++;
        }
    }

    public static synchronized Boolean a(MotionEvent motionEvent, View view, int i) {
        synchronized (q0.class) {
            if (motionEvent == null || view == null) {
                return Boolean.FALSE;
            }
            return Boolean.valueOf(a(view).contains(((int) motionEvent.getX()) + i, ((int) motionEvent.getY()) + i));
        }
    }

    private static boolean a(boolean z, View view) {
        if (z) {
            return view instanceof TextView;
        }
        return (view instanceof TextView) && !TextUtils.isEmpty(((TextView) view).getText());
    }

    public static boolean a(View view, int i) {
        if (view == null) {
            return false;
        }
        try {
            if (view.getVisibility() == 8) {
                return false;
            }
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            boolean globalVisibleRect = view.getGlobalVisibleRect(rect);
            if (i == 1) {
                view.getLocalVisibleRect(rect2);
            } else {
                if (i != 0) {
                    throw new IllegalArgumentException("viewMode is illegal : " + i);
                }
                view.getWindowVisibleDisplayFrame(rect2);
            }
            return globalVisibleRect && Rect.intersects(rect2, rect);
        } catch (Exception e) {
            PendoLogger.d("ViewUtils failed to calculate isViewInsideDisplay. " + e, e.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(List list, Bitmap bitmap, sdk.pendo.io.h9.c cVar, AtomicReference atomicReference, CountDownLatch countDownLatch) {
        try {
            try {
                a((List<b>) list, bitmap, cVar);
            } catch (Exception e) {
                atomicReference.set(e);
            }
        } finally {
            countDownLatch.countDown();
        }
    }

    protected static void a(AbsListView absListView) {
        ListAdapter listAdapter = (ListAdapter) absListView.getAdapter();
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(new a());
        }
    }

    protected static synchronized void a(DrawerLayout drawerLayout) {
        PendoDrawerListener pendoDrawerListener;
        synchronized (q0.class) {
            Object extractDrawerListener = PendoDrawerListener.extractDrawerListener(drawerLayout);
            if (extractDrawerListener instanceof ArrayList) {
                ArrayList arrayList = (ArrayList) extractDrawerListener;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (arrayList.get(size) instanceof PendoDrawerListener) {
                        return;
                    }
                }
                WeakReference<PendoDrawerListener> e = PendoInternal.x().e();
                if (e != null && e.get() != null) {
                    pendoDrawerListener = e.get();
                    pendoDrawerListener.setDrawerLayoutReference(drawerLayout);
                    drawerLayout.addDrawerListener(pendoDrawerListener);
                    PendoInternal.x().a(new WeakReference<>(pendoDrawerListener));
                }
                pendoDrawerListener = new PendoDrawerListener(drawerLayout);
                drawerLayout.addDrawerListener(pendoDrawerListener);
                PendoInternal.x().a(new WeakReference<>(pendoDrawerListener));
            }
        }
    }

    protected static void a(View view, WeakReference<View> weakReference) {
        try {
            o(view);
            TouchDelegate touchDelegate = view.getTouchDelegate();
            if (touchDelegate instanceof PendoTouchDelegate) {
                return;
            }
            Rect rect = new Rect();
            view.getHitRect(rect);
            PendoTouchDelegate pendoTouchDelegate = new PendoTouchDelegate(rect, view, weakReference);
            if (PlatformStateManager.INSTANCE.isReactNativeAnalyticsEnabled()) {
                view.setOnTouchListener(pendoTouchDelegate);
                view.setTouchDelegate(pendoTouchDelegate);
            } else {
                if (touchDelegate != null) {
                    pendoTouchDelegate.a(touchDelegate);
                }
                view.setTouchDelegate(pendoTouchDelegate);
            }
        } catch (Exception e) {
            PendoLogger.w("ViewUtils Unable to set touch delegate on touchDelegateView: %s", e.getMessage());
        }
    }

    private static Bitmap a(Activity activity, sdk.pendo.io.h9.c cVar) {
        try {
            List<b> a2 = a(activity);
            if (a2.isEmpty()) {
                PendoLogger.e("Unable to capture any view data in " + (activity != null ? activity.getClass().getCanonicalName() : "no activity"), new Object[0]);
                return null;
            }
            Iterator<b> it = a2.iterator();
            int i = Integer.MIN_VALUE;
            int i2 = Integer.MIN_VALUE;
            while (it.hasNext()) {
                Rect rect = it.next().b;
                int i3 = rect.right;
                if (i3 > i) {
                    i = i3;
                }
                int i4 = rect.bottom;
                if (i4 > i2) {
                    i2 = i4;
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                a(a2, createBitmap, cVar);
            } else {
                a(activity, a2, createBitmap, cVar);
            }
            return createBitmap;
        } catch (Exception e) {
            PendoLogger.e(e);
            return null;
        }
    }
}
