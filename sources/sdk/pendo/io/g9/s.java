package sdk.pendo.io.g9;

import android.provider.Settings;
import java.nio.charset.Charset;
import sdk.pendo.io.PendoInternal;

/* loaded from: classes6.dex */
public final class s {
    public static String a() {
        String a2 = m0.a(Settings.Secure.getString(PendoInternal.m().getContentResolver(), "android_id").getBytes(Charset.forName("UTF-8")));
        StringBuilder sb = new StringBuilder("IN:");
        for (int i = 0; i < 4; i += 2) {
            sb.append(a2.charAt(i));
            sb.append(a2.charAt(i + 1));
            sb.append(":");
        }
        sb.append("ST");
        return sb.toString();
    }
}
