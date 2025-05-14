package sdk.pendo.io.g9;

import java.lang.reflect.Field;
import sdk.pendo.io.logging.PendoLogger;

/* loaded from: classes6.dex */
public final class f0 {
    static Field a(String str, Class cls) {
        if (str == null || cls == null) {
            PendoLogger.e("can't call findField with null objects", new Object[0]);
            return null;
        }
        for (Class cls2 = cls; cls2 != Object.class; cls2 = cls2.getSuperclass()) {
            for (Field field : cls2.getDeclaredFields()) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found for class " + cls);
    }

    private static Object b(String str, Object obj) {
        if (obj == null) {
            return null;
        }
        Field a2 = a(str, (Class) obj.getClass());
        a2.setAccessible(true);
        return a2.get(obj);
    }

    public static Object a(String str, Object obj) {
        try {
            return b(str, obj);
        } catch (Exception e) {
            String message = e.getMessage();
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder("field name: ");
            if (str == null) {
                str = "";
            }
            objArr[0] = sb.append(str).toString();
            PendoLogger.e(e, message, objArr);
            return null;
        }
    }
}
