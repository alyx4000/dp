package com.google.android.gms.internal.identity;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
/* loaded from: classes3.dex */
final class zzeq extends zzeo {
    private final zzes zza;

    zzeq(zzes zzesVar, int i) {
        super(zzesVar.size(), i);
        this.zza = zzesVar;
    }

    @Override // com.google.android.gms.internal.identity.zzeo
    protected final Object zza(int i) {
        return this.zza.get(i);
    }
}
