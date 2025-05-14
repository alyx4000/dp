package sdk.pendo.io.m8;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import sdk.pendo.io.events.ConditionData;
import sdk.pendo.io.events.IdentificationData;
import sdk.pendo.io.g9.l0;
import sdk.pendo.io.g9.m0;
import sdk.pendo.io.g9.o0;
import sdk.pendo.io.g9.p0;
import sdk.pendo.io.g9.q0;
import sdk.pendo.io.p2.d;

/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static o0.a f1402a = new a();

    class a extends o0.a {
        a() {
        }

        @Override // sdk.pendo.io.g9.o0.a
        public boolean performActionOnView(View view, Bundle bundle) {
            if (view == null || !(view instanceof TextView)) {
                return false;
            }
            String obj = ((TextView) view).getText().toString();
            if (TextUtils.isEmpty(obj)) {
                return false;
            }
            getData().putString("result", m0.a((CharSequence) obj).toString());
            return true;
        }
    }

    public static synchronized IdentificationData a(View view, IdentificationData identificationData) {
        TextView a2;
        synchronized (b.class) {
            if (view == null) {
                return identificationData;
            }
            IdentificationData.LegacyTexts legacyTexts = identificationData.getLegacyTexts();
            if ((view instanceof TextView) && !(view instanceof EditText)) {
                legacyTexts.setText(((TextView) view).getText().toString());
            }
            if (q0.k(view) && (a2 = q0.a(view, true)) != null && a2.getText() != null && !TextUtils.isEmpty(legacyTexts.getLegacyTextBase64())) {
                legacyTexts.setText(a2.getText().toString().trim());
            }
            if (view.isClickable() && TextUtils.isEmpty(legacyTexts.getLegacyTextBase64())) {
                q0.c cVar = new q0.c();
                q0.a(view, true, cVar, true);
                if (cVar.c() != null) {
                    legacyTexts.setText(cVar.c().trim());
                }
                if (cVar.a() != null) {
                    legacyTexts.setAccessibilityData(cVar.a());
                }
                if (cVar.b() != null && cVar.b().size() > 1) {
                    legacyTexts.setNestedTexts(cVar.b());
                }
            }
            String c = q0.c(view);
            if (!TextUtils.isEmpty(c) && legacyTexts.getLegacyAccessibilityBase64() == null) {
                legacyTexts.setAccessibilityData(c);
            }
            return identificationData;
        }
    }

    public static synchronized sdk.pendo.io.u2.b<Boolean, Integer> a(IdentificationData identificationData, IdentificationData identificationData2, boolean z, ConditionData conditionData) {
        synchronized (b.class) {
            d diff = identificationData.diff(identificationData2);
            int i = 100;
            if (diff.b() == 0 && !l0.a(conditionData)) {
                return sdk.pendo.io.u2.b.a(Boolean.TRUE, 100);
            }
            Iterator<sdk.pendo.io.p2.b<?>> it = diff.a().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String c = it.next().c();
                if (IdentificationData.FIELD_PARENT_ID.equals(c) || IdentificationData.FIELD_INDEX_IN_PARENT.equals(c) || ((IdentificationData.FIELD_ID_OF_PARENTS.equals(c) && !z) || "id".equals(c) || "type".equals(c) || "text".equals(c) || IdentificationData.RA_PREDICATE.equals(c) || "label".equals(c))) {
                    break;
                }
                if (IdentificationData.FIELD_CHILD_COUNT.equals(c)) {
                    i -= 5;
                }
            }
            i = 0;
            return sdk.pendo.io.u2.b.a(Boolean.valueOf(i >= 70), Integer.valueOf(i));
        }
    }

    public static synchronized IdentificationData a(View view, Boolean bool, Boolean bool2) {
        int indexOfChild;
        String f;
        TextView d;
        synchronized (b.class) {
            IdentificationData identificationData = new IdentificationData();
            if (view == null) {
                return identificationData;
            }
            identificationData.setPredicate(view);
            identificationData.retrieveViewTag(view);
            if (bool.booleanValue()) {
                if ((view instanceof TextView) && !(view instanceof EditText)) {
                    identificationData.setText(((TextView) view).getText().toString());
                }
                if (q0.k(view) && (d = q0.d(view)) != null && d.getText() != null && TextUtils.isEmpty(identificationData.getTextBase64())) {
                    identificationData.setText(d.getText().toString().trim());
                }
                if (TextUtils.isEmpty(identificationData.getAccessibilityBase64())) {
                    String c = q0.c(view);
                    if (!TextUtils.isEmpty(c)) {
                        identificationData.setAccessibility(c);
                    }
                }
                if (p0.b(view)) {
                    q0.c cVar = new q0.c();
                    q0.a(view, bool2.booleanValue(), cVar);
                    if (cVar.c() != null && TextUtils.isEmpty(identificationData.getTextBase64())) {
                        identificationData.setText(cVar.c().trim());
                    }
                    if (cVar.a() != null && TextUtils.isEmpty(identificationData.getAccessibilityBase64())) {
                        identificationData.setAccessibility(cVar.a());
                    }
                    if (bool2.booleanValue() && cVar.b() != null && cVar.b().size() > 1) {
                        identificationData.setNestedTexts(cVar.b());
                    }
                }
            }
            String f2 = q0.f(view);
            if (f2 != null) {
                identificationData.setId(f2);
            }
            ArrayList<String> arrayList = new ArrayList<>();
            for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
                if ((parent instanceof View) && (f = q0.f((View) parent)) != null) {
                    arrayList.add(f);
                }
            }
            identificationData.setIdOfParents(arrayList);
            if (view instanceof ViewGroup) {
                identificationData.setChildCount(((ViewGroup) view).getChildCount());
            }
            if (q0.l(view)) {
                identificationData.setInsideList(true);
            }
            ViewParent parent2 = view.getParent();
            if ((parent2 instanceof ViewGroup) && (indexOfChild = ((ViewGroup) parent2).indexOfChild(view)) != -1) {
                identificationData.setIndexInParent(Integer.valueOf(indexOfChild));
            }
            if (q0.d()) {
                identificationData.setInsideDrawer(true);
            }
            if (q0.j(view)) {
                identificationData.setIsList(true);
            }
            identificationData.setType(view.getClass().getSimpleName());
            return identificationData;
        }
    }
}
