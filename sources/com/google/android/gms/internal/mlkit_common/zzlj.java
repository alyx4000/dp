package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@18.8.0 */
/* loaded from: classes3.dex */
public final class zzlj {
    private zzlv zza;
    private Long zzb;
    private zzle zzc;
    private Long zzd;
    private zzlk zze;
    private Long zzf;

    public final zzlj zzb(Long l) {
        this.zzf = l;
        return this;
    }

    public final zzlj zzc(zzlk zzlkVar) {
        this.zze = zzlkVar;
        return this;
    }

    public final zzlj zzd(zzle zzleVar) {
        this.zzc = zzleVar;
        return this;
    }

    public final zzlj zze(Long l) {
        this.zzd = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzlj zzf(zzlv zzlvVar) {
        this.zza = zzlvVar;
        return this;
    }

    public final zzlj zzg(Long l) {
        this.zzb = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzlm zzi() {
        return new zzlm(this, null);
    }
}
