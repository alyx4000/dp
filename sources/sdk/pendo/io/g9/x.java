package sdk.pendo.io.g9;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import sdk.pendo.io.R;
import sdk.pendo.io.e8.a;
import sdk.pendo.io.g9.q0;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.views.listener.FloatingListenerButton;

/* loaded from: classes6.dex */
public final class x {
    public static void a(final FloatingListenerButton floatingListenerButton) {
        final Activity f = sdk.pendo.io.n8.c.g().f();
        if (f == null) {
            return;
        }
        sdk.pendo.io.e8.a aVar = new sdk.pendo.io.e8.a(new a.InterfaceC0122a() { // from class: sdk.pendo.io.g9.x$$ExternalSyntheticLambda0
            @Override // sdk.pendo.io.e8.a.InterfaceC0122a
            public final void a() {
                x.a(FloatingListenerButton.this, f);
            }
        });
        floatingListenerButton.setVisibility(8);
        aVar.a(f);
    }

    public static void b(final Activity activity) {
        if (activity == null) {
            PendoLogger.e("Can't showFlash on null activity", new Object[0]);
        } else {
            activity.runOnUiThread(new Runnable() { // from class: sdk.pendo.io.g9.x$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    x.a(activity);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(FloatingListenerButton floatingListenerButton, Activity activity) {
        floatingListenerButton.setVisibility(0);
        sdk.pendo.io.h8.b bVar = new sdk.pendo.io.h8.b();
        bVar.show(activity.getFragmentManager(), FloatingListenerButton.SCREEN_SEND_MODE_TAG);
        FloatingListenerButton.setProgressDialog(bVar);
    }

    public static void b() {
        View findViewById;
        Activity f = sdk.pendo.io.n8.c.g().f();
        if (f == null || (findViewById = f.findViewById(R.id.pnd_pairingButton)) == null) {
            return;
        }
        findViewById.performClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Activity activity) {
        FloatingListenerButton floatingListenerButton = (FloatingListenerButton) ((ViewGroup) activity.findViewById(android.R.id.content)).findViewWithTag(activity.getString(R.string.pnd_pairing_button_name_tag));
        FloatingListenerButton.Builder.removeActiveInstances();
        q0.b a2 = o0.f1142a.a(activity, true);
        if (a2 == null || a2.f1145a.get() == null) {
            PendoLogger.w("Show flash -> root view is null", new Object[0]);
        } else {
            new sdk.pendo.io.m9.a(activity).a(a2.f1145a.get(), floatingListenerButton);
        }
    }

    public static void a() {
        PendoLogger.d("Floating Button - FLASH STATE", new Object[0]);
        Activity f = sdk.pendo.io.n8.c.g().f();
        if (f == null) {
            return;
        }
        b(f);
    }
}
