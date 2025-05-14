package sdk.pendo.io.h8;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import sdk.pendo.io.R;

/* loaded from: classes6.dex */
public class a extends DialogFragment {
    private static final int b = R.color.pnd_colorTransparent;

    /* renamed from: a, reason: collision with root package name */
    private Dialog f1162a = null;

    /* renamed from: sdk.pendo.io.h8.a$a, reason: collision with other inner class name */
    class ViewOnClickListenerC0150a implements View.OnClickListener {
        ViewOnClickListenerC0150a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f1162a.dismiss();
        }
    }

    public static a a(int i, int i2) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putInt("layoutID", i);
        bundle.putInt("imageID", i2);
        aVar.setArguments(bundle);
        return aVar;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        int i = R.layout.pnd_capture_fail;
        int i2 = R.id.imageViewFail;
        if (getArguments() != null) {
            i = getArguments().getInt("layoutID");
            i2 = getArguments().getInt("imageID");
        }
        setRetainInstance(true);
        setCancelable(true);
        Dialog dialog = new Dialog(getActivity());
        this.f1162a = dialog;
        dialog.requestWindowFeature(1);
        this.f1162a.setContentView(i);
        ((View) ((ImageView) this.f1162a.findViewById(i2)).getParent()).setOnClickListener(new ViewOnClickListenerC0150a());
        Window window = this.f1162a.getWindow();
        if (window != null) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(new ColorDrawable(getResources().getColor(b)));
        }
        return this.f1162a;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onDestroyView() {
        if (getDialog() != null && getRetainInstance()) {
            getDialog().setDismissMessage(null);
        }
        super.onDestroyView();
    }
}
