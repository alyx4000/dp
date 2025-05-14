package sdk.pendo.io.models;

import sdk.pendo.io.actions.GuideActionConfiguration;
import sdk.pendo.io.k0.f;
import sdk.pendo.io.l0.c;

/* loaded from: classes6.dex */
public class StepGuideModel {

    @c("actions")
    private f mActions;

    @c("configuration")
    private GuideConfigurationModel mConfiguration;

    @c("id")
    private String mId;

    @c("properties")
    private f mProperties;

    @c(GuideActionConfiguration.GUIDE_BUILDING_BLOCK_VIEWS)
    private f mViews;

    @c("widget")
    private String mWidget;

    public f getActions() {
        return this.mActions;
    }

    public GuideConfigurationModel getConfiguration() {
        return this.mConfiguration;
    }

    public String getId() {
        return this.mId;
    }

    public f getProperties() {
        return this.mProperties;
    }

    public f getViews() {
        return this.mViews;
    }

    public String getWidget() {
        return this.mWidget;
    }

    public void setActions(f fVar) {
        this.mActions = fVar;
    }

    public void setConfiguration(GuideConfigurationModel guideConfigurationModel) {
        this.mConfiguration = guideConfigurationModel;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void setProperties(f fVar) {
        this.mProperties = fVar;
    }

    public void setViews(f fVar) {
        this.mViews = fVar;
    }

    public void setWidget(String str) {
        this.mWidget = str;
    }
}
