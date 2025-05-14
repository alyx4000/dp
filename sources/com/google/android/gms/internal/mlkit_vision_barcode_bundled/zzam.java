package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* compiled from: com.google.mlkit:barcode-scanning@@17.1.0 */
/* loaded from: classes3.dex */
public final class zzam extends zzed implements zzfp {
    private static final zzam zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";

    static {
        zzam zzamVar = new zzam();
        zza = zzamVar;
        zzed.zzU(zzam.class, zzamVar);
    }

    private zzam() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    protected final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzR(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzam();
        }
        zzak zzakVar = null;
        if (i2 == 4) {
            return new zzal(zzakVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
