package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.2.0 */
/* loaded from: classes3.dex */
final class zzrv extends LazyInstanceMap {
    private zzrv() {
    }

    @Override // com.google.mlkit.common.sdkinternal.LazyInstanceMap
    protected final /* bridge */ /* synthetic */ Object create(Object obj) {
        zzrd zzrdVar = (zzrd) obj;
        MlKitContext mlKitContext = MlKitContext.getInstance();
        return new zzrl(mlKitContext.getApplicationContext(), (SharedPrefManager) mlKitContext.get(SharedPrefManager.class), new zzre(MlKitContext.getInstance().getApplicationContext(), zzrdVar), zzrdVar.zzb());
    }

    /* synthetic */ zzrv(zzru zzruVar) {
    }
}
