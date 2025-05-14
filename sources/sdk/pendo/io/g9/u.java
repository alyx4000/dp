package sdk.pendo.io.g9;

import java.util.Arrays;

/* loaded from: classes6.dex */
public class u {
    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}
