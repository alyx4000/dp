package sdk.pendo.io.g9;

import android.content.Context;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\n\u0010\u0001\u001a\u00020\u0000*\u00020\u0000\u001a\u0010\u0010\u0001\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u001a\u000e\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\b"}, d2 = {"Landroid/view/MotionEvent;", "a", "Landroid/content/Context;", "context", "", "Landroid/view/View;", "view", "", "pendoIO_release"}, k = 2, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class b {
    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(android.view.View r9) {
        /*
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            int r0 = androidx.core.R.id.tag_accessibility_actions
            java.lang.Object r0 = r9.getTag(r0)
            boolean r1 = r0 instanceof java.util.ArrayList
            r2 = 0
            if (r1 == 0) goto L13
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            goto L14
        L13:
            r0 = r2
        L14:
            if (r0 == 0) goto L38
            java.util.Iterator r9 = r0.iterator()
        L1a:
            boolean r1 = r9.hasNext()
            if (r1 == 0) goto L4b
            java.lang.Object r1 = r9.next()
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat r1 = (androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat) r1
            int r3 = r1.getId()
            r4 = 16
            if (r3 != r4) goto L1a
            boolean r9 = r1 instanceof sdk.pendo.io.b8.a
            if (r9 == 0) goto L33
            return
        L33:
            r0.remove(r1)
            r6 = r1
            goto L4c
        L38:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            int r1 = androidx.core.R.id.tag_accessibility_actions
            r9.setTag(r1, r0)
            androidx.core.view.AccessibilityDelegateCompat r1 = androidx.core.view.ViewCompat.getAccessibilityDelegate(r9)
            if (r1 != 0) goto L4b
            androidx.core.view.ViewCompat.enableAccessibleClickableSpanSupport(r9)
        L4b:
            r6 = r2
        L4c:
            if (r6 == 0) goto L52
            java.lang.CharSequence r2 = r6.getLabel()
        L52:
            r7 = r2
            sdk.pendo.io.b8.a r9 = new sdk.pendo.io.b8.a
            sdk.pendo.io.e9.a r4 = sdk.pendo.io.e9.a.f1035a
            sdk.pendo.io.actions.ActivationManager r5 = sdk.pendo.io.actions.ActivationManager.INSTANCE
            r8 = 16
            r3 = r9
            r3.<init>(r4, r5, r6, r7, r8)
            r0.add(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.g9.b.a(android.view.View):void");
    }

    public static final boolean a(Context context) {
        if (context != null) {
            Object systemService = context.getSystemService("accessibility");
            AccessibilityManager accessibilityManager = systemService instanceof AccessibilityManager ? (AccessibilityManager) systemService : null;
            if (accessibilityManager != null && accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
                return true;
            }
        }
        return false;
    }

    public static final MotionEvent a(MotionEvent motionEvent) {
        int i;
        Intrinsics.checkNotNullParameter(motionEvent, "<this>");
        int action = motionEvent.getAction();
        if (action == 7) {
            i = 2;
        } else {
            if (action != 9) {
                if (action == 10) {
                    i = 1;
                }
                return motionEvent;
            }
            i = 0;
        }
        motionEvent.setAction(i);
        return motionEvent;
    }
}
