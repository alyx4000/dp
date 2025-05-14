package com.google.photos.vision.barhopper;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp;

/* compiled from: com.google.mlkit:barcode-scanning@@17.1.0 */
/* loaded from: classes5.dex */
public final class zzt extends zzed implements zzfp {
    private static final zzt zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";
    private String zzl = "";
    private String zzm = "";
    private String zzn = "";
    private String zzo = "";
    private String zzp = "";
    private String zzq = "";
    private String zzr = "";

    static {
        zzt zztVar = new zzt();
        zza = zztVar;
        zzed.zzU(zzt.class, zztVar);
    }

    private zzt() {
    }

    public static zzt zzb() {
        return zza;
    }

    public final String zzc() {
        return this.zzk;
    }

    public final String zzd() {
        return this.zzl;
    }

    public final String zze() {
        return this.zzj;
    }

    public final String zzf() {
        return this.zzm;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    protected final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzR(zza, "\u0001\u000e\u0000\u0001\u0001\u000e\u000e\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006\bဈ\u0007\tဈ\b\nဈ\t\u000bဈ\n\fဈ\u000b\rဈ\f\u000eဈ\r", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr"});
        }
        if (i2 == 3) {
            return new zzt();
        }
        zza zzaVar = null;
        if (i2 == 4) {
            return new zzs(zzaVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }

    public final String zzh() {
        return this.zzq;
    }

    public final String zzi() {
        return this.zze;
    }

    public final String zzj() {
        return this.zzp;
    }

    public final String zzk() {
        return this.zzf;
    }

    public final String zzl() {
        return this.zzi;
    }

    public final String zzm() {
        return this.zzo;
    }

    public final String zzn() {
        return this.zzr;
    }

    public final String zzo() {
        return this.zzh;
    }

    public final String zzp() {
        return this.zzn;
    }

    public final String zzq() {
        return this.zzg;
    }
}
