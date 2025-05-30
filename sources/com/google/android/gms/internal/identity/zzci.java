package com.google.android.gms.internal.identity;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.GeofencingRequest;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
/* loaded from: classes3.dex */
final class zzci extends zzcl {
    final /* synthetic */ GeofencingRequest zza;
    final /* synthetic */ PendingIntent zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzci(zzcm zzcmVar, GoogleApiClient googleApiClient, GeofencingRequest geofencingRequest, PendingIntent pendingIntent) {
        super(googleApiClient);
        this.zza = geofencingRequest;
        this.zzb = pendingIntent;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzdu) anyClient).zzE(this.zza, this.zzb, zzcm.zza(this));
    }
}
