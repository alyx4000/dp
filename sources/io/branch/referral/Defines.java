package io.branch.referral;

import com.amplitude.reactnative.AndroidContextProvider;
import com.amplitude.reactnative.DatabaseConstants;
import com.facebook.react.animated.InterpolationAnimatedNode;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.messaging.Constants;
import com.iterable.iterableapi.IterableConstants;
import com.socure.docv.capturesdk.api.Keys;
import io.sentry.ProfilingTraceData;
import io.sentry.SentryEnvelopeItemHeader;
import io.sentry.Session;
import io.sentry.protocol.App;
import io.sentry.protocol.Device;
import io.sentry.protocol.Gpu;
import io.sentry.protocol.OperatingSystem;
import sdk.pendo.io.actions.configurations.GuideTransition;
import sdk.pendo.io.network.responses.KillSwitchModel;

/* loaded from: classes2.dex */
public class Defines {

    public enum Jsonkey {
        RandomizedBundleToken("randomized_bundle_token"),
        Identity(InterpolationAnimatedNode.EXTRAPOLATE_TYPE_IDENTITY),
        RandomizedDeviceToken("randomized_device_token"),
        SessionID(Keys.KEY_SESSION_ID),
        LinkClickID("link_click_id"),
        GoogleSearchInstallReferrer("google_search_install_referrer"),
        GooglePlayInstallReferrer("install_referrer_extras"),
        ClickedReferrerTimeStamp("clicked_referrer_ts"),
        Gclid("gclid"),
        IsDeeplinkGclid("is_deeplink_gclid"),
        ReferrerGclid("referrer_gclid"),
        ReferringUrlQueryParameters("bnc_referringUrlQueryParameters"),
        InstallBeginTimeStamp("install_begin_ts"),
        BranchLinkUsed("branch_used"),
        ReferringBranchIdentity("referring_branch_identity"),
        BranchIdentity("branch_identity"),
        BranchKey("branch_key"),
        BranchData("branch_data"),
        PlayAutoInstalls("play-auto-installs"),
        UTMCampaign("utm_campaign"),
        UTMMedium("utm_medium"),
        InitialReferrer("initial_referrer"),
        Bucket("bucket"),
        DefaultBucket("default"),
        Amount("amount"),
        CalculationType("calculation_type"),
        Location(IterableConstants.ITERABLE_IN_APP_LOCATION),
        Type("type"),
        CreationSource("creation_source"),
        Prefix("prefix"),
        Expiration(KillSwitchModel.KILL_SWITCH_EXPIRATION),
        Event("event"),
        Metadata("metadata"),
        CommerceData("commerce_data"),
        Total(IterableConstants.KEY_TOTAL),
        Unique("unique"),
        Length(SentryEnvelopeItemHeader.JsonKeys.LENGTH),
        Direction(GuideTransition.GUIDE_TRANSITION_DIRECTION_FIELD),
        BeginAfterID("begin_after_id"),
        Link("link"),
        ReferringData("referring_data"),
        ReferringLink("referring_link"),
        IsFullAppConv("is_full_app_conversion"),
        Data("data"),
        OS(OperatingSystem.TYPE),
        HardwareID("hardware_id"),
        AndroidID("android_id"),
        UnidentifiedDevice("unidentified_device"),
        HardwareIDType("hardware_id_type"),
        HardwareIDTypeVendor(Gpu.JsonKeys.VENDOR_ID),
        HardwareIDTypeRandom("random"),
        IsHardwareIDReal("is_hardware_id_real"),
        AnonID("anon_id"),
        AppVersion(App.JsonKeys.APP_VERSION),
        APILevel("os_version"),
        Country("country"),
        Language("language"),
        Update("update"),
        OriginalInstallTime("first_install_time"),
        FirstInstallTime("latest_install_time"),
        LastUpdateTime("latest_update_time"),
        PreviousUpdateTime("previous_update_time"),
        URIScheme("uri_scheme"),
        AppLinks("app_links"),
        AppIdentifier(App.JsonKeys.APP_IDENTIFIER),
        LinkIdentifier("link_identifier"),
        GoogleAdvertisingID("google_advertising_id"),
        AAID("aaid"),
        FireAdId("fire_ad_id"),
        OpenAdvertisingID("oaid"),
        LATVal("lat_val"),
        LimitedAdTracking(AndroidContextProvider.SETTING_LIMIT_AD_TRACKING),
        limitFacebookTracking("limit_facebook_tracking"),
        Debug(external.sdk.pendo.io.daimajia.BuildConfig.BUILD_TYPE),
        Brand("brand"),
        Model("model"),
        ScreenDpi(Device.JsonKeys.SCREEN_DPI),
        ScreenHeight("screen_height"),
        ScreenWidth("screen_width"),
        WiFi("wifi"),
        LocalIP("local_ip"),
        UserData("user_data"),
        AdvertisingIDs("advertising_ids"),
        DeveloperIdentity("developer_identity"),
        UserAgent(Session.JsonKeys.USER_AGENT),
        SDK("sdk"),
        SdkVersion(Keys.KEY_SDK_VERSION),
        UIMode("ui_mode"),
        InstallMetadata("install_metadata"),
        LATDAttributionWindow("attribution_window"),
        Clicked_Branch_Link("+clicked_branch_link"),
        IsFirstSession("+is_first_session"),
        AndroidDeepLinkPath("$android_deeplink_path"),
        DeepLinkPath(Branch.DEEPLINK_PATH),
        AndroidAppLinkURL("android_app_link_url"),
        AndroidPushNotificationKey("branch"),
        AndroidPushIdentifier("push_identifier"),
        CanonicalIdentifier("$canonical_identifier"),
        ContentTitle(Branch.OG_TITLE),
        ContentDesc(Branch.OG_DESC),
        ContentImgUrl(Branch.OG_IMAGE_URL),
        CanonicalUrl("$canonical_url"),
        ContentType("$content_type"),
        PublicallyIndexable("$publicly_indexable"),
        LocallyIndexable("$locally_indexable"),
        ContentKeyWords("$keywords"),
        ContentExpiryTime("$exp_date"),
        Params("params"),
        SharedLink("$shared_link"),
        ShareError("$share_error"),
        SharedChannel("$shared_channel"),
        URLSource(AndroidContextProvider.OS_NAME),
        External_Intent_URI("external_intent_uri"),
        External_Intent_Extra("external_intent_extra"),
        Last_Round_Trip_Time("lrtt"),
        Branch_Round_Trip_Time("brtt"),
        Branch_Instrumentation("instrumentation"),
        Queue_Wait_Time("qwt"),
        InstantDeepLinkSession("instant_dl_session"),
        Path("path"),
        ViewList("view_list"),
        ContentActionView("view"),
        ContentPath("content_path"),
        ContentNavPath("content_nav_path"),
        ReferralLink("referral_link"),
        ContentData("content_data"),
        ContentEvents(DatabaseConstants.EVENT_TABLE_NAME),
        ContentAnalyticsMode("content_analytics_mode"),
        Environment("environment"),
        InstantApp("INSTANT_APP"),
        NativeApp("FULL_APP"),
        CustomerEventAlias("customer_event_alias"),
        TransactionID(ProfilingTraceData.JsonKeys.TRANSACTION_ID),
        Currency("currency"),
        Revenue("revenue"),
        Shipping("shipping"),
        Tax("tax"),
        Coupon("coupon"),
        Affiliation("affiliation"),
        Description("description"),
        SearchQuery("search_query"),
        AdType("ad_type"),
        CPUType("cpu_type"),
        DeviceBuildId(OperatingSystem.JsonKeys.BUILD),
        Locale("locale"),
        ConnectionType(Device.JsonKeys.CONNECTION_TYPE),
        DeviceCarrier("device_carrier"),
        PluginName("plugin_name"),
        PluginVersion("plugin_version"),
        OSVersionAndroid("os_version_android"),
        Name("name"),
        CustomData("custom_data"),
        EventData("event_data"),
        ContentItems("content_items"),
        ContentSchema("$content_schema"),
        Price("$price"),
        PriceCurrency("$currency"),
        Quantity("$quantity"),
        SKU("$sku"),
        ProductName("$product_name"),
        ProductBrand("$product_brand"),
        ProductCategory("$product_category"),
        ProductVariant("$product_variant"),
        Rating("$rating"),
        RatingAverage("$rating_average"),
        RatingCount("$rating_count"),
        RatingMax("$rating_max"),
        AddressStreet("$address_street"),
        AddressCity("$address_city"),
        AddressRegion("$address_region"),
        AddressCountry("$address_country"),
        AddressPostalCode("$address_postal_code"),
        Latitude("$latitude"),
        Longitude("$longitude"),
        ImageCaptions("$image_captions"),
        Condition("$condition"),
        CreationTimestamp("$creation_timestamp"),
        TrackingDisabled("tracking_disabled"),
        DisableAdNetworkCallouts("disable_ad_network_callouts"),
        PartnerData("partner_data"),
        Instant("instant"),
        QRCodeTag("qr-code"),
        CodeColor("code_color"),
        BackgroundColor("background_color"),
        Width("width"),
        Margin(ViewProps.MARGIN),
        ImageFormat("image_format"),
        CenterLogo("center_logo_url"),
        QRCodeSettings("qr_code_settings"),
        QRCodeData("data"),
        QRCodeBranchKey("branch_key"),
        QRCodeResponseString("QRCodeString"),
        App_Store("app_store"),
        Google_Play_Store("PlayStore"),
        Huawei_App_Gallery("AppGallery"),
        Samsung_Galaxy_Store("GalaxyStore"),
        Xiaomi_Get_Apps("GetApps"),
        DMA_EEA("dma_eea"),
        DMA_Ad_Personalization("dma_ad_personalization"),
        DMA_Ad_User_Data("dma_ad_user_data");

        private final String key;

        Jsonkey(String str) {
            this.key = str;
        }

        public String getKey() {
            return this.key;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.key;
        }
    }

    public enum RequestPath {
        GetURL("v1/url"),
        GetApp("v1/app-link-settings"),
        RegisterInstall("v1/install"),
        RegisterOpen("v1/open"),
        ContentEvent("v1/content-events"),
        TrackStandardEvent("v2/event/standard"),
        TrackCustomEvent("v2/event/custom"),
        GetLATD("v1/cpid/latd"),
        QRCode("v1/qr-code");

        private final String key;

        RequestPath(String str) {
            this.key = str;
        }

        public String getPath() {
            return this.key;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.key;
        }
    }

    public enum LinkParam {
        Tags("tags"),
        Alias("alias"),
        Type("type"),
        Duration("duration"),
        Channel("channel"),
        Feature("feature"),
        Stage("stage"),
        Campaign(Constants.ScionAnalytics.PARAM_CAMPAIGN),
        Data("data"),
        URL("url");

        private final String key;

        LinkParam(String str) {
            this.key = str;
        }

        public String getKey() {
            return this.key;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.key;
        }
    }

    public enum PreinstallKey {
        campaign("preinstall_campaign"),
        partner("preinstall_partner");

        private final String key;

        PreinstallKey(String str) {
            this.key = str;
        }

        public String getKey() {
            return this.key;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.key;
        }
    }

    public enum IntentKeys {
        BranchData("branch_data"),
        ForceNewBranchSession("branch_force_new_session"),
        BranchLinkUsed("branch_used"),
        BranchURI("branch"),
        AutoDeepLinked("io.branch.sdk.auto_linked");

        private final String key;

        IntentKeys(String str) {
            this.key = str;
        }

        public String getKey() {
            return this.key;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.key;
        }
    }

    public enum HeaderKey {
        RequestId("X-Branch-Request-Id"),
        SendCloseRequest("X-Branch-Send-Close-Request");

        private final String key;

        HeaderKey(String str) {
            this.key = str;
        }

        public String getKey() {
            return this.key;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.key;
        }
    }
}
