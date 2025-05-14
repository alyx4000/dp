package com.quantummetric.ui.internal;

import android.view.View;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
final class i extends JSONObject {

    enum a {
        l,
        w,
        p,
        c
    }

    private i() {
    }

    private i(String str) throws JSONException {
        super(str);
    }

    static i a(View view) {
        String str;
        if (aa.p != 0) {
            Object tag = view.getTag(aa.p);
            if (tag instanceof String) {
                str = (String) tag;
                if (!de.b(str) && str.startsWith("{")) {
                    try {
                        return new i(str);
                    } catch (Throwable unused) {
                    }
                }
                return null;
            }
        }
        str = "";
        if (!de.b(str)) {
            return new i(str);
        }
        return null;
    }

    static i a(JSONObject jSONObject) {
        i iVar = null;
        try {
            for (a aVar : a.values()) {
                String optString = jSONObject.optString("rn_".concat(String.valueOf(aVar.name())));
                if (!de.b(optString)) {
                    if (iVar == null) {
                        iVar = new i();
                    }
                    iVar.put(aVar.name(), optString);
                }
            }
        } catch (Throwable unused) {
        }
        return iVar;
    }

    static String a(String str) {
        return "rn-".concat(String.valueOf(str));
    }

    static String b(View view) {
        String str;
        if (aa.p != 0) {
            Object tag = view.getTag(aa.p);
            if (tag instanceof String) {
                str = (String) tag;
                return (de.b(str) || str.startsWith("{")) ? "" : str;
            }
        }
        str = "";
        if (de.b(str)) {
            return "";
        }
    }

    final void a(ar arVar) {
        for (a aVar : a.values()) {
            String name = aVar.name();
            String optString = optString(name);
            if (!de.b(optString)) {
                ad.a(arVar, "data-" + "rn-".concat(String.valueOf(name)), optString);
            }
        }
    }

    final boolean a(i iVar) {
        boolean z = iVar != null;
        if (z) {
            for (a aVar : a.values()) {
                String optString = optString(aVar.name());
                if (!de.b(optString) && !(z = optString.equals(iVar.optString(aVar.name())))) {
                    break;
                }
            }
        }
        return z;
    }
}
