package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.mlkit:barcode-scanning@@17.1.0 */
/* loaded from: classes3.dex */
final class zzdt {
    private static final zzdt zzb = new zzdt(true);
    final zzgu zza = new zzgk(16);
    private boolean zzc;
    private boolean zzd;

    private zzdt() {
    }

    public static int zza(zzds zzdsVar, Object obj) {
        int zzd;
        int zzy;
        zzho zzd2 = zzdsVar.zzd();
        int zza = zzdsVar.zza();
        zzdsVar.zzg();
        int i = zzdj.zzb;
        int zzy2 = zzdj.zzy(zza << 3);
        if (zzd2 == zzho.GROUP) {
            zzfo zzfoVar = (zzfo) obj;
            byte[] bArr = zzem.zzd;
            if (zzfoVar instanceof zzcl) {
                throw null;
            }
            zzy2 += zzy2;
        }
        zzhp zzhpVar = zzhp.INT;
        int i2 = 4;
        switch (zzd2) {
            case DOUBLE:
                ((Double) obj).doubleValue();
                i2 = 8;
                return zzy2 + i2;
            case FLOAT:
                ((Float) obj).floatValue();
                return zzy2 + i2;
            case INT64:
                i2 = zzdj.zzz(((Long) obj).longValue());
                return zzy2 + i2;
            case UINT64:
                i2 = zzdj.zzz(((Long) obj).longValue());
                return zzy2 + i2;
            case INT32:
                i2 = zzdj.zzu(((Integer) obj).intValue());
                return zzy2 + i2;
            case FIXED64:
                ((Long) obj).longValue();
                i2 = 8;
                return zzy2 + i2;
            case FIXED32:
                ((Integer) obj).intValue();
                return zzy2 + i2;
            case BOOL:
                ((Boolean) obj).booleanValue();
                i2 = 1;
                return zzy2 + i2;
            case STRING:
                if (!(obj instanceof zzdb)) {
                    i2 = zzdj.zzx((String) obj);
                    return zzy2 + i2;
                }
                zzd = ((zzdb) obj).zzd();
                zzy = zzdj.zzy(zzd);
                i2 = zzy + zzd;
                return zzy2 + i2;
            case GROUP:
                i2 = ((zzfo) obj).zzE();
                return zzy2 + i2;
            case MESSAGE:
                if (!(obj instanceof zzet)) {
                    i2 = zzdj.zzv((zzfo) obj);
                    return zzy2 + i2;
                }
                zzd = ((zzet) obj).zza();
                zzy = zzdj.zzy(zzd);
                i2 = zzy + zzd;
                return zzy2 + i2;
            case BYTES:
                if (obj instanceof zzdb) {
                    zzd = ((zzdb) obj).zzd();
                    zzy = zzdj.zzy(zzd);
                } else {
                    zzd = ((byte[]) obj).length;
                    zzy = zzdj.zzy(zzd);
                }
                i2 = zzy + zzd;
                return zzy2 + i2;
            case UINT32:
                i2 = zzdj.zzy(((Integer) obj).intValue());
                return zzy2 + i2;
            case ENUM:
                i2 = obj instanceof zzef ? zzdj.zzu(((zzef) obj).zza()) : zzdj.zzu(((Integer) obj).intValue());
                return zzy2 + i2;
            case SFIXED32:
                ((Integer) obj).intValue();
                return zzy2 + i2;
            case SFIXED64:
                ((Long) obj).longValue();
                i2 = 8;
                return zzy2 + i2;
            case SINT32:
                int intValue = ((Integer) obj).intValue();
                i2 = zzdj.zzy((intValue >> 31) ^ (intValue + intValue));
                return zzy2 + i2;
            case SINT64:
                long longValue = ((Long) obj).longValue();
                i2 = zzdj.zzz((longValue >> 63) ^ (longValue + longValue));
                return zzy2 + i2;
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static zzdt zzd() {
        return zzb;
    }

    private static Object zzl(Object obj) {
        if (obj instanceof zzft) {
            return ((zzft) obj).zzc();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    private final void zzm(Map.Entry entry) {
        zzfo zzj;
        zzds zzdsVar = (zzds) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzet) {
            throw null;
        }
        zzdsVar.zzg();
        if (zzdsVar.zze() != zzhp.MESSAGE) {
            this.zza.put(zzdsVar, zzl(value));
            return;
        }
        Object zze = zze(zzdsVar);
        if (zze == null) {
            this.zza.put(zzdsVar, zzl(value));
            return;
        }
        if (zze instanceof zzft) {
            zzj = zzdsVar.zzc((zzft) zze, (zzft) value);
        } else {
            zzfn zzZ = ((zzfo) zze).zzZ();
            zzdsVar.zzb(zzZ, (zzfo) value);
            zzj = zzZ.zzj();
        }
        this.zza.put(zzdsVar, zzj);
    }

    private static boolean zzn(Map.Entry entry) {
        zzds zzdsVar = (zzds) entry.getKey();
        if (zzdsVar.zze() != zzhp.MESSAGE) {
            return true;
        }
        zzdsVar.zzg();
        Object value = entry.getValue();
        if (value instanceof zzfp) {
            return ((zzfp) value).zzac();
        }
        if (value instanceof zzet) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzo(Map.Entry entry) {
        zzds zzdsVar = (zzds) entry.getKey();
        Object value = entry.getValue();
        if (zzdsVar.zze() != zzhp.MESSAGE) {
            return zza(zzdsVar, value);
        }
        zzdsVar.zzg();
        zzdsVar.zzf();
        if (!(value instanceof zzet)) {
            int zzy = zzdj.zzy(((zzds) entry.getKey()).zza());
            int zzy2 = zzdj.zzy(24) + zzdj.zzv((zzfo) value);
            int zzy3 = zzdj.zzy(16);
            int zzy4 = zzdj.zzy(8);
            return zzy4 + zzy4 + zzy3 + zzy + zzy2;
        }
        int zzy5 = zzdj.zzy(((zzds) entry.getKey()).zza());
        int zza = ((zzet) value).zza();
        int zzy6 = zzdj.zzy(zza) + zza;
        int zzy7 = zzdj.zzy(24);
        int zzy8 = zzdj.zzy(16);
        int zzy9 = zzdj.zzy(8);
        return zzy9 + zzy9 + zzy8 + zzy5 + zzy7 + zzy6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzdt) {
            return this.zza.equals(((zzdt) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzb() {
        int i = 0;
        for (int i2 = 0; i2 < this.zza.zzb(); i2++) {
            i += zzo(this.zza.zzg(i2));
        }
        Iterator it = this.zza.zzc().iterator();
        while (it.hasNext()) {
            i += zzo((Map.Entry) it.next());
        }
        return i;
    }

    /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzdt clone() {
        zzdt zzdtVar = new zzdt();
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry zzg = this.zza.zzg(i);
            zzdtVar.zzi((zzds) zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzdtVar.zzi((zzds) entry.getKey(), entry.getValue());
        }
        zzdtVar.zzd = this.zzd;
        return zzdtVar;
    }

    public final Object zze(zzds zzdsVar) {
        Object obj = this.zza.get(zzdsVar);
        if (!(obj instanceof zzet)) {
            return obj;
        }
        throw null;
    }

    public final Iterator zzf() {
        return this.zzd ? new zzes(this.zza.entrySet().iterator()) : this.zza.entrySet().iterator();
    }

    public final void zzg() {
        if (this.zzc) {
            return;
        }
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry zzg = this.zza.zzg(i);
            if (zzg.getValue() instanceof zzed) {
                ((zzed) zzg.getValue()).zzS();
            }
        }
        this.zza.zza();
        this.zzc = true;
    }

    public final void zzh(zzdt zzdtVar) {
        for (int i = 0; i < zzdtVar.zza.zzb(); i++) {
            zzm(zzdtVar.zza.zzg(i));
        }
        Iterator it = zzdtVar.zza.zzc().iterator();
        while (it.hasNext()) {
            zzm((Map.Entry) it.next());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002b, code lost:
    
        if ((r4 instanceof com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzef) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0034, code lost:
    
        if ((r4 instanceof byte[]) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0048, code lost:
    
        if (r0 == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0022, code lost:
    
        if ((r4 instanceof com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzet) == false) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzi(com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzds r3, java.lang.Object r4) {
        /*
            r2 = this;
            r3.zzg()
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzho r0 = r3.zzd()
            byte[] r1 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzem.zzd
            r4.getClass()
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzho r1 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzho.DOUBLE
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhp r1 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhp.INT
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhp r0 = r0.zza()
            int r0 = r0.ordinal()
            switch(r0) {
                case 0: goto L46;
                case 1: goto L43;
                case 2: goto L40;
                case 3: goto L3d;
                case 4: goto L3a;
                case 5: goto L37;
                case 6: goto L2e;
                case 7: goto L25;
                case 8: goto L1c;
                default: goto L1b;
            }
        L1b:
            goto L57
        L1c:
            boolean r0 = r4 instanceof com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfo
            if (r0 != 0) goto L4a
            boolean r0 = r4 instanceof com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzet
            if (r0 == 0) goto L57
            goto L4a
        L25:
            boolean r0 = r4 instanceof java.lang.Integer
            if (r0 != 0) goto L4a
            boolean r0 = r4 instanceof com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzef
            if (r0 == 0) goto L57
            goto L4a
        L2e:
            boolean r0 = r4 instanceof com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
            if (r0 != 0) goto L4a
            boolean r0 = r4 instanceof byte[]
            if (r0 == 0) goto L57
            goto L4a
        L37:
            boolean r0 = r4 instanceof java.lang.String
            goto L48
        L3a:
            boolean r0 = r4 instanceof java.lang.Boolean
            goto L48
        L3d:
            boolean r0 = r4 instanceof java.lang.Double
            goto L48
        L40:
            boolean r0 = r4 instanceof java.lang.Float
            goto L48
        L43:
            boolean r0 = r4 instanceof java.lang.Long
            goto L48
        L46:
            boolean r0 = r4 instanceof java.lang.Integer
        L48:
            if (r0 == 0) goto L57
        L4a:
            boolean r0 = r4 instanceof com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzet
            if (r0 == 0) goto L51
            r0 = 1
            r2.zzd = r0
        L51:
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgu r0 = r2.zza
            r0.put(r3, r4)
            return
        L57:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            int r1 = r3.zza()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzho r3 = r3.zzd()
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhp r3 = r3.zza()
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getName()
            java.lang.Object[] r3 = new java.lang.Object[]{r1, r3, r4}
            java.lang.String r4 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r3 = java.lang.String.format(r4, r3)
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdt.zzi(com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzds, java.lang.Object):void");
    }

    public final boolean zzj() {
        return this.zzc;
    }

    public final boolean zzk() {
        for (int i = 0; i < this.zza.zzb(); i++) {
            if (!zzn(this.zza.zzg(i))) {
                return false;
            }
        }
        Iterator it = this.zza.zzc().iterator();
        while (it.hasNext()) {
            if (!zzn((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private zzdt(boolean z) {
        zzg();
        zzg();
    }
}
