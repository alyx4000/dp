package com.google.android.gms.internal.mlkit_vision_barcode;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.2.0 */
/* loaded from: classes3.dex */
public final class zzrw {
    private static zzrv zza;

    public static synchronized zzrl zza(zzrd zzrdVar) {
        zzrl zzrlVar;
        synchronized (zzrw.class) {
            if (zza == null) {
                zza = new zzrv(null);
            }
            zzrlVar = (zzrl) zza.get(zzrdVar);
        }
        return zzrlVar;
    }

    public static synchronized zzrl zzb(String str) {
        zzrl zza2;
        synchronized (zzrw.class) {
            zza2 = zza(zzrd.zzd(str).zzd());
        }
        return zza2;
    }
}
