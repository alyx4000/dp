package sdk.pendo.io.l7;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.regex.Pattern;

/* loaded from: classes6.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static Pattern f1340a = Pattern.compile("^http|ws$");
    private static Pattern b = Pattern.compile("^(http|ws)s$");

    public static String a(URL url) {
        String protocol = url.getProtocol();
        int port = url.getPort();
        if (port == -1) {
            if (f1340a.matcher(protocol).matches()) {
                port = 80;
            } else if (b.matcher(protocol).matches()) {
                port = 443;
            }
        }
        return protocol + "://" + url.getHost() + ":" + port;
    }

    public static URL a(URI uri) {
        String scheme = uri.getScheme();
        if (scheme == null || !scheme.matches("^https?|wss?$")) {
            scheme = "https";
        }
        int port = uri.getPort();
        if (port == -1) {
            if (f1340a.matcher(scheme).matches()) {
                port = 80;
            } else if (b.matcher(scheme).matches()) {
                port = 443;
            }
        }
        String rawPath = uri.getRawPath();
        if (rawPath == null || rawPath.length() == 0) {
            rawPath = "/";
        }
        String rawUserInfo = uri.getRawUserInfo();
        String rawQuery = uri.getRawQuery();
        String rawFragment = uri.getRawFragment();
        try {
            return new URL(scheme + "://" + (rawUserInfo != null ? rawUserInfo + "@" : "") + uri.getHost() + (port != -1 ? ":" + port : "") + rawPath + (rawQuery != null ? "?" + rawQuery : "") + (rawFragment != null ? "#" + rawFragment : ""));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
