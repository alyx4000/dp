package com.quantummetric.ui.internal;

import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONObject;

/* loaded from: classes5.dex */
class ce {
    private static ce c;

    /* renamed from: a, reason: collision with root package name */
    final ArrayList<a> f162a = new ArrayList<>();
    final HashSet<ah> b = new HashSet<>();

    static class a {

        /* renamed from: a, reason: collision with root package name */
        final String f163a;
        final String b;
        final boolean c;
        final int d;
        final boolean e;

        a(JSONObject jSONObject) {
            this.f163a = jSONObject.optString("id");
            this.b = jSONObject.optString("class");
            this.c = jSONObject.optBoolean("block_children");
            this.d = jSONObject.optInt("retry_millis");
            this.e = jSONObject.optBoolean("capture_text", false);
        }
    }

    private ce() {
    }

    public static ce a() {
        if (c == null) {
            synchronized (ce.class) {
                c = new ce();
            }
        }
        return c;
    }
}
