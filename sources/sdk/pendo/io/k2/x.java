package sdk.pendo.io.k2;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0019\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005¨\u0006\u0007"}, d2 = {"Lsdk/pendo/io/k2/x;", ExifInterface.GPS_DIRECTION_TRUE, "Lsdk/pendo/io/g2/b;", "", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "typeParametersSerializers", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public interface x<T> extends sdk.pendo.io.g2.b<T> {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public static <T> sdk.pendo.io.g2.b<?>[] a(x<T> xVar) {
            Intrinsics.checkNotNullParameter(xVar, "this");
            return s0.f1277a;
        }
    }

    sdk.pendo.io.g2.b<?>[] childSerializers();

    sdk.pendo.io.g2.b<?>[] typeParametersSerializers();
}
