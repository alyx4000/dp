package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* compiled from: com.google.mlkit:barcode-scanning@@17.1.0 */
/* loaded from: classes3.dex */
public final class zziw extends zzed implements zzfp {
    private static final zziw zza;
    private int zzd;
    private boolean zze;
    private int zzf;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private boolean zzg = true;
    private String zzl = "";
    private String zzm = "";

    static {
        zziw zziwVar = new zziw();
        zza = zziwVar;
        zzed.zzU(zziw.class, zziwVar);
    }

    private zziw() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    protected final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zzeh zzehVar = zziy.zza;
            zzeh zzehVar2 = zziu.zza;
            zzeh zzehVar3 = zzix.zza;
            return zzR(zza, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဌ\u0001\u0003ဇ\u0002\u0004ဌ\u0003\u0005ဌ\u0004\u0006ဌ\u0005\u0007ဌ\u0006\bဈ\u0007\tဈ\b", new Object[]{"zzd", "zze", "zzf", zzehVar, "zzg", "zzh", zzehVar2, "zzi", zzehVar3, "zzj", zzehVar3, "zzk", zzehVar3, "zzl", "zzm"});
        }
        if (i2 == 3) {
            return new zziw();
        }
        zzhr zzhrVar = null;
        if (i2 == 4) {
            return new zziv(zzhrVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
