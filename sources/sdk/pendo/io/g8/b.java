package sdk.pendo.io.g8;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lsdk/pendo/io/g8/b;", "", "Lsdk/pendo/io/h5/b;", "b", "Lsdk/pendo/io/h5/b;", "koinApp", "Lsdk/pendo/io/h5/a;", "c", "Lsdk/pendo/io/h5/a;", "a", "()Lsdk/pendo/io/h5/a;", "koin", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f1120a = new b();

    /* renamed from: b, reason: from kotlin metadata */
    private static final sdk.pendo.io.h5.b koinApp;

    /* renamed from: c, reason: from kotlin metadata */
    private static final sdk.pendo.io.h5.a koin;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lsdk/pendo/io/h5/b;", "", "a", "(Lsdk/pendo/io/h5/b;)V"}, k = 3, mv = {1, 9, 0})
    static final class a extends Lambda implements Function1<sdk.pendo.io.h5.b, Unit> {
        public static final a f = new a();

        a() {
            super(1);
        }

        public final void a(sdk.pendo.io.h5.b koinApplication) {
            Intrinsics.checkNotNullParameter(koinApplication, "$this$koinApplication");
            koinApplication.a(c.a(), c.b(), c.c());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(sdk.pendo.io.h5.b bVar) {
            a(bVar);
            return Unit.INSTANCE;
        }
    }

    static {
        sdk.pendo.io.h5.b a2 = sdk.pendo.io.t5.a.a(false, a.f, 1, null);
        koinApp = a2;
        koin = a2.getKoin();
    }

    private b() {
    }

    public final sdk.pendo.io.h5.a a() {
        return koin;
    }
}
