package sdk.pendo.io.v;

import android.app.ActivityManager;
import android.content.Context;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final int f1645a;
    private final int b;
    private final Context c;
    private final int d;

    /* renamed from: sdk.pendo.io.v.a$a, reason: collision with other inner class name */
    public static final class C0245a {
        static final int i = 1;

        /* renamed from: a, reason: collision with root package name */
        final Context f1646a;
        ActivityManager b;
        c c;
        float e;
        float d = 2.0f;
        float f = 0.4f;
        float g = 0.33f;
        int h = 4194304;

        public C0245a(Context context) {
            this.e = i;
            this.f1646a = context;
            this.b = (ActivityManager) context.getSystemService("activity");
            this.c = new b(context.getResources().getDisplayMetrics());
            if (a.a(this.b)) {
                this.e = 0.0f;
            }
        }

        public a a() {
            return new a(this);
        }
    }

    private static final class b implements c {

        /* renamed from: a, reason: collision with root package name */
        private final DisplayMetrics f1647a;

        b(DisplayMetrics displayMetrics) {
            this.f1647a = displayMetrics;
        }

        @Override // sdk.pendo.io.v.a.c
        public int a() {
            return this.f1647a.heightPixels;
        }

        @Override // sdk.pendo.io.v.a.c
        public int b() {
            return this.f1647a.widthPixels;
        }
    }

    interface c {
        int a();

        int b();
    }

    a(C0245a c0245a) {
        this.c = c0245a.f1646a;
        int i = a(c0245a.b) ? c0245a.h / 2 : c0245a.h;
        this.d = i;
        int a2 = a(c0245a.b, c0245a.f, c0245a.g);
        float b2 = c0245a.c.b() * c0245a.c.a() * 4;
        int round = Math.round(c0245a.e * b2);
        int round2 = Math.round(b2 * c0245a.d);
        int i2 = a2 - i;
        int i3 = round2 + round;
        if (i3 <= i2) {
            this.b = round2;
            this.f1645a = round;
        } else {
            float f = i2;
            float f2 = c0245a.e;
            float f3 = c0245a.d;
            float f4 = f / (f2 + f3);
            this.b = Math.round(f3 * f4);
            this.f1645a = Math.round(f4 * c0245a.e);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            Log.d("MemorySizeCalculator", "Calculation complete, Calculated memory cache size: " + a(this.b) + ", pool size: " + a(this.f1645a) + ", byte array size: " + a(i) + ", memory class limited? " + (i3 > a2) + ", max size: " + a(a2) + ", memoryClass: " + c0245a.b.getMemoryClass() + ", isLowMemoryDevice: " + a(c0245a.b));
        }
    }

    public int a() {
        return this.d;
    }

    public int b() {
        return this.f1645a;
    }

    public int c() {
        return this.b;
    }

    private static int a(ActivityManager activityManager, float f, float f2) {
        float memoryClass = activityManager.getMemoryClass() * 1024 * 1024;
        if (a(activityManager)) {
            f = f2;
        }
        return Math.round(memoryClass * f);
    }

    static boolean a(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }

    private String a(int i) {
        return Formatter.formatFileSize(this.c, i);
    }
}
