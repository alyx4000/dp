package sdk.pendo.io.i0;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import io.sentry.protocol.ViewHierarchyNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import kotlin.UByte;

/* loaded from: classes6.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f1177a = "0123456789abcdef".toCharArray();
    private static final char[] b = new char[64];
    private static volatile Handler c;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1178a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f1178a = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1178a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1178a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1178a[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1178a[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private k() {
    }

    public static int a(int i, int i2) {
        return (i2 * 31) + i;
    }

    public static void a() {
        if (!d()) {
            throw new IllegalArgumentException("You must call this method on a background thread");
        }
    }

    public static void b() {
        if (!e()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    private static Handler c() {
        if (c == null) {
            synchronized (k.class) {
                if (c == null) {
                    c = new Handler(Looper.getMainLooper());
                }
            }
        }
        return c;
    }

    private static boolean c(int i) {
        return i > 0 || i == Integer.MIN_VALUE;
    }

    public static boolean d() {
        return !e();
    }

    public static boolean e() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj instanceof sdk.pendo.io.x.b ? ((sdk.pendo.io.x.b) obj).a(obj2) : obj.equals(obj2);
    }

    public static boolean b(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    private static String a(byte[] bArr, char[] cArr) {
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & UByte.MAX_VALUE;
            int i3 = i * 2;
            char[] cArr2 = f1177a;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    public static int b(int i) {
        return a(i, 17);
    }

    public static <T> Queue<T> a(int i) {
        return new ArrayDeque(i);
    }

    public static boolean b(int i, int i2) {
        return c(i) && c(i2);
    }

    public static int a(int i, int i2, Bitmap.Config config) {
        return i * i2 * a(config);
    }

    public static void b(Runnable runnable) {
        c().removeCallbacks(runnable);
    }

    public static int a(Bitmap bitmap) {
        if (bitmap.isRecycled()) {
            throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + ViewHierarchyNode.JsonKeys.X + bitmap.getHeight() + "] " + bitmap.getConfig());
        }
        try {
            return bitmap.getAllocationByteCount();
        } catch (NullPointerException unused) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }
    }

    private static int a(Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i = a.f1178a[config.ordinal()];
        if (i == 1) {
            return 1;
        }
        if (i == 2 || i == 3) {
            return 2;
        }
        return i != 4 ? 4 : 8;
    }

    public static <T> List<T> a(Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t : collection) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static int a(float f) {
        return a(f, 17);
    }

    public static int a(float f, int i) {
        return a(Float.floatToIntBits(f), i);
    }

    public static int a(Object obj, int i) {
        return a(obj == null ? 0 : obj.hashCode(), i);
    }

    public static int a(boolean z, int i) {
        return a(z ? 1 : 0, i);
    }

    public static void a(Runnable runnable) {
        c().post(runnable);
    }

    public static String a(byte[] bArr) {
        String a2;
        char[] cArr = b;
        synchronized (cArr) {
            a2 = a(bArr, cArr);
        }
        return a2;
    }
}
