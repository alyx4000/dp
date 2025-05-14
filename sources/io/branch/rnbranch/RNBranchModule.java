package io.branch.rnbranch;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.util.Base64;
import android.util.Log;
import androidx.autofill.HintConstants;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.messaging.Constants;
import io.branch.indexing.BranchUniversalObject;
import io.branch.referral.Branch;
import io.branch.referral.BranchError;
import io.branch.referral.QRCode.BranchQRCode;
import io.branch.referral.ServerRequestGetLATD;
import io.branch.referral.SharingHelper;
import io.branch.referral.util.BRANCH_STANDARD_EVENT;
import io.branch.referral.util.BranchContentSchema;
import io.branch.referral.util.BranchEvent;
import io.branch.referral.util.ContentMetadata;
import io.branch.referral.util.CurrencyType;
import io.branch.referral.util.LinkProperties;
import io.branch.referral.util.ProductCategory;
import io.branch.referral.util.ShareSheetStyle;
import io.sentry.clientreport.DiscardedEvent;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ReactModule(name = "RNBranch")
/* loaded from: classes2.dex */
public class RNBranchModule extends ReactContextBaseJavaModule {
    private static final long AGING_HASH_TTL = 3600000;
    public static final String GENERIC_ERROR = "RNBranch::Error";
    private static final String IDENT_FIELD_NAME = "ident";
    private static final String INIT_SESSION_ERROR = "INIT_SESSION_ERROR";
    private static final String INIT_SESSION_START = "INIT_SESSION_START";
    private static final String INIT_SESSION_SUCCESS = "INIT_SESSION_SUCCESS";
    public static final String NAME = "RNBranch";
    public static final String NATIVE_INIT_SESSION_FINISHED_EVENT = "io.branch.rnbranch.RNBranchModule.onInitSessionFinished";
    public static final String NATIVE_INIT_SESSION_FINISHED_EVENT_BRANCH_UNIVERSAL_OBJECT = "branch_universal_object";
    public static final String NATIVE_INIT_SESSION_FINISHED_EVENT_ERROR = "error";
    public static final String NATIVE_INIT_SESSION_FINISHED_EVENT_LINK_PROPERTIES = "link_properties";
    public static final String NATIVE_INIT_SESSION_FINISHED_EVENT_PARAMS = "params";
    public static final String NATIVE_INIT_SESSION_FINISHED_EVENT_URI = "uri";
    public static final String NATIVE_INIT_SESSION_STARTED_EVENT = "io.branch.rnbranch.RNBranchModule.onInitSessionStarted";
    public static final String NATIVE_INIT_SESSION_STARTED_EVENT_URI = "uri";
    private static final String PLUGIN_NAME = "ReactNative";
    public static final String REACT_CLASS = "RNBranch";
    private static final String RN_INIT_SESSION_ERROR_EVENT = "RNBranch.initSessionError";
    private static final String RN_INIT_SESSION_START_EVENT = "RNBranch.initSessionStart";
    private static final String RN_INIT_SESSION_SUCCESS_EVENT = "RNBranch.initSessionSuccess";
    private static final String STANDARD_EVENT_ACHIEVE_LEVEL = "STANDARD_EVENT_ACHIEVE_LEVEL";
    private static final String STANDARD_EVENT_ADD_PAYMENT_INFO = "STANDARD_EVENT_ADD_PAYMENT_INFO";
    private static final String STANDARD_EVENT_ADD_TO_CART = "STANDARD_EVENT_ADD_TO_CART";
    private static final String STANDARD_EVENT_ADD_TO_WISHLIST = "STANDARD_EVENT_ADD_TO_WISHLIST";
    private static final String STANDARD_EVENT_CLICK_AD = "STANDARD_EVENT_CLICK_AD";
    private static final String STANDARD_EVENT_COMPLETE_REGISTRATION = "STANDARD_EVENT_COMPLETE_REGISTRATION";
    private static final String STANDARD_EVENT_COMPLETE_TUTORIAL = "STANDARD_EVENT_COMPLETE_TUTORIAL";
    private static final String STANDARD_EVENT_INITIATE_PURCHASE = "STANDARD_EVENT_INITIATE_PURCHASE";
    private static final String STANDARD_EVENT_INVITE = "STANDARD_EVENT_INVITE";
    private static final String STANDARD_EVENT_LOGIN = "STANDARD_EVENT_LOGIN";
    private static final String STANDARD_EVENT_PURCHASE = "STANDARD_EVENT_PURCHASE";
    private static final String STANDARD_EVENT_RATE = "STANDARD_EVENT_RATE";
    private static final String STANDARD_EVENT_RESERVE = "STANDARD_EVENT_RESERVE";
    private static final String STANDARD_EVENT_SEARCH = "STANDARD_EVENT_SEARCH";
    private static final String STANDARD_EVENT_SHARE = "STANDARD_EVENT_SHARE";
    private static final String STANDARD_EVENT_START_TRIAL = "STANDARD_EVENT_START_TRIAL";
    private static final String STANDARD_EVENT_SUBSCRIBE = "STANDARD_EVENT_SUBSCRIBE";
    private static final String STANDARD_EVENT_UNLOCK_ACHIEVEMENT = "STANDARD_EVENT_UNLOCK_ACHIEVEMENT";
    private static final String STANDARD_EVENT_VIEW_AD = "STANDARD_EVENT_VIEW_AD";
    private static final String STANDARD_EVENT_VIEW_CART = "STANDARD_EVENT_VIEW_CART";
    private static final String STANDARD_EVENT_VIEW_ITEM = "STANDARD_EVENT_VIEW_ITEM";
    private static final String STANDARD_EVENT_VIEW_ITEMS = "STANDARD_EVENT_VIEW_ITEMS";
    public static final String UNIVERSAL_OBJECT_NOT_FOUND_ERROR_CODE = "RNBranch::Error::BUONotFound";
    private static Branch.BranchUniversalReferralInitListener initListener = null;
    private static JSONObject initSessionResult = null;
    private static Activity mActivity = null;
    private static boolean mInitialized = false;
    private static volatile boolean mNewIntent = true;
    private static JSONObject mRequestMetadata = new JSONObject();
    private static Branch.BranchReferralInitListener referralInitListener = null;
    private BroadcastReceiver mInitSessionFinishedEventReceiver;
    private BroadcastReceiver mInitSessionStartedEventReceiver;
    private AgingHash<String, BranchUniversalObject> mUniversalObjectMap;

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNBranch";
    }

    public static void getAutoInstance(Context context) {
        Branch.registerPlugin("ReactNative", BuildConfig.RNBRANCH_VERSION);
        Branch.getAutoInstance(context);
    }

    public static void reInitSession(Activity activity) {
        Branch.getInstance();
        Intent intent = activity.getIntent();
        Log.d("RNBranch", "reInitSession intent " + intent);
        if (intent != null) {
            intent.putExtra("branch_force_new_session", true);
            notifyJSOfInitSessionStart(activity, intent.getData());
            Branch.sessionBuilder(activity).withCallback(referralInitListener).reInit();
            return;
        }
        Log.w("RNBranch", "reInitSession was called but the Intent is null");
    }

    public static void initSession(Uri uri, Activity activity, Branch.BranchUniversalReferralInitListener branchUniversalReferralInitListener) {
        Log.d("RNBranch", "initSession uri " + uri + " reactActivity " + activity + " anInitListener" + branchUniversalReferralInitListener);
        initListener = branchUniversalReferralInitListener;
        initSession(uri, activity);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [io.branch.rnbranch.RNBranchModule$1] */
    public static void initSession(final Uri uri, Activity activity) {
        Log.d("RNBranch", "initSession uri " + uri + " reactActivity " + activity);
        setupBranch(activity.getApplicationContext());
        mActivity = activity;
        final boolean z = mNewIntent;
        referralInitListener = new Branch.BranchReferralInitListener() { // from class: io.branch.rnbranch.RNBranchModule.1
            private Activity mmActivity = null;

            @Override // io.branch.referral.Branch.BranchReferralInitListener
            public void onInitFinished(JSONObject jSONObject, BranchError branchError) {
                Uri uri2;
                Log.d("RNBranch", "onInitFinished referringParams " + jSONObject);
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                JSONObject jSONObject2 = jSONObject;
                Log.d("RNBranch", "onInitFinished");
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("params", jSONObject2);
                    jSONObject3.put("error", branchError != null ? branchError.getMessage() : JSONObject.NULL);
                    jSONObject3.put("uri", (!z || (uri2 = uri) == null) ? JSONObject.NULL : uri2.toString());
                } catch (JSONException e) {
                    Log.e("RNBranch", e.getMessage());
                }
                RNBranchModule.initSessionResult = jSONObject3;
                BranchUniversalObject referredBranchUniversalObject = BranchUniversalObject.getReferredBranchUniversalObject();
                LinkProperties referredLinkProperties = LinkProperties.getReferredLinkProperties();
                if (RNBranchModule.initListener != null) {
                    Log.d("RNBranch", "onInitFinished " + referredBranchUniversalObject + " " + referredLinkProperties + " error " + branchError);
                    RNBranchModule.initListener.onInitFinished(referredBranchUniversalObject, referredLinkProperties, branchError);
                }
                generateLocalBroadcast(jSONObject2, uri, referredBranchUniversalObject, referredLinkProperties, branchError);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public Branch.BranchReferralInitListener init(Activity activity2) {
                this.mmActivity = activity2;
                return this;
            }

            private void generateLocalBroadcast(JSONObject jSONObject, Uri uri2, BranchUniversalObject branchUniversalObject, LinkProperties linkProperties, BranchError branchError) {
                Intent intent = new Intent(RNBranchModule.NATIVE_INIT_SESSION_FINISHED_EVENT);
                if (jSONObject != null) {
                    intent.putExtra("params", jSONObject.toString());
                }
                if (branchUniversalObject != null) {
                    intent.putExtra(RNBranchModule.NATIVE_INIT_SESSION_FINISHED_EVENT_BRANCH_UNIVERSAL_OBJECT, branchUniversalObject);
                }
                if (linkProperties != null) {
                    intent.putExtra(RNBranchModule.NATIVE_INIT_SESSION_FINISHED_EVENT_LINK_PROPERTIES, linkProperties);
                }
                if (z && uri2 != null) {
                    intent.putExtra("uri", uri2.toString());
                }
                if (branchError != null) {
                    intent.putExtra("error", branchError.getMessage());
                }
                LocalBroadcastManager.getInstance(this.mmActivity).sendBroadcast(intent);
            }
        }.init(activity);
        notifyJSOfInitSessionStart(activity, uri);
        Branch.InitSessionBuilder withData = Branch.sessionBuilder(activity).withCallback(referralInitListener).withData(uri);
        Log.d("RNBranch", "sessionBuilder " + withData);
        withData.init();
    }

    public static void onNewIntent(@Nonnull Intent intent) {
        Log.d("RNBranch", "onNewIntent " + intent);
        mActivity.setIntent(intent);
        mNewIntent = true;
        reInitSession(mActivity);
    }

    private static void notifyJSOfInitSessionStart(Context context, Uri uri) {
        Log.d("RNBranch", "notifyJSOfInitSessionStart  " + uri);
        if (mNewIntent) {
            mNewIntent = false;
            Intent intent = new Intent(NATIVE_INIT_SESSION_STARTED_EVENT);
            if (uri != null) {
                intent.putExtra("uri", uri);
            }
            Log.d("RNBranch", "Broadcasting NATIVE_INIT_SESSION_STARTED_EVENT");
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        }
    }

    public static void enableLogging() {
        Branch.enableLogging();
    }

    public static void setRequestMetadata(String str, String str2) {
        if (str == null) {
            return;
        }
        if (mRequestMetadata.has(str) && str2 == null) {
            mRequestMetadata.remove(str);
        }
        try {
            mRequestMetadata.put(str, str2);
        } catch (JSONException unused) {
        }
    }

    public RNBranchModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mInitSessionFinishedEventReceiver = null;
        this.mInitSessionStartedEventReceiver = null;
        this.mUniversalObjectMap = new AgingHash<>(3600000L);
        listenForInitSessionEventsToReactNative(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    @Nullable
    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put(INIT_SESSION_SUCCESS, RN_INIT_SESSION_SUCCESS_EVENT);
        hashMap.put(INIT_SESSION_ERROR, RN_INIT_SESSION_ERROR_EVENT);
        hashMap.put(INIT_SESSION_START, RN_INIT_SESSION_START_EVENT);
        hashMap.put(STANDARD_EVENT_ADD_TO_CART, BRANCH_STANDARD_EVENT.ADD_TO_CART.getName());
        hashMap.put(STANDARD_EVENT_ADD_TO_WISHLIST, BRANCH_STANDARD_EVENT.ADD_TO_WISHLIST.getName());
        hashMap.put(STANDARD_EVENT_VIEW_CART, BRANCH_STANDARD_EVENT.VIEW_CART.getName());
        hashMap.put(STANDARD_EVENT_INITIATE_PURCHASE, BRANCH_STANDARD_EVENT.INITIATE_PURCHASE.getName());
        hashMap.put(STANDARD_EVENT_ADD_PAYMENT_INFO, BRANCH_STANDARD_EVENT.ADD_PAYMENT_INFO.getName());
        hashMap.put(STANDARD_EVENT_PURCHASE, BRANCH_STANDARD_EVENT.PURCHASE.getName());
        hashMap.put(STANDARD_EVENT_VIEW_AD, BRANCH_STANDARD_EVENT.VIEW_AD.getName());
        hashMap.put(STANDARD_EVENT_CLICK_AD, BRANCH_STANDARD_EVENT.CLICK_AD.getName());
        hashMap.put(STANDARD_EVENT_SEARCH, BRANCH_STANDARD_EVENT.SEARCH.getName());
        hashMap.put(STANDARD_EVENT_VIEW_ITEM, BRANCH_STANDARD_EVENT.VIEW_ITEM.getName());
        hashMap.put(STANDARD_EVENT_VIEW_ITEMS, BRANCH_STANDARD_EVENT.VIEW_ITEMS.getName());
        hashMap.put(STANDARD_EVENT_RATE, BRANCH_STANDARD_EVENT.RATE.getName());
        hashMap.put(STANDARD_EVENT_SHARE, BRANCH_STANDARD_EVENT.SHARE.getName());
        hashMap.put(STANDARD_EVENT_COMPLETE_REGISTRATION, BRANCH_STANDARD_EVENT.COMPLETE_REGISTRATION.getName());
        hashMap.put(STANDARD_EVENT_COMPLETE_TUTORIAL, BRANCH_STANDARD_EVENT.COMPLETE_TUTORIAL.getName());
        hashMap.put(STANDARD_EVENT_ACHIEVE_LEVEL, BRANCH_STANDARD_EVENT.ACHIEVE_LEVEL.getName());
        hashMap.put(STANDARD_EVENT_UNLOCK_ACHIEVEMENT, BRANCH_STANDARD_EVENT.UNLOCK_ACHIEVEMENT.getName());
        hashMap.put(STANDARD_EVENT_INVITE, BRANCH_STANDARD_EVENT.INVITE.getName());
        hashMap.put(STANDARD_EVENT_LOGIN, BRANCH_STANDARD_EVENT.LOGIN.getName());
        hashMap.put(STANDARD_EVENT_RESERVE, BRANCH_STANDARD_EVENT.RESERVE.getName());
        hashMap.put(STANDARD_EVENT_SUBSCRIBE, BRANCH_STANDARD_EVENT.SUBSCRIBE.getName());
        hashMap.put(STANDARD_EVENT_START_TRIAL, BRANCH_STANDARD_EVENT.START_TRIAL.getName());
        return hashMap;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [io.branch.rnbranch.RNBranchModule$2] */
    /* JADX WARN: Type inference failed for: r0v3, types: [io.branch.rnbranch.RNBranchModule$3] */
    private void listenForInitSessionEventsToReactNative(ReactApplicationContext reactApplicationContext) {
        this.mInitSessionFinishedEventReceiver = new BroadcastReceiver() { // from class: io.branch.rnbranch.RNBranchModule.2
            RNBranchModule mBranchModule;

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                this.mBranchModule.sendRNEvent(RNBranchModule.initSessionResult.has("error") && !RNBranchModule.initSessionResult.isNull("error") ? RNBranchModule.RN_INIT_SESSION_ERROR_EVENT : RNBranchModule.RN_INIT_SESSION_SUCCESS_EVENT, RNBranchModule.convertJsonToMap(RNBranchModule.initSessionResult));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public BroadcastReceiver init(RNBranchModule rNBranchModule) {
                this.mBranchModule = rNBranchModule;
                return this;
            }
        }.init(this);
        LocalBroadcastManager.getInstance(reactApplicationContext).registerReceiver(this.mInitSessionFinishedEventReceiver, new IntentFilter(NATIVE_INIT_SESSION_FINISHED_EVENT));
        this.mInitSessionStartedEventReceiver = new BroadcastReceiver() { // from class: io.branch.rnbranch.RNBranchModule.3
            RNBranchModule mBranchModule;

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Uri uri = (Uri) intent.getParcelableExtra("uri");
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                if (uri != null) {
                    writableNativeMap.putString("uri", uri.toString());
                } else {
                    writableNativeMap.putNull("uri");
                }
                this.mBranchModule.sendRNEvent(RNBranchModule.RN_INIT_SESSION_START_EVENT, writableNativeMap);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public BroadcastReceiver init(RNBranchModule rNBranchModule) {
                this.mBranchModule = rNBranchModule;
                return this;
            }
        }.init(this);
        LocalBroadcastManager.getInstance(reactApplicationContext).registerReceiver(this.mInitSessionStartedEventReceiver, new IntentFilter(NATIVE_INIT_SESSION_STARTED_EVENT));
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void onCatalystInstanceDestroy() {
        Log.d("RNBranch", "onCatalystInstanceDestroy ");
        LocalBroadcastManager.getInstance(getReactApplicationContext()).unregisterReceiver(this.mInitSessionFinishedEventReceiver);
        LocalBroadcastManager.getInstance(getReactApplicationContext()).unregisterReceiver(this.mInitSessionStartedEventReceiver);
    }

    @ReactMethod
    public void notifyNativeToInit() {
        Log.d("RNBranch", "notifyNativeToInit");
        Branch.notifyNativeToInit();
    }

    @ReactMethod
    public void disableTracking(boolean z) {
        Branch.getInstance().disableTracking(z);
    }

    @ReactMethod
    public void isTrackingDisabled(Promise promise) {
        promise.resolve(Boolean.valueOf(Branch.getInstance().isTrackingDisabled()));
    }

    @ReactMethod
    public void createUniversalObject(ReadableMap readableMap, Promise promise) {
        String uuid = UUID.randomUUID().toString();
        this.mUniversalObjectMap.put(uuid, createBranchUniversalObject(readableMap));
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString(IDENT_FIELD_NAME, uuid);
        promise.resolve(writableNativeMap);
    }

    @ReactMethod
    public void releaseUniversalObject(String str) {
        this.mUniversalObjectMap.remove(str);
    }

    @ReactMethod
    public void redeemInitSessionResult(Promise promise) {
        promise.resolve(convertJsonToMap(initSessionResult));
    }

    @ReactMethod
    public void getLatestReferringParams(boolean z, Promise promise) {
        Branch branch = Branch.getInstance();
        if (z) {
            promise.resolve(convertJsonToMap(branch.getLatestReferringParamsSync()));
        } else {
            promise.resolve(convertJsonToMap(branch.getLatestReferringParams()));
        }
    }

    @ReactMethod
    public void getFirstReferringParams(Promise promise) {
        promise.resolve(convertJsonToMap(Branch.getInstance().getFirstReferringParams()));
    }

    @ReactMethod
    public void lastAttributedTouchData(int i, final Promise promise) {
        Branch.getInstance().getLastAttributedTouchData(new ServerRequestGetLATD.BranchLastAttributedTouchDataListener() { // from class: io.branch.rnbranch.RNBranchModule.4
            @Override // io.branch.referral.ServerRequestGetLATD.BranchLastAttributedTouchDataListener
            public void onDataFetched(JSONObject jSONObject, BranchError branchError) {
                if (branchError == null) {
                    promise.resolve(RNBranchModule.convertJsonToMap(jSONObject));
                } else {
                    promise.reject(RNBranchModule.GENERIC_ERROR, branchError.getMessage());
                }
            }
        }, i);
    }

    @ReactMethod
    public void setIdentity(String str) {
        Branch.getInstance().setIdentity(str);
    }

    @ReactMethod
    public void setIdentityAsync(String str, final Promise promise) {
        Branch.getInstance().setIdentity(str, new Branch.BranchReferralInitListener() { // from class: io.branch.rnbranch.RNBranchModule.5
            @Override // io.branch.referral.Branch.BranchReferralInitListener
            public void onInitFinished(JSONObject jSONObject, BranchError branchError) {
                if (branchError != null) {
                    promise.reject("RNBranch::Error::setIdentityAsync failed", branchError.getMessage());
                } else {
                    promise.resolve(RNBranchModule.convertJsonToMap(jSONObject));
                }
            }
        });
    }

    @ReactMethod
    public void setRequestMetadataKey(String str, String str2) {
        Branch.getInstance().setRequestMetadata(str, str2);
    }

    @ReactMethod
    public void addFacebookPartnerParameter(String str, String str2) {
        Branch.getInstance().addFacebookPartnerParameterWithName(str, str2);
    }

    @ReactMethod
    public void addSnapPartnerParameter(String str, String str2) {
        Branch.getInstance().addSnapPartnerParameterWithName(str, str2);
    }

    @ReactMethod
    public void clearPartnerParameters() {
        Branch.getInstance().clearPartnerParameters();
    }

    @ReactMethod
    public void logout() {
        Branch.getInstance().logout();
    }

    @ReactMethod
    public static void setPreinstallCampaign(String str) {
        Branch.getInstance().setPreinstallCampaign(str);
    }

    @ReactMethod
    public static void setPreinstallPartner(String str) {
        Branch.getInstance().setPreinstallPartner(str);
    }

    @ReactMethod
    public void logEvent(ReadableArray readableArray, String str, ReadableMap readableMap, Promise promise) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readableArray.size(); i++) {
            BranchUniversalObject findUniversalObjectOrReject = findUniversalObjectOrReject(readableArray.getString(i), promise);
            if (findUniversalObjectOrReject == null) {
                return;
            }
            arrayList.add(findUniversalObjectOrReject);
        }
        BranchEvent createBranchEvent = createBranchEvent(str, readableMap);
        createBranchEvent.addContentItems(arrayList);
        createBranchEvent.logEvent(mActivity);
        promise.resolve(null);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [io.branch.rnbranch.RNBranchModule$6] */
    @ReactMethod
    public void showShareSheet(String str, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, Promise promise) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        new Handler(reactApplicationContext.getMainLooper()).post(new Runnable() { // from class: io.branch.rnbranch.RNBranchModule.6
            ReadableMap controlParamsMap;
            String ident;
            ReadableMap linkPropertiesMap;
            Context mContext;
            Promise mPm;
            ReadableMap shareOptionsMap;

            /* JADX INFO: Access modifiers changed from: private */
            public Runnable init(ReadableMap readableMap4, String str2, ReadableMap readableMap5, ReadableMap readableMap6, Promise promise2, Context context) {
                this.mPm = promise2;
                this.mContext = context;
                this.shareOptionsMap = readableMap4;
                this.ident = str2;
                this.linkPropertiesMap = readableMap5;
                this.controlParamsMap = readableMap6;
                return this;
            }

            /* JADX WARN: Type inference failed for: r4v0, types: [io.branch.rnbranch.RNBranchModule$6$1] */
            @Override // java.lang.Runnable
            public void run() {
                ShareSheetStyle addPreferredSharingOption = new ShareSheetStyle(this.mContext, this.shareOptionsMap.hasKey("messageHeader") ? this.shareOptionsMap.getString("messageHeader") : "", this.shareOptionsMap.hasKey("messageBody") ? this.shareOptionsMap.getString("messageBody") : "").setCopyUrlStyle(this.mContext.getResources().getDrawable(android.R.drawable.ic_menu_send), "Copy", "Added to clipboard").setMoreOptionStyle(this.mContext.getResources().getDrawable(android.R.drawable.ic_menu_search), "Show more").addPreferredSharingOption(SharingHelper.SHARE_WITH.EMAIL).addPreferredSharingOption(SharingHelper.SHARE_WITH.TWITTER).addPreferredSharingOption(SharingHelper.SHARE_WITH.MESSAGE).addPreferredSharingOption(SharingHelper.SHARE_WITH.FACEBOOK);
                BranchUniversalObject findUniversalObjectOrReject = RNBranchModule.this.findUniversalObjectOrReject(this.ident, this.mPm);
                if (findUniversalObjectOrReject == null) {
                    return;
                }
                findUniversalObjectOrReject.showShareSheet(RNBranchModule.this.getCurrentActivity(), RNBranchModule.createLinkProperties(this.linkPropertiesMap, this.controlParamsMap), addPreferredSharingOption, new Branch.BranchLinkShareListener() { // from class: io.branch.rnbranch.RNBranchModule.6.1
                    private Promise mPromise = null;

                    @Override // io.branch.referral.Branch.BranchLinkShareListener
                    public void onChannelSelected(String str2) {
                    }

                    @Override // io.branch.referral.Branch.BranchLinkShareListener
                    public void onShareLinkDialogLaunched() {
                    }

                    @Override // io.branch.referral.Branch.BranchLinkShareListener
                    public void onShareLinkDialogDismissed() {
                        if (this.mPromise == null) {
                            return;
                        }
                        WritableNativeMap writableNativeMap = new WritableNativeMap();
                        writableNativeMap.putString("channel", null);
                        writableNativeMap.putBoolean("completed", false);
                        writableNativeMap.putString("error", null);
                        this.mPromise.resolve(writableNativeMap);
                        this.mPromise = null;
                    }

                    @Override // io.branch.referral.Branch.BranchLinkShareListener
                    public void onLinkShareResponse(String str2, String str3, BranchError branchError) {
                        if (this.mPromise == null) {
                            return;
                        }
                        WritableNativeMap writableNativeMap = new WritableNativeMap();
                        writableNativeMap.putString("channel", str3);
                        writableNativeMap.putBoolean("completed", true);
                        writableNativeMap.putString("error", branchError != null ? branchError.getMessage() : null);
                        this.mPromise.resolve(writableNativeMap);
                        this.mPromise = null;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public Branch.BranchLinkShareListener init(Promise promise2) {
                        this.mPromise = promise2;
                        return this;
                    }
                }.init(this.mPm));
            }
        }.init(readableMap, str, readableMap2, readableMap3, promise, reactApplicationContext));
    }

    @ReactMethod
    public void registerView(String str, Promise promise) {
        BranchUniversalObject findUniversalObjectOrReject = findUniversalObjectOrReject(str, promise);
        if (findUniversalObjectOrReject == null) {
            return;
        }
        findUniversalObjectOrReject.registerView();
        promise.resolve(null);
    }

    @ReactMethod
    public void generateShortUrl(String str, ReadableMap readableMap, ReadableMap readableMap2, final Promise promise) {
        LinkProperties createLinkProperties = createLinkProperties(readableMap, readableMap2);
        BranchUniversalObject findUniversalObjectOrReject = findUniversalObjectOrReject(str, promise);
        if (findUniversalObjectOrReject == null) {
            return;
        }
        findUniversalObjectOrReject.generateShortUrl(mActivity, createLinkProperties, new Branch.BranchLinkCreateListener() { // from class: io.branch.rnbranch.RNBranchModule.7
            @Override // io.branch.referral.Branch.BranchLinkCreateListener
            public void onLinkCreate(String str2, BranchError branchError) {
                Log.d("RNBranch", "onLinkCreate " + str2);
                if (branchError != null) {
                    if (branchError.getErrorCode() == -105) {
                        promise.reject("RNBranch::Error::DuplicateResourceError", branchError.getMessage());
                        return;
                    } else {
                        promise.reject(RNBranchModule.GENERIC_ERROR, branchError.getMessage());
                        return;
                    }
                }
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putString("url", str2);
                promise.resolve(writableNativeMap);
            }
        });
    }

    @ReactMethod
    public void openURL(String str, ReadableMap readableMap) {
        Log.d("RNBranch", "openURL url: " + str);
        if (mActivity == null) {
            Log.e("RNBranch", "Branch native Android SDK not initialized in openURL");
            return;
        }
        Activity activity = mActivity;
        Intent intent = new Intent(activity, activity.getClass());
        intent.setData(Uri.parse(str));
        intent.putExtra("branch_force_new_session", true);
        mActivity.startActivity(intent);
    }

    @ReactMethod
    public void getBranchQRCode(ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, ReadableMap readableMap4, final Promise promise) {
        BranchUniversalObject createBranchUniversalObject = createBranchUniversalObject(readableMap2);
        LinkProperties createLinkProperties = createLinkProperties(readableMap3, readableMap4);
        try {
            createBranchQRCode(readableMap).getQRCodeAsData(getReactApplicationContext().getCurrentActivity(), createBranchUniversalObject, createLinkProperties, new BranchQRCode.BranchQRCodeDataHandler() { // from class: io.branch.rnbranch.RNBranchModule.8
                @Override // io.branch.referral.QRCode.BranchQRCode.BranchQRCodeDataHandler
                public void onSuccess(byte[] bArr) {
                    promise.resolve(Base64.encodeToString(bArr, 0));
                }

                @Override // io.branch.referral.QRCode.BranchQRCode.BranchQRCodeDataHandler
                public void onFailure(Exception exc) {
                    Log.d("Failed to get QR Code", exc.getMessage());
                    promise.reject("Failed to get QR Code", exc.getMessage());
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("Failed to get QR Code", e.getMessage());
            promise.reject("Failed to get QR Code", e.getMessage());
        }
    }

    public BranchQRCode createBranchQRCode(ReadableMap readableMap) {
        String string;
        BranchQRCode branchQRCode = new BranchQRCode();
        if (readableMap.hasKey("codeColor")) {
            branchQRCode.setCodeColor(readableMap.getString("codeColor"));
        }
        if (readableMap.hasKey("backgroundColor")) {
            branchQRCode.setBackgroundColor(readableMap.getString("backgroundColor"));
        }
        if (readableMap.hasKey("centerLogo")) {
            branchQRCode.setCenterLogo(readableMap.getString("centerLogo"));
        }
        if (readableMap.hasKey("width")) {
            branchQRCode.setWidth(Integer.valueOf(readableMap.getInt("width")));
        }
        if (readableMap.hasKey(ViewProps.MARGIN)) {
            branchQRCode.setMargin(Integer.valueOf(readableMap.getInt(ViewProps.MARGIN)));
        }
        if (readableMap.hasKey("imageFormat") && (string = readableMap.getString("imageFormat")) != null) {
            if (string.equals("JPEG")) {
                branchQRCode.setImageFormat(BranchQRCode.BranchImageFormat.JPEG);
            } else {
                branchQRCode.setImageFormat(BranchQRCode.BranchImageFormat.PNG);
            }
        }
        return branchQRCode;
    }

    public static BranchEvent createBranchEvent(String str, ReadableMap readableMap) {
        BranchEvent branchEvent;
        try {
            branchEvent = new BranchEvent(BRANCH_STANDARD_EVENT.valueOf(str));
        } catch (IllegalArgumentException unused) {
            branchEvent = new BranchEvent(str);
        }
        if (readableMap.hasKey("currency")) {
            String string = readableMap.getString("currency");
            CurrencyType value = CurrencyType.getValue(string);
            if (value != null) {
                branchEvent.setCurrency(value);
            } else {
                Log.w("RNBranch", "Invalid currency " + string);
            }
        }
        if (readableMap.hasKey("transactionID")) {
            branchEvent.setTransactionID(readableMap.getString("transactionID"));
        }
        if (readableMap.hasKey("revenue")) {
            branchEvent.setRevenue(Double.parseDouble(readableMap.getString("revenue")));
        }
        if (readableMap.hasKey("shipping")) {
            branchEvent.setShipping(Double.parseDouble(readableMap.getString("shipping")));
        }
        if (readableMap.hasKey("tax")) {
            branchEvent.setTax(Double.parseDouble(readableMap.getString("tax")));
        }
        if (readableMap.hasKey("coupon")) {
            branchEvent.setCoupon(readableMap.getString("coupon"));
        }
        if (readableMap.hasKey("affiliation")) {
            branchEvent.setAffiliation(readableMap.getString("affiliation"));
        }
        if (readableMap.hasKey("description")) {
            branchEvent.setDescription(readableMap.getString("description"));
        }
        if (readableMap.hasKey("searchQuery")) {
            branchEvent.setSearchQuery(readableMap.getString("searchQuery"));
        }
        if (readableMap.hasKey("alias")) {
            branchEvent.setCustomerEventAlias(readableMap.getString("alias"));
        }
        if (readableMap.hasKey("customData")) {
            ReadableMap map = readableMap.getMap("customData");
            ReadableMapKeySetIterator keySetIterator = map.keySetIterator();
            while (keySetIterator.hasNextKey()) {
                String nextKey = keySetIterator.nextKey();
                if (map.getType(nextKey) == ReadableType.String) {
                    branchEvent.addCustomDataProperty(nextKey, map.getString(nextKey));
                } else {
                    Log.w("RNBranch", "customData values must be strings. Value for property " + nextKey + " is not a string type.");
                }
            }
        }
        return branchEvent;
    }

    public static LinkProperties createLinkProperties(ReadableMap readableMap, ReadableMap readableMap2) {
        LinkProperties linkProperties = new LinkProperties();
        if (readableMap.hasKey("alias")) {
            linkProperties.setAlias(readableMap.getString("alias"));
        }
        if (readableMap.hasKey(Constants.ScionAnalytics.PARAM_CAMPAIGN)) {
            linkProperties.setCampaign(readableMap.getString(Constants.ScionAnalytics.PARAM_CAMPAIGN));
        }
        if (readableMap.hasKey("channel")) {
            linkProperties.setChannel(readableMap.getString("channel"));
        }
        if (readableMap.hasKey("feature")) {
            linkProperties.setFeature(readableMap.getString("feature"));
        }
        if (readableMap.hasKey("stage")) {
            linkProperties.setStage(readableMap.getString("stage"));
        }
        if (readableMap.hasKey("tags")) {
            ReadableArray array = readableMap.getArray("tags");
            for (int i = 0; i < array.size(); i++) {
                linkProperties.addTag(array.getString(i));
            }
        }
        if (readableMap2 != null) {
            ReadableMapKeySetIterator keySetIterator = readableMap2.keySetIterator();
            while (keySetIterator.hasNextKey()) {
                String nextKey = keySetIterator.nextKey();
                linkProperties.addControlParameter(nextKey, getReadableMapObjectForKey(readableMap2, nextKey).toString());
            }
        }
        return linkProperties;
    }

    private static Branch setupBranch(Context context) {
        Branch autoInstance = Branch.getAutoInstance(context);
        if (!mInitialized) {
            Log.i("RNBranch", "Initializing Branch SDK v. 5.9.0");
            JSONObject jSONObject = mRequestMetadata;
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        autoInstance.setRequestMetadata(next, mRequestMetadata.getString(next));
                    } catch (JSONException unused) {
                    }
                }
            }
            mInitialized = true;
        }
        return autoInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BranchUniversalObject findUniversalObjectOrReject(String str, Promise promise) {
        BranchUniversalObject branchUniversalObject = this.mUniversalObjectMap.get(str);
        if (branchUniversalObject == null) {
            promise.reject(UNIVERSAL_OBJECT_NOT_FOUND_ERROR_CODE, "BranchUniversalObject not found for ident " + str + ".");
        }
        return branchUniversalObject;
    }

    public ContentMetadata createContentMetadata(ReadableMap readableMap) {
        ProductCategory productCategory;
        ContentMetadata contentMetadata = new ContentMetadata();
        if (readableMap.hasKey("contentSchema")) {
            contentMetadata.setContentSchema(BranchContentSchema.valueOf(readableMap.getString("contentSchema")));
        }
        if (readableMap.hasKey(DiscardedEvent.JsonKeys.QUANTITY)) {
            contentMetadata.setQuantity(Double.valueOf(readableMap.getDouble(DiscardedEvent.JsonKeys.QUANTITY)));
        }
        if (readableMap.hasKey("price")) {
            contentMetadata.setPrice(Double.valueOf(Double.parseDouble(readableMap.getString("price"))), readableMap.hasKey("currency") ? CurrencyType.valueOf(readableMap.getString("currency")) : null);
        }
        if (readableMap.hasKey("sku")) {
            contentMetadata.setSku(readableMap.getString("sku"));
        }
        if (readableMap.hasKey("productName")) {
            contentMetadata.setProductName(readableMap.getString("productName"));
        }
        if (readableMap.hasKey("productBrand")) {
            contentMetadata.setProductBrand(readableMap.getString("productBrand"));
        }
        if (readableMap.hasKey("productCategory") && (productCategory = getProductCategory(readableMap.getString("productCategory"))) != null) {
            contentMetadata.setProductCategory(productCategory);
        }
        if (readableMap.hasKey("productVariant")) {
            contentMetadata.setProductVariant(readableMap.getString("productVariant"));
        }
        if (readableMap.hasKey("condition")) {
            contentMetadata.setProductCondition(ContentMetadata.CONDITION.valueOf(readableMap.getString("condition")));
        }
        if (readableMap.hasKey("ratingAverage") || readableMap.hasKey("ratingMax") || readableMap.hasKey("ratingCount")) {
            contentMetadata.setRating(readableMap.hasKey("ratingAverage") ? Double.valueOf(readableMap.getDouble("ratingAverage")) : null, readableMap.hasKey("ratingMax") ? Double.valueOf(readableMap.getDouble("ratingMax")) : null, readableMap.hasKey("ratingCount") ? Integer.valueOf(readableMap.getInt("ratingCount")) : null);
        }
        if (readableMap.hasKey("addressStreet") || readableMap.hasKey("addressCity") || readableMap.hasKey(HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_REGION) || readableMap.hasKey(HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_COUNTRY) || readableMap.hasKey("addressPostalCode")) {
            String string = readableMap.hasKey("addressStreet") ? readableMap.getString("addressStreet") : null;
            if (readableMap.hasKey("addressCity")) {
                string = readableMap.getString("addressCity");
            }
            if (readableMap.hasKey(HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_REGION)) {
                string = readableMap.getString(HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_REGION);
            }
            if (readableMap.hasKey(HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_COUNTRY)) {
                string = readableMap.getString(HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_COUNTRY);
            }
            if (readableMap.hasKey("addressPostalCode")) {
                string = readableMap.getString("addressPostalCode");
            }
            contentMetadata.setAddress(string, null, null, null, null);
        }
        if (readableMap.hasKey("latitude") || readableMap.hasKey("longitude")) {
            contentMetadata.setLocation(readableMap.hasKey("latitude") ? Double.valueOf(readableMap.getDouble("latitude")) : null, readableMap.hasKey("longitude") ? Double.valueOf(readableMap.getDouble("longitude")) : null);
        }
        if (readableMap.hasKey("imageCaptions")) {
            ReadableArray array = readableMap.getArray("imageCaptions");
            for (int i = 0; i < array.size(); i++) {
                contentMetadata.addImageCaptions(array.getString(i));
            }
        }
        if (readableMap.hasKey("customMetadata")) {
            ReadableMap map = readableMap.getMap("customMetadata");
            ReadableMapKeySetIterator keySetIterator = map.keySetIterator();
            while (keySetIterator.hasNextKey()) {
                String nextKey = keySetIterator.nextKey();
                contentMetadata.addCustomMetadata(nextKey, map.getString(nextKey));
            }
        }
        return contentMetadata;
    }

    public BranchUniversalObject createBranchUniversalObject(ReadableMap readableMap) {
        BranchUniversalObject canonicalIdentifier = new BranchUniversalObject().setCanonicalIdentifier(readableMap.getString("canonicalIdentifier"));
        if (readableMap.hasKey("title")) {
            canonicalIdentifier.setTitle(readableMap.getString("title"));
        }
        if (readableMap.hasKey("canonicalUrl")) {
            canonicalIdentifier.setCanonicalUrl(readableMap.getString("canonicalUrl"));
        }
        if (readableMap.hasKey("contentDescription")) {
            canonicalIdentifier.setContentDescription(readableMap.getString("contentDescription"));
        }
        if (readableMap.hasKey("contentImageUrl")) {
            canonicalIdentifier.setContentImageUrl(readableMap.getString("contentImageUrl"));
        }
        if (readableMap.hasKey("locallyIndex")) {
            if (readableMap.getBoolean("locallyIndex")) {
                canonicalIdentifier.setLocalIndexMode(BranchUniversalObject.CONTENT_INDEX_MODE.PUBLIC);
            } else {
                canonicalIdentifier.setLocalIndexMode(BranchUniversalObject.CONTENT_INDEX_MODE.PRIVATE);
            }
        }
        if (readableMap.hasKey("publiclyIndex")) {
            if (readableMap.getBoolean("publiclyIndex")) {
                canonicalIdentifier.setContentIndexingMode(BranchUniversalObject.CONTENT_INDEX_MODE.PUBLIC);
            } else {
                canonicalIdentifier.setContentIndexingMode(BranchUniversalObject.CONTENT_INDEX_MODE.PRIVATE);
            }
        }
        if (readableMap.hasKey("contentIndexingMode")) {
            if (AnonymousClass10.$SwitchMap$com$facebook$react$bridge$ReadableType[readableMap.getType("contentIndexingMode").ordinal()] == 1) {
                String string = readableMap.getString("contentIndexingMode");
                if (string.equals("private")) {
                    canonicalIdentifier.setContentIndexingMode(BranchUniversalObject.CONTENT_INDEX_MODE.PRIVATE);
                } else if (string.equals("public")) {
                    canonicalIdentifier.setContentIndexingMode(BranchUniversalObject.CONTENT_INDEX_MODE.PUBLIC);
                } else {
                    Log.w("RNBranch", "Unsupported value for contentIndexingMode: " + string + ". Supported values are \"public\" and \"private\"");
                }
            } else {
                Log.w("RNBranch", "contentIndexingMode must be a String");
            }
        }
        if (readableMap.hasKey("currency") && readableMap.hasKey("price")) {
            canonicalIdentifier.setPrice(readableMap.getDouble("price"), CurrencyType.valueOf(readableMap.getString("currency")));
        }
        if (readableMap.hasKey("expirationDate")) {
            String string2 = readableMap.getString("expirationDate");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            try {
                Date parse = simpleDateFormat.parse(string2);
                Log.d("RNBranch", "Expiration date is " + parse.toString());
                canonicalIdentifier.setContentExpiration(parse);
            } catch (ParseException unused) {
                Log.w("RNBranch", "Invalid expiration date format. Valid format is YYYY-mm-ddTHH:MM:SS, e.g. 2017-02-01T00:00:00. All times UTC.");
            }
        }
        if (readableMap.hasKey("keywords")) {
            ReadableArray array = readableMap.getArray("keywords");
            for (int i = 0; i < array.size(); i++) {
                canonicalIdentifier.addKeyWord(array.getString(i));
            }
        }
        if (readableMap.hasKey("metadata")) {
            ReadableMap map = readableMap.getMap("metadata");
            ReadableMapKeySetIterator keySetIterator = map.keySetIterator();
            while (keySetIterator.hasNextKey()) {
                String nextKey = keySetIterator.nextKey();
                canonicalIdentifier.addContentMetadata(nextKey, getReadableMapObjectForKey(map, nextKey).toString());
                canonicalIdentifier.getMetadata();
            }
        }
        if (readableMap.hasKey("type")) {
            canonicalIdentifier.setContentType(readableMap.getString("type"));
        }
        if (readableMap.hasKey("contentMetadata")) {
            canonicalIdentifier.setContentMetadata(createContentMetadata(readableMap.getMap("contentMetadata")));
        }
        return canonicalIdentifier;
    }

    /* renamed from: io.branch.rnbranch.RNBranchModule$10, reason: invalid class name */
    static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$ReadableType;

        static {
            int[] iArr = new int[ReadableType.values().length];
            $SwitchMap$com$facebook$react$bridge$ReadableType = iArr;
            try {
                iArr[ReadableType.String.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Null.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Boolean.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Number.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Map.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Array.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public ProductCategory getProductCategory(String str) {
        for (ProductCategory productCategory : (ProductCategory[]) ProductCategory.class.getEnumConstants()) {
            if (str.equals(productCategory.getName())) {
                return productCategory;
            }
        }
        Log.w("RNBranch", "Could not find product category " + str);
        return null;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [io.branch.rnbranch.RNBranchModule$9] */
    public void sendRNEvent(String str, WritableMap writableMap) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Handler handler = new Handler(reactApplicationContext.getMainLooper());
        Runnable init = new Runnable() { // from class: io.branch.rnbranch.RNBranchModule.9
            ReactApplicationContext mContext;
            String mEventName;
            Handler mMainHandler;
            WritableMap mParams;
            final int pollDelayInMs = 100;
            final int maxTries = 300;
            int tries = 1;

            /* JADX INFO: Access modifiers changed from: private */
            public Runnable init(ReactApplicationContext reactApplicationContext2, Handler handler2, String str2, WritableMap writableMap2) {
                this.mMainHandler = handler2;
                this.mEventName = str2;
                this.mContext = reactApplicationContext2;
                this.mParams = writableMap2;
                return this;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    Log.d("RNBranch", "Catalyst instance poller try " + Integer.toString(this.tries));
                    if (this.mContext.hasActiveCatalystInstance()) {
                        Log.d("RNBranch", "Catalyst instance active");
                        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.mContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(this.mEventName, this.mParams);
                    } else {
                        int i = this.tries + 1;
                        this.tries = i;
                        if (i <= 300) {
                            this.mMainHandler.postDelayed(this, 100L);
                        } else {
                            Log.e("RNBranch", "Could not get Catalyst instance");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.init(reactApplicationContext, handler, str, writableMap);
        Log.d("RNBranch", "sendRNEvent");
        handler.post(init);
    }

    private static Object getReadableMapObjectForKey(ReadableMap readableMap, String str) {
        int i = AnonymousClass10.$SwitchMap$com$facebook$react$bridge$ReadableType[readableMap.getType(str).ordinal()];
        if (i == 1) {
            return readableMap.getString(str);
        }
        if (i == 2) {
            return "Null";
        }
        if (i == 3) {
            return Boolean.valueOf(readableMap.getBoolean(str));
        }
        if (i != 4) {
            return "Unsupported Type";
        }
        if (readableMap.getDouble(str) % 1.0d == 0.0d) {
            return Integer.valueOf(readableMap.getInt(str));
        }
        return Double.valueOf(readableMap.getDouble(str));
    }

    private static JSONObject convertMapToJson(ReadableMap readableMap) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            switch (AnonymousClass10.$SwitchMap$com$facebook$react$bridge$ReadableType[readableMap.getType(nextKey).ordinal()]) {
                case 1:
                    jSONObject.put(nextKey, readableMap.getString(nextKey));
                    break;
                case 2:
                    jSONObject.put(nextKey, JSONObject.NULL);
                    break;
                case 3:
                    jSONObject.put(nextKey, readableMap.getBoolean(nextKey));
                    break;
                case 4:
                    jSONObject.put(nextKey, readableMap.getDouble(nextKey));
                    break;
                case 5:
                    jSONObject.put(nextKey, convertMapToJson(readableMap.getMap(nextKey)));
                    break;
                case 6:
                    jSONObject.put(nextKey, convertArrayToJson(readableMap.getArray(nextKey)));
                    break;
            }
        }
        return jSONObject;
    }

    private static JSONArray convertArrayToJson(ReadableArray readableArray) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < readableArray.size(); i++) {
            int i2 = AnonymousClass10.$SwitchMap$com$facebook$react$bridge$ReadableType[readableArray.getType(i).ordinal()];
            if (i2 == 1) {
                jSONArray.put(readableArray.getString(i));
            } else if (i2 == 3) {
                jSONArray.put(readableArray.getBoolean(i));
            } else if (i2 == 4) {
                jSONArray.put(readableArray.getDouble(i));
            } else if (i2 == 5) {
                jSONArray.put(convertMapToJson(readableArray.getMap(i)));
            } else if (i2 == 6) {
                jSONArray.put(convertArrayToJson(readableArray.getArray(i)));
            }
        }
        return jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static WritableMap convertJsonToMap(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                if (obj instanceof JSONObject) {
                    writableNativeMap.putMap(next, convertJsonToMap((JSONObject) obj));
                } else if (obj instanceof JSONArray) {
                    writableNativeMap.putArray(next, convertJsonToArray((JSONArray) obj));
                } else if (obj instanceof Boolean) {
                    writableNativeMap.putBoolean(next, ((Boolean) obj).booleanValue());
                } else if (obj instanceof Integer) {
                    writableNativeMap.putInt(next, ((Integer) obj).intValue());
                } else if (obj instanceof Double) {
                    writableNativeMap.putDouble(next, ((Double) obj).doubleValue());
                } else if (obj instanceof String) {
                    writableNativeMap.putString(next, (String) obj);
                } else {
                    if (obj != null && obj != JSONObject.NULL) {
                        writableNativeMap.putString(next, obj.toString());
                    }
                    writableNativeMap.putNull(next);
                }
            }
        } catch (JSONException e) {
            writableNativeMap.putString("error", "Failed to convert JSONObject to WriteableMap: " + e.getMessage());
        }
        return writableNativeMap;
    }

    private static WritableArray convertJsonToArray(JSONArray jSONArray) throws JSONException {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONObject) {
                writableNativeArray.pushMap(convertJsonToMap((JSONObject) obj));
            } else if (obj instanceof JSONArray) {
                writableNativeArray.pushArray(convertJsonToArray((JSONArray) obj));
            } else if (obj instanceof Boolean) {
                writableNativeArray.pushBoolean(((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                writableNativeArray.pushInt(((Integer) obj).intValue());
            } else if (obj instanceof Double) {
                writableNativeArray.pushDouble(((Double) obj).doubleValue());
            } else if (obj instanceof String) {
                writableNativeArray.pushString((String) obj);
            } else {
                writableNativeArray.pushString(obj.toString());
            }
        }
        return writableNativeArray;
    }

    @ReactMethod
    public void setDMAParamsForEEA(boolean z, boolean z2, boolean z3) {
        Branch.getInstance().setDMAParamsForEEA(z, z2, z3);
    }
}
