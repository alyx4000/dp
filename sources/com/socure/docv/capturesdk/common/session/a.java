package com.socure.docv.capturesdk.common.session;

import com.socure.docv.capturesdk.common.network.model.stepup.App;
import com.socure.docv.capturesdk.common.network.model.stepup.Consent;
import com.socure.docv.capturesdk.common.network.model.stepup.FlowData;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class a {
    public static String b = null;
    public static String c = null;
    public static String d = null;
    public static String e = null;
    public static String f = null;
    public static String g = null;
    public static long h = 20000;
    public static String k;
    public static App l;
    public static FlowData m;
    public static Consent n;

    /* renamed from: a, reason: collision with root package name */
    public static final a f305a = new a();
    public static HashMap<String, String> i = new HashMap<>();
    public static HashMap<String, byte[]> j = new HashMap<>();

    public final void a() {
        Intrinsics.checkNotNullParameter("", "<set-?>");
        b = "";
        Intrinsics.checkNotNullParameter("", "<set-?>");
        c = "";
        Intrinsics.checkNotNullParameter("", "<set-?>");
        d = "";
        g = null;
        e = null;
        f = null;
        HashMap<String, byte[]> hashMap = j;
        if (hashMap != null) {
            hashMap.clear();
        }
        HashMap<String, String> hashMap2 = i;
        if (hashMap2 != null) {
            hashMap2.clear();
        }
        j = null;
        i = null;
        k = null;
    }

    public final App b() {
        App app = l;
        if (app != null) {
            return app;
        }
        Intrinsics.throwUninitializedPropertyAccessException("configData");
        return null;
    }

    public final FlowData c() {
        FlowData flowData = m;
        if (flowData != null) {
            return flowData;
        }
        Intrinsics.throwUninitializedPropertyAccessException("flowData");
        return null;
    }

    public final String d() {
        String str = b;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("publicKey");
        return null;
    }

    public final String e() {
        String str = c;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("socureVerificationToken");
        return null;
    }
}
