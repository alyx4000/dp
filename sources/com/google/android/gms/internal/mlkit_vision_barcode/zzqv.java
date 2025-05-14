package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.2.0 */
/* loaded from: classes3.dex */
public final class zzqv {
    private final zzcd zza;

    /* synthetic */ zzqv(zzqt zzqtVar, zzqu zzquVar) {
        zzcd zzcdVar;
        zzcdVar = zzqtVar.zza;
        this.zza = zzcdVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzqv) {
            return Objects.equal(this.zza, ((zzqv) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza);
    }

    public final zzcd zza() {
        return this.zza;
    }
}
