package sdk.pendo.io.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import sdk.pendo.io.d6.e;
import sdk.pendo.io.d9.b;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.n8.c;
import sdk.pendo.io.network.interfaces.GetAuthToken;
import sdk.pendo.io.network.interfaces.a;

/* loaded from: classes6.dex */
public final class PendoGateActivity extends Activity {
    private Intent a() {
        Activity f = c.g().f() != null ? c.g().f() : c.g().h();
        return (f == null || f.getIntent() == null) ? getPackageManager().getLaunchIntentForPackage(getPackageName()) : f.getIntent();
    }

    private void b() {
        Intent a2 = a();
        if (a2 != null) {
            startActivity(a2);
        } else {
            Log.w("PendoGateActivity->", "Launch intent is null can't start activity");
        }
    }

    private void c() {
        final String dataString = getIntent().getDataString();
        a.c().f().a(b.a(new e() { // from class: sdk.pendo.io.activities.PendoGateActivity$$ExternalSyntheticLambda0
            @Override // sdk.pendo.io.d6.e
            public final void accept(Object obj) {
                PendoGateActivity.a(dataString, (GetAuthToken.GetAuthTokenResponse) obj);
            }
        }, "PendoGateActivity-> start pairingProcess access token observer"));
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Uri data = getIntent().getData();
        if (data != null && "pairing".equals(data.getHost())) {
            c();
        }
        b();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, GetAuthToken.GetAuthTokenResponse getAuthTokenResponse) {
        if (TextUtils.isEmpty(getAuthTokenResponse.accessToken)) {
            return;
        }
        sdk.pendo.io.z8.b.b(str);
        PendoLogger.d("trying to connect to socket...", new Object[0]);
        sdk.pendo.io.u8.a.f1643a.a();
    }
}
