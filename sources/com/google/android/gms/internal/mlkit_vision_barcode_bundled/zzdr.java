package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* compiled from: com.google.mlkit:barcode-scanning@@17.1.0 */
/* loaded from: classes3.dex */
final class zzdr {
    private static final zzdp zza = new zzdq();
    private static final zzdp zzb;

    static {
        zzdp zzdpVar;
        try {
            zzdpVar = (zzdp) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzdpVar = null;
        }
        zzb = zzdpVar;
    }

    static zzdp zza() {
        zzdp zzdpVar = zzb;
        if (zzdpVar != null) {
            return zzdpVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static zzdp zzb() {
        return zza;
    }
}
