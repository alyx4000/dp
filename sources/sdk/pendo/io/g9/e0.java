package sdk.pendo.io.g9;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import sdk.pendo.io.p8.a;
import sdk.pendo.io.x5.p;

/* loaded from: classes6.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    private static ExecutorService f1128a = Executors.newFixedThreadPool(4);
    private static ExecutorService b = Executors.newFixedThreadPool(1);

    public static void a(sdk.pendo.io.s8.a aVar) {
        p.c a2 = sdk.pendo.io.v6.a.a(((aVar instanceof a.e) || (aVar instanceof a.f)) ? b : f1128a).a();
        aVar.setWorker(a2);
        a2.a(aVar);
    }
}
