package com.google.android.gms.internal.identity;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
/* loaded from: classes3.dex */
final /* synthetic */ class zzcc implements RemoteCall {
    static final /* synthetic */ zzcc zza = new zzcc();

    private /* synthetic */ zzcc() {
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final /* synthetic */ void accept(Object obj, Object obj2) {
        ((zzdu) obj).zzz((TaskCompletionSource) obj2);
    }
}
