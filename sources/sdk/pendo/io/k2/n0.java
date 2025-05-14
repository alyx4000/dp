package sdk.pendo.io.k2;

import androidx.exifinterface.media.ExifInterface;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import sdk.pendo.io.i2.k;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00028\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001b\u001a\u00020\u00168VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Lsdk/pendo/io/k2/n0;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lsdk/pendo/io/g2/b;", "Lsdk/pendo/io/j2/d;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "Lsdk/pendo/io/j2/e;", "encoder", "value", "", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "a", "Ljava/lang/Object;", "objectInstance", "", "", "b", "Ljava/util/List;", "_annotations", "Lsdk/pendo/io/i2/f;", "c", "Lkotlin/Lazy;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "", "serialName", "<init>", "(Ljava/lang/String;Ljava/lang/Object;)V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class n0<T> implements sdk.pendo.io.g2.b<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final T objectInstance;

    /* renamed from: b, reason: from kotlin metadata */
    private List<? extends Annotation> _annotations;

    /* renamed from: c, reason: from kotlin metadata */
    private final Lazy descriptor;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lsdk/pendo/io/i2/f;", "a", "()Lsdk/pendo/io/i2/f;"}, k = 3, mv = {1, 6, 0})
    static final class a extends Lambda implements Function0<sdk.pendo.io.i2.f> {
        final /* synthetic */ String f;
        final /* synthetic */ n0<T> s;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lsdk/pendo/io/i2/a;", "", "a", "(Lsdk/pendo/io/i2/a;)V"}, k = 3, mv = {1, 6, 0})
        /* renamed from: sdk.pendo.io.k2.n0$a$a, reason: collision with other inner class name */
        static final class C0169a extends Lambda implements Function1<sdk.pendo.io.i2.a, Unit> {
            final /* synthetic */ n0<T> f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0169a(n0<T> n0Var) {
                super(1);
                this.f = n0Var;
            }

            public final void a(sdk.pendo.io.i2.a buildSerialDescriptor) {
                Intrinsics.checkNotNullParameter(buildSerialDescriptor, "$this$buildSerialDescriptor");
                buildSerialDescriptor.a(((n0) this.f)._annotations);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(sdk.pendo.io.i2.a aVar) {
                a(aVar);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, n0<T> n0Var) {
            super(0);
            this.f = str;
            this.s = n0Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final sdk.pendo.io.i2.f invoke() {
            return sdk.pendo.io.i2.i.a(this.f, k.d.f1200a, new sdk.pendo.io.i2.f[0], new C0169a(this.s));
        }
    }

    public n0(String serialName, T objectInstance) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(objectInstance, "objectInstance");
        this.objectInstance = objectInstance;
        this._annotations = CollectionsKt.emptyList();
        this.descriptor = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new a(serialName, this));
    }

    @Override // sdk.pendo.io.g2.a
    public T deserialize(sdk.pendo.io.j2.d decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        decoder.a(getDescriptor()).c(getDescriptor());
        return this.objectInstance;
    }

    @Override // sdk.pendo.io.g2.b, sdk.pendo.io.g2.a
    public sdk.pendo.io.i2.f getDescriptor() {
        return (sdk.pendo.io.i2.f) this.descriptor.getValue();
    }
}
