package com.socure.idplus.device.internal.sharedPrefs;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f588a;
    public final SharedPreferences.Editor b;
    public final Gson c;

    public a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("socure_pref", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.f588a = sharedPreferences;
        SharedPreferences.Editor edit = sharedPreferences.edit();
        Intrinsics.checkNotNullExpressionValue(edit, "edit(...)");
        this.b = edit;
        this.c = new Gson();
    }

    public final void a() {
        String string = this.f588a.getString("SocureDeviceRiskUUID", "");
        if (string == null || StringsKt.isBlank(string)) {
            return;
        }
        this.b.remove("SocureDeviceRiskUUID");
        this.b.apply();
    }
}
