package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* compiled from: com.google.mlkit:barcode-scanning@@17.1.0 */
/* loaded from: classes3.dex */
public final class zzje extends zzed implements zzfp {
    private static final zzje zza;
    private int zzd;
    private int zze;
    private int zzf = 100;
    private int zzg;

    static {
        zzje zzjeVar = new zzje();
        zza = zzjeVar;
        zzed.zzU(zzje.class, zzjeVar);
    }

    private zzje() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    protected final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzR(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zzd", "zze", zzjc.zza, "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzje();
        }
        zzhr zzhrVar = null;
        if (i2 == 4) {
            return new zzjd(zzhrVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
