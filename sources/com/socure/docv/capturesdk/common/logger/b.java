package com.socure.docv.capturesdk.common.logger;

import android.util.Log;
import com.socure.docv.capturesdk.common.utils.ConstantsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class b {

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f293a;

        static {
            int[] iArr = new int[com.socure.docv.capturesdk.common.logger.a.b(3).length];
            iArr[com.socure.docv.capturesdk.common.logger.a.a(2)] = 1;
            iArr[com.socure.docv.capturesdk.common.logger.a.a(1)] = 2;
            iArr[com.socure.docv.capturesdk.common.logger.a.a(3)] = 3;
            f293a = iArr;
        }
    }

    public static final void a(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        a(tag, msg, 0, null, 12, null);
    }

    public static final void a(String str, String str2, int i, Throwable th) {
        if (!ConstantsKt.getSILENCE_DEBUG_LOG() || i == 1) {
            int[] iArr = a.f293a;
            if (i == 0) {
                throw null;
            }
            int i2 = iArr[i - 1];
            if (i2 == 1) {
                Log.i(str, str2);
                return;
            }
            if (i2 != 2) {
                if (i2 != 3) {
                    return;
                }
                Log.d(str, str2);
            } else if (th != null) {
                Log.e(str, str2, th);
            } else {
                Log.e(str, str2);
            }
        }
    }

    public static /* synthetic */ void a(String str, String str2, int i, Throwable th, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 3;
        }
        if ((i2 & 8) != 0) {
            th = null;
        }
        a(str, str2, i, th);
    }

    public static void a(String tag, String msg, Throwable th, int i, Object obj) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        a(tag, msg, 1, null);
    }

    public static final void b(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (ConstantsKt.getPRINT_DETAILED_LOG()) {
            a(tag, msg, 0, null, 12, null);
        }
    }

    public static final void c(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        a(tag, msg, 2, null, 8, null);
    }

    public static final void d(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
    }
}
