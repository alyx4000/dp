package com.google.android.gms.fido.fido2;

import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
/* loaded from: classes3.dex */
final class zzj extends com.google.android.gms.internal.fido.zzd {
    final /* synthetic */ TaskCompletionSource zza;

    zzj(Fido2ApiClient fido2ApiClient, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.fido.zze
    public final void zzb(boolean z) throws RemoteException {
        this.zza.setResult(Boolean.valueOf(z));
    }

    @Override // com.google.android.gms.internal.fido.zze
    public final void zzc(Status status) throws RemoteException {
        this.zza.trySetException(new ApiException(status));
    }
}
