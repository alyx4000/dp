package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* compiled from: com.google.mlkit:barcode-scanning@@17.1.0 */
/* loaded from: classes3.dex */
public final class zzjk extends zzed implements zzfp {
    private static final zzjk zza;
    private int zzd;
    private zzel zze = zzO();
    private zzjm zzf;
    private zzhv zzg;

    static {
        zzjk zzjkVar = new zzjk();
        zza = zzjkVar;
        zzed.zzU(zzjk.class, zzjkVar);
    }

    private zzjk() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    protected final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzR(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"zzd", "zze", zzjw.class, "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzjk();
        }
        zzhr zzhrVar = null;
        if (i2 == 4) {
            return new zzjj(zzhrVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
