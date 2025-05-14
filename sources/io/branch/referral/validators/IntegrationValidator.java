package io.branch.referral.validators;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import io.branch.referral.Branch;
import io.branch.referral.BranchUtil;
import io.branch.referral.validators.ServerRequestGetAppConfig;
import java.util.Iterator;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class IntegrationValidator implements ServerRequestGetAppConfig.IGetAppConfigEvents {
    private static IntegrationValidator instance;
    private final String TAG = "BranchSDK_Doctor";
    private final BranchIntegrationModel integrationModel;

    private IntegrationValidator(Context context) {
        this.integrationModel = new BranchIntegrationModel(context);
    }

    public static void validate(Context context) {
        if (instance == null) {
            instance = new IntegrationValidator(context);
        }
        instance.validateSDKIntegration(context);
    }

    private void validateSDKIntegration(Context context) {
        logValidationProgress("\n\n------------------- Initiating Branch integration verification ---------------------------");
        logValidationProgress("1. Verifying Branch instance creation");
        if (Branch.getInstance() == null) {
            logIntegrationError("Branch is not initialised from your Application class. Please add `Branch.getAutoInstance(this);` to your Application#onCreate() method.", "https://help.branch.io/developers-hub/docs/android-basic-integration#section-load-branch");
            return;
        }
        logValidationPassed();
        logValidationProgress("2. Checking Branch keys");
        if (TextUtils.isEmpty(BranchUtil.readBranchKey(context))) {
            logIntegrationError("Unable to read Branch keys from your application. Did you forget to add Branch keys in your application?.", "https://help.branch.io/developers-hub/docs/android-basic-integration#section-configure-app");
        } else {
            logValidationPassed();
            Branch.getInstance().requestQueue_.handleNewRequest(new ServerRequestGetAppConfig(context, this));
        }
    }

    private void doValidateWithAppConfig(JSONObject jSONObject) {
        logValidationProgress("3. Verifying application package name");
        if (!this.integrationModel.packageName.equals(jSONObject.optString("android_package_name"))) {
            logIntegrationError("Incorrect package name in Branch dashboard. Please correct your package name in dashboard -> Configuration page.", "https://help.branch.io/developers-hub/docs/android-basic-integration#section-configure-branch-dashboard");
            return;
        }
        logValidationPassed();
        logValidationProgress("4. Checking Android Manifest for URI based deep link config");
        if (this.integrationModel.deeplinkUriScheme == null || this.integrationModel.deeplinkUriScheme.length() == 0) {
            if (!this.integrationModel.appSettingsAvailable) {
                logValidationProgress("- Skipping. Unable to verify the deep link config. Failed to read the Android Manifest");
            } else {
                logIntegrationError(String.format("No intent found for opening the app through uri Scheme '%s'.Please add the intent with URI scheme to your Android manifest.", jSONObject.optString("android_uri_scheme")), "https://help.branch.io/developers-hub/docs/android-basic-integration#section-configure-app");
                return;
            }
        } else {
            logValidationPassed();
        }
        logValidationProgress("5. Verifying URI based deep link config with Branch dash board.");
        String optString = jSONObject.optString("android_uri_scheme");
        if (TextUtils.isEmpty(optString)) {
            logIntegrationError("Uri Scheme to open your app is not specified in Branch dashboard. Please add URI scheme in Branch dashboard.", "https://help.branch.io/developers-hub/docs/android-basic-integration#section-configure-branch-dashboard");
            return;
        }
        logValidationPassed();
        logValidationProgress("6. Verifying intent for receiving URI scheme.");
        if (!checkIfIntentAddedForURIScheme(optString)) {
            if (!this.integrationModel.appSettingsAvailable) {
                logValidationProgress("- Skipping. Unable to verify intent for receiving URI scheme. Failed to read the Android Manifest");
            } else {
                logIntegrationError(String.format("Uri scheme '%s' specified in Branch dashboard doesn't match with the deep link intent in manifest file", optString), "https://help.branch.io/developers-hub/docs/android-basic-integration#section-configure-branch-dashboard");
                return;
            }
        } else {
            logValidationPassed();
        }
        logValidationProgress("7. Checking AndroidManifest for AppLink config.");
        if (this.integrationModel.applinkScheme.isEmpty()) {
            if (!this.integrationModel.appSettingsAvailable) {
                logValidationProgress("- Skipping. Unable to verify intent for receiving URI scheme. Failed to read the Android Manifest");
            } else {
                logIntegrationError("Could not find any App Link hosts to support Android AppLinks. Please add intent filter for handling AppLinks in your Android Manifest file", "https://help.branch.io/using-branch/docs/android-app-links#section-add-intent-filter-to-manifest");
                return;
            }
        } else {
            logValidationPassed();
        }
        logValidationProgress("8. Verifying any supported custom link domains.");
        String optString2 = jSONObject.optString("short_url_domain");
        if (!TextUtils.isEmpty(optString2) && !checkIfIntentAddedForLinkDomain(optString2)) {
            if (!this.integrationModel.appSettingsAvailable) {
                logValidationProgress("- Skipping. Unable to verify supported custom link domains. Failed to read the Android Manifest");
            } else {
                logIntegrationError(String.format("Could not find intent filter to support custom link domain '%s'. Please add intent filter for handling custom link domain in your Android Manifest file ", optString2), "https://help.branch.io/developers-hub/docs/android-basic-integration#section-configure-app");
                return;
            }
        } else {
            logValidationPassed();
        }
        logValidationProgress("9. Verifying default link domains integrations.");
        String optString3 = jSONObject.optString("default_short_url_domain");
        if (!TextUtils.isEmpty(optString3) && !checkIfIntentAddedForLinkDomain(optString3)) {
            if (!this.integrationModel.appSettingsAvailable) {
                logValidationProgress("- Skipping. Unable to verify default link domains. Failed to read the Android Manifest");
            } else {
                logIntegrationError(String.format("Could not find intent filter to support Branch default link domain '%s'. Please add intent filter for handling custom link domain in your Android Manifest file ", optString3), "https://help.branch.io/developers-hub/docs/android-basic-integration#section-configure-app");
                return;
            }
        } else {
            logValidationPassed();
        }
        logValidationProgress("10. Verifying alternate link domains integrations.");
        String optString4 = jSONObject.optString("alternate_short_url_domain");
        if (!TextUtils.isEmpty(optString4) && !checkIfIntentAddedForLinkDomain(optString4)) {
            if (!this.integrationModel.appSettingsAvailable) {
                logValidationProgress("- Skipping.Unable to verify alternate link domains. Failed to read the Android Manifest");
            } else {
                logIntegrationError(String.format("Could not find intent filter to support alternate link domain '%s'. Please add intent filter for handling custom link domain in your Android Manifest file ", optString4), "https://help.branch.io/developers-hub/docs/android-basic-integration#section-configure-app");
                return;
            }
        } else {
            logValidationPassed();
        }
        logValidationPassed();
        Log.d("BranchSDK_Doctor", "--------------------------------------------\nSuccessfully completed Branch integration validation. Everything looks good!");
        Log.d("BranchSDK_Doctor", "\n         Great! Comment out the 'validateSDKIntegration' line in your app. Next check your deep link routing.\n         Append '?bnc_validate=true' to any of your app's Branch links and click it on your mobile device (not the Simulator!) to start the test.\n         For instance, to validate a link like:\n         https://<yourapp>.app.link/NdJ6nFzRbK\n         click on:\n         https://<yourapp>.app.link/NdJ6nFzRbK?bnc_validate=true");
    }

    private boolean checkIfIntentAddedForURIScheme(String str) {
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        String host = parse.getHost();
        if (TextUtils.isEmpty(host)) {
            host = AbstractCircuitBreaker.PROPERTY_NAME;
        }
        if (this.integrationModel.deeplinkUriScheme == null) {
            return false;
        }
        Iterator<String> keys = this.integrationModel.deeplinkUriScheme.keys();
        boolean z = false;
        while (keys.hasNext()) {
            String next = keys.next();
            if (scheme != null && scheme.equals(next)) {
                JSONArray optJSONArray = this.integrationModel.deeplinkUriScheme.optJSONArray(next);
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int i = 0;
                    while (true) {
                        if (i < optJSONArray.length()) {
                            if (host != null && host.equals(optJSONArray.optString(i))) {
                                z = true;
                                break;
                            }
                            i++;
                        } else {
                            break;
                        }
                    }
                } else {
                    return true;
                }
            }
        }
        return z;
    }

    private boolean checkIfIntentAddedForLinkDomain(String str) {
        if (!TextUtils.isEmpty(str) && this.integrationModel.applinkScheme != null) {
            Iterator<String> it = this.integrationModel.applinkScheme.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // io.branch.referral.validators.ServerRequestGetAppConfig.IGetAppConfigEvents
    public void onAppConfigAvailable(JSONObject jSONObject) {
        if (jSONObject != null) {
            doValidateWithAppConfig(jSONObject);
        } else {
            logIntegrationError("Unable to read Dashboard config. Please confirm that your Branch key is properly added to the manifest. Please fix your Dashboard settings.", "https://branch.app.link/link-settings-page");
        }
    }

    private void logIntegrationError(String str, String str2) {
        Log.d("BranchSDK_Doctor", "** ERROR ** : " + str + "\nPlease follow the link for more info " + str2);
    }

    private void logValidationProgress(String str) {
        Log.d("BranchSDK_Doctor", str + " ... ");
    }

    private void logValidationPassed() {
        Log.d("BranchSDK_Doctor", "Passed");
    }
}
