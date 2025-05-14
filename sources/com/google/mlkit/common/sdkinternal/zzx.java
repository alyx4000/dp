package com.google.mlkit.common.sdkinternal;

import com.google.android.gms.common.internal.Preconditions;
import java.io.Closeable;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.mlkit:common@@18.8.0 */
/* loaded from: classes5.dex */
final class zzx implements Closeable {
    final /* synthetic */ TaskQueue zza;

    /* synthetic */ zzx(TaskQueue taskQueue, zzw zzwVar) {
        AtomicReference atomicReference;
        this.zza = taskQueue;
        atomicReference = taskQueue.zzd;
        Preconditions.checkState(((Thread) atomicReference.getAndSet(Thread.currentThread())) == null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        AtomicReference atomicReference;
        atomicReference = this.zza.zzd;
        atomicReference.set(null);
        this.zza.zzc();
    }
}
