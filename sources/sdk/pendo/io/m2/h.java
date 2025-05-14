package sdk.pendo.io.m2;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0017\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\rR$\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00068\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b\n\u0010\u0010\u001a\u0004\b\u0007\u0010\u0011¨\u0006\u0015"}, d2 = {"Lsdk/pendo/io/m2/h;", "", "Lsdk/pendo/io/i2/f;", "descriptor", "", "index", "", "a", "", "(I)V", "b", "()I", "Lsdk/pendo/io/k2/s;", "Lsdk/pendo/io/k2/s;", "origin", "<set-?>", "Z", "()Z", "isUnmarkedNull", "<init>", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final sdk.pendo.io.k2.s origin;

    /* renamed from: b, reason: from kotlin metadata */
    private boolean isUnmarkedNull;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* synthetic */ class a extends FunctionReferenceImpl implements Function2<sdk.pendo.io.i2.f, Integer, Boolean> {
        a(Object obj) {
            super(2, obj, h.class, "readIfAbsent", "readIfAbsent(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", 0);
        }

        public final Boolean a(sdk.pendo.io.i2.f p0, int i) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return Boolean.valueOf(((h) this.receiver).a(p0, i));
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Boolean invoke(sdk.pendo.io.i2.f fVar, Integer num) {
            return a(fVar, num.intValue());
        }
    }

    public h(sdk.pendo.io.i2.f descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.origin = new sdk.pendo.io.k2.s(descriptor, new a(this));
    }

    public final int b() {
        return this.origin.b();
    }

    /* renamed from: a, reason: from getter */
    public final boolean getIsUnmarkedNull() {
        return this.isUnmarkedNull;
    }

    public final void a(int index) {
        this.origin.a(index);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean a(sdk.pendo.io.i2.f descriptor, int index) {
        boolean z = !descriptor.d(index) && descriptor.c(index).e();
        this.isUnmarkedNull = z;
        return z;
    }
}
