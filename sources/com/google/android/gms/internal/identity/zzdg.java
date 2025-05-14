package com.google.android.gms.internal.identity;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
/* loaded from: classes3.dex */
final class zzdg extends zzw {
    final /* synthetic */ TaskCompletionSource zza;

    zzdg(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.identity.zzx
    public final void zzb(Status status, LocationAvailability locationAvailability) {
        TaskUtil.setResultOrApiException(status, locationAvailability, this.zza);
    }
}
