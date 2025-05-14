package com.socure.idplus.device.internal.sigmaDeviceLocation.manager;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.iterable.iterableapi.IterableConstants;
import com.socure.idplus.device.internal.sigmaDeviceLocation.model.SigmaDeviceLocationModel;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* loaded from: classes5.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final com.socure.idplus.device.internal.thread.b f602a;
    public final com.socure.idplus.device.internal.sigmaDeviceLocation.dataHandler.b b;
    public final com.socure.idplus.device.internal.sigmaDeviceLocation.monitor.a c;

    public f(com.socure.idplus.device.internal.thread.b socureThread) {
        Intrinsics.checkNotNullParameter(socureThread, "socureThread");
        this.f602a = socureThread;
        this.b = new com.socure.idplus.device.internal.sigmaDeviceLocation.dataHandler.b();
        this.c = new com.socure.idplus.device.internal.sigmaDeviceLocation.monitor.a();
    }

    public static void a(final Context context, final Function1 function1) {
        Object systemService = context.getSystemService(IterableConstants.ITERABLE_IN_APP_LOCATION);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        boolean isProviderEnabled = ((LocationManager) systemService).isProviderEnabled("gps");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        if (isProviderEnabled) {
            Intrinsics.checkNotNullParameter(context, "context");
            GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
            Intrinsics.checkNotNullExpressionValue(googleApiAvailability, "getInstance(...)");
            if (googleApiAvailability.isGooglePlayServicesAvailable(context) == 0) {
                FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
                Intrinsics.checkNotNullExpressionValue(fusedLocationProviderClient, "getFusedLocationProviderClient(...)");
                Task<Location> lastLocation = fusedLocationProviderClient.getLastLocation();
                final a aVar = new a(booleanRef, function1);
                lastLocation.addOnSuccessListener(new OnSuccessListener() { // from class: com.socure.idplus.device.internal.sigmaDeviceLocation.manager.f$$ExternalSyntheticLambda0
                    @Override // com.google.android.gms.tasks.OnSuccessListener
                    public final void onSuccess(Object obj) {
                        f.a(Function1.this, obj);
                    }
                }).addOnFailureListener(new OnFailureListener() { // from class: com.socure.idplus.device.internal.sigmaDeviceLocation.manager.f$$ExternalSyntheticLambda1
                    @Override // com.google.android.gms.tasks.OnFailureListener
                    public final void onFailure(Exception exc) {
                        f.a(Ref.BooleanRef.this, function1, exc);
                    }
                });
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.socure.idplus.device.internal.sigmaDeviceLocation.manager.f$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        f.a(Ref.BooleanRef.this, function1, context);
                    }
                }, 5000L);
            }
        }
        booleanRef.element = true;
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService2 = context.getSystemService(IterableConstants.ITERABLE_IN_APP_LOCATION);
        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.location.LocationManager");
        LocationManager locationManager = (LocationManager) systemService2;
        com.socure.idplus.device.internal.permission.b bVar = com.socure.idplus.device.internal.permission.b.f584a;
        function1.invoke(com.socure.idplus.device.internal.permission.a.a(context) ? locationManager.getLastKnownLocation("gps") : null);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.socure.idplus.device.internal.sigmaDeviceLocation.manager.f$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                f.a(Ref.BooleanRef.this, function1, context);
            }
        }, 5000L);
    }

    public static final void a(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void a(Ref.BooleanRef isInitialized, Function1 onSuccess, Exception e) {
        Intrinsics.checkNotNullParameter(isInitialized, "$isInitialized");
        Intrinsics.checkNotNullParameter(onSuccess, "$onSuccess");
        Intrinsics.checkNotNullParameter(e, "e");
        Log.d("LocationManager", "Error trying to get last GPS location");
        isInitialized.element = true;
        onSuccess.invoke(null);
    }

    public static final void a(Ref.BooleanRef isInitialized, Function1 onSuccess, Context context) {
        Intrinsics.checkNotNullParameter(isInitialized, "$isInitialized");
        Intrinsics.checkNotNullParameter(onSuccess, "$onSuccess");
        Intrinsics.checkNotNullParameter(context, "$context");
        if (isInitialized.element) {
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService(IterableConstants.ITERABLE_IN_APP_LOCATION);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        LocationManager locationManager = (LocationManager) systemService;
        com.socure.idplus.device.internal.permission.b bVar = com.socure.idplus.device.internal.permission.b.f584a;
        onSuccess.invoke(com.socure.idplus.device.internal.permission.a.a(context) ? locationManager.getLastKnownLocation("gps") : null);
    }

    public final void a(Context context, com.socure.idplus.device.internal.api.a apiClient, String sessionToken, Function2 onError) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(apiClient, "api");
        Intrinsics.checkNotNullParameter(sessionToken, "sessionToken");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService(IterableConstants.ITERABLE_IN_APP_LOCATION);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        LocationManager locationManager = (LocationManager) systemService;
        com.socure.idplus.device.internal.permission.b bVar = com.socure.idplus.device.internal.permission.b.f584a;
        Location lastKnownLocation = com.socure.idplus.device.internal.permission.a.a(context) ? locationManager.getLastKnownLocation("gps") : null;
        if (lastKnownLocation != null) {
            SigmaDeviceLocationModel uploadLocationData = new SigmaDeviceLocationModel(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude(), lastKnownLocation.getAccuracy(), lastKnownLocation.getAltitude(), lastKnownLocation.getVerticalAccuracyMeters(), lastKnownLocation.getBearing(), lastKnownLocation.getBearingAccuracyDegrees(), lastKnownLocation.getSpeed(), lastKnownLocation.getSpeedAccuracyMetersPerSecond());
            com.socure.idplus.device.internal.sigmaDeviceLocation.dataHandler.b bVar2 = this.b;
            String sessionToken2 = com.socure.idplus.device.internal.common.utils.a.a(sessionToken);
            d onSuccess = d.f600a;
            e onError2 = new e(onError);
            bVar2.getClass();
            Intrinsics.checkNotNullParameter(apiClient, "apiClient");
            Intrinsics.checkNotNullParameter(sessionToken2, "sessionToken");
            Intrinsics.checkNotNullParameter(uploadLocationData, "uploadLocationData");
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError2, "onError");
            com.socure.idplus.device.internal.network.c.a(new com.socure.idplus.device.internal.sigmaDeviceLocation.dataHandler.a(apiClient, com.socure.idplus.device.internal.common.utils.a.a(sessionToken2), uploadLocationData), onSuccess, onError2);
        }
    }
}
