package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* compiled from: com.google.mlkit:barcode-scanning@@17.1.0 */
/* loaded from: classes3.dex */
public final class zzji extends zzed implements zzfp {
    private static final zzji zza;
    private int zzd;
    private String zze = "";
    private zzjo zzf;

    static {
        zzji zzjiVar = new zzji();
        zza = zzjiVar;
        zzed.zzU(zzji.class, zzjiVar);
    }

    private zzji() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    protected final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzR(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဉ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzji();
        }
        zzhr zzhrVar = null;
        if (i2 == 4) {
            return new zzjh(zzhrVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
