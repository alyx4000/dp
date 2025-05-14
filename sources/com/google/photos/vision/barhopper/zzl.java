package com.google.photos.vision.barhopper;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzel;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp;

/* compiled from: com.google.mlkit:barcode-scanning@@17.1.0 */
/* loaded from: classes5.dex */
public final class zzl extends zzed implements zzfp {
    private static final zzl zza;
    private int zzd;
    private String zze = "";
    private zzel zzf = zzO();

    static {
        zzl zzlVar = new zzl();
        zza = zzlVar;
        zzed.zzU(zzl.class, zzlVar);
    }

    private zzl() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    protected final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzR(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zzd", "zze", "zzf", zzaa.class});
        }
        if (i2 == 3) {
            return new zzl();
        }
        zza zzaVar = null;
        if (i2 == 4) {
            return new zzk(zzaVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
