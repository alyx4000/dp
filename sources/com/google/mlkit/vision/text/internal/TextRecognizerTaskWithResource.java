package com.google.mlkit.vision.text.internal;

import android.os.SystemClock;
import com.google.android.gms.internal.mlkit_vision_text_common.zzem;
import com.google.android.gms.internal.mlkit_vision_text_common.zzen;
import com.google.android.gms.internal.mlkit_vision_text_common.zzep;
import com.google.android.gms.internal.mlkit_vision_text_common.zzmb;
import com.google.android.gms.internal.mlkit_vision_text_common.zzmf;
import com.google.android.gms.internal.mlkit_vision_text_common.zzmg;
import com.google.android.gms.internal.mlkit_vision_text_common.zzmm;
import com.google.android.gms.internal.mlkit_vision_text_common.zzmu;
import com.google.android.gms.internal.mlkit_vision_text_common.zzmv;
import com.google.android.gms.internal.mlkit_vision_text_common.zzmw;
import com.google.android.gms.internal.mlkit_vision_text_common.zzmx;
import com.google.android.gms.internal.mlkit_vision_text_common.zzpe;
import com.google.android.gms.internal.mlkit_vision_text_common.zzpg;
import com.google.android.gms.internal.mlkit_vision_text_common.zzph;
import com.google.android.gms.internal.mlkit_vision_text_common.zzqs;
import com.google.android.gms.internal.mlkit_vision_text_common.zzrc;
import com.google.android.gms.internal.mlkit_vision_text_common.zzrd;
import com.google.android.gms.internal.mlkit_vision_text_common.zzrf;
import com.google.android.gms.internal.mlkit_vision_text_common.zzrg;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MLTask;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.TaskQueue;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.ImageUtils;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognizerOptionsInterface;

/* compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.0.0 */
/* loaded from: classes5.dex */
public class TextRecognizerTaskWithResource extends MLTask<Text, InputImage> {
    static boolean zza = true;
    private final zzl zzc;
    private final zzrd zzd;
    private final zzrf zze;
    private final TextRecognizerOptionsInterface zzf;
    private static final ImageUtils zzb = ImageUtils.getInstance();
    private static final TaskQueue taskQueue = new TaskQueue();

    TextRecognizerTaskWithResource(zzrd zzrdVar, zzl zzlVar, TextRecognizerOptionsInterface textRecognizerOptionsInterface) {
        super(taskQueue);
        this.zzd = zzrdVar;
        this.zzc = zzlVar;
        this.zze = zzrf.zza(MlKitContext.getInstance().getApplicationContext());
        this.zzf = textRecognizerOptionsInterface;
    }

    private final void zzf(final zzmv zzmvVar, long j, final InputImage inputImage) {
        final long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        this.zzd.zzf(new zzrc() { // from class: com.google.mlkit.vision.text.internal.zzo
            @Override // com.google.android.gms.internal.mlkit_vision_text_common.zzrc
            public final zzqs zza() {
                return TextRecognizerTaskWithResource.this.zzc(elapsedRealtime, zzmvVar, inputImage);
            }
        }, zzmw.ON_DEVICE_TEXT_DETECT);
        zzen zzenVar = new zzen();
        zzenVar.zza(zzmvVar);
        zzenVar.zzb(Boolean.valueOf(zza));
        zzph zzphVar = new zzph();
        zzphVar.zza(LoggingUtils.zza(this.zzf.getLoggingLanguageOption()));
        zzenVar.zzc(zzphVar.zzc());
        final zzep zzd = zzenVar.zzd();
        final zzp zzpVar = new zzp(this);
        final zzrd zzrdVar = this.zzd;
        final zzmw zzmwVar = zzmw.AGGREGATED_ON_DEVICE_TEXT_DETECTION;
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable() { // from class: com.google.android.gms.internal.mlkit_vision_text_common.zzra
            @Override // java.lang.Runnable
            public final void run() {
                zzrd.this.zzh(zzmwVar, zzd, elapsedRealtime, zzpVar);
            }
        });
        long currentTimeMillis = System.currentTimeMillis();
        this.zze.zzc(this.zzf.getLoggingEventId(), zzmvVar.zza(), currentTimeMillis - elapsedRealtime, currentTimeMillis);
    }

    @Override // com.google.mlkit.common.sdkinternal.ModelResource
    public final synchronized void load() throws MlKitException {
        this.zzc.zzb();
    }

    @Override // com.google.mlkit.common.sdkinternal.ModelResource
    public final synchronized void release() {
        zza = true;
        this.zzc.zzc();
    }

    final /* synthetic */ zzqs zzc(long j, zzmv zzmvVar, InputImage inputImage) {
        zzpe zzpeVar = new zzpe();
        zzmm zzmmVar = new zzmm();
        zzmmVar.zzc(Long.valueOf(j));
        zzmmVar.zzd(zzmvVar);
        zzmmVar.zze(Boolean.valueOf(zza));
        zzmmVar.zza(true);
        zzmmVar.zzb(true);
        zzpeVar.zzd(zzmmVar.zzf());
        ImageUtils imageUtils = zzb;
        int mobileVisionImageFormat = imageUtils.getMobileVisionImageFormat(inputImage);
        int mobileVisionImageSize = imageUtils.getMobileVisionImageSize(inputImage);
        zzmf zzmfVar = new zzmf();
        zzmfVar.zza(mobileVisionImageFormat != -1 ? mobileVisionImageFormat != 35 ? mobileVisionImageFormat != 842094169 ? mobileVisionImageFormat != 16 ? mobileVisionImageFormat != 17 ? zzmg.UNKNOWN_FORMAT : zzmg.NV21 : zzmg.NV16 : zzmg.YV12 : zzmg.YUV_420_888 : zzmg.BITMAP);
        zzmfVar.zzb(Integer.valueOf(mobileVisionImageSize));
        zzpeVar.zzc(zzmfVar.zzd());
        zzph zzphVar = new zzph();
        zzphVar.zza(LoggingUtils.zza(this.zzf.getLoggingLanguageOption()));
        zzpeVar.zze(zzphVar.zzc());
        zzpg zzf = zzpeVar.zzf();
        zzmx zzmxVar = new zzmx();
        zzmxVar.zze(this.zzf.getIsThickClient() ? zzmu.TYPE_THICK : zzmu.TYPE_THIN);
        zzmxVar.zzh(zzf);
        return zzrg.zzf(zzmxVar);
    }

    final /* synthetic */ zzqs zzd(zzep zzepVar, int i, zzmb zzmbVar) {
        zzmx zzmxVar = new zzmx();
        zzmxVar.zze(this.zzf.getIsThickClient() ? zzmu.TYPE_THICK : zzmu.TYPE_THIN);
        zzem zzemVar = new zzem();
        zzemVar.zza(Integer.valueOf(i));
        zzemVar.zzc(zzepVar);
        zzemVar.zzb(zzmbVar);
        zzmxVar.zzd(zzemVar.zze());
        return zzrg.zzf(zzmxVar);
    }

    @Override // com.google.mlkit.common.sdkinternal.MLTask
    /* renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final synchronized Text run(InputImage inputImage) throws MlKitException {
        Text zza2;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            zza2 = this.zzc.zza(inputImage);
            zzf(zzmv.NO_ERROR, elapsedRealtime, inputImage);
            zza = false;
        } catch (MlKitException e) {
            zzf(e.getErrorCode() == 14 ? zzmv.MODEL_NOT_DOWNLOADED : zzmv.UNKNOWN_ERROR, elapsedRealtime, inputImage);
            throw e;
        }
        return zza2;
    }
}
