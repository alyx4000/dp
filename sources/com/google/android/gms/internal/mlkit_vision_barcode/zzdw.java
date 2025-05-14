package com.google.android.gms.internal.mlkit_vision_barcode;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.2.0 */
/* loaded from: classes3.dex */
public final class zzdw {
    private zzdz zza;
    private Integer zzb;
    private zzmj zzc;

    public final zzdw zza(Integer num) {
        this.zzb = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final zzdw zzb(zzmj zzmjVar) {
        this.zzc = zzmjVar;
        return this;
    }

    public final zzdw zzc(zzdz zzdzVar) {
        this.zza = zzdzVar;
        return this;
    }

    public final zzeb zze() {
        return new zzeb(this, null);
    }
}
