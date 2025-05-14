package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.UnsupportedEncodingException;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.2.0 */
/* loaded from: classes3.dex */
public final class zzro implements zzra {
    private final zznf zza;
    private zzpx zzb = new zzpx();
    private final int zzc;

    private zzro(zznf zznfVar, int i) {
        this.zza = zznfVar;
        zzrx.zza();
        this.zzc = i;
    }

    public static zzra zzf(zznf zznfVar) {
        return new zzro(zznfVar, 0);
    }

    public static zzra zzg(zznf zznfVar, int i) {
        return new zzro(zznfVar, 1);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzra
    public final int zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzra
    public final zzra zzb(zzne zzneVar) {
        this.zza.zzf(zzneVar);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzra
    public final zzra zzc(zzpx zzpxVar) {
        this.zzb = zzpxVar;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzra
    public final String zzd() {
        zzpz zzf = this.zza.zzj().zzf();
        return (zzf == null || zzar.zzb(zzf.zzk())) ? "NA" : (String) Preconditions.checkNotNull(zzf.zzk());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzra
    public final byte[] zze(int i, boolean z) {
        this.zzb.zzf(Boolean.valueOf(1 == (i ^ 1)));
        this.zzb.zze(false);
        this.zza.zzi(this.zzb.zzm());
        try {
            zzrx.zza();
            if (i == 0) {
                return new JsonDataEncoderBuilder().configureWith(zzlh.zza).ignoreNullValues(true).build().encode(this.zza.zzj()).getBytes("utf-8");
            }
            zznh zzj = this.zza.zzj();
            zzdo zzdoVar = new zzdo();
            zzlh.zza.configure(zzdoVar);
            return zzdoVar.zza().zza(zzj);
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e);
        }
    }
}
