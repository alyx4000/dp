package sdk.pendo.io.g9;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.events.IdentificationData;
import sdk.pendo.io.sdk.react.PlatformStateManager;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0016\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J&\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0010"}, d2 = {"Lsdk/pendo/io/g9/n0;", "", "", "a", "Landroid/view/ViewGroup;", "viewGroup", "c", "", "childIndex", "b", "childrenCount", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class n0 {

    /* renamed from: a, reason: collision with root package name */
    public static final n0 f1140a = new n0();

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\n\u0010\u0010¨\u0006\u0014"}, d2 = {"Lsdk/pendo/io/g9/n0$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/view/View;", "a", "Landroid/view/View;", "b", "()Landroid/view/View;", "view", "I", "()I", IdentificationData.FIELD_INDEX_IN_PARENT, "<init>", "(Landroid/view/View;I)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    private static final /* data */ class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final View view;

        /* renamed from: b, reason: from kotlin metadata */
        private final int indexInParent;

        public a(View view, int i) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.view = view;
            this.indexInParent = i;
        }

        /* renamed from: a, reason: from getter */
        public final int getIndexInParent() {
            return this.indexInParent;
        }

        /* renamed from: b, reason: from getter */
        public final View getView() {
            return this.view;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            return Intrinsics.areEqual(this.view, aVar.view) && this.indexInParent == aVar.indexInParent;
        }

        public int hashCode() {
            return (this.view.hashCode() * 31) + Integer.hashCode(this.indexInParent);
        }

        public String toString() {
            return "ChildView(view=" + this.view + ", indexInParent=" + this.indexInParent + ")";
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class b<T> implements Comparator {
        final /* synthetic */ ViewGroup f;

        public b(ViewGroup viewGroup) {
            this.f = viewGroup;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            a aVar = (a) t;
            PlatformStateManager platformStateManager = PlatformStateManager.INSTANCE;
            a aVar2 = (a) t2;
            return ComparisonsKt.compareValues(Integer.valueOf(platformStateManager.isReactNativeAnalyticsEnabled() ? n0.f1140a.b(this.f, aVar.getIndexInParent()) : this.f.getChildDrawingOrder(aVar.getIndexInParent())), Integer.valueOf(platformStateManager.isReactNativeAnalyticsEnabled() ? n0.f1140a.b(this.f, aVar2.getIndexInParent()) : this.f.getChildDrawingOrder(aVar2.getIndexInParent())));
        }
    }

    private n0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int b(ViewGroup viewGroup, int childIndex) {
        Class<?> cls = Class.forName("com.facebook.react.uimanager.ViewGroupDrawingOrderHelper");
        Object newInstance = cls.getConstructor(ViewGroup.class).newInstance(viewGroup);
        Class<?> cls2 = Integer.TYPE;
        Object invoke = cls.getMethod("getChildDrawingOrder", cls2, cls2).invoke(newInstance, Integer.valueOf(viewGroup.getChildCount()), Integer.valueOf(childIndex));
        Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) invoke).intValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0027, code lost:
    
        if (r4.getChildDrawingOrder(r5) == r5) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean c(android.view.ViewGroup r4, int r5) {
        /*
            r3 = this;
            java.lang.String r0 = "viewGroup"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            boolean r0 = r3.a()
            r1 = 1
            if (r0 != 0) goto Ld
            return r1
        Ld:
            r0 = 0
            sdk.pendo.io.sdk.react.PlatformStateManager r2 = sdk.pendo.io.sdk.react.PlatformStateManager.INSTANCE     // Catch: java.lang.Exception -> L2c
            boolean r2 = r2.isReactNativeAnalyticsEnabled()     // Catch: java.lang.Exception -> L2c
            if (r2 == 0) goto L23
            boolean r2 = r3.c(r4)     // Catch: java.lang.Exception -> L2c
            if (r2 == 0) goto L23
            int r4 = r3.b(r4, r5)     // Catch: java.lang.Exception -> L2c
            if (r4 != r5) goto L2a
            goto L41
        L23:
            int r4 = r4.getChildDrawingOrder(r5)     // Catch: java.lang.Exception -> L2c
            if (r4 != r5) goto L2a
            goto L41
        L2a:
            r1 = r0
            goto L41
        L2c:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r2 = "ViewGroupUtils-> Could not check for child draw order "
            r5.<init>(r2)
            java.lang.StringBuilder r4 = r5.append(r4)
            java.lang.String r4 = r4.toString()
            java.lang.Object[] r5 = new java.lang.Object[r0]
            sdk.pendo.io.logging.PendoLogger.i(r4, r5)
        L41:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.g9.n0.c(android.view.ViewGroup, int):boolean");
    }

    private final boolean c(ViewGroup viewGroup) {
        if (Intrinsics.areEqual(viewGroup.getClass().getSimpleName(), "ReactViewGroup")) {
            return true;
        }
        return Class.forName("com.facebook.react.views.view.ReactViewGroup").isAssignableFrom(viewGroup.getClass());
    }

    public final ArrayList<View> a(ViewGroup viewGroup, int childrenCount) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        ArrayList arrayList = new ArrayList();
        if (childrenCount >= 0) {
            int i = 0;
            while (true) {
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
                arrayList.add(new a(childAt, i));
                if (i == childrenCount) {
                    break;
                }
                i++;
            }
        }
        if (Build.VERSION.SDK_INT >= 29 && arrayList.size() > 1) {
            CollectionsKt.sortWith(arrayList, new b(viewGroup));
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((a) it.next()).getView());
        }
        return new ArrayList<>(arrayList2);
    }

    public final boolean b(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        if (a(viewGroup)) {
            DrawerLayout drawerLayout = (DrawerLayout) viewGroup;
            if (drawerLayout.isDrawerOpen(GravityCompat.START) || drawerLayout.isDrawerOpen(GravityCompat.END)) {
                return true;
            }
        }
        return false;
    }

    private final boolean a() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public final boolean a(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        return !PlatformStateManager.INSTANCE.isReactNativeAnalyticsEnabled() && p0.a(viewGroup);
    }
}
