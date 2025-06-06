package com.google.android.gms.internal.identity;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.location.zzv;
import com.google.android.gms.location.zzw;
import com.google.android.gms.location.zzy;
import com.google.android.gms.location.zzz;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
@Deprecated
/* loaded from: classes3.dex */
public final class zzed extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzed> CREATOR = new zzee();
    private final int zza;
    private final zzeb zzb;
    private final zzz zzc;
    private final zzw zzd;
    private final PendingIntent zze;
    private final zzr zzf;
    private final String zzg;

    zzed(int i, zzeb zzebVar, IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent, IBinder iBinder3, String str) {
        this.zza = i;
        this.zzb = zzebVar;
        zzr zzrVar = null;
        this.zzc = iBinder != null ? zzy.zzb(iBinder) : null;
        this.zze = pendingIntent;
        this.zzd = iBinder2 != null ? zzv.zzb(iBinder2) : null;
        if (iBinder3 != null) {
            IInterface queryLocalInterface = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            zzrVar = queryLocalInterface instanceof zzr ? (zzr) queryLocalInterface : new zzp(iBinder3);
        }
        this.zzf = zzrVar;
        this.zzg = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        zzz zzzVar = this.zzc;
        SafeParcelWriter.writeIBinder(parcel, 3, zzzVar == null ? null : zzzVar.asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zze, i, false);
        zzw zzwVar = this.zzd;
        SafeParcelWriter.writeIBinder(parcel, 5, zzwVar == null ? null : zzwVar.asBinder(), false);
        zzr zzrVar = this.zzf;
        SafeParcelWriter.writeIBinder(parcel, 6, zzrVar != null ? zzrVar.asBinder() : null, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzg, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
