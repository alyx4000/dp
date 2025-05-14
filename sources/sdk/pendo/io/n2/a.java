package sdk.pendo.io.n2;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0005\bB\t\b\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00032\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002H¦\u0002\u0082\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lsdk/pendo/io/n2/a;", "", "", "Lsdk/pendo/io/g2/b;", "typeArgumentsSerializers", "a", "<init>", "()V", "b", "Lsdk/pendo/io/n2/a$a;", "Lsdk/pendo/io/n2/a$b;", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public abstract class a {

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00032\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002H\u0096\u0002J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016R\u001b\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lsdk/pendo/io/n2/a$a;", "Lsdk/pendo/io/n2/a;", "", "Lsdk/pendo/io/g2/b;", "typeArgumentsSerializers", "a", "", "other", "", "equals", "", "hashCode", "Lsdk/pendo/io/g2/b;", "getSerializer", "()Lkotlinx/serialization/KSerializer;", "serializer", "<init>", "(Lkotlinx/serialization/KSerializer;)V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
    /* renamed from: sdk.pendo.io.n2.a$a, reason: collision with other inner class name */
    public static final class C0203a extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final sdk.pendo.io.g2.b<?> serializer;

        public final sdk.pendo.io.g2.b<?> a() {
            return this.serializer;
        }

        public boolean equals(Object other) {
            return (other instanceof C0203a) && Intrinsics.areEqual(((C0203a) other).serializer, this.serializer);
        }

        public int hashCode() {
            return this.serializer.hashCode();
        }

        @Override // sdk.pendo.io.n2.a
        public sdk.pendo.io.g2.b<?> a(List<? extends sdk.pendo.io.g2.b<?>> typeArgumentsSerializers) {
            Intrinsics.checkNotNullParameter(typeArgumentsSerializers, "typeArgumentsSerializers");
            return this.serializer;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00032\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002H\u0096\u0002R@\u0010\u000b\u001a+\u0012\u001d\u0012\u001b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u00068\u0006¢\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0005\u0010\n¨\u0006\f"}, d2 = {"Lsdk/pendo/io/n2/a$b;", "Lsdk/pendo/io/n2/a;", "", "Lsdk/pendo/io/g2/b;", "typeArgumentsSerializers", "a", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", "provider", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
    public static final class b extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final Function1<List<? extends sdk.pendo.io.g2.b<?>>, sdk.pendo.io.g2.b<?>> provider;

        public final Function1<List<? extends sdk.pendo.io.g2.b<?>>, sdk.pendo.io.g2.b<?>> a() {
            return this.provider;
        }

        @Override // sdk.pendo.io.n2.a
        public sdk.pendo.io.g2.b<?> a(List<? extends sdk.pendo.io.g2.b<?>> typeArgumentsSerializers) {
            Intrinsics.checkNotNullParameter(typeArgumentsSerializers, "typeArgumentsSerializers");
            return this.provider.invoke(typeArgumentsSerializers);
        }
    }

    private a() {
    }

    public abstract sdk.pendo.io.g2.b<?> a(List<? extends sdk.pendo.io.g2.b<?>> typeArgumentsSerializers);
}
