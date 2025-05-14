package com.google.android.gms.internal.mlkit_vision_barcode;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.2.0 */
/* loaded from: classes3.dex */
public final class zzsm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzsm> CREATOR = new zzsn();
    private final int zza;
    private final String zzb;
    private final String zzc;
    private final byte[] zzd;
    private final Point[] zze;
    private final int zzf;
    private final zzsf zzg;
    private final zzsi zzh;
    private final zzsj zzi;
    private final zzsl zzj;
    private final zzsk zzk;
    private final zzsg zzl;
    private final zzsc zzm;
    private final zzsd zzn;
    private final zzse zzo;

    public zzsm(int i, String str, String str2, byte[] bArr, Point[] pointArr, int i2, zzsf zzsfVar, zzsi zzsiVar, zzsj zzsjVar, zzsl zzslVar, zzsk zzskVar, zzsg zzsgVar, zzsc zzscVar, zzsd zzsdVar, zzse zzseVar) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bArr;
        this.zze = pointArr;
        this.zzf = i2;
        this.zzg = zzsfVar;
        this.zzh = zzsiVar;
        this.zzi = zzsjVar;
        this.zzj = zzslVar;
        this.zzk = zzskVar;
        this.zzl = zzsgVar;
        this.zzm = zzscVar;
        this.zzn = zzsdVar;
        this.zzo = zzseVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeByteArray(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeTypedArray(parcel, 5, this.zze, i, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzf);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzg, i, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzh, i, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzi, i, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzj, i, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzk, i, false);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzl, i, false);
        SafeParcelWriter.writeParcelable(parcel, 13, this.zzm, i, false);
        SafeParcelWriter.writeParcelable(parcel, 14, this.zzn, i, false);
        SafeParcelWriter.writeParcelable(parcel, 15, this.zzo, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzf;
    }

    public final zzsc zzc() {
        return this.zzm;
    }

    public final zzsd zzd() {
        return this.zzn;
    }

    public final zzse zze() {
        return this.zzo;
    }

    public final zzsf zzf() {
        return this.zzg;
    }

    public final zzsg zzg() {
        return this.zzl;
    }

    public final zzsi zzh() {
        return this.zzh;
    }

    public final zzsj zzi() {
        return this.zzi;
    }

    public final zzsk zzj() {
        return this.zzk;
    }

    public final zzsl zzk() {
        return this.zzj;
    }

    public final String zzl() {
        return this.zzb;
    }

    public final String zzm() {
        return this.zzc;
    }

    public final byte[] zzn() {
        return this.zzd;
    }

    public final Point[] zzo() {
        return this.zze;
    }
}
