package com.google.android.gms.internal.mlkit_vision_barcode;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.2.0 */
/* loaded from: classes3.dex */
public final class zzmn {
    private zzmo zza;
    private Integer zzb;

    public final zzmn zza(zzmo zzmoVar) {
        this.zza = zzmoVar;
        return this;
    }

    public final zzmn zzb(Integer num) {
        this.zzb = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final zzmq zzd() {
        return new zzmq(this, null);
    }
}
