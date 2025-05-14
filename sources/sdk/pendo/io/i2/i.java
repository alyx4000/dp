package sdk.pendo.io.i2;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import sdk.pendo.io.i2.k;
import sdk.pendo.io.k2.x0;

@Metadata(d1 = {"\u00004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001aD\u0010\r\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0006\"\u00020\u00042\u0019\b\u0002\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b¢\u0006\u0004\b\r\u0010\u000e\u001aN\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u000f2\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0006\"\u00020\u00042\u0019\b\u0002\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0004\b\u0011\u0010\u0012\"\u001b\u0010\u0017\u001a\u00020\u0004*\u00020\u00048F¢\u0006\f\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"", "serialName", "Lsdk/pendo/io/i2/e;", "kind", "Lsdk/pendo/io/i2/f;", "a", "", "typeParameters", "Lkotlin/Function1;", "Lsdk/pendo/io/i2/a;", "", "Lkotlin/ExtensionFunctionType;", "builderAction", "buildClassSerialDescriptor", "(Ljava/lang/String;[Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/jvm/functions/Function1;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lsdk/pendo/io/i2/j;", "builder", "buildSerialDescriptor", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialKind;[Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/jvm/functions/Function1;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "getNullable", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "getNullable$annotations", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "nullable", "kotlinx-serialization-core"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class i {

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lsdk/pendo/io/i2/a;", "", "a", "(Lsdk/pendo/io/i2/a;)V"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function1<sdk.pendo.io.i2.a, Unit> {
        public static final a f = new a();

        a() {
            super(1);
        }

        public final void a(sdk.pendo.io.i2.a aVar) {
            Intrinsics.checkNotNullParameter(aVar, "$this$null");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(sdk.pendo.io.i2.a aVar) {
            a(aVar);
            return Unit.INSTANCE;
        }
    }

    public static final f a(String serialName, e kind) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(kind, "kind");
        if (!StringsKt.isBlank(serialName)) {
            return x0.a(serialName, kind);
        }
        throw new IllegalArgumentException("Blank serial names are prohibited".toString());
    }

    public static final f a(String serialName, j kind, f[] typeParameters, Function1<? super sdk.pendo.io.i2.a, Unit> builder) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(typeParameters, "typeParameters");
        Intrinsics.checkNotNullParameter(builder, "builder");
        if (!(!StringsKt.isBlank(serialName))) {
            throw new IllegalArgumentException("Blank serial names are prohibited".toString());
        }
        if (!(!Intrinsics.areEqual(kind, k.a.f1197a))) {
            throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead".toString());
        }
        sdk.pendo.io.i2.a aVar = new sdk.pendo.io.i2.a(serialName);
        builder.invoke(aVar);
        return new g(serialName, kind, aVar.d().size(), ArraysKt.toList(typeParameters), aVar);
    }

    public static /* synthetic */ f a(String str, j jVar, f[] fVarArr, Function1 function1, int i, Object obj) {
        if ((i & 8) != 0) {
            function1 = a.f;
        }
        return a(str, jVar, fVarArr, function1);
    }
}
