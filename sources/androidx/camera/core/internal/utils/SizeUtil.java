package androidx.camera.core.internal.utils;

import android.util.Size;
import com.socure.docv.capturesdk.common.utils.ConstantsKt;

/* loaded from: classes.dex */
public final class SizeUtil {
    public static final Size RESOLUTION_ZERO = new Size(0, 0);
    public static final Size RESOLUTION_VGA = new Size(640, 480);
    public static final Size RESOLUTION_480P = new Size(ConstantsKt.MIN_FRONT_CAMERA_HEIGHT, 480);
    public static final Size RESOLUTION_1080P = new Size(1920, 1080);

    private SizeUtil() {
    }

    public static int getArea(Size size) {
        return size.getWidth() * size.getHeight();
    }
}
