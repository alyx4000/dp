package com.google.android.gms.internal.mlkit_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.mlkit:common@@18.8.0 */
/* loaded from: classes3.dex */
final class zzfq implements ObjectEncoder {
    static final zzfq zza = new zzfq();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;
    private static final FieldDescriptor zzg;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("maxMs");
        zzbk zzbkVar = new zzbk();
        zzbkVar.zza(1);
        zzb = builder.withProperty(zzbkVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("minMs");
        zzbk zzbkVar2 = new zzbk();
        zzbkVar2.zza(2);
        zzc = builder2.withProperty(zzbkVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("avgMs");
        zzbk zzbkVar3 = new zzbk();
        zzbkVar3.zza(3);
        zzd = builder3.withProperty(zzbkVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("firstQuartileMs");
        zzbk zzbkVar4 = new zzbk();
        zzbkVar4.zza(4);
        zze = builder4.withProperty(zzbkVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("medianMs");
        zzbk zzbkVar5 = new zzbk();
        zzbkVar5.zza(5);
        zzf = builder5.withProperty(zzbkVar5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("thirdQuartileMs");
        zzbk zzbkVar6 = new zzbk();
        zzbkVar6.zza(6);
        zzg = builder6.withProperty(zzbkVar6.zzb()).build();
    }

    private zzfq() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
