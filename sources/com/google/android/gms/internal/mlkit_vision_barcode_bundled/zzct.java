package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.Comparator;
import kotlin.UByte;

/* compiled from: com.google.mlkit:barcode-scanning@@17.1.0 */
/* loaded from: classes3.dex */
final class zzct implements Comparator {
    zzct() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzdb zzdbVar = (zzdb) obj;
        zzdb zzdbVar2 = (zzdb) obj2;
        zzcw it = zzdbVar.iterator();
        zzcw it2 = zzdbVar2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            int compareTo = Integer.valueOf(it.zza() & UByte.MAX_VALUE).compareTo(Integer.valueOf(it2.zza() & UByte.MAX_VALUE));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzdbVar.zzd()).compareTo(Integer.valueOf(zzdbVar2.zzd()));
    }
}
