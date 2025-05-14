package com.socure.idplus.device.internal.sigmaDeviceV2.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013¢\u0006\u0002\u0010\u0015J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003J¯\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013HÆ\u0001J\u0013\u00107\u001a\u00020\u00032\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020:HÖ\u0001J\t\u0010;\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001b¨\u0006<"}, d2 = {"Lcom/socure/idplus/device/internal/sigmaDeviceV2/model/AndroidAttributes;", "", "isRooted", "", "buildFingerprint", "", "buildBrand", "buildDevice", "buildHardware", "buildProduct", "localeCalendar", "localeKeyboards", "localeUserPreferredLanguages", "advertisingId", "accessibilityClosedCaptionsEnabled", "accessibilityIsBoldTextEnabled", "accessibilityReduceMotionEnabled", "wifiNetwork", "mobileNetwork", "", "Lcom/socure/idplus/device/internal/sigmaDeviceV2/model/MobileNetwork;", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;Ljava/util/List;)V", "getAccessibilityClosedCaptionsEnabled", "()Z", "getAccessibilityIsBoldTextEnabled", "getAccessibilityReduceMotionEnabled", "getAdvertisingId", "()Ljava/lang/String;", "getBuildBrand", "getBuildDevice", "getBuildFingerprint", "getBuildHardware", "getBuildProduct", "getLocaleCalendar", "getLocaleKeyboards", "getLocaleUserPreferredLanguages", "getMobileNetwork", "()Ljava/util/List;", "getWifiNetwork", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "device-risk-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AndroidAttributes {

    @SerializedName("accessibilityClosedCaptionsEnabled")
    private final boolean accessibilityClosedCaptionsEnabled;

    @SerializedName("accessibilityIsBoldTextEnabled")
    private final boolean accessibilityIsBoldTextEnabled;

    @SerializedName("accessibilityReduceMotionEnabled")
    private final boolean accessibilityReduceMotionEnabled;

    @SerializedName("advertisingId")
    private final String advertisingId;

    @SerializedName("buildBrand")
    private final String buildBrand;

    @SerializedName("buildDevice")
    private final String buildDevice;

    @SerializedName("buildFingerprint")
    private final String buildFingerprint;

    @SerializedName("buildHardware")
    private final String buildHardware;

    @SerializedName("buildProduct")
    private final String buildProduct;

    @SerializedName("isRooted")
    private final boolean isRooted;

    @SerializedName("localeCalendar")
    private final String localeCalendar;

    @SerializedName("localeKeyboards")
    private final String localeKeyboards;

    @SerializedName("localeUserPreferredLanguages")
    private final String localeUserPreferredLanguages;

    @SerializedName("mobileNetwork")
    private final List<MobileNetwork> mobileNetwork;

    @SerializedName("wifiNetwork")
    private final String wifiNetwork;

    public AndroidAttributes(boolean z, String buildFingerprint, String buildBrand, String buildDevice, String buildHardware, String buildProduct, String str, String localeKeyboards, String str2, String str3, boolean z2, boolean z3, boolean z4, String str4, List<MobileNetwork> list) {
        Intrinsics.checkNotNullParameter(buildFingerprint, "buildFingerprint");
        Intrinsics.checkNotNullParameter(buildBrand, "buildBrand");
        Intrinsics.checkNotNullParameter(buildDevice, "buildDevice");
        Intrinsics.checkNotNullParameter(buildHardware, "buildHardware");
        Intrinsics.checkNotNullParameter(buildProduct, "buildProduct");
        Intrinsics.checkNotNullParameter(localeKeyboards, "localeKeyboards");
        this.isRooted = z;
        this.buildFingerprint = buildFingerprint;
        this.buildBrand = buildBrand;
        this.buildDevice = buildDevice;
        this.buildHardware = buildHardware;
        this.buildProduct = buildProduct;
        this.localeCalendar = str;
        this.localeKeyboards = localeKeyboards;
        this.localeUserPreferredLanguages = str2;
        this.advertisingId = str3;
        this.accessibilityClosedCaptionsEnabled = z2;
        this.accessibilityIsBoldTextEnabled = z3;
        this.accessibilityReduceMotionEnabled = z4;
        this.wifiNetwork = str4;
        this.mobileNetwork = list;
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsRooted() {
        return this.isRooted;
    }

    /* renamed from: component10, reason: from getter */
    public final String getAdvertisingId() {
        return this.advertisingId;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getAccessibilityClosedCaptionsEnabled() {
        return this.accessibilityClosedCaptionsEnabled;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getAccessibilityIsBoldTextEnabled() {
        return this.accessibilityIsBoldTextEnabled;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getAccessibilityReduceMotionEnabled() {
        return this.accessibilityReduceMotionEnabled;
    }

    /* renamed from: component14, reason: from getter */
    public final String getWifiNetwork() {
        return this.wifiNetwork;
    }

    public final List<MobileNetwork> component15() {
        return this.mobileNetwork;
    }

    /* renamed from: component2, reason: from getter */
    public final String getBuildFingerprint() {
        return this.buildFingerprint;
    }

    /* renamed from: component3, reason: from getter */
    public final String getBuildBrand() {
        return this.buildBrand;
    }

    /* renamed from: component4, reason: from getter */
    public final String getBuildDevice() {
        return this.buildDevice;
    }

    /* renamed from: component5, reason: from getter */
    public final String getBuildHardware() {
        return this.buildHardware;
    }

    /* renamed from: component6, reason: from getter */
    public final String getBuildProduct() {
        return this.buildProduct;
    }

    /* renamed from: component7, reason: from getter */
    public final String getLocaleCalendar() {
        return this.localeCalendar;
    }

    /* renamed from: component8, reason: from getter */
    public final String getLocaleKeyboards() {
        return this.localeKeyboards;
    }

    /* renamed from: component9, reason: from getter */
    public final String getLocaleUserPreferredLanguages() {
        return this.localeUserPreferredLanguages;
    }

    public final AndroidAttributes copy(boolean isRooted, String buildFingerprint, String buildBrand, String buildDevice, String buildHardware, String buildProduct, String localeCalendar, String localeKeyboards, String localeUserPreferredLanguages, String advertisingId, boolean accessibilityClosedCaptionsEnabled, boolean accessibilityIsBoldTextEnabled, boolean accessibilityReduceMotionEnabled, String wifiNetwork, List<MobileNetwork> mobileNetwork) {
        Intrinsics.checkNotNullParameter(buildFingerprint, "buildFingerprint");
        Intrinsics.checkNotNullParameter(buildBrand, "buildBrand");
        Intrinsics.checkNotNullParameter(buildDevice, "buildDevice");
        Intrinsics.checkNotNullParameter(buildHardware, "buildHardware");
        Intrinsics.checkNotNullParameter(buildProduct, "buildProduct");
        Intrinsics.checkNotNullParameter(localeKeyboards, "localeKeyboards");
        return new AndroidAttributes(isRooted, buildFingerprint, buildBrand, buildDevice, buildHardware, buildProduct, localeCalendar, localeKeyboards, localeUserPreferredLanguages, advertisingId, accessibilityClosedCaptionsEnabled, accessibilityIsBoldTextEnabled, accessibilityReduceMotionEnabled, wifiNetwork, mobileNetwork);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AndroidAttributes)) {
            return false;
        }
        AndroidAttributes androidAttributes = (AndroidAttributes) other;
        return this.isRooted == androidAttributes.isRooted && Intrinsics.areEqual(this.buildFingerprint, androidAttributes.buildFingerprint) && Intrinsics.areEqual(this.buildBrand, androidAttributes.buildBrand) && Intrinsics.areEqual(this.buildDevice, androidAttributes.buildDevice) && Intrinsics.areEqual(this.buildHardware, androidAttributes.buildHardware) && Intrinsics.areEqual(this.buildProduct, androidAttributes.buildProduct) && Intrinsics.areEqual(this.localeCalendar, androidAttributes.localeCalendar) && Intrinsics.areEqual(this.localeKeyboards, androidAttributes.localeKeyboards) && Intrinsics.areEqual(this.localeUserPreferredLanguages, androidAttributes.localeUserPreferredLanguages) && Intrinsics.areEqual(this.advertisingId, androidAttributes.advertisingId) && this.accessibilityClosedCaptionsEnabled == androidAttributes.accessibilityClosedCaptionsEnabled && this.accessibilityIsBoldTextEnabled == androidAttributes.accessibilityIsBoldTextEnabled && this.accessibilityReduceMotionEnabled == androidAttributes.accessibilityReduceMotionEnabled && Intrinsics.areEqual(this.wifiNetwork, androidAttributes.wifiNetwork) && Intrinsics.areEqual(this.mobileNetwork, androidAttributes.mobileNetwork);
    }

    public final boolean getAccessibilityClosedCaptionsEnabled() {
        return this.accessibilityClosedCaptionsEnabled;
    }

    public final boolean getAccessibilityIsBoldTextEnabled() {
        return this.accessibilityIsBoldTextEnabled;
    }

    public final boolean getAccessibilityReduceMotionEnabled() {
        return this.accessibilityReduceMotionEnabled;
    }

    public final String getAdvertisingId() {
        return this.advertisingId;
    }

    public final String getBuildBrand() {
        return this.buildBrand;
    }

    public final String getBuildDevice() {
        return this.buildDevice;
    }

    public final String getBuildFingerprint() {
        return this.buildFingerprint;
    }

    public final String getBuildHardware() {
        return this.buildHardware;
    }

    public final String getBuildProduct() {
        return this.buildProduct;
    }

    public final String getLocaleCalendar() {
        return this.localeCalendar;
    }

    public final String getLocaleKeyboards() {
        return this.localeKeyboards;
    }

    public final String getLocaleUserPreferredLanguages() {
        return this.localeUserPreferredLanguages;
    }

    public final List<MobileNetwork> getMobileNetwork() {
        return this.mobileNetwork;
    }

    public final String getWifiNetwork() {
        return this.wifiNetwork;
    }

    public int hashCode() {
        int hashCode = (this.buildProduct.hashCode() + ((this.buildHardware.hashCode() + ((this.buildDevice.hashCode() + ((this.buildBrand.hashCode() + ((this.buildFingerprint.hashCode() + (Boolean.hashCode(this.isRooted) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        String str = this.localeCalendar;
        int hashCode2 = (this.localeKeyboards.hashCode() + ((hashCode + (str == null ? 0 : str.hashCode())) * 31)) * 31;
        String str2 = this.localeUserPreferredLanguages;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.advertisingId;
        int hashCode4 = (Boolean.hashCode(this.accessibilityReduceMotionEnabled) + ((Boolean.hashCode(this.accessibilityIsBoldTextEnabled) + ((Boolean.hashCode(this.accessibilityClosedCaptionsEnabled) + ((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31)) * 31)) * 31)) * 31;
        String str4 = this.wifiNetwork;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        List<MobileNetwork> list = this.mobileNetwork;
        return hashCode5 + (list != null ? list.hashCode() : 0);
    }

    public final boolean isRooted() {
        return this.isRooted;
    }

    public String toString() {
        return "AndroidAttributes(isRooted=" + this.isRooted + ", buildFingerprint=" + this.buildFingerprint + ", buildBrand=" + this.buildBrand + ", buildDevice=" + this.buildDevice + ", buildHardware=" + this.buildHardware + ", buildProduct=" + this.buildProduct + ", localeCalendar=" + this.localeCalendar + ", localeKeyboards=" + this.localeKeyboards + ", localeUserPreferredLanguages=" + this.localeUserPreferredLanguages + ", advertisingId=" + this.advertisingId + ", accessibilityClosedCaptionsEnabled=" + this.accessibilityClosedCaptionsEnabled + ", accessibilityIsBoldTextEnabled=" + this.accessibilityIsBoldTextEnabled + ", accessibilityReduceMotionEnabled=" + this.accessibilityReduceMotionEnabled + ", wifiNetwork=" + this.wifiNetwork + ", mobileNetwork=" + this.mobileNetwork + ")";
    }

    public /* synthetic */ AndroidAttributes(boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z2, boolean z3, boolean z4, String str10, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, str, str2, str3, str4, str5, (i & 64) != 0 ? null : str6, str7, (i & 256) != 0 ? null : str8, str9, z2, z3, z4, (i & 8192) != 0 ? null : str10, (i & 16384) != 0 ? null : list);
    }
}
