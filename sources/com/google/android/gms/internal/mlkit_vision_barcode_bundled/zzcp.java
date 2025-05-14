package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import org.tensorflow.lite.schema.BuiltinOptions;

/* compiled from: com.google.mlkit:barcode-scanning@@17.1.0 */
/* loaded from: classes3.dex */
final class zzcp {
    static int zza(byte[] bArr, int i, zzco zzcoVar) throws zzeo {
        int zzj = zzj(bArr, i, zzcoVar);
        int i2 = zzcoVar.zza;
        if (i2 < 0) {
            throw zzeo.zzd();
        }
        if (i2 > bArr.length - zzj) {
            throw zzeo.zzg();
        }
        if (i2 == 0) {
            zzcoVar.zzc = zzdb.zzb;
            return zzj;
        }
        zzcoVar.zzc = zzdb.zzr(bArr, zzj, i2);
        return zzj + i2;
    }

    static int zzb(byte[] bArr, int i) {
        int i2 = bArr[i] & UByte.MAX_VALUE;
        int i3 = bArr[i + 1] & UByte.MAX_VALUE;
        int i4 = bArr[i + 2] & UByte.MAX_VALUE;
        return ((bArr[i + 3] & UByte.MAX_VALUE) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    static int zzc(zzgh zzghVar, byte[] bArr, int i, int i2, int i3, zzco zzcoVar) throws IOException {
        Object zze = zzghVar.zze();
        int zzn = zzn(zze, zzghVar, bArr, i, i2, i3, zzcoVar);
        zzghVar.zzf(zze);
        zzcoVar.zzc = zze;
        return zzn;
    }

    static int zzd(zzgh zzghVar, byte[] bArr, int i, int i2, zzco zzcoVar) throws IOException {
        Object zze = zzghVar.zze();
        int zzo = zzo(zze, zzghVar, bArr, i, i2, zzcoVar);
        zzghVar.zzf(zze);
        zzcoVar.zzc = zze;
        return zzo;
    }

    static int zze(zzgh zzghVar, int i, byte[] bArr, int i2, int i3, zzel zzelVar, zzco zzcoVar) throws IOException {
        int zzd = zzd(zzghVar, bArr, i2, i3, zzcoVar);
        zzelVar.add(zzcoVar.zzc);
        while (zzd < i3) {
            int zzj = zzj(bArr, zzd, zzcoVar);
            if (i != zzcoVar.zza) {
                break;
            }
            zzd = zzd(zzghVar, bArr, zzj, i3, zzcoVar);
            zzelVar.add(zzcoVar.zzc);
        }
        return zzd;
    }

    static int zzf(byte[] bArr, int i, zzel zzelVar, zzco zzcoVar) throws IOException {
        zzee zzeeVar = (zzee) zzelVar;
        int zzj = zzj(bArr, i, zzcoVar);
        int i2 = zzcoVar.zza + zzj;
        while (zzj < i2) {
            zzj = zzj(bArr, zzj, zzcoVar);
            zzeeVar.zzg(zzcoVar.zza);
        }
        if (zzj == i2) {
            return zzj;
        }
        throw zzeo.zzg();
    }

    static int zzg(byte[] bArr, int i, zzco zzcoVar) throws zzeo {
        int zzj = zzj(bArr, i, zzcoVar);
        int i2 = zzcoVar.zza;
        if (i2 < 0) {
            throw zzeo.zzd();
        }
        if (i2 == 0) {
            zzcoVar.zzc = "";
            return zzj;
        }
        zzcoVar.zzc = new String(bArr, zzj, i2, zzem.zzb);
        return zzj + i2;
    }

    static int zzh(byte[] bArr, int i, zzco zzcoVar) throws zzeo {
        int zzj = zzj(bArr, i, zzcoVar);
        int i2 = zzcoVar.zza;
        if (i2 < 0) {
            throw zzeo.zzd();
        }
        if (i2 == 0) {
            zzcoVar.zzc = "";
            return zzj;
        }
        int length = bArr.length;
        int i3 = zzhn.zza;
        if ((zzj | i2 | ((length - zzj) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(zzj), Integer.valueOf(i2)));
        }
        int i4 = zzj + i2;
        char[] cArr = new char[i2];
        int i5 = 0;
        while (zzj < i4) {
            byte b = bArr[zzj];
            if (!zzhj.zzd(b)) {
                break;
            }
            zzj++;
            cArr[i5] = (char) b;
            i5++;
        }
        int i6 = i5;
        while (zzj < i4) {
            int i7 = zzj + 1;
            byte b2 = bArr[zzj];
            if (zzhj.zzd(b2)) {
                int i8 = i6 + 1;
                cArr[i6] = (char) b2;
                zzj = i7;
                while (true) {
                    i6 = i8;
                    if (zzj < i4) {
                        byte b3 = bArr[zzj];
                        if (zzhj.zzd(b3)) {
                            zzj++;
                            i8 = i6 + 1;
                            cArr[i6] = (char) b3;
                        }
                    }
                }
            } else if (b2 < -32) {
                if (i7 >= i4) {
                    throw zzeo.zzc();
                }
                zzhj.zzc(b2, bArr[i7], cArr, i6);
                zzj = i7 + 1;
                i6++;
            } else if (b2 < -16) {
                if (i7 >= i4 - 1) {
                    throw zzeo.zzc();
                }
                int i9 = i7 + 1;
                zzhj.zzb(b2, bArr[i7], bArr[i9], cArr, i6);
                zzj = i9 + 1;
                i6++;
            } else {
                if (i7 >= i4 - 2) {
                    throw zzeo.zzc();
                }
                int i10 = i7 + 1;
                byte b4 = bArr[i7];
                int i11 = i10 + 1;
                zzhj.zza(b2, b4, bArr[i10], bArr[i11], cArr, i6);
                i6 += 2;
                zzj = i11 + 1;
            }
        }
        zzcoVar.zzc = new String(cArr, 0, i6);
        return i4;
    }

    static int zzi(int i, byte[] bArr, int i2, int i3, zzgz zzgzVar, zzco zzcoVar) throws zzeo {
        if ((i >>> 3) == 0) {
            throw zzeo.zzb();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int zzm = zzm(bArr, i2, zzcoVar);
            zzgzVar.zzj(i, Long.valueOf(zzcoVar.zzb));
            return zzm;
        }
        if (i4 == 1) {
            zzgzVar.zzj(i, Long.valueOf(zzq(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int zzj = zzj(bArr, i2, zzcoVar);
            int i5 = zzcoVar.zza;
            if (i5 < 0) {
                throw zzeo.zzd();
            }
            if (i5 > bArr.length - zzj) {
                throw zzeo.zzg();
            }
            if (i5 == 0) {
                zzgzVar.zzj(i, zzdb.zzb);
            } else {
                zzgzVar.zzj(i, zzdb.zzr(bArr, zzj, i5));
            }
            return zzj + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw zzeo.zzb();
            }
            zzgzVar.zzj(i, Integer.valueOf(zzb(bArr, i2)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        zzgz zzf = zzgz.zzf();
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int zzj2 = zzj(bArr, i2, zzcoVar);
            int i8 = zzcoVar.zza;
            i7 = i8;
            if (i8 == i6) {
                i2 = zzj2;
                break;
            }
            int zzi = zzi(i7, bArr, zzj2, i3, zzf, zzcoVar);
            i7 = i8;
            i2 = zzi;
        }
        if (i2 > i3 || i7 != i6) {
            throw zzeo.zze();
        }
        zzgzVar.zzj(i, zzf);
        return i2;
    }

    static int zzj(byte[] bArr, int i, zzco zzcoVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzk(b, bArr, i2, zzcoVar);
        }
        zzcoVar.zza = b;
        return i2;
    }

    static int zzk(int i, byte[] bArr, int i2, zzco zzcoVar) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            zzcoVar.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & ByteCompanionObject.MAX_VALUE) << 7);
        int i6 = i3 + 1;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzcoVar.zza = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & ByteCompanionObject.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzcoVar.zza = i7 | (b3 << BuiltinOptions.MulOptions);
            return i8;
        }
        int i9 = i7 | ((b3 & ByteCompanionObject.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzcoVar.zza = i9 | (b4 << BuiltinOptions.SubOptions);
            return i10;
        }
        int i11 = i9 | ((b4 & ByteCompanionObject.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzcoVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zzl(int i, byte[] bArr, int i2, int i3, zzel zzelVar, zzco zzcoVar) {
        zzee zzeeVar = (zzee) zzelVar;
        int zzj = zzj(bArr, i2, zzcoVar);
        zzeeVar.zzg(zzcoVar.zza);
        while (zzj < i3) {
            int zzj2 = zzj(bArr, zzj, zzcoVar);
            if (i != zzcoVar.zza) {
                break;
            }
            zzj = zzj(bArr, zzj2, zzcoVar);
            zzeeVar.zzg(zzcoVar.zza);
        }
        return zzj;
    }

    static int zzm(byte[] bArr, int i, zzco zzcoVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzcoVar.zzb = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b = bArr[i2];
        long j2 = (j & 127) | ((b & ByteCompanionObject.MAX_VALUE) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= (b2 & ByteCompanionObject.MAX_VALUE) << i4;
            i3 = i5;
            b = b2;
        }
        zzcoVar.zzb = j2;
        return i3;
    }

    static int zzn(Object obj, zzgh zzghVar, byte[] bArr, int i, int i2, int i3, zzco zzcoVar) throws IOException {
        int zzc = ((zzfr) zzghVar).zzc(obj, bArr, i, i2, i3, zzcoVar);
        zzcoVar.zzc = obj;
        return zzc;
    }

    static int zzo(Object obj, zzgh zzghVar, byte[] bArr, int i, int i2, zzco zzcoVar) throws IOException {
        int i3 = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            i3 = zzk(i4, bArr, i3, zzcoVar);
            i4 = zzcoVar.zza;
        }
        int i5 = i3;
        if (i4 < 0 || i4 > i2 - i5) {
            throw zzeo.zzg();
        }
        int i6 = i4 + i5;
        zzghVar.zzh(obj, bArr, i5, i6, zzcoVar);
        zzcoVar.zzc = obj;
        return i6;
    }

    static long zzq(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48) | ((bArr[i + 7] & 255) << 56);
    }

    static int zzp(int i, byte[] bArr, int i2, int i3, zzco zzcoVar) throws zzeo {
        if ((i >>> 3) == 0) {
            throw zzeo.zzb();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return zzm(bArr, i2, zzcoVar);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return zzj(bArr, i2, zzcoVar) + zzcoVar.zza;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw zzeo.zzb();
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = zzj(bArr, i2, zzcoVar);
            i6 = zzcoVar.zza;
            if (i6 == i5) {
                break;
            }
            i2 = zzp(i6, bArr, i2, i3, zzcoVar);
        }
        if (i2 > i3 || i6 != i5) {
            throw zzeo.zze();
        }
        return i2;
    }
}
