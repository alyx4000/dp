package com.google.android.gms.internal.identity;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
/* loaded from: classes3.dex */
final /* synthetic */ class zzcb implements RemoteCall {
    static final /* synthetic */ zzcb zza = new zzcb();

    private /* synthetic */ zzcb() {
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final /* synthetic */ void accept(Object obj, Object obj2) {
        ((zzdu) obj).zzy((TaskCompletionSource) obj2);
    }
}
