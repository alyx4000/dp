package com.google.barhopper.deeplearning;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzei;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzht;

/* compiled from: com.google.mlkit:barcode-scanning@@17.1.0 */
/* loaded from: classes3.dex */
public final class zzi extends zzed implements zzfp {
    private static final zzi zza;
    private int zzd;
    private zzf zzj;
    private zzht zzm;
    private String zze = "";
    private zzdb zzf = zzdb.zzb;
    private int zzg = 10;
    private float zzh = 0.5f;
    private float zzi = 0.05f;
    private zzei zzk = zzL();
    private int zzl = 1;
    private int zzn = 320;
    private int zzo = 4;
    private int zzp = 2;

    static {
        zzi zziVar = new zzi();
        zza = zziVar;
        zzed.zzU(zzi.class, zziVar);
    }

    private zzi() {
    }

    public static zzh zza() {
        return (zzh) zza.zzF();
    }

    static /* synthetic */ void zzc(zzi zziVar, zzf zzfVar) {
        zzfVar.getClass();
        zziVar.zzj = zzfVar;
        zziVar.zzd |= 32;
    }

    static /* synthetic */ void zzd(zzi zziVar, zzdb zzdbVar) {
        zzdbVar.getClass();
        zziVar.zzd |= 2;
        zziVar.zzf = zzdbVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    protected final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzR(zza, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0001\u0000\u0001ဈ\u0000\u0002ည\u0001\u0003ဋ\u0002\u0004ခ\u0003\u0005ခ\u0004\u0006ဉ\u0005\u0007\u0013\bင\u0006\tဉ\u0007\nင\b\u000bင\t\fင\n", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp"});
        }
        if (i2 == 3) {
            return new zzi();
        }
        zzg zzgVar = null;
        if (i2 == 4) {
            return new zzh(zzgVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
