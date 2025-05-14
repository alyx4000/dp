package com.quantummetric.ui.internal;

import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes5.dex */
final class ak {

    /* renamed from: a, reason: collision with root package name */
    static final Object f49a = new Object();
    private static ak c;
    final HashSet<h<a>> b = new HashSet<>();

    enum a {
        APP_SUSPEND,
        APP_RESUME,
        SDK_STOP,
        SDK_START,
        SDK_PAUSE,
        SDK_RESUME
    }

    private ak() {
    }

    static ak a() {
        if (c == null) {
            synchronized (f49a) {
                if (c == null) {
                    c = new ak();
                }
            }
        }
        return c;
    }

    final void a(a aVar) {
        synchronized (f49a) {
            try {
                Iterator<h<a>> it = this.b.iterator();
                while (it.hasNext()) {
                    it.next().a(aVar);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
