package com.extole.android.sdk.impl;

import com.amplitude.reactnative.AndroidContextProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ExtoleContext.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/extole/android/sdk/impl/ExtoleContext;", "", "()V", "toString", "", "Companion", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ExtoleContext {
    public static final int SDK_INTERNAL_VERSION = 1;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String versionName = "";
    private static final int versionCode = -1;
    private static final List<String> TAGS = CollectionsKt.listOf((Object[]) new String[]{"mobile-sdk", AndroidContextProvider.OS_NAME});

    /* compiled from: ExtoleContext.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/extole/android/sdk/impl/ExtoleContext$Companion;", "", "()V", "SDK_INTERNAL_VERSION", "", "TAGS", "", "", "getTAGS", "()Ljava/util/List;", "versionCode", "getVersionCode", "()I", "versionName", "getVersionName", "()Ljava/lang/String;", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getVersionName() {
            return ExtoleContext.versionName;
        }

        public final int getVersionCode() {
            return ExtoleContext.versionCode;
        }

        public final List<String> getTAGS() {
            return ExtoleContext.TAGS;
        }
    }

    public String toString() {
        return "SDK Version: 1, " + TAGS + ", appName: " + versionName + ", appVersion: " + versionCode;
    }
}
