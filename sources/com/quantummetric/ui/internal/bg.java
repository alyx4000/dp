package com.quantummetric.ui.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: classes5.dex */
final class bg extends ArrayList<bf> implements x {
    bg() {
    }

    @Override // com.quantummetric.ui.internal.x
    public final byte[] a() {
        return de.f(c().toString());
    }

    @Override // com.quantummetric.ui.internal.x
    public final String b() {
        return c().toString();
    }

    final JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator<bf> it = iterator();
            while (it.hasNext()) {
                jSONArray.put(de.a((Map<String, ?>) it.next()));
            }
        } catch (Exception unused) {
        }
        return jSONArray;
    }
}
