package sdk.pendo.io.x7;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes4.dex */
public class a implements Executor {

    /* renamed from: a, reason: collision with root package name */
    private Executor f1750a = Executors.newSingleThreadExecutor();

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f1750a.execute(runnable);
    }
}
