package sdk.pendo.io.z1;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.commons.io.IOUtils;
import sdk.pendo.io.a.d0;
import sdk.pendo.io.a.s;
import sdk.pendo.io.a.u;

/* loaded from: classes4.dex */
public class e {
    private static String j = d0.b((Class<?>) d.class);

    /* renamed from: a, reason: collision with root package name */
    final Class<?> f1870a;
    final b[] b;
    final i c;
    final String d;
    final String e;
    final String f;
    final String g;
    final HashMap<Class<?>, Method> h = new HashMap<>();
    Class<? extends Exception> i = NoSuchFieldException.class;

    public e(Class<?> cls, b[] bVarArr, i iVar) {
        this.f1870a = cls;
        this.b = bVarArr;
        this.c = iVar;
        String name = cls.getName();
        this.d = name;
        this.e = name.startsWith("java.") ? "external.sdk.pendo.io.jsonsmart.asm." + name + "AccAccess" : name.concat("AccAccess");
        this.f = this.e.replace('.', IOUtils.DIR_SEPARATOR_UNIX);
        this.g = name.replace('.', IOUtils.DIR_SEPARATOR_UNIX);
    }

    private void b(u uVar, Class<?> cls) {
        String b = d0.b(cls);
        uVar.a(187, b);
        uVar.a(89);
        uVar.a("mapping " + this.d + " failed to map field:");
        uVar.d(25, 2);
        uVar.a(182, "java/lang/String", "concat", "(Ljava/lang/String;)Ljava/lang/String;", false);
        uVar.a(183, b, "<init>", "(Ljava/lang/String;)V", false);
        uVar.a(191);
    }

    public void a(Class<?> cls) {
        if (cls == null) {
            return;
        }
        for (Method method : cls.getMethods()) {
            if ((method.getModifiers() & 8) != 0) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0].equals(Object.class)) {
                    Class<?> returnType = method.getReturnType();
                    if (!returnType.equals(Void.TYPE)) {
                        this.h.put(returnType, method);
                    }
                }
            }
        }
    }

    public void a(Iterable<Class<?>> iterable) {
        if (iterable == null) {
            return;
        }
        Iterator<Class<?>> it = iterable.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0276  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Class<?> a() {
        /*
            Method dump skipped, instructions count: 1019
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.z1.e.a():java.lang.Class");
    }

    private void a(u uVar, int i, int i2, s sVar) {
        int i3;
        uVar.d(21, i);
        if (i2 == 0) {
            uVar.a(154, sVar);
            return;
        }
        if (i2 == 1) {
            uVar.a(4);
        } else if (i2 == 2) {
            uVar.a(5);
        } else if (i2 == 3) {
            uVar.a(6);
        } else {
            if (i2 == 4) {
                i3 = 7;
            } else if (i2 == 5) {
                i3 = 8;
            } else {
                if (i2 < 6) {
                    throw new RuntimeException("non supported negative values");
                }
                uVar.b(16, i2);
            }
            uVar.a(i3);
        }
        uVar.a(160, sVar);
    }

    private void a(u uVar, b bVar) {
        int i;
        s sVar;
        int i2;
        String str;
        String str2;
        String str3;
        boolean z;
        u uVar2;
        Method method;
        uVar.d(25, 1);
        uVar.a(192, this.g);
        uVar.d(25, 3);
        d0 c = d0.c(bVar.d());
        Class<?> d = bVar.d();
        String b = d0.b(d);
        Method method2 = this.h.get(d);
        if (method2 != null) {
            uVar.a(184, d0.b(method2.getDeclaringClass()), method2.getName(), d0.a(method2), false);
        } else {
            if (bVar.e()) {
                s sVar2 = new s();
                uVar.a(198, sVar2);
                uVar.d(25, 3);
                sVar = sVar2;
                uVar.a(182, "java/lang/Object", "toString", "()Ljava/lang/String;", false);
                str3 = "(Ljava/lang/String;)L" + b + ";";
                i2 = 184;
                str2 = "valueOf";
                z = false;
                uVar2 = uVar;
                str = b;
            } else if (d.equals(String.class)) {
                sVar = new s();
                uVar.a(198, sVar);
                uVar.d(25, 3);
                i2 = 182;
                str = "java/lang/Object";
                str2 = "toString";
                str3 = "()Ljava/lang/String;";
                z = false;
                uVar2 = uVar;
            } else {
                i = 192;
                uVar.a(i, b);
            }
            uVar2.a(i2, str, str2, str3, z);
            uVar.d(58, 3);
            uVar.a(sVar);
            uVar2.a(3, 0, (Object[]) null, 0, (Object[]) null);
            uVar.d(25, 1);
            i = 192;
            uVar.a(192, this.g);
            uVar.d(25, 3);
            uVar.a(i, b);
        }
        if (bVar.f() || (method = bVar.b) == null) {
            uVar.a(181, this.g, bVar.c(), c.a());
        } else {
            uVar.a(182, this.g, bVar.b.getName(), d0.a(method), false);
        }
        uVar.a(177);
    }

    private void a(u uVar, Class<?> cls) {
        String b = d0.b(cls);
        uVar.a(187, b);
        uVar.a(89);
        uVar.a("mapping " + this.d + " failed to map field:");
        uVar.d(21, 2);
        uVar.a(184, "java/lang/Integer", "toString", "(I)Ljava/lang/String;", false);
        uVar.a(182, "java/lang/String", "concat", "(Ljava/lang/String;)Ljava/lang/String;", false);
        uVar.a(183, b, "<init>", "(Ljava/lang/String;)V", false);
        uVar.a(191);
    }
}
