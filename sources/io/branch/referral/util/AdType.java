package io.branch.referral.util;

/* loaded from: classes2.dex */
public enum AdType {
    BANNER("BANNER"),
    INTERSTITIAL("INTERSTITIAL"),
    REWARDED_VIDEO("REWARDED_VIDEO"),
    NATIVE("NATIVE");

    private final String name;

    AdType(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
