package sdk.pendo.io.r4;

import java.net.Socket;
import java.security.Principal;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.X509ExtendedKeyManager;

/* loaded from: classes6.dex */
public abstract class j extends X509ExtendedKeyManager {
    protected abstract l a(String str, String str2);

    public l a(String[] strArr, Principal[] principalArr, Socket socket) {
        l a2;
        if (strArr == null) {
            return null;
        }
        for (String str : strArr) {
            String chooseClientAlias = chooseClientAlias(new String[]{str}, principalArr, socket);
            if (chooseClientAlias != null && (a2 = a(false, str, chooseClientAlias, socket)) != null) {
                return a2;
            }
        }
        return null;
    }

    public l b(String[] strArr, Principal[] principalArr, SSLEngine sSLEngine) {
        l a2;
        if (strArr == null) {
            return null;
        }
        for (String str : strArr) {
            String chooseEngineServerAlias = chooseEngineServerAlias(str, principalArr, sSLEngine);
            if (chooseEngineServerAlias != null && (a2 = a(true, str, chooseEngineServerAlias, sSLEngine)) != null) {
                return a2;
            }
        }
        return null;
    }

    public l a(String[] strArr, Principal[] principalArr, SSLEngine sSLEngine) {
        l a2;
        if (strArr == null) {
            return null;
        }
        for (String str : strArr) {
            String chooseEngineClientAlias = chooseEngineClientAlias(new String[]{str}, principalArr, sSLEngine);
            if (chooseEngineClientAlias != null && (a2 = a(false, str, chooseEngineClientAlias, sSLEngine)) != null) {
                return a2;
            }
        }
        return null;
    }

    public l b(String[] strArr, Principal[] principalArr, Socket socket) {
        l a2;
        if (strArr == null) {
            return null;
        }
        for (String str : strArr) {
            String chooseServerAlias = chooseServerAlias(str, principalArr, socket);
            if (chooseServerAlias != null && (a2 = a(true, str, chooseServerAlias, socket)) != null) {
                return a2;
            }
        }
        return null;
    }

    protected l a(boolean z, String str, String str2, Socket socket) {
        return a(str, str2);
    }

    protected l a(boolean z, String str, String str2, SSLEngine sSLEngine) {
        return a(str, str2);
    }
}
