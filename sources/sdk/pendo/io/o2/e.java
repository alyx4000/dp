package sdk.pendo.io.o2;

import java.io.Serializable;

/* loaded from: classes6.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final a f1455a = new a();

    public static class a implements Serializable {
        a() {
        }
    }

    public static <T> T a(T t, T t2) {
        return t != null ? t : t2;
    }

    public static String a(Object obj) {
        if (obj == null) {
            return null;
        }
        String name = obj.getClass().getName();
        String hexString = Integer.toHexString(System.identityHashCode(obj));
        StringBuilder sb = new StringBuilder(name.length() + 1 + hexString.length());
        sb.append(name).append('@').append(hexString);
        return sb.toString();
    }

    public static void a(StringBuffer stringBuffer, Object obj) {
        h.a(obj, "object", new Object[0]);
        String name = obj.getClass().getName();
        String hexString = Integer.toHexString(System.identityHashCode(obj));
        stringBuffer.ensureCapacity(stringBuffer.length() + name.length() + 1 + hexString.length());
        stringBuffer.append(name).append('@').append(hexString);
    }
}
