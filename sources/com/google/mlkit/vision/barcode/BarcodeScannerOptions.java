package com.google.mlkit.vision.barcode;

import com.google.android.gms.common.internal.Objects;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.2.0 */
/* loaded from: classes5.dex */
public class BarcodeScannerOptions {
    private final int zza;
    private final boolean zzb;
    private final Executor zzc;

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.2.0 */
    public static class Builder {
        private int zza = 0;
        private boolean zzb;
        private Executor zzc;

        public BarcodeScannerOptions build() {
            return new BarcodeScannerOptions(this.zza, this.zzb, this.zzc, null);
        }

        public Builder enableAllPotentialBarcodes() {
            this.zzb = true;
            return this;
        }

        public Builder setBarcodeFormats(int i, int... iArr) {
            this.zza = i;
            if (iArr != null) {
                for (int i2 : iArr) {
                    this.zza = i2 | this.zza;
                }
            }
            return this;
        }

        public Builder setExecutor(Executor executor) {
            this.zzc = executor;
            return this;
        }
    }

    /* synthetic */ BarcodeScannerOptions(int i, boolean z, Executor executor, zza zzaVar) {
        this.zza = i;
        this.zzb = z;
        this.zzc = executor;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BarcodeScannerOptions)) {
            return false;
        }
        BarcodeScannerOptions barcodeScannerOptions = (BarcodeScannerOptions) obj;
        return this.zza == barcodeScannerOptions.zza && this.zzb == barcodeScannerOptions.zzb && Objects.equal(this.zzc, barcodeScannerOptions.zzc);
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Boolean.valueOf(this.zzb), this.zzc);
    }

    public final int zza() {
        return this.zza;
    }

    public final Executor zzb() {
        return this.zzc;
    }

    public final boolean zzc() {
        return this.zzb;
    }
}
