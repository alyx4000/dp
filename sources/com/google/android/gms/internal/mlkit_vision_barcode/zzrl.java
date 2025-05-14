package com.google.android.gms.internal.mlkit_vision_barcode;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.2.0 */
/* loaded from: classes3.dex */
public final class zzrl {
    private static zzcd zza;
    private static final zzcf zzb = zzcf.zzc("optional-module-barcode", OptionalModuleUtils.BARCODE_MODULE_ID);
    private final String zzc;
    private final String zzd;
    private final zzrb zze;
    private final SharedPrefManager zzf;
    private final Task zzg;
    private final Task zzh;
    private final String zzi;
    private final int zzj;
    private final Map zzk = new HashMap();
    private final Map zzl = new HashMap();

    public zzrl(Context context, final SharedPrefManager sharedPrefManager, zzrb zzrbVar, String str) {
        this.zzc = context.getPackageName();
        this.zzd = CommonUtils.getAppVersion(context);
        this.zzf = sharedPrefManager;
        this.zze = zzrbVar;
        zzrx.zza();
        this.zzi = str;
        this.zzg = MLTaskExecutor.getInstance().scheduleCallable(new Callable() { // from class: com.google.android.gms.internal.mlkit_vision_barcode.zzrf
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzrl.this.zzb();
            }
        });
        MLTaskExecutor mLTaskExecutor = MLTaskExecutor.getInstance();
        sharedPrefManager.getClass();
        this.zzh = mLTaskExecutor.scheduleCallable(new Callable() { // from class: com.google.android.gms.internal.mlkit_vision_barcode.zzrg
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SharedPrefManager.this.getMlSdkInstanceId();
            }
        });
        zzcf zzcfVar = zzb;
        this.zzj = zzcfVar.containsKey(str) ? DynamiteModule.getRemoteVersion(context, (String) zzcfVar.get(str)) : -1;
    }

    static long zza(List list, double d) {
        return ((Long) list.get(Math.max(((int) Math.ceil((d / 100.0d) * list.size())) - 1, 0))).longValue();
    }

    private static synchronized zzcd zzi() {
        synchronized (zzrl.class) {
            zzcd zzcdVar = zza;
            if (zzcdVar != null) {
                return zzcdVar;
            }
            LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
            zzca zzcaVar = new zzca();
            for (int i = 0; i < locales.size(); i++) {
                zzcaVar.zzd(CommonUtils.languageTagFromLocale(locales.get(i)));
            }
            zzcd zzf = zzcaVar.zzf();
            zza = zzf;
            return zzf;
        }
    }

    private final String zzj() {
        return this.zzg.isSuccessful() ? (String) this.zzg.getResult() : LibraryVersion.getInstance().getVersion(this.zzi);
    }

    private final boolean zzk(zzne zzneVar, long j, long j2) {
        return this.zzk.get(zzneVar) == null || j - ((Long) this.zzk.get(zzneVar)).longValue() > TimeUnit.SECONDS.toMillis(30L);
    }

    final /* synthetic */ String zzb() throws Exception {
        return LibraryVersion.getInstance().getVersion(this.zzi);
    }

    final /* synthetic */ void zzc(zzra zzraVar, zzne zzneVar, String str) {
        zzraVar.zzb(zzneVar);
        String zzd = zzraVar.zzd();
        zzpx zzpxVar = new zzpx();
        zzpxVar.zzb(this.zzc);
        zzpxVar.zzc(this.zzd);
        zzpxVar.zzh(zzi());
        zzpxVar.zzg(true);
        zzpxVar.zzl(zzd);
        zzpxVar.zzj(str);
        zzpxVar.zzi(this.zzh.isSuccessful() ? (String) this.zzh.getResult() : this.zzf.getMlSdkInstanceId());
        zzpxVar.zzd(10);
        zzpxVar.zzk(Integer.valueOf(this.zzj));
        zzraVar.zzc(zzpxVar);
        this.zze.zza(zzraVar);
    }

    public final void zzd(zzra zzraVar, zzne zzneVar) {
        zze(zzraVar, zzneVar, zzj());
    }

    public final void zze(final zzra zzraVar, final zzne zzneVar, final String str) {
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable() { // from class: com.google.android.gms.internal.mlkit_vision_barcode.zzrh
            @Override // java.lang.Runnable
            public final void run() {
                zzrl.this.zzc(zzraVar, zzneVar, str);
            }
        });
    }

    public final void zzf(zzrk zzrkVar, zzne zzneVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (zzk(zzneVar, elapsedRealtime, 30L)) {
            this.zzk.put(zzneVar, Long.valueOf(elapsedRealtime));
            zze(zzrkVar.zza(), zzneVar, zzj());
        }
    }

    final /* synthetic */ void zzg(zzne zzneVar, com.google.mlkit.vision.barcode.internal.zzh zzhVar) {
        zzci zzciVar = (zzci) this.zzl.get(zzneVar);
        if (zzciVar != null) {
            for (Object obj : zzciVar.zzo()) {
                ArrayList arrayList = new ArrayList(zzciVar.zzc(obj));
                Collections.sort(arrayList);
                zzmh zzmhVar = new zzmh();
                Iterator it = arrayList.iterator();
                long j = 0;
                while (it.hasNext()) {
                    j += ((Long) it.next()).longValue();
                }
                zzmhVar.zza(Long.valueOf(j / arrayList.size()));
                zzmhVar.zzc(Long.valueOf(zza(arrayList, 100.0d)));
                zzmhVar.zzf(Long.valueOf(zza(arrayList, 75.0d)));
                zzmhVar.zzd(Long.valueOf(zza(arrayList, 50.0d)));
                zzmhVar.zzb(Long.valueOf(zza(arrayList, 25.0d)));
                zzmhVar.zze(Long.valueOf(zza(arrayList, 0.0d)));
                zze(zzhVar.zza(obj, arrayList.size(), zzmhVar.zzg()), zzneVar, zzj());
            }
            this.zzl.remove(zzneVar);
        }
    }

    final /* synthetic */ void zzh(final zzne zzneVar, Object obj, long j, final com.google.mlkit.vision.barcode.internal.zzh zzhVar) {
        if (!this.zzl.containsKey(zzneVar)) {
            this.zzl.put(zzneVar, zzbh.zzp());
        }
        ((zzci) this.zzl.get(zzneVar)).zzm(obj, Long.valueOf(j));
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (zzk(zzneVar, elapsedRealtime, 30L)) {
            this.zzk.put(zzneVar, Long.valueOf(elapsedRealtime));
            MLTaskExecutor.workerThreadExecutor().execute(new Runnable() { // from class: com.google.android.gms.internal.mlkit_vision_barcode.zzrj
                @Override // java.lang.Runnable
                public final void run() {
                    zzrl.this.zzg(zzneVar, zzhVar);
                }
            });
        }
    }
}
