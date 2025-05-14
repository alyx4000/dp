package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.2.0 */
/* loaded from: classes3.dex */
final class zzhl implements ObjectEncoder {
    static final zzhl zza = new zzhl();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;
    private static final FieldDescriptor zzg;
    private static final FieldDescriptor zzh;
    private static final FieldDescriptor zzi;
    private static final FieldDescriptor zzj;
    private static final FieldDescriptor zzk;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("sdkVersion");
        zzdg zzdgVar = new zzdg();
        zzdgVar.zza(1);
        zzb = builder.withProperty(zzdgVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("osBuild");
        zzdg zzdgVar2 = new zzdg();
        zzdgVar2.zza(2);
        zzc = builder2.withProperty(zzdgVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("brand");
        zzdg zzdgVar3 = new zzdg();
        zzdgVar3.zza(3);
        zzd = builder3.withProperty(zzdgVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("device");
        zzdg zzdgVar4 = new zzdg();
        zzdgVar4.zza(4);
        zze = builder4.withProperty(zzdgVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("hardware");
        zzdg zzdgVar5 = new zzdg();
        zzdgVar5.zza(5);
        zzf = builder5.withProperty(zzdgVar5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("manufacturer");
        zzdg zzdgVar6 = new zzdg();
        zzdgVar6.zza(6);
        zzg = builder6.withProperty(zzdgVar6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("model");
        zzdg zzdgVar7 = new zzdg();
        zzdgVar7.zza(7);
        zzh = builder7.withProperty(zzdgVar7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("product");
        zzdg zzdgVar8 = new zzdg();
        zzdgVar8.zza(8);
        zzi = builder8.withProperty(zzdgVar8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("soc");
        zzdg zzdgVar9 = new zzdg();
        zzdgVar9.zza(9);
        zzj = builder9.withProperty(zzdgVar9.zzb()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("socMetaBuildId");
        zzdg zzdgVar10 = new zzdg();
        zzdgVar10.zza(10);
        zzk = builder10.withProperty(zzdgVar10.zzb()).build();
    }

    private zzhl() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
