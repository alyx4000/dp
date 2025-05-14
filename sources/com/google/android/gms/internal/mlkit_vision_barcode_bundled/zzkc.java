package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* compiled from: com.google.mlkit:barcode-scanning@@17.1.0 */
/* loaded from: classes3.dex */
public final class zzkc extends zzdz implements zzfp {
    private static final zzkc zzd;
    private byte zze = 2;

    static {
        zzkc zzkcVar = new zzkc();
        zzd = zzkcVar;
        zzed.zzU(zzkc.class, zzkcVar);
    }

    private zzkc() {
    }

    public static zzkc zzf() {
        return zzd;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    protected final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zze);
        }
        zzka zzkaVar = null;
        if (i2 == 2) {
            return zzR(zzd, "\u0003\u0000", null);
        }
        if (i2 == 3) {
            return new zzkc();
        }
        if (i2 == 4) {
            return new zzkb(zzkaVar);
        }
        if (i2 == 5) {
            return zzd;
        }
        this.zze = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
