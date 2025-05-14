package sdk.pendo.io.models;

import sdk.pendo.io.g9.u;
import sdk.pendo.io.l0.c;

/* loaded from: classes6.dex */
public class StepLocationModel {

    @c("featureLocationId")
    private String mFeatureLocationId;

    @c("featureSelector")
    private String mFeatureSelector;

    @c("gravity")
    private String mGravity;

    @c("pageLocationId")
    private String mPageLocationId;

    @c("pageSelector")
    private String mPageSelector;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StepLocationModel stepLocationModel = (StepLocationModel) obj;
        return u.a(this.mPageSelector, stepLocationModel.mPageSelector) && u.a(this.mFeatureSelector, stepLocationModel.mFeatureSelector) && u.a(this.mFeatureLocationId, stepLocationModel.mFeatureLocationId) && u.a(this.mPageLocationId, stepLocationModel.mPageLocationId) && u.a(this.mGravity, stepLocationModel.mGravity);
    }

    public String getFeatureSelector() {
        return this.mFeatureSelector;
    }

    public String getGravity() {
        return this.mGravity;
    }

    public int hashCode() {
        return u.a(this.mPageSelector, this.mFeatureSelector, this.mFeatureLocationId, this.mPageLocationId, this.mGravity);
    }

    public void setFeatureSelector(String str) {
        this.mFeatureSelector = str;
    }
}
