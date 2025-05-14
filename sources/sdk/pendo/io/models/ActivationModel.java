package sdk.pendo.io.models;

import sdk.pendo.io.g9.u;
import sdk.pendo.io.l0.c;

/* loaded from: classes6.dex */
public class ActivationModel {
    private boolean isActivationOverriden = false;

    @c("event")
    private String mEvent;

    @c("featureActivationId")
    private long mFeatureActivationId;

    @c("featureSelector")
    private String mFeatureSelector;

    @c("pageActivationId")
    private long mPageActivationId;

    @c("pageSelector")
    private String mPageSelector;

    @c("trackActivationId")
    private long mTrackActivationId;

    @c("trackSelector")
    private String mTrackSelector;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ActivationModel activationModel = (ActivationModel) obj;
        return this.mPageActivationId == activationModel.mPageActivationId && this.mFeatureActivationId == activationModel.mFeatureActivationId && u.a(this.mPageSelector, activationModel.mPageSelector) && u.a(this.mFeatureSelector, activationModel.mFeatureSelector) && u.a(this.mTrackSelector, activationModel.mTrackSelector) && u.a(this.mEvent, activationModel.mEvent);
    }

    public String getEvent() {
        return this.mEvent;
    }

    public String getFeatureSelector() {
        return this.mFeatureSelector;
    }

    public String getPageSelector() {
        return this.mPageSelector;
    }

    public String getTrackSelector() {
        return this.mTrackSelector;
    }

    public int hashCode() {
        return u.a(this.mPageSelector, this.mFeatureSelector, Long.valueOf(this.mPageActivationId), Long.valueOf(this.mFeatureActivationId), this.mTrackSelector, Long.valueOf(this.mTrackActivationId), this.mEvent);
    }

    public boolean isActivationOverriden() {
        return this.isActivationOverriden;
    }

    public void setEvent(String str) {
        this.mEvent = str;
    }

    public void setFeatureSelector(String str) {
        this.mFeatureSelector = str;
    }

    public void setIsActivationOverridden(boolean z) {
        this.isActivationOverriden = z;
    }

    public void setPageSelector(String str) {
        this.mPageSelector = str;
    }

    public void setTrackSelector(String str) {
        this.mTrackSelector = str;
    }

    public String toString() {
        String str = this.mPageSelector;
        if (str == null) {
            str = "";
        }
        String str2 = this.mFeatureSelector;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = this.mTrackSelector;
        if (str3 == null) {
            str3 = "";
        }
        String str4 = this.mEvent;
        return "Activation Model: \npageSelector: " + str + "\nfeatureSelector: " + str2 + "\ntrackSelector: " + str3 + "\nfeatureActivationId: " + this.mFeatureActivationId + "\npageActivationId: " + this.mPageActivationId + "\ntrackActivationId: " + this.mTrackActivationId + "\nevent: " + (str4 != null ? str4 : "");
    }
}
