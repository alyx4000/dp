package sdk.pendo.io.l8;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.g9.r;
import sdk.pendo.io.g9.s;
import sdk.pendo.io.l8.b;
import sdk.pendo.io.utilities.AndroidUtils;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0003J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0015¨\u0006\f"}, d2 = {"Lsdk/pendo/io/l8/d;", "Lsdk/pendo/io/k8/a;", "Lorg/json/JSONObject;", "info", "", "c", "netInfo", "a", "json", "b", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class d extends sdk.pendo.io.k8.a {
    private final void a(JSONObject info, JSONObject netInfo) {
        if (AndroidUtils.b("android.permission.ACCESS_WIFI_STATE")) {
            Context a2 = a();
            Intrinsics.checkNotNull(a2);
            Object systemService = a2.getSystemService("wifi");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
            String macAddress = ((WifiManager) systemService).getConnectionInfo().getMacAddress();
            if (PendoInternal.I()) {
                String d = b.C0190b.f1342a.d();
                String a3 = s.a();
                Intrinsics.checkNotNullExpressionValue(a3, "getMockMACAddress(...)");
                r.a(netInfo, d, a3);
            } else {
                String d2 = b.C0190b.f1342a.d();
                Intrinsics.checkNotNull(macAddress);
                r.a(netInfo, d2, macAddress);
            }
        }
        r.a(info, b.C0190b.f1342a.a(), netInfo);
    }

    private final void c(JSONObject info) {
        Context a2 = a();
        Intrinsics.checkNotNull(a2);
        Object systemService = a2.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        if (AndroidUtils.b("android.permission.ACCESS_NETWORK_STATE")) {
            JSONObject jSONObject = new JSONObject();
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                b.C0190b c0190b = b.C0190b.f1342a;
                r.a(jSONObject, c0190b.b(), Boolean.valueOf(activeNetworkInfo.isRoaming()));
                String c = c0190b.c();
                String typeName = activeNetworkInfo.getTypeName();
                Intrinsics.checkNotNullExpressionValue(typeName, "getTypeName(...)");
                r.a(jSONObject, c, typeName);
            }
            a(info, jSONObject);
        }
    }

    @Override // sdk.pendo.io.k8.a
    protected void b(JSONObject json) {
        Intrinsics.checkNotNullParameter(json, "json");
        c(json);
    }
}
