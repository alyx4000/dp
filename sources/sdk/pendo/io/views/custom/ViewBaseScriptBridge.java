package sdk.pendo.io.views.custom;

import org.json.JSONObject;

/* loaded from: classes4.dex */
public interface ViewBaseScriptBridge {

    public interface FormScriptBridge extends ViewBaseScriptBridge {
        JSONObject getAnswers();
    }

    public interface PagerScriptBridge extends ViewBaseScriptBridge {
        Integer getPageNumber();
    }

    public interface RadioGroupScriptBridge extends ViewBaseScriptBridge {
        String getSelectedResponseId();
    }

    public interface TextFieldScriptBridge extends ViewBaseScriptBridge {
        String getTextFieldResponse();
    }

    public static class ViewBaseScriptBridgeUtils {
        public static String getType(ViewBaseScriptBridge viewBaseScriptBridge) {
            return viewBaseScriptBridge instanceof FormScriptBridge ? "Form" : viewBaseScriptBridge instanceof PagerScriptBridge ? "Pager" : "UNKNOWN";
        }
    }

    String getType();

    ViewBaseScriptBridge getViewScriptBridge();
}
