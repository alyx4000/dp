package io.castle.highwind.android;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import com.iterable.iterableapi.IterableConstants;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;

/* loaded from: classes2.dex */
public final class d0 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f766a;
    public boolean b;
    public Date c;
    public Map<Integer, Integer> d = new LinkedHashMap();
    public Map<Integer, v> e = new LinkedHashMap();
    public Map<Integer, v> f = new LinkedHashMap();
    public final SensorManager g;
    public final Sensor h;
    public final Sensor i;
    public final Sensor j;
    public Location k;
    public final a l;

    public static final class a implements SensorEventListener {
        public a() {
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.util.LinkedHashMap, java.util.Map<java.lang.Integer, java.lang.Integer>] */
        /* JADX WARN: Type inference failed for: r5v3, types: [java.util.LinkedHashMap, java.util.Map, java.util.Map<java.lang.Integer, java.lang.Integer>] */
        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent != null) {
                int intValue = ((Number) d0.this.d.get(Integer.valueOf(sensorEvent.sensor.getType()))).intValue();
                d0.this.getClass();
                if (intValue >= 100) {
                    d0.this.g.unregisterListener(this, sensorEvent.sensor);
                    ?? r5 = d0.this.d;
                    boolean z = true;
                    if (!r5.isEmpty()) {
                        Iterator it = r5.entrySet().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            if (!(((Number) ((Map.Entry) it.next()).getValue()).intValue() == 100)) {
                                z = false;
                                break;
                            }
                        }
                    }
                    if (z) {
                        d0 d0Var = d0.this;
                        d0Var.g.unregisterListener(d0Var.l);
                        d0Var.c = new Date();
                        d0Var.b = false;
                        d0Var.f = d0Var.e;
                        d0Var.e = new LinkedHashMap();
                    }
                }
            }
        }
    }

    public d0(Context context) {
        this.f766a = context;
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.g = sensorManager;
        this.h = sensorManager.getDefaultSensor(4);
        this.i = sensorManager.getDefaultSensor(2);
        this.j = sensorManager.getDefaultSensor(1);
        this.l = new a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0027, code lost:
    
        if (java.lang.Math.abs(new java.util.Date().getTime() - r8.c.getTime()) <= 120000) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0030 A[Catch: all -> 0x007d, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:11:0x0030, B:13:0x004b, B:15:0x0079, B:19:0x0055, B:21:0x005d, B:25:0x0077, B:26:0x0008, B:30:0x000d), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() {
        /*
            r8 = this;
            monitor-enter(r8)
            boolean r0 = r8.b     // Catch: java.lang.Throwable -> L7d
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L8
            goto L2b
        L8:
            java.util.Date r0 = r8.c     // Catch: java.lang.Throwable -> L7d
            if (r0 != 0) goto Ld
            goto L29
        Ld:
            java.util.Date r0 = new java.util.Date     // Catch: java.lang.Throwable -> L7d
            r0.<init>()     // Catch: java.lang.Throwable -> L7d
            long r3 = r0.getTime()     // Catch: java.lang.Throwable -> L7d
            java.util.Date r0 = r8.c     // Catch: java.lang.Throwable -> L7d
            long r5 = r0.getTime()     // Catch: java.lang.Throwable -> L7d
            long r3 = r3 - r5
            long r3 = java.lang.Math.abs(r3)     // Catch: java.lang.Throwable -> L7d
            r0 = 120000(0x1d4c0, float:1.68156E-40)
            long r5 = (long) r0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 <= 0) goto L2b
        L29:
            r0 = r2
            goto L2c
        L2b:
            r0 = r1
        L2c:
            if (r0 != 0) goto L30
            monitor-exit(r8)
            return
        L30:
            r8.b = r2     // Catch: java.lang.Throwable -> L7d
            android.hardware.Sensor r0 = r8.h     // Catch: java.lang.Throwable -> L7d
            r8.a(r0)     // Catch: java.lang.Throwable -> L7d
            android.hardware.Sensor r0 = r8.i     // Catch: java.lang.Throwable -> L7d
            r8.a(r0)     // Catch: java.lang.Throwable -> L7d
            android.hardware.Sensor r0 = r8.j     // Catch: java.lang.Throwable -> L7d
            r8.a(r0)     // Catch: java.lang.Throwable -> L7d
            android.content.Context r0 = r8.f766a     // Catch: java.lang.Throwable -> L7d
            java.lang.String r3 = "android.permission.ACCESS_FINE_LOCATION"
            int r0 = r0.checkCallingOrSelfPermission(r3)     // Catch: java.lang.Throwable -> L7d
            if (r0 == 0) goto L55
            android.content.Context r0 = r8.f766a     // Catch: java.lang.Throwable -> L7d
            java.lang.String r3 = "android.permission.ACCESS_COARSE_LOCATION"
            int r0 = r0.checkCallingOrSelfPermission(r3)     // Catch: java.lang.Throwable -> L7d
            if (r0 != 0) goto L79
        L55:
            android.content.Context r0 = r8.f766a     // Catch: java.lang.Throwable -> L7d
            android.location.Location r0 = r8.a(r0)     // Catch: java.lang.Throwable -> L7d
            if (r0 == 0) goto L79
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.HOURS     // Catch: java.lang.Throwable -> L7d
            long r4 = android.os.SystemClock.elapsedRealtimeNanos()     // Catch: java.lang.Throwable -> L7d
            long r6 = r0.getElapsedRealtimeNanos()     // Catch: java.lang.Throwable -> L7d
            long r4 = r4 - r6
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch: java.lang.Throwable -> L7d
            long r3 = r3.convert(r4, r6)     // Catch: java.lang.Throwable -> L7d
            r5 = 24
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 >= 0) goto L75
            r1 = r2
        L75:
            if (r1 == 0) goto L79
            r8.k = r0     // Catch: java.lang.Throwable -> L7d
        L79:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L7d
            monitor-exit(r8)
            return
        L7d:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.castle.highwind.android.d0.a():void");
    }

    public final double b(int i) {
        this.f.get(Integer.valueOf(i)).getClass();
        return 0.0f;
    }

    public final Location a(Context context) {
        List listOf;
        Location location;
        LocationManager locationManager = (LocationManager) context.getSystemService(IterableConstants.ITERABLE_IN_APP_LOCATION);
        if (Build.VERSION.SDK_INT >= 31) {
            listOf = CollectionsKt.listOf((Object[]) new String[]{"gps", "passive", "network", "fused"});
        } else {
            listOf = CollectionsKt.listOf((Object[]) new String[]{"gps", "passive", "network"});
        }
        Iterator it = listOf.iterator();
        do {
            location = null;
            if (!it.hasNext()) {
                break;
            }
            try {
                location = locationManager.getLastKnownLocation((String) it.next());
            } catch (SecurityException unused) {
            }
        } while (location == null);
        return location;
    }

    public final void a(Sensor sensor) {
        if (sensor != null) {
            this.e.put(Integer.valueOf(sensor.getType()), new v());
            this.d.put(Integer.valueOf(sensor.getType()), 0);
            this.g.registerListener(this.l, sensor, 2);
        }
    }

    public final boolean a(int i) {
        return !this.b && this.f.containsKey(Integer.valueOf(i));
    }
}
