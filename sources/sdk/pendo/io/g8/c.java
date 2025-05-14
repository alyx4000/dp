package sdk.pendo.io.g8;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.f9.f;
import sdk.pendo.io.j5.d;
import sdk.pendo.io.j5.e;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\t\"\u0017\u0010\u0004\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0001\u0010\u0003\"\u0017\u0010\u0006\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0005\u0010\u0003\"\u0017\u0010\b\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0002\u001a\u0004\b\u0007\u0010\u0003¨\u0006\t"}, d2 = {"Lsdk/pendo/io/o5/a;", "a", "Lsdk/pendo/io/o5/a;", "()Lsdk/pendo/io/o5/a;", "contextModule", "b", "guidesModule", "c", "screenManagerModule", "pendoIO_release"}, k = 2, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static final sdk.pendo.io.o5.a f1121a = sdk.pendo.io.t5.b.a(false, a.f, 1, null);
    private static final sdk.pendo.io.o5.a b = sdk.pendo.io.t5.b.a(false, b.f, 1, null);
    private static final sdk.pendo.io.o5.a c = sdk.pendo.io.t5.b.a(false, C0146c.f, 1, null);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lsdk/pendo/io/o5/a;", "", "a", "(Lsdk/pendo/io/o5/a;)V"}, k = 3, mv = {1, 9, 0})
    static final class a extends Lambda implements Function1<sdk.pendo.io.o5.a, Unit> {
        public static final a f = new a();

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lsdk/pendo/io/s5/a;", "Lsdk/pendo/io/p5/a;", "it", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "a", "(Lsdk/pendo/io/s5/a;Lsdk/pendo/io/p5/a;)Landroid/content/Context;"}, k = 3, mv = {1, 9, 0})
        /* renamed from: sdk.pendo.io.g8.c$a$a, reason: collision with other inner class name */
        static final class C0145a extends Lambda implements Function2<sdk.pendo.io.s5.a, sdk.pendo.io.p5.a, Context> {
            public static final C0145a f = new C0145a();

            C0145a() {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Context invoke(sdk.pendo.io.s5.a single, sdk.pendo.io.p5.a it) {
                Intrinsics.checkNotNullParameter(single, "$this$single");
                Intrinsics.checkNotNullParameter(it, "it");
                return PendoInternal.m();
            }
        }

        a() {
            super(1);
        }

        public final void a(sdk.pendo.io.o5.a module) {
            Intrinsics.checkNotNullParameter(module, "$this$module");
            C0145a c0145a = C0145a.f;
            sdk.pendo.io.m5.c<?> cVar = new sdk.pendo.io.m5.c<>(new sdk.pendo.io.j5.a(sdk.pendo.io.r5.c.INSTANCE.a(), Reflection.getOrCreateKotlinClass(Context.class), null, c0145a, d.Singleton, CollectionsKt.emptyList()));
            module.a((sdk.pendo.io.m5.b<?>) cVar);
            if (module.get_createdAtStart()) {
                module.a(cVar);
            }
            new e(module, cVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(sdk.pendo.io.o5.a aVar) {
            a(aVar);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lsdk/pendo/io/o5/a;", "", "a", "(Lsdk/pendo/io/o5/a;)V"}, k = 3, mv = {1, 9, 0})
    static final class b extends Lambda implements Function1<sdk.pendo.io.o5.a, Unit> {
        public static final b f = new b();

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lsdk/pendo/io/s5/a;", "Lsdk/pendo/io/p5/a;", "it", "Lsdk/pendo/io/q8/b;", "a", "(Lsdk/pendo/io/s5/a;Lsdk/pendo/io/p5/a;)Lsdk/pendo/io/q8/b;"}, k = 3, mv = {1, 9, 0})
        static final class a extends Lambda implements Function2<sdk.pendo.io.s5.a, sdk.pendo.io.p5.a, sdk.pendo.io.q8.b> {
            public static final a f = new a();

            a() {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final sdk.pendo.io.q8.b invoke(sdk.pendo.io.s5.a single, sdk.pendo.io.p5.a it) {
                Intrinsics.checkNotNullParameter(single, "$this$single");
                Intrinsics.checkNotNullParameter(it, "it");
                return new sdk.pendo.io.q8.b((Context) single.b(Reflection.getOrCreateKotlinClass(Context.class), null, null));
            }
        }

        b() {
            super(1);
        }

        public final void a(sdk.pendo.io.o5.a module) {
            Intrinsics.checkNotNullParameter(module, "$this$module");
            a aVar = a.f;
            sdk.pendo.io.m5.c<?> cVar = new sdk.pendo.io.m5.c<>(new sdk.pendo.io.j5.a(sdk.pendo.io.r5.c.INSTANCE.a(), Reflection.getOrCreateKotlinClass(sdk.pendo.io.q8.b.class), null, aVar, d.Singleton, CollectionsKt.emptyList()));
            module.a((sdk.pendo.io.m5.b<?>) cVar);
            if (module.get_createdAtStart()) {
                module.a(cVar);
            }
            new e(module, cVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(sdk.pendo.io.o5.a aVar) {
            a(aVar);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lsdk/pendo/io/o5/a;", "", "a", "(Lsdk/pendo/io/o5/a;)V"}, k = 3, mv = {1, 9, 0})
    /* renamed from: sdk.pendo.io.g8.c$c, reason: collision with other inner class name */
    static final class C0146c extends Lambda implements Function1<sdk.pendo.io.o5.a, Unit> {
        public static final C0146c f = new C0146c();

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lsdk/pendo/io/s5/a;", "Lsdk/pendo/io/p5/a;", "it", "Lsdk/pendo/io/f9/f;", "kotlin.jvm.PlatformType", "a", "(Lsdk/pendo/io/s5/a;Lsdk/pendo/io/p5/a;)Lsdk/pendo/io/f9/f;"}, k = 3, mv = {1, 9, 0})
        /* renamed from: sdk.pendo.io.g8.c$c$a */
        static final class a extends Lambda implements Function2<sdk.pendo.io.s5.a, sdk.pendo.io.p5.a, f> {
            public static final a f = new a();

            a() {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final f invoke(sdk.pendo.io.s5.a single, sdk.pendo.io.p5.a it) {
                Intrinsics.checkNotNullParameter(single, "$this$single");
                Intrinsics.checkNotNullParameter(it, "it");
                return PendoInternal.x();
            }
        }

        C0146c() {
            super(1);
        }

        public final void a(sdk.pendo.io.o5.a module) {
            Intrinsics.checkNotNullParameter(module, "$this$module");
            a aVar = a.f;
            sdk.pendo.io.m5.c<?> cVar = new sdk.pendo.io.m5.c<>(new sdk.pendo.io.j5.a(sdk.pendo.io.r5.c.INSTANCE.a(), Reflection.getOrCreateKotlinClass(f.class), null, aVar, d.Singleton, CollectionsKt.emptyList()));
            module.a((sdk.pendo.io.m5.b<?>) cVar);
            if (module.get_createdAtStart()) {
                module.a(cVar);
            }
            new e(module, cVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(sdk.pendo.io.o5.a aVar) {
            a(aVar);
            return Unit.INSTANCE;
        }
    }

    public static final sdk.pendo.io.o5.a a() {
        return f1121a;
    }

    public static final sdk.pendo.io.o5.a b() {
        return b;
    }

    public static final sdk.pendo.io.o5.a c() {
        return c;
    }
}
