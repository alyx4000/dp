package sdk.pendo.io.a7;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.x5.j;
import sdk.pendo.io.x5.o;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0003H\u0014J\u0018\u0010\u0007\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0003H$R\u0014\u0010\n\u001a\u00028\u00008$X¤\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lsdk/pendo/io/a7/a;", ExifInterface.GPS_DIRECTION_TRUE, "Lsdk/pendo/io/x5/j;", "Lsdk/pendo/io/x5/o;", "observer", "", "b", "d", "m", "()Ljava/lang/Object;", "initialValue", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public abstract class a<T> extends j<T> {
    @Override // sdk.pendo.io.x5.j
    protected void b(o<? super T> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        d(observer);
        observer.onNext(m());
    }

    protected abstract void d(o<? super T> observer);

    protected abstract T m();
}
