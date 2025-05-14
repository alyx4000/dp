package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.mlkit:barcode-scanning@@17.1.0 */
/* loaded from: classes3.dex */
final class zzgj {
    public static final /* synthetic */ int zza = 0;
    private static final Class zzb;
    private static final zzgy zzc;
    private static final zzgy zzd;
    private static final zzgy zze;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zzb = cls;
        zzc = zzY(false);
        zzd = zzY(true);
        zze = new zzha();
    }

    public static zzgy zzA() {
        return zze;
    }

    static Object zzB(Object obj, int i, int i2, Object obj2, zzgy zzgyVar) {
        if (obj2 == null) {
            obj2 = zzgyVar.zzc(obj);
        }
        zzgyVar.zzf(obj2, i, i2);
        return obj2;
    }

    static void zzC(zzdp zzdpVar, Object obj, Object obj2) {
        zzdt zzb2 = zzdpVar.zzb(obj2);
        if (zzb2.zza.isEmpty()) {
            return;
        }
        zzdpVar.zzc(obj).zzh(zzb2);
    }

    static void zzD(zzgy zzgyVar, Object obj, Object obj2) {
        zzgyVar.zzh(obj, zzgyVar.zze(zzgyVar.zzd(obj), zzgyVar.zzd(obj2)));
    }

    public static void zzE(Class cls) {
        Class cls2;
        if (!zzed.class.isAssignableFrom(cls) && (cls2 = zzb) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzF(int i, List list, zzhq zzhqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhqVar.zzc(i, list, z);
    }

    public static void zzG(int i, List list, zzhq zzhqVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhqVar.zze(i, list);
    }

    public static void zzH(int i, List list, zzhq zzhqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhqVar.zzg(i, list, z);
    }

    public static void zzI(int i, List list, zzhq zzhqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhqVar.zzj(i, list, z);
    }

    public static void zzJ(int i, List list, zzhq zzhqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhqVar.zzl(i, list, z);
    }

    public static void zzK(int i, List list, zzhq zzhqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhqVar.zzn(i, list, z);
    }

    public static void zzL(int i, List list, zzhq zzhqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhqVar.zzp(i, list, z);
    }

    public static void zzM(int i, List list, zzhq zzhqVar, zzgh zzghVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ((zzdk) zzhqVar).zzq(i, list.get(i2), zzghVar);
        }
    }

    public static void zzN(int i, List list, zzhq zzhqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhqVar.zzs(i, list, z);
    }

    public static void zzO(int i, List list, zzhq zzhqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhqVar.zzu(i, list, z);
    }

    public static void zzP(int i, List list, zzhq zzhqVar, zzgh zzghVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ((zzdk) zzhqVar).zzv(i, list.get(i2), zzghVar);
        }
    }

    public static void zzQ(int i, List list, zzhq zzhqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhqVar.zzy(i, list, z);
    }

    public static void zzR(int i, List list, zzhq zzhqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhqVar.zzA(i, list, z);
    }

    public static void zzS(int i, List list, zzhq zzhqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhqVar.zzC(i, list, z);
    }

    public static void zzT(int i, List list, zzhq zzhqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhqVar.zzE(i, list, z);
    }

    public static void zzU(int i, List list, zzhq zzhqVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhqVar.zzH(i, list);
    }

    public static void zzV(int i, List list, zzhq zzhqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhqVar.zzJ(i, list, z);
    }

    public static void zzW(int i, List list, zzhq zzhqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhqVar.zzL(i, list, z);
    }

    static boolean zzX(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    private static zzgy zzY(boolean z) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (zzgy) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused2) {
            return null;
        }
    }

    static int zza(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzdj.zzy(i << 3) + 1);
    }

    static int zzb(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzy = size * zzdj.zzy(i << 3);
        for (int i2 = 0; i2 < list.size(); i2++) {
            int zzd2 = ((zzdb) list.get(i2)).zzd();
            zzy += zzdj.zzy(zzd2) + zzd2;
        }
        return zzy;
    }

    static int zzc(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzdj.zzy(i << 3));
    }

    static int zzd(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzee) {
            zzee zzeeVar = (zzee) list;
            i = 0;
            while (i2 < size) {
                i += zzdj.zzu(zzeeVar.zze(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzdj.zzu(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zze(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzdj.zzy(i << 3) + 4);
    }

    static int zzf(List list) {
        return list.size() * 4;
    }

    static int zzg(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzdj.zzy(i << 3) + 8);
    }

    static int zzh(List list) {
        return list.size() * 8;
    }

    static int zzi(int i, List list, zzgh zzghVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzdj.zzt(i, (zzfo) list.get(i3), zzghVar);
        }
        return i2;
    }

    static int zzj(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzk(list) + (size * zzdj.zzy(i << 3));
    }

    static int zzk(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzee) {
            zzee zzeeVar = (zzee) list;
            i = 0;
            while (i2 < size) {
                i += zzdj.zzu(zzeeVar.zze(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzdj.zzu(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzl(int i, List list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzm(list) + (list.size() * zzdj.zzy(i << 3));
    }

    static int zzm(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfd) {
            zzfd zzfdVar = (zzfd) list;
            i = 0;
            while (i2 < size) {
                i += zzdj.zzz(zzfdVar.zze(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzdj.zzz(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzn(int i, Object obj, zzgh zzghVar) {
        if (!(obj instanceof zzeu)) {
            return zzdj.zzy(i << 3) + zzdj.zzw((zzfo) obj, zzghVar);
        }
        int i2 = zzdj.zzb;
        int zza2 = ((zzeu) obj).zza();
        return zzdj.zzy(i << 3) + zzdj.zzy(zza2) + zza2;
    }

    static int zzo(int i, List list, zzgh zzghVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzy = zzdj.zzy(i << 3) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof zzeu) {
                int zza2 = ((zzeu) obj).zza();
                zzy += zzdj.zzy(zza2) + zza2;
            } else {
                zzy += zzdj.zzw((zzfo) obj, zzghVar);
            }
        }
        return zzy;
    }

    static int zzp(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzq(list) + (size * zzdj.zzy(i << 3));
    }

    static int zzq(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzee) {
            zzee zzeeVar = (zzee) list;
            i = 0;
            while (i2 < size) {
                int zze2 = zzeeVar.zze(i2);
                i += zzdj.zzy((zze2 >> 31) ^ (zze2 + zze2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                int intValue = ((Integer) list.get(i2)).intValue();
                i += zzdj.zzy((intValue >> 31) ^ (intValue + intValue));
                i2++;
            }
        }
        return i;
    }

    static int zzr(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzs(list) + (size * zzdj.zzy(i << 3));
    }

    static int zzs(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfd) {
            zzfd zzfdVar = (zzfd) list;
            i = 0;
            while (i2 < size) {
                long zze2 = zzfdVar.zze(i2);
                i += zzdj.zzz((zze2 >> 63) ^ (zze2 + zze2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                long longValue = ((Long) list.get(i2)).longValue();
                i += zzdj.zzz((longValue >> 63) ^ (longValue + longValue));
                i2++;
            }
        }
        return i;
    }

    static int zzt(int i, List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int i3 = zzdj.zzb;
        boolean z = list instanceof zzew;
        int zzy = zzdj.zzy(i << 3) * size;
        if (z) {
            zzew zzewVar = (zzew) list;
            while (i2 < size) {
                Object zzf = zzewVar.zzf(i2);
                if (zzf instanceof zzdb) {
                    int zzd2 = ((zzdb) zzf).zzd();
                    zzy += zzdj.zzy(zzd2) + zzd2;
                } else {
                    zzy += zzdj.zzx((String) zzf);
                }
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof zzdb) {
                    int zzd3 = ((zzdb) obj).zzd();
                    zzy += zzdj.zzy(zzd3) + zzd3;
                } else {
                    zzy += zzdj.zzx((String) obj);
                }
                i2++;
            }
        }
        return zzy;
    }

    static int zzu(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzv(list) + (size * zzdj.zzy(i << 3));
    }

    static int zzv(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzee) {
            zzee zzeeVar = (zzee) list;
            i = 0;
            while (i2 < size) {
                i += zzdj.zzy(zzeeVar.zze(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzdj.zzy(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzw(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzx(list) + (size * zzdj.zzy(i << 3));
    }

    static int zzx(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfd) {
            zzfd zzfdVar = (zzfd) list;
            i = 0;
            while (i2 < size) {
                i += zzdj.zzz(zzfdVar.zze(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzdj.zzz(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    public static zzgy zzy() {
        return zzc;
    }

    public static zzgy zzz() {
        return zzd;
    }
}
