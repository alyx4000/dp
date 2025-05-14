package com.google.android.gms.internal.fido;

import java.util.Arrays;
import org.tensorflow.lite.schema.BuiltinOptions;

/* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
/* loaded from: classes3.dex */
public final class zzdk extends zzdr {
    private final zzcz zza;

    zzdk(zzcz zzczVar) {
        this.zza = zzczVar;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzdr zzdrVar = (zzdr) obj;
        if (zzd(BuiltinOptions.UnpackOptions) != zzdrVar.zza()) {
            return zzd(BuiltinOptions.UnpackOptions) - zzdrVar.zza();
        }
        zzdk zzdkVar = (zzdk) zzdrVar;
        zzcz zzczVar = this.zza;
        int zzd = zzczVar.zzd();
        zzcz zzczVar2 = zzdkVar.zza;
        if (zzd != zzczVar2.zzd()) {
            return zzczVar.zzd() - zzczVar2.zzd();
        }
        return zzco.zza().compare(zzczVar.zzm(), zzdkVar.zza.zzm());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return this.zza.equals(((zzdk) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(zzd(BuiltinOptions.UnpackOptions)), this.zza});
    }

    public final String toString() {
        zzch zzd = zzch.zzf().zzd();
        byte[] zzm = this.zza.zzm();
        return "h'" + zzd.zzg(zzm, 0, zzm.length) + "'";
    }

    @Override // com.google.android.gms.internal.fido.zzdr
    protected final int zza() {
        return zzd(BuiltinOptions.UnpackOptions);
    }

    public final zzcz zzc() {
        return this.zza;
    }
}
