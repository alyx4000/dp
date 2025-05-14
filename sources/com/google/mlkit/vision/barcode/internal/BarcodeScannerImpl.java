package com.google.mlkit.vision.barcode.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.internal.mlkit_vision_barcode.zznc;
import com.google.android.gms.internal.mlkit_vision_barcode.zzne;
import com.google.android.gms.internal.mlkit_vision_barcode.zznf;
import com.google.android.gms.internal.mlkit_vision_barcode.zznr;
import com.google.android.gms.internal.mlkit_vision_barcode.zznt;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrl;
import com.google.android.gms.internal.mlkit_vision_barcode.zzro;
import com.google.android.gms.tasks.Task;
import com.google.android.odml.image.MlImage;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.MobileVisionBase;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.2.0 */
/* loaded from: classes5.dex */
public class BarcodeScannerImpl extends MobileVisionBase<List<Barcode>> implements BarcodeScanner {
    private static final BarcodeScannerOptions zzb = new BarcodeScannerOptions.Builder().build();
    private final boolean zzc;

    BarcodeScannerImpl(BarcodeScannerOptions barcodeScannerOptions, zzi zziVar, Executor executor, zzrl zzrlVar) {
        super(zziVar, executor);
        boolean zzf = zzb.zzf();
        this.zzc = zzf;
        zznr zznrVar = new zznr();
        zznrVar.zzi(zzb.zzc(barcodeScannerOptions));
        zznt zzj = zznrVar.zzj();
        zznf zznfVar = new zznf();
        zznfVar.zze(zzf ? zznc.TYPE_THICK : zznc.TYPE_THIN);
        zznfVar.zzg(zzj);
        zzrlVar.zzd(zzro.zzg(zznfVar, 1), zzne.ON_DEVICE_BARCODE_CREATE);
    }

    @Override // com.google.mlkit.vision.interfaces.Detector
    public final int getDetectorType() {
        return 1;
    }

    @Override // com.google.android.gms.common.api.OptionalModuleApi
    public final Feature[] getOptionalFeatures() {
        return this.zzc ? OptionalModuleUtils.EMPTY_FEATURES : new Feature[]{OptionalModuleUtils.FEATURE_BARCODE};
    }

    @Override // com.google.mlkit.vision.barcode.BarcodeScanner
    public final Task<List<Barcode>> process(MlImage mlImage) {
        return super.processBase(mlImage);
    }

    @Override // com.google.mlkit.vision.barcode.BarcodeScanner
    public final Task<List<Barcode>> process(InputImage inputImage) {
        return super.processBase(inputImage);
    }
}
