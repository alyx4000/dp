package com.google.mlkit.vision.barcode.internal;

import android.os.SystemClock;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_vision_barcode.zzca;
import com.google.android.gms.internal.mlkit_vision_barcode.zzdw;
import com.google.android.gms.internal.mlkit_vision_barcode.zzdx;
import com.google.android.gms.internal.mlkit_vision_barcode.zzdz;
import com.google.android.gms.internal.mlkit_vision_barcode.zzmj;
import com.google.android.gms.internal.mlkit_vision_barcode.zzmn;
import com.google.android.gms.internal.mlkit_vision_barcode.zzmo;
import com.google.android.gms.internal.mlkit_vision_barcode.zzmu;
import com.google.android.gms.internal.mlkit_vision_barcode.zznc;
import com.google.android.gms.internal.mlkit_vision_barcode.zznd;
import com.google.android.gms.internal.mlkit_vision_barcode.zzne;
import com.google.android.gms.internal.mlkit_vision_barcode.zznf;
import com.google.android.gms.internal.mlkit_vision_barcode.zznr;
import com.google.android.gms.internal.mlkit_vision_barcode.zzra;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrk;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrl;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrn;
import com.google.android.gms.internal.mlkit_vision_barcode.zzro;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MLTask;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.BitmapInStreamingChecker;
import com.google.mlkit.vision.common.internal.ImageUtils;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.2.0 */
/* loaded from: classes5.dex */
public final class zzi extends MLTask {
    private final BarcodeScannerOptions zzc;
    private final zzj zzd;
    private final zzrl zze;
    private final zzrn zzf;
    private final BitmapInStreamingChecker zzg = new BitmapInStreamingChecker();
    private boolean zzh;
    private static final ImageUtils zzb = ImageUtils.getInstance();
    static boolean zza = true;

    public zzi(MlKitContext mlKitContext, BarcodeScannerOptions barcodeScannerOptions, zzj zzjVar, zzrl zzrlVar) {
        Preconditions.checkNotNull(mlKitContext, "MlKitContext can not be null");
        Preconditions.checkNotNull(barcodeScannerOptions, "BarcodeScannerOptions can not be null");
        this.zzc = barcodeScannerOptions;
        this.zzd = zzjVar;
        this.zze = zzrlVar;
        this.zzf = zzrn.zza(mlKitContext.getApplicationContext());
    }

    private final void zzf(final zznd zzndVar, long j, final InputImage inputImage, List list) {
        final zzca zzcaVar = new zzca();
        final zzca zzcaVar2 = new zzca();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Barcode barcode = (Barcode) it.next();
                zzcaVar.zzd(zzb.zza(barcode.getFormat()));
                zzcaVar2.zzd(zzb.zzb(barcode.getValueType()));
            }
        }
        final long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        this.zze.zzf(new zzrk() { // from class: com.google.mlkit.vision.barcode.internal.zzg
            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzrk
            public final zzra zza() {
                return zzi.this.zzc(elapsedRealtime, zzndVar, zzcaVar, zzcaVar2, inputImage);
            }
        }, zzne.ON_DEVICE_BARCODE_DETECT);
        zzdx zzdxVar = new zzdx();
        zzdxVar.zze(zzndVar);
        zzdxVar.zzf(Boolean.valueOf(zza));
        zzdxVar.zzg(zzb.zzc(this.zzc));
        zzdxVar.zzc(zzcaVar.zzf());
        zzdxVar.zzd(zzcaVar2.zzf());
        final zzdz zzh = zzdxVar.zzh();
        final zzh zzhVar = new zzh(this);
        final zzrl zzrlVar = this.zze;
        final zzne zzneVar = zzne.AGGREGATED_ON_DEVICE_BARCODE_DETECTION;
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable() { // from class: com.google.android.gms.internal.mlkit_vision_barcode.zzri
            @Override // java.lang.Runnable
            public final void run() {
                zzrl.this.zzh(zzneVar, zzh, elapsedRealtime, zzhVar);
            }
        });
        long currentTimeMillis = System.currentTimeMillis();
        this.zzf.zzc(true != this.zzh ? 24301 : 24302, zzndVar.zza(), currentTimeMillis - elapsedRealtime, currentTimeMillis);
    }

    @Override // com.google.mlkit.common.sdkinternal.ModelResource
    public final synchronized void load() throws MlKitException {
        this.zzh = this.zzd.zzc();
    }

    @Override // com.google.mlkit.common.sdkinternal.ModelResource
    public final synchronized void release() {
        this.zzd.zzb();
        zza = true;
        zzrl zzrlVar = this.zze;
        zznf zznfVar = new zznf();
        zznfVar.zze(this.zzh ? zznc.TYPE_THICK : zznc.TYPE_THIN);
        zznr zznrVar = new zznr();
        zznrVar.zzi(zzb.zzc(this.zzc));
        zznfVar.zzg(zznrVar.zzj());
        zzrlVar.zzd(zzro.zzf(zznfVar), zzne.ON_DEVICE_BARCODE_CLOSE);
    }

    final /* synthetic */ zzra zzc(long j, zznd zzndVar, zzca zzcaVar, zzca zzcaVar2, InputImage inputImage) {
        zznr zznrVar = new zznr();
        zzmu zzmuVar = new zzmu();
        zzmuVar.zzc(Long.valueOf(j));
        zzmuVar.zzd(zzndVar);
        zzmuVar.zze(Boolean.valueOf(zza));
        zzmuVar.zza(true);
        zzmuVar.zzb(true);
        zznrVar.zzh(zzmuVar.zzf());
        zznrVar.zzi(zzb.zzc(this.zzc));
        zznrVar.zze(zzcaVar.zzf());
        zznrVar.zzf(zzcaVar2.zzf());
        int format = inputImage.getFormat();
        int mobileVisionImageSize = zzb.getMobileVisionImageSize(inputImage);
        zzmn zzmnVar = new zzmn();
        zzmnVar.zza(format != -1 ? format != 35 ? format != 842094169 ? format != 16 ? format != 17 ? zzmo.UNKNOWN_FORMAT : zzmo.NV21 : zzmo.NV16 : zzmo.YV12 : zzmo.YUV_420_888 : zzmo.BITMAP);
        zzmnVar.zzb(Integer.valueOf(mobileVisionImageSize));
        zznrVar.zzg(zzmnVar.zzd());
        zznf zznfVar = new zznf();
        zznfVar.zze(this.zzh ? zznc.TYPE_THICK : zznc.TYPE_THIN);
        zznfVar.zzg(zznrVar.zzj());
        return zzro.zzf(zznfVar);
    }

    final /* synthetic */ zzra zzd(zzdz zzdzVar, int i, zzmj zzmjVar) {
        zznf zznfVar = new zznf();
        zznfVar.zze(this.zzh ? zznc.TYPE_THICK : zznc.TYPE_THIN);
        zzdw zzdwVar = new zzdw();
        zzdwVar.zza(Integer.valueOf(i));
        zzdwVar.zzc(zzdzVar);
        zzdwVar.zzb(zzmjVar);
        zznfVar.zzd(zzdwVar.zze());
        return zzro.zzf(zznfVar);
    }

    @Override // com.google.mlkit.common.sdkinternal.MLTask
    /* renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final synchronized List run(InputImage inputImage) throws MlKitException {
        List zza2;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.zzg.check(inputImage);
        try {
            zza2 = this.zzd.zza(inputImage);
            zzf(zznd.NO_ERROR, elapsedRealtime, inputImage, zza2);
            zza = false;
        } catch (MlKitException e) {
            zzf(e.getErrorCode() == 14 ? zznd.MODEL_NOT_DOWNLOADED : zznd.UNKNOWN_ERROR, elapsedRealtime, inputImage, null);
            throw e;
        }
        return zza2;
    }
}
