package com.google.photos.vision.barhopper;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp;

/* compiled from: com.google.mlkit:barcode-scanning@@17.1.0 */
/* loaded from: classes5.dex */
public final class zzp extends zzed implements zzfp {
    private static final zzp zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private zzn zzj;
    private zzn zzk;

    static {
        zzp zzpVar = new zzp();
        zza = zzpVar;
        zzed.zzU(zzp.class, zzpVar);
    }

    private zzp() {
    }

    public static zzp zzd() {
        return zza;
    }

    public final zzn zza() {
        zzn zznVar = this.zzk;
        return zznVar == null ? zzn.zzi() : zznVar;
    }

    public final zzn zzb() {
        zzn zznVar = this.zzj;
        return zznVar == null ? zzn.zzi() : zznVar;
    }

    public final String zze() {
        return this.zzf;
    }

    public final String zzf() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    protected final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzR(zza, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဉ\u0005\u0007ဉ\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i2 == 3) {
            return new zzp();
        }
        zza zzaVar = null;
        if (i2 == 4) {
            return new zzo(zzaVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }

    public final String zzh() {
        return this.zzh;
    }

    public final String zzi() {
        return this.zzi;
    }

    public final String zzj() {
        return this.zze;
    }
}
