package sdk.pendo.io.listeners.views;

import android.widget.AdapterView;
import java.util.ArrayList;
import sdk.pendo.io.b6.b;

/* loaded from: classes6.dex */
public final class PendoOnItemClickListener implements AdapterView.OnItemClickListener {
    private static final String TAG = "PendoOnItemClickListener";
    private ArrayList<AdapterView.OnItemClickListener> mOnItemClickListener = new ArrayList<>();
    private b mSubscription = null;

    public boolean addListener(AdapterView.OnItemClickListener onItemClickListener) {
        return this.mOnItemClickListener.add(onItemClickListener);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d5 A[LOOP:0: B:26:0x00cf->B:28:0x00d5, LOOP_END] */
    @Override // android.widget.AdapterView.OnItemClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onItemClick(final android.widget.AdapterView<?> r11, final android.view.View r12, final int r13, final long r14) {
        /*
            r10 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "PendoOnItemClickListener onItemClick, position: '"
            r0.<init>(r1)
            java.lang.StringBuilder r0 = r0.append(r13)
            java.lang.String r1 = "', id: '"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r14)
            java.lang.String r1 = "'."
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]
            sdk.pendo.io.logging.PendoLogger.d(r0, r2)
            java.lang.String r0 = ""
            r2 = 1
            boolean r3 = sdk.pendo.io.t8.a.d()     // Catch: java.lang.Exception -> L56
            if (r3 != 0) goto L54
            boolean r3 = sdk.pendo.io.PendoInternal.U()     // Catch: java.lang.Exception -> L56
            if (r3 == 0) goto L54
            sdk.pendo.io.g9.o0 r3 = sdk.pendo.io.g9.o0.f1142a     // Catch: java.lang.Exception -> L56
            org.json.JSONObject r3 = r3.b(r12)     // Catch: java.lang.Exception -> L56
            sdk.pendo.io.e9.a r4 = sdk.pendo.io.e9.a.f1035a     // Catch: java.lang.Exception -> L56
            r4.a(r3, r1)     // Catch: java.lang.Exception -> L56
            boolean r4 = sdk.pendo.io.actions.GuidesActionsManager.isActivityDestroyed()     // Catch: java.lang.Exception -> L56
            if (r4 != 0) goto L7f
            sdk.pendo.io.actions.ActivationManager r5 = sdk.pendo.io.actions.ActivationManager.INSTANCE     // Catch: java.lang.Exception -> L52
            java.lang.ref.WeakReference r6 = new java.lang.ref.WeakReference     // Catch: java.lang.Exception -> L52
            r6.<init>(r12)     // Catch: java.lang.Exception -> L52
            java.lang.String r2 = r5.handleClick(r3, r6)     // Catch: java.lang.Exception -> L52
            r3 = r2
            goto L80
        L52:
            r3 = move-exception
            goto L58
        L54:
            r3 = r0
            goto L81
        L56:
            r3 = move-exception
            r4 = r2
        L58:
            java.lang.String r5 = r3.getMessage()
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "parent: "
            r6.<init>(r7)
            if (r11 == 0) goto L70
            java.lang.Class r7 = r11.getClass()
            java.lang.String r7 = r7.getCanonicalName()
            goto L72
        L70:
            java.lang.String r7 = "no parent"
        L72:
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r6 = r6.toString()
            r2[r1] = r6
            sdk.pendo.io.logging.PendoLogger.e(r3, r5, r2)
        L7f:
            r3 = r0
        L80:
            r2 = r4
        L81:
            if (r2 != 0) goto Lc9
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L8a
            goto Lc9
        L8a:
            sdk.pendo.io.b6.b r0 = r10.mSubscription
            if (r0 != 0) goto Le4
            sdk.pendo.io.actions.PendoCommandsEventBus r0 = sdk.pendo.io.actions.PendoCommandsEventBus.getInstance()     // Catch: java.lang.Exception -> Lbb
            sdk.pendo.io.x5.d r0 = r0.getCommandEventBus()     // Catch: java.lang.Exception -> Lbb
            sdk.pendo.io.x5.f r2 = sdk.pendo.io.actions.VisualAnimationManager.waitForAnimationDoneAndNotifyClose(r3)     // Catch: java.lang.Exception -> Lbb
            sdk.pendo.io.x5.d r0 = r0.a(r2)     // Catch: java.lang.Exception -> Lbb
            sdk.pendo.io.x5.g r0 = r0.b()     // Catch: java.lang.Exception -> Lbb
            sdk.pendo.io.listeners.views.PendoOnItemClickListener$1 r9 = new sdk.pendo.io.listeners.views.PendoOnItemClickListener$1     // Catch: java.lang.Exception -> Lbb
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r13
            r7 = r14
            r2.<init>()     // Catch: java.lang.Exception -> Lbb
            sdk.pendo.io.a9.a r11 = new sdk.pendo.io.a9.a     // Catch: java.lang.Exception -> Lbb
            java.lang.String r12 = "PendoOnItemClickListener Pendo Command error consumer"
            r11.<init>(r12)     // Catch: java.lang.Exception -> Lbb
            sdk.pendo.io.b6.b r11 = r0.a(r9, r11)     // Catch: java.lang.Exception -> Lbb
            r10.mSubscription = r11     // Catch: java.lang.Exception -> Lbb
            goto Le4
        Lbb:
            r11 = move-exception
            r12 = 0
            r10.mSubscription = r12
            java.lang.String r12 = r11.getMessage()
            java.lang.Object[] r13 = new java.lang.Object[r1]
            sdk.pendo.io.logging.PendoLogger.e(r11, r12, r13)
            goto Le4
        Lc9:
            java.util.ArrayList<android.widget.AdapterView$OnItemClickListener> r0 = r10.mOnItemClickListener
            java.util.Iterator r0 = r0.iterator()
        Lcf:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto Le4
            java.lang.Object r1 = r0.next()
            r2 = r1
            android.widget.AdapterView$OnItemClickListener r2 = (android.widget.AdapterView.OnItemClickListener) r2
            r3 = r11
            r4 = r12
            r5 = r13
            r6 = r14
            r2.onItemClick(r3, r4, r5, r6)
            goto Lcf
        Le4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.listeners.views.PendoOnItemClickListener.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
    }
}
