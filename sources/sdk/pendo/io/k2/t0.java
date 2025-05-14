package sdk.pendo.io.k2;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b!\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\t\b\u0000¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0004\u001a\u00020\u0003H ¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u0006\u001a\u00028\u0000H ¢\u0006\u0004\b\u0006\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00038 X \u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lsdk/pendo/io/k2/t0;", "Array", "", "", "requiredCapacity", "", "a", "(I)V", "()Ljava/lang/Object;", "b", "()I", ViewProps.POSITION, "<init>", "()V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public abstract class t0<Array> {
    public static /* synthetic */ void a(t0 t0Var, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: ensureCapacity");
        }
        if ((i2 & 1) != 0) {
            i = t0Var.b() + 1;
        }
        t0Var.a(i);
    }

    public abstract Array a();

    public abstract void a(int requiredCapacity);

    public abstract int b();
}
