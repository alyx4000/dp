package sdk.pendo.io.b2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes6.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static final a f883a = new a();

    public static class a implements sdk.pendo.io.z1.j {
        @Override // sdk.pendo.io.z1.j
        public boolean a(Field field, Method method) {
            sdk.pendo.io.c2.a aVar = (sdk.pendo.io.c2.a) method.getAnnotation(sdk.pendo.io.c2.a.class);
            return aVar == null || !aVar.value();
        }
    }

    public static Object a(Object obj, Class<?> cls) {
        if (obj == null) {
            return null;
        }
        if (cls.isAssignableFrom(obj.getClass())) {
            return obj;
        }
        if (!cls.isPrimitive()) {
            if (cls.isEnum()) {
                return Enum.valueOf(cls, obj.toString());
            }
            if (cls == Integer.class) {
                return obj instanceof Number ? Integer.valueOf(((Number) obj).intValue()) : Integer.valueOf(obj.toString());
            }
            if (cls == Long.class) {
                return obj instanceof Number ? Long.valueOf(((Number) obj).longValue()) : Long.valueOf(obj.toString());
            }
            if (cls == Short.class) {
                return obj instanceof Number ? Short.valueOf(((Number) obj).shortValue()) : Short.valueOf(obj.toString());
            }
            if (cls == Byte.class) {
                return obj instanceof Number ? Byte.valueOf(((Number) obj).byteValue()) : Byte.valueOf(obj.toString());
            }
            if (cls == Float.class) {
                return obj instanceof Number ? Float.valueOf(((Number) obj).floatValue()) : Float.valueOf(obj.toString());
            }
            if (cls == Double.class) {
                return obj instanceof Number ? Double.valueOf(((Number) obj).doubleValue()) : Double.valueOf(obj.toString());
            }
            if (cls == Character.class) {
                String cls2 = cls.toString();
                if (cls2.length() > 0) {
                    return Character.valueOf(cls2.charAt(0));
                }
            }
            throw new RuntimeException("Object: Can not Convert " + obj.getClass().getName() + " to " + cls.getName());
        }
        if (obj instanceof Number) {
            return obj;
        }
        if (cls == Integer.TYPE) {
            return Integer.valueOf(obj.toString());
        }
        if (cls == Short.TYPE) {
            return Short.valueOf(obj.toString());
        }
        if (cls == Long.TYPE) {
            return Long.valueOf(obj.toString());
        }
        if (cls == Byte.TYPE) {
            return Byte.valueOf(obj.toString());
        }
        if (cls == Float.TYPE) {
            return Float.valueOf(obj.toString());
        }
        if (cls == Double.TYPE) {
            return Double.valueOf(obj.toString());
        }
        if (cls == Character.TYPE) {
            String cls3 = cls.toString();
            if (cls3.length() > 0) {
                return Character.valueOf(cls3.charAt(0));
            }
        } else if (cls == Boolean.TYPE) {
            return (Boolean) obj;
        }
        throw new RuntimeException("Primitive: Can not convert " + obj.getClass().getName() + " to " + cls.getName());
    }

    public static String b(String str) {
        int length = str.length();
        char[] cArr = new char[length + 2];
        cArr[0] = 'i';
        cArr[1] = 's';
        char charAt = str.charAt(0);
        if (charAt >= 'a' && charAt <= 'z') {
            charAt = (char) (charAt - ' ');
        }
        cArr[2] = charAt;
        for (int i = 1; i < length; i++) {
            cArr[i + 2] = str.charAt(i);
        }
        return new String(cArr);
    }

    public static String a(String str) {
        int length = str.length();
        char[] cArr = new char[length + 3];
        cArr[0] = 'g';
        cArr[1] = 'e';
        cArr[2] = 't';
        char charAt = str.charAt(0);
        if (charAt >= 'a' && charAt <= 'z') {
            charAt = (char) (charAt - ' ');
        }
        cArr[3] = charAt;
        for (int i = 1; i < length; i++) {
            cArr[i + 3] = str.charAt(i);
        }
        return new String(cArr);
    }
}
