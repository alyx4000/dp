package sdk.pendo.io.t4;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* loaded from: classes6.dex */
class r1 {

    static class a implements PrivilegedAction<Class<?>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f1604a;

        a(String str) {
            this.f1604a = str;
        }

        @Override // java.security.PrivilegedAction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Class<?> run() {
            try {
                ClassLoader classLoader = r1.class.getClassLoader();
                return classLoader == null ? Class.forName(this.f1604a) : classLoader.loadClass(this.f1604a);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static class b<T> implements PrivilegedAction<Constructor<T>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f1605a;
        final /* synthetic */ Class[] b;

        b(String str, Class[] clsArr) {
            this.f1605a = str;
            this.b = clsArr;
        }

        @Override // java.security.PrivilegedAction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Constructor<T> run() {
            try {
                ClassLoader classLoader = r1.class.getClassLoader();
                Class<?> cls = classLoader == null ? Class.forName(this.f1605a) : classLoader.loadClass(this.f1605a);
                if (cls != null) {
                    return (Constructor<T>) cls.getDeclaredConstructor(this.b);
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
    }

    static class c implements PrivilegedAction<Method> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f1606a;
        final /* synthetic */ String b;
        final /* synthetic */ Class[] c;

        c(String str, String str2, Class[] clsArr) {
            this.f1606a = str;
            this.b = str2;
            this.c = clsArr;
        }

        @Override // java.security.PrivilegedAction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Method run() {
            try {
                ClassLoader classLoader = r1.class.getClassLoader();
                Class<?> cls = classLoader == null ? Class.forName(this.f1606a) : classLoader.loadClass(this.f1606a);
                if (cls != null) {
                    return cls.getMethod(this.b, this.c);
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
    }

    static class d implements PrivilegedAction<Method[]> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f1607a;

        d(String str) {
            this.f1607a = str;
        }

        @Override // java.security.PrivilegedAction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Method[] run() {
            try {
                ClassLoader classLoader = r1.class.getClassLoader();
                Class<?> cls = classLoader == null ? Class.forName(this.f1607a) : classLoader.loadClass(this.f1607a);
                if (cls != null) {
                    return cls.getMethods();
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
    }

    static class e implements PrivilegedAction<Integer> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f1608a;
        final /* synthetic */ String b;

        e(String str, String str2) {
            this.f1608a = str;
            this.b = str2;
        }

        @Override // java.security.PrivilegedAction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer run() {
            Field field;
            try {
                ClassLoader classLoader = r1.class.getClassLoader();
                Class<?> cls = classLoader == null ? Class.forName(this.f1608a) : classLoader.loadClass(this.f1608a);
                if (cls == null || (field = cls.getField(this.b)) == null) {
                    return null;
                }
                if (Integer.TYPE == field.getType()) {
                    return Integer.valueOf(field.getInt(null));
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
    }

    static class f implements PrivilegedAction<Object> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f1609a;
        final /* synthetic */ Object b;
        final /* synthetic */ Object[] c;

        f(Method method, Object obj, Object[] objArr) {
            this.f1609a = method;
            this.b = obj;
            this.c = objArr;
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            try {
                return this.f1609a.invoke(this.b, this.c);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    r1() {
    }

    static Method a(Method[] methodArr, String str) {
        if (methodArr == null) {
            return null;
        }
        for (Method method : methodArr) {
            if (method.getName().equals(str)) {
                return method;
            }
        }
        return null;
    }

    static Method[] b(String str) {
        if (str == null) {
            return null;
        }
        return (Method[]) AccessController.doPrivileged(new d(str));
    }

    static Class<?> a(String str) {
        if (str == null) {
            return null;
        }
        return (Class) AccessController.doPrivileged(new a(str));
    }

    static boolean b(Method[] methodArr, String str) {
        return a(methodArr, str) != null;
    }

    static <T> Constructor<T> a(String str, Class<?>... clsArr) {
        if (str == null) {
            return null;
        }
        return (Constructor) AccessController.doPrivileged(new b(str, clsArr));
    }

    static Method a(String str, String str2, Class<?>... clsArr) {
        if (str == null || str2 == null) {
            return null;
        }
        return (Method) AccessController.doPrivileged(new c(str, str2, clsArr));
    }

    static Integer a(String str, String str2) {
        return (Integer) AccessController.doPrivileged(new e(str, str2));
    }

    static Integer a(String str, String str2, int i) {
        Integer a2 = a(str, str2);
        if (a2 != null) {
            i = a2.intValue();
        }
        return Integer.valueOf(i);
    }

    static Object a(Object obj, Method method) {
        return a(obj, method, new Object[0]);
    }

    static Object a(Object obj, Method method, Object... objArr) {
        return AccessController.doPrivileged(new f(method, obj, objArr));
    }

    static void a(Object obj, Method method, Object obj2) {
        a(obj, method, obj2);
    }
}
