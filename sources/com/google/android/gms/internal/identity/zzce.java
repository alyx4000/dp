package com.google.android.gms.internal.identity;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
/* loaded from: classes3.dex */
final /* synthetic */ class zzce implements Executor {
    static final /* synthetic */ zzce zza = new zzce();

    private /* synthetic */ zzce() {
    }

    @Override // java.util.concurrent.Executor
    public final /* synthetic */ void execute(Runnable runnable) {
        runnable.run();
    }
}
