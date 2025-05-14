package com.google.android.gms.internal.mlkit_vision_text_common;

import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.0.0 */
/* loaded from: classes3.dex */
final class zzrn extends LazyInstanceMap {
    private zzrn() {
    }

    @Override // com.google.mlkit.common.sdkinternal.LazyInstanceMap
    protected final /* bridge */ /* synthetic */ Object create(Object obj) {
        zzqv zzqvVar = (zzqv) obj;
        MlKitContext mlKitContext = MlKitContext.getInstance();
        return new zzrd(mlKitContext.getApplicationContext(), (SharedPrefManager) mlKitContext.get(SharedPrefManager.class), new zzqw(MlKitContext.getInstance().getApplicationContext(), zzqvVar), zzqvVar.zzb());
    }

    /* synthetic */ zzrn(zzrm zzrmVar) {
    }
}
