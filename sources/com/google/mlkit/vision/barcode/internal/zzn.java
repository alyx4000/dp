package com.google.mlkit.vision.barcode.internal;

import android.content.Context;
import android.media.Image;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.mlkit_vision_barcode.zzad;
import com.google.android.gms.internal.mlkit_vision_barcode.zzaf;
import com.google.android.gms.internal.mlkit_vision_barcode.zzah;
import com.google.android.gms.internal.mlkit_vision_barcode.zzaj;
import com.google.android.gms.internal.mlkit_vision_barcode.zznd;
import com.google.android.gms.internal.mlkit_vision_barcode.zzq;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrl;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.CommonConvertUtils;
import com.google.mlkit.vision.common.internal.ImageConvertUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.2.0 */
/* loaded from: classes5.dex */
final class zzn implements zzj {
    private boolean zza;
    private final Context zzb;
    private final zzad zzc;
    private final zzrl zzd;
    private zzaf zze;

    zzn(Context context, BarcodeScannerOptions barcodeScannerOptions, zzrl zzrlVar) {
        zzad zzadVar = new zzad();
        this.zzc = zzadVar;
        this.zzb = context;
        zzadVar.zza = barcodeScannerOptions.zza();
        this.zzd = zzrlVar;
    }

    @Override // com.google.mlkit.vision.barcode.internal.zzj
    public final List zza(InputImage inputImage) throws MlKitException {
        zzq[] zzf;
        if (this.zze == null) {
            zzc();
        }
        zzaf zzafVar = this.zze;
        if (zzafVar == null) {
            throw new MlKitException("Error initializing the legacy barcode scanner.", 14);
        }
        zzaf zzafVar2 = (zzaf) Preconditions.checkNotNull(zzafVar);
        zzaj zzajVar = new zzaj(inputImage.getWidth(), inputImage.getHeight(), 0, 0L, CommonConvertUtils.convertToMVRotation(inputImage.getRotationDegrees()));
        try {
            int format = inputImage.getFormat();
            if (format == -1) {
                zzf = zzafVar2.zzf(ObjectWrapper.wrap(inputImage.getBitmapInternal()), zzajVar);
            } else if (format == 17) {
                zzf = zzafVar2.zze(ObjectWrapper.wrap(inputImage.getByteBuffer()), zzajVar);
            } else if (format == 35) {
                Image.Plane[] planeArr = (Image.Plane[]) Preconditions.checkNotNull(inputImage.getPlanes());
                zzajVar.zza = planeArr[0].getRowStride();
                zzf = zzafVar2.zze(ObjectWrapper.wrap(planeArr[0].getBuffer()), zzajVar);
            } else {
                if (format != 842094169) {
                    throw new MlKitException("Unsupported image format: " + inputImage.getFormat(), 3);
                }
                zzf = zzafVar2.zze(ObjectWrapper.wrap(ImageConvertUtils.getInstance().convertToNv21Buffer(inputImage, false)), zzajVar);
            }
            ArrayList arrayList = new ArrayList();
            for (zzq zzqVar : zzf) {
                arrayList.add(new Barcode(new zzm(zzqVar), inputImage.getCoordinatesMatrix()));
            }
            return arrayList;
        } catch (RemoteException e) {
            throw new MlKitException("Failed to detect with legacy barcode detector", 13, e);
        }
    }

    @Override // com.google.mlkit.vision.barcode.internal.zzj
    public final void zzb() {
        zzaf zzafVar = this.zze;
        if (zzafVar != null) {
            try {
                zzafVar.zzd();
            } catch (RemoteException e) {
                Log.e("LegacyBarcodeScanner", "Failed to release legacy barcode detector.", e);
            }
            this.zze = null;
        }
    }

    @Override // com.google.mlkit.vision.barcode.internal.zzj
    public final boolean zzc() throws MlKitException {
        if (this.zze != null) {
            return false;
        }
        try {
            zzaf zzd = zzah.zza(DynamiteModule.load(this.zzb, DynamiteModule.PREFER_REMOTE, OptionalModuleUtils.DEPRECATED_DYNAMITE_MODULE_ID).instantiate("com.google.android.gms.vision.barcode.ChimeraNativeBarcodeDetectorCreator")).zzd(ObjectWrapper.wrap(this.zzb), this.zzc);
            this.zze = zzd;
            if (zzd == null && !this.zza) {
                Log.d("LegacyBarcodeScanner", "Request optional module download.");
                OptionalModuleUtils.requestDownload(this.zzb, "barcode");
                this.zza = true;
                zzb.zze(this.zzd, zznd.OPTIONAL_MODULE_NOT_AVAILABLE);
                throw new MlKitException("Waiting for the barcode module to be downloaded. Please wait.", 14);
            }
            zzb.zze(this.zzd, zznd.NO_ERROR);
            return false;
        } catch (RemoteException e) {
            throw new MlKitException("Failed to create legacy barcode detector.", 13, e);
        } catch (DynamiteModule.LoadingException e2) {
            throw new MlKitException("Failed to load deprecated vision dynamite module.", 13, e2);
        }
    }
}
