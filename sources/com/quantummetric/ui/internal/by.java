package com.quantummetric.ui.internal;

import androidx.compose.ui.graphics.ColorKt;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
final class by {

    /* renamed from: a, reason: collision with root package name */
    private static Method f148a = null;
    private static Method b = null;
    private static boolean c = false;

    private static Class<?> a(Class<?> cls) {
        return cls.isPrimitive() ? cls == Integer.TYPE ? Integer.class : cls == Boolean.TYPE ? Boolean.class : cls == Float.TYPE ? Float.class : cls == Long.TYPE ? Long.class : cls == Double.TYPE ? Double.class : cls == Short.TYPE ? Short.class : cls == Byte.TYPE ? Byte.class : cls == Character.TYPE ? Character.class : cls : cls;
    }

    static Object a(long j) {
        try {
            Method method = f148a;
            if (method != null) {
                return method.invoke(null, Long.valueOf(j));
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    static Object a(Object obj) {
        try {
            if (b == null && !c) {
                b = a("getConsumedScroll", obj.getClass(), new Object[0]);
            }
            Method method = b;
            if (method != null) {
                return method.invoke(obj, new Object[0]);
            }
            return null;
        } catch (Throwable unused) {
            c = true;
            return null;
        }
    }

    static Object a(Object obj, Class<?> cls) {
        if (obj != null) {
            try {
                for (Field field : obj.getClass().getDeclaredFields()) {
                    if (field.getType() == cls) {
                        field.setAccessible(true);
                        return field.get(obj);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    static Object a(Object obj, Class<?> cls, String... strArr) throws NoSuchFieldException, IllegalAccessException {
        int i = 0;
        while (i < strArr.length) {
            Field declaredField = i == 0 ? cls.getDeclaredField(strArr[i]) : obj.getClass().getDeclaredField(strArr[i]);
            declaredField.setAccessible(true);
            obj = declaredField.get(obj);
            i++;
        }
        return obj;
    }

    static Object a(Object obj, String... strArr) throws NoSuchFieldException, IllegalAccessException {
        for (String str : strArr) {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            obj = declaredField.get(obj);
        }
        return obj;
    }

    static <T> T a(String str, Class cls, Object obj, Object... objArr) {
        try {
            Method a2 = a(str, cls, objArr);
            a2.setAccessible(true);
            return (T) a2.invoke(obj, objArr);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Method a(String str, Class cls, Object... objArr) throws NoSuchMethodException {
        int i;
        if (objArr.length == 0) {
            return cls.getDeclaredMethod(str, new Class[0]);
        }
        for (Method method : cls.getDeclaredMethods()) {
            if (method.getName().equals(str)) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == objArr.length) {
                    for (0; i < parameterTypes.length; i + 1) {
                        i = a(parameterTypes[i]).isInstance(objArr[i]) ? i + 1 : 0;
                    }
                    return method;
                }
                continue;
            }
        }
        return null;
    }

    static void a() {
        try {
            for (Method method : ColorKt.class.getDeclaredMethods()) {
                if (method.getName().contains("toArgb")) {
                    f148a = method;
                    return;
                }
            }
        } catch (Throwable unused) {
        }
    }

    static Object b(Object obj, Class<?> cls, String... strArr) {
        try {
            return a(obj, cls, strArr);
        } catch (Exception unused) {
            return null;
        }
    }

    static Object b(Object obj, String... strArr) {
        try {
            return a(obj, strArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
