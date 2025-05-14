package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* compiled from: com.google.mlkit:barcode-scanning@@17.1.0 */
/* loaded from: classes3.dex */
public final class zzab extends zzed implements zzfp {
    private static final zzab zza;
    private int zzd;
    private zzae zze;
    private boolean zzf;

    static {
        zzab zzabVar = new zzab();
        zza = zzabVar;
        zzed.zzU(zzab.class, zzabVar);
    }

    private zzab() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    protected final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzR(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဇ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzab();
        }
        zzz zzzVar = null;
        if (i2 == 4) {
            return new zzaa(zzzVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
