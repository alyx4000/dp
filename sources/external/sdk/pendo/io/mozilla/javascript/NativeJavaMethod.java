package external.sdk.pendo.io.mozilla.javascript;

import io.sentry.protocol.SentryStackFrame;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import sdk.pendo.io.events.ConditionData;

/* loaded from: classes2.dex */
public class NativeJavaMethod extends BaseFunction {
    private static final int PREFERENCE_AMBIGUOUS = 3;
    private static final int PREFERENCE_EQUAL = 0;
    private static final int PREFERENCE_FIRST_ARG = 1;
    private static final int PREFERENCE_SECOND_ARG = 2;
    private static final boolean debug = false;
    private static final long serialVersionUID = -3440381785576412928L;
    private String functionName;
    MemberBox[] methods;
    private final transient CopyOnWriteArrayList<ResolvedOverload> overloadCache;

    NativeJavaMethod(MemberBox memberBox, String str) {
        this.overloadCache = new CopyOnWriteArrayList<>();
        this.functionName = str;
        this.methods = new MemberBox[]{memberBox};
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x008c, code lost:
    
        if (r14.isPublic() == false) goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static int findFunction(external.sdk.pendo.io.mozilla.javascript.Context r16, external.sdk.pendo.io.mozilla.javascript.MemberBox[] r17, java.lang.Object[] r18) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.NativeJavaMethod.findFunction(external.sdk.pendo.io.mozilla.javascript.Context, external.sdk.pendo.io.mozilla.javascript.MemberBox[], java.lang.Object[]):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0040, code lost:
    
        if (r4.isAssignableFrom(r3) != false) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int preferSignature(java.lang.Object[] r8, java.lang.Class<?>[] r9, boolean r10, java.lang.Class<?>[] r11, boolean r12) {
        /*
            r0 = 0
            r1 = r0
        L2:
            int r2 = r8.length
            if (r0 >= r2) goto L4b
            r2 = 1
            if (r10 == 0) goto L10
            int r3 = r9.length
            if (r0 < r3) goto L10
            int r3 = r9.length
            int r3 = r3 - r2
            r3 = r9[r3]
            goto L12
        L10:
            r3 = r9[r0]
        L12:
            if (r12 == 0) goto L1c
            int r4 = r11.length
            if (r0 < r4) goto L1c
            int r4 = r11.length
            int r4 = r4 - r2
            r4 = r11[r4]
            goto L1e
        L1c:
            r4 = r11[r0]
        L1e:
            if (r3 != r4) goto L21
            goto L48
        L21:
            r5 = r8[r0]
            int r6 = external.sdk.pendo.io.mozilla.javascript.NativeJavaObject.getConversionWeight(r5, r3)
            int r5 = external.sdk.pendo.io.mozilla.javascript.NativeJavaObject.getConversionWeight(r5, r4)
            r7 = 3
            if (r6 >= r5) goto L2f
            goto L44
        L2f:
            if (r6 <= r5) goto L32
            goto L3a
        L32:
            if (r6 != 0) goto L43
            boolean r5 = r3.isAssignableFrom(r4)
            if (r5 == 0) goto L3c
        L3a:
            r2 = 2
            goto L44
        L3c:
            boolean r3 = r4.isAssignableFrom(r3)
            if (r3 == 0) goto L43
            goto L44
        L43:
            r2 = r7
        L44:
            r1 = r1 | r2
            if (r1 != r7) goto L48
            goto L4b
        L48:
            int r0 = r0 + 1
            goto L2
        L4b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.NativeJavaMethod.preferSignature(java.lang.Object[], java.lang.Class[], boolean, java.lang.Class[], boolean):int");
    }

    private static void printDebug(String str, MemberBox memberBox, Object[] objArr) {
    }

    static String scriptSignature(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i != objArr.length; i++) {
            Object obj = objArr[i];
            String name = obj == null ? "null" : obj instanceof Boolean ? "boolean" : obj instanceof String ? "string" : obj instanceof Number ? ConditionData.NUMBER_VALUE : obj instanceof Scriptable ? obj instanceof Undefined ? "undefined" : obj instanceof Wrapper ? ((Wrapper) obj).unwrap().getClass().getName() : obj instanceof Function ? SentryStackFrame.JsonKeys.FUNCTION : "object" : JavaMembers.javaSignature(obj.getClass());
            if (i != 0) {
                sb.append(',');
            }
            sb.append(name);
        }
        return sb.toString();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.BaseFunction, external.sdk.pendo.io.mozilla.javascript.Function, external.sdk.pendo.io.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Object[] objArr2;
        Object obj;
        Object obj2;
        if (this.methods.length == 0) {
            throw new RuntimeException("No methods defined for call");
        }
        int findCachedFunction = findCachedFunction(context, objArr);
        int i = 0;
        if (findCachedFunction < 0) {
            throw Context.reportRuntimeError1("msg.java.no_such_method", this.methods[0].method().getDeclaringClass().getName() + '.' + getFunctionName() + '(' + scriptSignature(objArr) + ')');
        }
        MemberBox memberBox = this.methods[findCachedFunction];
        Class<?>[] clsArr = memberBox.argTypes;
        if (memberBox.vararg) {
            objArr2 = new Object[clsArr.length];
            for (int i2 = 0; i2 < clsArr.length - 1; i2++) {
                objArr2[i2] = Context.jsToJava(objArr[i2], clsArr[i2]);
            }
            if (objArr.length == clsArr.length && (objArr[objArr.length - 1] == null || (objArr[objArr.length - 1] instanceof NativeArray) || (objArr[objArr.length - 1] instanceof NativeJavaArray))) {
                obj2 = Context.jsToJava(objArr[objArr.length - 1], clsArr[clsArr.length - 1]);
            } else {
                Class<?> componentType = clsArr[clsArr.length - 1].getComponentType();
                Object newInstance = Array.newInstance(componentType, (objArr.length - clsArr.length) + 1);
                while (i < Array.getLength(newInstance)) {
                    Array.set(newInstance, i, Context.jsToJava(objArr[(clsArr.length - 1) + i], componentType));
                    i++;
                }
                obj2 = newInstance;
            }
            objArr2[clsArr.length - 1] = obj2;
        } else {
            objArr2 = objArr;
            while (i < objArr2.length) {
                Object obj3 = objArr2[i];
                Object jsToJava = Context.jsToJava(obj3, clsArr[i]);
                if (jsToJava != obj3) {
                    if (objArr == objArr2) {
                        objArr2 = (Object[]) objArr2.clone();
                    }
                    objArr2[i] = jsToJava;
                }
                i++;
            }
        }
        if (!memberBox.isStatic()) {
            Class<?> declaringClass = memberBox.getDeclaringClass();
            for (Scriptable scriptable3 = scriptable2; scriptable3 != null; scriptable3 = scriptable3.getPrototype()) {
                if (scriptable3 instanceof Wrapper) {
                    Object unwrap = ((Wrapper) scriptable3).unwrap();
                    if (declaringClass.isInstance(unwrap)) {
                        obj = unwrap;
                    }
                }
            }
            throw Context.reportRuntimeError3("msg.nonjava.method", getFunctionName(), ScriptRuntime.toString(scriptable2), declaringClass.getName());
        }
        obj = null;
        Object invoke = memberBox.invoke(obj, objArr2);
        Class<?> returnType = memberBox.method().getReturnType();
        Object wrap = context.getWrapFactory().wrap(context, scriptable, invoke, returnType);
        return (wrap == null && returnType == Void.TYPE) ? Undefined.instance : wrap;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.BaseFunction
    String decompile(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        boolean z = (i2 & 1) != 0;
        if (!z) {
            sb.append("function ");
            sb.append(getFunctionName());
            sb.append("() {");
        }
        sb.append("/*\n");
        sb.append(toString());
        sb.append(z ? "*/\n" : "*/}\n");
        return sb.toString();
    }

    int findCachedFunction(Context context, Object[] objArr) {
        MemberBox[] memberBoxArr = this.methods;
        if (memberBoxArr.length <= 1) {
            return findFunction(context, memberBoxArr, objArr);
        }
        Iterator<ResolvedOverload> it = this.overloadCache.iterator();
        while (it.hasNext()) {
            ResolvedOverload next = it.next();
            if (next.matches(objArr)) {
                return next.index;
            }
        }
        int findFunction = findFunction(context, this.methods, objArr);
        if (this.overloadCache.size() < this.methods.length * 2) {
            this.overloadCache.addIfAbsent(new ResolvedOverload(objArr, findFunction));
        }
        return findFunction;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.BaseFunction
    public String getFunctionName() {
        return this.functionName;
    }

    public String toString() {
        String name;
        StringBuilder sb = new StringBuilder();
        int length = this.methods.length;
        for (int i = 0; i != length; i++) {
            if (this.methods[i].isMethod()) {
                Method method = this.methods[i].method();
                sb.append(JavaMembers.javaSignature(method.getReturnType()));
                sb.append(' ');
                name = method.getName();
            } else {
                name = this.methods[i].getName();
            }
            sb.append(name);
            sb.append(JavaMembers.liveConnectSignature(this.methods[i].argTypes));
            sb.append('\n');
        }
        return sb.toString();
    }

    public NativeJavaMethod(Method method, String str) {
        this(new MemberBox(method), str);
    }

    NativeJavaMethod(MemberBox[] memberBoxArr) {
        this.overloadCache = new CopyOnWriteArrayList<>();
        this.functionName = memberBoxArr[0].getName();
        this.methods = memberBoxArr;
    }

    NativeJavaMethod(MemberBox[] memberBoxArr, String str) {
        this.overloadCache = new CopyOnWriteArrayList<>();
        this.functionName = str;
        this.methods = memberBoxArr;
    }
}
