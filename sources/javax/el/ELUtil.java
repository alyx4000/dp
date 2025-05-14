package javax.el;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/* loaded from: classes2.dex */
class ELUtil {
    public static ExpressionFactory exprFactory = ExpressionFactory.newInstance();
    private static ThreadLocal<Map<String, ResourceBundle>> instance = new ThreadLocal<Map<String, ResourceBundle>>() { // from class: javax.el.ELUtil.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Map<String, ResourceBundle> initialValue() {
            return null;
        }
    };

    private ELUtil() {
    }

    private static Map<String, ResourceBundle> getCurrentInstance() {
        Map<String, ResourceBundle> map = instance.get();
        if (map != null) {
            return map;
        }
        HashMap hashMap = new HashMap();
        setCurrentInstance(hashMap);
        return hashMap;
    }

    private static void setCurrentInstance(Map<String, ResourceBundle> map) {
        instance.set(map);
    }

    public static String getExceptionMessageString(ELContext eLContext, String str) {
        return getExceptionMessageString(eLContext, str, null);
    }

    public static String getExceptionMessageString(ELContext eLContext, String str, Object[] objArr) {
        if (eLContext == null || str == null) {
            return "";
        }
        Locale locale = eLContext.getLocale();
        if (locale == null) {
            locale = Locale.getDefault();
        }
        if (locale == null) {
            return "";
        }
        Map<String, ResourceBundle> currentInstance = getCurrentInstance();
        ResourceBundle resourceBundle = currentInstance.get(locale.toString());
        if (resourceBundle == null) {
            resourceBundle = ResourceBundle.getBundle("javax.el.PrivateMessages", locale);
            currentInstance.put(locale.toString(), resourceBundle);
        }
        if (resourceBundle == null) {
            return "";
        }
        try {
            String string = resourceBundle.getString(str);
            if (objArr != null) {
                string = MessageFormat.format(string, objArr);
            }
            return string;
        } catch (IllegalArgumentException unused) {
            return "Can't get localized message: parameters to message appear to be incorrect.  Message to format: " + str;
        } catch (MissingResourceException unused2) {
            return "Missing Resource in EL implementation: ???" + str + "???";
        } catch (Exception unused3) {
            return "Exception resolving message in EL implementation: ???" + str + "???";
        }
    }

    static ExpressionFactory getExpressionFactory() {
        return exprFactory;
    }

    static Constructor<?> findConstructor(Class<?> cls, Class<?>[] clsArr, Object[] objArr) {
        if (clsArr != null) {
            try {
                Constructor<?> constructor = cls.getConstructor(clsArr);
                if (Modifier.isPublic(constructor.getModifiers())) {
                    return constructor;
                }
            } catch (NoSuchMethodException unused) {
            }
            throw new MethodNotFoundException("The constructor for class " + cls + " not found or accessible");
        }
        int length = objArr == null ? 0 : objArr.length;
        for (Constructor<?> constructor2 : cls.getConstructors()) {
            if (constructor2.isVarArgs() || constructor2.getParameterTypes().length == length) {
                return constructor2;
            }
        }
        throw new MethodNotFoundException("The constructor for class " + cls + " not found");
    }

    static Object invokeConstructor(ELContext eLContext, Constructor<?> constructor, Object[] objArr) {
        Object[] objArr2;
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        if (parameterTypes.length <= 0 || constructor.isVarArgs()) {
            objArr2 = null;
        } else {
            objArr2 = new Object[parameterTypes.length];
            for (int i = 0; i < parameterTypes.length; i++) {
                objArr2[i] = eLContext.convertToType(objArr[i], parameterTypes[i]);
            }
        }
        try {
            return constructor.newInstance(objArr2);
        } catch (IllegalAccessException e) {
            throw new ELException(e);
        } catch (InstantiationException e2) {
            throw new ELException(e2.getCause());
        } catch (InvocationTargetException e3) {
            throw new ELException(e3.getCause());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0018, code lost:
    
        if (java.lang.reflect.Modifier.isStatic(r6) != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.lang.reflect.Method findMethod(java.lang.Class<?> r3, java.lang.String r4, java.lang.Class<?>[] r5, java.lang.Object[] r6, boolean r7) {
        /*
            java.lang.String r0 = "Method "
            if (r5 == 0) goto L3e
            java.lang.reflect.Method r5 = r3.getMethod(r4, r5)     // Catch: java.lang.NoSuchMethodException -> L1b
            int r6 = r5.getModifiers()     // Catch: java.lang.NoSuchMethodException -> L1b
            boolean r1 = java.lang.reflect.Modifier.isPublic(r6)     // Catch: java.lang.NoSuchMethodException -> L1b
            if (r1 == 0) goto L1b
            if (r7 == 0) goto L1a
            boolean r6 = java.lang.reflect.Modifier.isStatic(r6)     // Catch: java.lang.NoSuchMethodException -> L1b
            if (r6 == 0) goto L1b
        L1a:
            return r5
        L1b:
            javax.el.MethodNotFoundException r5 = new javax.el.MethodNotFoundException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r0)
            java.lang.StringBuilder r4 = r6.append(r4)
            java.lang.String r6 = "for class "
            java.lang.StringBuilder r4 = r4.append(r6)
            java.lang.StringBuilder r3 = r4.append(r3)
            java.lang.String r4 = " not found or accessible"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            r5.<init>(r3)
            throw r5
        L3e:
            r5 = 0
            if (r6 != 0) goto L43
            r6 = r5
            goto L44
        L43:
            int r6 = r6.length
        L44:
            java.lang.reflect.Method[] r3 = r3.getMethods()
            int r7 = r3.length
        L49:
            if (r5 >= r7) goto L68
            r1 = r3[r5]
            java.lang.String r2 = r1.getName()
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L65
            boolean r2 = r1.isVarArgs()
            if (r2 != 0) goto L64
            java.lang.Class[] r2 = r1.getParameterTypes()
            int r2 = r2.length
            if (r2 != r6) goto L65
        L64:
            return r1
        L65:
            int r5 = r5 + 1
            goto L49
        L68:
            javax.el.MethodNotFoundException r3 = new javax.el.MethodNotFoundException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r0)
            java.lang.StringBuilder r4 = r5.append(r4)
            java.lang.String r5 = " not found"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.el.ELUtil.findMethod(java.lang.Class, java.lang.String, java.lang.Class[], java.lang.Object[], boolean):java.lang.reflect.Method");
    }

    static Object invokeMethod(ELContext eLContext, Method method, Object obj, Object[] objArr) {
        Object[] objArr2;
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length <= 0 || method.isVarArgs()) {
            objArr2 = null;
        } else {
            objArr2 = new Object[parameterTypes.length];
            for (int i = 0; i < parameterTypes.length; i++) {
                objArr2[i] = eLContext.convertToType(objArr[i], parameterTypes[i]);
            }
        }
        try {
            return method.invoke(obj, objArr2);
        } catch (IllegalAccessException e) {
            throw new ELException(e);
        } catch (InvocationTargetException e2) {
            throw new ELException(e2.getCause());
        }
    }
}
