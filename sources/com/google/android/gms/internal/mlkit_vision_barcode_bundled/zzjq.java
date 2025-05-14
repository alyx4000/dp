package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* compiled from: com.google.mlkit:barcode-scanning@@17.1.0 */
/* loaded from: classes3.dex */
public final class zzjq extends zzed implements zzfp {
    private static final zzjq zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private int zzh;
    private int zzi;
    private zzit zzj;
    private boolean zzk;
    private int zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;
    private long zzp;

    static {
        zzjq zzjqVar = new zzjq();
        zza = zzjqVar;
        zzed.zzU(zzjq.class, zzjqVar);
    }

    private zzjq() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    protected final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzR(zza, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဌ\u0003\u0005င\u0004\u0006ဉ\u0005\u0007ဇ\u0006\bဌ\u0007\tဇ\b\nဇ\t\u000bဇ\n\fဂ\u000b", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", zzjr.zza, "zzi", "zzj", "zzk", "zzl", zzjs.zza, "zzm", "zzn", "zzo", "zzp"});
        }
        if (i2 == 3) {
            return new zzjq();
        }
        zzhr zzhrVar = null;
        if (i2 == 4) {
            return new zzjp(zzhrVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
