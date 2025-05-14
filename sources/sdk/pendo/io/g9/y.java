package sdk.pendo.io.g9;

import android.net.Uri;
import android.text.TextUtils;
import io.sentry.protocol.ViewHierarchyNode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.logging.PendoLogger;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b*\u0010+J\u001c\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007J\u001c\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\t\u001a\u00020\bH\u0007J\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u000bJ\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\fH\u0016J\u0011\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0007\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0004\b\u0007\u0010\u000fJ\u001b\u0010\u0007\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0007\u0010\u0011J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\t\u0010\u0012J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\r\u0010\u0012R\u001c\u0010\u0015\u001a\n \u0013*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0016R$\u0010\u001c\u001a\u0004\u0018\u00010\f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u001bR\"\u0010!\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0016\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R*\u0010(\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00028G@@X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0014\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0013\u0010)\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b#\u0010\u000f¨\u0006,"}, d2 = {"Lsdk/pendo/io/g9/y;", "", "", "newEndpoint", "", "isRedirect", "a", "b", "", "d", "dataCenter", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/net/Uri;", "e", "c", "()Landroid/net/Uri;", "customUrl", "(Ljava/lang/String;)Landroid/net/Uri;", "(Ljava/lang/String;)Z", "kotlin.jvm.PlatformType", "Ljava/lang/String;", "TAG", "Z", "redirectionEnable", "Landroid/net/Uri;", "getRedirectionHost$pendoIO_release", "setRedirectionHost$pendoIO_release", "(Landroid/net/Uri;)V", "redirectionHost", "getHostRedirectionEnable$pendoIO_release", "()Z", "setHostRedirectionEnable$pendoIO_release", "(Z)V", "hostRedirectionEnable", "<set-?>", "f", "getDatacenter", "()Ljava/lang/String;", "setDatacenter$pendoIO_release", "(Ljava/lang/String;)V", "datacenter", "productionUri", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class y {

    /* renamed from: c, reason: from kotlin metadata */
    public static boolean redirectionEnable;

    /* renamed from: d, reason: from kotlin metadata */
    private static Uri redirectionHost;

    /* renamed from: e, reason: from kotlin metadata */
    private static boolean hostRedirectionEnable;

    /* renamed from: a, reason: collision with root package name */
    public static final y f1148a = new y();

    /* renamed from: b, reason: from kotlin metadata */
    private static final String TAG = ViewHierarchyNode.JsonKeys.Y;

    /* renamed from: f, reason: from kotlin metadata */
    private static String datacenter = "";

    private y() {
    }

    @JvmStatic
    public static final void d() {
        hostRedirectionEnable = true;
    }

    public Uri a() {
        return redirectionEnable ? c() : b();
    }

    public final Uri b() {
        Uri e = e();
        return e == null ? f() : e;
    }

    public final Uri c() {
        Uri uri = redirectionHost;
        return uri == null ? f() : uri;
    }

    public Uri e() {
        return b(i0.a(PendoInternal.m()));
    }

    public final Uri f() {
        String a2 = a(datacenter);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        return Uri.parse(a2);
    }

    @JvmStatic
    public static final boolean c(String str) {
        return a(str, false, 2, null);
    }

    public final String a(String dataCenter) {
        if (dataCenter != null) {
            int hashCode = dataCenter.hashCode();
            if (hashCode != 3248) {
                if (hashCode != 3398) {
                    if (hashCode != 3742) {
                        if (hashCode == 116051 && dataCenter.equals("us1")) {
                            return "https://us1.data.pendo.io";
                        }
                    } else if (dataCenter.equals("us")) {
                        return "https://data.pendo.io";
                    }
                } else if (dataCenter.equals("jp")) {
                    return "https://data.jpn.pendo.io";
                }
            } else if (dataCenter.equals("eu")) {
                return "https://data.eu.pendo.io";
            }
        }
        PendoLogger.w(TAG + ", GetEndpoint got an invalid datacenter " + dataCenter + ", please contact Pendo support.", new Object[0]);
        return null;
    }

    public final Uri b(String customUrl) {
        if (j0.a(customUrl)) {
            return null;
        }
        return Uri.parse(customUrl);
    }

    public final boolean d(String newEndpoint) {
        Intrinsics.checkNotNullParameter(newEndpoint, "newEndpoint");
        return a(newEndpoint) != null;
    }

    public final boolean e(String newEndpoint) {
        Intrinsics.checkNotNullParameter(newEndpoint, "newEndpoint");
        return hostRedirectionEnable && (StringsKt.isBlank(newEndpoint) ^ true);
    }

    @JvmStatic
    public static final boolean a(String newEndpoint, boolean isRedirect) {
        if (newEndpoint != null && f1148a.d(newEndpoint)) {
            redirectionEnable = isRedirect;
            datacenter = newEndpoint;
            return true;
        }
        datacenter = "";
        redirectionEnable = false;
        PendoLogger.w(TAG + ", validateAndSetDatacenterEndpoint got an invalid endpoint " + newEndpoint + ", please contact Pendo support.", new Object[0]);
        return false;
    }

    @JvmStatic
    public static final boolean b(String newEndpoint, boolean isRedirect) {
        if (newEndpoint == null || !f1148a.e(newEndpoint)) {
            redirectionEnable = false;
            redirectionHost = null;
            return false;
        }
        StringsKt.replace(newEndpoint, "http://", "https://", true);
        if (!StringsKt.startsWith(newEndpoint, "https", true)) {
            newEndpoint = "https://" + newEndpoint;
        }
        redirectionHost = Uri.parse(newEndpoint);
        redirectionEnable = isRedirect;
        return true;
    }

    public static /* synthetic */ boolean a(String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return a(str, z);
    }
}
