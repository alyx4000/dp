package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* compiled from: com.google.mlkit:barcode-scanning@@17.1.0 */
/* loaded from: classes3.dex */
public final class zzjm extends zzed implements zzfp {
    private static final zzjm zza;
    private int zzd;
    private String zze = "";
    private long zzf;
    private long zzg;
    private long zzh;

    static {
        zzjm zzjmVar = new zzjm();
        zza = zzjmVar;
        zzed.zzU(zzjm.class, zzjmVar);
    }

    private zzjm() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    protected final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzR(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzjm();
        }
        zzhr zzhrVar = null;
        if (i2 == 4) {
            return new zzjl(zzhrVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
