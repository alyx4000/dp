package sdk.pendo.io.g9;

import android.util.Pair;
import android.view.View;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import sdk.pendo.io.events.ConditionData;
import sdk.pendo.io.events.IdentificationData;

/* loaded from: classes6.dex */
public final class a0 {
    private static void a(View view, StringBuilder sb) {
        Integer a2;
        if (q0.j(view)) {
            return;
        }
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            if (!q0.j(view2) || (a2 = q0.a(view2, view)) == null || a2.intValue() == -1) {
                return;
            }
            sb.append("[").append("indexPath=(0,").append(a2).append(")").append("]");
        }
    }

    public static boolean a(IdentificationData identificationData, View view, ConditionData conditionData) {
        Boolean bool = Boolean.FALSE;
        return a(identificationData, sdk.pendo.io.m8.b.a(view, bool, bool), conditionData);
    }

    public static boolean a(IdentificationData identificationData, IdentificationData identificationData2, ConditionData conditionData) {
        String rAPredicate = identificationData.getRAPredicate();
        String rAPredicate2 = identificationData2.getRAPredicate();
        return (rAPredicate2 == null || !rAPredicate2.equals(rAPredicate) || l0.a(conditionData)) ? false : true;
    }

    public static synchronized String a(View view) {
        String sb;
        synchronized (a0.class) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Pair(view.getClass().getName(), view));
            for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
                arrayList.add(new Pair(parent.getClass().getName(), parent));
            }
            StringBuilder sb2 = new StringBuilder();
            Collections.reverse(arrayList);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                sb2.append("[").append((String) pair.first).append("]");
                Object obj = pair.second;
                if (obj instanceof View) {
                    a((View) obj, sb2);
                }
            }
            sb = sb2.toString();
        }
        return sb;
    }
}
