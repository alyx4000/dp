package sdk.pendo.io.f9;

import android.app.Activity;
import android.view.ViewParent;
import android.widget.ScrollView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.g9.q;
import sdk.pendo.io.logging.PendoLogger;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ<\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J(\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0019\u0010\r\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0000¢\u0006\u0004\b\r\u0010\u0012J\u001c\u0010\r\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0016\u001a\u00020\nJ,\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0016\u001a\u00020\nR \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00000\u00188\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\r\u0010\u001a¨\u0006\u001e"}, d2 = {"Lsdk/pendo/io/f9/b;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Ljava/util/ArrayList;", "Lsdk/pendo/io/f9/d;", "Lkotlin/collections/ArrayList;", "visibleFragmentsList", "", "hierarchyLevel", "", "isIgnoreDynamicFragmentsInScrollView", "", "a", "Landroid/app/Activity;", "activity", "Landroid/view/ViewParent;", "viewParent", "(Landroid/view/ViewParent;)Z", "Ljava/util/TreeSet;", "", "fragmentsNames", "isOldScreenIdFormat", "fragmentsInfoList", "Ljava/lang/Class;", "Ljava/lang/Class;", "()Ljava/lang/Class;", "TAG", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Class<b> TAG = b.class;

    /* JADX WARN: Removed duplicated region for block: B:21:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void a(androidx.fragment.app.FragmentManager r7, java.util.ArrayList<sdk.pendo.io.f9.d> r8, int r9, boolean r10) {
        /*
            r6 = this;
            r0 = 0
            if (r7 == 0) goto L6a
            java.util.List r7 = r7.getFragments()
            java.lang.String r1 = "getFragments(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)
            java.util.List r7 = kotlin.collections.CollectionsKt.filterNotNull(r7)
            java.util.Iterator r7 = r7.iterator()
        L14:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L86
            java.lang.Object r1 = r7.next()
            androidx.fragment.app.Fragment r1 = (androidx.fragment.app.Fragment) r1
            r2 = 1
            if (r10 == 0) goto L37
            android.view.View r3 = r1.getView()
            if (r3 == 0) goto L2e
            android.view.ViewParent r3 = r3.getParent()
            goto L2f
        L2e:
            r3 = 0
        L2f:
            boolean r3 = r6.a(r3)
            if (r3 == 0) goto L37
            r3 = r2
            goto L38
        L37:
            r3 = r0
        L38:
            boolean r4 = sdk.pendo.io.g9.c0.a(r1)
            if (r4 == 0) goto L14
            if (r3 != 0) goto L14
            sdk.pendo.io.f9.d r3 = new sdk.pendo.io.f9.d
            java.lang.Class r4 = r1.getClass()
            java.lang.String r4 = r4.getSimpleName()
            java.lang.String r5 = "getSimpleName(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            android.view.View r5 = r1.getView()
            if (r5 == 0) goto L5a
            int r5 = r5.hashCode()
            goto L5b
        L5a:
            r5 = -1
        L5b:
            r3.<init>(r4, r9, r5)
            r8.add(r3)
            androidx.fragment.app.FragmentManager r1 = r1.getChildFragmentManager()
            int r2 = r2 + r9
            r6.a(r1, r8, r2, r10)
            goto L14
        L6a:
            java.lang.Class r7 = r6.a()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.StringBuilder r7 = r8.append(r7)
            java.lang.String r8 = ".allActivityFragmentsInfo, fragment manager is null"
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r0]
            sdk.pendo.io.logging.PendoLogger.e(r7, r8)
        L86:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.f9.b.a(androidx.fragment.app.FragmentManager, java.util.ArrayList, int, boolean):void");
    }

    static /* synthetic */ void a(b bVar, FragmentManager fragmentManager, ArrayList arrayList, int i, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: allActivityFragmentsInfo");
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        bVar.a(fragmentManager, arrayList, i, z);
    }

    public ArrayList<d> a(Activity activity, boolean isIgnoreDynamicFragmentsInScrollView) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ArrayList<d> arrayList = new ArrayList<>();
        if (activity instanceof FragmentActivity) {
            a(this, ((FragmentActivity) activity).getSupportFragmentManager(), arrayList, 0, isIgnoreDynamicFragmentsInScrollView, 4, null);
        } else {
            PendoLogger.d(a() + ".collectAllVisibleFragmentsInfo, activity is not FragmentActivity", new Object[0]);
        }
        return arrayList;
    }

    public final TreeSet<String> a(ArrayList<d> fragmentsInfoList, boolean isOldScreenIdFormat) {
        Intrinsics.checkNotNullParameter(fragmentsInfoList, "fragmentsInfoList");
        TreeSet<String> treeSet = new TreeSet<>();
        Iterator<d> it = fragmentsInfoList.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (!isOldScreenIdFormat || next.getFragmentLevel() == 0) {
                treeSet.add(next.getFragmentName());
            }
        }
        return treeSet;
    }

    public final String a(TreeSet<String> fragmentsNames, boolean isOldScreenIdFormat) {
        q qVar;
        Intrinsics.checkNotNullParameter(fragmentsNames, "fragmentsNames");
        String str = "";
        StringBuilder sb = new StringBuilder("");
        if (!fragmentsNames.isEmpty()) {
            sb.append("_F_");
            if (isOldScreenIdFormat) {
                qVar = q.f1144a;
            } else {
                qVar = q.f1144a;
                str = "|";
            }
            sb.append(qVar.a(str, fragmentsNames));
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public Class<b> a() {
        return this.TAG;
    }

    public final boolean a(ViewParent viewParent) {
        return viewParent != null && ((viewParent instanceof NestedScrollView) || (viewParent instanceof ScrollView) || a(viewParent.getParent()));
    }
}
