package sdk.pendo.io.utilities.script;

import com.iterable.iterableapi.IterableConstants;
import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.ContextFactory;
import external.sdk.pendo.io.mozilla.javascript.Function;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import external.sdk.pendo.io.mozilla.javascript.ScriptableObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.actions.GuidesManager;
import sdk.pendo.io.actions.PendoCommand;
import sdk.pendo.io.actions.PendoCommandEventType;
import sdk.pendo.io.actions.StepSeenManager;
import sdk.pendo.io.actions.VisualGuideBase;
import sdk.pendo.io.actions.VisualGuidesManager;
import sdk.pendo.io.g9.g0;
import sdk.pendo.io.g9.i0;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.GuideModel;
import sdk.pendo.io.models.StepContentModel;
import sdk.pendo.io.utilities.script.JavascriptSandboxContextFactory;
import sdk.pendo.io.utilities.script.PendoNativeBridge;

/* loaded from: classes3.dex */
public final class JavascriptRunner {
    public static final String JAVA_SCRIPT_RUNNER_DESTINATION = "JavaScriptRunner";
    public static final String JAVA_SCRIPT_TYPE = "javascript";
    private static final String MAIN_FUNCTION_NAME = "guideRun";
    public static final String SCRIPT_NAME = "script";
    private static String sDeviceLocal = g0.a();

    public static final class GuideContext {
        public static final String EVENT_TYPE = "eventType";
        public static final String GUIDE_ID = "guideId";
        public static final String LOCALE = "locale";
        public static final String SDK_VERSION = "sdkVersion";
        private final Map<String, Object> mContextMap;

        public GuideContext() {
            HashMap hashMap = new HashMap();
            this.mContextMap = hashMap;
            if (JavascriptRunner.sDeviceLocal.equals("")) {
                JavascriptRunner.sDeviceLocal = g0.a();
            }
            hashMap.put("locale", JavascriptRunner.sDeviceLocal);
            hashMap.put("sdkVersion", i0.a());
            hashMap.put("eventType", PendoCommandEventType.PENDO_COMMAND_EVENT_TYPE_ANY);
        }

        public static void addBasicParamsToGuideCommands(List<PendoCommand> list) {
            StepContentModel stepContentModel;
            try {
                for (PendoCommand pendoCommand : list) {
                    GuideContext context = pendoCommand.getContext();
                    if (context == null || context.getGuideId() == null) {
                        pendoCommand.setContext(new GuideContext());
                    } else {
                        String guideId = context.getGuideId();
                        GuideModel guide = GuidesManager.INSTANCE.getGuide(guideId);
                        VisualGuideBase visualGuide = VisualGuidesManager.getInstance().getVisualGuide(guideId);
                        if (guide != null && (stepContentModel = guide.getStepContentModel(StepSeenManager.getInstance().getCurrentStepIndex().intValue())) != null && stepContentModel.getGuideStepId() != null) {
                            context.set(VisualGuideBase.GUIDE_STEP_ID_PARAMETER_NAME, stepContentModel.getGuideStepId());
                        }
                        if (visualGuide != null) {
                            context.set("seenReason", visualGuide.getActivatedBy());
                            context.set(IterableConstants.ITERABLE_INBOX_IMP_DISPLAY_DURATION, Long.toString(visualGuide.getDuration()));
                        }
                        if (context.get("guideId", String.class) == null) {
                            context.set("guideId", guideId);
                        }
                        if (context.get("visitorId", String.class) == null) {
                            context.set("visitorId", PendoInternal.D());
                        }
                        if (context.get("accountId", String.class) == null) {
                            context.set("accountId", PendoInternal.k());
                        }
                    }
                }
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder("command ids: ");
                if (list != null && list.size() > 0) {
                    for (PendoCommand pendoCommand2 : list) {
                        sb.append(pendoCommand2.getCommandId()).append(pendoCommand2.getAction().action).append("\n");
                    }
                }
                PendoLogger.e(e, e.getMessage(), sb.toString());
            }
        }

        public <T> T get(String str, Class<T> cls) {
            if (this.mContextMap.containsKey(str)) {
                return cls.cast(this.mContextMap.get(str));
            }
            return null;
        }

        public int getContextMapSize() {
            return this.mContextMap.size();
        }

        public PendoCommandEventType getEventType() {
            return (PendoCommandEventType) get("eventType", PendoCommandEventType.class);
        }

        public String getGuideId() {
            return (String) get("guideId", String.class);
        }

        public void set(String str, Object obj) {
            this.mContextMap.put(str, obj);
        }

        public GuideContext(String str) {
            this();
            this.mContextMap.put("guideId", str);
        }
    }

    static {
        ContextFactory.initGlobal(new JavascriptSandboxContextFactory(JavascriptSandboxImpl.getInstance()));
    }

    private JavascriptRunner() {
    }

    private static void addAllBaseJSFunctions(JavascriptSandboxContextFactory.PendoIoJSContext pendoIoJSContext, Scriptable scriptable) {
        pendoIoJSContext.evaluateString(scriptable, PendoNativeBridge.PendoNativeBridgeJSFunctions.JS_STANDIN_CONSTRUCTOR, "JS_STANDIN_CONSTRUCTOR", 1, null);
        pendoIoJSContext.evaluateString(scriptable, PendoNativeBridge.PendoNativeBridgeJSFunctions.JS_STANDIN_PROTOTYPE_FUNCTION_GET_ELEMENT, "JS_STANDIN_PROTOTYPE_FUNCTION_GET_ELEMENT", 1, null);
        pendoIoJSContext.evaluateString(scriptable, PendoNativeBridge.PendoNativeBridgeJSFunctions.JS_STANDIN_PROTOTYPE_FUNCTION_GET_TYPE, "JS_STANDIN_PROTOTYPE_FUNCTION_GET_TYPE", 1, null);
        pendoIoJSContext.evaluateString(scriptable, PendoNativeBridge.PendoNativeBridgeJSFunctions.JS_STANDIN_PROTOTYPE_FUNCTION_GET_PAGE_NUMBER, "JS_STANDIN_PROTOTYPE_FUNCTION_GET_PAGE_NUMBER", 1, null);
        pendoIoJSContext.evaluateString(scriptable, PendoNativeBridge.PendoNativeBridgeJSFunctions.JS_STANDIN_PROTOTYPE_FUNCTION_GET_ANSWERS, "JS_STANDIN_PROTOTYPE_FUNCTION_GET_ANSWERS", 1, null);
        pendoIoJSContext.evaluateString(scriptable, PendoNativeBridge.PendoNativeBridgeJSFunctions.JS_FUNCTION_GET_MULTIPLE_CHOICE_POLL_ANSWER, "JS_FUNCTION_GET_MULTIPLE_CHOICE_POLL_ANSWER", 1, null);
        pendoIoJSContext.evaluateString(scriptable, PendoNativeBridge.PendoNativeBridgeJSFunctions.JS_FUNCTION_FIND_ELEMENT_BY_ID, "JS_FUNCTION_FIND_ELEMENT_BY_ID", 1, null);
        pendoIoJSContext.evaluateString(scriptable, PendoNativeBridge.PendoNativeBridgeJSFunctions.JS_FUNCTION_FIND_DISPATCH_ACTIONS, "JS_FUNCTION_FIND_DISPATCH_ACTIONS", 1, null);
        pendoIoJSContext.evaluateString(scriptable, PendoNativeBridge.PendoNativeBridgeJSFunctions.JS_FUNCTION_FIND_DISPATCH_TRIGGER_ACTIONS, "JS_FUNCTION_FIND_DISPATCH_TRIGGER_ACTIONS", 1, null);
        pendoIoJSContext.evaluateString(scriptable, PendoNativeBridge.PendoNativeBridgeJSFunctions.JS_FUNCTION_GET_FROM_CONTEXT, "JS_FUNCTION_GET_FROM_CONTEXT", 1, null);
        pendoIoJSContext.evaluateString(scriptable, PendoNativeBridge.PendoNativeBridgeJSFunctions.JS_FUNCTION_GET_STEP_POLL_TYPES, "JS_FUNCTION_GET_STEP_POLL_TYPES", 1, null);
        pendoIoJSContext.evaluateString(scriptable, PendoNativeBridge.PendoNativeBridgeJSFunctions.JS_FUNCTION_GET_GUIDE_STEP_ID, "JS_FUNCTION_GET_GUIDE_STEP_ID", 1, null);
        pendoIoJSContext.evaluateString(scriptable, PendoNativeBridge.PendoNativeBridgeJSFunctions.JS_FUNCTION_GET_DURATION_GUIDE_DISMISSED, "JS_FUNCTION_GET_DURATION_GUIDE_DISMISSED", 1, null);
        pendoIoJSContext.evaluateString(scriptable, PendoNativeBridge.PendoNativeBridgeJSFunctions.JS_FUNCTION_GET_DURATION_SCREEN_LEFT, "JS_FUNCTION_GET_DURATION_SCREEN_LEFT", 1, null);
        pendoIoJSContext.evaluateString(scriptable, PendoNativeBridge.PendoNativeBridgeJSFunctions.JS_FUNCTION_GET_ACTIVE_TIME_FROM_LAST_FOREGROUND, "JS_FUNCTION_GET_ACTIVE_TIME_FROM_LAST_FOREGROUND", 1, null);
        pendoIoJSContext.evaluateString(scriptable, PendoNativeBridge.PendoNativeBridgeJSFunctions.JS_FUNCTION_GET_DURATION_APP_IN_BACKGROUND, "JS_FUNCTION_GET_DURATION_APP_IN_BACKGROUND", 1, null);
        pendoIoJSContext.evaluateString(scriptable, PendoNativeBridge.PendoNativeBridgeJSFunctions.JS_FUNCTION_GET_ACTIVE_TIME_FOR_APP_SESSION_END, "JS_FUNCTION_GET_ACTIVE_TIME_FOR_APP_SESSION_END", 1, null);
        pendoIoJSContext.evaluateString(scriptable, PendoNativeBridge.PendoNativeBridgeJSFunctions.JS_FUNCTION_GET_DURATION_SESSION_END, "JS_FUNCTION_GET_DURATION_SESSION_END", 1, null);
        pendoIoJSContext.evaluateString(scriptable, PendoNativeBridge.PendoNativeBridgeJSFunctions.JS_FUNCTION_GET_ACTIVE_TIME_SCREEN_LEFT, "JS_FUNCTION_GET_ACTIVE_TIME_SCREEN_LEFT", 1, null);
        pendoIoJSContext.evaluateString(scriptable, PendoNativeBridge.PendoNativeBridgeJSFunctions.JS_FUNCTION_VALIDATE_FORM, "JS_FUNCTION_VALIDATE_FORM", 1, null);
        pendoIoJSContext.evaluateString(scriptable, PendoNativeBridge.PendoNativeBridgeJSFunctions.JS_FUNCTION_GET_ORIENTATION, "JS_FUNCTION_GET_ORIENTATION", 1, null);
        pendoIoJSContext.evaluateString(scriptable, PendoNativeBridge.PendoNativeBridgeJSFunctions.JS_FUNCTION_LOG_I, "JS_FUNCTION_LOG_I", 1, null);
        pendoIoJSContext.evaluateString(scriptable, PendoNativeBridge.PendoNativeBridgeJSFunctions.JS_FUNCTION_LOG_D, "JS_FUNCTION_LOG_D", 1, null);
        pendoIoJSContext.evaluateString(scriptable, PendoNativeBridge.PendoNativeBridgeJSFunctions.JS_FUNCTION_LOG_E, "JS_FUNCTION_LOG_E", 1, null);
    }

    public static void log(String str) {
        PendoLogger.i("RHINO_LOG", str);
    }

    public static Object runCode(String str, Class<?> cls) {
        return runCode(str, cls, null);
    }

    public static Object runCode(String str, Class<?> cls, GuideContext guideContext) {
        try {
            try {
                JavascriptSandboxContextFactory.PendoIoJSContext pendoIoJSContext = (JavascriptSandboxContextFactory.PendoIoJSContext) ContextFactory.getGlobal().enterContext();
                pendoIoJSContext.setOptimizationLevel(-1);
                ScriptableObject initStandardObjects = pendoIoJSContext.initStandardObjects();
                Object[] objArr = {guideContext};
                ScriptableObject.putProperty(initStandardObjects, "javaContext", Context.javaToJS(PendoInternal.m(), initStandardObjects));
                ScriptableObject.putProperty(initStandardObjects, "javaLoader", Context.javaToJS(PendoInternal.class.getClassLoader(), initStandardObjects));
                addAllBaseJSFunctions(pendoIoJSContext, initStandardObjects);
                pendoIoJSContext.evaluateString(initStandardObjects, str, "MAIN_SERVER_SCRIPT", 1, null);
                Object obj = initStandardObjects.get(MAIN_FUNCTION_NAME, initStandardObjects);
                if (obj instanceof Function) {
                    Object cast = cls.cast(Context.jsToJava(((Function) obj).call(pendoIoJSContext, initStandardObjects, initStandardObjects, objArr), Object.class));
                    try {
                        Context.exit();
                    } catch (Exception e) {
                        PendoLogger.e(e.getMessage(), new Object[0]);
                    }
                    return cast;
                }
                try {
                    Context.exit();
                    return null;
                } catch (Exception e2) {
                    PendoLogger.e(e2.getMessage(), new Object[0]);
                    return null;
                }
            } catch (Exception e3) {
                PendoLogger.e(e3, e3.getMessage(), "jsCode: " + str);
                try {
                    Context.exit();
                    return null;
                } catch (Exception e4) {
                    PendoLogger.e(e4.getMessage(), new Object[0]);
                    return null;
                }
            } catch (ExceptionInInitializerError e5) {
                PendoLogger.e(e5.getMessage(), "Cause: " + e5.getCause().getMessage());
                try {
                    Context.exit();
                    return null;
                } catch (Exception e6) {
                    PendoLogger.e(e6.getMessage(), new Object[0]);
                    return null;
                }
            }
        } catch (Throwable th) {
            try {
                Context.exit();
            } catch (Exception e7) {
                PendoLogger.e(e7.getMessage(), new Object[0]);
            }
            throw th;
        }
    }
}
