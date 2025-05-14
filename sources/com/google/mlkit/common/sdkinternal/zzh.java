package com.google.mlkit.common.sdkinternal;

import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: com.google.mlkit:common@@18.8.0 */
/* loaded from: classes5.dex */
enum zzh implements Executor {
    INSTANCE;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        Handler handler;
        handler = MLTaskExecutor.getInstance().zzc;
        handler.post(runnable);
    }
}
