package com.google.android.gms.internal.identity;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.CurrentLocationRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.SleepSegmentRequest;
import com.google.android.gms.location.zzad;
import com.google.android.gms.location.zzb;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
/* loaded from: classes3.dex */
public final class zzu extends zza implements zzv {
    zzu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.internal.IGoogleLocationManagerService");
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzA(Location location) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, location);
        zzc(13, zza);
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzB(Location location, IStatusCallback iStatusCallback) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, location);
        zzc.zzc(zza, iStatusCallback);
        zzc(85, zza);
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzC(zzr zzrVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, zzrVar);
        zzc(67, zza);
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzD(LocationSettingsRequest locationSettingsRequest, zzab zzabVar, String str) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, locationSettingsRequest);
        zzc.zzc(zza, zzabVar);
        zza.writeString(null);
        zzc(63, zza);
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzE(zzo zzoVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, zzoVar);
        zzc(95, zza);
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzF(zzj zzjVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, zzjVar);
        zzc(75, zza);
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzd(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, zzt zztVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, geofencingRequest);
        zzc.zzb(zza, pendingIntent);
        zzc.zzc(zza, zztVar);
        zzc(57, zza);
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zze(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, IStatusCallback iStatusCallback) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, geofencingRequest);
        zzc.zzb(zza, pendingIntent);
        zzc.zzc(zza, iStatusCallback);
        zzc(97, zza);
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzf(zzeh zzehVar, zzt zztVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, zzehVar);
        zzc.zzc(zza, zztVar);
        zzc(74, zza);
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzg(zzeh zzehVar, IStatusCallback iStatusCallback) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, zzehVar);
        zzc.zzc(zza, iStatusCallback);
        zzc(98, zza);
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzh(long j, boolean z, PendingIntent pendingIntent) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        int i = zzc.zza;
        zza.writeInt(1);
        zzc.zzb(zza, pendingIntent);
        zzc(5, zza);
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzi(zzb zzbVar, PendingIntent pendingIntent, IStatusCallback iStatusCallback) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, zzbVar);
        zzc.zzb(zza, pendingIntent);
        zzc.zzc(zza, iStatusCallback);
        zzc(70, zza);
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzj(ActivityTransitionRequest activityTransitionRequest, PendingIntent pendingIntent, IStatusCallback iStatusCallback) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, activityTransitionRequest);
        zzc.zzb(zza, pendingIntent);
        zzc.zzc(zza, iStatusCallback);
        zzc(72, zza);
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzk(PendingIntent pendingIntent, IStatusCallback iStatusCallback) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, pendingIntent);
        zzc.zzc(zza, iStatusCallback);
        zzc(73, zza);
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzl(PendingIntent pendingIntent) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, pendingIntent);
        zzc(6, zza);
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzm(PendingIntent pendingIntent, SleepSegmentRequest sleepSegmentRequest, IStatusCallback iStatusCallback) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, pendingIntent);
        zzc.zzb(zza, sleepSegmentRequest);
        zzc.zzc(zza, iStatusCallback);
        zzc(79, zza);
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzn(PendingIntent pendingIntent, IStatusCallback iStatusCallback) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, pendingIntent);
        zzc.zzc(zza, iStatusCallback);
        zzc(69, zza);
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzo(zzad zzadVar, zzdz zzdzVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, zzadVar);
        zzc.zzb(zza, zzdzVar);
        zzc(91, zza);
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final LocationAvailability zzp(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzb = zzb(34, zza);
        LocationAvailability locationAvailability = (LocationAvailability) zzc.zza(zzb, LocationAvailability.CREATOR);
        zzb.recycle();
        return locationAvailability;
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzq(LastLocationRequest lastLocationRequest, zzdz zzdzVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, lastLocationRequest);
        zzc.zzb(zza, zzdzVar);
        zzc(90, zza);
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzr(LastLocationRequest lastLocationRequest, zzz zzzVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, lastLocationRequest);
        zzc.zzc(zza, zzzVar);
        zzc(82, zza);
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final Location zzs() throws RemoteException {
        Parcel zzb = zzb(7, zza());
        Location location = (Location) zzc.zza(zzb, Location.CREATOR);
        zzb.recycle();
        return location;
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final ICancelToken zzt(CurrentLocationRequest currentLocationRequest, zzdz zzdzVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, currentLocationRequest);
        zzc.zzb(zza, zzdzVar);
        Parcel zzb = zzb(92, zza);
        ICancelToken asInterface = ICancelToken.Stub.asInterface(zzb.readStrongBinder());
        zzb.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final ICancelToken zzu(CurrentLocationRequest currentLocationRequest, zzz zzzVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, currentLocationRequest);
        zzc.zzc(zza, zzzVar);
        Parcel zzb = zzb(87, zza);
        ICancelToken asInterface = ICancelToken.Stub.asInterface(zzb.readStrongBinder());
        zzb.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzv(zzed zzedVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, zzedVar);
        zzc(59, zza);
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzw(zzdz zzdzVar, LocationRequest locationRequest, IStatusCallback iStatusCallback) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, zzdzVar);
        zzc.zzb(zza, locationRequest);
        zzc.zzc(zza, iStatusCallback);
        zzc(88, zza);
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzx(zzdz zzdzVar, IStatusCallback iStatusCallback) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, zzdzVar);
        zzc.zzc(zza, iStatusCallback);
        zzc(89, zza);
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzy(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzc.zza;
        zza.writeInt(z ? 1 : 0);
        zzc(12, zza);
    }

    @Override // com.google.android.gms.internal.identity.zzv
    public final void zzz(boolean z, IStatusCallback iStatusCallback) throws RemoteException {
        Parcel zza = zza();
        int i = zzc.zza;
        zza.writeInt(z ? 1 : 0);
        zzc.zzc(zza, iStatusCallback);
        zzc(84, zza);
    }
}
