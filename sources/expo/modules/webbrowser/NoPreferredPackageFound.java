package expo.modules.webbrowser;

import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;

/* compiled from: WebBrowserExceptions.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lexpo/modules/webbrowser/NoPreferredPackageFound;", "Lexpo/modules/kotlin/exception/CodedException;", "()V", "expo-web-browser_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NoPreferredPackageFound extends CodedException {
    public NoPreferredPackageFound() {
        super("PREFERRED_PACKAGE_NOT_FOUND", "Cannot determine preferred package without satisfying it", null);
    }
}
