package sdk.pendo.io.views.custom;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.widget.EditText;
import android.widget.RadioGroup;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.actions.PendoCommand;
import sdk.pendo.io.actions.PendoCommandAction;
import sdk.pendo.io.actions.PendoCommandDispatcher;
import sdk.pendo.io.actions.PendoCommandEventType;
import sdk.pendo.io.actions.PendoCommandsEventBus;
import sdk.pendo.io.b6.b;
import sdk.pendo.io.c7.a;
import sdk.pendo.io.c8.d;
import sdk.pendo.io.d6.e;
import sdk.pendo.io.d9.c;
import sdk.pendo.io.f7.g;
import sdk.pendo.io.g9.d;
import sdk.pendo.io.g9.p;
import sdk.pendo.io.k0.f;
import sdk.pendo.io.k0.l;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.utilities.script.JavascriptRunner;
import sdk.pendo.io.views.custom.ViewBaseScriptBridge;

/* loaded from: classes4.dex */
public final class PendoForm extends PendoLinearLayout implements ViewBaseScriptBridge.FormScriptBridge {
    public static final String ADDITIONAL_INFO_BUTTON_GROUP_ID = "buttonGroupId";
    public static final String ADDITIONAL_INFO_KEY_VALUES_INPUT = "keyValuesInput";
    public static final String ADDITIONAL_INFO_RADIO_BUTTON_INPUT = "radioButtonInput";
    public static final String ADDITIONAL_INFO_SELECTED_BUTTON_ID = "selectedButtonId";
    public static final String ADDITIONAL_INFO_TEXT_FIELD_ID = "textFieldId";
    public static final String ADDITIONAL_INFO_TEXT_FIELD_INPUT = "textFieldInput";
    public static final String ADDITIONAL_INFO_TEXT_FIELD_VALUE = "value";
    private List<PendoCommand> mCommands;
    private e<PendoCommand> mFormUpdatedObserver;
    private b mFormUpdatedSubscription;
    private Set<String> mMandatory;
    private e<PendoCommand> mSubmitObserver;
    private b mSubmitterSubscription;
    private HashMap<String, Pair<Class, String>> mUserInput;

    public PendoForm(Context context) {
        this(context, null);
    }

    private JSONObject getFormAdditionalInfo() {
        String key;
        Class cls;
        String str;
        JSONArray jSONArray;
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray2 = new JSONArray();
        JSONArray jSONArray3 = new JSONArray();
        JSONArray jSONArray4 = new JSONArray();
        for (Map.Entry<String, Pair<Class, String>> entry : this.mUserInput.entrySet()) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                key = entry.getKey();
                Pair<Class, String> value = entry.getValue();
                cls = (Class) value.first;
                str = (String) value.second;
            } catch (Exception e) {
                PendoLogger.w(e, e.getMessage(), new Object[0]);
            }
            if (RadioGroup.class.equals(cls)) {
                jSONObject2.put(ADDITIONAL_INFO_BUTTON_GROUP_ID, key);
                jSONObject2.put(ADDITIONAL_INFO_SELECTED_BUTTON_ID, str);
                jSONArray = jSONArray2;
            } else if (EditText.class.equals(cls)) {
                jSONObject2.put(ADDITIONAL_INFO_TEXT_FIELD_ID, key);
                jSONObject2.put("value", str);
                jSONArray = jSONArray3;
            } else if (Map.class.equals(cls)) {
                jSONObject2.put(key, str);
                jSONArray = jSONArray4;
            }
            jSONArray.put(jSONObject2);
        }
        try {
            if (jSONArray2.length() > 0) {
                jSONObject.put(ADDITIONAL_INFO_RADIO_BUTTON_INPUT, jSONArray2);
            }
            if (jSONArray3.length() > 0) {
                jSONObject.put(ADDITIONAL_INFO_TEXT_FIELD_INPUT, jSONArray3);
            }
            if (jSONArray4.length() > 0) {
                jSONObject.put(ADDITIONAL_INFO_KEY_VALUES_INPUT, jSONArray4);
            }
            CharSequence contentDescription = getContentDescription();
            if (TextUtils.isEmpty(contentDescription)) {
                d.a(d.b.ERROR_REASON_CONFIGURATION, "No content description for element id.", new Object[0]);
            } else {
                jSONObject.put("elementId", contentDescription);
            }
        } catch (JSONException e2) {
            PendoLogger.e(e2, e2.getMessage(), new Object[0]);
        }
        return jSONObject;
    }

    private void processFormQuestions(l lVar) {
        String c = p.c(lVar, "widget");
        f b = p.b(lVar, "properties");
        if (c == null || b == null) {
            return;
        }
        JSONArray jSONArray = null;
        for (int i = 0; i < b.size(); i++) {
            l a2 = p.a(b, i);
            if (a2 != null && "mandatory_fields".equals(p.c(a2, "name"))) {
                try {
                    jSONArray = new JSONArray(p.c(a2, "value"));
                } catch (JSONException e) {
                    PendoLogger.d(e.getMessage(), new Object[0]);
                }
            }
            if (jSONArray != null) {
                break;
            }
        }
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    this.mMandatory.add(jSONArray.getString(i2));
                } catch (JSONException e2) {
                    PendoLogger.w(e2, e2.getMessage(), new Object[0]);
                }
            }
        }
    }

    private void subscribeFormUpdated(String str) {
        unsubscribeFormUpdated();
        LinkedList linkedList = new LinkedList();
        linkedList.add(PendoCommandAction.PendoCommandFormAction.UPDATE);
        linkedList.add(PendoCommandAction.PendoCommandFormAction.SET_VALUE_FOR_KEY);
        this.mFormUpdatedSubscription = PendoCommandsEventBus.getInstance().subscribe(g.a(this), PendoCommand.createFilter("any", str, linkedList, PendoCommandEventType.PENDO_COMMAND_EVENT_TYPE_ANY), this.mFormUpdatedObserver);
    }

    private void subscribeOnSubmit(String str) {
        unsubscribeSubmitter();
        this.mSubmitterSubscription = PendoCommandsEventBus.getInstance().subscribe(g.a(this), PendoCommand.createFilter("any", str, PendoCommandAction.PendoCommandFormAction.SUBMIT, PendoCommandEventType.PENDO_COMMAND_EVENT_TYPE_ANY, PendoCommand.PendoCommandScope.PENDO_COMMAND_SCOPE_ANY), this.mSubmitObserver);
    }

    private void unsubscribeFormUpdated() {
        b bVar = this.mFormUpdatedSubscription;
        if (bVar == null || bVar.a()) {
            return;
        }
        this.mFormUpdatedSubscription.dispose();
    }

    private void unsubscribeSubmitter() {
        b bVar = this.mSubmitterSubscription;
        if (bVar == null || bVar.a()) {
            return;
        }
        this.mSubmitterSubscription.dispose();
    }

    @Override // sdk.pendo.io.views.custom.ViewBaseScriptBridge.FormScriptBridge
    public JSONObject getAnswers() {
        return getFormAdditionalInfo();
    }

    @Override // sdk.pendo.io.views.custom.ViewBaseScriptBridge
    public String getType() {
        return ViewBaseScriptBridge.ViewBaseScriptBridgeUtils.getType(this);
    }

    @Override // sdk.pendo.io.views.custom.ViewBaseScriptBridge
    public ViewBaseScriptBridge getViewScriptBridge() {
        return this;
    }

    public boolean isValid() {
        if (this.mCommands == null) {
            return false;
        }
        if (this.mMandatory.isEmpty() || this.mUserInput.keySet().containsAll(this.mMandatory)) {
            PendoCommandDispatcher.getInstance().dispatchCommands(this.mCommands, PendoCommandEventType.FormEventType.ON_VALID, true);
            return true;
        }
        PendoCommandDispatcher.getInstance().dispatchCommands(this.mCommands, PendoCommandEventType.FormEventType.ON_INVALID, true);
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        CharSequence contentDescription = getContentDescription();
        if (contentDescription != null) {
            subscribeOnSubmit(contentDescription.toString());
            subscribeFormUpdated(contentDescription.toString());
            a.b(this).a(g.a(this)).a(c.a(new e<Object>() { // from class: sdk.pendo.io.views.custom.PendoForm.3
                @Override // sdk.pendo.io.d6.e
                public void accept(Object obj) {
                    PendoForm.this.isValid();
                }
            }, "PendoForm viewbind observer"));
        }
        super.onAttachedToWindow();
    }

    public void processForm(l lVar, List<PendoCommand> list, String str) {
        this.mCommands = list;
        processFormQuestions(lVar);
    }

    public void setSubmitButton(VisualActionButton visualActionButton) {
    }

    public PendoForm(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public PendoForm(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMandatory = new HashSet();
        this.mUserInput = new HashMap<>();
        this.mSubmitObserver = new e<PendoCommand>() { // from class: sdk.pendo.io.views.custom.PendoForm.1
            @Override // sdk.pendo.io.d6.e
            public void accept(PendoCommand pendoCommand) {
                PendoLogger.d(pendoCommand.toString(), new Object[0]);
                if (PendoForm.this.isValid()) {
                    JavascriptRunner.GuideContext.addBasicParamsToGuideCommands(PendoForm.this.mCommands);
                    PendoCommandDispatcher.getInstance().dispatchCommands(PendoForm.this.mCommands, PendoCommandEventType.FormEventType.ON_SUBMIT, true);
                }
            }
        };
        this.mFormUpdatedObserver = new e<PendoCommand>() { // from class: sdk.pendo.io.views.custom.PendoForm.2
            /* JADX WARN: Removed duplicated region for block: B:43:0x0148 A[Catch: Exception -> 0x0199, TryCatch #1 {Exception -> 0x0199, blocks: (B:3:0x0007, B:5:0x0018, B:8:0x0020, B:11:0x0032, B:14:0x003a, B:18:0x0065, B:20:0x0070, B:22:0x0076, B:24:0x007e, B:26:0x0097, B:28:0x00ab, B:30:0x00b2, B:32:0x00d4, B:41:0x0142, B:43:0x0148, B:44:0x0193, B:46:0x0156, B:49:0x0180, B:50:0x0178, B:66:0x0111, B:35:0x011d, B:37:0x0121, B:39:0x012e, B:51:0x0138), top: B:2:0x0007, inners: #2 }] */
            /* JADX WARN: Removed duplicated region for block: B:46:0x0156 A[Catch: Exception -> 0x0199, TryCatch #1 {Exception -> 0x0199, blocks: (B:3:0x0007, B:5:0x0018, B:8:0x0020, B:11:0x0032, B:14:0x003a, B:18:0x0065, B:20:0x0070, B:22:0x0076, B:24:0x007e, B:26:0x0097, B:28:0x00ab, B:30:0x00b2, B:32:0x00d4, B:41:0x0142, B:43:0x0148, B:44:0x0193, B:46:0x0156, B:49:0x0180, B:50:0x0178, B:66:0x0111, B:35:0x011d, B:37:0x0121, B:39:0x012e, B:51:0x0138), top: B:2:0x0007, inners: #2 }] */
            /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
            @Override // sdk.pendo.io.d6.e
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void accept(sdk.pendo.io.actions.PendoCommand r10) {
                /*
                    Method dump skipped, instructions count: 420
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.views.custom.PendoForm.AnonymousClass2.accept(sdk.pendo.io.actions.PendoCommand):void");
            }
        };
    }
}
