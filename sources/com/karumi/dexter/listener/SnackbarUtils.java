package com.karumi.dexter.listener;

import android.view.View;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

/* loaded from: classes5.dex */
public class SnackbarUtils {
    public static void show(View view, String str, int i, String str2, View.OnClickListener onClickListener, BaseTransientBottomBar.BaseCallback<Snackbar> baseCallback) {
        Snackbar make = Snackbar.make(view, str, i);
        if (str2 != null && onClickListener != null) {
            make.setAction(str2, onClickListener);
        }
        if (baseCallback != null) {
            make.addCallback(baseCallback);
        }
        make.show();
    }
}
