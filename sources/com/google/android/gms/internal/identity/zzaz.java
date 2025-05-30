package com.google.android.gms.internal.identity;

import com.google.android.gms.common.api.internal.ListenerHolder;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
/* loaded from: classes3.dex */
final class zzaz implements zzdm {
    private ListenerHolder zza;

    zzaz(ListenerHolder listenerHolder) {
        this.zza = listenerHolder;
    }

    @Override // com.google.android.gms.internal.identity.zzdm
    public final synchronized ListenerHolder zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.identity.zzdm
    public final synchronized void zzb(ListenerHolder listenerHolder) {
        ListenerHolder listenerHolder2 = this.zza;
        if (listenerHolder2 != listenerHolder) {
            listenerHolder2.clear();
            this.zza = listenerHolder;
        }
    }

    @Override // com.google.android.gms.internal.identity.zzdm
    public final void zzc() {
    }
}
