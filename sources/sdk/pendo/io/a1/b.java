package sdk.pendo.io.a1;

import java.security.Security;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static sdk.pendo.io.h7.a f836a = sdk.pendo.io.h7.b.a((Class<?>) b.class);

    public static boolean a(String str, String str2) {
        Set<String> algorithms = Security.getAlgorithms(str);
        Iterator<String> it = algorithms.iterator();
        while (it.hasNext()) {
            if (it.next().equalsIgnoreCase(str2)) {
                return true;
            }
        }
        f836a.a("{} is NOT available for {}. Algorithms available from underlying JCE: {}", str2, str, algorithms);
        return false;
    }
}
