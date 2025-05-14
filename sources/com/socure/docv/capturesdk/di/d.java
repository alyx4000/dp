package com.socure.docv.capturesdk.di;

import android.app.Application;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static c f413a;

    public static final c a(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        c cVar = f413a;
        if (cVar != null) {
            return cVar;
        }
        a aVar = new a(application);
        f413a = aVar;
        return aVar;
    }
}
