package sdk.pendo.io.l2;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import sdk.pendo.io.i2.f;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\u001a\f\u0010\u0005\u001a\u00020\u0004*\u00020\u0000H\u0000\u001a\u0016\u0010\u0005\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¨\u0006\t"}, d2 = {"Lsdk/pendo/io/j2/d;", "decoder", "", "c", "Lsdk/pendo/io/l2/g;", "b", "Lkotlin/Function0;", "Lsdk/pendo/io/i2/f;", "deferred", "kotlinx-serialization-json"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class k {

    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001b\u0010\u0010\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"sdk/pendo/io/l2/k$a", "Lsdk/pendo/io/i2/f;", "", "index", "", "a", "name", "", "", "b", "c", "", "d", "Lkotlin/Lazy;", "getOriginal", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "original", "()Ljava/lang/String;", "serialName", "()I", "elementsCount", "Lsdk/pendo/io/i2/j;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "kind", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0})
    public static final class a implements sdk.pendo.io.i2.f {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final Lazy original;
        final /* synthetic */ Function0<sdk.pendo.io.i2.f> b;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function0<? extends sdk.pendo.io.i2.f> function0) {
            this.b = function0;
            this.original = LazyKt.lazy(function0);
        }

        private final sdk.pendo.io.i2.f d() {
            return (sdk.pendo.io.i2.f) this.original.getValue();
        }

        @Override // sdk.pendo.io.i2.f
        public int a(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return d().a(name);
        }

        @Override // sdk.pendo.io.i2.f
        public List<Annotation> b(int index) {
            return d().b(index);
        }

        @Override // sdk.pendo.io.i2.f
        public sdk.pendo.io.i2.f c(int index) {
            return d().c(index);
        }

        @Override // sdk.pendo.io.i2.f
        public boolean e() {
            return f.a.c(this);
        }

        @Override // sdk.pendo.io.i2.f
        public List<Annotation> getAnnotations() {
            return f.a.a(this);
        }

        @Override // sdk.pendo.io.i2.f
        public boolean isInline() {
            return f.a.b(this);
        }

        @Override // sdk.pendo.io.i2.f
        public String a(int index) {
            return d().a(index);
        }

        @Override // sdk.pendo.io.i2.f
        /* renamed from: b */
        public sdk.pendo.io.i2.j getKind() {
            return d().getKind();
        }

        @Override // sdk.pendo.io.i2.f
        /* renamed from: c */
        public int getElementsCount() {
            return d().getElementsCount();
        }

        @Override // sdk.pendo.io.i2.f
        public boolean d(int index) {
            return d().d(index);
        }

        @Override // sdk.pendo.io.i2.f
        /* renamed from: a */
        public String getSerialName() {
            return d().getSerialName();
        }
    }

    public static final g b(sdk.pendo.io.j2.d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        g gVar = dVar instanceof g ? (g) dVar : null;
        if (gVar != null) {
            return gVar;
        }
        throw new IllegalStateException(Intrinsics.stringPlus("This serializer can be used only with Json format.Expected Decoder to be JsonDecoder, got ", Reflection.getOrCreateKotlinClass(dVar.getClass())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(sdk.pendo.io.j2.d dVar) {
        b(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sdk.pendo.io.i2.f b(Function0<? extends sdk.pendo.io.i2.f> function0) {
        return new a(function0);
    }
}
