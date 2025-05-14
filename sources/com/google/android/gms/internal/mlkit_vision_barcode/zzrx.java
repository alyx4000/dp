package com.google.android.gms.internal.mlkit_vision_barcode;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.2.0 */
/* loaded from: classes3.dex */
public final class zzrx {
    private static zzrx zza;

    private zzrx() {
    }

    public static synchronized zzrx zza() {
        zzrx zzrxVar;
        synchronized (zzrx.class) {
            if (zza == null) {
                zza = new zzrx();
            }
            zzrxVar = zza;
        }
        return zzrxVar;
    }
}
