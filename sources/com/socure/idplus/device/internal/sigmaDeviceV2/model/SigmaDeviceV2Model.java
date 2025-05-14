package com.socure.idplus.device.internal.sigmaDeviceV2.model;

import com.amplitude.reactnative.AndroidContextProvider;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.gson.annotations.SerializedName;
import com.iterable.iterableapi.IterableConstants;
import com.socure.idplus.device.internal.sigmaDeviceLocation.model.SigmaDeviceLocationModel;
import io.sentry.protocol.OperatingSystem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b;\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0081\b\u0018\u00002\u00020\u0001BÕ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0011\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u001f¢\u0006\u0002\u0010 J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00108J\u0010\u0010C\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00108J\u0010\u0010D\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00108J\t\u0010E\u001a\u00020\u000bHÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\rHÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0017HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u001bHÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\u001fHÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0003HÆ\u0003J\t\u0010V\u001a\u00020\u000bHÆ\u0003J\u0010\u0010W\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00108Jþ\u0001\u0010X\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u001fHÆ\u0001¢\u0006\u0002\u0010YJ\u0013\u0010Z\u001a\u00020[2\b\u0010\\\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010]\u001a\u00020\rHÖ\u0001J\t\u0010^\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u001e\u001a\u00020\u001f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0016\u0010\u001c\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0016\u0010\u001a\u001a\u00020\u001b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0016\u0010\u0015\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010$R\u0016\u0010\u001d\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010$R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010$R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010$R\u0016\u0010\u0011\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010+R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010$R\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010$R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0016\u0010\u0016\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010$R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010$R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010$R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00109\u001a\u0004\b7\u00108R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00109\u001a\u0004\b:\u00108R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010$R\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010$R\u0016\u0010\u0013\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00109\u001a\u0004\b?\u00108R\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00109\u001a\u0004\b@\u00108¨\u0006_"}, d2 = {"Lcom/socure/idplus/device/internal/sigmaDeviceV2/model/SigmaDeviceV2Model;", "", "sdkVersion", "", "platform", OperatingSystem.TYPE, "osVersion", "deviceModel", "deviceManufacturer", "deviceType", "deviceMemory", "", "viewportWidth", "", "viewportHeight", "screenWidth", "screenHeight", "devicePixelRatio", RemoteConfigConstants.RequestFieldKey.TIME_ZONE, "timeZoneOffset", "language", "deviceArchitecture", "network", "Lcom/socure/idplus/device/internal/sigmaDeviceV2/model/DeviceNetwork;", IterableConstants.ITERABLE_IN_APP_LOCATION, "Lcom/socure/idplus/device/internal/sigmaDeviceLocation/model/SigmaDeviceLocationModel;", "battery", "Lcom/socure/idplus/device/internal/sigmaDeviceV2/model/Battery;", "applicationType", "deviceContext", "androidAttributes", "Lcom/socure/idplus/device/internal/sigmaDeviceV2/model/AndroidAttributes;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;FLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/socure/idplus/device/internal/sigmaDeviceV2/model/DeviceNetwork;Lcom/socure/idplus/device/internal/sigmaDeviceLocation/model/SigmaDeviceLocationModel;Lcom/socure/idplus/device/internal/sigmaDeviceV2/model/Battery;Ljava/lang/String;Ljava/lang/String;Lcom/socure/idplus/device/internal/sigmaDeviceV2/model/AndroidAttributes;)V", "getAndroidAttributes", "()Lcom/socure/idplus/device/internal/sigmaDeviceV2/model/AndroidAttributes;", "getApplicationType", "()Ljava/lang/String;", "getBattery", "()Lcom/socure/idplus/device/internal/sigmaDeviceV2/model/Battery;", "getDeviceArchitecture", "getDeviceContext", "getDeviceManufacturer", "getDeviceMemory", "()F", "getDeviceModel", "getDevicePixelRatio", "getDeviceType", "getLanguage", "getLocation", "()Lcom/socure/idplus/device/internal/sigmaDeviceLocation/model/SigmaDeviceLocationModel;", "getNetwork", "()Lcom/socure/idplus/device/internal/sigmaDeviceV2/model/DeviceNetwork;", "getOs", "getOsVersion", "getPlatform", "getScreenHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getScreenWidth", "getSdkVersion", "getTimeZone", "getTimeZoneOffset", "()I", "getViewportHeight", "getViewportWidth", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;FLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/socure/idplus/device/internal/sigmaDeviceV2/model/DeviceNetwork;Lcom/socure/idplus/device/internal/sigmaDeviceLocation/model/SigmaDeviceLocationModel;Lcom/socure/idplus/device/internal/sigmaDeviceV2/model/Battery;Ljava/lang/String;Ljava/lang/String;Lcom/socure/idplus/device/internal/sigmaDeviceV2/model/AndroidAttributes;)Lcom/socure/idplus/device/internal/sigmaDeviceV2/model/SigmaDeviceV2Model;", "equals", "", "other", "hashCode", "toString", "device-risk-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SigmaDeviceV2Model {

    @SerializedName("androidAttributes")
    private final AndroidAttributes androidAttributes;

    @SerializedName("applicationType")
    private final String applicationType;

    @SerializedName("battery")
    private final Battery battery;

    @SerializedName("deviceArchitecture")
    private final String deviceArchitecture;

    @SerializedName("deviceContext")
    private final String deviceContext;

    @SerializedName("deviceManufacturer")
    private final String deviceManufacturer;

    @SerializedName("deviceMemory")
    private final float deviceMemory;

    @SerializedName("deviceModel")
    private final String deviceModel;

    @SerializedName("devicePixelRatio")
    private final float devicePixelRatio;

    @SerializedName("deviceType")
    private final String deviceType;

    @SerializedName("language")
    private final String language;

    @SerializedName(IterableConstants.ITERABLE_IN_APP_LOCATION)
    private final SigmaDeviceLocationModel location;

    @SerializedName("network")
    private final DeviceNetwork network;

    @SerializedName(OperatingSystem.TYPE)
    private final String os;

    @SerializedName("osVersion")
    private final String osVersion;

    @SerializedName("platform")
    private final String platform;

    @SerializedName("screenHeight")
    private final Integer screenHeight;

    @SerializedName("screenWidth")
    private final Integer screenWidth;

    @SerializedName("sdkVersion")
    private final String sdkVersion;

    @SerializedName(RemoteConfigConstants.RequestFieldKey.TIME_ZONE)
    private final String timeZone;

    @SerializedName("timeZoneOffset")
    private final int timeZoneOffset;

    @SerializedName("viewportHeight")
    private final Integer viewportHeight;

    @SerializedName("viewportWidth")
    private final Integer viewportWidth;

    public SigmaDeviceV2Model(String sdkVersion, String platform, String os, String osVersion, String deviceModel, String deviceManufacturer, String deviceType, float f, Integer num, Integer num2, Integer num3, Integer num4, float f2, String timeZone, int i, String language, String deviceArchitecture, DeviceNetwork network, SigmaDeviceLocationModel sigmaDeviceLocationModel, Battery battery, String applicationType, String deviceContext, AndroidAttributes androidAttributes) {
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(os, "os");
        Intrinsics.checkNotNullParameter(osVersion, "osVersion");
        Intrinsics.checkNotNullParameter(deviceModel, "deviceModel");
        Intrinsics.checkNotNullParameter(deviceManufacturer, "deviceManufacturer");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(deviceArchitecture, "deviceArchitecture");
        Intrinsics.checkNotNullParameter(network, "network");
        Intrinsics.checkNotNullParameter(battery, "battery");
        Intrinsics.checkNotNullParameter(applicationType, "applicationType");
        Intrinsics.checkNotNullParameter(deviceContext, "deviceContext");
        Intrinsics.checkNotNullParameter(androidAttributes, "androidAttributes");
        this.sdkVersion = sdkVersion;
        this.platform = platform;
        this.os = os;
        this.osVersion = osVersion;
        this.deviceModel = deviceModel;
        this.deviceManufacturer = deviceManufacturer;
        this.deviceType = deviceType;
        this.deviceMemory = f;
        this.viewportWidth = num;
        this.viewportHeight = num2;
        this.screenWidth = num3;
        this.screenHeight = num4;
        this.devicePixelRatio = f2;
        this.timeZone = timeZone;
        this.timeZoneOffset = i;
        this.language = language;
        this.deviceArchitecture = deviceArchitecture;
        this.network = network;
        this.location = sigmaDeviceLocationModel;
        this.battery = battery;
        this.applicationType = applicationType;
        this.deviceContext = deviceContext;
        this.androidAttributes = androidAttributes;
    }

    /* renamed from: component1, reason: from getter */
    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    /* renamed from: component10, reason: from getter */
    public final Integer getViewportHeight() {
        return this.viewportHeight;
    }

    /* renamed from: component11, reason: from getter */
    public final Integer getScreenWidth() {
        return this.screenWidth;
    }

    /* renamed from: component12, reason: from getter */
    public final Integer getScreenHeight() {
        return this.screenHeight;
    }

    /* renamed from: component13, reason: from getter */
    public final float getDevicePixelRatio() {
        return this.devicePixelRatio;
    }

    /* renamed from: component14, reason: from getter */
    public final String getTimeZone() {
        return this.timeZone;
    }

    /* renamed from: component15, reason: from getter */
    public final int getTimeZoneOffset() {
        return this.timeZoneOffset;
    }

    /* renamed from: component16, reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    /* renamed from: component17, reason: from getter */
    public final String getDeviceArchitecture() {
        return this.deviceArchitecture;
    }

    /* renamed from: component18, reason: from getter */
    public final DeviceNetwork getNetwork() {
        return this.network;
    }

    /* renamed from: component19, reason: from getter */
    public final SigmaDeviceLocationModel getLocation() {
        return this.location;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPlatform() {
        return this.platform;
    }

    /* renamed from: component20, reason: from getter */
    public final Battery getBattery() {
        return this.battery;
    }

    /* renamed from: component21, reason: from getter */
    public final String getApplicationType() {
        return this.applicationType;
    }

    /* renamed from: component22, reason: from getter */
    public final String getDeviceContext() {
        return this.deviceContext;
    }

    /* renamed from: component23, reason: from getter */
    public final AndroidAttributes getAndroidAttributes() {
        return this.androidAttributes;
    }

    /* renamed from: component3, reason: from getter */
    public final String getOs() {
        return this.os;
    }

    /* renamed from: component4, reason: from getter */
    public final String getOsVersion() {
        return this.osVersion;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDeviceModel() {
        return this.deviceModel;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDeviceManufacturer() {
        return this.deviceManufacturer;
    }

    /* renamed from: component7, reason: from getter */
    public final String getDeviceType() {
        return this.deviceType;
    }

    /* renamed from: component8, reason: from getter */
    public final float getDeviceMemory() {
        return this.deviceMemory;
    }

    /* renamed from: component9, reason: from getter */
    public final Integer getViewportWidth() {
        return this.viewportWidth;
    }

    public final SigmaDeviceV2Model copy(String sdkVersion, String platform, String os, String osVersion, String deviceModel, String deviceManufacturer, String deviceType, float deviceMemory, Integer viewportWidth, Integer viewportHeight, Integer screenWidth, Integer screenHeight, float devicePixelRatio, String timeZone, int timeZoneOffset, String language, String deviceArchitecture, DeviceNetwork network, SigmaDeviceLocationModel location, Battery battery, String applicationType, String deviceContext, AndroidAttributes androidAttributes) {
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(os, "os");
        Intrinsics.checkNotNullParameter(osVersion, "osVersion");
        Intrinsics.checkNotNullParameter(deviceModel, "deviceModel");
        Intrinsics.checkNotNullParameter(deviceManufacturer, "deviceManufacturer");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(deviceArchitecture, "deviceArchitecture");
        Intrinsics.checkNotNullParameter(network, "network");
        Intrinsics.checkNotNullParameter(battery, "battery");
        Intrinsics.checkNotNullParameter(applicationType, "applicationType");
        Intrinsics.checkNotNullParameter(deviceContext, "deviceContext");
        Intrinsics.checkNotNullParameter(androidAttributes, "androidAttributes");
        return new SigmaDeviceV2Model(sdkVersion, platform, os, osVersion, deviceModel, deviceManufacturer, deviceType, deviceMemory, viewportWidth, viewportHeight, screenWidth, screenHeight, devicePixelRatio, timeZone, timeZoneOffset, language, deviceArchitecture, network, location, battery, applicationType, deviceContext, androidAttributes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SigmaDeviceV2Model)) {
            return false;
        }
        SigmaDeviceV2Model sigmaDeviceV2Model = (SigmaDeviceV2Model) other;
        return Intrinsics.areEqual(this.sdkVersion, sigmaDeviceV2Model.sdkVersion) && Intrinsics.areEqual(this.platform, sigmaDeviceV2Model.platform) && Intrinsics.areEqual(this.os, sigmaDeviceV2Model.os) && Intrinsics.areEqual(this.osVersion, sigmaDeviceV2Model.osVersion) && Intrinsics.areEqual(this.deviceModel, sigmaDeviceV2Model.deviceModel) && Intrinsics.areEqual(this.deviceManufacturer, sigmaDeviceV2Model.deviceManufacturer) && Intrinsics.areEqual(this.deviceType, sigmaDeviceV2Model.deviceType) && Float.compare(this.deviceMemory, sigmaDeviceV2Model.deviceMemory) == 0 && Intrinsics.areEqual(this.viewportWidth, sigmaDeviceV2Model.viewportWidth) && Intrinsics.areEqual(this.viewportHeight, sigmaDeviceV2Model.viewportHeight) && Intrinsics.areEqual(this.screenWidth, sigmaDeviceV2Model.screenWidth) && Intrinsics.areEqual(this.screenHeight, sigmaDeviceV2Model.screenHeight) && Float.compare(this.devicePixelRatio, sigmaDeviceV2Model.devicePixelRatio) == 0 && Intrinsics.areEqual(this.timeZone, sigmaDeviceV2Model.timeZone) && this.timeZoneOffset == sigmaDeviceV2Model.timeZoneOffset && Intrinsics.areEqual(this.language, sigmaDeviceV2Model.language) && Intrinsics.areEqual(this.deviceArchitecture, sigmaDeviceV2Model.deviceArchitecture) && Intrinsics.areEqual(this.network, sigmaDeviceV2Model.network) && Intrinsics.areEqual(this.location, sigmaDeviceV2Model.location) && Intrinsics.areEqual(this.battery, sigmaDeviceV2Model.battery) && Intrinsics.areEqual(this.applicationType, sigmaDeviceV2Model.applicationType) && Intrinsics.areEqual(this.deviceContext, sigmaDeviceV2Model.deviceContext) && Intrinsics.areEqual(this.androidAttributes, sigmaDeviceV2Model.androidAttributes);
    }

    public final AndroidAttributes getAndroidAttributes() {
        return this.androidAttributes;
    }

    public final String getApplicationType() {
        return this.applicationType;
    }

    public final Battery getBattery() {
        return this.battery;
    }

    public final String getDeviceArchitecture() {
        return this.deviceArchitecture;
    }

    public final String getDeviceContext() {
        return this.deviceContext;
    }

    public final String getDeviceManufacturer() {
        return this.deviceManufacturer;
    }

    public final float getDeviceMemory() {
        return this.deviceMemory;
    }

    public final String getDeviceModel() {
        return this.deviceModel;
    }

    public final float getDevicePixelRatio() {
        return this.devicePixelRatio;
    }

    public final String getDeviceType() {
        return this.deviceType;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final SigmaDeviceLocationModel getLocation() {
        return this.location;
    }

    public final DeviceNetwork getNetwork() {
        return this.network;
    }

    public final String getOs() {
        return this.os;
    }

    public final String getOsVersion() {
        return this.osVersion;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final Integer getScreenHeight() {
        return this.screenHeight;
    }

    public final Integer getScreenWidth() {
        return this.screenWidth;
    }

    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    public final String getTimeZone() {
        return this.timeZone;
    }

    public final int getTimeZoneOffset() {
        return this.timeZoneOffset;
    }

    public final Integer getViewportHeight() {
        return this.viewportHeight;
    }

    public final Integer getViewportWidth() {
        return this.viewportWidth;
    }

    public int hashCode() {
        int hashCode = (Float.hashCode(this.deviceMemory) + ((this.deviceType.hashCode() + ((this.deviceManufacturer.hashCode() + ((this.deviceModel.hashCode() + ((this.osVersion.hashCode() + ((this.os.hashCode() + ((this.platform.hashCode() + (this.sdkVersion.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        Integer num = this.viewportWidth;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.viewportHeight;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.screenWidth;
        int hashCode4 = (hashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.screenHeight;
        int hashCode5 = (this.network.hashCode() + ((this.deviceArchitecture.hashCode() + ((this.language.hashCode() + ((Integer.hashCode(this.timeZoneOffset) + ((this.timeZone.hashCode() + ((Float.hashCode(this.devicePixelRatio) + ((hashCode4 + (num4 == null ? 0 : num4.hashCode())) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        SigmaDeviceLocationModel sigmaDeviceLocationModel = this.location;
        return this.androidAttributes.hashCode() + ((this.deviceContext.hashCode() + ((this.applicationType.hashCode() + ((this.battery.hashCode() + ((hashCode5 + (sigmaDeviceLocationModel != null ? sigmaDeviceLocationModel.hashCode() : 0)) * 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        return "SigmaDeviceV2Model(sdkVersion=" + this.sdkVersion + ", platform=" + this.platform + ", os=" + this.os + ", osVersion=" + this.osVersion + ", deviceModel=" + this.deviceModel + ", deviceManufacturer=" + this.deviceManufacturer + ", deviceType=" + this.deviceType + ", deviceMemory=" + this.deviceMemory + ", viewportWidth=" + this.viewportWidth + ", viewportHeight=" + this.viewportHeight + ", screenWidth=" + this.screenWidth + ", screenHeight=" + this.screenHeight + ", devicePixelRatio=" + this.devicePixelRatio + ", timeZone=" + this.timeZone + ", timeZoneOffset=" + this.timeZoneOffset + ", language=" + this.language + ", deviceArchitecture=" + this.deviceArchitecture + ", network=" + this.network + ", location=" + this.location + ", battery=" + this.battery + ", applicationType=" + this.applicationType + ", deviceContext=" + this.deviceContext + ", androidAttributes=" + this.androidAttributes + ")";
    }

    public /* synthetic */ SigmaDeviceV2Model(String str, String str2, String str3, String str4, String str5, String str6, String str7, float f, Integer num, Integer num2, Integer num3, Integer num4, float f2, String str8, int i, String str9, String str10, DeviceNetwork deviceNetwork, SigmaDeviceLocationModel sigmaDeviceLocationModel, Battery battery, String str11, String str12, AndroidAttributes androidAttributes, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? AndroidContextProvider.OS_NAME : str2, (i2 & 4) != 0 ? AndroidContextProvider.OS_NAME : str3, str4, str5, str6, str7, f, (i2 & 256) != 0 ? null : num, (i2 & 512) != 0 ? null : num2, (i2 & 1024) != 0 ? null : num3, (i2 & 2048) != 0 ? null : num4, f2, str8, i, str9, str10, deviceNetwork, (i2 & 262144) != 0 ? null : sigmaDeviceLocationModel, battery, str11, str12, androidAttributes);
    }
}
