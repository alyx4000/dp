package sdk.pendo.io.m0;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* loaded from: classes6.dex */
public abstract class l {

    class a extends l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f1373a;
        final /* synthetic */ Object b;

        a(Method method, Object obj) {
            this.f1373a = method;
            this.b = obj;
        }

        @Override // sdk.pendo.io.m0.l
        public <T> T b(Class<T> cls) {
            l.a(cls);
            return (T) this.f1373a.invoke(this.b, cls);
        }
    }

    class b extends l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f1374a;
        final /* synthetic */ int b;

        b(Method method, int i) {
            this.f1374a = method;
            this.b = i;
        }

        @Override // sdk.pendo.io.m0.l
        public <T> T b(Class<T> cls) {
            l.a(cls);
            return (T) this.f1374a.invoke(null, cls, Integer.valueOf(this.b));
        }
    }

    class c extends l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f1375a;

        c(Method method) {
            this.f1375a = method;
        }

        @Override // sdk.pendo.io.m0.l
        public <T> T b(Class<T> cls) {
            l.a(cls);
            return (T) this.f1375a.invoke(null, cls, Object.class);
        }
    }

    class d extends l {
        d() {
        }

        @Override // sdk.pendo.io.m0.l
        public <T> T b(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls + ". Usage of JDK sun.misc.Unsafe is enabled, but it could not be used. Make sure your runtime is configured correctly.");
        }
    }

    static void a(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: " + cls.getName());
        }
        if (Modifier.isAbstract(modifiers)) {
            throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + cls.getName());
        }
    }

    public abstract <T> T b(Class<T> cls);

    public static l a() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new a(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    int intValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    return new b(declaredMethod2, intValue);
                } catch (Exception unused2) {
                    Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod3.setAccessible(true);
                    return new c(declaredMethod3);
                }
            } catch (Exception unused3) {
                return new d();
            }
        }
    }
}
