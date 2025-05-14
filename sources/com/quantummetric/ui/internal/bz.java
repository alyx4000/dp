package com.quantummetric.ui.internal;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.graphics.drawable.VectorDrawable;
import android.util.LruCache;
import android.view.View;
import android.widget.ImageView;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import coil.request.ImageRequest;
import com.extole.android.sdk.impl.http.HttpRequest;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.iterable.iterableapi.IterableConstants;
import com.quantummetric.ui.QuantumMetric;
import com.quantummetric.ui.internal.as;
import com.quantummetric.ui.internal.ce;
import com.reactnativecommunity.clipboard.ClipboardModule;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
final class bz {
    private static String I;

    /* renamed from: a, reason: collision with root package name */
    static bz f149a;
    static int b;
    static int c;
    at A;
    Set<a> B;
    Set<Long> C;
    List<String> D;
    boolean E;
    Map<String, String> F;
    List<String> G;
    List<String> H;
    private Bitmap K;
    private String L;
    private String M;
    private int N;
    private WeakReference<LruCache> O;
    private WeakReference<Map<String, Bitmap>> P;
    final JSONObject e;
    c h;
    int i;
    int m;
    long n;
    final JSONObject y;
    Set<String> z;
    int d = 50;
    int f = 0;
    int g = 0;
    private int J = 0;
    boolean j = true;
    boolean k = true;
    boolean l = true;
    boolean o = true;
    boolean p = true;
    boolean q = true;
    boolean r = true;
    boolean s = true;
    boolean t = true;
    int u = ModuleDescriptor.MODULE_VERSION;
    boolean v = true;
    boolean w = true;
    boolean x = true;

    static class a {

        /* renamed from: a, reason: collision with root package name */
        byte[] f155a;
        boolean b;
        long c;

        a(byte[] bArr, boolean z, Long l) {
            this.f155a = bArr;
            this.b = z;
            this.c = l == null ? 0L : l.longValue();
        }
    }

    static class b {
        static boolean a(String str) {
            return str.contains(".otf") || str.contains(".ttf") || str.contains(".svg") || str.contains(".woff") || str.contains(".woff2") || str.contains(".eot") || str.contains(".sfnt");
        }
    }

    static class c extends Thread {

        /* renamed from: a, reason: collision with root package name */
        boolean f156a;
        private int b;

        private c() {
            this.b = 0;
        }

        /* synthetic */ c(byte b) {
            this();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            while (!this.f156a && QuantumMetric.b != null) {
                try {
                    this.b = bz.f149a.g;
                    Thread.sleep(DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM);
                    if (this.f156a) {
                        bz.b(bz.f149a);
                        return;
                    } else if (QuantumMetric.b != null) {
                        if (bz.f149a.e != null && bz.f149a.f != bz.f149a.g && this.b == bz.f149a.g) {
                            bz.b(bz.f149a);
                        }
                        if (bz.f149a.B.size() > 0) {
                            bz.f149a.b();
                        }
                    }
                } catch (Exception unused) {
                    return;
                }
            }
        }
    }

    protected bz() {
        this.L = "";
        this.M = "";
        if (QuantumMetric.f9a != null) {
            this.L = QuantumMetric.f9a.optString("mobile_rl_url");
            this.M = QuantumMetric.f9a.optString("mobile_hash_check_url");
        }
        this.e = a(true);
        this.y = a(false);
        this.A = new at(this);
    }

    static bz a() {
        if (de.b(I) && QuantumMetric.b != null) {
            I = QuantumMetric.b.d;
        }
        if (f149a == null) {
            bz bzVar = new bz();
            f149a = bzVar;
            bzVar.z = Collections.newSetFromMap(new ConcurrentHashMap());
            bz bzVar2 = f149a;
            bzVar2.i = 32;
            try {
                Class<?> cls = Class.forName(IterableConstants.PICASSO_CLASS);
                try {
                    bzVar2.O = new WeakReference<>((LruCache) by.a(cls.getMethod("get", new Class[0]).invoke(null, new Object[0]), "cache", "cache"));
                } catch (Exception unused) {
                    Context f = de.f();
                    if (f != null) {
                        bzVar2.P = new WeakReference<>((Map) by.a(cls.getMethod("with", Context.class).invoke(null, f), "cache", "map"));
                    }
                }
            } catch (Exception unused2) {
                bzVar2.O = new WeakReference<>(null);
                bzVar2.p = false;
            }
            bz bzVar3 = f149a;
            try {
                Context f2 = de.f();
                if (f2 != null) {
                    bzVar3.N = f2.getResources().getIdentifier("glide_custom_view_target_tag", "id", de.b(f2));
                }
            } catch (Exception unused3) {
            }
            f149a.B = Collections.newSetFromMap(new ConcurrentHashMap());
            f149a.C = Collections.newSetFromMap(new ConcurrentHashMap());
            f149a.D = new ArrayList();
            f149a.F = new ConcurrentHashMap();
            f149a.G = new ArrayList();
            f149a.H = new ArrayList();
        }
        return f149a;
    }

    static String a(String str) {
        try {
            if (de.b(str) || !b.a(str)) {
                return str;
            }
            String[] split = str.split("[/\\.]");
            return split.length > 1 ? split[split.length - 2] : str;
        } catch (Exception unused) {
            return str;
        }
    }

    static String a(String str, String[] strArr, String str2) {
        if (strArr == null) {
            return "";
        }
        for (String str3 : strArr) {
            if (str3.contains(str2) && b.a(str3)) {
                return str + str3;
            }
        }
        return "";
    }

    private JSONObject a(boolean z) {
        String g = de.g(b(z));
        if (!de.b(g)) {
            try {
                JSONObject jSONObject = new JSONObject(g);
                if (z) {
                    this.g = jSONObject.length();
                    this.f = jSONObject.length();
                } else {
                    this.J = jSONObject.length();
                }
                return jSONObject;
            } catch (JSONException unused) {
            }
        }
        return new JSONObject();
    }

    private void a(Drawable drawable, Drawable drawable2) {
        try {
            if (drawable instanceof LayerDrawable) {
                for (int i = 0; i < ((LayerDrawable) drawable).getNumberOfLayers(); i++) {
                    a(((LayerDrawable) drawable).getDrawable(i), ((LayerDrawable) drawable2).getDrawable(i));
                }
            } else if (drawable instanceof StateListDrawable) {
                a(((StateListDrawable) drawable).getCurrent(), ((StateListDrawable) drawable2).getCurrent());
            }
            if ((drawable instanceof GradientDrawable) && (drawable2 instanceof GradientDrawable)) {
                ((GradientDrawable) drawable2).setColor(((GradientDrawable) drawable).getColor());
                ((GradientDrawable) drawable2).setColors(((GradientDrawable) drawable).getColors());
            }
        } catch (Throwable unused) {
        }
    }

    static /* synthetic */ void a(bz bzVar) {
        JSONObject jSONObject = bzVar.y;
        if (jSONObject != null) {
            synchronized (jSONObject) {
                if (bzVar.J < bzVar.y.length()) {
                    bzVar.J = bzVar.y.length();
                    de.c(bzVar.b(false), bzVar.y.toString());
                }
            }
        }
    }

    static /* synthetic */ void a(bz bzVar, long j) {
        JSONObject jSONObject = bzVar.e;
        if (jSONObject != null) {
            try {
                synchronized (jSONObject) {
                    bzVar.e.put(Long.toString(j), Long.toString(System.currentTimeMillis()));
                    bzVar.g = bzVar.e.length();
                }
            } catch (JSONException unused) {
            }
        }
    }

    static /* synthetic */ void a(bz bzVar, final long j, String str, String str2, byte[] bArr, final boolean z) {
        try {
            if (bArr.length > 0) {
                as asVar = new as(str, new o<as.a>() { // from class: com.quantummetric.instrument.internal.bz.5
                    @Override // com.quantummetric.ui.internal.o
                    public final /* bridge */ /* synthetic */ void a(as.a aVar) {
                        if (aVar.f67a == 204) {
                            if (z) {
                                bz.a(bz.this, j);
                            } else {
                                bz.a(bz.this);
                            }
                        }
                    }
                });
                asVar.a("PUT");
                bf bfVar = new bf();
                bfVar.put(HttpRequest.HEADER_CONTENT_TYPE, str2);
                asVar.a(bfVar);
                asVar.f66a = bArr;
                as.c.execute(asVar);
            }
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void a(bz bzVar, a aVar, String str) {
        bzVar.C.add(Long.valueOf(aVar.c));
        if (!bzVar.t) {
            bzVar.a(aVar.c, str, aVar.b ? ClipboardModule.MIMETYPE_PNG : ClipboardModule.MIMETYPE_JPEG, aVar.f155a, true);
            return;
        }
        bzVar.B.add(aVar);
        Iterator<a> it = bzVar.B.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().f155a.length;
        }
        if (i > bzVar.u) {
            bzVar.b();
        }
    }

    static /* synthetic */ boolean a(bz bzVar, Bitmap bitmap, boolean z) {
        int byteCount = bitmap.getByteCount();
        return byteCount < c || ((byteCount <= c || z || !bitmap.hasAlpha()) ? false : bzVar.b(bitmap));
    }

    static byte[] a(AssetManager assetManager, String str) {
        if (de.b(str)) {
            return null;
        }
        try {
            InputStream open = assetManager.open(str);
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            return bArr;
        } catch (Exception unused) {
            return null;
        }
    }

    static byte[] a(Bitmap bitmap, boolean z) {
        try {
            if (bitmap.isRecycled()) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (z) {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            } else {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 30, byteArrayOutputStream);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:120:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x015d A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.graphics.Bitmap b(android.graphics.drawable.Drawable r14, android.view.View r15) {
        /*
            Method dump skipped, instructions count: 488
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.bz.b(android.graphics.drawable.Drawable, android.view.View):android.graphics.Bitmap");
    }

    private String b(boolean z) {
        String a2 = z ? aa.a(I) : aa.c(I);
        if (de.b(this.L)) {
            return a2;
        }
        return a2 + "-" + Math.abs(de.i(this.L));
    }

    static /* synthetic */ void b(bz bzVar) {
        JSONObject jSONObject = bzVar.e;
        if (jSONObject != null) {
            synchronized (jSONObject) {
                bzVar.f = bzVar.e.length();
                de.c(bzVar.b(true), bzVar.e.toString());
            }
        }
    }

    private boolean b(Bitmap bitmap) {
        try {
            int height = ((bitmap.getWidth() > bitmap.getHeight() ? bitmap.getHeight() : bitmap.getWidth()) / 10) - 1;
            int i = 0;
            int i2 = 10;
            while (i <= 10) {
                int i3 = i * height;
                if (Color.alpha(bitmap.getPixel(i3, i3)) <= this.d || Color.alpha(bitmap.getPixel(i2 * height, i3)) <= this.d) {
                    return true;
                }
                i++;
                i2--;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private boolean b(String str) {
        boolean z = !de.b(str) && str.contains("http");
        if (z && this.D.size() > 0) {
            Iterator<String> it = this.D.iterator();
            while (it.hasNext() && (!de.a(str, it.next()))) {
            }
        }
        return z;
    }

    private static Canvas c(Drawable drawable) {
        ce.a aVar;
        return ((drawable instanceof ah) && (aVar = ((ah) drawable).d) != null && aVar.e) ? new Canvas() : new bl();
    }

    private boolean d(View view) {
        boolean z = this.j;
        if (!z || this.H.isEmpty()) {
            return z;
        }
        return !de.b(de.a(view)) ? !this.H.contains(r3) : z;
    }

    private String e() {
        return de.b(this.L) ? "https://rl.quantummetric.com/" + I + "/" : this.L;
    }

    private String f() {
        String e = e();
        if (!de.a(this.L, this.M)) {
            e = this.M;
        }
        return e + "hash-check";
    }

    final Bitmap a(Drawable drawable, View view) {
        if (drawable == null) {
            return null;
        }
        try {
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
            if (ag.a(drawable)) {
                return ((RoundedBitmapDrawable) drawable).getBitmap();
            }
            if (drawable instanceof ah) {
                return b(drawable, view);
            }
            if (!(drawable instanceof LayerDrawable) && !(drawable instanceof StateListDrawable)) {
                if (!(drawable instanceof NinePatchDrawable) && !b(drawable) && !ag.b(drawable)) {
                    if (drawable instanceof Animatable) {
                        return b(drawable, view);
                    }
                    if (this.r && view.getClass().getName().equals("com.horcrux.svg.SvgView")) {
                        return (Bitmap) by.a(view, "mBitmap");
                    }
                    if (ag.c(drawable)) {
                        return b(drawable, view);
                    }
                    if (drawable != drawable.getCurrent()) {
                        return a(drawable.getCurrent(), view);
                    }
                    return null;
                }
                return b(drawable, view);
            }
            return b(drawable, view);
        } catch (Throwable unused) {
            return null;
        }
    }

    final Drawable a(Drawable drawable) {
        Drawable a2;
        if (drawable != null) {
            try {
                if (drawable instanceof StateListDrawable) {
                    Drawable current = drawable.getCurrent();
                    if (current != null && (a2 = a(current)) != null) {
                        drawable = a2;
                    }
                } else if (drawable instanceof LayerDrawable) {
                    if ((drawable instanceof TransitionDrawable) || (drawable instanceof RippleDrawable) || de.a(drawable)) {
                        drawable = de.a((LayerDrawable) drawable);
                    }
                } else if (drawable instanceof DrawableWrapper) {
                    drawable = ((DrawableWrapper) drawable).getDrawable();
                }
            } catch (Throwable unused) {
            }
        }
        return drawable;
    }

    final String a(View view) {
        if (this.p && (view instanceof ImageView) && (((ImageView) view).getDrawable() instanceof BitmapDrawable)) {
            try {
                Bitmap bitmap = ((BitmapDrawable) ((ImageView) view).getDrawable()).getBitmap();
                WeakReference<LruCache> weakReference = this.O;
                if (weakReference == null || weakReference.get() == null) {
                    WeakReference<Map<String, Bitmap>> weakReference2 = this.P;
                    if (weakReference2 != null && weakReference2.get() != null) {
                        for (Map.Entry<String, Bitmap> entry : this.P.get().entrySet()) {
                            if (bitmap == entry.getValue()) {
                                String str = entry.getKey().split("\\n")[0];
                                return b(str) ? str : "";
                            }
                        }
                    }
                } else {
                    for (Map.Entry entry2 : ((LinkedHashMap) this.O.get().snapshot()).entrySet()) {
                        if (bitmap == ((Bitmap) by.a(entry2.getValue(), "bitmap"))) {
                            String str2 = ((String) entry2.getKey()).split("\\n")[0];
                            return b(str2) ? str2 : "";
                        }
                    }
                }
            } catch (Exception unused) {
                this.p = false;
            }
        }
        return "";
    }

    final String a(Long l) {
        return (l == null || l.longValue() == 0) ? "" : e() + l;
    }

    final String a(Object obj) {
        if (!this.q) {
            return "";
        }
        try {
            Object invoke = obj.getClass().getDeclaredMethod("getRequest", new Class[0]).invoke(obj, new Object[0]);
            if (!ag.f(invoke)) {
                return "";
            }
            String obj2 = ((ImageRequest) invoke).getData().toString();
            return b(obj2) ? obj2 : "";
        } catch (Throwable unused) {
            this.q = false;
            return "";
        }
    }

    final void a(final long j, final String str, final String str2, final byte[] bArr, final boolean z) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        try {
            as a2 = new as(f(), new o<as.a>() { // from class: com.quantummetric.instrument.internal.bz.3
                @Override // com.quantummetric.ui.internal.o
                public final /* synthetic */ void a(as.a aVar) {
                    try {
                        if (aVar.b.length() > 2) {
                            bz.a(bz.this, j, str, str2, bArr, z);
                        } else if (z) {
                            bz.a(bz.this, j);
                        } else {
                            bz.a(bz.this);
                        }
                    } catch (Exception unused) {
                    }
                }
            }).a("POST");
            a2.f66a = ("[\"" + j + "\"]").getBytes();
            as.c.execute(a2);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    final void a(final Bitmap bitmap, co coVar, final h<String> hVar) {
        final String str = coVar.m;
        if (bd.a().a(coVar.y)) {
            hVar.a("");
        } else {
            this.A.a(bitmap, 0, true, new h<Long>() { // from class: com.quantummetric.instrument.internal.bz.2
                /* JADX WARN: Removed duplicated region for block: B:26:0x005b A[Catch: Exception -> 0x0074, TRY_LEAVE, TryCatch #0 {Exception -> 0x0074, blocks: (B:3:0x0002, B:6:0x0013, B:8:0x0022, B:10:0x0026, B:13:0x002e, B:15:0x0038, B:17:0x003e, B:22:0x004f, B:26:0x005b), top: B:2:0x0002 }] */
                /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
                @Override // com.quantummetric.ui.internal.h
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final /* synthetic */ void a(java.lang.Long r9) {
                    /*
                        r8 = this;
                        java.lang.Long r9 = (java.lang.Long) r9
                        com.quantummetric.instrument.internal.bz r0 = com.quantummetric.ui.internal.bz.this     // Catch: java.lang.Exception -> L74
                        java.lang.String r0 = r0.a(r9)     // Catch: java.lang.Exception -> L74
                        boolean r1 = com.quantummetric.ui.internal.de.b(r0)     // Catch: java.lang.Exception -> L74
                        r2 = 1
                        r3 = 0
                        if (r1 != 0) goto L12
                        r1 = r2
                        goto L13
                    L12:
                        r1 = r3
                    L13:
                        com.quantummetric.instrument.internal.bp$2 r4 = r2     // Catch: java.lang.Exception -> L74
                        r4.a(r0)     // Catch: java.lang.Exception -> L74
                        long r4 = r9.longValue()     // Catch: java.lang.Exception -> L74
                        r6 = 0
                        int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                        if (r4 == 0) goto L58
                        java.lang.String r4 = r3     // Catch: java.lang.Exception -> L74
                        if (r4 == 0) goto L2c
                        boolean r4 = r4.equals(r0)     // Catch: java.lang.Exception -> L74
                        if (r4 != 0) goto L58
                    L2c:
                        if (r1 == 0) goto L58
                        com.quantummetric.instrument.internal.bz r1 = com.quantummetric.ui.internal.bz.this     // Catch: java.lang.Exception -> L74
                        java.util.Set<java.lang.Long> r1 = r1.C     // Catch: java.lang.Exception -> L74
                        boolean r1 = r1.contains(r9)     // Catch: java.lang.Exception -> L74
                        if (r1 != 0) goto L58
                        int r1 = com.quantummetric.ui.internal.bz.b     // Catch: java.lang.Exception -> L74
                        r4 = 100
                        if (r1 == r4) goto L4c
                        int r1 = com.quantummetric.ui.internal.bz.b     // Catch: java.lang.Exception -> L74
                        float r1 = (float) r1     // Catch: java.lang.Exception -> L74
                        float r4 = com.quantummetric.ui.internal.de.g()     // Catch: java.lang.Exception -> L74
                        int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
                        if (r1 <= 0) goto L4a
                        goto L4c
                    L4a:
                        r1 = r3
                        goto L4d
                    L4c:
                        r1 = r2
                    L4d:
                        if (r1 == 0) goto L58
                        com.quantummetric.instrument.internal.bz r1 = com.quantummetric.ui.internal.bz.this     // Catch: java.lang.Exception -> L74
                        boolean r1 = r1.b(r9)     // Catch: java.lang.Exception -> L74
                        if (r1 != 0) goto L58
                        goto L59
                    L58:
                        r2 = r3
                    L59:
                        if (r2 == 0) goto L73
                        com.quantummetric.instrument.internal.bz r1 = com.quantummetric.ui.internal.bz.this     // Catch: java.lang.Exception -> L74
                        android.graphics.Bitmap r2 = r4     // Catch: java.lang.Exception -> L74
                        boolean r1 = com.quantummetric.ui.internal.bz.a(r1, r2, r3)     // Catch: java.lang.Exception -> L74
                        android.graphics.Bitmap r2 = r4     // Catch: java.lang.Exception -> L74
                        byte[] r2 = com.quantummetric.ui.internal.bz.a(r2, r1)     // Catch: java.lang.Exception -> L74
                        com.quantummetric.instrument.internal.bz$a r3 = new com.quantummetric.instrument.internal.bz$a     // Catch: java.lang.Exception -> L74
                        r3.<init>(r2, r1, r9)     // Catch: java.lang.Exception -> L74
                        com.quantummetric.instrument.internal.bz r9 = com.quantummetric.ui.internal.bz.this     // Catch: java.lang.Exception -> L74
                        com.quantummetric.ui.internal.bz.a(r9, r3, r0)     // Catch: java.lang.Exception -> L74
                    L73:
                        return
                    L74:
                        com.quantummetric.instrument.internal.bp$2 r9 = r2
                        java.lang.String r0 = ""
                        r9.a(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.bz.AnonymousClass2.a(java.lang.Object):void");
                }
            });
        }
    }

    final boolean a(Bitmap bitmap) {
        if (bitmap.getConfig() == Bitmap.Config.HARDWARE) {
            return false;
        }
        Bitmap bitmap2 = this.K;
        if (bitmap2 == null || bitmap2.getConfig() != bitmap.getConfig()) {
            int i = this.i;
            this.K = Bitmap.createBitmap(i, i, bitmap.getConfig());
        }
        return bitmap.sameAs((bitmap.getWidth() == this.i && bitmap.getHeight() == this.i) ? this.K : Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()));
    }

    final String b(View view) {
        Object a2;
        try {
            int i = this.N;
            Object tag = i > 0 ? view.getTag(i) : null;
            if (tag == null) {
                tag = view.getTag();
            }
            if (tag == null || !tag.getClass().getSimpleName().contains("SingleRequest") || (a2 = by.a(tag, "model")) == null) {
                return "";
            }
            String obj = a2.toString();
            String[] split = obj.split("url=");
            if (split.length > 1) {
                obj = split[1];
            }
            return b(obj) ? obj : "";
        } catch (Exception unused) {
            return "";
        }
    }

    final void b() {
        final HashSet hashSet = new HashSet(this.B);
        final JSONArray jSONArray = new JSONArray();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            jSONArray.put(Long.toString(((a) it.next()).c));
        }
        this.B.clear();
        if (jSONArray.length() > 0) {
            as a2 = new as(f(), new o<as.a>() { // from class: com.quantummetric.instrument.internal.bz.4
                @Override // com.quantummetric.ui.internal.o
                public final /* synthetic */ void a(as.a aVar) {
                    a aVar2;
                    as.a aVar3 = aVar;
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            String str = (String) jSONArray.get(i);
                            Set set = hashSet;
                            long parseLong = Long.parseLong(str);
                            Iterator it2 = set.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    aVar2 = (a) it2.next();
                                    if (aVar2.c == parseLong) {
                                        break;
                                    }
                                } else {
                                    aVar2 = null;
                                    break;
                                }
                            }
                            if (aVar3.b.contains(str)) {
                                bz.a(bz.this, aVar2.c, bz.this.a(Long.valueOf(aVar2.c)), aVar2.b ? ClipboardModule.MIMETYPE_PNG : ClipboardModule.MIMETYPE_JPEG, aVar2.f155a, true);
                            } else {
                                bz.a(bz.this, aVar2.c);
                            }
                        } catch (Exception unused) {
                            return;
                        }
                    }
                }
            }).a("POST");
            a2.f66a = jSONArray.toString().getBytes();
            as.c.execute(a2);
        }
    }

    final boolean b(Drawable drawable) {
        if (drawable == null || (drawable instanceof BitmapDrawable)) {
            return false;
        }
        boolean z = drawable instanceof VectorDrawable;
        if (z) {
            return z;
        }
        String name = drawable.getClass().getName();
        return name.contains("VectorDrawable") || (this.v && name.contains("androidx.vectordrawable"));
    }

    final boolean b(Long l) {
        try {
            JSONObject jSONObject = this.e;
            if (jSONObject == null) {
                return false;
            }
            synchronized (jSONObject) {
                long optLong = this.e.optLong(Long.toString(l.longValue()));
                if (optLong == 0 || optLong <= this.n) {
                    return false;
                }
                this.e.put(Long.toString(l.longValue()), System.currentTimeMillis());
                return true;
            }
        } catch (Exception unused) {
            return false;
        }
    }

    final String c(View view) {
        if (!view.getClass().getSimpleName().equals("ReactImageView")) {
            return "";
        }
        try {
            Field declaredField = view.getClass().getDeclaredField("mImageSource");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(view);
            String str = (String) obj.getClass().getDeclaredMethod("getSource", new Class[0]).invoke(obj, new Object[0]);
            return b(str) ? str : "";
        } catch (Exception unused) {
            return "";
        }
    }

    final void c() {
        if (QuantumMetric.b == null || f149a == null) {
            return;
        }
        try {
            c cVar = this.h;
            if (cVar != null && cVar.isAlive()) {
                this.h.f156a = true;
            }
            c cVar2 = new c((byte) 0);
            this.h = cVar2;
            cVar2.start();
        } catch (Exception unused) {
        }
    }

    final StringBuilder d() {
        StringBuilder sb = new StringBuilder();
        try {
            synchronized (this.y) {
                Iterator<String> keys = this.y.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    sb.append(String.format("@font-face { font-family: \"%1$s\"; src: url(\"%2$s\") format(\"opentype\"); }\n", next, a(Long.valueOf(this.y.getLong(next)))));
                }
            }
        } catch (Exception unused) {
        }
        return sb;
    }
}
