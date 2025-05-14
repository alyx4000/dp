package sdk.pendo.io.actions;

/* loaded from: classes6.dex */
public interface GuidesActionsManagerInterface {
    void dismissVisibleGuides();

    void removeGuideFullyDisplayedAfterAnimation(String str);

    void setGuideFullyDisplayedAfterAnimation(String str);

    boolean wasGuideFullyDisplayedAfterAnimation(String str);
}
