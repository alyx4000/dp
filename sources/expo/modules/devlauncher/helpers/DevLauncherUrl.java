package expo.modules.devlauncher.helpers;

import android.net.Uri;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DevLauncherURLHelper.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0004¨\u0006\r"}, d2 = {"Lexpo/modules/devlauncher/helpers/DevLauncherUrl;", "", "url", "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "queryParams", "", "", "getQueryParams", "()Ljava/util/Map;", "getUrl", "()Landroid/net/Uri;", "setUrl", "expo-dev-launcher_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DevLauncherUrl {
    private final Map<String, String> queryParams;
    private Uri url;

    public DevLauncherUrl(Uri url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
        this.queryParams = new LinkedHashMap();
        Set<String> queryParameterNames = this.url.getQueryParameterNames();
        Intrinsics.checkNotNullExpressionValue(queryParameterNames, "url.queryParameterNames");
        for (String name : queryParameterNames) {
            Map<String, String> map = this.queryParams;
            Intrinsics.checkNotNullExpressionValue(name, "name");
            String queryParameter = this.url.getQueryParameter(name);
            if (queryParameter == null) {
                queryParameter = "";
            }
            Intrinsics.checkNotNullExpressionValue(queryParameter, "url.getQueryParameter(name) ?: \"\"");
            map.put(name, queryParameter);
        }
        if (DevLauncherURLHelperKt.isDevLauncherUrl(this.url)) {
            if (this.queryParams.get("url") != null) {
                Uri queryUrl = Uri.parse(this.queryParams.get("url"));
                Intrinsics.checkNotNullExpressionValue(queryUrl, "queryUrl");
                this.url = DevLauncherURLHelperKt.replaceEXPScheme(queryUrl, "http");
                return;
            }
            return;
        }
        this.url = DevLauncherURLHelperKt.replaceEXPScheme(this.url, "http");
    }

    public final Uri getUrl() {
        return this.url;
    }

    public final void setUrl(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<set-?>");
        this.url = uri;
    }

    public final Map<String, String> getQueryParams() {
        return this.queryParams;
    }
}
