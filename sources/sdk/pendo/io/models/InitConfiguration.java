package sdk.pendo.io.models;

import external.sdk.pendo.io.daimajia.BuildConfig;
import sdk.pendo.io.l0.c;

/* loaded from: classes6.dex */
public class InitConfiguration {

    @c(BuildConfig.BUILD_TYPE)
    private DebugConfigurationModel mDebugConfigurationModel;

    @c("guides")
    private GuidesConfigurationModel mGuidesConfigurationModel;

    @c("analytics")
    private AnalyticsConfigurationModel mInitAnalyticsModel;

    @c("react")
    private ReactConfigurationModel mReactConfigurationModel;

    @c("sessionTimeout")
    private int mSessionTimeout;

    public DebugConfigurationModel getDebugConfigurationModel() {
        return this.mDebugConfigurationModel;
    }

    public GuidesConfigurationModel getGuidesConfigurationModel() {
        return this.mGuidesConfigurationModel;
    }

    public AnalyticsConfigurationModel getInitAnalyticsModel() {
        return this.mInitAnalyticsModel;
    }

    public ReactConfigurationModel getReactConfigurationModel() {
        return this.mReactConfigurationModel;
    }

    public int getSessionTimeout() {
        return this.mSessionTimeout;
    }

    public void setSessionTimeout(int i) {
        this.mSessionTimeout = i;
    }
}
