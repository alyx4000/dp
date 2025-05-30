package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.os.Build;

/* loaded from: classes.dex */
public final class BitmapCompat {
    static int sizeAtStep(int i, int i2, int i3, int i4) {
        return i3 == 0 ? i2 : i3 > 0 ? i * (1 << (i4 - i3)) : i2 << ((-i3) - 1);
    }

    public static boolean hasMipMap(Bitmap bitmap) {
        return Api17Impl.hasMipMap(bitmap);
    }

    public static void setHasMipMap(Bitmap bitmap, boolean z) {
        Api17Impl.setHasMipMap(bitmap, z);
    }

    public static int getAllocationByteCount(Bitmap bitmap) {
        return Api19Impl.getAllocationByteCount(bitmap);
    }

    /* JADX WARN: Code restructure failed: missing block: B:95:0x01a5, code lost:
    
        if (androidx.core.graphics.BitmapCompat.Api27Impl.isAlreadyF16AndLinear(r10) == false) goto L122;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap createScaledBitmap(android.graphics.Bitmap r22, int r23, int r24, android.graphics.Rect r25, boolean r26) {
        /*
            Method dump skipped, instructions count: 530
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.BitmapCompat.createScaledBitmap(android.graphics.Bitmap, int, int, android.graphics.Rect, boolean):android.graphics.Bitmap");
    }

    private BitmapCompat() {
    }

    static class Api17Impl {
        private Api17Impl() {
        }

        static boolean hasMipMap(Bitmap bitmap) {
            return bitmap.hasMipMap();
        }

        static void setHasMipMap(Bitmap bitmap, boolean z) {
            bitmap.setHasMipMap(z);
        }
    }

    static class Api19Impl {
        private Api19Impl() {
        }

        static int getAllocationByteCount(Bitmap bitmap) {
            return bitmap.getAllocationByteCount();
        }
    }

    static class Api27Impl {
        private Api27Impl() {
        }

        static Bitmap createBitmapWithSourceColorspace(int i, int i2, Bitmap bitmap, boolean z) {
            Bitmap.Config config = bitmap.getConfig();
            ColorSpace colorSpace = bitmap.getColorSpace();
            ColorSpace colorSpace2 = ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
            if (z && !bitmap.getColorSpace().equals(colorSpace2)) {
                config = Bitmap.Config.RGBA_F16;
                colorSpace = colorSpace2;
            } else if (bitmap.getConfig() == Bitmap.Config.HARDWARE) {
                config = Bitmap.Config.ARGB_8888;
                if (Build.VERSION.SDK_INT >= 31) {
                    config = Api31Impl.getHardwareBitmapConfig(bitmap);
                }
            }
            return Bitmap.createBitmap(i, i2, config, bitmap.hasAlpha(), colorSpace);
        }

        static boolean isAlreadyF16AndLinear(Bitmap bitmap) {
            return bitmap.getConfig() == Bitmap.Config.RGBA_F16 && bitmap.getColorSpace().equals(ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB));
        }

        static Bitmap copyBitmapIfHardware(Bitmap bitmap) {
            if (bitmap.getConfig() != Bitmap.Config.HARDWARE) {
                return bitmap;
            }
            Bitmap.Config config = Bitmap.Config.ARGB_8888;
            if (Build.VERSION.SDK_INT >= 31) {
                config = Api31Impl.getHardwareBitmapConfig(bitmap);
            }
            return bitmap.copy(config, true);
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static void setPaintBlendMode(Paint paint) {
            paint.setBlendMode(BlendMode.SRC);
        }
    }

    static class Api31Impl {
        private Api31Impl() {
        }

        static Bitmap.Config getHardwareBitmapConfig(Bitmap bitmap) {
            if (bitmap.getHardwareBuffer().getFormat() == 22) {
                return Bitmap.Config.RGBA_F16;
            }
            return Bitmap.Config.ARGB_8888;
        }
    }
}
