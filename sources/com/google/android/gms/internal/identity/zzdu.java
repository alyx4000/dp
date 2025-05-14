package com.google.android.gms.internal.identity;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.location.CurrentLocationRequest;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.zzad;
import com.google.android.gms.location.zzo;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnTokenCanceledListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
/* loaded from: classes3.dex */
public final class zzdu extends GmsClient {
    public static final /* synthetic */ int zze = 0;
    private final SimpleArrayMap zzf;
    private final SimpleArrayMap zzg;
    private final SimpleArrayMap zzh;
    private final SimpleArrayMap zzi;

    public zzdu(Context context, Looper looper, ClientSettings clientSettings, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 23, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zzf = new SimpleArrayMap();
        this.zzg = new SimpleArrayMap();
        this.zzh = new SimpleArrayMap();
        this.zzi = new SimpleArrayMap();
    }

    private final boolean zzG(Feature feature) {
        Feature feature2;
        Feature[] availableFeatures = getAvailableFeatures();
        if (availableFeatures != null) {
            int i = 0;
            while (true) {
                if (i >= availableFeatures.length) {
                    feature2 = null;
                    break;
                }
                feature2 = availableFeatures[i];
                if (feature.getName().equals(feature2.getName())) {
                    break;
                }
                i++;
            }
            if (feature2 != null && feature2.getVersion() >= feature.getVersion()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        return queryLocalInterface instanceof zzv ? (zzv) queryLocalInterface : new zzu(iBinder);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Feature[] getApiFeatures() {
        return zzo.zzo;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 11717000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getServiceDescriptor() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServiceAction() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final void onConnectionSuspended(int i) {
        super.onConnectionSuspended(i);
        synchronized (this.zzf) {
            this.zzf.clear();
        }
        synchronized (this.zzg) {
            this.zzg.clear();
        }
        synchronized (this.zzh) {
            this.zzh.clear();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final boolean usesClientTelemetry() {
        return true;
    }

    public final void zzA(Location location, TaskCompletionSource taskCompletionSource) throws RemoteException {
        if (zzG(zzo.zzh)) {
            ((zzv) getService()).zzB(location, new zzde(null, taskCompletionSource));
        } else {
            ((zzv) getService()).zzA(location);
            taskCompletionSource.setResult(null);
        }
    }

    public final void zzB(TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((zzv) getService()).zzC(new zzdi(null, taskCompletionSource));
    }

    public final void zzC(ListenerHolder listenerHolder, DeviceOrientationRequest deviceOrientationRequest, TaskCompletionSource taskCompletionSource) throws RemoteException {
        ListenerHolder.ListenerKey listenerKey = (ListenerHolder.ListenerKey) Objects.requireNonNull(listenerHolder.getListenerKey());
        synchronized (this.zzh) {
            zzdl zzdlVar = (zzdl) this.zzh.get(listenerKey);
            if (zzdlVar == null) {
                zzdlVar = new zzdl(listenerHolder);
                this.zzh.put(listenerKey, zzdlVar);
            } else {
                zzdlVar.zzc(listenerHolder);
            }
            ((zzv) getService()).zzF(new zzj(1, new zzh(deviceOrientationRequest, zzh.zza, null), zzdlVar, new zzdi(null, taskCompletionSource)));
        }
    }

    public final void zzD(ListenerHolder.ListenerKey listenerKey, TaskCompletionSource taskCompletionSource) throws RemoteException {
        synchronized (this.zzh) {
            zzdl zzdlVar = (zzdl) this.zzh.remove(listenerKey);
            if (zzdlVar == null) {
                taskCompletionSource.setResult(Boolean.FALSE);
            } else {
                zzdlVar.zze();
                ((zzv) getService()).zzF(new zzj(2, null, zzdlVar, new zzdi(Boolean.TRUE, taskCompletionSource)));
            }
        }
    }

    public final void zzE(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, TaskCompletionSource taskCompletionSource) throws RemoteException {
        if (zzG(zzo.zzn)) {
            ((zzv) getService()).zze(geofencingRequest, pendingIntent, new zzde(null, taskCompletionSource));
        } else {
            ((zzv) getService()).zzd(geofencingRequest, pendingIntent, new zzdb(taskCompletionSource));
        }
    }

    public final void zzF(zzeh zzehVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        if (zzG(zzo.zzn)) {
            ((zzv) getService()).zzg(zzehVar, new zzde(null, taskCompletionSource));
        } else {
            ((zzv) getService()).zzf(zzehVar, new zzdb(taskCompletionSource));
        }
    }

    public final void zzp(zzad zzadVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        if (zzG(zzo.zzj)) {
            ((zzv) getService()).zzo(zzadVar, new zzdz(5, null, new zzdg(taskCompletionSource), null, null));
        } else {
            taskCompletionSource.setResult(((zzv) getService()).zzp(getContext().getPackageName()));
        }
    }

    public final void zzq(LastLocationRequest lastLocationRequest, TaskCompletionSource taskCompletionSource) throws RemoteException {
        if (zzG(zzo.zzj)) {
            ((zzv) getService()).zzq(lastLocationRequest, zzdz.zzd(new zzdf(taskCompletionSource)));
        } else if (zzG(zzo.zzf)) {
            ((zzv) getService()).zzr(lastLocationRequest, new zzdf(taskCompletionSource));
        } else {
            taskCompletionSource.setResult(((zzv) getService()).zzs());
        }
    }

    public final void zzr(CurrentLocationRequest currentLocationRequest, CancellationToken cancellationToken, final TaskCompletionSource taskCompletionSource) throws RemoteException {
        if (zzG(zzo.zzj)) {
            final ICancelToken zzt = ((zzv) getService()).zzt(currentLocationRequest, zzdz.zzd(new zzdf(taskCompletionSource)));
            if (cancellationToken != null) {
                cancellationToken.onCanceledRequested(new OnTokenCanceledListener() { // from class: com.google.android.gms.internal.location.zzdy
                    @Override // com.google.android.gms.tasks.OnTokenCanceledListener
                    public final /* synthetic */ void onCanceled() {
                        int i = zzdu.zze;
                        try {
                            ICancelToken.this.cancel();
                        } catch (RemoteException unused) {
                        }
                    }
                });
                return;
            }
            return;
        }
        if (zzG(zzo.zze)) {
            final ICancelToken zzu = ((zzv) getService()).zzu(currentLocationRequest, new zzdf(taskCompletionSource));
            if (cancellationToken != null) {
                cancellationToken.onCanceledRequested(new OnTokenCanceledListener() { // from class: com.google.android.gms.internal.location.zzdw
                    @Override // com.google.android.gms.tasks.OnTokenCanceledListener
                    public final /* synthetic */ void onCanceled() {
                        int i = zzdu.zze;
                        try {
                            ICancelToken.this.cancel();
                        } catch (RemoteException unused) {
                        }
                    }
                });
                return;
            }
            return;
        }
        ListenerHolder createListenerHolder = ListenerHolders.createListenerHolder(new zzdc(this, taskCompletionSource), zzex.zza(), "GetCurrentLocation");
        final ListenerHolder.ListenerKey listenerKey = (ListenerHolder.ListenerKey) Objects.requireNonNull(createListenerHolder.getListenerKey());
        zzdd zzddVar = new zzdd(this, createListenerHolder, taskCompletionSource);
        TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
        LocationRequest.Builder builder = new LocationRequest.Builder(currentLocationRequest.getPriority(), 0L);
        builder.setMinUpdateIntervalMillis(0L);
        builder.setDurationMillis(currentLocationRequest.getDurationMillis());
        builder.setGranularity(currentLocationRequest.getGranularity());
        builder.setMaxUpdateAgeMillis(currentLocationRequest.getMaxUpdateAgeMillis());
        builder.zzb(currentLocationRequest.zza());
        builder.zza(currentLocationRequest.zzb());
        builder.setWaitForAccurateLocation(true);
        builder.zzc(currentLocationRequest.zzc());
        zzt(zzddVar, builder.build(), taskCompletionSource2);
        taskCompletionSource2.getTask().addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.gms.internal.location.zzdv
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final /* synthetic */ void onComplete(Task task) {
                int i = zzdu.zze;
                if (task.isSuccessful()) {
                    return;
                }
                TaskCompletionSource.this.trySetException((Exception) Objects.requireNonNull(task.getException()));
            }
        });
        if (cancellationToken != null) {
            cancellationToken.onCanceledRequested(new OnTokenCanceledListener() { // from class: com.google.android.gms.internal.location.zzdx
                @Override // com.google.android.gms.tasks.OnTokenCanceledListener
                public final /* synthetic */ void onCanceled() {
                    try {
                        zzdu.this.zzw(listenerKey, true, new TaskCompletionSource());
                    } catch (RemoteException unused) {
                    }
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0040 A[Catch: all -> 0x0078, TryCatch #0 {, blocks: (B:4:0x001d, B:8:0x002b, B:10:0x0040, B:11:0x0076, B:15:0x0057, B:16:0x0031), top: B:3:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0057 A[Catch: all -> 0x0078, TryCatch #0 {, blocks: (B:4:0x001d, B:8:0x002b, B:10:0x0040, B:11:0x0076, B:15:0x0057, B:16:0x0031), top: B:3:0x001d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzs(com.google.android.gms.internal.identity.zzdm r18, com.google.android.gms.location.LocationRequest r19, com.google.android.gms.tasks.TaskCompletionSource r20) throws android.os.RemoteException {
        /*
            r17 = this;
            r1 = r17
            r0 = r19
            r2 = r20
            com.google.android.gms.common.api.internal.ListenerHolder r3 = r18.zza()
            com.google.android.gms.common.api.internal.ListenerHolder$ListenerKey r4 = r3.getListenerKey()
            java.lang.Object r4 = java.util.Objects.requireNonNull(r4)
            com.google.android.gms.common.api.internal.ListenerHolder$ListenerKey r4 = (com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey) r4
            com.google.android.gms.common.Feature r5 = com.google.android.gms.location.zzo.zzj
            boolean r5 = r1.zzG(r5)
            androidx.collection.SimpleArrayMap r6 = r1.zzf
            monitor-enter(r6)
            androidx.collection.SimpleArrayMap r7 = r1.zzf     // Catch: java.lang.Throwable -> L78
            java.lang.Object r7 = r7.get(r4)     // Catch: java.lang.Throwable -> L78
            com.google.android.gms.internal.location.zzdt r7 = (com.google.android.gms.internal.identity.zzdt) r7     // Catch: java.lang.Throwable -> L78
            r8 = 0
            if (r7 == 0) goto L31
            if (r5 == 0) goto L2b
            goto L31
        L2b:
            r7.zzc(r3)     // Catch: java.lang.Throwable -> L78
            r12 = r7
            r7 = r8
            goto L3e
        L31:
            com.google.android.gms.internal.location.zzdt r3 = new com.google.android.gms.internal.location.zzdt     // Catch: java.lang.Throwable -> L78
            r9 = r18
            r3.<init>(r9)     // Catch: java.lang.Throwable -> L78
            androidx.collection.SimpleArrayMap r9 = r1.zzf     // Catch: java.lang.Throwable -> L78
            r9.put(r4, r3)     // Catch: java.lang.Throwable -> L78
            r12 = r3
        L3e:
            if (r5 == 0) goto L57
            android.os.IInterface r3 = r17.getService()     // Catch: java.lang.Throwable -> L78
            com.google.android.gms.internal.location.zzv r3 = (com.google.android.gms.internal.identity.zzv) r3     // Catch: java.lang.Throwable -> L78
            java.lang.String r4 = r4.toIdString()     // Catch: java.lang.Throwable -> L78
            com.google.android.gms.internal.location.zzdz r4 = com.google.android.gms.internal.identity.zzdz.zza(r7, r12, r4)     // Catch: java.lang.Throwable -> L78
            com.google.android.gms.internal.location.zzde r5 = new com.google.android.gms.internal.location.zzde     // Catch: java.lang.Throwable -> L78
            r5.<init>(r8, r2)     // Catch: java.lang.Throwable -> L78
            r3.zzw(r4, r0, r5)     // Catch: java.lang.Throwable -> L78
            goto L76
        L57:
            android.os.IInterface r3 = r17.getService()     // Catch: java.lang.Throwable -> L78
            com.google.android.gms.internal.location.zzv r3 = (com.google.android.gms.internal.identity.zzv) r3     // Catch: java.lang.Throwable -> L78
            com.google.android.gms.internal.location.zzeb r11 = com.google.android.gms.internal.identity.zzeb.zza(r8, r0)     // Catch: java.lang.Throwable -> L78
            com.google.android.gms.internal.location.zzdj r15 = new com.google.android.gms.internal.location.zzdj     // Catch: java.lang.Throwable -> L78
            r15.<init>(r2, r12)     // Catch: java.lang.Throwable -> L78
            java.lang.String r16 = r4.toIdString()     // Catch: java.lang.Throwable -> L78
            com.google.android.gms.internal.location.zzed r0 = new com.google.android.gms.internal.location.zzed     // Catch: java.lang.Throwable -> L78
            r10 = 1
            r13 = 0
            r14 = 0
            r9 = r0
            r9.<init>(r10, r11, r12, r13, r14, r15, r16)     // Catch: java.lang.Throwable -> L78
            r3.zzv(r0)     // Catch: java.lang.Throwable -> L78
        L76:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L78
            return
        L78:
            r0 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L78
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.identity.zzdu.zzs(com.google.android.gms.internal.location.zzdm, com.google.android.gms.location.LocationRequest, com.google.android.gms.tasks.TaskCompletionSource):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0040 A[Catch: all -> 0x0078, TryCatch #0 {, blocks: (B:4:0x001d, B:8:0x002b, B:10:0x0040, B:11:0x0076, B:15:0x0057, B:16:0x0031), top: B:3:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0057 A[Catch: all -> 0x0078, TryCatch #0 {, blocks: (B:4:0x001d, B:8:0x002b, B:10:0x0040, B:11:0x0076, B:15:0x0057, B:16:0x0031), top: B:3:0x001d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzt(com.google.android.gms.internal.identity.zzdm r18, com.google.android.gms.location.LocationRequest r19, com.google.android.gms.tasks.TaskCompletionSource r20) throws android.os.RemoteException {
        /*
            r17 = this;
            r1 = r17
            r0 = r19
            r2 = r20
            com.google.android.gms.common.api.internal.ListenerHolder r3 = r18.zza()
            com.google.android.gms.common.api.internal.ListenerHolder$ListenerKey r4 = r3.getListenerKey()
            java.lang.Object r4 = java.util.Objects.requireNonNull(r4)
            com.google.android.gms.common.api.internal.ListenerHolder$ListenerKey r4 = (com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey) r4
            com.google.android.gms.common.Feature r5 = com.google.android.gms.location.zzo.zzj
            boolean r5 = r1.zzG(r5)
            androidx.collection.SimpleArrayMap r6 = r1.zzg
            monitor-enter(r6)
            androidx.collection.SimpleArrayMap r7 = r1.zzg     // Catch: java.lang.Throwable -> L78
            java.lang.Object r7 = r7.get(r4)     // Catch: java.lang.Throwable -> L78
            com.google.android.gms.internal.location.zzdq r7 = (com.google.android.gms.internal.identity.zzdq) r7     // Catch: java.lang.Throwable -> L78
            r8 = 0
            if (r7 == 0) goto L31
            if (r5 == 0) goto L2b
            goto L31
        L2b:
            r7.zzc(r3)     // Catch: java.lang.Throwable -> L78
            r13 = r7
            r7 = r8
            goto L3e
        L31:
            com.google.android.gms.internal.location.zzdq r3 = new com.google.android.gms.internal.location.zzdq     // Catch: java.lang.Throwable -> L78
            r9 = r18
            r3.<init>(r9)     // Catch: java.lang.Throwable -> L78
            androidx.collection.SimpleArrayMap r9 = r1.zzg     // Catch: java.lang.Throwable -> L78
            r9.put(r4, r3)     // Catch: java.lang.Throwable -> L78
            r13 = r3
        L3e:
            if (r5 == 0) goto L57
            android.os.IInterface r3 = r17.getService()     // Catch: java.lang.Throwable -> L78
            com.google.android.gms.internal.location.zzv r3 = (com.google.android.gms.internal.identity.zzv) r3     // Catch: java.lang.Throwable -> L78
            java.lang.String r4 = r4.toIdString()     // Catch: java.lang.Throwable -> L78
            com.google.android.gms.internal.location.zzdz r4 = com.google.android.gms.internal.identity.zzdz.zzb(r7, r13, r4)     // Catch: java.lang.Throwable -> L78
            com.google.android.gms.internal.location.zzde r5 = new com.google.android.gms.internal.location.zzde     // Catch: java.lang.Throwable -> L78
            r5.<init>(r8, r2)     // Catch: java.lang.Throwable -> L78
            r3.zzw(r4, r0, r5)     // Catch: java.lang.Throwable -> L78
            goto L76
        L57:
            android.os.IInterface r3 = r17.getService()     // Catch: java.lang.Throwable -> L78
            com.google.android.gms.internal.location.zzv r3 = (com.google.android.gms.internal.identity.zzv) r3     // Catch: java.lang.Throwable -> L78
            com.google.android.gms.internal.location.zzeb r11 = com.google.android.gms.internal.identity.zzeb.zza(r8, r0)     // Catch: java.lang.Throwable -> L78
            com.google.android.gms.internal.location.zzcy r15 = new com.google.android.gms.internal.location.zzcy     // Catch: java.lang.Throwable -> L78
            r15.<init>(r2, r13)     // Catch: java.lang.Throwable -> L78
            java.lang.String r16 = r4.toIdString()     // Catch: java.lang.Throwable -> L78
            com.google.android.gms.internal.location.zzed r0 = new com.google.android.gms.internal.location.zzed     // Catch: java.lang.Throwable -> L78
            r10 = 1
            r12 = 0
            r14 = 0
            r9 = r0
            r9.<init>(r10, r11, r12, r13, r14, r15, r16)     // Catch: java.lang.Throwable -> L78
            r3.zzv(r0)     // Catch: java.lang.Throwable -> L78
        L76:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L78
            return
        L78:
            r0 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L78
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.identity.zzdu.zzt(com.google.android.gms.internal.location.zzdm, com.google.android.gms.location.LocationRequest, com.google.android.gms.tasks.TaskCompletionSource):void");
    }

    public final void zzu(PendingIntent pendingIntent, LocationRequest locationRequest, TaskCompletionSource taskCompletionSource) throws RemoteException {
        if (zzG(zzo.zzj)) {
            ((zzv) getService()).zzw(zzdz.zzc(pendingIntent), locationRequest, new zzde(null, taskCompletionSource));
            return;
        }
        zzv zzvVar = (zzv) getService();
        zzeb zza = zzeb.zza(null, locationRequest);
        zzdi zzdiVar = new zzdi(null, taskCompletionSource);
        int hashCode = pendingIntent.hashCode();
        StringBuilder sb = new StringBuilder(String.valueOf(hashCode).length() + 14);
        sb.append("PendingIntent@");
        sb.append(hashCode);
        zzvVar.zzv(new zzed(1, zza, null, null, pendingIntent, zzdiVar, sb.toString()));
    }

    public final void zzv(ListenerHolder.ListenerKey listenerKey, boolean z, TaskCompletionSource taskCompletionSource) throws RemoteException {
        synchronized (this.zzf) {
            zzdt zzdtVar = (zzdt) this.zzf.remove(listenerKey);
            if (zzdtVar == null) {
                taskCompletionSource.setResult(Boolean.FALSE);
                return;
            }
            zzdtVar.zzf();
            if (!z) {
                taskCompletionSource.setResult(Boolean.TRUE);
            } else if (zzG(zzo.zzj)) {
                zzv zzvVar = (zzv) getService();
                int identityHashCode = System.identityHashCode(zzdtVar);
                StringBuilder sb = new StringBuilder(String.valueOf(identityHashCode).length() + 18);
                sb.append("ILocationListener@");
                sb.append(identityHashCode);
                zzvVar.zzx(zzdz.zza(null, zzdtVar, sb.toString()), new zzde(Boolean.TRUE, taskCompletionSource));
            } else {
                ((zzv) getService()).zzv(new zzed(2, null, zzdtVar, null, null, new zzdi(Boolean.TRUE, taskCompletionSource), null));
            }
        }
    }

    public final void zzw(ListenerHolder.ListenerKey listenerKey, boolean z, TaskCompletionSource taskCompletionSource) throws RemoteException {
        synchronized (this.zzg) {
            zzdq zzdqVar = (zzdq) this.zzg.remove(listenerKey);
            if (zzdqVar == null) {
                taskCompletionSource.setResult(Boolean.FALSE);
                return;
            }
            zzdqVar.zzg();
            if (!z) {
                taskCompletionSource.setResult(Boolean.TRUE);
            } else if (zzG(zzo.zzj)) {
                zzv zzvVar = (zzv) getService();
                int identityHashCode = System.identityHashCode(zzdqVar);
                StringBuilder sb = new StringBuilder(String.valueOf(identityHashCode).length() + 18);
                sb.append("ILocationCallback@");
                sb.append(identityHashCode);
                zzvVar.zzx(zzdz.zzb(null, zzdqVar, sb.toString()), new zzde(Boolean.TRUE, taskCompletionSource));
            } else {
                ((zzv) getService()).zzv(new zzed(2, null, null, zzdqVar, null, new zzdi(Boolean.TRUE, taskCompletionSource), null));
            }
        }
    }

    public final void zzx(PendingIntent pendingIntent, TaskCompletionSource taskCompletionSource, Object obj) throws RemoteException {
        if (zzG(zzo.zzj)) {
            ((zzv) getService()).zzx(zzdz.zzc(pendingIntent), new zzde(null, taskCompletionSource));
        } else {
            ((zzv) getService()).zzv(new zzed(2, null, null, null, pendingIntent, new zzdi(null, taskCompletionSource), null));
        }
    }

    public final void zzy(TaskCompletionSource taskCompletionSource) throws RemoteException {
        if (zzG(zzo.zzg)) {
            ((zzv) getService()).zzz(true, new zzde(null, taskCompletionSource));
        } else {
            ((zzv) getService()).zzy(true);
            taskCompletionSource.setResult(null);
        }
    }

    public final void zzz(TaskCompletionSource taskCompletionSource) throws RemoteException {
        if (zzG(zzo.zzg)) {
            ((zzv) getService()).zzz(false, new zzde(true, taskCompletionSource));
        } else {
            ((zzv) getService()).zzy(false);
            taskCompletionSource.setResult(true);
        }
    }
}
