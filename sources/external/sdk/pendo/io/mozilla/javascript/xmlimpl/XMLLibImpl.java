package external.sdk.pendo.io.mozilla.javascript.xmlimpl;

import androidx.webkit.ProxyConfig;
import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.Kit;
import external.sdk.pendo.io.mozilla.javascript.Ref;
import external.sdk.pendo.io.mozilla.javascript.ScriptRuntime;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import external.sdk.pendo.io.mozilla.javascript.Undefined;
import external.sdk.pendo.io.mozilla.javascript.Wrapper;
import external.sdk.pendo.io.mozilla.javascript.xml.XMLLib;
import external.sdk.pendo.io.mozilla.javascript.xmlimpl.XmlNode;
import java.io.Serializable;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/* loaded from: classes2.dex */
public final class XMLLibImpl extends XMLLib implements Serializable {
    private static final long serialVersionUID = 1;
    private Scriptable globalScope;
    private Namespace namespacePrototype;
    private XmlProcessor options = new XmlProcessor();
    private QName qnamePrototype;
    private XMLList xmlListPrototype;
    private XML xmlPrototype;

    private XMLLibImpl(Scriptable scriptable) {
        this.globalScope = scriptable;
    }

    private static RuntimeException badXMLName(Object obj) {
        String str;
        if (obj instanceof Number) {
            str = "Can not construct XML name from number: ";
        } else if (obj instanceof Boolean) {
            str = "Can not construct XML name from boolean: ";
        } else {
            if (obj != Undefined.instance && obj != null) {
                throw new IllegalArgumentException(obj.toString());
            }
            str = "Can not construct XML name from ";
        }
        return ScriptRuntime.typeError(str + ScriptRuntime.toString(obj));
    }

    private void exportToScope(boolean z) {
        this.xmlPrototype = newXML(XmlNode.createText(this.options, ""));
        this.xmlListPrototype = newXMLList();
        this.namespacePrototype = Namespace.create(this.globalScope, null, XmlNode.Namespace.GLOBAL);
        this.qnamePrototype = QName.create(this, this.globalScope, null, XmlNode.QName.create(XmlNode.Namespace.create(""), ""));
        this.xmlPrototype.exportAsJSClass(z);
        this.xmlListPrototype.exportAsJSClass(z);
        this.namespacePrototype.exportAsJSClass(z);
        this.qnamePrototype.exportAsJSClass(z);
    }

    private String getDefaultNamespaceURI(Context context) {
        return getDefaultNamespace(context).uri();
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        XMLLibImpl xMLLibImpl = new XMLLibImpl(scriptable);
        if (xMLLibImpl.bindToScope(scriptable) == xMLLibImpl) {
            xMLLibImpl.exportToScope(z);
        }
    }

    private XML parse(String str) {
        try {
            return newXML(XmlNode.createElement(this.options, getDefaultNamespaceURI(Context.getCurrentContext()), str));
        } catch (SAXException e) {
            throw ScriptRuntime.typeError("Cannot parse XML: " + e.getMessage());
        }
    }

    public static Node toDomNode(Object obj) {
        if (obj instanceof XML) {
            return ((XML) obj).toDomNode();
        }
        throw new IllegalArgumentException("xmlObject is not an XML object in JavaScript.");
    }

    private Ref xmlPrimaryReference(Context context, XMLName xMLName, Scriptable scriptable) {
        XMLObjectImpl xMLObjectImpl;
        XMLObjectImpl xMLObjectImpl2 = null;
        while (true) {
            if (scriptable instanceof XMLWithScope) {
                xMLObjectImpl = (XMLObjectImpl) scriptable.getPrototype();
                if (xMLObjectImpl.hasXMLProperty(xMLName)) {
                    break;
                }
                if (xMLObjectImpl2 == null) {
                    xMLObjectImpl2 = xMLObjectImpl;
                }
            }
            scriptable = scriptable.getParentScope();
            if (scriptable == null) {
                xMLObjectImpl = xMLObjectImpl2;
                break;
            }
        }
        if (xMLObjectImpl != null) {
            xMLName.initXMLObject(xMLObjectImpl);
        }
        return xMLName;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.lang.Object addXMLObjects(external.sdk.pendo.io.mozilla.javascript.Context r5, external.sdk.pendo.io.mozilla.javascript.xml.XMLObject r6, external.sdk.pendo.io.mozilla.javascript.xml.XMLObject r7) {
        /*
            r4 = this;
            external.sdk.pendo.io.mozilla.javascript.xmlimpl.XMLList r5 = r4.newXMLList()
            boolean r0 = r6 instanceof external.sdk.pendo.io.mozilla.javascript.xmlimpl.XMLList
            r1 = 0
            if (r0 == 0) goto L1d
            r0 = r6
            external.sdk.pendo.io.mozilla.javascript.xmlimpl.XMLList r0 = (external.sdk.pendo.io.mozilla.javascript.xmlimpl.XMLList) r0
            int r2 = r0.length()
            r3 = 1
            if (r2 != r3) goto L18
            external.sdk.pendo.io.mozilla.javascript.xmlimpl.XML r6 = r0.item(r1)
            goto L1d
        L18:
            external.sdk.pendo.io.mozilla.javascript.xmlimpl.XMLList r5 = r4.newXMLListFrom(r6)
            goto L20
        L1d:
            r5.addToList(r6)
        L20:
            boolean r6 = r7 instanceof external.sdk.pendo.io.mozilla.javascript.xmlimpl.XMLList
            if (r6 == 0) goto L36
            external.sdk.pendo.io.mozilla.javascript.xmlimpl.XMLList r7 = (external.sdk.pendo.io.mozilla.javascript.xmlimpl.XMLList) r7
        L26:
            int r6 = r7.length()
            if (r1 >= r6) goto L3d
            external.sdk.pendo.io.mozilla.javascript.xmlimpl.XML r6 = r7.item(r1)
            r5.addToList(r6)
            int r1 = r1 + 1
            goto L26
        L36:
            boolean r6 = r7 instanceof external.sdk.pendo.io.mozilla.javascript.xmlimpl.XML
            if (r6 == 0) goto L3d
            r5.addToList(r7)
        L3d:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.xmlimpl.XMLLibImpl.addXMLObjects(external.sdk.pendo.io.mozilla.javascript.Context, external.sdk.pendo.io.mozilla.javascript.xml.XMLObject, external.sdk.pendo.io.mozilla.javascript.xml.XMLObject):java.lang.Object");
    }

    Namespace castToNamespace(Context context, Object obj) {
        return this.namespacePrototype.castToNamespace(obj);
    }

    QName castToQName(Context context, Object obj) {
        return this.qnamePrototype.castToQName(this, context, obj);
    }

    QName constructQName(Context context, Object obj) {
        return this.qnamePrototype.constructQName(this, context, obj);
    }

    Namespace[] createNamespaces(XmlNode.Namespace[] namespaceArr) {
        Namespace[] namespaceArr2 = new Namespace[namespaceArr.length];
        for (int i = 0; i < namespaceArr.length; i++) {
            namespaceArr2[i] = this.namespacePrototype.newNamespace(namespaceArr[i].getPrefix(), namespaceArr[i].getUri());
        }
        return namespaceArr2;
    }

    final XML ecmaToXml(Object obj) {
        XmlNode createText;
        if (obj == null || obj == Undefined.instance) {
            throw ScriptRuntime.typeError("Cannot convert " + obj + " to XML");
        }
        if (obj instanceof XML) {
            return (XML) obj;
        }
        if (obj instanceof XMLList) {
            XMLList xMLList = (XMLList) obj;
            if (xMLList.getXML() != null) {
                return xMLList.getXML();
            }
            throw ScriptRuntime.typeError("Cannot convert list of >1 element to XML");
        }
        if (obj instanceof Wrapper) {
            obj = ((Wrapper) obj).unwrap();
        }
        if (obj instanceof Node) {
            createText = XmlNode.createElementFromNode((Node) obj);
        } else {
            String scriptRuntime = ScriptRuntime.toString(obj);
            if (scriptRuntime.length() > 0 && scriptRuntime.charAt(0) == '<') {
                return parse(scriptRuntime);
            }
            createText = XmlNode.createText(this.options, scriptRuntime);
        }
        return newXML(createText);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLLib
    public String escapeAttributeValue(Object obj) {
        return this.options.escapeAttributeValue(obj);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLLib
    public String escapeTextValue(Object obj) {
        return this.options.escapeTextValue(obj);
    }

    Namespace getDefaultNamespace(Context context) {
        Object searchDefaultNamespace;
        if ((context != null || (context = Context.getCurrentContext()) != null) && (searchDefaultNamespace = ScriptRuntime.searchDefaultNamespace(context)) != null && (searchDefaultNamespace instanceof Namespace)) {
            return (Namespace) searchDefaultNamespace;
        }
        return this.namespacePrototype;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLLib
    public int getPrettyIndent() {
        return this.options.getPrettyIndent();
    }

    XmlProcessor getProcessor() {
        return this.options;
    }

    @Deprecated
    Scriptable globalScope() {
        return this.globalScope;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLLib
    public boolean isIgnoreComments() {
        return this.options.isIgnoreComments();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLLib
    public boolean isIgnoreProcessingInstructions() {
        return this.options.isIgnoreProcessingInstructions();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLLib
    public boolean isIgnoreWhitespace() {
        return this.options.isIgnoreWhitespace();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLLib
    public boolean isPrettyPrinting() {
        return this.options.isPrettyPrinting();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLLib
    public boolean isXMLName(Context context, Object obj) {
        return XMLName.accept(obj);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLLib
    public Ref nameRef(Context context, Object obj, Scriptable scriptable, int i) {
        if ((i & 2) != 0) {
            return xmlPrimaryReference(context, toAttributeName(context, obj), scriptable);
        }
        throw Kit.codeBug();
    }

    Namespace newNamespace(String str) {
        return this.namespacePrototype.newNamespace(str);
    }

    QName newQName(XmlNode.QName qName) {
        return QName.create(this, this.globalScope, this.qnamePrototype, qName);
    }

    final XML newTextElementXML(XmlNode xmlNode, XmlNode.QName qName, String str) {
        return newXML(XmlNode.newElementWithText(this.options, xmlNode, qName, str));
    }

    XML newXML(XmlNode xmlNode) {
        return new XML(this, this.globalScope, this.xmlPrototype, xmlNode);
    }

    final XML newXMLFromJs(Object obj) {
        String xMLString = (obj == null || obj == Undefined.instance) ? "" : obj instanceof XMLObjectImpl ? ((XMLObjectImpl) obj).toXMLString() : ScriptRuntime.toString(obj);
        if (xMLString.trim().startsWith("<>")) {
            throw ScriptRuntime.typeError("Invalid use of XML object anonymous tags <></>.");
        }
        return xMLString.indexOf("<") == -1 ? newXML(XmlNode.createText(this.options, xMLString)) : parse(xMLString);
    }

    XMLList newXMLList() {
        return new XMLList(this, this.globalScope, this.xmlListPrototype);
    }

    final XMLList newXMLListFrom(Object obj) {
        XMLList newXMLList = newXMLList();
        if (obj == null || (obj instanceof Undefined)) {
            return newXMLList;
        }
        if (obj instanceof XML) {
            newXMLList.getNodeList().add((XML) obj);
            return newXMLList;
        }
        if (obj instanceof XMLList) {
            newXMLList.getNodeList().add(((XMLList) obj).getNodeList());
            return newXMLList;
        }
        String trim = ScriptRuntime.toString(obj).trim();
        if (!trim.startsWith("<>")) {
            trim = "<>" + trim + "</>";
        }
        String str = "<fragment>" + trim.substring(2);
        if (!str.endsWith("</>")) {
            throw ScriptRuntime.typeError("XML with anonymous tag missing end anonymous tag");
        }
        XMLList children = newXMLFromJs(str.substring(0, str.length() - 3) + "</fragment>").children();
        for (int i = 0; i < children.getNodeList().length(); i++) {
            newXMLList.getNodeList().add((XML) children.item(i).copy());
        }
        return newXMLList;
    }

    @Deprecated
    QName qnamePrototype() {
        return this.qnamePrototype;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLLib
    public void setIgnoreComments(boolean z) {
        this.options.setIgnoreComments(z);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLLib
    public void setIgnoreProcessingInstructions(boolean z) {
        this.options.setIgnoreProcessingInstructions(z);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLLib
    public void setIgnoreWhitespace(boolean z) {
        this.options.setIgnoreWhitespace(z);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLLib
    public void setPrettyIndent(int i) {
        this.options.setPrettyIndent(i);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLLib
    public void setPrettyPrinting(boolean z) {
        this.options.setPrettyPrinting(z);
    }

    @Deprecated
    XMLName toAttributeName(Context context, Object obj) {
        XmlNode.QName create;
        if (obj instanceof XMLName) {
            return (XMLName) obj;
        }
        if (obj instanceof QName) {
            create = ((QName) obj).getDelegate();
        } else {
            if ((obj instanceof Boolean) || (obj instanceof Number) || obj == Undefined.instance || obj == null) {
                throw badXMLName(obj);
            }
            String scriptRuntime = obj instanceof String ? (String) obj : ScriptRuntime.toString(obj);
            if (scriptRuntime != null && scriptRuntime.equals(ProxyConfig.MATCH_ALL_SCHEMES)) {
                scriptRuntime = null;
            }
            create = XmlNode.QName.create(XmlNode.Namespace.create(""), scriptRuntime);
        }
        return XMLName.create(create, true, false);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLLib
    public Object toDefaultXmlNamespace(Context context, Object obj) {
        return this.namespacePrototype.constructNamespace(obj);
    }

    XmlNode.QName toNodeQName(Context context, Object obj, Object obj2) {
        Namespace constructNamespace;
        XmlNode.Namespace delegate;
        String localName = obj2 instanceof QName ? ((QName) obj2).localName() : ScriptRuntime.toString(obj2);
        if (obj == Undefined.instance) {
            if (!ProxyConfig.MATCH_ALL_SCHEMES.equals(localName)) {
                constructNamespace = getDefaultNamespace(context);
                delegate = constructNamespace.getDelegate();
            }
            delegate = null;
        } else {
            if (obj != null) {
                if (obj instanceof Namespace) {
                    delegate = ((Namespace) obj).getDelegate();
                } else {
                    constructNamespace = this.namespacePrototype.constructNamespace(obj);
                    delegate = constructNamespace.getDelegate();
                }
            }
            delegate = null;
        }
        if (localName != null && localName.equals(ProxyConfig.MATCH_ALL_SCHEMES)) {
            localName = null;
        }
        return XmlNode.QName.create(delegate, localName);
    }

    XMLName toXMLName(Context context, Object obj) {
        String scriptRuntime;
        if (obj instanceof XMLName) {
            return (XMLName) obj;
        }
        if (obj instanceof QName) {
            QName qName = (QName) obj;
            return XMLName.formProperty(qName.uri(), qName.localName());
        }
        if (obj instanceof String) {
            scriptRuntime = (String) obj;
        } else {
            if ((obj instanceof Boolean) || (obj instanceof Number) || obj == Undefined.instance || obj == null) {
                throw badXMLName(obj);
            }
            scriptRuntime = ScriptRuntime.toString(obj);
        }
        return toXMLNameFromString(context, scriptRuntime);
    }

    XMLName toXMLNameFromString(Context context, String str) {
        return XMLName.create(getDefaultNamespaceURI(context), str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x008b, code lost:
    
        return toXMLNameFromString(r11, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0082, code lost:
    
        external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.storeUint32Result(r11, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0080, code lost:
    
        if (r4 >= 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
    
        if (r4 >= 0) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    external.sdk.pendo.io.mozilla.javascript.xmlimpl.XMLName toXMLNameOrIndex(external.sdk.pendo.io.mozilla.javascript.Context r11, java.lang.Object r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof external.sdk.pendo.io.mozilla.javascript.xmlimpl.XMLName
            if (r0 == 0) goto L8
            external.sdk.pendo.io.mozilla.javascript.xmlimpl.XMLName r12 = (external.sdk.pendo.io.mozilla.javascript.xmlimpl.XMLName) r12
            goto L8b
        L8:
            boolean r0 = r12 instanceof java.lang.String
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L1a
            java.lang.String r12 = (java.lang.String) r12
            long r4 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.testUint32String(r12)
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 < 0) goto L87
            goto L82
        L1a:
            boolean r0 = r12 instanceof java.lang.Number
            if (r0 == 0) goto L41
            r0 = r12
            java.lang.Number r0 = (java.lang.Number) r0
            double r4 = r0.doubleValue()
            long r6 = (long) r4
            double r8 = (double) r6
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 != 0) goto L3c
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 > 0) goto L3c
            r2 = 4294967295(0xffffffff, double:2.1219957905E-314)
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 > 0) goto L3c
            external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.storeUint32Result(r11, r6)
            goto L85
        L3c:
            java.lang.RuntimeException r11 = badXMLName(r12)
            throw r11
        L41:
            boolean r0 = r12 instanceof external.sdk.pendo.io.mozilla.javascript.xmlimpl.QName
            if (r0 == 0) goto L6c
            external.sdk.pendo.io.mozilla.javascript.xmlimpl.QName r12 = (external.sdk.pendo.io.mozilla.javascript.xmlimpl.QName) r12
            java.lang.String r0 = r12.uri()
            if (r0 == 0) goto L60
            int r4 = r0.length()
            if (r4 != 0) goto L60
            long r4 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.testUint32String(r0)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 < 0) goto L60
            external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.storeUint32Result(r11, r4)
            r11 = 1
            goto L61
        L60:
            r11 = 0
        L61:
            if (r11 != 0) goto L85
            java.lang.String r11 = r12.localName()
            external.sdk.pendo.io.mozilla.javascript.xmlimpl.XMLName r12 = external.sdk.pendo.io.mozilla.javascript.xmlimpl.XMLName.formProperty(r0, r11)
            goto L8b
        L6c:
            boolean r0 = r12 instanceof java.lang.Boolean
            if (r0 != 0) goto L8c
            java.lang.Object r0 = external.sdk.pendo.io.mozilla.javascript.Undefined.instance
            if (r12 == r0) goto L8c
            if (r12 == 0) goto L8c
            java.lang.String r12 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.toString(r12)
            long r4 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.testUint32String(r12)
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 < 0) goto L87
        L82:
            external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.storeUint32Result(r11, r4)
        L85:
            r12 = r1
            goto L8b
        L87:
            external.sdk.pendo.io.mozilla.javascript.xmlimpl.XMLName r12 = r10.toXMLNameFromString(r11, r12)
        L8b:
            return r12
        L8c:
            java.lang.RuntimeException r11 = badXMLName(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.xmlimpl.XMLLibImpl.toXMLNameOrIndex(external.sdk.pendo.io.mozilla.javascript.Context, java.lang.Object):external.sdk.pendo.io.mozilla.javascript.xmlimpl.XMLName");
    }

    QName constructQName(Context context, Object obj, Object obj2) {
        return this.qnamePrototype.constructQName(this, context, obj, obj2);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.xml.XMLLib
    public Ref nameRef(Context context, Object obj, Object obj2, Scriptable scriptable, int i) {
        XMLName create = XMLName.create(toNodeQName(context, obj, obj2), false, false);
        if ((i & 2) != 0 && !create.isAttributeName()) {
            create.setAttributeName();
        }
        return xmlPrimaryReference(context, create, scriptable);
    }

    QName newQName(String str, String str2, String str3) {
        return this.qnamePrototype.newQName(this, str, str2, str3);
    }

    XmlNode.QName toNodeQName(Context context, Object obj, boolean z) {
        if (obj instanceof XMLName) {
            return ((XMLName) obj).toQname();
        }
        if (obj instanceof QName) {
            return ((QName) obj).getDelegate();
        }
        if ((obj instanceof Boolean) || (obj instanceof Number) || obj == Undefined.instance || obj == null) {
            throw badXMLName(obj);
        }
        return toNodeQName(context, obj instanceof String ? (String) obj : ScriptRuntime.toString(obj), z);
    }

    XmlNode.QName toNodeQName(Context context, String str, boolean z) {
        return (str == null || !str.equals(ProxyConfig.MATCH_ALL_SCHEMES)) ? z ? XmlNode.QName.create(XmlNode.Namespace.GLOBAL, str) : XmlNode.QName.create(getDefaultNamespace(context).getDelegate(), str) : XmlNode.QName.create(null, null);
    }
}
