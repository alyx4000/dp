package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* compiled from: com.google.mlkit:barcode-scanning@@17.1.0 */
/* loaded from: classes3.dex */
public final class zzjb extends zzed implements zzfp {
    private static final zzjb zza;
    private int zzd;
    private boolean zzf;
    private int zzg;
    private int zze = -1;
    private zzdb zzh = zzdb.zzb;

    static {
        zzjb zzjbVar = new zzjb();
        zza = zzjbVar;
        zzed.zzU(zzjb.class, zzjbVar);
    }

    private zzjb() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    protected final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzR(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဇ\u0001\u0003ဌ\u0002\u0004ည\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", zzja.zza, "zzh"});
        }
        if (i2 == 3) {
            return new zzjb();
        }
        zzhr zzhrVar = null;
        if (i2 == 4) {
            return new zziz(zzhrVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
