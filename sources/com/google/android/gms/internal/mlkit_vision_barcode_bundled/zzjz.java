package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* compiled from: com.google.mlkit:barcode-scanning@@17.1.0 */
/* loaded from: classes3.dex */
public final class zzjz extends zzed implements zzfp {
    private static final zzjz zza;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        zzjz zzjzVar = new zzjz();
        zza = zzjzVar;
        zzed.zzU(zzjz.class, zzjzVar);
    }

    private zzjz() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    protected final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzR(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဌ\u0001", new Object[]{"zzd", "zze", "zzf", zzjx.zza});
        }
        if (i2 == 3) {
            return new zzjz();
        }
        zzhr zzhrVar = null;
        if (i2 == 4) {
            return new zzjy(zzhrVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
