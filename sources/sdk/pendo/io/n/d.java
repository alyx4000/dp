package sdk.pendo.io.n;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.DailyPay.DailyPay.R;
import external.sdk.pendo.io.gson.Gson;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.actions.GuideActionConfiguration;
import sdk.pendo.io.actions.PendoCommand;
import sdk.pendo.io.actions.PendoCommandAction;
import sdk.pendo.io.actions.PendoCommandDispatcher;
import sdk.pendo.io.actions.PendoCommandEventType;
import sdk.pendo.io.g9.p;
import sdk.pendo.io.k0.i;
import sdk.pendo.io.k0.l;
import sdk.pendo.io.k0.m;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.PersonalizationDefVal;
import sdk.pendo.io.n.c;
import sdk.pendo.io.utilities.script.JavascriptRunner;
import sdk.pendo.io.views.custom.ActionableBlock;
import sdk.pendo.io.views.custom.IBackgroundRenderView;
import sdk.pendo.io.views.custom.PendoForm;
import sdk.pendo.io.views.custom.PendoScrollView;
import sdk.pendo.io.x5.j;
import sdk.pendo.io.x5.o;

/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, Integer> f1409a = new HashMap<>();
    private static Type b = new a().b();

    class a extends sdk.pendo.io.q0.a<HashMap<String, PersonalizationDefVal>> {
        a() {
        }
    }

    class b implements sdk.pendo.io.d6.e<Boolean> {
        final /* synthetic */ List f;

        b(List list) {
            this.f = list;
        }

        @Override // sdk.pendo.io.d6.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Boolean bool) {
            PendoCommandDispatcher.getInstance().dispatchCommands(this.f, PendoCommandEventType.UserEventType.TAP_ON, true);
        }
    }

    class c implements sdk.pendo.io.d6.e<Integer> {
        final /* synthetic */ List f;

        c(List list) {
            this.f = list;
        }

        @Override // sdk.pendo.io.d6.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Integer num) {
            PendoCommandDispatcher pendoCommandDispatcher;
            List<PendoCommand> list;
            PendoCommandEventType.FormEventType formEventType;
            if (num.intValue() != -1) {
                PendoCommandDispatcher.getInstance().dispatchCommands(this.f, PendoCommandEventType.FormEventType.ON_SELECTION_CHANGED, true);
                pendoCommandDispatcher = PendoCommandDispatcher.getInstance();
                list = this.f;
                formEventType = PendoCommandEventType.FormEventType.ON_VALID;
            } else {
                pendoCommandDispatcher = PendoCommandDispatcher.getInstance();
                list = this.f;
                formEventType = PendoCommandEventType.FormEventType.ON_INVALID;
            }
            pendoCommandDispatcher.dispatchCommands(list, formEventType, true);
        }
    }

    public static void a(View view, Map<String, sdk.pendo.io.n.c> map) {
        if (view instanceof TextView) {
            a(map, c.b.BACKGROUND.name(), new sdk.pendo.io.n.c((l) new Gson().a("{\"name\": \"background\",\"type\": \"color\",\"value\": \"#FFFFFF00\"}", l.class)));
            a(map, c.b.INCLUDE_FONT_PADDING.name(), new sdk.pendo.io.n.c((l) new Gson().a("{\"name\": \"include_font_padding\",\"type\": \"boolean\",\"value\": \"false\"}", l.class)));
        }
    }

    public static Map<String, sdk.pendo.io.n.c> b(l lVar) {
        HashMap hashMap = new HashMap();
        sdk.pendo.io.k0.f b2 = lVar.b("properties");
        if (b2 != null) {
            for (int i = 0; i < b2.size(); i++) {
                sdk.pendo.io.n.c cVar = new sdk.pendo.io.n.c(b2.a(i).e());
                if (cVar.l()) {
                    hashMap.put(cVar.f1407a.name(), cVar);
                }
            }
        }
        return hashMap;
    }

    public static View a(Context context, l lVar, ViewGroup viewGroup, Class cls, String str, String str2) {
        if (lVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        View a2 = a(context, lVar, viewGroup, (HashMap<String, Integer>) hashMap, str, str2, (HashMap<String, WeakReference<View>>) new HashMap());
        if (a2 == null) {
            return null;
        }
        if (a2.getTag(R.animator.design_appbar_state_list_animator) != null) {
            sdk.pendo.io.n.a.a(a2, (Map<String, sdk.pendo.io.n.c>) a2.getTag(R.animator.design_appbar_state_list_animator), viewGroup, (HashMap<String, Integer>) hashMap);
        }
        a2.setTag(null);
        if (cls != null) {
            try {
                Object newInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
                sdk.pendo.io.n.a.a(newInstance, a2, (HashMap<String, Integer>) hashMap);
                a2.setTag(newInstance);
            } catch (Exception e) {
                PendoLogger.e(e, e.getMessage(), "holder class:" + cls.getCanonicalName() + "guideId: " + str + " stepId: " + str2);
            }
        }
        return a2;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.view.View a(android.content.Context r16, sdk.pendo.io.k0.l r17, android.view.ViewGroup r18, java.util.HashMap<java.lang.String, java.lang.Integer> r19, java.lang.String r20, java.lang.String r21, java.util.HashMap<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r22) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.n.d.a(android.content.Context, sdk.pendo.io.k0.l, android.view.ViewGroup, java.util.HashMap, java.lang.String, java.lang.String, java.util.HashMap):android.view.View");
    }

    public static void a(Map<String, sdk.pendo.io.n.c> map, String str) {
        if (str.equals("RowBlock")) {
            sdk.pendo.io.n.c cVar = new sdk.pendo.io.n.c((l) new Gson().a("{\"name\": \"orientation\",\"type\": \"string\",\"value\": \"horizontal\"}", l.class));
            map.put(cVar.f1407a.name(), cVar);
        }
    }

    public static HashMap<String, Integer> a() {
        return f1409a;
    }

    public static Map<String, PersonalizationDefVal> a(l lVar) {
        i a2;
        if (lVar == null || (a2 = lVar.a(GuideActionConfiguration.GUIDE_SCREEN_PERSONALIZATION)) == null) {
            return null;
        }
        try {
            return (Map) PendoInternal.l.a(a2, b);
        } catch (m unused) {
            PendoLogger.d("initDefaultValuesForView - fromJson failed: " + a2, new Object[0]);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void a(View view, l lVar, String str) {
        j b2;
        sdk.pendo.io.d6.e cVar;
        String str2;
        sdk.pendo.io.k0.f b3 = p.b(lVar, "actions");
        if (b3 == null || b3.size() <= 0) {
            return;
        }
        List<PendoCommand> pendoCommandsWithParameters = PendoCommand.getPendoCommandsWithParameters(b3, PendoCommandAction.PendoCommandGlobalAction.PendoInfoConsts.createPendoMetadataParams(str), new JavascriptRunner.GuideContext(str));
        if (view instanceof ActionableBlock) {
            ((ActionableBlock) view).setActions(pendoCommandsWithParameters);
        }
        if (view instanceof PendoForm) {
            ((PendoForm) view).processForm(lVar, pendoCommandsWithParameters, str);
            return;
        }
        if (view instanceof RadioButton) {
            b2 = sdk.pendo.io.d7.c.a((CompoundButton) view).a(sdk.pendo.io.f7.g.a(view)).b(1L);
            cVar = new b(pendoCommandsWithParameters);
            str2 = "DynamicView RxCompoundButton isChecked observer";
        } else {
            if (!(view instanceof RadioGroup)) {
                return;
            }
            b2 = sdk.pendo.io.d7.e.a((RadioGroup) view).a(sdk.pendo.io.f7.g.a(view)).b(1L);
            cVar = new c(pendoCommandsWithParameters);
            str2 = "DynamicView RxRadioGroup checkedId observer";
        }
        b2.a((o) sdk.pendo.io.d9.c.a(cVar, str2));
    }

    private static void a(Context context, View view, l lVar, HashMap<String, Integer> hashMap, String str, String str2, HashMap<String, WeakReference<View>> hashMap2) {
        ViewGroup viewGroup = (ViewGroup) view;
        ArrayList<View> arrayList = new ArrayList();
        sdk.pendo.io.k0.f b2 = lVar.b(GuideActionConfiguration.GUIDE_BUILDING_BLOCK_VIEWS);
        if (b2 != null) {
            int size = b2.size();
            for (int i = 0; i < size; i++) {
                View a2 = a(context, b2.a(i).e(), viewGroup, hashMap, str, str2, hashMap2);
                if (a2 == null || a2.getParent() != null) {
                    PendoLogger.e("Error: Cannot create view: " + b2.a(i).e(), new Object[0]);
                } else {
                    arrayList.add(a2);
                    viewGroup.addView(a2);
                }
            }
        }
        for (View view2 : arrayList) {
            Map map = (Map) view2.getTag(R.animator.design_appbar_state_list_animator);
            if (map != null) {
                sdk.pendo.io.n.a.a(view2, (Map<String, sdk.pendo.io.n.c>) map, viewGroup, hashMap);
                view2.setTag(R.animator.design_appbar_state_list_animator, null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.view.View a(android.content.Context r2, java.lang.String r3, sdk.pendo.io.k0.l r4, android.view.ViewGroup r5, java.lang.String r6, java.lang.String r7) {
        /*
            r3.hashCode()
            java.lang.String r0 = "sdk.pendo.io.views.custom.PendoRegularRadioButton"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L40
            java.lang.String r0 = "sdk.pendo.io.views.custom.VisualActionImage"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L2e
            java.lang.Class r3 = java.lang.Class.forName(r3)
            r7 = 1
            java.lang.Class[] r7 = new java.lang.Class[r7]
            r0 = 0
            java.lang.Class<android.content.Context> r1 = android.content.Context.class
            r7[r0] = r1
            java.lang.reflect.Constructor r3 = r3.getConstructor(r7)
            java.lang.Object[] r2 = new java.lang.Object[]{r2}
            java.lang.Object r2 = r3.newInstance(r2)
            android.view.View r2 = (android.view.View) r2
            goto L46
        L2e:
            boolean r3 = r7.isEmpty()
            if (r3 == 0) goto L3a
            sdk.pendo.io.views.custom.VisualActionImage r3 = new sdk.pendo.io.views.custom.VisualActionImage
            r3.<init>(r2, r6)
            goto L45
        L3a:
            sdk.pendo.io.views.custom.VisualActionImage r3 = new sdk.pendo.io.views.custom.VisualActionImage
            r3.<init>(r2, r7)
            goto L45
        L40:
            sdk.pendo.io.views.custom.PendoRegularRadioButton r3 = new sdk.pendo.io.views.custom.PendoRegularRadioButton
            r3.<init>(r2)
        L45:
            r2 = r3
        L46:
            if (r2 == 0) goto L52
            a(r2, r4, r6)
            android.view.ViewGroup$LayoutParams r3 = sdk.pendo.io.n.a.a(r5)
            r2.setLayoutParams(r3)
        L52:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.n.d.a(android.content.Context, java.lang.String, sdk.pendo.io.k0.l, android.view.ViewGroup, java.lang.String, java.lang.String):android.view.View");
    }

    private static void a(Map<String, sdk.pendo.io.n.c> map, String str, sdk.pendo.io.n.c cVar) {
        if (map.get(str) == null) {
            map.put(str, cVar);
        }
    }

    private static void a(int i, sdk.pendo.io.n.c cVar, HashMap<String, WeakReference<View>> hashMap) {
        WeakReference<View> weakReference;
        if (cVar == null || cVar.j() == null) {
            return;
        }
        String j = cVar.j();
        if (!hashMap.containsKey(j) || (weakReference = hashMap.get(j)) == null || weakReference.get() == null) {
            return;
        }
        weakReference.get().setLabelFor(i);
    }

    private static void a(HashMap<String, Integer> hashMap, String str, String str2, String str3, int i) {
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(str, Integer.valueOf(i));
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put(str2, Integer.valueOf(i));
        }
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        hashMap.put(str3, Integer.valueOf(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static View a(Context context, View view, ViewGroup viewGroup, l lVar, HashMap<String, Integer> hashMap) {
        if (!p.a(lVar, "scrollable", false)) {
            return view;
        }
        boolean equals = "fill".equals(p.a(lVar, "scrollMode", "fill"));
        PendoScrollView pendoScrollView = new PendoScrollView(context);
        pendoScrollView.setLayoutParams(sdk.pendo.io.n.a.a(viewGroup));
        pendoScrollView.setFillViewport(equals);
        pendoScrollView.setId(view.getId());
        view.setId(View.generateViewId());
        pendoScrollView.addView(view);
        Map map = (Map) view.getTag(R.animator.design_appbar_state_list_animator);
        pendoScrollView.setTag(R.animator.design_appbar_state_list_animator, map);
        if (map != null) {
            sdk.pendo.io.n.a.a(view, (Map<String, sdk.pendo.io.n.c>) map, pendoScrollView, hashMap);
            if (view instanceof IBackgroundRenderView) {
                ((IBackgroundRenderView) view).setImageBackgroundURL(null);
                view.setBackground(null);
                sdk.pendo.io.n.a.a(pendoScrollView, (Map<String, sdk.pendo.io.n.c>) map);
            }
            view.setTag(R.animator.design_appbar_state_list_animator, null);
        }
        return pendoScrollView;
    }
}
