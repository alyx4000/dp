package external.sdk.pendo.io.mozilla.javascript;

import external.sdk.pendo.io.mozilla.javascript.ObjToIntMap;
import io.sentry.SentryEnvelopeItemHeader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import org.apache.commons.io.IOUtils;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;
import sdk.pendo.io.v2.c;

/* loaded from: classes2.dex */
public final class JavaAdapter implements IdFunctionCall {
    private static final Object FTAG = "JavaAdapter";
    private static final int Id_JavaAdapter = 1;

    static class JavaAdapterSignature {
        Class<?>[] interfaces;
        ObjToIntMap names;
        Class<?> superClass;

        JavaAdapterSignature(Class<?> cls, Class<?>[] clsArr, ObjToIntMap objToIntMap) {
            this.superClass = cls;
            this.interfaces = clsArr;
            this.names = objToIntMap;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof JavaAdapterSignature)) {
                return false;
            }
            JavaAdapterSignature javaAdapterSignature = (JavaAdapterSignature) obj;
            if (this.superClass != javaAdapterSignature.superClass) {
                return false;
            }
            Class<?>[] clsArr = this.interfaces;
            Class<?>[] clsArr2 = javaAdapterSignature.interfaces;
            if (clsArr != clsArr2) {
                if (clsArr.length == clsArr2.length) {
                    int i = 0;
                    while (true) {
                        Class<?>[] clsArr3 = this.interfaces;
                        if (i >= clsArr3.length) {
                            break;
                        }
                        if (clsArr3[i] != javaAdapterSignature.interfaces[i]) {
                            return false;
                        }
                        i++;
                    }
                } else {
                    return false;
                }
            }
            if (this.names.size() != javaAdapterSignature.names.size()) {
                return false;
            }
            ObjToIntMap.Iterator iterator = new ObjToIntMap.Iterator(this.names);
            iterator.start();
            while (!iterator.done()) {
                String str = (String) iterator.getKey();
                int value = iterator.getValue();
                if (value != javaAdapterSignature.names.get(str, value + 1)) {
                    return false;
                }
                iterator.next();
            }
            return true;
        }

        public int hashCode() {
            return (this.superClass.hashCode() + Arrays.hashCode(this.interfaces)) ^ this.names.size();
        }
    }

    static int appendMethodSignature(Class<?>[] clsArr, Class<?> cls, StringBuilder sb) {
        sb.append('(');
        int length = clsArr.length + 1;
        for (Class<?> cls2 : clsArr) {
            appendTypeString(sb, cls2);
            if (cls2 == Long.TYPE || cls2 == Double.TYPE) {
                length++;
            }
        }
        sb.append(')');
        appendTypeString(sb, cls);
        return length;
    }

    private static void appendOverridableMethods(Class<?> cls, ArrayList<Method> arrayList, HashSet<String> hashSet) {
        Method[] declaredMethods = cls.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            StringBuilder append = new StringBuilder().append(declaredMethods[i].getName());
            Method method = declaredMethods[i];
            String sb = append.append(getMethodSignature(method, method.getParameterTypes())).toString();
            if (!hashSet.contains(sb)) {
                int modifiers = declaredMethods[i].getModifiers();
                if (!Modifier.isStatic(modifiers)) {
                    if (!Modifier.isFinal(modifiers)) {
                        if (Modifier.isPublic(modifiers) || Modifier.isProtected(modifiers)) {
                            arrayList.add(declaredMethods[i]);
                        }
                    }
                    hashSet.add(sb);
                }
            }
        }
    }

    private static StringBuilder appendTypeString(StringBuilder sb, Class<?> cls) {
        char c;
        while (cls.isArray()) {
            sb.append('[');
            cls = cls.getComponentType();
        }
        if (cls.isPrimitive()) {
            c = cls == Boolean.TYPE ? Matrix.MATRIX_TYPE_ZERO : cls == Long.TYPE ? 'J' : Character.toUpperCase(cls.getName().charAt(0));
        } else {
            sb.append(Matrix.MATRIX_TYPE_RANDOM_LT);
            sb.append(cls.getName().replace('.', IOUtils.DIR_SEPARATOR_UNIX));
            c = ';';
        }
        sb.append(c);
        return sb;
    }

    public static Object callMethod(ContextFactory contextFactory, final Scriptable scriptable, final Function function, final Object[] objArr, final long j) {
        if (function == null) {
            return null;
        }
        if (contextFactory == null) {
            contextFactory = ContextFactory.getGlobal();
        }
        final Scriptable parentScope = function.getParentScope();
        if (j == 0) {
            return Context.call(contextFactory, function, parentScope, scriptable, objArr);
        }
        Context currentContext = Context.getCurrentContext();
        return currentContext != null ? doCall(currentContext, parentScope, scriptable, function, objArr, j) : contextFactory.call(new ContextAction() { // from class: external.sdk.pendo.io.mozilla.javascript.JavaAdapter$$ExternalSyntheticLambda0
            @Override // external.sdk.pendo.io.mozilla.javascript.ContextAction
            public final Object run(Context context) {
                Object doCall;
                doCall = JavaAdapter.doCall(context, Scriptable.this, scriptable, function, objArr, j);
                return doCall;
            }
        });
    }

    public static Object convertResult(Object obj, Class<?> cls) {
        if (obj != Undefined.instance || cls == ScriptRuntime.ObjectClass || cls == ScriptRuntime.StringClass) {
            return Context.jsToJava(obj, cls);
        }
        return null;
    }

    public static byte[] createAdapterCode(ObjToIntMap objToIntMap, String str, Class<?> cls, Class<?>[] clsArr, String str2) {
        Class<?> cls2;
        Method[] methodArr;
        int i;
        Method[] methodArr2;
        c cVar = new c(str, cls.getName(), "<adapter>");
        cVar.a("factory", "Lexternal/sdk/pendo/io/mozilla/javascript/ContextFactory;", (short) 17);
        cVar.a("delegee", "Lexternal/sdk/pendo/io/mozilla/javascript/Scriptable;", (short) 17);
        cVar.a("self", "Lexternal/sdk/pendo/io/mozilla/javascript/Scriptable;", (short) 17);
        int length = clsArr == null ? 0 : clsArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            Class<?> cls3 = clsArr[i2];
            if (cls3 != null) {
                cVar.c(cls3.getName());
            }
        }
        String replace = cls.getName().replace('.', IOUtils.DIR_SEPARATOR_UNIX);
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            int modifiers = constructor.getModifiers();
            if (Modifier.isPublic(modifiers) || Modifier.isProtected(modifiers)) {
                generateCtor(cVar, str, replace, constructor);
            }
        }
        generateSerialCtor(cVar, str, replace);
        if (str2 != null) {
            generateEmptyCtor(cVar, str, replace, str2);
        }
        ObjToIntMap objToIntMap2 = new ObjToIntMap();
        ObjToIntMap objToIntMap3 = new ObjToIntMap();
        for (int i3 = 0; i3 < length; i3++) {
            Method[] methods = clsArr[i3].getMethods();
            int i4 = 0;
            while (i4 < methods.length) {
                Method method = methods[i4];
                int modifiers2 = method.getModifiers();
                if (!Modifier.isStatic(modifiers2) && !Modifier.isFinal(modifiers2) && !method.isDefault()) {
                    String name = method.getName();
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (!objToIntMap.has(name)) {
                        try {
                            cls.getMethod(name, parameterTypes);
                        } catch (NoSuchMethodException unused) {
                        }
                    }
                    String str3 = name + getMethodSignature(method, parameterTypes);
                    if (!objToIntMap2.has(str3)) {
                        i = i4;
                        methodArr2 = methods;
                        generateMethod(cVar, str, name, parameterTypes, method.getReturnType(), true);
                        objToIntMap2.put(str3, 0);
                        objToIntMap3.put(name, 0);
                        i4 = i + 1;
                        methods = methodArr2;
                    }
                }
                i = i4;
                methodArr2 = methods;
                i4 = i + 1;
                methods = methodArr2;
            }
        }
        Method[] overridableMethods = getOverridableMethods(cls);
        int i5 = 0;
        while (i5 < overridableMethods.length) {
            Method method2 = overridableMethods[i5];
            boolean isAbstract = Modifier.isAbstract(method2.getModifiers());
            String name2 = method2.getName();
            if (isAbstract || objToIntMap.has(name2)) {
                Class<?>[] parameterTypes2 = method2.getParameterTypes();
                String methodSignature = getMethodSignature(method2, parameterTypes2);
                String str4 = name2 + methodSignature;
                if (!objToIntMap2.has(str4)) {
                    methodArr = overridableMethods;
                    generateMethod(cVar, str, name2, parameterTypes2, method2.getReturnType(), true);
                    objToIntMap2.put(str4, 0);
                    objToIntMap3.put(name2, 0);
                    if (!isAbstract) {
                        generateSuper(cVar, str, replace, name2, methodSignature, parameterTypes2, method2.getReturnType());
                    }
                    i5++;
                    overridableMethods = methodArr;
                }
            }
            methodArr = overridableMethods;
            i5++;
            overridableMethods = methodArr;
        }
        ObjToIntMap.Iterator iterator = new ObjToIntMap.Iterator(objToIntMap);
        iterator.start();
        while (!iterator.done()) {
            String str5 = (String) iterator.getKey();
            if (!objToIntMap3.has(str5)) {
                int value = iterator.getValue();
                Class[] clsArr2 = new Class[value];
                int i6 = 0;
                while (true) {
                    cls2 = ScriptRuntime.ObjectClass;
                    if (i6 >= value) {
                        break;
                    }
                    clsArr2[i6] = cls2;
                    i6++;
                }
                generateMethod(cVar, str, str5, clsArr2, cls2, false);
            }
            iterator.next();
        }
        return cVar.j();
    }

    public static Scriptable createAdapterWrapper(Scriptable scriptable, Object obj) {
        NativeJavaObject nativeJavaObject = new NativeJavaObject(ScriptableObject.getTopLevelScope(scriptable), obj, null, true);
        nativeJavaObject.setPrototype(scriptable);
        return nativeJavaObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object doCall(Context context, Scriptable scriptable, Scriptable scriptable2, Function function, Object[] objArr, long j) {
        for (int i = 0; i != objArr.length; i++) {
            if (0 != ((1 << i) & j)) {
                Object obj = objArr[i];
                if (!(obj instanceof Scriptable)) {
                    objArr[i] = context.getWrapFactory().wrap(context, scriptable, obj, null);
                }
            }
        }
        return function.call(context, scriptable, scriptable2, objArr);
    }

    private static void generateCtor(c cVar, String str, String str2, Constructor<?> constructor) {
        String sb;
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        short s = 3;
        if (parameterTypes.length == 0) {
            cVar.b("<init>", "(Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/ContextFactory;)V", (short) 1);
            cVar.b(42);
            sb = "()V";
        } else {
            StringBuilder sb2 = new StringBuilder("(Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/ContextFactory;");
            int length = sb2.length();
            for (Class<?> cls : parameterTypes) {
                appendTypeString(sb2, cls);
            }
            sb2.append(")V");
            cVar.b("<init>", sb2.toString(), (short) 1);
            cVar.b(42);
            for (Class<?> cls2 : parameterTypes) {
                s = (short) (s + generatePushParam(cVar, s, cls2));
            }
            sb2.delete(1, length);
            sb = sb2.toString();
        }
        cVar.b(183, str2, "<init>", sb);
        cVar.b(42);
        cVar.b(43);
        cVar.a(181, str, "delegee", "Lexternal/sdk/pendo/io/mozilla/javascript/Scriptable;");
        cVar.b(42);
        cVar.b(44);
        cVar.a(181, str, "factory", "Lexternal/sdk/pendo/io/mozilla/javascript/ContextFactory;");
        cVar.b(42);
        cVar.b(43);
        cVar.b(42);
        cVar.b(184, "external/sdk/pendo/io/mozilla/javascript/JavaAdapter", "createAdapterWrapper", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
        cVar.a(181, str, "self", "Lexternal/sdk/pendo/io/mozilla/javascript/Scriptable;");
        cVar.b(177);
        cVar.c(s);
    }

    private static void generateEmptyCtor(c cVar, String str, String str2, String str3) {
        cVar.b("<init>", "()V", (short) 1);
        cVar.b(42);
        cVar.b(183, str2, "<init>", "()V");
        cVar.b(42);
        cVar.b(1);
        cVar.a(181, str, "factory", "Lexternal/sdk/pendo/io/mozilla/javascript/ContextFactory;");
        cVar.a(187, str3);
        cVar.b(89);
        cVar.b(183, str3, "<init>", "()V");
        cVar.b(184, "external/sdk/pendo/io/mozilla/javascript/JavaAdapter", "runScript", "(Lorg/mozilla/javascript/Script;)Lorg/mozilla/javascript/Scriptable;");
        cVar.b(76);
        cVar.b(42);
        cVar.b(43);
        cVar.a(181, str, "delegee", "Lexternal/sdk/pendo/io/mozilla/javascript/Scriptable;");
        cVar.b(42);
        cVar.b(43);
        cVar.b(42);
        cVar.b(184, "external/sdk/pendo/io/mozilla/javascript/JavaAdapter", "createAdapterWrapper", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
        cVar.a(181, str, "self", "Lexternal/sdk/pendo/io/mozilla/javascript/Scriptable;");
        cVar.b(177);
        cVar.c((short) 2);
    }

    private static void generateMethod(c cVar, String str, String str2, Class<?>[] clsArr, Class<?> cls, boolean z) {
        StringBuilder sb = new StringBuilder();
        int appendMethodSignature = appendMethodSignature(clsArr, cls, sb);
        cVar.b(str2, sb.toString(), (short) 1);
        cVar.b(42);
        cVar.a(180, str, "factory", "Lexternal/sdk/pendo/io/mozilla/javascript/ContextFactory;");
        cVar.b(42);
        cVar.a(180, str, "self", "Lexternal/sdk/pendo/io/mozilla/javascript/Scriptable;");
        cVar.b(42);
        cVar.a(180, str, "delegee", "Lexternal/sdk/pendo/io/mozilla/javascript/Scriptable;");
        cVar.e(str2);
        cVar.b(184, "external/sdk/pendo/io/mozilla/javascript/JavaAdapter", "getFunction", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;)Lorg/mozilla/javascript/Function;");
        generatePushWrappedArgs(cVar, clsArr, clsArr.length);
        if (clsArr.length > 64) {
            throw Context.reportRuntimeError0("JavaAdapter can not subclass methods with more then 64 arguments.");
        }
        long j = 0;
        for (int i = 0; i != clsArr.length; i++) {
            if (!clsArr[i].isPrimitive()) {
                j |= 1 << i;
            }
        }
        cVar.b(j);
        cVar.b(184, "external/sdk/pendo/io/mozilla/javascript/JavaAdapter", "callMethod", "(Lorg/mozilla/javascript/ContextFactory;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Function;[Ljava/lang/Object;J)Ljava/lang/Object;");
        generateReturnResult(cVar, cls, z);
        cVar.c((short) appendMethodSignature);
    }

    private static void generatePopResult(c cVar, Class<?> cls) {
        int i;
        if (cls.isPrimitive()) {
            char charAt = cls.getName().charAt(0);
            if (charAt != 'f') {
                if (charAt != 'i') {
                    if (charAt == 'l') {
                        i = 173;
                    } else if (charAt != 's' && charAt != 'z') {
                        switch (charAt) {
                            case 'b':
                            case 'c':
                                break;
                            case 'd':
                                i = 175;
                                break;
                            default:
                                return;
                        }
                    }
                }
                i = 172;
            } else {
                i = 174;
            }
        } else {
            i = 176;
        }
        cVar.b(i);
    }

    private static int generatePushParam(c cVar, int i, Class<?> cls) {
        if (!cls.isPrimitive()) {
            cVar.c(i);
            return 1;
        }
        char charAt = cls.getName().charAt(0);
        if (charAt == 'f') {
            cVar.g(i);
            return 1;
        }
        if (charAt != 'i') {
            if (charAt == 'l') {
                cVar.j(i);
                return 2;
            }
            if (charAt != 's' && charAt != 'z') {
                switch (charAt) {
                    case 'b':
                    case 'c':
                        break;
                    case 'd':
                        cVar.e(i);
                        return 2;
                    default:
                        throw Kit.codeBug();
                }
            }
        }
        cVar.h(i);
        return 1;
    }

    static void generatePushWrappedArgs(c cVar, Class<?>[] clsArr, int i) {
        cVar.l(i);
        cVar.a(189, "java/lang/Object");
        int i2 = 1;
        for (int i3 = 0; i3 != clsArr.length; i3++) {
            cVar.b(89);
            cVar.l(i3);
            i2 += generateWrapArg(cVar, i2, clsArr[i3]);
            cVar.b(83);
        }
    }

    static void generateReturnResult(c cVar, Class<?> cls, boolean z) {
        int i;
        if (cls != Void.TYPE) {
            if (cls == Boolean.TYPE) {
                cVar.b(184, "external/sdk/pendo/io/mozilla/javascript/Context", "toBoolean", "(Ljava/lang/Object;)Z");
            } else if (cls == Character.TYPE) {
                cVar.b(184, "external/sdk/pendo/io/mozilla/javascript/Context", "toString", "(Ljava/lang/Object;)Ljava/lang/String;");
                cVar.b(3);
                cVar.b(182, "java/lang/String", "charAt", "(I)C");
            } else if (cls.isPrimitive()) {
                cVar.b(184, "external/sdk/pendo/io/mozilla/javascript/Context", "toNumber", "(Ljava/lang/Object;)D");
                char charAt = cls.getName().charAt(0);
                if (charAt != 'b') {
                    if (charAt == 'd') {
                        i = 175;
                    } else if (charAt == 'f') {
                        cVar.b(144);
                        i = 174;
                    } else if (charAt != 'i') {
                        if (charAt == 'l') {
                            cVar.b(143);
                            i = 173;
                        } else if (charAt != 's') {
                            throw new RuntimeException("Unexpected return type " + cls);
                        }
                    }
                }
                cVar.b(142);
            } else {
                String name = cls.getName();
                if (z) {
                    cVar.d(name);
                    cVar.b(184, "java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;");
                    cVar.b(184, "external/sdk/pendo/io/mozilla/javascript/JavaAdapter", "convertResult", "(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;");
                }
                cVar.a(192, name);
                i = 176;
            }
            cVar.b(172);
            return;
        }
        cVar.b(87);
        i = 177;
        cVar.b(i);
    }

    private static void generateSerialCtor(c cVar, String str, String str2) {
        cVar.b("<init>", "(Lorg/mozilla/javascript/ContextFactory;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;)V", (short) 1);
        cVar.b(42);
        cVar.b(183, str2, "<init>", "()V");
        cVar.b(42);
        cVar.b(43);
        cVar.a(181, str, "factory", "Lexternal/sdk/pendo/io/mozilla/javascript/ContextFactory;");
        cVar.b(42);
        cVar.b(44);
        cVar.a(181, str, "delegee", "Lexternal/sdk/pendo/io/mozilla/javascript/Scriptable;");
        cVar.b(42);
        cVar.b(45);
        cVar.a(181, str, "self", "Lexternal/sdk/pendo/io/mozilla/javascript/Scriptable;");
        cVar.b(177);
        cVar.c((short) 4);
    }

    private static void generateSuper(c cVar, String str, String str2, String str3, String str4, Class<?>[] clsArr, Class<?> cls) {
        cVar.b("super$" + str3, str4, (short) 1);
        cVar.a(25, 0);
        int i = 1;
        for (Class<?> cls2 : clsArr) {
            i += generatePushParam(cVar, i, cls2);
        }
        cVar.b(183, str2, str3, str4);
        if (cls.equals(Void.TYPE)) {
            cVar.b(177);
        } else {
            generatePopResult(cVar, cls);
        }
        cVar.c((short) (i + 1));
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0068, code lost:
    
        if (r9 != 's') goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int generateWrapArg(sdk.pendo.io.v2.c r7, int r8, java.lang.Class<?> r9) {
        /*
            boolean r0 = r9.isPrimitive()
            r1 = 1
            if (r0 != 0) goto Le
            r9 = 25
            r7.a(r9, r8)
            goto L92
        Le:
            java.lang.Class r0 = java.lang.Boolean.TYPE
            java.lang.String r2 = "<init>"
            r3 = 183(0xb7, float:2.56E-43)
            r4 = 89
            r5 = 187(0xbb, float:2.62E-43)
            r6 = 21
            if (r9 != r0) goto L2d
            java.lang.String r9 = "java/lang/Boolean"
            r7.a(r5, r9)
            r7.b(r4)
            r7.a(r6, r8)
            java.lang.String r8 = "(Z)V"
            r7.b(r3, r9, r2, r8)
            goto L92
        L2d:
            java.lang.Class r0 = java.lang.Character.TYPE
            if (r9 != r0) goto L40
            r7.a(r6, r8)
            java.lang.String r8 = "valueOf"
            java.lang.String r9 = "(C)Ljava/lang/String;"
            r0 = 184(0xb8, float:2.58E-43)
            java.lang.String r2 = "java/lang/String"
            r7.b(r0, r2, r8, r9)
            goto L92
        L40:
            java.lang.String r0 = "java/lang/Double"
            r7.a(r5, r0)
            r7.b(r4)
            java.lang.String r9 = r9.getName()
            r4 = 0
            char r9 = r9.charAt(r4)
            r4 = 98
            if (r9 == r4) goto L85
            r4 = 100
            r5 = 2
            if (r9 == r4) goto L7e
            r4 = 102(0x66, float:1.43E-43)
            if (r9 == r4) goto L76
            r4 = 105(0x69, float:1.47E-43)
            if (r9 == r4) goto L85
            r4 = 108(0x6c, float:1.51E-43)
            if (r9 == r4) goto L6b
            r4 = 115(0x73, float:1.61E-43)
            if (r9 == r4) goto L85
            goto L8d
        L6b:
            r9 = 22
            r7.a(r9, r8)
            r8 = 138(0x8a, float:1.93E-43)
            r7.b(r8)
            goto L83
        L76:
            r9 = 23
            r7.a(r9, r8)
            r8 = 141(0x8d, float:1.98E-43)
            goto L8a
        L7e:
            r9 = 24
            r7.a(r9, r8)
        L83:
            r1 = r5
            goto L8d
        L85:
            r7.a(r6, r8)
            r8 = 135(0x87, float:1.89E-43)
        L8a:
            r7.b(r8)
        L8d:
            java.lang.String r8 = "(D)V"
            r7.b(r3, r0, r2, r8)
        L92:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.JavaAdapter.generateWrapArg(sdk.pendo.io.v2.c, int, java.lang.Class):int");
    }

    private static Class<?> getAdapterClass(Scriptable scriptable, Class<?> cls, Class<?>[] clsArr, Scriptable scriptable2) {
        ClassCache classCache = ClassCache.get(scriptable);
        Map<JavaAdapterSignature, Class<?>> interfaceAdapterCacheMap = classCache.getInterfaceAdapterCacheMap();
        ObjToIntMap objectFunctionNames = getObjectFunctionNames(scriptable2);
        JavaAdapterSignature javaAdapterSignature = new JavaAdapterSignature(cls, clsArr, objectFunctionNames);
        Class<?> cls2 = interfaceAdapterCacheMap.get(javaAdapterSignature);
        if (cls2 == null) {
            String str = "adapter" + classCache.newClassSerialNumber();
            cls2 = loadAdapterClass(str, createAdapterCode(objectFunctionNames, str, cls, clsArr, null));
            if (classCache.isCachingEnabled()) {
                interfaceAdapterCacheMap.put(javaAdapterSignature, cls2);
            }
        }
        return cls2;
    }

    public static Object getAdapterSelf(Class<?> cls, Object obj) {
        return cls.getDeclaredField("self").get(obj);
    }

    static int[] getArgsToConvert(Class<?>[] clsArr) {
        int i = 0;
        for (int i2 = 0; i2 != clsArr.length; i2++) {
            if (!clsArr[i2].isPrimitive()) {
                i++;
            }
        }
        if (i == 0) {
            return null;
        }
        int[] iArr = new int[i];
        int i3 = 0;
        for (int i4 = 0; i4 != clsArr.length; i4++) {
            if (!clsArr[i4].isPrimitive()) {
                iArr[i3] = i4;
                i3++;
            }
        }
        return iArr;
    }

    public static Function getFunction(Scriptable scriptable, String str) {
        Object property = ScriptableObject.getProperty(scriptable, str);
        if (property == Scriptable.NOT_FOUND) {
            return null;
        }
        if (property instanceof Function) {
            return (Function) property;
        }
        throw ScriptRuntime.notFunctionError(property, str);
    }

    private static String getMethodSignature(Method method, Class<?>[] clsArr) {
        StringBuilder sb = new StringBuilder();
        appendMethodSignature(clsArr, method.getReturnType(), sb);
        return sb.toString();
    }

    private static ObjToIntMap getObjectFunctionNames(Scriptable scriptable) {
        Object[] propertyIds = ScriptableObject.getPropertyIds(scriptable);
        ObjToIntMap objToIntMap = new ObjToIntMap(propertyIds.length);
        for (int i = 0; i != propertyIds.length; i++) {
            Object obj = propertyIds[i];
            if (obj instanceof String) {
                String str = (String) obj;
                Object property = ScriptableObject.getProperty(scriptable, str);
                if (property instanceof Function) {
                    int int32 = ScriptRuntime.toInt32(ScriptableObject.getProperty((Function) property, SentryEnvelopeItemHeader.JsonKeys.LENGTH));
                    if (int32 < 0) {
                        int32 = 0;
                    }
                    objToIntMap.put(str, int32);
                }
            }
        }
        return objToIntMap;
    }

    static Method[] getOverridableMethods(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            appendOverridableMethods(cls2, arrayList, hashSet);
        }
        while (cls != null) {
            for (Class<?> cls3 : cls.getInterfaces()) {
                appendOverridableMethods(cls3, arrayList, hashSet);
            }
            cls = cls.getSuperclass();
        }
        return (Method[]) arrayList.toArray(new Method[arrayList.size()]);
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        IdFunctionObject idFunctionObject = new IdFunctionObject(new JavaAdapter(), FTAG, 1, "JavaAdapter", 1, scriptable);
        idFunctionObject.markAsConstructor(null);
        if (z) {
            idFunctionObject.sealObject();
        }
        idFunctionObject.exportAsScopeProperty();
    }

    static Object js_createAdapter(Context context, Scriptable scriptable, Object[] objArr) {
        Object newInstance;
        int length = objArr.length;
        if (length == 0) {
            throw ScriptRuntime.typeError0("msg.adapter.zero.args");
        }
        int i = 0;
        while (i < length - 1) {
            Object obj = objArr[i];
            if (obj instanceof NativeObject) {
                break;
            }
            if (!(obj instanceof NativeJavaClass)) {
                throw ScriptRuntime.typeError2("msg.not.java.class.arg", String.valueOf(i), ScriptRuntime.toString(obj));
            }
            i++;
        }
        Class[] clsArr = new Class[i];
        Class<?> cls = null;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Class<?> classObject = ((NativeJavaClass) objArr[i3]).getClassObject();
            if (classObject.isInterface()) {
                clsArr[i2] = classObject;
                i2++;
            } else {
                if (cls != null) {
                    throw ScriptRuntime.typeError2("msg.only.one.super", cls.getName(), classObject.getName());
                }
                cls = classObject;
            }
        }
        if (cls == null) {
            cls = ScriptRuntime.ObjectClass;
        }
        Class[] clsArr2 = new Class[i2];
        System.arraycopy(clsArr, 0, clsArr2, 0, i2);
        Scriptable ensureScriptable = ScriptableObject.ensureScriptable(objArr[i]);
        Class<?> adapterClass = getAdapterClass(scriptable, cls, clsArr2, ensureScriptable);
        int i4 = (length - i) - 1;
        try {
            if (i4 > 0) {
                Object[] objArr2 = new Object[i4 + 2];
                objArr2[0] = ensureScriptable;
                objArr2[1] = context.getFactory();
                System.arraycopy(objArr, i + 1, objArr2, 2, i4);
                NativeJavaMethod nativeJavaMethod = new NativeJavaClass(scriptable, adapterClass, true).members.ctors;
                int findCachedFunction = nativeJavaMethod.findCachedFunction(context, objArr2);
                if (findCachedFunction < 0) {
                    throw Context.reportRuntimeError2("msg.no.java.ctor", adapterClass.getName(), NativeJavaMethod.scriptSignature(objArr));
                }
                newInstance = NativeJavaClass.constructInternal(objArr2, nativeJavaMethod.methods[findCachedFunction]);
            } else {
                newInstance = adapterClass.getConstructor(ScriptRuntime.ScriptableClass, ScriptRuntime.ContextFactoryClass).newInstance(ensureScriptable, context.getFactory());
            }
            Object adapterSelf = getAdapterSelf(adapterClass, newInstance);
            if (adapterSelf instanceof Wrapper) {
                Object unwrap = ((Wrapper) adapterSelf).unwrap();
                if (unwrap instanceof Scriptable) {
                    if (unwrap instanceof ScriptableObject) {
                        ScriptRuntime.setObjectProtoAndParent((ScriptableObject) unwrap, scriptable);
                    }
                    return unwrap;
                }
            }
            return adapterSelf;
        } catch (Exception e) {
            throw Context.throwAsScriptRuntimeEx(e);
        }
    }

    static /* synthetic */ ScriptableObject lambda$runScript$1(Script script, Context context) {
        ScriptableObject global = ScriptRuntime.getGlobal(context);
        script.exec(context, global);
        return global;
    }

    static Class<?> loadAdapterClass(String str, byte[] bArr) {
        CodeSource codeSource;
        Class<?> staticSecurityDomainClass = SecurityController.getStaticSecurityDomainClass();
        if (staticSecurityDomainClass == CodeSource.class || staticSecurityDomainClass == ProtectionDomain.class) {
            ProtectionDomain scriptProtectionDomain = SecurityUtilities.getScriptProtectionDomain();
            ProtectionDomain protectionDomain = scriptProtectionDomain;
            if (scriptProtectionDomain == null) {
                protectionDomain = JavaAdapter.class.getProtectionDomain();
            }
            codeSource = protectionDomain;
            if (staticSecurityDomainClass == CodeSource.class) {
                if (protectionDomain != null) {
                    codeSource = protectionDomain.getCodeSource();
                }
            }
            GeneratedClassLoader createLoader = SecurityController.createLoader(null, codeSource);
            Class<?> defineClass = createLoader.defineClass(str, bArr);
            createLoader.linkClass(defineClass);
            return defineClass;
        }
        codeSource = null;
        GeneratedClassLoader createLoader2 = SecurityController.createLoader(null, codeSource);
        Class<?> defineClass2 = createLoader2.defineClass(str, bArr);
        createLoader2.linkClass(defineClass2);
        return defineClass2;
    }

    public static Object readAdapterObject(Scriptable scriptable, ObjectInputStream objectInputStream) {
        Context currentContext = Context.getCurrentContext();
        ContextFactory factory = currentContext != null ? currentContext.getFactory() : null;
        Class<?> cls = Class.forName((String) objectInputStream.readObject());
        String[] strArr = (String[]) objectInputStream.readObject();
        Class[] clsArr = new Class[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            clsArr[i] = Class.forName(strArr[i]);
        }
        Scriptable scriptable2 = (Scriptable) objectInputStream.readObject();
        Class<?> adapterClass = getAdapterClass(scriptable, cls, clsArr, scriptable2);
        Class<Scriptable> cls2 = ScriptRuntime.ScriptableClass;
        try {
            return adapterClass.getConstructor(ScriptRuntime.ContextFactoryClass, cls2, cls2).newInstance(factory, scriptable2, scriptable);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            throw new ClassNotFoundException("adapter");
        }
    }

    public static Scriptable runScript(final Script script) {
        return (Scriptable) ContextFactory.getGlobal().call(new ContextAction() { // from class: external.sdk.pendo.io.mozilla.javascript.JavaAdapter$$ExternalSyntheticLambda1
            @Override // external.sdk.pendo.io.mozilla.javascript.ContextAction
            public final Object run(Context context) {
                return JavaAdapter.lambda$runScript$1(Script.this, context);
            }
        });
    }

    public static void writeAdapterObject(Object obj, ObjectOutputStream objectOutputStream) {
        Class<?> cls = obj.getClass();
        objectOutputStream.writeObject(cls.getSuperclass().getName());
        Class<?>[] interfaces = cls.getInterfaces();
        String[] strArr = new String[interfaces.length];
        for (int i = 0; i < interfaces.length; i++) {
            strArr[i] = interfaces[i].getName();
        }
        objectOutputStream.writeObject(strArr);
        try {
            objectOutputStream.writeObject(cls.getField("delegee").get(obj));
        } catch (IllegalAccessException | NoSuchFieldException unused) {
            throw new IOException();
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (idFunctionObject.hasTag(FTAG) && idFunctionObject.methodId() == 1) {
            return js_createAdapter(context, scriptable, objArr);
        }
        throw idFunctionObject.unknown();
    }
}
