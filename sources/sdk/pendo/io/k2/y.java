package sdk.pendo.io.k2;

import com.facebook.react.uimanager.ViewProps;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0010¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0010¢\u0006\u0004\b\b\u0010\nR\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u000bR$\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00038\u0010@RX\u0090\u000e¢\u0006\f\n\u0004\b\t\u0010\u000e\u001a\u0004\b\t\u0010\u000f¨\u0006\u0014"}, d2 = {"Lsdk/pendo/io/k2/y;", "Lsdk/pendo/io/k2/t0;", "", "", "requiredCapacity", "", "a", "(I)V", "c", "b", "()[I", "[I", "buffer", "<set-?>", "I", "()I", ViewProps.POSITION, "bufferWithData", "<init>", "([I)V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class y extends t0<int[]> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int[] buffer;

    /* renamed from: b, reason: from kotlin metadata */
    private int position;

    public y(int[] bufferWithData) {
        Intrinsics.checkNotNullParameter(bufferWithData, "bufferWithData");
        this.buffer = bufferWithData;
        this.position = bufferWithData.length;
        a(10);
    }

    public final void b(int c) {
        t0.a(this, 0, 1, null);
        int[] iArr = this.buffer;
        int position = getPosition();
        this.position = position + 1;
        iArr[position] = c;
    }

    @Override // sdk.pendo.io.k2.t0
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int[] a() {
        int[] copyOf = Arrays.copyOf(this.buffer, getPosition());
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }

    @Override // sdk.pendo.io.k2.t0
    public void a(int requiredCapacity) {
        int[] iArr = this.buffer;
        if (iArr.length < requiredCapacity) {
            int[] copyOf = Arrays.copyOf(iArr, RangesKt.coerceAtLeast(requiredCapacity, iArr.length * 2));
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.buffer = copyOf;
        }
    }

    @Override // sdk.pendo.io.k2.t0
    /* renamed from: b, reason: from getter */
    public int getPosition() {
        return this.position;
    }
}
