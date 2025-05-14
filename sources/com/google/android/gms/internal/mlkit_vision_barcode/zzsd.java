package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.2.0 */
/* loaded from: classes3.dex */
public final class zzsd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzsd> CREATOR = new zzss();
    private final zzsh zza;
    private final String zzb;
    private final String zzc;
    private final zzsi[] zzd;
    private final zzsf[] zze;
    private final String[] zzf;
    private final zzsa[] zzg;

    public zzsd(zzsh zzshVar, String str, String str2, zzsi[] zzsiVarArr, zzsf[] zzsfVarArr, String[] strArr, zzsa[] zzsaVarArr) {
        this.zza = zzshVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzsiVarArr;
        this.zze = zzsfVarArr;
        this.zzf = strArr;
        this.zzg = zzsaVarArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeTypedArray(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeTypedArray(parcel, 5, this.zze, i, false);
        SafeParcelWriter.writeStringArray(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeTypedArray(parcel, 7, this.zzg, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzsh zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final zzsa[] zzd() {
        return this.zzg;
    }

    public final zzsf[] zze() {
        return this.zze;
    }

    public final zzsi[] zzf() {
        return this.zzd;
    }

    public final String[] zzg() {
        return this.zzf;
    }
}
