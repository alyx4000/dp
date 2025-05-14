package sdk.pendo.io.k2;

import com.facebook.react.uimanager.ViewProps;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0010¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0006\u0010\nJ\u000f\u0010\t\u001a\u00020\u0002H\u0010¢\u0006\u0004\b\t\u0010\u000bR\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\fR$\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00038\u0010@RX\u0090\u000e¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011¨\u0006\u0016"}, d2 = {"Lsdk/pendo/io/k2/u;", "Lsdk/pendo/io/k2/t0;", "", "", "requiredCapacity", "", "a", "(I)V", "", "c", "(F)V", "()[F", "[F", "buffer", "<set-?>", "b", "I", "()I", ViewProps.POSITION, "bufferWithData", "<init>", "([F)V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class u extends t0<float[]> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private float[] buffer;

    /* renamed from: b, reason: from kotlin metadata */
    private int position;

    public u(float[] bufferWithData) {
        Intrinsics.checkNotNullParameter(bufferWithData, "bufferWithData");
        this.buffer = bufferWithData;
        this.position = bufferWithData.length;
        a(10);
    }

    public final void a(float c) {
        t0.a(this, 0, 1, null);
        float[] fArr = this.buffer;
        int position = getPosition();
        this.position = position + 1;
        fArr[position] = c;
    }

    @Override // sdk.pendo.io.k2.t0
    /* renamed from: b, reason: from getter */
    public int getPosition() {
        return this.position;
    }

    @Override // sdk.pendo.io.k2.t0
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public float[] a() {
        float[] copyOf = Arrays.copyOf(this.buffer, getPosition());
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }

    @Override // sdk.pendo.io.k2.t0
    public void a(int requiredCapacity) {
        float[] fArr = this.buffer;
        if (fArr.length < requiredCapacity) {
            float[] copyOf = Arrays.copyOf(fArr, RangesKt.coerceAtLeast(requiredCapacity, fArr.length * 2));
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.buffer = copyOf;
        }
    }
}
