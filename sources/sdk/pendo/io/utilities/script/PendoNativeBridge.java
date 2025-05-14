package sdk.pendo.io.utilities.script;

import android.app.Activity;
import android.view.KeyEvent;
import com.iterable.iterableapi.IterableConstants;
import external.sdk.pendo.io.gson.JsonParser;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.actions.PendoCommand;
import sdk.pendo.io.actions.PendoCommandAction;
import sdk.pendo.io.actions.PendoCommandDispatcher;
import sdk.pendo.io.actions.PendoCommandEventType;
import sdk.pendo.io.actions.PendoCommandsEventBus;
import sdk.pendo.io.actions.VisualGuideBase;
import sdk.pendo.io.actions.VisualGuidesManager;
import sdk.pendo.io.g9.e0;
import sdk.pendo.io.g9.g;
import sdk.pendo.io.g9.m0;
import sdk.pendo.io.g9.o0;
import sdk.pendo.io.g9.q0;
import sdk.pendo.io.g9.z;
import sdk.pendo.io.k0.i;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.n8.c;
import sdk.pendo.io.s8.a;
import sdk.pendo.io.utilities.script.JavascriptRunner;
import sdk.pendo.io.views.custom.ViewBaseScriptBridge;

/* loaded from: classes3.dex */
public final class PendoNativeBridge {
    private static final String DOES_NOT_EXIST_IN_CONTEXT_VALUE = "";
    private static final String EMPTY_ACCOUNT = "";
    private static final String EMPTY_VISITOR = "";
    private static final String TAG = "PendoNativeBridge";

    public static final class PendoNativeBridgeJSFunctions {
        public static final String JS_STANDIN_CONSTRUCTOR = jsFunctionBuilder("StandIn", "id", "this.elementId = id;this.element = null;this.type = null;");
        public static final String JS_STANDIN_PROTOTYPE_FUNCTION_GET_ELEMENT = jsAnonFunctionBuilder("StandIn.prototype.getElement", "", "if (!this.element) {this.element = Packages.sdk.pendo.io.utilities.script.PendoNativeBridge.findElementById(this.elementId);this.type = this.element.getType();}return this.element;");
        public static final String JS_STANDIN_PROTOTYPE_FUNCTION_GET_TYPE = jsAnonFunctionBuilder("StandIn.prototype.getType", "", "this.getElement();return this.type;");
        public static final String JS_STANDIN_PROTOTYPE_FUNCTION_GET_PAGE_NUMBER = jsAnonFunctionBuilder("StandIn.prototype.getPageNumber", "", "return Number(this.getElement().getPageNumber());");
        public static final String JS_STANDIN_PROTOTYPE_FUNCTION_GET_ANSWERS = jsAnonFunctionBuilder("StandIn.prototype.getAnswers", "", "var answers = this.getElement().getAnswers();return JSON.parse(answers.toString());");
        public static final String JS_FUNCTION_GET_MULTIPLE_CHOICE_POLL_ANSWER = jsFunctionBuilder("getPollResponseById", "elementId", "return String(Packages.sdk.pendo.io.utilities.script.PendoNativeBridge.getPollResponseById(elementId));");
        public static final String JS_FUNCTION_FIND_ELEMENT_BY_ID = jsFunctionBuilder("findElementById", "elementId", "return new StandIn(elementId);");
        public static final String JS_FUNCTION_GET_FROM_CONTEXT = jsFunctionBuilder("getFromContext", "context, parameterName", "return String(Packages.sdk.pendo.io.utilities.script.PendoNativeBridge.getFromContext(context, parameterName));");
        public static final String JS_FUNCTION_GET_GUIDE_STEP_ID = jsFunctionBuilder("getGuideStepId", "context", "return String(Packages.sdk.pendo.io.utilities.script.PendoNativeBridge.getGuideStepId(context));");
        public static final String JS_FUNCTION_GET_STEP_POLL_TYPES = jsFunctionBuilder("getStepPollTypes", "context", "return String(Packages.sdk.pendo.io.utilities.script.PendoNativeBridge.getGuideStepPollTypes(context));");
        public static final String JS_FUNCTION_GET_DURATION_GUIDE_DISMISSED = jsFunctionBuilder("getGuideStepDuration", "context", "return String(Packages.sdk.pendo.io.utilities.script.PendoNativeBridge.getGuideStepDuration(context));");
        public static final String JS_FUNCTION_GET_GUIDE_STEP_ADVANCED_DURATION = jsFunctionBuilder("getGuideStepAdvancedDuration", "context", "return String(Packages.sdk.pendo.io.utilities.script.PendoNativeBridge.getGuideStepAdvancedDuration(context));");
        public static final String JS_FUNCTION_GET_DURATION_SCREEN_LEFT = jsFunctionBuilder("getDurationScreenLeft", "context", "return String(Packages.sdk.pendo.io.utilities.script.PendoNativeBridge.getDurationScreenLeft(context));");
        public static final String JS_FUNCTION_GET_ACTIVE_TIME_FROM_LAST_FOREGROUND = jsFunctionBuilder("getActiveTimeFromLastForeground", "", "return String(Packages.sdk.pendo.io.utilities.script.PendoNativeBridge.getActiveTimeFromLastForeground());");
        public static final String JS_FUNCTION_GET_DURATION_APP_IN_BACKGROUND = jsFunctionBuilder("getDurationAppInBackground", "", "return String(Packages.sdk.pendo.io.utilities.script.PendoNativeBridge.getDurationAppInBackground());");
        public static final String JS_FUNCTION_GET_ACTIVE_TIME_FOR_APP_SESSION_END = jsFunctionBuilder("getActiveTimeForAppSessionEnd", "", "return String(Packages.sdk.pendo.io.utilities.script.PendoNativeBridge.getActiveTimeForAppSessionEnd());");
        public static final String JS_FUNCTION_GET_DURATION_SESSION_END = jsFunctionBuilder("getDurationSessionEnd", "", "return String(Packages.sdk.pendo.io.utilities.script.PendoNativeBridge.getDurationSessionEnd());");
        public static final String JS_FUNCTION_GET_ACTIVE_TIME_SCREEN_LEFT = jsFunctionBuilder("getActiveTimeScreenLeft", "context", "return String(Packages.sdk.pendo.io.utilities.script.PendoNativeBridge.getActiveTimeScreenLeft(context));");
        public static final String JS_FUNCTION_VALIDATE_FORM = jsAnonFunctionBuilder("StandIn.prototype.isValid", "", "return this.getElement().isValid();");
        public static final String JS_FUNCTION_FIND_DISPATCH_ACTIONS = jsFunctionBuilder("dispatchActions", "action, context", "var stringAction = JSON.stringify(action);Packages.sdk.pendo.io.utilities.script.PendoNativeBridge.dispatchActions(stringAction, context);");
        public static final String JS_FUNCTION_FIND_DISPATCH_TRIGGER_ACTIONS = jsFunctionBuilder("dispatchTriggerActions", "action, context", "var stringAction = JSON.stringify(action);Packages.sdk.pendo.io.utilities.script.PendoNativeBridge.dispatchActions(stringAction, context);");
        public static final String JS_FUNCTION_LOG_I = jsFunctionBuilder("logI", "msg", "Packages.sdk.pendo.io.logging.PendoLogger.i(msg);");
        public static final String JS_FUNCTION_LOG_D = jsFunctionBuilder("logD", "msg", "Packages.sdk.pendo.io.logging.PendoLogger.d(msg);");
        public static final String JS_FUNCTION_GET_ORIENTATION = jsFunctionBuilder("getOrientation", null, "return String(Packages.sdk.pendo.io.utilities.script.PendoNativeBridge.getOrientation());");
        public static final String JS_FUNCTION_LOG_E = jsFunctionBuilder("logE", "msg", "Packages.sdk.pendo.io.logging.PendoLogger.e(msg);");

        private PendoNativeBridgeJSFunctions() {
        }

        private static String jsAnonFunctionBuilder(String str, String str2, String str3) {
            return str + " = function(" + m0.h(str2) + ") {" + m0.h(str3) + "}";
        }

        private static String jsFunctionBuilder(String str, String str2, String str3) {
            return "function " + str + "(" + m0.h(str2) + ") {" + m0.h(str3) + "}";
        }
    }

    private PendoNativeBridge() {
    }

    private static void addVisitorAccountInfo(List<PendoCommand> list) {
        String D = PendoInternal.D();
        String k = PendoInternal.k();
        for (PendoCommand pendoCommand : list) {
            if (PendoCommandEventType.AppEventType.APP_SESSION_END.eventType.equals(pendoCommand.getEventType().eventType)) {
                D = PendoInternal.v();
                if (D == null) {
                    D = "";
                }
                k = PendoInternal.s();
                if (k == null) {
                    k = "";
                }
            }
            pendoCommand.addParameter(k != null ? new PendoCommandsEventBus.Parameter("accountId", "string", k) : new PendoCommandsEventBus.Parameter("accountId", "string", ""));
            if (D != null) {
                pendoCommand.addParameter(new PendoCommandsEventBus.Parameter("visitorId", "string", D));
            } else {
                pendoCommand.addParameter(new PendoCommandsEventBus.Parameter("visitorId", "string", ""));
            }
        }
    }

    private static Long computeIntervalsDurationFromJSONArray(JSONArray jSONArray) {
        JSONObject jSONObject;
        long j;
        if (jSONArray == null) {
            return 0L;
        }
        long j2 = 0;
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                jSONObject = jSONArray.getJSONObject(i);
            } catch (JSONException e) {
                PendoLogger.e(e, e.getMessage(), new Object[0]);
                jSONObject = null;
            }
            if (jSONObject != null && jSONObject.has("duration")) {
                try {
                    j = jSONObject.getLong("duration");
                } catch (JSONException e2) {
                    PendoLogger.e(e2, e2.getMessage(), new Object[0]);
                    j = 0;
                }
                j2 += j;
            }
        }
        return Long.valueOf(j2);
    }

    public static void dispatchActions(final String str, final JavascriptRunner.GuideContext guideContext) {
        e0.a(new a() { // from class: sdk.pendo.io.utilities.script.PendoNativeBridge.1
            @Override // sdk.pendo.io.s8.a
            protected void execute() {
                PendoNativeBridge.parseAndDispatchCommands(str, guideContext);
            }
        });
    }

    public static ViewBaseScriptBridge findElementById(String str) {
        q0.b a2;
        Activity f = c.g().f();
        if (f == null || (a2 = o0.f1142a.a(f)) == null || a2.f1145a.get() == null) {
            return null;
        }
        KeyEvent.Callback a3 = sdk.pendo.io.m8.a.a(a2.f1145a.get(), str);
        if (a3 instanceof ViewBaseScriptBridge) {
            return ((ViewBaseScriptBridge) a3).getViewScriptBridge();
        }
        return null;
    }

    public static ViewBaseScriptBridge findElementByTag(Object obj) {
        q0.b a2;
        try {
            Activity f = c.g().f();
            if (f == null || (a2 = o0.f1142a.a(f)) == null || a2.f1145a.get() == null) {
                return null;
            }
            KeyEvent.Callback a3 = sdk.pendo.io.m8.a.a(a2.f1145a.get(), obj);
            if (a3 instanceof ViewBaseScriptBridge) {
                return ((ViewBaseScriptBridge) a3).getViewScriptBridge();
            }
            return null;
        } catch (Exception unused) {
            PendoLogger.e("Failed to find element by tag " + obj, new Object[0]);
            return null;
        }
    }

    public static String getDurationAppInBackground() {
        JSONObject jSONObject;
        long j;
        String e = z.e();
        if (e == null) {
            return Integer.toString(0);
        }
        try {
            jSONObject = new JSONObject(e);
        } catch (JSONException e2) {
            PendoLogger.e(e2, e2.getMessage(), new Object[0]);
            jSONObject = null;
        }
        if (jSONObject != null && jSONObject.has("duration")) {
            try {
                j = jSONObject.getLong("duration");
            } catch (JSONException e3) {
                PendoLogger.e(e3, e3.getMessage(), new Object[0]);
            }
            return Long.toString(j);
        }
        j = 0;
        return Long.toString(j);
    }

    public static String getFromContext(JavascriptRunner.GuideContext guideContext, String str) {
        String str2 = guideContext != null ? (String) guideContext.get(str, String.class) : null;
        return str2 == null ? "" : str2;
    }

    public static String getGuideStepAdvancedDuration(JavascriptRunner.GuideContext guideContext) {
        VisualGuideBase visualGuide;
        String str = (String) guideContext.get("stepDisplayDuration", String.class);
        return (str != null || guideContext.getGuideId() == null || (visualGuide = VisualGuidesManager.getInstance().getVisualGuide(guideContext.getGuideId())) == null) ? str : String.valueOf(visualGuide.getDuration());
    }

    public static String getGuideStepDuration(JavascriptRunner.GuideContext guideContext) {
        VisualGuideBase visualGuide;
        String str = (String) guideContext.get(IterableConstants.ITERABLE_INBOX_IMP_DISPLAY_DURATION, String.class);
        if (str == null && guideContext.getGuideId() != null && (visualGuide = VisualGuidesManager.getInstance().getVisualGuide(guideContext.getGuideId())) != null) {
            str = String.valueOf(visualGuide.getDuration());
        }
        return str != null ? str : String.valueOf(0);
    }

    public static String getGuideStepId(JavascriptRunner.GuideContext guideContext) {
        String str = guideContext != null ? (String) guideContext.get(VisualGuideBase.GUIDE_STEP_ID_PARAMETER_NAME, String.class) : null;
        return str == null ? "" : str;
    }

    public static String getGuideStepPollTypes(JavascriptRunner.GuideContext guideContext) {
        return getFromContext(guideContext, "pollTypes");
    }

    public static String getOrientation() {
        return g.g();
    }

    public static String getPollResponseById(String str) {
        ViewBaseScriptBridge findElementByTag = findElementByTag(str);
        return findElementByTag instanceof ViewBaseScriptBridge.RadioGroupScriptBridge ? ((ViewBaseScriptBridge.RadioGroupScriptBridge) findElementByTag).getSelectedResponseId() : findElementByTag instanceof ViewBaseScriptBridge.TextFieldScriptBridge ? ((ViewBaseScriptBridge.TextFieldScriptBridge) findElementByTag).getTextFieldResponse() : "";
    }

    public static void parseAndDispatchCommands(String str, JavascriptRunner.GuideContext guideContext) {
        PendoCommandDispatcher pendoCommandDispatcher;
        PendoCommandEventType pendoCommandEventType;
        try {
            i a2 = JsonParser.a(str);
            List<PendoCommand> pendoCommands = a2.h() ? PendoCommand.getPendoCommands(a2.d()) : PendoCommand.commandFactory(a2.e());
            if (guideContext != null) {
                for (PendoCommand pendoCommand : pendoCommands) {
                    String guideId = guideContext.getGuideId();
                    if (guideId != null) {
                        pendoCommand.addParameter(PendoCommandAction.PendoCommandGlobalAction.PendoInfoConsts.createPendoMetadataParam(guideId));
                    }
                }
                pendoCommandDispatcher = PendoCommandDispatcher.getInstance();
                pendoCommandEventType = guideContext.getEventType();
            } else {
                pendoCommandDispatcher = PendoCommandDispatcher.getInstance();
                pendoCommandEventType = PendoCommandEventType.PENDO_COMMAND_EVENT_TYPE_ANY;
            }
            pendoCommandDispatcher.dispatchCommands(pendoCommands, pendoCommandEventType, true);
        } catch (Exception e) {
            PendoLogger.e(e, e.getMessage(), "PendoNativeBridge commands: " + str);
        }
    }
}
