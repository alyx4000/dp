package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.2.0 */
/* loaded from: classes3.dex */
final class zzjq implements ObjectEncoder {
    static final zzjq zza = new zzjq();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("inferenceCommonLogEvent");
        zzdg zzdgVar = new zzdg();
        zzdgVar.zza(1);
        zzb = builder.withProperty(zzdgVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("options");
        zzdg zzdgVar2 = new zzdg();
        zzdgVar2.zza(2);
        zzc = builder2.withProperty(zzdgVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("imageInfo");
        zzdg zzdgVar3 = new zzdg();
        zzdgVar3.zza(3);
        zzd = builder3.withProperty(zzdgVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("labelCount");
        zzdg zzdgVar4 = new zzdg();
        zzdgVar4.zza(4);
        zze = builder4.withProperty(zzdgVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("highestConfidence");
        zzdg zzdgVar5 = new zzdg();
        zzdgVar5.zza(5);
        zzf = builder5.withProperty(zzdgVar5.zzb()).build();
    }

    private zzjq() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
