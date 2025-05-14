package io.castle.highwind.android;

import android.app.UiModeManager;
import android.app.usage.StorageStatsManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Environment;
import android.os.LocaleList;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import androidx.autofill.HintConstants;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* loaded from: classes2.dex */
public final class g extends c0 {
    public final Context c;
    public Pair<? extends Long, ? extends Long> d;
    public final Mutex e = MutexKt.Mutex$default(false, 1, null);

    @JvmInline
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Pair<Long, Long> f771a;

        public final boolean equals(Object obj) {
            return (obj instanceof a) && Intrinsics.areEqual(this.f771a, ((a) obj).f771a);
        }

        public final int hashCode() {
            return this.f771a.hashCode();
        }

        public final String toString() {
            return "StorageSize(src=" + this.f771a + ')';
        }
    }

    public g(Context context) {
        this.c = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(io.castle.highwind.android.g r5, kotlin.coroutines.Continuation r6) {
        /*
            r5.getClass()
            boolean r0 = r6 instanceof io.castle.highwind.android.h
            if (r0 == 0) goto L16
            r0 = r6
            io.castle.highwind.android.h r0 = (io.castle.highwind.android.h) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L16
            int r1 = r1 - r2
            r0.c = r1
            goto L1b
        L16:
            io.castle.highwind.android.h r0 = new io.castle.highwind.android.h
            r0.<init>(r5, r6)
        L1b:
            java.lang.Object r6 = r0.f772a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4a
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.CoroutineDispatcher r6 = kotlinx.coroutines.Dispatchers.getDefault()
            io.castle.highwind.android.i r2 = new io.castle.highwind.android.i
            r4 = 0
            r2.<init>(r5, r4)
            r0.c = r3
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.withContext(r6, r2, r0)
            if (r6 != r1) goto L4a
            goto L4e
        L4a:
            io.castle.highwind.android.g$a r6 = (io.castle.highwind.android.g.a) r6
            kotlin.Pair<java.lang.Long, java.lang.Long> r1 = r6.f771a
        L4e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.castle.highwind.android.g.a(io.castle.highwind.android.g, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Pair a(g gVar) {
        gVar.getClass();
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return TuplesKt.to(Long.valueOf(statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong()), Long.valueOf(statFs.getBlockSizeLong() * statFs.getBlockCountLong()));
    }

    public static final Pair a(g gVar, StorageStatsManager storageStatsManager) {
        gVar.getClass();
        try {
            return TuplesKt.to(Long.valueOf(storageStatsManager.getFreeBytes(StorageManager.UUID_DEFAULT)), Long.valueOf(storageStatsManager.getTotalBytes(StorageManager.UUID_DEFAULT)));
        } catch (IOException unused) {
            return TuplesKt.to(0L, 0L);
        }
    }

    public final int a() {
        int currentModeType = ((UiModeManager) this.c.getSystemService("uimode")).getCurrentModeType();
        if (currentModeType == 3) {
            return 3;
        }
        if (currentModeType == 4) {
            return 2;
        }
        if (currentModeType == 6) {
            return 4;
        }
        if (((TelephonyManager) this.c.getSystemService(HintConstants.AUTOFILL_HINT_PHONE)).getPhoneType() == 0) {
            DisplayMetrics a2 = k.f775a.a(this.c);
            if (MathKt.roundToInt(Math.sqrt(Math.pow(a2.heightPixels / a2.ydpi, 2.0d) + Math.pow(a2.widthPixels / a2.xdpi, 2.0d)) * r2) / 10 >= 7.0d) {
                return 1;
            }
        }
        return 0;
    }

    public final String a(Context context) {
        ArrayList arrayList = new ArrayList();
        LocaleList locales = Resources.getSystem().getConfiguration().getLocales();
        int size = locales.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(f0.a(locales.get(i)));
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return CollectionsKt.joinToString$default(arrayList, ",", null, null, 0, null, null, 62, null);
    }
}
