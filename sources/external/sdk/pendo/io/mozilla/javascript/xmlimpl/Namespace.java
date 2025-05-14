package external.sdk.pendo.io.mozilla.javascript.xmlimpl;

import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.IdFunctionObject;
import external.sdk.pendo.io.mozilla.javascript.IdScriptableObject;
import external.sdk.pendo.io.mozilla.javascript.ScriptRuntime;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import external.sdk.pendo.io.mozilla.javascript.Undefined;
import external.sdk.pendo.io.mozilla.javascript.xmlimpl.XmlNode;

/* loaded from: classes2.dex */
class Namespace extends IdScriptableObject {
    private static final int Id_constructor = 1;
    private static final int Id_prefix = 1;
    private static final int Id_toSource = 3;
    private static final int Id_toString = 2;
    private static final int Id_uri = 2;
    private static final int MAX_INSTANCE_ID = 2;
    private static final int MAX_PROTOTYPE_ID = 3;
    private static final Object NAMESPACE_TAG = "Namespace";
    static final long serialVersionUID = -5765755238131301744L;
    private XmlNode.Namespace ns;
    private Namespace prototype;

    private Namespace() {
    }

    private Namespace constructNamespace() {
        return newNamespace("", "");
    }

    static Namespace create(Scriptable scriptable, Namespace namespace, XmlNode.Namespace namespace2) {
        Namespace namespace3 = new Namespace();
        namespace3.setParentScope(scriptable);
        namespace3.prototype = namespace;
        namespace3.setPrototype(namespace);
        namespace3.ns = namespace2;
        return namespace3;
    }

    private boolean equals(Namespace namespace) {
        return uri().equals(namespace.uri());
    }

    private Object jsConstructor(Context context, boolean z, Object[] objArr) {
        return (z || objArr.length != 1) ? objArr.length == 0 ? constructNamespace() : objArr.length == 1 ? constructNamespace(objArr[0]) : constructNamespace(objArr[0], objArr[1]) : castToNamespace(objArr[0]);
    }

    private String js_toSource() {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        toSourceImpl(this.ns.getPrefix(), this.ns.getUri(), sb);
        sb.append(')');
        return sb.toString();
    }

    private Namespace realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable instanceof Namespace) {
            return (Namespace) scriptable;
        }
        throw IdScriptableObject.incompatibleCallError(idFunctionObject);
    }

    static void toSourceImpl(String str, String str2, StringBuilder sb) {
        sb.append("new Namespace(");
        if (str2.length() != 0) {
            sb.append('\'');
            if (str != null) {
                sb.append(ScriptRuntime.escapeString(str, '\''));
                sb.append("', '");
            }
            sb.append(ScriptRuntime.escapeString(str2, '\''));
            sb.append('\'');
        } else if (!"".equals(str)) {
            throw new IllegalArgumentException(str);
        }
        sb.append(')');
    }

    Namespace castToNamespace(Object obj) {
        return obj instanceof Namespace ? (Namespace) obj : constructNamespace(obj);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject
    protected Object equivalentValues(Object obj) {
        return !(obj instanceof Namespace) ? Scriptable.NOT_FOUND : equals((Namespace) obj) ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject, external.sdk.pendo.io.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(NAMESPACE_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        if (methodId == 1) {
            return jsConstructor(context, scriptable2 == null, objArr);
        }
        if (methodId == 2) {
            return realThis(scriptable2, idFunctionObject).toString();
        }
        if (methodId == 3) {
            return realThis(scriptable2, idFunctionObject).js_toSource();
        }
        throw new IllegalArgumentException(String.valueOf(methodId));
    }

    public void exportAsJSClass(boolean z) {
        exportAsJSClass(3, getParentScope(), z);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findInstanceIdInfo(String str) {
        String str2;
        int i;
        int length = str.length();
        if (length == 3) {
            str2 = "uri";
            i = 2;
        } else if (length == 6) {
            str2 = "prefix";
            i = 1;
        } else {
            str2 = null;
            i = 0;
        }
        int i2 = (str2 == null || str2 == str || str2.equals(str)) ? i : 0;
        if (i2 == 0) {
            return super.findInstanceIdInfo(str);
        }
        if (i2 == 1 || i2 == 2) {
            return IdScriptableObject.instanceIdInfo(5, super.getMaxInstanceId() + i2);
        }
        throw new IllegalStateException();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(String str) {
        String str2;
        int i;
        int length = str.length();
        if (length == 8) {
            i = 3;
            char charAt = str.charAt(3);
            if (charAt == 'o') {
                str2 = "toSource";
            } else {
                if (charAt == 't') {
                    str2 = "toString";
                    i = 2;
                }
                str2 = null;
                i = 0;
            }
        } else {
            if (length == 11) {
                str2 = "constructor";
                i = 1;
            }
            str2 = null;
            i = 0;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Namespace";
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public Object getDefaultValue(Class<?> cls) {
        return uri();
    }

    final XmlNode.Namespace getDelegate() {
        return this.ns;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected String getInstanceIdName(int i) {
        int maxInstanceId = i - super.getMaxInstanceId();
        return maxInstanceId != 1 ? maxInstanceId != 2 ? super.getInstanceIdName(i) : "uri" : "prefix";
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected Object getInstanceIdValue(int i) {
        int maxInstanceId = i - super.getMaxInstanceId();
        return maxInstanceId != 1 ? maxInstanceId != 2 ? super.getInstanceIdValue(i) : this.ns.getUri() : this.ns.getPrefix() == null ? Undefined.instance : this.ns.getPrefix();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int getMaxInstanceId() {
        return super.getMaxInstanceId() + 2;
    }

    public int hashCode() {
        return uri().hashCode();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        int i2;
        if (i != 1) {
            i2 = 0;
            if (i == 2) {
                str = "toString";
            } else {
                if (i != 3) {
                    throw new IllegalArgumentException(String.valueOf(i));
                }
                str = "toSource";
            }
        } else {
            str = "constructor";
            i2 = 2;
        }
        initPrototypeMethod(NAMESPACE_TAG, i, str, i2);
    }

    Namespace newNamespace(String str) {
        Namespace namespace = this.prototype;
        if (namespace == null) {
            namespace = this;
        }
        return create(getParentScope(), namespace, XmlNode.Namespace.create(str));
    }

    public String prefix() {
        return this.ns.getPrefix();
    }

    public String toLocaleString() {
        return toString();
    }

    public String toString() {
        return uri();
    }

    public String uri() {
        return this.ns.getUri();
    }

    Namespace constructNamespace(Object obj) {
        String scriptRuntime;
        String str;
        if (obj instanceof Namespace) {
            Namespace namespace = (Namespace) obj;
            str = namespace.prefix();
            scriptRuntime = namespace.uri();
        } else if (obj instanceof QName) {
            QName qName = (QName) obj;
            String uri = qName.uri();
            if (uri != null) {
                str = qName.prefix();
                scriptRuntime = uri;
            } else {
                scriptRuntime = qName.toString();
                str = null;
            }
        } else {
            scriptRuntime = ScriptRuntime.toString(obj);
            if (scriptRuntime.length() == 0) {
                str = "";
            }
            str = null;
        }
        return newNamespace(str, scriptRuntime);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Namespace) {
            return equals((Namespace) obj);
        }
        return false;
    }

    Namespace newNamespace(String str, String str2) {
        if (str == null) {
            return newNamespace(str2);
        }
        Namespace namespace = this.prototype;
        if (namespace == null) {
            namespace = this;
        }
        return create(getParentScope(), namespace, XmlNode.Namespace.create(str, str2));
    }

    private Namespace constructNamespace(Object obj, Object obj2) {
        String scriptRuntime;
        String scriptRuntime2;
        if (obj2 instanceof QName) {
            QName qName = (QName) obj2;
            scriptRuntime = qName.uri();
            if (scriptRuntime == null) {
                scriptRuntime = qName.toString();
            }
        } else {
            scriptRuntime = ScriptRuntime.toString(obj2);
        }
        if (scriptRuntime.length() == 0) {
            if (obj != Undefined.instance) {
                scriptRuntime2 = ScriptRuntime.toString(obj);
                if (scriptRuntime2.length() != 0) {
                    throw ScriptRuntime.typeError("Illegal prefix '" + scriptRuntime2 + "' for 'no namespace'.");
                }
            }
            scriptRuntime2 = "";
        } else {
            if (obj != Undefined.instance && XMLName.accept(obj)) {
                scriptRuntime2 = ScriptRuntime.toString(obj);
            }
            scriptRuntime2 = "";
        }
        return newNamespace(scriptRuntime2, scriptRuntime);
    }
}
