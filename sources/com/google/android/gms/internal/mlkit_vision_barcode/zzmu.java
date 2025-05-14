package com.google.android.gms.internal.mlkit_vision_barcode;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.2.0 */
/* loaded from: classes3.dex */
public final class zzmu {
    private Long zza;
    private zznd zzb;
    private Boolean zzc;
    private Boolean zzd;
    private Boolean zze;

    public final zzmu zza(Boolean bool) {
        this.zzd = bool;
        return this;
    }

    public final zzmu zzb(Boolean bool) {
        this.zze = bool;
        return this;
    }

    public final zzmu zzc(Long l) {
        this.zza = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzmu zzd(zznd zzndVar) {
        this.zzb = zzndVar;
        return this;
    }

    public final zzmu zze(Boolean bool) {
        this.zzc = bool;
        return this;
    }

    public final zzmw zzf() {
        return new zzmw(this, null);
    }
}
