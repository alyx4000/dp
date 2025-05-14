package com.google.android.gms.location;

import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
/* loaded from: classes3.dex */
public abstract class zzy extends com.google.android.gms.internal.identity.zzb implements zzz {
    public zzy() {
        super("com.google.android.gms.location.ILocationListener");
    }

    public static zzz zzb(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
        return queryLocalInterface instanceof zzz ? (zzz) queryLocalInterface : new zzx(iBinder);
    }

    @Override // com.google.android.gms.internal.identity.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            Location location = (Location) com.google.android.gms.internal.identity.zzc.zza(parcel, Location.CREATOR);
            com.google.android.gms.internal.identity.zzc.zzd(parcel);
            zzd(location);
        } else {
            if (i != 2) {
                return false;
            }
            zze();
        }
        return true;
    }
}
