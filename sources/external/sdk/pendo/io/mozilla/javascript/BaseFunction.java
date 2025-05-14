package external.sdk.pendo.io.mozilla.javascript;

import androidx.core.app.NotificationCompat;
import io.sentry.SentryEnvelopeItemHeader;
import io.sentry.protocol.SentryStackFrame;

/* loaded from: classes2.dex */
public class BaseFunction extends IdScriptableObject implements Function {
    private static final String FUNCTION_CLASS = "Function";
    private static final Object FUNCTION_TAG = FUNCTION_CLASS;
    static final String GENERATOR_FUNCTION_CLASS = "__GeneratorFunction";
    private static final int Id_apply = 4;
    private static final int Id_arguments = 5;
    private static final int Id_arity = 2;
    private static final int Id_bind = 6;
    private static final int Id_call = 5;
    private static final int Id_constructor = 1;
    private static final int Id_length = 1;
    private static final int Id_name = 3;
    private static final int Id_prototype = 4;
    private static final int Id_toSource = 3;
    private static final int Id_toString = 2;
    private static final int MAX_INSTANCE_ID = 5;
    private static final int MAX_PROTOTYPE_ID = 6;
    private static final long serialVersionUID = 5311394446546053859L;
    private int argumentsAttributes;
    private Object argumentsObj;
    private boolean isGeneratorFunction;
    private Object prototypeProperty;
    private int prototypePropertyAttributes;

    public BaseFunction() {
        this.argumentsObj = Scriptable.NOT_FOUND;
        this.isGeneratorFunction = false;
        this.prototypePropertyAttributes = 6;
        this.argumentsAttributes = 6;
    }

    private Object getArguments() {
        Object defaultGet = defaultHas("arguments") ? defaultGet("arguments") : this.argumentsObj;
        if (defaultGet != Scriptable.NOT_FOUND) {
            return defaultGet;
        }
        Scriptable findFunctionActivation = ScriptRuntime.findFunctionActivation(Context.getContext(), this);
        if (findFunctionActivation == null) {
            return null;
        }
        return findFunctionActivation.get("arguments", findFunctionActivation);
    }

    static void init(Scriptable scriptable, boolean z) {
        BaseFunction baseFunction = new BaseFunction();
        baseFunction.prototypePropertyAttributes = 7;
        baseFunction.exportAsJSClass(6, scriptable, z);
    }

    static Object initAsGeneratorFunction(Scriptable scriptable, boolean z) {
        BaseFunction baseFunction = new BaseFunction(true);
        baseFunction.prototypePropertyAttributes = 5;
        baseFunction.exportAsJSClass(6, scriptable, z);
        return ScriptableObject.getProperty(scriptable, GENERATOR_FUNCTION_CLASS);
    }

    static boolean isApply(IdFunctionObject idFunctionObject) {
        return idFunctionObject.hasTag(FUNCTION_TAG) && idFunctionObject.methodId() == 4;
    }

    static boolean isApplyOrCall(IdFunctionObject idFunctionObject) {
        if (!idFunctionObject.hasTag(FUNCTION_TAG)) {
            return false;
        }
        int methodId = idFunctionObject.methodId();
        return methodId == 4 || methodId == 5;
    }

    private Object jsConstructor(Context context, Scriptable scriptable, Object[] objArr) {
        int i;
        int length = objArr.length;
        StringBuilder sb = new StringBuilder("function ");
        if (isGeneratorFunction()) {
            sb.append("* ");
        }
        if (context.getLanguageVersion() != 120) {
            sb.append("anonymous");
        }
        sb.append('(');
        int i2 = 0;
        while (true) {
            i = length - 1;
            if (i2 >= i) {
                break;
            }
            if (i2 > 0) {
                sb.append(',');
            }
            sb.append(ScriptRuntime.toString(objArr[i2]));
            i2++;
        }
        sb.append(") {");
        if (length != 0) {
            sb.append(ScriptRuntime.toString(objArr[i]));
        }
        sb.append("\n}");
        String sb2 = sb.toString();
        int[] iArr = new int[1];
        String sourcePositionFromStack = Context.getSourcePositionFromStack(iArr);
        if (sourcePositionFromStack == null) {
            iArr[0] = 1;
            sourcePositionFromStack = "<eval'ed string>";
        }
        String makeUrlForGeneratedScript = ScriptRuntime.makeUrlForGeneratedScript(false, sourcePositionFromStack, iArr[0]);
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        ErrorReporter forEval = DefaultErrorReporter.forEval(context.getErrorReporter());
        Evaluator createInterpreter = Context.createInterpreter();
        if (createInterpreter != null) {
            return context.compileFunction(topLevelScope, sb2, createInterpreter, forEval, makeUrlForGeneratedScript, 1, null);
        }
        throw new JavaScriptException("Interpreter not present", sourcePositionFromStack, iArr[0]);
    }

    private static BaseFunction realFunction(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        Object defaultValue = scriptable.getDefaultValue(ScriptRuntime.FunctionClass);
        if (defaultValue instanceof Delegator) {
            defaultValue = ((Delegator) defaultValue).getDelegee();
        }
        if (defaultValue instanceof BaseFunction) {
            return (BaseFunction) defaultValue;
        }
        throw ScriptRuntime.typeError1("msg.incompat.call", idFunctionObject.getFunctionName());
    }

    private synchronized Object setupDefaultPrototype() {
        Object obj = this.prototypeProperty;
        if (obj != null) {
            return obj;
        }
        NativeObject nativeObject = new NativeObject();
        nativeObject.defineProperty("constructor", this, 2);
        this.prototypeProperty = nativeObject;
        Scriptable objectPrototype = ScriptableObject.getObjectPrototype(this);
        if (objectPrototype != nativeObject) {
            nativeObject.setPrototype(objectPrototype);
        }
        return nativeObject;
    }

    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return Undefined.instance;
    }

    public Scriptable construct(Context context, Scriptable scriptable, Object[] objArr) {
        Scriptable parentScope;
        Scriptable classPrototype;
        Scriptable createObject = createObject(context, scriptable);
        if (createObject != null) {
            Object call = call(context, scriptable, createObject, objArr);
            return call instanceof Scriptable ? (Scriptable) call : createObject;
        }
        Object call2 = call(context, scriptable, null, objArr);
        if (!(call2 instanceof Scriptable)) {
            throw new IllegalStateException("Bad implementaion of call as constructor, name=" + getFunctionName() + " in " + getClass().getName());
        }
        Scriptable scriptable2 = (Scriptable) call2;
        if (scriptable2.getPrototype() == null && scriptable2 != (classPrototype = getClassPrototype())) {
            scriptable2.setPrototype(classPrototype);
        }
        if (scriptable2.getParentScope() != null || scriptable2 == (parentScope = getParentScope())) {
            return scriptable2;
        }
        scriptable2.setParentScope(parentScope);
        return scriptable2;
    }

    public Scriptable createObject(Context context, Scriptable scriptable) {
        NativeObject nativeObject = new NativeObject();
        nativeObject.setPrototype(getClassPrototype());
        nativeObject.setParentScope(getParentScope());
        return nativeObject;
    }

    String decompile(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        boolean z = (i2 & 1) != 0;
        if (!z) {
            sb.append("function ");
            sb.append(getFunctionName());
            sb.append("() {\n\t");
        }
        sb.append("[native code, arity=");
        sb.append(getArity());
        sb.append("]\n");
        if (!z) {
            sb.append("}\n");
        }
        return sb.toString();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject, external.sdk.pendo.io.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        int int32;
        Object[] objArr2;
        Scriptable scriptable3;
        if (!idFunctionObject.hasTag(FUNCTION_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        int i = 0;
        switch (methodId) {
            case 1:
                return jsConstructor(context, scriptable, objArr);
            case 2:
                return realFunction(scriptable2, idFunctionObject).decompile(ScriptRuntime.toInt32(objArr, 0), 0);
            case 3:
                BaseFunction realFunction = realFunction(scriptable2, idFunctionObject);
                int i2 = 2;
                if (objArr.length != 0 && (int32 = ScriptRuntime.toInt32(objArr[0])) >= 0) {
                    i2 = 0;
                    i = int32;
                }
                return realFunction.decompile(i, i2);
            case 4:
            case 5:
                return ScriptRuntime.applyOrCall(methodId == 4, context, scriptable, scriptable2, objArr);
            case 6:
                if (!(scriptable2 instanceof Callable)) {
                    throw ScriptRuntime.notFunctionError(scriptable2);
                }
                Callable callable = (Callable) scriptable2;
                int length = objArr.length;
                if (length > 0) {
                    Scriptable objectOrNull = ScriptRuntime.toObjectOrNull(context, objArr[0], scriptable);
                    int i3 = length - 1;
                    Object[] objArr3 = new Object[i3];
                    System.arraycopy(objArr, 1, objArr3, 0, i3);
                    scriptable3 = objectOrNull;
                    objArr2 = objArr3;
                } else {
                    objArr2 = ScriptRuntime.emptyArgs;
                    scriptable3 = null;
                }
                return new BoundFunction(context, scriptable, callable, scriptable3, objArr2);
            default:
                throw new IllegalArgumentException(String.valueOf(methodId));
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        idFunctionObject.setPrototype(this);
        super.fillConstructorProperties(idFunctionObject);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findInstanceIdInfo(String str) {
        String str2;
        int i;
        int i2;
        int length = str.length();
        if (length == 4) {
            str2 = "name";
            i = 3;
        } else if (length == 5) {
            str2 = "arity";
            i = 2;
        } else if (length != 6) {
            if (length == 9) {
                char charAt = str.charAt(0);
                if (charAt == 'a') {
                    str2 = "arguments";
                    i = 5;
                } else if (charAt == 'p') {
                    str2 = "prototype";
                    i = 4;
                }
            }
            str2 = null;
            i = 0;
        } else {
            str2 = SentryEnvelopeItemHeader.JsonKeys.LENGTH;
            i = 1;
        }
        if (str2 != null && str2 != str && !str2.equals(str)) {
            i = 0;
        }
        if (i == 0) {
            return super.findInstanceIdInfo(str);
        }
        if (i == 1 || i == 2 || i == 3) {
            i2 = 7;
        } else if (i != 4) {
            if (i != 5) {
                throw new IllegalStateException();
            }
            i2 = this.argumentsAttributes;
        } else {
            if (!hasPrototypeProperty()) {
                return 0;
            }
            i2 = this.prototypePropertyAttributes;
        }
        return IdScriptableObject.instanceIdInfo(i2, i);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(String str) {
        String str2;
        int length = str.length();
        int i = 5;
        if (length == 4) {
            char charAt = str.charAt(0);
            if (charAt == 'b') {
                str2 = "bind";
                i = 6;
            } else {
                if (charAt == 'c') {
                    str2 = NotificationCompat.CATEGORY_CALL;
                }
                str2 = null;
                i = 0;
            }
        } else if (length == 5) {
            str2 = "apply";
            i = 4;
        } else if (length != 8) {
            if (length == 11) {
                str2 = "constructor";
                i = 1;
            }
            str2 = null;
            i = 0;
        } else {
            i = 3;
            char charAt2 = str.charAt(3);
            if (charAt2 == 'o') {
                str2 = "toSource";
            } else {
                if (charAt2 == 't') {
                    str2 = "toString";
                    i = 2;
                }
                str2 = null;
                i = 0;
            }
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }

    public int getArity() {
        return 0;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public String getClassName() {
        return isGeneratorFunction() ? GENERATOR_FUNCTION_CLASS : FUNCTION_CLASS;
    }

    protected Scriptable getClassPrototype() {
        Object prototypeProperty = getPrototypeProperty();
        return prototypeProperty instanceof Scriptable ? (Scriptable) prototypeProperty : ScriptableObject.getObjectPrototype(this);
    }

    public String getFunctionName() {
        return "";
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected String getInstanceIdName(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? super.getInstanceIdName(i) : "arguments" : "prototype" : "name" : "arity" : SentryEnvelopeItemHeader.JsonKeys.LENGTH;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected Object getInstanceIdValue(int i) {
        int length;
        if (i == 1) {
            length = getLength();
        } else {
            if (i != 2) {
                return i != 3 ? i != 4 ? i != 5 ? super.getInstanceIdValue(i) : getArguments() : getPrototypeProperty() : getFunctionName();
            }
            length = getArity();
        }
        return ScriptRuntime.wrapInt(length);
    }

    public int getLength() {
        return 0;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int getMaxInstanceId() {
        return 5;
    }

    protected Object getPrototypeProperty() {
        Object obj = this.prototypeProperty;
        if (obj == null) {
            return this instanceof NativeFunction ? setupDefaultPrototype() : Undefined.instance;
        }
        if (obj == UniqueTag.NULL_VALUE) {
            return null;
        }
        return obj;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject
    public String getTypeOf() {
        return avoidObjectDetection() ? "undefined" : SentryStackFrame.JsonKeys.FUNCTION;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public boolean hasInstance(Scriptable scriptable) {
        Object property = ScriptableObject.getProperty(this, "prototype");
        if (property instanceof Scriptable) {
            return ScriptRuntime.jsDelegatesTo(scriptable, (Scriptable) property);
        }
        throw ScriptRuntime.typeError1("msg.instanceof.bad.prototype", getFunctionName());
    }

    protected boolean hasPrototypeProperty() {
        return this.prototypeProperty != null || (this instanceof NativeFunction);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        int i2 = 1;
        switch (i) {
            case 1:
                str = "constructor";
                break;
            case 2:
                i2 = 0;
                str = "toString";
                break;
            case 3:
                str = "toSource";
                break;
            case 4:
                i2 = 2;
                str = "apply";
                break;
            case 5:
                str = NotificationCompat.CATEGORY_CALL;
                break;
            case 6:
                str = "bind";
                break;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
        initPrototypeMethod(FUNCTION_TAG, i, str, i2);
    }

    protected boolean isGeneratorFunction() {
        return this.isGeneratorFunction;
    }

    public void setImmunePrototypeProperty(Object obj) {
        if ((this.prototypePropertyAttributes & 1) != 0) {
            throw new IllegalStateException();
        }
        if (obj == null) {
            obj = UniqueTag.NULL_VALUE;
        }
        this.prototypeProperty = obj;
        this.prototypePropertyAttributes = 7;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void setInstanceIdAttributes(int i, int i2) {
        if (i == 4) {
            this.prototypePropertyAttributes = i2;
        } else if (i != 5) {
            super.setInstanceIdAttributes(i, i2);
        } else {
            this.argumentsAttributes = i2;
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void setInstanceIdValue(int i, Object obj) {
        if (i == 1 || i == 2 || i == 3) {
            return;
        }
        if (i == 4) {
            if ((this.prototypePropertyAttributes & 1) == 0) {
                if (obj == null) {
                    obj = UniqueTag.NULL_VALUE;
                }
                this.prototypeProperty = obj;
                return;
            }
            return;
        }
        if (i != 5) {
            super.setInstanceIdValue(i, obj);
            return;
        }
        if (obj == Scriptable.NOT_FOUND) {
            Kit.codeBug();
        }
        if (defaultHas("arguments")) {
            defaultPut("arguments", obj);
        } else if ((this.argumentsAttributes & 1) == 0) {
            this.argumentsObj = obj;
        }
    }

    public BaseFunction(Scriptable scriptable, Scriptable scriptable2) {
        super(scriptable, scriptable2);
        this.argumentsObj = Scriptable.NOT_FOUND;
        this.isGeneratorFunction = false;
        this.prototypePropertyAttributes = 6;
        this.argumentsAttributes = 6;
    }

    public BaseFunction(boolean z) {
        this.argumentsObj = Scriptable.NOT_FOUND;
        this.prototypePropertyAttributes = 6;
        this.argumentsAttributes = 6;
        this.isGeneratorFunction = z;
    }
}
