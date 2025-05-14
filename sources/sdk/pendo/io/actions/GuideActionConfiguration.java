package sdk.pendo.io.actions;

import java.util.Iterator;
import sdk.pendo.io.g9.k0;
import sdk.pendo.io.k0.f;
import sdk.pendo.io.k0.i;
import sdk.pendo.io.k0.l;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.StepGuideModel;
import sdk.pendo.io.models.StepModel;

/* loaded from: classes6.dex */
public class GuideActionConfiguration {
    private static final String BANNER_GUIDE = "Banner";
    public static final int FIRST_CHILD_INDEX = 0;
    private static final String FULLSCREEN_WIDGET_NAME = "Fullscreen";
    public static final String GUIDE_BUILDING_BLOCK_ACTIONS = "actions";
    public static final String GUIDE_BUILDING_BLOCK_ID = "id";
    public static final String GUIDE_BUILDING_BLOCK_PROPERTIES = "properties";
    public static final String GUIDE_BUILDING_BLOCK_VIEWS = "views";
    public static final String GUIDE_BUILDING_BLOCK_WIDGET = "widget";
    public static final String GUIDE_SCREEN_CONTENT = "content";
    public static final String GUIDE_SCREEN_CONTENT_GUIDE = "guide";
    public static final String GUIDE_SCREEN_PERSONALIZATION = "personalization";
    public static final String GUIDE_SCREEN_WIDGET = "widget";
    public static final String GUIDE_SCREEN_WIDGET_PROPERTIES = "properties";
    public static final String GUIDE_WIDGET_BASE_BUILDING_BLOCK_NAME = "Base";
    public static final String NAME = "name";
    private static final String TOOLTIP_WIDGET_NAME = "Tooltip";
    public static final String TYPE = "type";
    public static final String VALUE = "value";

    public enum VisualGuideType {
        TOOLTIP("Tooltip"),
        FULLSCREEN("Fullscreen"),
        BANNER(GuideActionConfiguration.BANNER_GUIDE);

        public final String widgetType;

        VisualGuideType(String str) {
            this.widgetType = str;
        }
    }

    static l getFloatingGuideContent(StepModel stepModel, VisualGuideType visualGuideType) {
        try {
            i screenContents = getScreenContents(stepModel.getStepContent());
            if (screenContents != null) {
                return k0.a(screenContents.e().b(GUIDE_BUILDING_BLOCK_VIEWS).a(0).e(), visualGuideType);
            }
            PendoLogger.i("No screen content found in object", stepModel);
            return null;
        } catch (Exception e) {
            PendoLogger.e(e, e.getMessage(), new Object[0]);
            return null;
        }
    }

    static f getGuideContentProperties(StepModel stepModel) {
        try {
            i screenContents = getScreenContents(stepModel.getStepContent());
            if (screenContents != null) {
                return screenContents.e().b("properties");
            }
            return null;
        } catch (Exception e) {
            PendoLogger.e(e, e.getMessage(), new Object[0]);
            return null;
        }
    }

    public static i getScreenContents(StepGuideModel stepGuideModel) {
        if (!hasBaseBuildingBlock(stepGuideModel)) {
            return null;
        }
        try {
            return stepGuideModel.getViews().a(0);
        } catch (Exception e) {
            PendoLogger.e(e, e.getMessage(), "stepGuideModelId: " + stepGuideModel.getId());
            return null;
        }
    }

    public static VisualGuideType getStepVisualPendoGuideType(StepModel stepModel) {
        try {
            i screenContents = getScreenContents(stepModel.getStepContent());
            if (screenContents != null) {
                if (isTooltipGuide(screenContents)) {
                    return VisualGuideType.TOOLTIP;
                }
                if (isBannerGuide(screenContents)) {
                    return VisualGuideType.BANNER;
                }
            }
        } catch (Exception e) {
            PendoLogger.e(e, e.getMessage(), new Object[0]);
        }
        return VisualGuideType.FULLSCREEN;
    }

    static f getTooltipProperties(StepModel stepModel) {
        i screenContents;
        f b;
        i a2;
        if (stepModel == null) {
            return null;
        }
        try {
            if (stepModel.getStepContent() == null || (screenContents = getScreenContents(stepModel.getStepContent())) == null || (b = screenContents.e().b(GUIDE_BUILDING_BLOCK_VIEWS)) == null || (a2 = b.a(0)) == null) {
                return null;
            }
            return a2.e().b("properties");
        } catch (Exception e) {
            PendoLogger.e(e, e.getMessage(), new Object[0]);
            return null;
        }
    }

    static l getTooltipWidgetWrapperObject(StepModel stepModel) {
        try {
            i screenContents = getScreenContents(stepModel.getStepContent());
            if (screenContents != null) {
                return screenContents.e();
            }
            PendoLogger.i("No screen content found in object", stepModel);
            return null;
        } catch (Exception e) {
            PendoLogger.e(e, e.getMessage(), new Object[0]);
            return null;
        }
    }

    private static boolean hasBaseBuildingBlock(StepGuideModel stepGuideModel) {
        f views = stepGuideModel.getViews();
        return GUIDE_WIDGET_BASE_BUILDING_BLOCK_NAME.equals(stepGuideModel.getWidget()) && views != null && views.size() > 0;
    }

    public static boolean isBannerGuide(i iVar) {
        Iterator<i> it = iVar.e().b("properties").d().iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (next.e().a("name").g().equals("isMobileBanner")) {
                return next.e().a("value").a();
            }
        }
        return false;
    }

    public static boolean isTooltipGuide(i iVar) {
        return VisualGuideType.TOOLTIP.widgetType.contentEquals(iVar.e().b(GUIDE_BUILDING_BLOCK_VIEWS).a(0).e().c("widget").g());
    }
}
