package expo.modules.devlauncher.helpers;

import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: DevLauncherCoroutinesExtensions.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"runBlockingOnMainThread", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "expo-dev-launcher_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DevLauncherCoroutinesExtensionsKt {
    public static final <T> T runBlockingOnMainThread(Function0<? extends T> block) throws InterruptedException {
        Intrinsics.checkNotNullParameter(block, "block");
        if (Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            return block.invoke();
        }
        return (T) BuildersKt.runBlocking(Dispatchers.getMain(), new DevLauncherCoroutinesExtensionsKt$runBlockingOnMainThread$1(block, null));
    }
}
