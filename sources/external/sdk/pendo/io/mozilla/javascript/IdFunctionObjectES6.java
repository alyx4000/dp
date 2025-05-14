package external.sdk.pendo.io.mozilla.javascript;

import io.sentry.SentryEnvelopeItemHeader;

/* loaded from: classes2.dex */
public class IdFunctionObjectES6 extends IdFunctionObject {
    private static final int Id_length = 1;
    private static final int Id_name = 3;
    private static final long serialVersionUID = -8023088662589035261L;
    private boolean myLength;
    private boolean myName;

    public IdFunctionObjectES6(IdFunctionCall idFunctionCall, Object obj, int i, String str, int i2, Scriptable scriptable) {
        super(idFunctionCall, obj, i, str, i2, scriptable);
        this.myLength = true;
        this.myName = true;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.BaseFunction, external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findInstanceIdInfo(String str) {
        return str.equals(SentryEnvelopeItemHeader.JsonKeys.LENGTH) ? IdScriptableObject.instanceIdInfo(3, 1) : str.equals("name") ? IdScriptableObject.instanceIdInfo(3, 3) : super.findInstanceIdInfo(str);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.BaseFunction, external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected Object getInstanceIdValue(int i) {
        return (i != 1 || this.myLength) ? (i != 3 || this.myName) ? super.getInstanceIdValue(i) : Scriptable.NOT_FOUND : Scriptable.NOT_FOUND;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.BaseFunction, external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void setInstanceIdValue(int i, Object obj) {
        if (i == 1 && obj == Scriptable.NOT_FOUND) {
            this.myLength = false;
        } else if (i == 3 && obj == Scriptable.NOT_FOUND) {
            this.myName = false;
        } else {
            super.setInstanceIdValue(i, obj);
        }
    }
}
