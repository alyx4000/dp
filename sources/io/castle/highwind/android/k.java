package io.castle.highwind.android;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import kotlin.text.Charsets;

/* loaded from: classes2.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final a f775a = new a();

    public static final class a {
        public final DisplayMetrics a(Context context) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (Build.VERSION.SDK_INT >= 30) {
                return Resources.getSystem().getDisplayMetrics();
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            return displayMetrics;
        }

        public final String a(String str) {
            return Base64.encodeToString(str.getBytes(Charsets.ISO_8859_1), 11);
        }

        public final String a(byte[] bArr) {
            return Base64.encodeToString(bArr, 11);
        }
    }
}
