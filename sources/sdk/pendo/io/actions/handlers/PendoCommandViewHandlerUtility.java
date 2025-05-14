package sdk.pendo.io.actions.handlers;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import io.sentry.protocol.ViewHierarchyNode;
import java.util.List;
import sdk.pendo.io.actions.PendoCommand;
import sdk.pendo.io.actions.PendoCommandAction;
import sdk.pendo.io.actions.PendoCommandEventType;
import sdk.pendo.io.actions.PendoCommandsEventBus;
import sdk.pendo.io.d6.e;
import sdk.pendo.io.d6.j;
import sdk.pendo.io.f7.g;
import sdk.pendo.io.logging.PendoLogger;

/* loaded from: classes6.dex */
public final class PendoCommandViewHandlerUtility {
    private static final String PARAMETER_NAME_TEXT = "text";

    private PendoCommandViewHandlerUtility() {
    }

    public static void handlePendoCommandsForView(View view, String str) {
        j<PendoCommand> createFilter = PendoCommand.createFilter("any", str, PendoCommandAction.PENDO_COMMAND_ACTION_ANY, PendoCommandEventType.PENDO_COMMAND_EVENT_TYPE_ANY, PendoCommand.PendoCommandScope.PENDO_COMMAND_SCOPE_ANY);
        setupViewGeneralHandler(view, createFilter);
        if (view instanceof TextView) {
            setupTextViewHandler(view, createFilter);
        }
    }

    private static void setupTextViewHandler(final View view, j<PendoCommand> jVar) {
        PendoCommandsEventBus.getInstance().subscribe(g.a(view), jVar, new e<PendoCommand>() { // from class: sdk.pendo.io.actions.handlers.PendoCommandViewHandlerUtility.2
            @Override // sdk.pendo.io.d6.e
            public void accept(PendoCommand pendoCommand) {
                PendoLogger.d(pendoCommand.toString(), new Object[0]);
                PendoCommandAction action = pendoCommand.getAction();
                List<PendoCommandsEventBus.Parameter> parameters = pendoCommand.getParameters();
                if (parameters == null) {
                    PendoLogger.w("Got " + pendoCommand.getAction() + " and " + pendoCommand.getEventType() + " without parameters! Doing nothing.", new Object[0]);
                    return;
                }
                String str = null;
                for (PendoCommandsEventBus.Parameter parameter : parameters) {
                    if ("text".equals(parameter.getParameterName())) {
                        str = parameter.getParameterValue();
                    }
                }
                if (PendoCommandAction.PendoCommandTextAction.SET_TEXT.equals(action) && !TextUtils.isEmpty(str)) {
                    ((TextView) view).setText(str);
                    view.setContentDescription(str);
                }
                PendoCommandAction.PendoCommandPageAction.VALIDATE.equals(action);
            }
        });
    }

    private static void setupViewGeneralHandler(final View view, j<PendoCommand> jVar) {
        PendoCommandsEventBus.getInstance().subscribe(g.a(view), jVar, new e<PendoCommand>() { // from class: sdk.pendo.io.actions.handlers.PendoCommandViewHandlerUtility.1
            @Override // sdk.pendo.io.d6.e
            public void accept(PendoCommand pendoCommand) {
                View view2;
                int i;
                PendoLogger.d(pendoCommand.toString(), new Object[0]);
                PendoCommandAction action = pendoCommand.getAction();
                List<PendoCommandsEventBus.Parameter> parameters = pendoCommand.getParameters();
                if (parameters == null) {
                    PendoLogger.w("Got " + pendoCommand.getAction() + " and " + pendoCommand.getEventType() + " without parameters! Doing nothing.", new Object[0]);
                    return;
                }
                Boolean bool = null;
                String str = null;
                String str2 = null;
                for (PendoCommandsEventBus.Parameter parameter : parameters) {
                    String parameterName = parameter.getParameterName();
                    if (ViewHierarchyNode.JsonKeys.VISIBILITY.equals(parameterName)) {
                        str2 = parameter.getParameterValue();
                    } else if ("color".equals(parameterName)) {
                        str = parameter.getParameterValue();
                    } else if ("enabled".equals(parameterName) && "boolean".equalsIgnoreCase(parameter.getValueType())) {
                        try {
                            bool = Boolean.valueOf(parameter.getParameterValue());
                        } catch (Exception e) {
                            PendoLogger.w(e, e.getMessage(), new Object[0]);
                        }
                    }
                }
                if (PendoCommandAction.PendoCommandViewGeneralAction.ENABLE.equals(action)) {
                    if (bool == null) {
                        PendoLogger.w("enable is null doing nothing.", new Object[0]);
                        return;
                    } else {
                        view.setEnabled(bool.booleanValue());
                        return;
                    }
                }
                if (PendoCommandAction.PendoCommandViewGeneralAction.SET_BACKGROUND_COLOR.equals(action)) {
                    if (str == null) {
                        PendoLogger.w("color is null doing nothing.", new Object[0]);
                        return;
                    }
                    try {
                        view.setBackgroundColor(Color.parseColor(str));
                        return;
                    } catch (Exception e2) {
                        PendoLogger.w(e2, "Got color: " + str, new Object[0]);
                        return;
                    }
                }
                if (PendoCommandAction.PendoCommandViewGeneralAction.SET_VISIBILITY.equals(action)) {
                    if (str2 == null) {
                        PendoLogger.w("visibility is null doing nothing.", new Object[0]);
                        return;
                    }
                    str2.hashCode();
                    switch (str2) {
                        case "hidden":
                            view2 = view;
                            i = 4;
                            break;
                        case "visible":
                            view.setVisibility(0);
                            return;
                        case "removed":
                            view2 = view;
                            i = 8;
                            break;
                        default:
                            PendoLogger.w("Got unsupported visibility: " + str2, new Object[0]);
                            return;
                    }
                    view2.setVisibility(i);
                }
            }
        });
    }
}
