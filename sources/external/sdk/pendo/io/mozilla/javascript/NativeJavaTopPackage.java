package external.sdk.pendo.io.mozilla.javascript;

import io.sentry.SentryBaseEvent;

/* loaded from: classes2.dex */
public class NativeJavaTopPackage extends NativeJavaPackage implements Function, IdFunctionCall {
    private static final int Id_getClass = 1;
    private static final long serialVersionUID = -1455787259477709999L;
    private static final String[][] commonPackages = {new String[]{SentryBaseEvent.DEFAULT_PLATFORM, "lang", "reflect"}, new String[]{SentryBaseEvent.DEFAULT_PLATFORM, "io"}, new String[]{SentryBaseEvent.DEFAULT_PLATFORM, "math"}, new String[]{SentryBaseEvent.DEFAULT_PLATFORM, "net"}, new String[]{SentryBaseEvent.DEFAULT_PLATFORM, "util", "zip"}, new String[]{SentryBaseEvent.DEFAULT_PLATFORM, "text", "resources"}, new String[]{SentryBaseEvent.DEFAULT_PLATFORM, "applet"}, new String[]{"javax", "swing"}};
    private static final Object FTAG = "JavaTopPackage";

    NativeJavaTopPackage(ClassLoader classLoader) {
        super(true, "", classLoader);
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        NativeJavaTopPackage nativeJavaTopPackage = new NativeJavaTopPackage(context.getApplicationClassLoader());
        nativeJavaTopPackage.setPrototype(ScriptableObject.getObjectPrototype(scriptable));
        nativeJavaTopPackage.setParentScope(scriptable);
        for (int i = 0; i != commonPackages.length; i++) {
            int i2 = 0;
            NativeJavaPackage nativeJavaPackage = nativeJavaTopPackage;
            while (true) {
                String[] strArr = commonPackages[i];
                if (i2 != strArr.length) {
                    nativeJavaPackage = nativeJavaPackage.forcePackage(strArr[i2], scriptable);
                    i2++;
                }
            }
        }
        IdFunctionObject idFunctionObject = new IdFunctionObject(nativeJavaTopPackage, FTAG, 1, "getClass", 1, scriptable);
        String[] topPackageNames = ScriptRuntime.getTopPackageNames();
        Object[] objArr = new NativeJavaPackage[topPackageNames.length];
        for (int i3 = 0; i3 < topPackageNames.length; i3++) {
            objArr[i3] = (NativeJavaPackage) nativeJavaTopPackage.get(topPackageNames[i3], nativeJavaTopPackage);
        }
        ScriptableObject scriptableObject = (ScriptableObject) scriptable;
        if (z) {
            idFunctionObject.sealObject();
        }
        idFunctionObject.exportAsScopeProperty();
        scriptableObject.defineProperty("Packages", nativeJavaTopPackage, 2);
        for (int i4 = 0; i4 < topPackageNames.length; i4++) {
            scriptableObject.defineProperty(topPackageNames[i4], objArr[i4], 2);
        }
    }

    private Scriptable js_getClass(Context context, Scriptable scriptable, Object[] objArr) {
        if (objArr.length > 0) {
            int i = 0;
            Object obj = objArr[0];
            if (obj instanceof Wrapper) {
                String name = ((Wrapper) obj).unwrap().getClass().getName();
                Scriptable scriptable2 = this;
                while (true) {
                    int indexOf = name.indexOf(46, i);
                    Object obj2 = scriptable2.get(indexOf == -1 ? name.substring(i) : name.substring(i, indexOf), scriptable2);
                    if (!(obj2 instanceof Scriptable)) {
                        break;
                    }
                    scriptable2 = (Scriptable) obj2;
                    if (indexOf == -1) {
                        return scriptable2;
                    }
                    i = indexOf + 1;
                }
            }
        }
        throw Context.reportRuntimeError0("msg.not.java.obj");
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Function, external.sdk.pendo.io.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return construct(context, scriptable, objArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0021  */
    @Override // external.sdk.pendo.io.mozilla.javascript.Function
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public external.sdk.pendo.io.mozilla.javascript.Scriptable construct(external.sdk.pendo.io.mozilla.javascript.Context r3, external.sdk.pendo.io.mozilla.javascript.Scriptable r4, java.lang.Object[] r5) {
        /*
            r2 = this;
            int r3 = r5.length
            r0 = 0
            if (r3 == 0) goto L18
            r3 = 0
            r3 = r5[r3]
            boolean r5 = r3 instanceof external.sdk.pendo.io.mozilla.javascript.Wrapper
            if (r5 == 0) goto L11
            external.sdk.pendo.io.mozilla.javascript.Wrapper r3 = (external.sdk.pendo.io.mozilla.javascript.Wrapper) r3
            java.lang.Object r3 = r3.unwrap()
        L11:
            boolean r5 = r3 instanceof java.lang.ClassLoader
            if (r5 == 0) goto L18
            java.lang.ClassLoader r3 = (java.lang.ClassLoader) r3
            goto L19
        L18:
            r3 = r0
        L19:
            if (r3 != 0) goto L21
            java.lang.String r3 = "msg.not.classloader"
            external.sdk.pendo.io.mozilla.javascript.Context.reportRuntimeError0(r3)
            return r0
        L21:
            external.sdk.pendo.io.mozilla.javascript.NativeJavaPackage r5 = new external.sdk.pendo.io.mozilla.javascript.NativeJavaPackage
            r0 = 1
            java.lang.String r1 = ""
            r5.<init>(r0, r1, r3)
            external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.setObjectProtoAndParent(r5, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.NativeJavaTopPackage.construct(external.sdk.pendo.io.mozilla.javascript.Context, external.sdk.pendo.io.mozilla.javascript.Scriptable, java.lang.Object[]):external.sdk.pendo.io.mozilla.javascript.Scriptable");
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (idFunctionObject.hasTag(FTAG) && idFunctionObject.methodId() == 1) {
            return js_getClass(context, scriptable, objArr);
        }
        throw idFunctionObject.unknown();
    }
}
