package com.google.android.gms.internal.fido;

import org.bouncycastle.asn1.BERTags;

/* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
/* loaded from: classes3.dex */
public final class zzdt {
    private final byte zza;
    private final byte zzb;

    zzdt(int i) {
        this.zza = (byte) (i & BERTags.FLAGS);
        this.zzb = (byte) (i & 31);
    }

    public final byte zza() {
        return this.zzb;
    }

    public final byte zzb() {
        return this.zza;
    }

    public final int zzc() {
        return (this.zza >> 5) & 7;
    }
}
