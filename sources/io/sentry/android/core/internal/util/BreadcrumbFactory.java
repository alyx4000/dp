package io.sentry.android.core.internal.util;

import io.sentry.Breadcrumb;
import io.sentry.SentryLevel;
import io.sentry.cache.EnvelopeCache;

/* loaded from: classes2.dex */
public class BreadcrumbFactory {
    public static Breadcrumb forSession(String str) {
        Breadcrumb breadcrumb = new Breadcrumb();
        breadcrumb.setType(EnvelopeCache.PREFIX_CURRENT_SESSION_FILE);
        breadcrumb.setData("state", str);
        breadcrumb.setCategory("app.lifecycle");
        breadcrumb.setLevel(SentryLevel.INFO);
        return breadcrumb;
    }
}
