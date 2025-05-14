package sdk.pendo.io.z8;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import sdk.pendo.io.R;
import sdk.pendo.io.n8.c;
import sdk.pendo.io.views.listener.FloatingListenerButton;

/* loaded from: classes4.dex */
public class a {
    public static void b() {
        Activity f = c.g().f();
        if (f == null) {
            FloatingListenerButton.clearDialogFragment();
        } else {
            final sdk.pendo.io.h8.b progressDialog = FloatingListenerButton.getProgressDialog();
            f.runOnUiThread(new Runnable() { // from class: sdk.pendo.io.z8.a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    a.a(sdk.pendo.io.h8.b.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(sdk.pendo.io.h8.b bVar) {
        if (bVar == null || bVar.getDialog() == null || !bVar.getDialog().isShowing()) {
            return;
        }
        Dialog dialog = bVar.getDialog();
        dialog.setContentView(R.layout.pnd_capture_successful);
        new Handler().postDelayed(new Runnable() { // from class: sdk.pendo.io.z8.a$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                FloatingListenerButton.clearDialogFragment();
            }
        }, 5000L);
        ((View) ((ImageView) dialog.findViewById(R.id.imageViewSuccess)).getParent()).setOnClickListener(new View.OnClickListener() { // from class: sdk.pendo.io.z8.a$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatingListenerButton.clearDialogFragment();
            }
        });
        dialog.show();
    }

    public static void a() {
        FloatingListenerButton.clearDialogFragment();
        sdk.pendo.io.h8.a.a(R.layout.pnd_capture_fail, R.id.imageViewFail).show(c.g().f().getFragmentManager(), "error");
    }
}
