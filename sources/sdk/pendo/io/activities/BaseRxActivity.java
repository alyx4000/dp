package sdk.pendo.io.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import sdk.pendo.io.f7.d;
import sdk.pendo.io.f7.g;
import sdk.pendo.io.w6.a;

/* loaded from: classes6.dex */
public class BaseRxActivity extends AppCompatActivity {

    /* renamed from: a, reason: collision with root package name */
    private final a<sdk.pendo.io.f7.a> f864a = a.n();

    public final <T> d<T> a() {
        return g.a(this.f864a);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f864a.onNext(sdk.pendo.io.f7.a.CREATE);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.f864a.onNext(sdk.pendo.io.f7.a.DESTROY);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        this.f864a.onNext(sdk.pendo.io.f7.a.PAUSE);
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f864a.onNext(sdk.pendo.io.f7.a.RESUME);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        this.f864a.onNext(sdk.pendo.io.f7.a.START);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        this.f864a.onNext(sdk.pendo.io.f7.a.STOP);
        super.onStop();
    }
}
