package com.google.android.gms.cloudmessaging;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.1.0 */
/* loaded from: classes3.dex */
final class zzt extends zzr {
    zzt(int i, int i2, Bundle bundle) {
        super(i, 1, bundle);
    }

    @Override // com.google.android.gms.cloudmessaging.zzr
    final void zza(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        zzd(bundle2);
    }

    @Override // com.google.android.gms.cloudmessaging.zzr
    final boolean zzb() {
        return false;
    }
}
