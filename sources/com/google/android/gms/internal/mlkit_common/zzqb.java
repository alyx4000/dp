package com.google.android.gms.internal.mlkit_common;

import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* compiled from: com.google.mlkit:common@@18.8.0 */
/* loaded from: classes3.dex */
final class zzqb extends LazyInstanceMap {
    private zzqb() {
    }

    @Override // com.google.mlkit.common.sdkinternal.LazyInstanceMap
    protected final /* bridge */ /* synthetic */ Object create(Object obj) {
        zzpl zzplVar = (zzpl) obj;
        MlKitContext mlKitContext = MlKitContext.getInstance();
        return new zzpr(mlKitContext.getApplicationContext(), (SharedPrefManager) mlKitContext.get(SharedPrefManager.class), new zzpm(MlKitContext.getInstance().getApplicationContext(), zzplVar), zzplVar.zzb());
    }

    /* synthetic */ zzqb(zzqa zzqaVar) {
    }
}
