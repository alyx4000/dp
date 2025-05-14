package sdk.pendo.io.i2;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H'J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u0002H'J\u0010\u0010\n\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H'J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H'R\u001a\u0010\u0010\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0005\u0010\rR\u001a\u0010\u0014\u001a\u00020\u000b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0015\u001a\u00020\u000b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u000f\u001a\u0004\b\n\u0010\u0017R \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u00078VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\"\u001a\u00020\u001e8&X§\u0004¢\u0006\f\u0012\u0004\b!\u0010\u000f\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lsdk/pendo/io/i2/f;", "", "", "index", "", "a", "name", "", "", "b", "c", "", "d", "()Ljava/lang/String;", "getSerialName$annotations", "()V", "serialName", "e", "()Z", "isNullable$annotations", "isNullable", "isInline", "isInline$annotations", "()I", "getElementsCount$annotations", "elementsCount", "getAnnotations", "()Ljava/util/List;", "getAnnotations$annotations", "annotations", "Lsdk/pendo/io/i2/j;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "getKind$annotations", "kind", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public interface f {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public static List<Annotation> a(f fVar) {
            Intrinsics.checkNotNullParameter(fVar, "this");
            return CollectionsKt.emptyList();
        }

        public static boolean b(f fVar) {
            Intrinsics.checkNotNullParameter(fVar, "this");
            return false;
        }

        public static boolean c(f fVar) {
            Intrinsics.checkNotNullParameter(fVar, "this");
            return false;
        }
    }

    int a(String name);

    String a();

    String a(int index);

    List<Annotation> b(int index);

    j b();

    int c();

    f c(int index);

    boolean d(int index);

    boolean e();

    List<Annotation> getAnnotations();

    boolean isInline();
}
