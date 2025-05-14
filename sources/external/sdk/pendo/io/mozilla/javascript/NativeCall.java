package external.sdk.pendo.io.mozilla.javascript;

/* loaded from: classes2.dex */
public final class NativeCall extends IdScriptableObject {
    private static final Object CALL_TAG = "Call";
    private static final int Id_constructor = 1;
    private static final int MAX_PROTOTYPE_ID = 1;
    private static final long serialVersionUID = -7471457301304454454L;
    private Arguments arguments;
    NativeFunction function;
    boolean isStrict;
    Object[] originalArgs;
    transient NativeCall parentActivationCall;

    NativeCall() {
    }

    NativeCall(NativeFunction nativeFunction, Scriptable scriptable, Object[] objArr, boolean z, boolean z2) {
        this.function = nativeFunction;
        setParentScope(scriptable);
        this.originalArgs = objArr == null ? ScriptRuntime.emptyArgs : objArr;
        this.isStrict = z2;
        int paramAndVarCount = nativeFunction.getParamAndVarCount();
        int paramCount = nativeFunction.getParamCount();
        if (paramAndVarCount != 0) {
            int i = 0;
            while (i < paramCount) {
                defineProperty(nativeFunction.getParamOrVarName(i), i < objArr.length ? objArr[i] : Undefined.instance, 4);
                i++;
            }
        }
        if (!super.has("arguments", this) && !z) {
            Arguments arguments = new Arguments(this);
            this.arguments = arguments;
            defineProperty("arguments", arguments, 4);
        }
        if (paramAndVarCount != 0) {
            while (paramCount < paramAndVarCount) {
                String paramOrVarName = nativeFunction.getParamOrVarName(paramCount);
                if (!super.has(paramOrVarName, this)) {
                    if (nativeFunction.getParamOrVarConst(paramCount)) {
                        defineProperty(paramOrVarName, Undefined.instance, 13);
                    } else if (!(nativeFunction instanceof InterpretedFunction) || ((InterpretedFunction) nativeFunction).hasFunctionNamed(paramOrVarName)) {
                        defineProperty(paramOrVarName, Undefined.instance, 4);
                    }
                }
                paramCount++;
            }
        }
    }

    static void init(Scriptable scriptable, boolean z) {
        new NativeCall().exportAsJSClass(1, scriptable, z);
    }

    public void defineAttributesForArguments() {
        Arguments arguments = this.arguments;
        if (arguments != null) {
            arguments.defineAttributesForStrictMode();
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject, external.sdk.pendo.io.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(CALL_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        if (methodId != 1) {
            throw new IllegalArgumentException(String.valueOf(methodId));
        }
        if (scriptable2 != null) {
            throw Context.reportRuntimeError1("msg.only.from.new", "Call");
        }
        ScriptRuntime.checkDeprecated(context, "Call");
        NativeCall nativeCall = new NativeCall();
        nativeCall.setPrototype(ScriptableObject.getObjectPrototype(scriptable));
        return nativeCall;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(String str) {
        return str.equals("constructor") ? 1 : 0;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Call";
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        if (i != 1) {
            throw new IllegalArgumentException(String.valueOf(i));
        }
        initPrototypeMethod(CALL_TAG, i, "constructor", 1);
    }
}
