package com.google.android.gms.internal.mlkit_vision_barcode;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.2.0 */
/* loaded from: classes3.dex */
public final class zzre implements zzrb {
    final List zza;

    public zzre(Context context, zzrd zzrdVar) {
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        if (zzrdVar.zzc()) {
            arrayList.add(new zzrt(context, zzrdVar));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzrb
    public final void zza(zzra zzraVar) {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((zzrb) it.next()).zza(zzraVar);
        }
    }
}
