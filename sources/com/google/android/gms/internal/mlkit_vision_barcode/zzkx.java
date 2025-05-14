package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.2.0 */
/* loaded from: classes3.dex */
final class zzkx implements ObjectEncoder {
    static final zzkx zza = new zzkx();
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
    private static final FieldDescriptor zzl;
    private static final FieldDescriptor zzm;
    private static final FieldDescriptor zzn;
    private static final FieldDescriptor zzo;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder(RemoteConfigConstants.RequestFieldKey.APP_ID);
        zzdg zzdgVar = new zzdg();
        zzdgVar.zza(1);
        zzb = builder.withProperty(zzdgVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("appVersion");
        zzdg zzdgVar2 = new zzdg();
        zzdgVar2.zza(2);
        zzc = builder2.withProperty(zzdgVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("firebaseProjectId");
        zzdg zzdgVar3 = new zzdg();
        zzdgVar3.zza(3);
        zzd = builder3.withProperty(zzdgVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("mlSdkVersion");
        zzdg zzdgVar4 = new zzdg();
        zzdgVar4.zza(4);
        zze = builder4.withProperty(zzdgVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("tfliteSchemaVersion");
        zzdg zzdgVar5 = new zzdg();
        zzdgVar5.zza(5);
        zzf = builder5.withProperty(zzdgVar5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("gcmSenderId");
        zzdg zzdgVar6 = new zzdg();
        zzdgVar6.zza(6);
        zzg = builder6.withProperty(zzdgVar6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("apiKey");
        zzdg zzdgVar7 = new zzdg();
        zzdgVar7.zza(7);
        zzh = builder7.withProperty(zzdgVar7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("languages");
        zzdg zzdgVar8 = new zzdg();
        zzdgVar8.zza(8);
        zzi = builder8.withProperty(zzdgVar8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("mlSdkInstanceId");
        zzdg zzdgVar9 = new zzdg();
        zzdgVar9.zza(9);
        zzj = builder9.withProperty(zzdgVar9.zzb()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("isClearcutClient");
        zzdg zzdgVar10 = new zzdg();
        zzdgVar10.zza(10);
        zzk = builder10.withProperty(zzdgVar10.zzb()).build();
        FieldDescriptor.Builder builder11 = FieldDescriptor.builder("isStandaloneMlkit");
        zzdg zzdgVar11 = new zzdg();
        zzdgVar11.zza(11);
        zzl = builder11.withProperty(zzdgVar11.zzb()).build();
        FieldDescriptor.Builder builder12 = FieldDescriptor.builder("isJsonLogging");
        zzdg zzdgVar12 = new zzdg();
        zzdgVar12.zza(12);
        zzm = builder12.withProperty(zzdgVar12.zzb()).build();
        FieldDescriptor.Builder builder13 = FieldDescriptor.builder("buildLevel");
        zzdg zzdgVar13 = new zzdg();
        zzdgVar13.zza(13);
        zzn = builder13.withProperty(zzdgVar13.zzb()).build();
        FieldDescriptor.Builder builder14 = FieldDescriptor.builder("optionalModuleVersion");
        zzdg zzdgVar14 = new zzdg();
        zzdgVar14.zza(14);
        zzo = builder14.withProperty(zzdgVar14.zzb()).build();
    }

    private zzkx() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zzpz zzpzVar = (zzpz) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(zzb, zzpzVar.zzg());
        objectEncoderContext2.add(zzc, zzpzVar.zzh());
        objectEncoderContext2.add(zzd, (Object) null);
        objectEncoderContext2.add(zze, zzpzVar.zzj());
        objectEncoderContext2.add(zzf, zzpzVar.zzk());
        objectEncoderContext2.add(zzg, (Object) null);
        objectEncoderContext2.add(zzh, (Object) null);
        objectEncoderContext2.add(zzi, zzpzVar.zza());
        objectEncoderContext2.add(zzj, zzpzVar.zzi());
        objectEncoderContext2.add(zzk, zzpzVar.zzb());
        objectEncoderContext2.add(zzl, zzpzVar.zzd());
        objectEncoderContext2.add(zzm, zzpzVar.zzc());
        objectEncoderContext2.add(zzn, zzpzVar.zze());
        objectEncoderContext2.add(zzo, zzpzVar.zzf());
    }
}
