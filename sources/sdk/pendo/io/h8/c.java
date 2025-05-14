package sdk.pendo.io.h8;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import sdk.pendo.io.R;

/* loaded from: classes6.dex */
public final class c extends DialogFragment {

    /* renamed from: a, reason: collision with root package name */
    private static final int f1164a = R.layout.pnd_activity_test_mode;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dismiss();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            sdk.pendo.io.z8.b.d();
            sdk.pendo.io.u8.a aVar = sdk.pendo.io.u8.a.f1643a;
            aVar.f();
            aVar.b();
            Toast.makeText(c.this.getActivity(), c.this.getResources().getString(R.string.pnd_disconnected_permanently), 0).show();
            c.this.dismiss();
        }
    }

    public static c a() {
        return new c();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.pnd_Pendo_Dialog_Transparent_Background);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(f1164a, viewGroup, false);
        getDialog().getWindow().setBackgroundDrawableResource(R.color.pnd_backgrpund_test_dialog);
        inflate.findViewById(R.id.insert_testmode_container).setOnClickListener(new a());
        inflate.findViewById(R.id.btnDisconnect).setOnClickListener(new b());
        return inflate;
    }
}
