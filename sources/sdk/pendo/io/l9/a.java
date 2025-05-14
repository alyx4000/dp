package sdk.pendo.io.l9;

import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.uimanager.ViewProps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.g9.n0;
import sdk.pendo.io.g9.p0;
import sdk.pendo.io.g9.q0;
import sdk.pendo.io.logging.PendoLogger;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0004\u000e\u0014\u0015\u0016B\u0007¢\u0006\u0004\b\u0012\u0010\u0013JN\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\r\u001a\u00020\fR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0010¨\u0006\u0017"}, d2 = {"Lsdk/pendo/io/l9/a;", "", "Landroid/view/View;", "view", "", "isParentAList", "Lsdk/pendo/io/l9/a$d;", "viewZIndex", "Ljava/util/ArrayList;", "Landroid/graphics/Rect;", "Lkotlin/collections/ArrayList;", "overallVisibleViewsOnScreen", "Lsdk/pendo/io/l9/a$c;", "screenTraversalListener", "a", "Lsdk/pendo/io/l9/a$b;", "Lsdk/pendo/io/l9/a$b;", "helper", "<init>", "()V", "b", "c", "d", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final b helper = new b();

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001c\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\tJ.\u0010\u0006\u001a\u00020\u00042\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u000bj\b\u0012\u0004\u0012\u00020\u0002`\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010J2\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\tJ>\u0010\u0006\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u000e2\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u000bj\b\u0012\u0004\u0012\u00020\u0007`\f2\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u000bj\b\u0012\u0004\u0012\u00020\u0007`\fJ6\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u000bj\b\u0012\u0004\u0012\u00020\u0007`\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u000bj\b\u0012\u0004\u0012\u00020\u0007`\f¨\u0006\u001a"}, d2 = {"Lsdk/pendo/io/l9/a$b;", "", "Landroid/view/View;", "view", "", "b", "a", "Landroid/graphics/Rect;", "viewRect", "", "visibleViewsOnScreenRectList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "childrenListToIterate", "Landroid/view/ViewGroup;", "viewGroup", "", "currentIndex", "childView", "childRect", "visibleViewsInsideLayoutList", "visibleViewsUnderSameParentList", "overallVisibleViewsOnScreen", "", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final class b {
        public final void a(ViewGroup view, ArrayList<Rect> visibleViewsUnderSameParentList, ArrayList<Rect> overallVisibleViewsOnScreen) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(visibleViewsUnderSameParentList, "visibleViewsUnderSameParentList");
            Intrinsics.checkNotNullParameter(overallVisibleViewsOnScreen, "overallVisibleViewsOnScreen");
            if (!a(view) || view.isClickable()) {
                overallVisibleViewsOnScreen.add(q0.g(view));
            } else {
                overallVisibleViewsOnScreen.addAll(visibleViewsUnderSameParentList);
            }
        }

        public final boolean b(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (!q0.a(view, 0) || view.getVisibility() != 0) {
                PendoLogger.i("ScreenTraversalHelper -> " + view + " is not inside display bounds, continue", new Object[0]);
                return false;
            }
            if (!(view instanceof ViewGroup)) {
                if ((view.getAlpha() == 0.0f) && !p0.b(view)) {
                    PendoLogger.i("ScreenTraversalHelper -> " + view + " alpha is 0 and it's not clickable, continue", new Object[0]);
                    return false;
                }
            } else if (a(view) && ((ViewGroup) view).getChildCount() == 0 && !p0.b(view)) {
                PendoLogger.i("ScreenTraversalHelper -> " + view + " is transparent without children and it's not clickable, continue", new Object[0]);
                return false;
            }
            return true;
        }

        public final ArrayList<Rect> a(View view, ArrayList<Rect> visibleViewsUnderSameParentList) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(visibleViewsUnderSameParentList, "visibleViewsUnderSameParentList");
            if ((view instanceof ViewGroup) && a(view) && !((ViewGroup) view).isClickable()) {
                return visibleViewsUnderSameParentList;
            }
            Rect g = q0.g(view);
            Intrinsics.checkNotNullExpressionValue(g, "getViewVisibleRect(...)");
            return CollectionsKt.arrayListOf(g);
        }

        public final boolean a(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            boolean z = view.getBackground() instanceof ColorDrawable;
            Drawable background = view.getBackground();
            if (!z) {
                return background == null;
            }
            Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
            ColorDrawable colorDrawable = (ColorDrawable) background;
            return colorDrawable.getColor() == 0 || colorDrawable.getAlpha() == 0;
        }

        public final boolean a(Rect viewRect, List<Rect> visibleViewsOnScreenRectList) {
            Intrinsics.checkNotNullParameter(viewRect, "viewRect");
            Intrinsics.checkNotNullParameter(visibleViewsOnScreenRectList, "visibleViewsOnScreenRectList");
            Iterator<Rect> it = visibleViewsOnScreenRectList.iterator();
            while (it.hasNext()) {
                if (it.next().contains(viewRect)) {
                    return true;
                }
            }
            return false;
        }

        public final boolean a(ArrayList<View> childrenListToIterate, ViewGroup viewGroup, int currentIndex) {
            Intrinsics.checkNotNullParameter(childrenListToIterate, "childrenListToIterate");
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            childrenListToIterate.clear();
            n0 n0Var = n0.f1140a;
            if (n0Var.b(viewGroup) && viewGroup.getChildCount() > 0) {
                childrenListToIterate.add(viewGroup.getChildAt(viewGroup.getChildCount() - 1));
                return true;
            }
            if (currentIndex < 0) {
                return false;
            }
            if (n0Var.c(viewGroup, currentIndex)) {
                childrenListToIterate.add(viewGroup.getChildAt(currentIndex));
                return false;
            }
            childrenListToIterate.addAll(n0Var.a(viewGroup, currentIndex));
            return true;
        }

        public final boolean a(View childView, Rect childRect, List<Rect> visibleViewsOnScreenRectList, List<Rect> visibleViewsInsideLayoutList) {
            Intrinsics.checkNotNullParameter(childView, "childView");
            Intrinsics.checkNotNullParameter(childRect, "childRect");
            Intrinsics.checkNotNullParameter(visibleViewsOnScreenRectList, "visibleViewsOnScreenRectList");
            Intrinsics.checkNotNullParameter(visibleViewsInsideLayoutList, "visibleViewsInsideLayoutList");
            if (!b(childView)) {
                return false;
            }
            if ((!visibleViewsInsideLayoutList.isEmpty()) && a(childRect, visibleViewsInsideLayoutList)) {
                PendoLogger.i("ScreenTraversalHelper -> this view already has siblings that covers it: " + childView, new Object[0]);
                return false;
            }
            if (!(!visibleViewsOnScreenRectList.isEmpty()) || !a(childRect, visibleViewsOnScreenRectList)) {
                return true;
            }
            PendoLogger.i("ScreenTraversalHelper -> this view is hidden by another view on the screen: " + childView, new Object[0]);
            return false;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\n"}, d2 = {"Lsdk/pendo/io/l9/a$c;", "", "Landroid/view/View;", "view", "", "isParentAList", "", ViewProps.Z_INDEX, "", "a", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public interface c {
        void a(View view, boolean isParentAList, int zIndex);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\fJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\t\u0010\f¨\u0006\u000f"}, d2 = {"Lsdk/pendo/io/l9/a$d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "(I)V", ViewProps.Z_INDEX, "<init>", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final /* data */ class d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int zIndex;

        public d(int i) {
            this.zIndex = i;
        }

        /* renamed from: a, reason: from getter */
        public final int getZIndex() {
            return this.zIndex;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof d) && this.zIndex == ((d) other).zIndex;
        }

        public int hashCode() {
            return Integer.hashCode(this.zIndex);
        }

        public String toString() {
            return "ViewZIndex(zIndex=" + this.zIndex + ")";
        }

        public final void a(int i) {
            this.zIndex = i;
        }
    }

    public final ArrayList<Rect> a(View view, boolean isParentAList, d viewZIndex, ArrayList<Rect> overallVisibleViewsOnScreen, c screenTraversalListener) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(viewZIndex, "viewZIndex");
        Intrinsics.checkNotNullParameter(overallVisibleViewsOnScreen, "overallVisibleViewsOnScreen");
        Intrinsics.checkNotNullParameter(screenTraversalListener, "screenTraversalListener");
        ArrayList<Rect> arrayList = new ArrayList<>();
        boolean j = q0.j(view);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount() - 1;
            ArrayList<View> arrayList2 = new ArrayList<>();
            int i = childCount;
            boolean a2 = this.helper.a(arrayList2, viewGroup, childCount);
            while (!arrayList2.isEmpty()) {
                View view2 = (View) CollectionsKt.removeLast(arrayList2);
                Rect g = q0.g(view2);
                b bVar = this.helper;
                Intrinsics.checkNotNull(g);
                if (bVar.a(view2, g, overallVisibleViewsOnScreen, arrayList)) {
                    arrayList.addAll(a(view2, j, viewZIndex, overallVisibleViewsOnScreen, screenTraversalListener));
                }
                i--;
                if (!a2) {
                    a2 = this.helper.a(arrayList2, viewGroup, i);
                }
            }
            this.helper.a(viewGroup, arrayList, overallVisibleViewsOnScreen);
        }
        viewZIndex.a(viewZIndex.getZIndex() - 1);
        screenTraversalListener.a(view, isParentAList, viewZIndex.getZIndex());
        return this.helper.a(view, arrayList);
    }
}
