package com.karumi.dexter;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import java.util.Arrays;
import java.util.LinkedList;

/* loaded from: classes5.dex */
public final class DexterActivity extends Activity implements ActivityCompat.OnRequestPermissionsResultCallback {
    private boolean isTargetSdkUnderAndroidM() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0).applicationInfo.targetSdkVersion < 23;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Dexter.onActivityReady(this);
        getWindow().addFlags(16);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Dexter.onActivityDestroyed(this);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Dexter.onActivityReady(this);
    }

    @Override // android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        if (isTargetSdkUnderAndroidM()) {
            linkedList2.addAll(Arrays.asList(strArr));
        } else {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                String str = strArr[i2];
                int i3 = iArr[i2];
                if (i3 == -2 || i3 == -1) {
                    linkedList2.add(str);
                } else if (i3 == 0) {
                    linkedList.add(str);
                }
            }
        }
        Dexter.onPermissionsRequested(linkedList, linkedList2);
    }
}
