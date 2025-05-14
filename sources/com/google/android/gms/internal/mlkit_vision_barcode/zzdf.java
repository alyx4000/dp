package com.google.android.gms.internal.mlkit_vision_barcode;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.2.0 */
/* loaded from: classes3.dex */
final class zzdf implements zzdk {
    private final int zza;
    private final zzdj zzb;

    zzdf(int i, zzdj zzdjVar) {
        this.zza = i;
        this.zzb = zzdjVar;
    }

    @Override // java.lang.annotation.Annotation
    public final Class annotationType() {
        return zzdk.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdk)) {
            return false;
        }
        zzdk zzdkVar = (zzdk) obj;
        return this.zza == zzdkVar.zza() && this.zzb.equals(zzdkVar.zzb());
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return (this.zza ^ 14552422) + (this.zzb.hashCode() ^ 2041407134);
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.zza + "intEncoding=" + this.zzb + ')';
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzdk
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzdk
    public final zzdj zzb() {
        return this.zzb;
    }
}
