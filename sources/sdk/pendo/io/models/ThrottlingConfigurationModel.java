package sdk.pendo.io.models;

import sdk.pendo.io.l0.c;

/* loaded from: classes6.dex */
public class ThrottlingConfigurationModel {

    @c("count")
    private int mCount;

    @c("enabled")
    private boolean mEnabled;

    @c("interval")
    private int mInterval;

    @c("unit")
    private String mUnit;

    public int getInterval() {
        return this.mInterval;
    }

    public String getUnit() {
        return this.mUnit;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }
}
