package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* compiled from: com.google.mlkit:barcode-scanning@@17.1.0 */
/* loaded from: classes3.dex */
public final class zzju extends zzed implements zzfp {
    private static final zzju zza;
    private int zzd;
    private String zze = "";

    static {
        zzju zzjuVar = new zzju();
        zza = zzjuVar;
        zzed.zzU(zzju.class, zzjuVar);
    }

    private zzju() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    protected final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzR(zza, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzju();
        }
        zzhr zzhrVar = null;
        if (i2 == 4) {
            return new zzjt(zzhrVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
